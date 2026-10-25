package org.bouncycastle.operator;

/* loaded from: classes2.dex */
public class RuntimeOperatorException extends RuntimeException {

    /* renamed from: cause */
    private Throwable f22865cause;

    public RuntimeOperatorException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f22865cause;
    }

    public RuntimeOperatorException(String str, Throwable th) {
        super(str);
        this.f22865cause = th;
    }
}
