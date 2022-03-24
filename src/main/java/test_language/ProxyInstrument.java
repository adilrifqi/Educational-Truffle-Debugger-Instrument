package test_language;

import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import org.graalvm.options.OptionDescriptors;

import java.util.function.Consumer;

/**
 * Reusable language for testing that allows wrap all methods.
 */
@TruffleInstrument.Registration(id = ProxyInstrument.ID, name = ProxyInstrument.ID, version = "1.0", services = ProxyInstrument.Initialize.class)
public class ProxyInstrument extends TruffleInstrument {

    public static final String ID = "proxyInstrument";

    public interface Initialize {

        Env getEnv();
    }

    private static volatile ProxyInstrument delegate = new ProxyInstrument();
    static {
        delegate.wrapper = false;
    }
    private boolean wrapper = true;
    protected ProxyInstrument instrument;
    private Consumer<Env> onCreate;

    public static <T extends ProxyInstrument> T setDelegate(T delegate) {
        ProxyInstrument prevInstrument = ProxyInstrument.delegate != null ? ProxyInstrument.delegate.instrument : null;
        ((ProxyInstrument) delegate).wrapper = false;
        ProxyInstrument.delegate = delegate;
        delegate.instrument = prevInstrument;
        return delegate;
    }

    public void setOnCreate(Consumer<Env> onCreate) {
        this.onCreate = onCreate;
    }

    @Override
    protected OptionDescriptors getOptionDescriptors() {
        if (wrapper) {
            delegate.instrument = this;
            return delegate.getOptionDescriptors();
        }
        return super.getOptionDescriptors();
    }

    @Override
    protected OptionDescriptors getContextOptionDescriptors() {
        if (wrapper) {
            delegate.instrument = this;
            return delegate.getContextOptionDescriptors();
        }
        return super.getContextOptionDescriptors();
    }

    @Override
    protected void onCreate(Env env) {
        env.registerService(new Initialize() {
            public Env getEnv() {
                return env;
            }
        });
        if (wrapper) {
            delegate.instrument = this;
            delegate.onCreate(env);
        }
        if (onCreate != null) {
            onCreate.accept(env);
        }
    }

    @Override
    protected void onDispose(Env env) {
        if (wrapper) {
            delegate.instrument = this;
            delegate.onDispose(env);
        }
    }

    @Override
    protected void onFinalize(Env env) {
        if (wrapper) {
            delegate.instrument = this;
            delegate.onFinalize(env);
        }
    }

    public static ProxyInstrument getCurrent() {
        return delegate;
    }

}