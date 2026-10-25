package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class BasePublicEncryptionKey extends ASN1Object implements ASN1Choice {
    public static final int eciesBrainpoolP256r1 = 1;
    public static final int eciesNistP256 = 0;
    private final ASN1Encodable basePublicEncryptionKey;

    /* renamed from: choice */
    private final int f22688choice;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.BasePublicEncryptionKey$Builder */
    public static class C5940Builder {

        /* renamed from: choice */
        private int f22689choice;

        /* renamed from: value */
        private ASN1Encodable f22690value;

        public BasePublicEncryptionKey createBasePublicEncryptionKey() {
            return new BasePublicEncryptionKey(this.f22689choice, this.f22690value);
        }

        public C5940Builder setChoice(int i) {
            this.f22689choice = i;
            return this;
        }

        public C5940Builder setValue(EccCurvePoint eccCurvePoint) {
            this.f22690value = eccCurvePoint;
            return this;
        }
    }

    public BasePublicEncryptionKey(int i, ASN1Encodable aSN1Encodable) {
        this.f22688choice = i;
        this.basePublicEncryptionKey = aSN1Encodable;
    }

    public static BasePublicEncryptionKey eciesBrainpoolP256r1(EccP256CurvePoint eccP256CurvePoint) {
        return new BasePublicEncryptionKey(1, eccP256CurvePoint);
    }

    public static BasePublicEncryptionKey eciesNistP256(EccP256CurvePoint eccP256CurvePoint) {
        return new BasePublicEncryptionKey(0, eccP256CurvePoint);
    }

    public static BasePublicEncryptionKey getInstance(Object obj) {
        if (obj instanceof BasePublicEncryptionKey) {
            return (BasePublicEncryptionKey) obj;
        }
        if (obj != null) {
            return new BasePublicEncryptionKey(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public ASN1Encodable getBasePublicEncryptionKey() {
        return this.basePublicEncryptionKey;
    }

    public int getChoice() {
        return this.f22688choice;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22688choice, this.basePublicEncryptionKey);
    }

    private BasePublicEncryptionKey(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22688choice = tagNo;
        if (tagNo == 0 || tagNo == 1) {
            this.basePublicEncryptionKey = EccP256CurvePoint.getInstance(aSN1TaggedObject.getExplicitBaseObject());
            return;
        }
        throw new IllegalArgumentException("invalid choice value " + aSN1TaggedObject.getTagNo());
    }
}
