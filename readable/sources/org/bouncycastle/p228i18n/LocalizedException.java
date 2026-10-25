package org.bouncycastle.p228i18n;

import java.util.Locale;

/* loaded from: classes2.dex */
public class LocalizedException extends Exception {

    /* renamed from: cause */
    private Throwable f21221cause;

    /* renamed from: message */
    protected ErrorBundle f21222message;

    public LocalizedException(ErrorBundle errorBundle) {
        super(errorBundle.m15985getText(Locale.getDefault()));
        this.f21222message = errorBundle;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f21221cause;
    }

    public ErrorBundle getErrorMessage() {
        return this.f21222message;
    }

    public LocalizedException(ErrorBundle errorBundle, Throwable th) {
        super(errorBundle.m15985getText(Locale.getDefault()));
        this.f21222message = errorBundle;
        this.f21221cause = th;
    }
}
