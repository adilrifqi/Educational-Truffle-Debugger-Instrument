package test_language;

import com.oracle.truffle.api.impl.Accessor;
import org.graalvm.polyglot.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * Base class for instrumentation tests.
 */
public abstract class AbstractInstrumentationTest extends AbstractPolyglotTest {

    protected Engine engine;

    protected final ByteArrayOutputStream out = new ByteArrayOutputStream();
    protected final ByteArrayOutputStream err = new ByteArrayOutputStream();

    Context newContext() {
        Context.Builder builder = Context.newBuilder().allowAllAccess(true);
        builder.engine(getEngine());
        return builder.build();
    }

    @Before
    public void setup() {
        setupEnv(newContext());
    }

    protected final Engine getEngine() {
        if (engine == null) {
            engine = Engine.newBuilder().out(out).err(err).build();
        }
        return engine;
    }

    protected String run(Source source) throws IOException {
        this.out.reset();
        this.err.reset();
        context.eval(source);
        this.out.flush();
        this.err.flush();
        String outText = getOut();
        return outText;
    }

    protected static boolean containsTag(String[] tags, String tag) {
        for (int i = 0; i < tags.length; i++) {
            if (tags[i] == tag) {
                return true;
            }
        }
        return false;
    }

    protected String run(String source) throws IOException {
        return run(lines(source));
    }

    protected void assertEvalOut(String source, String output) throws IOException {
        assertEvalOut(lines(source), output);
    }

    protected void assertEvalOut(Source source, String output) throws IOException {
        String actual = run(source);
        String error = getErr();
        if (!error.isEmpty()) {
            throw new AssertionError("Unexpected error printed: %s" + error);
        }
        if (!actual.equals(output)) {
            Assert.assertEquals(output, actual);
        }
    }

    protected final String getOut() {
        return new String(out.toByteArray());
    }

    protected final String getErr() {
        return new String(err.toByteArray());
    }

    protected static com.oracle.truffle.api.source.Source linesImpl(String... lines) {
        StringBuilder b = new StringBuilder();
        for (String line : lines) {
            b.append(line);
            b.append("\n");
        }
        return com.oracle.truffle.api.source.Source.newBuilder(InstrumentationTestLanguage.ID, b.toString(), null).name("unknown").build();
    }

    protected static Source lines(String... lines) {
        StringBuilder b = new StringBuilder();
        for (String line : lines) {
            b.append(line);
            b.append("\n");
        }
        return Source.create(InstrumentationTestLanguage.ID, b.toString());
    }

    @SuppressWarnings("static-method")
    protected final boolean isInitialized(Instrument instrument) {
        Object instrumentImpl = ReflectionUtils.getField(instrument, "receiver");
        return (Boolean) ReflectionUtils.getField(instrumentImpl, "initialized");
    }

    @SuppressWarnings("static-method")
    protected final boolean isCreated(Instrument instrument) {
        Object instrumentImpl = ReflectionUtils.getField(instrument, "receiver");
        return (Boolean) ReflectionUtils.getField(instrumentImpl, "created");
    }

    protected final void assureEnabled(Instrument instrument) {
        instrument.lookup(Object.class);
        Assert.assertTrue("Not enabled, instrument does not provide service Object.class", isCreated(instrument));
    }

    @SuppressWarnings("static-method")
    protected final com.oracle.truffle.api.source.Source getSourceImpl(Source source) {
        return sourceToImpl(source);
    }

    static final com.oracle.truffle.api.source.Source sourceToImpl(Source source) {
        return (com.oracle.truffle.api.source.Source) ReflectionUtils.getField(source, "receiver");
    }

    @SuppressWarnings("static-method")
    protected final com.oracle.truffle.api.source.SourceSection getSectionImpl(SourceSection sourceSection) {
        return (com.oracle.truffle.api.source.SourceSection) ReflectionUtils.getField(sourceSection, "receiver");
    }

    protected final SourceSection createSection(Source source, int charIndex, int length) {
        com.oracle.truffle.api.source.Source sourceImpl = getSourceImpl(source);
        com.oracle.truffle.api.source.SourceSection sectionImpl = sourceImpl.createSection(charIndex, length);
        return TestAccessor.ACCESSOR.engineAccess().createSourceSection(getPolyglotEngine(), source, sectionImpl);
    }

    private Object getPolyglotEngine() {
        return ReflectionUtils.getField(engine, "receiver");
    }

    @After
    public void teardown() {
        cleanup();
        if (engine != null) {
            engine.close();
            engine = null;
        }
        InstrumentationTestLanguage.envConfig = new HashMap<>();
    }

    static final class TestAccessor extends Accessor {

        EngineSupport engineAccess() {
            return engineSupport();
        }

        static final TestAccessor ACCESSOR = new TestAccessor();

    }
}