package org.bouncycastle.p191cms;

/* loaded from: classes2.dex */
public class CMSRuntimeException extends RuntimeException {

    /* renamed from: e */
    Exception f18984e;

    public CMSRuntimeException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f18984e;
    }

    public Exception getUnderlyingException() {
        return this.f18984e;
    }

    public CMSRuntimeException(String str, Exception exc) {
        super(str);
        this.f18984e = exc;
    }
}
