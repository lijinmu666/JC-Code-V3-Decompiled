package p094kotlin.p101io;

import java.io.InputStream;
import java.nio.charset.Charset;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecatedSinceKotlin;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0018\u0010\u000e\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u000e\u0010\u000e\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0018\u0010\u000f\u001a\u00020\u0010H\u0087\u0080\u0004b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u001a\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0087\u0080\u0004b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u001a(\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0087\u0080\u0004b\f\b\u0016\u0012\b\b\u0002\u0012\u0004\b\b(\u0017b\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a¨\u0006\u001b"}, m4988d2 = {"print", BuildConfig.f24315FLAVOR, "message", BuildConfig.f24315FLAVOR, "Lkotlin/internal/InlineOnly;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "println", "readln", BuildConfig.f24315FLAVOR, "Lkotlin/SinceKotlin;", "version", "1.6", "readlnOrNull", "readLine", "Lkotlin/Deprecated;", "Use `readln()` instead of `readLine()!!`, and `readlnOrNull()` instead of `readLine()`.", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "2.4", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "ConsoleKt")
/* loaded from: classes.dex */
public final class ConsoleKt {
    @InlineOnly
    /* renamed from: print */
    private static final void m6164print(Object obj) {
        System.out.print(obj);
    }

    @InlineOnly
    /* renamed from: println */
    private static final void m6175println(Object obj) {
        System.out.println(obj);
    }

    @Deprecated(m4972message = "Use `readln()` instead of `readLine()!!`, and `readlnOrNull()` instead of `readLine()`.")
    @DeprecatedSinceKotlin(warningSince = "2.4")
    public static final String readLine() {
        return readlnOrNull();
    }

    @SinceKotlin(m5061version = "1.6")
    /* renamed from: readln */
    public static final String m6179readln() {
        String str = readlnOrNull();
        if (str != null) {
            return str;
        }
        throw new ReadAfterEOFException("EOF has already been reached");
    }

    @SinceKotlin(m5061version = "1.6")
    public static final String readlnOrNull() {
        LineReader lineReader = LineReader.INSTANCE;
        InputStream in = System.in;
        Intrinsics.checkNotNullExpressionValue(in, "in");
        Charset charsetDefaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(charsetDefaultCharset, "defaultCharset(...)");
        return lineReader.readLine(in, charsetDefaultCharset);
    }

    @InlineOnly
    /* renamed from: print */
    private static final void m6162print(int i) {
        System.out.print(i);
    }

    @InlineOnly
    /* renamed from: println */
    private static final void m6173println(int i) {
        System.out.println(i);
    }

    @InlineOnly
    /* renamed from: print */
    private static final void m6163print(long j) {
        System.out.print(j);
    }

    @InlineOnly
    /* renamed from: println */
    private static final void m6174println(long j) {
        System.out.println(j);
    }

    @InlineOnly
    /* renamed from: print */
    private static final void m6158print(byte b) {
        System.out.print(Byte.valueOf(b));
    }

    @InlineOnly
    /* renamed from: println */
    private static final void m6169println(byte b) {
        System.out.println(Byte.valueOf(b));
    }

    @InlineOnly
    /* renamed from: print */
    private static final void m6165print(short s) {
        System.out.print(Short.valueOf(s));
    }

    @InlineOnly
    /* renamed from: println */
    private static final void m6176println(short s) {
        System.out.println(Short.valueOf(s));
    }

    @InlineOnly
    /* renamed from: print */
    private static final void m6159print(char c) {
        System.out.print(c);
    }

    @InlineOnly
    /* renamed from: println */
    private static final void m6170println(char c) {
        System.out.println(c);
    }

    @InlineOnly
    /* renamed from: print */
    private static final void m6166print(boolean z) {
        System.out.print(z);
    }

    @InlineOnly
    /* renamed from: println */
    private static final void m6177println(boolean z) {
        System.out.println(z);
    }

    @InlineOnly
    /* renamed from: print */
    private static final void m6161print(float f) {
        System.out.print(f);
    }

    @InlineOnly
    /* renamed from: println */
    private static final void m6172println(float f) {
        System.out.println(f);
    }

    @InlineOnly
    /* renamed from: print */
    private static final void m6160print(double d) {
        System.out.print(d);
    }

    @InlineOnly
    /* renamed from: println */
    private static final void m6171println(double d) {
        System.out.println(d);
    }

    @InlineOnly
    /* renamed from: print */
    private static final void m6167print(char[] message) {
        Intrinsics.checkNotNullParameter(message, "message");
        System.out.print(message);
    }

    @InlineOnly
    /* renamed from: println */
    private static final void m6178println(char[] message) {
        Intrinsics.checkNotNullParameter(message, "message");
        System.out.println(message);
    }

    @InlineOnly
    /* renamed from: println */
    private static final void m6168println() {
        System.out.println();
    }
}
