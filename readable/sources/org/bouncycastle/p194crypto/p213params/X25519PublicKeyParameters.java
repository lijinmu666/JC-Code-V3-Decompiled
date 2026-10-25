package org.bouncycastle.p194crypto.p213params;

import java.io.EOFException;
import java.io.InputStream;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public final class X25519PublicKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 32;

    /* renamed from: data */
    private final byte[] f20868data;

    public X25519PublicKeyParameters(InputStream inputStream) throws EOFException {
        super(false);
        byte[] bArr = new byte[32];
        this.f20868data = bArr;
        if (32 != C6257Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of X25519 public key");
        }
    }

    private static byte[] validate(byte[] bArr) {
        if (bArr.length == 32) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 32");
    }

    /* renamed from: encode */
    public void m15833encode(byte[] bArr, int i) {
        System.arraycopy(this.f20868data, 0, bArr, i, 32);
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.f20868data);
    }

    public X25519PublicKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public X25519PublicKeyParameters(byte[] bArr, int i) {
        super(false);
        byte[] bArr2 = new byte[32];
        this.f20868data = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, 32);
    }
}
