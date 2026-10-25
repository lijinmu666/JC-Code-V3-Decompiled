package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.p199digests.AsconBaseDigest;
import org.bouncycastle.p194crypto.p199digests.BufferBaseDigest;
import org.bouncycastle.p194crypto.p201engines.AsconPermutationFriend;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class ISAPDigest extends BufferBaseDigest {

    /* renamed from: p */
    private final AsconPermutationFriend.AsconPermutation f19401p;

    /* renamed from: org.bouncycastle.crypto.digests.ISAPDigest$Friend */
    public static class C5290Friend {
        private static final C5290Friend INSTANCE = new C5290Friend();

        private C5290Friend() {
        }

        public static C5290Friend getFriend(AsconBaseDigest.C5288Friend c5288Friend) {
            if (c5288Friend != null) {
                return INSTANCE;
            }
            throw new NullPointerException("This method is only for use by AsconBaseDigest");
        }
    }

    public ISAPDigest() {
        super(BufferBaseDigest.ProcessingBufferType.Immediate, 8);
        this.f19401p = AsconPermutationFriend.getAsconPermutation(C5290Friend.INSTANCE);
        this.DigestSize = 32;
        this.algorithmName = "ISAP Hash";
        mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public /* bridge */ /* synthetic */ int mo14967doFinal(byte[] bArr, int i) {
        return super.mo14967doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest
    /* renamed from: finish */
    public void mo15038finish(byte[] bArr, int i) {
        this.f19401p.f19740x0 ^= 128 << ((7 - this.m_bufPos) << 3);
        while (true) {
            int i2 = this.m_bufPos;
            if (i2 <= 0) {
                break;
            }
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f19401p;
            long j = asconPermutation.f19740x0;
            byte[] bArr2 = this.f19336m_buf;
            int i3 = i2 - 1;
            this.m_bufPos = i3;
            asconPermutation.f19740x0 = j ^ ((bArr2[i3] & 255) << ((7 - i3) << 3));
        }
        for (int i4 = 0; i4 < 4; i4++) {
            this.f19401p.m15266p(12);
            AbstractC6245Pack.longToBigEndian(this.f19401p.f19740x0, bArr, i);
            i += 8;
        }
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

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest
    public void processBytes(byte[] bArr, int i) {
        AsconPermutationFriend.AsconPermutation asconPermutation = this.f19401p;
        asconPermutation.f19740x0 = AbstractC6245Pack.bigEndianToLong(bArr, i) ^ asconPermutation.f19740x0;
        this.f19401p.m15266p(12);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        this.f19401p.m15268set(-1255492011513352131L, -8380609354527731710L, -5437372128236807582L, 4834782570098516968L, 3787428097924915520L);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public /* bridge */ /* synthetic */ void mo14969update(byte b) {
        super.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public /* bridge */ /* synthetic */ void mo14970update(byte[] bArr, int i, int i2) {
        super.mo14970update(bArr, i, i2);
    }
}
