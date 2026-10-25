package org.bouncycastle.p133asn1.p168smime;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p139cms.Attribute;
import org.bouncycastle.p133asn1.p139cms.IssuerAndSerialNumber;
import org.bouncycastle.p133asn1.p139cms.RecipientKeyIdentifier;

/* loaded from: classes2.dex */
public class SMIMEEncryptionKeyPreferenceAttribute extends Attribute {
    public SMIMEEncryptionKeyPreferenceAttribute(ASN1OctetString aSN1OctetString) {
        super(SMIMEAttributes.encrypKeyPref, new C5104DERSet(new DERTaggedObject(false, 2, (ASN1Encodable) aSN1OctetString)));
    }

    public SMIMEEncryptionKeyPreferenceAttribute(IssuerAndSerialNumber issuerAndSerialNumber) {
        super(SMIMEAttributes.encrypKeyPref, new C5104DERSet(new DERTaggedObject(false, 0, (ASN1Encodable) issuerAndSerialNumber)));
    }

    public SMIMEEncryptionKeyPreferenceAttribute(RecipientKeyIdentifier recipientKeyIdentifier) {
        super(SMIMEAttributes.encrypKeyPref, new C5104DERSet(new DERTaggedObject(false, 1, (ASN1Encodable) recipientKeyIdentifier)));
    }
}
