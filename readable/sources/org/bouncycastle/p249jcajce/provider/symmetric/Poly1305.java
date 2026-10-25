package org.bouncycastle.p249jcajce.provider.symmetric;

import org.bouncycastle.p194crypto.generators.Poly1305KeyGenerator;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;

/* loaded from: classes2.dex */
public class Poly1305 {

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Poly1305$KeyGen */
    public static class C5756KeyGen extends BaseKeyGenerator {
        public C5756KeyGen() {
            super("Poly1305", 256, new Poly1305KeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Poly1305$Mac */
    public static class C5757Mac extends C5789BaseMac {
        public C5757Mac() {
            super(new org.bouncycastle.p194crypto.p209macs.Poly1305());
        }
    }

    public static class Mappings extends AlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21816PREFIX = Poly1305.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21816PREFIX;
            sb.append(str);
            sb.append("$Mac");
            configurableProvider.addAlgorithm("Mac.POLY1305", sb.toString());
            configurableProvider.addAlgorithm("KeyGenerator.POLY1305", str + "$KeyGen");
        }
    }

    private Poly1305() {
    }
}
