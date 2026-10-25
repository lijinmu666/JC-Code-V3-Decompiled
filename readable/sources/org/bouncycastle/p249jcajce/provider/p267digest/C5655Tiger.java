package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.internal.p231asn1.p237iana.IANAObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p199digests.TigerDigest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.PBESecretKeyFactory;

/* renamed from: org.bouncycastle.jcajce.provider.digest.Tiger */
/* loaded from: classes2.dex */
public class C5655Tiger {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Tiger$Digest */
    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new TigerDigest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.f21665digest = new TigerDigest((TigerDigest) this.f21665digest);
            return digest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Tiger$HashMac */
    public static class HashMac extends C5789BaseMac {
        public HashMac() {
            super(new C5360HMac(new TigerDigest()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Tiger$KeyGenerator */
    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACTIGER", 192, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Tiger$Mappings */
    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21688PREFIX = C5655Tiger.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21688PREFIX;
            sb.append(str);
            sb.append("$Digest");
            configurableProvider.addAlgorithm("MessageDigest.TIGER", sb.toString());
            configurableProvider.addAlgorithm("MessageDigest.Tiger", str + "$Digest");
            addHMACAlgorithm(configurableProvider, "TIGER", str + "$HashMac", str + "$KeyGenerator");
            addHMACAlias(configurableProvider, "TIGER", IANAObjectIdentifiers.hmacTIGER);
            configurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHHMACTIGER", str + "$PBEWithMacKeyFactory");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Tiger$PBEWithHashMac */
    public static class PBEWithHashMac extends C5789BaseMac {
        public PBEWithHashMac() {
            super(new C5360HMac(new TigerDigest()), 2, 3, 192);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Tiger$PBEWithMacKeyFactory */
    public static class PBEWithMacKeyFactory extends PBESecretKeyFactory {
        public PBEWithMacKeyFactory() {
            super("PBEwithHmacTiger", null, false, 2, 3, 192, 0);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.Tiger$TigerHmac */
    public static class TigerHmac extends C5789BaseMac {
        public TigerHmac() {
            super(new C5360HMac(new TigerDigest()));
        }
    }

    private C5655Tiger() {
    }
}
