package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.OTSHashAddress;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSMTPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSMTPublicKeyParameters;

/* loaded from: classes2.dex */
public final class XMSSMTKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: params */
    private XMSSMTParameters f23625params;

    /* renamed from: prng */
    private SecureRandom f23626prng;
    private XMSSParameters xmssParams;

    private XMSSMTPrivateKeyParameters generatePrivateKey(BDSStateMap bDSStateMap) {
        int treeDigestSize = this.f23625params.getTreeDigestSize();
        byte[] bArr = new byte[treeDigestSize];
        this.f23626prng.nextBytes(bArr);
        byte[] bArr2 = new byte[treeDigestSize];
        this.f23626prng.nextBytes(bArr2);
        byte[] bArr3 = new byte[treeDigestSize];
        this.f23626prng.nextBytes(bArr3);
        return new XMSSMTPrivateKeyParameters.C6119Builder(this.f23625params).withSecretKeySeed(bArr).withSecretKeyPRF(bArr2).withPublicSeed(bArr3).withBDSState(bDSStateMap).m17917build();
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParametersGeneratePrivateKey = generatePrivateKey(new XMSSMTPrivateKeyParameters.C6119Builder(this.f23625params).m17917build().getBDSState());
        this.xmssParams.getWOTSPlus().importKeys(new byte[this.f23625params.getTreeDigestSize()], xMSSMTPrivateKeyParametersGeneratePrivateKey.getPublicSeed());
        int layers = this.f23625params.getLayers() - 1;
        C6108BDS c6108bds = new C6108BDS(this.xmssParams, xMSSMTPrivateKeyParametersGeneratePrivateKey.getPublicSeed(), xMSSMTPrivateKeyParametersGeneratePrivateKey.getSecretKeySeed(), (OTSHashAddress) new OTSHashAddress.C6114Builder().withLayerAddress(layers).mo17893build());
        XMSSNode xMSSNodeM17880getRoot = c6108bds.m17880getRoot();
        xMSSMTPrivateKeyParametersGeneratePrivateKey.getBDSState().m17884put(layers, c6108bds);
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParametersM17917build = new XMSSMTPrivateKeyParameters.C6119Builder(this.f23625params).withSecretKeySeed(xMSSMTPrivateKeyParametersGeneratePrivateKey.getSecretKeySeed()).withSecretKeyPRF(xMSSMTPrivateKeyParametersGeneratePrivateKey.getSecretKeyPRF()).withPublicSeed(xMSSMTPrivateKeyParametersGeneratePrivateKey.getPublicSeed()).withRoot(xMSSNodeM17880getRoot.getValue()).withBDSState(xMSSMTPrivateKeyParametersGeneratePrivateKey.getBDSState()).m17917build();
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new XMSSMTPublicKeyParameters.C6121Builder(this.f23625params).withRoot(xMSSNodeM17880getRoot.getValue()).withPublicSeed(xMSSMTPrivateKeyParametersM17917build.getPublicSeed()).m17919build(), (AsymmetricKeyParameter) xMSSMTPrivateKeyParametersM17917build);
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        XMSSMTKeyGenerationParameters xMSSMTKeyGenerationParameters = (XMSSMTKeyGenerationParameters) keyGenerationParameters;
        this.f23626prng = xMSSMTKeyGenerationParameters.getRandom();
        XMSSMTParameters parameters = xMSSMTKeyGenerationParameters.getParameters();
        this.f23625params = parameters;
        this.xmssParams = parameters.getXMSSParameters();
    }
}
