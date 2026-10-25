package org.bouncycastle.p133asn1.p138cmp;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes.dex */
public class PKIMessage extends ASN1Object {

    /* renamed from: body */
    private final C5114PKIBody f18143body;
    private final ASN1Sequence extraCerts;

    /* renamed from: header */
    private final PKIHeader f18144header;
    private final ASN1BitString protection;

    private PKIMessage(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18144header = PKIHeader.getInstance(objects.nextElement());
        if (!objects.hasMoreElements()) {
            throw new IllegalArgumentException("PKIMessage missing PKIBody structure");
        }
        this.f18143body = C5114PKIBody.getInstance(objects.nextElement());
        ASN1BitString aSN1BitString = null;
        ASN1Sequence aSN1Sequence2 = null;
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            if (aSN1TaggedObject.getTagNo() == 0) {
                aSN1BitString = ASN1BitString.getInstance(aSN1TaggedObject, true);
            } else {
                aSN1Sequence2 = ASN1Sequence.getInstance(aSN1TaggedObject, true);
            }
        }
        this.protection = aSN1BitString;
        this.extraCerts = aSN1Sequence2;
    }

    private void addOptional(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, i, aSN1Encodable));
        }
    }

    public static PKIMessage getInstance(Object obj) {
        if (obj instanceof PKIMessage) {
            return (PKIMessage) obj;
        }
        if (obj != null) {
            return new PKIMessage(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getBody */
    public C5114PKIBody m14521getBody() {
        return this.f18143body;
    }

    public CMPCertificate[] getExtraCerts() {
        ASN1Sequence aSN1Sequence = this.extraCerts;
        if (aSN1Sequence == null) {
            return null;
        }
        int iMo14450size = aSN1Sequence.mo14450size();
        CMPCertificate[] cMPCertificateArr = new CMPCertificate[iMo14450size];
        for (int i = 0; i < iMo14450size; i++) {
            cMPCertificateArr[i] = CMPCertificate.getInstance(this.extraCerts.getObjectAt(i));
        }
        return cMPCertificateArr;
    }

    public PKIHeader getHeader() {
        return this.f18144header;
    }

    public ASN1BitString getProtection() {
        return this.protection;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(this.f18144header);
        aSN1EncodableVector.m14420add(this.f18143body);
        addOptional(aSN1EncodableVector, 0, this.protection);
        addOptional(aSN1EncodableVector, 1, this.extraCerts);
        return new DERSequence(aSN1EncodableVector);
    }

    public PKIMessage(PKIHeader pKIHeader, C5114PKIBody c5114PKIBody) {
        this(pKIHeader, c5114PKIBody, null, null);
    }

    public PKIMessage(PKIHeader pKIHeader, C5114PKIBody c5114PKIBody, ASN1BitString aSN1BitString) {
        this(pKIHeader, c5114PKIBody, aSN1BitString, null);
    }

    public PKIMessage(PKIHeader pKIHeader, C5114PKIBody c5114PKIBody, ASN1BitString aSN1BitString, CMPCertificate[] cMPCertificateArr) {
        this.f18144header = pKIHeader;
        this.f18143body = c5114PKIBody;
        this.protection = aSN1BitString;
        this.extraCerts = cMPCertificateArr != null ? new DERSequence(cMPCertificateArr) : null;
    }
}
