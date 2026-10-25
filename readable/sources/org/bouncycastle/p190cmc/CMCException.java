package org.bouncycastle.p190cmc;

/* loaded from: classes2.dex */
public class CMCException extends Exception {

    /* renamed from: cause */
    private final Throwable f18925cause;

    public CMCException(String str) {
        this(str, null);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f18925cause;
    }

    public CMCException(String str, Throwable th) {
        super(str);
        this.f18925cause = th;
    }
}
