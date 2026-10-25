package org.bouncycastle.p249jcajce.provider.symmetric;

import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p209macs.C5364SipHash;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;

/* renamed from: org.bouncycastle.jcajce.provider.symmetric.SipHash */
/* loaded from: classes2.dex */
public final class C5769SipHash {

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SipHash$KeyGen */
    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("SipHash", 128, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SipHash$Mac24 */
    public static class Mac24 extends C5789BaseMac {
        public Mac24() {
            super(new C5364SipHash());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SipHash$Mac48 */
    public static class Mac48 extends C5789BaseMac {
        public Mac48() {
            super(new C5364SipHash(4, 8));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SipHash$Mappings */
    public static class Mappings extends AlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21832PREFIX = C5769SipHash.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21832PREFIX;
            sb.append(str);
            sb.append("$Mac24");
            configurableProvider.addAlgorithm("Mac.SIPHASH-2-4", sb.toString());
            configurableProvider.addAlgorithm("Alg.Alias.Mac.SIPHASH", "SIPHASH-2-4");
            configurableProvider.addAlgorithm("Mac.SIPHASH-4-8", str + "$Mac48");
            configurableProvider.addAlgorithm("KeyGenerator.SIPHASH", str + "$KeyGen");
            configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.SIPHASH-2-4", "SIPHASH");
            configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.SIPHASH-4-8", "SIPHASH");
        }
    }

    private C5769SipHash() {
    }
}
