package org.bouncycastle.p281jce.exception;

import java.security.cert.CertificateEncodingException;

/* loaded from: classes2.dex */
public class ExtCertificateEncodingException extends CertificateEncodingException implements ExtException {

    /* renamed from: cause */
    private Throwable f21967cause;

    public ExtCertificateEncodingException(String str, Throwable th) {
        super(str);
        this.f21967cause = th;
    }

    @Override // java.lang.Throwable, org.bouncycastle.p281jce.exception.ExtException
    public Throwable getCause() {
        return this.f21967cause;
    }
}
