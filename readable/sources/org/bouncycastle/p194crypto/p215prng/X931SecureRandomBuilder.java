package org.bouncycastle.p194crypto.p215prng;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class X931SecureRandomBuilder {
    private byte[] dateTimeVector;
    private EntropySourceProvider entropySourceProvider;

    /* renamed from: random */
    private SecureRandom f20898random;

    public X931SecureRandomBuilder() {
        this(CryptoServicesRegistrar.getSecureRandom(), false);
    }

    /* renamed from: build */
    public X931SecureRandom m15841build(BlockCipher blockCipher, KeyParameter keyParameter, boolean z) {
        if (this.dateTimeVector == null) {
            this.dateTimeVector = new byte[blockCipher.getBlockSize()];
            AbstractC6245Pack.longToBigEndian(System.currentTimeMillis(), this.dateTimeVector, 0);
        }
        blockCipher.mo14946init(true, keyParameter);
        return new X931SecureRandom(this.f20898random, new C5378X931RNG(blockCipher, this.dateTimeVector, this.entropySourceProvider.mo15836get(blockCipher.getBlockSize() * 8)), z);
    }

    public X931SecureRandomBuilder setDateTimeVector(byte[] bArr) {
        this.dateTimeVector = C6238Arrays.m18231clone(bArr);
        return this;
    }

    public X931SecureRandomBuilder(SecureRandom secureRandom, boolean z) {
        this.f20898random = secureRandom;
        this.entropySourceProvider = new BasicEntropySourceProvider(secureRandom, z);
    }

    public X931SecureRandomBuilder(EntropySourceProvider entropySourceProvider) {
        this.f20898random = null;
        this.entropySourceProvider = entropySourceProvider;
    }
}
