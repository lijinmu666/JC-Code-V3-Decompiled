package org.bouncycastle.p314pqc.p316crypto.p318falcon;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
class FalconNIST {
    final int CRYPTO_BYTES;
    private final int CRYPTO_PUBLICKEYBYTES;
    private final int CRYPTO_SECRETKEYBYTES;

    /* renamed from: LOGN */
    final int f23119LOGN;

    /* renamed from: N */
    private final int f23120N;
    final int NONCELEN;

    /* renamed from: rand */
    private final SecureRandom f23121rand;

    public FalconNIST(int i, int i2, SecureRandom secureRandom) {
        int i3;
        int i4;
        this.f23121rand = secureRandom;
        this.f23119LOGN = i;
        this.NONCELEN = i2;
        int i5 = 1 << i;
        this.f23120N = i5;
        this.CRYPTO_PUBLICKEYBYTES = ((i5 * 14) / 8) + 1;
        if (i == 10) {
            this.CRYPTO_SECRETKEYBYTES = 2305;
            this.CRYPTO_BYTES = 1330;
            return;
        }
        if (i == 9 || i == 8) {
            i3 = i5 * 12;
        } else {
            if (i != 7 && i != 6) {
                i4 = i5 * 2;
                this.CRYPTO_SECRETKEYBYTES = i4 + 1 + i5;
                this.CRYPTO_BYTES = 690;
            }
            i3 = i5 * 14;
        }
        i4 = i3 / 8;
        this.CRYPTO_SECRETKEYBYTES = i4 + 1 + i5;
        this.CRYPTO_BYTES = 690;
    }

    public byte[] crypto_sign(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) {
        int i2 = this.f23120N;
        byte[] bArr4 = new byte[i2];
        byte[] bArr5 = new byte[i2];
        byte[] bArr6 = new byte[i2];
        byte[] bArr7 = new byte[i2];
        short[] sArr = new short[i2];
        short[] sArr2 = new short[i2];
        byte[] bArr8 = new byte[48];
        byte[] bArr9 = new byte[this.NONCELEN];
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        FalconSign falconSign = new FalconSign();
        int i3 = this.f23119LOGN;
        byte[] bArr10 = FalconCodec.max_fg_bits;
        int iTrim_i8_decode = FalconCodec.trim_i8_decode(bArr4, i3, bArr10[i3], bArr3, 0, this.CRYPTO_SECRETKEYBYTES);
        if (iTrim_i8_decode == 0) {
            throw new IllegalStateException("f decode failed");
        }
        int i4 = this.f23119LOGN;
        int iTrim_i8_decode2 = FalconCodec.trim_i8_decode(bArr5, i4, bArr10[i4], bArr3, iTrim_i8_decode, this.CRYPTO_SECRETKEYBYTES - iTrim_i8_decode);
        if (iTrim_i8_decode2 == 0) {
            throw new IllegalStateException("g decode failed");
        }
        int i5 = iTrim_i8_decode + iTrim_i8_decode2;
        int i6 = this.f23119LOGN;
        int iTrim_i8_decode3 = FalconCodec.trim_i8_decode(bArr6, i6, FalconCodec.max_FG_bits[i6], bArr3, i5, this.CRYPTO_SECRETKEYBYTES - i5);
        if (iTrim_i8_decode3 == 0) {
            throw new IllegalArgumentException("F decode failed");
        }
        if (i5 + iTrim_i8_decode3 != this.CRYPTO_SECRETKEYBYTES - 1) {
            throw new IllegalStateException("full key not used");
        }
        if (!FalconVrfy.complete_private(bArr7, bArr4, bArr5, bArr6, this.f23119LOGN, new short[this.f23120N * 2])) {
            throw new IllegalStateException("complete_private failed");
        }
        this.f23121rand.nextBytes(bArr9);
        sHAKEDigest.mo14970update(bArr9, 0, this.NONCELEN);
        sHAKEDigest.mo14970update(bArr2, 0, i);
        FalconCommon.hash_to_point_vartime(sHAKEDigest, sArr2, this.f23119LOGN);
        this.f23121rand.nextBytes(bArr8);
        sHAKEDigest.mo14968reset();
        sHAKEDigest.mo14970update(bArr8, 0, 48);
        falconSign.sign_dyn(sArr, sHAKEDigest, bArr4, bArr5, bArr6, bArr7, sArr2, this.f23119LOGN, new double[this.f23120N * 10]);
        int i7 = (this.CRYPTO_BYTES - 2) - this.NONCELEN;
        byte[] bArr11 = new byte[i7];
        int iComp_encode = FalconCodec.comp_encode(bArr11, i7, sArr, this.f23119LOGN);
        if (iComp_encode == 0) {
            throw new IllegalStateException("signature failed to generate");
        }
        bArr[0] = (byte) (this.f23119LOGN + 48);
        System.arraycopy(bArr9, 0, bArr, 1, this.NONCELEN);
        System.arraycopy(bArr11, 0, bArr, this.NONCELEN + 1, iComp_encode);
        return C6238Arrays.copyOfRange(bArr, 0, this.NONCELEN + 1 + iComp_encode);
    }

