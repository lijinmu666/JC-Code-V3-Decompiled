package org.bouncycastle.p314pqc.p334jcajce.provider;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p249jcajce.p280util.AbstractC5806SpiUtil;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricAlgorithmProvider;
import org.bouncycastle.p314pqc.p334jcajce.provider.ntruprime.NTRULPRimeKeyFactorySpi;
import org.bouncycastle.p314pqc.p334jcajce.provider.ntruprime.SNTRUPrimeKeyFactorySpi;

/* loaded from: classes2.dex */
public class NTRUPrime {

    /* renamed from: PREFIX */
    private static final String f23695PREFIX = "org.bouncycastle.pqc.jcajce.provider.ntruprime.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.NTRULPRIME", "org.bouncycastle.pqc.jcajce.provider.ntruprime.NTRULPRimeKeyFactorySpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.NTRULPRIME", "org.bouncycastle.pqc.jcajce.provider.ntruprime.NTRULPRimeKeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("KeyGenerator.NTRULPRIME", "org.bouncycastle.pqc.jcajce.provider.ntruprime.NTRULPRimeKeyGeneratorSpi");
            NTRULPRimeKeyFactorySpi nTRULPRimeKeyFactorySpi = new NTRULPRimeKeyFactorySpi();
            addCipherAlgorithm(configurableProvider, "NTRULPRIME", "org.bouncycastle.pqc.jcajce.provider.ntruprime.NTRULPRimeCipherSpi$Base", BCObjectIdentifiers.pqc_kem_ntrulprime);
            registerOid(configurableProvider, BCObjectIdentifiers.ntrulpr653, "NTRULPRIME", nTRULPRimeKeyFactorySpi);
            registerOid(configurableProvider, BCObjectIdentifiers.ntrulpr761, "NTRULPRIME", nTRULPRimeKeyFactorySpi);
            registerOid(configurableProvider, BCObjectIdentifiers.ntrulpr857, "NTRULPRIME", nTRULPRimeKeyFactorySpi);
            registerOid(configurableProvider, BCObjectIdentifiers.ntrulpr953, "NTRULPRIME", nTRULPRimeKeyFactorySpi);
            registerOid(configurableProvider, BCObjectIdentifiers.ntrulpr1013, "NTRULPRIME", nTRULPRimeKeyFactorySpi);
            registerOid(configurableProvider, BCObjectIdentifiers.ntrulpr1277, "NTRULPRIME", nTRULPRimeKeyFactorySpi);
            configurableProvider.addAlgorithm("KeyFactory.SNTRUPRIME", "org.bouncycastle.pqc.jcajce.provider.ntruprime.SNTRUPrimeKeyFactorySpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.SNTRUPRIME", "org.bouncycastle.pqc.jcajce.provider.ntruprime.SNTRUPrimeKeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("KeyGenerator.SNTRUPRIME", "org.bouncycastle.pqc.jcajce.provider.ntruprime.SNTRUPrimeKeyGeneratorSpi");
            SNTRUPrimeKeyFactorySpi sNTRUPrimeKeyFactorySpi = new SNTRUPrimeKeyFactorySpi();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = BCObjectIdentifiers.pqc_kem_sntruprime;
            addCipherAlgorithm(configurableProvider, "SNTRUPRIME", "org.bouncycastle.pqc.jcajce.provider.ntruprime.SNTRUPrimeCipherSpi$Base", aSN1ObjectIdentifier);
            registerOid(configurableProvider, BCObjectIdentifiers.sntrup653, "SNTRUPRIME", sNTRUPrimeKeyFactorySpi);
            registerOid(configurableProvider, BCObjectIdentifiers.sntrup761, "SNTRUPRIME", sNTRUPrimeKeyFactorySpi);
            registerOid(configurableProvider, BCObjectIdentifiers.sntrup857, "SNTRUPRIME", sNTRUPrimeKeyFactorySpi);
            registerOid(configurableProvider, BCObjectIdentifiers.sntrup953, "SNTRUPRIME", sNTRUPrimeKeyFactorySpi);
            registerOid(configurableProvider, BCObjectIdentifiers.sntrup1013, "SNTRUPRIME", sNTRUPrimeKeyFactorySpi);
            registerOid(configurableProvider, BCObjectIdentifiers.sntrup1277, "SNTRUPRIME", sNTRUPrimeKeyFactorySpi);
            if (AbstractC5806SpiUtil.m16226hasKEM()) {
                addKEMAlgorithm(configurableProvider, "SNTRUPRIME", "org.bouncycastle.pqc.jcajce.provider.ntruprime.SNTRUPrimeKEMSpi$SNTRUPrime", aSN1ObjectIdentifier);
            }
        }
    }
}
