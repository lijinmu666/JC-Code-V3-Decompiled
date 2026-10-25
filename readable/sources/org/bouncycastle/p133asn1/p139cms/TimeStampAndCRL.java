package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.CertificateList;

/* loaded from: classes.dex */
public class TimeStampAndCRL extends ASN1Object {

    /* renamed from: crl */
    private CertificateList f18232crl;
    private ContentInfo timeStamp;

    private TimeStampAndCRL(ASN1Sequence aSN1Sequence) {
        this.timeStamp = ContentInfo.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.mo14450size() == 2) {
            this.f18232crl = CertificateList.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static TimeStampAndCRL getInstance(Object obj) {
        if (obj instanceof TimeStampAndCRL) {
            return (TimeStampAndCRL) obj;
        }
        if (obj != null) {
            return new TimeStampAndCRL(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getCRL */
    public CertificateList m14559getCRL() {
        return this.f18232crl;
    }

    public CertificateList getCertificateList() {
        return this.f18232crl;
    }

    public ContentInfo getTimeStampToken() {
        return this.timeStamp;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(this.timeStamp);
        CertificateList certificateList = this.f18232crl;
        if (certificateList != null) {
            aSN1EncodableVector.m14420add(certificateList);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public TimeStampAndCRL(ContentInfo contentInfo) {
        this(contentInfo, null);
    }

    public TimeStampAndCRL(ContentInfo contentInfo, CertificateList certificateList) {
        this.timeStamp = contentInfo;
        this.f18232crl = certificateList;
    }
}
