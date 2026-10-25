package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class DSTU4145Parameters extends ECDomainParameters {

    /* renamed from: dke */
    private final byte[] f20722dke;

    public DSTU4145Parameters(ECDomainParameters eCDomainParameters, byte[] bArr) {
        super(eCDomainParameters.getCurve(), eCDomainParameters.m15720getG(), eCDomainParameters.m15723getN(), eCDomainParameters.m15721getH(), eCDomainParameters.m15724getSeed());
        this.f20722dke = C6238Arrays.m18231clone(bArr);
    }

    /* renamed from: getDKE */
    public byte[] m15711getDKE() {
        return C6238Arrays.m18231clone(this.f20722dke);
    }
}
