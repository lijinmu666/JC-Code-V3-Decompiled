package org.bouncycastle.p194crypto.p213params;

import java.io.EOFException;
import java.io.InputStream;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public final class X448PublicKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 56;

    /* renamed from: data */
    private final byte[] f20870data;

    public X448PublicKeyParameters(InputStream inputStream) throws EOFException {
        super(false);
        byte[] bArr = new byte[56];
        this.f20870data = bArr;
        if (56 != C6257Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of X448 public key");
        }
    }

    private static byte[] validate(byte[] bArr) {
        if (bArr.length == 56) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 56");
    }

    /* renamed from: encode */
    public void m15835encode(byte[] bArr, int i) {
        System.arraycopy(this.f20870data, 0, bArr, i, 56);
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.f20870data);
    }

    public X448PublicKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public X448PublicKeyParameters(byte[] bArr, int i) {
        super(false);
        byte[] bArr2 = new byte[56];
        this.f20870data = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, 56);
    }
}
