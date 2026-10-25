package org.bouncycastle.p191cms;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.p139cms.IssuerAndSerialNumber;
import org.bouncycastle.p133asn1.p139cms.KEMRecipientInfo;
import org.bouncycastle.p133asn1.p139cms.RecipientIdentifier;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class KEMRecipientInformation extends RecipientInformation {

    /* renamed from: info */
    private KEMRecipientInfo f19020info;

    public KEMRecipientInformation(KEMRecipientInfo kEMRecipientInfo, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable) {
        KEMRecipientId kEMRecipientId;
        super(kEMRecipientInfo.m14543getKem(), algorithmIdentifier, cMSSecureReadable);
        this.f19020info = kEMRecipientInfo;
        RecipientIdentifier recipientIdentifier = kEMRecipientInfo.getRecipientIdentifier();
        boolean zIsTagged = recipientIdentifier.isTagged();
        ASN1Encodable aSN1EncodableM14550getId = recipientIdentifier.m14550getId();
        if (zIsTagged) {
            kEMRecipientId = new KEMRecipientId(ASN1OctetString.getInstance(aSN1EncodableM14550getId).getOctets());
        } else {
            IssuerAndSerialNumber issuerAndSerialNumber = IssuerAndSerialNumber.getInstance(aSN1EncodableM14550getId);
            kEMRecipientId = new KEMRecipientId(issuerAndSerialNumber.m14540getName(), issuerAndSerialNumber.getSerialNumber().getValue());
        }
        this.f19036rid = kEMRecipientId;
    }

    public byte[] getEncapsulation() {
        return C6238Arrays.m18231clone(this.f19020info.getKemct().getOctets());
    }

    public AlgorithmIdentifier getKdfAlgorithm() {
        return this.f19020info.m14542getKdf();
    }

    @Override // org.bouncycastle.p191cms.RecipientInformation
    public RecipientOperator getRecipientOperator(Recipient recipient) {
        return ((KEMRecipient) recipient).getRecipientOperator(new AlgorithmIdentifier(this.keyEncAlg.getAlgorithm(), this.f19020info), this.messageAlgorithm, this.f19020info.getEncryptedKey().getOctets());
    }

    /* renamed from: getUkm */
    public byte[] m14884getUkm() {
        return C6238Arrays.m18231clone(this.f19020info.m14544getUkm());
    }
}
