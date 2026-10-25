package org.bouncycastle.p249jcajce.provider.asymmetric;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p249jcajce.p280util.AbstractC5806SpiUtil;
import org.bouncycastle.p249jcajce.provider.asymmetric.p261mlkem.MLKEMKeyFactorySpi;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricAlgorithmProvider;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.MLKEM */
/* loaded from: classes2.dex */
public class C5499MLKEM {

    /* renamed from: PREFIX */
    private static final String f21399PREFIX = "org.bouncycastle.jcajce.provider.asymmetric.mlkem.";

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.MLKEM$Mappings */
    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.ML-KEM", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMKeyFactorySpi");
            configurableProvider.addAlgorithm("Alg.Alias.KeyFactory.MLKEM", "ML-KEM");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_alg_ml_kem_512;
            addKeyFactoryAlgorithm(configurableProvider, "ML-KEM-512", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMKeyFactorySpi$MLKEM512", aSN1ObjectIdentifier, new MLKEMKeyFactorySpi.MLKEM512());
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_alg_ml_kem_768;
            addKeyFactoryAlgorithm(configurableProvider, "ML-KEM-768", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMKeyFactorySpi$MLKEM768", aSN1ObjectIdentifier2, new MLKEMKeyFactorySpi.MLKEM768());
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_alg_ml_kem_1024;
            addKeyFactoryAlgorithm(configurableProvider, "ML-KEM-1024", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMKeyFactorySpi$MLKEM1024", aSN1ObjectIdentifier3, new MLKEMKeyFactorySpi.MLKEM1024());
            configurableProvider.addAlgorithm("KeyPairGenerator.ML-KEM", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMKeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("Alg.Alias.KeyPairGenerator.MLKEM", "ML-KEM");
            addKeyPairGeneratorAlgorithm(configurableProvider, "ML-KEM-512", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMKeyPairGeneratorSpi$MLKEM512", aSN1ObjectIdentifier);
            addKeyPairGeneratorAlgorithm(configurableProvider, "ML-KEM-768", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMKeyPairGeneratorSpi$MLKEM768", aSN1ObjectIdentifier2);
            addKeyPairGeneratorAlgorithm(configurableProvider, "ML-KEM-1024", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMKeyPairGeneratorSpi$MLKEM1024", aSN1ObjectIdentifier3);
            configurableProvider.addAlgorithm("KeyGenerator.ML-KEM", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMKeyGeneratorSpi");
            addKeyGeneratorAlgorithm(configurableProvider, "ML-KEM-512", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMKeyGeneratorSpi$MLKEM512", aSN1ObjectIdentifier);
            addKeyGeneratorAlgorithm(configurableProvider, "ML-KEM-768", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMKeyGeneratorSpi$MLKEM768", aSN1ObjectIdentifier2);
            addKeyGeneratorAlgorithm(configurableProvider, "ML-KEM-1024", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMKeyGeneratorSpi$MLKEM1024", aSN1ObjectIdentifier3);
            MLKEMKeyFactorySpi mLKEMKeyFactorySpi = new MLKEMKeyFactorySpi();
            configurableProvider.addAlgorithm("Cipher.ML-KEM", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMCipherSpi$Base");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.MLKEM", "ML-KEM");
            addCipherAlgorithm(configurableProvider, "ML-KEM-512", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMCipherSpi$MLKEM512", aSN1ObjectIdentifier);
            addCipherAlgorithm(configurableProvider, "ML-KEM-768", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMCipherSpi$MLKEM768", aSN1ObjectIdentifier2);
            addCipherAlgorithm(configurableProvider, "ML-KEM-1024", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMCipherSpi$MLKEM1024", aSN1ObjectIdentifier3);
            configurableProvider.addKeyInfoConverter(aSN1ObjectIdentifier, mLKEMKeyFactorySpi);
            configurableProvider.addKeyInfoConverter(aSN1ObjectIdentifier2, mLKEMKeyFactorySpi);
            configurableProvider.addKeyInfoConverter(aSN1ObjectIdentifier3, mLKEMKeyFactorySpi);
            if (AbstractC5806SpiUtil.m16226hasKEM()) {
                configurableProvider.addAlgorithm("KEM.ML-KEM", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMSpi$MLKEM");
                addKEMAlgorithm(configurableProvider, "ML-KEM-512", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMSpi$MLKEM512", aSN1ObjectIdentifier);
                addKEMAlgorithm(configurableProvider, "ML-KEM-768", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMSpi$MLKEM768", aSN1ObjectIdentifier2);
                addKEMAlgorithm(configurableProvider, "ML-KEM-1024", "org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMSpi$MLKEM1024", aSN1ObjectIdentifier3);
            }
        }
    }
}
