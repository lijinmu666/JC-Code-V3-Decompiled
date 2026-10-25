package org.bouncycastle.p194crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.BasicAgreement;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.MQVPrivateParameters;
import org.bouncycastle.p194crypto.p213params.MQVPublicParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p361util.Properties;

/* loaded from: classes2.dex */
public class ECMQVBasicAgreement implements BasicAgreement {
    MQVPrivateParameters privParams;

    private AbstractC5820ECPoint calculateMqvAgreement(ECDomainParameters eCDomainParameters, ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters, ECPublicKeyParameters eCPublicKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters3) {
        BigInteger bigIntegerM15723getN = eCDomainParameters.m15723getN();
        int iBitLength = (bigIntegerM15723getN.bitLength() + 1) / 2;
        BigInteger bigIntegerShiftLeft = ECConstants.f22091ONE.shiftLeft(iBitLength);
        AbstractC5817ECCurve curve = eCDomainParameters.getCurve();
        AbstractC5820ECPoint abstractC5820ECPointCleanPoint = ECAlgorithms.cleanPoint(curve, eCPublicKeyParameters.m15728getQ());
        AbstractC5820ECPoint abstractC5820ECPointCleanPoint2 = ECAlgorithms.cleanPoint(curve, eCPublicKeyParameters2.m15728getQ());
        AbstractC5820ECPoint abstractC5820ECPointCleanPoint3 = ECAlgorithms.cleanPoint(curve, eCPublicKeyParameters3.m15728getQ());
        BigInteger bigIntegerMod = eCPrivateKeyParameters.m15727getD().multiply(abstractC5820ECPointCleanPoint.getAffineXCoord().toBigInteger().mod(bigIntegerShiftLeft).setBit(iBitLength)).add(eCPrivateKeyParameters2.m15727getD()).mod(bigIntegerM15723getN);
        BigInteger bit = abstractC5820ECPointCleanPoint3.getAffineXCoord().toBigInteger().mod(bigIntegerShiftLeft).setBit(iBitLength);
        BigInteger bigIntegerMod2 = eCDomainParameters.m15721getH().multiply(bigIntegerMod).mod(bigIntegerM15723getN);
        return ECAlgorithms.sumOfTwoMultiplies(abstractC5820ECPointCleanPoint2, bit.multiply(bigIntegerMod2).mod(bigIntegerM15723getN), abstractC5820ECPointCleanPoint3, bigIntegerMod2);
    }

    @Override // org.bouncycastle.p194crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        if (Properties.isOverrideSet("org.bouncycastle.ec.disable_mqv")) {
            throw new IllegalStateException("ECMQV explicitly disabled");
        }
        MQVPublicParameters mQVPublicParameters = (MQVPublicParameters) cipherParameters;
        ECPrivateKeyParameters staticPrivateKey = this.privParams.getStaticPrivateKey();
        ECDomainParameters parameters = staticPrivateKey.getParameters();
        if (!parameters.m15719equals(mQVPublicParameters.getStaticPublicKey().getParameters())) {
            throw new IllegalStateException("ECMQV public key components have wrong domain parameters");
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = calculateMqvAgreement(parameters, staticPrivateKey, this.privParams.getEphemeralPrivateKey(), this.privParams.getEphemeralPublicKey(), mQVPublicParameters.getStaticPublicKey(), mQVPublicParameters.getEphemeralPublicKey()).normalize();
        if (abstractC5820ECPointNormalize.isInfinity()) {
            throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
        }
        return abstractC5820ECPointNormalize.getAffineXCoord().toBigInteger();
    }

    @Override // org.bouncycastle.p194crypto.BasicAgreement
    public int getFieldSize() {
        return this.privParams.getStaticPrivateKey().getParameters().getCurve().getFieldElementEncodingLength();
    }

    @Override // org.bouncycastle.p194crypto.BasicAgreement
    /* renamed from: init */
    public void mo14945init(CipherParameters cipherParameters) {
        MQVPrivateParameters mQVPrivateParameters = (MQVPrivateParameters) cipherParameters;
        this.privParams = mQVPrivateParameters;
        CryptoServicesRegistrar.checkConstraints(C5285Utils.getDefaultProperties("ECMQV", mQVPrivateParameters.getStaticPrivateKey()));
    }
}
