package org.bouncycastle.p194crypto.p213params;

import java.io.EOFException;
import java.io.InputStream;
import org.bouncycastle.p284math.p285ec.p292rfc8032.AbstractC5864Ed448;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public final class Ed448PublicKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 57;
    private final AbstractC5864Ed448.PublicPoint publicPoint;

    public Ed448PublicKeyParameters(InputStream inputStream) throws EOFException {
        super(false);
        byte[] bArr = new byte[57];
        if (57 != C6257Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of Ed448 public key");
        }
        this.publicPoint = m15738parse(bArr, 0);
    }

    /* renamed from: parse */
    private static AbstractC5864Ed448.PublicPoint m15738parse(byte[] bArr, int i) {
        AbstractC5864Ed448.PublicPoint publicPointValidatePublicKeyPartialExport = AbstractC5864Ed448.validatePublicKeyPartialExport(bArr, i);
        if (publicPointValidatePublicKeyPartialExport != null) {
            return publicPointValidatePublicKeyPartialExport;
        }
        throw new IllegalArgumentException("invalid public key");
    }

    private static byte[] validate(byte[] bArr) {
        if (bArr.length == 57) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 57");
    }

    /* renamed from: encode */
    public void m15739encode(byte[] bArr, int i) {
        AbstractC5864Ed448.encodePublicPoint(this.publicPoint, bArr, i);
    }

    public byte[] getEncoded() {
        byte[] bArr = new byte[57];
        m15739encode(bArr, 0);
        return bArr;
    }

    /* renamed from: verify */
    public boolean m15740verify(int i, byte[] bArr, byte[] bArr2, int i2, int i3, byte[] bArr3, int i4) {
        if (i == 0) {
            if (bArr == null) {
                throw new NullPointerException("'ctx' cannot be null");
            }
            if (bArr.length <= 255) {
                return AbstractC5864Ed448.m16863verify(bArr3, i4, this.publicPoint, bArr, bArr2, i2, i3);
            }
            throw new IllegalArgumentException("ctx");
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
        if (64 == i3) {
            return AbstractC5864Ed448.verifyPrehash(bArr3, i4, this.publicPoint, bArr, bArr2, i2);
        }
        throw new IllegalArgumentException("msgLen");
    }

    public Ed448PublicKeyParameters(AbstractC5864Ed448.PublicPoint publicPoint) {
        super(false);
        if (publicPoint == null) {
            throw new NullPointerException("'publicPoint' cannot be null");
        }
        this.publicPoint = publicPoint;
    }

    public Ed448PublicKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public Ed448PublicKeyParameters(byte[] bArr, int i) {
        super(false);
        this.publicPoint = m15738parse(bArr, i);
    }
}
