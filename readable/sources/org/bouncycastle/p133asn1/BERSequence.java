package org.bouncycastle.p133asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class BERSequence extends ASN1Sequence {

    /* renamed from: EMPTY */
    public static final BERSequence f17969EMPTY = new BERSequence();

    public BERSequence() {
    }

    public static BERSequence fromElementsOptional(ASN1Encodable[] aSN1EncodableArr) {
        if (aSN1EncodableArr == null) {
            return null;
        }
        return aSN1EncodableArr.length < 1 ? f17969EMPTY : new BERSequence(aSN1EncodableArr);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncodingIL(z, 48, this.elements);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        int iEncodedLength = z ? 4 : 3;
        int length = this.elements.length;
        for (int i = 0; i < length; i++) {
            iEncodedLength += this.elements[i].toASN1Primitive().encodedLength(true);
        }
        return iEncodedLength;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public ASN1BitString toASN1BitString() {
        return new BERBitString(getConstructedBitStrings());
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public ASN1External toASN1External() {
        return ((ASN1Sequence) toDLObject()).toASN1External();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public ASN1OctetString toASN1OctetString() {
        return new BEROctetString(getConstructedOctetStrings());
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public AbstractC5093ASN1Set toASN1Set() {
        return new C5101BERSet(false, toArrayInternal());
    }

    public BERSequence(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public BERSequence(ASN1Encodable aSN1Encodable, ASN1Encodable aSN1Encodable2) {
        super(aSN1Encodable, aSN1Encodable2);
    }

    public BERSequence(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector);
    }

    public BERSequence(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr);
    }
}
