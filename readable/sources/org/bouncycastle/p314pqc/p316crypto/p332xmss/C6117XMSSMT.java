package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSMTPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSMTPublicKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSMT */
/* loaded from: classes2.dex */
public final class C6117XMSSMT {

    /* renamed from: params */
    private XMSSMTParameters f23623params;
    private XMSSMTPrivateKeyParameters privateKey;

    /* renamed from: prng */
    private SecureRandom f23624prng;
    private XMSSMTPublicKeyParameters publicKey;
    private XMSSParameters xmssParams;

    public C6117XMSSMT(XMSSMTParameters xMSSMTParameters, SecureRandom secureRandom) {
        if (xMSSMTParameters == null) {
            throw new NullPointerException("params == null");
        }
        this.f23623params = xMSSMTParameters;
        this.xmssParams = xMSSMTParameters.getXMSSParameters();
        this.f23624prng = secureRandom;
        this.privateKey = new XMSSMTPrivateKeyParameters.C6119Builder(xMSSMTParameters).m17917build();
        this.publicKey = new XMSSMTPublicKeyParameters.C6121Builder(xMSSMTParameters).m17919build();
    }

    private void importState(XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters, XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters) {
        this.xmssParams.getWOTSPlus().importKeys(new byte[this.f23623params.getTreeDigestSize()], this.privateKey.getPublicSeed());
        this.privateKey = xMSSMTPrivateKeyParameters;
        this.publicKey = xMSSMTPublicKeyParameters;
    }

    public byte[] exportPrivateKey() {
        return this.privateKey.toByteArray();
    }

    public byte[] exportPublicKey() {
        return this.publicKey.toByteArray();
    }

    public void generateKeys() {
        XMSSMTKeyPairGenerator xMSSMTKeyPairGenerator = new XMSSMTKeyPairGenerator();
        xMSSMTKeyPairGenerator.mo14944init(new XMSSMTKeyGenerationParameters(getParams(), this.f23624prng));
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = xMSSMTKeyPairGenerator.generateKeyPair();
        this.privateKey = (XMSSMTPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate();
        XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters = (XMSSMTPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic();
        this.publicKey = xMSSMTPublicKeyParameters;
        importState(this.privateKey, xMSSMTPublicKeyParameters);
    }

    public XMSSMTParameters getParams() {
        return this.f23623params;
    }

    public byte[] getPublicSeed() {
        return this.privateKey.getPublicSeed();
    }

    /* renamed from: getXMSS */
    public XMSSParameters m17911getXMSS() {
        return this.xmssParams;
    }

    /* renamed from: sign */
    public byte[] m17912sign(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("message == null");
        }
        XMSSMTSigner xMSSMTSigner = new XMSSMTSigner();
        xMSSMTSigner.mo15864init(true, this.privateKey);
        byte[] bArrGenerateSignature = xMSSMTSigner.generateSignature(bArr);
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = (XMSSMTPrivateKeyParameters) xMSSMTSigner.getUpdatedPrivateKey();
        this.privateKey = xMSSMTPrivateKeyParameters;
        importState(xMSSMTPrivateKeyParameters, this.publicKey);
        return bArrGenerateSignature;
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            throw new NullPointerException("message == null");
        }
        if (bArr2 == null) {
            throw new NullPointerException("signature == null");
        }
        if (bArr3 == null) {
            throw new NullPointerException("publicKey == null");
        }
        XMSSMTSigner xMSSMTSigner = new XMSSMTSigner();
        xMSSMTSigner.mo15864init(false, new XMSSMTPublicKeyParameters.C6121Builder(getParams()).withPublicKey(bArr3).m17919build());
        return xMSSMTSigner.verifySignature(bArr, bArr2);
    }

    public void importState(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new NullPointerException("privateKey == null");
        }
        if (bArr2 == null) {
            throw new NullPointerException("publicKey == null");
        }
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParametersM17917build = new XMSSMTPrivateKeyParameters.C6119Builder(this.f23623params).withPrivateKey(bArr).m17917build();
        XMSSMTPublicKeyParameters xMSSMTPublicKeyParametersM17919build = new XMSSMTPublicKeyParameters.C6121Builder(this.f23623params).withPublicKey(bArr2).m17919build();
        if (!C6238Arrays.areEqual(xMSSMTPrivateKeyParametersM17917build.m17915getRoot(), xMSSMTPublicKeyParametersM17919build.m17918getRoot())) {
            throw new IllegalStateException("root of private key and public key do not match");
        }
        if (!C6238Arrays.areEqual(xMSSMTPrivateKeyParametersM17917build.getPublicSeed(), xMSSMTPublicKeyParametersM17919build.getPublicSeed())) {
            throw new IllegalStateException("public seed of private key and public key do not match");
        }
        this.xmssParams.getWOTSPlus().importKeys(new byte[this.f23623params.getTreeDigestSize()], xMSSMTPrivateKeyParametersM17917build.getPublicSeed());
        this.privateKey = xMSSMTPrivateKeyParametersM17917build;
        this.publicKey = xMSSMTPublicKeyParametersM17919build;
    }
}
