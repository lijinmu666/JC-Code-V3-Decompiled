package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class Ieee1609Dot2Content extends ASN1Object implements ASN1Choice {
    public static final int encryptedData = 2;
    public static final int signedCertificateRequest = 3;
    public static final int signedData = 1;
    public static final int unsecuredData = 0;

    /* renamed from: choice */
    private final int f22646choice;
    private final ASN1Encodable ieee1609Dot2Content;

    public Ieee1609Dot2Content(int i, ASN1Encodable aSN1Encodable) {
        this.f22646choice = i;
        this.ieee1609Dot2Content = aSN1Encodable;
    }

    public static Ieee1609Dot2Content encryptedData(EncryptedData encryptedData2) {
        return new Ieee1609Dot2Content(2, encryptedData2);
    }

    public static Ieee1609Dot2Content getInstance(Object obj) {
        if (obj instanceof Ieee1609Dot2Content) {
            return (Ieee1609Dot2Content) obj;
        }
        if (obj != null) {
            return new Ieee1609Dot2Content(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public static Ieee1609Dot2Content signedCertificateRequest(C5929Opaque c5929Opaque) {
        return new Ieee1609Dot2Content(3, c5929Opaque);
    }

    public static Ieee1609Dot2Content signedData(SignedData signedData2) {
        return new Ieee1609Dot2Content(1, signedData2);
    }

    public static Ieee1609Dot2Content unsecuredData(C5929Opaque c5929Opaque) {
        return new Ieee1609Dot2Content(0, c5929Opaque);
    }

    public int getChoice() {
        return this.f22646choice;
    }

    public ASN1Encodable getIeee1609Dot2Content() {
        return this.ieee1609Dot2Content;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22646choice, this.ieee1609Dot2Content);
    }

    private Ieee1609Dot2Content(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable c5929Opaque;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22646choice = tagNo;
        if (tagNo == 0) {
            c5929Opaque = C5929Opaque.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else if (tagNo == 1) {
            c5929Opaque = SignedData.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else if (tagNo != 2) {
            if (tagNo != 3) {
                throw new IllegalArgumentException("invalid choice value " + aSN1TaggedObject.getTagNo());
            }
            c5929Opaque = C5929Opaque.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else {
            c5929Opaque = EncryptedData.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        }
        this.ieee1609Dot2Content = c5929Opaque;
    }

    public static Ieee1609Dot2Content signedCertificateRequest(byte[] bArr) {
        return new Ieee1609Dot2Content(3, new DEROctetString(C6238Arrays.m18231clone(bArr)));
    }

    public static Ieee1609Dot2Content unsecuredData(byte[] bArr) {
        return new Ieee1609Dot2Content(0, new DEROctetString(C6238Arrays.m18231clone(bArr)));
    }
}
