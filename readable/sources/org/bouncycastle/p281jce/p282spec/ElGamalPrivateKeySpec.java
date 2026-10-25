package org.bouncycastle.p281jce.p282spec;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class ElGamalPrivateKeySpec extends ElGamalKeySpec {

    /* renamed from: x */
    private BigInteger f22068x;

    public ElGamalPrivateKeySpec(BigInteger bigInteger, ElGamalParameterSpec elGamalParameterSpec) {
        super(elGamalParameterSpec);
        this.f22068x = bigInteger;
    }

    /* renamed from: getX */
    public BigInteger m16277getX() {
        return this.f22068x;
    }
}
