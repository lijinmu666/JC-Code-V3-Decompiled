package org.bouncycastle.p314pqc.p334jcajce.provider;

import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricAlgorithmProvider;
import org.bouncycastle.p314pqc.p315asn1.PQCObjectIdentifiers;
import org.bouncycastle.p314pqc.p334jcajce.provider.p343newhope.NHKeyFactorySpi;

/* renamed from: org.bouncycastle.pqc.jcajce.provider.NH */
/* loaded from: classes2.dex */
public class C6150NH {

    /* renamed from: PREFIX */
    private static final String f23692PREFIX = "org.bouncycastle.pqc.jcajce.provider.newhope.";

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.NH$Mappings */
    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.NH", "org.bouncycastle.pqc.jcajce.provider.newhope.NHKeyFactorySpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.NH", "org.bouncycastle.pqc.jcajce.provider.newhope.NHKeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("KeyAgreement.NH", "org.bouncycastle.pqc.jcajce.provider.newhope.KeyAgreementSpi");
            registerOid(configurableProvider, PQCObjectIdentifiers.f23021newHope, "NH", new NHKeyFactorySpi());
        }
    }
}
