package org.bouncycastle.p296mime;

import java.io.IOException;

/* loaded from: classes2.dex */
public class MimeIOException extends IOException {

    /* renamed from: cause */
    private Throwable f22507cause;

    public MimeIOException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f22507cause;
    }

    public MimeIOException(String str, Throwable th) {
        super(str);
        this.f22507cause = th;
    }
}
