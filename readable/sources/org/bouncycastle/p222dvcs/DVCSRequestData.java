package org.bouncycastle.p222dvcs;

import org.bouncycastle.p133asn1.p142dvcs.C5124Data;

/* loaded from: classes2.dex */
public abstract class DVCSRequestData {

    /* renamed from: data */
    protected C5124Data f21144data;

    public DVCSRequestData(C5124Data c5124Data) {
        this.f21144data = c5124Data;
    }

    public C5124Data toASN1Structure() {
        return this.f21144data;
    }
}
