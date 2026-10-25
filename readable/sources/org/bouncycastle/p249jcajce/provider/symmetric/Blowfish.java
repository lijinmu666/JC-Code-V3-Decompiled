package org.bouncycastle.p249jcajce.provider.symmetric;

import org.bouncycastle.internal.p231asn1.p242misc.MiscObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p201engines.BlowfishEngine;
import org.bouncycastle.p194crypto.p209macs.C5358CMac;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseBlockCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters;

/* loaded from: classes2.dex */
public final class Blowfish {

    public static class AlgParams extends IvAlgorithmParameters {
        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Blowfish IV";
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Blowfish$CBC */
    public static class C5680CBC extends BaseBlockCipher {
        public C5680CBC() {
            super(new CBCBlockCipher(new BlowfishEngine()), 64);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Blowfish$CMAC */
    public static class C5681CMAC extends C5789BaseMac {
        public C5681CMAC() {
            super(new C5358CMac(new BlowfishEngine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Blowfish$ECB */
    public static class C5682ECB extends BaseBlockCipher {
        public C5682ECB() {
            super(new BlowfishEngine());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Blowfish$KeyGen */
    public static class C5683KeyGen extends BaseKeyGenerator {
        public C5683KeyGen() {
            super("Blowfish", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21775PREFIX = Blowfish.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21775PREFIX;
            sb.append(str);
            sb.append("$CMAC");
            configurableProvider.addAlgorithm("Mac.BLOWFISHCMAC", sb.toString());
            configurableProvider.addAlgorithm("Cipher.BLOWFISH", str + "$ECB");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CBC;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier, str + "$CBC");
            configurableProvider.addAlgorithm("KeyGenerator.BLOWFISH", str + "$KeyGen");
            configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator", aSN1ObjectIdentifier, "BLOWFISH");
            configurableProvider.addAlgorithm("AlgorithmParameters.BLOWFISH", str + "$AlgParams");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters", aSN1ObjectIdentifier, "BLOWFISH");
        }
    }

    private Blowfish() {
    }
}
