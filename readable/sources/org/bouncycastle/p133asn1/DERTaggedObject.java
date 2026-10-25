package org.bouncycastle.p133asn1;

/* loaded from: classes.dex */
public class DERTaggedObject extends ASN1TaggedObject {
    public DERTaggedObject(int i, int i2, int i3, ASN1Encodable aSN1Encodable) {
        super(i, i2, i3, aSN1Encodable);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) {
        ASN1Primitive dERObject = this.f17952obj.toASN1Primitive().toDERObject();
        boolean zIsExplicit = isExplicit();
        if (z) {
            int i = this.tagClass;
            if (zIsExplicit || dERObject.encodeConstructed()) {
                i |= 32;
            }
            aSN1OutputStream.writeIdentifier(true, i, this.f17953tagNo);
        }
        if (zIsExplicit) {
            aSN1OutputStream.m14444writeDL(dERObject.encodedLength(true));
        }
        dERObject.mo14417encode(aSN1OutputStream.getDERSubStream(), zIsExplicit);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return isExplicit() || this.f17952obj.toASN1Primitive().toDERObject().encodeConstructed();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        ASN1Primitive dERObject = this.f17952obj.toASN1Primitive().toDERObject();
        boolean zIsExplicit = isExplicit();
        int iEncodedLength = dERObject.encodedLength(zIsExplicit);
        if (zIsExplicit) {
            iEncodedLength += ASN1OutputStream.getLengthOfDL(iEncodedLength);
        }
        return iEncodedLength + (z ? ASN1OutputStream.getLengthOfIdentifier(this.f17953tagNo) : 0);
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObject
    public ASN1Sequence rebuildConstructed(ASN1Primitive aSN1Primitive) {
        return new DERSequence(aSN1Primitive);
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObject
    public ASN1TaggedObject replaceTag(int i, int i2) {
        return new DERTaggedObject(this.explicitness, i, i2, this.f17952obj);
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObject, org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return this;
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObject, org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }

    public DERTaggedObject(int i, int i2, ASN1Encodable aSN1Encodable) {
        super(true, i, i2, aSN1Encodable);
    }

    public DERTaggedObject(int i, ASN1Encodable aSN1Encodable) {
        super(true, i, aSN1Encodable);
    }

    public DERTaggedObject(boolean z, int i, int i2, ASN1Encodable aSN1Encodable) {
        super(z, i, i2, aSN1Encodable);
    }

    public DERTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }
}
