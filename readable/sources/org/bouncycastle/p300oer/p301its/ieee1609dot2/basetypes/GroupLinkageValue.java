package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p300oer.p301its.ItsUtils;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class GroupLinkageValue extends ASN1Object {

    /* renamed from: jValue */
    private final ASN1OctetString f22726jValue;

    /* renamed from: value */
    private final ASN1OctetString f22727value;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.GroupLinkageValue$Builder */
    public static class C5948Builder {

        /* renamed from: jValue */
        private ASN1OctetString f22728jValue;

        /* renamed from: value */
        private ASN1OctetString f22729value;

        public GroupLinkageValue createGroupLinkageValue() {
            return new GroupLinkageValue(this.f22728jValue, this.f22729value);
        }

        public C5948Builder setJValue(ASN1OctetString aSN1OctetString) {
            this.f22728jValue = aSN1OctetString;
            return this;
        }

        public C5948Builder setValue(ASN1OctetString aSN1OctetString) {
            this.f22729value = aSN1OctetString;
            return this;
        }

        public C5948Builder setJValue(byte[] bArr) {
            return setJValue(new DEROctetString(C6238Arrays.m18231clone(bArr)));
        }

        public C5948Builder setValue(byte[] bArr) {
            return setValue(new DEROctetString(C6238Arrays.m18231clone(bArr)));
        }
    }

    public GroupLinkageValue(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        this.f22726jValue = aSN1OctetString;
        this.f22727value = aSN1OctetString2;
        assertValues();
    }

    private void assertValues() {
        ASN1OctetString aSN1OctetString = this.f22726jValue;
        if (aSN1OctetString == null || aSN1OctetString.getOctets().length != 4) {
            throw new IllegalArgumentException("jValue is null or not four bytes long");
        }
        ASN1OctetString aSN1OctetString2 = this.f22727value;
        if (aSN1OctetString2 == null || aSN1OctetString2.getOctets().length != 9) {
            throw new IllegalArgumentException("value is null or not nine bytes long");
        }
    }

    /* renamed from: builder */
    public static C5948Builder m17289builder() {
        return new C5948Builder();
    }

    public static GroupLinkageValue getInstance(Object obj) {
        if (obj instanceof GroupLinkageValue) {
            return (GroupLinkageValue) obj;
        }
        if (obj != null) {
            return new GroupLinkageValue(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1OctetString getJValue() {
        return this.f22726jValue;
    }

    public ASN1OctetString getValue() {
        return this.f22727value;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.f22726jValue, this.f22727value);
    }

    private GroupLinkageValue(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.f22726jValue = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        this.f22727value = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
        assertValues();
    }
}
