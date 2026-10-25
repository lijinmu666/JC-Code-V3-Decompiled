package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.CertificateList;

/* loaded from: classes.dex */
public class CRLAnnContent extends ASN1Object {

    /* renamed from: content */
    private final ASN1Sequence f18096content;

    private CRLAnnContent(ASN1Sequence aSN1Sequence) {
        this.f18096content = aSN1Sequence;
    }

    public static CRLAnnContent getInstance(Object obj) {
        if (obj instanceof CRLAnnContent) {
            return (CRLAnnContent) obj;
        }
        if (obj != null) {
            return new CRLAnnContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertificateList[] getCertificateLists() {
        int iMo14450size = this.f18096content.mo14450size();
        CertificateList[] certificateListArr = new CertificateList[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            certificateListArr[i] = CertificateList.getInstance(this.f18096content.getObjectAt(i));
        }
        return certificateListArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18096content;
    }

    public CRLAnnContent(CertificateList certificateList) {
        this.f18096content = new DERSequence(certificateList);
    }
}
