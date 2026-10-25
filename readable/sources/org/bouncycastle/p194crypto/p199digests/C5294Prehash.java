package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p361util.p362io.LimitedBuffer;

/* renamed from: org.bouncycastle.crypto.digests.Prehash */
/* loaded from: classes2.dex */
public class C5294Prehash implements InterfaceC5277Digest {
    private final String algorithmName;

    /* renamed from: buf */
    private final LimitedBuffer f19482buf;

    private C5294Prehash(InterfaceC5277Digest interfaceC5277Digest) {
        this.algorithmName = interfaceC5277Digest.getAlgorithmName();
        this.f19482buf = new LimitedBuffer(interfaceC5277Digest.getDigestSize());
    }

    public static C5294Prehash forDigest(InterfaceC5277Digest interfaceC5277Digest) {
        return new C5294Prehash(interfaceC5277Digest);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        try {
            if (getDigestSize() == this.f19482buf.m18359size()) {
                return this.f19482buf.m18356copyTo(bArr, i);
            }
            throw new IllegalStateException("Incorrect prehash size");
        } finally {
            mo14968reset();
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return this.algorithmName;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return this.f19482buf.m18357limit();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        this.f19482buf.m18358reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        this.f19482buf.write(b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        this.f19482buf.write(bArr, i, i2);
    }
}
