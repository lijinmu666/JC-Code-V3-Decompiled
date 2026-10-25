package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* renamed from: org.bouncycastle.asn1.x509.Holder */
/* loaded from: classes2.dex */
public class C5190Holder extends ASN1Object {
    public static final int V1_CERTIFICATE_HOLDER = 0;
    public static final int V2_CERTIFICATE_HOLDER = 1;
    IssuerSerial baseCertificateID;
    GeneralNames entityName;
    ObjectDigestInfo objectDigestInfo;

    /* renamed from: version */
    private int f18662version;

    private C5190Holder(ASN1Sequence aSN1Sequence) {
        this.f18662version = 1;
        if (aSN1Sequence.mo14450size() > 3) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
        for (int i = 0; i != aSN1Sequence.mo14450size(); i++) {
            ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                this.baseCertificateID = IssuerSerial.getInstance(aSN1TaggedObject, false);
            } else if (tagNo == 1) {
                this.entityName = GeneralNames.getInstance(aSN1TaggedObject, false);
            } else {
                if (tagNo != 2) {
                    throw new IllegalArgumentException("unknown tag in Holder");
                }
                this.objectDigestInfo = ObjectDigestInfo.getInstance(aSN1TaggedObject, false);
            }
        }
        this.f18662version = 1;
    }

    public static C5190Holder getInstance(Object obj) {
        if (obj instanceof C5190Holder) {
            return (C5190Holder) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new C5190Holder(ASN1TaggedObject.getInstance(obj));
        }
        if (obj != null) {
            return new C5190Holder(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public IssuerSerial getBaseCertificateID() {
        return this.baseCertificateID;
    }

    public GeneralNames getEntityName() {
        return this.entityName;
    }

    public ObjectDigestInfo getObjectDigestInfo() {
        return this.objectDigestInfo;
    }

    public int getVersion() {
        return this.f18662version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (this.f18662version != 1) {
            GeneralNames generalNames = this.entityName;
            return generalNames != null ? new DERTaggedObject(true, 1, (ASN1Encodable) generalNames) : new DERTaggedObject(true, 0, (ASN1Encodable) this.baseCertificateID);
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        IssuerSerial issuerSerial = this.baseCertificateID;
        if (issuerSerial != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) issuerSerial));
        }
        GeneralNames generalNames2 = this.entityName;
        if (generalNames2 != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) generalNames2));
        }
        ObjectDigestInfo objectDigestInfo = this.objectDigestInfo;
        if (objectDigestInfo != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 2, (ASN1Encodable) objectDigestInfo));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private C5190Holder(ASN1TaggedObject aSN1TaggedObject) {
        this.f18662version = 1;
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            this.baseCertificateID = IssuerSerial.getInstance(aSN1TaggedObject, true);
        } else {
            if (tagNo != 1) {
                throw new IllegalArgumentException("unknown tag in Holder");
            }
            this.entityName = GeneralNames.getInstance(aSN1TaggedObject, true);
        }
        this.f18662version = 0;
    }

    public C5190Holder(GeneralNames generalNames) {
        this(generalNames, 1);
    }

    public C5190Holder(GeneralNames generalNames, int i) {
        this.entityName = generalNames;
        this.f18662version = i;
    }

    public C5190Holder(IssuerSerial issuerSerial) {
        this(issuerSerial, 1);
    }

    public C5190Holder(IssuerSerial issuerSerial, int i) {
        this.baseCertificateID = issuerSerial;
        this.f18662version = i;
    }

    public C5190Holder(ObjectDigestInfo objectDigestInfo) {
        this.f18662version = 1;
        this.objectDigestInfo = objectDigestInfo;
    }
}
