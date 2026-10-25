package p094kotlin.p117text.p118jdk8;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p117text.MatchGroup;
import p094kotlin.p117text.MatchGroupCollection;
import p094kotlin.p117text.MatchNamedGroupCollection;

@Metadata(m4987d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0082\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¨\u0006\b"}, m4988d2 = {"get", "Lkotlin/text/MatchGroup;", "Lkotlin/text/MatchGroupCollection;", "name", BuildConfig.f24315FLAVOR, "Lkotlin/SinceKotlin;", "version", "1.2", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4991pn = "kotlin.text", m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "RegexExtensionsJDK8Kt")
/* loaded from: classes.dex */
public final class RegexExtensionsJDK8Kt {
    @SinceKotlin(m5061version = "1.2")
    /* renamed from: get */
    public static final MatchGroup m6858get(MatchGroupCollection matchGroupCollection, String name) {
        Intrinsics.checkNotNullParameter(matchGroupCollection, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        MatchNamedGroupCollection matchNamedGroupCollection = matchGroupCollection instanceof MatchNamedGroupCollection ? (MatchNamedGroupCollection) matchGroupCollection : null;
        if (matchNamedGroupCollection != null) {
            return matchNamedGroupCollection.mo6688get(name);
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
