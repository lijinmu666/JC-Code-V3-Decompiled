package org.bouncycastle.p191cms;

import java.io.IOException;

/* loaded from: classes2.dex */
public class CMSStreamException extends IOException {
    private final Throwable underlying;

    public CMSStreamException(String str) {
        super(str);
        this.underlying = null;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.underlying;
    }

    public CMSStreamException(String str, Throwable th) {
        super(str);
        this.underlying = th;
    }
}
