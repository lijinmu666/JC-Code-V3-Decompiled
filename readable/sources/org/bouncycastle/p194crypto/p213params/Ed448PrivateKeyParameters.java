package org.bouncycastle.p194crypto.p213params;

import java.io.EOFException;
import java.io.InputStream;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p285ec.p292rfc8032.AbstractC5864Ed448;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public final class Ed448PrivateKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 57;
    public static final int SIGNATURE_SIZE = 114;
    private Ed448PublicKeyParameters cachedPublicKey;

    /* renamed from: data */
    private final byte[] f20743data;

    public Ed448PrivateKeyParameters(InputStream inputStream) throws EOFException {
        super(true);
        byte[] bArr = new byte[57];
        this.f20743data = bArr;
        if (57 != C6257Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of Ed448 private key");
        }
    }

    private static byte[] validate(byte[] bArr) {
        if (bArr.length == 57) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 57");
    }

    /* renamed from: encode */
    public void m15735encode(byte[] bArr, int i) {
        System.arraycopy(this.f20743data, 0, bArr, i, 57);
    }

    public Ed448PublicKeyParameters generatePublicKey() {
        Ed448PublicKeyParameters ed448PublicKeyParameters;
        synchronized (this.f20743data) {
            try {
                if (this.cachedPublicKey == null) {
                    this.cachedPublicKey = new Ed448PublicKeyParameters(AbstractC5864Ed448.generatePublicKey(this.f20743data, 0));
                }
                ed448PublicKeyParameters = this.cachedPublicKey;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ed448PublicKeyParameters;
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.f20743data);
    }

    /* renamed from: sign */
    public void m15736sign(int i, Ed448PublicKeyParameters ed448PublicKeyParameters, byte[] bArr, byte[] bArr2, int i2, int i3, byte[] bArr3, int i4) {
        m15737sign(i, bArr, bArr2, i2, i3, bArr3, i4);
    }

    public Ed448PrivateKeyParameters(SecureRandom secureRandom) {
        super(true);
        byte[] bArr = new byte[57];
        this.f20743data = bArr;
        AbstractC5864Ed448.generatePrivateKey(secureRandom, bArr);
    }

    /* renamed from: sign */
    public void m15737sign(int i, byte[] bArr, byte[] bArr2, int i2, int i3, byte[] bArr3, int i4) {
        byte[] bArr4 = new byte[57];
        generatePublicKey().m15739encode(bArr4, 0);
        if (i == 0) {
            if (bArr == null) {
                throw new NullPointerException("'ctx' cannot be null");
            }
            if (bArr.length > 255) {
                throw new IllegalArgumentException("ctx");
            }
            AbstractC5864Ed448.m16861sign(this.f20743data, 0, bArr4, 0, bArr, bArr2, i2, i3, bArr3, i4);
            return;
        }
        if (i != 1) {
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
        AbstractC5864Ed448.signPrehash(this.f20743data, 0, bArr4, 0, bArr, bArr2, i2, bArr3, i4);
    }

    public Ed448PrivateKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public Ed448PrivateKeyParameters(byte[] bArr, int i) {
        super(true);
        byte[] bArr2 = new byte[57];
        this.f20743data = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, 57);
    }
}
