package org.bouncycastle.p361util.encoders;

/* loaded from: classes2.dex */
public class EncoderException extends IllegalStateException {

    /* renamed from: cause */
    private Throwable f24217cause;

    public EncoderException(String str, Throwable th) {
        super(str);
        this.f24217cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f24217cause;
    }
}
