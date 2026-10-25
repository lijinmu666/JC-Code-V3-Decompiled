package org.bouncycastle.p310pkix;

/* loaded from: classes2.dex */
public class PKIXNameConstraintValidatorException extends Exception {

    /* renamed from: cause */
    private Throwable f22976cause;

    public PKIXNameConstraintValidatorException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f22976cause;
    }

    public PKIXNameConstraintValidatorException(String str, Throwable th) {
        super(str);
        this.f22976cause = th;
    }
}
