package org.bouncycastle.p194crypto.p207kems.p208mlkem;

import p094kotlin.C1126UByte;

/* renamed from: org.bouncycastle.crypto.kems.mlkem.PolyVec */
/* loaded from: classes2.dex */
class C5356PolyVec {

    /* renamed from: vec */
    final C5355Poly[] f20408vec;

    public C5356PolyVec(int i) {
        this.f20408vec = new C5355Poly[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.f20408vec[i2] = new C5355Poly();
        }
    }

    public static int checkModulus(MLKEMEngine mLKEMEngine, byte[] bArr) {
        int iM15566getK = mLKEMEngine.m15566getK();
        int iCheckModulus = -1;
        for (int i = 0; i < iM15566getK; i++) {
            iCheckModulus &= C5355Poly.checkModulus(bArr, i * 384);
        }
        return iCheckModulus;
    }

    private void condSubQ() {
        int i = 0;
        while (true) {
            C5355Poly[] c5355PolyArr = this.f20408vec;
            if (i >= c5355PolyArr.length) {
                return;
            }
            c5355PolyArr[i].condSubQ();
            i++;
        }
    }

    public static void pointwiseAccountMontgomery(C5355Poly c5355Poly, C5356PolyVec c5356PolyVec, C5356PolyVec c5356PolyVec2, MLKEMEngine mLKEMEngine) {
        C5355Poly c5355Poly2 = new C5355Poly();
        C5355Poly.baseMultMontgomery(c5355Poly, c5356PolyVec.f20408vec[0], c5356PolyVec2.f20408vec[0]);
        for (int i = 1; i < mLKEMEngine.m15566getK(); i++) {
            C5355Poly.baseMultMontgomery(c5355Poly2, c5356PolyVec.f20408vec[i], c5356PolyVec2.f20408vec[i]);
            c5355Poly.m15573add(c5355Poly2);
        }
        c5355Poly.m15576reduce();
    }

    /* renamed from: addPoly */
    public void m15579addPoly(C5356PolyVec c5356PolyVec) {
        int i = 0;
        while (true) {
            C5355Poly[] c5355PolyArr = this.f20408vec;
            if (i >= c5355PolyArr.length) {
                return;
            }
            c5355PolyArr[i].m15573add(c5356PolyVec.f20408vec[i]);
            i++;
        }
    }

    public void compressPolyVec(byte[] bArr, int i) {
        condSubQ();
        int i2 = 32;
        if (this.f20408vec.length != 4) {
            short[] sArr = new short[4];
            int i3 = i;
            for (int i4 = 0; i4 < this.f20408vec.length; i4++) {
                for (int i5 = 0; i5 < 64; i5++) {
                    for (int i6 = 0; i6 < 4; i6++) {
                        sArr[i6] = (short) (((((this.f20408vec[i4].getCoeffIndex((i5 * 4) + i6) << 10) + 1665) * 1290167) >> 32) & 1023);
                    }
                    short s = sArr[0];
                    bArr[i3] = (byte) s;
                    short s2 = sArr[1];
                    bArr[i3 + 1] = (byte) ((s >> 8) | (s2 << 2));
                    short s3 = sArr[2];
                    bArr[i3 + 2] = (byte) ((s2 >> 6) | (s3 << 4));
                    short s4 = sArr[3];
                    bArr[i3 + 3] = (byte) ((s3 >> 4) | (s4 << 6));
                    bArr[i3 + 4] = (byte) (s4 >> 2);
                    i3 += 5;
                }
            }
            return;
        }
        short[] sArr2 = new short[8];
        int i7 = i;
        int i8 = 0;
        while (i8 < this.f20408vec.length) {
            int i9 = 0;
            while (i9 < i2) {
                for (int i10 = 0; i10 < 8; i10++) {
                    sArr2[i10] = (short) (((((this.f20408vec[i8].getCoeffIndex((i9 * 8) + i10) << 11) + 1664) * 645084) >> 31) & 2047);
                }
                short s5 = sArr2[0];
                bArr[i7] = (byte) s5;
                short s6 = sArr2[1];
                bArr[i7 + 1] = (byte) ((s5 >> 8) | (s6 << 3));
                short s7 = sArr2[2];
                bArr[i7 + 2] = (byte) ((s6 >> 5) | (s7 << 6));
                bArr[i7 + 3] = (byte) (s7 >> 2);
                short s8 = sArr2[3];
                bArr[i7 + 4] = (byte) ((s7 >> 10) | (s8 << 1));
                int i11 = s8 >> 7;
                short s9 = sArr2[4];
                bArr[i7 + 5] = (byte) (i11 | (s9 << 4));
                short s10 = sArr2[5];
                bArr[i7 + 6] = (byte) ((s9 >> 4) | (s10 << 7));
                bArr[i7 + 7] = (byte) (s10 >> 1);
                short s11 = sArr2[6];
                bArr[i7 + 8] = (byte) ((s10 >> 9) | (s11 << 2));
                short s12 = sArr2[7];
                bArr[i7 + 9] = (byte) ((s11 >> 6) | (s12 << 5));
                bArr[i7 + 10] = (byte) (s12 >> 3);
                i7 += 11;
                i9++;
                i2 = 32;
            }
            i8++;
            i2 = 32;
        }
    }

