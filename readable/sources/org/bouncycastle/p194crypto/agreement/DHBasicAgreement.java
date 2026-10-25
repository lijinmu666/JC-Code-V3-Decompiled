package org.bouncycastle.p194crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.BasicAgreement;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p194crypto.p213params.DHPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.DHPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;

/* loaded from: classes2.dex */
public class DHBasicAgreement implements BasicAgreement {

    /* renamed from: ONE */
    private static final BigInteger f19148ONE = BigInteger.valueOf(1);
    private DHParameters dhParams;

    /* renamed from: key */
    private DHPrivateKeyParameters f19149key;

    @Override // org.bouncycastle.p194crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        DHPublicKeyParameters dHPublicKeyParameters = (DHPublicKeyParameters) cipherParameters;
        if (!dHPublicKeyParameters.getParameters().m15690equals(this.dhParams)) {
            throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
        }
        BigInteger bigIntegerM15695getP = this.dhParams.m15695getP();
        BigInteger bigIntegerM15698getY = dHPublicKeyParameters.m15698getY();
        if (bigIntegerM15698getY != null) {
            BigInteger bigInteger = f19148ONE;
            if (bigIntegerM15698getY.compareTo(bigInteger) > 0 && bigIntegerM15698getY.compareTo(bigIntegerM15695getP.subtract(bigInteger)) < 0) {
                BigInteger bigIntegerModPow = bigIntegerM15698getY.modPow(this.f19149key.m15697getX(), bigIntegerM15695getP);
                if (bigIntegerModPow.equals(bigInteger)) {
                    throw new IllegalStateException("Shared key can't be 1");
                }
                return bigIntegerModPow;
            }
        }
        throw new IllegalArgumentException("Diffie-Hellman public key is weak");
    }

    @Override // org.bouncycastle.p194crypto.BasicAgreement
    public int getFieldSize() {
        return (this.f19149key.getParameters().m15695getP().bitLength() + 7) / 8;
    }

    @Override // org.bouncycastle.p194crypto.BasicAgreement
    /* renamed from: init */
    public void mo14945init(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        AsymmetricKeyParameter asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        if (!(asymmetricKeyParameter instanceof DHPrivateKeyParameters)) {
            throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
        }
        DHPrivateKeyParameters dHPrivateKeyParameters = (DHPrivateKeyParameters) asymmetricKeyParameter;
        this.f19149key = dHPrivateKeyParameters;
        this.dhParams = dHPrivateKeyParameters.getParameters();
        CryptoServicesRegistrar.checkConstraints(C5285Utils.getDefaultProperties("DHB", this.f19149key));
    }
}
