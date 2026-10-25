package org.bouncycastle.p177cert;

import java.io.IOException;

/* loaded from: classes2.dex */
public class CertIOException extends IOException {

    /* renamed from: cause */
    private Throwable f18798cause;

    public CertIOException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f18798cause;
    }

    public CertIOException(String str, Throwable th) {
        super(str);
        this.f18798cause = th;
    }
}
