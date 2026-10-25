package org.bouncycastle.p222dvcs;

import org.bouncycastle.p133asn1.p142dvcs.C5124Data;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.CMSSignedData;

/* loaded from: classes2.dex */
public class VSDRequestData extends DVCSRequestData {

    /* renamed from: doc */
    private CMSSignedData f21150doc;

    public VSDRequestData(C5124Data c5124Data) throws DVCSConstructionException {
        super(c5124Data);
        initDocument();
    }

    private void initDocument() throws DVCSConstructionException {
        if (this.f21150doc == null) {
            if (this.f21144data.getMessage() == null) {
                throw new DVCSConstructionException("DVCSRequest.data.message should be specified for VSD service");
            }
            try {
                this.f21150doc = new CMSSignedData(this.f21144data.getMessage().getOctets());
            } catch (CMSException e) {
                throw new DVCSConstructionException("Can't read CMS SignedData from input", e);
            }
        }
    }

    public byte[] getMessage() {
        return this.f21144data.getMessage().getOctets();
    }

    public CMSSignedData getParsedMessage() {
        return this.f21150doc;
    }
}
