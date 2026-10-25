package org.bouncycastle.p249jcajce.provider.asymmetric.p265x509;

import java.security.cert.CRLException;

/* loaded from: classes2.dex */
class ExtCRLException extends CRLException {

    /* renamed from: cause */
    Throwable f21647cause;

    public ExtCRLException(String str, Throwable th) {
        super(str);
        this.f21647cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f21647cause;
    }
}
