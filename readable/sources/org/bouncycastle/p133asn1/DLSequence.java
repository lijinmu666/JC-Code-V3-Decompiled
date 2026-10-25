package org.bouncycastle.p133asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class DLSequence extends ASN1Sequence {

    /* renamed from: EMPTY */
    public static final DLSequence f17998EMPTY = new DLSequence();
    private int contentsLength;

    public DLSequence() {
        this.contentsLength = -1;
    }

    /* renamed from: convert */
    public static DLSequence m14477convert(ASN1Sequence aSN1Sequence) {
        return (DLSequence) aSN1Sequence.toDLObject();
    }

    public static DLSequence fromElementsOptional(ASN1Encodable[] aSN1EncodableArr) {
        if (aSN1EncodableArr == null) {
            return null;
        }
        return aSN1EncodableArr.length < 1 ? f17998EMPTY : new DLSequence(aSN1EncodableArr);
    }

    private int getContentsLength() {
        if (this.contentsLength < 0) {
            int length = this.elements.length;
            int iEncodedLength = 0;
            for (int i = 0; i < length; i++) {
                iEncodedLength += this.elements[i].toASN1Primitive().toDLObject().encodedLength(true);
            }
            this.contentsLength = iEncodedLength;
        }
        return this.contentsLength;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeIdentifier(z, 48);
        DLOutputStream dLSubStream = aSN1OutputStream.getDLSubStream();
        int length = this.elements.length;
        int i = 0;
        if (this.contentsLength >= 0 || length > 16) {
            aSN1OutputStream.m14444writeDL(getContentsLength());
            while (i < length) {
                dLSubStream.writePrimitive(this.elements[i].toASN1Primitive(), true);
                i++;
            }
            return;
        }
        ASN1Primitive[] aSN1PrimitiveArr = new ASN1Primitive[length];
        int iEncodedLength = 0;
        for (int i2 = 0; i2 < length; i2++) {
            ASN1Primitive dLObject = this.elements[i2].toASN1Primitive().toDLObject();
            aSN1PrimitiveArr[i2] = dLObject;
            iEncodedLength += dLObject.encodedLength(true);
        }
        this.contentsLength = iEncodedLength;
        aSN1OutputStream.m14444writeDL(iEncodedLength);
        while (i < length) {
            dLSubStream.writePrimitive(aSN1PrimitiveArr[i], true);
            i++;
        }
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, getContentsLength());
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public ASN1BitString toASN1BitString() {
        return new DLBitString(BERBitString.flattenBitStrings(getConstructedBitStrings()), false);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public ASN1External toASN1External() {
        return DLExternal.fromSequence(this);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public ASN1OctetString toASN1OctetString() {
        return new DEROctetString(BEROctetString.flattenOctetStrings(getConstructedOctetStrings()));
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public AbstractC5093ASN1Set toASN1Set() {
        return new C5105DLSet(false, toArrayInternal());
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence, org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }

    public DLSequence(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
        this.contentsLength = -1;
    }

    public DLSequence(ASN1Encodable aSN1Encodable, ASN1Encodable aSN1Encodable2) {
        super(aSN1Encodable, aSN1Encodable2);
        this.contentsLength = -1;
    }

    public DLSequence(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector);
        this.contentsLength = -1;
    }

    public DLSequence(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr);
        this.contentsLength = -1;
    }

    public DLSequence(ASN1Encodable[] aSN1EncodableArr, boolean z) {
        super(aSN1EncodableArr, z);
        this.contentsLength = -1;
    }
}
