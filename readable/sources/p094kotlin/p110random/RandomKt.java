package p094kotlin.p110random;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p112ranges.IntRange;
import p094kotlin.p112ranges.LongRange;

@Metadata(m4987d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a$\u0010\b\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a$\u0010\u000b\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\t\u001a\u00020\fH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\u0012\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0080\u0080\u0004\u001a\u0016\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0080\u0080\u0004\u001a\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0080\u0080\u0004\u001a\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0080\u0080\u0004\u001a\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0080\u0080\u0004\u001a\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0018H\u0080\u0080\u0004¨\u0006\u0019"}, m4988d2 = {"Random", "Lkotlin/random/Random;", "seed", BuildConfig.f24315FLAVOR, "Lkotlin/SinceKotlin;", "version", "1.3", BuildConfig.f24315FLAVOR, "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "fastLog2", "value", "takeUpperBits", "bitCount", "checkRangeBounds", BuildConfig.f24315FLAVOR, "from", "until", BuildConfig.f24315FLAVOR, "boundsErrorMessage", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/RandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,392:1\n1#2:393\n*E\n"})
/* loaded from: classes.dex */
public final class RandomKt {
    @SinceKotlin(m5061version = "1.3")
    /* renamed from: Random */
    public static final AbstractC1241Random m6439Random(int i) {
        return new XorWowRandom(i, i >> 31);
    }

    public static final String boundsErrorMessage(Object from, Object until) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void checkRangeBounds(int i, int i2) {
        if (i2 <= i) {
            throw new IllegalArgumentException(boundsErrorMessage(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public static final int fastLog2(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    @SinceKotlin(m5061version = "1.3")
    /* renamed from: nextInt */
    public static final int m6441nextInt(AbstractC1241Random abstractC1241Random, IntRange range) {
        Intrinsics.checkNotNullParameter(abstractC1241Random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.mo6445isEmpty()) {
            return range.getLast() < Integer.MAX_VALUE ? abstractC1241Random.mo6438nextInt(range.getFirst(), range.getLast() + 1) : range.getFirst() > Integer.MIN_VALUE ? abstractC1241Random.mo6438nextInt(range.getFirst() - 1, range.getLast()) + 1 : abstractC1241Random.mo6435nextInt();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @SinceKotlin(m5061version = "1.3")
    public static final long nextLong(AbstractC1241Random abstractC1241Random, LongRange range) {
        Intrinsics.checkNotNullParameter(abstractC1241Random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.mo6445isEmpty()) {
            return range.getLast() < LongCompanionObject.MAX_VALUE ? abstractC1241Random.nextLong(range.getFirst(), range.getLast() + 1) : range.getFirst() > Long.MIN_VALUE ? abstractC1241Random.nextLong(range.getFirst() - 1, range.getLast()) + 1 : abstractC1241Random.nextLong();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int takeUpperBits(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }

    @SinceKotlin(m5061version = "1.3")
    /* renamed from: Random */
    public static final AbstractC1241Random m6440Random(long j) {
        return new XorWowRandom((int) j, (int) (j >> 32));
    }

    public static final void checkRangeBounds(long j, long j2) {
        if (j2 <= j) {
            throw new IllegalArgumentException(boundsErrorMessage(Long.valueOf(j), Long.valueOf(j2)).toString());
        }
    }

    public static final void checkRangeBounds(double d, double d2) {
        if (d2 <= d) {
            throw new IllegalArgumentException(boundsErrorMessage(Double.valueOf(d), Double.valueOf(d2)).toString());
        }
    }
}
