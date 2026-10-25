package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p199digests.KeccakDigest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;

/* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak */
/* loaded from: classes2.dex */
public class C5635Keccak {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$Digest224 */
    public static class Digest224 extends DigestKeccak {
        public Digest224() {
            super(InterfaceC5102BERTags.f17976FLAGS);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$Digest256 */
    public static class Digest256 extends DigestKeccak {
        public Digest256() {
            super(256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$Digest288 */
    public static class Digest288 extends DigestKeccak {
        public Digest288() {
            super(288);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$Digest384 */
    public static class Digest384 extends DigestKeccak {
        public Digest384() {
            super(384);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$Digest512 */
    public static class Digest512 extends DigestKeccak {
        public Digest512() {
            super(512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$DigestKeccak */
    public static class DigestKeccak extends BCMessageDigest implements Cloneable {
        public DigestKeccak(int i) {
            super(new KeccakDigest(i));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.f21665digest = new KeccakDigest((KeccakDigest) this.f21665digest);
            return bCMessageDigest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$HashMac224 */
    public static class HashMac224 extends C5789BaseMac {
        public HashMac224() {
            super(new C5360HMac(new KeccakDigest(InterfaceC5102BERTags.f17976FLAGS)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$HashMac256 */
    public static class HashMac256 extends C5789BaseMac {
        public HashMac256() {
            super(new C5360HMac(new KeccakDigest(256)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$HashMac288 */
    public static class HashMac288 extends C5789BaseMac {
        public HashMac288() {
            super(new C5360HMac(new KeccakDigest(288)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$HashMac384 */
    public static class HashMac384 extends C5789BaseMac {
        public HashMac384() {
            super(new C5360HMac(new KeccakDigest(384)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$HashMac512 */
    public static class HashMac512 extends C5789BaseMac {
        public HashMac512() {
            super(new C5360HMac(new KeccakDigest(512)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$KeyGenerator224 */
    public static class KeyGenerator224 extends BaseKeyGenerator {
        public KeyGenerator224() {
            super("HMACKECCAK224", InterfaceC5102BERTags.f17976FLAGS, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$KeyGenerator256 */
    public static class KeyGenerator256 extends BaseKeyGenerator {
        public KeyGenerator256() {
            super("HMACKECCAK256", 256, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$KeyGenerator288 */
    public static class KeyGenerator288 extends BaseKeyGenerator {
        public KeyGenerator288() {
            super("HMACKECCAK288", 288, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$KeyGenerator384 */
    public static class KeyGenerator384 extends BaseKeyGenerator {
        public KeyGenerator384() {
            super("HMACKECCAK384", 384, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$KeyGenerator512 */
    public static class KeyGenerator512 extends BaseKeyGenerator {
        public KeyGenerator512() {
            super("HMACKECCAK512", 512, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Keccak$Mappings */
    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21672PREFIX = C5635Keccak.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21672PREFIX;
            sb.append(str);
            sb.append("$Digest224");
            configurableProvider.addAlgorithm("MessageDigest.KECCAK-224", sb.toString());
            configurableProvider.addAlgorithm("MessageDigest.KECCAK-288", str + "$Digest288");
            configurableProvider.addAlgorithm("MessageDigest.KECCAK-256", str + "$Digest256");
            configurableProvider.addAlgorithm("MessageDigest.KECCAK-384", str + "$Digest384");
            configurableProvider.addAlgorithm("MessageDigest.KECCAK-512", str + "$Digest512");
            addHMACAlgorithm(configurableProvider, "KECCAK224", str + "$HashMac224", str + "$KeyGenerator224");
            addHMACAlgorithm(configurableProvider, "KECCAK256", str + "$HashMac256", str + "$KeyGenerator256");
            addHMACAlgorithm(configurableProvider, "KECCAK288", str + "$HashMac288", str + "$KeyGenerator288");
            addHMACAlgorithm(configurableProvider, "KECCAK384", str + "$HashMac384", str + "$KeyGenerator384");
            addHMACAlgorithm(configurableProvider, "KECCAK512", str + "$HashMac512", str + "$KeyGenerator512");
        }
    }

    private C5635Keccak() {
    }
}
