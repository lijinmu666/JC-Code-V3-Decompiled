package org.bouncycastle.p133asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class DERSequence extends ASN1Sequence {

    /* renamed from: EMPTY */
    public static final DERSequence f17994EMPTY = new DERSequence();
    private int contentsLength;

    public DERSequence() {
        this.contentsLength = -1;
    }

    /* renamed from: convert */
    public static DERSequence m14472convert(ASN1Sequence aSN1Sequence) {
        return (DERSequence) aSN1Sequence.toDERObject();
    }

    public static DERSequence fromElementsOptional(ASN1Encodable[] aSN1EncodableArr) {
        if (aSN1EncodableArr == null) {
            return null;
        }
        return aSN1EncodableArr.length < 1 ? f17994EMPTY : new DERSequence(aSN1EncodableArr);
    }

    private int getContentsLength() {
        if (this.contentsLength < 0) {
            int length = this.elements.length;
            int iEncodedLength = 0;
            for (int i = 0; i < length; i++) {
                iEncodedLength += this.elements[i].toASN1Primitive().toDERObject().encodedLength(true);
            }
            this.contentsLength = iEncodedLength;
        }
        return this.contentsLength;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeIdentifier(z, 48);
        DEROutputStream dERSubStream = aSN1OutputStream.getDERSubStream();
        int length = this.elements.length;
        int i = 0;
        if (this.contentsLength >= 0 || length > 16) {
            aSN1OutputStream.m14444writeDL(getContentsLength());
            while (i < length) {
                this.elements[i].toASN1Primitive().toDERObject().mo14417encode(dERSubStream, true);
                i++;
            }
            return;
        }
        ASN1Primitive[] aSN1PrimitiveArr = new ASN1Primitive[length];
        int iEncodedLength = 0;
        for (int i2 = 0; i2 < length; i2++) {
            ASN1Primitive dERObject = this.elements[i2].toASN1Primitive().toDERObject();
            aSN1PrimitiveArr[i2] = dERObject;
            iEncodedLength += dERObject.encodedLength(true);
        }
        this.contentsLength = iEncodedLength;
        aSN1OutputStream.m14444writeDL(iEncodedLength);
        while (i < length) {
            aSN1PrimitiveArr[i].mo14417encode(dERSubStream, true);
            i++;
        }
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, getContentsLength());
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public ASN1BitString toASN1BitString() {
        return new DERBitString(BERBitString.flattenBitStrings(getConstructedBitStrings()), false);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public ASN1External toASN1External() {
        return DERExternal.fromSequence(this);
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
    public ASN1Primitive toDERObject() {
        return this;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence, org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }

    public DERSequence(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
        this.contentsLength = -1;
    }

    public DERSequence(ASN1Encodable aSN1Encodable, ASN1Encodable aSN1Encodable2) {
        super(aSN1Encodable, aSN1Encodable2);
        this.contentsLength = -1;
    }

    public DERSequence(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector);
        this.contentsLength = -1;
    }

    public DERSequence(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr);
        this.contentsLength = -1;
    }

    public DERSequence(ASN1Encodable[] aSN1EncodableArr, boolean z) {
        super(aSN1EncodableArr, z);
        this.contentsLength = -1;
    }
}
