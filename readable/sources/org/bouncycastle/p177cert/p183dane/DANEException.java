package org.bouncycastle.p177cert.p183dane;

/* loaded from: classes2.dex */
public class DANEException extends Exception {

    /* renamed from: cause */
    private Throwable f18868cause;

    public DANEException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f18868cause;
    }

    public DANEException(String str, Throwable th) {
        super(str);
        this.f18868cause = th;
    }
}
