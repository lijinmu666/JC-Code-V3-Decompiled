package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1PrintableString;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public abstract class X509NameEntryConverter {
    public boolean canBePrintable(String str) {
        return ASN1PrintableString.isPrintableString(str);
    }

    public ASN1Primitive convertHexEncoded(String str, int i) {
        return ASN1Primitive.fromByteArray(C6255Hex.decodeStrict(str, i, str.length() - i));
    }

    public abstract ASN1Primitive getConvertedValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str);
}
