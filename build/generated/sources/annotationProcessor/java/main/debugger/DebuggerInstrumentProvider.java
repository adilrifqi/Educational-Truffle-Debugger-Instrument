// CheckStyle: start generated
package debugger;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Provider;
import com.oracle.truffle.api.instrumentation.TruffleInstrument.Registration;
import java.util.Arrays;
import java.util.Collection;

@GeneratedBy(DebuggerInstrument.class)
@Registration(id = "mydebugger", name = "My Debugger Instrument", version = "1.0")
public final class DebuggerInstrumentProvider implements Provider {

    @Override
    public String getInstrumentClassName() {
        return "debugger.DebuggerInstrument";
    }

    @Override
    public TruffleInstrument create() {
        return new DebuggerInstrument();
    }

    @Override
    public Collection<String> getServicesClassNames() {
        return Arrays.asList("com.oracle.truffle.api.debug.DebuggerSession");
    }

}
