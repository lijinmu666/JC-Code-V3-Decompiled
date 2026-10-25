package org.bouncycastle.p222dvcs;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p139cms.SignedData;
import org.bouncycastle.p133asn1.p142dvcs.DVCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p142dvcs.ServiceType;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p191cms.CMSSignedData;

/* loaded from: classes2.dex */
public class DVCSRequest extends DVCSMessage {

    /* renamed from: asn1 */
    private org.bouncycastle.p133asn1.p142dvcs.DVCSRequest f21141asn1;

    /* renamed from: data */
    private DVCSRequestData f21142data;

    /* renamed from: reqInfo */
    private DVCSRequestInfo f21143reqInfo;

    public DVCSRequest(ContentInfo contentInfo) throws DVCSConstructionException {
        DVCSRequestData cCPDRequestData;
        super(contentInfo);
        if (!DVCSObjectIdentifiers.id_ct_DVCSRequestData.m14446equals((ASN1Primitive) contentInfo.getContentType())) {
            throw new DVCSConstructionException("ContentInfo not a DVCS Request");
        }
        try {
            this.f21141asn1 = contentInfo.getContent().toASN1Primitive() instanceof ASN1Sequence ? org.bouncycastle.p133asn1.p142dvcs.DVCSRequest.getInstance(contentInfo.getContent()) : org.bouncycastle.p133asn1.p142dvcs.DVCSRequest.getInstance(ASN1OctetString.getInstance(contentInfo.getContent()).getOctets());
            DVCSRequestInfo dVCSRequestInfo = new DVCSRequestInfo(this.f21141asn1.getRequestInformation());
            this.f21143reqInfo = dVCSRequestInfo;
            int serviceType = dVCSRequestInfo.getServiceType();
            if (serviceType == ServiceType.f18320CPD.getValue().intValue()) {
                cCPDRequestData = new CPDRequestData(this.f21141asn1.m14583getData());
            } else if (serviceType == ServiceType.f18322VSD.getValue().intValue()) {
                cCPDRequestData = new VSDRequestData(this.f21141asn1.m14583getData());
            } else if (serviceType == ServiceType.f18321VPKC.getValue().intValue()) {
                cCPDRequestData = new VPKCRequestData(this.f21141asn1.m14583getData());
            } else {
                if (serviceType != ServiceType.f18319CCPD.getValue().intValue()) {
                    throw new DVCSConstructionException("Unknown service type: " + serviceType);
                }
                cCPDRequestData = new CCPDRequestData(this.f21141asn1.m14583getData());
            }
            this.f21142data = cCPDRequestData;
        } catch (Exception e) {
            throw new DVCSConstructionException("Unable to parse content: " + e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.p222dvcs.DVCSMessage
    public ASN1Encodable getContent() {
        return this.f21141asn1;
    }

    /* renamed from: getData */
    public DVCSRequestData m15939getData() {
        return this.f21142data;
    }

    public DVCSRequestInfo getRequestInfo() {
        return this.f21143reqInfo;
    }

    public GeneralName getTransactionIdentifier() {
        return this.f21141asn1.getTransactionIdentifier();
    }

    public DVCSRequest(CMSSignedData cMSSignedData) {
        this(SignedData.getInstance(cMSSignedData.toASN1Structure().getContent()).getEncapContentInfo());
    }
}
