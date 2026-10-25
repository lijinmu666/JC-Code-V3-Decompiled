package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class DSAPrivateKeyParameters extends DSAKeyParameters {

    /* renamed from: x */
    private BigInteger f20716x;

    public DSAPrivateKeyParameters(BigInteger bigInteger, DSAParameters dSAParameters) {
        super(true, dSAParameters);
        this.f20716x = bigInteger;
    }

    /* renamed from: getX */
    public BigInteger m15707getX() {
        return this.f20716x;
    }
}
