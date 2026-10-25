package org.bouncycastle.p194crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.StagedAgreement;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;

/* loaded from: classes2.dex */
public class ECDHCStagedAgreement implements StagedAgreement {

    /* renamed from: key */
    ECPrivateKeyParameters f19153key;

    private AbstractC5820ECPoint calculateNextPoint(ECPublicKeyParameters eCPublicKeyParameters) {
        ECDomainParameters parameters = this.f19153key.getParameters();
        if (!parameters.m15719equals(eCPublicKeyParameters.getParameters())) {
            throw new IllegalStateException("ECDHC public key has wrong domain parameters");
        }
        BigInteger bigIntegerMod = parameters.m15721getH().multiply(this.f19153key.m15727getD()).mod(parameters.m15723getN());
        AbstractC5820ECPoint abstractC5820ECPointCleanPoint = ECAlgorithms.cleanPoint(parameters.getCurve(), eCPublicKeyParameters.m15728getQ());
        if (abstractC5820ECPointCleanPoint.isInfinity()) {
            throw new IllegalStateException("Infinity is not a valid public key for ECDHC");
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = abstractC5820ECPointCleanPoint.multiply(bigIntegerMod).normalize();
        if (abstractC5820ECPointNormalize.isInfinity()) {
            throw new IllegalStateException("Infinity is not a valid agreement value for ECDHC");
        }
        return abstractC5820ECPointNormalize;
    }

    @Override // org.bouncycastle.p194crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        return calculateNextPoint((ECPublicKeyParameters) cipherParameters).getAffineXCoord().toBigInteger();
    }

    @Override // org.bouncycastle.p194crypto.StagedAgreement
    public AsymmetricKeyParameter calculateStage(CipherParameters cipherParameters) {
        return new ECPublicKeyParameters(calculateNextPoint((ECPublicKeyParameters) cipherParameters), this.f19153key.getParameters());
    }

    @Override // org.bouncycastle.p194crypto.BasicAgreement
    public int getFieldSize() {
        return this.f19153key.getParameters().getCurve().getFieldElementEncodingLength();
    }

    @Override // org.bouncycastle.p194crypto.BasicAgreement
    /* renamed from: init */
    public void mo14945init(CipherParameters cipherParameters) {
        ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) cipherParameters;
        this.f19153key = eCPrivateKeyParameters;
        CryptoServicesRegistrar.checkConstraints(C5285Utils.getDefaultProperties("ECCDH", eCPrivateKeyParameters));
    }
}
