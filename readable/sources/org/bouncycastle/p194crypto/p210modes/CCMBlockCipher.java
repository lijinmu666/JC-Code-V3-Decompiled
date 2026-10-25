package org.bouncycastle.p194crypto.p210modes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p209macs.CBCBlockCipherMac;
import org.bouncycastle.p194crypto.p213params.AEADParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class CCMBlockCipher implements CCMModeCipher {
    private int blockSize;

    /* renamed from: cipher */
    private BlockCipher f20517cipher;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private CipherParameters keyParam;
    private byte[] macBlock;

    /* renamed from: macSize */
    private int f20519macSize;

    /* renamed from: nonce */
    private byte[] f20520nonce;
    private ExposedByteArrayOutputStream associatedText = new ExposedByteArrayOutputStream();

    /* renamed from: data */
    private ExposedByteArrayOutputStream f20518data = new ExposedByteArrayOutputStream();

    public static class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public byte[] getBuffer() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public CCMBlockCipher(BlockCipher blockCipher) {
        this.f20517cipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.macBlock = new byte[blockSize];
        if (blockSize != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
    }

    private int calculateMac(byte[] bArr, int i, int i2, byte[] bArr2) {
        CBCBlockCipherMac cBCBlockCipherMac = new CBCBlockCipherMac(this.f20517cipher, this.f20519macSize * 8);
        cBCBlockCipherMac.mo14976init(this.keyParam);
        byte[] bArr3 = new byte[16];
        if (hasAssociatedText()) {
            bArr3[0] = (byte) (bArr3[0] | 64);
        }
        int i3 = 2;
        byte macSize = (byte) (bArr3[0] | ((((cBCBlockCipherMac.getMacSize() - 2) / 2) & 7) << 3));
        bArr3[0] = macSize;
        byte[] bArr4 = this.f20520nonce;
        bArr3[0] = (byte) (macSize | ((14 - bArr4.length) & 7));
        System.arraycopy(bArr4, 0, bArr3, 1, bArr4.length);
        int i4 = i2;
        int i5 = 1;
        while (i4 > 0) {
            bArr3[16 - i5] = (byte) (i4 & 255);
            i4 >>>= 8;
            i5++;
        }
        cBCBlockCipherMac.mo14979update(bArr3, 0, 16);
        if (hasAssociatedText()) {
            int associatedTextLength = getAssociatedTextLength();
            if (associatedTextLength < 65280) {
                cBCBlockCipherMac.mo14978update((byte) (associatedTextLength >> 8));
                cBCBlockCipherMac.mo14978update((byte) associatedTextLength);
            } else {
                cBCBlockCipherMac.mo14978update((byte) -1);
                cBCBlockCipherMac.mo14978update((byte) -2);
                cBCBlockCipherMac.mo14978update((byte) (associatedTextLength >> 24));
                cBCBlockCipherMac.mo14978update((byte) (associatedTextLength >> 16));
                cBCBlockCipherMac.mo14978update((byte) (associatedTextLength >> 8));
                cBCBlockCipherMac.mo14978update((byte) associatedTextLength);
                i3 = 6;
            }
            byte[] bArr5 = this.initialAssociatedText;
            if (bArr5 != null) {
                cBCBlockCipherMac.mo14979update(bArr5, 0, bArr5.length);
            }
            if (this.associatedText.size() > 0) {
                cBCBlockCipherMac.mo14979update(this.associatedText.getBuffer(), 0, this.associatedText.size());
            }
            int i6 = (i3 + associatedTextLength) % 16;
            if (i6 != 0) {
                while (i6 != 16) {
                    cBCBlockCipherMac.mo14978update((byte) 0);
                    i6++;
                }
            }
        }
        cBCBlockCipherMac.mo14979update(bArr, i, i2);
        return cBCBlockCipherMac.mo14975doFinal(bArr2, 0);
    }

    private int getAssociatedTextLength() {
        int size = this.associatedText.size();
        byte[] bArr = this.initialAssociatedText;
        return size + (bArr == null ? 0 : bArr.length);
    }

    private int getMacSize(boolean z, int i) {
        if (!z || (i >= 32 && i <= 128 && (i & 15) == 0)) {
            return i >>> 3;
        }
        throw new IllegalArgumentException("tag length in octets must be one of {4,6,8,10,12,14,16}");
    }

    private boolean hasAssociatedText() {
        return getAssociatedTextLength() > 0;
    }

    public static CCMModeCipher newInstance(BlockCipher blockCipher) {
        return new CCMBlockCipher(blockCipher);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: doFinal */
    public int mo15224doFinal(byte[] bArr, int i) throws InvalidCipherTextException {
        int iProcessPacket = processPacket(this.f20518data.getBuffer(), 0, this.f20518data.size(), bArr, i);
        mo15228reset();
        return iProcessPacket;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public String getAlgorithmName() {
        return this.f20517cipher.getAlgorithmName() + "/CCM";
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: getMac */
    public byte[] mo15225getMac() {
        int i = this.f20519macSize;
        byte[] bArr = new byte[i];
        System.arraycopy(this.macBlock, 0, bArr, 0, i);
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getOutputSize(int i) {
        int size = i + this.f20518data.size();
        boolean z = this.forEncryption;
        int i2 = this.f20519macSize;
        if (z) {
            return size + i2;
        }
        if (size < i2) {
            return 0;
        }
        return size - i2;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.f20517cipher;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getUpdateOutputSize(int i) {
        return 0;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: init */
    public void mo15226init(boolean z, CipherParameters cipherParameters) {
        CipherParameters parameters;
        this.forEncryption = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            this.f20520nonce = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            this.f20519macSize = getMacSize(z, aEADParameters.getMacSize());
            parameters = aEADParameters.m15664getKey();
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("invalid parameters passed to CCM: " + cipherParameters.getClass().getName());
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f20520nonce = parametersWithIV.m15801getIV();
            this.initialAssociatedText = null;
            this.f20519macSize = getMacSize(z, 64);
            parameters = parametersWithIV.getParameters();
        }
        if (parameters != null) {
            this.keyParam = parameters;
        }
        byte[] bArr = this.f20520nonce;
        if (bArr == null || bArr.length < 7 || bArr.length > 13) {
            throw new IllegalArgumentException("nonce must have length from 7 to 13 octets");
        }
        mo15228reset();
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public void processAADByte(byte b) throws IOException {
        this.associatedText.write(b);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public void processAADBytes(byte[] bArr, int i, int i2) throws IOException {
        this.associatedText.write(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int processByte(byte b, byte[] bArr, int i) throws IOException {
        this.f20518data.write(b);
        return 0;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException {
        if (bArr.length < i + i2) {
            throw new DataLengthException("Input buffer too short");
        }
        this.f20518data.write(bArr, i, i2);
        return 0;
    }

    public int processPacket(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws InvalidCipherTextException {
        int i4;
        if (this.keyParam == null) {
            throw new IllegalStateException("CCM cipher unitialized.");
        }
        byte[] bArr3 = this.f20520nonce;
        int length = bArr3.length;
        int i5 = 15 - length;
        if (i5 < 4) {
            if (i2 - (!this.forEncryption ? 16 : 0) >= (1 << (i5 * 8))) {
                throw new IllegalStateException("CCM packet too large for choice of q");
            }
        }
        byte[] bArr4 = new byte[this.blockSize];
        bArr4[0] = (byte) ((14 - length) & 7);
        System.arraycopy(bArr3, 0, bArr4, 1, bArr3.length);
        CTRModeCipher cTRModeCipherNewInstance = SICBlockCipher.newInstance(this.f20517cipher);
        cTRModeCipherNewInstance.mo14946init(this.forEncryption, new ParametersWithIV(this.keyParam, bArr4));
        if (!this.forEncryption) {
            int i6 = this.f20519macSize;
            if (i2 < i6) {
                throw new InvalidCipherTextException("data too short");
            }
            int i7 = i2 - i6;
            if (bArr2.length < i7 + i3) {
                throw new OutputLengthException("Output buffer too short.");
            }
            int i8 = i + i7;
            System.arraycopy(bArr, i8, this.macBlock, 0, i6);
            byte[] bArr5 = this.macBlock;
            cTRModeCipherNewInstance.processBlock(bArr5, 0, bArr5, 0);
            int i9 = this.f20519macSize;
            while (true) {
                byte[] bArr6 = this.macBlock;
                if (i9 == bArr6.length) {
                    break;
                }
                bArr6[i9] = 0;
                i9++;
            }
            int i10 = i;
            int i11 = i3;
            while (true) {
                i4 = this.blockSize;
                if (i10 >= i8 - i4) {
                    break;
                }
                cTRModeCipherNewInstance.processBlock(bArr, i10, bArr2, i11);
                int i12 = this.blockSize;
                i11 += i12;
                i10 += i12;
            }
            byte[] bArr7 = new byte[i4];
            int i13 = i7 - (i10 - i);
            System.arraycopy(bArr, i10, bArr7, 0, i13);
            cTRModeCipherNewInstance.processBlock(bArr7, 0, bArr7, 0);
            System.arraycopy(bArr7, 0, bArr2, i11, i13);
            byte[] bArr8 = new byte[this.blockSize];
            calculateMac(bArr2, i3, i7, bArr8);
            if (C6238Arrays.constantTimeAreEqual(this.macBlock, bArr8)) {
                return i7;
            }
            throw new InvalidCipherTextException("mac check in CCM failed");
        }
        int i14 = this.f20519macSize + i2;
        if (bArr2.length < i14 + i3) {
            throw new OutputLengthException("Output buffer too short.");
        }
        calculateMac(bArr, i, i2, this.macBlock);
        byte[] bArr9 = new byte[this.blockSize];
        cTRModeCipherNewInstance.processBlock(this.macBlock, 0, bArr9, 0);
        int i15 = i;
        int i16 = i3;
        while (true) {
            int i17 = i + i2;
            int i18 = this.blockSize;
            if (i15 >= i17 - i18) {
                byte[] bArr10 = new byte[i18];
                int i19 = i17 - i15;
                System.arraycopy(bArr, i15, bArr10, 0, i19);
                cTRModeCipherNewInstance.processBlock(bArr10, 0, bArr10, 0);
                System.arraycopy(bArr10, 0, bArr2, i16, i19);
                System.arraycopy(bArr9, 0, bArr2, i3 + i2, this.f20519macSize);
                return i14;
            }
            cTRModeCipherNewInstance.processBlock(bArr, i15, bArr2, i16);
            int i20 = this.blockSize;
            i16 += i20;
            i15 += i20;
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: reset */
    public void mo15228reset() {
        this.f20517cipher.mo14947reset();
        this.associatedText.reset();
        this.f20518data.reset();
    }

    public byte[] processPacket(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        int i3;
        if (this.forEncryption) {
            i3 = this.f20519macSize + i2;
        } else {
            int i4 = this.f20519macSize;
            if (i2 < i4) {
                throw new InvalidCipherTextException("data too short");
            }
            i3 = i2 - i4;
        }
        byte[] bArr2 = new byte[i3];
        processPacket(bArr, i, i2, bArr2, 0);
        return bArr2;
    }
}
