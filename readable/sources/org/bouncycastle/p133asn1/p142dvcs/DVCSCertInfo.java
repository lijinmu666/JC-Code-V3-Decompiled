package org.bouncycastle.p133asn1.p142dvcs;

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
import org.bouncycastle.p133asn1.p138cmp.PKIStatusInfo;
import org.bouncycastle.p133asn1.p174x509.DigestInfo;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.PolicyInformation;

/* loaded from: classes2.dex */
public class DVCSCertInfo extends ASN1Object {
    private static final int DEFAULT_VERSION = 1;
    private static final int TAG_CERTS = 3;
    private static final int TAG_DV_STATUS = 0;
    private static final int TAG_POLICY = 1;
    private static final int TAG_REQ_SIGNATURE = 2;

    /* renamed from: certs */
    private ASN1Sequence f18300certs;
    private DVCSRequestInformation dvReqInfo;
    private PKIStatusInfo dvStatus;
    private Extensions extensions;
    private DigestInfo messageImprint;

    /* renamed from: policy */
    private PolicyInformation f18301policy;
    private AbstractC5093ASN1Set reqSignature;
    private DVCSTime responseTime;
    private ASN1Integer serialNumber;

    /* renamed from: version */
    private int f18302version;

    private DVCSCertInfo(ASN1Sequence aSN1Sequence) {
        int i;
        this.f18302version = 1;
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(0);
        try {
            this.f18302version = ASN1Integer.getInstance(objectAt).intValueExact();
            try {
                objectAt = aSN1Sequence.getObjectAt(1);
            } catch (IllegalArgumentException unused) {
            }
            i = 2;
        } catch (IllegalArgumentException unused2) {
            i = 1;
        }
        this.dvReqInfo = DVCSRequestInformation.getInstance(objectAt);
        this.messageImprint = DigestInfo.getInstance(aSN1Sequence.getObjectAt(i));
        int i2 = i + 2;
        this.serialNumber = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i + 1));
        int i3 = i + 3;
        this.responseTime = DVCSTime.getInstance(aSN1Sequence.getObjectAt(i2));
        while (i3 < aSN1Sequence.mo14450size()) {
            int i4 = i3 + 1;
            ASN1Encodable objectAt2 = aSN1Sequence.getObjectAt(i3);
            if (objectAt2 instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(objectAt2);
                int tagNo = aSN1TaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.dvStatus = PKIStatusInfo.getInstance(aSN1TaggedObject, false);
                } else if (tagNo == 1) {
                    this.f18301policy = PolicyInformation.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, false));
                } else if (tagNo == 2) {
                    this.reqSignature = AbstractC5093ASN1Set.getInstance(aSN1TaggedObject, false);
                } else {
                    if (tagNo != 3) {
                        throw new IllegalArgumentException("Unknown tag encountered: " + tagNo);
                    }
                    this.f18300certs = ASN1Sequence.getInstance(aSN1TaggedObject, false);
                }
            } else {
                try {
                    this.extensions = Extensions.getInstance(objectAt2);
                } catch (IllegalArgumentException unused3) {
                }
            }
            i3 = i4;
        }
    }

    public static DVCSCertInfo getInstance(Object obj) {
        if (obj instanceof DVCSCertInfo) {
            return (DVCSCertInfo) obj;
        }
        if (obj != null) {
            return new DVCSCertInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private void setDvReqInfo(DVCSRequestInformation dVCSRequestInformation) {
        this.dvReqInfo = dVCSRequestInformation;
    }

    private void setMessageImprint(DigestInfo digestInfo) {
        this.messageImprint = digestInfo;
    }

    private void setVersion(int i) {
        this.f18302version = i;
    }

    public TargetEtcChain[] getCerts() {
        ASN1Sequence aSN1Sequence = this.f18300certs;
        if (aSN1Sequence != null) {
            return TargetEtcChain.arrayFromSequence(aSN1Sequence);
        }
        return null;
    }

    public DVCSRequestInformation getDvReqInfo() {
        return this.dvReqInfo;
    }

    public PKIStatusInfo getDvStatus() {
        return this.dvStatus;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public DigestInfo getMessageImprint() {
        return this.messageImprint;
    }

    public PolicyInformation getPolicy() {
        return this.f18301policy;
    }

    public AbstractC5093ASN1Set getReqSignature() {
        return this.reqSignature;
    }

    public DVCSTime getResponseTime() {
        return this.responseTime;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public int getVersion() {
        return this.f18302version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
        int i = this.f18302version;
        if (i != 1) {
            aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(i));
        }
        aSN1EncodableVector.m14420add(this.dvReqInfo);
        aSN1EncodableVector.m14420add(this.messageImprint);
        aSN1EncodableVector.m14420add(this.serialNumber);
        aSN1EncodableVector.m14420add(this.responseTime);
        PKIStatusInfo pKIStatusInfo = this.dvStatus;
        if (pKIStatusInfo != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) pKIStatusInfo));
        }
        PolicyInformation policyInformation = this.f18301policy;
        if (policyInformation != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) policyInformation));
        }
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.reqSignature;
        if (abstractC5093ASN1Set != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 2, (ASN1Encodable) abstractC5093ASN1Set));
        }
        ASN1Sequence aSN1Sequence = this.f18300certs;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 3, (ASN1Encodable) aSN1Sequence));
        }
        Extensions extensions = this.extensions;
        if (extensions != null) {
            aSN1EncodableVector.m14420add(extensions);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DVCSCertInfo {\n");
        if (this.f18302version != 1) {
            sb.append("version: " + this.f18302version + "\n");
        }
        sb.append("dvReqInfo: " + this.dvReqInfo + "\n");
        sb.append("messageImprint: " + this.messageImprint + "\n");
        sb.append("serialNumber: " + this.serialNumber + "\n");
        sb.append("responseTime: " + this.responseTime + "\n");
        if (this.dvStatus != null) {
            sb.append("dvStatus: " + this.dvStatus + "\n");
        }
        if (this.f18301policy != null) {
            sb.append("policy: " + this.f18301policy + "\n");
        }
        if (this.reqSignature != null) {
            sb.append("reqSignature: " + this.reqSignature + "\n");
        }
        if (this.f18300certs != null) {
            sb.append("certs: " + this.f18300certs + "\n");
        }
        if (this.extensions != null) {
            sb.append("extensions: " + this.extensions + "\n");
        }
        sb.append("}\n");
        return sb.toString();
    }

    public DVCSCertInfo(DVCSRequestInformation dVCSRequestInformation, DigestInfo digestInfo, ASN1Integer aSN1Integer, DVCSTime dVCSTime) {
        this.f18302version = 1;
        this.dvReqInfo = dVCSRequestInformation;
        this.messageImprint = digestInfo;
        this.serialNumber = aSN1Integer;
        this.responseTime = dVCSTime;
    }

    public static DVCSCertInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
