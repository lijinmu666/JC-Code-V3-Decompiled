package org.bouncycastle.p222dvcs;

/* loaded from: classes2.dex */
public class DVCSException extends Exception {
    private static final long serialVersionUID = 389345256020131488L;

    /* renamed from: cause */
    private Throwable f21140cause;

    public DVCSException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f21140cause;
    }

    public DVCSException(String str, Throwable th) {
        super(str);
        this.f21140cause = th;
    }
}
