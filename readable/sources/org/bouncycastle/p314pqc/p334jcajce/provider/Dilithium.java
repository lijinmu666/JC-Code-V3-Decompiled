package org.bouncycastle.p314pqc.p334jcajce.provider;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricAlgorithmProvider;
import org.bouncycastle.p314pqc.p334jcajce.provider.dilithium.DilithiumKeyFactorySpi;

/* loaded from: classes2.dex */
public class Dilithium {

    /* renamed from: PREFIX */
    private static final String f23685PREFIX = "org.bouncycastle.pqc.jcajce.provider.dilithium.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.DILITHIUM", "org.bouncycastle.pqc.jcajce.provider.dilithium.DilithiumKeyFactorySpi");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = BCObjectIdentifiers.dilithium2;
            addKeyFactoryAlgorithm(configurableProvider, "DILITHIUM2", "org.bouncycastle.pqc.jcajce.provider.dilithium.DilithiumKeyFactorySpi$Base2", aSN1ObjectIdentifier, new DilithiumKeyFactorySpi.C6162Base2());
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = BCObjectIdentifiers.dilithium3;
            addKeyFactoryAlgorithm(configurableProvider, "DILITHIUM3", "org.bouncycastle.pqc.jcajce.provider.dilithium.DilithiumKeyFactorySpi$Base3", aSN1ObjectIdentifier2, new DilithiumKeyFactorySpi.C6163Base3());
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = BCObjectIdentifiers.dilithium5;
            addKeyFactoryAlgorithm(configurableProvider, "DILITHIUM5", "org.bouncycastle.pqc.jcajce.provider.dilithium.DilithiumKeyFactorySpi$Base5", aSN1ObjectIdentifier3, new DilithiumKeyFactorySpi.C6164Base5());
            configurableProvider.addAlgorithm("KeyPairGenerator.DILITHIUM", "org.bouncycastle.pqc.jcajce.provider.dilithium.DilithiumKeyPairGeneratorSpi");
            addKeyPairGeneratorAlgorithm(configurableProvider, "DILITHIUM2", "org.bouncycastle.pqc.jcajce.provider.dilithium.DilithiumKeyPairGeneratorSpi$Base2", aSN1ObjectIdentifier);
            addKeyPairGeneratorAlgorithm(configurableProvider, "DILITHIUM3", "org.bouncycastle.pqc.jcajce.provider.dilithium.DilithiumKeyPairGeneratorSpi$Base3", aSN1ObjectIdentifier2);
            addKeyPairGeneratorAlgorithm(configurableProvider, "DILITHIUM5", "org.bouncycastle.pqc.jcajce.provider.dilithium.DilithiumKeyPairGeneratorSpi$Base5", aSN1ObjectIdentifier3);
            addSignatureAlgorithm(configurableProvider, "DILITHIUM", "org.bouncycastle.pqc.jcajce.provider.dilithium.SignatureSpi$Base", BCObjectIdentifiers.dilithium);
            addSignatureAlgorithm(configurableProvider, "DILITHIUM2", "org.bouncycastle.pqc.jcajce.provider.dilithium.SignatureSpi$Base2", aSN1ObjectIdentifier);
            addSignatureAlgorithm(configurableProvider, "DILITHIUM3", "org.bouncycastle.pqc.jcajce.provider.dilithium.SignatureSpi$Base3", aSN1ObjectIdentifier2);
            addSignatureAlgorithm(configurableProvider, "DILITHIUM5", "org.bouncycastle.pqc.jcajce.provider.dilithium.SignatureSpi$Base5", aSN1ObjectIdentifier3);
        }
    }
}
