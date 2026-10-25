package org.bouncycastle.p223eac;

/* loaded from: classes2.dex */
public class EACException extends Exception {

    /* renamed from: cause */
    private Throwable f21152cause;

    public EACException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f21152cause;
    }

    public EACException(String str, Throwable th) {
        super(str);
        this.f21152cause = th;
    }
}
