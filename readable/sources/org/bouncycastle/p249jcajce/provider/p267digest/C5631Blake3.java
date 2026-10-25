package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.internal.p231asn1.p242misc.MiscObjectIdentifiers;
import org.bouncycastle.p194crypto.p199digests.Blake3Digest;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;

/* renamed from: org.bouncycastle.jcajce.provider.digest.Blake3 */
/* loaded from: classes2.dex */
public class C5631Blake3 {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Blake3$Blake3_256 */
    public static class Blake3_256 extends BCMessageDigest implements Cloneable {
        public Blake3_256() {
            super(new Blake3Digest(256));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Blake3_256 blake3_256 = (Blake3_256) super.clone();
            blake3_256.f21665digest = new Blake3Digest((Blake3Digest) this.f21665digest);
            return blake3_256;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Blake3$Mappings */
    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21668PREFIX = C5631Blake3.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("MessageDigest.BLAKE3-256", f21668PREFIX + "$Blake3_256");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + MiscObjectIdentifiers.blake3_256, "BLAKE3-256");
        }
    }

    private C5631Blake3() {
    }
}
