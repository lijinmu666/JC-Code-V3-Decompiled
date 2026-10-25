package org.bouncycastle.p314pqc.p316crypto.p325newhope;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.p199digests.SHA3Digest;
import p094kotlin.C1126UByte;

/* renamed from: org.bouncycastle.pqc.crypto.newhope.NewHope */
/* loaded from: classes2.dex */
class C6085NewHope {
    public static final int AGREEMENT_SIZE = 32;
    public static final int POLY_SIZE = 1024;
    public static final int SENDA_BYTES = 1824;
    public static final int SENDB_BYTES = 2048;
    private static final boolean STATISTICAL_TEST = false;

    /* renamed from: decodeA */
    public static void m17742decodeA(short[] sArr, byte[] bArr, byte[] bArr2) {
        C6087Poly.fromBytes(sArr, bArr2);
        System.arraycopy(bArr2, 1792, bArr, 0, 32);
    }

    /* renamed from: decodeB */
    public static void m17743decodeB(short[] sArr, short[] sArr2, byte[] bArr) {
        C6087Poly.fromBytes(sArr, bArr);
        for (int i = 0; i < 256; i++) {
            int i2 = i * 4;
            byte b = bArr[i + 1792];
            int i3 = b & C1126UByte.MAX_VALUE;
            sArr2[i2] = (short) (b & 3);
            sArr2[i2 + 1] = (short) ((i3 >>> 2) & 3);
            sArr2[i2 + 2] = (short) ((i3 >>> 4) & 3);
            sArr2[i2 + 3] = (short) (i3 >>> 6);
        }
    }

    /* renamed from: encodeA */
    public static void m17744encodeA(byte[] bArr, short[] sArr, byte[] bArr2) {
        C6087Poly.m17752toBytes(bArr, sArr);
        System.arraycopy(bArr2, 0, bArr, 1792, 32);
    }

    /* renamed from: encodeB */
    public static void m17745encodeB(byte[] bArr, short[] sArr, short[] sArr2) {
        C6087Poly.m17752toBytes(bArr, sArr);
        for (int i = 0; i < 256; i++) {
            int i2 = i * 4;
            bArr[i + 1792] = (byte) ((sArr2[i2 + 3] << 6) | sArr2[i2] | (sArr2[i2 + 1] << 2) | (sArr2[i2 + 2] << 4));
        }
    }

    public static void generateA(short[] sArr, byte[] bArr) {
        C6087Poly.m17754uniform(sArr, bArr);
    }

    /* renamed from: keygen */
    public static void m17746keygen(SecureRandom secureRandom, byte[] bArr, short[] sArr) {
        byte[] bArr2 = new byte[32];
        secureRandom.nextBytes(bArr2);
        m17747sha3(bArr2);
        short[] sArr2 = new short[1024];
        generateA(sArr2, bArr2);
        byte[] bArr3 = new byte[32];
        secureRandom.nextBytes(bArr3);
        C6087Poly.getNoise(sArr, bArr3, (byte) 0);
        C6087Poly.m17753toNTT(sArr);
        short[] sArr3 = new short[1024];
        C6087Poly.getNoise(sArr3, bArr3, (byte) 1);
        C6087Poly.m17753toNTT(sArr3);
        short[] sArr4 = new short[1024];
        C6087Poly.pointWise(sArr2, sArr, sArr4);
        short[] sArr5 = new short[1024];
        C6087Poly.m17750add(sArr4, sArr3, sArr5);
        m17744encodeA(bArr, sArr5, bArr2);
    }

    /* renamed from: sha3 */
    public static void m17747sha3(byte[] bArr) {
        SHA3Digest sHA3Digest = new SHA3Digest(256);
        sHA3Digest.mo14970update(bArr, 0, 32);
        sHA3Digest.mo14967doFinal(bArr, 0);
    }

    /* renamed from: sharedA */
    public static void m17748sharedA(byte[] bArr, short[] sArr, byte[] bArr2) {
        short[] sArr2 = new short[1024];
        short[] sArr3 = new short[1024];
        m17743decodeB(sArr2, sArr3, bArr2);
        short[] sArr4 = new short[1024];
        C6087Poly.pointWise(sArr, sArr2, sArr4);
        C6087Poly.m17751fromNTT(sArr4);
        ErrorCorrection.m17736rec(bArr, sArr4, sArr3);
        m17747sha3(bArr);
    }

    /* renamed from: sharedB */
    public static void m17749sharedB(SecureRandom secureRandom, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        short[] sArr = new short[1024];
        byte[] bArr4 = new byte[32];
        m17742decodeA(sArr, bArr4, bArr3);
        short[] sArr2 = new short[1024];
        generateA(sArr2, bArr4);
        byte[] bArr5 = new byte[32];
        secureRandom.nextBytes(bArr5);
        short[] sArr3 = new short[1024];
        C6087Poly.getNoise(sArr3, bArr5, (byte) 0);
        C6087Poly.m17753toNTT(sArr3);
        short[] sArr4 = new short[1024];
        C6087Poly.getNoise(sArr4, bArr5, (byte) 1);
        C6087Poly.m17753toNTT(sArr4);
        short[] sArr5 = new short[1024];
        C6087Poly.pointWise(sArr2, sArr3, sArr5);
        C6087Poly.m17750add(sArr5, sArr4, sArr5);
        short[] sArr6 = new short[1024];
        C6087Poly.pointWise(sArr, sArr3, sArr6);
        C6087Poly.m17751fromNTT(sArr6);
        short[] sArr7 = new short[1024];
        C6087Poly.getNoise(sArr7, bArr5, (byte) 2);
        C6087Poly.m17750add(sArr6, sArr7, sArr6);
        short[] sArr8 = new short[1024];
        ErrorCorrection.m17735helpRec(sArr8, sArr6, bArr5, (byte) 3);
        m17745encodeB(bArr2, sArr5, sArr8);
        ErrorCorrection.m17736rec(bArr, sArr6, sArr8);
        m17747sha3(bArr);
    }
}
