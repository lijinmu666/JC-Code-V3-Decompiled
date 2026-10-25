package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p199digests.RIPEMD256Digest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;

/* loaded from: classes2.dex */
public class RIPEMD256 {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.RIPEMD256$Digest */
    public static class C5643Digest extends BCMessageDigest implements Cloneable {
        public C5643Digest() {
            super(new RIPEMD256Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            C5643Digest c5643Digest = (C5643Digest) super.clone();
            c5643Digest.f21665digest = new RIPEMD256Digest((RIPEMD256Digest) this.f21665digest);
            return c5643Digest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.RIPEMD256$HashMac */
    public static class C5644HashMac extends C5789BaseMac {
        public C5644HashMac() {
            super(new C5360HMac(new RIPEMD256Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACRIPEMD256", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21678PREFIX = RIPEMD256.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21678PREFIX;
            sb.append(str);
            sb.append("$Digest");
            configurableProvider.addAlgorithm("MessageDigest.RIPEMD256", sb.toString());
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + TeleTrusTObjectIdentifiers.ripemd256, "RIPEMD256");
            addHMACAlgorithm(configurableProvider, "RIPEMD256", str + "$HashMac", str + "$KeyGenerator");
        }
    }

    private RIPEMD256() {
    }
}
