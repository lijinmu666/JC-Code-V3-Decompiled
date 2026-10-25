package org.bouncycastle.p133asn1.p164ocsp;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* renamed from: org.bouncycastle.asn1.ocsp.CertID */
/* loaded from: classes2.dex */
public class C5131CertID extends ASN1Object {
    AlgorithmIdentifier hashAlgorithm;
    ASN1OctetString issuerKeyHash;
    ASN1OctetString issuerNameHash;
    ASN1Integer serialNumber;

    private C5131CertID(ASN1Sequence aSN1Sequence) {
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.issuerNameHash = (ASN1OctetString) aSN1Sequence.getObjectAt(1);
        this.issuerKeyHash = (ASN1OctetString) aSN1Sequence.getObjectAt(2);
        this.serialNumber = (ASN1Integer) aSN1Sequence.getObjectAt(3);
    }

    public static C5131CertID getInstance(Object obj) {
        if (obj instanceof C5131CertID) {
            return (C5131CertID) obj;
        }
        if (obj != null) {
            return new C5131CertID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: isEqual */
    private boolean m14622isEqual(ASN1Encodable aSN1Encodable, ASN1Encodable aSN1Encodable2) {
        if (aSN1Encodable == aSN1Encodable2) {
            return true;
        }
        if (aSN1Encodable == null) {
            return C5103DERNull.INSTANCE.m14445equals(aSN1Encodable2);
        }
        if (C5103DERNull.INSTANCE.m14445equals(aSN1Encodable) && aSN1Encodable2 == null) {
            return true;
        }
        return aSN1Encodable.equals(aSN1Encodable2);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object
    /* renamed from: equals */
    public boolean mo14431equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ASN1Encodable) {
            try {
                C5131CertID c5131CertID = getInstance(obj);
                if (!this.hashAlgorithm.getAlgorithm().m14446equals((ASN1Primitive) c5131CertID.hashAlgorithm.getAlgorithm()) || !m14622isEqual(this.hashAlgorithm.getParameters(), c5131CertID.hashAlgorithm.getParameters())) {
                    return false;
                }
                if (this.issuerNameHash.m14446equals((ASN1Primitive) c5131CertID.issuerNameHash) && this.issuerKeyHash.m14446equals((ASN1Primitive) c5131CertID.issuerKeyHash)) {
                    if (this.serialNumber.m14446equals((ASN1Primitive) c5131CertID.serialNumber)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public ASN1OctetString getIssuerKeyHash() {
        return this.issuerKeyHash;
    }

    public ASN1OctetString getIssuerNameHash() {
        return this.issuerNameHash;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object
    public int hashCode() {
        ASN1Encodable parameters = this.hashAlgorithm.getParameters();
        return ((parameters == null || C5103DERNull.INSTANCE.m14445equals(parameters)) ? 0 : parameters.hashCode()) + ((this.hashAlgorithm.getAlgorithm().hashCode() + ((this.issuerNameHash.hashCode() + ((this.issuerKeyHash.hashCode() + (this.serialNumber.hashCode() * 7)) * 7)) * 7)) * 7);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(this.hashAlgorithm);
        aSN1EncodableVector.m14420add(this.issuerNameHash);
        aSN1EncodableVector.m14420add(this.issuerKeyHash);
        aSN1EncodableVector.m14420add(this.serialNumber);
        return new DERSequence(aSN1EncodableVector);
    }

    public C5131CertID(AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2, ASN1Integer aSN1Integer) {
        this.hashAlgorithm = algorithmIdentifier;
        this.issuerNameHash = aSN1OctetString;
        this.issuerKeyHash = aSN1OctetString2;
        this.serialNumber = aSN1Integer;
    }

    public static C5131CertID getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
