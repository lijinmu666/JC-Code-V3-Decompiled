package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p201engines.AEADBaseEngine;
import org.bouncycastle.p361util.C6240Bytes;
import p094kotlin.C1126UByte;
import p094kotlin.p101io.encoding.C1217Base64;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public class GiftCofbEngine extends AEADBaseEngine {

    /* renamed from: GIFT_RC */
    private static final byte[] f19881GIFT_RC = {1, 3, 7, 15, 31, 62, C1217Base64.padSymbol, 59, 55, 47, 30, 60, 57, 51, 39, 14, 29, 58, 53, 43, 22, 44, 24, 48, 33, 2, 5, 11, 23, 46, 28, 56, 49, 35, 6, 13, 27, 54, 45, 26};

    /* renamed from: Y */
    private byte[] f19882Y;

    /* renamed from: input */
    private byte[] f19883input;

    /* renamed from: k */
    private byte[] f19884k;

    /* renamed from: npub */
    private byte[] f19885npub;

    /* renamed from: offset */
    private byte[] f19886offset;

    public GiftCofbEngine() {
        this.KEY_SIZE = 16;
        this.f19650IV_SIZE = 16;
        this.MAC_SIZE = 16;
        this.BlockSize = 16;
        this.AADBufferSize = 16;
        this.algorithmName = "GIFT-COFB AEAD";
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Buffered, AEADBaseEngine.AADOperatorType.f19658Default, AEADBaseEngine.DataOperatorType.f19672Counter);
    }

    private void double_half_block(byte[] bArr) {
        int i = 0;
        int i2 = ((bArr[0] & C1126UByte.MAX_VALUE) >>> 7) * 27;
        while (i < 7) {
            int i3 = i + 1;
            bArr[i] = (byte) (((bArr[i] & C1126UByte.MAX_VALUE) << 1) | ((bArr[i3] & C1126UByte.MAX_VALUE) >>> 7));
            i = i3;
        }
        bArr[7] = (byte) (((bArr[7] & C1126UByte.MAX_VALUE) << 1) ^ i2);
    }

    private void giftb128(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = {((bArr[0] & C1126UByte.MAX_VALUE) << 24) | ((bArr[1] & C1126UByte.MAX_VALUE) << 16) | ((bArr[2] & C1126UByte.MAX_VALUE) << 8) | (bArr[3] & C1126UByte.MAX_VALUE), ((bArr[4] & C1126UByte.MAX_VALUE) << 24) | ((bArr[5] & C1126UByte.MAX_VALUE) << 16) | ((bArr[6] & C1126UByte.MAX_VALUE) << 8) | (bArr[7] & C1126UByte.MAX_VALUE), ((bArr[8] & C1126UByte.MAX_VALUE) << 24) | ((bArr[9] & C1126UByte.MAX_VALUE) << 16) | ((bArr[10] & C1126UByte.MAX_VALUE) << 8) | (bArr[11] & C1126UByte.MAX_VALUE), ((bArr[13] & C1126UByte.MAX_VALUE) << 16) | ((bArr[12] & C1126UByte.MAX_VALUE) << 24) | ((bArr[14] & C1126UByte.MAX_VALUE) << 8) | (bArr[15] & C1126UByte.MAX_VALUE)};
        short[] sArr = {(short) (((bArr2[0] & C1126UByte.MAX_VALUE) << 8) | (bArr2[1] & C1126UByte.MAX_VALUE)), (short) (((bArr2[2] & C1126UByte.MAX_VALUE) << 8) | (bArr2[3] & C1126UByte.MAX_VALUE)), (short) (((bArr2[4] & C1126UByte.MAX_VALUE) << 8) | (bArr2[5] & C1126UByte.MAX_VALUE)), (short) (((bArr2[6] & C1126UByte.MAX_VALUE) << 8) | (bArr2[7] & C1126UByte.MAX_VALUE)), (short) (((bArr2[8] & C1126UByte.MAX_VALUE) << 8) | (bArr2[9] & C1126UByte.MAX_VALUE)), (short) (((bArr2[10] & C1126UByte.MAX_VALUE) << 8) | (bArr2[11] & C1126UByte.MAX_VALUE)), (short) (((bArr2[12] & C1126UByte.MAX_VALUE) << 8) | (bArr2[13] & C1126UByte.MAX_VALUE)), (short) (((bArr2[14] & C1126UByte.MAX_VALUE) << 8) | (bArr2[15] & C1126UByte.MAX_VALUE))};
        for (int i = 0; i < 40; i++) {
            int i2 = iArr[1];
            int i3 = iArr[0];
            int i4 = iArr[2];
            int i5 = i2 ^ (i3 & i4);
            iArr[1] = i5;
            int i6 = iArr[3];
            int i7 = i3 ^ (i5 & i6);
            iArr[0] = i7;
            int i8 = i4 ^ (i7 | i5);
            iArr[2] = i8;
            int i9 = i6 ^ i8;
            iArr[3] = i9;
            int i10 = i5 ^ i9;
            iArr[1] = i10;
            int i11 = ~i9;
            iArr[3] = i11;
            iArr[2] = i8 ^ (i10 & i7);
            iArr[0] = i11;
            iArr[3] = i7;
            iArr[0] = m15322rowperm(i11, 0, 3, 2, 1);
            iArr[1] = m15322rowperm(iArr[1], 1, 0, 3, 2);
            iArr[2] = m15322rowperm(iArr[2], 2, 1, 0, 3);
            int iM15322rowperm = m15322rowperm(iArr[3], 3, 2, 1, 0);
            iArr[3] = iM15322rowperm;
            int i12 = iArr[2];
            short s = sArr[2];
            short s2 = sArr[3];
            iArr[2] = i12 ^ (((s & 65535) << 16) | (s2 & 65535));
            int i13 = iArr[1];
            short s3 = sArr[6];
            short s4 = sArr[7];
            iArr[1] = i13 ^ (((s3 & 65535) << 16) | (s4 & 65535));
            iArr[3] = iM15322rowperm ^ ((f19881GIFT_RC[i] & C1126UByte.MAX_VALUE) ^ Integer.MIN_VALUE);
            sArr[7] = sArr[5];
            sArr[6] = sArr[4];
            sArr[5] = s2;
            sArr[4] = s;
            sArr[3] = sArr[1];
            sArr[2] = sArr[0];
            sArr[1] = (short) (((s4 & 65535) >>> 12) | ((s4 & 65535) << 4));
            sArr[0] = (short) (((s3 & 65535) >>> 2) | ((s3 & 65535) << 14));
        }
        int i14 = iArr[0];
        bArr3[0] = (byte) (i14 >>> 24);
        bArr3[1] = (byte) (i14 >>> 16);
        bArr3[2] = (byte) (i14 >>> 8);
        bArr3[3] = (byte) i14;
        int i15 = iArr[1];
        bArr3[4] = (byte) (i15 >>> 24);
        bArr3[5] = (byte) (i15 >>> 16);
        bArr3[6] = (byte) (i15 >>> 8);
        bArr3[7] = (byte) i15;
        int i16 = iArr[2];
        bArr3[8] = (byte) (i16 >>> 24);
        bArr3[9] = (byte) (i16 >>> 16);
        bArr3[10] = (byte) (i16 >>> 8);
        bArr3[11] = (byte) i16;
        int i17 = iArr[3];
        bArr3[12] = (byte) (i17 >>> 24);
        bArr3[13] = (byte) (i17 >>> 16);
        bArr3[14] = (byte) (i17 >>> 8);
        bArr3[15] = (byte) i17;
    }

    /* renamed from: pho1 */
    private void m15321pho1(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[16];
        if (i2 == 0) {
            bArr4[0] = ByteCompanionObject.MIN_VALUE;
        } else {
            System.arraycopy(bArr3, i, bArr4, 0, i2);
            if (i2 < 16) {
                bArr4[i2] = ByteCompanionObject.MIN_VALUE;
            }
        }
        System.arraycopy(bArr2, 8, bArr5, 0, 8);
        int i3 = 0;
        while (i3 < 7) {
            int i4 = i3 + 8;
            int i5 = (bArr2[i3] & C1126UByte.MAX_VALUE) << 1;
            i3++;
            bArr5[i4] = (byte) (((bArr2[i3] & C1126UByte.MAX_VALUE) >>> 7) | i5);
        }
        bArr5[15] = (byte) (((bArr2[7] & C1126UByte.MAX_VALUE) << 1) | ((bArr2[0] & C1126UByte.MAX_VALUE) >>> 7));
        System.arraycopy(bArr5, 0, bArr2, 0, 16);
        C6240Bytes.m18277xor(16, bArr2, bArr4, bArr);
    }

    /* renamed from: rowperm */
    private int m15322rowperm(int i, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        for (int i7 = 0; i7 < 8; i7++) {
            int i8 = i7 * 4;
            i6 = i6 | (((i >>> i8) & 1) << ((i2 * 8) + i7)) | (((i >>> (i8 + 1)) & 1) << ((i3 * 8) + i7)) | (((i >>> (i8 + 2)) & 1) << ((i4 * 8) + i7)) | (((i >>> (i8 + 3)) & 1) << ((8 * i5) + i7));
        }
        return i6;
    }

    private void triple_half_block(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        int i = 0;
        while (i < 7) {
            int i2 = i + 1;
            bArr2[i] = (byte) (((bArr[i2] & C1126UByte.MAX_VALUE) >>> 7) | ((bArr[i] & C1126UByte.MAX_VALUE) << 1));
            i = i2;
        }
        bArr2[7] = (byte) ((((bArr[0] & C1126UByte.MAX_VALUE) >>> 7) * 27) ^ ((bArr[7] & C1126UByte.MAX_VALUE) << 1));
        C6240Bytes.m18281xorTo(8, bArr2, bArr);
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
        m15321pho1(this.f19883input, this.f19882Y, bArr, i, 16);
        double_half_block(this.f19886offset);
        C6240Bytes.m18281xorTo(8, this.f19886offset, this.f19883input);
        giftb128(this.f19883input, this.f19884k, this.f19882Y);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        double_half_block(this.f19886offset);
        C6240Bytes.m18276xor(this.BlockSize, this.f19882Y, bArr, i, bArr2, i2);
        m15321pho1(this.f19883input, this.f19882Y, bArr2, i2, this.BlockSize);
        C6240Bytes.m18281xorTo(8, this.f19886offset, this.f19883input);
        giftb128(this.f19883input, this.f19884k, this.f19882Y);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        double_half_block(this.f19886offset);
        C6240Bytes.m18276xor(this.BlockSize, this.f19882Y, bArr, i, bArr2, i2);
        m15321pho1(this.f19883input, this.f19882Y, bArr, i, this.BlockSize);
        C6240Bytes.m18281xorTo(8, this.f19886offset, this.f19883input);
        giftb128(this.f19883input, this.f19884k, this.f19882Y);
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
        AEADBaseEngine.C5335State c5335State;
        int iMo15232getLen = this.dataOperator.mo15232getLen() - (this.forEncryption ? 0 : this.MAC_SIZE);
        triple_half_block(this.f19886offset);
        if ((this.m_aadPos & 15) != 0 || (c5335State = this.f19653m_state) == AEADBaseEngine.C5335State.f19687DecInit || c5335State == AEADBaseEngine.C5335State.f19691EncInit) {
            triple_half_block(this.f19886offset);
        }
        if (iMo15232getLen == 0) {
            triple_half_block(this.f19886offset);
            triple_half_block(this.f19886offset);
        }
        m15321pho1(this.f19883input, this.f19882Y, this.f19651m_aad, 0, this.m_aadPos);
        C6240Bytes.m18281xorTo(8, this.f19886offset, this.f19883input);
        giftb128(this.f19883input, this.f19884k, this.f19882Y);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processFinalBlock(byte[] bArr, int i) {
        int iMo15232getLen = this.dataOperator.mo15232getLen() - (this.forEncryption ? 0 : this.MAC_SIZE);
        if (iMo15232getLen != 0) {
            triple_half_block(this.f19886offset);
            if ((iMo15232getLen & 15) != 0) {
                triple_half_block(this.f19886offset);
            }
            C6240Bytes.m18276xor(this.m_bufPos, this.f19882Y, this.f19652m_buf, 0, bArr, i);
            boolean z = this.forEncryption;
            byte[] bArr2 = this.f19883input;
            byte[] bArr3 = this.f19882Y;
            if (z) {
                m15321pho1(bArr2, bArr3, this.f19652m_buf, 0, this.m_bufPos);
            } else {
                m15321pho1(bArr2, bArr3, bArr, i, this.m_bufPos);
            }
            C6240Bytes.m18281xorTo(8, this.f19886offset, this.f19883input);
            giftb128(this.f19883input, this.f19884k, this.f19882Y);
        }
        System.arraycopy(this.f19882Y, 0, this.f19654mac, 0, this.BlockSize);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: reset */
    public /* bridge */ /* synthetic */ void mo15228reset() {
        super.mo15228reset();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    /* renamed from: init */
    public void mo15227init(byte[] bArr, byte[] bArr2) {
        this.f19885npub = bArr2;
        this.f19884k = bArr;
        this.f19882Y = new byte[this.BlockSize];
        this.f19883input = new byte[16];
        this.f19886offset = new byte[8];
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    /* renamed from: reset */
    public void mo15229reset(boolean z) {
        super.mo15229reset(z);
        System.arraycopy(this.f19885npub, 0, this.f19883input, 0, this.f19650IV_SIZE);
        giftb128(this.f19883input, this.f19884k, this.f19882Y);
        System.arraycopy(this.f19882Y, 0, this.f19886offset, 0, 8);
    }
}
