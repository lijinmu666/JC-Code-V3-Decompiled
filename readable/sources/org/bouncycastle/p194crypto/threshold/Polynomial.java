package org.bouncycastle.p194crypto.threshold;

import org.bouncycastle.p194crypto.threshold.ShamirSecretSplitter;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
abstract class Polynomial {
    public static Polynomial newInstance(ShamirSecretSplitter.Algorithm algorithm, ShamirSecretSplitter.EnumC5398Mode enumC5398Mode) {
        return enumC5398Mode == ShamirSecretSplitter.EnumC5398Mode.Native ? new PolynomialNative(algorithm) : new PolynomialTable(algorithm);
    }

    /* renamed from: gfDiv */
    public abstract byte mo15902gfDiv(int i, int i2);

    /* renamed from: gfMul */
    public abstract byte mo15903gfMul(int i, int i2);

    /* renamed from: gfPow */
    public byte m15904gfPow(int i, byte b) {
        byte bMo15903gfMul = 1;
        for (int i2 = 0; i2 < 8; i2++) {
            if (((1 << i2) & b) != 0) {
                bMo15903gfMul = mo15903gfMul(bMo15903gfMul & C1126UByte.MAX_VALUE, i & 255);
            }
            int i3 = i & 255;
            i = mo15903gfMul(i3, i3);
        }
        return bMo15903gfMul;
    }

    public byte[] gfVecMul(byte[] bArr, byte[][] bArr2) {
        byte[] bArr3 = new byte[bArr2[0].length];
        for (int i = 0; i < bArr2[0].length; i++) {
            int iMo15903gfMul = 0;
            for (int i2 = 0; i2 < bArr.length; i2++) {
                iMo15903gfMul ^= mo15903gfMul(bArr[i2] & C1126UByte.MAX_VALUE, bArr2[i2][i] & C1126UByte.MAX_VALUE);
            }
            bArr3[i] = (byte) iMo15903gfMul;
        }
        return bArr3;
    }
}
