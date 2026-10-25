package org.bouncycastle.p314pqc.p316crypto.p330sphincs;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p314pqc.p316crypto.MessageSigner;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.C6102Tree;
import org.bouncycastle.p361util.AbstractC6245Pack;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class SPHINCS256Signer implements MessageSigner {
    private final HashFunctions hashFunctions;

    /* renamed from: keyData */
    private byte[] f23577keyData;

    public SPHINCS256Signer(InterfaceC5277Digest interfaceC5277Digest, InterfaceC5277Digest interfaceC5277Digest2) {
        if (interfaceC5277Digest.getDigestSize() != 32) {
            throw new IllegalArgumentException("n-digest needs to produce 32 bytes of output");
        }
        if (interfaceC5277Digest2.getDigestSize() != 64) {
            throw new IllegalArgumentException("2n-digest needs to produce 64 bytes of output");
        }
        this.hashFunctions = new HashFunctions(interfaceC5277Digest, interfaceC5277Digest2);
    }

    public static void compute_authpath_wots(HashFunctions hashFunctions, byte[] bArr, byte[] bArr2, int i, C6102Tree.leafaddr leafaddrVar, byte[] bArr3, byte[] bArr4, int i2) {
        C6102Tree.leafaddr leafaddrVar2 = new C6102Tree.leafaddr(leafaddrVar);
        byte[] bArr5 = new byte[2048];
        byte[] bArr6 = new byte[1024];
        byte[] bArr7 = new byte[68608];
        leafaddrVar2.f23581subleaf = 0L;
        while (true) {
            long j = leafaddrVar2.f23581subleaf;
            if (j >= 32) {
                break;
            }
            C6101Seed.get_seed(hashFunctions, bArr6, (int) (j * 32), bArr3, leafaddrVar2);
            leafaddrVar2.f23581subleaf++;
        }
        C6103Wots c6103Wots = new C6103Wots();
        leafaddrVar2.f23581subleaf = 0L;
        while (true) {
            long j2 = leafaddrVar2.f23581subleaf;
            if (j2 >= 32) {
                break;
            }
            c6103Wots.wots_pkgen(hashFunctions, bArr7, (int) (j2 * 2144), bArr6, (int) (j2 * 32), bArr4, 0);
            leafaddrVar2.f23581subleaf++;
        }
        leafaddrVar2.f23581subleaf = 0L;
        while (true) {
            long j3 = leafaddrVar2.f23581subleaf;
            if (j3 >= 32) {
                break;
            }
            C6102Tree.m17875l_tree(hashFunctions, bArr5, (int) ((j3 * 32) + 1024), bArr7, (int) (j3 * 2144), bArr4, 0);
            leafaddrVar2.f23581subleaf++;
        }
        int i3 = 0;
        for (int i4 = 32; i4 > 0; i4 >>>= 1) {
            for (int i5 = 0; i5 < i4; i5 += 2) {
                hashFunctions.hash_2n_n_mask(bArr5, ((i4 >>> 1) * 32) + ((i5 >>> 1) * 32), bArr5, (i4 * 32) + (i5 * 32), bArr4, (i3 + 7) * 64);
            }
            i3++;
        }
        int i6 = (int) leafaddrVar.f23581subleaf;
        for (int i7 = 0; i7 < i2; i7++) {
            System.arraycopy(bArr5, ((32 >>> i7) * 32) + (((i6 >>> i7) ^ 1) * 32), bArr2, i + (i7 * 32), 32);
        }
        System.arraycopy(bArr5, 32, bArr, 0, 32);
    }

    public static void validate_authpath(HashFunctions hashFunctions, byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2, byte[] bArr4, int i3) {
        byte[] bArr5 = new byte[64];
        if ((i & 1) != 0) {
            for (int i4 = 0; i4 < 32; i4++) {
                bArr5[i4 + 32] = bArr2[i4];
            }
            for (int i5 = 0; i5 < 32; i5++) {
                bArr5[i5] = bArr3[i2 + i5];
            }
        } else {
            for (int i6 = 0; i6 < 32; i6++) {
                bArr5[i6] = bArr2[i6];
            }
            for (int i7 = 0; i7 < 32; i7++) {
                bArr5[i7 + 32] = bArr3[i2 + i7];
            }
        }
        int i8 = i2 + 32;
        int i9 = 0;
        int i10 = i;
        while (i9 < i3 - 1) {
            int i11 = i10 >>> 1;
            if ((i11 & 1) != 0) {
                hashFunctions.hash_2n_n_mask(bArr5, 32, bArr5, 0, bArr4, (i9 + 7) * 64);
                for (int i12 = 0; i12 < 32; i12++) {
                    bArr5[i12] = bArr3[i8 + i12];
                }
            } else {
                hashFunctions.hash_2n_n_mask(bArr5, 0, bArr5, 0, bArr4, (i9 + 7) * 64);
                for (int i13 = 0; i13 < 32; i13++) {
                    bArr5[i13 + 32] = bArr3[i8 + i13];
                }
            }
            i8 += 32;
            i9++;
            i10 = i11;
        }
        hashFunctions.hash_2n_n_mask(bArr, 0, bArr5, 0, bArr4, (i3 + 6) * 64);
    }

    private void zerobytes(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 != i2; i3++) {
            bArr[i + i3] = 0;
        }
    }

    public byte[] crypto_sign(HashFunctions hashFunctions, byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[41000];
        byte[] bArr4 = new byte[32];
        byte[] bArr5 = new byte[64];
        long[] jArr = new long[8];
        byte[] bArr6 = new byte[32];
        byte[] bArr7 = new byte[32];
        byte[] bArr8 = new byte[1024];
        byte[] bArr9 = new byte[1088];
        for (int i = 0; i < 1088; i++) {
            bArr9[i] = bArr2[i];
        }
        System.arraycopy(bArr9, 1056, bArr3, 40968, 32);
        InterfaceC5277Digest messageHash = hashFunctions.getMessageHash();
        byte[] bArr10 = new byte[messageHash.getDigestSize()];
        messageHash.mo14970update(bArr3, 40968, 32);
        messageHash.mo14970update(bArr, 0, bArr.length);
        messageHash.mo14967doFinal(bArr10, 0);
        zerobytes(bArr3, 40968, 32);
        for (int i2 = 0; i2 != 8; i2++) {
            jArr[i2] = AbstractC6245Pack.littleEndianToLong(bArr10, i2 * 8);
        }
        long j = jArr[0] & 1152921504606846975L;
        System.arraycopy(bArr10, 16, bArr4, 0, 32);
        System.arraycopy(bArr4, 0, bArr3, 39912, 32);
        C6102Tree.leafaddr leafaddrVar = new C6102Tree.leafaddr();
        leafaddrVar.f23580level = 11;
        leafaddrVar.f23582subtree = 0L;
        leafaddrVar.f23581subleaf = 0L;
        System.arraycopy(bArr9, 32, bArr3, 39944, 1024);
        C6102Tree.treehash(hashFunctions, bArr3, 40968, 5, bArr9, leafaddrVar, bArr3, 39944);
        InterfaceC5277Digest messageHash2 = hashFunctions.getMessageHash();
        messageHash2.mo14970update(bArr3, 39912, 1088);
        messageHash2.mo14970update(bArr, 0, bArr.length);
        messageHash2.mo14967doFinal(bArr5, 0);
        C6102Tree.leafaddr leafaddrVar2 = new C6102Tree.leafaddr();
        leafaddrVar2.f23580level = 12;
        leafaddrVar2.f23581subleaf = (int) (r19 & 31);
        leafaddrVar2.f23582subtree = j >>> 5;
        for (int i3 = 0; i3 < 32; i3++) {
            bArr3[i3] = bArr4[i3];
        }
        byte[] bArr11 = bArr8;
        System.arraycopy(bArr9, 32, bArr11, 0, 1024);
        for (int i4 = 0; i4 < 8; i4++) {
            bArr3[32 + i4] = (byte) ((j >>> (i4 * 8)) & 255);
        }
        C6101Seed.get_seed(hashFunctions, bArr7, 0, bArr9, leafaddrVar2);
        new C6099Horst();
        int iHorst_sign = 40 + C6099Horst.horst_sign(hashFunctions, bArr3, 40, bArr6, bArr7, bArr11, bArr5);
        C6103Wots c6103Wots = new C6103Wots();
        int i5 = iHorst_sign;
        int i6 = 0;
        for (int i7 = 12; i6 < i7; i7 = 12) {
            leafaddrVar2.f23580level = i6;
            C6101Seed.get_seed(hashFunctions, bArr7, 0, bArr9, leafaddrVar2);
            int i8 = i5;
            int i9 = i6;
            byte[] bArr12 = bArr11;
            c6103Wots.wots_sign(hashFunctions, bArr3, i5, bArr6, bArr7, bArr12);
            compute_authpath_wots(hashFunctions, bArr6, bArr3, i8 + 2144, leafaddrVar2, bArr9, bArr12, 5);
            i5 = i8 + 2304;
            long j2 = leafaddrVar2.f23582subtree;
            leafaddrVar2.f23581subleaf = (int) (j2 & 31);
            leafaddrVar2.f23582subtree = j2 >>> 5;
            i6 = i9 + 1;
            bArr11 = bArr11;
        }
        zerobytes(bArr9, 0, 1088);
        return bArr3;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        return crypto_sign(this.hashFunctions, bArr, this.f23577keyData);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    /* renamed from: init */
    public void mo15864init(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.f23577keyData = ((SPHINCSPublicKeyParameters) cipherParameters).getKeyData();
        } else if (cipherParameters instanceof ParametersWithRandom) {
            this.f23577keyData = ((SPHINCSPrivateKeyParameters) ((ParametersWithRandom) cipherParameters).getParameters()).getKeyData();
        } else {
            this.f23577keyData = ((SPHINCSPrivateKeyParameters) cipherParameters).getKeyData();
        }
    }

    /* renamed from: verify */
    public boolean m17873verify(HashFunctions hashFunctions, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[2144];
        byte[] bArr5 = new byte[32];
        byte[] bArr6 = new byte[32];
        byte[] bArr7 = new byte[41000];
        byte[] bArr8 = new byte[1056];
        if (bArr2.length != 41000) {
            throw new IllegalArgumentException("signature wrong size");
        }
        byte[] bArr9 = new byte[64];
        for (int i = 0; i < 1056; i++) {
            bArr8[i] = bArr3[i];
        }
        byte[] bArr10 = new byte[32];
        for (int i2 = 0; i2 < 32; i2++) {
            bArr10[i2] = bArr2[i2];
        }
        System.arraycopy(bArr2, 0, bArr7, 0, 41000);
        InterfaceC5277Digest messageHash = hashFunctions.getMessageHash();
        messageHash.mo14970update(bArr10, 0, 32);
        messageHash.mo14970update(bArr8, 0, 1056);
        messageHash.mo14970update(bArr, 0, bArr.length);
        messageHash.mo14967doFinal(bArr9, 0);
        long j = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            j ^= (bArr7[32 + i3] & C1126UByte.MAX_VALUE) << (i3 * 8);
        }
        new C6099Horst();
        C6099Horst.horst_verify(hashFunctions, bArr6, bArr7, 40, bArr8, bArr9);
        C6103Wots c6103Wots = new C6103Wots();
        int i4 = 0;
        int i5 = 13352;
        while (i4 < 12) {
            int i6 = i5;
            c6103Wots.wots_verify(hashFunctions, bArr4, bArr7, i5, bArr6, bArr8);
            C6102Tree.m17875l_tree(hashFunctions, bArr5, 0, bArr4, 0, bArr8, 0);
            byte[] bArr11 = bArr8;
            byte[] bArr12 = bArr7;
            validate_authpath(hashFunctions, bArr6, bArr5, (int) (31 & j), bArr12, i6 + 2144, bArr11, 5);
            j >>= 5;
            i5 = i6 + 2304;
            i4++;
            bArr8 = bArr11;
            bArr7 = bArr12;
            bArr6 = bArr6;
            bArr5 = bArr5;
        }
        byte[] bArr13 = bArr8;
        byte[] bArr14 = bArr6;
        boolean z = true;
        for (int i7 = 0; i7 < 32; i7++) {
            z &= bArr14[i7] == bArr13[i7 + 1024];
        }
        return z;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        return m17873verify(this.hashFunctions, bArr, bArr2, this.f23577keyData);
    }
}
