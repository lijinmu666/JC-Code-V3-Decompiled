package org.bouncycastle.p133asn1.p145esf;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p164ocsp.BasicOCSPResponse;
import org.bouncycastle.p133asn1.p174x509.CertificateList;

/* loaded from: classes2.dex */
public class RevocationValues extends ASN1Object {

    /* renamed from: crlVals */
    private ASN1Sequence f18372crlVals;
    private ASN1Sequence ocspVals;
    private OtherRevVals otherRevVals;

    private RevocationValues(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() > 3) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject contextInstance = ASN1TaggedObject.getContextInstance(objects.nextElement());
            int tagNo = contextInstance.getTagNo();
            if (tagNo == 0) {
                ASN1Sequence aSN1Sequence2 = (ASN1Sequence) contextInstance.getExplicitBaseObject();
                Enumeration objects2 = aSN1Sequence2.getObjects();
                while (objects2.hasMoreElements()) {
                    CertificateList.getInstance(objects2.nextElement());
                }
                this.f18372crlVals = aSN1Sequence2;
            } else if (tagNo == 1) {
                ASN1Sequence aSN1Sequence3 = (ASN1Sequence) contextInstance.getExplicitBaseObject();
                Enumeration objects3 = aSN1Sequence3.getObjects();
                while (objects3.hasMoreElements()) {
                    BasicOCSPResponse.getInstance(objects3.nextElement());
                }
                this.ocspVals = aSN1Sequence3;
            } else {
                if (tagNo != 2) {
                    throw new IllegalArgumentException("invalid tag: " + contextInstance.getTagNo());
                }
                this.otherRevVals = OtherRevVals.getInstance(contextInstance.getExplicitBaseObject());
            }
        }
    }

    public static RevocationValues getInstance(Object obj) {
        if (obj instanceof RevocationValues) {
            return (RevocationValues) obj;
        }
        if (obj != null) {
            return new RevocationValues(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertificateList[] getCrlVals() {
        ASN1Sequence aSN1Sequence = this.f18372crlVals;
        if (aSN1Sequence == null) {
            return new CertificateList[0];
        }
        int iMo14450size = aSN1Sequence.mo14450size();
        CertificateList[] certificateListArr = new CertificateList[iMo14450size];
        for (int i = 0; i < iMo14450size; i++) {
            certificateListArr[i] = CertificateList.getInstance(this.f18372crlVals.getObjectAt(i));
        }
        return certificateListArr;
    }

    public BasicOCSPResponse[] getOcspVals() {
        ASN1Sequence aSN1Sequence = this.ocspVals;
        if (aSN1Sequence == null) {
            return new BasicOCSPResponse[0];
        }
        int iMo14450size = aSN1Sequence.mo14450size();
        BasicOCSPResponse[] basicOCSPResponseArr = new BasicOCSPResponse[iMo14450size];
        for (int i = 0; i < iMo14450size; i++) {
            basicOCSPResponseArr[i] = BasicOCSPResponse.getInstance(this.ocspVals.getObjectAt(i));
        }
        return basicOCSPResponseArr;
    }

    public OtherRevVals getOtherRevVals() {
        return this.otherRevVals;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        ASN1Sequence aSN1Sequence = this.f18372crlVals;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) aSN1Sequence));
        }
        ASN1Sequence aSN1Sequence2 = this.ocspVals;
        if (aSN1Sequence2 != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 1, (ASN1Encodable) aSN1Sequence2));
        }
        OtherRevVals otherRevVals = this.otherRevVals;
        if (otherRevVals != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 2, (ASN1Encodable) otherRevVals.toASN1Primitive()));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public RevocationValues(CertificateList[] certificateListArr, BasicOCSPResponse[] basicOCSPResponseArr, OtherRevVals otherRevVals) {
        if (certificateListArr != null) {
            this.f18372crlVals = new DERSequence(certificateListArr);
        }
        if (basicOCSPResponseArr != null) {
            this.ocspVals = new DERSequence(basicOCSPResponseArr);
        }
        this.otherRevVals = otherRevVals;
    }
}
