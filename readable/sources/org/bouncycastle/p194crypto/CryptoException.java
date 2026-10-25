package org.bouncycastle.p194crypto;

/* loaded from: classes2.dex */
public class CryptoException extends Exception {

    /* renamed from: cause */
    private Throwable f19123cause;

    public CryptoException() {
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f19123cause;
    }

    public CryptoException(String str) {
        super(str);
    }

    public CryptoException(String str, Throwable th) {
        super(str);
        this.f19123cause = th;
    }
}
