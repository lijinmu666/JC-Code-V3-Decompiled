package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class SHA384Digest extends LongDigest {
    private static final int DIGEST_LENGTH = 48;

    public SHA384Digest() {
        this(CryptoServicePurpose.ANY);
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new SHA384Digest(this);
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
        mo14968reset();
        return 48;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "SHA-384";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return 48;
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
        this.f19412H1 = -3766243637369397544L;
        this.f19413H2 = 7105036623409894663L;
        this.f19414H3 = -7973340178411365097L;
        this.f19415H4 = 1526699215303891257L;
        this.f19416H5 = 7436329637833083697L;
        this.f19417H6 = -8163818279084223215L;
        this.f19418H7 = -2662702644619276377L;
        this.f19419H8 = 5167115440072839076L;
    }

    public SHA384Digest(CryptoServicePurpose cryptoServicePurpose) {
        super(cryptoServicePurpose);
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        mo14968reset();
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        super.m15098copyIn((SHA384Digest) memoable);
    }

    public SHA384Digest(SHA384Digest sHA384Digest) {
        super(sHA384Digest);
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
    }

    public SHA384Digest(byte[] bArr) {
        super(CryptoServicePurpose.m14960values()[bArr[bArr.length - 1]]);
        restoreState(bArr);
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
    }
}
