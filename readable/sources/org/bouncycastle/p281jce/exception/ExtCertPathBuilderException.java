package org.bouncycastle.p281jce.exception;

import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;

/* loaded from: classes2.dex */
public class ExtCertPathBuilderException extends CertPathBuilderException implements ExtException {

    /* renamed from: cause */
    private Throwable f21965cause;

    public ExtCertPathBuilderException(String str, Throwable th) {
        super(str);
        this.f21965cause = th;
    }

    @Override // java.lang.Throwable, org.bouncycastle.p281jce.exception.ExtException
    public Throwable getCause() {
        return this.f21965cause;
    }

    public ExtCertPathBuilderException(String str, Throwable th, CertPath certPath, int i) {
        super(str, th);
        this.f21965cause = th;
    }
}
