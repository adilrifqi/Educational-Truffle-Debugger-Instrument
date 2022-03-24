// CheckStyle: start generated
package test_language;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleFile.FileTypeDetector;
import com.oracle.truffle.api.TruffleLanguage.ContextPolicy;
import com.oracle.truffle.api.TruffleLanguage.Provider;
import com.oracle.truffle.api.TruffleLanguage.Registration;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags.ExpressionTag;
import com.oracle.truffle.api.instrumentation.StandardTags.RootBodyTag;
import com.oracle.truffle.api.instrumentation.StandardTags.RootTag;
import com.oracle.truffle.api.instrumentation.StandardTags.StatementTag;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@GeneratedBy(ProxyLanguage.class)
@Registration(characterMimeTypes = {"application/x-proxy-language"}, contextPolicy = ContextPolicy.SHARED, id = "proxyLanguage", name = "proxyLanguage", version = "1.0")
@ProvidedTags({ExpressionTag.class, StatementTag.class, RootBodyTag.class, RootTag.class})
public final class ProxyLanguageProvider implements Provider {

    @Override
    public String getLanguageClassName() {
        return "test_language.ProxyLanguage";
    }

    @Override
    public TruffleLanguage<?> create() {
        return new ProxyLanguage();
    }

    @Override
    public List<FileTypeDetector> createFileTypeDetectors() {
        return Collections.emptyList();
    }

    @Override
    public Collection<String> getServicesClassNames() {
        return Collections.emptySet();
    }

}
