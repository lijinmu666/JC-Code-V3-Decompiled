package org.bouncycastle.p133asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class ASN1Exception extends IOException {

    /* renamed from: cause */
    private Throwable f17907cause;

    public ASN1Exception(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f17907cause;
    }

    public ASN1Exception(String str, Throwable th) {
        super(str);
        this.f17907cause = th;
    }
}
