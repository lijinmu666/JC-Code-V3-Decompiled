package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p199digests.SkeinDigest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p209macs.SkeinMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;

/* renamed from: org.bouncycastle.jcajce.provider.digest.Skein */
/* loaded from: classes2.dex */
public class C5654Skein {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$DigestSkein1024 */
    public static class DigestSkein1024 extends BCMessageDigest implements Cloneable {
        public DigestSkein1024(int i) {
            super(new SkeinDigest(1024, i));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.f21665digest = new SkeinDigest((SkeinDigest) this.f21665digest);
            return bCMessageDigest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$DigestSkein256 */
    public static class DigestSkein256 extends BCMessageDigest implements Cloneable {
        public DigestSkein256(int i) {
            super(new SkeinDigest(256, i));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.f21665digest = new SkeinDigest((SkeinDigest) this.f21665digest);
            return bCMessageDigest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$DigestSkein512 */
    public static class DigestSkein512 extends BCMessageDigest implements Cloneable {
        public DigestSkein512(int i) {
            super(new SkeinDigest(512, i));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.f21665digest = new SkeinDigest((SkeinDigest) this.f21665digest);
            return bCMessageDigest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$Digest_1024_1024 */
    public static class Digest_1024_1024 extends DigestSkein1024 {
        public Digest_1024_1024() {
            super(1024);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$Digest_1024_384 */
    public static class Digest_1024_384 extends DigestSkein1024 {
        public Digest_1024_384() {
            super(384);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$Digest_1024_512 */
    public static class Digest_1024_512 extends DigestSkein1024 {
        public Digest_1024_512() {
            super(512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$Digest_256_128 */
    public static class Digest_256_128 extends DigestSkein256 {
        public Digest_256_128() {
            super(128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$Digest_256_160 */
    public static class Digest_256_160 extends DigestSkein256 {
        public Digest_256_160() {
            super(160);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$Digest_256_224 */
    public static class Digest_256_224 extends DigestSkein256 {
        public Digest_256_224() {
            super(InterfaceC5102BERTags.f17976FLAGS);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$Digest_256_256 */
    public static class Digest_256_256 extends DigestSkein256 {
        public Digest_256_256() {
            super(256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$Digest_512_128 */
    public static class Digest_512_128 extends DigestSkein512 {
        public Digest_512_128() {
            super(128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$Digest_512_160 */
    public static class Digest_512_160 extends DigestSkein512 {
        public Digest_512_160() {
            super(160);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$Digest_512_224 */
    public static class Digest_512_224 extends DigestSkein512 {
        public Digest_512_224() {
            super(InterfaceC5102BERTags.f17976FLAGS);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$Digest_512_256 */
    public static class Digest_512_256 extends DigestSkein512 {
        public Digest_512_256() {
            super(256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$Digest_512_384 */
    public static class Digest_512_384 extends DigestSkein512 {
        public Digest_512_384() {
            super(384);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$Digest_512_512 */
    public static class Digest_512_512 extends DigestSkein512 {
        public Digest_512_512() {
            super(512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_1024_1024 */
    public static class HMacKeyGenerator_1024_1024 extends BaseKeyGenerator {
        public HMacKeyGenerator_1024_1024() {
            super("HMACSkein-1024-1024", 1024, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_1024_384 */
    public static class HMacKeyGenerator_1024_384 extends BaseKeyGenerator {
        public HMacKeyGenerator_1024_384() {
            super("HMACSkein-1024-384", 384, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_1024_512 */
    public static class HMacKeyGenerator_1024_512 extends BaseKeyGenerator {
        public HMacKeyGenerator_1024_512() {
            super("HMACSkein-1024-512", 512, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_256_128 */
    public static class HMacKeyGenerator_256_128 extends BaseKeyGenerator {
        public HMacKeyGenerator_256_128() {
            super("HMACSkein-256-128", 128, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_256_160 */
    public static class HMacKeyGenerator_256_160 extends BaseKeyGenerator {
        public HMacKeyGenerator_256_160() {
            super("HMACSkein-256-160", 160, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_256_224 */
    public static class HMacKeyGenerator_256_224 extends BaseKeyGenerator {
        public HMacKeyGenerator_256_224() {
            super("HMACSkein-256-224", InterfaceC5102BERTags.f17976FLAGS, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_256_256 */
    public static class HMacKeyGenerator_256_256 extends BaseKeyGenerator {
        public HMacKeyGenerator_256_256() {
            super("HMACSkein-256-256", 256, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_512_128 */
    public static class HMacKeyGenerator_512_128 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_128() {
            super("HMACSkein-512-128", 128, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_512_160 */
    public static class HMacKeyGenerator_512_160 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_160() {
            super("HMACSkein-512-160", 160, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_512_224 */
    public static class HMacKeyGenerator_512_224 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_224() {
            super("HMACSkein-512-224", InterfaceC5102BERTags.f17976FLAGS, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_512_256 */
    public static class HMacKeyGenerator_512_256 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_256() {
            super("HMACSkein-512-256", 256, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_512_384 */
    public static class HMacKeyGenerator_512_384 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_384() {
            super("HMACSkein-512-384", 384, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_512_512 */
    public static class HMacKeyGenerator_512_512 extends BaseKeyGenerator {
        public HMacKeyGenerator_512_512() {
            super("HMACSkein-512-512", 512, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HashMac_1024_1024 */
    public static class HashMac_1024_1024 extends C5789BaseMac {
        public HashMac_1024_1024() {
            super(new C5360HMac(new SkeinDigest(1024, 1024)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HashMac_1024_384 */
    public static class HashMac_1024_384 extends C5789BaseMac {
        public HashMac_1024_384() {
            super(new C5360HMac(new SkeinDigest(1024, 384)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HashMac_1024_512 */
    public static class HashMac_1024_512 extends C5789BaseMac {
        public HashMac_1024_512() {
            super(new C5360HMac(new SkeinDigest(1024, 512)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HashMac_256_128 */
    public static class HashMac_256_128 extends C5789BaseMac {
        public HashMac_256_128() {
            super(new C5360HMac(new SkeinDigest(256, 128)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HashMac_256_160 */
    public static class HashMac_256_160 extends C5789BaseMac {
        public HashMac_256_160() {
            super(new C5360HMac(new SkeinDigest(256, 160)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HashMac_256_224 */
    public static class HashMac_256_224 extends C5789BaseMac {
        public HashMac_256_224() {
            super(new C5360HMac(new SkeinDigest(256, InterfaceC5102BERTags.f17976FLAGS)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HashMac_256_256 */
    public static class HashMac_256_256 extends C5789BaseMac {
        public HashMac_256_256() {
            super(new C5360HMac(new SkeinDigest(256, 256)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HashMac_512_128 */
    public static class HashMac_512_128 extends C5789BaseMac {
        public HashMac_512_128() {
            super(new C5360HMac(new SkeinDigest(512, 128)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HashMac_512_160 */
    public static class HashMac_512_160 extends C5789BaseMac {
        public HashMac_512_160() {
            super(new C5360HMac(new SkeinDigest(512, 160)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HashMac_512_224 */
    public static class HashMac_512_224 extends C5789BaseMac {
        public HashMac_512_224() {
            super(new C5360HMac(new SkeinDigest(512, InterfaceC5102BERTags.f17976FLAGS)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HashMac_512_256 */
    public static class HashMac_512_256 extends C5789BaseMac {
        public HashMac_512_256() {
            super(new C5360HMac(new SkeinDigest(512, 256)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HashMac_512_384 */
    public static class HashMac_512_384 extends C5789BaseMac {
        public HashMac_512_384() {
            super(new C5360HMac(new SkeinDigest(512, 384)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$HashMac_512_512 */
    public static class HashMac_512_512 extends C5789BaseMac {
        public HashMac_512_512() {
            super(new C5360HMac(new SkeinDigest(512, 512)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$Mappings */
    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21687PREFIX = C5654Skein.class.getName();

        private void addSkeinMacAlgorithm(ConfigurableProvider configurableProvider, int i, int i2) {
            String str = "Skein-MAC-" + i + "-" + i2;
            StringBuilder sb = new StringBuilder();
            String str2 = f21687PREFIX;
            sb.append(str2);
            sb.append("$SkeinMac_");
            sb.append(i);
            sb.append("_");
            sb.append(i2);
            configurableProvider.addAlgorithm("Mac." + str, sb.toString());
            configurableProvider.addAlgorithm("Alg.Alias.Mac.Skein-MAC" + i + "/" + i2, str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("KeyGenerator.");
            sb2.append(str);
            configurableProvider.addAlgorithm(sb2.toString(), str2 + "$SkeinMacKeyGenerator_" + i + "_" + i2);
            configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.Skein-MAC" + i + "/" + i2, str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21687PREFIX;
            sb.append(str);
            sb.append("$Digest_256_128");
            configurableProvider.addAlgorithm("MessageDigest.Skein-256-128", sb.toString());
            configurableProvider.addAlgorithm("MessageDigest.Skein-256-160", str + "$Digest_256_160");
            configurableProvider.addAlgorithm("MessageDigest.Skein-256-224", str + "$Digest_256_224");
            configurableProvider.addAlgorithm("MessageDigest.Skein-256-256", str + "$Digest_256_256");
            configurableProvider.addAlgorithm("MessageDigest.Skein-512-128", str + "$Digest_512_128");
            configurableProvider.addAlgorithm("MessageDigest.Skein-512-160", str + "$Digest_512_160");
            configurableProvider.addAlgorithm("MessageDigest.Skein-512-224", str + "$Digest_512_224");
            configurableProvider.addAlgorithm("MessageDigest.Skein-512-256", str + "$Digest_512_256");
            configurableProvider.addAlgorithm("MessageDigest.Skein-512-384", str + "$Digest_512_384");
            configurableProvider.addAlgorithm("MessageDigest.Skein-512-512", str + "$Digest_512_512");
            configurableProvider.addAlgorithm("MessageDigest.Skein-1024-384", str + "$Digest_1024_384");
            configurableProvider.addAlgorithm("MessageDigest.Skein-1024-512", str + "$Digest_1024_512");
            configurableProvider.addAlgorithm("MessageDigest.Skein-1024-1024", str + "$Digest_1024_1024");
            addHMACAlgorithm(configurableProvider, "Skein-256-128", str + "$HashMac_256_128", str + "$HMacKeyGenerator_256_128");
            addHMACAlgorithm(configurableProvider, "Skein-256-160", str + "$HashMac_256_160", str + "$HMacKeyGenerator_256_160");
            addHMACAlgorithm(configurableProvider, "Skein-256-224", str + "$HashMac_256_224", str + "$HMacKeyGenerator_256_224");
            addHMACAlgorithm(configurableProvider, "Skein-256-256", str + "$HashMac_256_256", str + "$HMacKeyGenerator_256_256");
            addHMACAlgorithm(configurableProvider, "Skein-512-128", str + "$HashMac_512_128", str + "$HMacKeyGenerator_512_128");
            addHMACAlgorithm(configurableProvider, "Skein-512-160", str + "$HashMac_512_160", str + "$HMacKeyGenerator_512_160");
            addHMACAlgorithm(configurableProvider, "Skein-512-224", str + "$HashMac_512_224", str + "$HMacKeyGenerator_512_224");
            addHMACAlgorithm(configurableProvider, "Skein-512-256", str + "$HashMac_512_256", str + "$HMacKeyGenerator_512_256");
            addHMACAlgorithm(configurableProvider, "Skein-512-384", str + "$HashMac_512_384", str + "$HMacKeyGenerator_512_384");
            addHMACAlgorithm(configurableProvider, "Skein-512-512", str + "$HashMac_512_512", str + "$HMacKeyGenerator_512_512");
            addHMACAlgorithm(configurableProvider, "Skein-1024-384", str + "$HashMac_1024_384", str + "$HMacKeyGenerator_1024_384");
            addHMACAlgorithm(configurableProvider, "Skein-1024-512", str + "$HashMac_1024_512", str + "$HMacKeyGenerator_1024_512");
            addHMACAlgorithm(configurableProvider, "Skein-1024-1024", str + "$HashMac_1024_1024", str + "$HMacKeyGenerator_1024_1024");
            addSkeinMacAlgorithm(configurableProvider, 256, 128);
            addSkeinMacAlgorithm(configurableProvider, 256, 160);
            addSkeinMacAlgorithm(configurableProvider, 256, InterfaceC5102BERTags.f17976FLAGS);
            addSkeinMacAlgorithm(configurableProvider, 256, 256);
            addSkeinMacAlgorithm(configurableProvider, 512, 128);
            addSkeinMacAlgorithm(configurableProvider, 512, 160);
            addSkeinMacAlgorithm(configurableProvider, 512, InterfaceC5102BERTags.f17976FLAGS);
            addSkeinMacAlgorithm(configurableProvider, 512, 256);
            addSkeinMacAlgorithm(configurableProvider, 512, 384);
            addSkeinMacAlgorithm(configurableProvider, 512, 512);
            addSkeinMacAlgorithm(configurableProvider, 1024, 384);
            addSkeinMacAlgorithm(configurableProvider, 1024, 512);
            addSkeinMacAlgorithm(configurableProvider, 1024, 1024);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_1024_1024 */
    public static class SkeinMacKeyGenerator_1024_1024 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_1024_1024() {
            super("Skein-MAC-1024-1024", 1024, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_1024_384 */
    public static class SkeinMacKeyGenerator_1024_384 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_1024_384() {
            super("Skein-MAC-1024-384", 384, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_1024_512 */
    public static class SkeinMacKeyGenerator_1024_512 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_1024_512() {
            super("Skein-MAC-1024-512", 512, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_256_128 */
    public static class SkeinMacKeyGenerator_256_128 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_256_128() {
            super("Skein-MAC-256-128", 128, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_256_160 */
    public static class SkeinMacKeyGenerator_256_160 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_256_160() {
            super("Skein-MAC-256-160", 160, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_256_224 */
    public static class SkeinMacKeyGenerator_256_224 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_256_224() {
            super("Skein-MAC-256-224", InterfaceC5102BERTags.f17976FLAGS, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_256_256 */
    public static class SkeinMacKeyGenerator_256_256 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_256_256() {
            super("Skein-MAC-256-256", 256, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_512_128 */
    public static class SkeinMacKeyGenerator_512_128 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_128() {
            super("Skein-MAC-512-128", 128, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_512_160 */
    public static class SkeinMacKeyGenerator_512_160 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_160() {
            super("Skein-MAC-512-160", 160, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_512_224 */
    public static class SkeinMacKeyGenerator_512_224 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_224() {
            super("Skein-MAC-512-224", InterfaceC5102BERTags.f17976FLAGS, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_512_256 */
    public static class SkeinMacKeyGenerator_512_256 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_256() {
            super("Skein-MAC-512-256", 256, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_512_384 */
    public static class SkeinMacKeyGenerator_512_384 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_384() {
            super("Skein-MAC-512-384", 384, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_512_512 */
    public static class SkeinMacKeyGenerator_512_512 extends BaseKeyGenerator {
        public SkeinMacKeyGenerator_512_512() {
            super("Skein-MAC-512-512", 512, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_1024_1024 */
    public static class SkeinMac_1024_1024 extends C5789BaseMac {
        public SkeinMac_1024_1024() {
            super(new SkeinMac(1024, 1024));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_1024_384 */
    public static class SkeinMac_1024_384 extends C5789BaseMac {
        public SkeinMac_1024_384() {
            super(new SkeinMac(1024, 384));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_1024_512 */
    public static class SkeinMac_1024_512 extends C5789BaseMac {
        public SkeinMac_1024_512() {
            super(new SkeinMac(1024, 512));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_256_128 */
    public static class SkeinMac_256_128 extends C5789BaseMac {
        public SkeinMac_256_128() {
            super(new SkeinMac(256, 128));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_256_160 */
    public static class SkeinMac_256_160 extends C5789BaseMac {
        public SkeinMac_256_160() {
            super(new SkeinMac(256, 160));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_256_224 */
    public static class SkeinMac_256_224 extends C5789BaseMac {
        public SkeinMac_256_224() {
            super(new SkeinMac(256, InterfaceC5102BERTags.f17976FLAGS));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_256_256 */
    public static class SkeinMac_256_256 extends C5789BaseMac {
        public SkeinMac_256_256() {
            super(new SkeinMac(256, 256));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_512_128 */
    public static class SkeinMac_512_128 extends C5789BaseMac {
        public SkeinMac_512_128() {
            super(new SkeinMac(512, 128));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_512_160 */
    public static class SkeinMac_512_160 extends C5789BaseMac {
        public SkeinMac_512_160() {
            super(new SkeinMac(512, 160));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_512_224 */
    public static class SkeinMac_512_224 extends C5789BaseMac {
        public SkeinMac_512_224() {
            super(new SkeinMac(512, InterfaceC5102BERTags.f17976FLAGS));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_512_256 */
    public static class SkeinMac_512_256 extends C5789BaseMac {
        public SkeinMac_512_256() {
            super(new SkeinMac(512, 256));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_512_384 */
    public static class SkeinMac_512_384 extends C5789BaseMac {
        public SkeinMac_512_384() {
            super(new SkeinMac(512, 384));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_512_512 */
    public static class SkeinMac_512_512 extends C5789BaseMac {
        public SkeinMac_512_512() {
            super(new SkeinMac(512, 512));
        }
    }

    private C5654Skein() {
    }
}
