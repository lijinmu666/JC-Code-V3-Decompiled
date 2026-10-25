package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes.dex */
public class CertResponse extends ASN1Object {
    private final ASN1Integer certReqId;
    private CertifiedKeyPair certifiedKeyPair;

    /* renamed from: rspInfo */
    private ASN1OctetString f18103rspInfo;

    /* renamed from: status */
    private final PKIStatusInfo f18104status;

    public CertResponse(ASN1Integer aSN1Integer, PKIStatusInfo pKIStatusInfo) {
        this(aSN1Integer, pKIStatusInfo, null, null);
    }

    public static CertResponse getInstance(Object obj) {
        if (obj instanceof CertResponse) {
            return (CertResponse) obj;
        }
        if (obj != null) {
            return new CertResponse(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getCertReqId() {
        return this.certReqId;
    }

    public CertifiedKeyPair getCertifiedKeyPair() {
        return this.certifiedKeyPair;
    }

    public ASN1OctetString getRspInfo() {
        return this.f18103rspInfo;
    }

    public PKIStatusInfo getStatus() {
        return this.f18104status;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(this.certReqId);
        aSN1EncodableVector.m14420add(this.f18104status);
        CertifiedKeyPair certifiedKeyPair = this.certifiedKeyPair;
        if (certifiedKeyPair != null) {
            aSN1EncodableVector.m14420add(certifiedKeyPair);
        }
        ASN1OctetString aSN1OctetString = this.f18103rspInfo;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.m14420add(aSN1OctetString);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CertResponse(ASN1Integer aSN1Integer, PKIStatusInfo pKIStatusInfo, CertifiedKeyPair certifiedKeyPair, ASN1OctetString aSN1OctetString) {
        if (aSN1Integer == null) {
            throw new IllegalArgumentException("'certReqId' cannot be null");
        }
        if (pKIStatusInfo == null) {
            throw new IllegalArgumentException("'status' cannot be null");
        }
        this.certReqId = aSN1Integer;
        this.f18104status = pKIStatusInfo;
        this.certifiedKeyPair = certifiedKeyPair;
        this.f18103rspInfo = aSN1OctetString;
    }

    private CertResponse(ASN1Sequence aSN1Sequence) {
        ASN1Encodable objectAt;
        this.certReqId = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18104status = PKIStatusInfo.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.mo14450size() >= 3) {
            if (aSN1Sequence.mo14450size() == 3) {
                objectAt = aSN1Sequence.getObjectAt(2);
                if (!(objectAt instanceof ASN1OctetString)) {
                    this.certifiedKeyPair = CertifiedKeyPair.getInstance(objectAt);
                    return;
                }
            } else {
                this.certifiedKeyPair = CertifiedKeyPair.getInstance(aSN1Sequence.getObjectAt(2));
                objectAt = aSN1Sequence.getObjectAt(3);
            }
            this.f18103rspInfo = ASN1OctetString.getInstance(objectAt);
        }
    }
}
