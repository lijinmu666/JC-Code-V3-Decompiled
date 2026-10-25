package p094kotlin.comparisons;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000X\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0017\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0014\n\u0002\u0010\u0013\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0005\u001a,\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\tH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a,\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a,\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a,\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a,\u0010\u0000\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a,\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001aE\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0010\u001a\u0002H\u0001H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0011\u001a4\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a4\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a4\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a4\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a4\u0010\u0000\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a4\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001aI\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u0013\"\u0002H\u0001H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015¢\u0006\u0002\u0010\u0014\u001a,\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\n\u0010\u0012\u001a\u00020\u0016\"\u00020\tH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u001a,\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\u0012\u001a\u00020\u0017\"\u00020\u000bH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u001a,\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\n\u0010\u0012\u001a\u00020\u0018\"\u00020\fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u001a,\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\u0012\u001a\u00020\u0019\"\u00020\rH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u001a,\u0010\u0000\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\n\u0010\u0012\u001a\u00020\u001a\"\u00020\u000eH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u001a,\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\u0012\u001a\u00020\u001b\"\u00020\u000fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u001a=\u0010\u001c\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0005\u001a,\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\tH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a,\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a,\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a,\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a,\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a,\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001aE\u0010\u001c\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0010\u001a\u0002H\u0001H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0011\u001a4\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a4\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a4\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a4\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a4\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001a4\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\n\u001aI\u0010\u001c\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u0013\"\u0002H\u0001H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015¢\u0006\u0002\u0010\u0014\u001a,\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\n\u0010\u0012\u001a\u00020\u0016\"\u00020\tH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u001a,\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\u0012\u001a\u00020\u0017\"\u00020\u000bH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u001a,\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\n\u0010\u0012\u001a\u00020\u0018\"\u00020\fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u001a,\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\u0012\u001a\u00020\u0019\"\u00020\rH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u001a,\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\n\u0010\u0012\u001a\u00020\u001a\"\u00020\u000eH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u001a,\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\u0012\u001a\u00020\u001b\"\u00020\u000fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015¨\u0006\u001d"}, m4988d2 = {"maxOf", "T", BuildConfig.f24315FLAVOR, "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "Lkotlin/SinceKotlin;", "version", "1.1", BuildConfig.f24315FLAVOR, "Lkotlin/internal/InlineOnly;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", BuildConfig.f24315FLAVOR, "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "1.4", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "minOf", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: classes.dex */
public class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    @SinceKotlin(m5061version = "1.1")
    /* renamed from: maxOf */
    public static <T extends Comparable<? super T>> T m6047maxOf(T a, T b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return a.compareTo(b) >= 0 ? a : b;
    }

    @SinceKotlin(m5061version = "1.1")
    /* renamed from: minOf */
    public static final <T extends Comparable<? super T>> T m6068minOf(T a, T b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return a.compareTo(b) <= 0 ? a : b;
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: maxOf */
    private static final byte m6032maxOf(byte b, byte b2) {
        return (byte) Math.max((int) b, (int) b2);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: minOf */
    private static final byte m6053minOf(byte b, byte b2) {
        return (byte) Math.min((int) b, (int) b2);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: maxOf */
    private static final short m6050maxOf(short s, short s2) {
        return (short) Math.max((int) s, (int) s2);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: minOf */
    private static final short m6071minOf(short s, short s2) {
        return (short) Math.min((int) s, (int) s2);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: maxOf */
    private static final int m6041maxOf(int i, int i2) {
        return Math.max(i, i2);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: minOf */
    private static final int m6062minOf(int i, int i2) {
        return Math.min(i, i2);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: maxOf */
    private static final long m6044maxOf(long j, long j2) {
        return Math.max(j, j2);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: minOf */
    private static final long m6065minOf(long j, long j2) {
        return Math.min(j, j2);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: maxOf */
    private static final float m6038maxOf(float f, float f2) {
        return Math.max(f, f2);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: minOf */
    private static final float m6059minOf(float f, float f2) {
        return Math.min(f, f2);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: maxOf */
    private static final double m6035maxOf(double d, double d2) {
        return Math.max(d, d2);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: minOf */
    private static final double m6056minOf(double d, double d2) {
        return Math.min(d, d2);
    }

    @SinceKotlin(m5061version = "1.1")
    /* renamed from: maxOf */
    public static final <T extends Comparable<? super T>> T m6048maxOf(T a, T b, T c) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(c, "c");
        return (T) ComparisonsKt.m6047maxOf(a, ComparisonsKt.m6047maxOf(b, c));
    }

    @SinceKotlin(m5061version = "1.1")
    /* renamed from: minOf */
    public static final <T extends Comparable<? super T>> T m6069minOf(T a, T b, T c) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(c, "c");
        return (T) m6068minOf(a, m6068minOf(b, c));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: maxOf */
    private static final byte m6033maxOf(byte b, byte b2, byte b3) {
        return (byte) Math.max((int) b, Math.max((int) b2, (int) b3));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: minOf */
    private static final byte m6054minOf(byte b, byte b2, byte b3) {
        return (byte) Math.min((int) b, Math.min((int) b2, (int) b3));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: maxOf */
    private static final short m6051maxOf(short s, short s2, short s3) {
        return (short) Math.max((int) s, Math.max((int) s2, (int) s3));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: minOf */
    private static final short m6072minOf(short s, short s2, short s3) {
        return (short) Math.min((int) s, Math.min((int) s2, (int) s3));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: maxOf */
    private static final int m6042maxOf(int i, int i2, int i3) {
        return Math.max(i, Math.max(i2, i3));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: minOf */
    private static final int m6063minOf(int i, int i2, int i3) {
        return Math.min(i, Math.min(i2, i3));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: maxOf */
    private static final long m6045maxOf(long j, long j2, long j3) {
        return Math.max(j, Math.max(j2, j3));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: minOf */
    private static final long m6066minOf(long j, long j2, long j3) {
        return Math.min(j, Math.min(j2, j3));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: maxOf */
    private static final float m6039maxOf(float f, float f2, float f3) {
        return Math.max(f, Math.max(f2, f3));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: minOf */
    private static final float m6060minOf(float f, float f2, float f3) {
        return Math.min(f, Math.min(f2, f3));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: maxOf */
    private static final double m6036maxOf(double d, double d2, double d3) {
        return Math.max(d, Math.max(d2, d3));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: minOf */
    private static final double m6057minOf(double d, double d2, double d3) {
        return Math.min(d, Math.min(d2, d3));
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: maxOf */
    public static final <T extends Comparable<? super T>> T m6049maxOf(T a, T... other) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(other, "other");
        for (T t : other) {
            a = (T) ComparisonsKt.m6047maxOf(a, t);
        }
        return a;
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: minOf */
    public static final <T extends Comparable<? super T>> T m6070minOf(T a, T... other) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(other, "other");
        for (T t : other) {
            a = (T) m6068minOf(a, t);
        }
        return a;
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: maxOf */
    public static final byte m6034maxOf(byte b, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (byte b2 : other) {
            b = (byte) Math.max((int) b, (int) b2);
        }
        return b;
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: minOf */
    public static final byte m6055minOf(byte b, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (byte b2 : other) {
            b = (byte) Math.min((int) b, (int) b2);
        }
        return b;
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: maxOf */
    public static final short m6052maxOf(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (short s2 : other) {
            s = (short) Math.max((int) s, (int) s2);
        }
        return s;
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: minOf */
    public static final short m6073minOf(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (short s2 : other) {
            s = (short) Math.min((int) s, (int) s2);
        }
        return s;
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: maxOf */
    public static final int m6043maxOf(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i2 : other) {
            i = Math.max(i, i2);
        }
        return i;
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: minOf */
    public static final int m6064minOf(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i2 : other) {
            i = Math.min(i, i2);
        }
        return i;
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: maxOf */
    public static final long m6046maxOf(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (long j2 : other) {
            j = Math.max(j, j2);
        }
        return j;
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: minOf */
    public static final long m6067minOf(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (long j2 : other) {
            j = Math.min(j, j2);
        }
        return j;
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: maxOf */
    public static final float m6040maxOf(float f, float... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (float f2 : other) {
            f = Math.max(f, f2);
        }
        return f;
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: minOf */
    public static final float m6061minOf(float f, float... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (float f2 : other) {
            f = Math.min(f, f2);
        }
        return f;
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: maxOf */
    public static final double m6037maxOf(double d, double... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (double d2 : other) {
            d = Math.max(d, d2);
        }
        return d;
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: minOf */
    public static final double m6058minOf(double d, double... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (double d2 : other) {
            d = Math.min(d, d2);
        }
        return d;
    }
}
