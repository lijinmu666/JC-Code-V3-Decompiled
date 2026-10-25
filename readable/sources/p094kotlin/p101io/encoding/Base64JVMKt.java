package p094kotlin.p101io.encoding;

import java.nio.charset.Charset;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p117text.Charsets;

@Metadata(m4987d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nb\u0002\b\u000b\u001a8\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nb\u0002\b\u000b\u001aH\u0010\u000e\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nb\u0002\b\u000b\u001a8\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nb\u0002\b\u000b¨\u0006\u0012"}, m4988d2 = {"platformCharsToBytes", BuildConfig.f24315FLAVOR, "Lkotlin/io/encoding/Base64;", "source", BuildConfig.f24315FLAVOR, "startIndex", BuildConfig.f24315FLAVOR, "endIndex", "Lkotlin/SinceKotlin;", "version", "1.8", "Lkotlin/internal/InlineOnly;", "platformEncodeToString", BuildConfig.f24315FLAVOR, "platformEncodeIntoByteArray", "destination", "destinationOffset", "platformEncodeToByteArray", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class Base64JVMKt {
    @SinceKotlin(m5061version = "1.8")
    @InlineOnly
    private static final byte[] platformCharsToBytes(C1217Base64 c1217Base64, CharSequence source, int i, int i2) {
        Intrinsics.checkNotNullParameter(c1217Base64, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(source instanceof String)) {
            return c1217Base64.charsToBytesImpl$kotlin_stdlib(source, i, i2);
        }
        String str = (String) source;
        c1217Base64.checkSourceBounds$kotlin_stdlib(str.length(), i, i2);
        String strSubstring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        Charset charset = Charsets.ISO_8859_1;
        Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = strSubstring.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    @SinceKotlin(m5061version = "1.8")
    @InlineOnly
    private static final int platformEncodeIntoByteArray(C1217Base64 c1217Base64, byte[] source, byte[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(c1217Base64, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return c1217Base64.encodeIntoByteArrayImpl$kotlin_stdlib(source, destination, i, i2, i3);
    }

    @SinceKotlin(m5061version = "1.8")
    @InlineOnly
    private static final byte[] platformEncodeToByteArray(C1217Base64 c1217Base64, byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(c1217Base64, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return c1217Base64.encodeToByteArrayImpl$kotlin_stdlib(source, i, i2);
    }

    @SinceKotlin(m5061version = "1.8")
    @InlineOnly
    private static final String platformEncodeToString(C1217Base64 c1217Base64, byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(c1217Base64, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return new String(c1217Base64.encodeToByteArrayImpl$kotlin_stdlib(source, i, i2), Charsets.ISO_8859_1);
    }
}
