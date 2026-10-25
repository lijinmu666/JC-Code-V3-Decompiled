package org.bouncycastle.p249jcajce.provider.symmetric;

import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p201engines.XSalsa20Engine;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseStreamCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters;

/* loaded from: classes2.dex */
public final class XSalsa20 {

    public static class AlgParams extends IvAlgorithmParameters {
        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "XSalsa20 IV";
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.XSalsa20$Base */
    public static class C5785Base extends BaseStreamCipher {
        public C5785Base() {
            super(new XSalsa20Engine(), 24);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.XSalsa20$KeyGen */
    public static class C5786KeyGen extends BaseKeyGenerator {
        public C5786KeyGen() {
            super("XSalsa20", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21842PREFIX = XSalsa20.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21842PREFIX;
            sb.append(str);
            sb.append("$Base");
            configurableProvider.addAlgorithm("Cipher.XSALSA20", sb.toString());
            configurableProvider.addAlgorithm("KeyGenerator.XSALSA20", str + "$KeyGen");
            configurableProvider.addAlgorithm("AlgorithmParameters.XSALSA20", str + "$AlgParams");
        }
    }

    private XSalsa20() {
    }
}
