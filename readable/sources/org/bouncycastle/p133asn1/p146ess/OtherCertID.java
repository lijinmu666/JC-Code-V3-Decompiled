package org.bouncycastle.p133asn1.p146ess;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.DigestInfo;
import org.bouncycastle.p133asn1.p174x509.IssuerSerial;

/* loaded from: classes2.dex */
public class OtherCertID extends ASN1Object {
    private IssuerSerial issuerSerial;
    private ASN1Encodable otherCertHash;

    private OtherCertID(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() < 1 || aSN1Sequence.mo14450size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
        boolean z = aSN1Sequence.getObjectAt(0).toASN1Primitive() instanceof ASN1OctetString;
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(0);
        this.otherCertHash = z ? ASN1OctetString.getInstance(objectAt) : DigestInfo.getInstance(objectAt);
        if (aSN1Sequence.mo14450size() > 1) {
            this.issuerSerial = IssuerSerial.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static OtherCertID getInstance(Object obj) {
        if (obj instanceof OtherCertID) {
            return (OtherCertID) obj;
        }
        if (obj != null) {
            return new OtherCertID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getAlgorithmHash() {
        return this.otherCertHash.toASN1Primitive() instanceof ASN1OctetString ? new AlgorithmIdentifier(OIWObjectIdentifiers.f18459idSHA1) : DigestInfo.getInstance(this.otherCertHash).getAlgorithmId();
    }

    public byte[] getCertHash() {
        boolean z = this.otherCertHash.toASN1Primitive() instanceof ASN1OctetString;
        ASN1Encodable aSN1Encodable = this.otherCertHash;
        return z ? ((ASN1OctetString) aSN1Encodable.toASN1Primitive()).getOctets() : DigestInfo.getInstance(aSN1Encodable).getDigest();
    }

    public IssuerSerial getIssuerSerial() {
        return this.issuerSerial;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(this.otherCertHash);
        IssuerSerial issuerSerial = this.issuerSerial;
        if (issuerSerial != null) {
            aSN1EncodableVector.m14420add(issuerSerial);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public OtherCertID(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.otherCertHash = new DigestInfo(algorithmIdentifier, bArr);
    }

    public OtherCertID(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, IssuerSerial issuerSerial) {
        this.otherCertHash = new DigestInfo(algorithmIdentifier, bArr);
        this.issuerSerial = issuerSerial;
    }
}
