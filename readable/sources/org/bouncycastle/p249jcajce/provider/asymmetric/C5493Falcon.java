package org.bouncycastle.p249jcajce.provider.asymmetric;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricAlgorithmProvider;
import org.bouncycastle.p314pqc.p334jcajce.provider.p337falcon.FalconKeyFactorySpi;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.Falcon */
/* loaded from: classes2.dex */
public class C5493Falcon {

    /* renamed from: PREFIX */
    private static final String f21393PREFIX = "org.bouncycastle.pqc.jcajce.provider.falcon.";

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.Falcon$Mappings */
    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.FALCON", "org.bouncycastle.pqc.jcajce.provider.falcon.FalconKeyFactorySpi");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = BCObjectIdentifiers.falcon_512;
            addKeyFactoryAlgorithm(configurableProvider, "FALCON-512", "org.bouncycastle.pqc.jcajce.provider.falcon.FalconKeyFactorySpi$Falcon512", aSN1ObjectIdentifier, new FalconKeyFactorySpi.Falcon512());
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = BCObjectIdentifiers.falcon_1024;
            addKeyFactoryAlgorithm(configurableProvider, "FALCON-1024", "org.bouncycastle.pqc.jcajce.provider.falcon.FalconKeyFactorySpi$Falcon1024", aSN1ObjectIdentifier2, new FalconKeyFactorySpi.Falcon1024());
            configurableProvider.addAlgorithm("KeyPairGenerator.FALCON", "org.bouncycastle.pqc.jcajce.provider.falcon.FalconKeyPairGeneratorSpi");
            addKeyPairGeneratorAlgorithm(configurableProvider, "FALCON-512", "org.bouncycastle.pqc.jcajce.provider.falcon.FalconKeyPairGeneratorSpi$Falcon512", aSN1ObjectIdentifier);
            addKeyPairGeneratorAlgorithm(configurableProvider, "FALCON-1024", "org.bouncycastle.pqc.jcajce.provider.falcon.FalconKeyPairGeneratorSpi$Falcon1024", aSN1ObjectIdentifier2);
            addSignatureAlgorithm(configurableProvider, "FALCON", "org.bouncycastle.pqc.jcajce.provider.falcon.SignatureSpi$Base", BCObjectIdentifiers.f18022falcon);
            addSignatureAlgorithm(configurableProvider, "FALCON-512", "org.bouncycastle.pqc.jcajce.provider.falcon.SignatureSpi$Falcon512", aSN1ObjectIdentifier);
            addSignatureAlgorithm(configurableProvider, "FALCON-1024", "org.bouncycastle.pqc.jcajce.provider.falcon.SignatureSpi$Falcon1024", aSN1ObjectIdentifier2);
            registerSignatureOid(configurableProvider, BCObjectIdentifiers.old_falcon_512, "FALCON-512");
            registerSignatureOid(configurableProvider, BCObjectIdentifiers.old_falcon_1024, "FALCON-1024");
        }
    }
}
