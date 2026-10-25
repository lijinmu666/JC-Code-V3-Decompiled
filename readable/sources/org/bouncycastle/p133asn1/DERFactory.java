package org.bouncycastle.p133asn1;

/* loaded from: classes.dex */
class DERFactory {
    static final DERSequence EMPTY_SEQUENCE = new DERSequence();
    static final C5104DERSet EMPTY_SET = new C5104DERSet();

    public static DERSequence createSequence(ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.m14424size() < 1 ? EMPTY_SEQUENCE : new DERSequence(aSN1EncodableVector);
    }

    public static C5104DERSet createSet(ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.m14424size() < 1 ? EMPTY_SET : new C5104DERSet(aSN1EncodableVector);
    }
}
