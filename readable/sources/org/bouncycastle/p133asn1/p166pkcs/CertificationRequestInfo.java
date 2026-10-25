package org.bouncycastle.p133asn1.p166pkcs;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p174x509.X509Name;

/* loaded from: classes2.dex */
public class CertificationRequestInfo extends ASN1Object {
    AbstractC5093ASN1Set attributes;

    /* renamed from: subject */
    X500Name f18466subject;
    SubjectPublicKeyInfo subjectPKInfo;

    /* renamed from: version */
    ASN1Integer f18467version;

    private CertificationRequestInfo(ASN1Sequence aSN1Sequence) {
        this.f18467version = ASN1Integer.f17922ZERO;
        this.attributes = null;
        this.f18467version = (ASN1Integer) aSN1Sequence.getObjectAt(0);
        this.f18466subject = X500Name.getInstance(aSN1Sequence.getObjectAt(1));
        this.subjectPKInfo = SubjectPublicKeyInfo.getInstance(aSN1Sequence.getObjectAt(2));
        if (aSN1Sequence.mo14450size() > 3) {
            this.attributes = AbstractC5093ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(3), false);
        }
        validateAttributes(this.attributes);
        if (this.f18466subject == null || this.f18467version == null || this.subjectPKInfo == null) {
            throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        }
    }

    public static CertificationRequestInfo getInstance(Object obj) {
        if (obj instanceof CertificationRequestInfo) {
            return (CertificationRequestInfo) obj;
        }
        if (obj != null) {
            return new CertificationRequestInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private static void validateAttributes(AbstractC5093ASN1Set abstractC5093ASN1Set) {
        if (abstractC5093ASN1Set == null) {
            return;
        }
        Enumeration objects = abstractC5093ASN1Set.getObjects();
        while (objects.hasMoreElements()) {
            Attribute attribute = Attribute.getInstance(objects.nextElement());
            if (attribute.getAttrType().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs_9_at_challengePassword) && attribute.getAttrValues().m14454size() != 1) {
                throw new IllegalArgumentException("challengePassword attribute must have one value");
            }
        }
    }

    public AbstractC5093ASN1Set getAttributes() {
        return this.attributes;
    }

    public X500Name getSubject() {
        return this.f18466subject;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.subjectPKInfo;
    }

    public ASN1Integer getVersion() {
        return this.f18467version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(this.f18467version);
        aSN1EncodableVector.m14420add(this.f18466subject);
        aSN1EncodableVector.m14420add(this.subjectPKInfo);
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.attributes;
        if (abstractC5093ASN1Set != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) abstractC5093ASN1Set));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CertificationRequestInfo(X500Name x500Name, SubjectPublicKeyInfo subjectPublicKeyInfo, AbstractC5093ASN1Set abstractC5093ASN1Set) {
        this.f18467version = ASN1Integer.f17922ZERO;
        this.attributes = null;
        if (x500Name == null || subjectPublicKeyInfo == null) {
            throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        }
        validateAttributes(abstractC5093ASN1Set);
        this.f18466subject = x500Name;
        this.subjectPKInfo = subjectPublicKeyInfo;
        this.attributes = abstractC5093ASN1Set;
    }

    public CertificationRequestInfo(X509Name x509Name, SubjectPublicKeyInfo subjectPublicKeyInfo, AbstractC5093ASN1Set abstractC5093ASN1Set) {
        this(X500Name.getInstance(x509Name.toASN1Primitive()), subjectPublicKeyInfo, abstractC5093ASN1Set);
    }
}
