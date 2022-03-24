// CheckStyle: start generated
package test_language;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.NodeLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import test_language.InstrumentationTestLanguage.InstrumentedNode;

@GeneratedBy(InstrumentedNode.class)
public final class InstrumentedNodeGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(InstrumentedNode.class, new InteropLibraryExports(), new NodeLibraryExports());
    }

    private InstrumentedNodeGen() {
    }

    @GeneratedBy(InstrumentedNode.class)
    public static class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, InstrumentedNode.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof InstrumentedNode;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof InstrumentedNode;
            return new Cached(receiver);
        }

        @GeneratedBy(InstrumentedNode.class)
        public static class Cached extends InteropLibrary {

            private final Class<? extends InstrumentedNode> receiverClass_;

            protected Cached(Object receiver) {
                InstrumentedNode castReceiver = ((InstrumentedNode) receiver) ;
                this.receiverClass_ = castReceiver.getClass();
            }

            @Override
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return CompilerDirectives.isExact(receiver, this.receiverClass_);
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).hasMembers();
            }

            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).getMembers(includeInternal);
            }

            @Override
            public boolean isMemberReadable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).isMemberReadable(member);
            }

            @Override
            public Object readMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).readMember(member);
            }

        }
        @GeneratedBy(InstrumentedNode.class)
        public static class Uncached extends InteropLibrary {

            private final Class<? extends InstrumentedNode> receiverClass_;

            protected Uncached(Object receiver) {
                this.receiverClass_ = ((InstrumentedNode) receiver).getClass();
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return CompilerDirectives.isExact(receiver, this.receiverClass_);
            }

            @Override
            public final boolean isAdoptable() {
                return false;
            }

            @Override
            public final NodeCost getCost() {
                return NodeCost.MEGAMORPHIC;
            }

            @TruffleBoundary
            @Override
            public boolean hasMembers(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentedNode) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentedNode) receiver) .getMembers(includeInternal);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object receiver, String member) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentedNode) receiver) .isMemberReadable(member);
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object receiver, String member) throws UnsupportedMessageException, UnknownIdentifierException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentedNode) receiver) .readMember(member);
            }

        }
    }
    @GeneratedBy(InstrumentedNode.class)
    public static class NodeLibraryExports extends LibraryExport<NodeLibrary> {

        private NodeLibraryExports() {
            super(NodeLibrary.class, InstrumentedNode.class, false, false, 0);
        }

        @Override
        protected NodeLibrary createUncached(Object receiver) {
            assert receiver instanceof InstrumentedNode;
            NodeLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected NodeLibrary createCached(Object receiver) {
            assert receiver instanceof InstrumentedNode;
            return new Cached(receiver);
        }

        @GeneratedBy(InstrumentedNode.class)
        public static class Cached extends NodeLibrary {

            private final Class<? extends InstrumentedNode> receiverClass_;

            protected Cached(Object receiver) {
                InstrumentedNode castReceiver = ((InstrumentedNode) receiver) ;
                this.receiverClass_ = castReceiver.getClass();
            }

            @Override
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return CompilerDirectives.isExact(receiver, this.receiverClass_);
            }

            @Override
            public boolean hasScope(Object receiver, Frame frame) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).hasScope(frame);
            }

            @Override
            public Object getScope(Object receiver, Frame frame, boolean nodeEnter) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).getScope(frame, nodeEnter);
            }

            @Override
            public boolean hasReceiverMember(Object receiver, Frame frame) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).hasReceiverMember(frame);
            }

            @Override
            public Object getReceiverMember(Object receiver, Frame frame) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).getReceiverMember(frame);
            }

            @Override
            public boolean hasRootInstance(Object receiver, Frame frame) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).hasRootInstance(frame);
            }

            @Override
            public Object getRootInstance(Object receiver, Frame frame) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).getRootInstance(frame);
            }

        }
        @GeneratedBy(InstrumentedNode.class)
        public static class Uncached extends NodeLibrary {

            private final Class<? extends InstrumentedNode> receiverClass_;

            protected Uncached(Object receiver) {
                this.receiverClass_ = ((InstrumentedNode) receiver).getClass();
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return CompilerDirectives.isExact(receiver, this.receiverClass_);
            }

            @Override
            public final boolean isAdoptable() {
                return false;
            }

            @Override
            public final NodeCost getCost() {
                return NodeCost.MEGAMORPHIC;
            }

            @TruffleBoundary
            @Override
            public boolean hasScope(Object receiver, Frame frame) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentedNode) receiver) .hasScope(frame);
            }

            @TruffleBoundary
            @Override
            public Object getScope(Object receiver, Frame frame, boolean nodeEnter) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentedNode) receiver) .getScope(frame, nodeEnter);
            }

            @TruffleBoundary
            @Override
            public boolean hasReceiverMember(Object receiver, Frame frame) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentedNode) receiver) .hasReceiverMember(frame);
            }

            @TruffleBoundary
            @Override
            public Object getReceiverMember(Object receiver, Frame frame) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentedNode) receiver) .getReceiverMember(frame);
            }

            @TruffleBoundary
            @Override
            public boolean hasRootInstance(Object receiver, Frame frame) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentedNode) receiver) .hasRootInstance(frame);
            }

            @TruffleBoundary
            @Override
            public Object getRootInstance(Object receiver, Frame frame) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentedNode) receiver) .getRootInstance(frame);
            }

        }
    }
}
