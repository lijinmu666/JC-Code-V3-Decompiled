package org.bouncycastle.p300oer.p301its.etsi102941.basetypes;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097DataEncrypted;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097DataSignedExternalPayload;

/* loaded from: classes2.dex */
public class EcSignature extends ASN1Object implements ASN1Choice {
    public static final int ecSignature = 1;
    public static final int encryptedEcSignature = 0;
    private final ASN1Encodable _ecSignature;

    /* renamed from: choice */
    private final int f22618choice;

    public EcSignature(int i, ASN1Encodable aSN1Encodable) {
        this.f22618choice = i;
        this._ecSignature = aSN1Encodable;
    }

    public static EcSignature getInstance(Object obj) {
        if (obj instanceof EcSignature) {
            return (EcSignature) obj;
        }
        if (obj != null) {
            return new EcSignature(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public int getChoice() {
        return this.f22618choice;
    }

    public ASN1Encodable getEcSignature() {
        return this._ecSignature;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22618choice, this._ecSignature);
    }

    private EcSignature(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable etsiTs103097DataEncrypted;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22618choice = tagNo;
        if (tagNo == 0) {
            etsiTs103097DataEncrypted = EtsiTs103097DataEncrypted.getInstance((Object) aSN1TaggedObject.getExplicitBaseObject());
        } else {
            if (tagNo != 1) {
                throw new IllegalArgumentException("invalid choice value " + tagNo);
            }
            etsiTs103097DataEncrypted = EtsiTs103097DataSignedExternalPayload.getInstance((Object) aSN1TaggedObject.getExplicitBaseObject());
        }
        this._ecSignature = etsiTs103097DataEncrypted;
    }
}
