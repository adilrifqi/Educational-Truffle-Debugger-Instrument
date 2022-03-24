package debugger;

import com.oracle.truffle.api.debug.DebuggerSession;
import com.oracle.truffle.api.instrumentation.TruffleInstrument;
import test_language.AbstractInstrumentationTest;
import org.graalvm.polyglot.Instrument;
import org.graalvm.polyglot.Source;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static debugger.DebuggerInstrument.ID;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

public class MyDebuggerTest extends AbstractInstrumentationTest {
    private DebuggerSession debuggerSession;

    @Before
    public void setupDebugger() throws IOException {
        Instrument instrument = engine.getInstruments().get(ID);
        assert !isCreated(instrument) : "Not enabled yet";
        debuggerSession = instrument.lookup(DebuggerSession.class);
        assert isCreated(instrument) : "Got enabled";
        assert debuggerSession != null : "We can control the debugger";

        assertTrue("Enabled by requesting registered services class", isCreated(instrument));
        assertNotNull("Debugger interface found", debuggerSession);
        DebuggerInstrument itself = instrument.lookup(DebuggerInstrument.class);
        assertNull("Debugger instrument itself isn't found", itself);
        TruffleInstrument instr = instrument.lookup(TruffleInstrument.class);
        assertNull("Instrument itself isn't found", instr);
        assertEvalOut("", ""); // ensure debugger gets loaded
    }

    @Test
    public void basicTest() throws IOException {
        Source source = lines("ROOT(", // 1
                "VARIABLE(lol, 1),", // 2
                "DEFINE(foo,STATEMENT),", // 3
                "DEFINE(bar", // 4
                /**/",STATEMENT", // 5
                /**/",STATEMENT(CALL(foo))", // 6
                /**/",STATEMENT),", // 7
                "STATEMENT(CALL(bar)),", // 8
                "STATEMENT(CALL(bar)))"); // 9

        run(source);
    }
}
