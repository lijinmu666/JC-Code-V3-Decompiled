package org.bouncycastle.p133asn1.p142dvcs;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p138cmp.PKIStatusInfo;
import org.bouncycastle.p133asn1.p174x509.DigestInfo;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.PolicyInformation;

/* loaded from: classes2.dex */
public class DVCSCertInfoBuilder {
    private static final int DEFAULT_VERSION = 1;
    private static final int TAG_CERTS = 3;
    private static final int TAG_DV_STATUS = 0;
    private static final int TAG_POLICY = 1;
    private static final int TAG_REQ_SIGNATURE = 2;

    /* renamed from: certs */
    private ASN1Sequence f18303certs;
    private DVCSRequestInformation dvReqInfo;
    private PKIStatusInfo dvStatus;
    private Extensions extensions;
    private DigestInfo messageImprint;

    /* renamed from: policy */
    private PolicyInformation f18304policy;
    private AbstractC5093ASN1Set reqSignature;
    private DVCSTime responseTime;
    private ASN1Integer serialNumber;

    /* renamed from: version */
    private int f18305version = 1;

    public DVCSCertInfoBuilder(DVCSRequestInformation dVCSRequestInformation, DigestInfo digestInfo, ASN1Integer aSN1Integer, DVCSTime dVCSTime) {
        this.dvReqInfo = dVCSRequestInformation;
        this.messageImprint = digestInfo;
        this.serialNumber = aSN1Integer;
        this.responseTime = dVCSTime;
    }

    /* renamed from: build */
    public DVCSCertInfo m14582build() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
        int i = this.f18305version;
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
        PolicyInformation policyInformation = this.f18304policy;
        if (policyInformation != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) policyInformation));
        }
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.reqSignature;
        if (abstractC5093ASN1Set != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 2, (ASN1Encodable) abstractC5093ASN1Set));
        }
        ASN1Sequence aSN1Sequence = this.f18303certs;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 3, (ASN1Encodable) aSN1Sequence));
        }
        Extensions extensions = this.extensions;
        if (extensions != null) {
            aSN1EncodableVector.m14420add(extensions);
        }
        return DVCSCertInfo.getInstance(new DERSequence(aSN1EncodableVector));
    }

    public void setCerts(TargetEtcChain[] targetEtcChainArr) {
        this.f18303certs = new DERSequence(targetEtcChainArr);
    }

    public void setDvReqInfo(DVCSRequestInformation dVCSRequestInformation) {
        this.dvReqInfo = dVCSRequestInformation;
    }

    public void setDvStatus(PKIStatusInfo pKIStatusInfo) {
        this.dvStatus = pKIStatusInfo;
    }

    public void setExtensions(Extensions extensions) {
        this.extensions = extensions;
    }

    public void setMessageImprint(DigestInfo digestInfo) {
        this.messageImprint = digestInfo;
    }

    public void setPolicy(PolicyInformation policyInformation) {
        this.f18304policy = policyInformation;
    }

    public void setReqSignature(AbstractC5093ASN1Set abstractC5093ASN1Set) {
        this.reqSignature = abstractC5093ASN1Set;
    }

    public void setResponseTime(DVCSTime dVCSTime) {
        this.responseTime = dVCSTime;
    }

    public void setSerialNumber(ASN1Integer aSN1Integer) {
        this.serialNumber = aSN1Integer;
    }

    public void setVersion(int i) {
        this.f18305version = i;
    }
}
