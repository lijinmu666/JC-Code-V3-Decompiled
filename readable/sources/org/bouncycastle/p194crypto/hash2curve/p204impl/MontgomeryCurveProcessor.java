package org.bouncycastle.p194crypto.hash2curve.p204impl;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.hash2curve.CurveProcessor;
import org.bouncycastle.p194crypto.hash2curve.p203data.AffineXY;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class MontgomeryCurveProcessor implements CurveProcessor {

    /* renamed from: J */
    private final int f20317J;

    /* renamed from: K */
    private final int f20318K;

    /* renamed from: curve */
    private final AbstractC5817ECCurve f20319curve;

    /* renamed from: hEff */
    private final BigInteger f20320hEff;

    /* renamed from: p */
    private final BigInteger f20321p;

    public MontgomeryCurveProcessor(AbstractC5817ECCurve abstractC5817ECCurve, int i, int i2, int i3) {
        this.f20317J = i;
        this.f20318K = i2;
        this.f20319curve = abstractC5817ECCurve;
        this.f20321p = abstractC5817ECCurve.getField().getCharacteristic();
        this.f20320hEff = BigInteger.valueOf(i3);
    }

    /* renamed from: Fmtow */
    private AffineXY m15529Fmtow(BigInteger bigInteger, BigInteger bigInteger2) {
        return new AffineXY(bigInteger.mod(this.f20321p).add(BigInteger.valueOf(this.f20317J).mod(this.f20321p).multiply(BigInteger.valueOf(this.f20318K).mod(this.f20321p).modInverse(this.f20321p)).mod(this.f20321p).multiply(BigInteger.valueOf(3L).modInverse(this.f20321p)).mod(this.f20321p)).mod(this.f20321p), bigInteger2.mod(this.f20321p).multiply(BigInteger.valueOf(this.f20318K).mod(this.f20321p).modInverse(this.f20321p)).mod(this.f20321p));
    }

    /* renamed from: Fwtom */
    private AffineXY m15531Fwtom(BigInteger bigInteger, BigInteger bigInteger2) {
        return new AffineXY(bigInteger.mod(this.f20321p).subtract(BigInteger.valueOf(this.f20317J).mod(this.f20321p).multiply(BigInteger.valueOf(this.f20318K).mod(this.f20321p).modInverse(this.f20321p)).mod(this.f20321p).multiply(BigInteger.valueOf(3L).modInverse(this.f20321p)).mod(this.f20321p)).mod(this.f20321p), bigInteger2.mod(this.f20321p).multiply(BigInteger.valueOf(this.f20318K).mod(this.f20321p)).mod(this.f20321p));
    }

    @Override // org.bouncycastle.p194crypto.hash2curve.CurveProcessor
    /* renamed from: add */
    public AbstractC5820ECPoint mo15506add(AbstractC5820ECPoint abstractC5820ECPoint, AbstractC5820ECPoint abstractC5820ECPoint2) {
        return m15532Fwtom(m15530Fmtow(abstractC5820ECPoint).m15528toPoint(this.f20319curve).mo16330add(m15530Fmtow(abstractC5820ECPoint2).m15528toPoint(this.f20319curve)).normalize()).m15528toPoint(this.f20319curve);
    }

    @Override // org.bouncycastle.p194crypto.hash2curve.CurveProcessor
    public AbstractC5820ECPoint clearCofactor(AbstractC5820ECPoint abstractC5820ECPoint) {
        return abstractC5820ECPoint.isInfinity() ? abstractC5820ECPoint : m15530Fmtow(abstractC5820ECPoint).m15528toPoint(this.f20319curve).multiply(this.f20320hEff).normalize();
    }

    @Override // org.bouncycastle.p194crypto.hash2curve.CurveProcessor
    public AffineXY mapToAffineXY(AbstractC5820ECPoint abstractC5820ECPoint) {
        return m15532Fwtom(abstractC5820ECPoint.normalize());
    }

    /* renamed from: Fmtow */
    private AffineXY m15530Fmtow(AbstractC5820ECPoint abstractC5820ECPoint) {
        if (abstractC5820ECPoint.isInfinity()) {
            BigInteger bigInteger = BigInteger.ZERO;
            return new AffineXY(bigInteger, bigInteger);
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = abstractC5820ECPoint.normalize();
        return m15529Fmtow(abstractC5820ECPointNormalize.getAffineXCoord().toBigInteger(), abstractC5820ECPointNormalize.getAffineYCoord().toBigInteger());
    }

    /* renamed from: Fwtom */
    private AffineXY m15532Fwtom(AbstractC5820ECPoint abstractC5820ECPoint) {
        if (abstractC5820ECPoint.isInfinity()) {
            BigInteger bigInteger = BigInteger.ZERO;
            return new AffineXY(bigInteger, bigInteger);
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = abstractC5820ECPoint.normalize();
        return m15531Fwtom(abstractC5820ECPointNormalize.getAffineXCoord().toBigInteger(), abstractC5820ECPointNormalize.getAffineYCoord().toBigInteger());
    }
}
