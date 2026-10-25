package org.bouncycastle.p284math.p285ec;

import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.ECFieldElement;

/* renamed from: org.bouncycastle.math.ec.ECPoint */
/* loaded from: classes2.dex */
public abstract class AbstractC5820ECPoint {
    protected static final ECFieldElement[] EMPTY_ZS = new ECFieldElement[0];

    /* renamed from: curve */
    protected AbstractC5817ECCurve f22124curve;
    protected Hashtable preCompTable;

    /* renamed from: x */
    protected ECFieldElement f22125x;

    /* renamed from: y */
    protected ECFieldElement f22126y;

    /* renamed from: zs */
    protected ECFieldElement[] f22127zs;

    /* renamed from: org.bouncycastle.math.ec.ECPoint$AbstractF2m */
    public static abstract class AbstractF2m extends AbstractC5820ECPoint {
        public AbstractF2m(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        public boolean satisfiesCurveEquation() {
            ECFieldElement eCFieldElementMultiplyPlusProduct;
            ECFieldElement eCFieldElementSquarePlusProduct;
            AbstractC5817ECCurve curve = getCurve();
            ECFieldElement eCFieldElement = this.f22125x;
            ECFieldElement eCFieldElementM16298getA = curve.m16298getA();
            ECFieldElement eCFieldElementM16299getB = curve.m16299getB();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem != 6) {
                ECFieldElement eCFieldElement2 = this.f22126y;
                ECFieldElement eCFieldElementMultiply = eCFieldElement2.mo16310add(eCFieldElement).multiply(eCFieldElement2);
                if (coordinateSystem != 0) {
                    if (coordinateSystem != 1) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    ECFieldElement eCFieldElement3 = this.f22127zs[0];
                    if (!eCFieldElement3.mo16314isOne()) {
                        ECFieldElement eCFieldElementMultiply2 = eCFieldElement3.multiply(eCFieldElement3.mo16318square());
                        eCFieldElementMultiply = eCFieldElementMultiply.multiply(eCFieldElement3);
                        eCFieldElementM16298getA = eCFieldElementM16298getA.multiply(eCFieldElement3);
                        eCFieldElementM16299getB = eCFieldElementM16299getB.multiply(eCFieldElementMultiply2);
                    }
                }
                return eCFieldElementMultiply.equals(eCFieldElement.mo16310add(eCFieldElementM16298getA).multiply(eCFieldElement.mo16318square()).mo16310add(eCFieldElementM16299getB));
            }
            ECFieldElement eCFieldElement4 = this.f22127zs[0];
            boolean zMo16314isOne = eCFieldElement4.mo16314isOne();
            boolean zMo16315isZero = eCFieldElement.mo16315isZero();
            ECFieldElement eCFieldElement5 = this.f22126y;
            if (zMo16315isZero) {
                ECFieldElement eCFieldElementMo16318square = eCFieldElement5.mo16318square();
                if (!zMo16314isOne) {
                    eCFieldElementM16299getB = eCFieldElementM16299getB.multiply(eCFieldElement4.mo16318square());
                }
                return eCFieldElementMo16318square.equals(eCFieldElementM16299getB);
            }
            ECFieldElement eCFieldElementMo16318square2 = eCFieldElement.mo16318square();
            if (zMo16314isOne) {
                eCFieldElementMultiplyPlusProduct = eCFieldElement5.mo16318square().mo16310add(eCFieldElement5).mo16310add(eCFieldElementM16298getA);
                eCFieldElementSquarePlusProduct = eCFieldElementMo16318square2.mo16318square().mo16310add(eCFieldElementM16299getB);
            } else {
                ECFieldElement eCFieldElementMo16318square3 = eCFieldElement4.mo16318square();
                ECFieldElement eCFieldElementMo16318square4 = eCFieldElementMo16318square3.mo16318square();
                eCFieldElementMultiplyPlusProduct = eCFieldElement5.mo16310add(eCFieldElement4).multiplyPlusProduct(eCFieldElement5, eCFieldElementM16298getA, eCFieldElementMo16318square3);
                eCFieldElementSquarePlusProduct = eCFieldElementMo16318square2.squarePlusProduct(eCFieldElementM16299getB, eCFieldElementMo16318square4);
            }
            return eCFieldElementMultiplyPlusProduct.multiply(eCFieldElementMo16318square2).equals(eCFieldElementSquarePlusProduct);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        public boolean satisfiesOrder() {
            BigInteger cofactor = this.f22124curve.getCofactor();
            if (ECConstants.f22093TWO.equals(cofactor)) {
                return ((ECFieldElement.AbstractF2m) normalize().getAffineXCoord()).mo16319trace() != 0;
            }
            if (!ECConstants.f22090FOUR.equals(cofactor)) {
                return super.satisfiesOrder();
            }
            AbstractC5820ECPoint abstractC5820ECPointNormalize = normalize();
            ECFieldElement affineXCoord = abstractC5820ECPointNormalize.getAffineXCoord();
            AbstractC5817ECCurve abstractC5817ECCurve = this.f22124curve;
            ECFieldElement eCFieldElementSolveQuadraticEquation = ((AbstractC5817ECCurve.AbstractF2m) abstractC5817ECCurve).solveQuadraticEquation(affineXCoord.mo16310add(abstractC5817ECCurve.m16298getA()));
            if (eCFieldElementSolveQuadraticEquation == null) {
                return false;
            }
            return ((ECFieldElement.AbstractF2m) affineXCoord.multiply(eCFieldElementSolveQuadraticEquation).mo16310add(abstractC5820ECPointNormalize.getAffineYCoord())).mo16319trace() == 0;
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        /* renamed from: scaleX */
        public AbstractC5820ECPoint mo16336scaleX(ECFieldElement eCFieldElement) {
            if (isInfinity()) {
                return this;
            }
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem == 5) {
                ECFieldElement rawXCoord = getRawXCoord();
                ECFieldElement rawYCoord = getRawYCoord();
                return getCurve().createRawPoint(rawXCoord, rawYCoord.mo16310add(rawXCoord).mo16312divide(eCFieldElement).mo16310add(rawXCoord.multiply(eCFieldElement)), getRawZCoords());
            }
            if (curveCoordinateSystem != 6) {
                return super.mo16336scaleX(eCFieldElement);
            }
            ECFieldElement rawXCoord2 = getRawXCoord();
            ECFieldElement rawYCoord2 = getRawYCoord();
            ECFieldElement eCFieldElement2 = getRawZCoords()[0];
            ECFieldElement eCFieldElementMultiply = rawXCoord2.multiply(eCFieldElement.mo16318square());
            return getCurve().createRawPoint(eCFieldElementMultiply, rawYCoord2.mo16310add(rawXCoord2).mo16310add(eCFieldElementMultiply), new ECFieldElement[]{eCFieldElement2.multiply(eCFieldElement)});
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        public AbstractC5820ECPoint scaleXNegateY(ECFieldElement eCFieldElement) {
            return mo16336scaleX(eCFieldElement);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        /* renamed from: scaleY */
        public AbstractC5820ECPoint mo16337scaleY(ECFieldElement eCFieldElement) {
            if (isInfinity()) {
                return this;
            }
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 5 && curveCoordinateSystem != 6) {
                return super.mo16337scaleY(eCFieldElement);
            }
            ECFieldElement rawXCoord = getRawXCoord();
            return getCurve().createRawPoint(rawXCoord, getRawYCoord().mo16310add(rawXCoord).multiply(eCFieldElement).mo16310add(rawXCoord), getRawZCoords());
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        public AbstractC5820ECPoint scaleYNegateX(ECFieldElement eCFieldElement) {
            return mo16337scaleY(eCFieldElement);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        public AbstractC5820ECPoint subtract(AbstractC5820ECPoint abstractC5820ECPoint) {
            return abstractC5820ECPoint.isInfinity() ? this : mo16330add(abstractC5820ECPoint.mo16335negate());
        }

        /* renamed from: tau */
        public AbstractF2m m16339tau() {
            AbstractC5820ECPoint abstractC5820ECPointCreateRawPoint;
            if (isInfinity()) {
                return this;
            }
            AbstractC5817ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement = this.f22125x;
            if (coordinateSystem == 0) {
                abstractC5820ECPointCreateRawPoint = curve.createRawPoint(eCFieldElement.mo16318square(), this.f22126y.mo16318square());
            } else {
                if (coordinateSystem != 1) {
                    if (coordinateSystem != 5) {
                        if (coordinateSystem != 6) {
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                    }
                    abstractC5820ECPointCreateRawPoint = curve.createRawPoint(eCFieldElement.mo16318square(), this.f22126y.mo16318square());
                }
                abstractC5820ECPointCreateRawPoint = curve.createRawPoint(eCFieldElement.mo16318square(), this.f22126y.mo16318square(), new ECFieldElement[]{this.f22127zs[0].mo16318square()});
            }
            return (AbstractF2m) abstractC5820ECPointCreateRawPoint;
        }

        /* renamed from: tauPow */
        public AbstractF2m m16340tauPow(int i) {
            AbstractC5820ECPoint abstractC5820ECPointCreateRawPoint;
            if (isInfinity()) {
                return this;
            }
            AbstractC5817ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement = this.f22125x;
            if (coordinateSystem == 0) {
                abstractC5820ECPointCreateRawPoint = curve.createRawPoint(eCFieldElement.squarePow(i), this.f22126y.squarePow(i));
            } else {
                if (coordinateSystem != 1) {
                    if (coordinateSystem != 5) {
                        if (coordinateSystem != 6) {
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                    }
                    abstractC5820ECPointCreateRawPoint = curve.createRawPoint(eCFieldElement.squarePow(i), this.f22126y.squarePow(i));
                }
                abstractC5820ECPointCreateRawPoint = curve.createRawPoint(eCFieldElement.squarePow(i), this.f22126y.squarePow(i), new ECFieldElement[]{this.f22127zs[0].squarePow(i)});
            }
            return (AbstractF2m) abstractC5820ECPointCreateRawPoint;
        }

        public AbstractF2m(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }
    }

    /* renamed from: org.bouncycastle.math.ec.ECPoint$AbstractFp */
    public static abstract class AbstractFp extends AbstractC5820ECPoint {
        public AbstractFp(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        public boolean getCompressionYTilde() {
            return getAffineYCoord().testBitZero();
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        public boolean satisfiesCurveEquation() {
            ECFieldElement eCFieldElement = this.f22125x;
            ECFieldElement eCFieldElement2 = this.f22126y;
            ECFieldElement eCFieldElementM16298getA = this.f22124curve.m16298getA();
            ECFieldElement eCFieldElementM16299getB = this.f22124curve.m16299getB();
            ECFieldElement eCFieldElementMo16318square = eCFieldElement2.mo16318square();
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 0) {
                if (curveCoordinateSystem == 1) {
                    ECFieldElement eCFieldElement3 = this.f22127zs[0];
                    if (!eCFieldElement3.mo16314isOne()) {
                        ECFieldElement eCFieldElementMo16318square2 = eCFieldElement3.mo16318square();
                        ECFieldElement eCFieldElementMultiply = eCFieldElement3.multiply(eCFieldElementMo16318square2);
                        eCFieldElementMo16318square = eCFieldElementMo16318square.multiply(eCFieldElement3);
                        eCFieldElementM16298getA = eCFieldElementM16298getA.multiply(eCFieldElementMo16318square2);
                        eCFieldElementM16299getB = eCFieldElementM16299getB.multiply(eCFieldElementMultiply);
                    }
                } else {
                    if (curveCoordinateSystem != 2 && curveCoordinateSystem != 3 && curveCoordinateSystem != 4) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    ECFieldElement eCFieldElement4 = this.f22127zs[0];
                    if (!eCFieldElement4.mo16314isOne()) {
                        ECFieldElement eCFieldElementMo16318square3 = eCFieldElement4.mo16318square();
                        ECFieldElement eCFieldElementMo16318square4 = eCFieldElementMo16318square3.mo16318square();
                        ECFieldElement eCFieldElementMultiply2 = eCFieldElementMo16318square3.multiply(eCFieldElementMo16318square4);
                        eCFieldElementM16298getA = eCFieldElementM16298getA.multiply(eCFieldElementMo16318square4);
                        eCFieldElementM16299getB = eCFieldElementM16299getB.multiply(eCFieldElementMultiply2);
                    }
                }
            }
            return eCFieldElementMo16318square.equals(eCFieldElement.mo16318square().mo16310add(eCFieldElementM16298getA).multiply(eCFieldElement).mo16310add(eCFieldElementM16299getB));
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        public AbstractC5820ECPoint subtract(AbstractC5820ECPoint abstractC5820ECPoint) {
            return abstractC5820ECPoint.isInfinity() ? this : mo16330add(abstractC5820ECPoint.mo16335negate());
        }

        public AbstractFp(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }
    }

    /* renamed from: org.bouncycastle.math.ec.ECPoint$F2m */
    public static class F2m extends AbstractF2m {
        public F2m(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        /* renamed from: add */
        public AbstractC5820ECPoint mo16330add(AbstractC5820ECPoint abstractC5820ECPoint) {
            ECFieldElement eCFieldElementMultiply;
            ECFieldElement eCFieldElementMultiply2;
            ECFieldElement eCFieldElementMultiply3;
            ECFieldElement eCFieldElementMultiply4;
            ECFieldElement eCFieldElementMultiply5;
            ECFieldElement eCFieldElementSquarePlusProduct;
            if (isInfinity()) {
                return abstractC5820ECPoint;
            }
            if (abstractC5820ECPoint.isInfinity()) {
                return this;
            }
            AbstractC5817ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElementMultiply6 = this.f22125x;
            ECFieldElement eCFieldElement = abstractC5820ECPoint.f22125x;
            if (coordinateSystem == 0) {
                ECFieldElement eCFieldElement2 = this.f22126y;
                ECFieldElement eCFieldElement3 = abstractC5820ECPoint.f22126y;
                ECFieldElement eCFieldElementMo16310add = eCFieldElementMultiply6.mo16310add(eCFieldElement);
                ECFieldElement eCFieldElementMo16310add2 = eCFieldElement2.mo16310add(eCFieldElement3);
                if (eCFieldElementMo16310add.mo16315isZero()) {
                    return eCFieldElementMo16310add2.mo16315isZero() ? mo16338twice() : curve.getInfinity();
                }
                ECFieldElement eCFieldElementMo16312divide = eCFieldElementMo16310add2.mo16312divide(eCFieldElementMo16310add);
                ECFieldElement eCFieldElementMo16310add3 = eCFieldElementMo16312divide.mo16318square().mo16310add(eCFieldElementMo16312divide).mo16310add(eCFieldElementMo16310add).mo16310add(curve.m16298getA());
                return new F2m(curve, eCFieldElementMo16310add3, eCFieldElementMo16312divide.multiply(eCFieldElementMultiply6.mo16310add(eCFieldElementMo16310add3)).mo16310add(eCFieldElementMo16310add3).mo16310add(eCFieldElement2));
            }
            if (coordinateSystem == 1) {
                ECFieldElement eCFieldElement4 = this.f22126y;
                ECFieldElement eCFieldElementMultiply7 = this.f22127zs[0];
                ECFieldElement eCFieldElement5 = abstractC5820ECPoint.f22126y;
                ECFieldElement eCFieldElement6 = abstractC5820ECPoint.f22127zs[0];
                boolean zMo16314isOne = eCFieldElement6.mo16314isOne();
                ECFieldElement eCFieldElementMo16310add4 = eCFieldElementMultiply7.multiply(eCFieldElement5).mo16310add(zMo16314isOne ? eCFieldElement4 : eCFieldElement4.multiply(eCFieldElement6));
                ECFieldElement eCFieldElementMo16310add5 = eCFieldElementMultiply7.multiply(eCFieldElement).mo16310add(zMo16314isOne ? eCFieldElementMultiply6 : eCFieldElementMultiply6.multiply(eCFieldElement6));
                if (eCFieldElementMo16310add5.mo16315isZero()) {
                    return eCFieldElementMo16310add4.mo16315isZero() ? mo16338twice() : curve.getInfinity();
                }
                ECFieldElement eCFieldElementMo16318square = eCFieldElementMo16310add5.mo16318square();
                ECFieldElement eCFieldElementMultiply8 = eCFieldElementMo16318square.multiply(eCFieldElementMo16310add5);
                if (!zMo16314isOne) {
                    eCFieldElementMultiply7 = eCFieldElementMultiply7.multiply(eCFieldElement6);
                }
                ECFieldElement eCFieldElementMo16310add6 = eCFieldElementMo16310add4.mo16310add(eCFieldElementMo16310add5);
                ECFieldElement eCFieldElementMo16310add7 = eCFieldElementMo16310add6.multiplyPlusProduct(eCFieldElementMo16310add4, eCFieldElementMo16318square, curve.m16298getA()).multiply(eCFieldElementMultiply7).mo16310add(eCFieldElementMultiply8);
                ECFieldElement eCFieldElementMultiply9 = eCFieldElementMo16310add5.multiply(eCFieldElementMo16310add7);
                if (!zMo16314isOne) {
                    eCFieldElementMo16318square = eCFieldElementMo16318square.multiply(eCFieldElement6);
                }
                return new F2m(curve, eCFieldElementMultiply9, eCFieldElementMo16310add4.multiplyPlusProduct(eCFieldElementMultiply6, eCFieldElementMo16310add5, eCFieldElement4).multiplyPlusProduct(eCFieldElementMo16318square, eCFieldElementMo16310add6, eCFieldElementMo16310add7), new ECFieldElement[]{eCFieldElementMultiply8.multiply(eCFieldElementMultiply7)});
            }
            if (coordinateSystem != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            if (eCFieldElementMultiply6.mo16315isZero()) {
                return eCFieldElement.mo16315isZero() ? curve.getInfinity() : abstractC5820ECPoint.mo16330add(this);
            }
            ECFieldElement eCFieldElement7 = this.f22126y;
            ECFieldElement eCFieldElement8 = this.f22127zs[0];
            ECFieldElement eCFieldElement9 = abstractC5820ECPoint.f22126y;
            ECFieldElement eCFieldElement10 = abstractC5820ECPoint.f22127zs[0];
            boolean zMo16314isOne2 = eCFieldElement8.mo16314isOne();
            if (zMo16314isOne2) {
                eCFieldElementMultiply = eCFieldElement;
                eCFieldElementMultiply2 = eCFieldElement9;
            } else {
                eCFieldElementMultiply = eCFieldElement.multiply(eCFieldElement8);
                eCFieldElementMultiply2 = eCFieldElement9.multiply(eCFieldElement8);
            }
            boolean zMo16314isOne3 = eCFieldElement10.mo16314isOne();
            if (zMo16314isOne3) {
                eCFieldElementMultiply3 = eCFieldElement7;
            } else {
                eCFieldElementMultiply6 = eCFieldElementMultiply6.multiply(eCFieldElement10);
                eCFieldElementMultiply3 = eCFieldElement7.multiply(eCFieldElement10);
            }
            ECFieldElement eCFieldElementMo16310add8 = eCFieldElementMultiply3.mo16310add(eCFieldElementMultiply2);
            ECFieldElement eCFieldElementMo16310add9 = eCFieldElementMultiply6.mo16310add(eCFieldElementMultiply);
            if (eCFieldElementMo16310add9.mo16315isZero()) {
                return eCFieldElementMo16310add8.mo16315isZero() ? mo16338twice() : curve.getInfinity();
            }
            if (eCFieldElement.mo16315isZero()) {
                AbstractC5820ECPoint abstractC5820ECPointNormalize = normalize();
                ECFieldElement xCoord = abstractC5820ECPointNormalize.getXCoord();
                ECFieldElement yCoord = abstractC5820ECPointNormalize.getYCoord();
                ECFieldElement eCFieldElementMo16312divide2 = yCoord.mo16310add(eCFieldElement9).mo16312divide(xCoord);
                eCFieldElementMultiply4 = eCFieldElementMo16312divide2.mo16318square().mo16310add(eCFieldElementMo16312divide2).mo16310add(xCoord).mo16310add(curve.m16298getA());
                if (eCFieldElementMultiply4.mo16315isZero()) {
                    return new F2m(curve, eCFieldElementMultiply4, curve.m16299getB().mo16317sqrt());
                }
                eCFieldElementSquarePlusProduct = eCFieldElementMo16312divide2.multiply(xCoord.mo16310add(eCFieldElementMultiply4)).mo16310add(eCFieldElementMultiply4).mo16310add(yCoord).mo16312divide(eCFieldElementMultiply4).mo16310add(eCFieldElementMultiply4);
                eCFieldElementMultiply5 = curve.fromBigInteger(ECConstants.f22091ONE);
            } else {
                ECFieldElement eCFieldElementMo16318square2 = eCFieldElementMo16310add9.mo16318square();
                ECFieldElement eCFieldElementMultiply10 = eCFieldElementMo16310add8.multiply(eCFieldElementMultiply6);
                ECFieldElement eCFieldElementMultiply11 = eCFieldElementMo16310add8.multiply(eCFieldElementMultiply);
                eCFieldElementMultiply4 = eCFieldElementMultiply10.multiply(eCFieldElementMultiply11);
                if (eCFieldElementMultiply4.mo16315isZero()) {
                    return new F2m(curve, eCFieldElementMultiply4, curve.m16299getB().mo16317sqrt());
                }
                ECFieldElement eCFieldElementMultiply12 = eCFieldElementMo16310add8.multiply(eCFieldElementMo16318square2);
                eCFieldElementMultiply5 = !zMo16314isOne3 ? eCFieldElementMultiply12.multiply(eCFieldElement10) : eCFieldElementMultiply12;
                eCFieldElementSquarePlusProduct = eCFieldElementMultiply11.mo16310add(eCFieldElementMo16318square2).squarePlusProduct(eCFieldElementMultiply5, eCFieldElement7.mo16310add(eCFieldElement8));
                if (!zMo16314isOne2) {
                    eCFieldElementMultiply5 = eCFieldElementMultiply5.multiply(eCFieldElement8);
                }
            }
            return new F2m(curve, eCFieldElementMultiply4, eCFieldElementSquarePlusProduct, new ECFieldElement[]{eCFieldElementMultiply5});
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        /* renamed from: detach */
        public AbstractC5820ECPoint mo16331detach() {
            return new F2m(null, getAffineXCoord(), getAffineYCoord());
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        public boolean getCompressionYTilde() {
            ECFieldElement rawXCoord = getRawXCoord();
            if (rawXCoord.mo16315isZero()) {
                return false;
            }
            ECFieldElement rawYCoord = getRawYCoord();
            int curveCoordinateSystem = getCurveCoordinateSystem();
            return (curveCoordinateSystem == 5 || curveCoordinateSystem == 6) ? rawYCoord.testBitZero() != rawXCoord.testBitZero() : rawYCoord.mo16312divide(rawXCoord).testBitZero();
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        public ECFieldElement getYCoord() {
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 5 && curveCoordinateSystem != 6) {
                return this.f22126y;
            }
            ECFieldElement eCFieldElement = this.f22125x;
            ECFieldElement eCFieldElement2 = this.f22126y;
            if (isInfinity() || eCFieldElement.mo16315isZero()) {
                return eCFieldElement2;
            }
            ECFieldElement eCFieldElementMultiply = eCFieldElement2.mo16310add(eCFieldElement).multiply(eCFieldElement);
            if (6 != curveCoordinateSystem) {
                return eCFieldElementMultiply;
            }
            ECFieldElement eCFieldElement3 = this.f22127zs[0];
            return !eCFieldElement3.mo16314isOne() ? eCFieldElementMultiply.mo16312divide(eCFieldElement3) : eCFieldElementMultiply;
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        /* renamed from: negate */
        public AbstractC5820ECPoint mo16335negate() {
            if (isInfinity()) {
                return this;
            }
            ECFieldElement eCFieldElement = this.f22125x;
            if (eCFieldElement.mo16315isZero()) {
                return this;
            }
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem == 0) {
                return new F2m(this.f22124curve, eCFieldElement, this.f22126y.mo16310add(eCFieldElement));
            }
            if (curveCoordinateSystem == 1) {
                return new F2m(this.f22124curve, eCFieldElement, this.f22126y.mo16310add(eCFieldElement), new ECFieldElement[]{this.f22127zs[0]});
            }
            if (curveCoordinateSystem == 5) {
                return new F2m(this.f22124curve, eCFieldElement, this.f22126y.mo16311addOne());
            }
            if (curveCoordinateSystem != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            ECFieldElement eCFieldElement2 = this.f22126y;
            ECFieldElement eCFieldElement3 = this.f22127zs[0];
            return new F2m(this.f22124curve, eCFieldElement, eCFieldElement2.mo16310add(eCFieldElement3), new ECFieldElement[]{eCFieldElement3});
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        /* renamed from: twice */
        public AbstractC5820ECPoint mo16338twice() {
            ECFieldElement eCFieldElementMo16310add;
            if (isInfinity()) {
                return this;
            }
            AbstractC5817ECCurve curve = getCurve();
            ECFieldElement eCFieldElementMultiply = this.f22125x;
            if (eCFieldElementMultiply.mo16315isZero()) {
                return curve.getInfinity();
            }
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem == 0) {
                ECFieldElement eCFieldElementMo16310add2 = this.f22126y.mo16312divide(eCFieldElementMultiply).mo16310add(eCFieldElementMultiply);
                ECFieldElement eCFieldElementMo16310add3 = eCFieldElementMo16310add2.mo16318square().mo16310add(eCFieldElementMo16310add2).mo16310add(curve.m16298getA());
                return new F2m(curve, eCFieldElementMo16310add3, eCFieldElementMultiply.squarePlusProduct(eCFieldElementMo16310add3, eCFieldElementMo16310add2.mo16311addOne()));
            }
            if (coordinateSystem == 1) {
                ECFieldElement eCFieldElementMultiply2 = this.f22126y;
                ECFieldElement eCFieldElement = this.f22127zs[0];
                boolean zMo16314isOne = eCFieldElement.mo16314isOne();
                ECFieldElement eCFieldElementMultiply3 = zMo16314isOne ? eCFieldElementMultiply : eCFieldElementMultiply.multiply(eCFieldElement);
                if (!zMo16314isOne) {
                    eCFieldElementMultiply2 = eCFieldElementMultiply2.multiply(eCFieldElement);
                }
                ECFieldElement eCFieldElementMo16318square = eCFieldElementMultiply.mo16318square();
                ECFieldElement eCFieldElementMo16310add4 = eCFieldElementMo16318square.mo16310add(eCFieldElementMultiply2);
                ECFieldElement eCFieldElementMo16318square2 = eCFieldElementMultiply3.mo16318square();
                ECFieldElement eCFieldElementMo16310add5 = eCFieldElementMo16310add4.mo16310add(eCFieldElementMultiply3);
                ECFieldElement eCFieldElementMultiplyPlusProduct = eCFieldElementMo16310add5.multiplyPlusProduct(eCFieldElementMo16310add4, eCFieldElementMo16318square2, curve.m16298getA());
                return new F2m(curve, eCFieldElementMultiply3.multiply(eCFieldElementMultiplyPlusProduct), eCFieldElementMo16318square.mo16318square().multiplyPlusProduct(eCFieldElementMultiply3, eCFieldElementMultiplyPlusProduct, eCFieldElementMo16310add5), new ECFieldElement[]{eCFieldElementMultiply3.multiply(eCFieldElementMo16318square2)});
            }
            if (coordinateSystem != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            ECFieldElement eCFieldElement2 = this.f22126y;
            ECFieldElement eCFieldElement3 = this.f22127zs[0];
            boolean zMo16314isOne2 = eCFieldElement3.mo16314isOne();
            ECFieldElement eCFieldElementMultiply4 = zMo16314isOne2 ? eCFieldElement2 : eCFieldElement2.multiply(eCFieldElement3);
            ECFieldElement eCFieldElementMo16318square3 = zMo16314isOne2 ? eCFieldElement3 : eCFieldElement3.mo16318square();
            ECFieldElement eCFieldElementM16298getA = curve.m16298getA();
            ECFieldElement eCFieldElementMultiply5 = zMo16314isOne2 ? eCFieldElementM16298getA : eCFieldElementM16298getA.multiply(eCFieldElementMo16318square3);
            ECFieldElement eCFieldElementMo16310add6 = eCFieldElement2.mo16318square().mo16310add(eCFieldElementMultiply4).mo16310add(eCFieldElementMultiply5);
            if (eCFieldElementMo16310add6.mo16315isZero()) {
                return new F2m(curve, eCFieldElementMo16310add6, curve.m16299getB().mo16317sqrt());
            }
            ECFieldElement eCFieldElementMo16318square4 = eCFieldElementMo16310add6.mo16318square();
            ECFieldElement eCFieldElementMultiply6 = zMo16314isOne2 ? eCFieldElementMo16310add6 : eCFieldElementMo16310add6.multiply(eCFieldElementMo16318square3);
            ECFieldElement eCFieldElementM16299getB = curve.m16299getB();
            if (eCFieldElementM16299getB.bitLength() < (curve.getFieldSize() >> 1)) {
                ECFieldElement eCFieldElementMo16318square5 = eCFieldElement2.mo16310add(eCFieldElementMultiply).mo16318square();
                eCFieldElementMo16310add = eCFieldElementMo16318square5.mo16310add(eCFieldElementMo16310add6).mo16310add(eCFieldElementMo16318square3).multiply(eCFieldElementMo16318square5).mo16310add(eCFieldElementM16299getB.mo16314isOne() ? eCFieldElementMultiply5.mo16310add(eCFieldElementMo16318square3).mo16318square() : eCFieldElementMultiply5.squarePlusProduct(eCFieldElementM16299getB, eCFieldElementMo16318square3.mo16318square())).mo16310add(eCFieldElementMo16318square4);
                if (!eCFieldElementM16298getA.mo16315isZero()) {
                    if (!eCFieldElementM16298getA.mo16314isOne()) {
                        eCFieldElementMo16310add = eCFieldElementMo16310add.mo16310add(eCFieldElementM16298getA.mo16311addOne().multiply(eCFieldElementMultiply6));
                    }
                }
                return new F2m(curve, eCFieldElementMo16318square4, eCFieldElementMo16310add, new ECFieldElement[]{eCFieldElementMultiply6});
            }
            if (!zMo16314isOne2) {
                eCFieldElementMultiply = eCFieldElementMultiply.multiply(eCFieldElement3);
            }
            eCFieldElementMo16310add = eCFieldElementMultiply.squarePlusProduct(eCFieldElementMo16310add6, eCFieldElementMultiply4).mo16310add(eCFieldElementMo16318square4);
            eCFieldElementMo16310add = eCFieldElementMo16310add.mo16310add(eCFieldElementMultiply6);
            return new F2m(curve, eCFieldElementMo16318square4, eCFieldElementMo16310add, new ECFieldElement[]{eCFieldElementMultiply6});
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        public AbstractC5820ECPoint twicePlus(AbstractC5820ECPoint abstractC5820ECPoint) {
            if (isInfinity()) {
                return abstractC5820ECPoint;
            }
            if (abstractC5820ECPoint.isInfinity()) {
                return mo16338twice();
            }
            AbstractC5817ECCurve curve = getCurve();
            ECFieldElement eCFieldElement = this.f22125x;
            if (eCFieldElement.mo16315isZero()) {
                return abstractC5820ECPoint;
            }
            if (curve.getCoordinateSystem() != 6) {
                return mo16338twice().mo16330add(abstractC5820ECPoint);
            }
            ECFieldElement eCFieldElement2 = abstractC5820ECPoint.f22125x;
            ECFieldElement eCFieldElement3 = abstractC5820ECPoint.f22127zs[0];
            if (eCFieldElement2.mo16315isZero() || !eCFieldElement3.mo16314isOne()) {
                return mo16338twice().mo16330add(abstractC5820ECPoint);
            }
            ECFieldElement eCFieldElement4 = this.f22126y;
            ECFieldElement eCFieldElement5 = this.f22127zs[0];
            ECFieldElement eCFieldElement6 = abstractC5820ECPoint.f22126y;
            ECFieldElement eCFieldElementMo16318square = eCFieldElement.mo16318square();
            ECFieldElement eCFieldElementMo16318square2 = eCFieldElement4.mo16318square();
            ECFieldElement eCFieldElementMo16318square3 = eCFieldElement5.mo16318square();
            ECFieldElement eCFieldElementMo16310add = curve.m16298getA().multiply(eCFieldElementMo16318square3).mo16310add(eCFieldElementMo16318square2).mo16310add(eCFieldElement4.multiply(eCFieldElement5));
            ECFieldElement eCFieldElementMo16311addOne = eCFieldElement6.mo16311addOne();
            ECFieldElement eCFieldElementMultiplyPlusProduct = curve.m16298getA().mo16310add(eCFieldElementMo16311addOne).multiply(eCFieldElementMo16318square3).mo16310add(eCFieldElementMo16318square2).multiplyPlusProduct(eCFieldElementMo16310add, eCFieldElementMo16318square, eCFieldElementMo16318square3);
            ECFieldElement eCFieldElementMultiply = eCFieldElement2.multiply(eCFieldElementMo16318square3);
            ECFieldElement eCFieldElementMo16318square4 = eCFieldElementMultiply.mo16310add(eCFieldElementMo16310add).mo16318square();
            if (eCFieldElementMo16318square4.mo16315isZero()) {
                return eCFieldElementMultiplyPlusProduct.mo16315isZero() ? abstractC5820ECPoint.mo16338twice() : curve.getInfinity();
            }
            if (eCFieldElementMultiplyPlusProduct.mo16315isZero()) {
                return new F2m(curve, eCFieldElementMultiplyPlusProduct, curve.m16299getB().mo16317sqrt());
            }
            ECFieldElement eCFieldElementMultiply2 = eCFieldElementMultiplyPlusProduct.mo16318square().multiply(eCFieldElementMultiply);
            ECFieldElement eCFieldElementMultiply3 = eCFieldElementMultiplyPlusProduct.multiply(eCFieldElementMo16318square4).multiply(eCFieldElementMo16318square3);
            return new F2m(curve, eCFieldElementMultiply2, eCFieldElementMultiplyPlusProduct.mo16310add(eCFieldElementMo16318square4).mo16318square().multiplyPlusProduct(eCFieldElementMo16310add, eCFieldElementMo16311addOne, eCFieldElementMultiply3), new ECFieldElement[]{eCFieldElementMultiply3});
        }

        public F2m(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }
    }

    /* renamed from: org.bouncycastle.math.ec.ECPoint$Fp */
    public static class Fp extends AbstractFp {
        public Fp(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2);
        }

        /* JADX WARN: Removed duplicated region for block: B:61:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0136  */
        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        /* renamed from: add */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AbstractC5820ECPoint mo16330add(AbstractC5820ECPoint abstractC5820ECPoint) {
            ECFieldElement eCFieldElementMo16318square;
            ECFieldElement eCFieldElementMultiplyMinusProduct;
            ECFieldElement eCFieldElementMultiply;
            ECFieldElement eCFieldElementSubtract;
            if (isInfinity()) {
                return abstractC5820ECPoint;
            }
            if (abstractC5820ECPoint.isInfinity()) {
                return this;
            }
            if (this == abstractC5820ECPoint) {
                return mo16338twice();
            }
            AbstractC5817ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElementMultiply2 = this.f22125x;
            ECFieldElement eCFieldElementMultiply3 = this.f22126y;
            ECFieldElement eCFieldElementMultiply4 = abstractC5820ECPoint.f22125x;
            ECFieldElement eCFieldElementMultiply5 = abstractC5820ECPoint.f22126y;
            if (coordinateSystem == 0) {
                ECFieldElement eCFieldElementSubtract2 = eCFieldElementMultiply4.subtract(eCFieldElementMultiply2);
                ECFieldElement eCFieldElementSubtract3 = eCFieldElementMultiply5.subtract(eCFieldElementMultiply3);
                if (eCFieldElementSubtract2.mo16315isZero()) {
                    return eCFieldElementSubtract3.mo16315isZero() ? mo16338twice() : curve.getInfinity();
                }
                ECFieldElement eCFieldElementMo16312divide = eCFieldElementSubtract3.mo16312divide(eCFieldElementSubtract2);
                ECFieldElement eCFieldElementSubtract4 = eCFieldElementMo16312divide.mo16318square().subtract(eCFieldElementMultiply2).subtract(eCFieldElementMultiply4);
                return new Fp(curve, eCFieldElementSubtract4, eCFieldElementMo16312divide.multiply(eCFieldElementMultiply2.subtract(eCFieldElementSubtract4)).subtract(eCFieldElementMultiply3));
            }
            if (coordinateSystem == 1) {
                ECFieldElement eCFieldElementMultiply6 = this.f22127zs[0];
                ECFieldElement eCFieldElement = abstractC5820ECPoint.f22127zs[0];
                boolean zMo16314isOne = eCFieldElementMultiply6.mo16314isOne();
                boolean zMo16314isOne2 = eCFieldElement.mo16314isOne();
                if (!zMo16314isOne) {
                    eCFieldElementMultiply5 = eCFieldElementMultiply5.multiply(eCFieldElementMultiply6);
                }
                if (!zMo16314isOne2) {
                    eCFieldElementMultiply3 = eCFieldElementMultiply3.multiply(eCFieldElement);
                }
                ECFieldElement eCFieldElementSubtract5 = eCFieldElementMultiply5.subtract(eCFieldElementMultiply3);
                if (!zMo16314isOne) {
                    eCFieldElementMultiply4 = eCFieldElementMultiply4.multiply(eCFieldElementMultiply6);
                }
                if (!zMo16314isOne2) {
                    eCFieldElementMultiply2 = eCFieldElementMultiply2.multiply(eCFieldElement);
                }
                ECFieldElement eCFieldElementSubtract6 = eCFieldElementMultiply4.subtract(eCFieldElementMultiply2);
                if (eCFieldElementSubtract6.mo16315isZero()) {
                    return eCFieldElementSubtract5.mo16315isZero() ? mo16338twice() : curve.getInfinity();
                }
                if (zMo16314isOne) {
                    eCFieldElementMultiply6 = eCFieldElement;
                } else if (!zMo16314isOne2) {
                    eCFieldElementMultiply6 = eCFieldElementMultiply6.multiply(eCFieldElement);
                }
                ECFieldElement eCFieldElementMo16318square2 = eCFieldElementSubtract6.mo16318square();
                ECFieldElement eCFieldElementMultiply7 = eCFieldElementMo16318square2.multiply(eCFieldElementSubtract6);
                ECFieldElement eCFieldElementMultiply8 = eCFieldElementMo16318square2.multiply(eCFieldElementMultiply2);
                ECFieldElement eCFieldElementSubtract7 = eCFieldElementSubtract5.mo16318square().multiply(eCFieldElementMultiply6).subtract(eCFieldElementMultiply7).subtract(m16344two(eCFieldElementMultiply8));
                return new Fp(curve, eCFieldElementSubtract6.multiply(eCFieldElementSubtract7), eCFieldElementMultiply8.subtract(eCFieldElementSubtract7).multiplyMinusProduct(eCFieldElementSubtract5, eCFieldElementMultiply3, eCFieldElementMultiply7), new ECFieldElement[]{eCFieldElementMultiply7.multiply(eCFieldElementMultiply6)});
            }
            if (coordinateSystem != 2 && coordinateSystem != 4) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            ECFieldElement eCFieldElement2 = this.f22127zs[0];
            ECFieldElement eCFieldElement3 = abstractC5820ECPoint.f22127zs[0];
            boolean zMo16314isOne3 = eCFieldElement2.mo16314isOne();
            if (zMo16314isOne3 || !eCFieldElement2.equals(eCFieldElement3)) {
                if (!zMo16314isOne3) {
                    ECFieldElement eCFieldElementMo16318square3 = eCFieldElement2.mo16318square();
                    eCFieldElementMultiply4 = eCFieldElementMo16318square3.multiply(eCFieldElementMultiply4);
                    eCFieldElementMultiply5 = eCFieldElementMo16318square3.multiply(eCFieldElement2).multiply(eCFieldElementMultiply5);
                }
                boolean zMo16314isOne4 = eCFieldElement3.mo16314isOne();
                if (!zMo16314isOne4) {
                    ECFieldElement eCFieldElementMo16318square4 = eCFieldElement3.mo16318square();
                    eCFieldElementMultiply2 = eCFieldElementMo16318square4.multiply(eCFieldElementMultiply2);
                    eCFieldElementMultiply3 = eCFieldElementMo16318square4.multiply(eCFieldElement3).multiply(eCFieldElementMultiply3);
                }
                ECFieldElement eCFieldElementSubtract8 = eCFieldElementMultiply2.subtract(eCFieldElementMultiply4);
                ECFieldElement eCFieldElementSubtract9 = eCFieldElementMultiply3.subtract(eCFieldElementMultiply5);
                if (eCFieldElementSubtract8.mo16315isZero()) {
                    return eCFieldElementSubtract9.mo16315isZero() ? mo16338twice() : curve.getInfinity();
                }
                eCFieldElementMo16318square = eCFieldElementSubtract8.mo16318square();
                ECFieldElement eCFieldElementMultiply9 = eCFieldElementMo16318square.multiply(eCFieldElementSubtract8);
                ECFieldElement eCFieldElementMultiply10 = eCFieldElementMo16318square.multiply(eCFieldElementMultiply2);
                ECFieldElement eCFieldElementSubtract10 = eCFieldElementSubtract9.mo16318square().mo16310add(eCFieldElementMultiply9).subtract(m16344two(eCFieldElementMultiply10));
                eCFieldElementMultiplyMinusProduct = eCFieldElementMultiply10.subtract(eCFieldElementSubtract10).multiplyMinusProduct(eCFieldElementSubtract9, eCFieldElementMultiply9, eCFieldElementMultiply3);
                ECFieldElement eCFieldElementMultiply11 = !zMo16314isOne3 ? eCFieldElementSubtract8.multiply(eCFieldElement2) : eCFieldElementSubtract8;
                eCFieldElementMultiply = !zMo16314isOne4 ? eCFieldElementMultiply11.multiply(eCFieldElement3) : eCFieldElementMultiply11;
                if (eCFieldElementMultiply == eCFieldElementSubtract8) {
                    eCFieldElementSubtract = eCFieldElementSubtract10;
                    return new Fp(curve, eCFieldElementSubtract, eCFieldElementMultiplyMinusProduct, coordinateSystem != 4 ? new ECFieldElement[]{eCFieldElementMultiply, calculateJacobianModifiedW(eCFieldElementMultiply, eCFieldElementMo16318square)} : new ECFieldElement[]{eCFieldElementMultiply});
                }
                eCFieldElementSubtract = eCFieldElementSubtract10;
            } else {
                ECFieldElement eCFieldElementSubtract11 = eCFieldElementMultiply2.subtract(eCFieldElementMultiply4);
                ECFieldElement eCFieldElementSubtract12 = eCFieldElementMultiply3.subtract(eCFieldElementMultiply5);
                if (eCFieldElementSubtract11.mo16315isZero()) {
                    return eCFieldElementSubtract12.mo16315isZero() ? mo16338twice() : curve.getInfinity();
                }
                ECFieldElement eCFieldElementMo16318square5 = eCFieldElementSubtract11.mo16318square();
                ECFieldElement eCFieldElementMultiply12 = eCFieldElementMultiply2.multiply(eCFieldElementMo16318square5);
                ECFieldElement eCFieldElementMultiply13 = eCFieldElementMultiply4.multiply(eCFieldElementMo16318square5);
                ECFieldElement eCFieldElementMultiply14 = eCFieldElementMultiply12.subtract(eCFieldElementMultiply13).multiply(eCFieldElementMultiply3);
                eCFieldElementSubtract = eCFieldElementSubtract12.mo16318square().subtract(eCFieldElementMultiply12).subtract(eCFieldElementMultiply13);
                eCFieldElementMultiplyMinusProduct = eCFieldElementMultiply12.subtract(eCFieldElementSubtract).multiply(eCFieldElementSubtract12).subtract(eCFieldElementMultiply14);
                eCFieldElementMultiply = eCFieldElementSubtract11.multiply(eCFieldElement2);
            }
            eCFieldElementMo16318square = null;
            return new Fp(curve, eCFieldElementSubtract, eCFieldElementMultiplyMinusProduct, coordinateSystem != 4 ? new ECFieldElement[]{eCFieldElementMultiply, calculateJacobianModifiedW(eCFieldElementMultiply, eCFieldElementMo16318square)} : new ECFieldElement[]{eCFieldElementMultiply});
        }

        public ECFieldElement calculateJacobianModifiedW(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            ECFieldElement eCFieldElementM16298getA = getCurve().m16298getA();
            if (eCFieldElementM16298getA.mo16315isZero() || eCFieldElement.mo16314isOne()) {
                return eCFieldElementM16298getA;
            }
            if (eCFieldElement2 == null) {
                eCFieldElement2 = eCFieldElement.mo16318square();
            }
            ECFieldElement eCFieldElementMo16318square = eCFieldElement2.mo16318square();
            ECFieldElement eCFieldElementMo16316negate = eCFieldElementM16298getA.mo16316negate();
            return eCFieldElementMo16316negate.bitLength() < eCFieldElementM16298getA.bitLength() ? eCFieldElementMo16318square.multiply(eCFieldElementMo16316negate).mo16316negate() : eCFieldElementMo16318square.multiply(eCFieldElementM16298getA);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        /* renamed from: detach */
        public AbstractC5820ECPoint mo16331detach() {
            return new Fp(null, getAffineXCoord(), getAffineYCoord());
        }

        public ECFieldElement doubleProductFromSquares(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3, ECFieldElement eCFieldElement4) {
            return eCFieldElement.mo16310add(eCFieldElement2).mo16318square().subtract(eCFieldElement3).subtract(eCFieldElement4);
        }

        /* renamed from: eight */
        public ECFieldElement m16341eight(ECFieldElement eCFieldElement) {
            return m16342four(m16344two(eCFieldElement));
        }

        /* renamed from: four */
        public ECFieldElement m16342four(ECFieldElement eCFieldElement) {
            return m16344two(m16344two(eCFieldElement));
        }

        public ECFieldElement getJacobianModifiedW() {
            ECFieldElement[] eCFieldElementArr = this.f22127zs;
            ECFieldElement eCFieldElement = eCFieldElementArr[1];
            if (eCFieldElement != null) {
                return eCFieldElement;
            }
            ECFieldElement eCFieldElementCalculateJacobianModifiedW = calculateJacobianModifiedW(eCFieldElementArr[0], null);
            eCFieldElementArr[1] = eCFieldElementCalculateJacobianModifiedW;
            return eCFieldElementCalculateJacobianModifiedW;
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        public ECFieldElement getZCoord(int i) {
            return (i == 1 && 4 == getCurveCoordinateSystem()) ? getJacobianModifiedW() : super.getZCoord(i);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        /* renamed from: negate */
        public AbstractC5820ECPoint mo16335negate() {
            if (isInfinity()) {
                return this;
            }
            AbstractC5817ECCurve curve = getCurve();
            return curve.getCoordinateSystem() != 0 ? new Fp(curve, this.f22125x, this.f22126y.mo16316negate(), this.f22127zs) : new Fp(curve, this.f22125x, this.f22126y.mo16316negate());
        }

        /* renamed from: three */
        public ECFieldElement m16343three(ECFieldElement eCFieldElement) {
            return m16344two(eCFieldElement).mo16310add(eCFieldElement);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        public AbstractC5820ECPoint threeTimes() {
            if (isInfinity()) {
                return this;
            }
            ECFieldElement eCFieldElement = this.f22126y;
            if (eCFieldElement.mo16315isZero()) {
                return this;
            }
            AbstractC5817ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem != 0) {
                return coordinateSystem != 4 ? mo16338twice().mo16330add(this) : twiceJacobianModified(false).mo16330add(this);
            }
            ECFieldElement eCFieldElement2 = this.f22125x;
            ECFieldElement eCFieldElementM16344two = m16344two(eCFieldElement);
            ECFieldElement eCFieldElementMo16318square = eCFieldElementM16344two.mo16318square();
            ECFieldElement eCFieldElementMo16310add = m16343three(eCFieldElement2.mo16318square()).mo16310add(getCurve().m16298getA());
            ECFieldElement eCFieldElementSubtract = m16343three(eCFieldElement2).multiply(eCFieldElementMo16318square).subtract(eCFieldElementMo16310add.mo16318square());
            if (eCFieldElementSubtract.mo16315isZero()) {
                return getCurve().getInfinity();
            }
            ECFieldElement eCFieldElementMo16313invert = eCFieldElementSubtract.multiply(eCFieldElementM16344two).mo16313invert();
            ECFieldElement eCFieldElementMultiply = eCFieldElementSubtract.multiply(eCFieldElementMo16313invert).multiply(eCFieldElementMo16310add);
            ECFieldElement eCFieldElementSubtract2 = eCFieldElementMo16318square.mo16318square().multiply(eCFieldElementMo16313invert).subtract(eCFieldElementMultiply);
            ECFieldElement eCFieldElementMo16310add2 = eCFieldElementSubtract2.subtract(eCFieldElementMultiply).multiply(eCFieldElementMultiply.mo16310add(eCFieldElementSubtract2)).mo16310add(eCFieldElement2);
            return new Fp(curve, eCFieldElementMo16310add2, eCFieldElement2.subtract(eCFieldElementMo16310add2).multiply(eCFieldElementSubtract2).subtract(eCFieldElement));
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        public AbstractC5820ECPoint timesPow2(int i) {
            ECFieldElement eCFieldElementMo16318square;
            if (i < 0) {
                throw new IllegalArgumentException("'e' cannot be negative");
            }
            if (i == 0 || isInfinity()) {
                return this;
            }
            if (i == 1) {
                return mo16338twice();
            }
            AbstractC5817ECCurve curve = getCurve();
            ECFieldElement eCFieldElementSubtract = this.f22126y;
            if (eCFieldElementSubtract.mo16315isZero()) {
                return curve.getInfinity();
            }
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElementM16298getA = curve.m16298getA();
            ECFieldElement eCFieldElementMultiply = this.f22125x;
            ECFieldElement[] eCFieldElementArr = this.f22127zs;
            int i2 = 0;
            ECFieldElement eCFieldElementFromBigInteger = eCFieldElementArr.length < 1 ? curve.fromBigInteger(ECConstants.f22091ONE) : eCFieldElementArr[0];
            if (!eCFieldElementFromBigInteger.mo16314isOne() && coordinateSystem != 0) {
                if (coordinateSystem == 1) {
                    eCFieldElementMo16318square = eCFieldElementFromBigInteger.mo16318square();
                    eCFieldElementMultiply = eCFieldElementMultiply.multiply(eCFieldElementFromBigInteger);
                    eCFieldElementSubtract = eCFieldElementSubtract.multiply(eCFieldElementMo16318square);
                } else if (coordinateSystem == 2) {
                    eCFieldElementMo16318square = null;
                } else {
                    if (coordinateSystem != 4) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    eCFieldElementM16298getA = getJacobianModifiedW();
                }
                eCFieldElementM16298getA = calculateJacobianModifiedW(eCFieldElementFromBigInteger, eCFieldElementMo16318square);
            }
            while (i2 < i) {
                if (eCFieldElementSubtract.mo16315isZero()) {
                    return curve.getInfinity();
                }
                ECFieldElement eCFieldElementM16343three = m16343three(eCFieldElementMultiply.mo16318square());
                ECFieldElement eCFieldElementM16344two = m16344two(eCFieldElementSubtract);
                ECFieldElement eCFieldElementMultiply2 = eCFieldElementM16344two.multiply(eCFieldElementSubtract);
                ECFieldElement eCFieldElementM16344two2 = m16344two(eCFieldElementMultiply.multiply(eCFieldElementMultiply2));
                ECFieldElement eCFieldElementM16344two3 = m16344two(eCFieldElementMultiply2.mo16318square());
                if (!eCFieldElementM16298getA.mo16315isZero()) {
                    eCFieldElementM16343three = eCFieldElementM16343three.mo16310add(eCFieldElementM16298getA);
                    eCFieldElementM16298getA = m16344two(eCFieldElementM16344two3.multiply(eCFieldElementM16298getA));
                }
                ECFieldElement eCFieldElementSubtract2 = eCFieldElementM16343three.mo16318square().subtract(m16344two(eCFieldElementM16344two2));
                eCFieldElementSubtract = eCFieldElementM16343three.multiply(eCFieldElementM16344two2.subtract(eCFieldElementSubtract2)).subtract(eCFieldElementM16344two3);
                eCFieldElementFromBigInteger = eCFieldElementFromBigInteger.mo16314isOne() ? eCFieldElementM16344two : eCFieldElementM16344two.multiply(eCFieldElementFromBigInteger);
                i2++;
                eCFieldElementMultiply = eCFieldElementSubtract2;
            }
            if (coordinateSystem == 0) {
                ECFieldElement eCFieldElementMo16313invert = eCFieldElementFromBigInteger.mo16313invert();
                ECFieldElement eCFieldElementMo16318square2 = eCFieldElementMo16313invert.mo16318square();
                return new Fp(curve, eCFieldElementMultiply.multiply(eCFieldElementMo16318square2), eCFieldElementSubtract.multiply(eCFieldElementMo16318square2.multiply(eCFieldElementMo16313invert)));
            }
            if (coordinateSystem == 1) {
                return new Fp(curve, eCFieldElementMultiply.multiply(eCFieldElementFromBigInteger), eCFieldElementSubtract, new ECFieldElement[]{eCFieldElementFromBigInteger.multiply(eCFieldElementFromBigInteger.mo16318square())});
            }
            if (coordinateSystem == 2) {
                return new Fp(curve, eCFieldElementMultiply, eCFieldElementSubtract, new ECFieldElement[]{eCFieldElementFromBigInteger});
            }
            if (coordinateSystem == 4) {
                return new Fp(curve, eCFieldElementMultiply, eCFieldElementSubtract, new ECFieldElement[]{eCFieldElementFromBigInteger, eCFieldElementM16298getA});
            }
            throw new IllegalStateException("unsupported coordinate system");
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        /* renamed from: twice */
        public AbstractC5820ECPoint mo16338twice() {
            ECFieldElement eCFieldElementSubtract;
            ECFieldElement eCFieldElementMultiply;
            if (isInfinity()) {
                return this;
            }
            AbstractC5817ECCurve curve = getCurve();
            ECFieldElement eCFieldElement = this.f22126y;
            if (eCFieldElement.mo16315isZero()) {
                return curve.getInfinity();
            }
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement2 = this.f22125x;
            if (coordinateSystem == 0) {
                ECFieldElement eCFieldElementMo16312divide = m16343three(eCFieldElement2.mo16318square()).mo16310add(getCurve().m16298getA()).mo16312divide(m16344two(eCFieldElement));
                ECFieldElement eCFieldElementSubtract2 = eCFieldElementMo16312divide.mo16318square().subtract(m16344two(eCFieldElement2));
                return new Fp(curve, eCFieldElementSubtract2, eCFieldElementMo16312divide.multiply(eCFieldElement2.subtract(eCFieldElementSubtract2)).subtract(eCFieldElement));
            }
            if (coordinateSystem == 1) {
                ECFieldElement eCFieldElement3 = this.f22127zs[0];
                boolean zMo16314isOne = eCFieldElement3.mo16314isOne();
                ECFieldElement eCFieldElementM16298getA = curve.m16298getA();
                if (!eCFieldElementM16298getA.mo16315isZero() && !zMo16314isOne) {
                    eCFieldElementM16298getA = eCFieldElementM16298getA.multiply(eCFieldElement3.mo16318square());
                }
                ECFieldElement eCFieldElementMo16310add = eCFieldElementM16298getA.mo16310add(m16343three(eCFieldElement2.mo16318square()));
                ECFieldElement eCFieldElementMultiply2 = zMo16314isOne ? eCFieldElement : eCFieldElement.multiply(eCFieldElement3);
                ECFieldElement eCFieldElementMo16318square = zMo16314isOne ? eCFieldElement.mo16318square() : eCFieldElementMultiply2.multiply(eCFieldElement);
                ECFieldElement eCFieldElementM16342four = m16342four(eCFieldElement2.multiply(eCFieldElementMo16318square));
                ECFieldElement eCFieldElementSubtract3 = eCFieldElementMo16310add.mo16318square().subtract(m16344two(eCFieldElementM16342four));
                ECFieldElement eCFieldElementM16344two = m16344two(eCFieldElementMultiply2);
                ECFieldElement eCFieldElementMultiply3 = eCFieldElementSubtract3.multiply(eCFieldElementM16344two);
                ECFieldElement eCFieldElementM16344two2 = m16344two(eCFieldElementMo16318square);
                return new Fp(curve, eCFieldElementMultiply3, eCFieldElementM16342four.subtract(eCFieldElementSubtract3).multiply(eCFieldElementMo16310add).subtract(m16344two(eCFieldElementM16344two2.mo16318square())), new ECFieldElement[]{m16344two(zMo16314isOne ? m16344two(eCFieldElementM16344two2) : eCFieldElementM16344two.mo16318square()).multiply(eCFieldElementMultiply2)});
            }
            if (coordinateSystem != 2) {
                if (coordinateSystem == 4) {
                    return twiceJacobianModified(true);
                }
                throw new IllegalStateException("unsupported coordinate system");
            }
            ECFieldElement eCFieldElement4 = this.f22127zs[0];
            boolean zMo16314isOne2 = eCFieldElement4.mo16314isOne();
            ECFieldElement eCFieldElementMo16318square2 = eCFieldElement.mo16318square();
            ECFieldElement eCFieldElementMo16318square3 = eCFieldElementMo16318square2.mo16318square();
            ECFieldElement eCFieldElementM16298getA2 = curve.m16298getA();
            ECFieldElement eCFieldElementMo16316negate = eCFieldElementM16298getA2.mo16316negate();
            if (eCFieldElementMo16316negate.toBigInteger().equals(BigInteger.valueOf(3L))) {
                ECFieldElement eCFieldElementMo16318square4 = zMo16314isOne2 ? eCFieldElement4 : eCFieldElement4.mo16318square();
                eCFieldElementSubtract = m16343three(eCFieldElement2.mo16310add(eCFieldElementMo16318square4).multiply(eCFieldElement2.subtract(eCFieldElementMo16318square4)));
                eCFieldElementMultiply = eCFieldElementMo16318square2.multiply(eCFieldElement2);
            } else {
                ECFieldElement eCFieldElementM16343three = m16343three(eCFieldElement2.mo16318square());
                if (zMo16314isOne2) {
                    eCFieldElementSubtract = eCFieldElementM16343three.mo16310add(eCFieldElementM16298getA2);
                    eCFieldElementMultiply = eCFieldElement2.multiply(eCFieldElementMo16318square2);
                } else {
                    if (eCFieldElementM16298getA2.mo16315isZero()) {
                        eCFieldElementSubtract = eCFieldElementM16343three;
                    } else {
                        ECFieldElement eCFieldElementMo16318square5 = eCFieldElement4.mo16318square().mo16318square();
                        if (eCFieldElementMo16316negate.bitLength() < eCFieldElementM16298getA2.bitLength()) {
                            eCFieldElementSubtract = eCFieldElementM16343three.subtract(eCFieldElementMo16318square5.multiply(eCFieldElementMo16316negate));
                        } else {
                            eCFieldElementM16298getA2 = eCFieldElementMo16318square5.multiply(eCFieldElementM16298getA2);
                            eCFieldElementSubtract = eCFieldElementM16343three.mo16310add(eCFieldElementM16298getA2);
                        }
                    }
                    eCFieldElementMultiply = eCFieldElement2.multiply(eCFieldElementMo16318square2);
                }
            }
            ECFieldElement eCFieldElementM16342four2 = m16342four(eCFieldElementMultiply);
            ECFieldElement eCFieldElementSubtract4 = eCFieldElementSubtract.mo16318square().subtract(m16344two(eCFieldElementM16342four2));
            ECFieldElement eCFieldElementSubtract5 = eCFieldElementM16342four2.subtract(eCFieldElementSubtract4).multiply(eCFieldElementSubtract).subtract(m16341eight(eCFieldElementMo16318square3));
            ECFieldElement eCFieldElementM16344two3 = m16344two(eCFieldElement);
            if (!zMo16314isOne2) {
                eCFieldElementM16344two3 = eCFieldElementM16344two3.multiply(eCFieldElement4);
            }
            return new Fp(curve, eCFieldElementSubtract4, eCFieldElementSubtract5, new ECFieldElement[]{eCFieldElementM16344two3});
        }

        public Fp twiceJacobianModified(boolean z) {
            ECFieldElement eCFieldElement = this.f22125x;
            ECFieldElement eCFieldElement2 = this.f22126y;
            ECFieldElement eCFieldElement3 = this.f22127zs[0];
            ECFieldElement jacobianModifiedW = getJacobianModifiedW();
            ECFieldElement eCFieldElementMo16310add = m16343three(eCFieldElement.mo16318square()).mo16310add(jacobianModifiedW);
            ECFieldElement eCFieldElementM16344two = m16344two(eCFieldElement2);
            ECFieldElement eCFieldElementMultiply = eCFieldElementM16344two.multiply(eCFieldElement2);
            ECFieldElement eCFieldElementM16344two2 = m16344two(eCFieldElement.multiply(eCFieldElementMultiply));
            ECFieldElement eCFieldElementSubtract = eCFieldElementMo16310add.mo16318square().subtract(m16344two(eCFieldElementM16344two2));
            ECFieldElement eCFieldElementM16344two3 = m16344two(eCFieldElementMultiply.mo16318square());
            ECFieldElement eCFieldElementSubtract2 = eCFieldElementMo16310add.multiply(eCFieldElementM16344two2.subtract(eCFieldElementSubtract)).subtract(eCFieldElementM16344two3);
            ECFieldElement eCFieldElementM16344two4 = z ? m16344two(eCFieldElementM16344two3.multiply(jacobianModifiedW)) : null;
            if (!eCFieldElement3.mo16314isOne()) {
                eCFieldElementM16344two = eCFieldElementM16344two.multiply(eCFieldElement3);
            }
            return new Fp(getCurve(), eCFieldElementSubtract, eCFieldElementSubtract2, new ECFieldElement[]{eCFieldElementM16344two, eCFieldElementM16344two4});
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
        public AbstractC5820ECPoint twicePlus(AbstractC5820ECPoint abstractC5820ECPoint) {
            if (this == abstractC5820ECPoint) {
                return threeTimes();
            }
            if (isInfinity()) {
                return abstractC5820ECPoint;
            }
            if (abstractC5820ECPoint.isInfinity()) {
                return mo16338twice();
            }
            ECFieldElement eCFieldElement = this.f22126y;
            if (eCFieldElement.mo16315isZero()) {
                return abstractC5820ECPoint;
            }
            AbstractC5817ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem != 0) {
                return coordinateSystem != 4 ? mo16338twice().mo16330add(abstractC5820ECPoint) : twiceJacobianModified(false).mo16330add(abstractC5820ECPoint);
            }
            ECFieldElement eCFieldElement2 = this.f22125x;
            ECFieldElement eCFieldElement3 = abstractC5820ECPoint.f22125x;
            ECFieldElement eCFieldElement4 = abstractC5820ECPoint.f22126y;
            ECFieldElement eCFieldElementSubtract = eCFieldElement3.subtract(eCFieldElement2);
            ECFieldElement eCFieldElementSubtract2 = eCFieldElement4.subtract(eCFieldElement);
            if (eCFieldElementSubtract.mo16315isZero()) {
                return eCFieldElementSubtract2.mo16315isZero() ? threeTimes() : this;
            }
            ECFieldElement eCFieldElementMo16318square = eCFieldElementSubtract.mo16318square();
            ECFieldElement eCFieldElementSubtract3 = eCFieldElementMo16318square.multiply(m16344two(eCFieldElement2).mo16310add(eCFieldElement3)).subtract(eCFieldElementSubtract2.mo16318square());
            if (eCFieldElementSubtract3.mo16315isZero()) {
                return curve.getInfinity();
            }
            ECFieldElement eCFieldElementMo16313invert = eCFieldElementSubtract3.multiply(eCFieldElementSubtract).mo16313invert();
            ECFieldElement eCFieldElementMultiply = eCFieldElementSubtract3.multiply(eCFieldElementMo16313invert).multiply(eCFieldElementSubtract2);
            ECFieldElement eCFieldElementSubtract4 = m16344two(eCFieldElement).multiply(eCFieldElementMo16318square).multiply(eCFieldElementSubtract).multiply(eCFieldElementMo16313invert).subtract(eCFieldElementMultiply);
            ECFieldElement eCFieldElementMo16310add = eCFieldElementSubtract4.subtract(eCFieldElementMultiply).multiply(eCFieldElementMultiply.mo16310add(eCFieldElementSubtract4)).mo16310add(eCFieldElement3);
            return new Fp(curve, eCFieldElementMo16310add, eCFieldElement2.subtract(eCFieldElementMo16310add).multiply(eCFieldElementSubtract4).subtract(eCFieldElement));
        }

        /* renamed from: two */
        public ECFieldElement m16344two(ECFieldElement eCFieldElement) {
            return eCFieldElement.mo16310add(eCFieldElement);
        }

        public Fp(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }
    }

    public AbstractC5820ECPoint(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, getInitialZCoords(abstractC5817ECCurve));
    }

    public static ECFieldElement[] getInitialZCoords(AbstractC5817ECCurve abstractC5817ECCurve) {
        int coordinateSystem = abstractC5817ECCurve == null ? 0 : abstractC5817ECCurve.getCoordinateSystem();
        if (coordinateSystem == 0 || coordinateSystem == 5) {
            return EMPTY_ZS;
        }
        ECFieldElement eCFieldElementFromBigInteger = abstractC5817ECCurve.fromBigInteger(ECConstants.f22091ONE);
        if (coordinateSystem != 1 && coordinateSystem != 2) {
            if (coordinateSystem == 3) {
                return new ECFieldElement[]{eCFieldElementFromBigInteger, eCFieldElementFromBigInteger, eCFieldElementFromBigInteger};
            }
            if (coordinateSystem == 4) {
                return new ECFieldElement[]{eCFieldElementFromBigInteger, abstractC5817ECCurve.m16298getA()};
            }
            if (coordinateSystem != 6) {
                throw new IllegalArgumentException("unknown coordinate system");
            }
        }
        return new ECFieldElement[]{eCFieldElementFromBigInteger};
    }

    /* renamed from: add */
    public abstract AbstractC5820ECPoint mo16330add(AbstractC5820ECPoint abstractC5820ECPoint);

    public void checkNormalized() {
        if (!isNormalized()) {
            throw new IllegalStateException("point not in normal form");
        }
    }

    public AbstractC5820ECPoint createScaledPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return getCurve().createRawPoint(getRawXCoord().multiply(eCFieldElement), getRawYCoord().multiply(eCFieldElement2));
    }

    /* renamed from: detach */
    public abstract AbstractC5820ECPoint mo16331detach();

    public void encodeTo(boolean z, byte[] bArr, int i) {
        if (isInfinity()) {
            bArr[i] = 0;
            return;
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = normalize();
        ECFieldElement xCoord = abstractC5820ECPointNormalize.getXCoord();
        ECFieldElement yCoord = abstractC5820ECPointNormalize.getYCoord();
        if (z) {
            bArr[i] = (byte) (abstractC5820ECPointNormalize.getCompressionYTilde() ? 3 : 2);
            xCoord.encodeTo(bArr, i + 1);
        } else {
            bArr[i] = 4;
            int i2 = i + 1;
            xCoord.encodeTo(bArr, i2);
            yCoord.encodeTo(bArr, i2 + xCoord.getEncodedLength());
        }
    }

    /* renamed from: equals */
    public boolean m16332equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC5820ECPoint) {
            return m16333equals((AbstractC5820ECPoint) obj);
        }
        return false;
    }

    public ECFieldElement getAffineXCoord() {
        checkNormalized();
        return getXCoord();
    }

    public ECFieldElement getAffineYCoord() {
        checkNormalized();
        return getYCoord();
    }

    public abstract boolean getCompressionYTilde();

    public AbstractC5817ECCurve getCurve() {
        return this.f22124curve;
    }

    public int getCurveCoordinateSystem() {
        AbstractC5817ECCurve abstractC5817ECCurve = this.f22124curve;
        if (abstractC5817ECCurve == null) {
            return 0;
        }
        return abstractC5817ECCurve.getCoordinateSystem();
    }

    public final AbstractC5820ECPoint getDetachedPoint() {
        return normalize().mo16331detach();
    }

    public byte[] getEncoded(boolean z) {
        if (isInfinity()) {
            return new byte[1];
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = normalize();
        byte[] encoded = abstractC5820ECPointNormalize.getXCoord().getEncoded();
        if (z) {
            byte[] bArr = new byte[encoded.length + 1];
            bArr[0] = (byte) (abstractC5820ECPointNormalize.getCompressionYTilde() ? 3 : 2);
            System.arraycopy(encoded, 0, bArr, 1, encoded.length);
            return bArr;
        }
        byte[] encoded2 = abstractC5820ECPointNormalize.getYCoord().getEncoded();
        byte[] bArr2 = new byte[encoded.length + encoded2.length + 1];
        bArr2[0] = 4;
        System.arraycopy(encoded, 0, bArr2, 1, encoded.length);
        System.arraycopy(encoded2, 0, bArr2, encoded.length + 1, encoded2.length);
        return bArr2;
    }

    public int getEncodedLength(boolean z) {
        if (isInfinity()) {
            return 1;
        }
        return z ? getXCoord().getEncodedLength() + 1 : getXCoord().getEncodedLength() + 1 + getYCoord().getEncodedLength();
    }

    public final ECFieldElement getRawXCoord() {
        return this.f22125x;
    }

    public final ECFieldElement getRawYCoord() {
        return this.f22126y;
    }

    public final ECFieldElement[] getRawZCoords() {
        return this.f22127zs;
    }

    public ECFieldElement getXCoord() {
        return this.f22125x;
    }

    public ECFieldElement getYCoord() {
        return this.f22126y;
    }

    public ECFieldElement getZCoord(int i) {
        if (i >= 0) {
            ECFieldElement[] eCFieldElementArr = this.f22127zs;
            if (i < eCFieldElementArr.length) {
                return eCFieldElementArr[i];
            }
        }
        return null;
    }

    public ECFieldElement[] getZCoords() {
        ECFieldElement[] eCFieldElementArr = this.f22127zs;
        int length = eCFieldElementArr.length;
        if (length == 0) {
            return EMPTY_ZS;
        }
        ECFieldElement[] eCFieldElementArr2 = new ECFieldElement[length];
        System.arraycopy(eCFieldElementArr, 0, eCFieldElementArr2, 0, length);
        return eCFieldElementArr2;
    }

    public int hashCode() {
        AbstractC5817ECCurve curve = getCurve();
        int i = curve == null ? 0 : ~curve.hashCode();
        if (isInfinity()) {
            return i;
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = normalize();
        return (i ^ (abstractC5820ECPointNormalize.getXCoord().hashCode() * 17)) ^ (abstractC5820ECPointNormalize.getYCoord().hashCode() * 257);
    }

    public boolean implIsValid(final boolean z, final boolean z2) {
        if (isInfinity()) {
            return true;
        }
        return !((ValidityPrecompInfo) getCurve().precompute(this, "bc_validity", new PreCompCallback(this) { // from class: org.bouncycastle.math.ec.ECPoint.1

            /* renamed from: this$0 */
            final /* synthetic */ AbstractC5820ECPoint f22128this$0;

            {
                this.f22128this$0 = this;
            }

            @Override // org.bouncycastle.p284math.p285ec.PreCompCallback
            public PreCompInfo precompute(PreCompInfo preCompInfo) {
                ValidityPrecompInfo validityPrecompInfo = preCompInfo instanceof ValidityPrecompInfo ? (ValidityPrecompInfo) preCompInfo : null;
                if (validityPrecompInfo == null) {
                    validityPrecompInfo = new ValidityPrecompInfo();
                }
                if (validityPrecompInfo.hasFailed()) {
                    return validityPrecompInfo;
                }
                if (!validityPrecompInfo.hasCurveEquationPassed()) {
                    if (!z && !this.f22128this$0.satisfiesCurveEquation()) {
                        validityPrecompInfo.reportFailed();
                        return validityPrecompInfo;
                    }
                    validityPrecompInfo.reportCurveEquationPassed();
                }
                if (z2 && !validityPrecompInfo.hasOrderPassed()) {
                    if (!this.f22128this$0.satisfiesOrder()) {
                        validityPrecompInfo.reportFailed();
                        return validityPrecompInfo;
                    }
                    validityPrecompInfo.reportOrderPassed();
                }
                return validityPrecompInfo;
            }
        })).hasFailed();
    }

    public boolean isInfinity() {
        if (this.f22125x != null && this.f22126y != null) {
            ECFieldElement[] eCFieldElementArr = this.f22127zs;
            if (eCFieldElementArr.length <= 0 || !eCFieldElementArr[0].mo16315isZero()) {
                return false;
            }
        }
        return true;
    }

    public boolean isNormalized() {
        int curveCoordinateSystem = getCurveCoordinateSystem();
        return curveCoordinateSystem == 0 || curveCoordinateSystem == 5 || isInfinity() || this.f22127zs[0].mo16314isOne();
    }

    /* renamed from: isValid */
    public boolean m16334isValid() {
        return implIsValid(false, true);
    }

    public boolean isValidPartial() {
        return implIsValid(false, false);
    }

    public AbstractC5820ECPoint multiply(BigInteger bigInteger) {
        return getCurve().getMultiplier().multiply(this, bigInteger);
    }

    /* renamed from: negate */
    public abstract AbstractC5820ECPoint mo16335negate();

    public AbstractC5820ECPoint normalize() {
        int curveCoordinateSystem;
        if (isInfinity() || (curveCoordinateSystem = getCurveCoordinateSystem()) == 0 || curveCoordinateSystem == 5) {
            return this;
        }
        ECFieldElement zCoord = getZCoord(0);
        if (zCoord.mo16314isOne()) {
            return this;
        }
        if (this.f22124curve == null) {
            throw new IllegalStateException("Detached points must be in affine coordinates");
        }
        ECFieldElement eCFieldElementRandomFieldElementMult = this.f22124curve.randomFieldElementMult(CryptoServicesRegistrar.getSecureRandom());
        return normalize(zCoord.multiply(eCFieldElementRandomFieldElementMult).mo16313invert().multiply(eCFieldElementRandomFieldElementMult));
    }

    public abstract boolean satisfiesCurveEquation();

    public boolean satisfiesOrder() {
        BigInteger order;
        return ECConstants.f22091ONE.equals(this.f22124curve.getCofactor()) || (order = this.f22124curve.getOrder()) == null || ECAlgorithms.referenceMultiply(this, order).isInfinity();
    }

    /* renamed from: scaleX */
    public AbstractC5820ECPoint mo16336scaleX(ECFieldElement eCFieldElement) {
        return isInfinity() ? this : getCurve().createRawPoint(getRawXCoord().multiply(eCFieldElement), getRawYCoord(), getRawZCoords());
    }

    public AbstractC5820ECPoint scaleXNegateY(ECFieldElement eCFieldElement) {
        return isInfinity() ? this : getCurve().createRawPoint(getRawXCoord().multiply(eCFieldElement), getRawYCoord().mo16316negate(), getRawZCoords());
    }

    /* renamed from: scaleY */
    public AbstractC5820ECPoint mo16337scaleY(ECFieldElement eCFieldElement) {
        return isInfinity() ? this : getCurve().createRawPoint(getRawXCoord(), getRawYCoord().multiply(eCFieldElement), getRawZCoords());
    }

    public AbstractC5820ECPoint scaleYNegateX(ECFieldElement eCFieldElement) {
        return isInfinity() ? this : getCurve().createRawPoint(getRawXCoord().mo16316negate(), getRawYCoord().multiply(eCFieldElement), getRawZCoords());
    }

    public abstract AbstractC5820ECPoint subtract(AbstractC5820ECPoint abstractC5820ECPoint);

    public AbstractC5820ECPoint threeTimes() {
        return twicePlus(this);
    }

    public AbstractC5820ECPoint timesPow2(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("'e' cannot be negative");
        }
        while (true) {
            i--;
            if (i < 0) {
                return this;
            }
            this = this.mo16338twice();
        }
    }

    public String toString() {
        if (isInfinity()) {
            return "INF";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(getRawXCoord());
        sb.append(',');
        sb.append(getRawYCoord());
        for (int i = 0; i < this.f22127zs.length; i++) {
            sb.append(',');
            sb.append(this.f22127zs[i]);
        }
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: twice */
    public abstract AbstractC5820ECPoint mo16338twice();

    public AbstractC5820ECPoint twicePlus(AbstractC5820ECPoint abstractC5820ECPoint) {
        return mo16338twice().mo16330add(abstractC5820ECPoint);
    }

    public AbstractC5820ECPoint(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        this.preCompTable = null;
        this.f22124curve = abstractC5817ECCurve;
        this.f22125x = eCFieldElement;
        this.f22126y = eCFieldElement2;
        this.f22127zs = eCFieldElementArr;
    }

    /* renamed from: equals */
    public boolean m16333equals(AbstractC5820ECPoint abstractC5820ECPoint) {
        if (abstractC5820ECPoint == null) {
            return false;
        }
        AbstractC5817ECCurve curve = getCurve();
        AbstractC5817ECCurve curve2 = abstractC5820ECPoint.getCurve();
        boolean z = curve == null;
        boolean z2 = curve2 == null;
        boolean zIsInfinity = isInfinity();
        boolean zIsInfinity2 = abstractC5820ECPoint.isInfinity();
        if (zIsInfinity || zIsInfinity2) {
            if (zIsInfinity && zIsInfinity2) {
                return z || z2 || curve.m16297equals(curve2);
            }
            return false;
        }
        if (!z || !z2) {
            if (z) {
                abstractC5820ECPoint = abstractC5820ECPoint.normalize();
            } else if (z2) {
                this = normalize();
            } else {
                if (!curve.m16297equals(curve2)) {
                    return false;
                }
                AbstractC5820ECPoint[] abstractC5820ECPointArr = {this, curve.importPoint(abstractC5820ECPoint)};
                curve.normalizeAll(abstractC5820ECPointArr);
                AbstractC5820ECPoint abstractC5820ECPoint2 = abstractC5820ECPointArr[0];
                abstractC5820ECPoint = abstractC5820ECPointArr[1];
                this = abstractC5820ECPoint2;
            }
        }
        return this.getXCoord().equals(abstractC5820ECPoint.getXCoord()) && this.getYCoord().equals(abstractC5820ECPoint.getYCoord());
    }

    public AbstractC5820ECPoint normalize(ECFieldElement eCFieldElement) {
        int curveCoordinateSystem = getCurveCoordinateSystem();
        if (curveCoordinateSystem != 1) {
            if (curveCoordinateSystem == 2 || curveCoordinateSystem == 3 || curveCoordinateSystem == 4) {
                ECFieldElement eCFieldElementMo16318square = eCFieldElement.mo16318square();
                return createScaledPoint(eCFieldElementMo16318square, eCFieldElementMo16318square.multiply(eCFieldElement));
            }
            if (curveCoordinateSystem != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return createScaledPoint(eCFieldElement, eCFieldElement);
    }
}
