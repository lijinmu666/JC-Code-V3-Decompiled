package org.bouncycastle.p133asn1;

/* loaded from: classes.dex */
public class DLExternal extends ASN1External {
    @Deprecated
    public DLExternal(ASN1EncodableVector aSN1EncodableVector) {
        this((ASN1Sequence) DLFactory.createSequence(aSN1EncodableVector));
    }

    public static DLExternal fromSequence(ASN1Sequence aSN1Sequence) {
        return new DLExternal(aSN1Sequence);
    }

    public static DLExternal fromVector(ASN1EncodableVector aSN1EncodableVector) {
        return fromSequence(DLFactory.createSequence(aSN1EncodableVector));
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
            aSN1EncodableVector.m14420add(aSN1Primitive.toDLObject());
        }
        int i = this.encoding;
        aSN1EncodableVector.m14420add(new DLTaggedObject(i == 0, i, this.externalContent));
        return new DLSequence(aSN1EncodableVector);
    }

    @Override // org.bouncycastle.p133asn1.ASN1External, org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }

    public DLExternal(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Integer aSN1Integer, ASN1Primitive aSN1Primitive, int i, ASN1Primitive aSN1Primitive2) {
        super(aSN1ObjectIdentifier, aSN1Integer, aSN1Primitive, i, aSN1Primitive2);
    }

    public DLExternal(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Integer aSN1Integer, ASN1Primitive aSN1Primitive, DERTaggedObject dERTaggedObject) {
        super(aSN1ObjectIdentifier, aSN1Integer, aSN1Primitive, dERTaggedObject);
    }

    private DLExternal(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public DLExternal(DLSequence dLSequence) {
        super(dLSequence);
    }
}
