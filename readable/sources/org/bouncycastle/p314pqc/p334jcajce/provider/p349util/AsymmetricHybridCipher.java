package org.bouncycastle.p314pqc.p334jcajce.provider.p349util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.ShortBufferException;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;

/* loaded from: classes2.dex */
public abstract class AsymmetricHybridCipher extends CipherSpiExt {
    protected AlgorithmParameterSpec paramSpec;

    public abstract int decryptOutputSize(int i);

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    /* renamed from: doFinal */
    public final int mo18023doFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        if (bArr2.length < getOutputSize(i2)) {
            throw new ShortBufferException("Output buffer too short.");
        }
        byte[] bArrMo18024doFinal = mo18024doFinal(bArr, i, i2);
        System.arraycopy(bArrMo18024doFinal, 0, bArr2, i3, bArrMo18024doFinal.length);
        return bArrMo18024doFinal.length;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    /* renamed from: doFinal */
    public abstract byte[] mo18024doFinal(byte[] bArr, int i, int i2);

    public abstract int encryptOutputSize(int i);

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    public final int getBlockSize() {
        return 0;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    /* renamed from: getIV */
    public final byte[] mo18025getIV() {
        return null;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    public final int getOutputSize(int i) {
        return this.f23878opMode == 1 ? encryptOutputSize(i) : decryptOutputSize(i);
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

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    /* renamed from: setMode */
    public final void mo18026setMode(String str) {
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    public final void setPadding(String str) {
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    /* renamed from: update */
    public final int mo18027update(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        if (bArr2.length < getOutputSize(i2)) {
            throw new ShortBufferException("output");
        }
        byte[] bArrMo18028update = mo18028update(bArr, i, i2);
        System.arraycopy(bArrMo18028update, 0, bArr2, i3, bArrMo18028update.length);
        return bArrMo18028update.length;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    /* renamed from: update */
    public abstract byte[] mo18028update(byte[] bArr, int i, int i2);

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

    public final void initEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) {
        initEncrypt(key, algorithmParameterSpec, CryptoServicesRegistrar.getSecureRandom());
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.CipherSpiExt
    public final void initEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        this.f23878opMode = 1;
        initCipherEncrypt(key, algorithmParameterSpec, secureRandom);
    }
}
