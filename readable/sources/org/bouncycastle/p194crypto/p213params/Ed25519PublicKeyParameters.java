package org.bouncycastle.p194crypto.p213params;

import java.io.EOFException;
import java.io.InputStream;
import org.bouncycastle.p284math.p285ec.p292rfc8032.AbstractC5863Ed25519;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public final class Ed25519PublicKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 32;
    private final AbstractC5863Ed25519.PublicPoint publicPoint;

    public Ed25519PublicKeyParameters(InputStream inputStream) throws EOFException {
        super(false);
        byte[] bArr = new byte[32];
        if (32 != C6257Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of Ed25519 public key");
        }
        this.publicPoint = m15732parse(bArr, 0);
    }

    /* renamed from: parse */
    private static AbstractC5863Ed25519.PublicPoint m15732parse(byte[] bArr, int i) {
        AbstractC5863Ed25519.PublicPoint publicPointValidatePublicKeyPartialExport = AbstractC5863Ed25519.validatePublicKeyPartialExport(bArr, i);
        if (publicPointValidatePublicKeyPartialExport != null) {
            return publicPointValidatePublicKeyPartialExport;
        }
        throw new IllegalArgumentException("invalid public key");
    }

    private static byte[] validate(byte[] bArr) {
        if (bArr.length == 32) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 32");
    }

    /* renamed from: encode */
    public void m15733encode(byte[] bArr, int i) {
        AbstractC5863Ed25519.encodePublicPoint(this.publicPoint, bArr, i);
    }

    public byte[] getEncoded() {
        byte[] bArr = new byte[32];
        m15733encode(bArr, 0);
        return bArr;
    }

    /* renamed from: verify */
    public boolean m15734verify(int i, byte[] bArr, byte[] bArr2, int i2, int i3, byte[] bArr3, int i4) {
        if (i == 0) {
            if (bArr == null) {
                return AbstractC5863Ed25519.m16855verify(bArr3, i4, this.publicPoint, bArr2, i2, i3);
            }
            throw new IllegalArgumentException("ctx");
        }
        if (i == 1) {
            if (bArr == null) {
                throw new NullPointerException("'ctx' cannot be null");
            }
            if (bArr.length <= 255) {
                return AbstractC5863Ed25519.m16856verify(bArr3, i4, this.publicPoint, bArr, bArr2, i2, i3);
            }
            throw new IllegalArgumentException("ctx");
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
        if (64 == i3) {
            return AbstractC5863Ed25519.verifyPrehash(bArr3, i4, this.publicPoint, bArr, bArr2, i2);
        }
        throw new IllegalArgumentException("msgLen");
    }

    public Ed25519PublicKeyParameters(AbstractC5863Ed25519.PublicPoint publicPoint) {
        super(false);
        if (publicPoint == null) {
            throw new NullPointerException("'publicPoint' cannot be null");
        }
        this.publicPoint = publicPoint;
    }

    public Ed25519PublicKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public Ed25519PublicKeyParameters(byte[] bArr, int i) {
        super(false);
        this.publicPoint = m15732parse(bArr, i);
    }
}
