package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p133asn1.p174x509.DisplayText;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p284math.AbstractC5816Primes;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Memoable;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public final class WhirlpoolDigest implements ExtendedDigest, Memoable {
    private static final int BITCOUNT_ARRAY_SIZE = 32;
    private static final int BYTE_LENGTH = 64;
    private static final int DIGEST_LENGTH_BYTES = 64;

    /* renamed from: EIGHT */
    private static final short[] f19606EIGHT;
    private static final int REDUCTION_POLYNOMIAL = 285;

    /* renamed from: ROUNDS */
    private static final int f19607ROUNDS = 10;

    /* renamed from: _K */
    private long[] f19609_K;

    /* renamed from: _L */
    private long[] f19610_L;
    private short[] _bitCount;

    /* renamed from: _block */
    private long[] f19611_block;

    /* renamed from: _buffer */
    private byte[] f19612_buffer;
    private int _bufferPos;

    /* renamed from: _hash */
    private long[] f19613_hash;

    /* renamed from: _rc */
    private final long[] f19614_rc;

    /* renamed from: _state */
    private long[] f19615_state;

    /* renamed from: purpose */
    private final CryptoServicePurpose f19616purpose;

    /* renamed from: SBOX */
    private static final int[] f19608SBOX = {24, 35, 198, 232, 135, 184, 1, 79, 54, 166, 210, 245, 121, 111, 145, 82, 96, 188, 155, 142, 163, 12, 123, 53, 29, InterfaceC5102BERTags.f17976FLAGS, 215, 194, 46, 75, 254, 87, 21, 119, 55, 229, 159, 240, 74, 218, 88, 201, 41, 10, 177, 160, 107, 133, 189, 93, 16, 244, 203, 62, 5, 103, 228, 39, 65, 139, 167, 125, 149, 216, 251, 238, 124, 102, 221, 23, 71, 158, 202, 45, 191, 7, 173, 90, 131, 51, 99, 2, 170, 113, DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE, 25, 73, 217, 242, 227, 91, 136, 154, 38, 50, 176, 233, 15, 213, 128, 190, 205, 52, 72, 255, 122, 144, 95, 32, 104, 26, 174, 180, 84, 147, 34, 100, 241, 115, 18, 64, 8, 195, 236, 219, 161, 141, 61, 151, 0, 207, 43, 118, 130, 214, 27, 181, 175, 106, 80, 69, 243, 48, 239, 63, 85, 162, 234, 101, 186, 47, 192, 222, 28, 253, 77, 146, 117, 6, 138, 178, 230, 14, 31, 98, 212, 168, 150, 249, 197, 37, 89, 132, 114, 57, 76, 94, 120, 56, 140, 209, 165, 226, 97, 179, 33, 156, 30, 67, 199, 252, 4, 81, 153, 109, 13, 250, 223, 126, 36, 59, 171, 206, 17, 143, 78, 183, 235, 60, 129, 148, 247, 185, 19, 44, AbstractC5816Primes.SMALL_FACTOR_LIMIT, 231, 110, 196, 3, 86, 68, 127, 169, 42, 187, 193, 83, 220, 11, 157, 108, 49, 116, 246, 70, 172, 137, 20, 225, 22, 58, 105, 9, 112, 182, 208, 237, 204, 66, 152, 164, 40, 92, 248, 134};

    /* renamed from: C0 */
    private static final long[] f19598C0 = new long[256];

    /* renamed from: C1 */
    private static final long[] f19599C1 = new long[256];

    /* renamed from: C2 */
    private static final long[] f19600C2 = new long[256];

    /* renamed from: C3 */
    private static final long[] f19601C3 = new long[256];

    /* renamed from: C4 */
    private static final long[] f19602C4 = new long[256];

    /* renamed from: C5 */
    private static final long[] f19603C5 = new long[256];

    /* renamed from: C6 */
    private static final long[] f19604C6 = new long[256];

    /* renamed from: C7 */
    private static final long[] f19605C7 = new long[256];

    static {
        short[] sArr = new short[32];
        f19606EIGHT = sArr;
        sArr[31] = 8;
        for (int i = 0; i < 256; i++) {
            int i2 = f19608SBOX[i];
            int iM15210mulX = m15210mulX(i2);
            int iM15210mulX2 = m15210mulX(iM15210mulX);
            int i3 = iM15210mulX2 ^ i2;
            int iM15210mulX3 = m15210mulX(iM15210mulX2);
            int i4 = iM15210mulX3 ^ i2;
            f19598C0[i] = packIntoLong(i2, i2, iM15210mulX2, i2, iM15210mulX3, i3, iM15210mulX, i4);
            f19599C1[i] = packIntoLong(i4, i2, i2, iM15210mulX2, i2, iM15210mulX3, i3, iM15210mulX);
            f19600C2[i] = packIntoLong(iM15210mulX, i4, i2, i2, iM15210mulX2, i2, iM15210mulX3, i3);
            f19601C3[i] = packIntoLong(i3, iM15210mulX, i4, i2, i2, iM15210mulX2, i2, iM15210mulX3);
            f19602C4[i] = packIntoLong(iM15210mulX3, i3, iM15210mulX, i4, i2, i2, iM15210mulX2, i2);
            f19603C5[i] = packIntoLong(i2, iM15210mulX3, i3, iM15210mulX, i4, i2, i2, iM15210mulX2);
            f19604C6[i] = packIntoLong(iM15210mulX2, i2, iM15210mulX3, i3, iM15210mulX, i4, i2, i2);
            f19605C7[i] = packIntoLong(i2, iM15210mulX2, i2, iM15210mulX3, i3, iM15210mulX, i4, i2);
        }
    }

    public WhirlpoolDigest() {
        this(CryptoServicePurpose.ANY);
    }

    private byte[] copyBitLength() {
        byte[] bArr = new byte[32];
        for (int i = 0; i < 32; i++) {
            bArr[i] = (byte) (this._bitCount[i] & 255);
        }
        return bArr;
    }

    /* renamed from: finish */
    private void m15209finish() {
        byte[] bArrCopyBitLength = copyBitLength();
        byte[] bArr = this.f19612_buffer;
        int i = this._bufferPos;
        bArr[i] = (byte) (bArr[i] | ByteCompanionObject.MIN_VALUE);
        int i2 = i + 1;
        this._bufferPos = i2;
        if (i2 == bArr.length) {
            processFilledBuffer(bArr, 0);
        }
        if (this._bufferPos > 32) {
            while (this._bufferPos != 0) {
                mo14969update((byte) 0);
            }
        }
        while (this._bufferPos <= 32) {
            mo14969update((byte) 0);
        }
        System.arraycopy(bArrCopyBitLength, 0, this.f19612_buffer, 32, bArrCopyBitLength.length);
        processFilledBuffer(this.f19612_buffer, 0);
    }

    private void increment() {
        int i = 0;
        for (int length = this._bitCount.length - 1; length >= 0; length--) {
            short[] sArr = this._bitCount;
            int i2 = (sArr[length] & 255) + f19606EIGHT[length] + i;
            i = i2 >>> 8;
            sArr[length] = (short) (i2 & 255);
        }
    }

    /* renamed from: mulX */
    private static int m15210mulX(int i) {
        return ((-(i >>> 7)) & REDUCTION_POLYNOMIAL) ^ (i << 1);
    }

    private static long packIntoLong(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return (((((((i2 << 48) ^ (i << 56)) ^ (i3 << 40)) ^ (i4 << 32)) ^ (i5 << 24)) ^ (i6 << 16)) ^ (i7 << 8)) ^ i8;
    }

    private void processFilledBuffer(byte[] bArr, int i) {
        AbstractC6245Pack.bigEndianToLong(this.f19612_buffer, 0, this.f19611_block);
        processBlock();
        this._bufferPos = 0;
        C6238Arrays.m18249fill(this.f19612_buffer, (byte) 0);
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new WhirlpoolDigest(this);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        m15209finish();
        AbstractC6245Pack.longToBigEndian(this.f19613_hash, bArr, i);
        mo14968reset();
        return getDigestSize();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "Whirlpool";
    }

    @Override // org.bouncycastle.p194crypto.ExtendedDigest
    public int getByteLength() {
        return 64;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return 64;
    }

    public void processBlock() {
        long[] jArr;
        for (int i = 0; i < 8; i++) {
            long[] jArr2 = this.f19615_state;
            long j = this.f19611_block[i];
            long[] jArr3 = this.f19609_K;
            long j2 = this.f19613_hash[i];
            jArr3[i] = j2;
            jArr2[i] = j ^ j2;
        }
        int i2 = 1;
        while (i2 <= 10) {
            int i3 = 0;
            while (i3 < 8) {
                long[] jArr4 = this.f19610_L;
                jArr4[i3] = 0;
                long[] jArr5 = f19598C0;
                long[] jArr6 = this.f19609_K;
                long j3 = jArr5[((int) (jArr6[i3 & 7] >>> 56)) & 255];
                jArr4[i3] = j3;
                long j4 = f19599C1[((int) (jArr6[(i3 - 1) & 7] >>> 48)) & 255] ^ j3;
                jArr4[i3] = j4;
                long j5 = j4 ^ f19600C2[((int) (jArr6[(i3 - 2) & 7] >>> 40)) & 255];
                jArr4[i3] = j5;
                long j6 = j5 ^ f19601C3[((int) (jArr6[(i3 - 3) & 7] >>> 32)) & 255];
                jArr4[i3] = j6;
                long j7 = j6 ^ f19602C4[((int) (jArr6[(i3 - 4) & 7] >>> 24)) & 255];
                jArr4[i3] = j7;
                long j8 = j7 ^ f19603C5[((int) (jArr6[(i3 - 5) & 7] >>> 16)) & 255];
                jArr4[i3] = j8;
                long j9 = j8 ^ f19604C6[((int) (jArr6[(i3 - 6) & 7] >>> 8)) & 255];
                jArr4[i3] = j9;
                jArr4[i3] = j9 ^ f19605C7[((int) jArr6[(i3 - 7) & 7]) & 255];
                i3++;
                i2 = i2;
            }
            int i4 = i2;
            long[] jArr7 = this.f19610_L;
            long[] jArr8 = this.f19609_K;
            System.arraycopy(jArr7, 0, jArr8, 0, jArr8.length);
            long[] jArr9 = this.f19609_K;
            jArr9[0] = jArr9[0] ^ this.f19614_rc[i4];
            int i5 = 0;
            while (true) {
                jArr = this.f19610_L;
                if (i5 < 8) {
                    long j10 = this.f19609_K[i5];
                    jArr[i5] = j10;
                    long[] jArr10 = f19598C0;
                    long[] jArr11 = this.f19615_state;
                    long j11 = jArr10[((int) (jArr11[i5 & 7] >>> 56)) & 255] ^ j10;
                    jArr[i5] = j11;
                    long j12 = j11 ^ f19599C1[((int) (jArr11[(i5 - 1) & 7] >>> 48)) & 255];
                    jArr[i5] = j12;
                    long j13 = j12 ^ f19600C2[((int) (jArr11[(i5 - 2) & 7] >>> 40)) & 255];
                    jArr[i5] = j13;
                    long j14 = j13 ^ f19601C3[((int) (jArr11[(i5 - 3) & 7] >>> 32)) & 255];
                    jArr[i5] = j14;
                    long j15 = j14 ^ f19602C4[((int) (jArr11[(i5 - 4) & 7] >>> 24)) & 255];
                    jArr[i5] = j15;
                    long j16 = j15 ^ f19603C5[((int) (jArr11[(i5 - 5) & 7] >>> 16)) & 255];
                    jArr[i5] = j16;
                    long j17 = j16 ^ f19604C6[((int) (jArr11[(i5 - 6) & 7] >>> 8)) & 255];
                    jArr[i5] = j17;
                    jArr[i5] = j17 ^ f19605C7[((int) jArr11[(i5 - 7) & 7]) & 255];
                    i5++;
                }
            }
            long[] jArr12 = this.f19615_state;
            System.arraycopy(jArr, 0, jArr12, 0, jArr12.length);
            i2 = i4 + 1;
        }
        for (int i6 = 0; i6 < 8; i6++) {
            long[] jArr13 = this.f19613_hash;
            jArr13[i6] = jArr13[i6] ^ (this.f19615_state[i6] ^ this.f19611_block[i6]);
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        this._bufferPos = 0;
        C6238Arrays.m18260fill(this._bitCount, (short) 0);
        C6238Arrays.m18249fill(this.f19612_buffer, (byte) 0);
        C6238Arrays.m18256fill(this.f19613_hash, 0L);
        C6238Arrays.m18256fill(this.f19609_K, 0L);
        C6238Arrays.m18256fill(this.f19610_L, 0L);
        C6238Arrays.m18256fill(this.f19611_block, 0L);
        C6238Arrays.m18256fill(this.f19615_state, 0L);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        byte[] bArr = this.f19612_buffer;
        int i = this._bufferPos;
        bArr[i] = b;
        int i2 = i + 1;
        this._bufferPos = i2;
        if (i2 == bArr.length) {
            processFilledBuffer(bArr, 0);
        }
        increment();
    }

    public WhirlpoolDigest(CryptoServicePurpose cryptoServicePurpose) {
        long[] jArr = new long[11];
        this.f19614_rc = jArr;
        this.f19612_buffer = new byte[64];
        this._bufferPos = 0;
        this._bitCount = new short[32];
        this.f19613_hash = new long[8];
        this.f19609_K = new long[8];
        this.f19610_L = new long[8];
        this.f19611_block = new long[8];
        this.f19615_state = new long[8];
        jArr[0] = 0;
        for (int i = 1; i <= 10; i++) {
            int i2 = (i - 1) * 8;
            this.f19614_rc[i] = (((((((f19598C0[i2] & (-72057594037927936L)) ^ (f19599C1[i2 + 1] & 71776119061217280L)) ^ (f19600C2[i2 + 2] & 280375465082880L)) ^ (f19601C3[i2 + 3] & 1095216660480L)) ^ (f19602C4[i2 + 4] & 4278190080L)) ^ (f19603C5[i2 + 5] & 16711680)) ^ (f19604C6[i2 + 6] & 65280)) ^ (f19605C7[i2 + 7] & 255);
        }
        this.f19616purpose = cryptoServicePurpose;
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, getDigestSize(), cryptoServicePurpose));
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        WhirlpoolDigest whirlpoolDigest = (WhirlpoolDigest) memoable;
        long[] jArr = whirlpoolDigest.f19614_rc;
        long[] jArr2 = this.f19614_rc;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        byte[] bArr = whirlpoolDigest.f19612_buffer;
        byte[] bArr2 = this.f19612_buffer;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this._bufferPos = whirlpoolDigest._bufferPos;
        short[] sArr = whirlpoolDigest._bitCount;
        short[] sArr2 = this._bitCount;
        System.arraycopy(sArr, 0, sArr2, 0, sArr2.length);
        long[] jArr3 = whirlpoolDigest.f19613_hash;
        long[] jArr4 = this.f19613_hash;
        System.arraycopy(jArr3, 0, jArr4, 0, jArr4.length);
        long[] jArr5 = whirlpoolDigest.f19609_K;
        long[] jArr6 = this.f19609_K;
        System.arraycopy(jArr5, 0, jArr6, 0, jArr6.length);
        long[] jArr7 = whirlpoolDigest.f19610_L;
        long[] jArr8 = this.f19610_L;
        System.arraycopy(jArr7, 0, jArr8, 0, jArr8.length);
        long[] jArr9 = whirlpoolDigest.f19611_block;
        long[] jArr10 = this.f19611_block;
        System.arraycopy(jArr9, 0, jArr10, 0, jArr10.length);
        long[] jArr11 = whirlpoolDigest.f19615_state;
        long[] jArr12 = this.f19615_state;
        System.arraycopy(jArr11, 0, jArr12, 0, jArr12.length);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            mo14969update(bArr[i]);
            i++;
            i2--;
        }
    }

    public WhirlpoolDigest(WhirlpoolDigest whirlpoolDigest) {
        this.f19614_rc = new long[11];
        this.f19612_buffer = new byte[64];
        this._bufferPos = 0;
        this._bitCount = new short[32];
        this.f19613_hash = new long[8];
        this.f19609_K = new long[8];
        this.f19610_L = new long[8];
        this.f19611_block = new long[8];
        this.f19615_state = new long[8];
        CryptoServicePurpose cryptoServicePurpose = whirlpoolDigest.f19616purpose;
        this.f19616purpose = cryptoServicePurpose;
        mo14824reset(whirlpoolDigest);
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, getDigestSize(), cryptoServicePurpose));
    }
}
