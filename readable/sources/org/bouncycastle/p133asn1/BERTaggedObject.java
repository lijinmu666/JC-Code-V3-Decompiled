package org.bouncycastle.p133asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class BERTaggedObject extends ASN1TaggedObject {
    public BERTaggedObject(int i, int i2, int i3, ASN1Encodable aSN1Encodable) {
        super(i, i2, i3, aSN1Encodable);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        ASN1Primitive aSN1Primitive = this.f17952obj.toASN1Primitive();
        boolean zIsExplicit = isExplicit();
        if (z) {
            int i = this.tagClass;
            if (zIsExplicit || aSN1Primitive.encodeConstructed()) {
                i |= 32;
            }
            aSN1OutputStream.writeIdentifier(true, i, this.f17953tagNo);
        }
        if (!zIsExplicit) {
            aSN1Primitive.mo14417encode(aSN1OutputStream, false);
            return;
        }
        aSN1OutputStream.m14442write(128);
        aSN1Primitive.mo14417encode(aSN1OutputStream, true);
        aSN1OutputStream.m14442write(0);
        aSN1OutputStream.m14442write(0);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return isExplicit() || this.f17952obj.toASN1Primitive().encodeConstructed();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        ASN1Primitive aSN1Primitive = this.f17952obj.toASN1Primitive();
        boolean zIsExplicit = isExplicit();
        int iEncodedLength = aSN1Primitive.encodedLength(zIsExplicit);
        if (zIsExplicit) {
            iEncodedLength += 3;
        }
        return iEncodedLength + (z ? ASN1OutputStream.getLengthOfIdentifier(this.f17953tagNo) : 0);
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObject
    public ASN1Sequence rebuildConstructed(ASN1Primitive aSN1Primitive) {
        return new BERSequence(aSN1Primitive);
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObject
    public ASN1TaggedObject replaceTag(int i, int i2) {
        return new BERTaggedObject(this.explicitness, i, i2, this.f17952obj);
    }

    public BERTaggedObject(int i, int i2, ASN1Encodable aSN1Encodable) {
        super(true, i, i2, aSN1Encodable);
    }

    public BERTaggedObject(int i, ASN1Encodable aSN1Encodable) {
        super(true, i, aSN1Encodable);
    }

    public BERTaggedObject(boolean z, int i, int i2, ASN1Encodable aSN1Encodable) {
        super(z, i, i2, aSN1Encodable);
    }

    public BERTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }
}
