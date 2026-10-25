package org.bouncycastle.p194crypto.p210modes;

import java.util.Vector;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p213params.AEADParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;
import org.bouncycastle.p361util.C6243Longs;
import p094kotlin.C1126UByte;
import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p132okio.C5066Utf8;

/* loaded from: classes2.dex */
public class OCBBlockCipher implements AEADBlockCipher {
    private static final int BLOCK_SIZE = 16;
    private byte[] Checksum;

    /* renamed from: L */
    private Vector f20618L;
    private byte[] L_Asterisk;
    private byte[] L_Dollar;
    private byte[] OffsetHASH;

    /* renamed from: Sum */
    private byte[] f20620Sum;
    private boolean forEncryption;
    private byte[] hashBlock;
    private long hashBlockCount;
    private int hashBlockPos;
    private BlockCipher hashCipher;
    private byte[] initialAssociatedText;
    private byte[] macBlock;

    /* renamed from: macSize */
    private int f20621macSize;
    private byte[] mainBlock;
    private long mainBlockCount;
    private int mainBlockPos;
    private BlockCipher mainCipher;
    private byte[] KtopInput = null;

    /* renamed from: Stretch */
    private byte[] f20619Stretch = new byte[24];
    private byte[] OffsetMAIN_0 = new byte[16];
    private byte[] OffsetMAIN = new byte[16];

