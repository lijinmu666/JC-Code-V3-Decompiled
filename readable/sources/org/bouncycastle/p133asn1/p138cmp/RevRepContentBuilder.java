package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p141crmf.C5116CertId;
import org.bouncycastle.p133asn1.p174x509.CertificateList;

/* loaded from: classes.dex */
public class RevRepContentBuilder {

    /* renamed from: status */
    private final ASN1EncodableVector f18163status = new ASN1EncodableVector();
    private final ASN1EncodableVector revCerts = new ASN1EncodableVector();

    /* renamed from: crls */
    private final ASN1EncodableVector f18162crls = new ASN1EncodableVector();

    /* renamed from: add */
    public RevRepContentBuilder m14525add(PKIStatusInfo pKIStatusInfo) {
        this.f18163status.m14420add(pKIStatusInfo);
        return this;
    }

    /* renamed from: addCrl */
    public RevRepContentBuilder m14527addCrl(CertificateList certificateList) {
        this.f18162crls.m14420add(certificateList);
        return this;
    }

    /* renamed from: build */
    public RevRepContent m14528build() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(new DERSequence(this.f18163status));
        if (this.revCerts.m14424size() != 0) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) new DERSequence(this.revCerts)));
        }
        if (this.f18162crls.m14424size() != 0) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 1, (ASN1Encodable) new DERSequence(this.f18162crls)));
        }
        return RevRepContent.getInstance(new DERSequence(aSN1EncodableVector));
    }

    /* renamed from: add */
    public RevRepContentBuilder m14526add(PKIStatusInfo pKIStatusInfo, C5116CertId c5116CertId) {
        if (this.f18163status.m14424size() != this.revCerts.m14424size()) {
            throw new IllegalStateException("status and revCerts sequence must be in common order");
        }
        this.f18163status.m14420add(pKIStatusInfo);
        this.revCerts.m14420add(c5116CertId);
        return this;
    }
}
