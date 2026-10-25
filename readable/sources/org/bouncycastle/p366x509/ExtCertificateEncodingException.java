package org.bouncycastle.p366x509;

import java.security.cert.CertificateEncodingException;

/* loaded from: classes2.dex */
class ExtCertificateEncodingException extends CertificateEncodingException {

    /* renamed from: cause */
    Throwable f24280cause;

    public ExtCertificateEncodingException(String str, Throwable th) {
        super(str);
        this.f24280cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f24280cause;
    }
}
