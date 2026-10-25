package org.bouncycastle.p314pqc.p334jcajce.provider;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricAlgorithmProvider;
import org.bouncycastle.p314pqc.p334jcajce.provider.p342mayo.MayoKeyFactorySpi;

/* renamed from: org.bouncycastle.pqc.jcajce.provider.Mayo */
/* loaded from: classes2.dex */
public class C6149Mayo {

    /* renamed from: PREFIX */
    private static final String f23691PREFIX = "org.bouncycastle.pqc.jcajce.provider.mayo.";

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.Mayo$Mappings */
    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.Mayo", "org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyFactorySpi");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = BCObjectIdentifiers.f18027mayo1;
            addKeyFactoryAlgorithm(configurableProvider, "MAYO_1", "org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyFactorySpi$Mayo1", aSN1ObjectIdentifier, new MayoKeyFactorySpi.C6189Mayo1());
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = BCObjectIdentifiers.f18028mayo2;
            addKeyFactoryAlgorithm(configurableProvider, "MAYO_2", "org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyFactorySpi$Mayo2", aSN1ObjectIdentifier2, new MayoKeyFactorySpi.C6190Mayo2());
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = BCObjectIdentifiers.f18029mayo3;
            addKeyFactoryAlgorithm(configurableProvider, "MAYO_3", "org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyFactorySpi$Mayo3", aSN1ObjectIdentifier3, new MayoKeyFactorySpi.C6191Mayo3());
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = BCObjectIdentifiers.f18030mayo5;
            addKeyFactoryAlgorithm(configurableProvider, "MAYO_5", "org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyFactorySpi$Mayo5", aSN1ObjectIdentifier4, new MayoKeyFactorySpi.C6192Mayo5());
            configurableProvider.addAlgorithm("KeyPairGenerator.Mayo", "org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyPairGeneratorSpi");
            addKeyPairGeneratorAlgorithm(configurableProvider, "MAYO_1", "org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyPairGeneratorSpi$Mayo1", aSN1ObjectIdentifier);
            addKeyPairGeneratorAlgorithm(configurableProvider, "MAYO_2", "org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyPairGeneratorSpi$Mayo2", aSN1ObjectIdentifier2);
            addKeyPairGeneratorAlgorithm(configurableProvider, "MAYO_3", "org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyPairGeneratorSpi$Mayo3", aSN1ObjectIdentifier3);
            addKeyPairGeneratorAlgorithm(configurableProvider, "MAYO_5", "org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyPairGeneratorSpi$Mayo5", aSN1ObjectIdentifier4);
            addSignatureAlgorithm(configurableProvider, "Mayo", "org.bouncycastle.pqc.jcajce.provider.mayo.SignatureSpi$Base", BCObjectIdentifiers.f18026mayo);
            addSignatureAlgorithm(configurableProvider, "MAYO_1", "org.bouncycastle.pqc.jcajce.provider.mayo.SignatureSpi$Mayo1", aSN1ObjectIdentifier);
            addSignatureAlgorithm(configurableProvider, "MAYO_2", "org.bouncycastle.pqc.jcajce.provider.mayo.SignatureSpi$Mayo2", aSN1ObjectIdentifier2);
            addSignatureAlgorithm(configurableProvider, "MAYO_3", "org.bouncycastle.pqc.jcajce.provider.mayo.SignatureSpi$Mayo3", aSN1ObjectIdentifier3);
            addSignatureAlgorithm(configurableProvider, "MAYO_5", "org.bouncycastle.pqc.jcajce.provider.mayo.SignatureSpi$Mayo5", aSN1ObjectIdentifier4);
        }
    }
}
