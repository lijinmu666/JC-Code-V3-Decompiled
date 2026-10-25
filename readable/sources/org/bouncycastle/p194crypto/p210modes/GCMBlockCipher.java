package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p210modes.p211gcm.AbstractC5369GCMUtil;
import org.bouncycastle.p194crypto.p210modes.p211gcm.BasicGCMExponentiator;
import org.bouncycastle.p194crypto.p210modes.p211gcm.GCMExponentiator;
import org.bouncycastle.p194crypto.p210modes.p211gcm.GCMMultiplier;
import org.bouncycastle.p194crypto.p210modes.p211gcm.Tables4kGCMMultiplier;
import org.bouncycastle.p194crypto.p213params.AEADParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class GCMBlockCipher implements GCMModeCipher {
    private static final int BLOCK_SIZE = 16;

    /* renamed from: H */
    private byte[] f20566H;

    /* renamed from: J0 */
    private byte[] f20567J0;

    /* renamed from: S */
    private byte[] f20568S;

    /* renamed from: S_at */
    private byte[] f20569S_at;

    /* renamed from: S_atPre */
    private byte[] f20570S_atPre;

    /* renamed from: atBlock */
    private byte[] f20571atBlock;
    private int atBlockPos;
    private long atLength;
    private long atLengthPre;
    private int blocksRemaining;
    private byte[] bufBlock;

    /* renamed from: bufOff */
    private int f20572bufOff;

    /* renamed from: cipher */
    private BlockCipher f20573cipher;

    /* renamed from: counter */
    private byte[] f20574counter;

    /* renamed from: exp */
    private GCMExponentiator f20575exp;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private boolean initialised;

    /* renamed from: lastKey */
    private byte[] f20576lastKey;
    private byte[] macBlock;

    /* renamed from: macSize */
    private int f20577macSize;
    private GCMMultiplier multiplier;

    /* renamed from: nonce */
    private byte[] f20578nonce;
    private long totalLength;

    public GCMBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, null);
    }

    private void checkStatus() {
        if (this.initialised) {
            return;
        }
        if (!this.forEncryption) {
            throw new IllegalStateException("GCM cipher needs to be initialised");
        }
        throw new IllegalStateException("GCM cipher cannot be reused for encryption");
    }

    private void decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (bArr2.length - i2 < 16) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (this.totalLength == 0) {
            initCipher();
        }
        byte[] bArr3 = new byte[16];
        getNextCTRBlock(bArr3);
        gHASHBlock(this.f20568S, bArr, i);
        AbstractC5369GCMUtil.m15632xor(bArr3, 0, bArr, i, bArr2, i2);
        this.totalLength += 16;
    }

    private void encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (bArr2.length - i2 < 16) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (this.totalLength == 0) {
            initCipher();
        }
        byte[] bArr3 = new byte[16];
        getNextCTRBlock(bArr3);
        AbstractC5369GCMUtil.m15634xor(bArr3, bArr, i);
        gHASHBlock(this.f20568S, bArr3);
        System.arraycopy(bArr3, 0, bArr2, i2, 16);
        this.totalLength += 16;
    }

    /* renamed from: gHASH */
    private void m15601gHASH(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2 += 16) {
            gHASHPartial(bArr, bArr2, i2, Math.min(i - i2, 16));
        }
    }

    private void gHASHBlock(byte[] bArr, byte[] bArr2) {
        AbstractC5369GCMUtil.m15633xor(bArr, bArr2);
        this.multiplier.multiplyH(bArr);
    }

    private void gHASHPartial(byte[] bArr, byte[] bArr2, int i, int i2) {
        AbstractC5369GCMUtil.m15635xor(bArr, bArr2, i, i2);
        this.multiplier.multiplyH(bArr);
    }

    private void getNextCTRBlock(byte[] bArr) {
        int i = this.blocksRemaining;
        if (i == 0) {
            throw new IllegalStateException("Attempt to process too many blocks");
        }
        this.blocksRemaining = i - 1;
        byte[] bArr2 = this.f20574counter;
        int i2 = (bArr2[15] & C1126UByte.MAX_VALUE) + 1;
        bArr2[15] = (byte) i2;
        int i3 = (i2 >>> 8) + (bArr2[14] & C1126UByte.MAX_VALUE);
        bArr2[14] = (byte) i3;
        int i4 = (i3 >>> 8) + (bArr2[13] & C1126UByte.MAX_VALUE);
        bArr2[13] = (byte) i4;
        bArr2[12] = (byte) ((i4 >>> 8) + (bArr2[12] & C1126UByte.MAX_VALUE));
        this.f20573cipher.processBlock(bArr2, 0, bArr, 0);
    }

    private void initCipher() {
        if (this.atLength > 0) {
            System.arraycopy(this.f20569S_at, 0, this.f20570S_atPre, 0, 16);
            this.atLengthPre = this.atLength;
        }
        int i = this.atBlockPos;
        if (i > 0) {
            gHASHPartial(this.f20570S_atPre, this.f20571atBlock, 0, i);
            this.atLengthPre += this.atBlockPos;
        }
        if (this.atLengthPre > 0) {
            System.arraycopy(this.f20570S_atPre, 0, this.f20568S, 0, 16);
        }
    }

    public static GCMModeCipher newInstance(BlockCipher blockCipher) {
        return new GCMBlockCipher(blockCipher);
    }

    private void processPartial(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        byte[] bArr3 = new byte[16];
        getNextCTRBlock(bArr3);
        if (this.forEncryption) {
            AbstractC5369GCMUtil.m15631xor(bArr, i, bArr3, 0, i2);
            gHASHPartial(this.f20568S, bArr, i, i2);
        } else {
            gHASHPartial(this.f20568S, bArr, i, i2);
            AbstractC5369GCMUtil.m15631xor(bArr, i, bArr3, 0, i2);
        }
        System.arraycopy(bArr, i, bArr2, i3, i2);
        this.totalLength += i2;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: doFinal */
    public int mo15224doFinal(byte[] bArr, int i) throws InvalidCipherTextException {
        checkStatus();
        if (this.totalLength == 0) {
            initCipher();
        }
        int i2 = this.f20572bufOff;
        if (!this.forEncryption) {
            int i3 = this.f20577macSize;
            if (i2 < i3) {
                throw new InvalidCipherTextException("data too short");
            }
            i2 -= i3;
            if (bArr.length - i < i2) {
                throw new OutputLengthException("Output buffer too short");
            }
        } else if (bArr.length - i < this.f20577macSize + i2) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (i2 > 0) {
            processPartial(this.bufBlock, 0, i2, bArr, i);
        }
        long j = this.atLength;
        int i4 = this.atBlockPos;
        long j2 = j + i4;
        this.atLength = j2;
        if (j2 > this.atLengthPre) {
            if (i4 > 0) {
                gHASHPartial(this.f20569S_at, this.f20571atBlock, 0, i4);
            }
            if (this.atLengthPre > 0) {
                AbstractC5369GCMUtil.m15633xor(this.f20569S_at, this.f20570S_atPre);
            }
            long j3 = ((this.totalLength * 8) + 127) >>> 7;
            byte[] bArr2 = new byte[16];
            if (this.f20575exp == null) {
                BasicGCMExponentiator basicGCMExponentiator = new BasicGCMExponentiator();
                this.f20575exp = basicGCMExponentiator;
                basicGCMExponentiator.mo15616init(this.f20566H);
            }
            this.f20575exp.exponentiateX(j3, bArr2);
            AbstractC5369GCMUtil.multiply(this.f20569S_at, bArr2);
            AbstractC5369GCMUtil.m15633xor(this.f20568S, this.f20569S_at);
        }
        byte[] bArr3 = new byte[16];
        AbstractC6245Pack.longToBigEndian(this.atLength * 8, bArr3, 0);
        AbstractC6245Pack.longToBigEndian(this.totalLength * 8, bArr3, 8);
        gHASHBlock(this.f20568S, bArr3);
        byte[] bArr4 = new byte[16];
        this.f20573cipher.processBlock(this.f20567J0, 0, bArr4, 0);
        AbstractC5369GCMUtil.m15633xor(bArr4, this.f20568S);
        int i5 = this.f20577macSize;
        byte[] bArr5 = new byte[i5];
        this.macBlock = bArr5;
        System.arraycopy(bArr4, 0, bArr5, 0, i5);
        if (this.forEncryption) {
            System.arraycopy(this.macBlock, 0, bArr, i + this.f20572bufOff, this.f20577macSize);
            i2 += this.f20577macSize;
        } else {
            int i6 = this.f20577macSize;
            byte[] bArr6 = new byte[i6];
            System.arraycopy(this.bufBlock, i2, bArr6, 0, i6);
            if (!C6238Arrays.constantTimeAreEqual(this.macBlock, bArr6)) {
                throw new InvalidCipherTextException("mac check in GCM failed");
            }
        }
        m15602reset(false);
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public String getAlgorithmName() {
        return this.f20573cipher.getAlgorithmName() + "/GCM";
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: getMac */
    public byte[] mo15225getMac() {
        byte[] bArr = this.macBlock;
        return bArr == null ? new byte[this.f20577macSize] : C6238Arrays.m18231clone(bArr);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getOutputSize(int i) {
        int i2 = i + this.f20572bufOff;
        boolean z = this.forEncryption;
        int i3 = this.f20577macSize;
        if (z) {
            return i2 + i3;
        }
        if (i2 < i3) {
            return 0;
        }
        return i2 - i3;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.f20573cipher;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getUpdateOutputSize(int i) {
        int i2 = i + this.f20572bufOff;
        if (!this.forEncryption) {
            int i3 = this.f20577macSize;
            if (i2 < i3) {
                return 0;
            }
            i2 -= i3;
        }
        return i2 - (i2 % 16);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: init */
    public void mo15226init(boolean z, CipherParameters cipherParameters) {
        byte[] bArrM15801getIV;
        KeyParameter keyParameterM15664getKey;
        byte[] bArr;
        this.forEncryption = z;
        this.macBlock = null;
        this.initialised = true;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            bArrM15801getIV = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            int macSize = aEADParameters.getMacSize();
            if (macSize < 32 || macSize > 128 || macSize % 8 != 0) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + macSize);
            }
            this.f20577macSize = macSize / 8;
            keyParameterM15664getKey = aEADParameters.m15664getKey();
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("invalid parameters passed to GCM");
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArrM15801getIV = parametersWithIV.m15801getIV();
            this.initialAssociatedText = null;
            this.f20577macSize = 16;
            keyParameterM15664getKey = (KeyParameter) parametersWithIV.getParameters();
        }
        this.bufBlock = new byte[z ? 16 : this.f20577macSize + 16];
        if (bArrM15801getIV == null || bArrM15801getIV.length < 1) {
            throw new IllegalArgumentException("IV must be at least 1 byte");
        }
        if (z && (bArr = this.f20578nonce) != null && C6238Arrays.areEqual(bArr, bArrM15801getIV)) {
            if (keyParameterM15664getKey == null) {
                throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
            }
            byte[] bArr2 = this.f20576lastKey;
            if (bArr2 != null && C6238Arrays.areEqual(bArr2, keyParameterM15664getKey.m15773getKey())) {
                throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
            }
        }
        this.f20578nonce = bArrM15801getIV;
        if (keyParameterM15664getKey != null) {
            this.f20576lastKey = keyParameterM15664getKey.m15773getKey();
        }
        if (keyParameterM15664getKey != null) {
            this.f20573cipher.mo14946init(true, keyParameterM15664getKey);
            byte[] bArr3 = new byte[16];
            this.f20566H = bArr3;
            this.f20573cipher.processBlock(bArr3, 0, bArr3, 0);
            this.multiplier.mo15617init(this.f20566H);
            this.f20575exp = null;
        } else if (this.f20566H == null) {
            throw new IllegalArgumentException("Key must be specified in initial init");
        }
        byte[] bArr4 = new byte[16];
        this.f20567J0 = bArr4;
        byte[] bArr5 = this.f20578nonce;
        if (bArr5.length == 12) {
            System.arraycopy(bArr5, 0, bArr4, 0, bArr5.length);
            this.f20567J0[15] = 1;
        } else {
            m15601gHASH(bArr4, bArr5, bArr5.length);
            byte[] bArr6 = new byte[16];
            AbstractC6245Pack.longToBigEndian(this.f20578nonce.length * 8, bArr6, 8);
            gHASHBlock(this.f20567J0, bArr6);
        }
        this.f20568S = new byte[16];
        this.f20569S_at = new byte[16];
        this.f20570S_atPre = new byte[16];
        this.f20571atBlock = new byte[16];
        this.atBlockPos = 0;
        this.atLength = 0L;
        this.atLengthPre = 0L;
        this.f20574counter = C6238Arrays.m18231clone(this.f20567J0);
        this.blocksRemaining = -2;
        this.f20572bufOff = 0;
        this.totalLength = 0L;
        byte[] bArr7 = this.initialAssociatedText;
        if (bArr7 != null) {
            processAADBytes(bArr7, 0, bArr7.length);
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public void processAADByte(byte b) {
        checkStatus();
        byte[] bArr = this.f20571atBlock;
        int i = this.atBlockPos;
        bArr[i] = b;
        int i2 = i + 1;
        this.atBlockPos = i2;
        if (i2 == 16) {
            gHASHBlock(this.f20569S_at, bArr);
            this.atBlockPos = 0;
            this.atLength += 16;
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public void processAADBytes(byte[] bArr, int i, int i2) {
        checkStatus();
        int i3 = this.atBlockPos;
        if (i3 > 0) {
            int i4 = 16 - i3;
            if (i2 < i4) {
                System.arraycopy(bArr, i, this.f20571atBlock, i3, i2);
                this.atBlockPos += i2;
                return;
            } else {
                System.arraycopy(bArr, i, this.f20571atBlock, i3, i4);
                gHASHBlock(this.f20569S_at, this.f20571atBlock);
                this.atLength += 16;
                i += i4;
                i2 -= i4;
            }
        }
        int i5 = i2 + i;
        int i6 = i5 - 16;
        while (i <= i6) {
            gHASHBlock(this.f20569S_at, bArr, i);
            this.atLength += 16;
            i += 16;
        }
        int i7 = i5 - i;
        this.atBlockPos = i7;
        System.arraycopy(bArr, i, this.f20571atBlock, 0, i7);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int processByte(byte b, byte[] bArr, int i) {
        checkStatus();
        byte[] bArr2 = this.bufBlock;
        int i2 = this.f20572bufOff;
        bArr2[i2] = b;
        int i3 = i2 + 1;
        this.f20572bufOff = i3;
        if (i3 != bArr2.length) {
            return 0;
        }
        if (this.forEncryption) {
            encryptBlock(bArr2, 0, bArr, i);
            this.f20572bufOff = 0;
        } else {
            decryptBlock(bArr2, 0, bArr, i);
            byte[] bArr3 = this.bufBlock;
            System.arraycopy(bArr3, 16, bArr3, 0, this.f20577macSize);
            this.f20572bufOff = this.f20577macSize;
        }
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4;
        checkStatus();
        if (bArr.length - i < i2) {
            throw new DataLengthException("Input buffer too short");
        }
        if (bArr == bArr2 && C6238Arrays.segmentsOverlap(i, i2, i3, getUpdateOutputSize(i2))) {
            bArr = new byte[i2];
            System.arraycopy(bArr2, i, bArr, 0, i2);
            i = 0;
        }
        int i5 = 16;
        if (this.forEncryption) {
            int i6 = this.f20572bufOff;
            if (i6 > 0) {
                int i7 = 16 - i6;
                if (i2 < i7) {
                    System.arraycopy(bArr, i, this.bufBlock, i6, i2);
                    this.f20572bufOff += i2;
                    return 0;
                }
                System.arraycopy(bArr, i, this.bufBlock, i6, i7);
                encryptBlock(this.bufBlock, 0, bArr2, i3);
                i += i7;
                i2 -= i7;
            } else {
                i5 = 0;
            }
            int i8 = i2 + i;
            int i9 = i8 - 16;
            while (i <= i9) {
                encryptBlock(bArr, i, bArr2, i3 + i5);
                i += 16;
                i5 += 16;
            }
            int i10 = i8 - i;
            this.f20572bufOff = i10;
            System.arraycopy(bArr, i, this.bufBlock, 0, i10);
            return i5;
        }
        byte[] bArr3 = this.bufBlock;
        int length = bArr3.length;
        int i11 = this.f20572bufOff;
        int i12 = length - i11;
        if (i2 < i12) {
            System.arraycopy(bArr, i, bArr3, i11, i2);
            this.f20572bufOff += i2;
            return 0;
        }
        if (i11 >= 16) {
            decryptBlock(bArr3, 0, bArr2, i3);
            byte[] bArr4 = this.bufBlock;
            int i13 = this.f20572bufOff - 16;
            this.f20572bufOff = i13;
            System.arraycopy(bArr4, 16, bArr4, 0, i13);
            if (i2 < i12 + 16) {
                System.arraycopy(bArr, i, this.bufBlock, this.f20572bufOff, i2);
                this.f20572bufOff += i2;
                return 16;
            }
            i4 = 16;
        } else {
            i4 = 0;
        }
        byte[] bArr5 = this.bufBlock;
        int length2 = (i2 + i) - bArr5.length;
        int i14 = this.f20572bufOff;
        int i15 = 16 - i14;
        System.arraycopy(bArr, i, bArr5, i14, i15);
        decryptBlock(this.bufBlock, 0, bArr2, i3 + i4);
        int i16 = i + i15;
        i5 = i4 + 16;
        while (i16 <= length2) {
            decryptBlock(bArr, i16, bArr2, i3 + i5);
            i16 += 16;
            i5 += 16;
        }
        byte[] bArr6 = this.bufBlock;
        int length3 = (bArr6.length + length2) - i16;
        this.f20572bufOff = length3;
        System.arraycopy(bArr, i16, bArr6, 0, length3);
        return i5;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: reset */
    public void mo15228reset() {
        m15602reset(true);
    }

    public GCMBlockCipher(BlockCipher blockCipher, GCMMultiplier gCMMultiplier) {
        if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
        gCMMultiplier = gCMMultiplier == null ? new Tables4kGCMMultiplier() : gCMMultiplier;
        this.f20573cipher = blockCipher;
        this.multiplier = gCMMultiplier;
    }

    private void gHASHBlock(byte[] bArr, byte[] bArr2, int i) {
        AbstractC5369GCMUtil.m15634xor(bArr, bArr2, i);
        this.multiplier.multiplyH(bArr);
    }

    public static GCMModeCipher newInstance(BlockCipher blockCipher, GCMMultiplier gCMMultiplier) {
        return new GCMBlockCipher(blockCipher, gCMMultiplier);
    }

    /* renamed from: reset */
    private void m15602reset(boolean z) {
        this.f20573cipher.mo14947reset();
        this.f20568S = new byte[16];
        this.f20569S_at = new byte[16];
        this.f20570S_atPre = new byte[16];
        this.f20571atBlock = new byte[16];
        this.atBlockPos = 0;
        this.atLength = 0L;
        this.atLengthPre = 0L;
        this.f20574counter = C6238Arrays.m18231clone(this.f20567J0);
        this.blocksRemaining = -2;
        this.f20572bufOff = 0;
        this.totalLength = 0L;
        byte[] bArr = this.bufBlock;
        if (bArr != null) {
            C6238Arrays.m18249fill(bArr, (byte) 0);
        }
        if (z) {
            this.macBlock = null;
        }
        if (this.forEncryption) {
            this.initialised = false;
            return;
        }
        byte[] bArr2 = this.initialAssociatedText;
        if (bArr2 != null) {
            processAADBytes(bArr2, 0, bArr2.length);
        }
    }
}