    public byte[][] crypto_sign_keypair(byte[] bArr, byte[] bArr2) {
        int i = this.f23120N;
        byte[] bArr3 = new byte[i];
        byte[] bArr4 = new byte[i];
        byte[] bArr5 = new byte[i];
        short[] sArr = new short[i];
        byte[] bArr6 = new byte[48];
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        this.f23121rand.nextBytes(bArr6);
        sHAKEDigest.mo14970update(bArr6, 0, 48);
        FalconKeyGen.m17541keygen(sHAKEDigest, bArr3, bArr4, bArr5, sArr, this.f23119LOGN);
        int i2 = this.f23119LOGN;
        bArr2[0] = (byte) (i2 + 80);
        int i3 = this.CRYPTO_SECRETKEYBYTES - 1;
        byte[] bArr7 = FalconCodec.max_fg_bits;
        int iTrim_i8_encode = FalconCodec.trim_i8_encode(bArr2, 1, i3, bArr3, i2, bArr7[i2]);
        if (iTrim_i8_encode == 0) {
            throw new IllegalStateException("f encode failed");
        }
        int i4 = iTrim_i8_encode + 1;
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr2, 1, i4);
        int i5 = this.CRYPTO_SECRETKEYBYTES - i4;
        int i6 = this.f23119LOGN;
        int iTrim_i8_encode2 = FalconCodec.trim_i8_encode(bArr2, i4, i5, bArr4, i6, bArr7[i6]);
        if (iTrim_i8_encode2 == 0) {
            throw new IllegalStateException("g encode failed");
        }
        int i7 = i4 + iTrim_i8_encode2;
        byte[] bArrCopyOfRange2 = C6238Arrays.copyOfRange(bArr2, i4, i7);
        int i8 = this.CRYPTO_SECRETKEYBYTES - i7;
        int i9 = this.f23119LOGN;
        int iTrim_i8_encode3 = FalconCodec.trim_i8_encode(bArr2, i7, i8, bArr5, i9, FalconCodec.max_FG_bits[i9]);
        if (iTrim_i8_encode3 == 0) {
            throw new IllegalStateException("F encode failed");
        }
        int i10 = iTrim_i8_encode3 + i7;
        byte[] bArrCopyOfRange3 = C6238Arrays.copyOfRange(bArr2, i7, i10);
        if (i10 != this.CRYPTO_SECRETKEYBYTES) {
            throw new IllegalStateException("secret key encoding failed");
        }
        int i11 = this.f23119LOGN;
        bArr[0] = (byte) i11;
        if (FalconCodec.modq_encode(bArr, this.CRYPTO_PUBLICKEYBYTES - 1, sArr, i11) == this.CRYPTO_PUBLICKEYBYTES - 1) {
            return new byte[][]{C6238Arrays.copyOfRange(bArr, 1, bArr.length), bArrCopyOfRange, bArrCopyOfRange2, bArrCopyOfRange3};
        }
        throw new IllegalStateException("public key encoding failed");
    }

    public int crypto_sign_open(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int i = this.f23120N;
        short[] sArr = new short[i];
        short[] sArr2 = new short[i];
        short[] sArr3 = new short[i];
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        if (FalconCodec.modq_decode(sArr, this.f23119LOGN, bArr4, this.CRYPTO_PUBLICKEYBYTES - 1) != this.CRYPTO_PUBLICKEYBYTES - 1) {
            return -1;
        }
        FalconVrfy.to_ntt_monty(sArr, this.f23119LOGN);
        int length = bArr.length;
        int length2 = bArr3.length;
        if (length < 1 || FalconCodec.comp_decode(sArr3, this.f23119LOGN, bArr, length) != length) {
            return -1;
        }
        sHAKEDigest.mo14970update(bArr2, 0, this.NONCELEN);
        sHAKEDigest.mo14970update(bArr3, 0, length2);
        FalconCommon.hash_to_point_vartime(sHAKEDigest, sArr2, this.f23119LOGN);
        return FalconVrfy.verify_raw(sArr2, sArr3, sArr, this.f23119LOGN, new short[this.f23120N]) == 0 ? -1 : 0;
    }
}
