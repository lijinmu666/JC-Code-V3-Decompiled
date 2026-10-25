package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.internal.p231asn1.p237iana.IANAObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA1Digest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.PBESecretKeyFactory;

/* renamed from: org.bouncycastle.jcajce.provider.digest.SHA1 */
/* loaded from: classes2.dex */
public class C5647SHA1 {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA1$Digest */
    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SHA1Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.f21665digest = new SHA1Digest((SHA1Digest) this.f21665digest);
            return digest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA1$HashMac */
    public static class HashMac extends C5789BaseMac {
        public HashMac() {
            super(new C5360HMac(new SHA1Digest()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA1$KeyFactory */
    public static class KeyFactory extends BaseSecretKeyFactory {
        public KeyFactory() {
            super("HmacSHA1", null);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA1$KeyGenerator */
    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA1", 160, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA1$Mappings */
    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21680PREFIX = C5647SHA1.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21680PREFIX;
            sb.append(str);
            sb.append("$Digest");
            configurableProvider.addAlgorithm("MessageDigest.SHA-1", sb.toString());
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA1", "SHA-1");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA", "SHA-1");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Alg.Alias.MessageDigest.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = OIWObjectIdentifiers.f21282idSHA1;
            sb2.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(sb2.toString(), "SHA-1");
            addHMACAlgorithm(configurableProvider, "SHA1", str + "$HashMac", str + "$KeyGenerator");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.id_hmacWithSHA1;
            addHMACAlias(configurableProvider, "SHA1", aSN1ObjectIdentifier2);
            addHMACAlias(configurableProvider, "SHA1", IANAObjectIdentifiers.hmacSHA1);
            configurableProvider.addAlgorithm("Mac.PBEWITHHMACSHA", str + "$SHA1Mac");
            configurableProvider.addAlgorithm("Mac.PBEWITHHMACSHA1", str + "$SHA1Mac");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA", "PBEWITHHMACSHA1");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier, "PBEWITHHMACSHA1");
            configurableProvider.addAlgorithm("Alg.Alias.Mac." + aSN1ObjectIdentifier, "PBEWITHHMACSHA");
            configurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHHMACSHA1", str + "$PBEWithMacKeyFactory");
            configurableProvider.addAlgorithm("SecretKeyFactory.HMACSHA1", str + "$KeyFactory");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier2, "HMACSHA1");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA1$PBEWithMacKeyFactory */
    public static class PBEWithMacKeyFactory extends PBESecretKeyFactory {
        public PBEWithMacKeyFactory() {
            super("PBEwithHmacSHA1", null, false, 2, 1, 160, 0);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA1$SHA1Mac */
    public static class SHA1Mac extends C5789BaseMac {
        public SHA1Mac() {
            super(new C5360HMac(new SHA1Digest()));
        }
    }

    private C5647SHA1() {
    }
}
