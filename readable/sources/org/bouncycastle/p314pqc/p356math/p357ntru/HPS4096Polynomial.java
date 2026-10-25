package org.bouncycastle.p314pqc.p356math.p357ntru;

import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUHPSParameterSet;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class HPS4096Polynomial extends HPSPolynomial {
    public HPS4096Polynomial(NTRUHPSParameterSet nTRUHPSParameterSet) {
        super(nTRUHPSParameterSet);
    }

    @Override // org.bouncycastle.p314pqc.p356math.p357ntru.HPSPolynomial, org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial
    public void sqFromBytes(byte[] bArr) {
        for (int i = 0; i < this.f24145params.packDegree() / 2; i++) {
            short[] sArr = this.f24144coeffs;
            int i2 = i * 2;
            int i3 = i * 3;
            int i4 = bArr[i3] & C1126UByte.MAX_VALUE;
            byte b = bArr[i3 + 1];
            sArr[i2] = (short) (i4 | ((((short) (b & C1126UByte.MAX_VALUE)) & 15) << 8));
            sArr[i2 + 1] = (short) (((((short) (bArr[i3 + 2] & C1126UByte.MAX_VALUE)) & 255) << 4) | ((b & C1126UByte.MAX_VALUE) >>> 4));
        }
        this.f24144coeffs[this.f24145params.m18201n() - 1] = 0;
    }

    @Override // org.bouncycastle.p314pqc.p356math.p357ntru.HPSPolynomial, org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial
    public byte[] sqToBytes(int i) {
        byte[] bArr = new byte[i];
        int iM18202q = this.f24145params.m18202q();
        for (int i2 = 0; i2 < this.f24145params.packDegree() / 2; i2++) {
            int i3 = i2 * 3;
            int i4 = i2 * 2;
            bArr[i3] = (byte) (Polynomial.m18187modQ(this.f24144coeffs[i4] & 65535, iM18202q) & 255);
            int iM18187modQ = Polynomial.m18187modQ(this.f24144coeffs[i4] & 65535, iM18202q) >>> 8;
            int i5 = i4 + 1;
            bArr[i3 + 1] = (byte) (iM18187modQ | ((Polynomial.m18187modQ(this.f24144coeffs[i5] & 65535, iM18202q) & 15) << 4));
            bArr[i3 + 2] = (byte) (Polynomial.m18187modQ(this.f24144coeffs[i5] & 65535, iM18202q) >>> 4);
        }
        return bArr;
    }
}
