package org.bouncycastle.p314pqc.p334jcajce.provider;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricAlgorithmProvider;
import org.bouncycastle.p314pqc.p334jcajce.provider.p336cmce.CMCEKeyFactorySpi;

/* renamed from: org.bouncycastle.pqc.jcajce.provider.CMCE */
/* loaded from: classes2.dex */
public class C6143CMCE {

    /* renamed from: PREFIX */
    private static final String f23684PREFIX = "org.bouncycastle.pqc.jcajce.provider.cmce.";

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.CMCE$Mappings */
    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.CMCE", "org.bouncycastle.pqc.jcajce.provider.cmce.CMCEKeyFactorySpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.CMCE", "org.bouncycastle.pqc.jcajce.provider.cmce.CMCEKeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("KeyGenerator.CMCE", "org.bouncycastle.pqc.jcajce.provider.cmce.CMCEKeyGeneratorSpi");
            CMCEKeyFactorySpi cMCEKeyFactorySpi = new CMCEKeyFactorySpi();
            configurableProvider.addAlgorithm("Cipher.CMCE", "org.bouncycastle.pqc.jcajce.provider.cmce.CMCECipherSpi$Base");
            StringBuilder sb = new StringBuilder();
            sb.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = BCObjectIdentifiers.pqc_kem_mceliece;
            sb.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(sb.toString(), "CMCE");
            addCipherAlgorithm(configurableProvider, "mceliece348864", "org.bouncycastle.pqc.jcajce.provider.cmce.CMCECipherSpi$MCE348864", BCObjectIdentifiers.mceliece348864_r3);
            addCipherAlgorithm(configurableProvider, "mceliece460896", "org.bouncycastle.pqc.jcajce.provider.cmce.CMCECipherSpi$MCE460896", BCObjectIdentifiers.mceliece460896_r3);
            addCipherAlgorithm(configurableProvider, "mceliece6688128", "org.bouncycastle.pqc.jcajce.provider.cmce.CMCECipherSpi$MCE6688128", BCObjectIdentifiers.mceliece6688128_r3);
            addCipherAlgorithm(configurableProvider, "mceliece6960119", "org.bouncycastle.pqc.jcajce.provider.cmce.CMCECipherSpi$MCE6960119", BCObjectIdentifiers.mceliece6960119_r3);
            addCipherAlgorithm(configurableProvider, "mceliece8192128", "org.bouncycastle.pqc.jcajce.provider.cmce.CMCECipherSpi$MCE8192128", BCObjectIdentifiers.mceliece8192128_r3);
            registerOid(configurableProvider, aSN1ObjectIdentifier, "CMCE", cMCEKeyFactorySpi);
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier, "CMCE");
        }
    }
}
