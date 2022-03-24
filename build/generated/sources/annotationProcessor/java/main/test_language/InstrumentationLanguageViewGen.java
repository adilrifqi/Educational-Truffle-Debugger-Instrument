// CheckStyle: start generated
package test_language;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.Library;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.library.ReflectionLibrary;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.api.utilities.FinalBitSet;
import test_language.InstrumentationTestLanguage.InstrumentationLanguageView;

@GeneratedBy(InstrumentationLanguageView.class)
final class InstrumentationLanguageViewGen {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);
    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<ReflectionLibrary> REFLECTION_LIBRARY_ = LibraryFactory.resolve(ReflectionLibrary.class);

    static  {
        LibraryExport.register(InstrumentationLanguageView.class, new InteropLibraryExports(), new ReflectionLibraryExports());
    }

    private InstrumentationLanguageViewGen() {
    }

    @GeneratedBy(InstrumentationLanguageView.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        static final FinalBitSet ENABLED_MESSAGES = createMessageBitSet(INTEROP_LIBRARY_, "hasLanguage", "getLanguage", "hasSourceLocation", "getSourceLocation", "toDisplayString", "hasMetaObject", "getMetaObject");
        private static final Uncached UNCACHED = new Uncached();

        private InteropLibraryExports() {
            super(InteropLibrary.class, InstrumentationLanguageView.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof InstrumentationLanguageView;
            InteropLibrary uncached = createDelegate(INTEROP_LIBRARY_, InteropLibraryExports.UNCACHED);
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof InstrumentationLanguageView;
            return createDelegate(INTEROP_LIBRARY_, new Cached(receiver));
        }

        @GeneratedBy(InstrumentationLanguageView.class)
        private static final class Cached extends InteropLibrary implements DelegateExport {

            @Child private InteropLibrary receiverDelegateInteropLibrary_;

            protected Cached(Object receiver) {
                InstrumentationLanguageView castReceiver = ((InstrumentationLanguageView) receiver) ;
                this.receiverDelegateInteropLibrary_ = super.insert(INTEROP_LIBRARY_.create((castReceiver.delegate)));
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return ((InstrumentationLanguageView) receiver_).delegate;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate) {
                return this.receiverDelegateInteropLibrary_;
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof InstrumentationLanguageView) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof InstrumentationLanguageView)) {
                    return false;
                } else if (!this.receiverDelegateInteropLibrary_.accepts((((InstrumentationLanguageView) receiver).delegate))) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public boolean hasLanguage(Object receiver) {
                assert receiver instanceof InstrumentationLanguageView : "Invalid library usage. Library does not accept given receiver.";
                return (((InstrumentationLanguageView) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof InstrumentationLanguageView : "Invalid library usage. Library does not accept given receiver.";
                return (((InstrumentationLanguageView) receiver)).getLanguage();
            }

            @Override
            public boolean hasSourceLocation(Object receiver) {
                assert receiver instanceof InstrumentationLanguageView : "Invalid library usage. Library does not accept given receiver.";
                return (((InstrumentationLanguageView) receiver)).hasSourceLocation();
            }

            @Override
            public SourceSection getSourceLocation(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof InstrumentationLanguageView : "Invalid library usage. Library does not accept given receiver.";
                return (((InstrumentationLanguageView) receiver)).getSourceLocation();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert receiver instanceof InstrumentationLanguageView : "Invalid library usage. Library does not accept given receiver.";
                return (((InstrumentationLanguageView) receiver)).toDisplayString(allowSideEffects);
            }

            @Override
            public boolean hasMetaObject(Object receiver) {
                assert receiver instanceof InstrumentationLanguageView : "Invalid library usage. Library does not accept given receiver.";
                return (((InstrumentationLanguageView) receiver)).hasMetaObject();
            }

            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof InstrumentationLanguageView : "Invalid library usage. Library does not accept given receiver.";
                return (((InstrumentationLanguageView) receiver)).getMetaObject();
            }

        }
        @GeneratedBy(InstrumentationLanguageView.class)
        private static final class Uncached extends InteropLibrary implements DelegateExport {

            protected Uncached() {
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return (((InstrumentationLanguageView) receiver_)).delegate;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate_) {
                return INTEROP_LIBRARY_.getUncached(delegate_);
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof InstrumentationLanguageView) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof InstrumentationLanguageView;
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
                return ((InstrumentationLanguageView) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentationLanguageView) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public boolean hasSourceLocation(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentationLanguageView) receiver) .hasSourceLocation();
            }

            @TruffleBoundary
            @Override
            public SourceSection getSourceLocation(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentationLanguageView) receiver) .getSourceLocation();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentationLanguageView) receiver) .toDisplayString(allowSideEffects);
            }

            @TruffleBoundary
            @Override
            public boolean hasMetaObject(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentationLanguageView) receiver) .hasMetaObject();
            }

            @TruffleBoundary
            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((InstrumentationLanguageView) receiver) .getMetaObject();
            }

        }
    }
    @GeneratedBy(InstrumentationLanguageView.class)
    private static final class ReflectionLibraryExports extends LibraryExport<ReflectionLibrary> {

        static final FinalBitSet ENABLED_MESSAGES = createMessageBitSet(REFLECTION_LIBRARY_);
        private static final Uncached UNCACHED = new Uncached();

        private ReflectionLibraryExports() {
            super(ReflectionLibrary.class, InstrumentationLanguageView.class, false, false, 0);
        }

        @Override
        protected ReflectionLibrary createUncached(Object receiver) {
            assert receiver instanceof InstrumentationLanguageView;
            ReflectionLibrary uncached = createDelegate(REFLECTION_LIBRARY_, ReflectionLibraryExports.UNCACHED);
            return uncached;
        }

        @Override
        protected ReflectionLibrary createCached(Object receiver) {
            assert receiver instanceof InstrumentationLanguageView;
            return createDelegate(REFLECTION_LIBRARY_, new Cached(receiver));
        }

        @GeneratedBy(InstrumentationLanguageView.class)
        private static final class Cached extends ReflectionLibrary implements DelegateExport {

            @Child private ReflectionLibrary receiverDelegateReflectionLibrary_;

            protected Cached(Object receiver) {
                InstrumentationLanguageView castReceiver = ((InstrumentationLanguageView) receiver) ;
                this.receiverDelegateReflectionLibrary_ = super.insert(REFLECTION_LIBRARY_.create((castReceiver.delegate)));
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return ((InstrumentationLanguageView) receiver_).delegate;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate) {
                return this.receiverDelegateReflectionLibrary_;
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof InstrumentationLanguageView) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof InstrumentationLanguageView)) {
                    return false;
                } else if (!this.receiverDelegateReflectionLibrary_.accepts((((InstrumentationLanguageView) receiver).delegate))) {
                    return false;
                } else {
                    return true;
                }
            }

        }
        @GeneratedBy(InstrumentationLanguageView.class)
        private static final class Uncached extends ReflectionLibrary implements DelegateExport {

            protected Uncached() {
            }

            @Override
            public FinalBitSet getDelegateExportMessages() {
                return ENABLED_MESSAGES;
            }

            @Override
            public Object readDelegateExport(Object receiver_) {
                return (((InstrumentationLanguageView) receiver_)).delegate;
            }

            @Override
            public Library getDelegateExportLibrary(Object delegate_) {
                return REFLECTION_LIBRARY_.getUncached(delegate_);
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof InstrumentationLanguageView) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof InstrumentationLanguageView;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MEGAMORPHIC;
            }

        }
    }
}
