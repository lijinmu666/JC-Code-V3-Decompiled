package org.bouncycastle.p133asn1.p137cmc;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes.dex */
public class CMCUnsignedData extends ASN1Object {
    private final BodyPartPath bodyPartPath;

    /* renamed from: content */
    private final ASN1Encodable f18072content;
    private final ASN1ObjectIdentifier identifier;

    private CMCUnsignedData(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.bodyPartPath = BodyPartPath.getInstance(aSN1Sequence.getObjectAt(0));
        this.identifier = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.f18072content = aSN1Sequence.getObjectAt(2);
    }

    public static CMCUnsignedData getInstance(Object obj) {
        if (obj instanceof CMCUnsignedData) {
            return (CMCUnsignedData) obj;
        }
        if (obj != null) {
            return new CMCUnsignedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BodyPartPath getBodyPartPath() {
        return this.bodyPartPath;
    }

    public ASN1Encodable getContent() {
        return this.f18072content;
    }

    public ASN1ObjectIdentifier getIdentifier() {
        return this.identifier;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.bodyPartPath);
        aSN1EncodableVector.m14420add(this.identifier);
        aSN1EncodableVector.m14420add(this.f18072content);
        return new DERSequence(aSN1EncodableVector);
    }

    public CMCUnsignedData(BodyPartPath bodyPartPath, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.bodyPartPath = bodyPartPath;
        this.identifier = aSN1ObjectIdentifier;
        this.f18072content = aSN1Encodable;
    }
}
