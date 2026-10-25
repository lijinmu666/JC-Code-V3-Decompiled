package org.bouncycastle.p133asn1.p164ocsp;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.ASN1Util;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class CertStatus extends ASN1Object implements ASN1Choice {

    /* renamed from: tagNo */
    private int f18436tagNo;

    /* renamed from: value */
    private ASN1Encodable f18437value;

    public CertStatus() {
        this.f18436tagNo = 0;
        this.f18437value = C5103DERNull.INSTANCE;
    }

    public static CertStatus getInstance(Object obj) {
        if (obj == null || (obj instanceof CertStatus)) {
            return (CertStatus) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new CertStatus((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public ASN1Encodable getStatus() {
        return this.f18437value;
    }

    public int getTagNo() {
        return this.f18436tagNo;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.f18436tagNo, this.f18437value);
    }

    public CertStatus(int i, ASN1Encodable aSN1Encodable) {
        this.f18436tagNo = i;
        this.f18437value = aSN1Encodable;
    }

    public static CertStatus getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getExplicitBaseTagged());
    }

    private CertStatus(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable aSN1Null;
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            aSN1Null = ASN1Null.getInstance(aSN1TaggedObject, false);
        } else if (tagNo != 1) {
            if (tagNo != 2) {
                throw new IllegalArgumentException("Unknown tag encountered: " + ASN1Util.getTagText(aSN1TaggedObject));
            }
            aSN1Null = ASN1Null.getInstance(aSN1TaggedObject, false);
        } else {
            aSN1Null = RevokedInfo.getInstance(aSN1TaggedObject, false);
        }
        this.f18437value = aSN1Null;
        this.f18436tagNo = tagNo;
    }

    public CertStatus(RevokedInfo revokedInfo) {
        this.f18436tagNo = 1;
        this.f18437value = revokedInfo;
    }
}
