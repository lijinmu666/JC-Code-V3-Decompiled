package org.bouncycastle.p133asn1.p137cmc;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1BitString;
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
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes.dex */
public class CertificationRequest extends ASN1Object {
    private final CertificationRequestInfo certificationRequestInfo;
    private final ASN1BitString signature;
    private final AlgorithmIdentifier signatureAlgorithm;

    private CertificationRequest(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.certificationRequestInfo = new CertificationRequestInfo(ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(0)));
        this.signatureAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.signature = ASN1BitString.getInstance(aSN1Sequence.getObjectAt(2));
    }

    public static CertificationRequest getInstance(Object obj) {
        if (obj instanceof CertificationRequest) {
            return (CertificationRequest) obj;
        }
        if (obj != null) {
            return new CertificationRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AbstractC5093ASN1Set getAttributes() {
        return this.certificationRequestInfo.getAttributes();
    }

    public ASN1BitString getSignature() {
        return this.signature;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public X500Name getSubject() {
        return this.certificationRequestInfo.getSubject();
    }

    public ASN1BitString getSubjectPublicKey() {
        return ASN1BitString.getInstance(this.certificationRequestInfo.getSubjectPublicKeyInfo().getObjectAt(1));
    }

    public AlgorithmIdentifier getSubjectPublicKeyAlgorithm() {
        return AlgorithmIdentifier.getInstance(this.certificationRequestInfo.getSubjectPublicKeyInfo().getObjectAt(0));
    }

    public BigInteger getVersion() {
        return this.certificationRequestInfo.getVersion().getValue();
    }

    public ASN1Primitive parsePublicKey() {
        return ASN1Primitive.fromByteArray(getSubjectPublicKey().getOctets());
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.certificationRequestInfo);
        aSN1EncodableVector.m14420add(this.signatureAlgorithm);
        aSN1EncodableVector.m14420add(this.signature);
        return new DERSequence(aSN1EncodableVector);
    }

    public static class CertificationRequestInfo extends ASN1Object {
        private final AbstractC5093ASN1Set attributes;

        /* renamed from: subject */
        private final X500Name f18073subject;
        private final ASN1Sequence subjectPublicKeyInfo;

        /* renamed from: version */
        private final ASN1Integer f18074version;

        private CertificationRequestInfo(ASN1Sequence aSN1Sequence) {
            if (aSN1Sequence.mo14450size() != 4) {
                throw new IllegalArgumentException("incorrect sequence size for CertificationRequestInfo");
            }
            this.f18074version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
            this.f18073subject = X500Name.getInstance(aSN1Sequence.getObjectAt(1));
            ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(2));
            this.subjectPublicKeyInfo = aSN1Sequence2;
            if (aSN1Sequence2.mo14450size() != 2) {
                throw new IllegalArgumentException("incorrect subjectPublicKeyInfo size for CertificationRequestInfo");
            }
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(3);
            if (aSN1TaggedObject.getTagNo() != 0) {
                throw new IllegalArgumentException("incorrect tag number on attributes for CertificationRequestInfo");
            }
            this.attributes = AbstractC5093ASN1Set.getInstance(aSN1TaggedObject, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AbstractC5093ASN1Set getAttributes() {
            return this.attributes;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public X500Name getSubject() {
            return this.f18073subject;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ASN1Sequence getSubjectPublicKeyInfo() {
            return this.subjectPublicKeyInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ASN1Integer getVersion() {
            return this.f18074version;
        }

        @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
        public ASN1Primitive toASN1Primitive() {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
            aSN1EncodableVector.m14420add(this.f18074version);
            aSN1EncodableVector.m14420add(this.f18073subject);
            aSN1EncodableVector.m14420add(this.subjectPublicKeyInfo);
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) this.attributes));
            return new DERSequence(aSN1EncodableVector);
        }

        private CertificationRequestInfo(X500Name x500Name, AlgorithmIdentifier algorithmIdentifier, ASN1BitString aSN1BitString, AbstractC5093ASN1Set abstractC5093ASN1Set) {
            this.f18074version = ASN1Integer.f17922ZERO;
            this.f18073subject = x500Name;
            this.subjectPublicKeyInfo = new DERSequence(algorithmIdentifier, aSN1BitString);
            this.attributes = abstractC5093ASN1Set;
        }
    }

    public CertificationRequest(X500Name x500Name, AlgorithmIdentifier algorithmIdentifier, ASN1BitString aSN1BitString, AbstractC5093ASN1Set abstractC5093ASN1Set, AlgorithmIdentifier algorithmIdentifier2, ASN1BitString aSN1BitString2) {
        this.certificationRequestInfo = new CertificationRequestInfo(x500Name, algorithmIdentifier, aSN1BitString, abstractC5093ASN1Set);
        this.signatureAlgorithm = algorithmIdentifier2;
        this.signature = aSN1BitString2;
    }
}
