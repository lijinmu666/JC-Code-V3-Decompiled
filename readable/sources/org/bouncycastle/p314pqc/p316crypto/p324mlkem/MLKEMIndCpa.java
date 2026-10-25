package org.bouncycastle.p314pqc.p316crypto.p324mlkem;

import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class MLKEMIndCpa {
    private static final int NUM_MATRIX_BLOCKS = 3;
    private static final int SHAKE128_RATE = 168;

    /* renamed from: engine */
    private final MLKEMEngine f23340engine;

    public MLKEMIndCpa(MLKEMEngine mLKEMEngine) {
        this.f23340engine = mLKEMEngine;
    }

    private byte[] packCipherText(C6079PolyVec c6079PolyVec, C6078Poly c6078Poly) {
        int polyVecCompressedBytes = this.f23340engine.getPolyVecCompressedBytes();
        byte[] bArr = new byte[this.f23340engine.getCipherTextBytes()];
        c6079PolyVec.compressPolyVec(bArr, 0);
        System.arraycopy(this.f23340engine.m17708getK() == 4 ? c6078Poly.compressPoly160() : c6078Poly.compressPoly128(), 0, bArr, polyVecCompressedBytes, this.f23340engine.getPolyCompressedBytes());
        return bArr;
    }

    private static int rejectionSampling(C6078Poly c6078Poly, int i, int i2, byte[] bArr, int i3) {
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
                c6078Poly.setCoeffIndex(i + i4, s2);
                i4++;
            }
            if (i4 < i2 && s3 < 3329) {
                c6078Poly.setCoeffIndex(i + i4, s3);
                i4++;
            }
            i5 = i6;
        }
        return i4;
    }

    private void unpackCipherText(C6079PolyVec c6079PolyVec, C6078Poly c6078Poly, byte[] bArr, int i) {
        c6079PolyVec.decompressPolyVec(bArr, i);
        int polyVecCompressedBytes = i + this.f23340engine.getPolyVecCompressedBytes();
        if (this.f23340engine.m17708getK() == 4) {
            c6078Poly.decompressPoly160(bArr, polyVecCompressedBytes);
        } else {
            c6078Poly.decompressPoly128(bArr, polyVecCompressedBytes);
        }
    }

    /* renamed from: decrypt */
    public void m17709decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int iM17708getK = this.f23340engine.m17708getK();
        C6079PolyVec c6079PolyVec = new C6079PolyVec(iM17708getK);
        C6079PolyVec c6079PolyVec2 = new C6079PolyVec(iM17708getK);
        C6078Poly c6078Poly = new C6078Poly();
        C6078Poly c6078Poly2 = new C6078Poly();
        unpackCipherText(c6079PolyVec, c6078Poly, bArr2, 0);
        unpackSecretKey(c6079PolyVec2, bArr);
        c6079PolyVec.polyVecNtt();
        C6079PolyVec.pointwiseAccountMontgomery(c6078Poly2, c6079PolyVec2, c6079PolyVec, this.f23340engine);
        c6078Poly2.polyInverseNttToMont();
        c6078Poly2.subtract(c6078Poly);
        c6078Poly2.m17726reduce();
        c6078Poly2.m17728toMsg(bArr3);
    }

    /* renamed from: encrypt */
    public byte[] m17710encrypt(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        C6078Poly c6078Poly;
        byte b;
        int iM17708getK = this.f23340engine.m17708getK();
        C6079PolyVec c6079PolyVec = new C6079PolyVec(iM17708getK);
        C6079PolyVec c6079PolyVec2 = new C6079PolyVec(iM17708getK);
        C6079PolyVec c6079PolyVec3 = new C6079PolyVec(iM17708getK);
        C6079PolyVec c6079PolyVec4 = new C6079PolyVec(iM17708getK);
        C6078Poly c6078Poly2 = new C6078Poly();
        C6078Poly c6078Poly3 = new C6078Poly();
        C6078Poly c6078Poly4 = new C6078Poly();
        byte[] bArrUnpackPublicKey = unpackPublicKey(c6079PolyVec2, bArr, i);
        c6078Poly4.m17724fromMsg(bArr2, i2);
        C6079PolyVec[] c6079PolyVecArr = new C6079PolyVec[this.f23340engine.m17708getK()];
        for (int i4 = 0; i4 < iM17708getK; i4++) {
            c6079PolyVecArr[i4] = new C6079PolyVec(iM17708getK);
        }
        generateMatrixA(c6079PolyVecArr, bArrUnpackPublicKey, true);
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        if (this.f23340engine.m17707getEta1() == 2) {
            int i5 = 0;
            b = 0;
            while (i5 < iM17708getK) {
                c6079PolyVec.getVectorIndex(i5).getNoiseEta2(sHAKEDigest, bArr3, i3, b);
                i5++;
                b = (byte) (b + 1);
                c6078Poly4 = c6078Poly4;
            }
            c6078Poly = c6078Poly4;
        } else {
            c6078Poly = c6078Poly4;
            int i6 = 0;
            b = 0;
            while (i6 < iM17708getK) {
                c6079PolyVec.getVectorIndex(i6).getNoiseEta3(sHAKEDigest, bArr3, i3, b);
                i6++;
                b = (byte) (b + 1);
            }
        }
        int i7 = 0;
        while (i7 < iM17708getK) {
            c6079PolyVec3.getVectorIndex(i7).getNoiseEta2(sHAKEDigest, bArr3, i3, b);
            i7++;
            b = (byte) (b + 1);
        }
        c6078Poly2.getNoiseEta2(sHAKEDigest, bArr3, i3, b);
        c6079PolyVec.polyVecNtt();
        for (int i8 = 0; i8 < iM17708getK; i8++) {
            C6079PolyVec.pointwiseAccountMontgomery(c6079PolyVec4.getVectorIndex(i8), c6079PolyVecArr[i8], c6079PolyVec, this.f23340engine);
        }
        C6079PolyVec.pointwiseAccountMontgomery(c6078Poly3, c6079PolyVec2, c6079PolyVec, this.f23340engine);
        c6079PolyVec4.polyVecInverseNttToMont();
        c6078Poly3.polyInverseNttToMont();
        c6079PolyVec4.m17729addPoly(c6079PolyVec3);
        c6078Poly3.m17723add(c6078Poly2);
        c6078Poly3.m17723add(c6078Poly);
        c6079PolyVec4.reducePoly();
        c6078Poly3.m17726reduce();
        return packCipherText(c6079PolyVec4, c6078Poly3);
    }

    public byte[][] generateKeyPair(byte[] bArr) {
        int iM17708getK = this.f23340engine.m17708getK();
        C6079PolyVec c6079PolyVec = new C6079PolyVec(iM17708getK);
        C6079PolyVec c6079PolyVec2 = new C6079PolyVec(iM17708getK);
        byte[] bArr2 = new byte[64];
        MLKEMEngine.m17705hash_G(C6238Arrays.m18223append(bArr, (byte) iM17708getK), bArr2);
        C6079PolyVec[] c6079PolyVecArr = new C6079PolyVec[iM17708getK];
        for (int i = 0; i < iM17708getK; i++) {
            c6079PolyVecArr[i] = new C6079PolyVec(iM17708getK);
        }
        generateMatrixA(c6079PolyVecArr, bArr2, false);
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        if (this.f23340engine.m17707getEta1() == 2) {
            int i2 = 0;
            byte b = 0;
            while (i2 < iM17708getK) {
                c6079PolyVec.getVectorIndex(i2).getNoiseEta2(sHAKEDigest, bArr2, 32, b);
                i2++;
                b = (byte) (b + 1);
            }
            int i3 = 0;
            while (i3 < iM17708getK) {
                c6079PolyVec2.getVectorIndex(i3).getNoiseEta2(sHAKEDigest, bArr2, 32, b);
                i3++;
                b = (byte) (b + 1);
            }
        } else {
            int i4 = 0;
            byte b2 = 0;
            while (i4 < iM17708getK) {
                c6079PolyVec.getVectorIndex(i4).getNoiseEta3(sHAKEDigest, bArr2, 32, b2);
                i4++;
                b2 = (byte) (b2 + 1);
            }
            int i5 = 0;
            while (i5 < iM17708getK) {
                c6079PolyVec2.getVectorIndex(i5).getNoiseEta3(sHAKEDigest, bArr2, 32, b2);
                i5++;
                b2 = (byte) (b2 + 1);
            }
        }
        c6079PolyVec.polyVecNtt();
        c6079PolyVec2.polyVecNtt();
        C6079PolyVec c6079PolyVec3 = new C6079PolyVec(iM17708getK);
        for (int i6 = 0; i6 < iM17708getK; i6++) {
            C6079PolyVec.pointwiseAccountMontgomery(c6079PolyVec3.getVectorIndex(i6), c6079PolyVecArr[i6], c6079PolyVec, this.f23340engine);
            c6079PolyVec3.getVectorIndex(i6).convertToMont();
        }
        c6079PolyVec3.m17729addPoly(c6079PolyVec2);
        c6079PolyVec3.reducePoly();
        return new byte[][]{packPublicKey(c6079PolyVec3, bArr2), packSecretKey(c6079PolyVec)};
    }

    public void generateMatrixA(C6079PolyVec[] c6079PolyVecArr, byte[] bArr, boolean z) {
        byte b;
        int iM17708getK = this.f23340engine.m17708getK();
        SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
        byte[] bArr2 = new byte[506];
        for (int i = 0; i < iM17708getK; i++) {
            for (int i2 = 0; i2 < iM17708getK; i2++) {
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
                int iRejectionSampling = rejectionSampling(c6079PolyVecArr[i].getVectorIndex(i2), 0, 256, bArr2, 504);
                while (iRejectionSampling < 256) {
                    int i4 = i3 % 3;
                    for (int i5 = 0; i5 < i4; i5++) {
                        bArr2[i5] = bArr2[(i3 - i4) + i5];
                    }
                    sHAKEDigest.doOutput(bArr2, i4, 336);
                    i3 = i4 + SHAKE128_RATE;
                    iRejectionSampling += rejectionSampling(c6079PolyVecArr[i].getVectorIndex(i2), iRejectionSampling, 256 - iRejectionSampling, bArr2, i3);
                }
            }
        }
    }

    public byte[] packPublicKey(C6079PolyVec c6079PolyVec, byte[] bArr) {
        int publicKeyBytes = this.f23340engine.getPublicKeyBytes();
        int polyVecBytes = this.f23340engine.getPolyVecBytes();
        byte[] bArr2 = new byte[publicKeyBytes];
        c6079PolyVec.m17730toBytes(bArr2, 0);
        System.arraycopy(bArr, 0, bArr2, polyVecBytes, 32);
        return bArr2;
    }

    public byte[] packSecretKey(C6079PolyVec c6079PolyVec) {
        byte[] bArr = new byte[this.f23340engine.getPolyVecBytes()];
        c6079PolyVec.m17730toBytes(bArr, 0);
        return bArr;
    }

    public byte[] unpackPublicKey(C6079PolyVec c6079PolyVec, byte[] bArr, int i) {
        int polyVecBytes = this.f23340engine.getPolyVecBytes();
        byte[] bArr2 = new byte[32];
        c6079PolyVec.fromBytes(bArr, i);
        System.arraycopy(bArr, i + polyVecBytes, bArr2, 0, 32);
        return bArr2;
    }

    public void unpackSecretKey(C6079PolyVec c6079PolyVec, byte[] bArr) {
        c6079PolyVec.fromBytes(bArr, 0);
    }
}
