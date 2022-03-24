// CheckStyle: start generated
package test_language;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import test_language.InstrumentationTestLanguage.Null;

@GeneratedBy(Null.class)
final class NullGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(Null.class, new InteropLibraryExports());
    }

    private NullGen() {
    }

    @GeneratedBy(Null.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private static final Uncached UNCACHED = new Uncached();
        private static final Cached CACHE = new Cached();

        private InteropLibraryExports() {
            super(InteropLibrary.class, Null.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof Null;
            InteropLibrary uncached = InteropLibraryExports.UNCACHED;
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof Null;
            return InteropLibraryExports.CACHE;
        }

        @GeneratedBy(Null.class)
        private static final class Cached extends InteropLibrary {

            protected Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof Null) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof Null;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public boolean isNull(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (((Null) receiver)).isNull();
            }

            @Override
            public boolean hasLanguage(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (((Null) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (((Null) receiver)).getLanguage();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (((Null) receiver)).toDisplayString(allowSideEffects);
            }

        }
        @GeneratedBy(Null.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof Null) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof Null;
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
            public boolean isNull(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Null) receiver) .isNull();
            }

            @TruffleBoundary
            @Override
            public boolean hasLanguage(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Null) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Null) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((Null) receiver) .toDisplayString(allowSideEffects);
            }

        }
    }
}
