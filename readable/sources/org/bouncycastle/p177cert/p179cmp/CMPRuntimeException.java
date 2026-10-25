package org.bouncycastle.p177cert.p179cmp;

/* loaded from: classes2.dex */
public class CMPRuntimeException extends RuntimeException {

    /* renamed from: cause */
    private Throwable f18808cause;

    public CMPRuntimeException(String str, Throwable th) {
        super(str);
        this.f18808cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f18808cause;
    }
}
