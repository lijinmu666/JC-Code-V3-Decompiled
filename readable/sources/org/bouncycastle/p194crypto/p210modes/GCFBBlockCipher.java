package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.StreamBlockCipher;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p213params.ParametersWithSBox;

/* loaded from: classes2.dex */
public class GCFBBlockCipher extends StreamBlockCipher {

    /* renamed from: C */
    private static final byte[] f20563C = {105, 0, 114, 34, 100, -55, 4, 35, -115, 58, -37, -106, 70, -23, 42, -60, 24, -2, -84, -108, 0, -19, 7, 18, -64, -122, -36, -62, -17, 76, -87, 43};
    private final CFBBlockCipher cfbEngine;

    /* renamed from: counter */
    private long f20564counter;
    private boolean forEncryption;
    private ParametersWithIV initParams;

    /* renamed from: key */
    private KeyParameter f20565key;

    public GCFBBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.f20564counter = 0L;
        this.cfbEngine = new CFBBlockCipher(blockCipher, blockCipher.getBlockSize() * 8);
    }

    @Override // org.bouncycastle.p194crypto.StreamBlockCipher
    public byte calculateByte(byte b) {
        long j = this.f20564counter;
        if (j > 0 && (j & 1023) == 0) {
            BlockCipher underlyingCipher = this.cfbEngine.getUnderlyingCipher();
            underlyingCipher.mo14946init(false, this.f20565key);
            byte[] bArr = new byte[32];
            int blockSize = underlyingCipher.getBlockSize();
            for (int i = 0; i < 32; i += blockSize) {
                underlyingCipher.processBlock(f20563C, i, bArr, i);
            }
            KeyParameter keyParameter = new KeyParameter(bArr);
            this.f20565key = keyParameter;
            underlyingCipher.mo14946init(true, keyParameter);
            byte[] currentIV = this.cfbEngine.getCurrentIV();
            underlyingCipher.processBlock(currentIV, 0, currentIV, 0);
            this.cfbEngine.mo14946init(this.forEncryption, new ParametersWithIV(this.f20565key, currentIV));
        }
        this.f20564counter++;
        return this.cfbEngine.calculateByte(b);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        String algorithmName = this.cfbEngine.getAlgorithmName();
        return algorithmName.substring(0, algorithmName.indexOf(47)) + "/G" + algorithmName.substring(algorithmName.indexOf(47) + 1);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return this.cfbEngine.getBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        byte[] bArr;
        ParametersWithIV parametersWithIV;
        ParametersWithIV parametersWithIV2;
        this.f20564counter = 0L;
        this.cfbEngine.mo14946init(z, cipherParameters);
        this.forEncryption = z;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV3 = (ParametersWithIV) cipherParameters;
            CipherParameters parameters = parametersWithIV3.getParameters();
            byte[] bArrM15801getIV = parametersWithIV3.m15801getIV();
            cipherParameters = parameters;
            bArr = bArrM15801getIV;
        } else {
            bArr = null;
        }
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        if (cipherParameters instanceof ParametersWithSBox) {
            cipherParameters = ((ParametersWithSBox) cipherParameters).getParameters();
        }
        KeyParameter keyParameter = (KeyParameter) cipherParameters;
        this.f20565key = keyParameter;
        if (keyParameter == null && (parametersWithIV2 = this.initParams) != null) {
            this.f20565key = (KeyParameter) parametersWithIV2.getParameters();
        }
        this.initParams = new ParametersWithIV(this.f20565key, (bArr != null || (parametersWithIV = this.initParams) == null) ? this.cfbEngine.getCurrentIV() : parametersWithIV.m15801getIV());
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        processBytes(bArr, i, this.cfbEngine.getBlockSize(), bArr2, i2);
        return this.cfbEngine.getBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
        this.f20564counter = 0L;
        ParametersWithIV parametersWithIV = this.initParams;
        if (parametersWithIV == null) {
            this.cfbEngine.mo14947reset();
        } else {
            this.f20565key = (KeyParameter) parametersWithIV.getParameters();
            this.cfbEngine.mo14946init(this.forEncryption, this.initParams);
        }
    }
}
