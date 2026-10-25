package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.p133asn1.p148gm.GMObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p199digests.SM3Digest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;

/* renamed from: org.bouncycastle.jcajce.provider.digest.SM3 */
/* loaded from: classes2.dex */
public class C5653SM3 {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SM3$Digest */
    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SM3Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.f21665digest = new SM3Digest((SM3Digest) this.f21665digest);
            return digest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SM3$HashMac */
    public static class HashMac extends C5789BaseMac {
        public HashMac() {
            super(new C5360HMac(new SM3Digest()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SM3$KeyGenerator */
    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSM3", 256, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SM3$Mappings */
    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21686PREFIX = C5653SM3.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21686PREFIX;
            sb.append(str);
            sb.append("$Digest");
            configurableProvider.addAlgorithm("MessageDigest.SM3", sb.toString());
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SM3", "SM3");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.1.2.156.197.1.401", "SM3");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + GMObjectIdentifiers.f18386sm3, "SM3");
            addHMACAlgorithm(configurableProvider, "SM3", str + "$HashMac", str + "$KeyGenerator");
            addHMACAlias(configurableProvider, "SM3", GMObjectIdentifiers.hmac_sm3);
        }
    }

    private C5653SM3() {
    }
}
