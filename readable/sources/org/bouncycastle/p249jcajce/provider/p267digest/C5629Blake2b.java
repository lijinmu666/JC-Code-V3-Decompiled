package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.internal.p231asn1.p242misc.MiscObjectIdentifiers;
import org.bouncycastle.p194crypto.p199digests.Blake2bDigest;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;

/* renamed from: org.bouncycastle.jcajce.provider.digest.Blake2b */
/* loaded from: classes2.dex */
public class C5629Blake2b {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Blake2b$Blake2b160 */
    public static class Blake2b160 extends BCMessageDigest implements Cloneable {
        public Blake2b160() {
            super(new Blake2bDigest(160));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Blake2b160 blake2b160 = (Blake2b160) super.clone();
            blake2b160.f21665digest = new Blake2bDigest((Blake2bDigest) this.f21665digest);
            return blake2b160;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Blake2b$Blake2b256 */
    public static class Blake2b256 extends BCMessageDigest implements Cloneable {
        public Blake2b256() {
            super(new Blake2bDigest(256));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Blake2b256 blake2b256 = (Blake2b256) super.clone();
            blake2b256.f21665digest = new Blake2bDigest((Blake2bDigest) this.f21665digest);
            return blake2b256;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Blake2b$Blake2b384 */
    public static class Blake2b384 extends BCMessageDigest implements Cloneable {
        public Blake2b384() {
            super(new Blake2bDigest(384));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Blake2b384 blake2b384 = (Blake2b384) super.clone();
            blake2b384.f21665digest = new Blake2bDigest((Blake2bDigest) this.f21665digest);
            return blake2b384;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Blake2b$Blake2b512 */
    public static class Blake2b512 extends BCMessageDigest implements Cloneable {
        public Blake2b512() {
            super(new Blake2bDigest(512));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Blake2b512 blake2b512 = (Blake2b512) super.clone();
            blake2b512.f21665digest = new Blake2bDigest((Blake2bDigest) this.f21665digest);
            return blake2b512;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Blake2b$Mappings */
    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21666PREFIX = C5629Blake2b.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21666PREFIX;
            sb.append(str);
            sb.append("$Blake2b512");
            configurableProvider.addAlgorithm("MessageDigest.BLAKE2B-512", sb.toString());
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + MiscObjectIdentifiers.id_blake2b512, "BLAKE2B-512");
            configurableProvider.addAlgorithm("MessageDigest.BLAKE2B-384", str + "$Blake2b384");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + MiscObjectIdentifiers.id_blake2b384, "BLAKE2B-384");
            configurableProvider.addAlgorithm("MessageDigest.BLAKE2B-256", str + "$Blake2b256");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + MiscObjectIdentifiers.id_blake2b256, "BLAKE2B-256");
            configurableProvider.addAlgorithm("MessageDigest.BLAKE2B-160", str + "$Blake2b160");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + MiscObjectIdentifiers.id_blake2b160, "BLAKE2B-160");
        }
    }

    private C5629Blake2b() {
    }
}
