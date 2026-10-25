package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSPublicKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.pqc.crypto.xmss.XMSS */
/* loaded from: classes2.dex */
public class C6115XMSS {

    /* renamed from: params */
    private final XMSSParameters f23615params;
    private XMSSPrivateKeyParameters privateKey;

    /* renamed from: prng */
    private SecureRandom f23616prng;
    private XMSSPublicKeyParameters publicKey;
    private WOTSPlus wotsPlus;

    public C6115XMSS(XMSSParameters xMSSParameters, SecureRandom secureRandom) {
        if (xMSSParameters == null) {
            throw new NullPointerException("params == null");
        }
        this.f23615params = xMSSParameters;
        this.wotsPlus = xMSSParameters.getWOTSPlus();
        this.f23616prng = secureRandom;
    }

    public XMSSPrivateKeyParameters exportPrivateKey() {
        return this.privateKey;
    }

    public XMSSPublicKeyParameters exportPublicKey() {
        return this.publicKey;
    }

    public void generateKeys() {
        XMSSKeyPairGenerator xMSSKeyPairGenerator = new XMSSKeyPairGenerator();
        xMSSKeyPairGenerator.mo14944init(new XMSSKeyGenerationParameters(getParams(), this.f23616prng));
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = xMSSKeyPairGenerator.generateKeyPair();
        this.privateKey = (XMSSPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate();
        this.publicKey = (XMSSPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic();
        this.wotsPlus.importKeys(new byte[this.f23615params.getTreeDigestSize()], this.privateKey.getPublicSeed());
    }

    public int getIndex() {
        return this.privateKey.getIndex();
    }

    public XMSSParameters getParams() {
        return this.f23615params;
    }

    public XMSSPrivateKeyParameters getPrivateKey() {
        return this.privateKey;
    }

    public byte[] getPublicSeed() {
        return this.privateKey.getPublicSeed();
    }

    /* renamed from: getRoot */
    public byte[] m17907getRoot() {
        return this.privateKey.m17925getRoot();
    }

    public WOTSPlus getWOTSPlus() {
        return this.wotsPlus;
    }

    public void importState(XMSSPrivateKeyParameters xMSSPrivateKeyParameters, XMSSPublicKeyParameters xMSSPublicKeyParameters) {
        if (!C6238Arrays.areEqual(xMSSPrivateKeyParameters.m17925getRoot(), xMSSPublicKeyParameters.m17928getRoot())) {
            throw new IllegalStateException("root of private key and public key do not match");
        }
        if (!C6238Arrays.areEqual(xMSSPrivateKeyParameters.getPublicSeed(), xMSSPublicKeyParameters.getPublicSeed())) {
            throw new IllegalStateException("public seed of private key and public key do not match");
        }
        this.privateKey = xMSSPrivateKeyParameters;
        this.publicKey = xMSSPublicKeyParameters;
        this.wotsPlus.importKeys(new byte[this.f23615params.getTreeDigestSize()], this.privateKey.getPublicSeed());
    }

    public void setIndex(int i) {
        this.privateKey = new XMSSPrivateKeyParameters.C6126Builder(this.f23615params).withSecretKeySeed(this.privateKey.getSecretKeySeed()).withSecretKeyPRF(this.privateKey.getSecretKeyPRF()).withPublicSeed(this.privateKey.getPublicSeed()).withRoot(this.privateKey.m17925getRoot()).withBDSState(this.privateKey.getBDSState()).m17927build();
    }

    public void setPublicSeed(byte[] bArr) {
        this.privateKey = new XMSSPrivateKeyParameters.C6126Builder(this.f23615params).withSecretKeySeed(this.privateKey.getSecretKeySeed()).withSecretKeyPRF(this.privateKey.getSecretKeyPRF()).withPublicSeed(bArr).withRoot(m17907getRoot()).withBDSState(this.privateKey.getBDSState()).m17927build();
        this.publicKey = new XMSSPublicKeyParameters.C6128Builder(this.f23615params).withRoot(m17907getRoot()).withPublicSeed(bArr).m17929build();
        this.wotsPlus.importKeys(new byte[this.f23615params.getTreeDigestSize()], bArr);
    }

    /* renamed from: setRoot */
    public void m17908setRoot(byte[] bArr) {
        this.privateKey = new XMSSPrivateKeyParameters.C6126Builder(this.f23615params).withSecretKeySeed(this.privateKey.getSecretKeySeed()).withSecretKeyPRF(this.privateKey.getSecretKeyPRF()).withPublicSeed(getPublicSeed()).withRoot(bArr).withBDSState(this.privateKey.getBDSState()).m17927build();
        this.publicKey = new XMSSPublicKeyParameters.C6128Builder(this.f23615params).withRoot(bArr).withPublicSeed(getPublicSeed()).m17929build();
    }

    /* renamed from: sign */
    public byte[] m17909sign(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("message == null");
        }
        XMSSSigner xMSSSigner = new XMSSSigner();
        xMSSSigner.mo15864init(true, this.privateKey);
        byte[] bArrGenerateSignature = xMSSSigner.generateSignature(bArr);
        XMSSPrivateKeyParameters xMSSPrivateKeyParameters = (XMSSPrivateKeyParameters) xMSSSigner.getUpdatedPrivateKey();
        this.privateKey = xMSSPrivateKeyParameters;
        importState(xMSSPrivateKeyParameters, this.publicKey);
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
        XMSSSigner xMSSSigner = new XMSSSigner();
        xMSSSigner.mo15864init(false, new XMSSPublicKeyParameters.C6128Builder(getParams()).withPublicKey(bArr3).m17929build());
        return xMSSSigner.verifySignature(bArr, bArr2);
    }

    public WOTSPlusSignature wotsSign(byte[] bArr, OTSHashAddress oTSHashAddress) {
        if (bArr.length != this.f23615params.getTreeDigestSize()) {
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        }
        if (oTSHashAddress == null) {
            throw new NullPointerException("otsHashAddress == null");
        }
        WOTSPlus wOTSPlus = this.wotsPlus;
        wOTSPlus.importKeys(wOTSPlus.getWOTSPlusSecretKey(this.privateKey.getSecretKeySeed(), oTSHashAddress), getPublicSeed());
        return this.wotsPlus.m17901sign(bArr, oTSHashAddress);
    }

    public void importState(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new NullPointerException("privateKey == null");
        }
        if (bArr2 == null) {
            throw new NullPointerException("publicKey == null");
        }
        XMSSPrivateKeyParameters xMSSPrivateKeyParametersM17927build = new XMSSPrivateKeyParameters.C6126Builder(this.f23615params).withPrivateKey(bArr).m17927build();
        XMSSPublicKeyParameters xMSSPublicKeyParametersM17929build = new XMSSPublicKeyParameters.C6128Builder(this.f23615params).withPublicKey(bArr2).m17929build();
        if (!C6238Arrays.areEqual(xMSSPrivateKeyParametersM17927build.m17925getRoot(), xMSSPublicKeyParametersM17929build.m17928getRoot())) {
            throw new IllegalStateException("root of private key and public key do not match");
        }
        if (!C6238Arrays.areEqual(xMSSPrivateKeyParametersM17927build.getPublicSeed(), xMSSPublicKeyParametersM17929build.getPublicSeed())) {
            throw new IllegalStateException("public seed of private key and public key do not match");
        }
        this.privateKey = xMSSPrivateKeyParametersM17927build;
        this.publicKey = xMSSPublicKeyParametersM17929build;
        this.wotsPlus.importKeys(new byte[this.f23615params.getTreeDigestSize()], this.privateKey.getPublicSeed());
    }
}
