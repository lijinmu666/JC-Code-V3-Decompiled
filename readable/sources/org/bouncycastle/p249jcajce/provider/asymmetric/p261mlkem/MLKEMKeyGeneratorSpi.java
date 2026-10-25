package org.bouncycastle.p249jcajce.provider.asymmetric.p261mlkem;

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
import org.bouncycastle.p249jcajce.p279spec.MLKEMParameterSpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5620KdfUtil;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class MLKEMKeyGeneratorSpi extends KeyGeneratorSpi {

    /* renamed from: extSpec */
    private KEMExtractSpec f21586extSpec;

    /* renamed from: genSpec */
    private KEMGenerateSpec f21587genSpec;
    private final MLKEMParameters mlkemParameters;

    /* renamed from: random */
    private SecureRandom f21588random;

    public static class MLKEM1024 extends MLKEMKeyGeneratorSpi {
        public MLKEM1024() {
            super(MLKEMParameters.ml_kem_1024);
        }
    }

    public static class MLKEM512 extends MLKEMKeyGeneratorSpi {
        public MLKEM512() {
            super(MLKEMParameters.ml_kem_512);
        }
    }

    public static class MLKEM768 extends MLKEMKeyGeneratorSpi {
        public MLKEM768() {
            super(MLKEMParameters.ml_kem_768);
        }
    }

    public MLKEMKeyGeneratorSpi() {
        this(null);
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public SecretKey engineGenerateKey() throws DestroyFailedException {
        KEMGenerateSpec kEMGenerateSpec = this.f21587genSpec;
        if (kEMGenerateSpec != null) {
            SecretWithEncapsulation secretWithEncapsulationGenerateEncapsulated = new MLKEMGenerator(this.f21588random).generateEncapsulated(((BCMLKEMPublicKey) kEMGenerateSpec.getPublicKey()).getKeyParams());
            try {
                return new SecretKeyWithEncapsulation(new SecretKeySpec(C5620KdfUtil.makeKeyBytes(this.f21587genSpec, secretWithEncapsulationGenerateEncapsulated.getSecret()), this.f21587genSpec.getKeyAlgorithmName()), secretWithEncapsulationGenerateEncapsulated.getEncapsulation());
            } finally {
                try {
                    secretWithEncapsulationGenerateEncapsulated.destroy();
                } catch (DestroyFailedException unused) {
                }
            }
        }
        MLKEMExtractor mLKEMExtractor = new MLKEMExtractor(((BCMLKEMPrivateKey) this.f21586extSpec.getPrivateKey()).getKeyParams());
        byte[] encapsulation = this.f21586extSpec.getEncapsulation();
        byte[] bArrMakeKeyBytes = C5620KdfUtil.makeKeyBytes(this.f21586extSpec, mLKEMExtractor.extractSecret(encapsulation));
        try {
            return new SecretKeyWithEncapsulation(new SecretKeySpec(bArrMakeKeyBytes, this.f21586extSpec.getKeyAlgorithmName()), encapsulation);
        } finally {
            C6238Arrays.m18227clear(bArrMakeKeyBytes);
        }
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(int i, SecureRandom secureRandom) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public MLKEMKeyGeneratorSpi(MLKEMParameters mLKEMParameters) {
        this.mlkemParameters = mLKEMParameters;
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(SecureRandom secureRandom) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.f21588random = secureRandom;
        if (algorithmParameterSpec instanceof KEMGenerateSpec) {
            this.f21587genSpec = (KEMGenerateSpec) algorithmParameterSpec;
            this.f21586extSpec = null;
            MLKEMParameters mLKEMParameters = this.mlkemParameters;
            if (mLKEMParameters != null) {
                String strM16208getName = MLKEMParameterSpec.fromName(mLKEMParameters.m15790getName()).m16208getName();
                if (strM16208getName.equals(this.f21587genSpec.getPublicKey().getAlgorithm())) {
                    return;
                }
                throw new InvalidAlgorithmParameterException("key generator locked to " + strM16208getName);
            }
            return;
        }
        if (!(algorithmParameterSpec instanceof KEMExtractSpec)) {
            throw new InvalidAlgorithmParameterException("unknown spec");
        }
        this.f21587genSpec = null;
        this.f21586extSpec = (KEMExtractSpec) algorithmParameterSpec;
        MLKEMParameters mLKEMParameters2 = this.mlkemParameters;
        if (mLKEMParameters2 != null) {
            String strM16208getName2 = MLKEMParameterSpec.fromName(mLKEMParameters2.m15790getName()).m16208getName();
            if (strM16208getName2.equals(this.f21586extSpec.getPrivateKey().getAlgorithm())) {
                return;
            }
            throw new InvalidAlgorithmParameterException("key generator locked to " + strM16208getName2);
        }
    }
}
