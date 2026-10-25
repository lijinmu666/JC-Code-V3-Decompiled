package org.bouncycastle.p222dvcs;

import org.bouncycastle.p133asn1.p142dvcs.C5124Data;
import org.bouncycastle.p133asn1.p142dvcs.DVCSRequestInformationBuilder;
import org.bouncycastle.p133asn1.p142dvcs.ServiceType;

/* loaded from: classes2.dex */
public class CCPDRequestBuilder extends DVCSRequestBuilder {
    public CCPDRequestBuilder() {
        super(new DVCSRequestInformationBuilder(ServiceType.f18319CCPD));
    }

    /* renamed from: build */
    public DVCSRequest m15937build(MessageImprint messageImprint) {
        return createDVCRequest(new C5124Data(messageImprint.toASN1Structure()));
    }
}
