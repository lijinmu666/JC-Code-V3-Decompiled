package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.InterfaceC5284Xof;

/* loaded from: classes2.dex */
abstract class AsconXofBase extends AsconBaseDigest implements InterfaceC5284Xof {

    /* renamed from: buffer */
    private final byte[] f19273buffer = new byte[this.BlockSize];
    private int bytesInBuffer;
    private boolean m_squeezing;

    private void ensureNoAbsorbWhileSqueezing(boolean z) {
        if (z) {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    /* renamed from: doFinal */
    public int mo14998doFinal(byte[] bArr, int i, int i2) {
        int iDoOutput = doOutput(bArr, i, i2);
        mo14968reset();
        return iDoOutput;
    }

    public int doOutput(byte[] bArr, int i, int i2) {
        int iM15039hash;
        ensureSufficientOutputBuffer(bArr, i, i2);
        int i3 = this.bytesInBuffer;
        if (i3 != 0) {
            int i4 = this.BlockSize - i3;
            iM15039hash = Math.min(i2, i3);
            System.arraycopy(this.f19273buffer, i4, bArr, i, iM15039hash);
            this.bytesInBuffer -= iM15039hash;
        } else {
            iM15039hash = 0;
        }
        int i5 = i2 - iM15039hash;
        int i6 = this.BlockSize;
        if (i5 >= i6) {
            iM15039hash += m15039hash(bArr, i + iM15039hash, i5 - (i5 % i6));
        }
        if (iM15039hash >= i2) {
            return iM15039hash;
        }
        m15039hash(this.f19273buffer, 0, this.BlockSize);
        int i7 = i2 - iM15039hash;
        System.arraycopy(this.f19273buffer, 0, bArr, i + iM15039hash, i7);
        this.bytesInBuffer = this.f19273buffer.length - i7;
        return iM15039hash + i7;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconBaseDigest
    public void padAndAbsorb() {
        if (this.m_squeezing) {
            this.f19265p.m15266p(this.ASCON_PB_ROUNDS);
        } else {
            this.m_squeezing = true;
            super.padAndAbsorb();
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        this.m_squeezing = false;
        this.bytesInBuffer = 0;
        super.mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        ensureNoAbsorbWhileSqueezing(this.m_squeezing);
        super.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        ensureNoAbsorbWhileSqueezing(this.m_squeezing);
        super.mo14970update(bArr, i, i2);
    }
}
