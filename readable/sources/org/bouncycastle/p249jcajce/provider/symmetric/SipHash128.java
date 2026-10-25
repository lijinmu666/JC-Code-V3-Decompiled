package org.bouncycastle.p249jcajce.provider.symmetric;

import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;

/* loaded from: classes2.dex */
public final class SipHash128 {

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SipHash128$KeyGen */
    public static class C5770KeyGen extends BaseKeyGenerator {
        public C5770KeyGen() {
            super("SipHash128", 128, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SipHash128$Mac24 */
    public static class C5771Mac24 extends C5789BaseMac {
        public C5771Mac24() {
            super(new org.bouncycastle.p194crypto.p209macs.SipHash128());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SipHash128$Mac48 */
    public static class C5772Mac48 extends C5789BaseMac {
        public C5772Mac48() {
            super(new org.bouncycastle.p194crypto.p209macs.SipHash128(4, 8));
        }
    }

    public static class Mappings extends AlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21833PREFIX = SipHash128.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21833PREFIX;
            sb.append(str);
            sb.append("$Mac24");
            configurableProvider.addAlgorithm("Mac.SIPHASH128-2-4", sb.toString());
            configurableProvider.addAlgorithm("Alg.Alias.Mac.SIPHASH128", "SIPHASH128-2-4");
            configurableProvider.addAlgorithm("Mac.SIPHASH128-4-8", str + "$Mac48");
            configurableProvider.addAlgorithm("KeyGenerator.SIPHASH128", str + "$KeyGen");
            configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.SIPHASH128-2-4", "SIPHASH128");
            configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.SIPHASH128-4-8", "SIPHASH128");
        }
    }

    private SipHash128() {
    }
}
