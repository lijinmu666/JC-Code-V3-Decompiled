package org.bouncycastle.p314pqc.p316crypto.crystals.dilithium;

import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;

/* loaded from: classes2.dex */
class Rounding {
    public static int[] decompose(int i, int i2) {
        int i3;
        int i4 = (i + 127) >> 7;
        if (i2 == 261888) {
            i3 = (((i4 * 1025) + PKIFailureInfo.badSenderNonce) >> 22) & 15;
        } else {
            if (i2 != 95232) {
                throw new RuntimeException("Wrong Gamma2!");
            }
            int i5 = ((i4 * 11275) + 8388608) >> 24;
            i3 = i5 ^ (((43 - i5) >> 31) & i5);
        }
        int i6 = i - ((i3 * 2) * i2);
        return new int[]{i6 - (((4190208 - i6) >> 31) & 8380417), i3};
    }

    public static int makeHint(int i, int i2, DilithiumEngine dilithiumEngine) {
        int i3;
        int dilithiumGamma2 = dilithiumEngine.getDilithiumGamma2();
        if (i <= dilithiumGamma2 || i > (i3 = 8380417 - dilithiumGamma2)) {
            return 0;
        }
        return (i == i3 && i2 == 0) ? 0 : 1;
    }

    public static int[] power2Round(int i) {
        int i2 = (i + 4095) >> 13;
        return new int[]{i2, i - (i2 << 13)};
    }

    /* renamed from: useHint */
    public static int m17537useHint(int i, int i2, int i3) {
        int[] iArrDecompose = decompose(i, i3);
        int i4 = iArrDecompose[0];
        int i5 = iArrDecompose[1];
        if (i2 == 0) {
            return i5;
        }
        if (i3 == 261888) {
            return (i4 > 0 ? i5 + 1 : i5 - 1) & 15;
        }
        if (i3 != 95232) {
            throw new RuntimeException("Wrong Gamma2!");
        }
        if (i4 > 0) {
            if (i5 == 43) {
                return 0;
            }
            return i5 + 1;
        }
        if (i5 == 0) {
            return 43;
        }
        return i5 - 1;
    }
}
