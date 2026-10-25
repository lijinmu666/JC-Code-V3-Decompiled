package org.bouncycastle.p249jcajce.provider.asymmetric.p254ec;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.util.Hashtable;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5617EC5Util;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5618ECUtil;
import org.bouncycastle.p249jcajce.provider.p266config.ProviderConfiguration;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveGenParameterSpec;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveSpec;
import org.bouncycastle.p281jce.p282spec.ECParameterSpec;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public abstract class GMKeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.GMKeyPairGeneratorSpi$BaseSM2 */
    public static class C5521BaseSM2 extends GMKeyPairGeneratorSpi {
        private static final Hashtable ecParameters;
        String algorithm;
        ProviderConfiguration configuration;
        Object ecParams;

        /* renamed from: engine */
        ECKeyPairGenerator f21483engine;
        boolean initialised;

        /* renamed from: param */
        ECKeyGenerationParameters f21484param;

        /* renamed from: random */
        SecureRandom f21485random;
        int strength;

        static {
            Hashtable hashtable = new Hashtable();
            ecParameters = hashtable;
            hashtable.put(Integers.m18296valueOf(192), new ECNamedCurveGenParameterSpec("prime192v1"));
            hashtable.put(Integers.m18296valueOf(239), new ECNamedCurveGenParameterSpec("prime239v1"));
            hashtable.put(Integers.m18296valueOf(256), new ECNamedCurveGenParameterSpec("prime256v1"));
            hashtable.put(Integers.m18296valueOf(InterfaceC5102BERTags.f17976FLAGS), new ECNamedCurveGenParameterSpec("P-224"));
            hashtable.put(Integers.m18296valueOf(384), new ECNamedCurveGenParameterSpec("P-384"));
            hashtable.put(Integers.m18296valueOf(521), new ECNamedCurveGenParameterSpec("P-521"));
        }

        public C5521BaseSM2() {
            super("EC");
            this.f21483engine = new ECKeyPairGenerator();
            this.ecParams = null;
            this.strength = 239;
            this.f21485random = CryptoServicesRegistrar.getSecureRandom();
            this.initialised = false;
            this.algorithm = "EC";
            this.configuration = BouncyCastleProvider.CONFIGURATION;
        }

        public ECKeyGenerationParameters createKeyGenParamsBC(ECParameterSpec eCParameterSpec, SecureRandom secureRandom) {
            return new ECKeyGenerationParameters(new ECDomainParameters(eCParameterSpec.getCurve(), eCParameterSpec.m16269getG(), eCParameterSpec.m16271getN(), eCParameterSpec.m16270getH()), secureRandom);
        }

        public ECKeyGenerationParameters createKeyGenParamsJCE(java.security.spec.ECParameterSpec eCParameterSpec, SecureRandom secureRandom) {
            X9ECParameters domainParametersFromName;
            if ((eCParameterSpec instanceof ECNamedCurveSpec) && (domainParametersFromName = C5518ECUtils.getDomainParametersFromName(((ECNamedCurveSpec) eCParameterSpec).m16267getName(), this.configuration)) != null) {
                return createKeyGenParamsJCE(domainParametersFromName, secureRandom);
            }
            AbstractC5817ECCurve abstractC5817ECCurveConvertCurve = C5617EC5Util.convertCurve(eCParameterSpec.getCurve());
            return new ECKeyGenerationParameters(new ECDomainParameters(abstractC5817ECCurveConvertCurve, C5617EC5Util.convertPoint(abstractC5817ECCurveConvertCurve, eCParameterSpec.getGenerator()), eCParameterSpec.getOrder(), BigInteger.valueOf(eCParameterSpec.getCofactor())), secureRandom);
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public KeyPair generateKeyPair() {
            if (!this.initialised) {
                initialize(this.strength, new SecureRandom());
            }
            AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f21483engine.generateKeyPair();
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic();
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate();
            Object obj = this.ecParams;
            if (obj instanceof ECParameterSpec) {
                ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
                BCECPublicKey bCECPublicKey = new BCECPublicKey(this.algorithm, eCPublicKeyParameters, eCParameterSpec, this.configuration);
                return new KeyPair(bCECPublicKey, new BCECPrivateKey(this.algorithm, eCPrivateKeyParameters, bCECPublicKey, eCParameterSpec, this.configuration));
            }
            if (obj == null) {
                return new KeyPair(new BCECPublicKey(this.algorithm, eCPublicKeyParameters, this.configuration), new BCECPrivateKey(this.algorithm, eCPrivateKeyParameters, this.configuration));
            }
            java.security.spec.ECParameterSpec eCParameterSpec2 = (java.security.spec.ECParameterSpec) obj;
            BCECPublicKey bCECPublicKey2 = new BCECPublicKey(this.algorithm, eCPublicKeyParameters, eCParameterSpec2, this.configuration);
            return new KeyPair(bCECPublicKey2, new BCECPrivateKey(this.algorithm, eCPrivateKeyParameters, bCECPublicKey2, eCParameterSpec2, this.configuration));
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(int i, SecureRandom secureRandom) {
            this.strength = i;
            this.f21485random = secureRandom;
            ECNamedCurveGenParameterSpec eCNamedCurveGenParameterSpec = (ECNamedCurveGenParameterSpec) ecParameters.get(Integers.m18296valueOf(i));
            if (eCNamedCurveGenParameterSpec == null) {
                throw new InvalidParameterException("unknown key size.");
            }
            try {
                initialize(eCNamedCurveGenParameterSpec, secureRandom);
            } catch (InvalidAlgorithmParameterException unused) {
                throw new InvalidParameterException("key size not configurable.");
            }
        }

        public void initializeNamedCurve(String str, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            X9ECParameters domainParametersFromName = C5518ECUtils.getDomainParametersFromName(str, this.configuration);
            if (domainParametersFromName != null) {
                this.ecParams = new ECNamedCurveSpec(str, domainParametersFromName.getCurve(), domainParametersFromName.m14735getG(), domainParametersFromName.m14737getN(), domainParametersFromName.m14736getH(), null);
                this.f21484param = createKeyGenParamsJCE(domainParametersFromName, secureRandom);
            } else {
                throw new InvalidAlgorithmParameterException("unknown curve name: " + str);
            }
        }

        public C5521BaseSM2(String str, ProviderConfiguration providerConfiguration) {
            super(str);
            this.f21483engine = new ECKeyPairGenerator();
            this.ecParams = null;
            this.strength = 239;
            this.f21485random = CryptoServicesRegistrar.getSecureRandom();
            this.initialised = false;
            this.algorithm = str;
            this.configuration = providerConfiguration;
        }

        public ECKeyGenerationParameters createKeyGenParamsJCE(X9ECParameters x9ECParameters, SecureRandom secureRandom) {
            return new ECKeyGenerationParameters(new ECDomainParameters(x9ECParameters.getCurve(), x9ECParameters.m14735getG(), x9ECParameters.m14737getN(), x9ECParameters.m14736getH()), secureRandom);
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            String strM16265getName;
            ECKeyGenerationParameters eCKeyGenerationParametersCreateKeyGenParamsJCE;
            ECParameterSpec ecImplicitlyCa;
            if (algorithmParameterSpec == null) {
                ecImplicitlyCa = this.configuration.getEcImplicitlyCa();
                if (ecImplicitlyCa == null) {
                    throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
                }
                this.ecParams = null;
            } else {
                if (!(algorithmParameterSpec instanceof ECParameterSpec)) {
                    if (algorithmParameterSpec instanceof java.security.spec.ECParameterSpec) {
                        this.ecParams = algorithmParameterSpec;
                        eCKeyGenerationParametersCreateKeyGenParamsJCE = createKeyGenParamsJCE((java.security.spec.ECParameterSpec) algorithmParameterSpec, secureRandom);
                        this.f21484param = eCKeyGenerationParametersCreateKeyGenParamsJCE;
                        this.f21483engine.mo14944init(this.f21484param);
                        this.initialised = true;
                    }
                    if (algorithmParameterSpec instanceof ECGenParameterSpec) {
                        strM16265getName = ((ECGenParameterSpec) algorithmParameterSpec).getName();
                    } else {
                        if (!(algorithmParameterSpec instanceof ECNamedCurveGenParameterSpec)) {
                            String nameFrom = C5618ECUtil.getNameFrom(algorithmParameterSpec);
                            if (nameFrom != null) {
                                initializeNamedCurve(nameFrom, secureRandom);
                                this.f21483engine.mo14944init(this.f21484param);
                                this.initialised = true;
                            } else {
                                throw new InvalidAlgorithmParameterException("invalid parameterSpec: " + algorithmParameterSpec);
                            }
                        }
                        strM16265getName = ((ECNamedCurveGenParameterSpec) algorithmParameterSpec).m16265getName();
                    }
                    initializeNamedCurve(strM16265getName, secureRandom);
                    this.f21483engine.mo14944init(this.f21484param);
                    this.initialised = true;
                }
                this.ecParams = algorithmParameterSpec;
                ecImplicitlyCa = (ECParameterSpec) algorithmParameterSpec;
            }
            eCKeyGenerationParametersCreateKeyGenParamsJCE = createKeyGenParamsBC(ecImplicitlyCa, secureRandom);
            this.f21484param = eCKeyGenerationParametersCreateKeyGenParamsJCE;
            this.f21483engine.mo14944init(this.f21484param);
            this.initialised = true;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.GMKeyPairGeneratorSpi$SM2 */
    public static class C5522SM2 extends C5521BaseSM2 {
        public C5522SM2() {
            super("SM2", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public GMKeyPairGeneratorSpi(String str) {
        super(str);
    }
}
