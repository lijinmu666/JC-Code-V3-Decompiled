package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p141crmf.CertTemplate;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.X509Extensions;

/* loaded from: classes.dex */
public class RevDetails extends ASN1Object {
    private final CertTemplate certDetails;
    private Extensions crlEntryDetails;

    private RevDetails(ASN1Sequence aSN1Sequence) {
        this.certDetails = CertTemplate.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.mo14450size() > 1) {
            this.crlEntryDetails = Extensions.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static RevDetails getInstance(Object obj) {
        if (obj instanceof RevDetails) {
            return (RevDetails) obj;
        }
        if (obj != null) {
            return new RevDetails(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertTemplate getCertDetails() {
        return this.certDetails;
    }

    public Extensions getCrlEntryDetails() {
        return this.crlEntryDetails;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(this.certDetails);
        Extensions extensions = this.crlEntryDetails;
        if (extensions != null) {
            aSN1EncodableVector.m14420add(extensions);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public RevDetails(CertTemplate certTemplate) {
        this.certDetails = certTemplate;
    }

    public RevDetails(CertTemplate certTemplate, Extensions extensions) {
        this.certDetails = certTemplate;
        this.crlEntryDetails = extensions;
    }

    public RevDetails(CertTemplate certTemplate, X509Extensions x509Extensions) {
        this.certDetails = certTemplate;
        this.crlEntryDetails = Extensions.getInstance(x509Extensions.toASN1Primitive());
    }
}
