package org.bouncycastle.p194crypto.p213params;

import java.io.EOFException;
import java.io.InputStream;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p285ec.p292rfc8032.AbstractC5863Ed25519;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public final class Ed25519PrivateKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 32;
    public static final int SIGNATURE_SIZE = 64;
    private Ed25519PublicKeyParameters cachedPublicKey;

    /* renamed from: data */
    private final byte[] f20742data;

    public Ed25519PrivateKeyParameters(InputStream inputStream) throws EOFException {
        super(true);
        byte[] bArr = new byte[32];
        this.f20742data = bArr;
        if (32 != C6257Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of Ed25519 private key");
        }
    }

    private static byte[] validate(byte[] bArr) {
        if (bArr.length == 32) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 32");
    }

    /* renamed from: encode */
    public void m15729encode(byte[] bArr, int i) {
        System.arraycopy(this.f20742data, 0, bArr, i, 32);
    }

    public Ed25519PublicKeyParameters generatePublicKey() {
        Ed25519PublicKeyParameters ed25519PublicKeyParameters;
        synchronized (this.f20742data) {
            try {
                if (this.cachedPublicKey == null) {
                    this.cachedPublicKey = new Ed25519PublicKeyParameters(AbstractC5863Ed25519.generatePublicKey(this.f20742data, 0));
                }
                ed25519PublicKeyParameters = this.cachedPublicKey;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ed25519PublicKeyParameters;
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.f20742data);
    }

    /* renamed from: sign */
    public void m15730sign(int i, Ed25519PublicKeyParameters ed25519PublicKeyParameters, byte[] bArr, byte[] bArr2, int i2, int i3, byte[] bArr3, int i4) {
        m15731sign(i, bArr, bArr2, i2, i3, bArr3, i4);
    }

    public Ed25519PrivateKeyParameters(SecureRandom secureRandom) {
        super(true);
        byte[] bArr = new byte[32];
        this.f20742data = bArr;
        AbstractC5863Ed25519.generatePrivateKey(secureRandom, bArr);
    }

    /* renamed from: sign */
    public void m15731sign(int i, byte[] bArr, byte[] bArr2, int i2, int i3, byte[] bArr3, int i4) {
        byte[] bArr4 = new byte[32];
        generatePublicKey().m15733encode(bArr4, 0);
        if (i == 0) {
            if (bArr != null) {
                throw new IllegalArgumentException("ctx");
            }
            AbstractC5863Ed25519.m16852sign(this.f20742data, 0, bArr4, 0, bArr2, i2, i3, bArr3, i4);
            return;
        }
        if (i == 1) {
            if (bArr == null) {
                throw new NullPointerException("'ctx' cannot be null");
            }
            if (bArr.length > 255) {
                throw new IllegalArgumentException("ctx");
            }
            AbstractC5863Ed25519.m16853sign(this.f20742data, 0, bArr4, 0, bArr, bArr2, i2, i3, bArr3, i4);
            return;
        }
        if (i != 2) {
            throw new IllegalArgumentException("algorithm");
        }
        if (bArr == null) {
            throw new NullPointerException("'ctx' cannot be null");
        }
        if (bArr.length > 255) {
            throw new IllegalArgumentException("ctx");
        }
        if (64 != i3) {
            throw new IllegalArgumentException("msgLen");
        }
        AbstractC5863Ed25519.signPrehash(this.f20742data, 0, bArr4, 0, bArr, bArr2, i2, bArr3, i4);
    }

    public Ed25519PrivateKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public Ed25519PrivateKeyParameters(byte[] bArr, int i) {
        super(true);
        byte[] bArr2 = new byte[32];
        this.f20742data = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, 32);
    }
}
