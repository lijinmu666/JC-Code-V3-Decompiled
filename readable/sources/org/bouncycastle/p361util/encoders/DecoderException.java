package org.bouncycastle.p361util.encoders;

/* loaded from: classes2.dex */
public class DecoderException extends IllegalStateException {

    /* renamed from: cause */
    private Throwable f24216cause;

    public DecoderException(String str, Throwable th) {
        super(str);
        this.f24216cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f24216cause;
    }
}
