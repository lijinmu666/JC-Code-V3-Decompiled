package org.bouncycastle.p177cert.p188path;

/* loaded from: classes2.dex */
public class CertPathValidationException extends Exception {

    /* renamed from: cause */
    private final Exception f18900cause;

    public CertPathValidationException(String str) {
        this(str, null);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f18900cause;
    }

    public CertPathValidationException(String str, Exception exc) {
        super(str);
        this.f18900cause = exc;
    }
}
