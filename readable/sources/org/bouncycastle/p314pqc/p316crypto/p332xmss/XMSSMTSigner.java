package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p316crypto.StateAwareMessageSigner;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.OTSHashAddress;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSMTSignature;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSReducedSignature;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class XMSSMTSigner implements StateAwareMessageSigner {
    private boolean hasGenerated;
    private boolean initSign;

    /* renamed from: params */
    private XMSSMTParameters f23649params;
    private XMSSMTPrivateKeyParameters privateKey;
    private XMSSMTPublicKeyParameters publicKey;
    private WOTSPlus wotsPlus;
    private XMSSParameters xmssParams;

    private WOTSPlusSignature wotsSign(byte[] bArr, OTSHashAddress oTSHashAddress) {
        if (bArr.length != this.f23649params.getTreeDigestSize()) {
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
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = this.privateKey;
        if (xMSSMTPrivateKeyParameters == null) {
            throw new IllegalStateException("signing key no longer usable");
        }
        synchronized (xMSSMTPrivateKeyParameters) {
            if (this.privateKey.getUsagesRemaining() <= 0) {
                throw new IllegalStateException("no usages of private key remaining");
            }
            if (this.privateKey.getBDSState().m17883isEmpty()) {
                throw new IllegalStateException("not initialized");
            }
            try {
                BDSStateMap bDSState = this.privateKey.getBDSState();
                long index = this.privateKey.getIndex();
                this.f23649params.getHeight();
                int height = this.xmssParams.getHeight();
                if (this.privateKey.getUsagesRemaining() <= 0) {
                    throw new IllegalStateException("index out of bounds");
                }
                byte[] bArrM17898PRF = this.wotsPlus.m17900getKhf().m17898PRF(this.privateKey.getSecretKeyPRF(), XMSSUtil.toBytesBigEndian(index, 32));
                byte[] bArrM17897HMsg = this.wotsPlus.m17900getKhf().m17897HMsg(C6238Arrays.concatenate(bArrM17898PRF, this.privateKey.m17915getRoot(), XMSSUtil.toBytesBigEndian(index, this.f23649params.getTreeDigestSize())), bArr);
                this.hasGenerated = true;
                XMSSMTSignature xMSSMTSignatureM17920build = new XMSSMTSignature.C6123Builder(this.f23649params).withIndex(index).withRandom(bArrM17898PRF).m17920build();
                long treeIndex = XMSSUtil.getTreeIndex(index, height);
                int leafIndex = XMSSUtil.getLeafIndex(index, height);
                this.wotsPlus.importKeys(new byte[this.f23649params.getTreeDigestSize()], this.privateKey.getPublicSeed());
                OTSHashAddress oTSHashAddress = (OTSHashAddress) new OTSHashAddress.C6114Builder().withTreeAddress(treeIndex).withOTSAddress(leafIndex).mo17893build();
                if (bDSState.m17882get(0) == null || leafIndex == 0) {
                    bDSState.m17884put(0, new C6108BDS(this.xmssParams, this.privateKey.getPublicSeed(), this.privateKey.getSecretKeySeed(), oTSHashAddress));
                }
                xMSSMTSignatureM17920build.getReducedSignatures().add(new XMSSReducedSignature.C6129Builder(this.xmssParams).withWOTSPlusSignature(wotsSign(bArrM17897HMsg, oTSHashAddress)).withAuthPath(bDSState.m17882get(0).getAuthenticationPath()).mo17930build());
                for (int i = 1; i < this.f23649params.getLayers(); i++) {
                    XMSSNode xMSSNodeM17880getRoot = bDSState.m17882get(i - 1).m17880getRoot();
                    int leafIndex2 = XMSSUtil.getLeafIndex(treeIndex, height);
                    treeIndex = XMSSUtil.getTreeIndex(treeIndex, height);
                    OTSHashAddress oTSHashAddress2 = (OTSHashAddress) new OTSHashAddress.C6114Builder().withLayerAddress(i).withTreeAddress(treeIndex).withOTSAddress(leafIndex2).mo17893build();
                    WOTSPlusSignature wOTSPlusSignatureWotsSign = wotsSign(xMSSNodeM17880getRoot.getValue(), oTSHashAddress2);
                    if (bDSState.m17882get(i) == null || XMSSUtil.isNewBDSInitNeeded(index, height, i)) {
                        bDSState.m17884put(i, new C6108BDS(this.xmssParams, this.privateKey.getPublicSeed(), this.privateKey.getSecretKeySeed(), oTSHashAddress2));
                    }
                    xMSSMTSignatureM17920build.getReducedSignatures().add(new XMSSReducedSignature.C6129Builder(this.xmssParams).withWOTSPlusSignature(wOTSPlusSignatureWotsSign).withAuthPath(bDSState.m17882get(i).getAuthenticationPath()).mo17930build());
                }
                byteArray = xMSSMTSignatureM17920build.toByteArray();
                this.privateKey.m17916rollKey();
            } catch (Throwable th) {
                this.privateKey.m17916rollKey();
                throw th;
            }
        }
        return byteArray;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.StateAwareMessageSigner
    public AsymmetricKeyParameter getUpdatedPrivateKey() {
        if (this.hasGenerated) {
            XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = this.privateKey;
            this.privateKey = null;
            return xMSSMTPrivateKeyParameters;
        }
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters2 = this.privateKey;
        if (xMSSMTPrivateKeyParameters2 != null) {
            this.privateKey = xMSSMTPrivateKeyParameters2.getNextKey();
        }
        return xMSSMTPrivateKeyParameters2;
    }

    public long getUsagesRemaining() {
        return this.privateKey.getUsagesRemaining();
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    /* renamed from: init */
    public void mo15864init(boolean z, CipherParameters cipherParameters) {
        XMSSMTParameters parameters;
        if (z) {
            this.initSign = true;
            this.hasGenerated = false;
            XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = (XMSSMTPrivateKeyParameters) cipherParameters;
            this.privateKey = xMSSMTPrivateKeyParameters;
            parameters = xMSSMTPrivateKeyParameters.getParameters();
        } else {
            this.initSign = false;
            XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters = (XMSSMTPublicKeyParameters) cipherParameters;
            this.publicKey = xMSSMTPublicKeyParameters;
            parameters = xMSSMTPublicKeyParameters.getParameters();
        }
        this.f23649params = parameters;
        this.xmssParams = parameters.getXMSSParameters();
        this.wotsPlus = this.f23649params.getWOTSPlus();
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new NullPointerException("message == null");
        }
        if (bArr2 == null) {
            throw new NullPointerException("signature == null");
        }
        if (this.publicKey == null) {
            throw new NullPointerException("publicKey == null");
        }
        XMSSMTSignature xMSSMTSignatureM17920build = new XMSSMTSignature.C6123Builder(this.f23649params).withSignature(bArr2).m17920build();
        byte[] bArrM17897HMsg = this.wotsPlus.m17900getKhf().m17897HMsg(C6238Arrays.concatenate(xMSSMTSignatureM17920build.getRandom(), this.publicKey.m17918getRoot(), XMSSUtil.toBytesBigEndian(xMSSMTSignatureM17920build.getIndex(), this.f23649params.getTreeDigestSize())), bArr);
        long index = xMSSMTSignatureM17920build.getIndex();
        int height = this.xmssParams.getHeight();
        long treeIndex = XMSSUtil.getTreeIndex(index, height);
        int leafIndex = XMSSUtil.getLeafIndex(index, height);
        this.wotsPlus.importKeys(new byte[this.f23649params.getTreeDigestSize()], this.publicKey.getPublicSeed());
        OTSHashAddress oTSHashAddress = (OTSHashAddress) new OTSHashAddress.C6114Builder().withTreeAddress(treeIndex).withOTSAddress(leafIndex).mo17893build();
        XMSSNode rootNodeFromSignature = XMSSVerifierUtil.getRootNodeFromSignature(this.wotsPlus, height, bArrM17897HMsg, xMSSMTSignatureM17920build.getReducedSignatures().get(0), oTSHashAddress, leafIndex);
        int i = 1;
        while (i < this.f23649params.getLayers()) {
            XMSSReducedSignature xMSSReducedSignature = xMSSMTSignatureM17920build.getReducedSignatures().get(i);
            int leafIndex2 = XMSSUtil.getLeafIndex(treeIndex, height);
            long treeIndex2 = XMSSUtil.getTreeIndex(treeIndex, height);
            rootNodeFromSignature = XMSSVerifierUtil.getRootNodeFromSignature(this.wotsPlus, height, rootNodeFromSignature.getValue(), xMSSReducedSignature, (OTSHashAddress) new OTSHashAddress.C6114Builder().withLayerAddress(i).withTreeAddress(treeIndex2).withOTSAddress(leafIndex2).mo17893build(), leafIndex2);
            i++;
            treeIndex = treeIndex2;
        }
        return C6238Arrays.constantTimeAreEqual(rootNodeFromSignature.getValue(), this.publicKey.m17918getRoot());
    }
}
