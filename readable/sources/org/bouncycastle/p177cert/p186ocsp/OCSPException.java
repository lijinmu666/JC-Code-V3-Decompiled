package org.bouncycastle.p177cert.p186ocsp;

/* loaded from: classes2.dex */
public class OCSPException extends Exception {

    /* renamed from: cause */
    private Throwable f18889cause;

    public OCSPException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f18889cause;
    }

    public OCSPException(String str, Throwable th) {
        super(str);
        this.f18889cause = th;
    }
}
