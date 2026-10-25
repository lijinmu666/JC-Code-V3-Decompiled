package org.bouncycastle.operator;

import java.io.IOException;

/* loaded from: classes2.dex */
public class OperatorStreamException extends IOException {

    /* renamed from: cause */
    private Throwable f22864cause;

    public OperatorStreamException(String str, Throwable th) {
        super(str);
        this.f22864cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f22864cause;
    }
}
