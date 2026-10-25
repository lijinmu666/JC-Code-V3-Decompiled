package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes.dex */
public class RevReqContent extends ASN1Object {

    /* renamed from: content */
    private final ASN1Sequence f18164content;

    private RevReqContent(ASN1Sequence aSN1Sequence) {
        this.f18164content = aSN1Sequence;
    }

    public static RevReqContent getInstance(Object obj) {
        if (obj instanceof RevReqContent) {
            return (RevReqContent) obj;
        }
        if (obj != null) {
            return new RevReqContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18164content;
    }

    public RevDetails[] toRevDetailsArray() {
        int iMo14450size = this.f18164content.mo14450size();
        RevDetails[] revDetailsArr = new RevDetails[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            revDetailsArr[i] = RevDetails.getInstance(this.f18164content.getObjectAt(i));
        }
        return revDetailsArr;
    }

    public RevReqContent(RevDetails revDetails) {
        this.f18164content = new DERSequence(revDetails);
    }

    public RevReqContent(RevDetails[] revDetailsArr) {
        this.f18164content = new DERSequence(revDetailsArr);
    }
}
