package org.bouncycastle.p281jce.provider;

import java.security.cert.CRLException;

/* loaded from: classes2.dex */
class ExtCRLException extends CRLException {

    /* renamed from: cause */
    Throwable f21994cause;

    public ExtCRLException(String str, Throwable th) {
        super(str);
        this.f21994cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f21994cause;
    }
}
