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

/* loaded from: classes2.dex */
public class CrlOcspRef extends ASN1Object {

    /* renamed from: crlids */
    private CrlListID f18369crlids;

    /* renamed from: ocspids */
    private OcspListID f18370ocspids;
    private OtherRevRefs otherRev;

    private CrlOcspRef(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject contextInstance = ASN1TaggedObject.getContextInstance(objects.nextElement());
            int tagNo = contextInstance.getTagNo();
            if (tagNo == 0) {
                this.f18369crlids = CrlListID.getInstance(contextInstance.getExplicitBaseObject());
            } else if (tagNo == 1) {
                this.f18370ocspids = OcspListID.getInstance(contextInstance.getExplicitBaseObject());
            } else {
                if (tagNo != 2) {
                    throw new IllegalArgumentException("illegal tag");
                }
                this.otherRev = OtherRevRefs.getInstance(contextInstance.getExplicitBaseObject());
            }
        }
    }

    public static CrlOcspRef getInstance(Object obj) {
        if (obj instanceof CrlOcspRef) {
            return (CrlOcspRef) obj;
        }
        if (obj != null) {
            return new CrlOcspRef(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CrlListID getCrlids() {
        return this.f18369crlids;
    }

    public OcspListID getOcspids() {
        return this.f18370ocspids;
    }

    public OtherRevRefs getOtherRev() {
        return this.otherRev;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        CrlListID crlListID = this.f18369crlids;
        if (crlListID != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) crlListID.toASN1Primitive()));
        }
        OcspListID ocspListID = this.f18370ocspids;
        if (ocspListID != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 1, (ASN1Encodable) ocspListID.toASN1Primitive()));
        }
        OtherRevRefs otherRevRefs = this.otherRev;
        if (otherRevRefs != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 2, (ASN1Encodable) otherRevRefs.toASN1Primitive()));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CrlOcspRef(CrlListID crlListID, OcspListID ocspListID, OtherRevRefs otherRevRefs) {
        this.f18369crlids = crlListID;
        this.f18370ocspids = ocspListID;
        this.otherRev = otherRevRefs;
    }
}
