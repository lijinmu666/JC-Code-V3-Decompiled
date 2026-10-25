package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p199digests.ParallelHash;
import org.bouncycastle.p194crypto.p199digests.SHA3Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p199digests.TupleHash;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p209macs.C5362KMAC;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;

/* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3 */
/* loaded from: classes2.dex */
public class C5650SHA3 {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$Digest224 */
    public static class Digest224 extends DigestSHA3 {
        public Digest224() {
            super(InterfaceC5102BERTags.f17976FLAGS);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$Digest256 */
    public static class Digest256 extends DigestSHA3 {
        public Digest256() {
            super(256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$Digest384 */
    public static class Digest384 extends DigestSHA3 {
        public Digest384() {
            super(384);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$Digest512 */
    public static class Digest512 extends DigestSHA3 {
        public Digest512() {
            super(512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$DigestParallelHash */
    public static class DigestParallelHash extends BCMessageDigest implements Cloneable {
        public DigestParallelHash(int i, int i2) {
            super(new ParallelHash(i, null, 128, i2));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.f21665digest = new ParallelHash((ParallelHash) this.f21665digest);
            return bCMessageDigest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$DigestParallelHash128_256 */
    public static class DigestParallelHash128_256 extends DigestParallelHash {
        public DigestParallelHash128_256() {
            super(128, 256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$DigestParallelHash256_512 */
    public static class DigestParallelHash256_512 extends DigestParallelHash {
        public DigestParallelHash256_512() {
            super(256, 512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$DigestSHA3 */
    public static class DigestSHA3 extends BCMessageDigest implements Cloneable {
        public DigestSHA3(int i) {
            super(new SHA3Digest(i));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.f21665digest = new SHA3Digest((SHA3Digest) this.f21665digest);
            return bCMessageDigest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$DigestSHAKE */
    public static class DigestSHAKE extends BCMessageDigest implements Cloneable {
        public DigestSHAKE(int i, int i2) {
            super(new SHAKEDigest(i));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.f21665digest = new SHAKEDigest((SHAKEDigest) this.f21665digest);
            return bCMessageDigest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$DigestShake128_256 */
    public static class DigestShake128_256 extends DigestSHAKE {
        public DigestShake128_256() {
            super(128, 256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$DigestShake256_512 */
    public static class DigestShake256_512 extends DigestSHAKE {
        public DigestShake256_512() {
            super(256, 512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$DigestTupleHash */
    public static class DigestTupleHash extends BCMessageDigest implements Cloneable {
        public DigestTupleHash(int i, int i2) {
            super(new TupleHash(i, null, i2));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.f21665digest = new TupleHash((TupleHash) this.f21665digest);
            return bCMessageDigest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$DigestTupleHash128_256 */
    public static class DigestTupleHash128_256 extends DigestTupleHash {
        public DigestTupleHash128_256() {
            super(128, 256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$DigestTupleHash256_512 */
    public static class DigestTupleHash256_512 extends DigestTupleHash {
        public DigestTupleHash256_512() {
            super(256, 512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$HashMac224 */
    public static class HashMac224 extends HashMacSHA3 {
        public HashMac224() {
            super(InterfaceC5102BERTags.f17976FLAGS);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$HashMac256 */
    public static class HashMac256 extends HashMacSHA3 {
        public HashMac256() {
            super(256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$HashMac384 */
    public static class HashMac384 extends HashMacSHA3 {
        public HashMac384() {
            super(384);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$HashMac512 */
    public static class HashMac512 extends HashMacSHA3 {
        public HashMac512() {
            super(512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$HashMacSHA3 */
    public static class HashMacSHA3 extends C5789BaseMac {
        public HashMacSHA3(int i) {
            super(new C5360HMac(new SHA3Digest(i)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$KMac128 */
    public static class KMac128 extends C5789BaseMac {
        public KMac128() {
            super(new C5362KMAC(128, new byte[0]));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$KMac256 */
    public static class KMac256 extends C5789BaseMac {
        public KMac256() {
            super(new C5362KMAC(256, new byte[0]));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$KeyFactory224 */
    public static class KeyFactory224 extends KeyFactorySHA3 {
        public KeyFactory224() {
            super(InterfaceC5102BERTags.f17976FLAGS, NISTObjectIdentifiers.id_hmacWithSHA3_224);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$KeyFactory256 */
    public static class KeyFactory256 extends KeyFactorySHA3 {
        public KeyFactory256() {
            super(256, NISTObjectIdentifiers.id_hmacWithSHA3_256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$KeyFactory384 */
    public static class KeyFactory384 extends KeyFactorySHA3 {
        public KeyFactory384() {
            super(384, NISTObjectIdentifiers.id_hmacWithSHA3_384);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$KeyFactory512 */
    public static class KeyFactory512 extends KeyFactorySHA3 {
        public KeyFactory512() {
            super(512, NISTObjectIdentifiers.id_hmacWithSHA3_512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$KeyFactoryKMAC */
    public static class KeyFactoryKMAC extends BaseSecretKeyFactory {
        public KeyFactoryKMAC(int i, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            super("KMAC" + i, aSN1ObjectIdentifier);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$KeyFactoryKMAC128 */
    public static class KeyFactoryKMAC128 extends KeyFactoryKMAC {
        public KeyFactoryKMAC128() {
            super(128, NISTObjectIdentifiers.id_KmacWithSHAKE128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$KeyFactoryKMAC256 */
    public static class KeyFactoryKMAC256 extends KeyFactoryKMAC {
        public KeyFactoryKMAC256() {
            super(256, NISTObjectIdentifiers.id_KmacWithSHAKE256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$KeyFactorySHA3 */
    public static class KeyFactorySHA3 extends BaseSecretKeyFactory {
        public KeyFactorySHA3(int i, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            super("HmacSHA3-" + i, aSN1ObjectIdentifier);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$KeyGenerator224 */
    public static class KeyGenerator224 extends KeyGeneratorSHA3 {
        public KeyGenerator224() {
            super(InterfaceC5102BERTags.f17976FLAGS);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$KeyGenerator256 */
    public static class KeyGenerator256 extends KeyGeneratorSHA3 {
        public KeyGenerator256() {
            super(256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$KeyGenerator384 */
    public static class KeyGenerator384 extends KeyGeneratorSHA3 {
        public KeyGenerator384() {
            super(384);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$KeyGenerator512 */
    public static class KeyGenerator512 extends KeyGeneratorSHA3 {
        public KeyGenerator512() {
            super(512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$KeyGeneratorSHA3 */
    public static class KeyGeneratorSHA3 extends BaseKeyGenerator {
        public KeyGeneratorSHA3(int i) {
            super("HMACSHA3-" + i, i, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA3$Mappings */
    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21683PREFIX = C5650SHA3.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21683PREFIX;
            sb.append(str);
            sb.append("$Digest224");
            configurableProvider.addAlgorithm("MessageDigest.SHA3-224", sb.toString());
            configurableProvider.addAlgorithm("MessageDigest.SHA3-256", str + "$Digest256");
            configurableProvider.addAlgorithm("MessageDigest.SHA3-384", str + "$Digest384");
            configurableProvider.addAlgorithm("MessageDigest.SHA3-512", str + "$Digest512");
            configurableProvider.addAlgorithm("MessageDigest", NISTObjectIdentifiers.id_sha3_224, str + "$Digest224");
            configurableProvider.addAlgorithm("MessageDigest", NISTObjectIdentifiers.id_sha3_256, str + "$Digest256");
            configurableProvider.addAlgorithm("MessageDigest", NISTObjectIdentifiers.id_sha3_384, str + "$Digest384");
            configurableProvider.addAlgorithm("MessageDigest", NISTObjectIdentifiers.id_sha3_512, str + "$Digest512");
            configurableProvider.addAlgorithm("MessageDigest.SHAKE256-512", str + "$DigestShake256_512");
            configurableProvider.addAlgorithm("MessageDigest.SHAKE128-256", str + "$DigestShake128_256");
            configurableProvider.addAlgorithm("MessageDigest", NISTObjectIdentifiers.id_shake256, str + "$DigestShake256_512");
            configurableProvider.addAlgorithm("MessageDigest", NISTObjectIdentifiers.id_shake128, str + "$DigestShake128_256");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHAKE256", "SHAKE256-512");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHAKE128", "SHAKE128-256");
            addHMACAlgorithm(configurableProvider, "SHA3-224", str + "$HashMac224", str + "$KeyGenerator224");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_hmacWithSHA3_224;
            addHMACAlias(configurableProvider, "SHA3-224", aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm("SecretKeyFactory.HMACSHA3-224", str + "$KeyFactory224");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier, "HMACSHA3-224");
            addHMACAlgorithm(configurableProvider, "SHA3-256", str + "$HashMac256", str + "$KeyGenerator256");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_hmacWithSHA3_256;
            addHMACAlias(configurableProvider, "SHA3-256", aSN1ObjectIdentifier2);
            configurableProvider.addAlgorithm("SecretKeyFactory.HMACSHA3-256", str + "$KeyFactory256");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier2, "HMACSHA3-256");
            addHMACAlgorithm(configurableProvider, "SHA3-384", str + "$HashMac384", str + "$KeyGenerator384");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_hmacWithSHA3_384;
            addHMACAlias(configurableProvider, "SHA3-384", aSN1ObjectIdentifier3);
            configurableProvider.addAlgorithm("SecretKeyFactory.HMACSHA3-384", str + "$KeyFactory384");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier3, "HMACSHA3-384");
            addHMACAlgorithm(configurableProvider, "SHA3-512", str + "$HashMac512", str + "$KeyGenerator512");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_hmacWithSHA3_512;
            addHMACAlias(configurableProvider, "SHA3-512", aSN1ObjectIdentifier4);
            configurableProvider.addAlgorithm("SecretKeyFactory.HMACSHA3-512", str + "$KeyFactory512");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier4, "HMACSHA3-512");
            addKMACAlgorithm(configurableProvider, "128", str + "$KMac128", str + "$KeyGenerator256");
            configurableProvider.addAlgorithm("SecretKeyFactory.KMAC128", str + "$KeyFactoryKMAC128");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + NISTObjectIdentifiers.id_Kmac128, "KMAC128");
            addKMACAlgorithm(configurableProvider, "256", str + "$KMac256", str + "$KeyGenerator512");
            configurableProvider.addAlgorithm("SecretKeyFactory.KMAC256", str + "$KeyFactoryKMAC256");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + NISTObjectIdentifiers.id_Kmac256, "KMAC256");
            configurableProvider.addAlgorithm("MessageDigest.TUPLEHASH256-512", str + "$DigestTupleHash256_512");
            configurableProvider.addAlgorithm("MessageDigest.TUPLEHASH128-256", str + "$DigestTupleHash128_256");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.TUPLEHASH256", "TUPLEHASH256-512");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.TUPLEHASH128", "TUPLEHASH128-256");
            configurableProvider.addAlgorithm("MessageDigest.PARALLELHASH256-512", str + "$DigestParallelHash256_512");
            configurableProvider.addAlgorithm("MessageDigest.PARALLELHASH128-256", str + "$DigestParallelHash128_256");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.PARALLELHASH256", "PARALLELHASH256-512");
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.PARALLELHASH128", "PARALLELHASH128-256");
        }
    }

    private C5650SHA3() {
    }
}
