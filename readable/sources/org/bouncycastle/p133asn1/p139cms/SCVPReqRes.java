package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes.dex */
public class SCVPReqRes extends ASN1Object {

    /* renamed from: request */
    private final ContentInfo f18221request;
    private final ContentInfo response;

    private SCVPReqRes(ASN1Sequence aSN1Sequence) {
        ContentInfo tagged;
        ASN1TaggedObject contextOptional;
        int iMo14450size = aSN1Sequence.mo14450size();
        int i = 1;
        if (iMo14450size < 1 || iMo14450size > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + iMo14450size);
        }
        if (iMo14450size <= 0 || (contextOptional = ASN1TaggedObject.getContextOptional(aSN1Sequence.getObjectAt(0), 0)) == null) {
            tagged = null;
            i = 0;
        } else {
            tagged = ContentInfo.getTagged(contextOptional, true);
        }
        this.f18221request = tagged;
        int i2 = i + 1;
        this.response = ContentInfo.getInstance(aSN1Sequence.getObjectAt(i));
        if (i2 != iMo14450size) {
            throw new IllegalArgumentException("Unexpected elements in sequence");
        }
    }

    public static SCVPReqRes getInstance(Object obj) {
        if (obj instanceof SCVPReqRes) {
            return (SCVPReqRes) obj;
        }
        if (obj != null) {
            return new SCVPReqRes(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static SCVPReqRes getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new SCVPReqRes(ASN1Sequence.getTagged(aSN1TaggedObject, z));
    }

    public ContentInfo getRequest() {
        return this.f18221request;
    }

    public ContentInfo getResponse() {
        return this.response;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18221request == null ? new DERSequence(this.response) : new DERSequence(new DERTaggedObject(true, 0, (ASN1Encodable) this.f18221request), this.response);
    }

    public SCVPReqRes(ContentInfo contentInfo) {
        this(null, contentInfo);
    }

    public static SCVPReqRes getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new SCVPReqRes(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public SCVPReqRes(ContentInfo contentInfo, ContentInfo contentInfo2) {
        if (contentInfo2 == null) {
            throw new NullPointerException("'response' cannot be null");
        }
        this.f18221request = contentInfo;
        this.response = contentInfo2;
    }
}
