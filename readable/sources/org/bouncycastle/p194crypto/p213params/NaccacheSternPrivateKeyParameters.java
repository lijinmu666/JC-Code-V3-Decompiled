package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;
import java.util.Vector;

/* loaded from: classes2.dex */
public class NaccacheSternPrivateKeyParameters extends NaccacheSternKeyParameters {

    /* renamed from: phi_n */
    private BigInteger f20810phi_n;
    private Vector smallPrimes;

    public NaccacheSternPrivateKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, int i, Vector vector, BigInteger bigInteger3) {
        super(true, bigInteger, bigInteger2, i);
        this.smallPrimes = vector;
        this.f20810phi_n = bigInteger3;
    }

    public BigInteger getPhi_n() {
        return this.f20810phi_n;
    }

    public Vector getSmallPrimes() {
        return this.smallPrimes;
    }
}
