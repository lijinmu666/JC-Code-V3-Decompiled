package org.bouncycastle.p314pqc.p352legacy.sphincsplus;

import org.bouncycastle.p194crypto.InterfaceC5277Digest;

/* loaded from: classes2.dex */
class HarakaS256Digest extends HarakaSBase implements InterfaceC5277Digest {
    public HarakaS256Digest(HarakaSXof harakaSXof) {
        this.haraka256_rc = harakaSXof.haraka256_rc;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        byte[] bArr2 = new byte[32];
        haraka256Perm(bArr2);
        HarakaSBase.m18151xor(bArr2, 0, this.f24083buffer, 0, bArr, i, 32);
        mo14968reset();
        return bArr.length;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "HarakaS-256";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.HarakaSBase, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        int i = this.f24084off;
        if (i > 31) {
            throw new IllegalArgumentException("total input cannot be more than 32 bytes");
        }
        byte[] bArr = this.f24083buffer;
        this.f24084off = i + 1;
        bArr[i] = b;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        int i3 = this.f24084off;
        if (i3 > 32 - i2) {
            throw new IllegalArgumentException("total input cannot be more than 32 bytes");
        }
        System.arraycopy(bArr, i, this.f24083buffer, i3, i2);
        this.f24084off += i2;
    }
}
