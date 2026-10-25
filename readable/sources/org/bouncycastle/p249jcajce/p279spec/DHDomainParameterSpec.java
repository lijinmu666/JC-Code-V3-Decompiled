package org.bouncycastle.p249jcajce.p279spec;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p194crypto.p213params.DHValidationParameters;

/* loaded from: classes2.dex */
public class DHDomainParameterSpec extends DHParameterSpec {

    /* renamed from: j */
    private final BigInteger f21912j;

    /* renamed from: m */
    private final int f21913m;

    /* renamed from: q */
    private final BigInteger f21914q;
    private DHValidationParameters validationParameters;

    public DHDomainParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, null, 0);
    }

    public DHParameters getDomainParameters() {
        return new DHParameters(getP(), getG(), this.f21914q, this.f21913m, getL(), this.f21912j, this.validationParameters);
    }

    /* renamed from: getJ */
    public BigInteger m16185getJ() {
        return this.f21912j;
    }

    /* renamed from: getM */
    public int m16186getM() {
        return this.f21913m;
    }

    /* renamed from: getQ */
    public BigInteger m16187getQ() {
        return this.f21914q;
    }

    public DHDomainParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i) {
        this(bigInteger, bigInteger2, bigInteger3, null, i);
    }

    public DHDomainParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i) {
        this(bigInteger, bigInteger2, bigInteger3, bigInteger4, 0, i);
    }

    public DHDomainParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i, int i2) {
        super(bigInteger, bigInteger3, i2);
        this.f21914q = bigInteger2;
        this.f21912j = bigInteger4;
        this.f21913m = i;
    }

    public DHDomainParameterSpec(DHParameters dHParameters) {
        this(dHParameters.m15695getP(), dHParameters.m15696getQ(), dHParameters.m15691getG(), dHParameters.m15692getJ(), dHParameters.m15694getM(), dHParameters.m15693getL());
        this.validationParameters = dHParameters.getValidationParameters();
    }
}
