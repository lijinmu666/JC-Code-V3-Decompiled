package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashAlgorithm;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId8;

/* loaded from: classes2.dex */
public class IssuerIdentifier extends ASN1Object implements ASN1Choice {

    /* renamed from: self */
    public static final int f22649self = 1;
    public static final int sha256AndDigest = 0;
    public static final int sha384AndDigest = 2;

    /* renamed from: choice */
    private final int f22650choice;
    private final ASN1Encodable issuerIdentifier;

    public IssuerIdentifier(int i, ASN1Encodable aSN1Encodable) {
        this.f22650choice = i;
        this.issuerIdentifier = aSN1Encodable;
    }

    public static IssuerIdentifier getInstance(Object obj) {
        if (obj instanceof IssuerIdentifier) {
            return (IssuerIdentifier) obj;
        }
        if (obj != null) {
            return new IssuerIdentifier(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    /* renamed from: self */
    public static IssuerIdentifier m17231self(HashAlgorithm hashAlgorithm) {
        return new IssuerIdentifier(1, hashAlgorithm);
    }

    public static IssuerIdentifier sha256AndDigest(HashedId8 hashedId8) {
        return new IssuerIdentifier(0, hashedId8);
    }

    public static IssuerIdentifier sha384AndDigest(HashedId8 hashedId8) {
        return new IssuerIdentifier(2, hashedId8);
    }

    public int getChoice() {
        return this.f22650choice;
    }

    public ASN1Encodable getIssuerIdentifier() {
        return this.issuerIdentifier;
    }

    /* renamed from: isSelf */
    public boolean m17232isSelf() {
        return this.f22650choice == 1;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22650choice, this.issuerIdentifier);
    }

    private IssuerIdentifier(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable hashedId8;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22650choice = tagNo;
        ASN1Object explicitBaseObject = aSN1TaggedObject.getExplicitBaseObject();
        if (tagNo == 0) {
            hashedId8 = HashedId8.getInstance(explicitBaseObject);
        } else if (tagNo != 1) {
            if (tagNo != 2) {
                throw new IllegalArgumentException("invalid choice value " + tagNo);
            }
            hashedId8 = HashedId8.getInstance(explicitBaseObject);
        } else {
            hashedId8 = HashAlgorithm.getInstance((Object) explicitBaseObject);
        }
        this.issuerIdentifier = hashedId8;
    }
}
