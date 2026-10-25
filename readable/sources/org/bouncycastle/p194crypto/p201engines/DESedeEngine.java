package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.KeyParameter;

/* loaded from: classes2.dex */
public class DESedeEngine extends C5336DESBase implements BlockCipher {
    protected static final int BLOCK_SIZE = 8;
    private boolean forEncryption;
    private int[] workingKey1 = null;
    private int[] workingKey2 = null;
    private int[] workingKey3 = null;

    public DESedeEngine() {
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), bitsOfSecurity()));
    }

    private int bitsOfSecurity() {
        int[] iArr = this.workingKey1;
        return (iArr == null || iArr != this.workingKey3) ? 112 : 80;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return "DESede";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("invalid parameter passed to DESede init - " + cipherParameters.getClass().getName());
        }
        byte[] bArrM15773getKey = ((KeyParameter) cipherParameters).m15773getKey();
        if (bArrM15773getKey.length != 24 && bArrM15773getKey.length != 16) {
            throw new IllegalArgumentException("key size must be 16 or 24 bytes.");
        }
        this.forEncryption = z;
        byte[] bArr = new byte[8];
        System.arraycopy(bArrM15773getKey, 0, bArr, 0, 8);
        this.workingKey1 = generateWorkingKey(z, bArr);
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArrM15773getKey, 8, bArr2, 0, 8);
        this.workingKey2 = generateWorkingKey(!z, bArr2);
        if (bArrM15773getKey.length == 24) {
            byte[] bArr3 = new byte[8];
            System.arraycopy(bArrM15773getKey, 16, bArr3, 0, 8);
            this.workingKey3 = generateWorkingKey(z, bArr3);
        } else {
            this.workingKey3 = this.workingKey1;
        }
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), bitsOfSecurity(), cipherParameters, C5342Utils.getPurpose(this.forEncryption)));
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = this.workingKey1;
        if (iArr == null) {
            throw new IllegalStateException("DESede engine not initialised");
        }
        if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i2 + 8 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        byte[] bArr3 = new byte[8];
        if (this.forEncryption) {
            mo15295desFunc(iArr, bArr, i, bArr3, 0);
            mo15295desFunc(this.workingKey2, bArr3, 0, bArr3, 0);
            mo15295desFunc(this.workingKey3, bArr3, 0, bArr2, i2);
        } else {
            mo15295desFunc(this.workingKey3, bArr, i, bArr3, 0);
            mo15295desFunc(this.workingKey2, bArr3, 0, bArr3, 0);
            mo15295desFunc(this.workingKey1, bArr3, 0, bArr2, i2);
        }
        return 8;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
    }
}
