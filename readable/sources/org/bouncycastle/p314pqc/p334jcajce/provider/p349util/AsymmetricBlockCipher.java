package org.bouncycastle.p314pqc.p334jcajce.provider.p349util;

import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;

/* loaded from: classes2.dex */
public abstract class AsymmetricBlockCipher extends CipherSpiExt {

    /* renamed from: buf */
    protected ByteArrayOutputStream f23875buf = new ByteArrayOutputStream();
    protected int cipherTextSize;
    protected int maxPlainTextSize;
    protected AlgorithmParameterSpec paramSpec;

    public void checkLength(int i) throws IllegalBlockSizeException {
        int size = i + this.f23875buf.size();
        int i2 = this.f23878opMode;
        if (i2 == 1) {
            if (size <= this.maxPlainTextSize) {
                return;
            }
            throw new IllegalBlockSizeException("The length of the plaintext (" + size + " bytes) is not supported by the cipher (max. " + this.maxPlainTextSize + " bytes).");
        }
        if (i2 != 2 || size == this.cipherTextSize) {
            return;
        }
        throw new IllegalBlockSizeException("Illegal ciphertext length (expected " + this.cipherTextSize + " bytes, was " + size + " bytes).");
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    /* renamed from: doFinal */
    public final int mo18023doFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, ShortBufferException {
        if (bArr2.length < getOutputSize(i2)) {
            throw new ShortBufferException("Output buffer too short.");
        }
        byte[] bArrMo18024doFinal = mo18024doFinal(bArr, i, i2);
        System.arraycopy(bArrMo18024doFinal, 0, bArr2, i3, bArrMo18024doFinal.length);
        return bArrMo18024doFinal.length;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    public final int getBlockSize() {
        return this.f23878opMode == 1 ? this.maxPlainTextSize : this.cipherTextSize;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    /* renamed from: getIV */
    public final byte[] mo18025getIV() {
        return null;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    public final int getOutputSize(int i) {
        if (i + this.f23875buf.size() > getBlockSize()) {
            return 0;
        }
        return this.f23878opMode == 1 ? this.cipherTextSize : this.maxPlainTextSize;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    public final AlgorithmParameterSpec getParameters() {
        return this.paramSpec;
    }

    public abstract void initCipherDecrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec);

    public abstract void initCipherEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom);

    public final void initDecrypt(Key key) {
        try {
            initDecrypt(key, null);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final void initEncrypt(Key key) {
        try {
            initEncrypt(key, null, CryptoServicesRegistrar.getSecureRandom());
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public abstract byte[] messageDecrypt(byte[] bArr);

    public abstract byte[] messageEncrypt(byte[] bArr);

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    /* renamed from: setMode */
    public final void mo18026setMode(String str) {
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    public final void setPadding(String str) {
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    /* renamed from: update */
    public final int mo18027update(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        mo18028update(bArr, i, i2);
        return 0;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    /* renamed from: doFinal */
    public final byte[] mo18024doFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException {
        checkLength(i2);
        mo18028update(bArr, i, i2);
        byte[] byteArray = this.f23875buf.toByteArray();
        this.f23875buf.reset();
        int i3 = this.f23878opMode;
        if (i3 == 1) {
            return messageEncrypt(byteArray);
        }
        if (i3 != 2) {
            return null;
        }
        return messageDecrypt(byteArray);
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    public final void initDecrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) {
        this.f23878opMode = 2;
        initCipherDecrypt(key, algorithmParameterSpec);
    }

    public final void initEncrypt(Key key, SecureRandom secureRandom) {
        try {
            initEncrypt(key, null, secureRandom);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    /* renamed from: update */
    public final byte[] mo18028update(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            this.f23875buf.write(bArr, i, i2);
        }
        return new byte[0];
    }

    public final void initEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) {
        initEncrypt(key, algorithmParameterSpec, CryptoServicesRegistrar.getSecureRandom());
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    public final void initEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        this.f23878opMode = 1;
        initCipherEncrypt(key, algorithmParameterSpec, secureRandom);
    }
}
