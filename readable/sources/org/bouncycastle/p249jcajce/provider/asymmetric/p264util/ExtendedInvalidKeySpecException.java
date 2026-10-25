package org.bouncycastle.p249jcajce.provider.asymmetric.p264util;

import java.security.spec.InvalidKeySpecException;

/* loaded from: classes2.dex */
public class ExtendedInvalidKeySpecException extends InvalidKeySpecException {

    /* renamed from: cause */
    private Throwable f21644cause;

    public ExtendedInvalidKeySpecException(String str, Throwable th) {
        super(str);
        this.f21644cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f21644cause;
    }
}
