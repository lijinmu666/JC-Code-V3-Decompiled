package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes.dex */
public class GenRepContent extends ASN1Object {

    /* renamed from: content */
    private final ASN1Sequence f18113content;

    private GenRepContent(ASN1Sequence aSN1Sequence) {
        this.f18113content = aSN1Sequence;
    }

    public static GenRepContent getInstance(Object obj) {
        if (obj instanceof GenRepContent) {
            return (GenRepContent) obj;
        }
        if (obj != null) {
            return new GenRepContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18113content;
    }

    public InfoTypeAndValue[] toInfoTypeAndValueArray() {
        int iMo14450size = this.f18113content.mo14450size();
        InfoTypeAndValue[] infoTypeAndValueArr = new InfoTypeAndValue[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            infoTypeAndValueArr[i] = InfoTypeAndValue.getInstance(this.f18113content.getObjectAt(i));
        }
        return infoTypeAndValueArr;
    }

    public GenRepContent(InfoTypeAndValue infoTypeAndValue) {
        this.f18113content = new DERSequence(infoTypeAndValue);
    }

    public GenRepContent(InfoTypeAndValue[] infoTypeAndValueArr) {
        this.f18113content = new DERSequence(infoTypeAndValueArr);
    }
}
