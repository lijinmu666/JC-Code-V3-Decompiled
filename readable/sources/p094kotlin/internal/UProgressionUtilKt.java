package p094kotlin.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.C1128UInt;
import p094kotlin.C1130ULong;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.SinceKotlin;

@Metadata(m4987d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0082\u0080\u0004¢\u0006\u0004\b\b\u0010\t\u001a?\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0081\u0080\u0004b\u0002\b\u0010b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013b\u0002\b\u0014¢\u0006\u0004\b\u000f\u0010\u0006\u001a?\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0015H\u0081\u0080\u0004b\u0002\b\u0010b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013b\u0002\b\u0014¢\u0006\u0004\b\u0016\u0010\t¨\u0006\u0017"}, m4988d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", BuildConfig.f24315FLAVOR, "getProgressionLastElement-Nkh28Cs", "Lkotlin/PublishedApi;", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/internal/UsedFromCompilerGeneratedCode;", BuildConfig.f24315FLAVOR, "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class UProgressionUtilKt {
    /* renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m19727differenceModuloWZ9TVnA(int i, int i2, int i3) {
        int iRemainderUnsigned = Integer.remainderUnsigned(i, i3);
        int iRemainderUnsigned2 = Integer.remainderUnsigned(i2, i3);
        int iCompareUnsigned = Integer.compareUnsigned(iRemainderUnsigned, iRemainderUnsigned2);
        int iM18641constructorimpl = C1128UInt.m18641constructorimpl(iRemainderUnsigned - iRemainderUnsigned2);
        return iCompareUnsigned >= 0 ? iM18641constructorimpl : C1128UInt.m18641constructorimpl(iM18641constructorimpl + i3);
    }

    /* renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m19728differenceModulosambcqE(long j, long j2, long j3) {
        long jRemainderUnsigned = Long.remainderUnsigned(j, j3);
        long jRemainderUnsigned2 = Long.remainderUnsigned(j2, j3);
        int iCompareUnsigned = Long.compareUnsigned(jRemainderUnsigned, jRemainderUnsigned2);
        long jM18720constructorimpl = C1130ULong.m18720constructorimpl(jRemainderUnsigned - jRemainderUnsigned2);
        return iCompareUnsigned >= 0 ? jM18720constructorimpl : C1130ULong.m18720constructorimpl(jM18720constructorimpl + j3);
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    @UsedFromCompilerGeneratedCode
    /* renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m19729getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        if (j3 > 0) {
            return Long.compareUnsigned(j, j2) >= 0 ? j2 : C1130ULong.m18720constructorimpl(j2 - m19728differenceModulosambcqE(j2, j, C1130ULong.m18720constructorimpl(j3)));
        }
        if (j3 < 0) {
            return Long.compareUnsigned(j, j2) <= 0 ? j2 : C1130ULong.m18720constructorimpl(j2 + m19728differenceModulosambcqE(j, j2, C1130ULong.m18720constructorimpl(-j3)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    @UsedFromCompilerGeneratedCode
    /* renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m19730getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        if (i3 > 0) {
            return Integer.compareUnsigned(i, i2) >= 0 ? i2 : C1128UInt.m18641constructorimpl(i2 - m19727differenceModuloWZ9TVnA(i2, i, C1128UInt.m18641constructorimpl(i3)));
        }
        if (i3 < 0) {
            return Integer.compareUnsigned(i, i2) <= 0 ? i2 : C1128UInt.m18641constructorimpl(i2 + m19727differenceModuloWZ9TVnA(i, i2, C1128UInt.m18641constructorimpl(-i3)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
