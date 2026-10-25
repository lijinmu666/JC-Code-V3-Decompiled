package org.bouncycastle.p194crypto.p210modes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p210modes.p212kgcm.KGCMMultiplier;
import org.bouncycastle.p194crypto.p210modes.p212kgcm.Tables16kKGCMMultiplier_512;
import org.bouncycastle.p194crypto.p210modes.p212kgcm.Tables4kKGCMMultiplier_128;
import org.bouncycastle.p194crypto.p210modes.p212kgcm.Tables8kKGCMMultiplier_256;
import org.bouncycastle.p194crypto.p213params.AEADParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class KGCMBlockCipher implements AEADBlockCipher {
    private static final int MIN_MAC_BITS = 64;

    /* renamed from: b */
    private long[] f20607b;
    private final int blockSize;
    private BufferedBlockCipher ctrEngine;

    /* renamed from: engine */
    private BlockCipher f20609engine;
    private boolean forEncryption;
    private byte[] initialAssociatedText;

    /* renamed from: iv */
    private byte[] f20610iv;
    private byte[] macBlock;
    private KGCMMultiplier multiplier;
    private ExposedByteArrayOutputStream associatedText = new ExposedByteArrayOutputStream();

    /* renamed from: data */
    private ExposedByteArrayOutputStream f20608data = new ExposedByteArrayOutputStream();

    /* renamed from: macSize */
    private int f20611macSize = -1;

    public static class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public byte[] getBuffer() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public KGCMBlockCipher(BlockCipher blockCipher) {
        this.f20609engine = blockCipher;
        this.ctrEngine = new BufferedBlockCipher(new KCTRBlockCipher(blockCipher));
        int blockSize = this.f20609engine.getBlockSize();
        this.blockSize = blockSize;
        this.initialAssociatedText = new byte[blockSize];
        this.f20610iv = new byte[blockSize];
        this.multiplier = createDefaultMultiplier(blockSize);
        this.f20607b = new long[blockSize >>> 3];
        this.macBlock = null;
    }

    private void calculateMac(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i2;
        while (i < i4) {
            xorWithInput(this.f20607b, bArr, i);
            this.multiplier.multiplyH(this.f20607b);
            i += this.blockSize;
        }
        long j = (i3 & BodyPartID.bodyIdMax) << 3;
        long j2 = (BodyPartID.bodyIdMax & i2) << 3;
        long[] jArr = this.f20607b;
        jArr[0] = j ^ jArr[0];
        int i5 = this.blockSize >>> 4;
        jArr[i5] = jArr[i5] ^ j2;
        byte[] bArrLongToLittleEndian = AbstractC6245Pack.longToLittleEndian(jArr);
        this.macBlock = bArrLongToLittleEndian;
        this.f20609engine.processBlock(bArrLongToLittleEndian, 0, bArrLongToLittleEndian, 0);
    }

    private static KGCMMultiplier createDefaultMultiplier(int i) {
        if (i == 16) {
            return new Tables4kKGCMMultiplier_128();
        }
        if (i == 32) {
            return new Tables8kKGCMMultiplier_256();
        }
        if (i == 64) {
            return new Tables16kKGCMMultiplier_512();
        }
        throw new IllegalArgumentException("Only 128, 256, and 512 -bit block sizes supported");
    }

    private void processAAD(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            xorWithInput(this.f20607b, bArr, i);
            this.multiplier.multiplyH(this.f20607b);
            i += this.blockSize;
        }
    }

    private static void xorWithInput(long[] jArr, byte[] bArr, int i) {
        for (int i2 = 0; i2 < jArr.length; i2++) {
            jArr[i2] = jArr[i2] ^ AbstractC6245Pack.littleEndianToLong(bArr, i);
            i += 8;
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: doFinal */
    public int mo15224doFinal(byte[] bArr, int i) throws InvalidCipherTextException, IOException {
        int iMo14951doFinal;
        int size = this.f20608data.size();
        if (!this.forEncryption && size < this.f20611macSize) {
            throw new InvalidCipherTextException("data too short");
        }
        byte[] bArr2 = new byte[this.blockSize];
        this.f20609engine.processBlock(bArr2, 0, bArr2, 0);
        long[] jArr = new long[this.blockSize >>> 3];
        AbstractC6245Pack.littleEndianToLong(bArr2, 0, jArr);
        this.multiplier.mo15641init(jArr);
        C6238Arrays.m18249fill(bArr2, (byte) 0);
        C6238Arrays.m18256fill(jArr, 0L);
        int size2 = this.associatedText.size();
        if (size2 > 0) {
            processAAD(this.associatedText.getBuffer(), 0, size2);
        }
        if (!this.forEncryption) {
            int i2 = size - this.f20611macSize;
            if (bArr.length - i < i2) {
                throw new OutputLengthException("Output buffer too short");
            }
            calculateMac(this.f20608data.getBuffer(), 0, i2, size2);
            int iProcessBytes = this.ctrEngine.processBytes(this.f20608data.getBuffer(), 0, i2, bArr, i);
            iMo14951doFinal = iProcessBytes + this.ctrEngine.mo14951doFinal(bArr, i + iProcessBytes);
        } else {
            if ((bArr.length - i) - this.f20611macSize < size) {
                throw new OutputLengthException("Output buffer too short");
            }
            int iProcessBytes2 = this.ctrEngine.processBytes(this.f20608data.getBuffer(), 0, size, bArr, i);
            iMo14951doFinal = iProcessBytes2 + this.ctrEngine.mo14951doFinal(bArr, i + iProcessBytes2);
            calculateMac(bArr, i, size, size2);
        }
        byte[] bArr3 = this.macBlock;
        if (bArr3 == null) {
            throw new IllegalStateException("mac is not calculated");
        }
        if (this.forEncryption) {
            System.arraycopy(bArr3, 0, bArr, i + iMo14951doFinal, this.f20611macSize);
            mo15228reset();
            return iMo14951doFinal + this.f20611macSize;
        }
        byte[] bArr4 = new byte[this.f20611macSize];
        byte[] buffer = this.f20608data.getBuffer();
        int i3 = this.f20611macSize;
        System.arraycopy(buffer, size - i3, bArr4, 0, i3);
        int i4 = this.f20611macSize;
        byte[] bArr5 = new byte[i4];
        System.arraycopy(this.macBlock, 0, bArr5, 0, i4);
        if (!C6238Arrays.constantTimeAreEqual(bArr4, bArr5)) {
            throw new InvalidCipherTextException("mac verification failed");
        }
        mo15228reset();
        return iMo14951doFinal;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public String getAlgorithmName() {
        return this.f20609engine.getAlgorithmName() + "/KGCM";
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: getMac */
    public byte[] mo15225getMac() {
        int i = this.f20611macSize;
        byte[] bArr = new byte[i];
        System.arraycopy(this.macBlock, 0, bArr, 0, i);
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getOutputSize(int i) {
        int size = i + this.f20608data.size();
        boolean z = this.forEncryption;
        int i2 = this.f20611macSize;
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
        return this.f20609engine;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getUpdateOutputSize(int i) {
        return 0;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: init */
    public void mo15226init(boolean z, CipherParameters cipherParameters) throws IOException {
        KeyParameter keyParameterM15664getKey;
        this.forEncryption = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            byte[] nonce = aEADParameters.getNonce();
            byte[] bArr = this.f20610iv;
            int length = bArr.length - nonce.length;
            C6238Arrays.m18249fill(bArr, (byte) 0);
            System.arraycopy(nonce, 0, this.f20610iv, length, nonce.length);
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            int macSize = aEADParameters.getMacSize();
            if (macSize < 64 || macSize > (this.blockSize << 3) || (macSize & 7) != 0) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + macSize);
            }
            this.f20611macSize = macSize >>> 3;
            keyParameterM15664getKey = aEADParameters.m15664getKey();
            byte[] bArr2 = this.initialAssociatedText;
            if (bArr2 != null) {
                processAADBytes(bArr2, 0, bArr2.length);
            }
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("Invalid parameter passed");
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
            byte[] bArr3 = this.f20610iv;
            int length2 = bArr3.length - bArrM15801getIV.length;
            C6238Arrays.m18249fill(bArr3, (byte) 0);
            System.arraycopy(bArrM15801getIV, 0, this.f20610iv, length2, bArrM15801getIV.length);
            this.initialAssociatedText = null;
            this.f20611macSize = this.blockSize;
            keyParameterM15664getKey = (KeyParameter) parametersWithIV.getParameters();
        }
        this.macBlock = new byte[this.blockSize];
        this.ctrEngine.mo14952init(true, new ParametersWithIV(keyParameterM15664getKey, this.f20610iv));
        this.f20609engine.mo14946init(true, keyParameterM15664getKey);
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
        this.f20608data.write(b);
        return 0;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException {
        if (bArr.length < i + i2) {
            throw new DataLengthException("input buffer too short");
        }
        this.f20608data.write(bArr, i, i2);
        return 0;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: reset */
    public void mo15228reset() throws IOException {
        C6238Arrays.m18256fill(this.f20607b, 0L);
        this.f20609engine.mo14947reset();
        this.f20608data.reset();
        this.associatedText.reset();
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }
}
