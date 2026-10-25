package org.bouncycastle.p249jcajce.provider.p267digest;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.PBESecretKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;

/* renamed from: org.bouncycastle.jcajce.provider.digest.SHA256 */
/* loaded from: classes2.dex */
public class C5649SHA256 {

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA256$Digest */
    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(SHA256Digest.newInstance());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.f21665digest = SHA256Digest.newInstance(this.f21665digest);
            return digest;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA256$HashMac */
    public static class HashMac extends C5789BaseMac {
        public HashMac() {
            super(new C5360HMac(SHA256Digest.newInstance()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA256$KeyFactory */
    public static class KeyFactory extends BaseSecretKeyFactory {
        public KeyFactory() {
            super("HmacSHA256", null);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA256$KeyGenerator */
    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA256", 256, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA256$Mappings */
    public static class Mappings extends DigestAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21682PREFIX = C5649SHA256.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21682PREFIX;
            sb.append(str);
            sb.append("$Digest");
            configurableProvider.addAlgorithm("MessageDigest.SHA-256", sb.toString());
            configurableProvider.addAlgorithm("Alg.Alias.MessageDigest.SHA256", XMSSKeyParameters.f23621SHA_256);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Alg.Alias.MessageDigest.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha256;
            sb2.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(sb2.toString(), XMSSKeyParameters.f23621SHA_256);
            configurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHHMACSHA256", str + "$PBEWithMacKeyFactory");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA-256", "PBEWITHHMACSHA256");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier, "PBEWITHHMACSHA256");
            configurableProvider.addAlgorithm("Mac.PBEWITHHMACSHA256", str + "$HashMac");
            addHMACAlgorithm(configurableProvider, "SHA256", str + "$HashMac", str + "$KeyGenerator");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.id_hmacWithSHA256;
            addHMACAlias(configurableProvider, "SHA256", aSN1ObjectIdentifier2);
            addHMACAlias(configurableProvider, "SHA256", aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm("SecretKeyFactory.HMACSHA256", str + "$KeyFactory");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier2, "HMACSHA256");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.digest.SHA256$PBEWithMacKeyFactory */
    public static class PBEWithMacKeyFactory extends PBESecretKeyFactory {
        public PBEWithMacKeyFactory() {
            super("PBEwithHmacSHA256", null, false, 2, 4, 256, 0);
        }
    }

    private C5649SHA256() {
    }
}
