package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class XSalsa20Engine extends Salsa20Engine {
    @Override // org.bouncycastle.p194crypto.p201engines.Salsa20Engine, org.bouncycastle.p194crypto.StreamCipher
    public String getAlgorithmName() {
        return "XSalsa20";
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Salsa20Engine
    public int getNonceSize() {
        return 24;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Salsa20Engine
    /* renamed from: setKey */
    public void mo15283setKey(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new IllegalArgumentException(getAlgorithmName() + " doesn't support re-init with null key");
        }
        if (bArr.length != 32) {
            throw new IllegalArgumentException(getAlgorithmName() + " requires a 256 bit key");
        }
        super.mo15283setKey(bArr, bArr2);
        AbstractC6245Pack.littleEndianToInt(bArr2, 8, this.engineState, 8, 2);
        int[] iArr = this.engineState;
        int[] iArr2 = new int[iArr.length];
        Salsa20Engine.salsaCore(20, iArr, iArr2);
        int[] iArr3 = this.engineState;
        iArr3[1] = iArr2[0] - iArr3[0];
        iArr3[2] = iArr2[5] - iArr3[5];
        iArr3[3] = iArr2[10] - iArr3[10];
        iArr3[4] = iArr2[15] - iArr3[15];
        iArr3[11] = iArr2[6] - iArr3[6];
        iArr3[12] = iArr2[7] - iArr3[7];
        iArr3[13] = iArr2[8] - iArr3[8];
        iArr3[14] = iArr2[9] - iArr3[9];
        AbstractC6245Pack.littleEndianToInt(bArr2, 16, iArr3, 6, 2);
    }
}
