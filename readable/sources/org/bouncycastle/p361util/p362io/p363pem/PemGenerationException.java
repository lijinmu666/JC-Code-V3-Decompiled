package org.bouncycastle.p361util.p362io.p363pem;

import java.io.IOException;

/* loaded from: classes2.dex */
public class PemGenerationException extends IOException {

    /* renamed from: cause */
    private Throwable f24249cause;

    public PemGenerationException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f24249cause;
    }

    public PemGenerationException(String str, Throwable th) {
        super(str);
        this.f24249cause = th;
    }
}
