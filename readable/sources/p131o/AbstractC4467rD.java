package p131o;

import p094kotlin.C1126UByte;

/* renamed from: o.rD */
/* loaded from: classes.dex */
public abstract class AbstractC4467rD {
    /* renamed from: AZxh */
    public static int m13357AZxh(Object obj, Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i2;
        int i3;
        int iM13611mjFkc = AbstractC4601tD.m13611mjFkc(obj);
        int i4 = iM13611mjFkc & i;
        int iM13361wA = m13361wA(obj3, i4);
        if (iM13361wA != 0) {
            int i5 = ~i;
            int i6 = iM13611mjFkc & i5;
            int i7 = -1;
            while (true) {
                i2 = iM13361wA - 1;
                int i8 = iArr[i2];
                i3 = i8 & i;
                if ((i8 & i5) != i6 || !AbstractC2833SW.m10153mjFkc(obj, objArr[i2]) || (objArr2 != null && !AbstractC2833SW.m10153mjFkc(obj2, objArr2[i2]))) {
                    if (i3 == 0) {
                        break;
                    }
                    i7 = i2;
                    iM13361wA = i3;
                } else {
                    break;
                }
            }
            if (i7 == -1) {
                m13358KLFTb(obj3, i4, i3);
            } else {
                iArr[i7] = (iArr[i7] & i5) | (i3 & i);
            }
            return i2;
        }
        return -1;
    }

    /* renamed from: KLFTb */
    public static void m13358KLFTb(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }

    /* renamed from: ZfxDd */
    public static Object m13359ZfxDd(int i) {
        if (i >= 2 && i <= 1073741824 && Integer.highestOneBit(i) == i) {
            return i <= 256 ? new byte[i] : i <= 65536 ? new short[i] : new int[i];
        }
        throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + i);
    }

    /* renamed from: mjFkc */
    public static int m13360mjFkc(int i) {
        return (i < 32 ? 4 : 2) * (i + 1);
    }

    /* renamed from: wA */
    public static int m13361wA(Object obj, int i) {
        return obj instanceof byte[] ? ((byte[]) obj)[i] & C1126UByte.MAX_VALUE : obj instanceof short[] ? (char) ((short[]) obj)[i] : ((int[]) obj)[i];
    }
}
