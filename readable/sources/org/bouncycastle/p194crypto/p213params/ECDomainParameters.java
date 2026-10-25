package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ECDomainParameters implements ECConstants {

    /* renamed from: G */
    private final AbstractC5820ECPoint f20733G;

    /* renamed from: curve */
    private final AbstractC5817ECCurve f20734curve;

    /* renamed from: h */
    private final BigInteger f20735h;

    /* renamed from: hInv */
    private BigInteger f20736hInv;

    /* renamed from: n */
    private final BigInteger f20737n;

    /* renamed from: seed */
    private final byte[] f20738seed;

    public ECDomainParameters(X9ECParameters x9ECParameters) {
        this(x9ECParameters.getCurve(), x9ECParameters.m14735getG(), x9ECParameters.m14737getN(), x9ECParameters.m14736getH(), x9ECParameters.m14738getSeed());
    }

    public static AbstractC5820ECPoint validatePublicPoint(AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint) {
        if (abstractC5820ECPoint == null) {
            throw new NullPointerException("Point cannot be null");
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = ECAlgorithms.importPoint(abstractC5817ECCurve, abstractC5820ECPoint).normalize();
        if (abstractC5820ECPointNormalize.isInfinity()) {
            throw new IllegalArgumentException("Point at infinity");
        }
        if (abstractC5820ECPointNormalize.m16334isValid()) {
            return abstractC5820ECPointNormalize;
        }
        throw new IllegalArgumentException("Point not on curve");
    }

    /* renamed from: equals */
    public boolean m15719equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ECDomainParameters)) {
            return false;
        }
        ECDomainParameters eCDomainParameters = (ECDomainParameters) obj;
        return this.f20734curve.m16297equals(eCDomainParameters.f20734curve) && this.f20733G.m16333equals(eCDomainParameters.f20733G) && this.f20737n.equals(eCDomainParameters.f20737n);
    }

    public AbstractC5817ECCurve getCurve() {
        return this.f20734curve;
    }

    /* renamed from: getG */
    public AbstractC5820ECPoint m15720getG() {
        return this.f20733G;
    }

    /* renamed from: getH */
    public BigInteger m15721getH() {
        return this.f20735h;
    }

    /* renamed from: getHInv */
    public synchronized BigInteger m15722getHInv() {
        try {
            if (this.f20736hInv == null) {
                this.f20736hInv = BigIntegers.modOddInverseVar(this.f20737n, this.f20735h);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f20736hInv;
    }

    /* renamed from: getN */
    public BigInteger m15723getN() {
        return this.f20737n;
    }

    /* renamed from: getSeed */
    public byte[] m15724getSeed() {
        return C6238Arrays.m18231clone(this.f20738seed);
    }

    public int hashCode() {
        return this.f20737n.hashCode() ^ ((((this.f20734curve.hashCode() ^ 1028) * 257) ^ this.f20733G.hashCode()) * 257);
    }

    public BigInteger validatePrivateScalar(BigInteger bigInteger) {
        if (bigInteger == null) {
            throw new NullPointerException("Scalar cannot be null");
        }
        if (bigInteger.compareTo(ECConstants.f22091ONE) < 0 || bigInteger.compareTo(m15723getN()) >= 0) {
            throw new IllegalArgumentException("Scalar is not in the interval [1, n - 1]");
        }
        return bigInteger;
    }

    public ECDomainParameters(AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger) {
        this(abstractC5817ECCurve, abstractC5820ECPoint, bigInteger, ECConstants.f22091ONE, null);
    }

    public AbstractC5820ECPoint validatePublicPoint(AbstractC5820ECPoint abstractC5820ECPoint) {
        return validatePublicPoint(getCurve(), abstractC5820ECPoint);
    }

    public ECDomainParameters(AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(abstractC5817ECCurve, abstractC5820ECPoint, bigInteger, bigInteger2, null);
    }

    public ECDomainParameters(AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f20736hInv = null;
        if (abstractC5817ECCurve == null) {
            throw new NullPointerException("curve");
        }
        if (bigInteger == null) {
            throw new NullPointerException("n");
        }
        this.f20734curve = abstractC5817ECCurve;
        this.f20733G = validatePublicPoint(abstractC5817ECCurve, abstractC5820ECPoint);
        this.f20737n = bigInteger;
        this.f20735h = bigInteger2;
        this.f20738seed = C6238Arrays.m18231clone(bArr);
    }
}
