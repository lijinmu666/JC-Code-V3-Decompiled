package org.bouncycastle.p249jcajce.provider.symmetric.p277util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class BaseKeyGenerator extends KeyGeneratorSpi {

    /* renamed from: algName */
    protected String f21865algName;
    protected int defaultKeySize;

    /* renamed from: engine */
    protected CipherKeyGenerator f21866engine;

    /* renamed from: keySize */
    protected int f21867keySize;
    protected boolean uninitialised = true;

    public BaseKeyGenerator(String str, int i, CipherKeyGenerator cipherKeyGenerator) {
        this.f21865algName = str;
        this.defaultKeySize = i;
        this.f21867keySize = i;
        this.f21866engine = cipherKeyGenerator;
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public SecretKey engineGenerateKey() {
        if (this.uninitialised) {
            this.f21866engine.mo14956init(new KeyGenerationParameters(CryptoServicesRegistrar.getSecureRandom(), this.defaultKeySize));
            this.uninitialised = false;
        }
        return new SecretKeySpec(this.f21866engine.generateKey(), this.f21865algName);
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(int i, SecureRandom secureRandom) {
        if (secureRandom == null) {
            try {
                secureRandom = CryptoServicesRegistrar.getSecureRandom();
            } catch (IllegalArgumentException e) {
                throw new InvalidParameterException(e.getMessage());
            }
        }
        this.f21866engine.mo14956init(new KeyGenerationParameters(secureRandom, i));
        this.uninitialised = false;
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(SecureRandom secureRandom) {
        if (secureRandom != null) {
            this.f21866engine.mo14956init(new KeyGenerationParameters(secureRandom, this.defaultKeySize));
            this.uninitialised = false;
        }
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("Not Implemented");
    }
}
