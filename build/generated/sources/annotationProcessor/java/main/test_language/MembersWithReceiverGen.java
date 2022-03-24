// CheckStyle: start generated
package test_language;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidArrayIndexException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import java.util.concurrent.locks.Lock;
import test_language.InstrumentationTestLanguage.InstrumentedNode.VariablesWithThis.MembersWithReceiver;

@GeneratedBy(MembersWithReceiver.class)
final class MembersWithReceiverGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(MembersWithReceiver.class, new InteropLibraryExports());
    }

    private MembersWithReceiverGen() {
    }

    @GeneratedBy(MembersWithReceiver.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, MembersWithReceiver.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof MembersWithReceiver;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof MembersWithReceiver;
            return new Cached();
        }

        @GeneratedBy(MembersWithReceiver.class)
        private static final class Cached extends InteropLibrary {

            @CompilationFinal private volatile int state_0_;
            @Child private InteropLibrary interop;

            protected Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof MembersWithReceiver) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof MembersWithReceiver;
            }

            @Override
            public boolean hasArrayElements(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((MembersWithReceiver) receiver)).hasArrayElements();
            }

            @Override
            public Object readArrayElement(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidArrayIndexException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                MembersWithReceiver arg0Value = ((MembersWithReceiver) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1) != 0 /* is-state_0 readArrayElement(MembersWithReceiver, long, InteropLibrary) */) {
                    return arg0Value.readArrayElement(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readArrayElementNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readArrayElementNode_AndSpecialize(MembersWithReceiver arg0Value, long arg1Value) throws UnsupportedMessageException, InvalidArrayIndexException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(1))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 readArrayElement(MembersWithReceiver, long, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readArrayElement(arg1Value, this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public NodeCost getCost() {
                int state_0 = this.state_0_;
                if ((state_0 & 0b1) == 0) {
                    return NodeCost.UNINITIALIZED;
                } else {
                    return NodeCost.MONOMORPHIC;
                }
            }

            @Override
            public long getArraySize(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                MembersWithReceiver arg0Value = ((MembersWithReceiver) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10) != 0 /* is-state_0 getArraySize(MembersWithReceiver, InteropLibrary) */) {
                    return arg0Value.getArraySize(this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getArraySizeNode_AndSpecialize(arg0Value);
            }

            private long getArraySizeNode_AndSpecialize(MembersWithReceiver arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(1))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 getArraySize(MembersWithReceiver, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.getArraySize(this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isArrayElementReadable(Object arg0Value_, long arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                MembersWithReceiver arg0Value = ((MembersWithReceiver) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100) != 0 /* is-state_0 isArrayElementReadable(MembersWithReceiver, long, InteropLibrary) */) {
                    return arg0Value.isArrayElementReadable(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isArrayElementReadableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isArrayElementReadableNode_AndSpecialize(MembersWithReceiver arg0Value, long arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(1))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 isArrayElementReadable(MembersWithReceiver, long, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isArrayElementReadable(arg1Value, this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

        }
        @GeneratedBy(MembersWithReceiver.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof MembersWithReceiver) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof MembersWithReceiver;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MEGAMORPHIC;
            }

            @TruffleBoundary
            @Override
            public boolean hasArrayElements(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((MembersWithReceiver) receiver) .hasArrayElements();
            }

            @TruffleBoundary
            @Override
            public Object readArrayElement(Object arg0Value_, long arg1Value) throws UnsupportedMessageException, InvalidArrayIndexException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                MembersWithReceiver arg0Value = ((MembersWithReceiver) arg0Value_);
                return arg0Value.readArrayElement(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public long getArraySize(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                MembersWithReceiver arg0Value = ((MembersWithReceiver) arg0Value_);
                return arg0Value.getArraySize((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isArrayElementReadable(Object arg0Value_, long arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                MembersWithReceiver arg0Value = ((MembersWithReceiver) arg0Value_);
                return arg0Value.isArrayElementReadable(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

        }
    }
}
