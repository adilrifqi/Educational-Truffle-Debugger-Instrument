package debugger;

import com.oracle.truffle.api.debug.*;
import com.oracle.truffle.api.instrumentation.*;

import java.util.Scanner;

import static debugger.DebuggerInstrument.ID;

@TruffleInstrument.Registration(id = ID, name = "My Debugger Instrument", version = "1.0", services = DebuggerSession.class)
public class DebuggerInstrument extends TruffleInstrument {
    public final static String ID = "mydebugger";

    private DebuggerSession debuggerSession;

    @Override
    protected void onCreate(Env env) {
        Debugger debugger = Debugger.find(env);
        debuggerSession = debugger.startSession(new SuspendedCallback() {
            @Override
            public void onSuspend(SuspendedEvent event) {
                System.out.println("Suspended at line " + event.getSourceSection().getStartLine());
//                event.prepareStepInto(StepConfig.newBuilder().count(1).sourceElements(SourceElement.ROOT, SourceElement.STATEMENT).build());
                event.prepareStepInto(1); // Could be changed to step over or step into

                // The following "paragraph" was written just to see the behaviour of the Stack Frame
                Iterable<DebugStackFrame> stackFrames = event.getStackFrames();
                for (DebugStackFrame stackFrame : stackFrames) {
                    Iterable<DebugValue> variables = stackFrame.getScope().getDeclaredValues();
                    System.out.print("");
                    // When a new Stack Frame is pushed, the variables in the frame's scope object does not include
                    // variables of the enclosing scopes. So the tool should iterate through the scopes when the program
                    // is suspended.
                }
            }
        });

//        int breakpointLine = askLineNumber();
        int breakpointLine = 8;

        // TODO: Find out how to get Context here
        //  Otherwise, just use attachLoadSourceListener for it?
        //  Might not work as it is a listener and we need to set the breakpoint here and now!
        //  Sample:
        SourceFilter filter = SourceFilter.newBuilder().includeInternal(false).build();
        Instrumenter instrumenter = env.getInstrumenter();
        instrumenter.attachLoadSourceListener(filter, new LoadSourceHandler(debuggerSession, breakpointLine), true);

        env.registerService(debuggerSession);
    }

    @Override
    protected void onDispose(Env env) {
    }

    private int askLineNumber() {
        Scanner reader = new Scanner(System.in);

        System.out.print("Which line to debug?");

        int n = reader.nextInt();
        reader.close();

        System.out.print("\n");
        return n;
    }
}
