package org.bouncycastle.p194crypto.p213params;

import java.io.EOFException;
import java.io.InputStream;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p285ec.p291rfc7748.AbstractC5860X25519;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public final class X25519PrivateKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 32;
    public static final int SECRET_SIZE = 32;

    /* renamed from: data */
    private final byte[] f20867data;

    public X25519PrivateKeyParameters(InputStream inputStream) throws EOFException {
        super(true);
        byte[] bArr = new byte[32];
        this.f20867data = bArr;
        if (32 != C6257Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of X25519 private key");
        }
    }

    private static byte[] validate(byte[] bArr) {
        if (bArr.length == 32) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 32");
    }

    /* renamed from: encode */
    public void m15832encode(byte[] bArr, int i) {
        System.arraycopy(this.f20867data, 0, bArr, i, 32);
    }

    public X25519PublicKeyParameters generatePublicKey() {
        byte[] bArr = new byte[32];
        AbstractC5860X25519.generatePublicKey(this.f20867data, 0, bArr, 0);
        return new X25519PublicKeyParameters(bArr, 0);
    }

    public void generateSecret(X25519PublicKeyParameters x25519PublicKeyParameters, byte[] bArr, int i) {
        byte[] bArr2 = new byte[32];
        x25519PublicKeyParameters.m15833encode(bArr2, 0);
        if (!AbstractC5860X25519.calculateAgreement(this.f20867data, 0, bArr2, 0, bArr, i)) {
            throw new IllegalStateException("X25519 agreement failed");
        }
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.f20867data);
    }

    public X25519PrivateKeyParameters(SecureRandom secureRandom) {
        super(true);
        byte[] bArr = new byte[32];
        this.f20867data = bArr;
        AbstractC5860X25519.generatePrivateKey(secureRandom, bArr);
    }

    public X25519PrivateKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public X25519PrivateKeyParameters(byte[] bArr, int i) {
        super(true);
        byte[] bArr2 = new byte[32];
        this.f20867data = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, 32);
    }
}
