package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class HashedData extends ASN1Object implements ASN1Choice {
    public static final int reserved = 2;
    public static final int sha256HashedData = 0;
    public static final int sha384HashedData = 1;

    /* renamed from: choice */
    private final int f22642choice;
    private final ASN1Encodable hashedData;

    public HashedData(int i, ASN1Encodable aSN1Encodable) {
        this.f22642choice = i;
        this.hashedData = aSN1Encodable;
    }

    public static HashedData getInstance(Object obj) {
        if (obj instanceof HashedData) {
            return (HashedData) obj;
        }
        if (obj != null) {
            return new HashedData(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public static HashedData reserved(ASN1OctetString aSN1OctetString) {
        return new HashedData(2, aSN1OctetString);
    }

    public static HashedData sha256HashedData(ASN1OctetString aSN1OctetString) {
        return new HashedData(0, aSN1OctetString);
    }

    public static HashedData sha384HashedData(ASN1OctetString aSN1OctetString) {
        return new HashedData(1, aSN1OctetString);
    }

    public int getChoice() {
        return this.f22642choice;
    }

    public ASN1Encodable getHashedData() {
        return this.hashedData;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22642choice, this.hashedData);
    }

    private HashedData(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0 || tagNo == 1 || tagNo == 2) {
            this.f22642choice = aSN1TaggedObject.getTagNo();
            this.hashedData = ASN1OctetString.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else {
            throw new IllegalArgumentException("invalid choice value " + aSN1TaggedObject.getTagNo());
        }
    }

    public static HashedData reserved(byte[] bArr) {
        return new HashedData(2, new DEROctetString(C6238Arrays.m18231clone(bArr)));
    }

    public static HashedData sha256HashedData(byte[] bArr) {
        return new HashedData(0, new DEROctetString(C6238Arrays.m18231clone(bArr)));
    }

    public static HashedData sha384HashedData(byte[] bArr) {
        return new HashedData(1, new DEROctetString(C6238Arrays.m18231clone(bArr)));
    }
}
