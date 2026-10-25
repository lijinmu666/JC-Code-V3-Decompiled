package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes.dex */
public class ProtectedPart extends ASN1Object {

    /* renamed from: body */
    private final C5114PKIBody f18156body;

    /* renamed from: header */
    private final PKIHeader f18157header;

    private ProtectedPart(ASN1Sequence aSN1Sequence) {
        this.f18157header = PKIHeader.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18156body = C5114PKIBody.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public static ProtectedPart getInstance(Object obj) {
        if (obj instanceof ProtectedPart) {
            return (ProtectedPart) obj;
        }
        if (obj != null) {
            return new ProtectedPart(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getBody */
    public C5114PKIBody m14523getBody() {
        return this.f18156body;
    }

    public PKIHeader getHeader() {
        return this.f18157header;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18157header, this.f18156body);
    }

    public ProtectedPart(PKIHeader pKIHeader, C5114PKIBody c5114PKIBody) {
        this.f18157header = pKIHeader;
        this.f18156body = c5114PKIBody;
    }
}
