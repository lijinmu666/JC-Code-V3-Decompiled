package org.bouncycastle.p133asn1;

import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class ASN1Generator {

    /* renamed from: _out */
    protected OutputStream f17911_out;

    public ASN1Generator(OutputStream outputStream) {
        this.f17911_out = outputStream;
    }

    public static int inheritConstructedFlag(int i, int i2) {
        return (i2 & 32) != 0 ? i | 32 : i & (-33);
    }

    public abstract OutputStream getRawOutputStream();
}
