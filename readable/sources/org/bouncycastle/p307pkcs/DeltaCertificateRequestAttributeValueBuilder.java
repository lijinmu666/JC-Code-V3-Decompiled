package org.bouncycastle.p307pkcs;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p166pkcs.Attribute;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;

/* loaded from: classes2.dex */
public class DeltaCertificateRequestAttributeValueBuilder {
    private AlgorithmIdentifier signatureAlgorithm;

    /* renamed from: subject */
    private X500Name f22926subject;
    private final SubjectPublicKeyInfo subjectPublicKey;

    public DeltaCertificateRequestAttributeValueBuilder(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.subjectPublicKey = subjectPublicKeyInfo;
    }

    /* renamed from: build */
    public DeltaCertificateRequestAttributeValue m17402build() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        X500Name x500Name = this.f22926subject;
        if (x500Name != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) x500Name));
        }
        aSN1EncodableVector.m14420add(this.subjectPublicKey);
        AlgorithmIdentifier algorithmIdentifier = this.signatureAlgorithm;
        if (algorithmIdentifier != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 2, (ASN1Encodable) algorithmIdentifier));
        }
        return new DeltaCertificateRequestAttributeValue(new Attribute(new ASN1ObjectIdentifier("2.16.840.1.114027.80.6.2"), new C5104DERSet(new DERSequence(aSN1EncodableVector))));
    }

    public DeltaCertificateRequestAttributeValueBuilder setSignatureAlgorithm(AlgorithmIdentifier algorithmIdentifier) {
        this.signatureAlgorithm = algorithmIdentifier;
        return this;
    }

    public DeltaCertificateRequestAttributeValueBuilder setSubject(X500Name x500Name) {
        this.f22926subject = x500Name;
        return this;
    }
}
