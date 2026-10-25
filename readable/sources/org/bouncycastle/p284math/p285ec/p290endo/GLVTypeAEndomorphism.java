package org.bouncycastle.p284math.p285ec.p290endo;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.ECPointMap;
import org.bouncycastle.p284math.p285ec.ScaleYNegateXPointMap;

/* loaded from: classes2.dex */
public class GLVTypeAEndomorphism implements GLVEndomorphism {
    protected final GLVTypeAParameters parameters;
    protected final ECPointMap pointMap;

    public GLVTypeAEndomorphism(AbstractC5817ECCurve abstractC5817ECCurve, GLVTypeAParameters gLVTypeAParameters) {
        this.parameters = gLVTypeAParameters;
        this.pointMap = new ScaleYNegateXPointMap(abstractC5817ECCurve.fromBigInteger(gLVTypeAParameters.m16777getI()));
    }

    @Override // org.bouncycastle.p284math.p285ec.p290endo.GLVEndomorphism
    public BigInteger[] decomposeScalar(BigInteger bigInteger) {
        return EndoUtil.decomposeScalar(this.parameters.getSplitParams(), bigInteger);
    }

    @Override // org.bouncycastle.p284math.p285ec.p290endo.ECEndomorphism
    public ECPointMap getPointMap() {
        return this.pointMap;
    }

    @Override // org.bouncycastle.p284math.p285ec.p290endo.ECEndomorphism
    public boolean hasEfficientPointMap() {
        return true;
    }
}
