package org.bouncycastle.p133asn1.p174x509;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DERGeneralizedTime;
import org.bouncycastle.p133asn1.DERIA5String;
import org.bouncycastle.p133asn1.DERPrintableString;
import org.bouncycastle.p133asn1.DERUTF8String;
import org.bouncycastle.p133asn1.p172x500.p173style.C5189BCStyle;

/* loaded from: classes2.dex */
public class X509DefaultEntryConverter extends X509NameEntryConverter {
    @Override // org.bouncycastle.p133asn1.p174x509.X509NameEntryConverter
    public ASN1Primitive getConvertedValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (str.length() == 0 || str.charAt(0) != '#') {
            if (str.length() != 0 && str.charAt(0) == '\\') {
                str = str.substring(1);
            }
            return (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) C5189BCStyle.EmailAddress) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) C5189BCStyle.f18592DC)) ? new DERIA5String(str) : aSN1ObjectIdentifier.m14446equals((ASN1Primitive) C5189BCStyle.DATE_OF_BIRTH) ? new DERGeneralizedTime(str) : (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) C5189BCStyle.f18590C) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) C5189BCStyle.SERIALNUMBER) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) C5189BCStyle.DN_QUALIFIER) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) C5189BCStyle.TELEPHONE_NUMBER)) ? new DERPrintableString(str) : new DERUTF8String(str);
        }
        try {
            return convertHexEncoded(str, 1);
        } catch (IOException unused) {
            throw new RuntimeException("can't recode value for oid " + aSN1ObjectIdentifier.m14433getId());
        }
    }
}
