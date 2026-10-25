package org.bouncycastle.p191cms;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.p139cms.IssuerAndSerialNumber;
import org.bouncycastle.p133asn1.p139cms.KeyTransRecipientInfo;
import org.bouncycastle.p133asn1.p139cms.RecipientIdentifier;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class KeyTransRecipientInformation extends RecipientInformation {

    /* renamed from: info */
    private KeyTransRecipientInfo f19023info;

    public KeyTransRecipientInformation(KeyTransRecipientInfo keyTransRecipientInfo, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable) {
        KeyTransRecipientId keyTransRecipientId;
        super(keyTransRecipientInfo.getKeyEncryptionAlgorithm(), algorithmIdentifier, cMSSecureReadable);
        this.f19023info = keyTransRecipientInfo;
        RecipientIdentifier recipientIdentifier = keyTransRecipientInfo.getRecipientIdentifier();
        boolean zIsTagged = recipientIdentifier.isTagged();
        ASN1Encodable aSN1EncodableM14550getId = recipientIdentifier.m14550getId();
        if (zIsTagged) {
            keyTransRecipientId = new KeyTransRecipientId(ASN1OctetString.getInstance(aSN1EncodableM14550getId).getOctets());
        } else {
            IssuerAndSerialNumber issuerAndSerialNumber = IssuerAndSerialNumber.getInstance(aSN1EncodableM14550getId);
            keyTransRecipientId = new KeyTransRecipientId(issuerAndSerialNumber.m14540getName(), issuerAndSerialNumber.getSerialNumber().getValue());
        }
        this.f19036rid = keyTransRecipientId;
    }

    @Override // org.bouncycastle.p191cms.RecipientInformation
    public RecipientOperator getRecipientOperator(Recipient recipient) {
        return ((KeyTransRecipient) recipient).getRecipientOperator(this.keyEncAlg, this.messageAlgorithm, this.f19023info.getEncryptedKey().getOctets());
    }
}
