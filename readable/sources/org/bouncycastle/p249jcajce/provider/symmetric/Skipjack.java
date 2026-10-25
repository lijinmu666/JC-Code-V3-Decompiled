package org.bouncycastle.p249jcajce.provider.symmetric;

import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p201engines.SkipjackEngine;
import org.bouncycastle.p194crypto.p209macs.CBCBlockCipherMac;
import org.bouncycastle.p194crypto.p209macs.CFBBlockCipherMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseBlockCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters;

/* loaded from: classes2.dex */
public final class Skipjack {

    public static class AlgParams extends IvAlgorithmParameters {
        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Skipjack IV";
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Skipjack$ECB */
    public static class C5773ECB extends BaseBlockCipher {
        public C5773ECB() {
            super(new SkipjackEngine());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Skipjack$KeyGen */
    public static class C5774KeyGen extends BaseKeyGenerator {
        public C5774KeyGen() {
            super("Skipjack", 80, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Skipjack$Mac */
    public static class C5775Mac extends C5789BaseMac {
        public C5775Mac() {
            super(new CBCBlockCipherMac(new SkipjackEngine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Skipjack$MacCFB8 */
    public static class C5776MacCFB8 extends C5789BaseMac {
        public C5776MacCFB8() {
            super(new CFBBlockCipherMac(new SkipjackEngine()));
        }
    }

    public static class Mappings extends AlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21834PREFIX = Skipjack.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21834PREFIX;
            sb.append(str);
            sb.append("$ECB");
            configurableProvider.addAlgorithm("Cipher.SKIPJACK", sb.toString());
            configurableProvider.addAlgorithm("KeyGenerator.SKIPJACK", str + "$KeyGen");
            configurableProvider.addAlgorithm("AlgorithmParameters.SKIPJACK", str + "$AlgParams");
            configurableProvider.addAlgorithm("Mac.SKIPJACKMAC", str + "$Mac");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.SKIPJACK", "SKIPJACKMAC");
            configurableProvider.addAlgorithm("Mac.SKIPJACKMAC/CFB8", str + "$MacCFB8");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.SKIPJACK/CFB8", "SKIPJACKMAC/CFB8");
        }
    }

    private Skipjack() {
    }
}
