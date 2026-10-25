package org.bouncycastle.p310pkix.p312util;

import java.util.Locale;

/* loaded from: classes2.dex */
public class LocalizedException extends Exception {

    /* renamed from: cause */
    private Throwable f22995cause;

    /* renamed from: message */
    protected ErrorBundle f22996message;

    public LocalizedException(ErrorBundle errorBundle) {
        super(errorBundle.m17454getText(Locale.getDefault()));
        this.f22996message = errorBundle;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f22995cause;
    }

    public ErrorBundle getErrorMessage() {
        return this.f22996message;
    }

    public LocalizedException(ErrorBundle errorBundle, Throwable th) {
        super(errorBundle.m17454getText(Locale.getDefault()));
        this.f22996message = errorBundle;
        this.f22995cause = th;
    }
}
