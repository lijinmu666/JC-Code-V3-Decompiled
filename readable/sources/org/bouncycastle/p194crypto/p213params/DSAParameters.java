package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.CipherParameters;

/* loaded from: classes2.dex */
public class DSAParameters implements CipherParameters {

    /* renamed from: g */
    private BigInteger f20713g;

    /* renamed from: p */
    private BigInteger f20714p;

    /* renamed from: q */
    private BigInteger f20715q;
    private DSAValidationParameters validation;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f20713g = bigInteger3;
        this.f20714p = bigInteger;
        this.f20715q = bigInteger2;
    }

    /* renamed from: equals */
    public boolean m15703equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        DSAParameters dSAParameters = (DSAParameters) obj;
        return dSAParameters.m15705getP().equals(this.f20714p) && dSAParameters.m15706getQ().equals(this.f20715q) && dSAParameters.m15704getG().equals(this.f20713g);
    }

    /* renamed from: getG */
    public BigInteger m15704getG() {
        return this.f20713g;
    }

    /* renamed from: getP */
    public BigInteger m15705getP() {
        return this.f20714p;
    }

    /* renamed from: getQ */
    public BigInteger m15706getQ() {
        return this.f20715q;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return m15704getG().hashCode() ^ (m15705getP().hashCode() ^ m15706getQ().hashCode());
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, DSAValidationParameters dSAValidationParameters) {
        this.f20713g = bigInteger3;
        this.f20714p = bigInteger;
        this.f20715q = bigInteger2;
        this.validation = dSAValidationParameters;
    }
}
