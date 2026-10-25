package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p316crypto.ExhaustedPrivateKeyException;
import org.bouncycastle.p314pqc.p316crypto.StateAwareMessageSigner;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.OTSHashAddress;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSSignature;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class XMSSSigner implements StateAwareMessageSigner {
    private boolean hasGenerated;
    private boolean initSign;

    /* renamed from: khf */
    private KeyedHashFunctions f23672khf;

    /* renamed from: params */
    private XMSSParameters f23673params;
    private XMSSPrivateKeyParameters privateKey;
    private XMSSPublicKeyParameters publicKey;
    private WOTSPlus wotsPlus;

    private WOTSPlusSignature wotsSign(byte[] bArr, OTSHashAddress oTSHashAddress) {
        if (bArr.length != this.f23673params.getTreeDigestSize()) {
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        }
        if (oTSHashAddress == null) {
            throw new NullPointerException("otsHashAddress == null");
        }
        WOTSPlus wOTSPlus = this.wotsPlus;
        wOTSPlus.importKeys(wOTSPlus.getWOTSPlusSecretKey(this.privateKey.getSecretKeySeed(), oTSHashAddress), this.privateKey.getPublicSeed());
        return this.wotsPlus.m17901sign(bArr, oTSHashAddress);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        byte[] byteArray;
        if (bArr == null) {
            throw new NullPointerException("message == null");
        }
        if (!this.initSign) {
            throw new IllegalStateException("signer not initialized for signature generation");
        }
        XMSSPrivateKeyParameters xMSSPrivateKeyParameters = this.privateKey;
        if (xMSSPrivateKeyParameters == null) {
            throw new IllegalStateException("signing key no longer usable");
        }
        synchronized (xMSSPrivateKeyParameters) {
            try {
                if (this.privateKey.getUsagesRemaining() <= 0) {
                    throw new ExhaustedPrivateKeyException("no usages of private key remaining");
                }
                if (this.privateKey.getBDSState().getAuthenticationPath().isEmpty()) {
                    throw new IllegalStateException("not initialized");
                }
                try {
                    int index = this.privateKey.getIndex();
                    this.hasGenerated = true;
                    long j = index;
                    byte[] bArrM17898PRF = this.f23672khf.m17898PRF(this.privateKey.getSecretKeyPRF(), XMSSUtil.toBytesBigEndian(j, 32));
                    byteArray = new XMSSSignature.C6131Builder(this.f23673params).withIndex(index).withRandom(bArrM17898PRF).withWOTSPlusSignature(wotsSign(this.f23672khf.m17897HMsg(C6238Arrays.concatenate(bArrM17898PRF, this.privateKey.m17925getRoot(), XMSSUtil.toBytesBigEndian(j, this.f23673params.getTreeDigestSize())), bArr), (OTSHashAddress) new OTSHashAddress.C6114Builder().withOTSAddress(index).mo17893build())).withAuthPath(this.privateKey.getBDSState().getAuthenticationPath()).mo17930build().toByteArray();
                } finally {
                    this.privateKey.getBDSState().markUsed();
                    this.privateKey.m17926rollKey();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return byteArray;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.StateAwareMessageSigner
    public AsymmetricKeyParameter getUpdatedPrivateKey() {
        synchronized (this.privateKey) {
            try {
                if (this.hasGenerated) {
                    XMSSPrivateKeyParameters xMSSPrivateKeyParameters = this.privateKey;
                    this.privateKey = null;
                    return xMSSPrivateKeyParameters;
                }
                XMSSPrivateKeyParameters xMSSPrivateKeyParameters2 = this.privateKey;
                if (xMSSPrivateKeyParameters2 != null) {
                    this.privateKey = xMSSPrivateKeyParameters2.getNextKey();
                }
                return xMSSPrivateKeyParameters2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long getUsagesRemaining() {
        return this.privateKey.getUsagesRemaining();
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    /* renamed from: init */
    public void mo15864init(boolean z, CipherParameters cipherParameters) {
        XMSSParameters parameters;
        if (z) {
            this.initSign = true;
            this.hasGenerated = false;
            XMSSPrivateKeyParameters xMSSPrivateKeyParameters = (XMSSPrivateKeyParameters) cipherParameters;
            this.privateKey = xMSSPrivateKeyParameters;
            parameters = xMSSPrivateKeyParameters.getParameters();
        } else {
            this.initSign = false;
            XMSSPublicKeyParameters xMSSPublicKeyParameters = (XMSSPublicKeyParameters) cipherParameters;
            this.publicKey = xMSSPublicKeyParameters;
            parameters = xMSSPublicKeyParameters.getParameters();
        }
        this.f23673params = parameters;
        WOTSPlus wOTSPlus = this.f23673params.getWOTSPlus();
        this.wotsPlus = wOTSPlus;
        this.f23672khf = wOTSPlus.m17900getKhf();
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        XMSSSignature xMSSSignatureMo17930build = new XMSSSignature.C6131Builder(this.f23673params).withSignature(bArr2).mo17930build();
        int index = xMSSSignatureMo17930build.getIndex();
        this.wotsPlus.importKeys(new byte[this.f23673params.getTreeDigestSize()], this.publicKey.getPublicSeed());
        long j = index;
        byte[] bArrM17897HMsg = this.f23672khf.m17897HMsg(C6238Arrays.concatenate(xMSSSignatureMo17930build.getRandom(), this.publicKey.m17928getRoot(), XMSSUtil.toBytesBigEndian(j, this.f23673params.getTreeDigestSize())), bArr);
        int height = this.f23673params.getHeight();
        return C6238Arrays.constantTimeAreEqual(XMSSVerifierUtil.getRootNodeFromSignature(this.wotsPlus, height, bArrM17897HMsg, xMSSSignatureMo17930build, (OTSHashAddress) new OTSHashAddress.C6114Builder().withOTSAddress(index).mo17893build(), XMSSUtil.getLeafIndex(j, height)).getValue(), this.publicKey.m17928getRoot());
    }
}
