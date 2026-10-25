package org.bouncycastle.p194crypto.agreement;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.DHKeyPairGenerator;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.DHKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p194crypto.p213params.DHPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.DHPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;

/* loaded from: classes2.dex */
public class DHAgreement {

    /* renamed from: ONE */
    private static final BigInteger f19145ONE = BigInteger.valueOf(1);
    private DHParameters dhParams;

    /* renamed from: key */
    private DHPrivateKeyParameters f19146key;
    private BigInteger privateValue;

    /* renamed from: random */
    private SecureRandom f19147random;

    public BigInteger calculateAgreement(DHPublicKeyParameters dHPublicKeyParameters, BigInteger bigInteger) {
        if (!dHPublicKeyParameters.getParameters().m15690equals(this.dhParams)) {
            throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
        }
        BigInteger bigIntegerM15695getP = this.dhParams.m15695getP();
        BigInteger bigIntegerM15698getY = dHPublicKeyParameters.m15698getY();
        if (bigIntegerM15698getY != null) {
            BigInteger bigInteger2 = f19145ONE;
            if (bigIntegerM15698getY.compareTo(bigInteger2) > 0 && bigIntegerM15698getY.compareTo(bigIntegerM15695getP.subtract(bigInteger2)) < 0) {
                BigInteger bigIntegerModPow = bigIntegerM15698getY.modPow(this.privateValue, bigIntegerM15695getP);
                if (bigIntegerModPow.equals(bigInteger2)) {
                    throw new IllegalStateException("Shared key can't be 1");
                }
                return bigInteger.modPow(this.f19146key.m15697getX(), bigIntegerM15695getP).multiply(bigIntegerModPow).mod(bigIntegerM15695getP);
            }
        }
        throw new IllegalArgumentException("Diffie-Hellman public key is weak");
    }

    public BigInteger calculateMessage() {
        DHKeyPairGenerator dHKeyPairGenerator = new DHKeyPairGenerator();
        dHKeyPairGenerator.mo14944init(new DHKeyGenerationParameters(this.f19147random, this.dhParams));
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = dHKeyPairGenerator.generateKeyPair();
        this.privateValue = ((DHPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()).m15697getX();
        return ((DHPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()).m15698getY();
    }

    /* renamed from: init */
    public void m14999init(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f19147random = parametersWithRandom.getRandom();
            cipherParameters = parametersWithRandom.getParameters();
        } else {
            this.f19147random = CryptoServicesRegistrar.getSecureRandom();
        }
        AsymmetricKeyParameter asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        if (!(asymmetricKeyParameter instanceof DHPrivateKeyParameters)) {
            throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
        }
        DHPrivateKeyParameters dHPrivateKeyParameters = (DHPrivateKeyParameters) asymmetricKeyParameter;
        this.f19146key = dHPrivateKeyParameters;
        this.dhParams = dHPrivateKeyParameters.getParameters();
        CryptoServicesRegistrar.checkConstraints(C5285Utils.getDefaultProperties("DH", this.f19146key));
    }
}
