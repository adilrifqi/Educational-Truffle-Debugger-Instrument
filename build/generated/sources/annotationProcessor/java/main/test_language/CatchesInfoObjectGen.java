// CheckStyle: start generated
package test_language;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import test_language.InstrumentationTestLanguage.TryNode.CatchesInfoObject;

@GeneratedBy(CatchesInfoObject.class)
final class CatchesInfoObjectGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(CatchesInfoObject.class, new InteropLibraryExports());
    }

    private CatchesInfoObjectGen() {
    }

    @GeneratedBy(CatchesInfoObject.class)
    static class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, CatchesInfoObject.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof CatchesInfoObject;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof CatchesInfoObject;
            return new Cached(receiver);
        }

        @GeneratedBy(CatchesInfoObject.class)
        static class Cached extends InteropLibrary {

            private final Class<? extends CatchesInfoObject> receiverClass_;

            protected Cached(Object receiver) {
                CatchesInfoObject castReceiver = ((CatchesInfoObject) receiver) ;
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
            public boolean isMemberInvocable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).isMemberInvocable(member);
            }

            @Override
            public Object invokeMember(Object receiver, String member, Object... arguments) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).invokeMember(member, arguments);
            }

        }
        @GeneratedBy(CatchesInfoObject.class)
        static class Uncached extends InteropLibrary {

            private final Class<? extends CatchesInfoObject> receiverClass_;

            protected Uncached(Object receiver) {
                this.receiverClass_ = ((CatchesInfoObject) receiver).getClass();
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
                return ((CatchesInfoObject) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((CatchesInfoObject) receiver) .getMembers(includeInternal);
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInvocable(Object receiver, String member) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((CatchesInfoObject) receiver) .isMemberInvocable(member);
            }

            @TruffleBoundary
            @Override
            public Object invokeMember(Object receiver, String member, Object... arguments) throws UnsupportedMessageException, ArityException, UnknownIdentifierException, UnsupportedTypeException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((CatchesInfoObject) receiver) .invokeMember(member, arguments);
            }

        }
    }
}
