package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA224Digest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;

/* renamed from: org.bouncycastle.jcajce.provider.digest.SHA224 */
/* loaded from: classes2.dex */
public class C5648SHA224 {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA224$Digest */
    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SHA224Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.f21665digest = new SHA224Digest((SHA224Digest) this.f21665digest);
            return digest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA224$HashMac */
    public static class HashMac extends C5789BaseMac {
        public HashMac() {
            super(new C5360HMac(new SHA224Digest()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA224$KeyFactory */
    public static class KeyFactory extends BaseSecretKeyFactory {
        public KeyFactory() {
            super("HmacSHA224", null);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA224$KeyGenerator */
    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA224", InterfaceC5102BERTags.f17976FLAGS, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA224$Mappings */
    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21681PREFIX = C5648SHA224.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21681PREFIX;
            sb.append(str);
            sb.append("$Digest");
            configurableProvider.addAlgorithm("MessageDigest.SHA-224", sb.toString());
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA224", "SHA-224");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + NISTObjectIdentifiers.id_sha224, "SHA-224");
            configurableProvider.addAlgorithm("Mac.PBEWITHHMACSHA224", str + "$HashMac");
            addHMACAlgorithm(configurableProvider, "SHA224", str + "$HashMac", str + "$KeyGenerator");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.id_hmacWithSHA224;
            addHMACAlias(configurableProvider, "SHA224", aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm("SecretKeyFactory.HMACSHA224", str + "$KeyFactory");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier, "HMACSHA224");
        }
    }

    private C5648SHA224() {
    }
}
