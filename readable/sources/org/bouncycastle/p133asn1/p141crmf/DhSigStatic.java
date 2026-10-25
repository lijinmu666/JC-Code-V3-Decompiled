package org.bouncycastle.p133asn1.p141crmf;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p139cms.IssuerAndSerialNumber;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class DhSigStatic extends ASN1Object {
    private final ASN1OctetString hashValue;
    private final IssuerAndSerialNumber issuerAndSerial;

    private DhSigStatic(ASN1Sequence aSN1Sequence) {
        ASN1Encodable objectAt;
        if (aSN1Sequence.mo14450size() == 1) {
            this.issuerAndSerial = null;
            objectAt = aSN1Sequence.getObjectAt(0);
        } else {
            if (aSN1Sequence.mo14450size() != 2) {
                throw new IllegalArgumentException("sequence wrong length for DhSigStatic");
            }
            this.issuerAndSerial = IssuerAndSerialNumber.getInstance(aSN1Sequence.getObjectAt(0));
            objectAt = aSN1Sequence.getObjectAt(1);
        }
        this.hashValue = ASN1OctetString.getInstance(objectAt);
    }

    public static DhSigStatic getInstance(Object obj) {
        if (obj instanceof DhSigStatic) {
            return (DhSigStatic) obj;
        }
        if (obj != null) {
            return new DhSigStatic(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getHashValue() {
        return C6238Arrays.m18231clone(this.hashValue.getOctets());
    }

    public IssuerAndSerialNumber getIssuerAndSerial() {
        return this.issuerAndSerial;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        IssuerAndSerialNumber issuerAndSerialNumber = this.issuerAndSerial;
        if (issuerAndSerialNumber != null) {
            aSN1EncodableVector.m14420add(issuerAndSerialNumber);
        }
        aSN1EncodableVector.m14420add(this.hashValue);
        return new DERSequence(aSN1EncodableVector);
    }

    public DhSigStatic(IssuerAndSerialNumber issuerAndSerialNumber, byte[] bArr) {
        this.issuerAndSerial = issuerAndSerialNumber;
        this.hashValue = new DEROctetString(C6238Arrays.m18231clone(bArr));
    }

    public DhSigStatic(byte[] bArr) {
        this(null, bArr);
    }
}
