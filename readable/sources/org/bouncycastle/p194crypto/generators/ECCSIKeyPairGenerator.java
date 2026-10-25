package org.bouncycastle.p194crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ECCSIKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.ECCSIPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECCSIPublicKeyParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class ECCSIKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: G */
    private AbstractC5820ECPoint f20233G;

    /* renamed from: digest */
    private InterfaceC5277Digest f20234digest;
    private ECCSIKeyGenerationParameters parameters;

    /* renamed from: q */
    private BigInteger f20235q;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        SecureRandom random = this.parameters.getRandom();
        this.f20234digest.mo14968reset();
        byte[] bArrM15713getId = this.parameters.m15713getId();
        AbstractC5820ECPoint abstractC5820ECPointM15714getKPAK = this.parameters.m15714getKPAK();
        BigInteger bigIntegerMod = BigIntegers.createRandomBigInteger(256, random).mod(this.f20235q);
        AbstractC5820ECPoint abstractC5820ECPointNormalize = this.f20233G.multiply(bigIntegerMod).normalize();
        byte[] encoded = this.f20233G.getEncoded(false);
        this.f20234digest.mo14970update(encoded, 0, encoded.length);
        byte[] encoded2 = abstractC5820ECPointM15714getKPAK.getEncoded(false);
        this.f20234digest.mo14970update(encoded2, 0, encoded2.length);
        this.f20234digest.mo14970update(bArrM15713getId, 0, bArrM15713getId.length);
        byte[] encoded3 = abstractC5820ECPointNormalize.getEncoded(false);
        this.f20234digest.mo14970update(encoded3, 0, encoded3.length);
        byte[] bArr = new byte[this.f20234digest.getDigestSize()];
        this.f20234digest.mo14967doFinal(bArr, 0);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new ECCSIPublicKeyParameters(abstractC5820ECPointNormalize), (AsymmetricKeyParameter) new ECCSIPrivateKeyParameters(this.parameters.computeSSK(new BigInteger(1, bArr).mod(this.f20235q).multiply(bigIntegerMod)), new ECCSIPublicKeyParameters(abstractC5820ECPointNormalize)));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        ECCSIKeyGenerationParameters eCCSIKeyGenerationParameters = (ECCSIKeyGenerationParameters) keyGenerationParameters;
        this.parameters = eCCSIKeyGenerationParameters;
        this.f20235q = eCCSIKeyGenerationParameters.m15716getQ();
        this.f20233G = this.parameters.m15712getG();
        this.f20234digest = this.parameters.getDigest();
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("ECCSI", this.parameters.m15715getN(), null, CryptoServicePurpose.KEYGEN));
    }
}
