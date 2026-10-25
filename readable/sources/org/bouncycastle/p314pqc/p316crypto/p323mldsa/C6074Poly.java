package org.bouncycastle.p314pqc.p316crypto.p323mldsa;

import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import p094kotlin.C1126UByte;

/* renamed from: org.bouncycastle.pqc.crypto.mldsa.Poly */
/* loaded from: classes2.dex */
class C6074Poly {
    private static final int DilithiumN = 256;

    /* renamed from: coeffs */
    private int[] f23326coeffs = new int[256];

    /* renamed from: engine */
    private final MLDSAEngine f23327engine;
    private final int polyUniformNBlocks;
    private final Symmetric symmetric;

    public C6074Poly(MLDSAEngine mLDSAEngine) {
        this.f23327engine = mLDSAEngine;
        Symmetric symmetricGetSymmetric = mLDSAEngine.GetSymmetric();
        this.symmetric = symmetricGetSymmetric;
        int i = symmetricGetSymmetric.stream128BlockBytes;
        this.polyUniformNBlocks = (i + 767) / i;
    }

    private static int rejectEta(C6074Poly c6074Poly, int i, int i2, byte[] bArr, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        while (i5 < i2 && i6 < i3) {
            byte b = bArr[i6];
            int i7 = b & 15;
            i6++;
            int i8 = (b & C1126UByte.MAX_VALUE) >> 4;
            if (i4 == 2) {
                if (i7 < 15) {
                    c6074Poly.setCoeffIndex(i + i5, 2 - (i7 - (((i7 * 205) >> 10) * 5)));
                    i5++;
                }
                if (i8 < 15 && i5 < i2) {
                    c6074Poly.setCoeffIndex(i + i5, 2 - (i8 - (((i8 * 205) >> 10) * 5)));
                    i5++;
                }
            } else if (i4 == 4) {
                if (i7 < 9) {
                    c6074Poly.setCoeffIndex(i + i5, 4 - i7);
                    i5++;
                }
                if (i8 < 9 && i5 < i2) {
                    c6074Poly.setCoeffIndex(i + i5, 4 - i8);
                    i5++;
                }
            }
        }
        return i5;
    }

