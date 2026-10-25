package org.bouncycastle.p133asn1.p141crmf;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p174x509.X509Extensions;

/* loaded from: classes2.dex */
public class CertTemplateBuilder {
    private Extensions extensions;

    /* renamed from: issuer */
    private X500Name f18255issuer;
    private DERBitString issuerUID;
    private SubjectPublicKeyInfo publicKey;
    private ASN1Integer serialNumber;
    private AlgorithmIdentifier signingAlg;

    /* renamed from: subject */
    private X500Name f18256subject;
    private DERBitString subjectUID;
    private OptionalValidity validity;

    /* renamed from: version */
    private ASN1Integer f18257version;

    private void addOptional(ASN1EncodableVector aSN1EncodableVector, int i, boolean z, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(z, i, aSN1Encodable));
        }
    }

    /* renamed from: build */
    public CertTemplate m14564build() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
        addOptional(aSN1EncodableVector, 0, false, this.f18257version);
        addOptional(aSN1EncodableVector, 1, false, this.serialNumber);
        addOptional(aSN1EncodableVector, 2, false, this.signingAlg);
        addOptional(aSN1EncodableVector, 3, true, this.f18255issuer);
        addOptional(aSN1EncodableVector, 4, false, this.validity);
        addOptional(aSN1EncodableVector, 5, true, this.f18256subject);
        addOptional(aSN1EncodableVector, 6, false, this.publicKey);
        addOptional(aSN1EncodableVector, 7, false, this.issuerUID);
        addOptional(aSN1EncodableVector, 8, false, this.subjectUID);
        addOptional(aSN1EncodableVector, 9, false, this.extensions);
        return CertTemplate.getInstance(new DERSequence(aSN1EncodableVector));
    }

    public CertTemplateBuilder setExtensions(Extensions extensions) {
        this.extensions = extensions;
        return this;
    }

    public CertTemplateBuilder setIssuer(X500Name x500Name) {
        this.f18255issuer = x500Name;
        return this;
    }

    public CertTemplateBuilder setIssuerUID(DERBitString dERBitString) {
        this.issuerUID = dERBitString;
        return this;
    }

    public CertTemplateBuilder setPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.publicKey = subjectPublicKeyInfo;
        return this;
    }

    public CertTemplateBuilder setSerialNumber(ASN1Integer aSN1Integer) {
        this.serialNumber = aSN1Integer;
        return this;
    }

    public CertTemplateBuilder setSigningAlg(AlgorithmIdentifier algorithmIdentifier) {
        this.signingAlg = algorithmIdentifier;
        return this;
    }

    public CertTemplateBuilder setSubject(X500Name x500Name) {
        this.f18256subject = x500Name;
        return this;
    }

    public CertTemplateBuilder setSubjectUID(DERBitString dERBitString) {
        this.subjectUID = dERBitString;
        return this;
    }

    public CertTemplateBuilder setValidity(OptionalValidity optionalValidity) {
        this.validity = optionalValidity;
        return this;
    }

    public CertTemplateBuilder setVersion(int i) {
        this.f18257version = ASN1Integer.m14429valueOf(i);
        return this;
    }

    public CertTemplateBuilder setExtensions(X509Extensions x509Extensions) {
        return setExtensions(Extensions.getInstance(x509Extensions));
    }
}
