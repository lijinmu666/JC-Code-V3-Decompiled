package org.bouncycastle.p249jcajce.provider.symmetric.p277util;

import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import java.security.SecureRandom;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;

/* loaded from: classes2.dex */
public abstract class BaseAlgorithmParameterGenerator extends AlgorithmParameterGeneratorSpi {

    /* renamed from: random */
    protected SecureRandom f21853random;

    /* renamed from: helper */
    private final JcaJceHelper f21852helper = new BCJcaJceHelper();
    protected int strength = 1024;

    public final AlgorithmParameters createParametersInstance(String str) {
        return this.f21852helper.createAlgorithmParameters(str);
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.f21853random = secureRandom;
    }
}
