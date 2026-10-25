package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class SymmetricCiphertext extends ASN1Object implements ASN1Choice {
    public static final int aes128ccm = 0;

    /* renamed from: choice */
    private final int f22678choice;
    private final ASN1Encodable symmetricCiphertext;

    public SymmetricCiphertext(int i, ASN1Encodable aSN1Encodable) {
        this.f22678choice = i;
        this.symmetricCiphertext = aSN1Encodable;
    }

    public static SymmetricCiphertext aes128ccm(AesCcmCiphertext aesCcmCiphertext) {
        return new SymmetricCiphertext(0, aesCcmCiphertext);
    }

    public static SymmetricCiphertext getInstance(Object obj) {
        if (obj instanceof SymmetricCiphertext) {
            return (SymmetricCiphertext) obj;
        }
        if (obj != null) {
            return new SymmetricCiphertext(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public int getChoice() {
        return this.f22678choice;
    }

    public ASN1Encodable getSymmetricCiphertext() {
        return this.symmetricCiphertext;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22678choice, this.symmetricCiphertext);
    }

    private SymmetricCiphertext(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22678choice = tagNo;
        if (tagNo == 0) {
            this.symmetricCiphertext = AesCcmCiphertext.getInstance(aSN1TaggedObject.getExplicitBaseObject());
            return;
        }
        throw new IllegalArgumentException("invalid choice value " + tagNo);
    }
}
