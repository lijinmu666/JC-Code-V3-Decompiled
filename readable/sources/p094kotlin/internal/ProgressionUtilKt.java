package p094kotlin.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;

@Metadata(m4987d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0082\u0080\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\u0080\u0004\u001a\"\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0082\u0080\u0004\u001a\"\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0082\u0080\u0004\u001a*\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0081\u0080\u0004b\u0002\b\u000bb\u0002\b\f\u001a*\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0081\u0080\u0004b\u0002\b\u000bb\u0002\b\f¨\u0006\r"}, m4988d2 = {"mod", BuildConfig.f24315FLAVOR, "a", "b", BuildConfig.f24315FLAVOR, "differenceModulo", "c", "getProgressionLastElement", "start", "end", "step", "Lkotlin/PublishedApi;", "Lkotlin/internal/UsedFromCompilerGeneratedCode;", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class ProgressionUtilKt {
    private static final int differenceModulo(int i, int i2, int i3) {
        return m6142mod(m6142mod(i, i3) - m6142mod(i2, i3), i3);
    }

    @PublishedApi
    @UsedFromCompilerGeneratedCode
    public static final int getProgressionLastElement(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - differenceModulo(i2, i, i3);
        }
        if (i3 < 0) {
            return i <= i2 ? i2 : i2 + differenceModulo(i, i2, -i3);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    /* renamed from: mod */
    private static final int m6142mod(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    private static final long differenceModulo(long j, long j2, long j3) {
        return m6143mod(m6143mod(j, j3) - m6143mod(j2, j3), j3);
    }

    /* renamed from: mod */
    private static final long m6143mod(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }

    @PublishedApi
    @UsedFromCompilerGeneratedCode
    public static final long getProgressionLastElement(long j, long j2, long j3) {
        if (j3 > 0) {
            return j >= j2 ? j2 : j2 - differenceModulo(j2, j, j3);
        }
        if (j3 < 0) {
            return j <= j2 ? j2 : j2 + differenceModulo(j, j2, -j3);
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
