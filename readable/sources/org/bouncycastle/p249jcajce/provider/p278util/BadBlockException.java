package org.bouncycastle.p249jcajce.provider.p278util;

import javax.crypto.BadPaddingException;

/* loaded from: classes2.dex */
public class BadBlockException extends BadPaddingException {

    /* renamed from: cause */
    private final Throwable f21903cause;

    public BadBlockException(String str, Throwable th) {
        super(str);
        this.f21903cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f21903cause;
    }
}
