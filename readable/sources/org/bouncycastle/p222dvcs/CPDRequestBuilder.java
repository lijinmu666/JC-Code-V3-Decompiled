package org.bouncycastle.p222dvcs;

import org.bouncycastle.p133asn1.p142dvcs.C5124Data;
import org.bouncycastle.p133asn1.p142dvcs.DVCSRequestInformationBuilder;
import org.bouncycastle.p133asn1.p142dvcs.ServiceType;

/* loaded from: classes2.dex */
public class CPDRequestBuilder extends DVCSRequestBuilder {
    public CPDRequestBuilder() {
        super(new DVCSRequestInformationBuilder(ServiceType.f18320CPD));
    }

    /* renamed from: build */
    public DVCSRequest m15938build(byte[] bArr) {
        return createDVCRequest(new C5124Data(bArr));
    }
}
