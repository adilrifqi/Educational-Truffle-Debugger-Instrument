// CheckStyle: start generated
package test_language;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.source.SourceSection;
import java.util.concurrent.locks.Lock;
import test_language.InstrumentationTestLanguage.InstrumentedNode.VariablesWithThis;

@GeneratedBy(VariablesWithThis.class)
final class VariablesWithThisGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    static  {
        LibraryExport.register(VariablesWithThis.class, new InteropLibraryExports());
    }

    private VariablesWithThisGen() {
    }

    @GeneratedBy(VariablesWithThis.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, VariablesWithThis.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof VariablesWithThis;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof VariablesWithThis;
            return new Cached();
        }

        @GeneratedBy(VariablesWithThis.class)
        private static final class Cached extends InteropLibrary {

            @CompilationFinal private volatile int state_0_;
            @Child private InteropLibrary interop;

            protected Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof VariablesWithThis) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof VariablesWithThis;
            }

            @Override
            public boolean hasLanguage(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((VariablesWithThis) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((VariablesWithThis) receiver)).getLanguage();
            }

            @Override
            public boolean isScope(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((VariablesWithThis) receiver)).isScope();
            }

            @Override
            public boolean hasScopeParent(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1) != 0 /* is-state_0 hasScopeParent(VariablesWithThis, InteropLibrary) */) {
                    return arg0Value.hasScopeParent(this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasScopeParentNode_AndSpecialize(arg0Value);
            }

            private boolean hasScopeParentNode_AndSpecialize(VariablesWithThis arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(1))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 hasScopeParent(VariablesWithThis, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.hasScopeParent(this.interop);
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
            public Object getScopeParent(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10) != 0 /* is-state_0 getScopeParent(VariablesWithThis, InteropLibrary) */) {
                    return arg0Value.getScopeParent(this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getScopeParentNode_AndSpecialize(arg0Value);
            }

            private Object getScopeParentNode_AndSpecialize(VariablesWithThis arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(1))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 getScopeParent(VariablesWithThis, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.getScopeParent(this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((VariablesWithThis) receiver)).hasMembers();
            }

            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100) != 0 /* is-state_0 getMembers(VariablesWithThis, boolean, InteropLibrary) */) {
                    return arg0Value.getMembers(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getMembersNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object getMembersNode_AndSpecialize(VariablesWithThis arg0Value, boolean arg1Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(1))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 getMembers(VariablesWithThis, boolean, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.getMembers(arg1Value, this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 readMember(VariablesWithThis, String, InteropLibrary) */) {
                    return arg0Value.readMember(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readMemberNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readMemberNode_AndSpecialize(VariablesWithThis arg0Value, String arg1Value) throws UnknownIdentifierException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(1))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 readMember(VariablesWithThis, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readMember(arg1Value, this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000) != 0 /* is-state_0 isMemberReadable(VariablesWithThis, String, InteropLibrary) */) {
                    return arg0Value.isMemberReadable(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberReadableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberReadableNode_AndSpecialize(VariablesWithThis arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(1))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 isMemberReadable(VariablesWithThis, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberReadable(arg1Value, this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000) != 0 /* is-state_0 writeMember(VariablesWithThis, String, Object, InteropLibrary) */) {
                    arg0Value.writeMember(arg1Value, arg2Value, this.interop);
                    return;
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeMemberNode_AndSpecialize(VariablesWithThis arg0Value, String arg1Value, Object arg2Value) throws UnknownIdentifierException, UnsupportedTypeException, UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(1))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 writeMember(VariablesWithThis, String, Object, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    arg0Value.writeMember(arg1Value, arg2Value, this.interop);
                    return;
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000) != 0 /* is-state_0 isMemberModifiable(VariablesWithThis, String, InteropLibrary) */) {
                    return arg0Value.isMemberModifiable(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isMemberModifiableNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean isMemberModifiableNode_AndSpecialize(VariablesWithThis arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(1))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 isMemberModifiable(VariablesWithThis, String, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.isMemberModifiable(arg1Value, this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberInsertable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((VariablesWithThis) receiver)).isMemberInsertable(member);
            }

            @Override
            public Object toDisplayString(Object arg0Value_, boolean arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000000) != 0 /* is-state_0 toDisplayString(VariablesWithThis, boolean, InteropLibrary) */) {
                    return arg0Value.toDisplayString(arg1Value, this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return toDisplayStringNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object toDisplayStringNode_AndSpecialize(VariablesWithThis arg0Value, boolean arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(1))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 toDisplayString(VariablesWithThis, boolean, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.toDisplayString(arg1Value, this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean hasSourceLocation(Object arg0Value_) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000000) != 0 /* is-state_0 hasSourceLocation(VariablesWithThis, InteropLibrary) */) {
                    return arg0Value.hasSourceLocation(this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return hasSourceLocationNode_AndSpecialize(arg0Value);
            }

            private boolean hasSourceLocationNode_AndSpecialize(VariablesWithThis arg0Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(1))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 hasSourceLocation(VariablesWithThis, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.hasSourceLocation(this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public SourceSection getSourceLocation(Object arg0Value_) throws UnsupportedMessageException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000000000) != 0 /* is-state_0 getSourceLocation(VariablesWithThis, InteropLibrary) */) {
                    return arg0Value.getSourceLocation(this.interop);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return getSourceLocationNode_AndSpecialize(arg0Value);
            }

            private SourceSection getSourceLocationNode_AndSpecialize(VariablesWithThis arg0Value) throws UnsupportedMessageException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.interop = super.insert(this.interop == null ? ((INTEROP_LIBRARY_.createDispatched(1))) : this.interop);
                    this.state_0_ = state_0 = state_0 | 0b1000000000 /* add-state_0 getSourceLocation(VariablesWithThis, InteropLibrary) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.getSourceLocation(this.interop);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

        }
        @GeneratedBy(VariablesWithThis.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof VariablesWithThis) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof VariablesWithThis;
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
            public boolean hasLanguage(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((VariablesWithThis) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((VariablesWithThis) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public boolean isScope(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((VariablesWithThis) receiver) .isScope();
            }

            @TruffleBoundary
            @Override
            public boolean hasScopeParent(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                return arg0Value.hasScopeParent((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object getScopeParent(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                return arg0Value.getScopeParent((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasMembers(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((VariablesWithThis) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                return arg0Value.getMembers(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnknownIdentifierException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                return arg0Value.readMember(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                return arg0Value.isMemberReadable(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnknownIdentifierException, UnsupportedTypeException, UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                arg0Value.writeMember(arg1Value, arg2Value, (INTEROP_LIBRARY_.getUncached()));
                return;
            }

            @TruffleBoundary
            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                return arg0Value.isMemberModifiable(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInsertable(Object receiver, String member) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((VariablesWithThis) receiver) .isMemberInsertable(member);
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object arg0Value_, boolean arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                return arg0Value.toDisplayString(arg1Value, (INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean hasSourceLocation(Object arg0Value_) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                return arg0Value.hasSourceLocation((INTEROP_LIBRARY_.getUncached()));
            }

            @TruffleBoundary
            @Override
            public SourceSection getSourceLocation(Object arg0Value_) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                VariablesWithThis arg0Value = ((VariablesWithThis) arg0Value_);
                return arg0Value.getSourceLocation((INTEROP_LIBRARY_.getUncached()));
            }

        }
    }
}
