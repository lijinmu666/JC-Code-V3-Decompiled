package org.bouncycastle.p133asn1;

/* loaded from: classes.dex */
public class ASN1ParsingException extends IllegalStateException {

    /* renamed from: cause */
    private Throwable f17934cause;

    public ASN1ParsingException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f17934cause;
    }

    public ASN1ParsingException(String str, Throwable th) {
        super(str);
        this.f17934cause = th;
    }
}
