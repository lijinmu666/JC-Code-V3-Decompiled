package org.bouncycastle.p133asn1;

/* loaded from: classes.dex */
public class DERExternal extends ASN1External {
    @Deprecated
    public DERExternal(ASN1EncodableVector aSN1EncodableVector) {
        this((ASN1Sequence) DERFactory.createSequence(aSN1EncodableVector));
    }

    public static DERExternal fromSequence(ASN1Sequence aSN1Sequence) {
        return new DERExternal(aSN1Sequence);
    }

    public static DERExternal fromVector(ASN1EncodableVector aSN1EncodableVector) {
        return fromSequence(DERFactory.createSequence(aSN1EncodableVector));
    }

    @Override // org.bouncycastle.p133asn1.ASN1External
    public ASN1Sequence buildSequence() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.directReference;
        if (aSN1ObjectIdentifier != null) {
            aSN1EncodableVector.m14420add(aSN1ObjectIdentifier);
        }
        ASN1Integer aSN1Integer = this.indirectReference;
        if (aSN1Integer != null) {
            aSN1EncodableVector.m14420add(aSN1Integer);
        }
        ASN1Primitive aSN1Primitive = this.dataValueDescriptor;
        if (aSN1Primitive != null) {
            aSN1EncodableVector.m14420add(aSN1Primitive.toDERObject());
        }
        int i = this.encoding;
        aSN1EncodableVector.m14420add(new DERTaggedObject(i == 0, i, this.externalContent));
        return new DERSequence(aSN1EncodableVector);
    }

    @Override // org.bouncycastle.p133asn1.ASN1External, org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return this;
    }

    @Override // org.bouncycastle.p133asn1.ASN1External, org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }

    public DERExternal(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Integer aSN1Integer, ASN1Primitive aSN1Primitive, int i, ASN1Primitive aSN1Primitive2) {
        super(aSN1ObjectIdentifier, aSN1Integer, aSN1Primitive, i, aSN1Primitive2);
    }

    public DERExternal(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Integer aSN1Integer, ASN1Primitive aSN1Primitive, DERTaggedObject dERTaggedObject) {
        super(aSN1ObjectIdentifier, aSN1Integer, aSN1Primitive, dERTaggedObject);
    }

    public DERExternal(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public DERExternal(DERSequence dERSequence) {
        super(dERSequence);
    }
}
