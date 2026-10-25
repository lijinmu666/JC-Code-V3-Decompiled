package org.bouncycastle.p249jcajce.provider.asymmetric;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;
import org.bouncycastle.internal.p231asn1.p232bsi.BSIObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p233cms.CMSObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p234eac.EACObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p167sec.SECObjectIdentifiers;
import org.bouncycastle.p133asn1.p176x9.ECNamedCurveTable;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p249jcajce.provider.asymmetric.p254ec.KeyFactorySpi;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricAlgorithmProvider;
import org.bouncycastle.p361util.Properties;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.EC */
/* loaded from: classes2.dex */
public class C5489EC {

    /* renamed from: PREFIX */
    private static final String f21388PREFIX = "org.bouncycastle.jcajce.provider.asymmetric.ec.";
    private static final Map<String, String> ecSupportCurves;
    private static final Map<String, String> generalEcAttributes;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.EC$Mappings */
    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("AlgorithmParameters.EC", "org.bouncycastle.jcajce.provider.asymmetric.ec.AlgorithmParametersSpi", C5489EC.ecSupportCurves);
            configurableProvider.addAlgorithm("KeyAgreement.ECDH", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DH", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECDHC", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDH", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHU", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECDHWITHSHA1KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1KDFAndSharedInfo", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHWITHSHA1KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA1KDFAndSharedInfo", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECDHWITHSHA224KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA224KDFAndSharedInfo", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHWITHSHA224KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA224KDFAndSharedInfo", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECDHWITHSHA256KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA256KDFAndSharedInfo", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHWITHSHA256KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA256KDFAndSharedInfo", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECDHWITHSHA384KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA384KDFAndSharedInfo", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHWITHSHA384KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA384KDFAndSharedInfo", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECDHWITHSHA512KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA512KDFAndSharedInfo", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHWITHSHA512KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo", C5489EC.generalEcAttributes);
            ASN1ObjectIdentifier aSN1ObjectIdentifier = X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme;
            configurableProvider.addAlgorithm("KeyAgreement", aSN1ObjectIdentifier, "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1KDFAndSharedInfo", C5489EC.generalEcAttributes);
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = X9ObjectIdentifiers.dhSinglePass_cofactorDH_sha1kdf_scheme;
            configurableProvider.addAlgorithm("KeyAgreement", aSN1ObjectIdentifier2, "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA1KDFAndSharedInfo", C5489EC.generalEcAttributes);
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = SECObjectIdentifiers.dhSinglePass_stdDH_sha224kdf_scheme;
            configurableProvider.addAlgorithm("KeyAgreement", aSN1ObjectIdentifier3, "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA224KDFAndSharedInfo", C5489EC.generalEcAttributes);
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = SECObjectIdentifiers.dhSinglePass_cofactorDH_sha224kdf_scheme;
            configurableProvider.addAlgorithm("KeyAgreement", aSN1ObjectIdentifier4, "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA224KDFAndSharedInfo", C5489EC.generalEcAttributes);
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = SECObjectIdentifiers.dhSinglePass_stdDH_sha256kdf_scheme;
            configurableProvider.addAlgorithm("KeyAgreement", aSN1ObjectIdentifier5, "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA256KDFAndSharedInfo", C5489EC.generalEcAttributes);
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = SECObjectIdentifiers.dhSinglePass_cofactorDH_sha256kdf_scheme;
            configurableProvider.addAlgorithm("KeyAgreement", aSN1ObjectIdentifier6, "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA256KDFAndSharedInfo", C5489EC.generalEcAttributes);
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = SECObjectIdentifiers.dhSinglePass_stdDH_sha384kdf_scheme;
            configurableProvider.addAlgorithm("KeyAgreement", aSN1ObjectIdentifier7, "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA384KDFAndSharedInfo", C5489EC.generalEcAttributes);
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = SECObjectIdentifiers.dhSinglePass_cofactorDH_sha384kdf_scheme;
            configurableProvider.addAlgorithm("KeyAgreement", aSN1ObjectIdentifier8, "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA384KDFAndSharedInfo", C5489EC.generalEcAttributes);
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = SECObjectIdentifiers.dhSinglePass_stdDH_sha512kdf_scheme;
            configurableProvider.addAlgorithm("KeyAgreement", aSN1ObjectIdentifier9, "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA512KDFAndSharedInfo", C5489EC.generalEcAttributes);
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = SECObjectIdentifiers.dhSinglePass_cofactorDH_sha512kdf_scheme;
            configurableProvider.addAlgorithm("KeyAgreement", aSN1ObjectIdentifier10, "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHWITHSHA1CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1CKDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHWITHSHA256CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA256CKDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHWITHSHA384CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA384CKDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHWITHSHA512CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA512CKDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHUWITHSHA1CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA1CKDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHUWITHSHA224CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA224CKDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHUWITHSHA256CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA256CKDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHUWITHSHA384CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA384CKDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHUWITHSHA512CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA512CKDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHUWITHSHA1KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA1KDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHUWITHSHA224KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA224KDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHUWITHSHA256KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA256KDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHUWITHSHA384KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA384KDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECCDHUWITHSHA512KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA512KDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECKAEGWITHSHA1KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithSHA1KDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECKAEGWITHSHA224KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithSHA224KDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECKAEGWITHSHA256KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithSHA256KDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECKAEGWITHSHA384KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithSHA384KDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECKAEGWITHSHA512KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithSHA512KDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement", BSIObjectIdentifiers.ecka_eg_X963kdf_SHA1, "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithSHA1KDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement", BSIObjectIdentifiers.ecka_eg_X963kdf_SHA224, "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithSHA224KDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement", BSIObjectIdentifiers.ecka_eg_X963kdf_SHA256, "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithSHA256KDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement", BSIObjectIdentifiers.ecka_eg_X963kdf_SHA384, "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithSHA384KDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement", BSIObjectIdentifiers.ecka_eg_X963kdf_SHA512, "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithSHA512KDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement", BSIObjectIdentifiers.ecka_eg_X963kdf_RIPEMD160, "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithRIPEMD160KDF", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("KeyAgreement.ECKAEGWITHRIPEMD160KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithRIPEMD160KDF", C5489EC.generalEcAttributes);
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = X9ObjectIdentifiers.id_ecPublicKey;
            registerOid(configurableProvider, aSN1ObjectIdentifier11, "EC", new KeyFactorySpi.C5532EC());
            registerOid(configurableProvider, aSN1ObjectIdentifier, "EC", new KeyFactorySpi.C5532EC());
            registerOid(configurableProvider, aSN1ObjectIdentifier2, "EC", new KeyFactorySpi.C5532EC());
            registerOid(configurableProvider, aSN1ObjectIdentifier3, "EC", new KeyFactorySpi.C5532EC());
            registerOid(configurableProvider, aSN1ObjectIdentifier4, "EC", new KeyFactorySpi.C5532EC());
            registerOid(configurableProvider, aSN1ObjectIdentifier5, "EC", new KeyFactorySpi.C5532EC());
            registerOid(configurableProvider, aSN1ObjectIdentifier6, "EC", new KeyFactorySpi.C5532EC());
            registerOid(configurableProvider, aSN1ObjectIdentifier7, "EC", new KeyFactorySpi.C5532EC());
            registerOid(configurableProvider, aSN1ObjectIdentifier8, "EC", new KeyFactorySpi.C5532EC());
            registerOid(configurableProvider, aSN1ObjectIdentifier9, "EC", new KeyFactorySpi.C5532EC());
            registerOid(configurableProvider, aSN1ObjectIdentifier10, "EC", new KeyFactorySpi.C5532EC());
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier11, "EC");
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier, "EC");
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier2, "EC");
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier3, "EC");
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier4, "EC");
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier5, "EC");
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier6, "EC");
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier7, "EC");
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier8, "EC");
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier9, "EC");
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier10, "EC");
            if (!Properties.isOverrideSet("org.bouncycastle.ec.disable_mqv")) {
                configurableProvider.addAlgorithm("KeyAgreement.ECMQV", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQV", C5489EC.generalEcAttributes);
                configurableProvider.addAlgorithm("KeyAgreement.ECMQVWITHSHA1CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA1CKDF", C5489EC.generalEcAttributes);
                configurableProvider.addAlgorithm("KeyAgreement.ECMQVWITHSHA224CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA224CKDF", C5489EC.generalEcAttributes);
                configurableProvider.addAlgorithm("KeyAgreement.ECMQVWITHSHA256CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA256CKDF", C5489EC.generalEcAttributes);
                configurableProvider.addAlgorithm("KeyAgreement.ECMQVWITHSHA384CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA384CKDF", C5489EC.generalEcAttributes);
                configurableProvider.addAlgorithm("KeyAgreement.ECMQVWITHSHA512CKDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA512CKDF", C5489EC.generalEcAttributes);
                configurableProvider.addAlgorithm("KeyAgreement.ECMQVWITHSHA1KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA1KDF", C5489EC.generalEcAttributes);
                configurableProvider.addAlgorithm("KeyAgreement.ECMQVWITHSHA224KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA224KDF", C5489EC.generalEcAttributes);
                configurableProvider.addAlgorithm("KeyAgreement.ECMQVWITHSHA256KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA256KDF", C5489EC.generalEcAttributes);
                configurableProvider.addAlgorithm("KeyAgreement.ECMQVWITHSHA384KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA384KDF", C5489EC.generalEcAttributes);
                configurableProvider.addAlgorithm("KeyAgreement.ECMQVWITHSHA512KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA512KDF", C5489EC.generalEcAttributes);
                StringBuilder sb = new StringBuilder();
                sb.append("KeyAgreement.");
                ASN1ObjectIdentifier aSN1ObjectIdentifier12 = X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme;
                sb.append(aSN1ObjectIdentifier12);
                configurableProvider.addAlgorithm(sb.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA1KDFAndSharedInfo", C5489EC.generalEcAttributes);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("KeyAgreement.");
                ASN1ObjectIdentifier aSN1ObjectIdentifier13 = SECObjectIdentifiers.mqvSinglePass_sha224kdf_scheme;
                sb2.append(aSN1ObjectIdentifier13);
                configurableProvider.addAlgorithm(sb2.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA224KDFAndSharedInfo", C5489EC.generalEcAttributes);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("KeyAgreement.");
                ASN1ObjectIdentifier aSN1ObjectIdentifier14 = SECObjectIdentifiers.mqvSinglePass_sha256kdf_scheme;
                sb3.append(aSN1ObjectIdentifier14);
                configurableProvider.addAlgorithm(sb3.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA256KDFAndSharedInfo", C5489EC.generalEcAttributes);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("KeyAgreement.");
                ASN1ObjectIdentifier aSN1ObjectIdentifier15 = SECObjectIdentifiers.mqvSinglePass_sha384kdf_scheme;
                sb4.append(aSN1ObjectIdentifier15);
                configurableProvider.addAlgorithm(sb4.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA384KDFAndSharedInfo", C5489EC.generalEcAttributes);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("KeyAgreement.");
                ASN1ObjectIdentifier aSN1ObjectIdentifier16 = SECObjectIdentifiers.mqvSinglePass_sha512kdf_scheme;
                sb5.append(aSN1ObjectIdentifier16);
                configurableProvider.addAlgorithm(sb5.toString(), "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA512KDFAndSharedInfo", C5489EC.generalEcAttributes);
                registerOid(configurableProvider, aSN1ObjectIdentifier12, "ECMQV", new KeyFactorySpi.C5536ECMQV());
                registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier12, "EC");
                registerOid(configurableProvider, aSN1ObjectIdentifier13, "ECMQV", new KeyFactorySpi.C5536ECMQV());
                registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier13, "EC");
                registerOid(configurableProvider, aSN1ObjectIdentifier14, "ECMQV", new KeyFactorySpi.C5536ECMQV());
                registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier14, "EC");
                registerOid(configurableProvider, aSN1ObjectIdentifier15, "ECMQV", new KeyFactorySpi.C5536ECMQV());
                registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier15, "EC");
                registerOid(configurableProvider, aSN1ObjectIdentifier16, "ECMQV", new KeyFactorySpi.C5536ECMQV());
                registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier16, "EC");
                configurableProvider.addAlgorithm("KeyFactory.ECMQV", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECMQV");
                configurableProvider.addAlgorithm("KeyPairGenerator.ECMQV", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECMQV");
            }
            configurableProvider.addAlgorithm("KeyFactory.EC", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$EC");
            configurableProvider.addAlgorithm("KeyFactory.ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDSA");
            configurableProvider.addAlgorithm("KeyFactory.ECDH", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDH");
            configurableProvider.addAlgorithm("KeyFactory.ECDHC", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDHC");
            configurableProvider.addAlgorithm("KeyPairGenerator.EC", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$EC");
            configurableProvider.addAlgorithm("KeyPairGenerator.ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDSA");
            configurableProvider.addAlgorithm("KeyPairGenerator.ECDH", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDH");
            configurableProvider.addAlgorithm("KeyPairGenerator.ECDHWITHSHA1KDF", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDH");
            configurableProvider.addAlgorithm("KeyPairGenerator.ECDHC", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDHC");
            configurableProvider.addAlgorithm("KeyPairGenerator.ECIES", "org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDH");
            configurableProvider.addAlgorithm("Cipher.ECIES", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIES", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESwithSHA1", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIES", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESWITHSHA1", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIES", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESwithSHA256", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA256", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESWITHSHA256", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA256", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESwithSHA384", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA384", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESWITHSHA384", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA384", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESwithSHA512", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA512", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESWITHSHA512", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA512", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESwithAES-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithAESCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESWITHAES-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithAESCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESwithSHA1andAES-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithAESCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESWITHSHA1ANDAES-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithAESCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESwithSHA256andAES-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA256andAESCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESWITHSHA256ANDAES-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA256andAESCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESwithSHA384andAES-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA384andAESCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESWITHSHA384ANDAES-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA384andAESCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESwithSHA512andAES-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA512andAESCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESWITHSHA512ANDAES-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA512andAESCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESwithDESEDE-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithDESedeCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESWITHDESEDE-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithDESedeCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESwithSHA1andDESEDE-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithDESedeCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESWITHSHA1ANDDESEDE-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithDESedeCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESwithSHA256andDESEDE-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA256andDESedeCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESWITHSHA256ANDDESEDE-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA256andDESedeCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESwithSHA384andDESEDE-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA384andDESedeCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESWITHSHA384ANDDESEDE-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA384andDESedeCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESwithSHA512andDESEDE-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA512andDESedeCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ECIESWITHSHA512ANDDESEDE-CBC", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithSHA512andDESedeCBC", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Cipher.ETSIKEMWITHSHA256", "org.bouncycastle.jcajce.provider.asymmetric.ec.IESKEMCipher$KEMwithSHA256", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Signature.ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Signature.NONEwithECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSAnone", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1withECDSA", "ECDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.ECDSAwithSHA1", "ECDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1WITHECDSA", "ECDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.ECDSAWITHSHA1", "ECDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1WithECDSA", "ECDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.ECDSAWithSHA1", "ECDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.1.2.840.10045.4.1", "ECDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature." + TeleTrusTObjectIdentifiers.ecSignWithSha1, "ECDSA");
            configurableProvider.addAlgorithm("Signature.ECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Signature.SHA1WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Signature.SHA224WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA224", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Signature.SHA256WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA256", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Signature.SHA384WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA384", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Signature.SHA512WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA512", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Signature.SHA3-224WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSASha3_224", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Signature.SHA3-256WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSASha3_256", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Signature.SHA3-384WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSASha3_384", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Signature.SHA3-512WITHECDDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSASha3_512", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Alg.Alias.Signature.DETECDSA", "ECDDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1WITHDETECDSA", "SHA1WITHECDDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA224WITHDETECDSA", "SHA224WITHECDDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA256WITHDETECDSA", "SHA256WITHECDDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA384WITHDETECDSA", "SHA384WITHECDDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA512WITHDETECDSA", "SHA512WITHECDDSA");
            addSignatureAlgorithm(configurableProvider, "SHA224", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA224", X9ObjectIdentifiers.ecdsa_with_SHA224, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA256", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA256", X9ObjectIdentifiers.ecdsa_with_SHA256, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA384", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA384", X9ObjectIdentifiers.ecdsa_with_SHA384, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA512", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA512", X9ObjectIdentifiers.ecdsa_with_SHA512, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA3-224", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSASha3_224", NISTObjectIdentifiers.id_ecdsa_with_sha3_224, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA3-256", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSASha3_256", NISTObjectIdentifiers.id_ecdsa_with_sha3_256, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA3-384", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSASha3_384", NISTObjectIdentifiers.id_ecdsa_with_sha3_384, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA3-512", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSASha3_512", NISTObjectIdentifiers.id_ecdsa_with_sha3_512, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHAKE128", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSAShake128", CMSObjectIdentifiers.id_ecdsa_with_shake128, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHAKE256", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSAShake256", CMSObjectIdentifiers.id_ecdsa_with_shake256, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "RIPEMD160", "ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSARipeMD160", TeleTrusTObjectIdentifiers.ecSignWithRipemd160, C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Signature.SHA1WITHECNR", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Signature.SHA224WITHECNR", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR224", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Signature.SHA256WITHECNR", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR256", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Signature.SHA384WITHECNR", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR384", C5489EC.generalEcAttributes);
            configurableProvider.addAlgorithm("Signature.SHA512WITHECNR", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR512", C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA1", "CVC-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_1, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA224", "CVC-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA224", EACObjectIdentifiers.id_TA_ECDSA_SHA_224, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA256", "CVC-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA256", EACObjectIdentifiers.id_TA_ECDSA_SHA_256, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA384", "CVC-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA384", EACObjectIdentifiers.id_TA_ECDSA_SHA_384, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA512", "CVC-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA512", EACObjectIdentifiers.id_TA_ECDSA_SHA_512, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA1", "PLAIN-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA", BSIObjectIdentifiers.ecdsa_plain_SHA1, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA224", "PLAIN-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA224", BSIObjectIdentifiers.ecdsa_plain_SHA224, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA256", "PLAIN-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA256", BSIObjectIdentifiers.ecdsa_plain_SHA256, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA384", "PLAIN-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA384", BSIObjectIdentifiers.ecdsa_plain_SHA384, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA512", "PLAIN-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA512", BSIObjectIdentifiers.ecdsa_plain_SHA512, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "RIPEMD160", "PLAIN-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecPlainDSARP160", BSIObjectIdentifiers.ecdsa_plain_RIPEMD160, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA3-224", "PLAIN-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA3_224", BSIObjectIdentifiers.ecdsa_plain_SHA3_224, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA3-256", "PLAIN-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA3_256", BSIObjectIdentifiers.ecdsa_plain_SHA3_256, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA3-384", "PLAIN-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA3_384", BSIObjectIdentifiers.ecdsa_plain_SHA3_384, C5489EC.generalEcAttributes);
            addSignatureAlgorithm(configurableProvider, "SHA3-512", "PLAIN-ECDSA", "org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA3_512", BSIObjectIdentifiers.ecdsa_plain_SHA3_512, C5489EC.generalEcAttributes);
        }
    }

    static {
        int i;
        String str;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14728getOID;
        HashMap map = new HashMap();
        generalEcAttributes = map;
        ecSupportCurves = new HashMap();
        map.put("SupportedKeyClasses", "java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey");
        map.put("SupportedKeyFormats", "PKCS#8|X.509");
        Enumeration names = ECNamedCurveTable.getNames();
        Hashtable hashtable = new Hashtable();
        while (names.hasMoreElements()) {
            String str2 = (String) names.nextElement();
            if (org.bouncycastle.p281jce.ECNamedCurveTable.getParameterSpec(str2) != null && (aSN1ObjectIdentifierM14728getOID = ECNamedCurveTable.m14728getOID(str2)) != null) {
                String strM14433getId = aSN1ObjectIdentifierM14728getOID.m14433getId();
                Vector vector = (Vector) hashtable.get(strM14433getId);
                if (vector == null) {
                    vector = new Vector();
                    hashtable.put(strM14433getId, vector);
                }
                if (!vector.contains(str2)) {
                    vector.addElement(str2);
                }
            }
        }
        Enumeration enumerationKeys = hashtable.keys();
        Vector vector2 = new Vector();
        while (true) {
            i = 0;
            if (!enumerationKeys.hasMoreElements()) {
                break;
            }
            String str3 = (String) enumerationKeys.nextElement();
            Vector vector3 = (Vector) hashtable.get(str3);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier(str3);
            if (X9ObjectIdentifiers.prime256v1.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                str = "secp256r1,NIST P-256,X9.62 prime256v1";
            } else if (X9ObjectIdentifiers.prime192v1.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                str = "secp192r1,NIST P-192,X9.62 prime192v1";
            } else {
                if (aSN1ObjectIdentifier.m14435on(X9ObjectIdentifiers.primeCurve) || aSN1ObjectIdentifier.m14435on(X9ObjectIdentifiers.cTwoCurve)) {
                    stringBuffer.append("X9.62 ");
                }
                while (i < vector3.size()) {
                    if (i > 0) {
                        stringBuffer.append(",");
                    }
                    String str4 = (String) vector3.elementAt(i);
                    if ((aSN1ObjectIdentifier.m14435on(SECObjectIdentifiers.ellipticCurve) || X9ObjectIdentifiers.prime256v1.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) || X9ObjectIdentifiers.prime192v1.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) && (str4.startsWith("K-") || str4.startsWith("B-") || str4.startsWith("P-"))) {
                        stringBuffer.append("NIST ");
                    }
                    stringBuffer.append(str4);
                    i++;
                }
                stringBuffer.append(",");
                stringBuffer.append(str3);
                stringBuffer.append("]");
                vector2.addElement(stringBuffer.toString());
            }
            stringBuffer.append(str);
            stringBuffer.append(",");
            stringBuffer.append(str3);
            stringBuffer.append("]");
            vector2.addElement(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        while (i < vector2.size()) {
            if (i > 0) {
                stringBuffer2.append("|");
            }
            stringBuffer2.append((String) vector2.elementAt(i));
            i++;
        }
        ecSupportCurves.put("SupportedCurves", stringBuffer2.toString());
    }
}
