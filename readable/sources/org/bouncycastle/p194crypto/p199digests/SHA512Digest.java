package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class SHA512Digest extends LongDigest {
    private static final int DIGEST_LENGTH = 64;

    public SHA512Digest() {
        this(CryptoServicePurpose.ANY);
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new SHA512Digest(this);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.LongDigest
    public CryptoServiceProperties cryptoServiceProperties() {
        return C5298Utils.getDefaultProperties(this, 256, this.f19421purpose);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        m15099finish();
        AbstractC6245Pack.longToBigEndian(this.f19412H1, bArr, i);
        AbstractC6245Pack.longToBigEndian(this.f19413H2, bArr, i + 8);
        AbstractC6245Pack.longToBigEndian(this.f19414H3, bArr, i + 16);
        AbstractC6245Pack.longToBigEndian(this.f19415H4, bArr, i + 24);
        AbstractC6245Pack.longToBigEndian(this.f19416H5, bArr, i + 32);
        AbstractC6245Pack.longToBigEndian(this.f19417H6, bArr, i + 40);
        AbstractC6245Pack.longToBigEndian(this.f19418H7, bArr, i + 48);
        AbstractC6245Pack.longToBigEndian(this.f19419H8, bArr, i + 56);
        mo14968reset();
        return 64;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return XMSSKeyParameters.f23622SHA_512;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return 64;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.EncodableDigest, org.bouncycastle.p194crypto.EncodableService
    public byte[] getEncodedState() {
        int encodedStateSize = getEncodedStateSize();
        byte[] bArr = new byte[encodedStateSize + 1];
        super.populateState(bArr);
        bArr[encodedStateSize] = (byte) this.f19421purpose.ordinal();
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.LongDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        this.f19412H1 = 7640891576956012808L;
        this.f19413H2 = -4942790177534073029L;
        this.f19414H3 = 4354685564936845355L;
        this.f19415H4 = -6534734903238641935L;
        this.f19416H5 = 5840696475078001361L;
        this.f19417H6 = -7276294671716946913L;
        this.f19418H7 = 2270897969802886507L;
        this.f19419H8 = 6620516959819538809L;
    }

    public SHA512Digest(CryptoServicePurpose cryptoServicePurpose) {
        super(cryptoServicePurpose);
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        mo14968reset();
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        m15098copyIn((SHA512Digest) memoable);
    }

    public SHA512Digest(SHA512Digest sHA512Digest) {
        super(sHA512Digest);
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
    }

    public SHA512Digest(byte[] bArr) {
        super(CryptoServicePurpose.m14960values()[bArr[bArr.length - 1]]);
        restoreState(bArr);
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
    }
}
