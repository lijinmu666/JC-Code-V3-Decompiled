package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes.dex */
public class KEKIdentifier extends ASN1Object {

    /* renamed from: date */
    private ASN1GeneralizedTime f18196date;
    private ASN1OctetString keyIdentifier;

    /* renamed from: other */
    private OtherKeyAttribute f18197other;

    private KEKIdentifier(ASN1Sequence aSN1Sequence) {
        ASN1Encodable objectAt;
        this.keyIdentifier = (ASN1OctetString) aSN1Sequence.getObjectAt(0);
        int iMo14450size = aSN1Sequence.mo14450size();
        if (iMo14450size != 1) {
            if (iMo14450size == 2) {
                boolean z = aSN1Sequence.getObjectAt(1) instanceof ASN1GeneralizedTime;
                objectAt = aSN1Sequence.getObjectAt(1);
                if (z) {
                    this.f18196date = (ASN1GeneralizedTime) objectAt;
                    return;
                }
            } else {
                if (iMo14450size != 3) {
                    throw new IllegalArgumentException("Invalid KEKIdentifier");
                }
                this.f18196date = (ASN1GeneralizedTime) aSN1Sequence.getObjectAt(1);
                objectAt = aSN1Sequence.getObjectAt(2);
            }
            this.f18197other = OtherKeyAttribute.getInstance(objectAt);
        }
    }

    public static KEKIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof KEKIdentifier)) {
            return (KEKIdentifier) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new KEKIdentifier((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid KEKIdentifier: " + obj.getClass().getName());
    }

    /* renamed from: getDate */
    public ASN1GeneralizedTime m14541getDate() {
        return this.f18196date;
    }

    public ASN1OctetString getKeyIdentifier() {
        return this.keyIdentifier;
    }

    public OtherKeyAttribute getOther() {
        return this.f18197other;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.keyIdentifier);
        ASN1GeneralizedTime aSN1GeneralizedTime = this.f18196date;
        if (aSN1GeneralizedTime != null) {
            aSN1EncodableVector.m14420add(aSN1GeneralizedTime);
        }
        OtherKeyAttribute otherKeyAttribute = this.f18197other;
        if (otherKeyAttribute != null) {
            aSN1EncodableVector.m14420add(otherKeyAttribute);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public KEKIdentifier(byte[] bArr, ASN1GeneralizedTime aSN1GeneralizedTime, OtherKeyAttribute otherKeyAttribute) {
        this.keyIdentifier = new DEROctetString(bArr);
        this.f18196date = aSN1GeneralizedTime;
        this.f18197other = otherKeyAttribute;
    }

    public static KEKIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
