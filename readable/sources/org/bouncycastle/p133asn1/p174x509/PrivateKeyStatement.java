package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p166pkcs.IssuerAndSerialNumber;

@Deprecated
/* loaded from: classes2.dex */
public class PrivateKeyStatement extends ASN1Object {

    /* renamed from: cert */
    private final Certificate f18676cert;

    /* renamed from: signer */
    private final IssuerAndSerialNumber f18677signer;

    private PrivateKeyStatement(ASN1Sequence aSN1Sequence) {
        Certificate certificate;
        if (aSN1Sequence.mo14450size() == 1) {
            this.f18677signer = IssuerAndSerialNumber.getInstance(aSN1Sequence.getObjectAt(0));
            certificate = null;
        } else {
            if (aSN1Sequence.mo14450size() != 2) {
                throw new IllegalArgumentException("unknown sequence in PrivateKeyStatement");
            }
            this.f18677signer = IssuerAndSerialNumber.getInstance(aSN1Sequence.getObjectAt(0));
            certificate = Certificate.getInstance(aSN1Sequence.getObjectAt(1));
        }
        this.f18676cert = certificate;
    }

    public static PrivateKeyStatement getInstance(Object obj) {
        if (obj instanceof PrivateKeyStatement) {
            return (PrivateKeyStatement) obj;
        }
        if (obj != null) {
            return new PrivateKeyStatement(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getCert */
    public Certificate m14706getCert() {
        return this.f18676cert;
    }

    public IssuerAndSerialNumber getSigner() {
        return this.f18677signer;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(this.f18677signer);
        Certificate certificate = this.f18676cert;
        if (certificate != null) {
            aSN1EncodableVector.m14420add(certificate);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public PrivateKeyStatement(IssuerAndSerialNumber issuerAndSerialNumber) {
        this.f18677signer = issuerAndSerialNumber;
        this.f18676cert = null;
    }

    public PrivateKeyStatement(Certificate certificate) {
        this.f18677signer = new IssuerAndSerialNumber(certificate.getIssuer(), certificate.getSerialNumber().getValue());
        this.f18676cert = certificate;
    }
}
