package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p361util.Properties;

/* loaded from: classes2.dex */
public class DHParameters implements CipherParameters {
    private static final int DEFAULT_MINIMUM_LENGTH = 160;

    /* renamed from: g */
    private BigInteger f20696g;

    /* renamed from: j */
    private BigInteger f20697j;

    /* renamed from: l */
    private int f20698l;

    /* renamed from: m */
    private int f20699m;

    /* renamed from: p */
    private BigInteger f20700p;

    /* renamed from: q */
    private BigInteger f20701q;
    private DHValidationParameters validation;

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, null, 0);
    }

    private static int getDefaultMParam(int i) {
        return (i != 0 && i < DEFAULT_MINIMUM_LENGTH) ? i : DEFAULT_MINIMUM_LENGTH;
    }

    /* renamed from: equals */
    public boolean m15690equals(Object obj) {
        if (!(obj instanceof DHParameters)) {
            return false;
        }
        DHParameters dHParameters = (DHParameters) obj;
        if (m15696getQ() != null) {
            if (!m15696getQ().equals(dHParameters.m15696getQ())) {
                return false;
            }
        } else if (dHParameters.m15696getQ() != null) {
            return false;
        }
        return dHParameters.m15695getP().equals(this.f20700p) && dHParameters.m15691getG().equals(this.f20696g);
    }

    /* renamed from: getG */
    public BigInteger m15691getG() {
        return this.f20696g;
    }

    /* renamed from: getJ */
    public BigInteger m15692getJ() {
        return this.f20697j;
    }

    /* renamed from: getL */
    public int m15693getL() {
        return this.f20698l;
    }

    /* renamed from: getM */
    public int m15694getM() {
        return this.f20699m;
    }

    /* renamed from: getP */
    public BigInteger m15695getP() {
        return this.f20700p;
    }

    /* renamed from: getQ */
    public BigInteger m15696getQ() {
        return this.f20701q;
    }

    public DHValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (m15696getQ() != null ? m15696getQ().hashCode() : 0) ^ (m15695getP().hashCode() ^ m15691getG().hashCode());
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, 0);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i) {
        this(bigInteger, bigInteger2, bigInteger3, getDefaultMParam(i), i, null, null);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i, int i2) {
        this(bigInteger, bigInteger2, bigInteger3, i, i2, null, null);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i, int i2, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        if (i2 != 0) {
            if (i2 > bigInteger.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            }
            if (i2 < i) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        if (i > bigInteger.bitLength() && !Properties.isOverrideSet("org.bouncycastle.dh.allow_unsafe_p_value")) {
            throw new IllegalArgumentException("unsafe p value so small specific l required");
        }
        this.f20696g = bigInteger2;
        this.f20700p = bigInteger;
        this.f20701q = bigInteger3;
        this.f20699m = i;
        this.f20698l = i2;
        this.f20697j = bigInteger4;
        this.validation = dHValidationParameters;
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        this(bigInteger, bigInteger2, bigInteger3, DEFAULT_MINIMUM_LENGTH, 0, bigInteger4, dHValidationParameters);
    }
}
