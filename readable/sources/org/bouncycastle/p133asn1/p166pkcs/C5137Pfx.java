package org.bouncycastle.p133asn1.p166pkcs;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.BERSequence;

/* renamed from: org.bouncycastle.asn1.pkcs.Pfx */
/* loaded from: classes2.dex */
public class C5137Pfx extends ASN1Object implements PKCSObjectIdentifiers {
    private ContentInfo contentInfo;

    /* renamed from: macData */
    private C5136MacData f18512macData;

    private C5137Pfx(ASN1Sequence aSN1Sequence) {
        this.f18512macData = null;
        if (!ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).hasValue(3)) {
            throw new IllegalArgumentException("wrong version for PFX PDU");
        }
        this.contentInfo = ContentInfo.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.mo14450size() == 3) {
            this.f18512macData = C5136MacData.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public static C5137Pfx getInstance(Object obj) {
        if (obj instanceof C5137Pfx) {
            return (C5137Pfx) obj;
        }
        if (obj != null) {
            return new C5137Pfx(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ContentInfo getAuthSafe() {
        return this.contentInfo;
    }

    public C5136MacData getMacData() {
        return this.f18512macData;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(ASN1Integer.f17919THREE);
        aSN1EncodableVector.m14420add(this.contentInfo);
        C5136MacData c5136MacData = this.f18512macData;
        if (c5136MacData != null) {
            aSN1EncodableVector.m14420add(c5136MacData);
        }
        return new BERSequence(aSN1EncodableVector);
    }

    public C5137Pfx(ContentInfo contentInfo, C5136MacData c5136MacData) {
        this.contentInfo = contentInfo;
        this.f18512macData = c5136MacData;
    }
}
