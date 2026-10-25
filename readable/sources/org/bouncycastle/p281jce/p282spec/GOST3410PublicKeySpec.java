package org.bouncycastle.p281jce.p282spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* loaded from: classes2.dex */
public class GOST3410PublicKeySpec implements KeySpec {

    /* renamed from: a */
    private BigInteger f22077a;

    /* renamed from: p */
    private BigInteger f22078p;

    /* renamed from: q */
    private BigInteger f22079q;

    /* renamed from: y */
    private BigInteger f22080y;

    public GOST3410PublicKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f22080y = bigInteger;
        this.f22078p = bigInteger2;
        this.f22079q = bigInteger3;
        this.f22077a = bigInteger4;
    }

    /* renamed from: getA */
    public BigInteger m16288getA() {
        return this.f22077a;
    }

    /* renamed from: getP */
    public BigInteger m16289getP() {
        return this.f22078p;
    }

    /* renamed from: getQ */
    public BigInteger m16290getQ() {
        return this.f22079q;
    }

    /* renamed from: getY */
    public BigInteger m16291getY() {
        return this.f22080y;
    }
}
