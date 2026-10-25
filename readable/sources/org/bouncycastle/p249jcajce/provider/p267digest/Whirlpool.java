package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.internal.p231asn1.p240iso.ISOIECObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p199digests.WhirlpoolDigest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;

/* loaded from: classes2.dex */
public class Whirlpool {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Whirlpool$Digest */
    public static class C5656Digest extends BCMessageDigest implements Cloneable {
        public C5656Digest() {
            super(new WhirlpoolDigest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            C5656Digest c5656Digest = (C5656Digest) super.clone();
            c5656Digest.f21665digest = new WhirlpoolDigest((WhirlpoolDigest) this.f21665digest);
            return c5656Digest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Whirlpool$HashMac */
    public static class C5657HashMac extends C5789BaseMac {
        public C5657HashMac() {
            super(new C5360HMac(new WhirlpoolDigest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACWHIRLPOOL", 512, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21689PREFIX = Whirlpool.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21689PREFIX;
            sb.append(str);
            sb.append("$Digest");
            configurableProvider.addAlgorithm("MessageDigest.WHIRLPOOL", sb.toString());
            configurableProvider.addAlgorithm("MessageDigest", ISOIECObjectIdentifiers.whirlpool, str + "$Digest");
            addHMACAlgorithm(configurableProvider, "WHIRLPOOL", str + "$HashMac", str + "$KeyGenerator");
        }
    }

    private Whirlpool() {
    }
}
