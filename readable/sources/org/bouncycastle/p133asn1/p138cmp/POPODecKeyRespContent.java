package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;

/* loaded from: classes.dex */
public class POPODecKeyRespContent extends ASN1Object {

    /* renamed from: content */
    private final ASN1Sequence f18153content;

    private POPODecKeyRespContent(ASN1Sequence aSN1Sequence) {
        this.f18153content = aSN1Sequence;
    }

    public static POPODecKeyRespContent getInstance(Object obj) {
        if (obj instanceof POPODecKeyRespContent) {
            return (POPODecKeyRespContent) obj;
        }
        if (obj != null) {
            return new POPODecKeyRespContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer[] toASN1IntegerArray() {
        int iMo14450size = this.f18153content.mo14450size();
        ASN1Integer[] aSN1IntegerArr = new ASN1Integer[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            aSN1IntegerArr[i] = ASN1Integer.getInstance(this.f18153content.getObjectAt(i));
        }
        return aSN1IntegerArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18153content;
    }
}
