package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class AsconHash256 extends AsconBaseDigest {
    public AsconHash256() {
        this.algorithmName = "Ascon-Hash256";
        mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public /* bridge */ /* synthetic */ int mo14967doFinal(byte[] bArr, int i) {
        return super.mo14967doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.ExtendedDigest
    public /* bridge */ /* synthetic */ int getByteLength() {
        return super.getByteLength();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    public /* bridge */ /* synthetic */ int getDigestSize() {
        return super.getDigestSize();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconBaseDigest
    public long loadBytes(byte[] bArr, int i) {
        return AbstractC6245Pack.littleEndianToLong(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconBaseDigest
    /* renamed from: pad */
    public long mo15040pad(int i) {
        return 1 << (i << 3);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        this.f19265p.m15268set(-7269279749984954751L, 5459383224871899602L, -5880230600644446182L, 4359436768738168243L, 1899470422303676269L);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconBaseDigest
    public void setBytes(long j, byte[] bArr, int i) {
        AbstractC6245Pack.longToLittleEndian(j, bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public /* bridge */ /* synthetic */ void mo14969update(byte b) {
        super.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconBaseDigest
    public long loadBytes(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return 0L;
        }
        return AbstractC6245Pack.littleEndianToLong_Low(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconBaseDigest
    public void setBytes(long j, byte[] bArr, int i, int i2) {
        if (i2 > 0) {
            AbstractC6245Pack.longToLittleEndian_Low(j, bArr, i, i2);
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public /* bridge */ /* synthetic */ void mo14970update(byte[] bArr, int i, int i2) {
        super.mo14970update(bArr, i, i2);
    }
}
