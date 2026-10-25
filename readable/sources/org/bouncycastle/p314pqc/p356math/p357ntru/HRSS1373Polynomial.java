package org.bouncycastle.p314pqc.p356math.p357ntru;

import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUHRSSParameterSet;
import p094kotlin.C1126UByte;
import p132okio.C5066Utf8;

/* loaded from: classes2.dex */
public class HRSS1373Polynomial extends HRSSPolynomial {

    /* renamed from: K */
    private static final int f24141K = 86;

    /* renamed from: L */
    private static final int f24142L = 1376;

    /* renamed from: M */
    private static final int f24143M = 344;

    public HRSS1373Polynomial(NTRUHRSSParameterSet nTRUHRSSParameterSet) {
        super(nTRUHRSSParameterSet);
    }

    @Override // org.bouncycastle.p314pqc.p356math.p357ntru.HRSSPolynomial, org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial
    public void sqFromBytes(byte[] bArr) {
        int i = 0;
        while (i < this.f24145params.packDegree() / 4) {
            short[] sArr = this.f24144coeffs;
            int i2 = i * 4;
            int i3 = i * 7;
            int i4 = bArr[i3] & C1126UByte.MAX_VALUE;
            byte b = bArr[i3 + 1];
            sArr[i2] = (short) (i4 | ((((short) (b & C1126UByte.MAX_VALUE)) & 63) << 8));
            int i5 = ((b & C1126UByte.MAX_VALUE) >>> 6) | (((short) (bArr[i3 + 2] & C1126UByte.MAX_VALUE)) << 2);
            byte b2 = bArr[i3 + 3];
            sArr[i2 + 1] = (short) (i5 | (((short) (b2 & 15)) << 10));
            int i6 = ((b2 & C1126UByte.MAX_VALUE) >>> 4) | ((((short) (bArr[i3 + 4] & C1126UByte.MAX_VALUE)) & 255) << 4);
            byte b3 = bArr[i3 + 5];
            sArr[i2 + 2] = (short) (i6 | (((short) (b3 & 3)) << 12));
            sArr[i2 + 3] = (short) (((b3 & C1126UByte.MAX_VALUE) >>> 2) | (((short) (bArr[i3 + 6] & C1126UByte.MAX_VALUE)) << 6));
            i++;
        }
        if (this.f24145params.packDegree() % 4 == 2) {
            short[] sArr2 = this.f24144coeffs;
            int i7 = i * 4;
            int i8 = i * 7;
            byte b4 = bArr[i8];
            byte b5 = bArr[i8 + 1];
            sArr2[i7] = (short) (b4 | ((b5 & C5066Utf8.REPLACEMENT_BYTE) << 8));
            sArr2[i7 + 1] = (short) (((bArr[i8 + 3] & 15) << 10) | (bArr[i8 + 2] << 2) | (b5 >>> 6));
        }
        this.f24144coeffs[this.f24145params.m18201n() - 1] = 0;
    }

    @Override // org.bouncycastle.p314pqc.p356math.p357ntru.HRSSPolynomial, org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial
    public byte[] sqToBytes(int i) {
        byte[] bArr = new byte[i];
        short[] sArr = new short[4];
        int i2 = 0;
        while (i2 < this.f24145params.packDegree() / 4) {
            for (int i3 = 0; i3 < 4; i3++) {
                sArr[i3] = (short) Polynomial.m18187modQ(this.f24144coeffs[(i2 * 4) + i3] & 65535, this.f24145params.m18202q());
            }
            int i4 = i2 * 7;
            short s = sArr[0];
            bArr[i4] = (byte) (s & 255);
            short s2 = sArr[1];
            bArr[i4 + 1] = (byte) ((s >>> 8) | ((s2 & 3) << 6));
            bArr[i4 + 2] = (byte) ((s2 >>> 2) & 255);
            short s3 = sArr[2];
            bArr[i4 + 3] = (byte) ((s2 >>> 10) | ((s3 & 15) << 4));
            bArr[i4 + 4] = (byte) ((s3 >>> 4) & 255);
            short s4 = sArr[3];
            bArr[i4 + 5] = (byte) ((s3 >>> 12) | ((s4 & 63) << 2));
            bArr[i4 + 6] = (byte) (s4 >>> 6);
            i2++;
        }
        if (this.f24145params.packDegree() % 4 == 2) {
            sArr[0] = (short) Polynomial.m18187modQ(this.f24144coeffs[this.f24145params.packDegree() - 2] & 65535, this.f24145params.m18202q());
            short sM18187modQ = (short) Polynomial.m18187modQ(this.f24144coeffs[this.f24145params.packDegree() - 1] & 65535, this.f24145params.m18202q());
            sArr[1] = sM18187modQ;
            int i5 = i2 * 7;
            short s5 = sArr[0];
            bArr[i5] = (byte) (s5 & 255);
            bArr[i5 + 1] = (byte) ((s5 >>> 8) | ((sM18187modQ & 3) << 6));
            bArr[i5 + 2] = (byte) ((sM18187modQ >>> 2) & 255);
            bArr[i5 + 3] = (byte) (sM18187modQ >>> 10);
        }
        return bArr;
    }
}
