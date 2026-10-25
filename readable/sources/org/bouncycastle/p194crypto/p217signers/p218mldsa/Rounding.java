package org.bouncycastle.p194crypto.p217signers.p218mldsa;

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

    public static int makeHint(int i, int i2, MLDSAEngine mLDSAEngine) {
        int i3;
        int dilithiumGamma2 = mLDSAEngine.getDilithiumGamma2();
        if (i <= dilithiumGamma2 || i > (i3 = 8380417 - dilithiumGamma2)) {
            return 0;
        }
        return (i == i3 && i2 == 0) ? 0 : 1;
    }

    public static void power2RoundAll(int[] iArr, int[] iArr2) {
        for (int i = 0; i < 256; i++) {
            int i2 = iArr[i];
            int i3 = i2 + 4095;
            iArr[i] = i3 >> 13;
            iArr2[i] = i2 - (i3 & (-8192));
        }
    }

    /* renamed from: useHint */
    public static int m15880useHint(int i, int i2, int i3) {
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
