package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p201engines.AEADBaseEngine;
import org.bouncycastle.p194crypto.p201engines.AsconPermutationFriend;
import org.bouncycastle.p361util.AbstractC6245Pack;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public class AsconEngine extends AsconBaseEngine {

    /* renamed from: K2 */
    private long f19738K2;
    private final AsconParameters asconParameters;

    public enum AsconParameters {
        ascon80pq,
        ascon128a,
        ascon128
    }

    public AsconEngine(AsconParameters asconParameters) {
        String str;
        this.asconParameters = asconParameters;
        this.MAC_SIZE = 16;
        this.f19650IV_SIZE = 16;
        int iOrdinal = asconParameters.ordinal();
        if (iOrdinal == 0) {
            this.KEY_SIZE = 20;
            this.BlockSize = 8;
            this.ASCON_IV = -6899501409222262784L;
            str = "Ascon-80pq AEAD";
        } else if (iOrdinal == 1) {
            this.KEY_SIZE = 16;
            this.BlockSize = 16;
            this.ASCON_IV = -9187330011336540160L;
            str = "Ascon-128a AEAD";
        } else {
            if (iOrdinal != 2) {
                throw new IllegalArgumentException("invalid parameter setting for ASCON AEAD");
            }
            this.KEY_SIZE = 16;
            this.BlockSize = 8;
            this.ASCON_IV = -9205344418435956736L;
            str = "Ascon-128 AEAD";
        }
        this.algorithmName = str;
        int i = this.BlockSize;
        this.f19736nr = i == 8 ? 6 : 8;
        this.AADBufferSize = i;
        this.f19735dsep = 1L;
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Immediate, AEADBaseEngine.AADOperatorType.f19658Default, AEADBaseEngine.DataOperatorType.f19674Default);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AsconBaseEngine
    public void ascon_aeadinit() {
        this.f19737p.m15268set(this.ASCON_IV, this.f19732K1, this.f19738K2, this.f19733N0, this.f19734N1);
        if (this.KEY_SIZE == 20) {
            this.f19737p.f19740x0 ^= this.f19731K0;
        }
        this.f19737p.m15266p(12);
        if (this.KEY_SIZE == 20) {
            this.f19737p.f19742x2 ^= this.f19731K0;
        }
        AsconPermutationFriend.AsconPermutation asconPermutation = this.f19737p;
        asconPermutation.f19743x3 ^= this.f19732K1;
        asconPermutation.f19744x4 ^= this.f19738K2;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: doFinal */
    public /* bridge */ /* synthetic */ int mo15224doFinal(byte[] bArr, int i) {
        return super.mo15224doFinal(bArr, i);
    }

    public void finishData(AEADBaseEngine.C5335State c5335State) {
        AsconPermutationFriend.AsconPermutation asconPermutation;
        long j;
        long j2;
        int iOrdinal = this.asconParameters.ordinal();
        if (iOrdinal == 0) {
            asconPermutation = this.f19737p;
            long j3 = asconPermutation.f19741x1;
            long j4 = this.f19731K0 << 32;
            long j5 = this.f19732K1;
            asconPermutation.f19741x1 = j3 ^ (j4 | (j5 >> 32));
            long j6 = asconPermutation.f19742x2;
            long j7 = j5 << 32;
            long j8 = this.f19738K2;
            asconPermutation.f19742x2 = j6 ^ (j7 | (j8 >> 32));
            j = asconPermutation.f19743x3;
            j2 = j8 << 32;
        } else {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    throw new IllegalStateException();
                }
                AsconPermutationFriend.AsconPermutation asconPermutation2 = this.f19737p;
                asconPermutation2.f19741x1 ^= this.f19732K1;
                asconPermutation2.f19742x2 ^= this.f19738K2;
                this.f19737p.m15266p(12);
                AsconPermutationFriend.AsconPermutation asconPermutation3 = this.f19737p;
                asconPermutation3.f19743x3 ^= this.f19732K1;
                asconPermutation3.f19744x4 ^= this.f19738K2;
                this.f19653m_state = c5335State;
            }
            asconPermutation = this.f19737p;
            asconPermutation.f19742x2 ^= this.f19732K1;
            j = asconPermutation.f19743x3;
            j2 = this.f19738K2;
        }
        asconPermutation.f19743x3 = j ^ j2;
        this.f19737p.m15266p(12);
        AsconPermutationFriend.AsconPermutation asconPermutation32 = this.f19737p;
        asconPermutation32.f19743x3 ^= this.f19732K1;
        asconPermutation32.f19744x4 ^= this.f19738K2;
        this.f19653m_state = c5335State;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AsconBaseEngine
    public String getAlgorithmVersion() {
        return "v1.2";
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
        return AbstractC6245Pack.bigEndianToLong(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AsconBaseEngine
    /* renamed from: pad */
    public long mo15262pad(int i) {
        return 128 << (56 - (i << 3));
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
        byte[] bArr = this.f19651m_aad;
        int i = this.m_aadPos;
        bArr[i] = ByteCompanionObject.MIN_VALUE;
        if (i < 8) {
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f19737p;
            asconPermutation.f19740x0 = (((-1) << (56 - (this.m_aadPos << 3))) & AbstractC6245Pack.bigEndianToLong(bArr, 0)) ^ asconPermutation.f19740x0;
            return;
        }
        this.f19737p.f19740x0 ^= AbstractC6245Pack.bigEndianToLong(bArr, 0);
        AsconPermutationFriend.AsconPermutation asconPermutation2 = this.f19737p;
        asconPermutation2.f19741x1 = (((-1) << (56 - ((this.m_aadPos - 8) << 3))) & AbstractC6245Pack.bigEndianToLong(this.f19651m_aad, 8)) ^ asconPermutation2.f19741x1;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AsconBaseEngine
    public void processFinalDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (i >= 8) {
            long jBigEndianToLong = AbstractC6245Pack.bigEndianToLong(bArr, 0);
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f19737p;
            long j = asconPermutation.f19740x0 ^ jBigEndianToLong;
            asconPermutation.f19740x0 = j;
            AbstractC6245Pack.longToBigEndian(j, bArr2, i2);
            AsconPermutationFriend.AsconPermutation asconPermutation2 = this.f19737p;
            asconPermutation2.f19740x0 = jBigEndianToLong;
            int i3 = i2 + 8;
            int i4 = i - 8;
            asconPermutation2.f19741x1 ^= mo15262pad(i4);
            if (i4 > 0) {
                long jBigEndianToLong_High = AbstractC6245Pack.bigEndianToLong_High(bArr, 8, i4);
                AsconPermutationFriend.AsconPermutation asconPermutation3 = this.f19737p;
                long j2 = asconPermutation3.f19741x1 ^ jBigEndianToLong_High;
                asconPermutation3.f19741x1 = j2;
                AbstractC6245Pack.longToBigEndian_High(j2, bArr2, i3, i4);
                AsconPermutationFriend.AsconPermutation asconPermutation4 = this.f19737p;
                asconPermutation4.f19741x1 = (asconPermutation4.f19741x1 & ((-1) >>> (i4 << 3))) ^ jBigEndianToLong_High;
            }
        } else {
            this.f19737p.f19740x0 ^= mo15262pad(i);
            if (i > 0) {
                long jBigEndianToLong_High2 = AbstractC6245Pack.bigEndianToLong_High(bArr, 0, i);
                AsconPermutationFriend.AsconPermutation asconPermutation5 = this.f19737p;
                long j3 = asconPermutation5.f19740x0 ^ jBigEndianToLong_High2;
                asconPermutation5.f19740x0 = j3;
                AbstractC6245Pack.longToBigEndian_High(j3, bArr2, i2, i);
                AsconPermutationFriend.AsconPermutation asconPermutation6 = this.f19737p;
                asconPermutation6.f19740x0 = (asconPermutation6.f19740x0 & ((-1) >>> (i << 3))) ^ jBigEndianToLong_High2;
            }
        }
        finishData(AEADBaseEngine.C5335State.DecFinal);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AsconBaseEngine
    public void processFinalEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        long j;
        if (i >= 8) {
            this.f19737p.f19740x0 ^= AbstractC6245Pack.bigEndianToLong(bArr, 0);
            AbstractC6245Pack.longToBigEndian(this.f19737p.f19740x0, bArr2, i2);
            i2 += 8;
            i -= 8;
            this.f19737p.f19741x1 ^= mo15262pad(i);
            if (i > 0) {
                this.f19737p.f19741x1 ^= AbstractC6245Pack.bigEndianToLong_High(bArr, 8, i);
                j = this.f19737p.f19741x1;
                AbstractC6245Pack.longToBigEndian_High(j, bArr2, i2, i);
            }
        } else {
            this.f19737p.f19740x0 ^= mo15262pad(i);
            if (i > 0) {
                this.f19737p.f19740x0 ^= AbstractC6245Pack.bigEndianToLong_High(bArr, 0, i);
                j = this.f19737p.f19740x0;
                AbstractC6245Pack.longToBigEndian_High(j, bArr2, i2, i);
            }
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
        AbstractC6245Pack.longToBigEndian(j, bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    /* renamed from: init */
    public void mo15227init(byte[] bArr, byte[] bArr2) {
        long jBigEndianToLong;
        this.f19733N0 = AbstractC6245Pack.bigEndianToLong(bArr2, 0);
        this.f19734N1 = AbstractC6245Pack.bigEndianToLong(bArr2, 8);
        int i = this.KEY_SIZE;
        if (i == 16) {
            this.f19732K1 = AbstractC6245Pack.bigEndianToLong(bArr, 0);
            jBigEndianToLong = AbstractC6245Pack.bigEndianToLong(bArr, 8);
        } else {
            if (i != 20) {
                throw new IllegalStateException();
            }
            this.f19731K0 = AbstractC6245Pack.bigEndianToInt(bArr, 0);
            this.f19732K1 = AbstractC6245Pack.bigEndianToLong(bArr, 4);
            jBigEndianToLong = AbstractC6245Pack.bigEndianToLong(bArr, 12);
        }
        this.f19738K2 = jBigEndianToLong;
    }
}
