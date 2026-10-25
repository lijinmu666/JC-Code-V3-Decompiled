package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p199digests.RIPEMD128Digest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;

/* loaded from: classes2.dex */
public class RIPEMD128 {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.RIPEMD128$Digest */
    public static class C5639Digest extends BCMessageDigest implements Cloneable {
        public C5639Digest() {
            super(new RIPEMD128Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            C5639Digest c5639Digest = (C5639Digest) super.clone();
            c5639Digest.f21665digest = new RIPEMD128Digest((RIPEMD128Digest) this.f21665digest);
            return c5639Digest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.RIPEMD128$HashMac */
    public static class C5640HashMac extends C5789BaseMac {
        public C5640HashMac() {
            super(new C5360HMac(new RIPEMD128Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACRIPEMD128", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21676PREFIX = RIPEMD128.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21676PREFIX;
            sb.append(str);
            sb.append("$Digest");
            configurableProvider.addAlgorithm("MessageDigest.RIPEMD128", sb.toString());
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + TeleTrusTObjectIdentifiers.ripemd128, "RIPEMD128");
            addHMACAlgorithm(configurableProvider, "RIPEMD128", str + "$HashMac", str + "$KeyGenerator");
        }
    }

    private RIPEMD128() {
    }
}
