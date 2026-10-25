package org.bouncycastle.p194crypto.p215prng;

import org.bouncycastle.p194crypto.BlockCipher;

/* renamed from: org.bouncycastle.crypto.prng.X931RNG */
/* loaded from: classes2.dex */
public class C5378X931RNG {
    private static final int BLOCK128_MAX_BITS_REQUEST = 262144;
    private static final long BLOCK128_RESEED_MAX = 8388608;
    private static final int BLOCK64_MAX_BITS_REQUEST = 4096;
    private static final long BLOCK64_RESEED_MAX = 32768;

    /* renamed from: DT */
    private final byte[] f20892DT;

    /* renamed from: I */
    private final byte[] f20893I;

    /* renamed from: R */
    private final byte[] f20894R;

    /* renamed from: V */
    private byte[] f20895V;

    /* renamed from: engine */
    private final BlockCipher f20896engine;
    private final EntropySource entropySource;
    private long reseedCounter = 1;

    public C5378X931RNG(BlockCipher blockCipher, byte[] bArr, EntropySource entropySource) {
        this.f20896engine = blockCipher;
        this.entropySource = entropySource;
        byte[] bArr2 = new byte[blockCipher.getBlockSize()];
        this.f20892DT = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.f20893I = new byte[blockCipher.getBlockSize()];
        this.f20894R = new byte[blockCipher.getBlockSize()];
    }

    private void increment(byte[] bArr) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            byte b = (byte) (bArr[length] + 1);
            bArr[length] = b;
            if (b != 0) {
                return;
            }
        }
    }

    private static boolean isTooLarge(byte[] bArr, int i) {
        return bArr != null && bArr.length > i;
    }

    /* renamed from: process */
    private void m15839process(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = (byte) (bArr2[i] ^ bArr3[i]);
        }
        this.f20896engine.processBlock(bArr, 0, bArr, 0);
    }

    public int generate(byte[] bArr, boolean z) {
        int length = this.f20894R.length;
        long j = this.reseedCounter;
        if (length == 8) {
            if (j > BLOCK64_RESEED_MAX) {
                return -1;
            }
            if (isTooLarge(bArr, 512)) {
                throw new IllegalArgumentException("Number of bits per request limited to 4096");
            }
        } else {
            if (j > BLOCK128_RESEED_MAX) {
                return -1;
            }
            if (isTooLarge(bArr, 32768)) {
                throw new IllegalArgumentException("Number of bits per request limited to 262144");
            }
        }
        if (z || this.f20895V == null) {
            byte[] entropy = this.entropySource.getEntropy();
            this.f20895V = entropy;
            if (entropy.length != this.f20896engine.getBlockSize()) {
                throw new IllegalStateException("Insufficient entropy returned");
            }
        }
        int length2 = bArr.length / this.f20894R.length;
        for (int i = 0; i < length2; i++) {
            this.f20896engine.processBlock(this.f20892DT, 0, this.f20893I, 0);
            m15839process(this.f20894R, this.f20893I, this.f20895V);
            m15839process(this.f20895V, this.f20894R, this.f20893I);
            byte[] bArr2 = this.f20894R;
            System.arraycopy(bArr2, 0, bArr, bArr2.length * i, bArr2.length);
            increment(this.f20892DT);
        }
        int length3 = bArr.length - (this.f20894R.length * length2);
        if (length3 > 0) {
            this.f20896engine.processBlock(this.f20892DT, 0, this.f20893I, 0);
            m15839process(this.f20894R, this.f20893I, this.f20895V);
            m15839process(this.f20895V, this.f20894R, this.f20893I);
            byte[] bArr3 = this.f20894R;
            System.arraycopy(bArr3, 0, bArr, length2 * bArr3.length, length3);
            increment(this.f20892DT);
        }
        this.reseedCounter++;
        return bArr.length * 8;
    }

    public EntropySource getEntropySource() {
        return this.entropySource;
    }

    /* renamed from: reseed */
    public void m15840reseed() {
        byte[] entropy = this.entropySource.getEntropy();
        this.f20895V = entropy;
        if (entropy.length != this.f20896engine.getBlockSize()) {
            throw new IllegalStateException("Insufficient entropy returned");
        }
        this.reseedCounter = 1L;
    }
}
