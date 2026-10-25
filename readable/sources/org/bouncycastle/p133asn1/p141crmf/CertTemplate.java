package org.bouncycastle.p133asn1.p141crmf;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;

/* loaded from: classes2.dex */
public class CertTemplate extends ASN1Object {
    private Extensions extensions;

    /* renamed from: issuer */
    private X500Name f18251issuer;
    private ASN1BitString issuerUID;
    private SubjectPublicKeyInfo publicKey;

    /* renamed from: seq */
    private ASN1Sequence f18252seq;
    private ASN1Integer serialNumber;
    private AlgorithmIdentifier signingAlg;

    /* renamed from: subject */
    private X500Name f18253subject;
    private ASN1BitString subjectUID;
    private OptionalValidity validity;

    /* renamed from: version */
    private ASN1Integer f18254version;

    private CertTemplate(ASN1Sequence aSN1Sequence) {
        this.f18252seq = aSN1Sequence;
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            switch (aSN1TaggedObject.getTagNo()) {
                case 0:
                    this.f18254version = ASN1Integer.getInstance(aSN1TaggedObject, false);
                    break;
                case 1:
                    this.serialNumber = ASN1Integer.getInstance(aSN1TaggedObject, false);
                    break;
                case 2:
                    this.signingAlg = AlgorithmIdentifier.getInstance(aSN1TaggedObject, false);
                    break;
                case 3:
                    this.f18251issuer = X500Name.getInstance(aSN1TaggedObject, true);
                    break;
                case 4:
                    this.validity = OptionalValidity.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, false));
                    break;
                case 5:
                    this.f18253subject = X500Name.getInstance(aSN1TaggedObject, true);
                    break;
                case 6:
                    this.publicKey = SubjectPublicKeyInfo.getInstance(aSN1TaggedObject, false);
                    break;
                case 7:
                    this.issuerUID = ASN1BitString.getInstance(aSN1TaggedObject, false);
                    break;
                case 8:
                    this.subjectUID = ASN1BitString.getInstance(aSN1TaggedObject, false);
                    break;
                case 9:
                    this.extensions = Extensions.getInstance(aSN1TaggedObject, false);
                    break;
                default:
                    throw new IllegalArgumentException("unknown tag: " + aSN1TaggedObject.getTagNo());
            }
        }
    }

    public static CertTemplate getInstance(Object obj) {
        if (obj instanceof CertTemplate) {
            return (CertTemplate) obj;
        }
        if (obj != null) {
            return new CertTemplate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public X500Name getIssuer() {
        return this.f18251issuer;
    }

    public ASN1BitString getIssuerUID() {
        return this.issuerUID;
    }

    public SubjectPublicKeyInfo getPublicKey() {
        return this.publicKey;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public AlgorithmIdentifier getSigningAlg() {
        return this.signingAlg;
    }

    public X500Name getSubject() {
        return this.f18253subject;
    }

    public ASN1BitString getSubjectUID() {
        return this.subjectUID;
    }

    public OptionalValidity getValidity() {
        return this.validity;
    }

    public int getVersion() {
        ASN1Integer aSN1Integer = this.f18254version;
        if (aSN1Integer != null) {
            return aSN1Integer.intValueExact();
        }
        return -1;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18252seq;
    }
}
