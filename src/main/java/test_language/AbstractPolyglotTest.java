package test_language;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleLanguage.Registration;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.RootNode;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Instrument;
import org.junit.After;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Base class for polyglot tests that require internal access to a language or instrument
 * environment.
 *
 * @see #setupEnv()
 * @see #setupEnv(Context)
 * @see #setupEnv(Context, ProxyLanguage, ProxyInstrument)
 */
public abstract class AbstractPolyglotTest {
    private static final String STRONG_ENCAPSULATION_MESSAGE_TEMPLATE = "Cannot use %s with strong encapsulation enabled (e.g. context isolates). " +
            "Add TruffleTestAssumptions.assumeWeakEncapsulation() in a @BeforeClass listener of the test class to resolve this.";
    protected static final InteropLibrary INTEROP = InteropLibrary.getFactory().getUncached();

    protected Context context;
    protected TruffleLanguage.Env languageEnv;
    protected TruffleLanguage<?> language;
    protected TruffleInstrument.Env instrumentEnv;
    protected boolean cleanupOnSetup = true;
    protected boolean enterContext = true;
    protected boolean needsInstrumentEnv = false;
    protected boolean needsLanguageEnv = false;

    protected final void setupEnv(Context.Builder contextBuilder, ProxyInstrument instrument) {
        setupEnv(null, contextBuilder, null, instrument);
    }

    protected final void setupEnv(Context.Builder contextBuilder, ProxyLanguage language) {
        setupEnv(null, contextBuilder, language, null);
    }

    protected final void setupEnv(Context.Builder contextBuilder, ProxyLanguage language, ProxyInstrument instrument) {
        setupEnv(null, contextBuilder, language, instrument);
    }

    protected final void setupEnv(Context newContext, ProxyInstrument instrument) {
        setupEnv(newContext, null, instrument);
    }

    protected final void setupEnv(Context newContext, ProxyLanguage language) {
        setupEnv(newContext, language, null);
    }

    protected final void setupEnv(Context newContext, ProxyLanguage language, ProxyInstrument instrument) {
        setupEnv(newContext, null, language, instrument);
    }

    private void setupEnv(Context originalContext, Context.Builder builder, ProxyLanguage language, ProxyInstrument instrument) {
        if (language != null && !TruffleTestAssumptions.isWeakEncapsulation()) {
            throw new AssertionError(String.format(STRONG_ENCAPSULATION_MESSAGE_TEMPLATE, "custom proxy language"));
        }
        if (instrument != null && !TruffleTestAssumptions.isWeakEncapsulation()) {
            throw new AssertionError(String.format(STRONG_ENCAPSULATION_MESSAGE_TEMPLATE, "custom proxy instrument"));
        }
        if (needsLanguageEnv && !TruffleTestAssumptions.isWeakEncapsulation()) {
            throw new AssertionError(String.format(STRONG_ENCAPSULATION_MESSAGE_TEMPLATE, "language env"));
        }
        if (needsInstrumentEnv && !TruffleTestAssumptions.isWeakEncapsulation()) {
            throw new AssertionError(String.format(STRONG_ENCAPSULATION_MESSAGE_TEMPLATE, "instrument env"));
        }

        if (cleanupOnSetup) {
            cleanup();
        }
        Context localContext = originalContext;

        final ProxyLanguage usedLanguage;
        if (language == null) {
            usedLanguage = new ProxyLanguage();
        } else {
            usedLanguage = language;
        }
        final ProxyInstrument usedInstrument;
        if (instrument == null) {
            usedInstrument = new ProxyInstrument();
        } else {
            usedInstrument = instrument;
        }
        usedLanguage.setOnCreate((c) -> {
            if (needsLanguageEnv) {
                this.languageEnv = c.env;
                this.language = usedLanguage.languageInstance;
            }
        });

        ProxyLanguage.setDelegate(usedLanguage);
        ProxyInstrument.setDelegate(usedInstrument);

        if (localContext == null) {
            localContext = builder.build();
        }

        Class<?> currentInstrumentClass = usedInstrument.getClass();
        String instrumentId = null;
        while (currentInstrumentClass != null && instrumentId == null) {
            TruffleInstrument.Registration reg = currentInstrumentClass.getAnnotation(TruffleInstrument.Registration.class);
            instrumentId = reg != null ? reg.id() : null;
            currentInstrumentClass = currentInstrumentClass.getSuperclass();
        }

        Instrument embedderInstrument = localContext.getEngine().getInstruments().get(instrumentId);
        if (embedderInstrument == null) {
            throw new IllegalStateException("Test proxy instrument not installed. Inconsistent build?");
        } else {
            if (needsInstrumentEnv) {
                // forces initialization of instrument
                this.instrumentEnv = embedderInstrument.lookup(ProxyInstrument.Initialize.class).getEnv();
            }
        }

        Class<?> currentLanguageClass = usedLanguage.getClass();
        String languageId = null;
        while (currentLanguageClass != null && languageId == null) {
            Registration reg = currentLanguageClass.getAnnotation(Registration.class);
            languageId = reg != null ? reg.id() : null;
            currentLanguageClass = currentLanguageClass.getSuperclass();
        }

        localContext.initialize(languageId);
        // enter current context
        if (enterContext) {
            localContext.enter();
        }

        if (needsLanguageEnv) {
            assertNotNull(this.languageEnv);
            assertNotNull(this.language);
        }
        if (needsInstrumentEnv) {
            assertNotNull(this.instrumentEnv);
        }

        usedLanguage.setOnCreate(null);

        this.context = localContext;
        usedInstrument.setOnCreate(null);
    }

