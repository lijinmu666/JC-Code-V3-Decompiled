package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class GOST3410PrivateKeyParameters extends GOST3410KeyParameters {

    /* renamed from: x */
    private BigInteger f20758x;

    public GOST3410PrivateKeyParameters(BigInteger bigInteger, GOST3410Parameters gOST3410Parameters) {
        super(true, gOST3410Parameters);
        this.f20758x = bigInteger;
    }

    /* renamed from: getX */
    public BigInteger m15753getX() {
        return this.f20758x;
    }
}
