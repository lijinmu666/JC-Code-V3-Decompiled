package org.bouncycastle.p177cert.p180crmf;

import org.bouncycastle.p133asn1.p138cmp.CMPCertificate;
import org.bouncycastle.p133asn1.p138cmp.CertResponse;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p191cms.CMSEnvelopedData;
import org.bouncycastle.p191cms.Recipient;

/* loaded from: classes2.dex */
public class CertificateResponse {
    private final CertResponse certResponse;

    public CertificateResponse(CertResponse certResponse) {
        this.certResponse = certResponse;
    }

    public CMPCertificate getCertificate() {
        if (hasEncryptedCertificate()) {
            throw new IllegalStateException("plaintext certificate asked for, none found");
        }
        return this.certResponse.getCertifiedKeyPair().getCertOrEncCert().getCertificate();
    }

    public CMSEnvelopedData getEncryptedCertificate() {
        if (!hasEncryptedCertificate()) {
            throw new IllegalStateException("encrypted certificate asked for, none found");
        }
        CMSEnvelopedData cMSEnvelopedData = new CMSEnvelopedData(new ContentInfo(PKCSObjectIdentifiers.envelopedData, this.certResponse.getCertifiedKeyPair().getCertOrEncCert().getEncryptedCert().getValue()));
        if (cMSEnvelopedData.getRecipientInfos().m14895size() == 1) {
            return cMSEnvelopedData;
        }
        throw new IllegalStateException("data encrypted for more than one recipient");
    }

    public boolean hasEncryptedCertificate() {
        return this.certResponse.getCertifiedKeyPair().getCertOrEncCert().hasEncryptedCertificate();
    }

    public CertResponse toASN1Structure() {
        return this.certResponse;
    }

    public CMPCertificate getCertificate(Recipient recipient) {
        return CMPCertificate.getInstance(getEncryptedCertificate().getRecipientInfos().getRecipients().iterator().next().getContent(recipient));
    }
}