    public OCBBlockCipher(BlockCipher blockCipher, BlockCipher blockCipher2) {
        if (blockCipher == null) {
            throw new IllegalArgumentException("'hashCipher' cannot be null");
        }
        if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("'hashCipher' must have a block size of 16");
        }
        if (blockCipher2 == null) {
            throw new IllegalArgumentException("'mainCipher' cannot be null");
        }
        if (blockCipher2.getBlockSize() != 16) {
            throw new IllegalArgumentException("'mainCipher' must have a block size of 16");
        }
        if (!blockCipher.getAlgorithmName().equals(blockCipher2.getAlgorithmName())) {
            throw new IllegalArgumentException("'hashCipher' and 'mainCipher' must be the same algorithm");
        }
        this.hashCipher = blockCipher;
        this.mainCipher = blockCipher2;
    }

    public static byte[] OCB_double(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) ((135 >>> ((1 - shiftLeft(bArr, bArr2)) << 3)) ^ bArr2[15]);
        return bArr2;
    }

    public static void OCB_extend(byte[] bArr, int i) {
        bArr[i] = ByteCompanionObject.MIN_VALUE;
        while (true) {
            i++;
            if (i >= 16) {
                return;
            } else {
                bArr[i] = 0;
            }
        }
    }

    /* renamed from: OCB_ntz */
    public static int m15611OCB_ntz(long j) {
        return C6243Longs.numberOfTrailingZeros(j);
    }

    public static int shiftLeft(byte[] bArr, byte[] bArr2) {
        int i = 16;
        int i2 = 0;
        while (true) {
            i--;
            if (i < 0) {
                return i2;
            }
            int i3 = bArr[i] & C1126UByte.MAX_VALUE;
            bArr2[i] = (byte) (i2 | (i3 << 1));
            i2 = (i3 >>> 7) & 1;
        }
    }

    /* renamed from: xor */
    public static void m15612xor(byte[] bArr, byte[] bArr2) {
        C6240Bytes.m18281xorTo(16, bArr2, bArr);
    }

    /* renamed from: clear */
    public void m15613clear(byte[] bArr) {
        if (bArr != null) {
            C6238Arrays.m18249fill(bArr, (byte) 0);
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: doFinal */
    public int mo15224doFinal(byte[] bArr, int i) throws InvalidCipherTextException {
        byte[] bArr2;
        if (this.forEncryption) {
            bArr2 = null;
        } else {
            int i2 = this.mainBlockPos;
            int i3 = this.f20621macSize;
            if (i2 < i3) {
                throw new InvalidCipherTextException("data too short");
            }
            int i4 = i2 - i3;
            this.mainBlockPos = i4;
            bArr2 = new byte[i3];
            System.arraycopy(this.mainBlock, i4, bArr2, 0, i3);
        }
        int i5 = this.hashBlockPos;
        if (i5 > 0) {
            OCB_extend(this.hashBlock, i5);
            updateHASH(this.L_Asterisk);
        }
        int i6 = this.mainBlockPos;
        if (i6 > 0) {
            if (this.forEncryption) {
                OCB_extend(this.mainBlock, i6);
                m15612xor(this.Checksum, this.mainBlock);
            }
            m15612xor(this.OffsetMAIN, this.L_Asterisk);
            byte[] bArr3 = new byte[16];
            this.hashCipher.processBlock(this.OffsetMAIN, 0, bArr3, 0);
            m15612xor(this.mainBlock, bArr3);
            int length = bArr.length;
            int i7 = this.mainBlockPos;
            if (length < i + i7) {
                throw new OutputLengthException("Output buffer too short");
            }
            System.arraycopy(this.mainBlock, 0, bArr, i, i7);
            if (!this.forEncryption) {
                OCB_extend(this.mainBlock, this.mainBlockPos);
                m15612xor(this.Checksum, this.mainBlock);
            }
        }
        m15612xor(this.Checksum, this.OffsetMAIN);
        m15612xor(this.Checksum, this.L_Dollar);
        BlockCipher blockCipher = this.hashCipher;
        byte[] bArr4 = this.Checksum;
        blockCipher.processBlock(bArr4, 0, bArr4, 0);
        m15612xor(this.Checksum, this.f20620Sum);
        int i8 = this.f20621macSize;
        byte[] bArr5 = new byte[i8];
        this.macBlock = bArr5;
        System.arraycopy(this.Checksum, 0, bArr5, 0, i8);
        int i9 = this.mainBlockPos;
        if (this.forEncryption) {
            int length2 = bArr.length;
            int i10 = i + i9;
            int i11 = this.f20621macSize;
            if (length2 < i10 + i11) {
                throw new OutputLengthException("Output buffer too short");
            }
            System.arraycopy(this.macBlock, 0, bArr, i10, i11);
            i9 += this.f20621macSize;
        } else if (!C6238Arrays.constantTimeAreEqual(this.macBlock, bArr2)) {
            throw new InvalidCipherTextException("mac check in OCB failed");
        }
        m15615reset(false);
        return i9;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public String getAlgorithmName() {
        return this.mainCipher.getAlgorithmName() + "/OCB";
    }

    /* renamed from: getLSub */
    public byte[] m15614getLSub(int i) {
        while (i >= this.f20618L.size()) {
            Vector vector = this.f20618L;
            vector.addElement(OCB_double((byte[]) vector.lastElement()));
        }
        return (byte[]) this.f20618L.elementAt(i);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: getMac */
    public byte[] mo15225getMac() {
        byte[] bArr = this.macBlock;
        return bArr == null ? new byte[this.f20621macSize] : C6238Arrays.m18231clone(bArr);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getOutputSize(int i) {
        int i2 = i + this.mainBlockPos;
        boolean z = this.forEncryption;
        int i3 = this.f20621macSize;
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
        return this.mainCipher;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getUpdateOutputSize(int i) {
        int i2 = i + this.mainBlockPos;
        if (!this.forEncryption) {
            int i3 = this.f20621macSize;
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
        boolean z2 = this.forEncryption;
        this.forEncryption = z;
        this.macBlock = null;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            bArrM15801getIV = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            int macSize = aEADParameters.getMacSize();
            if (macSize < 64 || macSize > 128 || macSize % 8 != 0) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + macSize);
            }
            this.f20621macSize = macSize / 8;
            keyParameterM15664getKey = aEADParameters.m15664getKey();
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("invalid parameters passed to OCB");
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArrM15801getIV = parametersWithIV.m15801getIV();
            this.initialAssociatedText = null;
            this.f20621macSize = 16;
            keyParameterM15664getKey = (KeyParameter) parametersWithIV.getParameters();
        }
        this.hashBlock = new byte[16];
        this.mainBlock = new byte[z ? 16 : this.f20621macSize + 16];
        if (bArrM15801getIV == null) {
            bArrM15801getIV = new byte[0];
        }
        if (bArrM15801getIV.length > 15) {
            throw new IllegalArgumentException("IV must be no more than 15 bytes");
        }
        if (keyParameterM15664getKey != null) {
            this.hashCipher.mo14946init(true, keyParameterM15664getKey);
            this.mainCipher.mo14946init(z, keyParameterM15664getKey);
            this.KtopInput = null;
        } else if (z2 != z) {
            throw new IllegalArgumentException("cannot change encrypting state without providing key.");
        }
        byte[] bArr = new byte[16];
        this.L_Asterisk = bArr;
        this.hashCipher.processBlock(bArr, 0, bArr, 0);
        this.L_Dollar = OCB_double(this.L_Asterisk);
        Vector vector = new Vector();
        this.f20618L = vector;
        vector.addElement(OCB_double(this.L_Dollar));
        int iProcessNonce = processNonce(bArrM15801getIV);
        int i = iProcessNonce % 8;
        int i2 = iProcessNonce / 8;
        if (i == 0) {
            System.arraycopy(this.f20619Stretch, i2, this.OffsetMAIN_0, 0, 16);
        } else {
            for (int i3 = 0; i3 < 16; i3++) {
                byte[] bArr2 = this.f20619Stretch;
                int i4 = bArr2[i2] & C1126UByte.MAX_VALUE;
                i2++;
                this.OffsetMAIN_0[i3] = (byte) (((bArr2[i2] & C1126UByte.MAX_VALUE) >>> (8 - i)) | (i4 << i));
            }
        }
        this.hashBlockPos = 0;
        this.mainBlockPos = 0;
        this.hashBlockCount = 0L;
        this.mainBlockCount = 0L;
        this.OffsetHASH = new byte[16];
        this.f20620Sum = new byte[16];
        System.arraycopy(this.OffsetMAIN_0, 0, this.OffsetMAIN, 0, 16);
        this.Checksum = new byte[16];
        byte[] bArr3 = this.initialAssociatedText;
        if (bArr3 != null) {
            processAADBytes(bArr3, 0, bArr3.length);
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public void processAADByte(byte b) {
        byte[] bArr = this.hashBlock;
        int i = this.hashBlockPos;
        bArr[i] = b;
        int i2 = i + 1;
        this.hashBlockPos = i2;
        if (i2 == bArr.length) {
            processHashBlock();
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public void processAADBytes(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr2 = this.hashBlock;
            int i4 = this.hashBlockPos;
            bArr2[i4] = bArr[i + i3];
            int i5 = i4 + 1;
            this.hashBlockPos = i5;
            if (i5 == bArr2.length) {
                processHashBlock();
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int processByte(byte b, byte[] bArr, int i) {
        byte[] bArr2 = this.mainBlock;
        int i2 = this.mainBlockPos;
        bArr2[i2] = b;
        int i3 = i2 + 1;
        this.mainBlockPos = i3;
        if (i3 != bArr2.length) {
            return 0;
        }
        processMainBlock(bArr, i);
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (bArr.length < i + i2) {
            throw new DataLengthException("Input buffer too short");
        }
        if (bArr == bArr2 && C6238Arrays.segmentsOverlap(i, i2, i3, getUpdateOutputSize(i2))) {
            bArr = new byte[i2];
            System.arraycopy(bArr2, i, bArr, 0, i2);
            i = 0;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            byte[] bArr3 = this.mainBlock;
            int i6 = this.mainBlockPos;
            bArr3[i6] = bArr[i + i5];
            int i7 = i6 + 1;
            this.mainBlockPos = i7;
            if (i7 == bArr3.length) {
                processMainBlock(bArr2, i3 + i4);
                i4 += 16;
            }
        }
        return i4;
    }

    public void processHashBlock() {
        long j = this.hashBlockCount + 1;
        this.hashBlockCount = j;
        updateHASH(m15614getLSub(m15611OCB_ntz(j)));
        this.hashBlockPos = 0;
    }

    public void processMainBlock(byte[] bArr, int i) {
        if (bArr.length < i + 16) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (this.forEncryption) {
            m15612xor(this.Checksum, this.mainBlock);
            this.mainBlockPos = 0;
        }
        byte[] bArr2 = this.OffsetMAIN;
        long j = this.mainBlockCount + 1;
        this.mainBlockCount = j;
        m15612xor(bArr2, m15614getLSub(m15611OCB_ntz(j)));
        m15612xor(this.mainBlock, this.OffsetMAIN);
        BlockCipher blockCipher = this.mainCipher;
        byte[] bArr3 = this.mainBlock;
        blockCipher.processBlock(bArr3, 0, bArr3, 0);
        m15612xor(this.mainBlock, this.OffsetMAIN);
        System.arraycopy(this.mainBlock, 0, bArr, i, 16);
        if (this.forEncryption) {
            return;
        }
        m15612xor(this.Checksum, this.mainBlock);
        byte[] bArr4 = this.mainBlock;
        System.arraycopy(bArr4, 16, bArr4, 0, this.f20621macSize);
        this.mainBlockPos = this.f20621macSize;
    }

    public int processNonce(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        System.arraycopy(bArr, 0, bArr2, 16 - bArr.length, bArr.length);
        bArr2[0] = (byte) (this.f20621macSize << 4);
        int length = 15 - bArr.length;
        bArr2[length] = (byte) (bArr2[length] | 1);
        byte b = bArr2[15];
        int i2 = b & C5066Utf8.REPLACEMENT_BYTE;
        bArr2[15] = (byte) (b & 192);
        byte[] bArr3 = this.KtopInput;
        if (bArr3 == null || !C6238Arrays.areEqual(bArr2, bArr3)) {
            byte[] bArr4 = new byte[16];
            this.KtopInput = bArr2;
            this.hashCipher.processBlock(bArr2, 0, bArr4, 0);
            System.arraycopy(bArr4, 0, this.f20619Stretch, 0, 16);
            while (i < 8) {
                byte[] bArr5 = this.f20619Stretch;
                int i3 = i + 16;
                byte b2 = bArr4[i];
                i++;
                bArr5[i3] = (byte) (b2 ^ bArr4[i]);
            }
        }
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: reset */
    public void mo15228reset() {
        m15615reset(true);
    }

    public void updateHASH(byte[] bArr) {
        m15612xor(this.OffsetHASH, bArr);
        m15612xor(this.hashBlock, this.OffsetHASH);
        BlockCipher blockCipher = this.hashCipher;
        byte[] bArr2 = this.hashBlock;
        blockCipher.processBlock(bArr2, 0, bArr2, 0);
        m15612xor(this.f20620Sum, this.hashBlock);
    }

    /* renamed from: reset */
    public void m15615reset(boolean z) {
        this.hashCipher.mo14947reset();
        this.mainCipher.mo14947reset();
        m15613clear(this.hashBlock);
        m15613clear(this.mainBlock);
        this.hashBlockPos = 0;
        this.mainBlockPos = 0;
        this.hashBlockCount = 0L;
        this.mainBlockCount = 0L;
        m15613clear(this.OffsetHASH);
        m15613clear(this.f20620Sum);
        System.arraycopy(this.OffsetMAIN_0, 0, this.OffsetMAIN, 0, 16);
        m15613clear(this.Checksum);
        if (z) {
            this.macBlock = null;
        }
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }
}
