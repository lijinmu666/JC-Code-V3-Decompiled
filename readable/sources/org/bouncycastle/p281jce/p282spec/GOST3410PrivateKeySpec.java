package org.bouncycastle.p281jce.p282spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* loaded from: classes2.dex */
public class GOST3410PrivateKeySpec implements KeySpec {

    /* renamed from: a */
    private BigInteger f22070a;

    /* renamed from: p */
    private BigInteger f22071p;

    /* renamed from: q */
    private BigInteger f22072q;

    /* renamed from: x */
    private BigInteger f22073x;

    public GOST3410PrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f22073x = bigInteger;
        this.f22071p = bigInteger2;
        this.f22072q = bigInteger3;
        this.f22070a = bigInteger4;
    }

    /* renamed from: getA */
    public BigInteger m16280getA() {
        return this.f22070a;
    }

    /* renamed from: getP */
    public BigInteger m16281getP() {
        return this.f22071p;
    }

    /* renamed from: getQ */
    public BigInteger m16282getQ() {
        return this.f22072q;
    }

    /* renamed from: getX */
    public BigInteger m16283getX() {
        return this.f22073x;
    }
}
