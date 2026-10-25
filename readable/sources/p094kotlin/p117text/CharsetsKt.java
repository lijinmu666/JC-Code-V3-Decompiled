package p094kotlin.p117text;

import java.nio.charset.Charset;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u0004¨\u0006\u0005"}, m4988d2 = {"charset", "Ljava/nio/charset/Charset;", "charsetName", BuildConfig.f24315FLAVOR, "Lkotlin/internal/InlineOnly;", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "CharsetsKt")
/* loaded from: classes.dex */
public final class CharsetsKt {
    @InlineOnly
    /* renamed from: charset */
    private static final Charset m6680charset(String charsetName) {
        Intrinsics.checkNotNullParameter(charsetName, "charsetName");
        Charset charsetForName = Charset.forName(charsetName);
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        return charsetForName;
    }
}
