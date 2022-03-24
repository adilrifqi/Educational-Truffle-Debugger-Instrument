// CheckStyle: start generated
package test_language;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.ProbeNode;
import com.oracle.truffle.api.instrumentation.InstrumentableNode.WrapperNode;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import test_language.InstrumentationTestLanguage.TypeSpecializedNode;

@GeneratedBy(TypeSpecializedNode.class)
final class TypeSpecializedNodeWrapper extends TypeSpecializedNode implements WrapperNode {

    @Child private TypeSpecializedNode delegateNode;
    @Child private ProbeNode probeNode;

    TypeSpecializedNodeWrapper(TypeSpecializedNode delegateNode, ProbeNode probeNode) {
        this.delegateNode = delegateNode;
        this.probeNode = probeNode;
    }

    @Override
    public TypeSpecializedNode getDelegateNode() {
        return delegateNode;
    }

    @Override
    public ProbeNode getProbeNode() {
        return probeNode;
    }

    @Override
    public NodeCost getCost() {
        return NodeCost.NONE;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        Object returnValue;
        for (;;) {
            boolean wasOnReturnExecuted = false;
            try {
                probeNode.onEnter(frame);
                returnValue = delegateNode.execute(frame);
                wasOnReturnExecuted = true;
                probeNode.onReturnValue(frame, returnValue);
                break;
            } catch (Throwable t) {
                Object result = probeNode.onReturnExceptionalOrUnwind(frame, t, wasOnReturnExecuted);
                if (result == ProbeNode.UNWIND_ACTION_REENTER) {
                    continue;
                } else if (result != null) {
                    returnValue = result;
                    break;
                }
                throw t;
            }
        }
        return returnValue;
    }

    @Override
    public int executeInt(VirtualFrame frame) throws UnexpectedResultException {
        int returnValue;
        for (;;) {
            boolean wasOnReturnExecuted = false;
            try {
                try {
                    probeNode.onEnter(frame);
                    returnValue = delegateNode.executeInt(frame);
                    wasOnReturnExecuted = true;
                    probeNode.onReturnValue(frame, returnValue);
                    break;
                } catch (UnexpectedResultException e) {
                    wasOnReturnExecuted = true;
                    probeNode.onReturnValue(frame, e.getResult());
                    throw e;
                }
            } catch (Throwable t) {
                Object result = probeNode.onReturnExceptionalOrUnwind(frame, t, wasOnReturnExecuted);
                if (result == ProbeNode.UNWIND_ACTION_REENTER) {
                    continue;
                }
                if (result instanceof Integer) {
                    returnValue = (int) result;
                    break;
                } else if (result != null) {
                    throw new UnexpectedResultException(result);
                }
                throw t;
            }
        }
        return returnValue;
    }

}
