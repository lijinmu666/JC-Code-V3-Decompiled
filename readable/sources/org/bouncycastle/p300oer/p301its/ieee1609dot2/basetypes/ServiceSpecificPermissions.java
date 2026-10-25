package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.C5929Opaque;

/* loaded from: classes2.dex */
public class ServiceSpecificPermissions extends ASN1Object implements ASN1Choice {
    public static final int bitmapSsp = 1;

    /* renamed from: opaque */
    public static final int f22768opaque = 0;

    /* renamed from: choice */
    private final int f22769choice;
    private final ASN1Encodable serviceSpecificPermissions;

    public ServiceSpecificPermissions(int i, ASN1Encodable aSN1Encodable) {
        this.f22769choice = i;
        this.serviceSpecificPermissions = aSN1Encodable;
    }

    public static ServiceSpecificPermissions bitmapSsp(BitmapSsp bitmapSsp2) {
        return new ServiceSpecificPermissions(1, bitmapSsp2);
    }

    public static ServiceSpecificPermissions getInstance(Object obj) {
        if (obj instanceof ServiceSpecificPermissions) {
            return (ServiceSpecificPermissions) obj;
        }
        if (obj != null) {
            return new ServiceSpecificPermissions(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    /* renamed from: opaque */
    public static ServiceSpecificPermissions m17338opaque(ASN1OctetString aSN1OctetString) {
        return new ServiceSpecificPermissions(0, aSN1OctetString);
    }

    public int getChoice() {
        return this.f22769choice;
    }

    public ASN1Encodable getServiceSpecificPermissions() {
        return this.serviceSpecificPermissions;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22769choice, this.serviceSpecificPermissions);
    }

    private ServiceSpecificPermissions(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable c5929Opaque;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22769choice = tagNo;
        if (tagNo == 0) {
            c5929Opaque = C5929Opaque.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else {
            if (tagNo != 1) {
                throw new IllegalArgumentException("invalid choice value " + tagNo);
            }
            c5929Opaque = BitmapSsp.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        }
        this.serviceSpecificPermissions = c5929Opaque;
    }

    /* renamed from: opaque */
    public static ServiceSpecificPermissions m17339opaque(byte[] bArr) {
        return new ServiceSpecificPermissions(0, new DEROctetString(bArr));
    }
}
