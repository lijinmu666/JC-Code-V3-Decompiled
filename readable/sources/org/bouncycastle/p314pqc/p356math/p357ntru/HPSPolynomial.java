package org.bouncycastle.p314pqc.p356math.p357ntru;

import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUHPSParameterSet;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class HPSPolynomial extends Polynomial {
    public HPSPolynomial(NTRUHPSParameterSet nTRUHPSParameterSet) {
        super(nTRUHPSParameterSet);
    }

    @Override // org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial
    /* renamed from: lift */
    public void mo18184lift(Polynomial polynomial) {
        short[] sArr = this.f24144coeffs;
        System.arraycopy(polynomial.f24144coeffs, 0, sArr, 0, sArr.length);
        m18198z3ToZq();
    }

    @Override // org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial
    public void sqFromBytes(byte[] bArr) {
        int length = this.f24144coeffs.length;
        int i = 0;
        while (i < this.f24145params.packDegree() / 8) {
            short[] sArr = this.f24144coeffs;
            int i2 = i * 8;
            int i3 = i * 11;
            int i4 = bArr[i3] & C1126UByte.MAX_VALUE;
            byte b = bArr[i3 + 1];
            sArr[i2] = (short) (i4 | ((((short) (b & C1126UByte.MAX_VALUE)) & 7) << 8));
            int i5 = (b & C1126UByte.MAX_VALUE) >>> 3;
            byte b2 = bArr[i3 + 2];
            sArr[i2 + 1] = (short) (i5 | ((((short) (b2 & C1126UByte.MAX_VALUE)) & 63) << 5));
            int i6 = ((b2 & C1126UByte.MAX_VALUE) >>> 6) | ((((short) (bArr[i3 + 3] & C1126UByte.MAX_VALUE)) & 255) << 2);
            byte b3 = bArr[i3 + 4];
            sArr[i2 + 2] = (short) (i6 | ((((short) (b3 & C1126UByte.MAX_VALUE)) & 1) << 10));
            int i7 = (b3 & C1126UByte.MAX_VALUE) >>> 1;
            byte b4 = bArr[i3 + 5];
            sArr[i2 + 3] = (short) (i7 | ((((short) (b4 & C1126UByte.MAX_VALUE)) & 15) << 7));
            int i8 = (b4 & C1126UByte.MAX_VALUE) >>> 4;
            byte b5 = bArr[i3 + 6];
            sArr[i2 + 4] = (short) (((((short) (b5 & C1126UByte.MAX_VALUE)) & 127) << 4) | i8);
            int i9 = ((b5 & C1126UByte.MAX_VALUE) >>> 7) | ((((short) (bArr[i3 + 7] & C1126UByte.MAX_VALUE)) & 255) << 1);
            byte b6 = bArr[i3 + 8];
            sArr[i2 + 5] = (short) (i9 | ((((short) (b6 & C1126UByte.MAX_VALUE)) & 3) << 9));
            int i10 = (b6 & C1126UByte.MAX_VALUE) >>> 2;
            byte b7 = bArr[i3 + 9];
            sArr[i2 + 6] = (short) (i10 | ((((short) (b7 & C1126UByte.MAX_VALUE)) & 31) << 6));
            sArr[i2 + 7] = (short) (((b7 & C1126UByte.MAX_VALUE) >>> 5) | ((((short) (bArr[i3 + 10] & C1126UByte.MAX_VALUE)) & 255) << 3));
            i++;
        }
        int iPackDegree = this.f24145params.packDegree() & 7;
        if (iPackDegree == 2) {
            short[] sArr2 = this.f24144coeffs;
            int i11 = i * 8;
            int i12 = i * 11;
            int i13 = bArr[i12] & C1126UByte.MAX_VALUE;
            byte b8 = bArr[i12 + 1];
            sArr2[i11] = (short) (i13 | ((((short) (b8 & C1126UByte.MAX_VALUE)) & 7) << 8));
            sArr2[i11 + 1] = (short) (((((short) (bArr[i12 + 2] & C1126UByte.MAX_VALUE)) & 63) << 5) | ((b8 & C1126UByte.MAX_VALUE) >>> 3));
        } else if (iPackDegree == 4) {
            short[] sArr3 = this.f24144coeffs;
            int i14 = i * 8;
            int i15 = i * 11;
            int i16 = bArr[i15] & C1126UByte.MAX_VALUE;
            byte b9 = bArr[i15 + 1];
            sArr3[i14] = (short) (i16 | ((((short) (b9 & C1126UByte.MAX_VALUE)) & 7) << 8));
            int i17 = (b9 & C1126UByte.MAX_VALUE) >>> 3;
            byte b10 = bArr[i15 + 2];
            sArr3[i14 + 1] = (short) (i17 | ((((short) (b10 & C1126UByte.MAX_VALUE)) & 63) << 5));
            int i18 = ((((short) (bArr[i15 + 3] & C1126UByte.MAX_VALUE)) & 255) << 2) | ((b10 & C1126UByte.MAX_VALUE) >>> 6);
            byte b11 = bArr[i15 + 4];
            sArr3[i14 + 2] = (short) (i18 | ((((short) (b11 & C1126UByte.MAX_VALUE)) & 1) << 10));
            sArr3[i14 + 3] = (short) (((((short) (bArr[i15 + 5] & C1126UByte.MAX_VALUE)) & 15) << 7) | ((b11 & C1126UByte.MAX_VALUE) >>> 1));
        }
        this.f24144coeffs[length - 1] = 0;
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
            int i4 = i2 * 11;
            short s2 = sArr[0];
            bArr[i4] = (byte) (s2 & 255);
            short s3 = sArr[1];
            bArr[i4 + 1] = (byte) ((s2 >>> 8) | ((s3 & 31) << 3));
            int i5 = s3 >>> 5;
            short s4 = sArr[2];
            bArr[i4 + 2] = (byte) (i5 | ((s4 & 3) << 6));
            bArr[i4 + 3] = (byte) ((s4 >>> 2) & 255);
            int i6 = s4 >>> 10;
            short s5 = sArr[3];
            bArr[i4 + 4] = (byte) (((s5 & 127) << 1) | i6);
            short s6 = sArr[4];
            bArr[i4 + 5] = (byte) ((s5 >>> 7) | ((s6 & 15) << 4));
            short s7 = sArr[5];
            bArr[i4 + 6] = (byte) ((s6 >>> 4) | ((s7 & 1) << 7));
            bArr[i4 + 7] = (byte) ((s7 >>> 1) & 255);
            int i7 = s7 >>> 9;
            short s8 = sArr[6];
            bArr[i4 + 8] = (byte) (i7 | ((s8 & 63) << 2));
            short s9 = sArr[7];
            bArr[i4 + 9] = (byte) ((s8 >>> 6) | ((s9 & 7) << 5));
            bArr[i4 + 10] = (byte) (s9 >>> 3);
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
        int iPackDegree = this.f24145params.packDegree() & 7;
        if (iPackDegree == 2) {
            int i10 = i2 * 11;
            short s10 = sArr[0];
            bArr[i10] = (byte) (s10 & 255);
            short s11 = sArr[1];
            bArr[i10 + 1] = (byte) ((s10 >>> 8) | ((s11 & 31) << 3));
            bArr[i10 + 2] = (byte) ((s11 >>> 5) | ((sArr[2] & 3) << 6));
        } else if (iPackDegree == 4) {
            int i11 = i2 * 11;
            short s12 = sArr[0];
            bArr[i11] = (byte) (s12 & 255);
            short s13 = sArr[1];
            bArr[i11 + 1] = (byte) ((s12 >>> 8) | ((s13 & 31) << 3));
            short s14 = sArr[2];
            bArr[i11 + 2] = (byte) ((s13 >>> 5) | ((s14 & 3) << 6));
            bArr[i11 + 3] = (byte) ((s14 >>> 2) & 255);
            int i12 = s14 >>> 10;
            short s15 = sArr[3];
            bArr[i11 + 4] = (byte) (i12 | ((s15 & 127) << 1));
            bArr[i11 + 5] = (byte) ((s15 >>> 7) | ((sArr[4] & 15) << 4));
        }
        return bArr;
    }
}
