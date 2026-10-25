package org.bouncycastle.p177cert;

/* loaded from: classes2.dex */
public class CertRuntimeException extends RuntimeException {

    /* renamed from: cause */
    private Throwable f18799cause;

    public CertRuntimeException(String str, Throwable th) {
        super(str);
        this.f18799cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f18799cause;
    }
}
