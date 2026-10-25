package org.bouncycastle.p194crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.BasicAgreement;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.p213params.DHMQVPrivateParameters;
import org.bouncycastle.p194crypto.p213params.DHMQVPublicParameters;
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p194crypto.p213params.DHPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.DHPublicKeyParameters;

/* loaded from: classes2.dex */
public class MQVBasicAgreement implements BasicAgreement {

    /* renamed from: ONE */
    private static final BigInteger f19157ONE = BigInteger.valueOf(1);
    DHMQVPrivateParameters privParams;

    private BigInteger calculateDHMQVAgreement(DHParameters dHParameters, DHPrivateKeyParameters dHPrivateKeyParameters, DHPublicKeyParameters dHPublicKeyParameters, DHPrivateKeyParameters dHPrivateKeyParameters2, DHPublicKeyParameters dHPublicKeyParameters2, DHPublicKeyParameters dHPublicKeyParameters3) {
        BigInteger bigIntegerM15696getQ = dHParameters.m15696getQ();
        BigInteger bigIntegerPow = BigInteger.valueOf(2L).pow((bigIntegerM15696getQ.bitLength() + 1) / 2);
        return dHPublicKeyParameters3.m15698getY().multiply(dHPublicKeyParameters.m15698getY().modPow(dHPublicKeyParameters3.m15698getY().mod(bigIntegerPow).add(bigIntegerPow), dHParameters.m15695getP())).modPow(dHPrivateKeyParameters2.m15697getX().add(dHPublicKeyParameters2.m15698getY().mod(bigIntegerPow).add(bigIntegerPow).multiply(dHPrivateKeyParameters.m15697getX())).mod(bigIntegerM15696getQ), dHParameters.m15695getP());
    }

    @Override // org.bouncycastle.p194crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        DHMQVPublicParameters dHMQVPublicParameters = (DHMQVPublicParameters) cipherParameters;
        DHPrivateKeyParameters staticPrivateKey = this.privParams.getStaticPrivateKey();
        if (!this.privParams.getStaticPrivateKey().getParameters().m15690equals(dHMQVPublicParameters.getStaticPublicKey().getParameters())) {
            throw new IllegalStateException("MQV public key components have wrong domain parameters");
        }
        if (this.privParams.getStaticPrivateKey().getParameters().m15696getQ() == null) {
            throw new IllegalStateException("MQV key domain parameters do not have Q set");
        }
        BigInteger bigIntegerCalculateDHMQVAgreement = calculateDHMQVAgreement(staticPrivateKey.getParameters(), staticPrivateKey, dHMQVPublicParameters.getStaticPublicKey(), this.privParams.getEphemeralPrivateKey(), this.privParams.getEphemeralPublicKey(), dHMQVPublicParameters.getEphemeralPublicKey());
        if (bigIntegerCalculateDHMQVAgreement.equals(f19157ONE)) {
            throw new IllegalStateException("1 is not a valid agreement value for MQV");
        }
        return bigIntegerCalculateDHMQVAgreement;
    }

    @Override // org.bouncycastle.p194crypto.BasicAgreement
    public int getFieldSize() {
        return (this.privParams.getStaticPrivateKey().getParameters().m15695getP().bitLength() + 7) / 8;
    }

    @Override // org.bouncycastle.p194crypto.BasicAgreement
    /* renamed from: init */
    public void mo14945init(CipherParameters cipherParameters) {
        DHMQVPrivateParameters dHMQVPrivateParameters = (DHMQVPrivateParameters) cipherParameters;
        this.privParams = dHMQVPrivateParameters;
        CryptoServicesRegistrar.checkConstraints(C5285Utils.getDefaultProperties("MQV", dHMQVPrivateParameters.getStaticPrivateKey()));
    }
}
