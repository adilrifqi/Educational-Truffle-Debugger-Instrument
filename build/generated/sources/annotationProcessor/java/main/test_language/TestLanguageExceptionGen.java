// CheckStyle: start generated
package test_language;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ExceptionType;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import test_language.InstrumentationTestLanguage.ThrowNode.TestLanguageException;

@GeneratedBy(TestLanguageException.class)
public final class TestLanguageExceptionGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(TestLanguageException.class, new InteropLibraryExports());
    }

    private TestLanguageExceptionGen() {
    }

    @GeneratedBy(TestLanguageException.class)
    public static class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, TestLanguageException.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof TestLanguageException;
            InteropLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof TestLanguageException;
            return new Cached(receiver);
        }

        @GeneratedBy(TestLanguageException.class)
        public static class Cached extends InteropLibrary {

            private final Class<? extends TestLanguageException> receiverClass_;

            protected Cached(Object receiver) {
                TestLanguageException castReceiver = ((TestLanguageException) receiver) ;
                this.receiverClass_ = castReceiver.getClass();
            }

            @Override
            public boolean accepts(Object receiver) {
                assert receiver.getClass() != this.receiverClass_ || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return CompilerDirectives.isExact(receiver, this.receiverClass_);
            }

            @Override
            public boolean hasLanguage(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).getLanguage();
            }

            @Override
            public ExceptionType getExceptionType(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).getExceptionType();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).toDisplayString(allowSideEffects);
            }

            @Override
            public boolean isString(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).isString();
            }

            @Override
            public String asString(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (CompilerDirectives.castExact(receiver, receiverClass_)).asString();
            }

        }
        @GeneratedBy(TestLanguageException.class)
        public static class Uncached extends InteropLibrary {

            private final Class<? extends TestLanguageException> receiverClass_;

            protected Uncached(Object receiver) {
                this.receiverClass_ = ((TestLanguageException) receiver).getClass();
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
            public boolean hasLanguage(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TestLanguageException) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TestLanguageException) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public ExceptionType getExceptionType(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TestLanguageException) receiver) .getExceptionType();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TestLanguageException) receiver) .toDisplayString(allowSideEffects);
            }

            @TruffleBoundary
            @Override
            public boolean isString(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TestLanguageException) receiver) .isString();
            }

            @TruffleBoundary
            @Override
            public String asString(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TestLanguageException) receiver) .asString();
            }

        }
    }
}
