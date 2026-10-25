package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA384Digest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p209macs.C5363OldHMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;

/* renamed from: org.bouncycastle.jcajce.provider.digest.SHA384 */
/* loaded from: classes2.dex */
public class C5651SHA384 {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA384$Digest */
    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SHA384Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.f21665digest = new SHA384Digest((SHA384Digest) this.f21665digest);
            return digest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA384$HashMac */
    public static class HashMac extends C5789BaseMac {
        public HashMac() {
            super(new C5360HMac(new SHA384Digest()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA384$KeyFactory */
    public static class KeyFactory extends BaseSecretKeyFactory {
        public KeyFactory() {
            super("HmacSHA384", null);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA384$KeyGenerator */
    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA384", 384, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA384$Mappings */
    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21684PREFIX = C5651SHA384.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21684PREFIX;
            sb.append(str);
            sb.append("$Digest");
            configurableProvider.addAlgorithm("MessageDigest.SHA-384", sb.toString());
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA384", "SHA-384");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + NISTObjectIdentifiers.id_sha384, "SHA-384");
            configurableProvider.addAlgorithm("Mac.OLDHMACSHA384", str + "$OldSHA384");
            configurableProvider.addAlgorithm("Mac.PBEWITHHMACSHA384", str + "$HashMac");
            addHMACAlgorithm(configurableProvider, "SHA384", str + "$HashMac", str + "$KeyGenerator");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.id_hmacWithSHA384;
            addHMACAlias(configurableProvider, "SHA384", aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm("SecretKeyFactory.HMACSHA384", str + "$KeyFactory");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier, "HMACSHA384");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA384$OldSHA384 */
    public static class OldSHA384 extends C5789BaseMac {
        public OldSHA384() {
            super(new C5363OldHMac(new SHA384Digest()));
        }
    }

    private C5651SHA384() {
    }
}
