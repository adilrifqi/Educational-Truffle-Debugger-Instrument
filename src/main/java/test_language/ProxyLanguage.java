package test_language;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags.ExpressionTag;
import com.oracle.truffle.api.instrumentation.StandardTags.RootBodyTag;
import com.oracle.truffle.api.instrumentation.StandardTags.RootTag;
import com.oracle.truffle.api.instrumentation.StandardTags.StatementTag;
import com.oracle.truffle.api.nodes.ExecutableNode;
import com.oracle.truffle.api.nodes.Node;
import org.graalvm.options.OptionDescriptors;

import java.util.function.Consumer;

/**
 * Reusable language for testing that allows wrap all methods.
 */
@TruffleLanguage.Registration(id = ProxyLanguage.ID, name = ProxyLanguage.ID, version = "1.0", contextPolicy = TruffleLanguage.ContextPolicy.SHARED, characterMimeTypes = "application/x-proxy-language")
@ProvidedTags({ExpressionTag.class, StatementTag.class, RootBodyTag.class, RootTag.class})
public class ProxyLanguage extends TruffleLanguage<ProxyLanguage.LanguageContext> {

    public static final String ID = "proxyLanguage";

    public static class LanguageContext {
        final Env env;

        LanguageContext(Env env) {
            this.env = env;
        }

        public Env getEnv() {
            return env;
        }

        private static final ContextReference<LanguageContext> REFERENCE = ContextReference.create(ProxyLanguage.class);

        public static LanguageContext get(Node node) {
            return REFERENCE.get(node);
        }
    }

    private static volatile ProxyLanguage delegate = new ProxyLanguage();
    static {
        delegate.wrapper = false;
    }
    protected boolean wrapper = true;
    public ProxyLanguage languageInstance;

    private Consumer<LanguageContext> onCreate;

    public static <T extends ProxyLanguage> T setDelegate(T delegate) {
        ((ProxyLanguage) delegate).wrapper = false;
        ProxyLanguage.delegate = delegate;
        return delegate;
    }

    public void setOnCreate(Consumer<LanguageContext> onCreate) {
        this.onCreate = onCreate;
    }

    private static final LanguageReference<ProxyLanguage> REFERENCE = LanguageReference.create(ProxyLanguage.class);

    public static ProxyLanguage get(Node node) {
        return REFERENCE.get(node);
    }

    @Override
    protected LanguageContext createContext(TruffleLanguage.Env env) {
        if (wrapper) {
            delegate.languageInstance = this;
            LanguageContext c = delegate.createContext(env);
            if (delegate.onCreate != null) {
                delegate.onCreate.accept(c);
            }
            return c;
        } else {
            LanguageContext c = new LanguageContext(env);
            if (onCreate != null) {
                onCreate.accept(c);
            }
            return c;
        }
    }

    @Override
    protected Object getLanguageView(LanguageContext context, Object value) {
        if (wrapper) {
            delegate.languageInstance = this;
            return delegate.getLanguageView(context, value);
        } else {
            return super.getLanguageView(context, value);
        }
    }

    @Override
    protected void finalizeContext(LanguageContext context) {
        if (wrapper) {
            delegate.finalizeContext(context);
        } else {
            super.finalizeContext(context);
        }
    }

    @Override
    protected void exitContext(LanguageContext context, ExitMode exitMode, int exitCode) {
        if (wrapper) {
            delegate.exitContext(context, exitMode, exitCode);
        } else {
            super.exitContext(context, exitMode, exitCode);
        }
    }

    @Override
    protected void disposeContext(LanguageContext context) {
        if (wrapper) {
            delegate.languageInstance = this;
            delegate.disposeContext(context);
        } else {
            super.disposeContext(context);
        }
    }

    @Override
    protected void disposeThread(LanguageContext context, Thread thread) {

        if (wrapper) {
            delegate.languageInstance = this;
            delegate.disposeThread(context, thread);
        } else {
            super.disposeThread(context, thread);
        }
    }

    @Override
    protected void initializeContext(LanguageContext context) throws Exception {
        if (wrapper) {
            delegate.languageInstance = this;
            delegate.initializeContext(context);
        } else {
            super.initializeContext(context);
        }

    }

    @Override
    protected void initializeMultipleContexts() {
        if (wrapper) {
            delegate.languageInstance = this;
            delegate.initializeMultipleContexts();
        } else {
            super.initializeMultipleContexts();
        }
    }

    @Override
    protected void initializeMultiThreading(LanguageContext context) {
        if (wrapper) {
            delegate.languageInstance = this;
            delegate.initializeMultiThreading(context);
        } else {
            super.initializeMultiThreading(context);
        }
    }

    @Override
    protected void initializeThread(LanguageContext context, Thread thread) {
        if (wrapper) {
            delegate.languageInstance = this;
            delegate.initializeThread(context, thread);
        } else {
            super.initializeThread(context, thread);
        }
    }

    @Override
    protected boolean isThreadAccessAllowed(Thread thread, boolean singleThreaded) {
        if (wrapper) {
            delegate.languageInstance = this;
            return delegate.isThreadAccessAllowed(thread, singleThreaded);
        } else {
            return super.isThreadAccessAllowed(thread, singleThreaded);
        }
    }

    @Override
    protected boolean isVisible(LanguageContext context, Object value) {
        if (wrapper) {
            delegate.languageInstance = this;
            return delegate.isVisible(context, value);
        } else {
            return super.isVisible(context, value);
        }
    }

    @Override
    protected OptionDescriptors getOptionDescriptors() {
        if (wrapper) {
            delegate.languageInstance = this;
            return delegate.getOptionDescriptors();
        } else {
            return super.getOptionDescriptors();
        }
    }

    @Override
    protected CallTarget parse(TruffleLanguage.ParsingRequest request) throws Exception {
        if (wrapper) {
            delegate.languageInstance = this;
            return delegate.parse(request);
        } else {
            return super.parse(request);
        }
    }

    @Override
    protected Object getScope(LanguageContext context) {
        if (wrapper) {
            delegate.languageInstance = this;
            return delegate.getScope(context);
        } else {
            return super.getScope(context);
        }
    }

    @Override
    protected ExecutableNode parse(InlineParsingRequest request) throws Exception {
        if (wrapper) {
            delegate.languageInstance = this;
            return delegate.parse(request);
        } else {
            return super.parse(request);
        }
    }

}