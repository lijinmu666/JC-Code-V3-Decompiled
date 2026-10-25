package org.bouncycastle.p191cms;

import org.bouncycastle.p133asn1.p139cms.KEKRecipientInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class KEKRecipientInformation extends RecipientInformation {

    /* renamed from: info */
    private KEKRecipientInfo f19018info;

    public KEKRecipientInformation(KEKRecipientInfo kEKRecipientInfo, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable) {
        super(kEKRecipientInfo.getKeyEncryptionAlgorithm(), algorithmIdentifier, cMSSecureReadable);
        this.f19018info = kEKRecipientInfo;
        this.f19036rid = new KEKRecipientId(kEKRecipientInfo.getKekid().getKeyIdentifier().getOctets());
    }

    @Override // org.bouncycastle.p191cms.RecipientInformation
    public RecipientOperator getRecipientOperator(Recipient recipient) {
        return ((KEKRecipient) recipient).getRecipientOperator(this.keyEncAlg, this.messageAlgorithm, this.f19018info.getEncryptedKey().getOctets());
    }
}
