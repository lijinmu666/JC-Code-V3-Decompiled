package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class Signature extends ASN1Object implements ASN1Choice {
    public static final int ecdsaBrainpoolP256r1Signature = 1;
    public static final int ecdsaBrainpoolP384r1Signature = 2;
    public static final int ecdsaNistP256Signature = 0;

    /* renamed from: choice */
    private final int f22770choice;
    private final ASN1Encodable signature;

    public Signature(int i, ASN1Encodable aSN1Encodable) {
        this.f22770choice = i;
        this.signature = aSN1Encodable;
    }

    public static Signature ecdsaBrainpoolP256r1Signature(EcdsaP256Signature ecdsaP256Signature) {
        return new Signature(1, ecdsaP256Signature);
    }

    public static Signature ecdsaBrainpoolP384r1Signature(EcdsaP384Signature ecdsaP384Signature) {
        return new Signature(2, ecdsaP384Signature);
    }

    public static Signature ecdsaNistP256Signature(EcdsaP256Signature ecdsaP256Signature) {
        return new Signature(0, ecdsaP256Signature);
    }

    public static Signature getInstance(Object obj) {
        if (obj instanceof Signature) {
            return (Signature) obj;
        }
        if (obj != null) {
            return new Signature(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public int getChoice() {
        return this.f22770choice;
    }

    public ASN1Encodable getSignature() {
        return this.signature;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22770choice, this.signature);
    }

    private Signature(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable ecdsaP256Signature;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22770choice = tagNo;
        if (tagNo == 0 || tagNo == 1) {
            ecdsaP256Signature = EcdsaP256Signature.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else {
            if (tagNo != 2) {
                throw new IllegalArgumentException("invalid choice value " + aSN1TaggedObject.getTagNo());
            }
            ecdsaP256Signature = EcdsaP384Signature.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        }
        this.signature = ecdsaP256Signature;
    }
}
