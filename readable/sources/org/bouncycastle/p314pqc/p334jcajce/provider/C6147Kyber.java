package org.bouncycastle.p314pqc.p334jcajce.provider;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricAlgorithmProvider;
import org.bouncycastle.p314pqc.p334jcajce.provider.p340kyber.KyberKeyFactorySpi;

/* renamed from: org.bouncycastle.pqc.jcajce.provider.Kyber */
/* loaded from: classes2.dex */
public class C6147Kyber {

    /* renamed from: PREFIX */
    private static final String f23689PREFIX = "org.bouncycastle.pqc.jcajce.provider.kyber.";

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.Kyber$Mappings */
    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.KYBER", "org.bouncycastle.pqc.jcajce.provider.kyber.KyberKeyFactorySpi");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_alg_ml_kem_512;
            addKeyFactoryAlgorithm(configurableProvider, "ML-KEM-512", "org.bouncycastle.pqc.jcajce.provider.kyber.KyberKeyFactorySpi$Kyber512", aSN1ObjectIdentifier, new KyberKeyFactorySpi.Kyber512());
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_alg_ml_kem_768;
            addKeyFactoryAlgorithm(configurableProvider, "ML-KEM-768", "org.bouncycastle.pqc.jcajce.provider.kyber.KyberKeyFactorySpi$Kyber768", aSN1ObjectIdentifier2, new KyberKeyFactorySpi.Kyber768());
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_alg_ml_kem_1024;
            addKeyFactoryAlgorithm(configurableProvider, "ML-KEM-1024", "org.bouncycastle.pqc.jcajce.provider.kyber.KyberKeyFactorySpi$Kyber1024", aSN1ObjectIdentifier3, new KyberKeyFactorySpi.Kyber1024());
            configurableProvider.addAlgorithm("Alg.Alias.KeyFactory.KYBER512", "ML-KEM-512");
            configurableProvider.addAlgorithm("Alg.Alias.KeyFactory.KYBER768", "ML-KEM-768");
            configurableProvider.addAlgorithm("Alg.Alias.KeyFactory.KYBER1024", "ML-KEM-1024");
            configurableProvider.addAlgorithm("KeyPairGenerator.ML-KEM", "org.bouncycastle.pqc.jcajce.provider.kyber.KyberKeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.ML-KEM-512", "org.bouncycastle.pqc.jcajce.provider.kyber.KyberKeyPairGeneratorSpi$Kyber512");
            configurableProvider.addAlgorithm("KeyPairGenerator.ML-KEM-768", "org.bouncycastle.pqc.jcajce.provider.kyber.KyberKeyPairGeneratorSpi$Kyber768");
            configurableProvider.addAlgorithm("KeyPairGenerator.ML-KEM-1024", "org.bouncycastle.pqc.jcajce.provider.kyber.KyberKeyPairGeneratorSpi$Kyber1024");
            configurableProvider.addAlgorithm("Alg.Alias.KeyPairGenerator.KYBER", "ML-KEM");
            configurableProvider.addAlgorithm("Alg.Alias.KeyPairGenerator.KYBER512", "ML-KEM-512");
            configurableProvider.addAlgorithm("Alg.Alias.KeyPairGenerator.KYBER768", "ML-KEM-768");
            configurableProvider.addAlgorithm("Alg.Alias.KeyPairGenerator.KYBER1024", "ML-KEM-1024");
            configurableProvider.addAlgorithm("KeyGenerator.KYBER", "org.bouncycastle.pqc.jcajce.provider.kyber.KyberKeyGeneratorSpi");
            addKeyGeneratorAlgorithm(configurableProvider, "ML-KEM-512", "org.bouncycastle.pqc.jcajce.provider.kyber.KyberKeyGeneratorSpi$Kyber512", aSN1ObjectIdentifier);
            addKeyGeneratorAlgorithm(configurableProvider, "ML-KEM-768", "org.bouncycastle.pqc.jcajce.provider.kyber.KyberKeyGeneratorSpi$Kyber768", aSN1ObjectIdentifier2);
            addKeyGeneratorAlgorithm(configurableProvider, "ML-KEM-1024", "org.bouncycastle.pqc.jcajce.provider.kyber.KyberKeyGeneratorSpi$Kyber1024", aSN1ObjectIdentifier3);
            configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.KYBER512", "ML-KEM-512");
            configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.KYBER768", "ML-KEM-768");
            configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.KYBER1024", "ML-KEM-1024");
            KyberKeyFactorySpi kyberKeyFactorySpi = new KyberKeyFactorySpi();
            configurableProvider.addAlgorithm("Cipher.KYBER", "org.bouncycastle.pqc.jcajce.provider.kyber.KyberCipherSpi$Base");
            StringBuilder sb = new StringBuilder();
            sb.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = BCObjectIdentifiers.pqc_kem_kyber;
            sb.append(aSN1ObjectIdentifier4);
            configurableProvider.addAlgorithm(sb.toString(), "KYBER");
            addCipherAlgorithm(configurableProvider, "ML-KEM-512", "org.bouncycastle.pqc.jcajce.provider.kyber.KyberCipherSpi$Kyber512", aSN1ObjectIdentifier);
            addCipherAlgorithm(configurableProvider, "ML-KEM-768", "org.bouncycastle.pqc.jcajce.provider.kyber.KyberCipherSpi$Kyber768", aSN1ObjectIdentifier2);
            addCipherAlgorithm(configurableProvider, "ML-KEM-1024", "org.bouncycastle.pqc.jcajce.provider.kyber.KyberCipherSpi$Kyber1024", aSN1ObjectIdentifier3);
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.KYBER512", "ML-KEM-512");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.KYBER768", "ML-KEM-768");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.KYBER1024", "ML-KEM-1024");
            registerOid(configurableProvider, aSN1ObjectIdentifier4, "KYBER", kyberKeyFactorySpi);
        }
    }
}
