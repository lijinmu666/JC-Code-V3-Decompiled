package org.bouncycastle.p194crypto.p207kems.p208mlkem;

import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class MLKEMIndCpa {
    private static final int NUM_MATRIX_BLOCKS = 3;
    private static final int SHAKE128_RATE = 168;

    /* renamed from: engine */
    private final MLKEMEngine f20405engine;

    public MLKEMIndCpa(MLKEMEngine mLKEMEngine) {
        this.f20405engine = mLKEMEngine;
    }

    private byte[] packCipherText(C5356PolyVec c5356PolyVec, C5355Poly c5355Poly) {
        int polyVecCompressedBytes = this.f20405engine.getPolyVecCompressedBytes();
        byte[] bArr = new byte[this.f20405engine.getCipherTextBytes()];
        c5356PolyVec.compressPolyVec(bArr, 0);
        System.arraycopy(this.f20405engine.m15566getK() == 4 ? c5355Poly.compressPoly160() : c5355Poly.compressPoly128(), 0, bArr, polyVecCompressedBytes, this.f20405engine.getPolyCompressedBytes());
        return bArr;
    }

    private static int rejectionSampling(C5355Poly c5355Poly, int i, int i2, byte[] bArr, int i3) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = i5 + 3;
            if (i6 > i3) {
                break;
            }
            short s = (short) (bArr[i5] & C1126UByte.MAX_VALUE);
            byte b = bArr[i5 + 1];
            short s2 = (short) ((s | (((short) (b & C1126UByte.MAX_VALUE)) << 8)) & 4095);
            short s3 = (short) (((((short) (bArr[i5 + 2] & C1126UByte.MAX_VALUE)) << 4) | (((short) (b & C1126UByte.MAX_VALUE)) >> 4)) & 4095);
            if (s2 < 3329) {
                c5355Poly.setCoeffIndex(i + i4, s2);
                i4++;
            }
            if (i4 < i2 && s3 < 3329) {
                c5355Poly.setCoeffIndex(i + i4, s3);
                i4++;
            }
            i5 = i6;
        }
        return i4;
    }

    private void unpackCipherText(C5356PolyVec c5356PolyVec, C5355Poly c5355Poly, byte[] bArr, int i) {
        c5356PolyVec.decompressPolyVec(bArr, i);
        int polyVecCompressedBytes = i + this.f20405engine.getPolyVecCompressedBytes();
        if (this.f20405engine.m15566getK() == 4) {
            c5355Poly.decompressPoly160(bArr, polyVecCompressedBytes);
        } else {
            c5355Poly.decompressPoly128(bArr, polyVecCompressedBytes);
        }
    }

    /* renamed from: decrypt */
    public void m15567decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int iM15566getK = this.f20405engine.m15566getK();
        C5356PolyVec c5356PolyVec = new C5356PolyVec(iM15566getK);
        C5356PolyVec c5356PolyVec2 = new C5356PolyVec(iM15566getK);
        C5355Poly c5355Poly = new C5355Poly();
        C5355Poly c5355Poly2 = new C5355Poly();
        unpackCipherText(c5356PolyVec, c5355Poly, bArr2, 0);
        unpackSecretKey(c5356PolyVec2, bArr);
        c5356PolyVec.polyVecNtt();
        C5356PolyVec.pointwiseAccountMontgomery(c5355Poly2, c5356PolyVec2, c5356PolyVec, this.f20405engine);
        c5355Poly2.polyInverseNttToMont();
        c5355Poly2.subtract(c5355Poly);
        c5355Poly2.m15576reduce();
        c5355Poly2.m15578toMsg(bArr3);
    }

    /* renamed from: encrypt */
    public byte[] m15568encrypt(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        C5355Poly c5355Poly;
        byte b;
        int iM15566getK = this.f20405engine.m15566getK();
        C5356PolyVec c5356PolyVec = new C5356PolyVec(iM15566getK);
        C5356PolyVec c5356PolyVec2 = new C5356PolyVec(iM15566getK);
        C5356PolyVec c5356PolyVec3 = new C5356PolyVec(iM15566getK);
        C5356PolyVec c5356PolyVec4 = new C5356PolyVec(iM15566getK);
        C5355Poly c5355Poly2 = new C5355Poly();
        C5355Poly c5355Poly3 = new C5355Poly();
        C5355Poly c5355Poly4 = new C5355Poly();
        byte[] bArrUnpackPublicKey = unpackPublicKey(c5356PolyVec2, bArr, i);
        c5355Poly4.m15574fromMsg(bArr2, i2);
        C5356PolyVec[] c5356PolyVecArr = new C5356PolyVec[this.f20405engine.m15566getK()];
        for (int i4 = 0; i4 < iM15566getK; i4++) {
            c5356PolyVecArr[i4] = new C5356PolyVec(iM15566getK);
        }
        generateMatrixA(c5356PolyVecArr, bArrUnpackPublicKey, true);
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        if (this.f20405engine.m15565getEta1() == 2) {
            int i5 = 0;
            b = 0;
            while (i5 < iM15566getK) {
                c5356PolyVec.getVectorIndex(i5).getNoiseEta2(sHAKEDigest, bArr3, i3, b);
                i5++;
                b = (byte) (b + 1);
                c5355Poly4 = c5355Poly4;
            }
            c5355Poly = c5355Poly4;
        } else {
            c5355Poly = c5355Poly4;
            int i6 = 0;
            b = 0;
            while (i6 < iM15566getK) {
                c5356PolyVec.getVectorIndex(i6).getNoiseEta3(sHAKEDigest, bArr3, i3, b);
                i6++;
                b = (byte) (b + 1);
            }
        }
        int i7 = 0;
        while (i7 < iM15566getK) {
            c5356PolyVec3.getVectorIndex(i7).getNoiseEta2(sHAKEDigest, bArr3, i3, b);
            i7++;
            b = (byte) (b + 1);
        }
        c5355Poly2.getNoiseEta2(sHAKEDigest, bArr3, i3, b);
        c5356PolyVec.polyVecNtt();
        for (int i8 = 0; i8 < iM15566getK; i8++) {
            C5356PolyVec.pointwiseAccountMontgomery(c5356PolyVec4.getVectorIndex(i8), c5356PolyVecArr[i8], c5356PolyVec, this.f20405engine);
        }
        C5356PolyVec.pointwiseAccountMontgomery(c5355Poly3, c5356PolyVec2, c5356PolyVec, this.f20405engine);
        c5356PolyVec4.polyVecInverseNttToMont();
        c5355Poly3.polyInverseNttToMont();
        c5356PolyVec4.m15579addPoly(c5356PolyVec3);
        c5355Poly3.m15573add(c5355Poly2);
        c5355Poly3.m15573add(c5355Poly);
        c5356PolyVec4.reducePoly();
        c5355Poly3.m15576reduce();
        return packCipherText(c5356PolyVec4, c5355Poly3);
    }

    public byte[][] generateKeyPair(byte[] bArr) {
        int iM15566getK = this.f20405engine.m15566getK();
        C5356PolyVec c5356PolyVec = new C5356PolyVec(iM15566getK);
        C5356PolyVec c5356PolyVec2 = new C5356PolyVec(iM15566getK);
        byte[] bArr2 = new byte[64];
        MLKEMEngine.m15563hash_G(C6238Arrays.m18223append(bArr, (byte) iM15566getK), bArr2);
        C5356PolyVec[] c5356PolyVecArr = new C5356PolyVec[iM15566getK];
        for (int i = 0; i < iM15566getK; i++) {
            c5356PolyVecArr[i] = new C5356PolyVec(iM15566getK);
        }
        generateMatrixA(c5356PolyVecArr, bArr2, false);
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        if (this.f20405engine.m15565getEta1() == 2) {
            int i2 = 0;
            byte b = 0;
            while (i2 < iM15566getK) {
                c5356PolyVec.getVectorIndex(i2).getNoiseEta2(sHAKEDigest, bArr2, 32, b);
                i2++;
                b = (byte) (b + 1);
            }
            int i3 = 0;
            while (i3 < iM15566getK) {
                c5356PolyVec2.getVectorIndex(i3).getNoiseEta2(sHAKEDigest, bArr2, 32, b);
                i3++;
                b = (byte) (b + 1);
            }
        } else {
            int i4 = 0;
            byte b2 = 0;
            while (i4 < iM15566getK) {
                c5356PolyVec.getVectorIndex(i4).getNoiseEta3(sHAKEDigest, bArr2, 32, b2);
                i4++;
                b2 = (byte) (b2 + 1);
            }
            int i5 = 0;
            while (i5 < iM15566getK) {
                c5356PolyVec2.getVectorIndex(i5).getNoiseEta3(sHAKEDigest, bArr2, 32, b2);
                i5++;
                b2 = (byte) (b2 + 1);
            }
        }
        c5356PolyVec.polyVecNtt();
        c5356PolyVec2.polyVecNtt();
        C5356PolyVec c5356PolyVec3 = new C5356PolyVec(iM15566getK);
        for (int i6 = 0; i6 < iM15566getK; i6++) {
            C5356PolyVec.pointwiseAccountMontgomery(c5356PolyVec3.getVectorIndex(i6), c5356PolyVecArr[i6], c5356PolyVec, this.f20405engine);
            c5356PolyVec3.getVectorIndex(i6).convertToMont();
        }
        c5356PolyVec3.m15579addPoly(c5356PolyVec2);
        c5356PolyVec3.reducePoly();
        return new byte[][]{packPublicKey(c5356PolyVec3, bArr2), packSecretKey(c5356PolyVec)};
    }

    public void generateMatrixA(C5356PolyVec[] c5356PolyVecArr, byte[] bArr, boolean z) {
        byte b;
        int iM15566getK = this.f20405engine.m15566getK();
        SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
        byte[] bArr2 = new byte[506];
        for (int i = 0; i < iM15566getK; i++) {
            for (int i2 = 0; i2 < iM15566getK; i2++) {
                sHAKEDigest.mo14968reset();
                sHAKEDigest.mo14970update(bArr, 0, 32);
                if (z) {
                    sHAKEDigest.mo14969update((byte) i);
                    b = (byte) i2;
                } else {
                    sHAKEDigest.mo14969update((byte) i2);
                    b = (byte) i;
                }
                sHAKEDigest.mo14969update(b);
                int i3 = 504;
                sHAKEDigest.doOutput(bArr2, 0, 504);
                int iRejectionSampling = rejectionSampling(c5356PolyVecArr[i].getVectorIndex(i2), 0, 256, bArr2, 504);
                while (iRejectionSampling < 256) {
                    int i4 = i3 % 3;
                    for (int i5 = 0; i5 < i4; i5++) {
                        bArr2[i5] = bArr2[(i3 - i4) + i5];
                    }
                    sHAKEDigest.doOutput(bArr2, i4, 336);
                    i3 = i4 + SHAKE128_RATE;
                    iRejectionSampling += rejectionSampling(c5356PolyVecArr[i].getVectorIndex(i2), iRejectionSampling, 256 - iRejectionSampling, bArr2, i3);
                }
            }
        }
    }

    public byte[] packPublicKey(C5356PolyVec c5356PolyVec, byte[] bArr) {
        int publicKeyBytes = this.f20405engine.getPublicKeyBytes();
        int polyVecBytes = this.f20405engine.getPolyVecBytes();
        byte[] bArr2 = new byte[publicKeyBytes];
        c5356PolyVec.m15580toBytes(bArr2, 0);
        System.arraycopy(bArr, 0, bArr2, polyVecBytes, 32);
        return bArr2;
    }

    public byte[] packSecretKey(C5356PolyVec c5356PolyVec) {
        byte[] bArr = new byte[this.f20405engine.getPolyVecBytes()];
        c5356PolyVec.m15580toBytes(bArr, 0);
        return bArr;
    }

    public byte[] unpackPublicKey(C5356PolyVec c5356PolyVec, byte[] bArr, int i) {
        int polyVecBytes = this.f20405engine.getPolyVecBytes();
        byte[] bArr2 = new byte[32];
        c5356PolyVec.fromBytes(bArr, i);
        System.arraycopy(bArr, i + polyVecBytes, bArr2, 0, 32);
        return bArr2;
    }

    public void unpackSecretKey(C5356PolyVec c5356PolyVec, byte[] bArr) {
        c5356PolyVec.fromBytes(bArr, 0);
    }
}
