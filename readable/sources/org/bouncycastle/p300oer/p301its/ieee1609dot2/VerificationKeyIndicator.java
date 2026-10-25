package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccP256CurvePoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.PublicVerificationKey;

/* loaded from: classes2.dex */
public class VerificationKeyIndicator extends ASN1Object implements ASN1Choice {
    public static final int reconstructionValue = 1;
    public static final int verificationKey = 0;

    /* renamed from: choice */
    private final int f22687choice;
    private final ASN1Encodable verificationKeyIndicator;

    public VerificationKeyIndicator(int i, ASN1Encodable aSN1Encodable) {
        this.f22687choice = i;
        this.verificationKeyIndicator = aSN1Encodable;
    }

    public static VerificationKeyIndicator getInstance(Object obj) {
        if (obj instanceof VerificationKeyIndicator) {
            return (VerificationKeyIndicator) obj;
        }
        if (obj != null) {
            return new VerificationKeyIndicator(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public static VerificationKeyIndicator reconstructionValue(EccP256CurvePoint eccP256CurvePoint) {
        return new VerificationKeyIndicator(1, eccP256CurvePoint);
    }

    public static VerificationKeyIndicator verificationKey(PublicVerificationKey publicVerificationKey) {
        return new VerificationKeyIndicator(0, publicVerificationKey);
    }

    public int getChoice() {
        return this.f22687choice;
    }

    public ASN1Encodable getVerificationKeyIndicator() {
        return this.verificationKeyIndicator;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22687choice, this.verificationKeyIndicator);
    }

    private VerificationKeyIndicator(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable publicVerificationKey;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22687choice = tagNo;
        if (tagNo == 0) {
            publicVerificationKey = PublicVerificationKey.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else {
            if (tagNo != 1) {
                throw new IllegalArgumentException("invalid choice value " + tagNo);
            }
            publicVerificationKey = EccP256CurvePoint.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        }
        this.verificationKeyIndicator = publicVerificationKey;
    }
}
