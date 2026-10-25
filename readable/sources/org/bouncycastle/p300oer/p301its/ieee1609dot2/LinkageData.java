package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.OEROptional;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5949IValue;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.GroupLinkageValue;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.LinkageValue;

/* loaded from: classes2.dex */
public class LinkageData extends ASN1Object {
    private final GroupLinkageValue groupLinkageValue;

    /* renamed from: iCert */
    private final C5949IValue f22651iCert;
    private final LinkageValue linkageValue;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.LinkageData$Builder */
    public static class C5927Builder {
        private GroupLinkageValue groupLinkageValue;

        /* renamed from: iCert */
        private C5949IValue f22652iCert;
        private LinkageValue linkageValue;

        public LinkageData createLinkageData() {
            return new LinkageData(this.f22652iCert, this.linkageValue, this.groupLinkageValue);
        }

        public C5927Builder setGroupLinkageValue(GroupLinkageValue groupLinkageValue) {
            this.groupLinkageValue = groupLinkageValue;
            return this;
        }

        public C5927Builder setICert(C5949IValue c5949IValue) {
            this.f22652iCert = c5949IValue;
            return this;
        }

        public C5927Builder setLinkageValue(LinkageValue linkageValue) {
            this.linkageValue = linkageValue;
            return this;
        }
    }

    private LinkageData(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("expected sequence size of 3");
        }
        this.f22651iCert = C5949IValue.getInstance(aSN1Sequence.getObjectAt(0));
        this.linkageValue = LinkageValue.getInstance((Object) aSN1Sequence.getObjectAt(1));
        this.groupLinkageValue = (GroupLinkageValue) OEROptional.getValue(GroupLinkageValue.class, aSN1Sequence.getObjectAt(2));
    }

    /* renamed from: builder */
    public static C5927Builder m17233builder() {
        return new C5927Builder();
    }

    public static LinkageData getInstance(Object obj) {
        if (obj instanceof LinkageData) {
            return (LinkageData) obj;
        }
        if (obj != null) {
            return new LinkageData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GroupLinkageValue getGroupLinkageValue() {
        return this.groupLinkageValue;
    }

    public C5949IValue getICert() {
        return this.f22651iCert;
    }

    public LinkageValue getLinkageValue() {
        return this.linkageValue;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f22651iCert, this.linkageValue, OEROptional.getInstance(this.groupLinkageValue)});
    }

    public LinkageData(C5949IValue c5949IValue, LinkageValue linkageValue, GroupLinkageValue groupLinkageValue) {
        this.f22651iCert = c5949IValue;
        this.linkageValue = linkageValue;
        this.groupLinkageValue = groupLinkageValue;
    }
}
