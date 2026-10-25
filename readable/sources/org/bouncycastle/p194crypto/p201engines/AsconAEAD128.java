package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p201engines.AEADBaseEngine;
import org.bouncycastle.p194crypto.p201engines.AsconPermutationFriend;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class AsconAEAD128 extends AsconBaseEngine {
    public AsconAEAD128() {
        this.BlockSize = 16;
        this.AADBufferSize = 16;
        this.MAC_SIZE = 16;
        this.f19650IV_SIZE = 16;
        this.KEY_SIZE = 16;
        this.ASCON_IV = 17594342703105L;
        this.algorithmName = "Ascon-AEAD128";
        this.f19736nr = 8;
        this.f19735dsep = Long.MIN_VALUE;
        this.macSizeLowerBound = 4;
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Immediate, AEADBaseEngine.AADOperatorType.DataLimit, AEADBaseEngine.DataOperatorType.DataLimit);
        this.dataLimitCounter.m15234init(54);
        this.decryptionFailureCounter = new AEADBaseEngine.DecryptionFailureCounter();
    }

    private void finishData(AEADBaseEngine.C5335State c5335State) {
        AsconPermutationFriend.AsconPermutation asconPermutation = this.f19737p;
        asconPermutation.f19742x2 ^= this.f19731K0;
        asconPermutation.f19743x3 ^= this.f19732K1;
        asconPermutation.m15266p(12);
        AsconPermutationFriend.AsconPermutation asconPermutation2 = this.f19737p;
        asconPermutation2.f19743x3 ^= this.f19731K0;
        asconPermutation2.f19744x4 ^= this.f19732K1;
        this.f19653m_state = c5335State;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AsconBaseEngine
    public void ascon_aeadinit() {
        this.f19737p.m15268set(this.ASCON_IV, this.f19731K0, this.f19732K1, this.f19733N0, this.f19734N1);
        this.f19737p.m15266p(12);
        AsconPermutationFriend.AsconPermutation asconPermutation = this.f19737p;
        asconPermutation.f19743x3 ^= this.f19731K0;
        asconPermutation.f19744x4 ^= this.f19732K1;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: doFinal */
    public /* bridge */ /* synthetic */ int mo15224doFinal(byte[] bArr, int i) {
        return super.mo15224doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AsconBaseEngine
    public String getAlgorithmVersion() {
        return "v1.3";
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public /* bridge */ /* synthetic */ int getIVBytesSize() {
        return super.getIVBytesSize();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public /* bridge */ /* synthetic */ int getKeyBytesSize() {
        return super.getKeyBytesSize();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: getMac */
    public /* bridge */ /* synthetic */ byte[] mo15225getMac() {
        return super.mo15225getMac();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ int getOutputSize(int i) {
        return super.getOutputSize(i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ int getUpdateOutputSize(int i) {
        return super.getUpdateOutputSize(i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: init */
    public /* bridge */ /* synthetic */ void mo15226init(boolean z, CipherParameters cipherParameters) {
        super.mo15226init(z, cipherParameters);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AsconBaseEngine
    public long loadBytes(byte[] bArr, int i) {
        return AbstractC6245Pack.littleEndianToLong(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AsconBaseEngine
    /* renamed from: pad */
    public long mo15262pad(int i) {
        return 1 << (i << 3);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADByte(byte b) {
        super.processAADByte(b);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADBytes(byte[] bArr, int i, int i2) {
        super.processAADBytes(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ int processByte(byte b, byte[] bArr, int i) {
        return super.processByte(b, bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        return super.processBytes(bArr, i, i2, bArr2, i3);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processFinalAAD() {
        if (this.m_aadPos == this.BlockSize) {
            this.f19737p.f19740x0 ^= loadBytes(this.f19651m_aad, 0);
            this.f19737p.f19741x1 ^= loadBytes(this.f19651m_aad, 8);
            this.m_aadPos -= this.BlockSize;
            this.f19737p.m15266p(this.f19736nr);
        }
        C6238Arrays.m18250fill(this.f19651m_aad, this.m_aadPos, this.AADBufferSize, (byte) 0);
        if (this.m_aadPos < 8) {
            this.f19737p.f19740x0 ^= AbstractC6245Pack.littleEndianToLong(this.f19651m_aad, 0) ^ mo15262pad(this.m_aadPos);
            return;
        }
        this.f19737p.f19740x0 ^= AbstractC6245Pack.littleEndianToLong(this.f19651m_aad, 0);
        AsconPermutationFriend.AsconPermutation asconPermutation = this.f19737p;
        asconPermutation.f19741x1 = (AbstractC6245Pack.littleEndianToLong(this.f19651m_aad, 8) ^ mo15262pad(this.m_aadPos)) ^ asconPermutation.f19741x1;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AsconBaseEngine
    public void processFinalDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (i >= 8) {
            long jLittleEndianToLong = AbstractC6245Pack.littleEndianToLong(bArr, 0);
            int i3 = i - 8;
            AbstractC6245Pack.longToLittleEndian(this.f19737p.f19740x0 ^ jLittleEndianToLong, bArr2, i2);
            this.f19737p.f19740x0 = jLittleEndianToLong;
            if (i3 > 0) {
                long jLittleEndianToLong_Low = AbstractC6245Pack.littleEndianToLong_Low(bArr, 8, i3);
                AbstractC6245Pack.longToLittleEndian_Low(this.f19737p.f19741x1 ^ jLittleEndianToLong_Low, bArr2, i2 + 8, i3);
                AsconPermutationFriend.AsconPermutation asconPermutation = this.f19737p;
                asconPermutation.f19741x1 = (asconPermutation.f19741x1 & (-(1 << (i3 << 3)))) | jLittleEndianToLong_Low;
            }
            this.f19737p.f19741x1 ^= mo15262pad(i3);
        } else {
            if (i > 0) {
                long jLittleEndianToLong_Low2 = AbstractC6245Pack.littleEndianToLong_Low(bArr, 0, i);
                AbstractC6245Pack.longToLittleEndian_Low(this.f19737p.f19740x0 ^ jLittleEndianToLong_Low2, bArr2, i2, i);
                AsconPermutationFriend.AsconPermutation asconPermutation2 = this.f19737p;
                asconPermutation2.f19740x0 = (asconPermutation2.f19740x0 & (-(1 << (i << 3)))) | jLittleEndianToLong_Low2;
            }
            this.f19737p.f19740x0 ^= mo15262pad(i);
        }
        finishData(AEADBaseEngine.C5335State.DecFinal);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AsconBaseEngine
    public void processFinalEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (i >= 8) {
            this.f19737p.f19740x0 ^= AbstractC6245Pack.littleEndianToLong(bArr, 0);
            int i3 = i - 8;
            AbstractC6245Pack.longToLittleEndian(this.f19737p.f19740x0, bArr2, i2);
            if (i3 > 0) {
                this.f19737p.f19741x1 ^= AbstractC6245Pack.littleEndianToLong_Low(bArr, 8, i3);
                AbstractC6245Pack.longToLittleEndian_Low(this.f19737p.f19741x1, bArr2, i2 + 8, i3);
            }
            this.f19737p.f19741x1 ^= mo15262pad(i3);
        } else {
            if (i > 0) {
                this.f19737p.f19740x0 ^= AbstractC6245Pack.littleEndianToLong_Low(bArr, 0, i);
                AbstractC6245Pack.longToLittleEndian_Low(this.f19737p.f19740x0, bArr2, i2, i);
            }
            this.f19737p.f19740x0 ^= mo15262pad(i);
        }
        finishData(AEADBaseEngine.C5335State.EncFinal);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: reset */
    public /* bridge */ /* synthetic */ void mo15228reset() {
        super.mo15228reset();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AsconBaseEngine
    public void setBytes(long j, byte[] bArr, int i) {
        AbstractC6245Pack.longToLittleEndian(j, bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    /* renamed from: init */
    public void mo15227init(byte[] bArr, byte[] bArr2) {
        int i = (this.MAC_SIZE << 3) - 32;
        long jLittleEndianToLong = AbstractC6245Pack.littleEndianToLong(bArr, 0);
        long jLittleEndianToLong2 = AbstractC6245Pack.littleEndianToLong(bArr, 8);
        this.decryptionFailureCounter.m15236init(i);
        if (this.f19731K0 != jLittleEndianToLong || this.f19732K1 != jLittleEndianToLong2) {
            this.dataLimitCounter.m15235reset();
            this.decryptionFailureCounter.m15237reset();
            this.f19731K0 = jLittleEndianToLong;
            this.f19732K1 = jLittleEndianToLong2;
        }
        this.f19733N0 = AbstractC6245Pack.littleEndianToLong(bArr2, 0);
        this.f19734N1 = AbstractC6245Pack.littleEndianToLong(bArr2, 8);
    }
}
