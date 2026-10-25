package org.bouncycastle.p222dvcs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bouncycastle.p133asn1.p142dvcs.C5124Data;
import org.bouncycastle.p133asn1.p142dvcs.TargetEtcChain;

/* loaded from: classes2.dex */
public class VPKCRequestData extends DVCSRequestData {

    /* renamed from: chains */
    private List f21149chains;

    public VPKCRequestData(C5124Data c5124Data) throws DVCSConstructionException {
        super(c5124Data);
        TargetEtcChain[] certs = c5124Data.getCerts();
        if (certs == null) {
            throw new DVCSConstructionException("DVCSRequest.data.certs should be specified for VPKC service");
        }
        this.f21149chains = new ArrayList(certs.length);
        for (int i = 0; i != certs.length; i++) {
            this.f21149chains.add(new TargetChain(certs[i]));
        }
    }

    public List getCerts() {
        return Collections.unmodifiableList(this.f21149chains);
    }
}
