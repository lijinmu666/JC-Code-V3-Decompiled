package org.bouncycastle.p194crypto.p202fpe;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p213params.FPEParameters;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public abstract class FPEEngine {
    protected final BlockCipher baseCipher;
    protected boolean forEncryption;
    protected FPEParameters fpeParameters;

    public FPEEngine(BlockCipher blockCipher) {
        this.baseCipher = blockCipher;
    }

    public static byte[] toByteArray(short[] sArr) {
        byte[] bArr = new byte[sArr.length * 2];
        for (int i = 0; i != sArr.length; i++) {
            AbstractC6245Pack.shortToBigEndian(sArr[i], bArr, i * 2);
        }
        return bArr;
    }

    public static short[] toShortArray(byte[] bArr) {
        if ((bArr.length & 1) != 0) {
            throw new IllegalArgumentException("data must be an even number of bytes for a wide radix");
        }
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i = 0; i != length; i++) {
            sArr[i] = AbstractC6245Pack.bigEndianToShort(bArr, i * 2);
        }
        return sArr;
    }

    public abstract int decryptBlock(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public abstract int encryptBlock(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public abstract String getAlgorithmName();

    /* renamed from: init */
    public abstract void mo15468init(boolean z, CipherParameters cipherParameters);

    public int processBlock(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (this.fpeParameters == null) {
            throw new IllegalStateException("FPE engine not initialized");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("input length cannot be negative");
        }
        if (bArr == null || bArr2 == null) {
            throw new NullPointerException("buffer value is null");
        }
        if (bArr.length < i + i2) {
            throw new DataLengthException("input buffer too short");
        }
        if (bArr2.length >= i3 + i2) {
            return this.forEncryption ? encryptBlock(bArr, i, i2, bArr2, i3) : decryptBlock(bArr, i, i2, bArr2, i3);
        }
        throw new OutputLengthException("output buffer too short");
    }
}
