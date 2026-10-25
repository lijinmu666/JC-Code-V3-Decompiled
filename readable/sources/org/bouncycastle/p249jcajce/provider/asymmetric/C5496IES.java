package org.bouncycastle.p249jcajce.provider.asymmetric;

import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricAlgorithmProvider;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.IES */
/* loaded from: classes2.dex */
public class C5496IES {

    /* renamed from: PREFIX */
    private static final String f21396PREFIX = "org.bouncycastle.jcajce.provider.asymmetric.ies.";

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.IES$Mappings */
    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("AlgorithmParameters.IES", "org.bouncycastle.jcajce.provider.asymmetric.ies.AlgorithmParametersSpi");
            configurableProvider.addAlgorithm("AlgorithmParameters.ECIES", "org.bouncycastle.jcajce.provider.asymmetric.ies.AlgorithmParametersSpi");
        }
    }
}
