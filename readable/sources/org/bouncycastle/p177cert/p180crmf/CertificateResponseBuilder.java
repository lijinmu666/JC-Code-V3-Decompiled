package org.bouncycastle.p177cert.p180crmf;

import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p138cmp.CMPCertificate;
import org.bouncycastle.p133asn1.p138cmp.CertOrEncCert;
import org.bouncycastle.p133asn1.p138cmp.CertResponse;
import org.bouncycastle.p133asn1.p138cmp.CertifiedKeyPair;
import org.bouncycastle.p133asn1.p138cmp.PKIStatusInfo;
import org.bouncycastle.p133asn1.p139cms.EnvelopedData;
import org.bouncycastle.p133asn1.p141crmf.EncryptedKey;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p191cms.CMSEnvelopedData;

/* loaded from: classes2.dex */
public class CertificateResponseBuilder {
    private CertifiedKeyPair certKeyPair;
    private final ASN1Integer certReqId;

    /* renamed from: rspInfo */
    private ASN1OctetString f18826rspInfo;
    private final PKIStatusInfo statusInfo;

    public CertificateResponseBuilder(ASN1Integer aSN1Integer, PKIStatusInfo pKIStatusInfo) {
        this.certReqId = aSN1Integer;
        this.statusInfo = pKIStatusInfo;
    }

    /* renamed from: build */
    public CertificateResponse m14781build() {
        return new CertificateResponse(new CertResponse(this.certReqId, this.statusInfo, this.certKeyPair, this.f18826rspInfo));
    }

    public CertificateResponseBuilder withCertificate(CMPCertificate cMPCertificate) {
        if (this.certKeyPair != null) {
            throw new IllegalStateException("certificate in response already set");
        }
        this.certKeyPair = new CertifiedKeyPair(new CertOrEncCert(cMPCertificate));
        return this;
    }

    public CertificateResponseBuilder withResponseInfo(byte[] bArr) {
        if (this.f18826rspInfo != null) {
            throw new IllegalStateException("response info already set");
        }
        this.f18826rspInfo = new DEROctetString(bArr);
        return this;
    }

    public CertificateResponseBuilder withCertificate(X509CertificateHolder x509CertificateHolder) {
        if (this.certKeyPair != null) {
            throw new IllegalStateException("certificate in response already set");
        }
        this.certKeyPair = new CertifiedKeyPair(new CertOrEncCert(new CMPCertificate(x509CertificateHolder.toASN1Structure())));
        return this;
    }

    public CertificateResponseBuilder withCertificate(CMSEnvelopedData cMSEnvelopedData) {
        if (this.certKeyPair != null) {
            throw new IllegalStateException("certificate in response already set");
        }
        this.certKeyPair = new CertifiedKeyPair(new CertOrEncCert(new EncryptedKey(EnvelopedData.getInstance(cMSEnvelopedData.toASN1Structure().getContent()))));
        return this;
    }
}
