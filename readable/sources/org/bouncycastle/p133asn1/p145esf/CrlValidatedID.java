package org.bouncycastle.p133asn1.p145esf;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class CrlValidatedID extends ASN1Object {

    /* renamed from: crlHash */
    private OtherHash f18371crlHash;
    private CrlIdentifier crlIdentifier;

    private CrlValidatedID(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() < 1 || aSN1Sequence.mo14450size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
        this.f18371crlHash = OtherHash.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.mo14450size() > 1) {
            this.crlIdentifier = CrlIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static CrlValidatedID getInstance(Object obj) {
        if (obj instanceof CrlValidatedID) {
            return (CrlValidatedID) obj;
        }
        if (obj != null) {
            return new CrlValidatedID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public OtherHash getCrlHash() {
        return this.f18371crlHash;
    }

    public CrlIdentifier getCrlIdentifier() {
        return this.crlIdentifier;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(this.f18371crlHash.toASN1Primitive());
        CrlIdentifier crlIdentifier = this.crlIdentifier;
        if (crlIdentifier != null) {
            aSN1EncodableVector.m14420add(crlIdentifier.toASN1Primitive());
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CrlValidatedID(OtherHash otherHash) {
        this(otherHash, null);
    }

    public CrlValidatedID(OtherHash otherHash, CrlIdentifier crlIdentifier) {
        this.f18371crlHash = otherHash;
        this.crlIdentifier = crlIdentifier;
    }
}
