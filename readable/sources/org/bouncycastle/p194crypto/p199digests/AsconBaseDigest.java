package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p199digests.BufferBaseDigest;
import org.bouncycastle.p194crypto.p199digests.ISAPDigest;
import org.bouncycastle.p194crypto.p201engines.AsconPermutationFriend;

/* loaded from: classes2.dex */
abstract class AsconBaseDigest extends BufferBaseDigest {
    protected int ASCON_PB_ROUNDS;

    /* renamed from: p */
    AsconPermutationFriend.AsconPermutation f19265p;

    /* renamed from: org.bouncycastle.crypto.digests.AsconBaseDigest$Friend */
    public static class C5288Friend {
        private static final C5288Friend INSTANCE = new C5288Friend();

        private C5288Friend() {
        }
    }

    public AsconBaseDigest() {
        super(BufferBaseDigest.ProcessingBufferType.Immediate, 8);
        this.ASCON_PB_ROUNDS = 12;
        this.f19265p = AsconPermutationFriend.getAsconPermutation(ISAPDigest.C5290Friend.getFriend(C5288Friend.INSTANCE));
        this.DigestSize = 32;
    }

    public void ensureSufficientOutputBuffer(byte[] bArr, int i, int i2) {
        if (i + i2 > bArr.length) {
            throw new OutputLengthException("output buffer is too short");
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest
    /* renamed from: finish */
    public void mo15038finish(byte[] bArr, int i) {
        padAndAbsorb();
        m15041squeeze(bArr, i, this.DigestSize);
    }

    /* renamed from: hash */
    public int m15039hash(byte[] bArr, int i, int i2) {
        ensureSufficientOutputBuffer(bArr, i, i2);
        padAndAbsorb();
        m15041squeeze(bArr, i, i2);
        return i2;
    }

    public abstract long loadBytes(byte[] bArr, int i);

    public abstract long loadBytes(byte[] bArr, int i, int i2);

    /* renamed from: pad */
    public abstract long mo15040pad(int i);

    public void padAndAbsorb() {
        this.f19265p.f19740x0 ^= loadBytes(this.f19336m_buf, 0, this.m_bufPos) ^ mo15040pad(this.m_bufPos);
        this.f19265p.m15266p(12);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest
    public void processBytes(byte[] bArr, int i) {
        AsconPermutationFriend.AsconPermutation asconPermutation = this.f19265p;
        asconPermutation.f19740x0 = loadBytes(bArr, i) ^ asconPermutation.f19740x0;
        this.f19265p.m15266p(this.ASCON_PB_ROUNDS);
    }

    public abstract void setBytes(long j, byte[] bArr, int i);

    public abstract void setBytes(long j, byte[] bArr, int i, int i2);

    /* renamed from: squeeze */
    public void m15041squeeze(byte[] bArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        while (i4 > this.BlockSize) {
            setBytes(this.f19265p.f19740x0, bArr, i3);
            this.f19265p.m15266p(this.ASCON_PB_ROUNDS);
            int i5 = this.BlockSize;
            i3 += i5;
            i4 -= i5;
        }
        setBytes(this.f19265p.f19740x0, bArr, i3, i4);
    }
}
