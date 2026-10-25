package org.bouncycastle.p194crypto.p206io;

import java.io.IOException;

/* loaded from: classes2.dex */
public class CipherIOException extends IOException {
    private static final long serialVersionUID = 1;

    /* renamed from: cause */
    private final Throwable f20351cause;

    public CipherIOException(String str, Throwable th) {
        super(str);
        this.f20351cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f20351cause;
    }
}
