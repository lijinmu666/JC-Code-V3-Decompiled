package org.bouncycastle.p284math.p285ec.p290endo;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.ECPointMap;
import org.bouncycastle.p284math.p285ec.ScaleXPointMap;

/* loaded from: classes2.dex */
public class GLVTypeBEndomorphism implements GLVEndomorphism {
    protected final GLVTypeBParameters parameters;
    protected final ECPointMap pointMap;

    public GLVTypeBEndomorphism(AbstractC5817ECCurve abstractC5817ECCurve, GLVTypeBParameters gLVTypeBParameters) {
        this.parameters = gLVTypeBParameters;
        this.pointMap = new ScaleXPointMap(abstractC5817ECCurve.fromBigInteger(gLVTypeBParameters.m16778getBeta()));
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
