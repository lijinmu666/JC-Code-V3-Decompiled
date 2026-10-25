package org.bouncycastle.p223eac;

import java.io.IOException;

/* loaded from: classes2.dex */
public class EACIOException extends IOException {

    /* renamed from: cause */
    private Throwable f21153cause;

    public EACIOException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f21153cause;
    }

    public EACIOException(String str, Throwable th) {
        super(str);
        this.f21153cause = th;
    }
}
