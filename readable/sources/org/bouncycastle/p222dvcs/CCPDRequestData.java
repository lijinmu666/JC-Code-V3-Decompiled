package org.bouncycastle.p222dvcs;

import org.bouncycastle.p133asn1.p142dvcs.C5124Data;

/* loaded from: classes2.dex */
public class CCPDRequestData extends DVCSRequestData {
    public CCPDRequestData(C5124Data c5124Data) throws DVCSConstructionException {
        super(c5124Data);
        initDigest();
    }

    private void initDigest() throws DVCSConstructionException {
        if (this.f21144data.getMessageImprint() == null) {
            throw new DVCSConstructionException("DVCSRequest.data.messageImprint should be specified for CCPD service");
        }
    }

    public MessageImprint getMessageImprint() {
        return new MessageImprint(this.f21144data.getMessageImprint());
    }
}
