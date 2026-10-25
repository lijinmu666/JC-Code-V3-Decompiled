package org.bouncycastle.p133asn1.p139cms;

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
public class RecipientKeyIdentifier extends ASN1Object {

    /* renamed from: date */
    private ASN1GeneralizedTime f18219date;

    /* renamed from: other */
    private OtherKeyAttribute f18220other;
    private ASN1OctetString subjectKeyIdentifier;

    public RecipientKeyIdentifier(ASN1OctetString aSN1OctetString, ASN1GeneralizedTime aSN1GeneralizedTime, OtherKeyAttribute otherKeyAttribute) {
        this.subjectKeyIdentifier = aSN1OctetString;
        this.f18219date = aSN1GeneralizedTime;
        this.f18220other = otherKeyAttribute;
    }

    public static RecipientKeyIdentifier getInstance(Object obj) {
        if (obj instanceof RecipientKeyIdentifier) {
            return (RecipientKeyIdentifier) obj;
        }
        if (obj != null) {
            return new RecipientKeyIdentifier(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getDate */
    public ASN1GeneralizedTime m14552getDate() {
        return this.f18219date;
    }

    public OtherKeyAttribute getOtherKeyAttribute() {
        return this.f18220other;
    }

    public ASN1OctetString getSubjectKeyIdentifier() {
        return this.subjectKeyIdentifier;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.subjectKeyIdentifier);
        ASN1GeneralizedTime aSN1GeneralizedTime = this.f18219date;
        if (aSN1GeneralizedTime != null) {
            aSN1EncodableVector.m14420add(aSN1GeneralizedTime);
        }
        OtherKeyAttribute otherKeyAttribute = this.f18220other;
        if (otherKeyAttribute != null) {
            aSN1EncodableVector.m14420add(otherKeyAttribute);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private RecipientKeyIdentifier(ASN1Sequence aSN1Sequence) {
        this.subjectKeyIdentifier = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        int iMo14450size = aSN1Sequence.mo14450size();
        if (iMo14450size != 1) {
            if (iMo14450size != 2) {
                if (iMo14450size != 3) {
                    throw new IllegalArgumentException("Invalid RecipientKeyIdentifier");
                }
                this.f18219date = ASN1GeneralizedTime.getInstance(aSN1Sequence.getObjectAt(1));
            } else if (aSN1Sequence.getObjectAt(1) instanceof ASN1GeneralizedTime) {
                this.f18219date = ASN1GeneralizedTime.getInstance(aSN1Sequence.getObjectAt(1));
                return;
            }
            this.f18220other = OtherKeyAttribute.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public static RecipientKeyIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public RecipientKeyIdentifier(byte[] bArr) {
        this(bArr, (ASN1GeneralizedTime) null, (OtherKeyAttribute) null);
    }

    public RecipientKeyIdentifier(byte[] bArr, ASN1GeneralizedTime aSN1GeneralizedTime, OtherKeyAttribute otherKeyAttribute) {
        this.subjectKeyIdentifier = new DEROctetString(bArr);
        this.f18219date = aSN1GeneralizedTime;
        this.f18220other = otherKeyAttribute;
    }
}
