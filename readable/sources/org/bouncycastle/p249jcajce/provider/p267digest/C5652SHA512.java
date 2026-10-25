package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512tDigest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p209macs.C5363OldHMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.SPHINCSKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;

/* renamed from: org.bouncycastle.jcajce.provider.digest.SHA512 */
/* loaded from: classes2.dex */
public class C5652SHA512 {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA512$Digest */
    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SHA512Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.f21665digest = new SHA512Digest((SHA512Digest) this.f21665digest);
            return digest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA512$DigestT */
    public static class DigestT extends BCMessageDigest implements Cloneable {
        public DigestT(int i) {
            super(new SHA512tDigest(i));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            DigestT digestT = (DigestT) super.clone();
            digestT.f21665digest = new SHA512tDigest((SHA512tDigest) this.f21665digest);
            return digestT;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA512$DigestT224 */
    public static class DigestT224 extends DigestT {
        public DigestT224() {
            super(InterfaceC5102BERTags.f17976FLAGS);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA512$DigestT256 */
    public static class DigestT256 extends DigestT {
        public DigestT256() {
            super(256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA512$HashMac */
    public static class HashMac extends C5789BaseMac {
        public HashMac() {
            super(new C5360HMac(new SHA512Digest()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA512$HashMacT224 */
    public static class HashMacT224 extends C5789BaseMac {
        public HashMacT224() {
            super(new C5360HMac(new SHA512tDigest(InterfaceC5102BERTags.f17976FLAGS)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA512$HashMacT256 */
    public static class HashMacT256 extends C5789BaseMac {
        public HashMacT256() {
            super(new C5360HMac(new SHA512tDigest(256)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA512$KeyFactory */
    public static class KeyFactory extends BaseSecretKeyFactory {
        public KeyFactory() {
            super("HmacSHA512", null);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA512$KeyFactory224 */
    public static class KeyFactory224 extends BaseSecretKeyFactory {
        public KeyFactory224() {
            super("HmacSHA512/224", null);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA512$KeyFactory256 */
    public static class KeyFactory256 extends BaseSecretKeyFactory {
        public KeyFactory256() {
            super("HmacSHA512/256", null);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA512$KeyGenerator */
    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA512", 512, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA512$KeyGeneratorT224 */
    public static class KeyGeneratorT224 extends BaseKeyGenerator {
        public KeyGeneratorT224() {
            super("HMACSHA512/224", InterfaceC5102BERTags.f17976FLAGS, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA512$KeyGeneratorT256 */
    public static class KeyGeneratorT256 extends BaseKeyGenerator {
        public KeyGeneratorT256() {
            super("HMACSHA512/256", 256, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA512$Mappings */
    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21685PREFIX = C5652SHA512.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21685PREFIX;
            sb.append(str);
            sb.append("$Digest");
            configurableProvider.addAlgorithm("MessageDigest.SHA-512", sb.toString());
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA512", XMSSKeyParameters.f23622SHA_512);
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + NISTObjectIdentifiers.id_sha512, XMSSKeyParameters.f23622SHA_512);
            configurableProvider.addAlgorithm("MessageDigest.SHA-512/224", str + "$DigestT224");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA512/224", "SHA-512/224");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA512224", "SHA-512/224");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA-512(224)", "SHA-512/224");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA512(224)", "SHA-512/224");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + NISTObjectIdentifiers.id_sha512_224, "SHA-512/224");
            configurableProvider.addAlgorithm("MessageDigest.SHA-512/256", str + "$DigestT256");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA512/256", SPHINCSKeyParameters.SHA512_256);
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA512256", SPHINCSKeyParameters.SHA512_256);
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA-512(256)", SPHINCSKeyParameters.SHA512_256);
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA512(256)", SPHINCSKeyParameters.SHA512_256);
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest." + NISTObjectIdentifiers.id_sha512_256, SPHINCSKeyParameters.SHA512_256);
            configurableProvider.addAlgorithm("Mac.OLDHMACSHA512", str + "$OldSHA512");
            configurableProvider.addAlgorithm("Mac.PBEWITHHMACSHA512", str + "$HashMac");
            addHMACAlgorithm(configurableProvider, "SHA512", str + "$HashMac", str + "$KeyGenerator");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.id_hmacWithSHA512;
            addHMACAlias(configurableProvider, "SHA512", aSN1ObjectIdentifier);
            addHMACAlgorithm(configurableProvider, "SHA512/224", str + "$HashMacT224", str + "$KeyGeneratorT224");
            addHMACAlgorithm(configurableProvider, "SHA512/256", str + "$HashMacT256", str + "$KeyGeneratorT256");
            configurableProvider.addAlgorithm("SecretKeyFactory.HMACSHA512", str + "$KeyFactory");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier, "HMACSHA512");
            configurableProvider.addAlgorithm("SecretKeyFactory.HMACSHA512/224", str + "$KeyFactory224");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.HMACSHA512(224)", "HMACSHA512/224");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + PKCSObjectIdentifiers.id_hmacWithSHA512_224, "HMACSHA512/224");
            configurableProvider.addAlgorithm("SecretKeyFactory.HMACSHA512/256", str + "$KeyFactory256");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.HMACSHA512(256)", "HMACSHA512/256");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + PKCSObjectIdentifiers.id_hmacWithSHA512_256, "HMACSHA512/256");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA512$OldSHA512 */
    public static class OldSHA512 extends C5789BaseMac {
        public OldSHA512() {
            super(new C5363OldHMac(new SHA512Digest()));
        }
    }

    private C5652SHA512() {
    }
}
