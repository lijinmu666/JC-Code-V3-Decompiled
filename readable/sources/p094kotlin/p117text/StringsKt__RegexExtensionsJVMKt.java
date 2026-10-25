package p094kotlin.p117text;

import java.util.regex.Pattern;
import p094kotlin.Metadata;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0003¨\u0006\u0004"}, m4988d2 = {"toRegex", "Lkotlin/text/Regex;", "Ljava/util/regex/Pattern;", "Lkotlin/internal/InlineOnly;", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
class StringsKt__RegexExtensionsJVMKt extends StringsKt__IndentKt {
    @InlineOnly
    /* renamed from: toRegex */
    private static final C1312Regex m6715toRegex(Pattern pattern) {
        Intrinsics.checkNotNullParameter(pattern, "<this>");
        return new C1312Regex(pattern);
    }
}
