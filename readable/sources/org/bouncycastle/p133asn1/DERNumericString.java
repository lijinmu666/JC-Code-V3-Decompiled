package org.bouncycastle.p133asn1;

/* loaded from: classes.dex */
public class DERNumericString extends ASN1NumericString {
    public DERNumericString(String str) {
        this(str, false);
    }

    public DERNumericString(String str, boolean z) {
        super(str, z);
    }

    public DERNumericString(byte[] bArr, boolean z) {
        super(bArr, z);
    }
}
