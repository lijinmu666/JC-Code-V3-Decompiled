package org.bouncycastle.p314pqc.p316crypto.p321lms;

import org.bouncycastle.p194crypto.InterfaceC5277Digest;

/* loaded from: classes2.dex */
public class LMSContext implements InterfaceC5277Digest {

    /* renamed from: C */
    private final byte[] f23242C;

    /* renamed from: digest */
    private volatile InterfaceC5277Digest f23243digest;

    /* renamed from: key */
    private final LMOtsPrivateKey f23244key;

    /* renamed from: path */
    private final byte[][] f23245path;
    private final LMOtsPublicKey publicKey;
    private final LMSigParameters sigParams;
    private final Object signature;
    private LMSSignedPubKey[] signedPubKeys;

    public LMSContext(LMOtsPrivateKey lMOtsPrivateKey, LMSigParameters lMSigParameters, InterfaceC5277Digest interfaceC5277Digest, byte[] bArr, byte[][] bArr2) {
        this.f23244key = lMOtsPrivateKey;
        this.sigParams = lMSigParameters;
        this.f23243digest = interfaceC5277Digest;
        this.f23242C = bArr;
        this.f23245path = bArr2;
        this.publicKey = null;
        this.signature = null;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        return this.f23243digest.mo14967doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return this.f23243digest.getAlgorithmName();
    }

    /* renamed from: getC */
    public byte[] m17636getC() {
        return this.f23242C;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return this.f23243digest.getDigestSize();
    }

    /* renamed from: getPath */
    public byte[][] m17637getPath() {
        return this.f23245path;
    }

    public LMOtsPrivateKey getPrivateKey() {
        return this.f23244key;
    }

    public LMOtsPublicKey getPublicKey() {
        return this.publicKey;
    }

    /* renamed from: getQ */
    public byte[] m17638getQ() {
        byte[] bArr = new byte[34];
        this.f23243digest.mo14967doFinal(bArr, 0);
        this.f23243digest = null;
        return bArr;
    }

    public LMSigParameters getSigParams() {
        return this.sigParams;
    }

    public Object getSignature() {
        return this.signature;
    }

    public LMSSignedPubKey[] getSignedPubKeys() {
        return this.signedPubKeys;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        this.f23243digest.mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        this.f23243digest.mo14969update(b);
    }

    public LMSContext withSignedPublicKeys(LMSSignedPubKey[] lMSSignedPubKeyArr) {
        this.signedPubKeys = lMSSignedPubKeyArr;
        return this;
    }

    public LMSContext(LMOtsPublicKey lMOtsPublicKey, Object obj, InterfaceC5277Digest interfaceC5277Digest) {
        this.publicKey = lMOtsPublicKey;
        this.signature = obj;
        this.f23243digest = interfaceC5277Digest;
        this.f23242C = null;
        this.f23244key = null;
        this.sigParams = null;
        this.f23245path = null;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        this.f23243digest.mo14970update(bArr, i, i2);
    }
}
