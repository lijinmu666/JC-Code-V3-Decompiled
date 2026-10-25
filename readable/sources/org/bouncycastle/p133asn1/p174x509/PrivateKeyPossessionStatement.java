package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p166pkcs.IssuerAndSerialNumber;

/* loaded from: classes2.dex */
public class PrivateKeyPossessionStatement extends ASN1Object {

    /* renamed from: cert */
    private final Certificate f18674cert;

    /* renamed from: signer */
    private final IssuerAndSerialNumber f18675signer;

    private PrivateKeyPossessionStatement(ASN1Sequence aSN1Sequence) {
        Certificate certificate;
        if (aSN1Sequence.mo14450size() == 1) {
            this.f18675signer = IssuerAndSerialNumber.getInstance(aSN1Sequence.getObjectAt(0));
            certificate = null;
        } else {
            if (aSN1Sequence.mo14450size() != 2) {
                throw new IllegalArgumentException("unknown sequence in PrivateKeyStatement");
            }
            this.f18675signer = IssuerAndSerialNumber.getInstance(aSN1Sequence.getObjectAt(0));
            certificate = Certificate.getInstance(aSN1Sequence.getObjectAt(1));
        }
        this.f18674cert = certificate;
    }

    public static PrivateKeyPossessionStatement getInstance(Object obj) {
        if (obj instanceof PrivateKeyPossessionStatement) {
            return (PrivateKeyPossessionStatement) obj;
        }
        if (obj != null) {
            return new PrivateKeyPossessionStatement(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getCert */
    public Certificate m14705getCert() {
        return this.f18674cert;
    }

    public IssuerAndSerialNumber getSigner() {
        return this.f18675signer;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(this.f18675signer);
        Certificate certificate = this.f18674cert;
        if (certificate != null) {
            aSN1EncodableVector.m14420add(certificate);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public PrivateKeyPossessionStatement(IssuerAndSerialNumber issuerAndSerialNumber) {
        this.f18675signer = issuerAndSerialNumber;
        this.f18674cert = null;
    }

    public PrivateKeyPossessionStatement(Certificate certificate) {
        this.f18675signer = new IssuerAndSerialNumber(certificate.getIssuer(), certificate.getSerialNumber().getValue());
        this.f18674cert = certificate;
    }
}
