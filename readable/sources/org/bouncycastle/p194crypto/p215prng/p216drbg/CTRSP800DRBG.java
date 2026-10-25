package org.bouncycastle.p194crypto.p215prng.p216drbg;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p215prng.EntropySource;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;
import org.bouncycastle.p361util.encoders.C6255Hex;
import p094kotlin.C1126UByte;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public class CTRSP800DRBG implements SP80090DRBG {
    private static final int AES_MAX_BITS_REQUEST = 262144;
    private static final long AES_RESEED_MAX = 140737488355328L;

    /* renamed from: K_BITS */
    private static final byte[] f20899K_BITS = C6255Hex.decodeStrict("000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F");
    private static final int TDEA_MAX_BITS_REQUEST = 4096;
    private static final long TDEA_RESEED_MAX = 2147483648L;

    /* renamed from: _Key */
    private byte[] f20900_Key;

    /* renamed from: _V */
    private byte[] f20901_V;

    /* renamed from: _engine */
    private BlockCipher f20902_engine;
    private EntropySource _entropySource;

    /* renamed from: _isTDEA */
    private boolean f20903_isTDEA;
    private int _keySizeInBits;
    private long _reseedCounter = 0;
    private int _securityStrength;
    private int _seedLength;

    public CTRSP800DRBG(BlockCipher blockCipher, int i, int i2, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        this.f20903_isTDEA = false;
        this._entropySource = entropySource;
        this.f20902_engine = blockCipher;
        this._keySizeInBits = i;
        this._securityStrength = i2;
        this._seedLength = (blockCipher.getBlockSize() * 8) + i;
        this.f20903_isTDEA = m15843isTDEA(blockCipher);
        if (i2 > 256) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        }
        if (getMaxSecurityStrength(blockCipher, i) < i2) {
            throw new IllegalArgumentException("Requested security strength is not supported by block cipher and key size");
        }
        if (entropySource.entropySize() < i2) {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
        CTR_DRBG_Instantiate_algorithm(getEntropy(), bArr2, bArr);
    }

    /* renamed from: BCC */
    private void m15842BCC(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int blockSize = this.f20902_engine.getBlockSize();
        byte[] bArr5 = new byte[blockSize];
        int length = bArr4.length / blockSize;
        byte[] bArr6 = new byte[blockSize];
        this.f20902_engine.mo14946init(true, new KeyParameter(expandKey(bArr2)));
        this.f20902_engine.processBlock(bArr3, 0, bArr5, 0);
        for (int i = 0; i < length; i++) {
            C6240Bytes.m18274xor(blockSize, bArr5, 0, bArr4, i * blockSize, bArr6, 0);
            this.f20902_engine.processBlock(bArr6, 0, bArr5, 0);
        }
        System.arraycopy(bArr5, 0, bArr, 0, bArr.length);
    }

    private byte[] Block_Cipher_df(byte[] bArr, int i) {
        int blockSize = this.f20902_engine.getBlockSize();
        int length = bArr.length;
        int i2 = i / 8;
        byte[] bArr2 = new byte[((((length + 9) + blockSize) - 1) / blockSize) * blockSize];
        copyIntToByteArray(bArr2, length, 0);
        copyIntToByteArray(bArr2, i2, 4);
        System.arraycopy(bArr, 0, bArr2, 8, length);
        bArr2[length + 8] = ByteCompanionObject.MIN_VALUE;
        int i3 = this._keySizeInBits;
        int i4 = (i3 / 8) + blockSize;
        byte[] bArr3 = new byte[i4];
        byte[] bArr4 = new byte[blockSize];
        byte[] bArr5 = new byte[blockSize];
        int i5 = i3 / 8;
        byte[] bArr6 = new byte[i5];
        System.arraycopy(f20899K_BITS, 0, bArr6, 0, i5);
        int i6 = 0;
        while (true) {
            int i7 = i6 * blockSize;
            if (i7 * 8 >= this._keySizeInBits + (blockSize * 8)) {
                break;
            }
            copyIntToByteArray(bArr5, i6, 0);
            m15842BCC(bArr4, bArr6, bArr5, bArr2);
            int i8 = i4 - i7;
            if (i8 > blockSize) {
                i8 = blockSize;
            }
            System.arraycopy(bArr4, 0, bArr3, i7, i8);
            i6++;
        }
        byte[] bArr7 = new byte[blockSize];
        System.arraycopy(bArr3, 0, bArr6, 0, i5);
        System.arraycopy(bArr3, i5, bArr7, 0, blockSize);
        byte[] bArr8 = new byte[i2];
        this.f20902_engine.mo14946init(true, new KeyParameter(expandKey(bArr6)));
        int i9 = 0;
        while (true) {
            int i10 = i9 * blockSize;
            if (i10 >= i2) {
                return bArr8;
            }
            this.f20902_engine.processBlock(bArr7, 0, bArr7, 0);
            int i11 = i2 - i10;
            if (i11 > blockSize) {
                i11 = blockSize;
            }
            System.arraycopy(bArr7, 0, bArr8, i10, i11);
            i9++;
        }
    }

    private void CTR_DRBG_Instantiate_algorithm(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArrBlock_Cipher_df = Block_Cipher_df(C6238Arrays.concatenate(bArr, bArr2, bArr3), this._seedLength);
        int blockSize = this.f20902_engine.getBlockSize();
        byte[] bArr4 = new byte[(this._keySizeInBits + 7) / 8];
        this.f20900_Key = bArr4;
        byte[] bArr5 = new byte[blockSize];
        this.f20901_V = bArr5;
        CTR_DRBG_Update(bArrBlock_Cipher_df, bArr4, bArr5);
        this._reseedCounter = 1L;
    }

    private void CTR_DRBG_Reseed_algorithm(byte[] bArr) {
        CTR_DRBG_Update(Block_Cipher_df(C6238Arrays.concatenate(getEntropy(), bArr), this._seedLength), this.f20900_Key, this.f20901_V);
        this._reseedCounter = 1L;
    }

    private void CTR_DRBG_Update(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int length = bArr.length;
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[this.f20902_engine.getBlockSize()];
        int blockSize = this.f20902_engine.getBlockSize();
        this.f20902_engine.mo14946init(true, new KeyParameter(expandKey(bArr2)));
        int i = 0;
        while (true) {
            int i2 = i * blockSize;
            if (i2 >= bArr.length) {
                C6240Bytes.m18281xorTo(bArr.length, bArr, bArr4);
                System.arraycopy(bArr4, 0, bArr2, 0, bArr2.length);
                System.arraycopy(bArr4, bArr2.length, bArr3, 0, bArr3.length);
                return;
            } else {
                addOneTo(bArr3);
                this.f20902_engine.processBlock(bArr3, 0, bArr5, 0);
                int i3 = length - i2;
                if (i3 > blockSize) {
                    i3 = blockSize;
                }
                System.arraycopy(bArr5, 0, bArr4, i2, i3);
                i++;
            }
        }
    }

    private void addOneTo(byte[] bArr) {
        int i = 1;
        for (int i2 = 1; i2 <= bArr.length; i2++) {
            int i3 = (bArr[bArr.length - i2] & C1126UByte.MAX_VALUE) + i;
            i = i3 > 255 ? 1 : 0;
            bArr[bArr.length - i2] = (byte) i3;
        }
    }

    private void copyIntToByteArray(byte[] bArr, int i, int i2) {
        bArr[i2] = (byte) (i >> 24);
        bArr[i2 + 1] = (byte) (i >> 16);
        bArr[i2 + 2] = (byte) (i >> 8);
        bArr[i2 + 3] = (byte) i;
    }

    private byte[] getEntropy() {
        byte[] entropy = this._entropySource.getEntropy();
        if (entropy.length >= (this._securityStrength + 7) / 8) {
            return entropy;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    private int getMaxSecurityStrength(BlockCipher blockCipher, int i) {
        if (m15843isTDEA(blockCipher) && i == 168) {
            return 112;
        }
        if (blockCipher.getAlgorithmName().equals("AES")) {
            return i;
        }
        return -1;
    }

    /* renamed from: isTDEA */
    private boolean m15843isTDEA(BlockCipher blockCipher) {
        return blockCipher.getAlgorithmName().equals("DESede") || blockCipher.getAlgorithmName().equals("TDEA");
    }

    /* renamed from: padKey */
    private void m15844padKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        bArr2[i2] = (byte) (bArr[i] & 254);
        int i3 = i + 1;
        bArr2[i2 + 1] = (byte) ((bArr[i] << 7) | ((bArr[i3] & 252) >>> 1));
        int i4 = bArr[i3] << 6;
        int i5 = i + 2;
        bArr2[i2 + 2] = (byte) (i4 | ((bArr[i5] & 248) >>> 2));
        int i6 = bArr[i5] << 5;
        int i7 = i + 3;
        bArr2[i2 + 3] = (byte) (i6 | ((bArr[i7] & 240) >>> 3));
        int i8 = bArr[i7] << 4;
        int i9 = i + 4;
        bArr2[i2 + 4] = (byte) (i8 | ((bArr[i9] & 224) >>> 4));
        int i10 = bArr[i9] << 3;
        int i11 = i + 5;
        bArr2[i2 + 5] = (byte) (i10 | ((bArr[i11] & 192) >>> 5));
        int i12 = i + 6;
        bArr2[i2 + 6] = (byte) ((bArr[i11] << 2) | ((bArr[i12] & ByteCompanionObject.MIN_VALUE) >>> 6));
        int i13 = i2 + 7;
        bArr2[i13] = (byte) (bArr[i12] << 1);
        while (i2 <= i13) {
            byte b = bArr2[i2];
            bArr2[i2] = (byte) (((((b >> 7) ^ ((((((b >> 1) ^ (b >> 2)) ^ (b >> 3)) ^ (b >> 4)) ^ (b >> 5)) ^ (b >> 6))) ^ 1) & 1) | (b & 254));
            i2++;
        }
    }

    public byte[] expandKey(byte[] bArr) {
        if (!this.f20903_isTDEA) {
            return bArr;
        }
        byte[] bArr2 = new byte[24];
        m15844padKey(bArr, 0, bArr2, 0);
        m15844padKey(bArr, 7, bArr2, 8);
        m15844padKey(bArr, 14, bArr2, 16);
        return bArr2;
    }

    @Override // org.bouncycastle.p194crypto.p215prng.p216drbg.SP80090DRBG
    public int generate(byte[] bArr, byte[] bArr2, boolean z) {
        byte[] bArrBlock_Cipher_df;
        boolean z2 = this.f20903_isTDEA;
        long j = this._reseedCounter;
        if (z2) {
            if (j > TDEA_RESEED_MAX) {
                return -1;
            }
            if (C5379Utils.isTooLarge(bArr, 512)) {
                throw new IllegalArgumentException("Number of bits per request limited to 4096");
            }
        } else {
            if (j > AES_RESEED_MAX) {
                return -1;
            }
            if (C5379Utils.isTooLarge(bArr, 32768)) {
                throw new IllegalArgumentException("Number of bits per request limited to 262144");
            }
        }
        if (z) {
            CTR_DRBG_Reseed_algorithm(bArr2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            bArrBlock_Cipher_df = Block_Cipher_df(bArr2, this._seedLength);
            CTR_DRBG_Update(bArrBlock_Cipher_df, this.f20900_Key, this.f20901_V);
        } else {
            bArrBlock_Cipher_df = new byte[this._seedLength / 8];
        }
        int length = this.f20901_V.length;
        byte[] bArr3 = new byte[length];
        this.f20902_engine.mo14946init(true, new KeyParameter(expandKey(this.f20900_Key)));
        for (int i = 0; i <= bArr.length / length; i++) {
            int i2 = i * length;
            int length2 = bArr.length - i2 > length ? length : bArr.length - (this.f20901_V.length * i);
            if (length2 != 0) {
                addOneTo(this.f20901_V);
                this.f20902_engine.processBlock(this.f20901_V, 0, bArr3, 0);
                System.arraycopy(bArr3, 0, bArr, i2, length2);
            }
        }
        CTR_DRBG_Update(bArrBlock_Cipher_df, this.f20900_Key, this.f20901_V);
        this._reseedCounter++;
        return bArr.length * 8;
    }

    @Override // org.bouncycastle.p194crypto.p215prng.p216drbg.SP80090DRBG
    public int getBlockSize() {
        return this.f20901_V.length * 8;
    }

    @Override // org.bouncycastle.p194crypto.p215prng.p216drbg.SP80090DRBG
    /* renamed from: reseed */
    public void mo15845reseed(byte[] bArr) {
        CTR_DRBG_Reseed_algorithm(bArr);
    }
}
