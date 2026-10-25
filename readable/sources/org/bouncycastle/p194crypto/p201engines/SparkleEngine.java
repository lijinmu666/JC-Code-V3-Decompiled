package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import org.bouncycastle.p194crypto.p199digests.SparkleDigest;
import org.bouncycastle.p194crypto.p201engines.AEADBaseEngine;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Integers;
import p094kotlin.C1126UByte;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public class SparkleEngine extends AEADBaseEngine {

    /* renamed from: RCON */
    private static final int[] f20096RCON = {-1209970334, -1083090816, 951376470, 844003128, -1156479509, 1333558103, -809524792, -1028445891};
    private final int CAP_MASK;
    private final int KEY_WORDS;
    private final int RATE_WORDS;
    private final int SPARKLE_STEPS_BIG;
    private final int SPARKLE_STEPS_SLIM;
    private final int STATE_WORDS;
    private final int TAG_WORDS;

    /* renamed from: _A0 */
    private final int f20097_A0;

    /* renamed from: _A1 */
    private final int f20098_A1;

    /* renamed from: _M2 */
    private final int f20099_M2;

    /* renamed from: _M3 */
    private final int f20100_M3;
    private boolean encrypted;

    /* renamed from: k */
    private final int[] f20101k;

    /* renamed from: npub */
    private final int[] f20102npub;

    /* renamed from: state */
    private final int[] f20103state;

    public enum SparkleParameters {
        SCHWAEMM128_128,
        SCHWAEMM256_128,
        SCHWAEMM192_192,
        SCHWAEMM256_256
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SparkleEngine(SparkleParameters sparkleParameters) {
        int i;
        int i2;
        int i3;
        int iOrdinal = sparkleParameters.ordinal();
        int i4 = 256;
        int i5 = 128;
        if (iOrdinal != 0) {
            i = 384;
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    this.SPARKLE_STEPS_SLIM = 7;
                    this.SPARKLE_STEPS_BIG = 11;
                    this.algorithmName = "SCHWAEMM192-192";
                    i4 = 192;
                } else {
                    if (iOrdinal != 3) {
                        throw new IllegalArgumentException("Invalid definition of SCHWAEMM instance");
                    }
                    this.SPARKLE_STEPS_SLIM = 8;
                    this.SPARKLE_STEPS_BIG = 12;
                    this.algorithmName = "SCHWAEMM256-256";
                    i = 512;
                }
                i2 = i4;
                i3 = i2;
                i5 = i3;
                int i6 = i4 >>> 5;
                this.KEY_WORDS = i6;
                this.KEY_SIZE = i4 >>> 3;
                this.TAG_WORDS = i5 >>> 5;
                this.MAC_SIZE = i5 >>> 3;
                int i7 = i >>> 5;
                this.STATE_WORDS = i7;
                int i8 = i2 >>> 5;
                this.RATE_WORDS = i8;
                int i9 = i2 >>> 3;
                this.f19650IV_SIZE = i9;
                int i10 = i3 >>> 6;
                int i11 = i3 >>> 5;
                this.CAP_MASK = i8 <= i11 ? i11 - 1 : -1;
                int i12 = 1 << i10;
                this.f20097_A0 = i12 << 24;
                this.f20098_A1 = (i12 ^ 1) << 24;
                this.f20099_M2 = (i12 ^ 2) << 24;
                this.f20100_M3 = (i12 ^ 3) << 24;
                this.f20103state = new int[i7];
                this.f20101k = new int[i6];
                this.f20102npub = new int[i8];
                this.BlockSize = i9;
                this.AADBufferSize = i9;
                setInnerMembers(AEADBaseEngine.ProcessingBufferType.Buffered, AEADBaseEngine.AADOperatorType.f19658Default, AEADBaseEngine.DataOperatorType.f19674Default);
            }
            this.SPARKLE_STEPS_SLIM = 7;
            this.SPARKLE_STEPS_BIG = 11;
            this.algorithmName = "SCHWAEMM256-128";
            i2 = 256;
            i3 = 128;
        } else {
            this.SPARKLE_STEPS_SLIM = 7;
            this.SPARKLE_STEPS_BIG = 10;
            this.algorithmName = "SCHWAEMM128-128";
            i = 256;
            i2 = 128;
            i3 = 128;
        }
        i4 = i3;
        int i62 = i4 >>> 5;
        this.KEY_WORDS = i62;
        this.KEY_SIZE = i4 >>> 3;
        this.TAG_WORDS = i5 >>> 5;
        this.MAC_SIZE = i5 >>> 3;
        int i72 = i >>> 5;
        this.STATE_WORDS = i72;
        int i82 = i2 >>> 5;
        this.RATE_WORDS = i82;
        int i92 = i2 >>> 3;
        this.f19650IV_SIZE = i92;
        int i102 = i3 >>> 6;
        int i112 = i3 >>> 5;
        this.CAP_MASK = i82 <= i112 ? i112 - 1 : -1;
        int i122 = 1 << i102;
        this.f20097_A0 = i122 << 24;
        this.f20098_A1 = (i122 ^ 1) << 24;
        this.f20099_M2 = (i122 ^ 2) << 24;
        this.f20100_M3 = (i122 ^ 3) << 24;
        this.f20103state = new int[i72];
        this.f20101k = new int[i62];
        this.f20102npub = new int[i82];
        this.BlockSize = i92;
        this.AADBufferSize = i92;
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Buffered, AEADBaseEngine.AADOperatorType.f19658Default, AEADBaseEngine.DataOperatorType.f19674Default);
    }

    /* renamed from: ELL */
    private static int m15428ELL(int i) {
        return (i & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) ^ Integers.rotateRight(i, 16);
    }

    private static void sparkle_opt(int[] iArr, int i) {
        int length = iArr.length;
        if (length == 8) {
            sparkle_opt8(iArr, i);
        } else if (length == 12) {
            sparkle_opt12(iArr, i);
        } else {
            if (length != 16) {
                throw new IllegalStateException();
            }
            sparkle_opt16(iArr, i);
        }
    }

    public static void sparkle_opt12(SparkleDigest.C5297Friend c5297Friend, int[] iArr, int i) {
        if (c5297Friend == null) {
            throw new NullPointerException("This method is only for use by SparkleDigest");
        }
        sparkle_opt12(iArr, i);
    }

    public static void sparkle_opt16(SparkleDigest.C5297Friend c5297Friend, int[] iArr, int i) {
        if (c5297Friend == null) {
            throw new NullPointerException("This method is only for use by SparkleDigest");
        }
        sparkle_opt16(iArr, i);
    }

    public static void sparkle_opt8(int[] iArr, int i) {
        char c = 0;
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        int i10 = 0;
        while (i10 < i) {
            int[] iArr2 = f20096RCON;
            int i11 = i3 ^ iArr2[i10 & 7];
            int i12 = i5 ^ i10;
            int i13 = iArr2[c];
            int iRotateRight = i2 + Integers.rotateRight(i11, 31);
            int iRotateRight2 = i11 ^ Integers.rotateRight(iRotateRight, 24);
            int iRotateRight3 = (iRotateRight ^ i13) + Integers.rotateRight(iRotateRight2, 17);
            int iRotateRight4 = iRotateRight2 ^ Integers.rotateRight(iRotateRight3, 17);
            int i14 = (iRotateRight3 ^ i13) + iRotateRight4;
            int iRotateRight5 = iRotateRight4 ^ Integers.rotateRight(i14, 31);
            int iRotateRight6 = (i14 ^ i13) + Integers.rotateRight(iRotateRight5, 24);
            int iRotateRight7 = iRotateRight5 ^ Integers.rotateRight(iRotateRight6, 16);
            int i15 = iRotateRight6 ^ i13;
            int i16 = iArr2[1];
            int iRotateRight8 = i4 + Integers.rotateRight(i12, 31);
            int iRotateRight9 = i12 ^ Integers.rotateRight(iRotateRight8, 24);
            int iRotateRight10 = (iRotateRight8 ^ i16) + Integers.rotateRight(iRotateRight9, 17);
            int iRotateRight11 = iRotateRight9 ^ Integers.rotateRight(iRotateRight10, 17);
            int i17 = (iRotateRight10 ^ i16) + iRotateRight11;
            int iRotateRight12 = iRotateRight11 ^ Integers.rotateRight(i17, 31);
            int iRotateRight13 = (i17 ^ i16) + Integers.rotateRight(iRotateRight12, 24);
            int iRotateRight14 = iRotateRight12 ^ Integers.rotateRight(iRotateRight13, 16);
            int i18 = iRotateRight13 ^ i16;
            int i19 = iArr2[2];
            int iRotateRight15 = i6 + Integers.rotateRight(i7, 31);
            int iRotateRight16 = i7 ^ Integers.rotateRight(iRotateRight15, 24);
            int iRotateRight17 = (iRotateRight15 ^ i19) + Integers.rotateRight(iRotateRight16, 17);
            int iRotateRight18 = iRotateRight16 ^ Integers.rotateRight(iRotateRight17, 17);
            int i20 = (iRotateRight17 ^ i19) + iRotateRight18;
            int iRotateRight19 = iRotateRight18 ^ Integers.rotateRight(i20, 31);
            int iRotateRight20 = (i20 ^ i19) + Integers.rotateRight(iRotateRight19, 24);
            int iRotateRight21 = iRotateRight19 ^ Integers.rotateRight(iRotateRight20, 16);
            int i21 = iArr2[3];
            int iRotateRight22 = i8 + Integers.rotateRight(i9, 31);
            int iRotateRight23 = i9 ^ Integers.rotateRight(iRotateRight22, 24);
            int iRotateRight24 = (iRotateRight22 ^ i21) + Integers.rotateRight(iRotateRight23, 17);
            int iRotateRight25 = Integers.rotateRight(iRotateRight24, 17) ^ iRotateRight23;
            int i22 = (iRotateRight24 ^ i21) + iRotateRight25;
            int iRotateRight26 = iRotateRight25 ^ Integers.rotateRight(i22, 31);
            int iRotateRight27 = (i22 ^ i21) + Integers.rotateRight(iRotateRight26, 24);
            int iRotateRight28 = iRotateRight26 ^ Integers.rotateRight(iRotateRight27, 16);
            int i23 = iRotateRight27 ^ i21;
            int iM15428ELL = m15428ELL(i15 ^ i18);
            int iM15428ELL2 = m15428ELL(iRotateRight7 ^ iRotateRight14);
            int i24 = (i23 ^ i18) ^ iM15428ELL2;
            int i25 = (iRotateRight28 ^ iRotateRight14) ^ iM15428ELL;
            int i26 = iM15428ELL ^ (iRotateRight21 ^ iRotateRight7);
            i10++;
            i7 = iRotateRight7;
            i8 = i18;
            i9 = iRotateRight14;
            i5 = i26;
            i4 = ((iRotateRight20 ^ i19) ^ i15) ^ iM15428ELL2;
            i3 = i25;
            i6 = i15;
            i2 = i24;
            c = 0;
        }
        iArr[c] = i2;
        iArr[1] = i3;
        iArr[2] = i4;
        iArr[3] = i5;
        iArr[4] = i6;
        iArr[5] = i7;
        iArr[6] = i8;
        iArr[7] = i9;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: doFinal */
    public /* bridge */ /* synthetic */ int mo15224doFinal(byte[] bArr, int i) {
        return super.mo15224doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void finishAAD(AEADBaseEngine.C5335State c5335State, boolean z) {
        finishAAD2(c5335State);
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
        int i2 = 0;
        while (true) {
            int i3 = this.RATE_WORDS;
            if (i2 >= i3 / 2) {
                sparkle_opt(this.f20103state, this.SPARKLE_STEPS_SLIM);
                return;
            }
            int i4 = (i3 / 2) + i2;
            int[] iArr = this.f20103state;
            int i5 = iArr[i2];
            int i6 = iArr[i4];
            int iLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(bArr, (i2 * 4) + i);
            int iLittleEndianToInt2 = AbstractC6245Pack.littleEndianToInt(bArr, (i4 * 4) + i);
            int[] iArr2 = this.f20103state;
            int i7 = this.RATE_WORDS;
            iArr2[i2] = (iLittleEndianToInt ^ i6) ^ iArr2[i7 + i2];
            iArr2[i4] = ((i6 ^ i5) ^ iLittleEndianToInt2) ^ iArr2[i7 + (this.CAP_MASK & i4)];
            i2++;
        }
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = this.RATE_WORDS;
            if (i3 >= i4 / 2) {
                sparkle_opt(this.f20103state, this.SPARKLE_STEPS_SLIM);
                this.encrypted = true;
                return;
            }
            int i5 = (i4 / 2) + i3;
            int[] iArr = this.f20103state;
            int i6 = iArr[i3];
            int i7 = iArr[i5];
            int i8 = i3 * 4;
            int iLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(bArr, i + i8);
            int i9 = i5 * 4;
            int iLittleEndianToInt2 = AbstractC6245Pack.littleEndianToInt(bArr, i + i9);
            int[] iArr2 = this.f20103state;
            int i10 = this.RATE_WORDS;
            iArr2[i3] = ((i6 ^ i7) ^ iLittleEndianToInt) ^ iArr2[i10 + i3];
            iArr2[i5] = (i6 ^ iLittleEndianToInt2) ^ iArr2[i10 + (this.CAP_MASK & i5)];
            AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt ^ i6, bArr2, i2 + i8);
            AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt2 ^ i7, bArr2, i2 + i9);
            i3++;
        }
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = this.RATE_WORDS;
            if (i3 >= i4 / 2) {
                sparkle_opt(this.f20103state, this.SPARKLE_STEPS_SLIM);
                this.encrypted = true;
                return;
            }
            int i5 = (i4 / 2) + i3;
            int[] iArr = this.f20103state;
            int i6 = iArr[i3];
            int i7 = iArr[i5];
            int i8 = i3 * 4;
            int iLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(bArr, i + i8);
            int i9 = i5 * 4;
            int iLittleEndianToInt2 = AbstractC6245Pack.littleEndianToInt(bArr, i + i9);
            int[] iArr2 = this.f20103state;
            int i10 = this.RATE_WORDS;
            iArr2[i3] = (i7 ^ iLittleEndianToInt) ^ iArr2[i10 + i3];
            iArr2[i5] = ((i6 ^ i7) ^ iLittleEndianToInt2) ^ iArr2[i10 + (this.CAP_MASK & i5)];
            AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt ^ i6, bArr2, i2 + i8);
            AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt2 ^ i7, bArr2, i2 + i9);
            i3++;
        }
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
        int i = this.m_aadPos;
        int i2 = this.BlockSize;
        int i3 = 0;
        if (i < i2) {
            int[] iArr = this.f20103state;
            int i4 = this.STATE_WORDS - 1;
            iArr[i4] = iArr[i4] ^ this.f20097_A0;
            byte[] bArr = this.f19651m_aad;
            int i5 = i + 1;
            this.m_aadPos = i5;
            bArr[i] = ByteCompanionObject.MIN_VALUE;
            C6238Arrays.m18250fill(bArr, i5, i2, (byte) 0);
        } else {
            int[] iArr2 = this.f20103state;
            int i6 = this.STATE_WORDS - 1;
            iArr2[i6] = iArr2[i6] ^ this.f20098_A1;
        }
        while (true) {
            int i7 = this.RATE_WORDS;
            if (i3 >= i7 / 2) {
                sparkle_opt(this.f20103state, this.SPARKLE_STEPS_BIG);
                return;
            }
            int i8 = (i7 / 2) + i3;
            int[] iArr3 = this.f20103state;
            int i9 = iArr3[i3];
            int i10 = iArr3[i8];
            int iLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(this.f19651m_aad, i3 * 4);
            int iLittleEndianToInt2 = AbstractC6245Pack.littleEndianToInt(this.f19651m_aad, i8 * 4);
            int[] iArr4 = this.f20103state;
            int i11 = this.RATE_WORDS;
            iArr4[i3] = (iLittleEndianToInt ^ i10) ^ iArr4[i11 + i3];
            iArr4[i8] = ((i10 ^ i9) ^ iLittleEndianToInt2) ^ iArr4[i11 + (this.CAP_MASK & i8)];
            i3++;
        }
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processFinalBlock(byte[] bArr, int i) {
        int i2;
        if (this.encrypted || this.m_bufPos > 0) {
            int[] iArr = this.f20103state;
            int i3 = this.STATE_WORDS - 1;
            iArr[i3] = iArr[i3] ^ (this.m_bufPos < this.f19650IV_SIZE ? this.f20099_M2 : this.f20100_M3);
            int[] iArr2 = new int[this.RATE_WORDS];
            int i4 = 0;
            while (true) {
                i2 = this.m_bufPos;
                if (i4 >= i2) {
                    break;
                }
                int i5 = i4 >>> 2;
                iArr2[i5] = iArr2[i5] | ((this.f19652m_buf[i4] & C1126UByte.MAX_VALUE) << ((i4 & 3) << 3));
                i4++;
            }
            if (i2 < this.f19650IV_SIZE) {
                if (!this.forEncryption) {
                    int i6 = (i2 & 3) << 3;
                    int i7 = i2 >>> 2;
                    int i8 = iArr2[i7];
                    int[] iArr3 = this.f20103state;
                    iArr2[i7] = ((iArr3[i2 >>> 2] >>> i6) << i6) | i8;
                    int i9 = (i2 >>> 2) + 1;
                    System.arraycopy(iArr3, i9, iArr2, i9, this.RATE_WORDS - i9);
                }
                int i10 = this.m_bufPos;
                int i11 = i10 >>> 2;
                iArr2[i11] = (128 << ((i10 & 3) << 3)) ^ iArr2[i11];
            }
            int i12 = 0;
            while (true) {
                int i13 = this.RATE_WORDS;
                if (i12 >= i13 / 2) {
                    break;
                }
                int i14 = (i13 / 2) + i12;
                int[] iArr4 = this.f20103state;
                int i15 = iArr4[i12];
                int i16 = iArr4[i14];
                if (this.forEncryption) {
                    iArr4[i12] = (iArr2[i12] ^ i16) ^ iArr4[i13 + i12];
                    iArr4[i14] = iArr4[i13 + (this.CAP_MASK & i14)] ^ ((i15 ^ i16) ^ iArr2[i14]);
                } else {
                    iArr4[i12] = ((i15 ^ i16) ^ iArr2[i12]) ^ iArr4[i13 + i12];
                    iArr4[i14] = iArr4[i13 + (this.CAP_MASK & i14)] ^ (iArr2[i14] ^ i15);
                }
                iArr2[i12] = iArr2[i12] ^ i15;
                iArr2[i14] = iArr2[i14] ^ i16;
                i12++;
            }
            int i17 = 0;
            while (i17 < this.m_bufPos) {
                bArr[i] = (byte) (iArr2[i17 >>> 2] >>> ((i17 & 3) << 3));
                i17++;
                i++;
            }
            sparkle_opt(this.f20103state, this.SPARKLE_STEPS_BIG);
        }
        for (int i18 = 0; i18 < this.KEY_WORDS; i18++) {
            int[] iArr5 = this.f20103state;
            int i19 = this.RATE_WORDS + i18;
            iArr5[i19] = iArr5[i19] ^ this.f20101k[i18];
        }
        AbstractC6245Pack.intToLittleEndian(this.f20103state, this.RATE_WORDS, this.TAG_WORDS, this.f19654mac, 0);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: reset */
    public /* bridge */ /* synthetic */ void mo15228reset() {
        super.mo15228reset();
    }

    public static void sparkle_opt12(int[] iArr, int i) {
        char c = 0;
        int i2 = iArr[0];
        char c2 = 1;
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        int i10 = iArr[8];
        int i11 = iArr[9];
        int i12 = iArr[10];
        int i13 = 0;
        int i14 = i11;
        int i15 = iArr[11];
        while (i13 < i) {
            int[] iArr2 = f20096RCON;
            int i16 = i3 ^ iArr2[i13 & 7];
            int i17 = i5 ^ i13;
            int i18 = iArr2[c];
            int iRotateRight = i2 + Integers.rotateRight(i16, 31);
            int iRotateRight2 = i16 ^ Integers.rotateRight(iRotateRight, 24);
            int iRotateRight3 = (iRotateRight ^ i18) + Integers.rotateRight(iRotateRight2, 17);
            int iRotateRight4 = iRotateRight2 ^ Integers.rotateRight(iRotateRight3, 17);
            int i19 = (iRotateRight3 ^ i18) + iRotateRight4;
            int iRotateRight5 = iRotateRight4 ^ Integers.rotateRight(i19, 31);
            int iRotateRight6 = (i19 ^ i18) + Integers.rotateRight(iRotateRight5, 24);
            int iRotateRight7 = iRotateRight5 ^ Integers.rotateRight(iRotateRight6, 16);
            int i20 = iRotateRight6 ^ i18;
            int i21 = iArr2[c2];
            int iRotateRight8 = i4 + Integers.rotateRight(i17, 31);
            int iRotateRight9 = i17 ^ Integers.rotateRight(iRotateRight8, 24);
            int iRotateRight10 = (iRotateRight8 ^ i21) + Integers.rotateRight(iRotateRight9, 17);
            int iRotateRight11 = iRotateRight9 ^ Integers.rotateRight(iRotateRight10, 17);
            int i22 = (iRotateRight10 ^ i21) + iRotateRight11;
            int iRotateRight12 = iRotateRight11 ^ Integers.rotateRight(i22, 31);
            int iRotateRight13 = (i22 ^ i21) + Integers.rotateRight(iRotateRight12, 24);
            int iRotateRight14 = iRotateRight12 ^ Integers.rotateRight(iRotateRight13, 16);
            int i23 = iRotateRight13 ^ i21;
            int i24 = iArr2[2];
            int iRotateRight15 = i6 + Integers.rotateRight(i7, 31);
            int iRotateRight16 = Integers.rotateRight(iRotateRight15, 24) ^ i7;
            int iRotateRight17 = (iRotateRight15 ^ i24) + Integers.rotateRight(iRotateRight16, 17);
            int iRotateRight18 = iRotateRight16 ^ Integers.rotateRight(iRotateRight17, 17);
            int i25 = (iRotateRight17 ^ i24) + iRotateRight18;
            int iRotateRight19 = iRotateRight18 ^ Integers.rotateRight(i25, 31);
            int iRotateRight20 = (i25 ^ i24) + Integers.rotateRight(iRotateRight19, 24);
            int iRotateRight21 = iRotateRight19 ^ Integers.rotateRight(iRotateRight20, 16);
            int i26 = iRotateRight20 ^ i24;
            int i27 = iArr2[3];
            int iRotateRight22 = i8 + Integers.rotateRight(i9, 31);
            int iRotateRight23 = Integers.rotateRight(iRotateRight22, 24) ^ i9;
            int iRotateRight24 = (iRotateRight22 ^ i27) + Integers.rotateRight(iRotateRight23, 17);
            int iRotateRight25 = iRotateRight23 ^ Integers.rotateRight(iRotateRight24, 17);
            int i28 = (iRotateRight24 ^ i27) + iRotateRight25;
            int iRotateRight26 = iRotateRight25 ^ Integers.rotateRight(i28, 31);
            int iRotateRight27 = (i28 ^ i27) + Integers.rotateRight(iRotateRight26, 24);
            int iRotateRight28 = iRotateRight26 ^ Integers.rotateRight(iRotateRight27, 16);
            int i29 = iRotateRight27 ^ i27;
            int i30 = iArr2[4];
            int iRotateRight29 = i10 + Integers.rotateRight(i14, 31);
            int iRotateRight30 = i14 ^ Integers.rotateRight(iRotateRight29, 24);
            int iRotateRight31 = (iRotateRight29 ^ i30) + Integers.rotateRight(iRotateRight30, 17);
            int iRotateRight32 = iRotateRight30 ^ Integers.rotateRight(iRotateRight31, 17);
            int i31 = (iRotateRight31 ^ i30) + iRotateRight32;
            int iRotateRight33 = iRotateRight32 ^ Integers.rotateRight(i31, 31);
            int iRotateRight34 = (i31 ^ i30) + Integers.rotateRight(iRotateRight33, 24);
            int iRotateRight35 = iRotateRight33 ^ Integers.rotateRight(iRotateRight34, 16);
            int i32 = iArr2[5];
            int iRotateRight36 = i12 + Integers.rotateRight(i15, 31);
            int iRotateRight37 = i15 ^ Integers.rotateRight(iRotateRight36, 24);
            int iRotateRight38 = (iRotateRight36 ^ i32) + Integers.rotateRight(iRotateRight37, 17);
            int iRotateRight39 = Integers.rotateRight(iRotateRight38, 17) ^ iRotateRight37;
            int i33 = (iRotateRight38 ^ i32) + iRotateRight39;
            int iRotateRight40 = Integers.rotateRight(i33, 31) ^ iRotateRight39;
            int iRotateRight41 = (i33 ^ i32) + Integers.rotateRight(iRotateRight40, 24);
            int iRotateRight42 = iRotateRight40 ^ Integers.rotateRight(iRotateRight41, 16);
            int iM15428ELL = m15428ELL((i20 ^ i23) ^ i26);
            int iM15428ELL2 = m15428ELL((iRotateRight7 ^ iRotateRight14) ^ iRotateRight21);
            int i34 = ((iRotateRight34 ^ i30) ^ i23) ^ iM15428ELL2;
            int i35 = ((iRotateRight41 ^ i32) ^ i26) ^ iM15428ELL2;
            int i36 = (iRotateRight42 ^ iRotateRight21) ^ iM15428ELL;
            int i37 = (i29 ^ i20) ^ iM15428ELL2;
            i7 = (iRotateRight28 ^ iRotateRight7) ^ iM15428ELL;
            i13++;
            i9 = iRotateRight7;
            i3 = (iRotateRight35 ^ iRotateRight14) ^ iM15428ELL;
            i10 = i23;
            i4 = i35;
            i15 = iRotateRight21;
            i12 = i26;
            i6 = i37;
            i5 = i36;
            i8 = i20;
            i2 = i34;
            c = 0;
            i14 = iRotateRight14;
            c2 = 1;
        }
        iArr[c] = i2;
        iArr[1] = i3;
        iArr[2] = i4;
        iArr[3] = i5;
        iArr[4] = i6;
        iArr[5] = i7;
        iArr[6] = i8;
        iArr[7] = i9;
        iArr[8] = i10;
        iArr[9] = i14;
        iArr[10] = i12;
        iArr[11] = i15;
    }

    public static void sparkle_opt16(int[] iArr, int i) {
        char c = 0;
        int i2 = iArr[0];
        char c2 = 1;
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        int i10 = iArr[8];
        int i11 = iArr[9];
        int i12 = iArr[10];
        int i13 = iArr[11];
        int i14 = iArr[12];
        int i15 = iArr[13];
        int i16 = iArr[14];
        int i17 = i;
        int i18 = 0;
        int i19 = i11;
        int i20 = i13;
        int i21 = i15;
        int i22 = iArr[15];
        while (i18 < i17) {
            int[] iArr2 = f20096RCON;
            int i23 = i3 ^ iArr2[i18 & 7];
            int i24 = i5 ^ i18;
            int i25 = iArr2[c];
            int iRotateRight = i2 + Integers.rotateRight(i23, 31);
            int iRotateRight2 = i23 ^ Integers.rotateRight(iRotateRight, 24);
            int iRotateRight3 = (iRotateRight ^ i25) + Integers.rotateRight(iRotateRight2, 17);
            int iRotateRight4 = iRotateRight2 ^ Integers.rotateRight(iRotateRight3, 17);
            int i26 = (iRotateRight3 ^ i25) + iRotateRight4;
            int iRotateRight5 = iRotateRight4 ^ Integers.rotateRight(i26, 31);
            int iRotateRight6 = (i26 ^ i25) + Integers.rotateRight(iRotateRight5, 24);
            int iRotateRight7 = iRotateRight5 ^ Integers.rotateRight(iRotateRight6, 16);
            int i27 = iRotateRight6 ^ i25;
            int i28 = iArr2[c2];
            int iRotateRight8 = i4 + Integers.rotateRight(i24, 31);
            int iRotateRight9 = i24 ^ Integers.rotateRight(iRotateRight8, 24);
            int iRotateRight10 = (iRotateRight8 ^ i28) + Integers.rotateRight(iRotateRight9, 17);
            int iRotateRight11 = iRotateRight9 ^ Integers.rotateRight(iRotateRight10, 17);
            int i29 = (iRotateRight10 ^ i28) + iRotateRight11;
            int iRotateRight12 = iRotateRight11 ^ Integers.rotateRight(i29, 31);
            int iRotateRight13 = (i29 ^ i28) + Integers.rotateRight(iRotateRight12, 24);
            int iRotateRight14 = iRotateRight12 ^ Integers.rotateRight(iRotateRight13, 16);
            int i30 = iRotateRight13 ^ i28;
            int i31 = iArr2[2];
            int iRotateRight15 = i6 + Integers.rotateRight(i7, 31);
            int iRotateRight16 = Integers.rotateRight(iRotateRight15, 24) ^ i7;
            int iRotateRight17 = (iRotateRight15 ^ i31) + Integers.rotateRight(iRotateRight16, 17);
            int iRotateRight18 = iRotateRight16 ^ Integers.rotateRight(iRotateRight17, 17);
            int i32 = (iRotateRight17 ^ i31) + iRotateRight18;
            int iRotateRight19 = iRotateRight18 ^ Integers.rotateRight(i32, 31);
            int iRotateRight20 = (i32 ^ i31) + Integers.rotateRight(iRotateRight19, 24);
            int iRotateRight21 = iRotateRight19 ^ Integers.rotateRight(iRotateRight20, 16);
            int i33 = iRotateRight20 ^ i31;
            int i34 = iArr2[3];
            int iRotateRight22 = i8 + Integers.rotateRight(i9, 31);
            int iRotateRight23 = Integers.rotateRight(iRotateRight22, 24) ^ i9;
            int iRotateRight24 = (iRotateRight22 ^ i34) + Integers.rotateRight(iRotateRight23, 17);
            int iRotateRight25 = iRotateRight23 ^ Integers.rotateRight(iRotateRight24, 17);
            int i35 = (iRotateRight24 ^ i34) + iRotateRight25;
            int iRotateRight26 = iRotateRight25 ^ Integers.rotateRight(i35, 31);
            int iRotateRight27 = (i35 ^ i34) + Integers.rotateRight(iRotateRight26, 24);
            int iRotateRight28 = iRotateRight26 ^ Integers.rotateRight(iRotateRight27, 16);
            int i36 = iRotateRight27 ^ i34;
            int i37 = iArr2[4];
            int iRotateRight29 = i10 + Integers.rotateRight(i19, 31);
            int iRotateRight30 = i19 ^ Integers.rotateRight(iRotateRight29, 24);
            int iRotateRight31 = (iRotateRight29 ^ i37) + Integers.rotateRight(iRotateRight30, 17);
            int iRotateRight32 = iRotateRight30 ^ Integers.rotateRight(iRotateRight31, 17);
            int i38 = (iRotateRight31 ^ i37) + iRotateRight32;
            int iRotateRight33 = iRotateRight32 ^ Integers.rotateRight(i38, 31);
            int iRotateRight34 = (i38 ^ i37) + Integers.rotateRight(iRotateRight33, 24);
            int iRotateRight35 = iRotateRight33 ^ Integers.rotateRight(iRotateRight34, 16);
            int i39 = iArr2[5];
            int iRotateRight36 = i12 + Integers.rotateRight(i20, 31);
            int iRotateRight37 = i20 ^ Integers.rotateRight(iRotateRight36, 24);
            int iRotateRight38 = (iRotateRight36 ^ i39) + Integers.rotateRight(iRotateRight37, 17);
            int iRotateRight39 = iRotateRight37 ^ Integers.rotateRight(iRotateRight38, 17);
            int i40 = (iRotateRight38 ^ i39) + iRotateRight39;
            int iRotateRight40 = iRotateRight39 ^ Integers.rotateRight(i40, 31);
            int iRotateRight41 = (i40 ^ i39) + Integers.rotateRight(iRotateRight40, 24);
            int iRotateRight42 = iRotateRight40 ^ Integers.rotateRight(iRotateRight41, 16);
            int i41 = iRotateRight41 ^ i39;
            int i42 = iArr2[6];
            int i43 = i21;
            int iRotateRight43 = i14 + Integers.rotateRight(i43, 31);
            int iRotateRight44 = i43 ^ Integers.rotateRight(iRotateRight43, 24);
            int iRotateRight45 = (iRotateRight43 ^ i42) + Integers.rotateRight(iRotateRight44, 17);
            int iRotateRight46 = iRotateRight44 ^ Integers.rotateRight(iRotateRight45, 17);
            int i44 = (iRotateRight45 ^ i42) + iRotateRight46;
            int iRotateRight47 = iRotateRight46 ^ Integers.rotateRight(i44, 31);
            int iRotateRight48 = (i44 ^ i42) + Integers.rotateRight(iRotateRight47, 24);
            int iRotateRight49 = iRotateRight47 ^ Integers.rotateRight(iRotateRight48, 16);
            int i45 = iRotateRight48 ^ i42;
            int i46 = iArr2[7];
            int i47 = i18;
            int i48 = i22;
            int iRotateRight50 = i16 + Integers.rotateRight(i48, 31);
            int iRotateRight51 = i48 ^ Integers.rotateRight(iRotateRight50, 24);
            int iRotateRight52 = (iRotateRight50 ^ i46) + Integers.rotateRight(iRotateRight51, 17);
            int iRotateRight53 = iRotateRight51 ^ Integers.rotateRight(iRotateRight52, 17);
            int i49 = (iRotateRight52 ^ i46) + iRotateRight53;
            int iRotateRight54 = iRotateRight53 ^ Integers.rotateRight(i49, 31);
            int iRotateRight55 = (i49 ^ i46) + Integers.rotateRight(iRotateRight54, 24);
            int iRotateRight56 = iRotateRight54 ^ Integers.rotateRight(iRotateRight55, 16);
            int i50 = iRotateRight55 ^ i46;
            int iM15428ELL = m15428ELL(((i27 ^ i30) ^ i33) ^ i36);
            int iM15428ELL2 = m15428ELL(((iRotateRight7 ^ iRotateRight14) ^ iRotateRight21) ^ iRotateRight28);
            int i51 = (i41 ^ i30) ^ iM15428ELL2;
            int i52 = (iRotateRight42 ^ iRotateRight14) ^ iM15428ELL;
            int i53 = (i45 ^ i33) ^ iM15428ELL2;
            int i54 = (iRotateRight21 ^ iRotateRight49) ^ iM15428ELL;
            int i55 = (i50 ^ i36) ^ iM15428ELL2;
            int i56 = (iRotateRight56 ^ iRotateRight28) ^ iM15428ELL;
            int i57 = ((iRotateRight34 ^ i37) ^ i27) ^ iM15428ELL2;
            i9 = iM15428ELL ^ (iRotateRight35 ^ iRotateRight7);
            int i58 = i47 + 1;
            i10 = i27;
            i21 = iRotateRight21;
            i14 = i33;
            i22 = iRotateRight28;
            i2 = i51;
            i16 = i36;
            i8 = i57;
            i5 = i54;
            i20 = iRotateRight14;
            i19 = iRotateRight7;
            i12 = i30;
            i3 = i52;
            i6 = i55;
            i7 = i56;
            c2 = 1;
            i17 = i;
            i4 = i53;
            i18 = i58;
            c = 0;
        }
        iArr[c] = i2;
        iArr[1] = i3;
        iArr[2] = i4;
        iArr[3] = i5;
        iArr[4] = i6;
        iArr[5] = i7;
        iArr[6] = i8;
        iArr[7] = i9;
        iArr[8] = i10;
        iArr[9] = i19;
        iArr[10] = i12;
        iArr[11] = i20;
        iArr[12] = i14;
        iArr[13] = i21;
        iArr[14] = i16;
        iArr[15] = i22;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    /* renamed from: init */
    public void mo15227init(byte[] bArr, byte[] bArr2) {
        AbstractC6245Pack.littleEndianToInt(bArr, 0, this.f20101k);
        AbstractC6245Pack.littleEndianToInt(bArr2, 0, this.f20102npub);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    /* renamed from: reset */
    public void mo15229reset(boolean z) {
        this.encrypted = false;
        System.arraycopy(this.f20102npub, 0, this.f20103state, 0, this.RATE_WORDS);
        System.arraycopy(this.f20101k, 0, this.f20103state, this.RATE_WORDS, this.KEY_WORDS);
        sparkle_opt(this.f20103state, this.SPARKLE_STEPS_BIG);
        super.mo15229reset(z);
    }
}
