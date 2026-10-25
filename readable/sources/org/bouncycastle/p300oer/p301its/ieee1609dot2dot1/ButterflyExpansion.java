package org.bouncycastle.p300oer.p301its.ieee1609dot2dot1;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class ButterflyExpansion extends ASN1Object implements ASN1Choice {

    /* renamed from: aes128 */
    public static final int f22785aes128 = 0;
    protected final ASN1Encodable butterflyExpansion;

    /* renamed from: choice */
    protected final int f22786choice;

    public ButterflyExpansion(int i, ASN1Encodable aSN1Encodable) {
        this.f22786choice = i;
        this.butterflyExpansion = aSN1Encodable;
    }

    /* renamed from: aes128 */
    public static ButterflyExpansion m17349aes128(ASN1OctetString aSN1OctetString) {
        return m17350aes128(aSN1OctetString.getOctets());
    }

    public static ButterflyExpansion getInstance(Object obj) {
        if (obj instanceof ButterflyExpansion) {
            return (ButterflyExpansion) obj;
        }
        if (obj != null) {
            return new ButterflyExpansion(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public ASN1Encodable getButterflyExpansion() {
        return this.butterflyExpansion;
    }

    public int getChoice() {
        return this.f22786choice;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22786choice, this.butterflyExpansion);
    }

    private ButterflyExpansion(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22786choice = tagNo;
        if (tagNo == 0) {
            this.butterflyExpansion = ASN1OctetString.getInstance(aSN1TaggedObject.getExplicitBaseObject());
            return;
        }
        throw new IllegalArgumentException("invalid choice value " + tagNo);
    }

    /* renamed from: aes128 */
    public static ButterflyExpansion m17350aes128(byte[] bArr) {
        if (bArr.length == 16) {
            return new ButterflyExpansion(0, new DEROctetString(bArr));
        }
        throw new IllegalArgumentException("length must be 16");
    }
}
