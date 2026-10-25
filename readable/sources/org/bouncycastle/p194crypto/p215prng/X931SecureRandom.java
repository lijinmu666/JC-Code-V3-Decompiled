package org.bouncycastle.p194crypto.p215prng;

import java.security.SecureRandom;

/* loaded from: classes2.dex */
public class X931SecureRandom extends SecureRandom {

    /* renamed from: drbg */
    private final C5378X931RNG f20897drbg;
    private final boolean predictionResistant;
    private final SecureRandom randomSource;

    public X931SecureRandom(SecureRandom secureRandom, C5378X931RNG c5378x931rng, boolean z) {
        this.randomSource = secureRandom;
        this.f20897drbg = c5378x931rng;
        this.predictionResistant = z;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i) {
        return EntropyUtil.generateSeed(this.f20897drbg.getEntropySource(), i);
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        synchronized (this) {
            try {
                if (this.f20897drbg.generate(bArr, this.predictionResistant) < 0) {
                    this.f20897drbg.m15840reseed();
                    this.f20897drbg.generate(bArr, this.predictionResistant);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void setSeed(long j) {
        synchronized (this) {
            try {
                SecureRandom secureRandom = this.randomSource;
                if (secureRandom != null) {
                    secureRandom.setSeed(j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.security.SecureRandom
    public void setSeed(byte[] bArr) {
        synchronized (this) {
            try {
                SecureRandom secureRandom = this.randomSource;
                if (secureRandom != null) {
                    secureRandom.setSeed(bArr);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
