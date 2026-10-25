package org.bouncycastle.p249jcajce.p250io;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Signature;
import java.security.SignatureException;
import org.bouncycastle.p361util.Exceptions;

/* loaded from: classes2.dex */
class SignatureUpdatingOutputStream extends OutputStream {

    /* renamed from: sig */
    private Signature f21380sig;

    public SignatureUpdatingOutputStream(Signature signature) {
        this.f21380sig = signature;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws SignatureException, IOException {
        try {
            this.f21380sig.update((byte) i);
        } catch (SignatureException e) {
            throw Exceptions.ioException(e.getMessage(), e);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws SignatureException, IOException {
        try {
            this.f21380sig.update(bArr);
        } catch (SignatureException e) {
            throw Exceptions.ioException(e.getMessage(), e);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws SignatureException, IOException {
        try {
            this.f21380sig.update(bArr, i, i2);
        } catch (SignatureException e) {
            throw Exceptions.ioException(e.getMessage(), e);
        }
    }
}
