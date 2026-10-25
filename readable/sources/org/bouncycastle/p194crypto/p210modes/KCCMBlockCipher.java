package org.bouncycastle.p194crypto.p210modes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p213params.AEADParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class KCCMBlockCipher implements AEADBlockCipher {
    private static final int BITS_IN_BYTE = 8;
    private static final int BYTES_IN_INT = 4;
    private static final int MAX_MAC_BIT_LENGTH = 512;
    private static final int MIN_MAC_BIT_LENGTH = 64;

    /* renamed from: G1 */
    private byte[] f20593G1;

    /* renamed from: Nb_ */
    private int f20594Nb_;
    private ExposedByteArrayOutputStream associatedText;

    /* renamed from: buffer */
    private byte[] f20595buffer;

    /* renamed from: counter */
    private byte[] f20596counter;

    /* renamed from: data */
    private ExposedByteArrayOutputStream f20597data;

    /* renamed from: engine */
    private BlockCipher f20598engine;
    private boolean forEncryption;
    private byte[] initialAssociatedText;

    /* renamed from: mac */
    private byte[] f20599mac;
    private byte[] macBlock;

    /* renamed from: macSize */
    private int f20600macSize;

    /* renamed from: nonce */
    private byte[] f20601nonce;

    /* renamed from: s */
    private byte[] f20602s;

    public static class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public byte[] getBuffer() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public KCCMBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, 4);
    }

    private void CalculateMac(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            for (int i3 = 0; i3 < this.f20598engine.getBlockSize(); i3++) {
                byte[] bArr2 = this.macBlock;
                bArr2[i3] = (byte) (bArr2[i3] ^ bArr[i + i3]);
            }
            BlockCipher blockCipher = this.f20598engine;
            byte[] bArr3 = this.macBlock;
            blockCipher.processBlock(bArr3, 0, bArr3, 0);
            i2 -= this.f20598engine.getBlockSize();
            i += this.f20598engine.getBlockSize();
        }
    }

    private void ProcessBlock(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = 0;
        while (true) {
            byte[] bArr3 = this.f20596counter;
            if (i4 >= bArr3.length) {
                break;
            }
            byte[] bArr4 = this.f20602s;
            bArr4[i4] = (byte) (bArr4[i4] + bArr3[i4]);
            i4++;
        }
        this.f20598engine.processBlock(this.f20602s, 0, this.f20595buffer, 0);
        for (int i5 = 0; i5 < this.f20598engine.getBlockSize(); i5++) {
            bArr2[i3 + i5] = (byte) (this.f20595buffer[i5] ^ bArr[i + i5]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048 A[LOOP:0: B:24:0x0041->B:26:0x0048, LOOP_END] */
    /* renamed from: getFlag */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte m15609getFlag(boolean z, int i) {
        String str;
        String binaryString;
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("1");
        } else {
            sb.append("0");
        }
        if (i == 8) {
            str = "010";
        } else if (i == 16) {
            str = "011";
        } else if (i == 32) {
            str = "100";
        } else {
            if (i != 48) {
                if (i == 64) {
                    str = "110";
                }
                binaryString = Integer.toBinaryString(this.f20594Nb_ - 1);
                while (binaryString.length() < 4) {
                    binaryString = new StringBuilder(binaryString).insert(0, "0").toString();
                }
                sb.append(binaryString);
                return (byte) Integer.parseInt(sb.toString(), 2);
            }
            str = "101";
        }
        sb.append(str);
        binaryString = Integer.toBinaryString(this.f20594Nb_ - 1);
        while (binaryString.length() < 4) {
        }
        sb.append(binaryString);
        return (byte) Integer.parseInt(sb.toString(), 2);
    }

    private void intToBytes(int i, byte[] bArr, int i2) {
        bArr[i2 + 3] = (byte) (i >> 24);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2] = (byte) i;
    }

    private void processAAD(byte[] bArr, int i, int i2, int i3) {
        if (i2 - i < this.f20598engine.getBlockSize()) {
            throw new IllegalArgumentException("authText buffer too short");
        }
        if (i2 % this.f20598engine.getBlockSize() != 0) {
            throw new IllegalArgumentException("padding not supported");
        }
        byte[] bArr2 = this.f20601nonce;
        System.arraycopy(bArr2, 0, this.f20593G1, 0, (bArr2.length - this.f20594Nb_) - 1);
        intToBytes(i3, this.f20595buffer, 0);
        System.arraycopy(this.f20595buffer, 0, this.f20593G1, (this.f20601nonce.length - this.f20594Nb_) - 1, 4);
        byte[] bArr3 = this.f20593G1;
        bArr3[bArr3.length - 1] = m15609getFlag(true, this.f20600macSize);
        this.f20598engine.processBlock(this.f20593G1, 0, this.macBlock, 0);
        intToBytes(i2, this.f20595buffer, 0);
        if (i2 <= this.f20598engine.getBlockSize() - this.f20594Nb_) {
            for (int i4 = 0; i4 < i2; i4++) {
                byte[] bArr4 = this.f20595buffer;
                int i5 = this.f20594Nb_ + i4;
                bArr4[i5] = (byte) (bArr4[i5] ^ bArr[i + i4]);
            }
            for (int i6 = 0; i6 < this.f20598engine.getBlockSize(); i6++) {
                byte[] bArr5 = this.macBlock;
                bArr5[i6] = (byte) (bArr5[i6] ^ this.f20595buffer[i6]);
            }
            BlockCipher blockCipher = this.f20598engine;
            byte[] bArr6 = this.macBlock;
            blockCipher.processBlock(bArr6, 0, bArr6, 0);
            return;
        }
        for (int i7 = 0; i7 < this.f20598engine.getBlockSize(); i7++) {
            byte[] bArr7 = this.macBlock;
            bArr7[i7] = (byte) (bArr7[i7] ^ this.f20595buffer[i7]);
        }
        BlockCipher blockCipher2 = this.f20598engine;
        byte[] bArr8 = this.macBlock;
        blockCipher2.processBlock(bArr8, 0, bArr8, 0);
        while (i2 != 0) {
            for (int i8 = 0; i8 < this.f20598engine.getBlockSize(); i8++) {
                byte[] bArr9 = this.macBlock;
                bArr9[i8] = (byte) (bArr9[i8] ^ bArr[i8 + i]);
            }
            BlockCipher blockCipher3 = this.f20598engine;
            byte[] bArr10 = this.macBlock;
            blockCipher3.processBlock(bArr10, 0, bArr10, 0);
            i += this.f20598engine.getBlockSize();
            i2 -= this.f20598engine.getBlockSize();
        }
    }

    /* renamed from: setNb */
    private void m15610setNb(int i) {
        if (i != 4 && i != 6 && i != 8) {
            throw new IllegalArgumentException("Nb = 4 is recommended by DSTU7624 but can be changed to only 6 or 8 in this implementation");
        }
        this.f20594Nb_ = i;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: doFinal */
    public int mo15224doFinal(byte[] bArr, int i) throws InvalidCipherTextException, IOException {
        int iProcessPacket = processPacket(this.f20597data.getBuffer(), 0, this.f20597data.size(), bArr, i);
        mo15228reset();
        return iProcessPacket;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public String getAlgorithmName() {
        return this.f20598engine.getAlgorithmName() + "/KCCM";
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: getMac */
    public byte[] mo15225getMac() {
        return C6238Arrays.m18231clone(this.f20599mac);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getOutputSize(int i) {
        return i + this.f20600macSize;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.f20598engine;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getUpdateOutputSize(int i) {
        return i;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: init */
    public void mo15226init(boolean z, CipherParameters cipherParameters) throws IOException {
        CipherParameters parameters;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            if (aEADParameters.getMacSize() > 512 || aEADParameters.getMacSize() < 64 || aEADParameters.getMacSize() % 8 != 0) {
                throw new IllegalArgumentException("Invalid mac size specified");
            }
            this.f20601nonce = aEADParameters.getNonce();
            this.f20600macSize = aEADParameters.getMacSize() / 8;
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            parameters = aEADParameters.m15664getKey();
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("Invalid parameters specified");
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f20601nonce = parametersWithIV.m15801getIV();
            this.f20600macSize = this.f20598engine.getBlockSize();
            this.initialAssociatedText = null;
            parameters = parametersWithIV.getParameters();
        }
        this.f20599mac = new byte[this.f20600macSize];
        this.forEncryption = z;
        this.f20598engine.mo14946init(true, parameters);
        this.f20596counter[0] = 1;
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
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
        this.f20597data.write(b);
        return 0;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException {
        if (bArr.length < i + i2) {
            throw new DataLengthException("input buffer too short");
        }
        this.f20597data.write(bArr, i, i2);
        return 0;
    }

    public int processPacket(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws InvalidCipherTextException, IOException {
        int i4;
        if (bArr.length - i < i2) {
            throw new DataLengthException("input buffer too short");
        }
        if (bArr2.length - i3 < i2) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.associatedText.size() > 0) {
            if (this.forEncryption) {
                processAAD(this.associatedText.getBuffer(), 0, this.associatedText.size(), this.f20597data.size());
            } else {
                processAAD(this.associatedText.getBuffer(), 0, this.associatedText.size(), this.f20597data.size() - this.f20600macSize);
            }
        }
        if (!this.forEncryption) {
            if ((i2 - this.f20600macSize) % this.f20598engine.getBlockSize() != 0) {
                throw new DataLengthException("partial blocks not supported");
            }
            this.f20598engine.processBlock(this.f20601nonce, 0, this.f20602s, 0);
            int blockSize = i2 / this.f20598engine.getBlockSize();
            for (int i5 = 0; i5 < blockSize; i5++) {
                ProcessBlock(bArr, i, i2, bArr2, i3);
                i += this.f20598engine.getBlockSize();
                i3 += this.f20598engine.getBlockSize();
            }
            if (i2 > i) {
                int i6 = 0;
                while (true) {
                    byte[] bArr3 = this.f20596counter;
                    if (i6 >= bArr3.length) {
                        break;
                    }
                    byte[] bArr4 = this.f20602s;
                    bArr4[i6] = (byte) (bArr4[i6] + bArr3[i6]);
                    i6++;
                }
                this.f20598engine.processBlock(this.f20602s, 0, this.f20595buffer, 0);
                int i7 = 0;
                while (true) {
                    i4 = this.f20600macSize;
                    if (i7 >= i4) {
                        break;
                    }
                    bArr2[i3 + i7] = (byte) (this.f20595buffer[i7] ^ bArr[i + i7]);
                    i7++;
                }
                i3 += i4;
            }
            int i8 = 0;
            while (true) {
                byte[] bArr5 = this.f20596counter;
                if (i8 >= bArr5.length) {
                    break;
                }
                byte[] bArr6 = this.f20602s;
                bArr6[i8] = (byte) (bArr6[i8] + bArr5[i8]);
                i8++;
            }
            this.f20598engine.processBlock(this.f20602s, 0, this.f20595buffer, 0);
            int i9 = this.f20600macSize;
            System.arraycopy(bArr2, i3 - i9, this.f20595buffer, 0, i9);
            CalculateMac(bArr2, 0, i3 - this.f20600macSize);
            System.arraycopy(this.macBlock, 0, this.f20599mac, 0, this.f20600macSize);
            int i10 = this.f20600macSize;
            byte[] bArr7 = new byte[i10];
            System.arraycopy(this.f20595buffer, 0, bArr7, 0, i10);
            if (!C6238Arrays.constantTimeAreEqual(this.f20599mac, bArr7)) {
                throw new InvalidCipherTextException("mac check failed");
            }
            mo15228reset();
            return i2 - this.f20600macSize;
        }
        if (i2 % this.f20598engine.getBlockSize() != 0) {
            throw new DataLengthException("partial blocks not supported");
        }
        CalculateMac(bArr, i, i2);
        this.f20598engine.processBlock(this.f20601nonce, 0, this.f20602s, 0);
        int blockSize2 = i2;
        while (blockSize2 > 0) {
            ProcessBlock(bArr, i, i2, bArr2, i3);
            blockSize2 -= this.f20598engine.getBlockSize();
            i += this.f20598engine.getBlockSize();
            i3 += this.f20598engine.getBlockSize();
        }
        int i11 = 0;
        while (true) {
            byte[] bArr8 = this.f20596counter;
            if (i11 >= bArr8.length) {
                break;
            }
            byte[] bArr9 = this.f20602s;
            bArr9[i11] = (byte) (bArr9[i11] + bArr8[i11]);
            i11++;
        }
        this.f20598engine.processBlock(this.f20602s, 0, this.f20595buffer, 0);
        int i12 = 0;
        while (true) {
            int i13 = this.f20600macSize;
            if (i12 >= i13) {
                System.arraycopy(this.macBlock, 0, this.f20599mac, 0, i13);
                mo15228reset();
                return i2 + this.f20600macSize;
            }
            bArr2[i3 + i12] = (byte) (this.f20595buffer[i12] ^ this.macBlock[i12]);
            i12++;
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: reset */
    public void mo15228reset() throws IOException {
        C6238Arrays.m18249fill(this.f20593G1, (byte) 0);
        C6238Arrays.m18249fill(this.f20595buffer, (byte) 0);
        C6238Arrays.m18249fill(this.f20596counter, (byte) 0);
        C6238Arrays.m18249fill(this.macBlock, (byte) 0);
        this.f20596counter[0] = 1;
        this.f20597data.reset();
        this.associatedText.reset();
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }

    public KCCMBlockCipher(BlockCipher blockCipher, int i) {
        this.associatedText = new ExposedByteArrayOutputStream();
        this.f20597data = new ExposedByteArrayOutputStream();
        this.f20594Nb_ = 4;
        this.f20598engine = blockCipher;
        this.f20600macSize = blockCipher.getBlockSize();
        this.f20601nonce = new byte[blockCipher.getBlockSize()];
        this.initialAssociatedText = new byte[blockCipher.getBlockSize()];
        this.f20599mac = new byte[blockCipher.getBlockSize()];
        this.macBlock = new byte[blockCipher.getBlockSize()];
        this.f20593G1 = new byte[blockCipher.getBlockSize()];
        this.f20595buffer = new byte[blockCipher.getBlockSize()];
        this.f20602s = new byte[blockCipher.getBlockSize()];
        this.f20596counter = new byte[blockCipher.getBlockSize()];
        m15610setNb(i);
    }
}
