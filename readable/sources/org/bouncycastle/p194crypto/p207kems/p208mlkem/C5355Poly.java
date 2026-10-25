package org.bouncycastle.p194crypto.p207kems.p208mlkem;

import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import p094kotlin.C1126UByte;

/* renamed from: org.bouncycastle.crypto.kems.mlkem.Poly */
/* loaded from: classes2.dex */
class C5355Poly {

    /* renamed from: coeffs */
    private final short[] f20407coeffs = new short[256];

    public static void baseMultMontgomery(C5355Poly c5355Poly, C5355Poly c5355Poly2, C5355Poly c5355Poly3) {
        for (int i = 0; i < 64; i++) {
            short[] sArr = c5355Poly.f20407coeffs;
            int i2 = i * 4;
            short coeffIndex = c5355Poly2.getCoeffIndex(i2);
            int i3 = i2 + 1;
            short coeffIndex2 = c5355Poly2.getCoeffIndex(i3);
            short coeffIndex3 = c5355Poly3.getCoeffIndex(i2);
            short coeffIndex4 = c5355Poly3.getCoeffIndex(i3);
            short[] sArr2 = C5354Ntt.f20406ZETAS;
            int i4 = i + 64;
            C5354Ntt.baseMult(sArr, i2, coeffIndex, coeffIndex2, coeffIndex3, coeffIndex4, sArr2[i4]);
            int i5 = i2 + 2;
            int i6 = i2 + 3;
            C5354Ntt.baseMult(c5355Poly.f20407coeffs, i5, c5355Poly2.getCoeffIndex(i5), c5355Poly2.getCoeffIndex(i6), c5355Poly3.getCoeffIndex(i5), c5355Poly3.getCoeffIndex(i6), (short) (sArr2[i4] * (-1)));
        }
    }

    public static int checkModulus(byte[] bArr, int i) {
        int iCheckModulus = -1;
        for (int i2 = 0; i2 < 128; i2++) {
            int i3 = (i2 * 3) + i;
            int i4 = bArr[i3] & C1126UByte.MAX_VALUE;
            int i5 = bArr[i3 + 1] & C1126UByte.MAX_VALUE;
            iCheckModulus = iCheckModulus & C5357Reduce.checkModulus((short) ((i4 | (i5 << 8)) & 4095)) & C5357Reduce.checkModulus((short) ((((bArr[i3 + 2] & C1126UByte.MAX_VALUE) << 4) | (i5 >> 4)) & 4095));
        }
        return iCheckModulus;
    }

    /* renamed from: prf */
    private static void m15572prf(InterfaceC5284Xof interfaceC5284Xof, byte[] bArr, int i, byte b, byte[] bArr2) {
        interfaceC5284Xof.mo14970update(bArr, i, 32);
        interfaceC5284Xof.mo14969update(b);
        interfaceC5284Xof.mo14998doFinal(bArr2, 0, bArr2.length);
    }

    /* renamed from: add */
    public void m15573add(C5355Poly c5355Poly) {
        for (int i = 0; i < 256; i++) {
            short[] sArr = this.f20407coeffs;
            sArr[i] = (short) (sArr[i] + c5355Poly.f20407coeffs[i]);
        }
    }

