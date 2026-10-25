package org.bouncycastle.p194crypto.p215prng;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.p215prng.p216drbg.SP80090DRBG;

/* loaded from: classes2.dex */
public class SP800SecureRandom extends SecureRandom {

    /* renamed from: drbg */
    private SP80090DRBG f20880drbg;
    private final DRBGProvider drbgProvider;
    private final EntropySource entropySource;
    private final boolean predictionResistant;
    private final SecureRandom randomSource;

    public SP800SecureRandom(SecureRandom secureRandom, EntropySource entropySource, DRBGProvider dRBGProvider, boolean z) {
        this.randomSource = secureRandom;
        this.entropySource = entropySource;
        this.drbgProvider = dRBGProvider;
        this.predictionResistant = z;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i) {
        return EntropyUtil.generateSeed(this.entropySource, i);
    }

    @Override // java.security.SecureRandom
    public String getAlgorithm() {
        return this.drbgProvider.getAlgorithm();
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        synchronized (this) {
            try {
                if (this.f20880drbg == null) {
                    this.f20880drbg = this.drbgProvider.mo15837get(this.entropySource);
                }
                if (this.f20880drbg.generate(bArr, null, this.predictionResistant) < 0) {
                    this.f20880drbg.mo15845reseed(null);
                    this.f20880drbg.generate(bArr, null, this.predictionResistant);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: reseed */
    public void m15838reseed(byte[] bArr) {
        synchronized (this) {
            try {
                if (this.f20880drbg == null) {
                    this.f20880drbg = this.drbgProvider.mo15837get(this.entropySource);
                }
                this.f20880drbg.mo15845reseed(bArr);
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
