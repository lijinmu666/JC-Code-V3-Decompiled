package org.bouncycastle.p191cms;

/* loaded from: classes2.dex */
public class CMSAttributeTableGenerationException extends CMSRuntimeException {

    /* renamed from: e */
    Exception f18936e;

    public CMSAttributeTableGenerationException(String str) {
        super(str);
    }

    @Override // org.bouncycastle.p191cms.CMSRuntimeException, java.lang.Throwable
    public Throwable getCause() {
        return this.f18936e;
    }

    @Override // org.bouncycastle.p191cms.CMSRuntimeException
    public Exception getUnderlyingException() {
        return this.f18936e;
    }

    public CMSAttributeTableGenerationException(String str, Exception exc) {
        super(str);
        this.f18936e = exc;
    }
}
