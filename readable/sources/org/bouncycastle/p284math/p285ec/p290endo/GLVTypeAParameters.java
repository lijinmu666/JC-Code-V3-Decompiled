package org.bouncycastle.p284math.p285ec.p290endo;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class GLVTypeAParameters {

    /* renamed from: i */
    protected final BigInteger f22364i;

    /* renamed from: lambda */
    protected final BigInteger f22365lambda;
    protected final ScalarSplitParameters splitParams;

    public GLVTypeAParameters(BigInteger bigInteger, BigInteger bigInteger2, ScalarSplitParameters scalarSplitParameters) {
        this.f22364i = bigInteger;
        this.f22365lambda = bigInteger2;
        this.splitParams = scalarSplitParameters;
    }

    /* renamed from: getI */
    public BigInteger m16777getI() {
        return this.f22364i;
    }

    public BigInteger getLambda() {
        return this.f22365lambda;
    }

    public ScalarSplitParameters getSplitParams() {
        return this.splitParams;
    }
}
