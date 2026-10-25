package org.bouncycastle.p222dvcs;

import org.bouncycastle.p133asn1.p142dvcs.C5124Data;

/* loaded from: classes2.dex */
public class CPDRequestData extends DVCSRequestData {
    public CPDRequestData(C5124Data c5124Data) throws DVCSConstructionException {
        super(c5124Data);
        initMessage();
    }

    private void initMessage() throws DVCSConstructionException {
        if (this.f21144data.getMessage() == null) {
            throw new DVCSConstructionException("DVCSRequest.data.message should be specified for CPD service");
        }
    }

    public byte[] getMessage() {
        return this.f21144data.getMessage().getOctets();
    }
}
