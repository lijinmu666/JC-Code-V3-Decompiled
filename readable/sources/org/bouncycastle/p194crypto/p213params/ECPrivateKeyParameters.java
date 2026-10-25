package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class ECPrivateKeyParameters extends ECKeyParameters {

    /* renamed from: d */
    private final BigInteger f20740d;

    public ECPrivateKeyParameters(BigInteger bigInteger, ECDomainParameters eCDomainParameters) {
        super(true, eCDomainParameters);
        this.f20740d = eCDomainParameters.validatePrivateScalar(bigInteger);
    }

    /* renamed from: getD */
    public BigInteger m15727getD() {
        return this.f20740d;
    }
}
