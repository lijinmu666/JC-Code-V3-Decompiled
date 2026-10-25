package org.bouncycastle.p177cert;

/* loaded from: classes2.dex */
public class CertException extends Exception {

    /* renamed from: cause */
    private Throwable f18797cause;

    public CertException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f18797cause;
    }

    public CertException(String str, Throwable th) {
        super(str);
        this.f18797cause = th;
    }
}
