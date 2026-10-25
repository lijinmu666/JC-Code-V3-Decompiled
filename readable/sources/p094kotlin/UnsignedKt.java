package p094kotlin;

import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.conscrypt.BuildConfig;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p117text.C1302CharsKt;

@Metadata(m4987d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0081\u0080\u0004b\u0002\b\u0006¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0081\u0080\u0004b\u0002\b\u0006¢\u0006\u0004\b\b\u0010\u0005\u001a%\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0081\u0080\u0004b\u0002\b\u0006¢\u0006\u0004\b\u000b\u0010\f\u001a%\u0010\r\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0081\u0080\u0004b\u0002\b\u0006¢\u0006\u0004\b\u000e\u0010\f\u001a\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010H\u0081\u0080\u0004b\u0002\b\u0006\u001a\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0012H\u0081\u0080\u0004b\u0002\b\u0006\u001a\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0010H\u0081\u0088\u0004b\u0002\b\u0006b\u0002\b\u0016¢\u0006\u0002\u0010\u0015\u001a\u001a\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0010H\u0081\u0088\u0004b\u0002\b\u0006b\u0002\b\u0016\u001a\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0010H\u0081\u0088\u0004b\u0002\b\u0006b\u0002\b\u0016\u001a\u001f\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0019H\u0081\u0088\u0004b\u0002\b\u0006b\u0002\b\u0016¢\u0006\u0002\u0010\u001b\u001a\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0010H\u0081\u0080\u0004b\u0002\b\u0006\u001a\u001b\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u001dH\u0081\u0080\u0004b\u0002\b\u0006¢\u0006\u0002\u0010\u001f\u001a\u001a\u0010 \u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0012H\u0081\u0088\u0004b\u0002\b\u0006b\u0002\b\u0016\u001a\u001f\u0010!\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0019H\u0081\u0088\u0004b\u0002\b\u0006b\u0002\b\u0016¢\u0006\u0002\u0010\"\u001a\u0016\u0010#\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0012H\u0081\u0080\u0004b\u0002\b\u0006\u001a\u001b\u0010$\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u001dH\u0081\u0080\u0004b\u0002\b\u0006¢\u0006\u0002\u0010%\u001a\u0016\u0010&\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u0010H\u0081\u0088\u0004b\u0002\b\u0016\u001a\u001e\u0010&\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0081\u0088\u0004b\u0002\b\u0016\u001a\u0016\u0010)\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u0012H\u0081\u0088\u0004b\u0002\b\u0016\u001a\u001a\u0010)\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0010H\u0080\u0080\u0004¨\u0006*"}, m4988d2 = {"uintRemainder", "Lkotlin/UInt;", "v1", "v2", "uintRemainder-J1ME1BU", "(II)I", "Lkotlin/PublishedApi;", "uintDivide", "uintDivide-J1ME1BU", "ulongDivide", "Lkotlin/ULong;", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "uintCompare", BuildConfig.f24315FLAVOR, "ulongCompare", BuildConfig.f24315FLAVOR, "uintToULong", "value", "(I)J", "Lkotlin/internal/InlineOnly;", "uintToLong", "uintToFloat", BuildConfig.f24315FLAVOR, "floatToUInt", "(F)I", "uintToDouble", BuildConfig.f24315FLAVOR, "doubleToUInt", "(D)I", "ulongToFloat", "floatToULong", "(F)J", "ulongToDouble", "doubleToULong", "(D)J", "uintToString", BuildConfig.f24315FLAVOR, "base", "ulongToString", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "UnsignedKt")
/* loaded from: classes.dex */
public final class UnsignedKt {
    @PublishedApi
    public static final int doubleToUInt(double d) {
        if (Double.isNaN(d) || d <= 0.0d) {
            return 0;
        }
        if (d >= 4.294967295E9d) {
            return -1;
        }
        return d <= 2.147483647E9d ? C1128UInt.m18641constructorimpl((int) d) : C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl((int) (d - Integer.MAX_VALUE)) + Integer.MAX_VALUE);
    }

    @PublishedApi
    public static final long doubleToULong(double d) {
        if (Double.isNaN(d) || d <= 0.0d) {
            return 0L;
        }
        if (d >= 1.8446744073709552E19d) {
            return -1L;
        }
        return d < 9.223372036854776E18d ? C1130ULong.m18720constructorimpl((long) d) : C1130ULong.m18720constructorimpl(C1130ULong.m18720constructorimpl((long) (d - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @PublishedApi
    @InlineOnly
    private static final int floatToUInt(float f) {
        return doubleToUInt(f);
    }

    @PublishedApi
    @InlineOnly
    private static final long floatToULong(float f) {
        return doubleToULong(f);
    }

    @PublishedApi
    public static final int uintCompare(int i, int i2) {
        return Intrinsics.m6319compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: uintDivide-J1ME1BU, reason: not valid java name */
    public static final int m18897uintDivideJ1ME1BU(int i, int i2) {
        return C1128UInt.m18641constructorimpl((int) ((i & BodyPartID.bodyIdMax) / (i2 & BodyPartID.bodyIdMax)));
    }

    @PublishedApi
    /* renamed from: uintRemainder-J1ME1BU, reason: not valid java name */
    public static final int m18898uintRemainderJ1ME1BU(int i, int i2) {
        return C1128UInt.m18641constructorimpl((int) ((i & BodyPartID.bodyIdMax) % (i2 & BodyPartID.bodyIdMax)));
    }

    @PublishedApi
    public static final double uintToDouble(int i) {
        return (Integer.MAX_VALUE & i) + (((i >>> 31) << 30) * 2);
    }

    @PublishedApi
    @InlineOnly
    private static final float uintToFloat(int i) {
        return (float) uintToDouble(i);
    }

    @PublishedApi
    @InlineOnly
    private static final long uintToLong(int i) {
        return i & BodyPartID.bodyIdMax;
    }

    @InlineOnly
    private static final String uintToString(int i) {
        return String.valueOf(i & BodyPartID.bodyIdMax);
    }

    @PublishedApi
    @InlineOnly
    private static final long uintToULong(int i) {
        return C1130ULong.m18720constructorimpl(i & BodyPartID.bodyIdMax);
    }

    @PublishedApi
    public static final int ulongCompare(long j, long j2) {
        return Intrinsics.m6320compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: ulongDivide-eb3DHEI, reason: not valid java name */
    public static final long m18899ulongDivideeb3DHEI(long j, long j2) {
        if (j2 < 0) {
            return Long.compareUnsigned(j, j2) < 0 ? C1130ULong.m18720constructorimpl(0L) : C1130ULong.m18720constructorimpl(1L);
        }
        if (j >= 0) {
            return C1130ULong.m18720constructorimpl(j / j2);
        }
        long j3 = ((j >>> 1) / j2) << 1;
        return C1130ULong.m18720constructorimpl(j3 + (Long.compareUnsigned(C1130ULong.m18720constructorimpl(j - (j3 * j2)), C1130ULong.m18720constructorimpl(j2)) < 0 ? 0 : 1));
    }

    @PublishedApi
    /* renamed from: ulongRemainder-eb3DHEI, reason: not valid java name */
    public static final long m18900ulongRemaindereb3DHEI(long j, long j2) {
        if (j2 < 0) {
            return Long.compareUnsigned(j, j2) < 0 ? j : C1130ULong.m18720constructorimpl(j - j2);
        }
        if (j >= 0) {
            return C1130ULong.m18720constructorimpl(j % j2);
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (Long.compareUnsigned(C1130ULong.m18720constructorimpl(j3), C1130ULong.m18720constructorimpl(j2)) < 0) {
            j2 = 0;
        }
        return C1130ULong.m18720constructorimpl(j3 - j2);
    }

    @PublishedApi
    public static final double ulongToDouble(long j) {
        return ((j >>> 11) * 2048) + (j & 2047);
    }

    @PublishedApi
    @InlineOnly
    private static final float ulongToFloat(long j) {
        return (float) ulongToDouble(j);
    }

    @InlineOnly
    private static final String ulongToString(long j) {
        return ulongToString(j, 10);
    }

    @InlineOnly
    private static final String uintToString(int i, int i2) {
        return ulongToString(i & BodyPartID.bodyIdMax, i2);
    }

    public static final String ulongToString(long j, int i) {
        if (j >= 0) {
            String string = Long.toString(j, C1302CharsKt.checkRadix(i));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(j3, C1302CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        sb.append(string2);
        String string3 = Long.toString(j4, C1302CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        sb.append(string3);
        return sb.toString();
    }
}
