package org.bouncycastle.p249jcajce.provider.symmetric;

import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p201engines.Grain128Engine;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseStreamCipher;

/* loaded from: classes2.dex */
public final class Grain128 {

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Grain128$Base */
    public static class C5747Base extends BaseStreamCipher {
        public C5747Base() {
            super(new Grain128Engine(), 12);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Grain128$KeyGen */
    public static class C5748KeyGen extends BaseKeyGenerator {
        public C5748KeyGen() {
            super("Grain128", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21798PREFIX = Grain128.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21798PREFIX;
            sb.append(str);
            sb.append("$Base");
            configurableProvider.addAlgorithm("Cipher.Grain128", sb.toString());
            configurableProvider.addAlgorithm("KeyGenerator.Grain128", str + "$KeyGen");
        }
    }

    private Grain128() {
    }
}
