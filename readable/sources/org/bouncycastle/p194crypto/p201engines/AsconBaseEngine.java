package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.p201engines.AEADBaseEngine;
import org.bouncycastle.p194crypto.p201engines.AsconPermutationFriend;

/* loaded from: classes2.dex */
abstract class AsconBaseEngine extends AEADBaseEngine {
    protected long ASCON_IV;

    /* renamed from: K0 */
    protected long f19731K0;

    /* renamed from: K1 */
    protected long f19732K1;

    /* renamed from: N0 */
    protected long f19733N0;

    /* renamed from: N1 */
    protected long f19734N1;

    /* renamed from: dsep */
    protected long f19735dsep;

    /* renamed from: nr */
    protected int f19736nr;

    /* renamed from: p */
    AsconPermutationFriend.AsconPermutation f19737p = new AsconPermutationFriend.AsconPermutation();

    public abstract void ascon_aeadinit();

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void finishAAD(AEADBaseEngine.C5335State c5335State, boolean z) {
        int i = this.f19653m_state.f19692ord;
        if (i == 2 || i == 6) {
            processFinalAAD();
            this.f19737p.m15266p(this.f19736nr);
        }
        this.f19737p.f19744x4 ^= this.f19735dsep;
        this.m_aadPos = 0;
        this.f19653m_state = c5335State;
    }

    public abstract String getAlgorithmVersion();

    public abstract long loadBytes(byte[] bArr, int i);

    /* renamed from: pad */
    public abstract long mo15262pad(int i);

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferAAD(byte[] bArr, int i) {
        this.f19737p.f19740x0 ^= loadBytes(bArr, i);
        if (this.BlockSize == 16) {
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f19737p;
            asconPermutation.f19741x1 = loadBytes(bArr, i + 8) ^ asconPermutation.f19741x1;
        }
        this.f19737p.m15266p(this.f19736nr);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        long jLoadBytes = loadBytes(bArr, i);
        setBytes(this.f19737p.f19740x0 ^ jLoadBytes, bArr2, i2);
        this.f19737p.f19740x0 = jLoadBytes;
        if (this.BlockSize == 16) {
            long jLoadBytes2 = loadBytes(bArr, i + 8);
            setBytes(this.f19737p.f19741x1 ^ jLoadBytes2, bArr2, i2 + 8);
            this.f19737p.f19741x1 = jLoadBytes2;
        }
        this.f19737p.m15266p(this.f19736nr);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        this.f19737p.f19740x0 ^= loadBytes(bArr, i);
        setBytes(this.f19737p.f19740x0, bArr2, i2);
        if (this.BlockSize == 16) {
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f19737p;
            asconPermutation.f19741x1 = loadBytes(bArr, i + 8) ^ asconPermutation.f19741x1;
            setBytes(this.f19737p.f19741x1, bArr2, i2 + 8);
        }
        this.f19737p.m15266p(this.f19736nr);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processFinalBlock(byte[] bArr, int i) {
        if (this.forEncryption) {
            processFinalEncrypt(this.f19652m_buf, this.m_bufPos, bArr, i);
        } else {
            processFinalDecrypt(this.f19652m_buf, this.m_bufPos, bArr, i);
        }
        setBytes(this.f19737p.f19743x3, this.f19654mac, 0);
        setBytes(this.f19737p.f19744x4, this.f19654mac, 8);
    }

    public abstract void processFinalDecrypt(byte[] bArr, int i, byte[] bArr2, int i2);

    public abstract void processFinalEncrypt(byte[] bArr, int i, byte[] bArr2, int i2);

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    /* renamed from: reset */
    public void mo15229reset(boolean z) {
        super.mo15229reset(z);
        ascon_aeadinit();
    }

    public abstract void setBytes(long j, byte[] bArr, int i);
}
