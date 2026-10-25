package org.bouncycastle.operator;

/* loaded from: classes2.dex */
public class OperatorException extends Exception {

    /* renamed from: cause */
    private Throwable f22863cause;

    public OperatorException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f22863cause;
    }

    public OperatorException(String str, Throwable th) {
        super(str);
        this.f22863cause = th;
    }
}
