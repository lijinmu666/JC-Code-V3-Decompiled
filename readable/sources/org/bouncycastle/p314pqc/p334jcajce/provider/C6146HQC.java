package org.bouncycastle.p314pqc.p334jcajce.provider;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p249jcajce.p280util.AbstractC5806SpiUtil;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricAlgorithmProvider;
import org.bouncycastle.p314pqc.p334jcajce.provider.p339hqc.HQCKeyFactorySpi;

/* renamed from: org.bouncycastle.pqc.jcajce.provider.HQC */
/* loaded from: classes2.dex */
public class C6146HQC {

    /* renamed from: PREFIX */
    private static final String f23688PREFIX = "org.bouncycastle.pqc.jcajce.provider.hqc.";

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.HQC$Mappings */
    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.HQC", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyFactorySpi");
            configurableProvider.addAlgorithm("Alg.Alias.KeyFactory.HQC", "HQC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = BCObjectIdentifiers.f18023hqc128;
            addKeyFactoryAlgorithm(configurableProvider, "HQC128", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyFactorySpi$HQC128", aSN1ObjectIdentifier, new HQCKeyFactorySpi.C6178HQC128());
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = BCObjectIdentifiers.f18024hqc192;
            addKeyFactoryAlgorithm(configurableProvider, "HQC192", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyFactorySpi$HQC192", aSN1ObjectIdentifier2, new HQCKeyFactorySpi.C6179HQC192());
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = BCObjectIdentifiers.f18025hqc256;
            addKeyFactoryAlgorithm(configurableProvider, "HQC256", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyFactorySpi$HQC256", aSN1ObjectIdentifier3, new HQCKeyFactorySpi.C6180HQC256());
            configurableProvider.addAlgorithm("KeyPairGenerator.HQC", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("Alg.Alias.KeyPairGenerator.HQC", "HQC");
            addKeyPairGeneratorAlgorithm(configurableProvider, "HQC128", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyPairGeneratorSpi$HQC128", aSN1ObjectIdentifier);
            addKeyPairGeneratorAlgorithm(configurableProvider, "HQC192", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyPairGeneratorSpi$HQC192", aSN1ObjectIdentifier2);
            addKeyPairGeneratorAlgorithm(configurableProvider, "HQC256", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyPairGeneratorSpi$HQC256", aSN1ObjectIdentifier3);
            configurableProvider.addAlgorithm("KeyGenerator.HQC", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyGeneratorSpi");
            addKeyGeneratorAlgorithm(configurableProvider, "HQC128", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyGeneratorSpi$HQC128", aSN1ObjectIdentifier);
            addKeyGeneratorAlgorithm(configurableProvider, "HQC192", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyGeneratorSpi$HQC192", aSN1ObjectIdentifier2);
            addKeyGeneratorAlgorithm(configurableProvider, "HQC256", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyGeneratorSpi$HQC256", aSN1ObjectIdentifier3);
            HQCKeyFactorySpi hQCKeyFactorySpi = new HQCKeyFactorySpi();
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = BCObjectIdentifiers.pqc_kem_hqc;
            addCipherAlgorithm(configurableProvider, "HQC", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCCipherSpi$Base", aSN1ObjectIdentifier4);
            addCipherAlgorithm(configurableProvider, "HQC128", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCCipherSpi$HQC128", aSN1ObjectIdentifier);
            addCipherAlgorithm(configurableProvider, "HQC192", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCCipherSpi$HQC192", aSN1ObjectIdentifier2);
            addCipherAlgorithm(configurableProvider, "HQC256", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCCipherSpi$HQC256", aSN1ObjectIdentifier3);
            registerOid(configurableProvider, aSN1ObjectIdentifier4, "HQC", hQCKeyFactorySpi);
            configurableProvider.addKeyInfoConverter(aSN1ObjectIdentifier, hQCKeyFactorySpi);
            configurableProvider.addKeyInfoConverter(aSN1ObjectIdentifier2, hQCKeyFactorySpi);
            configurableProvider.addKeyInfoConverter(aSN1ObjectIdentifier3, hQCKeyFactorySpi);
            if (AbstractC5806SpiUtil.m16226hasKEM()) {
                configurableProvider.addAlgorithm("KEM.HQC", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCKEMSpi$HQC");
                addKEMAlgorithm(configurableProvider, "HQC-128", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCKEMSpi$HQC128", aSN1ObjectIdentifier);
                addKEMAlgorithm(configurableProvider, "HQC-192", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCKEMSpi$HQC192", aSN1ObjectIdentifier2);
                addKEMAlgorithm(configurableProvider, "HQC-256", "org.bouncycastle.pqc.jcajce.provider.hqc.HQCKEMSpi$HQC256", aSN1ObjectIdentifier3);
            }
        }
    }
}
