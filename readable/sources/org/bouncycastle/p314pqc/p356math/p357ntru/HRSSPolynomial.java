package org.bouncycastle.p314pqc.p356math.p357ntru;

import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUHRSSParameterSet;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class HRSSPolynomial extends Polynomial {
    public HRSSPolynomial(NTRUHRSSParameterSet nTRUHRSSParameterSet) {
        super(nTRUHRSSParameterSet);
    }

    @Override // org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial
    /* renamed from: lift */
    public void mo18184lift(Polynomial polynomial) {
        int length = this.f24144coeffs.length;
        Polynomial polynomialCreatePolynomial = this.f24145params.createPolynomial();
        short s = (short) (3 - (length % 3));
        short[] sArr = polynomialCreatePolynomial.f24144coeffs;
        short[] sArr2 = polynomial.f24144coeffs;
        int i = 0;
        int i2 = 2 - s;
        int i3 = sArr2[0] * i2;
        short s2 = sArr2[1];
        short s3 = sArr2[2];
        sArr[0] = (short) (i3 + (s3 * s));
        sArr[1] = (short) (s2 * i2);
        sArr[2] = (short) (s3 * i2);
        short s4 = 0;
        for (int i4 = 3; i4 < length; i4++) {
            short[] sArr3 = polynomialCreatePolynomial.f24144coeffs;
            short s5 = sArr3[0];
            short[] sArr4 = polynomial.f24144coeffs;
            sArr3[0] = (short) (s5 + (sArr4[i4] * ((s * 2) + s4)));
            int i5 = s4 + s;
            sArr3[1] = (short) (sArr3[1] + (sArr4[i4] * i5));
            sArr3[2] = (short) (sArr3[2] + (sArr4[i4] * s4));
            s4 = (short) (i5 % 3);
        }
        short[] sArr5 = polynomialCreatePolynomial.f24144coeffs;
        short s6 = sArr5[1];
        short[] sArr6 = polynomial.f24144coeffs;
        short s7 = sArr6[0];
        int i6 = s + s4;
        sArr5[1] = (short) (s6 + (s7 * i6));
        short s8 = (short) (sArr5[2] + (s7 * s4));
        sArr5[2] = s8;
        sArr5[2] = (short) (s8 + (sArr6[1] * i6));
        for (int i7 = 3; i7 < length; i7++) {
            short[] sArr7 = polynomialCreatePolynomial.f24144coeffs;
            short s9 = sArr7[i7 - 3];
            short[] sArr8 = polynomial.f24144coeffs;
            sArr7[i7] = (short) (s9 + ((sArr8[i7] + sArr8[i7 - 1] + sArr8[i7 - 2]) * 2));
        }
        polynomialCreatePolynomial.mod3PhiN();
        polynomialCreatePolynomial.m18198z3ToZq();
        this.f24144coeffs[0] = (short) (-polynomialCreatePolynomial.f24144coeffs[0]);
        while (i < length - 1) {
            short[] sArr9 = this.f24144coeffs;
            int i8 = i + 1;
            short[] sArr10 = polynomialCreatePolynomial.f24144coeffs;
            sArr9[i8] = (short) (sArr10[i] - sArr10[i8]);
            i = i8;
        }
    }

    @Override // org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial
    public void sqFromBytes(byte[] bArr) {
        int i = 0;
        while (i < this.f24145params.packDegree() / 8) {
            short[] sArr = this.f24144coeffs;
            int i2 = i * 8;
            int i3 = i * 13;
            int i4 = bArr[i3] & C1126UByte.MAX_VALUE;
            byte b = bArr[i3 + 1];
            sArr[i2] = (short) (i4 | ((((short) (b & C1126UByte.MAX_VALUE)) & 31) << 8));
            int i5 = ((b & C1126UByte.MAX_VALUE) >>> 5) | (((short) (bArr[i3 + 2] & C1126UByte.MAX_VALUE)) << 3);
            byte b2 = bArr[i3 + 3];
            sArr[i2 + 1] = (short) (i5 | ((((short) (b2 & C1126UByte.MAX_VALUE)) & 3) << 11));
            int i6 = (b2 & C1126UByte.MAX_VALUE) >>> 2;
            byte b3 = bArr[i3 + 4];
            sArr[i2 + 2] = (short) (i6 | ((((short) (b3 & C1126UByte.MAX_VALUE)) & 127) << 6));
            int i7 = ((b3 & C1126UByte.MAX_VALUE) >>> 7) | (((short) (bArr[i3 + 5] & C1126UByte.MAX_VALUE)) << 1);
            byte b4 = bArr[i3 + 6];
            sArr[i2 + 3] = (short) (i7 | ((((short) (b4 & C1126UByte.MAX_VALUE)) & 15) << 9));
            int i8 = (((short) (bArr[i3 + 7] & C1126UByte.MAX_VALUE)) << 4) | ((b4 & C1126UByte.MAX_VALUE) >>> 4);
            byte b5 = bArr[i3 + 8];
            sArr[i2 + 4] = (short) (i8 | ((((short) (b5 & C1126UByte.MAX_VALUE)) & 1) << 12));
            int i9 = (b5 & C1126UByte.MAX_VALUE) >>> 1;
            byte b6 = bArr[i3 + 9];
            sArr[i2 + 5] = (short) (i9 | ((((short) (b6 & C1126UByte.MAX_VALUE)) & 63) << 7));
            int i10 = (((short) (bArr[i3 + 10] & C1126UByte.MAX_VALUE)) << 2) | ((b6 & C1126UByte.MAX_VALUE) >>> 6);
            byte b7 = bArr[i3 + 11];
            sArr[i2 + 6] = (short) (i10 | ((((short) (b7 & C1126UByte.MAX_VALUE)) & 7) << 10));
            sArr[i2 + 7] = (short) (((b7 & C1126UByte.MAX_VALUE) >>> 3) | (((short) (bArr[i3 + 12] & C1126UByte.MAX_VALUE)) << 5));
            i++;
        }
        int iPackDegree = this.f24145params.packDegree() & 7;
        if (iPackDegree == 2) {
            short[] sArr2 = this.f24144coeffs;
            int i11 = i * 8;
            int i12 = i * 13;
            int i13 = bArr[i12] & C1126UByte.MAX_VALUE;
            byte b8 = bArr[i12 + 1];
            sArr2[i11] = (short) (i13 | ((((short) (b8 & C1126UByte.MAX_VALUE)) & 31) << 8));
            sArr2[i11 + 1] = (short) (((((short) (bArr[i12 + 3] & C1126UByte.MAX_VALUE)) & 3) << 11) | ((b8 & C1126UByte.MAX_VALUE) >>> 5) | (((short) (bArr[i12 + 2] & C1126UByte.MAX_VALUE)) << 3));
        } else if (iPackDegree == 4) {
            short[] sArr3 = this.f24144coeffs;
            int i14 = i * 8;
            int i15 = i * 13;
            int i16 = bArr[i15] & C1126UByte.MAX_VALUE;
            byte b9 = bArr[i15 + 1];
            sArr3[i14] = (short) (i16 | ((((short) (b9 & C1126UByte.MAX_VALUE)) & 31) << 8));
            int i17 = ((b9 & C1126UByte.MAX_VALUE) >>> 5) | (((short) (bArr[i15 + 2] & C1126UByte.MAX_VALUE)) << 3);
            byte b10 = bArr[i15 + 3];
            sArr3[i14 + 1] = (short) (i17 | ((((short) (b10 & C1126UByte.MAX_VALUE)) & 3) << 11));
            int i18 = (b10 & C1126UByte.MAX_VALUE) >>> 2;
            byte b11 = bArr[i15 + 4];
            sArr3[i14 + 2] = (short) (i18 | ((((short) (b11 & C1126UByte.MAX_VALUE)) & 127) << 6));
            sArr3[i14 + 3] = (short) (((((short) (bArr[i15 + 6] & C1126UByte.MAX_VALUE)) & 15) << 9) | ((b11 & C1126UByte.MAX_VALUE) >>> 7) | (((short) (bArr[i15 + 5] & C1126UByte.MAX_VALUE)) << 1));
        }
        this.f24144coeffs[this.f24145params.m18201n() - 1] = 0;
    }

    @Override // org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial
    public byte[] sqToBytes(int i) {
        byte[] bArr = new byte[i];
        short[] sArr = new short[8];
        int i2 = 0;
        while (true) {
            short s = 65535;
            if (i2 >= this.f24145params.packDegree() / 8) {
                break;
            }
            int i3 = 0;
            while (i3 < 8) {
                sArr[i3] = (short) Polynomial.m18187modQ(this.f24144coeffs[(i2 * 8) + i3] & s, this.f24145params.m18202q());
                i3++;
                s = 65535;
            }
            int i4 = i2 * 13;
            short s2 = sArr[0];
            bArr[i4] = (byte) (s2 & 255);
            short s3 = sArr[1];
            bArr[i4 + 1] = (byte) ((s2 >>> 8) | ((s3 & 7) << 5));
            bArr[i4 + 2] = (byte) ((s3 >>> 3) & 255);
            int i5 = s3 >>> 11;
            short s4 = sArr[2];
            bArr[i4 + 3] = (byte) (((s4 & 63) << 2) | i5);
            short s5 = sArr[3];
            bArr[i4 + 4] = (byte) ((s4 >>> 6) | ((s5 & 1) << 7));
            bArr[i4 + 5] = (byte) ((s5 >>> 1) & 255);
            int i6 = s5 >>> 9;
            short s6 = sArr[4];
            bArr[i4 + 6] = (byte) (((s6 & 15) << 4) | i6);
            bArr[i4 + 7] = (byte) ((s6 >>> 4) & 255);
            short s7 = sArr[5];
            bArr[i4 + 8] = (byte) ((s6 >>> 12) | ((s7 & 127) << 1));
            int i7 = s7 >>> 7;
            short s8 = sArr[6];
            bArr[i4 + 9] = (byte) (((s8 & 3) << 6) | i7);
            bArr[i4 + 10] = (byte) ((s8 >>> 2) & 255);
            short s9 = sArr[7];
            bArr[i4 + 11] = (byte) ((s8 >>> 10) | ((s9 & 31) << 3));
            bArr[i4 + 12] = (byte) (s9 >>> 5);
            i2++;
        }
        int i8 = 0;
        while (true) {
            int i9 = i2 * 8;
            if (i8 >= this.f24145params.packDegree() - i9) {
                break;
            }
            sArr[i8] = (short) Polynomial.m18187modQ(this.f24144coeffs[i9 + i8] & 65535, this.f24145params.m18202q());
            i8++;
        }
        while (i8 < 8) {
            sArr[i8] = 0;
            i8++;
        }
        int iPackDegree = this.f24145params.packDegree() - ((this.f24145params.packDegree() / 8) * 8);
        if (iPackDegree == 2) {
            int i10 = i2 * 13;
            short s10 = sArr[0];
            bArr[i10] = (byte) (s10 & 255);
            short s11 = sArr[1];
            bArr[i10 + 1] = (byte) ((s10 >>> 8) | ((s11 & 7) << 5));
            bArr[i10 + 2] = (byte) ((s11 >>> 3) & 255);
            bArr[i10 + 3] = (byte) ((s11 >>> 11) | ((sArr[2] & 63) << 2));
        } else if (iPackDegree == 4) {
            int i11 = i2 * 13;
            short s12 = sArr[0];
            bArr[i11] = (byte) (s12 & 255);
            short s13 = sArr[1];
            bArr[i11 + 1] = (byte) ((s12 >>> 8) | ((s13 & 7) << 5));
            bArr[i11 + 2] = (byte) ((s13 >>> 3) & 255);
            int i12 = s13 >>> 11;
            short s14 = sArr[2];
            bArr[i11 + 3] = (byte) (i12 | ((s14 & 63) << 2));
            int i13 = s14 >>> 6;
            short s15 = sArr[3];
            bArr[i11 + 4] = (byte) (i13 | ((s15 & 1) << 7));
            bArr[i11 + 5] = (byte) ((s15 >>> 1) & 255);
            bArr[i11 + 6] = (byte) ((s15 >>> 9) | ((sArr[4] & 15) << 4));
            int i102 = i2 * 13;
            short s102 = sArr[0];
            bArr[i102] = (byte) (s102 & 255);
            short s112 = sArr[1];
            bArr[i102 + 1] = (byte) ((s102 >>> 8) | ((s112 & 7) << 5));
            bArr[i102 + 2] = (byte) ((s112 >>> 3) & 255);
            bArr[i102 + 3] = (byte) ((s112 >>> 11) | ((sArr[2] & 63) << 2));
        }
        return bArr;
    }
}
