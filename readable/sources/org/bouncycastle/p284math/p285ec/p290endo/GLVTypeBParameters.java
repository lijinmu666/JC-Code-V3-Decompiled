package org.bouncycastle.p284math.p285ec.p290endo;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class GLVTypeBParameters {

    /* renamed from: beta */
    protected final BigInteger f22366beta;

    /* renamed from: lambda */
    protected final BigInteger f22367lambda;
    protected final ScalarSplitParameters splitParams;

    public GLVTypeBParameters(BigInteger bigInteger, BigInteger bigInteger2, ScalarSplitParameters scalarSplitParameters) {
        this.f22366beta = bigInteger;
        this.f22367lambda = bigInteger2;
        this.splitParams = scalarSplitParameters;
    }

    /* renamed from: getBeta */
    public BigInteger m16778getBeta() {
        return this.f22366beta;
    }

    public BigInteger getLambda() {
        return this.f22367lambda;
    }

    public ScalarSplitParameters getSplitParams() {
        return this.splitParams;
    }
}
