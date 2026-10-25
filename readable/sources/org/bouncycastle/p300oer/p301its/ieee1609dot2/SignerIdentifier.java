package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId8;

/* loaded from: classes2.dex */
public class SignerIdentifier extends ASN1Object implements ASN1Choice {
    public static final int certificate = 1;

    /* renamed from: digest */
    public static final int f22671digest = 0;

    /* renamed from: self */
    public static final int f22672self = 2;

    /* renamed from: choice */
    private final int f22673choice;
    private final ASN1Encodable signerIdentifier;

    public SignerIdentifier(int i, ASN1Encodable aSN1Encodable) {
        this.f22673choice = i;
        this.signerIdentifier = aSN1Encodable;
    }

    public static SignerIdentifier certificate(SequenceOfCertificate sequenceOfCertificate) {
        return new SignerIdentifier(1, sequenceOfCertificate);
    }

    /* renamed from: digest */
    public static SignerIdentifier m17246digest(HashedId8 hashedId8) {
        return new SignerIdentifier(0, hashedId8);
    }

    public static SignerIdentifier getInstance(Object obj) {
        if (obj instanceof SignerIdentifier) {
            return (SignerIdentifier) obj;
        }
        if (obj != null) {
            return new SignerIdentifier(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    /* renamed from: self */
    public static SignerIdentifier m17247self() {
        return new SignerIdentifier(2, C5103DERNull.INSTANCE);
    }

    public int getChoice() {
        return this.f22673choice;
    }

    public ASN1Encodable getSignerIdentifier() {
        return this.signerIdentifier;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22673choice, this.signerIdentifier);
    }

    private SignerIdentifier(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable hashedId8;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22673choice = tagNo;
        if (tagNo == 0) {
            hashedId8 = HashedId8.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else if (tagNo == 1) {
            hashedId8 = SequenceOfCertificate.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else {
            if (tagNo != 2) {
                throw new IllegalArgumentException("invalid choice value " + tagNo);
            }
            hashedId8 = ASN1Null.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        }
        this.signerIdentifier = hashedId8;
    }
}
