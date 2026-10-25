package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p199digests.RIPEMD320Digest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;

/* loaded from: classes2.dex */
public class RIPEMD320 {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.RIPEMD320$Digest */
    public static class C5645Digest extends BCMessageDigest implements Cloneable {
        public C5645Digest() {
            super(new RIPEMD320Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            C5645Digest c5645Digest = (C5645Digest) super.clone();
            c5645Digest.f21665digest = new RIPEMD320Digest((RIPEMD320Digest) this.f21665digest);
            return c5645Digest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.RIPEMD320$HashMac */
    public static class C5646HashMac extends C5789BaseMac {
        public C5646HashMac() {
            super(new C5360HMac(new RIPEMD320Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACRIPEMD320", 320, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21679PREFIX = RIPEMD320.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21679PREFIX;
            sb.append(str);
            sb.append("$Digest");
            configurableProvider.addAlgorithm("MessageDigest.RIPEMD320", sb.toString());
            addHMACAlgorithm(configurableProvider, "RIPEMD320", str + "$HashMac", str + "$KeyGenerator");
        }
    }

    private RIPEMD320() {
    }
}
