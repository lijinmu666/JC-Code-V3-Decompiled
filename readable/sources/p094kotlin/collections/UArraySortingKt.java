package p094kotlin.collections;

import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.ExperimentalUnsignedTypes;
import p094kotlin.Metadata;
import p094kotlin.UByteArray;
import p094kotlin.UIntArray;
import p094kotlin.ULongArray;
import p094kotlin.UShortArray;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u000b\u0010\f\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a-\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a-\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a-\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0081\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u001f\u0010\f\u001a-\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0081\u0080\u0004b\u0002\b\b¢\u0006\u0004\b \u0010\u0011\u001a-\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0081\u0080\u0004b\u0002\b\b¢\u0006\u0004\b!\u0010\u0016\u001a-\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0081\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\"\u0010\u001b¨\u0006#"}, m4988d2 = {"partition", BuildConfig.f24315FLAVOR, "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/ExperimentalUnsignedTypes;", "quickSort", BuildConfig.f24315FLAVOR, "quickSort-4UcCI2c", "([BII)V", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort-Aa5vz7o", "([SII)V", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "quickSort-oBK06Vg", "([III)V", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "quickSort--nroSd4", "([JII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-Aa5vz7o", "sortArray-oBK06Vg", "sortArray--nroSd4", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m18953partitionnroSd4(long[] jArr, int i, int i2) {
        long jM18780getsVKNKU = ULongArray.m18780getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compareUnsigned(ULongArray.m18780getsVKNKU(jArr, i), jM18780getsVKNKU) < 0) {
                i++;
            }
            while (Long.compareUnsigned(ULongArray.m18780getsVKNKU(jArr, i2), jM18780getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long jM18780getsVKNKU2 = ULongArray.m18780getsVKNKU(jArr, i);
                ULongArray.m18785setk8EXiF4(jArr, i, ULongArray.m18780getsVKNKU(jArr, i2));
                ULongArray.m18785setk8EXiF4(jArr, i2, jM18780getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m18954partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte bM18622getw2LRezQ = UByteArray.m18622getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int iM18622getw2LRezQ = UByteArray.m18622getw2LRezQ(bArr, i) & C1126UByte.MAX_VALUE;
                i3 = bM18622getw2LRezQ & C1126UByte.MAX_VALUE;
                if (Intrinsics.m6319compare(iM18622getw2LRezQ, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.m6319compare(UByteArray.m18622getw2LRezQ(bArr, i2) & C1126UByte.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte bM18622getw2LRezQ2 = UByteArray.m18622getw2LRezQ(bArr, i);
                UByteArray.m18627setVurrAj0(bArr, i, UByteArray.m18622getw2LRezQ(bArr, i2));
                UByteArray.m18627setVurrAj0(bArr, i2, bM18622getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m18955partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short sM18885getMh2AYeg = UShortArray.m18885getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = sM18885getMh2AYeg & 65535;
                if (Intrinsics.m6319compare(UShortArray.m18885getMh2AYeg(sArr, i) & 65535, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.m6319compare(UShortArray.m18885getMh2AYeg(sArr, i2) & 65535, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short sM18885getMh2AYeg2 = UShortArray.m18885getMh2AYeg(sArr, i);
                UShortArray.m18890set01HTLdE(sArr, i, UShortArray.m18885getMh2AYeg(sArr, i2));
                UShortArray.m18890set01HTLdE(sArr, i2, sM18885getMh2AYeg2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m18956partitionoBK06Vg(int[] iArr, int i, int i2) {
        int iM18701getpVg5ArA = UIntArray.m18701getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compareUnsigned(UIntArray.m18701getpVg5ArA(iArr, i), iM18701getpVg5ArA) < 0) {
                i++;
            }
            while (Integer.compareUnsigned(UIntArray.m18701getpVg5ArA(iArr, i2), iM18701getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int iM18701getpVg5ArA2 = UIntArray.m18701getpVg5ArA(iArr, i);
                UIntArray.m18706setVXSXFK8(iArr, i, UIntArray.m18701getpVg5ArA(iArr, i2));
                UIntArray.m18706setVXSXFK8(iArr, i2, iM18701getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m18957quickSortnroSd4(long[] jArr, int i, int i2) {
        int iM18953partitionnroSd4 = m18953partitionnroSd4(jArr, i, i2);
        int i3 = iM18953partitionnroSd4 - 1;
        if (i < i3) {
            m18957quickSortnroSd4(jArr, i, i3);
        }
        if (iM18953partitionnroSd4 < i2) {
            m18957quickSortnroSd4(jArr, iM18953partitionnroSd4, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m18958quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int iM18954partition4UcCI2c = m18954partition4UcCI2c(bArr, i, i2);
        int i3 = iM18954partition4UcCI2c - 1;
        if (i < i3) {
            m18958quickSort4UcCI2c(bArr, i, i3);
        }
        if (iM18954partition4UcCI2c < i2) {
            m18958quickSort4UcCI2c(bArr, iM18954partition4UcCI2c, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m18959quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int iM18955partitionAa5vz7o = m18955partitionAa5vz7o(sArr, i, i2);
        int i3 = iM18955partitionAa5vz7o - 1;
        if (i < i3) {
            m18959quickSortAa5vz7o(sArr, i, i3);
        }
        if (iM18955partitionAa5vz7o < i2) {
            m18959quickSortAa5vz7o(sArr, iM18955partitionAa5vz7o, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m18960quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int iM18956partitionoBK06Vg = m18956partitionoBK06Vg(iArr, i, i2);
        int i3 = iM18956partitionoBK06Vg - 1;
        if (i < i3) {
            m18960quickSortoBK06Vg(iArr, i, i3);
        }
        if (iM18956partitionoBK06Vg < i2) {
            m18960quickSortoBK06Vg(iArr, iM18956partitionoBK06Vg, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m18961sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m18957quickSortnroSd4(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m18962sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m18958quickSort4UcCI2c(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m18963sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m18959quickSortAa5vz7o(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m18964sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m18960quickSortoBK06Vg(array, i, i2 - 1);
    }
}