    private static int rejectUniform(C6074Poly c6074Poly, int i, int i2, byte[] bArr, int i3) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2 && i5 + 3 <= i3) {
            int i6 = i5 + 2;
            int i7 = ((bArr[i5 + 1] & C1126UByte.MAX_VALUE) << 8) | (bArr[i5] & C1126UByte.MAX_VALUE);
            i5 += 3;
            int i8 = (i7 | ((bArr[i6] & C1126UByte.MAX_VALUE) << 16)) & 8388607;
            if (i8 < 8380417) {
                c6074Poly.setCoeffIndex(i + i4, i8);
                i4++;
            }
        }
        return i4;
    }

    /* renamed from: unpackZ */
    private void m17688unpackZ(byte[] bArr) {
        int dilithiumGamma1 = this.f23327engine.getDilithiumGamma1();
        int i = 0;
        if (dilithiumGamma1 != 131072) {
            if (dilithiumGamma1 != 524288) {
                throw new RuntimeException("Wrong Dilithiumn Gamma1!");
            }
            while (i < 128) {
                int i2 = i * 2;
                int i3 = i * 5;
                int i4 = i3 + 2;
                setCoeffIndex(i2, ((bArr[i3] & C1126UByte.MAX_VALUE) | ((bArr[i3 + 1] & C1126UByte.MAX_VALUE) << 8) | ((bArr[i4] & C1126UByte.MAX_VALUE) << 16)) & 1048575);
                int i5 = i2 + 1;
                setCoeffIndex(i5, (((bArr[i3 + 4] & C1126UByte.MAX_VALUE) << 12) | ((bArr[i4] & C1126UByte.MAX_VALUE) >> 4) | ((bArr[i3 + 3] & C1126UByte.MAX_VALUE) << 4)) & 1048575);
                setCoeffIndex(i2, dilithiumGamma1 - getCoeffIndex(i2));
                setCoeffIndex(i5, dilithiumGamma1 - getCoeffIndex(i5));
                i++;
            }
            return;
        }
        while (i < 64) {
            int i6 = i * 4;
            int i7 = i * 9;
            int i8 = i7 + 2;
            setCoeffIndex(i6, ((bArr[i7] & C1126UByte.MAX_VALUE) | ((bArr[i7 + 1] & C1126UByte.MAX_VALUE) << 8) | ((bArr[i8] & C1126UByte.MAX_VALUE) << 16)) & 262143);
            int i9 = i6 + 1;
            int i10 = i7 + 4;
            setCoeffIndex(i9, (((bArr[i8] & C1126UByte.MAX_VALUE) >> 2) | ((bArr[i7 + 3] & C1126UByte.MAX_VALUE) << 6) | ((bArr[i10] & C1126UByte.MAX_VALUE) << 14)) & 262143);
            int i11 = i6 + 2;
            int i12 = i7 + 6;
            setCoeffIndex(i11, (((bArr[i10] & C1126UByte.MAX_VALUE) >> 4) | ((bArr[i7 + 5] & C1126UByte.MAX_VALUE) << 4) | ((bArr[i12] & C1126UByte.MAX_VALUE) << 12)) & 262143);
            int i13 = i6 + 3;
            setCoeffIndex(i13, (((bArr[i7 + 8] & C1126UByte.MAX_VALUE) << 10) | ((bArr[i12] & C1126UByte.MAX_VALUE) >> 6) | ((bArr[i7 + 7] & C1126UByte.MAX_VALUE) << 2)) & 262143);
            setCoeffIndex(i6, dilithiumGamma1 - getCoeffIndex(i6));
            setCoeffIndex(i9, dilithiumGamma1 - getCoeffIndex(i9));
            setCoeffIndex(i11, dilithiumGamma1 - getCoeffIndex(i11));
            setCoeffIndex(i13, dilithiumGamma1 - getCoeffIndex(i13));
            i++;
        }
    }

    /* renamed from: addPoly */
    public void m17689addPoly(C6074Poly c6074Poly) {
        for (int i = 0; i < 256; i++) {
            setCoeffIndex(i, getCoeffIndex(i) + c6074Poly.getCoeffIndex(i));
        }
    }

    public void challenge(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        byte[] bArr2 = new byte[this.symmetric.stream256BlockBytes];
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.mo14970update(bArr, i, i2);
        sHAKEDigest.doOutput(bArr2, 0, this.symmetric.stream256BlockBytes);
        long j = 0;
        int i6 = 0;
        while (true) {
            i3 = 8;
            if (i6 >= 8) {
                break;
            }
            j |= (bArr2[i6] & C1126UByte.MAX_VALUE) << (i6 * 8);
            i6++;
        }
        for (int i7 = 0; i7 < 256; i7++) {
            setCoeffIndex(i7, 0);
        }
        int dilithiumTau = 256 - this.f23327engine.getDilithiumTau();
        while (dilithiumTau < 256) {
            while (true) {
                int i8 = this.symmetric.stream256BlockBytes;
                if (i3 >= i8) {
                    sHAKEDigest.doOutput(bArr2, 0, i8);
                    i3 = 0;
                }
                i4 = i3 + 1;
                i5 = bArr2[i3] & C1126UByte.MAX_VALUE;
                if (i5 <= dilithiumTau) {
                    break;
                } else {
                    i3 = i4;
                }
            }
            setCoeffIndex(dilithiumTau, getCoeffIndex(i5));
            setCoeffIndex(i5, (int) (1 - ((j & 1) * 2)));
            j >>= 1;
            dilithiumTau++;
            i3 = i4;
        }
    }

    public boolean checkNorm(int i) {
        if (i > 1047552) {
            return true;
        }
        for (int i2 = 0; i2 < 256; i2++) {
            if (getCoeffIndex(i2) - ((getCoeffIndex(i2) >> 31) & (getCoeffIndex(i2) * 2)) >= i) {
                return true;
            }
        }
        return false;
    }

    public void conditionalAddQ() {
        for (int i = 0; i < 256; i++) {
            setCoeffIndex(i, C6075Reduce.conditionalAddQ(getCoeffIndex(i)));
        }
    }

    /* renamed from: copyTo */
    public void m17690copyTo(C6074Poly c6074Poly) {
        System.arraycopy(this.f23326coeffs, 0, c6074Poly.f23326coeffs, 0, 256);
    }

    public void decompose(C6074Poly c6074Poly) {
        int dilithiumGamma2 = this.f23327engine.getDilithiumGamma2();
        for (int i = 0; i < 256; i++) {
            int[] iArrDecompose = Rounding.decompose(getCoeffIndex(i), dilithiumGamma2);
            setCoeffIndex(i, iArrDecompose[1]);
            c6074Poly.setCoeffIndex(i, iArrDecompose[0]);
        }
    }

    public int getCoeffIndex(int i) {
        return this.f23326coeffs[i];
    }

    public int[] getCoeffs() {
        return this.f23326coeffs;
    }

    public void invNttToMont() {
        setCoeffs(C6072Ntt.invNttToMont(getCoeffs()));
    }

    /* renamed from: packW1 */
    public void m17691packW1(byte[] bArr, int i) {
        int i2 = 0;
        if (this.f23327engine.getDilithiumGamma2() != 95232) {
            if (this.f23327engine.getDilithiumGamma2() == 261888) {
                while (i2 < 128) {
                    int i3 = i2 * 2;
                    bArr[i + i2] = (byte) ((getCoeffIndex(i3 + 1) << 4) | getCoeffIndex(i3));
                    i2++;
                }
                return;
            }
            return;
        }
        while (i2 < 64) {
            int i4 = (i2 * 3) + i;
            int i5 = i2 * 4;
            int i6 = i5 + 1;
            bArr[i4] = (byte) (((byte) getCoeffIndex(i5)) | (getCoeffIndex(i6) << 6));
            int i7 = i5 + 2;
            bArr[i4 + 1] = (byte) (((byte) (getCoeffIndex(i6) >> 2)) | (getCoeffIndex(i7) << 4));
            bArr[i4 + 2] = (byte) ((getCoeffIndex(i5 + 3) << 2) | ((byte) (getCoeffIndex(i7) >> 4)));
            i2++;
        }
    }

    public void pointwiseAccountMontgomery(PolyVecL polyVecL, PolyVecL polyVecL2) {
        C6074Poly c6074Poly = new C6074Poly(this.f23327engine);
        pointwiseMontgomery(polyVecL.getVectorIndex(0), polyVecL2.getVectorIndex(0));
        for (int i = 1; i < this.f23327engine.getDilithiumL(); i++) {
            c6074Poly.pointwiseMontgomery(polyVecL.getVectorIndex(i), polyVecL2.getVectorIndex(i));
            m17689addPoly(c6074Poly);
        }
    }

    public void pointwiseMontgomery(C6074Poly c6074Poly, C6074Poly c6074Poly2) {
        for (int i = 0; i < 256; i++) {
            setCoeffIndex(i, C6075Reduce.montgomeryReduce(c6074Poly.getCoeffIndex(i) * c6074Poly2.getCoeffIndex(i)));
        }
    }

    public byte[] polyEtaPack(byte[] bArr, int i) {
        byte[] bArr2 = new byte[8];
        if (this.f23327engine.getDilithiumEta() == 2) {
            for (int i2 = 0; i2 < 32; i2++) {
                int i3 = i2 * 8;
                bArr2[0] = (byte) (this.f23327engine.getDilithiumEta() - getCoeffIndex(i3));
                bArr2[1] = (byte) (this.f23327engine.getDilithiumEta() - getCoeffIndex(i3 + 1));
                bArr2[2] = (byte) (this.f23327engine.getDilithiumEta() - getCoeffIndex(i3 + 2));
                bArr2[3] = (byte) (this.f23327engine.getDilithiumEta() - getCoeffIndex(i3 + 3));
                bArr2[4] = (byte) (this.f23327engine.getDilithiumEta() - getCoeffIndex(i3 + 4));
                bArr2[5] = (byte) (this.f23327engine.getDilithiumEta() - getCoeffIndex(i3 + 5));
                bArr2[6] = (byte) (this.f23327engine.getDilithiumEta() - getCoeffIndex(i3 + 6));
                bArr2[7] = (byte) (this.f23327engine.getDilithiumEta() - getCoeffIndex(i3 + 7));
                int i4 = (i2 * 3) + i;
                bArr[i4] = (byte) (bArr2[0] | (bArr2[1] << 3) | (bArr2[2] << 6));
                bArr[i4 + 1] = (byte) ((bArr2[3] << 1) | (bArr2[2] >> 2) | (bArr2[4] << 4) | (bArr2[5] << 7));
                bArr[i4 + 2] = (byte) ((bArr2[5] >> 1) | (bArr2[6] << 2) | (bArr2[7] << 5));
            }
        } else {
            if (this.f23327engine.getDilithiumEta() != 4) {
                throw new RuntimeException("Eta needs to be 2 or 4!");
            }
            for (int i5 = 0; i5 < 128; i5++) {
                int i6 = i5 * 2;
                bArr2[0] = (byte) (this.f23327engine.getDilithiumEta() - getCoeffIndex(i6));
                byte dilithiumEta = (byte) (this.f23327engine.getDilithiumEta() - getCoeffIndex(i6 + 1));
                bArr2[1] = dilithiumEta;
                bArr[i + i5] = (byte) ((dilithiumEta << 4) | bArr2[0]);
            }
        }
        return bArr;
    }

    public void polyEtaUnpack(byte[] bArr, int i) {
        int dilithiumEta = this.f23327engine.getDilithiumEta();
        int i2 = 0;
        if (this.f23327engine.getDilithiumEta() != 2) {
            if (this.f23327engine.getDilithiumEta() == 4) {
                while (i2 < 128) {
                    int i3 = i2 * 2;
                    int i4 = i + i2;
                    setCoeffIndex(i3, bArr[i4] & 15);
                    int i5 = i3 + 1;
                    setCoeffIndex(i5, (bArr[i4] & C1126UByte.MAX_VALUE) >> 4);
                    setCoeffIndex(i3, dilithiumEta - getCoeffIndex(i3));
                    setCoeffIndex(i5, dilithiumEta - getCoeffIndex(i5));
                    i2++;
                }
                return;
            }
            return;
        }
        while (i2 < 32) {
            int i6 = (i2 * 3) + i;
            int i7 = i2 * 8;
            setCoeffIndex(i7, bArr[i6] & 7);
            int i8 = i7 + 1;
            setCoeffIndex(i8, ((bArr[i6] & C1126UByte.MAX_VALUE) >> 3) & 7);
            int i9 = i7 + 2;
            int i10 = i6 + 1;
            setCoeffIndex(i9, ((bArr[i6] & C1126UByte.MAX_VALUE) >> 6) | (((bArr[i10] & C1126UByte.MAX_VALUE) << 2) & 7));
            int i11 = i7 + 3;
            setCoeffIndex(i11, ((bArr[i10] & C1126UByte.MAX_VALUE) >> 1) & 7);
            int i12 = i7 + 4;
            setCoeffIndex(i12, ((bArr[i10] & C1126UByte.MAX_VALUE) >> 4) & 7);
            int i13 = i7 + 5;
            int i14 = i6 + 2;
            setCoeffIndex(i13, ((bArr[i10] & C1126UByte.MAX_VALUE) >> 7) | (((bArr[i14] & C1126UByte.MAX_VALUE) << 1) & 7));
            int i15 = i7 + 6;
            setCoeffIndex(i15, ((bArr[i14] & C1126UByte.MAX_VALUE) >> 2) & 7);
            int i16 = i7 + 7;
            setCoeffIndex(i16, ((bArr[i14] & C1126UByte.MAX_VALUE) >> 5) & 7);
            setCoeffIndex(i7, dilithiumEta - getCoeffIndex(i7));
            setCoeffIndex(i8, dilithiumEta - getCoeffIndex(i8));
            setCoeffIndex(i9, dilithiumEta - getCoeffIndex(i9));
            setCoeffIndex(i11, dilithiumEta - getCoeffIndex(i11));
            setCoeffIndex(i12, dilithiumEta - getCoeffIndex(i12));
            setCoeffIndex(i13, dilithiumEta - getCoeffIndex(i13));
            setCoeffIndex(i15, dilithiumEta - getCoeffIndex(i15));
            setCoeffIndex(i16, dilithiumEta - getCoeffIndex(i16));
            i2++;
        }
    }

    public int polyMakeHint(C6074Poly c6074Poly, C6074Poly c6074Poly2) {
        int coeffIndex = 0;
        for (int i = 0; i < 256; i++) {
            setCoeffIndex(i, Rounding.makeHint(c6074Poly.getCoeffIndex(i), c6074Poly2.getCoeffIndex(i), this.f23327engine));
            coeffIndex += getCoeffIndex(i);
        }
        return coeffIndex;
    }

    /* renamed from: polyNtt */
    public void m17692polyNtt() {
        setCoeffs(C6072Ntt.m17687ntt(this.f23326coeffs));
    }

    public void polyUseHint(C6074Poly c6074Poly, C6074Poly c6074Poly2) {
        for (int i = 0; i < 256; i++) {
            setCoeffIndex(i, Rounding.m17701useHint(c6074Poly.getCoeffIndex(i), c6074Poly2.getCoeffIndex(i), this.f23327engine.getDilithiumGamma2()));
        }
    }

    public byte[] polyt0Pack(byte[] bArr, int i) {
        for (int i2 = 0; i2 < 32; i2++) {
            int i3 = i2 * 8;
            int[] iArr = {4096 - getCoeffIndex(i3), 4096 - getCoeffIndex(i3 + 1), 4096 - getCoeffIndex(i3 + 2), 4096 - getCoeffIndex(i3 + 3), 4096 - getCoeffIndex(i3 + 4), 4096 - getCoeffIndex(i3 + 5), 4096 - getCoeffIndex(i3 + 6), 4096 - getCoeffIndex(i3 + 7)};
            int i4 = (i2 * 13) + i;
            int i5 = iArr[0];
            bArr[i4] = (byte) i5;
            int i6 = i4 + 1;
            byte b = (byte) (i5 >> 8);
            bArr[i6] = b;
            int i7 = iArr[1];
            bArr[i6] = (byte) (b | ((byte) (i7 << 5)));
            bArr[i4 + 2] = (byte) (i7 >> 3);
            int i8 = i4 + 3;
            byte b2 = (byte) (i7 >> 11);
            bArr[i8] = b2;
            int i9 = iArr[2];
            bArr[i8] = (byte) (b2 | ((byte) (i9 << 2)));
            int i10 = i4 + 4;
            byte b3 = (byte) (i9 >> 6);
            bArr[i10] = b3;
            int i11 = iArr[3];
            bArr[i10] = (byte) (b3 | ((byte) (i11 << 7)));
            bArr[i4 + 5] = (byte) (i11 >> 1);
            int i12 = i4 + 6;
            byte b4 = (byte) (i11 >> 9);
            bArr[i12] = b4;
            int i13 = iArr[4];
            bArr[i12] = (byte) (b4 | ((byte) (i13 << 4)));
            bArr[i4 + 7] = (byte) (i13 >> 4);
            int i14 = i4 + 8;
            byte b5 = (byte) (i13 >> 12);
            bArr[i14] = b5;
            int i15 = iArr[5];
            bArr[i14] = (byte) (b5 | ((byte) (i15 << 1)));
            int i16 = i4 + 9;
            byte b6 = (byte) (i15 >> 7);
            bArr[i16] = b6;
            int i17 = iArr[6];
            bArr[i16] = (byte) (b6 | ((byte) (i17 << 6)));
            bArr[i4 + 10] = (byte) (i17 >> 2);
            int i18 = i4 + 11;
            byte b7 = (byte) (i17 >> 10);
            bArr[i18] = b7;
            int i19 = iArr[7];
            bArr[i18] = (byte) (((byte) (i19 << 3)) | b7);
            bArr[i4 + 12] = (byte) (i19 >> 5);
        }
        return bArr;
    }

    public void polyt0Unpack(byte[] bArr, int i) {
        for (int i2 = 0; i2 < 32; i2++) {
            int i3 = (i2 * 13) + i;
            int i4 = i2 * 8;
            int i5 = i3 + 1;
            setCoeffIndex(i4, ((bArr[i3] & C1126UByte.MAX_VALUE) | ((bArr[i5] & C1126UByte.MAX_VALUE) << 8)) & 8191);
            int i6 = i4 + 1;
            int i7 = i3 + 3;
            setCoeffIndex(i6, (((bArr[i5] & C1126UByte.MAX_VALUE) >> 5) | ((bArr[i3 + 2] & C1126UByte.MAX_VALUE) << 3) | ((bArr[i7] & C1126UByte.MAX_VALUE) << 11)) & 8191);
            int i8 = i4 + 2;
            int i9 = i3 + 4;
            setCoeffIndex(i8, (((bArr[i7] & C1126UByte.MAX_VALUE) >> 2) | ((bArr[i9] & C1126UByte.MAX_VALUE) << 6)) & 8191);
            int i10 = i4 + 3;
            int i11 = i3 + 6;
            setCoeffIndex(i10, (((bArr[i9] & C1126UByte.MAX_VALUE) >> 7) | ((bArr[i3 + 5] & C1126UByte.MAX_VALUE) << 1) | ((bArr[i11] & C1126UByte.MAX_VALUE) << 9)) & 8191);
            int i12 = i4 + 4;
            int i13 = i3 + 8;
            setCoeffIndex(i12, (((bArr[i11] & C1126UByte.MAX_VALUE) >> 4) | ((bArr[i3 + 7] & C1126UByte.MAX_VALUE) << 4) | ((bArr[i13] & C1126UByte.MAX_VALUE) << 12)) & 8191);
            int i14 = i4 + 5;
            int i15 = i3 + 9;
            setCoeffIndex(i14, (((bArr[i13] & C1126UByte.MAX_VALUE) >> 1) | ((bArr[i15] & C1126UByte.MAX_VALUE) << 7)) & 8191);
            int i16 = i4 + 6;
            int i17 = i3 + 11;
            setCoeffIndex(i16, (((bArr[i15] & C1126UByte.MAX_VALUE) >> 6) | ((bArr[i3 + 10] & C1126UByte.MAX_VALUE) << 2) | ((bArr[i17] & C1126UByte.MAX_VALUE) << 10)) & 8191);
            int i18 = i4 + 7;
            setCoeffIndex(i18, (((bArr[i3 + 12] & C1126UByte.MAX_VALUE) << 5) | ((bArr[i17] & C1126UByte.MAX_VALUE) >> 3)) & 8191);
            setCoeffIndex(i4, 4096 - getCoeffIndex(i4));
            setCoeffIndex(i6, 4096 - getCoeffIndex(i6));
            setCoeffIndex(i8, 4096 - getCoeffIndex(i8));
            setCoeffIndex(i10, 4096 - getCoeffIndex(i10));
            setCoeffIndex(i12, 4096 - getCoeffIndex(i12));
            setCoeffIndex(i14, 4096 - getCoeffIndex(i14));
            setCoeffIndex(i16, 4096 - getCoeffIndex(i16));
            setCoeffIndex(i18, 4096 - getCoeffIndex(i18));
        }
    }

    public byte[] polyt1Pack() {
        byte[] bArr = new byte[320];
        for (int i = 0; i < 64; i++) {
            int i2 = i * 5;
            int[] iArr = this.f23326coeffs;
            int i3 = i * 4;
            int i4 = iArr[i3];
            bArr[i2] = (byte) i4;
            int i5 = iArr[i3 + 1];
            bArr[i2 + 1] = (byte) ((i4 >> 8) | (i5 << 2));
            int i6 = i5 >> 6;
            int i7 = iArr[i3 + 2];
            bArr[i2 + 2] = (byte) (i6 | (i7 << 4));
            int i8 = iArr[i3 + 3];
            bArr[i2 + 3] = (byte) ((i8 << 6) | (i7 >> 4));
            bArr[i2 + 4] = (byte) (i8 >> 2);
        }
        return bArr;
    }

    public void polyt1Unpack(byte[] bArr) {
        for (int i = 0; i < 64; i++) {
            int i2 = i * 4;
            int i3 = i * 5;
            int i4 = i3 + 1;
            setCoeffIndex(i2, ((bArr[i3] & C1126UByte.MAX_VALUE) | ((bArr[i4] & C1126UByte.MAX_VALUE) << 8)) & 1023);
            int i5 = i3 + 2;
            setCoeffIndex(i2 + 1, (((bArr[i4] & C1126UByte.MAX_VALUE) >> 2) | ((bArr[i5] & C1126UByte.MAX_VALUE) << 6)) & 1023);
            int i6 = (bArr[i5] & C1126UByte.MAX_VALUE) >> 4;
            int i7 = i3 + 3;
            setCoeffIndex(i2 + 2, (i6 | ((bArr[i7] & C1126UByte.MAX_VALUE) << 4)) & 1023);
            setCoeffIndex(i2 + 3, (((bArr[i3 + 4] & C1126UByte.MAX_VALUE) << 2) | ((bArr[i7] & C1126UByte.MAX_VALUE) >> 6)) & 1023);
        }
    }

    public void power2Round(C6074Poly c6074Poly) {
        Rounding.power2RoundAll(this.f23326coeffs, c6074Poly.f23326coeffs);
    }

    /* renamed from: reduce */
    public void m17693reduce() {
        for (int i = 0; i < 256; i++) {
            setCoeffIndex(i, C6075Reduce.reduce32(getCoeffIndex(i)));
        }
    }

    public void setCoeffIndex(int i, int i2) {
        this.f23326coeffs[i] = i2;
    }

    public void setCoeffs(int[] iArr) {
        this.f23326coeffs = iArr;
    }

    public void shiftLeft() {
        for (int i = 0; i < 256; i++) {
            setCoeffIndex(i, getCoeffIndex(i) << 13);
        }
    }

    public void subtract(C6074Poly c6074Poly) {
        for (int i = 0; i < 256; i++) {
            setCoeffIndex(i, getCoeffIndex(i) - c6074Poly.getCoeffIndex(i));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
        while (true) {
            int[] iArr = this.f23326coeffs;
            if (i >= iArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(iArr[i]);
            if (i != this.f23326coeffs.length - 1) {
                sb.append(", ");
            }
            i++;
        }
    }

    public void uniformBlocks(byte[] bArr, short s) {
        int i = this.polyUniformNBlocks;
        Symmetric symmetric = this.symmetric;
        int i2 = i * symmetric.stream128BlockBytes;
        byte[] bArr2 = new byte[i2 + 2];
        symmetric.stream128init(bArr, s);
        this.symmetric.stream128squeezeBlocks(bArr2, 0, i2);
        int iRejectUniform = rejectUniform(this, 0, 256, bArr2, i2);
        while (iRejectUniform < 256) {
            int i3 = i2 % 3;
            for (int i4 = 0; i4 < i3; i4++) {
                bArr2[i4] = bArr2[(i2 - i3) + i4];
            }
            Symmetric symmetric2 = this.symmetric;
            symmetric2.stream128squeezeBlocks(bArr2, i3, symmetric2.stream128BlockBytes);
            i2 = this.symmetric.stream128BlockBytes + i3;
            iRejectUniform += rejectUniform(this, iRejectUniform, 256 - iRejectUniform, bArr2, i2);
        }
    }

    public void uniformEta(byte[] bArr, short s) {
        int i;
        int i2;
        int dilithiumEta = this.f23327engine.getDilithiumEta();
        if (this.f23327engine.getDilithiumEta() == 2) {
            i = this.symmetric.stream256BlockBytes;
            i2 = i + 135;
        } else {
            if (this.f23327engine.getDilithiumEta() != 4) {
                throw new RuntimeException("Wrong Dilithium Eta!");
            }
            i = this.symmetric.stream256BlockBytes;
            i2 = i + 226;
        }
        int i3 = i2 / i;
        Symmetric symmetric = this.symmetric;
        int i4 = i3 * symmetric.stream256BlockBytes;
        byte[] bArr2 = new byte[i4];
        symmetric.stream256init(bArr, s);
        this.symmetric.stream256squeezeBlocks(bArr2, 0, i4);
        int iRejectEta = rejectEta(this, 0, 256, bArr2, i4, dilithiumEta);
        while (iRejectEta < 256) {
            Symmetric symmetric2 = this.symmetric;
            symmetric2.stream256squeezeBlocks(bArr2, 0, symmetric2.stream256BlockBytes);
            iRejectEta += rejectEta(this, iRejectEta, 256 - iRejectEta, bArr2, this.symmetric.stream256BlockBytes, dilithiumEta);
        }
    }

    public void uniformGamma1(byte[] bArr, short s) {
        int polyUniformGamma1NBlocks = this.f23327engine.getPolyUniformGamma1NBlocks();
        Symmetric symmetric = this.symmetric;
        byte[] bArr2 = new byte[polyUniformGamma1NBlocks * symmetric.stream256BlockBytes];
        symmetric.stream256init(bArr, s);
        this.symmetric.stream256squeezeBlocks(bArr2, 0, this.f23327engine.getPolyUniformGamma1NBlocks() * this.symmetric.stream256BlockBytes);
        m17688unpackZ(bArr2);
    }

    /* renamed from: zPack */
    public void m17694zPack(byte[] bArr, int i) {
        int dilithiumGamma1 = this.f23327engine.getDilithiumGamma1();
        int i2 = 0;
        if (dilithiumGamma1 != 131072) {
            if (dilithiumGamma1 != 524288) {
                throw new RuntimeException("Wrong Dilithium Gamma1!");
            }
            while (i2 < 128) {
                int i3 = i2 * 2;
                int coeffIndex = dilithiumGamma1 - getCoeffIndex(i3);
                int coeffIndex2 = dilithiumGamma1 - getCoeffIndex(i3 + 1);
                int i4 = (i2 * 5) + i;
                bArr[i4] = (byte) coeffIndex;
                bArr[i4 + 1] = (byte) (coeffIndex >> 8);
                bArr[i4 + 2] = (byte) (((byte) (coeffIndex >> 16)) | (coeffIndex2 << 4));
                bArr[i4 + 3] = (byte) (coeffIndex2 >> 4);
                bArr[i4 + 4] = (byte) (coeffIndex2 >> 12);
                i2++;
            }
            return;
        }
        while (i2 < 64) {
            int i5 = i2 * 4;
            int coeffIndex3 = dilithiumGamma1 - getCoeffIndex(i5);
            int coeffIndex4 = dilithiumGamma1 - getCoeffIndex(i5 + 1);
            int coeffIndex5 = dilithiumGamma1 - getCoeffIndex(i5 + 2);
            int coeffIndex6 = dilithiumGamma1 - getCoeffIndex(i5 + 3);
            int i6 = (i2 * 9) + i;
            bArr[i6] = (byte) coeffIndex3;
            bArr[i6 + 1] = (byte) (coeffIndex3 >> 8);
            bArr[i6 + 2] = (byte) (((byte) (coeffIndex3 >> 16)) | (coeffIndex4 << 2));
            bArr[i6 + 3] = (byte) (coeffIndex4 >> 6);
            bArr[i6 + 4] = (byte) (((byte) (coeffIndex4 >> 14)) | (coeffIndex5 << 4));
            bArr[i6 + 5] = (byte) (coeffIndex5 >> 4);
            bArr[i6 + 6] = (byte) (((byte) (coeffIndex5 >> 12)) | (coeffIndex6 << 6));
            bArr[i6 + 7] = (byte) (coeffIndex6 >> 2);
            bArr[i6 + 8] = (byte) (coeffIndex6 >> 10);
            i2++;
        }
    }

    /* renamed from: zUnpack */
    public void m17695zUnpack(byte[] bArr) {
        int i = 0;
        if (this.f23327engine.getDilithiumGamma1() != 131072) {
            if (this.f23327engine.getDilithiumGamma1() != 524288) {
                throw new RuntimeException("Wrong Dilithium Gamma1!");
            }
            while (i < 128) {
                int i2 = i * 2;
                int i3 = i * 5;
                int i4 = i3 + 2;
                setCoeffIndex(i2, ((bArr[i3] & C1126UByte.MAX_VALUE) | ((bArr[i3 + 1] & C1126UByte.MAX_VALUE) << 8) | ((bArr[i4] & C1126UByte.MAX_VALUE) << 16)) & 1048575);
                int i5 = i2 + 1;
                setCoeffIndex(i5, (((bArr[i3 + 4] & C1126UByte.MAX_VALUE) << 12) | ((bArr[i4] & C1126UByte.MAX_VALUE) >>> 4) | ((bArr[i3 + 3] & C1126UByte.MAX_VALUE) << 4)) & 1048575);
                setCoeffIndex(i2, this.f23327engine.getDilithiumGamma1() - getCoeffIndex(i2));
                setCoeffIndex(i5, this.f23327engine.getDilithiumGamma1() - getCoeffIndex(i5));
                i++;
            }
            return;
        }
        while (i < 64) {
            int i6 = i * 4;
            int i7 = i * 9;
            int i8 = i7 + 2;
            setCoeffIndex(i6, ((bArr[i7] & C1126UByte.MAX_VALUE) | ((bArr[i7 + 1] & C1126UByte.MAX_VALUE) << 8) | ((bArr[i8] & C1126UByte.MAX_VALUE) << 16)) & 262143);
            int i9 = i6 + 1;
            int i10 = i7 + 4;
            setCoeffIndex(i9, (((bArr[i8] & C1126UByte.MAX_VALUE) >>> 2) | ((bArr[i7 + 3] & C1126UByte.MAX_VALUE) << 6) | ((bArr[i10] & C1126UByte.MAX_VALUE) << 14)) & 262143);
            int i11 = i6 + 2;
            int i12 = i7 + 6;
            setCoeffIndex(i11, (((bArr[i10] & C1126UByte.MAX_VALUE) >>> 4) | ((bArr[i7 + 5] & C1126UByte.MAX_VALUE) << 4) | ((bArr[i12] & C1126UByte.MAX_VALUE) << 12)) & 262143);
            int i13 = i6 + 3;
            setCoeffIndex(i13, (((bArr[i7 + 8] & C1126UByte.MAX_VALUE) << 10) | ((bArr[i12] & C1126UByte.MAX_VALUE) >>> 6) | ((bArr[i7 + 7] & C1126UByte.MAX_VALUE) << 2)) & 262143);
            setCoeffIndex(i6, this.f23327engine.getDilithiumGamma1() - getCoeffIndex(i6));
            setCoeffIndex(i9, this.f23327engine.getDilithiumGamma1() - getCoeffIndex(i9));
            setCoeffIndex(i11, this.f23327engine.getDilithiumGamma1() - getCoeffIndex(i11));
            setCoeffIndex(i13, this.f23327engine.getDilithiumGamma1() - getCoeffIndex(i13));
            i++;
        }
    }
}
