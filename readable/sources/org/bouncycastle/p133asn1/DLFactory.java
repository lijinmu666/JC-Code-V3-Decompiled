package org.bouncycastle.p133asn1;

/* loaded from: classes.dex */
class DLFactory {
    static final DLSequence EMPTY_SEQUENCE = new DLSequence();
    static final C5105DLSet EMPTY_SET = new C5105DLSet();

    public static DLSequence createSequence(ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.m14424size() < 1 ? EMPTY_SEQUENCE : new DLSequence(aSN1EncodableVector);
    }

    public static C5105DLSet createSet(ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.m14424size() < 1 ? EMPTY_SET : new C5105DLSet(aSN1EncodableVector);
    }
}
