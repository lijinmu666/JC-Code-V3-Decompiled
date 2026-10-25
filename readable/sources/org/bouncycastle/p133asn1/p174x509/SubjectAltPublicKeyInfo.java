package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class SubjectAltPublicKeyInfo extends ASN1Object {
    private AlgorithmIdentifier algorithm;
    private ASN1BitString subjectAltPublicKey;

    private SubjectAltPublicKeyInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("extension should contain only 2 elements");
        }
        this.algorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.subjectAltPublicKey = ASN1BitString.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public static SubjectAltPublicKeyInfo fromExtensions(Extensions extensions) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, Extension.subjectAltPublicKeyInfo));
    }

    public static SubjectAltPublicKeyInfo getInstance(Object obj) {
        if (obj instanceof SubjectAltPublicKeyInfo) {
            return (SubjectAltPublicKeyInfo) obj;
        }
        if (obj != null) {
            return new SubjectAltPublicKeyInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public ASN1BitString getSubjectAltPublicKey() {
        return this.subjectAltPublicKey;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.algorithm, this.subjectAltPublicKey);
    }

    public SubjectAltPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1BitString aSN1BitString) {
        this.algorithm = algorithmIdentifier;
        this.subjectAltPublicKey = aSN1BitString;
    }

    public static SubjectAltPublicKeyInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public SubjectAltPublicKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.algorithm = subjectPublicKeyInfo.getAlgorithm();
        this.subjectAltPublicKey = subjectPublicKeyInfo.getPublicKeyData();
    }
}
