package org.bouncycastle.p249jcajce.provider.asymmetric.p264util;

import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;

/* loaded from: classes2.dex */
public abstract class BaseAlgorithmParameterGeneratorSpi extends AlgorithmParameterGeneratorSpi {

    /* renamed from: helper */
    private final JcaJceHelper f21632helper = new BCJcaJceHelper();

    public final AlgorithmParameters createParametersInstance(String str) {
        return this.f21632helper.createAlgorithmParameters(str);
    }
}
