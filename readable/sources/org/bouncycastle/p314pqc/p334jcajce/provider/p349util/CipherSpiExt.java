package org.bouncycastle.p314pqc.p334jcajce.provider.p349util;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.CipherSpi;

/* loaded from: classes2.dex */
public abstract class CipherSpiExt extends CipherSpi {
    public static final int DECRYPT_MODE = 2;
    public static final int ENCRYPT_MODE = 1;

    /* renamed from: opMode */
    protected int f23878opMode;

    /* renamed from: doFinal */
    public abstract int mo18023doFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    /* renamed from: doFinal */
    public final byte[] m18029doFinal() {
        return mo18024doFinal(null, 0, 0);
    }

    /* renamed from: doFinal */
    public abstract byte[] mo18024doFinal(byte[] bArr, int i, int i2);

    @Override // javax.crypto.CipherSpi
    public final int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        return mo18023doFinal(bArr, i, i2, bArr2, i3);
    }

    @Override // javax.crypto.CipherSpi
    public final int engineGetBlockSize() {
        return getBlockSize();
    }

    @Override // javax.crypto.CipherSpi
    public final byte[] engineGetIV() {
        return mo18025getIV();
    }

    @Override // javax.crypto.CipherSpi
    public final int engineGetKeySize(Key key) throws InvalidKeyException {
        if (key != null) {
            return getKeySize(key);
        }
        throw new InvalidKeyException("Unsupported key.");
    }

    @Override // javax.crypto.CipherSpi
    public final int engineGetOutputSize(int i) {
        return getOutputSize(i);
    }

    @Override // javax.crypto.CipherSpi
    public final AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public final void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException {
        if (algorithmParameters == null) {
            engineInit(i, key, secureRandom);
        } else {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        }
    }

    @Override // javax.crypto.CipherSpi
    public final void engineSetMode(String str) {
        mo18026setMode(str);
    }

    @Override // javax.crypto.CipherSpi
    public final void engineSetPadding(String str) {
        setPadding(str);
    }

    @Override // javax.crypto.CipherSpi
    public final int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        return mo18027update(bArr, i, i2, bArr2, i3);
    }

    public abstract int getBlockSize();

    /* renamed from: getIV */
    public abstract byte[] mo18025getIV();

    public abstract int getKeySize(Key key);

    /* renamed from: getName */
    public abstract String m18031getName();

    public abstract int getOutputSize(int i);

    public abstract AlgorithmParameterSpec getParameters();

    public abstract void initDecrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec);

    public abstract void initEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom);

    /* renamed from: setMode */
    public abstract void mo18026setMode(String str);

    public abstract void setPadding(String str);

    /* renamed from: update */
    public abstract int mo18027update(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    /* renamed from: update */
    public final byte[] m18032update(byte[] bArr) {
        return mo18028update(bArr, 0, bArr.length);
    }

    /* renamed from: update */
    public abstract byte[] mo18028update(byte[] bArr, int i, int i2);

    /* renamed from: doFinal */
    public final byte[] m18030doFinal(byte[] bArr) {
        return mo18024doFinal(bArr, 0, bArr.length);
    }

    @Override // javax.crypto.CipherSpi
    public final byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        return mo18024doFinal(bArr, i, i2);
    }

    @Override // javax.crypto.CipherSpi
    public final void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidParameterException(e.getMessage());
        }
    }

    @Override // javax.crypto.CipherSpi
    public final byte[] engineUpdate(byte[] bArr, int i, int i2) {
        return mo18028update(bArr, i, i2);
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException {
        if (key == null) {
            throw new InvalidKeyException();
        }
        this.f23878opMode = i;
        if (i == 1) {
            initEncrypt(key, algorithmParameterSpec, secureRandom);
        } else if (i == 2) {
            initDecrypt(key, algorithmParameterSpec);
        }
    }
}
