package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.Hostname;

/* loaded from: classes2.dex */
public class CertificateId extends ASN1Object implements ASN1Choice {
    public static final int binaryId = 2;
    public static final int linkageData = 0;

    /* renamed from: name */
    public static final int f22634name = 1;

    /* renamed from: none */
    public static final int f22635none = 3;
    private final ASN1Encodable certificateId;

    /* renamed from: choice */
    private final int f22636choice;

    public CertificateId(int i, ASN1Encodable aSN1Encodable) {
        this.f22636choice = i;
        this.certificateId = aSN1Encodable;
    }

    public static CertificateId binaryId(ASN1OctetString aSN1OctetString) {
        return new CertificateId(2, aSN1OctetString);
    }

    public static CertificateId getInstance(Object obj) {
        if (obj instanceof CertificateId) {
            return (CertificateId) obj;
        }
        if (obj != null) {
            return new CertificateId(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public static CertificateId linkageData(LinkageData linkageData2) {
        return new CertificateId(0, linkageData2);
    }

    /* renamed from: name */
    public static CertificateId m17219name(Hostname hostname) {
        return new CertificateId(1, hostname);
    }

    /* renamed from: none */
    public static CertificateId m17220none() {
        return new CertificateId(3, C5103DERNull.INSTANCE);
    }

    public ASN1Encodable getCertificateId() {
        return this.certificateId;
    }

    public int getChoice() {
        return this.f22636choice;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22636choice, this.certificateId).toASN1Primitive();
    }

    private CertificateId(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable linkageData2;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22636choice = tagNo;
        if (tagNo == 0) {
            linkageData2 = LinkageData.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else if (tagNo == 1) {
            linkageData2 = Hostname.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else if (tagNo == 2) {
            linkageData2 = ASN1OctetString.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else {
            if (tagNo != 3) {
                throw new IllegalArgumentException("invalid choice value " + tagNo);
            }
            linkageData2 = ASN1Null.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        }
        this.certificateId = linkageData2;
    }

    public static CertificateId binaryId(byte[] bArr) {
        return new CertificateId(2, new DEROctetString(bArr));
    }
}
