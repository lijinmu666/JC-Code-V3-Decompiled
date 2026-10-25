package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* renamed from: org.bouncycastle.asn1.x509.Target */
/* loaded from: classes2.dex */
public class C5192Target extends ASN1Object implements ASN1Choice {
    public static final int targetGroup = 1;
    public static final int targetName = 0;
    private GeneralName targGroup;
    private GeneralName targName;

    public C5192Target(int i, GeneralName generalName) {
        this(new DERTaggedObject(i, generalName));
    }

    public static C5192Target getInstance(Object obj) {
        if (obj == null || (obj instanceof C5192Target)) {
            return (C5192Target) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new C5192Target((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass());
    }

    public GeneralName getTargetGroup() {
        return this.targGroup;
    }

    public GeneralName getTargetName() {
        return this.targName;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        GeneralName generalName = this.targName;
        return generalName != null ? new DERTaggedObject(true, 0, (ASN1Encodable) generalName) : new DERTaggedObject(true, 1, (ASN1Encodable) this.targGroup);
    }

    private C5192Target(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            this.targName = GeneralName.getInstance(aSN1TaggedObject, true);
        } else {
            if (tagNo == 1) {
                this.targGroup = GeneralName.getInstance(aSN1TaggedObject, true);
                return;
            }
            throw new IllegalArgumentException("unknown tag: " + aSN1TaggedObject.getTagNo());
        }
    }
}
