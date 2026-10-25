package org.bouncycastle.p361util;

/* loaded from: classes2.dex */
public class StoreException extends RuntimeException {

    /* renamed from: _e */
    private Throwable f24206_e;

    public StoreException(String str, Throwable th) {
        super(str);
        this.f24206_e = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f24206_e;
    }
}
