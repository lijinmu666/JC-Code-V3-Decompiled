package p094kotlin.p117text;

import java.util.Set;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0087\u0088\u0004b\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0087\u0088\u0004b\u0002\b\u0003¨\u0006\b"}, m4988d2 = {"toRegex", "Lkotlin/text/Regex;", BuildConfig.f24315FLAVOR, "Lkotlin/internal/InlineOnly;", "option", "Lkotlin/text/RegexOption;", "options", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
class StringsKt__RegexExtensionsKt extends StringsKt__RegexExtensionsJVMKt {
    @InlineOnly
    /* renamed from: toRegex */
    private static final C1312Regex m6716toRegex(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new C1312Regex(str);
    }

    @InlineOnly
    /* renamed from: toRegex */
    private static final C1312Regex m6718toRegex(String str, RegexOption option) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(option, "option");
        return new C1312Regex(str, option);
    }

    @InlineOnly
    /* renamed from: toRegex */
    private static final C1312Regex m6717toRegex(String str, Set<? extends RegexOption> options) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return new C1312Regex(str, options);
    }
}
