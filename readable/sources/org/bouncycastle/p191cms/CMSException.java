package org.bouncycastle.p191cms;

/* loaded from: classes2.dex */
public class CMSException extends Exception {

    /* renamed from: e */
    Exception f18976e;

    public CMSException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f18976e;
    }

    public Exception getUnderlyingException() {
        return this.f18976e;
    }

    public CMSException(String str, Exception exc) {
        super(str);
        this.f18976e = exc;
    }
}
