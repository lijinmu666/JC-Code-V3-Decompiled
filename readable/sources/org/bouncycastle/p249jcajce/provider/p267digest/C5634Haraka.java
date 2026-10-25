package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.p194crypto.p199digests.Haraka256Digest;
import org.bouncycastle.p194crypto.p199digests.Haraka512Digest;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;

/* renamed from: org.bouncycastle.jcajce.provider.digest.Haraka */
/* loaded from: classes2.dex */
public class C5634Haraka {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Haraka$Digest256 */
    public static class Digest256 extends BCMessageDigest implements Cloneable {
        public Digest256() {
            super(new Haraka256Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Digest256 digest256 = (Digest256) super.clone();
            digest256.f21665digest = new Haraka256Digest((Haraka256Digest) this.f21665digest);
            return digest256;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Haraka$Digest512 */
    public static class Digest512 extends BCMessageDigest implements Cloneable {
        public Digest512() {
            super(new Haraka512Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Digest512 digest512 = (Digest512) super.clone();
            digest512.f21665digest = new Haraka512Digest((Haraka512Digest) this.f21665digest);
            return digest512;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Haraka$Mappings */
    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21671PREFIX = C5634Haraka.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21671PREFIX;
            sb.append(str);
            sb.append("$Digest256");
            configurableProvider.addAlgorithm("MessageDigest.HARAKA-256", sb.toString());
            configurableProvider.addAlgorithm("MessageDigest.HARAKA-512", str + "$Digest512");
        }
    }

    private C5634Haraka() {
    }
}
