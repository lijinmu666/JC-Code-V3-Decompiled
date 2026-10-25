package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes.dex */
public class PKIMessages extends ASN1Object {

    /* renamed from: content */
    private final ASN1Sequence f18145content;

    public PKIMessages(ASN1Sequence aSN1Sequence) {
        this.f18145content = aSN1Sequence;
    }

    public static PKIMessages getInstance(Object obj) {
        if (obj instanceof PKIMessages) {
            return (PKIMessages) obj;
        }
        if (obj != null) {
            return new PKIMessages(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18145content;
    }

    public PKIMessage[] toPKIMessageArray() {
        int iMo14450size = this.f18145content.mo14450size();
        PKIMessage[] pKIMessageArr = new PKIMessage[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            pKIMessageArr[i] = PKIMessage.getInstance(this.f18145content.getObjectAt(i));
        }
        return pKIMessageArr;
    }

    public PKIMessages(PKIMessage pKIMessage) {
        this.f18145content = new DERSequence(pKIMessage);
    }

    public PKIMessages(PKIMessage[] pKIMessageArr) {
        this.f18145content = new DERSequence(pKIMessageArr);
    }
}
