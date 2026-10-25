package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class PublicVerificationKey extends ASN1Object implements ASN1Choice {
    public static final int ecdsaBrainpoolP256r1 = 1;
    public static final int ecdsaBrainpoolP384r1 = 2;
    public static final int ecdsaNistP256 = 0;

    /* renamed from: choice */
    private final int f22755choice;
    private final ASN1Encodable publicVerificationKey;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.PublicVerificationKey$Builder */
    public static class C5958Builder {

        /* renamed from: choice */
        private int f22756choice;
        private ASN1Encodable curvePoint;

        public PublicVerificationKey createPublicVerificationKey() {
            return new PublicVerificationKey(this.f22756choice, this.curvePoint);
        }

        public C5958Builder ecdsaBrainpoolP256r1(EccP256CurvePoint eccP256CurvePoint) {
            this.curvePoint = eccP256CurvePoint;
            return this;
        }

        public C5958Builder ecdsaBrainpoolP384r1(EccP384CurvePoint eccP384CurvePoint) {
            this.curvePoint = eccP384CurvePoint;
            return this;
        }

        public C5958Builder ecdsaNistP256(EccP256CurvePoint eccP256CurvePoint) {
            this.curvePoint = eccP256CurvePoint;
            return this;
        }

        public C5958Builder extension(byte[] bArr) {
            this.curvePoint = new DEROctetString(bArr);
            return this;
        }

        public C5958Builder setChoice(int i) {
            this.f22756choice = i;
            return this;
        }

        public C5958Builder setCurvePoint(EccCurvePoint eccCurvePoint) {
            this.curvePoint = eccCurvePoint;
            return this;
        }
    }

    public PublicVerificationKey(int i, ASN1Encodable aSN1Encodable) {
        this.f22755choice = i;
        this.publicVerificationKey = aSN1Encodable;
    }

    /* renamed from: builder */
    public static C5958Builder m17320builder() {
        return new C5958Builder();
    }

    public static PublicVerificationKey ecdsaBrainpoolP256r1(EccP256CurvePoint eccP256CurvePoint) {
        return new PublicVerificationKey(1, eccP256CurvePoint);
    }

    public static PublicVerificationKey ecdsaBrainpoolP384r1(EccP384CurvePoint eccP384CurvePoint) {
        return new PublicVerificationKey(2, eccP384CurvePoint);
    }

    public static PublicVerificationKey ecdsaNistP256(EccP256CurvePoint eccP256CurvePoint) {
        return new PublicVerificationKey(0, eccP256CurvePoint);
    }

    public static PublicVerificationKey getInstance(Object obj) {
        if (obj instanceof PublicVerificationKey) {
            return (PublicVerificationKey) obj;
        }
        if (obj != null) {
            return new PublicVerificationKey(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public int getChoice() {
        return this.f22755choice;
    }

    public ASN1Encodable getPublicVerificationKey() {
        return this.publicVerificationKey;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22755choice, this.publicVerificationKey);
    }

    private PublicVerificationKey(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable eccP256CurvePoint;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22755choice = tagNo;
        if (tagNo == 0 || tagNo == 1) {
            eccP256CurvePoint = EccP256CurvePoint.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else {
            if (tagNo != 2) {
                throw new IllegalArgumentException("invalid choice value " + aSN1TaggedObject.getTagNo());
            }
            eccP256CurvePoint = EccP384CurvePoint.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        }
        this.publicVerificationKey = eccP256CurvePoint;
    }
}