    public byte[] compressPoly128() {
        byte[] bArr = new byte[8];
        byte[] bArr2 = new byte[128];
        condSubQ();
        int i = 0;
        for (int i2 = 0; i2 < 32; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                bArr[i3] = (byte) (((((getCoeffIndex((i2 * 8) + i3) << 4) + 1665) * 80635) >> 28) & 15);
            }
            bArr2[i] = (byte) (bArr[0] | (bArr[1] << 4));
            bArr2[i + 1] = (byte) (bArr[2] | (bArr[3] << 4));
            bArr2[i + 2] = (byte) (bArr[4] | (bArr[5] << 4));
            bArr2[i + 3] = (byte) (bArr[6] | (bArr[7] << 4));
            i += 4;
        }
        return bArr2;
    }

    public byte[] compressPoly160() {
        byte[] bArr = new byte[8];
        byte[] bArr2 = new byte[160];
        condSubQ();
        int i = 0;
        for (int i2 = 0; i2 < 32; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                bArr[i3] = (byte) (((((getCoeffIndex((i2 * 8) + i3) << 5) + 1664) * 40318) >> 27) & 31);
            }
            bArr2[i] = (byte) (bArr[0] | (bArr[1] << 5));
            bArr2[i + 1] = (byte) ((bArr[1] >> 3) | (bArr[2] << 2) | (bArr[3] << 7));
            bArr2[i + 2] = (byte) ((bArr[3] >> 1) | (bArr[4] << 4));
            bArr2[i + 3] = (byte) ((bArr[5] << 1) | (bArr[4] >> 4) | (bArr[6] << 6));
            bArr2[i + 4] = (byte) ((bArr[6] >> 2) | (bArr[7] << 3));
            i += 5;
        }
        return bArr2;
    }

    public void condSubQ() {
        for (int i = 0; i < 256; i++) {
            short[] sArr = this.f20407coeffs;
            sArr[i] = C5357Reduce.condSubQ(sArr[i]);
        }
    }

    public void convertToMont() {
        for (int i = 0; i < 256; i++) {
            setCoeffIndex(i, C5357Reduce.montgomeryReduce(getCoeffIndex(i) * 1353));
        }
    }

    public void decompressPoly128(byte[] bArr, int i) {
        for (int i2 = 0; i2 < 128; i2++) {
            int i3 = i2 * 2;
            setCoeffIndex(i3, (short) (((((short) (bArr[i] & 15)) * 3329) + 8) >> 4));
            setCoeffIndex(i3 + 1, (short) (((((short) ((bArr[i] & C1126UByte.MAX_VALUE) >> 4)) * 3329) + 8) >> 4));
            i++;
        }
    }

    public void decompressPoly160(byte[] bArr, int i) {
        int i2 = 6;
        int i3 = 7;
        int i4 = 5;
        int i5 = 4;
        int i6 = i;
        int i7 = 0;
        while (i7 < 32) {
            byte b = bArr[i6];
            byte b2 = (byte) (b & C1126UByte.MAX_VALUE);
            int i8 = (b & C1126UByte.MAX_VALUE) >> i4;
            byte b3 = bArr[i6 + 1];
            byte b4 = (byte) (i8 | ((b3 & C1126UByte.MAX_VALUE) << 3));
            byte b5 = (byte) ((b3 & C1126UByte.MAX_VALUE) >> 2);
            int i9 = (b3 & C1126UByte.MAX_VALUE) >> i3;
            byte b6 = bArr[i6 + 2];
            byte b7 = (byte) (((b6 & C1126UByte.MAX_VALUE) << 1) | i9);
            int i10 = (b6 & C1126UByte.MAX_VALUE) >> i5;
            byte b8 = bArr[i6 + 3];
            byte b9 = (byte) (((b8 & C1126UByte.MAX_VALUE) << i5) | i10);
            byte b10 = (byte) ((b8 & C1126UByte.MAX_VALUE) >> 1);
            int i11 = (b8 & C1126UByte.MAX_VALUE) >> i2;
            byte b11 = bArr[i6 + 4];
            byte[] bArr2 = {b2, b4, b5, b7, b9, b10, (byte) (((b11 & C1126UByte.MAX_VALUE) << 2) | i11), (byte) ((b11 & C1126UByte.MAX_VALUE) >> 3)};
            i6 += 5;
            for (int i12 = 0; i12 < 8; i12++) {
                setCoeffIndex((i7 * 8) + i12, (short) ((((bArr2[i12] & 31) * 3329) + 16) >> 5));
            }
            i7++;
            i2 = 6;
            i4 = 5;
            i5 = 4;
            i3 = 7;
        }
    }

    public void fromBytes(byte[] bArr, int i) {
        for (int i2 = 0; i2 < 128; i2++) {
            int i3 = (i2 * 3) + i;
            int i4 = bArr[i3] & C1126UByte.MAX_VALUE;
            int i5 = bArr[i3 + 1] & C1126UByte.MAX_VALUE;
            int i6 = bArr[i3 + 2] & C1126UByte.MAX_VALUE;
            short[] sArr = this.f20407coeffs;
            int i7 = i2 * 2;
            sArr[i7] = (short) ((i4 | (i5 << 8)) & 4095);
            sArr[i7 + 1] = (short) (((i6 << 4) | (i5 >> 4)) & 4095);
        }
    }

    /* renamed from: fromMsg */
    public void m15574fromMsg(byte[] bArr, int i) {
        for (int i2 = 0; i2 < 32; i2++) {
            int i3 = bArr[i + i2] & 255;
            for (int i4 = 0; i4 < 8; i4++) {
                setCoeffIndex((i2 * 8) + i4, (short) (((short) (-((i3 >> i4) & 1))) & 1665));
            }
        }
    }

    public short getCoeffIndex(int i) {
        return this.f20407coeffs[i];
    }

    public short[] getCoeffs() {
        return this.f20407coeffs;
    }

    public void getNoiseEta2(InterfaceC5284Xof interfaceC5284Xof, byte[] bArr, int i, byte b) {
        byte[] bArr2 = new byte[128];
        m15572prf(interfaceC5284Xof, bArr, i, b, bArr2);
        C5353CBD.m15560eta2(this, bArr2);
    }

    public void getNoiseEta3(InterfaceC5284Xof interfaceC5284Xof, byte[] bArr, int i, byte b) {
        byte[] bArr2 = new byte[192];
        m15572prf(interfaceC5284Xof, bArr, i, b, bArr2);
        C5353CBD.m15561eta3(this, bArr2);
    }

    public void polyInverseNttToMont() {
        C5354Ntt.m15569invNtt(this.f20407coeffs);
    }

    /* renamed from: polyNtt */
    public void m15575polyNtt() {
        C5354Ntt.m15571ntt(this.f20407coeffs);
        m15576reduce();
    }

    /* renamed from: reduce */
    public void m15576reduce() {
        for (int i = 0; i < 256; i++) {
            short[] sArr = this.f20407coeffs;
            sArr[i] = C5357Reduce.barrettReduce(sArr[i]);
        }
    }

    public void setCoeffIndex(int i, short s) {
        this.f20407coeffs[i] = s;
    }

    public void subtract(C5355Poly c5355Poly) {
        for (int i = 0; i < 256; i++) {
            short[] sArr = this.f20407coeffs;
            sArr[i] = (short) (c5355Poly.f20407coeffs[i] - sArr[i]);
        }
    }

    /* renamed from: toBytes */
    public void m15577toBytes(byte[] bArr, int i) {
        condSubQ();
        for (int i2 = 0; i2 < 128; i2++) {
            short[] sArr = this.f20407coeffs;
            int i3 = i2 * 2;
            short s = sArr[i3];
            short s2 = sArr[i3 + 1];
            int i4 = (i2 * 3) + i;
            bArr[i4] = (byte) s;
            bArr[i4 + 1] = (byte) ((s >> 8) | (s2 << 4));
            bArr[i4 + 2] = (byte) (s2 >> 4);
        }
    }

    /* renamed from: toMsg */
    public void m15578toMsg(byte[] bArr) {
        condSubQ();
        for (int i = 0; i < 32; i++) {
            bArr[i] = 0;
            for (int i2 = 0; i2 < 8; i2++) {
                short coeffIndex = getCoeffIndex((i * 8) + i2);
                bArr[i] = (byte) (((byte) ((((coeffIndex - 2497) & (832 - coeffIndex)) >>> 31) << i2)) | bArr[i]);
            }
        }
    }
}
