package org.bouncycastle.p307pkcs;

import java.io.IOException;

/* loaded from: classes2.dex */
public class PKCSIOException extends IOException {

    /* renamed from: cause */
    private Throwable f22933cause;

    public PKCSIOException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f22933cause;
    }

    public PKCSIOException(String str, Throwable th) {
        super(str);
        this.f22933cause = th;
    }
}
