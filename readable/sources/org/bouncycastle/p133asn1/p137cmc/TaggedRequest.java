package org.bouncycastle.p133asn1.p137cmc;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p141crmf.CertReqMsg;

/* loaded from: classes.dex */
public class TaggedRequest extends ASN1Object implements ASN1Choice {

    /* renamed from: CRM */
    public static final int f18089CRM = 1;

    /* renamed from: ORM */
    public static final int f18090ORM = 2;

    /* renamed from: TCR */
    public static final int f18091TCR = 0;

    /* renamed from: tagNo */
    private final int f18092tagNo = 2;

    /* renamed from: value */
    private final ASN1Encodable f18093value;

    private TaggedRequest(ASN1Sequence aSN1Sequence) {
        this.f18093value = aSN1Sequence;
    }

    public static TaggedRequest getInstance(Object obj) {
        if (obj instanceof TaggedRequest) {
            return (TaggedRequest) obj;
        }
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof ASN1Encodable)) {
            if (obj instanceof byte[]) {
                try {
                    return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
                } catch (IOException unused) {
                    throw new IllegalArgumentException("unknown encoding in getInstance()");
                }
            }
            throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
        }
        ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(((ASN1Encodable) obj).toASN1Primitive());
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            return new TaggedRequest(TaggedCertificationRequest.getInstance(aSN1TaggedObject, false));
        }
        if (tagNo == 1) {
            return new TaggedRequest(CertReqMsg.getInstance(aSN1TaggedObject, false));
        }
        if (tagNo == 2) {
            return new TaggedRequest(ASN1Sequence.getInstance(aSN1TaggedObject, false));
        }
        throw new IllegalArgumentException("unknown tag in getInstance(): " + aSN1TaggedObject.getTagNo());
    }

    public int getTagNo() {
        return this.f18092tagNo;
    }

    public ASN1Encodable getValue() {
        return this.f18093value;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.f18092tagNo, this.f18093value);
    }

    public TaggedRequest(TaggedCertificationRequest taggedCertificationRequest) {
        this.f18093value = taggedCertificationRequest;
    }

    public TaggedRequest(CertReqMsg certReqMsg) {
        this.f18093value = certReqMsg;
    }
}
