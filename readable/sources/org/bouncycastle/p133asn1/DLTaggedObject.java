package org.bouncycastle.p133asn1;

/* loaded from: classes.dex */
public class DLTaggedObject extends ASN1TaggedObject {
    public DLTaggedObject(int i, int i2, int i3, ASN1Encodable aSN1Encodable) {
        super(i, i2, i3, aSN1Encodable);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) {
        ASN1Primitive dLObject = this.f17952obj.toASN1Primitive().toDLObject();
        boolean zIsExplicit = isExplicit();
        if (z) {
            int i = this.tagClass;
            if (zIsExplicit || dLObject.encodeConstructed()) {
                i |= 32;
            }
            aSN1OutputStream.writeIdentifier(true, i, this.f17953tagNo);
        }
        if (zIsExplicit) {
            aSN1OutputStream.m14444writeDL(dLObject.encodedLength(true));
        }
        dLObject.mo14417encode(aSN1OutputStream.getDLSubStream(), zIsExplicit);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return isExplicit() || this.f17952obj.toASN1Primitive().toDLObject().encodeConstructed();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        ASN1Primitive dLObject = this.f17952obj.toASN1Primitive().toDLObject();
        boolean zIsExplicit = isExplicit();
        int iEncodedLength = dLObject.encodedLength(zIsExplicit);
        if (zIsExplicit) {
            iEncodedLength += ASN1OutputStream.getLengthOfDL(iEncodedLength);
        }
        return iEncodedLength + (z ? ASN1OutputStream.getLengthOfIdentifier(this.f17953tagNo) : 0);
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObject
    public ASN1Sequence rebuildConstructed(ASN1Primitive aSN1Primitive) {
        return new DLSequence(aSN1Primitive);
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObject
    public ASN1TaggedObject replaceTag(int i, int i2) {
        return new DLTaggedObject(this.explicitness, i, i2, this.f17952obj);
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObject, org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }

    public DLTaggedObject(int i, int i2, ASN1Encodable aSN1Encodable) {
        super(true, i, i2, aSN1Encodable);
    }

    public DLTaggedObject(int i, ASN1Encodable aSN1Encodable) {
        super(true, i, aSN1Encodable);
    }

    public DLTaggedObject(boolean z, int i, int i2, ASN1Encodable aSN1Encodable) {
        super(z, i, i2, aSN1Encodable);
    }

    public DLTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }
}
