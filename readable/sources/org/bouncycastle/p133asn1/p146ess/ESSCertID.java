package org.bouncycastle.p133asn1.p146ess;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.IssuerSerial;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ESSCertID extends ASN1Object {
    private ASN1OctetString certHash;
    private IssuerSerial issuerSerial;

    public ESSCertID(ASN1OctetString aSN1OctetString, IssuerSerial issuerSerial) {
        if (aSN1OctetString == null) {
            throw new NullPointerException("'certHash' cannot be null");
        }
        this.certHash = aSN1OctetString;
        this.issuerSerial = issuerSerial;
    }

    public static ESSCertID getInstance(Object obj) {
        if (obj instanceof ESSCertID) {
            return (ESSCertID) obj;
        }
        if (obj != null) {
            return new ESSCertID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getCertHash() {
        return this.certHash.getOctets();
    }

    public ASN1OctetString getCertHashObject() {
        return this.certHash;
    }

    public IssuerSerial getIssuerSerial() {
        return this.issuerSerial;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(this.certHash);
        IssuerSerial issuerSerial = this.issuerSerial;
        if (issuerSerial != null) {
            aSN1EncodableVector.m14420add(issuerSerial);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private ESSCertID(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() < 1 || aSN1Sequence.mo14450size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
        this.certHash = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.mo14450size() > 1) {
            this.issuerSerial = IssuerSerial.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public ESSCertID(byte[] bArr) {
        this.certHash = new DEROctetString(C6238Arrays.m18231clone(bArr));
    }

    public ESSCertID(byte[] bArr, IssuerSerial issuerSerial) {
        this.certHash = new DEROctetString(C6238Arrays.m18231clone(bArr));
        this.issuerSerial = issuerSerial;
    }
}
