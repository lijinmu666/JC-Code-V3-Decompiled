package org.bouncycastle.p307pkcs;

/* loaded from: classes2.dex */
public class PKCSException extends Exception {

    /* renamed from: cause */
    private Throwable f22932cause;

    public PKCSException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f22932cause;
    }

    public PKCSException(String str, Throwable th) {
        super(str);
        this.f22932cause = th;
    }
}
