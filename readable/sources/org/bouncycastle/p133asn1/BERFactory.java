package org.bouncycastle.p133asn1;

/* loaded from: classes.dex */
class BERFactory {
    static final BERSequence EMPTY_SEQUENCE = new BERSequence();
    static final C5101BERSet EMPTY_SET = new C5101BERSet();

    public static BERSequence createSequence(ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.m14424size() < 1 ? EMPTY_SEQUENCE : new BERSequence(aSN1EncodableVector);
    }

    public static C5101BERSet createSet(ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.m14424size() < 1 ? EMPTY_SET : new C5101BERSet(aSN1EncodableVector);
    }
}
