package org.bouncycastle.p133asn1.p146ess;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.IssuerSerial;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ESSCertIDv2 extends ASN1Object {
    private static final AlgorithmIdentifier DEFAULT_HASH_ALGORITHM = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
    private ASN1OctetString certHash;
    private AlgorithmIdentifier hashAlgorithm;
    private IssuerSerial issuerSerial;

    private ESSCertIDv2(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() > 3) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
        int i = 0;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1OctetString) {
            this.hashAlgorithm = DEFAULT_HASH_ALGORITHM;
        } else {
            this.hashAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            i = 1;
        }
        int i2 = i + 1;
        this.certHash = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i));
        if (aSN1Sequence.mo14450size() > i2) {
            this.issuerSerial = IssuerSerial.getInstance(aSN1Sequence.getObjectAt(i2));
        }
    }

    /* renamed from: from */
    public static ESSCertIDv2 m14606from(ESSCertID eSSCertID) {
        return new ESSCertIDv2(new AlgorithmIdentifier(OIWObjectIdentifiers.f18459idSHA1), eSSCertID.getCertHashObject(), eSSCertID.getIssuerSerial());
    }

    public static ESSCertIDv2 getInstance(Object obj) {
        if (obj instanceof ESSCertIDv2) {
            return (ESSCertIDv2) obj;
        }
        if (obj != null) {
            return new ESSCertIDv2(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getCertHash() {
        return C6238Arrays.m18231clone(this.certHash.getOctets());
    }

    public ASN1OctetString getCertHashObject() {
        return this.certHash;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public IssuerSerial getIssuerSerial() {
        return this.issuerSerial;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        if (!DEFAULT_HASH_ALGORITHM.mo14431equals(this.hashAlgorithm)) {
            aSN1EncodableVector.m14420add(this.hashAlgorithm);
        }
        aSN1EncodableVector.m14420add(this.certHash);
        IssuerSerial issuerSerial = this.issuerSerial;
        if (issuerSerial != null) {
            aSN1EncodableVector.m14420add(issuerSerial);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public ESSCertIDv2(AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString, IssuerSerial issuerSerial) {
        algorithmIdentifier = algorithmIdentifier == null ? DEFAULT_HASH_ALGORITHM : algorithmIdentifier;
        if (aSN1OctetString == null) {
            throw new NullPointerException("'certHash' cannot be null");
        }
        this.hashAlgorithm = algorithmIdentifier;
        this.certHash = aSN1OctetString;
        this.issuerSerial = issuerSerial;
    }

    public ESSCertIDv2(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this(algorithmIdentifier, bArr, (IssuerSerial) null);
    }

    public ESSCertIDv2(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, IssuerSerial issuerSerial) {
        this.hashAlgorithm = algorithmIdentifier == null ? DEFAULT_HASH_ALGORITHM : algorithmIdentifier;
        this.certHash = new DEROctetString(C6238Arrays.m18231clone(bArr));
        this.issuerSerial = issuerSerial;
    }

    public ESSCertIDv2(byte[] bArr) {
        this((AlgorithmIdentifier) null, bArr, (IssuerSerial) null);
    }

    public ESSCertIDv2(byte[] bArr, IssuerSerial issuerSerial) {
        this((AlgorithmIdentifier) null, bArr, issuerSerial);
    }
}
