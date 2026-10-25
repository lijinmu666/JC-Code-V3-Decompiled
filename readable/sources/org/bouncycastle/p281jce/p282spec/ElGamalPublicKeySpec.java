package org.bouncycastle.p281jce.p282spec;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class ElGamalPublicKeySpec extends ElGamalKeySpec {

    /* renamed from: y */
    private BigInteger f22069y;

    public ElGamalPublicKeySpec(BigInteger bigInteger, ElGamalParameterSpec elGamalParameterSpec) {
        super(elGamalParameterSpec);
        this.f22069y = bigInteger;
    }

    /* renamed from: getY */
    public BigInteger m16278getY() {
        return this.f22069y;
    }
}