    protected final void setupEnv(Context context) {
        setupEnv(context, null, null);
    }

    protected final void setupEnv() {
        setupEnv(Context.newBuilder().allowAllAccess(true).option("engine.InstrumentExceptionsAreThrown", "true").build(), null, null);
    }

    /**
     * Wraps a node in a RootNode and makes sure load listeners are notified, wrappers are inserted
     * and attached execution listeners are applied.
     */
    @SuppressWarnings("unchecked")
    protected final <T extends Node> Supplier<T> adoptNode(T node) {
        return adoptNode(this.language, node);
    }

    @SuppressWarnings({"unchecked", "static-method"})
    protected final <T extends Node> Supplier<T> adoptNode(TruffleLanguage<?> lang, T node) {
        TestRootNode root = new TestRootNode(lang, node);
        // execute it to trigger instrumentations
        root.getCallTarget().call();
        return () -> (T) root.node;
    }

    @After
    public final void cleanup() {
        if (context != null) {
            if (enterContext) {
                context.leave();
            }

            context.close();
            context = null;
        }
        // restore static state
        ProxyLanguage.setDelegate(new ProxyLanguage());
        ProxyInstrument.setDelegate(new ProxyInstrument());
    }

    public static void assertFails(Runnable callable, Class<?> exceptionType) {
        assertFails((Callable<?>) () -> {
            callable.run();
            return null;
        }, exceptionType);
    }

    public static void assertFails(Callable<?> callable, Class<?> exceptionType) {
        try {
            callable.call();
        } catch (Throwable t) {
            if (!exceptionType.isInstance(t)) {
                throw new AssertionError("expected instanceof " + exceptionType.getName() + " was " + t.toString(), t);
            }
            return;
        }
        fail("expected " + exceptionType.getName() + " but no exception was thrown");
    }

    public static <T> void assertFails(Runnable run, Class<T> exceptionType, Consumer<T> verifier) {
        try {
            run.run();
        } catch (Throwable t) {
            if (!exceptionType.isInstance(t)) {
                throw new AssertionError("expected instanceof " + exceptionType.getName() + " was " + t.toString(), t);
            }
            verifier.accept(exceptionType.cast(t));
            return;
        }
        fail("expected " + exceptionType.getName() + " but no exception was thrown");
    }

    public static <T> void assertFails(Callable<?> callable, Class<T> exceptionType, Consumer<T> verifier) {
        try {
            callable.call();
        } catch (Throwable t) {
            if (!exceptionType.isInstance(t)) {
                throw new AssertionError("expected instanceof " + exceptionType.getName() + " was " + t.getClass().getName(), t);
            }
            verifier.accept(exceptionType.cast(t));
            return;
        }
        fail("expected " + exceptionType.getName() + " but no exception was thrown");
    }

    public static boolean isGraalRuntime() {
        return Truffle.getRuntime().getName().contains("Graal");
    }

    private static class TestRootNode extends RootNode {

        @Child private Node node;

        protected TestRootNode(TruffleLanguage<?> language, Node node) {
            super(language);
            this.node = node;
        }

        @Override
        public Object execute(VirtualFrame frame) {
            // does nothing node is supposed to be exectued
            // externally.
            return null;
        }

    }

    public static FrameDescriptor createFrameDescriptor(int count) {
        FrameDescriptor.Builder builder = FrameDescriptor.newBuilder(count);
        builder.addSlots(count, FrameSlotKind.Illegal);
        return builder.build();
    }

}