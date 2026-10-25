package org.bouncycastle.p194crypto.p213params;

import java.io.EOFException;
import java.io.InputStream;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p285ec.p291rfc7748.AbstractC5861X448;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public final class X448PrivateKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 56;
    public static final int SECRET_SIZE = 56;

    /* renamed from: data */
    private final byte[] f20869data;

    public X448PrivateKeyParameters(InputStream inputStream) throws EOFException {
        super(true);
        byte[] bArr = new byte[56];
        this.f20869data = bArr;
        if (56 != C6257Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of X448 private key");
        }
    }

    private static byte[] validate(byte[] bArr) {
        if (bArr.length == 56) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 56");
    }

    /* renamed from: encode */
    public void m15834encode(byte[] bArr, int i) {
        System.arraycopy(this.f20869data, 0, bArr, i, 56);
    }

    public X448PublicKeyParameters generatePublicKey() {
        byte[] bArr = new byte[56];
        AbstractC5861X448.generatePublicKey(this.f20869data, 0, bArr, 0);
        return new X448PublicKeyParameters(bArr, 0);
    }

    public void generateSecret(X448PublicKeyParameters x448PublicKeyParameters, byte[] bArr, int i) {
        byte[] bArr2 = new byte[56];
        x448PublicKeyParameters.m15835encode(bArr2, 0);
        if (!AbstractC5861X448.calculateAgreement(this.f20869data, 0, bArr2, 0, bArr, i)) {
            throw new IllegalStateException("X448 agreement failed");
        }
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.f20869data);
    }

    public X448PrivateKeyParameters(SecureRandom secureRandom) {
        super(true);
        byte[] bArr = new byte[56];
        this.f20869data = bArr;
        AbstractC5861X448.generatePrivateKey(secureRandom, bArr);
    }

    public X448PrivateKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public X448PrivateKeyParameters(byte[] bArr, int i) {
        super(true);
        byte[] bArr2 = new byte[56];
        this.f20869data = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, 56);
    }
}
