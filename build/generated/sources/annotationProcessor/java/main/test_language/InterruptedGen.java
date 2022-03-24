// CheckStyle: start generated
package test_language;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ExceptionType;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import test_language.InstrumentationTestLanguage.Interrupted;

@GeneratedBy(Interrupted.class)
final class InterruptedGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(Interrupted.class, new InteropLibraryExports());
    }

    private InterruptedGen() {
    }

    @GeneratedBy(Interrupted.class)
    static class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, Interrupted.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof Interrupted;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof Interrupted;
            return new Cached(receiver);
        }

        @GeneratedBy(Interrupted.class)
        static class Cached extends InteropLibrary {

            private final Class<? extends Interrupted> receiverClass_;

            protected Cached(Object receiver) {
                Interrupted castReceiver = ((Interrupted) receiver) ;
                this.receiverClass_ = castReceiver.getClass();
            }

            @Override
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return CompilerDirectives.isExact(receiver, this.receiverClass_);
            }

            @Override
            public ExceptionType getExceptionType(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).getExceptionType();
            }

        }
        @GeneratedBy(Interrupted.class)
        static class Uncached extends InteropLibrary {

            private final Class<? extends Interrupted> receiverClass_;

            protected Uncached(Object receiver) {
                this.receiverClass_ = ((Interrupted) receiver).getClass();
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
            public ExceptionType getExceptionType(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Interrupted) receiver) .getExceptionType();
            }

        }
    }
}
