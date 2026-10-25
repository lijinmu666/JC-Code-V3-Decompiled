package org.bouncycastle.p177cert.p180crmf;

/* loaded from: classes2.dex */
public class CRMFRuntimeException extends RuntimeException {

    /* renamed from: cause */
    private Throwable f18819cause;

    public CRMFRuntimeException(String str, Throwable th) {
        super(str);
        this.f18819cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f18819cause;
    }
}
