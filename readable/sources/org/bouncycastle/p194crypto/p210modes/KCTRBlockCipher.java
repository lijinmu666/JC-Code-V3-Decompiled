package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.StreamBlockCipher;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class KCTRBlockCipher extends StreamBlockCipher {
    private int byteCount;

    /* renamed from: engine */
    private BlockCipher f20603engine;
    private boolean initialised;

    /* renamed from: iv */
    private byte[] f20604iv;

    /* renamed from: ofbOutV */
    private byte[] f20605ofbOutV;

    /* renamed from: ofbV */
    private byte[] f20606ofbV;

    public KCTRBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.f20603engine = blockCipher;
        this.f20604iv = new byte[blockCipher.getBlockSize()];
        this.f20606ofbV = new byte[blockCipher.getBlockSize()];
        this.f20605ofbOutV = new byte[blockCipher.getBlockSize()];
    }

    private void checkCounter() {
    }

    private void incrementCounterAt(int i) {
        while (true) {
            byte[] bArr = this.f20606ofbV;
            if (i >= bArr.length) {
                return;
            }
            int i2 = i + 1;
            byte b = (byte) (bArr[i] + 1);
            bArr[i] = b;
            if (b != 0) {
                return;
            } else {
                i = i2;
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.StreamBlockCipher
    public byte calculateByte(byte b) {
        int i = this.byteCount;
        if (i == 0) {
            incrementCounterAt(0);
            checkCounter();
            this.f20603engine.processBlock(this.f20606ofbV, 0, this.f20605ofbOutV, 0);
            byte[] bArr = this.f20605ofbOutV;
            int i2 = this.byteCount;
            this.byteCount = i2 + 1;
            return (byte) (bArr[i2] ^ b);
        }
        byte[] bArr2 = this.f20605ofbOutV;
        int i3 = i + 1;
        this.byteCount = i3;
        byte b2 = (byte) (b ^ bArr2[i]);
        if (i3 == this.f20606ofbV.length) {
            this.byteCount = 0;
        }
        return b2;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return this.f20603engine.getAlgorithmName() + "/KCTR";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return this.f20603engine.getBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        this.initialised = true;
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("invalid parameter passed");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
        byte[] bArr = this.f20604iv;
        int length = bArr.length - bArrM15801getIV.length;
        C6238Arrays.m18249fill(bArr, (byte) 0);
        System.arraycopy(bArrM15801getIV, 0, this.f20604iv, length, bArrM15801getIV.length);
        CipherParameters parameters = parametersWithIV.getParameters();
        if (parameters != null) {
            this.f20603engine.mo14946init(true, parameters);
        }
        mo14947reset();
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (bArr.length - i < getBlockSize()) {
            throw new DataLengthException("input buffer too short");
        }
        if (bArr2.length - i2 < getBlockSize()) {
            throw new OutputLengthException("output buffer too short");
        }
        processBytes(bArr, i, getBlockSize(), bArr2, i2);
        return getBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
        if (this.initialised) {
            this.f20603engine.processBlock(this.f20604iv, 0, this.f20606ofbV, 0);
        }
        this.f20603engine.mo14947reset();
        this.byteCount = 0;
    }
}
