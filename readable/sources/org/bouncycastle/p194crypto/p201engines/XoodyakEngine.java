package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p199digests.XoodyakDigest;
import org.bouncycastle.p194crypto.p201engines.AEADBaseEngine;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class XoodyakEngine extends AEADBaseEngine {
    private static final int ModeHash = 1;
    private static final int ModeKeyed = 0;
    private static final int PhaseDown = 1;

    /* renamed from: PhaseUp */
    private static final int f20161PhaseUp = 2;

    /* renamed from: RC */
    private static final int[] f20162RC = {88, 56, 960, 208, 288, 20, 96, 44, 896, 240, 416, 18};
    private static final int f_bPrime_1 = 47;

    /* renamed from: K */
    private byte[] f20163K;

    /* renamed from: aadcd */
    private byte f20164aadcd;
    private boolean encrypted;

    /* renamed from: iv */
    private byte[] f20165iv;

    /* renamed from: mode */
    private int f20166mode;

    /* renamed from: phase */
    private int f20167phase;

    /* renamed from: state */
    private final byte[] f20168state;

    public XoodyakEngine() {
        this.algorithmName = "Xoodyak AEAD";
        this.MAC_SIZE = 16;
        this.f19650IV_SIZE = 16;
        this.KEY_SIZE = 16;
        this.BlockSize = 24;
        this.AADBufferSize = 44;
        this.f20168state = new byte[48];
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Immediate, AEADBaseEngine.AADOperatorType.f19658Default, AEADBaseEngine.DataOperatorType.f19672Counter);
    }

    private void AbsorbAny(byte[] bArr, int i, int i2, int i3) {
        if (this.f20167phase != 2) {
            m15454up(this.f20166mode, this.f20168state, 0);
        }
        int i4 = i3;
        while (true) {
            int iMin = Math.min(i2, this.AADBufferSize);
            m15452down(this.f20166mode, this.f20168state, bArr, i, iMin, i4);
            this.f20167phase = 1;
            i += iMin;
            i2 -= iMin;
            if (i2 == 0) {
                return;
            } else {
                i4 = 0;
            }
        }
    }

    /* renamed from: down */
    private static void m15452down(int i, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        C6240Bytes.m18279xorTo(i3, bArr2, i2, bArr);
        bArr[i3] = (byte) (bArr[i3] ^ 1);
        int i5 = bArr[47];
        if (i == 1) {
            i4 &= 1;
        }
        bArr[47] = (byte) (i5 ^ i4);
    }

    /* renamed from: up */
    private static void m15454up(int i, byte[] bArr, int i2) {
        byte[] bArr2 = bArr;
        if (i != 1) {
            bArr2[47] = (byte) (bArr2[47] ^ i2);
        }
        int iLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(bArr2, 0);
        int iLittleEndianToInt2 = AbstractC6245Pack.littleEndianToInt(bArr2, 4);
        int iLittleEndianToInt3 = AbstractC6245Pack.littleEndianToInt(bArr2, 8);
        int i3 = 12;
        int iLittleEndianToInt4 = AbstractC6245Pack.littleEndianToInt(bArr2, 12);
        int iLittleEndianToInt5 = AbstractC6245Pack.littleEndianToInt(bArr2, 16);
        int iLittleEndianToInt6 = AbstractC6245Pack.littleEndianToInt(bArr2, 20);
        int iLittleEndianToInt7 = AbstractC6245Pack.littleEndianToInt(bArr2, 24);
        int iLittleEndianToInt8 = AbstractC6245Pack.littleEndianToInt(bArr2, 28);
        int iLittleEndianToInt9 = AbstractC6245Pack.littleEndianToInt(bArr2, 32);
        int i4 = 0;
        int iRotateLeft = iLittleEndianToInt8;
        int iRotateLeft2 = iLittleEndianToInt9;
        int iLittleEndianToInt10 = AbstractC6245Pack.littleEndianToInt(bArr2, 36);
        int iLittleEndianToInt11 = AbstractC6245Pack.littleEndianToInt(bArr2, 40);
        int iLittleEndianToInt12 = AbstractC6245Pack.littleEndianToInt(bArr2, 44);
        while (i4 < i3) {
            int i5 = (iLittleEndianToInt ^ iLittleEndianToInt5) ^ iRotateLeft2;
            int i6 = (iLittleEndianToInt2 ^ iLittleEndianToInt6) ^ iLittleEndianToInt10;
            int i7 = (iLittleEndianToInt3 ^ iLittleEndianToInt7) ^ iLittleEndianToInt11;
            int i8 = i4;
            int i9 = (iLittleEndianToInt4 ^ iRotateLeft) ^ iLittleEndianToInt12;
            int i10 = iLittleEndianToInt12;
            int iRotateLeft3 = Integers.rotateLeft(i9, 5) ^ Integers.rotateLeft(i9, 14);
            int iRotateLeft4 = Integers.rotateLeft(i5, 5) ^ Integers.rotateLeft(i5, 14);
            int iRotateLeft5 = Integers.rotateLeft(i6, 5) ^ Integers.rotateLeft(i6, 14);
            int iRotateLeft6 = Integers.rotateLeft(i7, 14) ^ Integers.rotateLeft(i7, 5);
            int i11 = iLittleEndianToInt ^ iRotateLeft3;
            int i12 = iLittleEndianToInt5 ^ iRotateLeft3;
            int i13 = iLittleEndianToInt2 ^ iRotateLeft4;
            int i14 = iLittleEndianToInt6 ^ iRotateLeft4;
            int i15 = iRotateLeft4 ^ iLittleEndianToInt10;
            int i16 = iLittleEndianToInt3 ^ iRotateLeft5;
            int i17 = iLittleEndianToInt7 ^ iRotateLeft5;
            int i18 = iRotateLeft5 ^ iLittleEndianToInt11;
            int i19 = iLittleEndianToInt4 ^ iRotateLeft6;
            int i20 = iRotateLeft ^ iRotateLeft6;
            int iRotateLeft7 = Integers.rotateLeft(iRotateLeft3 ^ iRotateLeft2, 11);
            int iRotateLeft8 = Integers.rotateLeft(i15, 11);
            int iRotateLeft9 = Integers.rotateLeft(i18, 11);
            int iRotateLeft10 = Integers.rotateLeft(i10 ^ iRotateLeft6, 11);
            int i21 = i11 ^ f20162RC[i8];
            int i22 = ((~i20) & iRotateLeft7) ^ i21;
            int i23 = ((~i12) & iRotateLeft8) ^ i13;
            int i24 = ((~i14) & iRotateLeft9) ^ i16;
            int i25 = ((~i17) & iRotateLeft10) ^ i19;
            int i26 = ((~iRotateLeft7) & i21) ^ i20;
            int i27 = ((~iRotateLeft8) & i13) ^ i12;
            int i28 = ((~iRotateLeft9) & i16) ^ i14;
            int i29 = ((~iRotateLeft10) & i19) ^ i17;
            int i30 = ((~i21) & i20) ^ iRotateLeft7;
            int i31 = (i12 & (~i13)) ^ iRotateLeft8;
            int i32 = iRotateLeft9 ^ ((~i16) & i14);
            int i33 = iRotateLeft10 ^ ((~i19) & i17);
            iLittleEndianToInt5 = Integers.rotateLeft(i26, 1);
            iLittleEndianToInt6 = Integers.rotateLeft(i27, 1);
            int iRotateLeft11 = Integers.rotateLeft(i28, 1);
            iRotateLeft = Integers.rotateLeft(i29, 1);
            iRotateLeft2 = Integers.rotateLeft(i32, 8);
            iLittleEndianToInt10 = Integers.rotateLeft(i33, 8);
            int iRotateLeft12 = Integers.rotateLeft(i30, 8);
            iLittleEndianToInt12 = Integers.rotateLeft(i31, 8);
            iLittleEndianToInt7 = iRotateLeft11;
            iLittleEndianToInt = i22;
            iLittleEndianToInt2 = i23;
            iLittleEndianToInt3 = i24;
            iLittleEndianToInt4 = i25;
            i3 = 12;
            iLittleEndianToInt11 = iRotateLeft12;
            bArr2 = bArr;
            i4 = i8 + 1;
        }
        AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt, bArr2, 0);
        AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt2, bArr2, 4);
        AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt3, bArr2, 8);
        AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt4, bArr2, 12);
        AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt5, bArr2, 16);
        AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt6, bArr2, 20);
        AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt7, bArr2, 24);
        AbstractC6245Pack.intToLittleEndian(iRotateLeft, bArr2, 28);
        AbstractC6245Pack.intToLittleEndian(iRotateLeft2, bArr2, 32);
        AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt10, bArr2, 36);
        AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt11, bArr2, 40);
        AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt12, bArr2, 44);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: doFinal */
    public /* bridge */ /* synthetic */ int mo15224doFinal(byte[] bArr, int i) {
        return super.mo15224doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void finishAAD(AEADBaseEngine.C5335State c5335State, boolean z) {
        finishAAD3(c5335State, z);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
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

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADByte(byte b) {
        super.processAADByte(b);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADBytes(byte[] bArr, int i, int i2) {
        super.processAADBytes(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferAAD(byte[] bArr, int i) {
        AbsorbAny(bArr, i, this.AADBufferSize, this.f20164aadcd);
        this.f20164aadcd = (byte) 0;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        m15454up(this.f20166mode, this.f20168state, this.encrypted ? 0 : 128);
        C6240Bytes.m18276xor(this.BlockSize, this.f20168state, bArr, i, bArr2, i2);
        m15452down(this.f20166mode, this.f20168state, bArr2, i2, this.BlockSize, 0);
        this.f20167phase = 1;
        this.encrypted = true;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        m15454up(this.f20166mode, this.f20168state, this.encrypted ? 0 : 128);
        C6240Bytes.m18276xor(this.BlockSize, this.f20168state, bArr, i, bArr2, i2);
        m15452down(this.f20166mode, this.f20168state, bArr, i, this.BlockSize, 0);
        this.f20167phase = 1;
        this.encrypted = true;
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
        AbsorbAny(this.f19651m_aad, 0, this.m_aadPos, this.f20164aadcd);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processFinalBlock(byte[] bArr, int i) {
        if (this.m_bufPos != 0 || !this.encrypted) {
            m15454up(this.f20166mode, this.f20168state, this.encrypted ? 0 : 128);
            C6240Bytes.m18276xor(this.m_bufPos, this.f20168state, this.f19652m_buf, 0, bArr, i);
            if (this.forEncryption) {
                m15452down(this.f20166mode, this.f20168state, this.f19652m_buf, 0, this.m_bufPos, 0);
            } else {
                m15452down(this.f20166mode, this.f20168state, bArr, i, this.m_bufPos, 0);
            }
            this.f20167phase = 1;
        }
        m15454up(this.f20166mode, this.f20168state, 64);
        System.arraycopy(this.f20168state, 0, this.f19654mac, 0, this.MAC_SIZE);
        this.f20167phase = 2;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: reset */
    public /* bridge */ /* synthetic */ void mo15228reset() {
        super.mo15228reset();
    }

    /* renamed from: down */
    public static void m15453down(XoodyakDigest.C5299Friend c5299Friend, int i, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        if (c5299Friend == null) {
            throw new NullPointerException("This method is only for use by XoodyakDigest");
        }
        m15452down(i, bArr, bArr2, i2, i3, i4);
    }

    /* renamed from: up */
    public static void m15455up(XoodyakDigest.C5299Friend c5299Friend, int i, byte[] bArr, int i2) {
        if (c5299Friend == null) {
            throw new NullPointerException("This method is only for use by XoodyakDigest");
        }
        m15454up(i, bArr, i2);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    /* renamed from: init */
    public void mo15227init(byte[] bArr, byte[] bArr2) {
        this.f20163K = bArr;
        this.f20165iv = bArr2;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    /* renamed from: reset */
    public void mo15229reset(boolean z) {
        super.mo15229reset(z);
        C6238Arrays.m18249fill(this.f20168state, (byte) 0);
        this.encrypted = false;
        this.f20167phase = 2;
        this.f20164aadcd = (byte) 3;
        byte[] bArr = this.f20163K;
        int length = bArr.length;
        int length2 = this.f20165iv.length;
        byte[] bArr2 = new byte[this.AADBufferSize];
        this.f20166mode = 0;
        System.arraycopy(bArr, 0, bArr2, 0, length);
        System.arraycopy(this.f20165iv, 0, bArr2, length, length2);
        int i = length + length2;
        bArr2[i] = (byte) length2;
        AbsorbAny(bArr2, 0, i + 1, 2);
    }
}
