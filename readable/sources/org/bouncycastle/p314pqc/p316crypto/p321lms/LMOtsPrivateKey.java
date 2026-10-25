package org.bouncycastle.p314pqc.p316crypto.p321lms;

import org.bouncycastle.p194crypto.InterfaceC5277Digest;

/* loaded from: classes2.dex */
class LMOtsPrivateKey {

    /* renamed from: I */
    private final byte[] f23232I;
    private final byte[] masterSecret;
    private final LMOtsParameters parameter;

    /* renamed from: q */
    private final int f23233q;

    public LMOtsPrivateKey(LMOtsParameters lMOtsParameters, byte[] bArr, int i, byte[] bArr2) {
        this.parameter = lMOtsParameters;
        this.f23232I = bArr;
        this.f23233q = i;
        this.masterSecret = bArr2;
    }

    public SeedDerive getDerivationFunction() {
        SeedDerive seedDerive = new SeedDerive(this.f23232I, this.masterSecret, DigestUtil.getDigest(this.parameter));
        seedDerive.m17664setQ(this.f23233q);
        return seedDerive;
    }

    /* renamed from: getI */
    public byte[] m17626getI() {
        return this.f23232I;
    }

    public byte[] getMasterSecret() {
        return this.masterSecret;
    }

    public LMOtsParameters getParameter() {
        return this.parameter;
    }

    /* renamed from: getQ */
    public int m17627getQ() {
        return this.f23233q;
    }

    public LMSContext getSignatureContext(LMSigParameters lMSigParameters, byte[][] bArr) {
        byte[] bArr2 = new byte[this.parameter.m17622getN()];
        SeedDerive derivationFunction = getDerivationFunction();
        derivationFunction.m17663setJ(-3);
        derivationFunction.deriveSeed(bArr2, false);
        InterfaceC5277Digest digest = DigestUtil.getDigest(this.parameter);
        LmsUtils.byteArray(m17626getI(), digest);
        LmsUtils.m17659u32str(m17627getQ(), digest);
        LmsUtils.m17658u16str((short) -32383, digest);
        LmsUtils.byteArray(bArr2, digest);
        return new LMSContext(this, lMSigParameters, digest, bArr2, bArr);
    }
}
