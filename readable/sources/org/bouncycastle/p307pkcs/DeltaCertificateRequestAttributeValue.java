package org.bouncycastle.p307pkcs;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.p166pkcs.Attribute;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.DeltaCertificateDescriptor;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;

/* loaded from: classes2.dex */
public class DeltaCertificateRequestAttributeValue implements ASN1Encodable {

    /* renamed from: attrSeq */
    private final ASN1Sequence f22924attrSeq;
    private final Extensions extensions;
    private final AlgorithmIdentifier signatureAlgorithm;

    /* renamed from: subject */
    private final X500Name f22925subject;
    private final SubjectPublicKeyInfo subjectPKInfo;

    public DeltaCertificateRequestAttributeValue(ASN1Sequence aSN1Sequence) {
        AlgorithmIdentifier algorithmIdentifier;
        this.f22924attrSeq = aSN1Sequence;
        int i = 0;
        Extensions extensions = null;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject) {
            this.f22925subject = X500Name.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(0)), true);
            i = 1;
        } else {
            this.f22925subject = null;
        }
        this.subjectPKInfo = SubjectPublicKeyInfo.getInstance(aSN1Sequence.getObjectAt(i));
        int i2 = i + 1;
        if (i2 != aSN1Sequence.mo14450size()) {
            algorithmIdentifier = null;
            while (i2 < aSN1Sequence.mo14450size()) {
                ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i2));
                if (aSN1TaggedObject.getTagNo() == 1) {
                    extensions = Extensions.getInstance(aSN1TaggedObject, true);
                } else {
                    if (aSN1TaggedObject.getTagNo() != 2) {
                        throw new IllegalArgumentException("unknown tag");
                    }
                    algorithmIdentifier = AlgorithmIdentifier.getInstance(aSN1TaggedObject, true);
                }
                i2++;
            }
        } else {
            algorithmIdentifier = null;
        }
        this.extensions = extensions;
        this.signatureAlgorithm = algorithmIdentifier;
    }

    public static DeltaCertificateRequestAttributeValue getInstance(Object obj) {
        if (obj instanceof DeltaCertificateDescriptor) {
            return (DeltaCertificateRequestAttributeValue) obj;
        }
        if (obj == null) {
            return null;
        }
        new DeltaCertificateRequestAttributeValue(ASN1Sequence.getInstance(obj));
        return null;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public X500Name getSubject() {
        return this.f22925subject;
    }

    public SubjectPublicKeyInfo getSubjectPKInfo() {
        return this.subjectPKInfo;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f22924attrSeq;
    }

    public DeltaCertificateRequestAttributeValue(Attribute attribute) {
        this(ASN1Sequence.getInstance(attribute.getAttributeValues()[0]));
    }
}
