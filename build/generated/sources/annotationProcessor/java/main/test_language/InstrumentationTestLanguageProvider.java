// CheckStyle: start generated
package test_language;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleFile.FileTypeDetector;
import com.oracle.truffle.api.TruffleLanguage.ContextPolicy;
import com.oracle.truffle.api.TruffleLanguage.Provider;
import com.oracle.truffle.api.TruffleLanguage.Registration;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags.CallTag;
import com.oracle.truffle.api.instrumentation.StandardTags.ExpressionTag;
import com.oracle.truffle.api.instrumentation.StandardTags.RootBodyTag;
import com.oracle.truffle.api.instrumentation.StandardTags.RootTag;
import com.oracle.truffle.api.instrumentation.StandardTags.StatementTag;
import com.oracle.truffle.api.instrumentation.StandardTags.TryBlockTag;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import test_language.InstrumentationTestLanguage.BlockTag;
import test_language.InstrumentationTestLanguage.ConstantTag;
import test_language.InstrumentationTestLanguage.DefineTag;
import test_language.InstrumentationTestLanguage.LoopTag;

@GeneratedBy(InstrumentationTestLanguage.class)
@Registration(contextPolicy = ContextPolicy.SHARED, id = "instrumentation-test-language", name = "Instrumentation Test Language", version = "2.0")
@ProvidedTags({ExpressionTag.class, DefineTag.class, LoopTag.class, StatementTag.class, CallTag.class, RootTag.class, RootBodyTag.class, TryBlockTag.class, BlockTag.class, ConstantTag.class})
public final class InstrumentationTestLanguageProvider implements Provider {

    @Override
    public String getLanguageClassName() {
        return "test_language.InstrumentationTestLanguage";
    }

    @Override
    public TruffleLanguage<?> create() {
        return new InstrumentationTestLanguage();
    }

    @Override
    public List<FileTypeDetector> createFileTypeDetectors() {
        return Collections.emptyList();
    }

    @Override
    public Collection<String> getServicesClassNames() {
        return Arrays.asList("test_language.SpecialService");
    }

}
