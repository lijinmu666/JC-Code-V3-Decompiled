package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.p199digests.BufferBaseDigest;
import org.bouncycastle.p194crypto.p201engines.XoodyakEngine;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class XoodyakDigest extends BufferBaseDigest {
    private static final int PhaseDown = 1;

    /* renamed from: PhaseUp */
    private static final int f19617PhaseUp = 2;

    /* renamed from: TAGLEN */
    private static final int f19618TAGLEN = 16;

    /* renamed from: mode */
    private static final int f19619mode = 1;

    /* renamed from: Cd */
    private int f19620Cd;

    /* renamed from: phase */
    private int f19621phase;

    /* renamed from: state */
    private final byte[] f19622state;

    /* renamed from: org.bouncycastle.crypto.digests.XoodyakDigest$Friend */
    public static class C5299Friend {
        private static final C5299Friend INSTANCE = new C5299Friend();

        private C5299Friend() {
        }
    }

    public XoodyakDigest() {
        super(BufferBaseDigest.ProcessingBufferType.Immediate, 16);
        this.DigestSize = 32;
        this.f19622state = new byte[48];
        this.algorithmName = "Xoodyak Hash";
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
        if (this.m_bufPos != 0) {
            if (this.f19621phase != 2) {
                XoodyakEngine.m15455up(C5299Friend.INSTANCE, 1, this.f19622state, 0);
            }
            XoodyakEngine.m15453down(C5299Friend.INSTANCE, 1, this.f19622state, this.f19336m_buf, 0, this.m_bufPos, this.f19620Cd);
        }
        XoodyakEngine.m15455up(C5299Friend.INSTANCE, 1, this.f19622state, 64);
        System.arraycopy(this.f19622state, 0, bArr, i, 16);
        XoodyakEngine.m15453down(C5299Friend.INSTANCE, 1, this.f19622state, null, 0, 0, 0);
        XoodyakEngine.m15455up(C5299Friend.INSTANCE, 1, this.f19622state, 0);
        System.arraycopy(this.f19622state, 0, bArr, i + 16, 16);
        this.f19621phase = 1;
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
        if (this.f19621phase != 2) {
            XoodyakEngine.m15455up(C5299Friend.INSTANCE, 1, this.f19622state, 0);
        }
        XoodyakEngine.m15453down(C5299Friend.INSTANCE, 1, this.f19622state, bArr, i, this.BlockSize, this.f19620Cd);
        this.f19621phase = 1;
        this.f19620Cd = 0;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        C6238Arrays.m18249fill(this.f19622state, (byte) 0);
        this.f19621phase = 2;
        this.f19620Cd = 3;
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
