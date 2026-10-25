package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.CipherParameters;

/* loaded from: classes2.dex */
public class GOST3410Parameters implements CipherParameters {

    /* renamed from: a */
    private BigInteger f20755a;

    /* renamed from: p */
    private BigInteger f20756p;

    /* renamed from: q */
    private BigInteger f20757q;
    private GOST3410ValidationParameters validation;

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f20756p = bigInteger;
        this.f20757q = bigInteger2;
        this.f20755a = bigInteger3;
    }

    /* renamed from: equals */
    public boolean m15749equals(Object obj) {
        if (!(obj instanceof GOST3410Parameters)) {
            return false;
        }
        GOST3410Parameters gOST3410Parameters = (GOST3410Parameters) obj;
        return gOST3410Parameters.m15751getP().equals(this.f20756p) && gOST3410Parameters.m15752getQ().equals(this.f20757q) && gOST3410Parameters.m15750getA().equals(this.f20755a);
    }

    /* renamed from: getA */
    public BigInteger m15750getA() {
        return this.f20755a;
    }

    /* renamed from: getP */
    public BigInteger m15751getP() {
        return this.f20756p;
    }

    /* renamed from: getQ */
    public BigInteger m15752getQ() {
        return this.f20757q;
    }

    public GOST3410ValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return this.f20755a.hashCode() ^ (this.f20756p.hashCode() ^ this.f20757q.hashCode());
    }

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, GOST3410ValidationParameters gOST3410ValidationParameters) {
        this.f20755a = bigInteger3;
        this.f20756p = bigInteger;
        this.f20757q = bigInteger2;
        this.validation = gOST3410ValidationParameters;
    }
}
