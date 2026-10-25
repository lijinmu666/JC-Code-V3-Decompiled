package org.bouncycastle.p281jce.exception;

import java.io.IOException;

/* loaded from: classes2.dex */
public class ExtIOException extends IOException implements ExtException {

    /* renamed from: cause */
    private Throwable f21968cause;

    public ExtIOException(String str, Throwable th) {
        super(str);
        this.f21968cause = th;
    }

    @Override // java.lang.Throwable, org.bouncycastle.p281jce.exception.ExtException
    public Throwable getCause() {
        return this.f21968cause;
    }
}
