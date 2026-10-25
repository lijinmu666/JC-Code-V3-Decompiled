package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class SipHash128 extends C5364SipHash {
    public SipHash128() {
    }

    @Override // org.bouncycastle.p194crypto.p209macs.C5364SipHash, org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        this.f20494m = ((this.f20494m >>> ((7 - this.f20499wordPos) << 3)) >>> 8) | ((((this.wordCount << 3) + r2) & 255) << 56);
        processMessageWord();
        this.f20497v2 ^= 238;
        applySipRounds(this.f20491d);
        long j = this.f20495v0;
        long j2 = this.f20496v1;
        long j3 = ((j ^ j2) ^ this.f20497v2) ^ this.f20498v3;
        this.f20496v1 = j2 ^ 221;
        applySipRounds(this.f20491d);
        long j4 = ((this.f20495v0 ^ this.f20496v1) ^ this.f20497v2) ^ this.f20498v3;
        mo14977reset();
        AbstractC6245Pack.longToLittleEndian(j3, bArr, i);
        AbstractC6245Pack.longToLittleEndian(j4, bArr, i + 8);
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.p209macs.C5364SipHash, org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return "SipHash128-" + this.f20490c + "-" + this.f20491d;
    }

    @Override // org.bouncycastle.p194crypto.p209macs.C5364SipHash, org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.p209macs.C5364SipHash, org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        super.mo14977reset();
        this.f20496v1 ^= 238;
    }

    public SipHash128(int i, int i2) {
        super(i, i2);
    }

    @Override // org.bouncycastle.p194crypto.p209macs.C5364SipHash
    /* renamed from: doFinal */
    public long mo15592doFinal() {
        throw new UnsupportedOperationException("doFinal() is not supported");
    }
}
