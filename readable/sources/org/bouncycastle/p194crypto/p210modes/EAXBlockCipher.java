package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p209macs.C5358CMac;
import org.bouncycastle.p194crypto.p213params.AEADParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class EAXBlockCipher implements AEADBlockCipher {

    /* renamed from: cTAG */
    private static final byte f20535cTAG = 2;

    /* renamed from: hTAG */
    private static final byte f20536hTAG = 1;

    /* renamed from: nTAG */
    private static final byte f20537nTAG = 0;
    private byte[] associatedTextMac;
    private int blockSize;
    private byte[] bufBlock;

    /* renamed from: bufOff */
    private int f20538bufOff;

    /* renamed from: cipher */
    private CTRModeCipher f20539cipher;
    private boolean cipherInitialized;
    private boolean forEncryption;
    private byte[] initialAssociatedText;

    /* renamed from: mac */
    private InterfaceC5278Mac f20540mac;
    private byte[] macBlock;

    /* renamed from: macSize */
    private int f20541macSize;
    private byte[] nonceMac;

    public EAXBlockCipher(BlockCipher blockCipher) {
        this.blockSize = blockCipher.getBlockSize();
        C5358CMac c5358CMac = new C5358CMac(blockCipher);
        this.f20540mac = c5358CMac;
        this.macBlock = new byte[this.blockSize];
        this.associatedTextMac = new byte[c5358CMac.getMacSize()];
        this.nonceMac = new byte[this.f20540mac.getMacSize()];
        this.f20539cipher = SICBlockCipher.newInstance(blockCipher);
    }

    private void calculateMac() {
        byte[] bArr = new byte[this.blockSize];
        int i = 0;
        this.f20540mac.mo14975doFinal(bArr, 0);
        while (true) {
            byte[] bArr2 = this.macBlock;
            if (i >= bArr2.length) {
                return;
            }
            bArr2[i] = (byte) ((this.nonceMac[i] ^ this.associatedTextMac[i]) ^ bArr[i]);
            i++;
        }
    }

    private void initCipher() {
        if (this.cipherInitialized) {
            return;
        }
        this.cipherInitialized = true;
        this.f20540mac.mo14975doFinal(this.associatedTextMac, 0);
        int i = this.blockSize;
        byte[] bArr = new byte[i];
        bArr[i - 1] = 2;
        this.f20540mac.mo14979update(bArr, 0, i);
    }

    /* renamed from: process */
    private int m15597process(byte b, byte[] bArr, int i) {
        int iProcessBlock;
        byte[] bArr2 = this.bufBlock;
        int i2 = this.f20538bufOff;
        int i3 = i2 + 1;
        this.f20538bufOff = i3;
        bArr2[i2] = b;
        if (i3 != bArr2.length) {
            return 0;
        }
        int length = bArr.length;
        int i4 = this.blockSize;
        if (length < i + i4) {
            throw new OutputLengthException("Output buffer is too short");
        }
        if (this.forEncryption) {
            iProcessBlock = this.f20539cipher.processBlock(bArr2, 0, bArr, i);
            this.f20540mac.mo14979update(bArr, i, this.blockSize);
        } else {
            this.f20540mac.mo14979update(bArr2, 0, i4);
            iProcessBlock = this.f20539cipher.processBlock(this.bufBlock, 0, bArr, i);
        }
        this.f20538bufOff = 0;
        if (!this.forEncryption) {
            byte[] bArr3 = this.bufBlock;
            System.arraycopy(bArr3, this.blockSize, bArr3, 0, this.f20541macSize);
            this.f20538bufOff = this.f20541macSize;
        }
        return iProcessBlock;
    }

    private boolean verifyMac(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f20541macSize; i3++) {
            i2 |= this.macBlock[i3] ^ bArr[i + i3];
        }
        return i2 == 0;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: doFinal */
    public int mo15224doFinal(byte[] bArr, int i) throws InvalidCipherTextException {
        initCipher();
        int i2 = this.f20538bufOff;
        byte[] bArr2 = this.bufBlock;
        byte[] bArr3 = new byte[bArr2.length];
        this.f20538bufOff = 0;
        if (this.forEncryption) {
            int i3 = i + i2;
            if (bArr.length < this.f20541macSize + i3) {
                throw new OutputLengthException("Output buffer too short");
            }
            this.f20539cipher.processBlock(bArr2, 0, bArr3, 0);
            System.arraycopy(bArr3, 0, bArr, i, i2);
            this.f20540mac.mo14979update(bArr3, 0, i2);
            calculateMac();
            System.arraycopy(this.macBlock, 0, bArr, i3, this.f20541macSize);
            m15598reset(false);
            return i2 + this.f20541macSize;
        }
        int i4 = this.f20541macSize;
        if (i2 < i4) {
            throw new InvalidCipherTextException("data too short");
        }
        if (bArr.length < (i + i2) - i4) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (i2 > i4) {
            this.f20540mac.mo14979update(bArr2, 0, i2 - i4);
            this.f20539cipher.processBlock(this.bufBlock, 0, bArr3, 0);
            System.arraycopy(bArr3, 0, bArr, i, i2 - this.f20541macSize);
        }
        calculateMac();
        if (!verifyMac(this.bufBlock, i2 - this.f20541macSize)) {
            throw new InvalidCipherTextException("mac check in EAX failed");
        }
        m15598reset(false);
        return i2 - this.f20541macSize;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public String getAlgorithmName() {
        return this.f20539cipher.getUnderlyingCipher().getAlgorithmName() + "/EAX";
    }

    public int getBlockSize() {
        return this.f20539cipher.getBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: getMac */
    public byte[] mo15225getMac() {
        int i = this.f20541macSize;
        byte[] bArr = new byte[i];
        System.arraycopy(this.macBlock, 0, bArr, 0, i);
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getOutputSize(int i) {
        int i2 = i + this.f20538bufOff;
        boolean z = this.forEncryption;
        int i3 = this.f20541macSize;
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
        return this.f20539cipher.getUnderlyingCipher();
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getUpdateOutputSize(int i) {
        int i2 = i + this.f20538bufOff;
        if (!this.forEncryption) {
            int i3 = this.f20541macSize;
            if (i2 < i3) {
                return 0;
            }
            i2 -= i3;
        }
        return i2 - (i2 % this.blockSize);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: init */
    public void mo15226init(boolean z, CipherParameters cipherParameters) {
        byte[] bArrM15801getIV;
        CipherParameters parameters;
        this.forEncryption = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            bArrM15801getIV = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            this.f20541macSize = aEADParameters.getMacSize() / 8;
            parameters = aEADParameters.m15664getKey();
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("invalid parameters passed to EAX");
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArrM15801getIV = parametersWithIV.m15801getIV();
            this.initialAssociatedText = null;
            this.f20541macSize = this.f20540mac.getMacSize() / 2;
            parameters = parametersWithIV.getParameters();
        }
        this.bufBlock = new byte[z ? this.blockSize : this.blockSize + this.f20541macSize];
        byte[] bArr = new byte[this.blockSize];
        this.f20540mac.mo14976init(parameters);
        int i = this.blockSize;
        bArr[i - 1] = 0;
        this.f20540mac.mo14979update(bArr, 0, i);
        this.f20540mac.mo14979update(bArrM15801getIV, 0, bArrM15801getIV.length);
        this.f20540mac.mo14975doFinal(this.nonceMac, 0);
        this.f20539cipher.mo14946init(true, new ParametersWithIV(parameters, this.nonceMac));
        mo15228reset();
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public void processAADByte(byte b) {
        if (this.cipherInitialized) {
            throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
        }
        this.f20540mac.mo14978update(b);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public void processAADBytes(byte[] bArr, int i, int i2) {
        if (this.cipherInitialized) {
            throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
        }
        this.f20540mac.mo14979update(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int processByte(byte b, byte[] bArr, int i) {
        initCipher();
        return m15597process(b, bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        initCipher();
        if (bArr.length < i + i2) {
            throw new DataLengthException("Input buffer too short");
        }
        if (bArr == bArr2 && C6238Arrays.segmentsOverlap(i, i2, i3, getUpdateOutputSize(i2))) {
            bArr = new byte[i2];
            System.arraycopy(bArr2, i, bArr, 0, i2);
            i = 0;
        }
        int iM15597process = 0;
        for (int i4 = 0; i4 != i2; i4++) {
            iM15597process += m15597process(bArr[i + i4], bArr2, i3 + iM15597process);
        }
        return iM15597process;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: reset */
    public void mo15228reset() {
        m15598reset(true);
    }

    /* renamed from: reset */
    private void m15598reset(boolean z) {
        this.f20539cipher.mo14947reset();
        this.f20540mac.mo14977reset();
        this.f20538bufOff = 0;
        C6238Arrays.m18249fill(this.bufBlock, (byte) 0);
        if (z) {
            C6238Arrays.m18249fill(this.macBlock, (byte) 0);
        }
        int i = this.blockSize;
        byte[] bArr = new byte[i];
        bArr[i - 1] = 1;
        this.f20540mac.mo14979update(bArr, 0, i);
        this.cipherInitialized = false;
        byte[] bArr2 = this.initialAssociatedText;
        if (bArr2 != null) {
            processAADBytes(bArr2, 0, bArr2.length);
        }
    }
}
