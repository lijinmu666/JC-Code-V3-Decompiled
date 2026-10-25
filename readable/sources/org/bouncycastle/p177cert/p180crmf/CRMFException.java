package org.bouncycastle.p177cert.p180crmf;

/* loaded from: classes2.dex */
public class CRMFException extends Exception {

    /* renamed from: cause */
    private Throwable f18818cause;

    public CRMFException(String str) {
        this(str, null);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f18818cause;
    }

    public CRMFException(String str, Throwable th) {
        super(str);
        this.f18818cause = th;
    }
}
