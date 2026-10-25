package org.bouncycastle.p358tsp.p360ers;

/* loaded from: classes2.dex */
public class ERSException extends Exception {

    /* renamed from: cause */
    private final Throwable f24185cause;

    public ERSException(String str) {
        this(str, null);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f24185cause;
    }

    public ERSException(String str, Throwable th) {
        super(str);
        this.f24185cause = th;
    }
}
