package org.bouncycastle.p194crypto.p221util;

import java.io.InputStream;
import java.math.BigInteger;
import org.bouncycastle.internal.p231asn1.p235edec.EdECObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p245oiw.ElGamalParameter;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.p133asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.DHParameter;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p166pkcs.RSAPrivateKey;
import org.bouncycastle.p133asn1.p167sec.ECPrivateKey;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.DSAParameter;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;
import org.bouncycastle.p133asn1.p176x9.ECNamedCurveTable;
import org.bouncycastle.p133asn1.p176x9.X962Parameters;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p194crypto.p213params.DHPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.DSAParameters;
import org.bouncycastle.p194crypto.p213params.DSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECGOST3410Parameters;
import org.bouncycastle.p194crypto.p213params.ECNamedDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.Ed25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.Ed448PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ElGamalParameters;
import org.bouncycastle.p194crypto.p213params.ElGamalPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X448PrivateKeyParameters;
import org.bouncycastle.p194crypto.p221util.PublicKeyFactory;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class PrivateKeyFactory {
    public static AsymmetricKeyParameter createKey(InputStream inputStream) {
        return createKey(PrivateKeyInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
    }

    private static byte[] getRawKey(PrivateKeyInfo privateKeyInfo) {
        return ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets();
    }

    private static ASN1OctetString parseOctetString(ASN1OctetString aSN1OctetString, int i) {
        ASN1OctetString octetData;
        byte[] octets = aSN1OctetString.getOctets();
        return (octets.length == i || (octetData = C5431Utils.parseOctetData(octets)) == null) ? aSN1OctetString : ASN1OctetString.getInstance(octetData);
    }

    private static ASN1Primitive parsePrimitiveString(ASN1OctetString aSN1OctetString, int i) {
        byte[] octets = aSN1OctetString.getOctets();
        if (octets.length == i) {
            return aSN1OctetString;
        }
        ASN1Primitive data = C5431Utils.parseData(octets);
        return data instanceof ASN1OctetString ? ASN1OctetString.getInstance(data) : data instanceof ASN1Sequence ? ASN1Sequence.getInstance(data) : aSN1OctetString;
    }

    public static AsymmetricKeyParameter createKey(PrivateKeyInfo privateKeyInfo) {
        BigInteger value;
        ECGOST3410Parameters eCGOST3410Parameters;
        BigInteger bigInteger;
        if (privateKeyInfo == null) {
            throw new IllegalArgumentException("keyInfo argument null");
        }
        AlgorithmIdentifier privateKeyAlgorithm = privateKeyInfo.getPrivateKeyAlgorithm();
        ASN1ObjectIdentifier algorithm = privateKeyAlgorithm.getAlgorithm();
        if (algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.rsaEncryption) || algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_RSASSA_PSS) || algorithm.m14446equals((ASN1Primitive) X509ObjectIdentifiers.id_ea_rsa)) {
            RSAPrivateKey rSAPrivateKey = RSAPrivateKey.getInstance(privateKeyInfo.parsePrivateKey());
            return new RSAPrivateCrtKeyParameters(rSAPrivateKey.getModulus(), rSAPrivateKey.getPublicExponent(), rSAPrivateKey.getPrivateExponent(), rSAPrivateKey.getPrime1(), rSAPrivateKey.getPrime2(), rSAPrivateKey.getExponent1(), rSAPrivateKey.getExponent2(), rSAPrivateKey.getCoefficient());
        }
        DSAParameters dSAParameters = null;
        ECGOST3410Parameters eCGOST3410Parameters2 = null;
        if (algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.dhKeyAgreement)) {
            DHParameter dHParameter = DHParameter.getInstance(privateKeyAlgorithm.getParameters());
            ASN1Integer aSN1Integer = (ASN1Integer) privateKeyInfo.parsePrivateKey();
            BigInteger bigIntegerM14628getL = dHParameter.m14628getL();
            return new DHPrivateKeyParameters(aSN1Integer.getValue(), new DHParameters(dHParameter.m14629getP(), dHParameter.m14627getG(), null, bigIntegerM14628getL != null ? bigIntegerM14628getL.intValue() : 0));
        }
        if (algorithm.m14446equals((ASN1Primitive) OIWObjectIdentifiers.elGamalAlgorithm)) {
            ElGamalParameter elGamalParameter = ElGamalParameter.getInstance(privateKeyAlgorithm.getParameters());
            return new ElGamalPrivateKeyParameters(((ASN1Integer) privateKeyInfo.parsePrivateKey()).getValue(), new ElGamalParameters(elGamalParameter.m15991getP(), elGamalParameter.m15990getG()));
        }
        if (algorithm.m14446equals((ASN1Primitive) X9ObjectIdentifiers.f18789id_dsa)) {
            ASN1Integer aSN1Integer2 = (ASN1Integer) privateKeyInfo.parsePrivateKey();
            ASN1Encodable parameters = privateKeyAlgorithm.getParameters();
            if (parameters != null) {
                DSAParameter dSAParameter = DSAParameter.getInstance(parameters.toASN1Primitive());
                dSAParameters = new DSAParameters(dSAParameter.m14680getP(), dSAParameter.m14681getQ(), dSAParameter.m14679getG());
            }
            return new DSAPrivateKeyParameters(aSN1Integer2.getValue(), dSAParameters);
        }
        if (algorithm.m14446equals((ASN1Primitive) X9ObjectIdentifiers.id_ecPublicKey)) {
            ECPrivateKey eCPrivateKey = ECPrivateKey.getInstance(privateKeyInfo.parsePrivateKey());
            X962Parameters x962Parameters = X962Parameters.getInstance(privateKeyAlgorithm.getParameters().toASN1Primitive());
            boolean zIsNamedCurve = x962Parameters.isNamedCurve();
            ASN1Primitive parameters2 = x962Parameters.getParameters();
            return new ECPrivateKeyParameters(eCPrivateKey.m14639getKey(), zIsNamedCurve ? ECNamedDomainParameters.m15725lookup(ASN1ObjectIdentifier.getInstance(parameters2)) : new ECDomainParameters(X9ECParameters.getInstance(parameters2)));
        }
        if (algorithm.m14446equals((ASN1Primitive) EdECObjectIdentifiers.id_X25519)) {
            return 32 == privateKeyInfo.getPrivateKeyLength() ? new X25519PrivateKeyParameters(privateKeyInfo.getPrivateKey().getOctets()) : new X25519PrivateKeyParameters(getRawKey(privateKeyInfo));
        }
        if (algorithm.m14446equals((ASN1Primitive) EdECObjectIdentifiers.f21248id_X448)) {
            return 56 == privateKeyInfo.getPrivateKeyLength() ? new X448PrivateKeyParameters(privateKeyInfo.getPrivateKey().getOctets()) : new X448PrivateKeyParameters(getRawKey(privateKeyInfo));
        }
        if (algorithm.m14446equals((ASN1Primitive) EdECObjectIdentifiers.id_Ed25519)) {
            return new Ed25519PrivateKeyParameters(getRawKey(privateKeyInfo));
        }
        if (algorithm.m14446equals((ASN1Primitive) EdECObjectIdentifiers.id_Ed448)) {
            return new Ed448PrivateKeyParameters(getRawKey(privateKeyInfo));
        }
        if (C5431Utils.mldsaParams.containsKey(algorithm)) {
            ASN1Primitive primitiveString = parsePrimitiveString(privateKeyInfo.getPrivateKey(), 32);
            MLDSAParameters mLDSAParametersMldsaParamsLookup = C5431Utils.mldsaParamsLookup(algorithm);
            MLDSAPublicKeyParameters publicKeyParams = privateKeyInfo.getPublicKeyData() != null ? PublicKeyFactory.MLDSAConverter.getPublicKeyParams(mLDSAParametersMldsaParamsLookup, privateKeyInfo.getPublicKeyData()) : null;
            if (primitiveString instanceof ASN1OctetString) {
                return new MLDSAPrivateKeyParameters(mLDSAParametersMldsaParamsLookup, ((ASN1OctetString) primitiveString).getOctets(), publicKeyParams);
            }
            if (!(primitiveString instanceof ASN1Sequence)) {
                throw new IllegalArgumentException("invalid " + mLDSAParametersMldsaParamsLookup.m15777getName() + " private key");
            }
            ASN1Sequence aSN1Sequence = (ASN1Sequence) primitiveString;
            byte[] octets = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets();
            byte[] octets2 = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets();
            MLDSAPrivateKeyParameters mLDSAPrivateKeyParameters = new MLDSAPrivateKeyParameters(mLDSAParametersMldsaParamsLookup, octets, publicKeyParams);
            if (C6238Arrays.constantTimeAreEqual(mLDSAPrivateKeyParameters.getEncoded(), octets2)) {
                return mLDSAPrivateKeyParameters;
            }
            throw new IllegalArgumentException("inconsistent " + mLDSAParametersMldsaParamsLookup.m15777getName() + " private key");
        }
        if (algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_alg_ml_kem_512) || algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_alg_ml_kem_768) || algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_alg_ml_kem_1024)) {
            ASN1Primitive primitiveString2 = parsePrimitiveString(privateKeyInfo.getPrivateKey(), 64);
            MLKEMParameters mLKEMParametersMlkemParamsLookup = C5431Utils.mlkemParamsLookup(algorithm);
            MLKEMPublicKeyParameters publicKeyParams2 = privateKeyInfo.getPublicKeyData() != null ? PublicKeyFactory.MLKEMConverter.getPublicKeyParams(mLKEMParametersMlkemParamsLookup, privateKeyInfo.getPublicKeyData()) : null;
            if (primitiveString2 instanceof ASN1OctetString) {
                return new MLKEMPrivateKeyParameters(mLKEMParametersMlkemParamsLookup, ((ASN1OctetString) primitiveString2).getOctets(), publicKeyParams2);
            }
            if (!(primitiveString2 instanceof ASN1Sequence)) {
                throw new IllegalArgumentException("invalid " + mLKEMParametersMlkemParamsLookup.m15790getName() + " private key");
            }
            ASN1Sequence aSN1Sequence2 = (ASN1Sequence) primitiveString2;
            byte[] octets3 = ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(0)).getOctets();
            byte[] octets4 = ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(1)).getOctets();
            MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters = new MLKEMPrivateKeyParameters(mLKEMParametersMlkemParamsLookup, octets3, publicKeyParams2);
            if (C6238Arrays.constantTimeAreEqual(mLKEMPrivateKeyParameters.getEncoded(), octets4)) {
                return mLKEMPrivateKeyParameters;
            }
            throw new IllegalArgumentException("inconsistent " + mLKEMParametersMlkemParamsLookup.m15790getName() + " private key");
        }
        if (C5431Utils.slhdsaParams.containsKey(algorithm)) {
            SLHDSAParameters sLHDSAParametersSlhdsaParamsLookup = C5431Utils.slhdsaParamsLookup(algorithm);
            return new SLHDSAPrivateKeyParameters(sLHDSAParametersSlhdsaParamsLookup, parseOctetString(privateKeyInfo.getPrivateKey(), sLHDSAParametersSlhdsaParamsLookup.m15815getN() * 4).getOctets());
        }
        if (!algorithm.m14446equals((ASN1Primitive) CryptoProObjectIdentifiers.gostR3410_2001) && !algorithm.m14446equals((ASN1Primitive) RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512) && !algorithm.m14446equals((ASN1Primitive) RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256)) {
            throw new RuntimeException("algorithm identifier in private key not recognised");
        }
        ASN1Encodable parameters3 = privateKeyAlgorithm.getParameters();
        GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = GOST3410PublicKeyAlgParameters.getInstance(parameters3);
        ASN1Primitive aSN1Primitive = parameters3.toASN1Primitive();
        if ((aSN1Primitive instanceof ASN1Sequence) && (ASN1Sequence.getInstance(aSN1Primitive).mo14450size() == 2 || ASN1Sequence.getInstance(aSN1Primitive).mo14450size() == 3)) {
            eCGOST3410Parameters = new ECGOST3410Parameters(new ECNamedDomainParameters(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet(), ECGOST3410NamedCurves.getByOIDX9(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet())), gOST3410PublicKeyAlgParameters.getPublicKeyParamSet(), gOST3410PublicKeyAlgParameters.getDigestParamSet(), gOST3410PublicKeyAlgParameters.getEncryptionParamSet());
            int privateKeyLength = privateKeyInfo.getPrivateKeyLength();
            if (privateKeyLength == 32 || privateKeyLength == 64) {
                bigInteger = new BigInteger(1, C6238Arrays.m18267reverse(privateKeyInfo.getPrivateKey().getOctets()));
            } else {
                ASN1Encodable privateKey = privateKeyInfo.parsePrivateKey();
                if (privateKey instanceof ASN1Integer) {
                    value = ASN1Integer.getInstance(privateKey).getPositiveValue();
                } else {
                    bigInteger = new BigInteger(1, C6238Arrays.m18267reverse(ASN1OctetString.getInstance(privateKey).getOctets()));
                }
            }
            value = bigInteger;
        } else {
            X962Parameters x962Parameters2 = X962Parameters.getInstance(privateKeyAlgorithm.getParameters());
            if (x962Parameters2.isNamedCurve()) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(x962Parameters2.getParameters());
                eCGOST3410Parameters2 = new ECGOST3410Parameters(new ECNamedDomainParameters(aSN1ObjectIdentifier, ECNamedCurveTable.getByOID(aSN1ObjectIdentifier)), gOST3410PublicKeyAlgParameters.getPublicKeyParamSet(), gOST3410PublicKeyAlgParameters.getDigestParamSet(), gOST3410PublicKeyAlgParameters.getEncryptionParamSet());
            } else if (!x962Parameters2.isImplicitlyCA()) {
                eCGOST3410Parameters2 = new ECGOST3410Parameters(new ECNamedDomainParameters(algorithm, X9ECParameters.getInstance(x962Parameters2.getParameters())), gOST3410PublicKeyAlgParameters.getPublicKeyParamSet(), gOST3410PublicKeyAlgParameters.getDigestParamSet(), gOST3410PublicKeyAlgParameters.getEncryptionParamSet());
            }
            ASN1Encodable privateKey2 = privateKeyInfo.parsePrivateKey();
            value = privateKey2 instanceof ASN1Integer ? ASN1Integer.getInstance(privateKey2).getValue() : ECPrivateKey.getInstance(privateKey2).m14639getKey();
            eCGOST3410Parameters = eCGOST3410Parameters2;
        }
        return new ECPrivateKeyParameters(value, new ECGOST3410Parameters(eCGOST3410Parameters, gOST3410PublicKeyAlgParameters.getPublicKeyParamSet(), gOST3410PublicKeyAlgParameters.getDigestParamSet(), gOST3410PublicKeyAlgParameters.getEncryptionParamSet()));
    }

    public static AsymmetricKeyParameter createKey(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("privateKeyInfoData array null");
        }
        if (bArr.length != 0) {
            return createKey(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(bArr)));
        }
        throw new IllegalArgumentException("privateKeyInfoData array empty");
    }
}
