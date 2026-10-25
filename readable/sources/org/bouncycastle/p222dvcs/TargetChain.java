package org.bouncycastle.p222dvcs;

import org.bouncycastle.p133asn1.p142dvcs.TargetEtcChain;

/* loaded from: classes2.dex */
public class TargetChain {

    /* renamed from: certs */
    private final TargetEtcChain f21147certs;

    public TargetChain(TargetEtcChain targetEtcChain) {
        this.f21147certs = targetEtcChain;
    }

    public TargetEtcChain toASN1Structure() {
        return this.f21147certs;
    }
}
