package org.bouncycastle.p249jcajce.provider.symmetric;

import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p201engines.VMPCKSA3Engine;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseStreamCipher;

/* loaded from: classes2.dex */
public final class VMPCKSA3 {

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.VMPCKSA3$Base */
    public static class C5783Base extends BaseStreamCipher {
        public C5783Base() {
            super(new VMPCKSA3Engine(), 16);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.VMPCKSA3$KeyGen */
    public static class C5784KeyGen extends BaseKeyGenerator {
        public C5784KeyGen() {
            super("VMPC-KSA3", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21841PREFIX = VMPCKSA3.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21841PREFIX;
            sb.append(str);
            sb.append("$Base");
            configurableProvider.addAlgorithm("Cipher.VMPC-KSA3", sb.toString());
            configurableProvider.addAlgorithm("KeyGenerator.VMPC-KSA3", str + "$KeyGen");
        }
    }

    private VMPCKSA3() {
    }
}
