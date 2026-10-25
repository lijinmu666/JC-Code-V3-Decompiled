package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.internal.p231asn1.p242misc.MiscObjectIdentifiers;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p194crypto.p199digests.Blake2sDigest;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;

/* renamed from: org.bouncycastle.jcajce.provider.digest.Blake2s */
/* loaded from: classes2.dex */
public class C5630Blake2s {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Blake2s$Blake2s128 */
    public static class Blake2s128 extends BCMessageDigest implements Cloneable {
        public Blake2s128() {
            super(new Blake2sDigest(128));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Blake2s128 blake2s128 = (Blake2s128) super.clone();
            blake2s128.f21665digest = new Blake2sDigest((Blake2sDigest) this.f21665digest);
            return blake2s128;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Blake2s$Blake2s160 */
    public static class Blake2s160 extends BCMessageDigest implements Cloneable {
        public Blake2s160() {
            super(new Blake2sDigest(160));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Blake2s160 blake2s160 = (Blake2s160) super.clone();
            blake2s160.f21665digest = new Blake2sDigest((Blake2sDigest) this.f21665digest);
            return blake2s160;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Blake2s$Blake2s224 */
    public static class Blake2s224 extends BCMessageDigest implements Cloneable {
        public Blake2s224() {
            super(new Blake2sDigest(InterfaceC5102BERTags.f17976FLAGS));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Blake2s224 blake2s224 = (Blake2s224) super.clone();
            blake2s224.f21665digest = new Blake2sDigest((Blake2sDigest) this.f21665digest);
            return blake2s224;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Blake2s$Blake2s256 */
    public static class Blake2s256 extends BCMessageDigest implements Cloneable {
        public Blake2s256() {
            super(new Blake2sDigest(256));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Blake2s256 blake2s256 = (Blake2s256) super.clone();
            blake2s256.f21665digest = new Blake2sDigest((Blake2sDigest) this.f21665digest);
            return blake2s256;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Blake2s$Mappings */
    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21667PREFIX = C5630Blake2s.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21667PREFIX;
            sb.append(str);
            sb.append("$Blake2s256");
            configurableProvider.addAlgorithm("MessageDigest.BLAKE2S-256", sb.toString());
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + MiscObjectIdentifiers.id_blake2s256, "BLAKE2S-256");
            configurableProvider.addAlgorithm("MessageDigest.BLAKE2S-224", str + "$Blake2s224");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + MiscObjectIdentifiers.id_blake2s224, "BLAKE2S-224");
            configurableProvider.addAlgorithm("MessageDigest.BLAKE2S-160", str + "$Blake2s160");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + MiscObjectIdentifiers.id_blake2s160, "BLAKE2S-160");
            configurableProvider.addAlgorithm("MessageDigest.BLAKE2S-128", str + "$Blake2s128");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + MiscObjectIdentifiers.id_blake2s128, "BLAKE2S-128");
        }
    }

    private C5630Blake2s() {
    }
}
