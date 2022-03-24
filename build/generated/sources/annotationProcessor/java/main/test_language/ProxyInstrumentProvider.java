// CheckStyle: start generated
package test_language;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Provider;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Registration;
import java.util.Arrays;
import java.util.Collection;

@GeneratedBy(ProxyInstrument.class)
@Registration(id = "proxyInstrument", name = "proxyInstrument", version = "1.0")
public final class ProxyInstrumentProvider implements Provider {

    @Override
    public String getInstrumentClassName() {
        return "test_language.ProxyInstrument";
    }

    @Override
    public TruffleInstrument create() {
        return new ProxyInstrument();
    }

    @Override
    public Collection<String> getServicesClassNames() {
        return Arrays.asList("test_language.ProxyInstrument$Initialize");
    }

}
