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
import test_language.InstrumentationTestLanguage.InstrumentationMetaObject;

@GeneratedBy(InstrumentationMetaObject.class)
final class InstrumentationMetaObjectGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(InstrumentationMetaObject.class, new InteropLibraryExports());
    }

    private InstrumentationMetaObjectGen() {
    }

    @GeneratedBy(InstrumentationMetaObject.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private static final Uncached UNCACHED = new Uncached();
        private static final Cached CACHE = new Cached();

        private InteropLibraryExports() {
            super(InteropLibrary.class, InstrumentationMetaObject.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof InstrumentationMetaObject;
            InteropLibrary uncached = InteropLibraryExports.UNCACHED;
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof InstrumentationMetaObject;
            return InteropLibraryExports.CACHE;
        }

        @GeneratedBy(InstrumentationMetaObject.class)
        private static final class Cached extends InteropLibrary {

            protected Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof InstrumentationMetaObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof InstrumentationMetaObject;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public boolean isMetaObject(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (((InstrumentationMetaObject) receiver)).isMetaObject();
            }

            @Override
            public boolean hasLanguage(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (((InstrumentationMetaObject) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (((InstrumentationMetaObject) receiver)).getLanguage();
            }

            @Override
            public Object getMetaQualifiedName(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (((InstrumentationMetaObject) receiver)).getMetaQualifiedName();
            }

            @Override
            public Object getMetaSimpleName(Object receiver) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (((InstrumentationMetaObject) receiver)).getMetaSimpleName();
            }

            @Override
            public boolean isMetaInstance(Object receiver, Object instance) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (((InstrumentationMetaObject) receiver)).isMetaInstance(instance);
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return (((InstrumentationMetaObject) receiver)).toDisplayString(allowSideEffects);
            }

        }
        @GeneratedBy(InstrumentationMetaObject.class)
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof InstrumentationMetaObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof InstrumentationMetaObject;
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
            public boolean isMetaObject(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentationMetaObject) receiver) .isMetaObject();
            }

            @TruffleBoundary
            @Override
            public boolean hasLanguage(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentationMetaObject) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentationMetaObject) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public Object getMetaQualifiedName(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentationMetaObject) receiver) .getMetaQualifiedName();
            }

            @TruffleBoundary
            @Override
            public Object getMetaSimpleName(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentationMetaObject) receiver) .getMetaSimpleName();
            }

            @TruffleBoundary
            @Override
            public boolean isMetaInstance(Object receiver, Object instance) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentationMetaObject) receiver) .isMetaInstance(instance);
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentationMetaObject) receiver) .toDisplayString(allowSideEffects);
            }

        }
    }
}
