package org.bouncycastle.p284math.p285ec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.p290endo.EndoUtil;
import org.bouncycastle.p284math.p285ec.p290endo.GLVEndomorphism;

/* loaded from: classes2.dex */
public class GLVMultiplier extends AbstractECMultiplier {

    /* renamed from: curve */
    protected final AbstractC5817ECCurve f22133curve;
    protected final GLVEndomorphism glvEndomorphism;

    public GLVMultiplier(AbstractC5817ECCurve abstractC5817ECCurve, GLVEndomorphism gLVEndomorphism) {
        if (abstractC5817ECCurve == null || abstractC5817ECCurve.getOrder() == null) {
            throw new IllegalArgumentException("Need curve with known group order");
        }
        this.f22133curve = abstractC5817ECCurve;
        this.glvEndomorphism = gLVEndomorphism;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractECMultiplier
    public AbstractC5820ECPoint multiplyPositive(AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger) {
        if (!this.f22133curve.m16297equals(abstractC5820ECPoint.getCurve())) {
            throw new IllegalStateException();
        }
        BigInteger[] bigIntegerArrDecomposeScalar = this.glvEndomorphism.decomposeScalar(bigInteger.mod(abstractC5820ECPoint.getCurve().getOrder()));
        BigInteger bigInteger2 = bigIntegerArrDecomposeScalar[0];
        BigInteger bigInteger3 = bigIntegerArrDecomposeScalar[1];
        boolean zHasEfficientPointMap = this.glvEndomorphism.hasEfficientPointMap();
        GLVEndomorphism gLVEndomorphism = this.glvEndomorphism;
        return zHasEfficientPointMap ? ECAlgorithms.implShamirsTrickWNaf(gLVEndomorphism, abstractC5820ECPoint, bigInteger2, bigInteger3) : ECAlgorithms.implShamirsTrickWNaf(abstractC5820ECPoint, bigInteger2, EndoUtil.mapPoint(gLVEndomorphism, abstractC5820ECPoint), bigInteger3);
    }
}
