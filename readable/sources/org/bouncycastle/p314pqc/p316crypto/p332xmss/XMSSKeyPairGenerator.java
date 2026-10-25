package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.OTSHashAddress;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSPublicKeyParameters;

/* loaded from: classes2.dex */
public final class XMSSKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: params */
    private XMSSParameters f23619params;

    /* renamed from: prng */
    private SecureRandom f23620prng;

    private XMSSPrivateKeyParameters generatePrivateKey(XMSSParameters xMSSParameters, SecureRandom secureRandom) {
        int treeDigestSize = xMSSParameters.getTreeDigestSize();
        byte[] bArr = new byte[treeDigestSize];
        secureRandom.nextBytes(bArr);
        byte[] bArr2 = new byte[treeDigestSize];
        secureRandom.nextBytes(bArr2);
        byte[] bArr3 = new byte[treeDigestSize];
        secureRandom.nextBytes(bArr3);
        return new XMSSPrivateKeyParameters.C6126Builder(xMSSParameters).withSecretKeySeed(bArr).withSecretKeyPRF(bArr2).withPublicSeed(bArr3).withBDSState(new C6108BDS(xMSSParameters, bArr3, bArr, (OTSHashAddress) new OTSHashAddress.C6114Builder().mo17893build())).m17927build();
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        XMSSPrivateKeyParameters xMSSPrivateKeyParametersGeneratePrivateKey = generatePrivateKey(this.f23619params, this.f23620prng);
        XMSSNode xMSSNodeM17880getRoot = xMSSPrivateKeyParametersGeneratePrivateKey.getBDSState().m17880getRoot();
        XMSSPrivateKeyParameters xMSSPrivateKeyParametersM17927build = new XMSSPrivateKeyParameters.C6126Builder(this.f23619params).withSecretKeySeed(xMSSPrivateKeyParametersGeneratePrivateKey.getSecretKeySeed()).withSecretKeyPRF(xMSSPrivateKeyParametersGeneratePrivateKey.getSecretKeyPRF()).withPublicSeed(xMSSPrivateKeyParametersGeneratePrivateKey.getPublicSeed()).withRoot(xMSSNodeM17880getRoot.getValue()).withBDSState(xMSSPrivateKeyParametersGeneratePrivateKey.getBDSState()).m17927build();
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new XMSSPublicKeyParameters.C6128Builder(this.f23619params).withRoot(xMSSNodeM17880getRoot.getValue()).withPublicSeed(xMSSPrivateKeyParametersM17927build.getPublicSeed()).m17929build(), (AsymmetricKeyParameter) xMSSPrivateKeyParametersM17927build);
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        XMSSKeyGenerationParameters xMSSKeyGenerationParameters = (XMSSKeyGenerationParameters) keyGenerationParameters;
        this.f23620prng = xMSSKeyGenerationParameters.getRandom();
        this.f23619params = xMSSKeyGenerationParameters.getParameters();
    }
}
