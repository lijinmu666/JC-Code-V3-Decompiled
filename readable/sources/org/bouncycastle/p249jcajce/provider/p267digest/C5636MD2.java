package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p199digests.MD2Digest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;

/* renamed from: org.bouncycastle.jcajce.provider.digest.MD2 */
/* loaded from: classes2.dex */
public class C5636MD2 {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.MD2$Digest */
    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new MD2Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.f21665digest = new MD2Digest((MD2Digest) this.f21665digest);
            return digest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.MD2$HashMac */
    public static class HashMac extends C5789BaseMac {
        public HashMac() {
            super(new C5360HMac(new MD2Digest()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.MD2$KeyGenerator */
    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACMD2", 128, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.MD2$Mappings */
    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21673PREFIX = C5636MD2.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21673PREFIX;
            sb.append(str);
            sb.append("$Digest");
            configurableProvider.addAlgorithm("MessageDigest.MD2", sb.toString());
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + PKCSObjectIdentifiers.f18501md2, "MD2");
            addHMACAlgorithm(configurableProvider, "MD2", str + "$HashMac", str + "$KeyGenerator");
        }
    }

    private C5636MD2() {
    }
}
