package org.bouncycastle.internal.p231asn1.p242misc;

import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.DERIA5String;

/* loaded from: classes2.dex */
public class NetscapeRevocationURL extends DERIA5String {
    public NetscapeRevocationURL(ASN1IA5String aSN1IA5String) {
        super(aSN1IA5String.getString());
    }

    @Override // org.bouncycastle.p133asn1.ASN1IA5String
    public String toString() {
        return "NetscapeRevocationURL: " + getString();
    }
}
