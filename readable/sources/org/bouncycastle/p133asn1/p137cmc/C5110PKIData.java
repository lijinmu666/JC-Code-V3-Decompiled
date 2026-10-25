package org.bouncycastle.p133asn1.p137cmc;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* renamed from: org.bouncycastle.asn1.cmc.PKIData */
/* loaded from: classes.dex */
public class C5110PKIData extends ASN1Object {
    private final TaggedContentInfo[] cmsSequence;
    private final TaggedAttribute[] controlSequence;
    private final OtherMsg[] otherMsgSequence;
    private final TaggedRequest[] reqSequence;

    private C5110PKIData(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 4) {
            throw new IllegalArgumentException("Sequence not 4 elements.");
        }
        int i = 0;
        ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(0);
        this.controlSequence = new TaggedAttribute[aSN1Sequence2.mo14450size()];
        int i2 = 0;
        while (true) {
            TaggedAttribute[] taggedAttributeArr = this.controlSequence;
            if (i2 >= taggedAttributeArr.length) {
                break;
            }
            taggedAttributeArr[i2] = TaggedAttribute.getInstance(aSN1Sequence2.getObjectAt(i2));
            i2++;
        }
        ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence.getObjectAt(1);
        this.reqSequence = new TaggedRequest[aSN1Sequence3.mo14450size()];
        int i3 = 0;
        while (true) {
            TaggedRequest[] taggedRequestArr = this.reqSequence;
            if (i3 >= taggedRequestArr.length) {
                break;
            }
            taggedRequestArr[i3] = TaggedRequest.getInstance(aSN1Sequence3.getObjectAt(i3));
            i3++;
        }
        ASN1Sequence aSN1Sequence4 = (ASN1Sequence) aSN1Sequence.getObjectAt(2);
        this.cmsSequence = new TaggedContentInfo[aSN1Sequence4.mo14450size()];
        int i4 = 0;
        while (true) {
            TaggedContentInfo[] taggedContentInfoArr = this.cmsSequence;
            if (i4 >= taggedContentInfoArr.length) {
                break;
            }
            taggedContentInfoArr[i4] = TaggedContentInfo.getInstance(aSN1Sequence4.getObjectAt(i4));
            i4++;
        }
        ASN1Sequence aSN1Sequence5 = (ASN1Sequence) aSN1Sequence.getObjectAt(3);
        this.otherMsgSequence = new OtherMsg[aSN1Sequence5.mo14450size()];
        while (true) {
            OtherMsg[] otherMsgArr = this.otherMsgSequence;
            if (i >= otherMsgArr.length) {
                return;
            }
            otherMsgArr[i] = OtherMsg.getInstance(aSN1Sequence5.getObjectAt(i));
            i++;
        }
    }

    /* renamed from: copy */
    private OtherMsg[] m14493copy(OtherMsg[] otherMsgArr) {
        int length = otherMsgArr.length;
        OtherMsg[] otherMsgArr2 = new OtherMsg[length];
        System.arraycopy(otherMsgArr, 0, otherMsgArr2, 0, length);
        return otherMsgArr2;
    }

    public static C5110PKIData getInstance(Object obj) {
        if (obj instanceof C5110PKIData) {
            return (C5110PKIData) obj;
        }
        if (obj != null) {
            return new C5110PKIData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public TaggedContentInfo[] getCmsSequence() {
        return m14495copy(this.cmsSequence);
    }

    public TaggedAttribute[] getControlSequence() {
        return m14494copy(this.controlSequence);
    }

    public OtherMsg[] getOtherMsgSequence() {
        return m14493copy(this.otherMsgSequence);
    }

    public TaggedRequest[] getReqSequence() {
        return m14496copy(this.reqSequence);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{new DERSequence(this.controlSequence), new DERSequence(this.reqSequence), new DERSequence(this.cmsSequence), new DERSequence(this.otherMsgSequence)});
    }

    public C5110PKIData(TaggedAttribute[] taggedAttributeArr, TaggedRequest[] taggedRequestArr, TaggedContentInfo[] taggedContentInfoArr, OtherMsg[] otherMsgArr) {
        this.controlSequence = m14494copy(taggedAttributeArr);
        this.reqSequence = m14496copy(taggedRequestArr);
        this.cmsSequence = m14495copy(taggedContentInfoArr);
        this.otherMsgSequence = m14493copy(otherMsgArr);
    }

    /* renamed from: copy */
    private TaggedAttribute[] m14494copy(TaggedAttribute[] taggedAttributeArr) {
        int length = taggedAttributeArr.length;
        TaggedAttribute[] taggedAttributeArr2 = new TaggedAttribute[length];
        System.arraycopy(taggedAttributeArr, 0, taggedAttributeArr2, 0, length);
        return taggedAttributeArr2;
    }

    /* renamed from: copy */
    private TaggedContentInfo[] m14495copy(TaggedContentInfo[] taggedContentInfoArr) {
        int length = taggedContentInfoArr.length;
        TaggedContentInfo[] taggedContentInfoArr2 = new TaggedContentInfo[length];
        System.arraycopy(taggedContentInfoArr, 0, taggedContentInfoArr2, 0, length);
        return taggedContentInfoArr2;
    }

    /* renamed from: copy */
    private TaggedRequest[] m14496copy(TaggedRequest[] taggedRequestArr) {
        int length = taggedRequestArr.length;
        TaggedRequest[] taggedRequestArr2 = new TaggedRequest[length];
        System.arraycopy(taggedRequestArr, 0, taggedRequestArr2, 0, length);
        return taggedRequestArr2;
    }
}
