package org.bouncycastle.p249jcajce.provider.asymmetric.ecgost12;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import org.bouncycastle.internal.p231asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECGOST3410Parameters;
import org.bouncycastle.p194crypto.p213params.ECKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.ECNamedDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p249jcajce.p279spec.GOST3410ParameterSpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5617EC5Util;
import org.bouncycastle.p249jcajce.provider.p266config.ProviderConfiguration;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveGenParameterSpec;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveSpec;
import org.bouncycastle.p281jce.p282spec.ECParameterSpec;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;

/* loaded from: classes2.dex */
public class KeyPairGeneratorSpi extends KeyPairGenerator {
    String algorithm;
    Object ecParams;

    /* renamed from: engine */
    ECKeyPairGenerator f21533engine;
    boolean initialised;

    /* renamed from: param */
    ECKeyGenerationParameters f21534param;

    /* renamed from: random */
    SecureRandom f21535random;
    int strength;

    public KeyPairGeneratorSpi() {
        super("ECGOST3410-2012");
        this.ecParams = null;
        this.f21533engine = new ECKeyPairGenerator();
        this.algorithm = "ECGOST3410-2012";
        this.strength = 239;
        this.f21535random = null;
        this.initialised = false;
    }

    /* renamed from: init */
    private void m16107init(GOST3410ParameterSpec gOST3410ParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        X9ECParameters byOIDX9 = ECGOST3410NamedCurves.getByOIDX9(gOST3410ParameterSpec.getPublicKeyParamSet());
        if (byOIDX9 == null) {
            throw new InvalidAlgorithmParameterException("unknown curve: " + gOST3410ParameterSpec.getPublicKeyParamSet());
        }
        this.ecParams = new ECNamedCurveSpec(ECGOST3410NamedCurves.m14570getName(gOST3410ParameterSpec.getPublicKeyParamSet()), byOIDX9.getCurve(), byOIDX9.m14735getG(), byOIDX9.m14737getN(), byOIDX9.m14736getH(), byOIDX9.m14738getSeed());
        ECKeyGenerationParameters eCKeyGenerationParameters = new ECKeyGenerationParameters(new ECGOST3410Parameters(new ECNamedDomainParameters(gOST3410ParameterSpec.getPublicKeyParamSet(), byOIDX9), gOST3410ParameterSpec.getPublicKeyParamSet(), gOST3410ParameterSpec.getDigestParamSet(), gOST3410ParameterSpec.getEncryptionParamSet()), secureRandom);
        this.f21534param = eCKeyGenerationParameters;
        this.f21533engine.mo14944init(eCKeyGenerationParameters);
        this.initialised = true;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            throw new IllegalStateException("EC Key Pair Generator not initialised");
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f21533engine.generateKeyPair();
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic();
        ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate();
        Object obj = this.ecParams;
        if (obj instanceof ECParameterSpec) {
            ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
            BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey = new BCECGOST3410_2012PublicKey(this.algorithm, eCPublicKeyParameters, eCParameterSpec);
            return new KeyPair(bCECGOST3410_2012PublicKey, new BCECGOST3410_2012PrivateKey(this.algorithm, eCPrivateKeyParameters, bCECGOST3410_2012PublicKey, eCParameterSpec));
        }
        if (obj == null) {
            return new KeyPair(new BCECGOST3410_2012PublicKey(this.algorithm, eCPublicKeyParameters), new BCECGOST3410_2012PrivateKey(this.algorithm, eCPrivateKeyParameters));
        }
        java.security.spec.ECParameterSpec eCParameterSpec2 = (java.security.spec.ECParameterSpec) obj;
        BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey2 = new BCECGOST3410_2012PublicKey(this.algorithm, eCPublicKeyParameters, eCParameterSpec2);
        return new KeyPair(bCECGOST3410_2012PublicKey2, new BCECGOST3410_2012PrivateKey(this.algorithm, eCPrivateKeyParameters, bCECGOST3410_2012PublicKey2, eCParameterSpec2));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.f21535random = secureRandom;
        Object obj = this.ecParams;
        if (obj == null) {
            throw new InvalidParameterException("unknown key size.");
        }
        try {
            initialize((ECGenParameterSpec) obj, secureRandom);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("key size not configurable.");
        }
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        ECKeyGenerationParameters eCKeyGenerationParameters;
        if (algorithmParameterSpec instanceof GOST3410ParameterSpec) {
            m16107init((GOST3410ParameterSpec) algorithmParameterSpec, secureRandom);
            return;
        }
        if (!(algorithmParameterSpec instanceof ECParameterSpec)) {
            if (algorithmParameterSpec instanceof java.security.spec.ECParameterSpec) {
                java.security.spec.ECParameterSpec eCParameterSpec = (java.security.spec.ECParameterSpec) algorithmParameterSpec;
                this.ecParams = algorithmParameterSpec;
                AbstractC5817ECCurve abstractC5817ECCurveConvertCurve = C5617EC5Util.convertCurve(eCParameterSpec.getCurve());
                ECKeyGenerationParameters eCKeyGenerationParameters2 = new ECKeyGenerationParameters(new ECDomainParameters(abstractC5817ECCurveConvertCurve, C5617EC5Util.convertPoint(abstractC5817ECCurveConvertCurve, eCParameterSpec.getGenerator()), eCParameterSpec.getOrder(), BigInteger.valueOf(eCParameterSpec.getCofactor())), secureRandom);
                this.f21534param = eCKeyGenerationParameters2;
                this.f21533engine.mo14944init(eCKeyGenerationParameters2);
                this.initialised = true;
            }
            boolean z = algorithmParameterSpec instanceof ECGenParameterSpec;
            if (z || (algorithmParameterSpec instanceof ECNamedCurveGenParameterSpec)) {
                String name = z ? ((ECGenParameterSpec) algorithmParameterSpec).getName() : ((ECNamedCurveGenParameterSpec) algorithmParameterSpec).m16265getName();
                ASN1ObjectIdentifier aSN1ObjectIdentifierM14571getOID = ECGOST3410NamedCurves.m14571getOID(name);
                m16107init((aSN1ObjectIdentifierM14571getOID.m14446equals((ASN1Primitive) RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetB) || aSN1ObjectIdentifierM14571getOID.m14446equals((ASN1Primitive) RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetC) || aSN1ObjectIdentifierM14571getOID.m14446equals((ASN1Primitive) RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetD)) ? new GOST3410ParameterSpec(ECGOST3410NamedCurves.m14571getOID(name), null) : new GOST3410ParameterSpec(name), secureRandom);
                return;
            }
            if (algorithmParameterSpec == null) {
                ProviderConfiguration providerConfiguration = BouncyCastleProvider.CONFIGURATION;
                if (providerConfiguration.getEcImplicitlyCa() != null) {
                    ECParameterSpec ecImplicitlyCa = providerConfiguration.getEcImplicitlyCa();
                    this.ecParams = algorithmParameterSpec;
                    eCKeyGenerationParameters = new ECKeyGenerationParameters(new ECDomainParameters(ecImplicitlyCa.getCurve(), ecImplicitlyCa.m16269getG(), ecImplicitlyCa.m16271getN(), ecImplicitlyCa.m16270getH()), secureRandom);
                }
            }
            if (algorithmParameterSpec == null && BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa() == null) {
                throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
            }
            throw new InvalidAlgorithmParameterException("parameter object not a ECParameterSpec: " + algorithmParameterSpec.getClass().getName());
        }
        ECParameterSpec eCParameterSpec2 = (ECParameterSpec) algorithmParameterSpec;
        this.ecParams = algorithmParameterSpec;
        eCKeyGenerationParameters = new ECKeyGenerationParameters(new ECDomainParameters(eCParameterSpec2.getCurve(), eCParameterSpec2.m16269getG(), eCParameterSpec2.m16271getN(), eCParameterSpec2.m16270getH()), secureRandom);
        this.f21534param = eCKeyGenerationParameters;
        this.f21533engine.mo14944init(eCKeyGenerationParameters);
        this.initialised = true;
    }
}
