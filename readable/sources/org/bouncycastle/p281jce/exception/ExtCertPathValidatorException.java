package org.bouncycastle.p281jce.exception;

import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;

/* loaded from: classes2.dex */
public class ExtCertPathValidatorException extends CertPathValidatorException implements ExtException {

    /* renamed from: cause */
    private Throwable f21966cause;

    public ExtCertPathValidatorException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable, org.bouncycastle.p281jce.exception.ExtException
    public Throwable getCause() {
        return this.f21966cause;
    }

    public ExtCertPathValidatorException(String str, Throwable th) {
        super(str);
        this.f21966cause = th;
    }

    public ExtCertPathValidatorException(String str, Throwable th, CertPath certPath, int i) {
        super(str, th, certPath, i);
        this.f21966cause = th;
    }
}
