package debugger;

import com.oracle.truffle.api.debug.Breakpoint;
import com.oracle.truffle.api.debug.DebuggerSession;
import com.oracle.truffle.api.debug.SuspendAnchor;
import com.oracle.truffle.api.instrumentation.LoadSourceEvent;
import com.oracle.truffle.api.instrumentation.LoadSourceListener;

public class LoadSourceHandler implements LoadSourceListener {
    private final DebuggerSession debuggerSession;
    private final int breakpointLine;

    public LoadSourceHandler(DebuggerSession debuggerSession, int breakpointLine) {
        this.debuggerSession = debuggerSession;
        this.breakpointLine = breakpointLine;
    }

    @Override
    public void onLoad(LoadSourceEvent event) {
        debuggerSession.install(Breakpoint.newBuilder(event.getSource()).lineIs(breakpointLine).build());
    }
}
