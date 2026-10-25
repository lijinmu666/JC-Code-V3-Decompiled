package org.bouncycastle.p133asn1.p138cmp;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.ASN1Util;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes.dex */
public class CertStatus extends ASN1Object {
    private final ASN1OctetString certHash;
    private final ASN1Integer certReqId;

    /* renamed from: hashAlg */
    private final AlgorithmIdentifier f18105hashAlg;
    private final PKIStatusInfo statusInfo;

    private CertStatus(ASN1Sequence aSN1Sequence) {
        AlgorithmIdentifier algorithmIdentifier;
        this.certHash = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        this.certReqId = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
        PKIStatusInfo pKIStatusInfo = null;
        if (aSN1Sequence.mo14450size() > 2) {
            algorithmIdentifier = null;
            for (int i = 2; i < aSN1Sequence.mo14450size(); i++) {
                ASN1Primitive aSN1Primitive = aSN1Sequence.getObjectAt(i).toASN1Primitive();
                pKIStatusInfo = aSN1Primitive instanceof ASN1Sequence ? PKIStatusInfo.getInstance(aSN1Primitive) : pKIStatusInfo;
                if (aSN1Primitive instanceof ASN1TaggedObject) {
                    ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
                    if (!aSN1TaggedObject.hasContextTag(0)) {
                        throw new IllegalArgumentException("unknown tag " + ASN1Util.getTagText(aSN1TaggedObject));
                    }
                    algorithmIdentifier = AlgorithmIdentifier.getInstance(aSN1TaggedObject, true);
                }
            }
        } else {
            algorithmIdentifier = null;
        }
        this.statusInfo = pKIStatusInfo;
        this.f18105hashAlg = algorithmIdentifier;
    }

    public static CertStatus getInstance(Object obj) {
        if (obj instanceof CertStatus) {
            return (CertStatus) obj;
        }
        if (obj != null) {
            return new CertStatus(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1OctetString getCertHash() {
        return this.certHash;
    }

    public ASN1Integer getCertReqId() {
        return this.certReqId;
    }

    public AlgorithmIdentifier getHashAlg() {
        return this.f18105hashAlg;
    }

    public PKIStatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(this.certHash);
        aSN1EncodableVector.m14420add(this.certReqId);
        PKIStatusInfo pKIStatusInfo = this.statusInfo;
        if (pKIStatusInfo != null) {
            aSN1EncodableVector.m14420add(pKIStatusInfo);
        }
        AlgorithmIdentifier algorithmIdentifier = this.f18105hashAlg;
        if (algorithmIdentifier != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) algorithmIdentifier));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CertStatus(byte[] bArr, BigInteger bigInteger) {
        this(bArr, new ASN1Integer(bigInteger));
    }

    public CertStatus(byte[] bArr, BigInteger bigInteger, PKIStatusInfo pKIStatusInfo) {
        this.certHash = new DEROctetString(bArr);
        this.certReqId = new ASN1Integer(bigInteger);
        this.statusInfo = pKIStatusInfo;
        this.f18105hashAlg = null;
    }

    public CertStatus(byte[] bArr, BigInteger bigInteger, PKIStatusInfo pKIStatusInfo, AlgorithmIdentifier algorithmIdentifier) {
        this.certHash = new DEROctetString(bArr);
        this.certReqId = new ASN1Integer(bigInteger);
        this.statusInfo = pKIStatusInfo;
        this.f18105hashAlg = algorithmIdentifier;
    }

    public CertStatus(byte[] bArr, ASN1Integer aSN1Integer) {
        this.certHash = new DEROctetString(bArr);
        this.certReqId = aSN1Integer;
        this.statusInfo = null;
        this.f18105hashAlg = null;
    }
}
