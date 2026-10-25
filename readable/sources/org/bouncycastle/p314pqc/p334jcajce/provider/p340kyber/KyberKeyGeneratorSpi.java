package org.bouncycastle.p314pqc.p334jcajce.provider.p340kyber;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.DestroyFailedException;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.p207kems.MLKEMExtractor;
import org.bouncycastle.p194crypto.p207kems.MLKEMGenerator;
import org.bouncycastle.p194crypto.p213params.MLKEMParameters;
import org.bouncycastle.p249jcajce.SecretKeyWithEncapsulation;
import org.bouncycastle.p249jcajce.p279spec.KEMExtractSpec;
import org.bouncycastle.p249jcajce.p279spec.KEMGenerateSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class KyberKeyGeneratorSpi extends KeyGeneratorSpi {

    /* renamed from: extSpec */
    private KEMExtractSpec f23766extSpec;

    /* renamed from: genSpec */
    private KEMGenerateSpec f23767genSpec;
    private MLKEMParameters kyberParameters;

    /* renamed from: random */
    private SecureRandom f23768random;

    public static class Kyber1024 extends KyberKeyGeneratorSpi {
        public Kyber1024() {
            super(MLKEMParameters.ml_kem_1024);
        }
    }

    public static class Kyber512 extends KyberKeyGeneratorSpi {
        public Kyber512() {
            super(MLKEMParameters.ml_kem_512);
        }
    }

    public static class Kyber768 extends KyberKeyGeneratorSpi {
        public Kyber768() {
            super(MLKEMParameters.ml_kem_768);
        }
    }

    public KyberKeyGeneratorSpi() {
        this(null);
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public SecretKey engineGenerateKey() throws DestroyFailedException {
        KEMGenerateSpec kEMGenerateSpec = this.f23767genSpec;
        if (kEMGenerateSpec == null) {
            MLKEMExtractor mLKEMExtractor = new MLKEMExtractor(((BCKyberPrivateKey) this.f23766extSpec.getPrivateKey()).getKeyParams());
            byte[] encapsulation = this.f23766extSpec.getEncapsulation();
            byte[] bArrExtractSecret = mLKEMExtractor.extractSecret(encapsulation);
            byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArrExtractSecret, 0, (this.f23766extSpec.getKeySize() + 7) / 8);
            C6238Arrays.m18227clear(bArrExtractSecret);
            SecretKeyWithEncapsulation secretKeyWithEncapsulation = new SecretKeyWithEncapsulation(new SecretKeySpec(bArrCopyOfRange, this.f23766extSpec.getKeyAlgorithmName()), encapsulation);
            C6238Arrays.m18227clear(bArrCopyOfRange);
            return secretKeyWithEncapsulation;
        }
        SecretWithEncapsulation secretWithEncapsulationGenerateEncapsulated = new MLKEMGenerator(this.f23768random).generateEncapsulated(((BCKyberPublicKey) kEMGenerateSpec.getPublicKey()).getKeyParams());
        byte[] secret = secretWithEncapsulationGenerateEncapsulated.getSecret();
        byte[] bArrCopyOfRange2 = C6238Arrays.copyOfRange(secret, 0, (this.f23767genSpec.getKeySize() + 7) / 8);
        C6238Arrays.m18227clear(secret);
        SecretKeyWithEncapsulation secretKeyWithEncapsulation2 = new SecretKeyWithEncapsulation(new SecretKeySpec(bArrCopyOfRange2, this.f23767genSpec.getKeyAlgorithmName()), secretWithEncapsulationGenerateEncapsulated.getEncapsulation());
        try {
            secretWithEncapsulationGenerateEncapsulated.destroy();
            return secretKeyWithEncapsulation2;
        } catch (DestroyFailedException unused) {
            throw new IllegalStateException("key cleanup failed");
        }
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(int i, SecureRandom secureRandom) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public KyberKeyGeneratorSpi(MLKEMParameters mLKEMParameters) {
        this.kyberParameters = mLKEMParameters;
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(SecureRandom secureRandom) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.f23768random = secureRandom;
        if (algorithmParameterSpec instanceof KEMGenerateSpec) {
            this.f23767genSpec = (KEMGenerateSpec) algorithmParameterSpec;
            this.f23766extSpec = null;
            MLKEMParameters mLKEMParameters = this.kyberParameters;
            if (mLKEMParameters != null) {
                String upperCase = C6250Strings.toUpperCase(mLKEMParameters.m15790getName());
                if (upperCase.equals(this.f23767genSpec.getPublicKey().getAlgorithm())) {
                    return;
                }
                throw new InvalidAlgorithmParameterException("key generator locked to " + upperCase);
            }
            return;
        }
        if (!(algorithmParameterSpec instanceof KEMExtractSpec)) {
            throw new InvalidAlgorithmParameterException("unknown spec");
        }
        this.f23767genSpec = null;
        this.f23766extSpec = (KEMExtractSpec) algorithmParameterSpec;
        MLKEMParameters mLKEMParameters2 = this.kyberParameters;
        if (mLKEMParameters2 != null) {
            String upperCase2 = C6250Strings.toUpperCase(mLKEMParameters2.m15790getName());
            if (upperCase2.equals(this.f23766extSpec.getPrivateKey().getAlgorithm())) {
                return;
            }
            throw new InvalidAlgorithmParameterException("key generator locked to " + upperCase2);
        }
    }
}
