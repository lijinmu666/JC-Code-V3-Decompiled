package org.bouncycastle.p222dvcs;

import java.io.IOException;
import java.util.Date;
import org.bouncycastle.p133asn1.p142dvcs.C5124Data;
import org.bouncycastle.p133asn1.p142dvcs.DVCSRequestInformationBuilder;
import org.bouncycastle.p133asn1.p142dvcs.DVCSTime;
import org.bouncycastle.p133asn1.p142dvcs.ServiceType;
import org.bouncycastle.p191cms.CMSSignedData;

/* loaded from: classes2.dex */
public class VSDRequestBuilder extends DVCSRequestBuilder {
    public VSDRequestBuilder() {
        super(new DVCSRequestInformationBuilder(ServiceType.f18322VSD));
    }

    /* renamed from: build */
    public DVCSRequest m15946build(CMSSignedData cMSSignedData) throws DVCSException {
        try {
            return createDVCRequest(new C5124Data(cMSSignedData.getEncoded()));
        } catch (IOException e) {
            throw new DVCSException("Failed to encode CMS signed data", e);
        }
    }

    public void setRequestTime(Date date) {
        this.requestInformationBuilder.setRequestTime(new DVCSTime(date));
    }
}
