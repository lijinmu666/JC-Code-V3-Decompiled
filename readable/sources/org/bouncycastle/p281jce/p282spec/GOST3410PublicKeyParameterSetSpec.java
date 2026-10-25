package org.bouncycastle.p281jce.p282spec;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class GOST3410PublicKeyParameterSetSpec {

    /* renamed from: a */
    private BigInteger f22074a;

    /* renamed from: p */
    private BigInteger f22075p;

    /* renamed from: q */
    private BigInteger f22076q;

    public GOST3410PublicKeyParameterSetSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f22075p = bigInteger;
        this.f22076q = bigInteger2;
        this.f22074a = bigInteger3;
    }

    /* renamed from: equals */
    public boolean m16284equals(Object obj) {
        if (!(obj instanceof GOST3410PublicKeyParameterSetSpec)) {
            return false;
        }
        GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec = (GOST3410PublicKeyParameterSetSpec) obj;
        return this.f22074a.equals(gOST3410PublicKeyParameterSetSpec.f22074a) && this.f22075p.equals(gOST3410PublicKeyParameterSetSpec.f22075p) && this.f22076q.equals(gOST3410PublicKeyParameterSetSpec.f22076q);
    }

    /* renamed from: getA */
    public BigInteger m16285getA() {
        return this.f22074a;
    }

    /* renamed from: getP */
    public BigInteger m16286getP() {
        return this.f22075p;
    }

    /* renamed from: getQ */
    public BigInteger m16287getQ() {
        return this.f22076q;
    }

    public int hashCode() {
        return this.f22076q.hashCode() ^ (this.f22074a.hashCode() ^ this.f22075p.hashCode());
    }
}
