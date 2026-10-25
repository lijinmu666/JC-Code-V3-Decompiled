package org.bouncycastle.p177cert.p179cmp;

/* loaded from: classes2.dex */
public class CMPException extends Exception {

    /* renamed from: cause */
    private Throwable f18807cause;

    public CMPException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f18807cause;
    }

    public CMPException(String str, Throwable th) {
        super(str);
        this.f18807cause = th;
    }
}
