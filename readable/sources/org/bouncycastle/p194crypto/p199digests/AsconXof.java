package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class AsconXof extends AsconXofBase {
    AsconParameters asconParameters;

    public enum AsconParameters {
        AsconXof,
        AsconXofA
    }

    public AsconXof(AsconParameters asconParameters) {
        String str;
        this.BlockSize = 8;
        this.asconParameters = asconParameters;
        int iOrdinal = asconParameters.ordinal();
        if (iOrdinal == 0) {
            this.ASCON_PB_ROUNDS = 12;
            str = "Ascon-Xof";
        } else {
            if (iOrdinal != 1) {
                throw new IllegalArgumentException("Invalid parameter settings for Ascon Hash");
            }
            this.ASCON_PB_ROUNDS = 8;
            str = "Ascon-XofA";
        }
        this.algorithmName = str;
        mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public /* bridge */ /* synthetic */ int mo14967doFinal(byte[] bArr, int i) {
        return super.mo14967doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconXofBase, org.bouncycastle.p194crypto.InterfaceC5284Xof
    public /* bridge */ /* synthetic */ int doOutput(byte[] bArr, int i, int i2) {
        return super.doOutput(bArr, i, i2);
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
        return AbstractC6245Pack.bigEndianToLong(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconBaseDigest
    /* renamed from: pad */
    public long mo15040pad(int i) {
        return 128 << (56 - (i << 3));
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconXofBase, org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        int iOrdinal = this.asconParameters.ordinal();
        if (iOrdinal == 0) {
            this.f19265p.m15268set(-5368810569253202922L, 3121280575360345120L, 7395939140700676632L, 6533890155656471820L, 5710016986865767350L);
        } else {
            if (iOrdinal != 1) {
                return;
            }
            this.f19265p.m15268set(4940560291654768690L, -3635129828240960206L, -597534922722107095L, 2623493988082852443L, -6283826724160825537L);
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconBaseDigest
    public void setBytes(long j, byte[] bArr, int i) {
        AbstractC6245Pack.longToBigEndian(j, bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconXofBase, org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public /* bridge */ /* synthetic */ void mo14969update(byte b) {
        super.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconXofBase, org.bouncycastle.p194crypto.InterfaceC5284Xof
    /* renamed from: doFinal */
    public /* bridge */ /* synthetic */ int mo14998doFinal(byte[] bArr, int i, int i2) {
        return super.mo14998doFinal(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconBaseDigest
    public long loadBytes(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return 0L;
        }
        return AbstractC6245Pack.bigEndianToLong_High(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconBaseDigest
    public void setBytes(long j, byte[] bArr, int i, int i2) {
        if (i2 > 0) {
            AbstractC6245Pack.longToBigEndian_High(j, bArr, i, i2);
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconXofBase, org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public /* bridge */ /* synthetic */ void mo14970update(byte[] bArr, int i, int i2) {
        super.mo14970update(bArr, i, i2);
    }
}
