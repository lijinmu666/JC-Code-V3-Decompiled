package org.bouncycastle.p314pqc.p334jcajce.provider.p341lms;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.HSSKeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.HSSKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.p321lms.HSSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.HSSPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMOtsParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSKeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSigParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.LMSHSSKeyGenParameterSpec;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.LMSHSSParameterSpec;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.LMSKeyGenParameterSpec;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.LMSParameterSpec;

/* loaded from: classes2.dex */
public class LMSKeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: engine */
    private AsymmetricCipherKeyPairGenerator f23772engine;
    private boolean initialised;

    /* renamed from: param */
    private KeyGenerationParameters f23773param;

    /* renamed from: random */
    private SecureRandom f23774random;
    private ASN1ObjectIdentifier treeDigest;

    public LMSKeyPairGeneratorSpi() {
        super("LMS");
        this.f23772engine = new LMSKeyPairGenerator();
        this.f23774random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            LMSKeyGenerationParameters lMSKeyGenerationParameters = new LMSKeyGenerationParameters(new LMSParameters(LMSigParameters.lms_sha256_n32_h10, LMOtsParameters.sha256_n32_w2), this.f23774random);
            this.f23773param = lMSKeyGenerationParameters;
            this.f23772engine.mo14944init(lMSKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23772engine.generateKeyPair();
        if (this.f23772engine instanceof LMSKeyPairGenerator) {
            return new KeyPair(new BCLMSPublicKey((LMSPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCLMSPrivateKey((LMSPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
        }
        return new KeyPair(new BCLMSPublicKey((HSSPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCLMSPrivateKey((HSSPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        AsymmetricCipherKeyPairGenerator hSSKeyPairGenerator;
        if (algorithmParameterSpec instanceof LMSKeyGenParameterSpec) {
            LMSKeyGenParameterSpec lMSKeyGenParameterSpec = (LMSKeyGenParameterSpec) algorithmParameterSpec;
            this.f23773param = new LMSKeyGenerationParameters(new LMSParameters(lMSKeyGenParameterSpec.getSigParams(), lMSKeyGenParameterSpec.getOtsParams()), secureRandom);
            hSSKeyPairGenerator = new LMSKeyPairGenerator();
        } else {
            int i = 0;
            if (algorithmParameterSpec instanceof LMSHSSKeyGenParameterSpec) {
                LMSKeyGenParameterSpec[] lMSSpecs = ((LMSHSSKeyGenParameterSpec) algorithmParameterSpec).getLMSSpecs();
                LMSParameters[] lMSParametersArr = new LMSParameters[lMSSpecs.length];
                while (i != lMSSpecs.length) {
                    lMSParametersArr[i] = new LMSParameters(lMSSpecs[i].getSigParams(), lMSSpecs[i].getOtsParams());
                    i++;
                }
                this.f23773param = new HSSKeyGenerationParameters(lMSParametersArr, secureRandom);
                hSSKeyPairGenerator = new HSSKeyPairGenerator();
            } else if (algorithmParameterSpec instanceof LMSParameterSpec) {
                LMSParameterSpec lMSParameterSpec = (LMSParameterSpec) algorithmParameterSpec;
                this.f23773param = new LMSKeyGenerationParameters(new LMSParameters(lMSParameterSpec.getSigParams(), lMSParameterSpec.getOtsParams()), secureRandom);
                hSSKeyPairGenerator = new LMSKeyPairGenerator();
            } else {
                if (!(algorithmParameterSpec instanceof LMSHSSParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("parameter object not a LMSParameterSpec/LMSHSSParameterSpec");
                }
                LMSParameterSpec[] lMSSpecs2 = ((LMSHSSParameterSpec) algorithmParameterSpec).getLMSSpecs();
                LMSParameters[] lMSParametersArr2 = new LMSParameters[lMSSpecs2.length];
                while (i != lMSSpecs2.length) {
                    lMSParametersArr2[i] = new LMSParameters(lMSSpecs2[i].getSigParams(), lMSSpecs2[i].getOtsParams());
                    i++;
                }
                this.f23773param = new HSSKeyGenerationParameters(lMSParametersArr2, secureRandom);
                hSSKeyPairGenerator = new HSSKeyPairGenerator();
            }
        }
        this.f23772engine = hSSKeyPairGenerator;
        hSSKeyPairGenerator.mo14944init(this.f23773param);
        this.initialised = true;
    }
}
