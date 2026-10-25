package org.bouncycastle.p194crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithUKM;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ECVKOAgreement {

    /* renamed from: digest */
    private final InterfaceC5277Digest f19154digest;

    /* renamed from: key */
    private ECPrivateKeyParameters f19155key;

    /* renamed from: ukm */
    private BigInteger f19156ukm;

    public ECVKOAgreement(InterfaceC5277Digest interfaceC5277Digest) {
        this.f19154digest = interfaceC5277Digest;
    }

    public byte[] calculateAgreement(CipherParameters cipherParameters) {
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) cipherParameters;
        ECDomainParameters parameters = this.f19155key.getParameters();
        if (!parameters.m15719equals(eCPublicKeyParameters.getParameters())) {
            throw new IllegalStateException("ECVKO public key has wrong domain parameters");
        }
        BigInteger bigIntegerMod = parameters.m15721getH().multiply(this.f19156ukm).multiply(this.f19155key.m15727getD()).mod(parameters.m15723getN());
        AbstractC5820ECPoint abstractC5820ECPointCleanPoint = ECAlgorithms.cleanPoint(parameters.getCurve(), eCPublicKeyParameters.m15728getQ());
        if (abstractC5820ECPointCleanPoint.isInfinity()) {
            throw new IllegalStateException("Infinity is not a valid public key for ECVKO");
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = abstractC5820ECPointCleanPoint.multiply(bigIntegerMod).normalize();
        if (abstractC5820ECPointNormalize.isInfinity()) {
            throw new IllegalStateException("Infinity is not a valid agreement value for ECVKO");
        }
        byte[] encoded = abstractC5820ECPointNormalize.getEncoded(false);
        int length = encoded.length;
        int i = length / 2;
        int i2 = i * 2;
        int i3 = length - i2;
        C6238Arrays.reverseInPlace(encoded, i3, i);
        C6238Arrays.reverseInPlace(encoded, length - i, i);
        byte[] bArr = new byte[this.f19154digest.getDigestSize()];
        this.f19154digest.mo14970update(encoded, i3, i2);
        this.f19154digest.mo14967doFinal(bArr, 0);
        return bArr;
    }

    public int getAgreementSize() {
        return this.f19154digest.getDigestSize();
    }

    public int getFieldSize() {
        return this.f19155key.getParameters().getCurve().getFieldElementEncodingLength();
    }

    /* renamed from: init */
    public void m15003init(CipherParameters cipherParameters) {
        ParametersWithUKM parametersWithUKM = (ParametersWithUKM) cipherParameters;
        this.f19155key = (ECPrivateKeyParameters) parametersWithUKM.getParameters();
        this.f19156ukm = new BigInteger(1, C6238Arrays.m18267reverse(parametersWithUKM.m15804getUKM()));
        CryptoServicesRegistrar.checkConstraints(C5285Utils.getDefaultProperties("ECVKO", this.f19155key));
    }
}
