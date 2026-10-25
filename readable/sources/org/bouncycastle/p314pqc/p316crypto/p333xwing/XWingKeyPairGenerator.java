package org.bouncycastle.p314pqc.p316crypto.p333xwing;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.generators.MLKEMKeyPairGenerator;
import org.bouncycastle.p194crypto.generators.X25519KeyPairGenerator;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.MLKEMKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.X25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519PublicKeyParameters;
import org.bouncycastle.p194crypto.p215prng.FixedSecureRandom;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class XWingKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: random */
    private SecureRandom f23677random;

    public static AsymmetricCipherKeyPair genKeyPair(byte[] bArr) {
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.mo14970update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[96];
        sHAKEDigest.doOutput(bArr2, 0, 96);
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr2, 0, 64);
        byte[] bArrCopyOfRange2 = C6238Arrays.copyOfRange(bArr2, 64, 96);
        FixedSecureRandom fixedSecureRandom = new FixedSecureRandom(bArrCopyOfRange);
        MLKEMKeyPairGenerator mLKEMKeyPairGenerator = new MLKEMKeyPairGenerator();
        mLKEMKeyPairGenerator.mo14944init(new MLKEMKeyGenerationParameters(fixedSecureRandom, MLKEMParameters.ml_kem_768));
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = mLKEMKeyPairGenerator.generateKeyPair();
        MLKEMPublicKeyParameters mLKEMPublicKeyParameters = (MLKEMPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic();
        MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters = (MLKEMPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate();
        FixedSecureRandom fixedSecureRandom2 = new FixedSecureRandom(bArrCopyOfRange2);
        X25519KeyPairGenerator x25519KeyPairGenerator = new X25519KeyPairGenerator();
        x25519KeyPairGenerator.mo14944init(new X25519KeyGenerationParameters(fixedSecureRandom2));
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair2 = x25519KeyPairGenerator.generateKeyPair();
        X25519PublicKeyParameters x25519PublicKeyParameters = (X25519PublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair2.getPublic();
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new XWingPublicKeyParameters(mLKEMPublicKeyParameters, x25519PublicKeyParameters), (AsymmetricKeyParameter) new XWingPrivateKeyParameters(bArr, mLKEMPrivateKeyParameters, (X25519PrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair2.getPrivate(), mLKEMPublicKeyParameters, x25519PublicKeyParameters));
    }

    private void initialize(KeyGenerationParameters keyGenerationParameters) {
        this.f23677random = keyGenerationParameters.getRandom();
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        byte[] bArr = new byte[32];
        this.f23677random.nextBytes(bArr);
        return genKeyPair(bArr);
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }
}
