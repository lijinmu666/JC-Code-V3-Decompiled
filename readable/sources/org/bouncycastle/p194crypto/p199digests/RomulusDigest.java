package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.p199digests.BufferBaseDigest;
import org.bouncycastle.p194crypto.p201engines.RomulusEngine;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class RomulusDigest extends BufferBaseDigest {

    /* renamed from: g */
    private final byte[] f19518g;

    /* renamed from: h */
    private final byte[] f19519h;

    /* renamed from: org.bouncycastle.crypto.digests.RomulusDigest$Friend */
    public static class C5295Friend {
        private static final C5295Friend INSTANCE = new C5295Friend();

        private C5295Friend() {
        }
    }

    public RomulusDigest() {
        super(BufferBaseDigest.ProcessingBufferType.Immediate, 32);
        this.f19519h = new byte[16];
        this.f19518g = new byte[16];
        this.DigestSize = 32;
        this.algorithmName = "Romulus Hash";
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public /* bridge */ /* synthetic */ int mo14967doFinal(byte[] bArr, int i) {
        return super.mo14967doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest
    /* renamed from: finish */
    public void mo15038finish(byte[] bArr, int i) {
        C6238Arrays.m18250fill(this.f19336m_buf, this.m_bufPos, 31, (byte) 0);
        this.f19336m_buf[31] = (byte) (this.m_bufPos & 31);
        byte[] bArr2 = this.f19519h;
        bArr2[0] = (byte) (bArr2[0] ^ 2);
        RomulusEngine.hirose_128_128_256(C5295Friend.INSTANCE, this.f19519h, this.f19518g, this.f19336m_buf, 0);
        System.arraycopy(this.f19519h, 0, bArr, i, 16);
        System.arraycopy(this.f19518g, 0, bArr, i + 16, 16);
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
        RomulusEngine.hirose_128_128_256(C5295Friend.INSTANCE, this.f19519h, this.f19518g, bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        C6238Arrays.m18227clear(this.f19519h);
        C6238Arrays.m18227clear(this.f19518g);
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