    public void decompressPolyVec(byte[] bArr, int i) {
        short s = 7;
        short s2 = 5;
        int i2 = 3;
        int i3 = 6;
        short s3 = 4;
        if (this.f20408vec.length != 4) {
            int i4 = i;
            for (int i5 = 0; i5 < this.f20408vec.length; i5++) {
                for (int i6 = 0; i6 < 64; i6++) {
                    int i7 = bArr[i4] & C1126UByte.MAX_VALUE;
                    byte b = bArr[i4 + 1];
                    short s4 = (short) (i7 | ((short) ((b & C1126UByte.MAX_VALUE) << 8)));
                    int i8 = (b & C1126UByte.MAX_VALUE) >> 2;
                    byte b2 = bArr[i4 + 2];
                    short s5 = (short) (i8 | ((short) ((b2 & C1126UByte.MAX_VALUE) << 6)));
                    int i9 = (b2 & C1126UByte.MAX_VALUE) >> 4;
                    byte b3 = bArr[i4 + 3];
                    short[] sArr = {s4, s5, (short) (i9 | ((short) ((b3 & C1126UByte.MAX_VALUE) << 4))), (short) (((b3 & C1126UByte.MAX_VALUE) >> 6) | ((short) ((bArr[i4 + 4] & C1126UByte.MAX_VALUE) << 2)))};
                    i4 += 5;
                    for (int i10 = 0; i10 < 4; i10++) {
                        this.f20408vec[i5].setCoeffIndex((i6 * 4) + i10, (short) ((((sArr[i10] & 1023) * 3329) + 512) >> 10));
                    }
                }
            }
            return;
        }
        int i11 = i;
        int i12 = 0;
        while (i12 < this.f20408vec.length) {
            int i13 = 0;
            while (i13 < 32) {
                int i14 = bArr[i11] & C1126UByte.MAX_VALUE;
                byte b4 = bArr[i11 + 1];
                short s6 = (short) (i14 | (((short) (b4 & C1126UByte.MAX_VALUE)) << 8));
                int i15 = (b4 & C1126UByte.MAX_VALUE) >> i2;
                byte b5 = bArr[i11 + 2];
                short s7 = (short) ((((short) (b5 & C1126UByte.MAX_VALUE)) << s2) | i15);
                int i16 = ((b5 & C1126UByte.MAX_VALUE) >> i3) | (((short) (bArr[i11 + 3] & C1126UByte.MAX_VALUE)) << 2);
                byte b6 = bArr[i11 + 4];
                short s8 = (short) (((short) ((b6 & C1126UByte.MAX_VALUE) << 10)) | i16);
                int i17 = (b6 & C1126UByte.MAX_VALUE) >> 1;
                byte b7 = bArr[i11 + 5];
                short s9 = (short) ((((short) (b7 & C1126UByte.MAX_VALUE)) << s) | i17);
                int i18 = (b7 & C1126UByte.MAX_VALUE) >> s3;
                byte b8 = bArr[i11 + 6];
                short s10 = (short) ((((short) (b8 & C1126UByte.MAX_VALUE)) << s3) | i18);
                int i19 = ((b8 & C1126UByte.MAX_VALUE) >> s) | (((short) (bArr[i11 + 7] & C1126UByte.MAX_VALUE)) << 1);
                byte b9 = bArr[i11 + 8];
                short s11 = (short) (((short) ((b9 & C1126UByte.MAX_VALUE) << 9)) | i19);
                int i20 = (b9 & C1126UByte.MAX_VALUE) >> 2;
                byte b10 = bArr[i11 + 9];
                s = 7;
                short[] sArr2 = {s6, s7, s8, s9, s10, s11, (short) ((((short) (b10 & C1126UByte.MAX_VALUE)) << 6) | i20), (short) (((b10 & C1126UByte.MAX_VALUE) >> 5) | (((short) (bArr[i11 + 10] & C1126UByte.MAX_VALUE)) << 3))};
                i11 += 11;
                for (int i21 = 0; i21 < 8; i21++) {
                    this.f20408vec[i12].setCoeffIndex((i13 * 8) + i21, (short) ((((sArr2[i21] & 2047) * 3329) + 1024) >> 11));
                }
                i13++;
                s2 = 5;
                i2 = 3;
                i3 = 6;
                s3 = 4;
            }
            i12++;
            s2 = 5;
            i2 = 3;
            i3 = 6;
            s3 = 4;
        }
    }

    public void fromBytes(byte[] bArr, int i) {
        int i2 = 0;
        while (true) {
            C5355Poly[] c5355PolyArr = this.f20408vec;
            if (i2 >= c5355PolyArr.length) {
                return;
            }
            c5355PolyArr[i2].fromBytes(bArr, (i2 * 384) + i);
            i2++;
        }
    }

    public C5355Poly getVectorIndex(int i) {
        return this.f20408vec[i];
    }

    public void polyVecInverseNttToMont() {
        int i = 0;
        while (true) {
            C5355Poly[] c5355PolyArr = this.f20408vec;
            if (i >= c5355PolyArr.length) {
                return;
            }
            c5355PolyArr[i].polyInverseNttToMont();
            i++;
        }
    }

    public void polyVecNtt() {
        int i = 0;
        while (true) {
            C5355Poly[] c5355PolyArr = this.f20408vec;
            if (i >= c5355PolyArr.length) {
                return;
            }
            c5355PolyArr[i].m15575polyNtt();
            i++;
        }
    }

    public void reducePoly() {
        int i = 0;
        while (true) {
            C5355Poly[] c5355PolyArr = this.f20408vec;
            if (i >= c5355PolyArr.length) {
                return;
            }
            c5355PolyArr[i].m15576reduce();
            i++;
        }
    }

    /* renamed from: toBytes */
    public void m15580toBytes(byte[] bArr, int i) {
        int i2 = 0;
        while (true) {
            C5355Poly[] c5355PolyArr = this.f20408vec;
            if (i2 >= c5355PolyArr.length) {
                return;
            }
            c5355PolyArr[i2].m15577toBytes(bArr, (i2 * 384) + i);
            i2++;
        }
    }
}
