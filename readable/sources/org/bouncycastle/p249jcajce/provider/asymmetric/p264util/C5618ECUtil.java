package org.bouncycastle.p249jcajce.provider.asymmetric.p264util;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.ECNamedCurveTable;
import org.bouncycastle.p133asn1.p176x9.X962Parameters;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p194crypto.p200ec.CustomNamedCurves;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECNamedDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p249jcajce.p280util.SpecUtil;
import org.bouncycastle.p249jcajce.provider.p266config.ProviderConfiguration;
import org.bouncycastle.p281jce.interfaces.ECPrivateKey;
import org.bouncycastle.p281jce.interfaces.ECPublicKey;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveParameterSpec;
import org.bouncycastle.p281jce.p282spec.ECParameterSpec;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.FixedPointCombMultiplier;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Fingerprint;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil */
/* loaded from: classes2.dex */
public class C5618ECUtil {
    public static int[] convertMidTerms(int[] iArr) {
        int i;
        int[] iArr2 = new int[3];
        if (iArr.length == 1) {
            iArr2[0] = iArr[0];
        } else {
            if (iArr.length != 3) {
                throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
            }
            int i2 = iArr[0];
            int i3 = iArr[1];
            if (i2 >= i3 || i2 >= (i = iArr[2])) {
                int i4 = iArr[2];
                if (i3 < i4) {
                    iArr2[0] = i3;
                    int i5 = iArr[0];
                    if (i5 < i4) {
                        iArr2[1] = i5;
                        iArr2[2] = i4;
                    } else {
                        iArr2[1] = i4;
                        iArr2[2] = i5;
                    }
                } else {
                    iArr2[0] = i4;
                    int i6 = iArr[0];
                    if (i6 < i3) {
                        iArr2[1] = i6;
                        iArr2[2] = iArr[1];
                    } else {
                        iArr2[1] = i3;
                        iArr2[2] = i6;
                    }
                }
            } else {
                iArr2[0] = i2;
                if (i3 < i) {
                    iArr2[1] = i3;
                    iArr2[2] = i;
                } else {
                    iArr2[1] = i;
                    iArr2[2] = iArr[1];
                }
            }
        }
        return iArr2;
    }

    public static String generateKeyFingerprint(AbstractC5820ECPoint abstractC5820ECPoint, ECParameterSpec eCParameterSpec) {
        AbstractC5817ECCurve curve = eCParameterSpec.getCurve();
        return curve != null ? new Fingerprint(C6238Arrays.concatenate(abstractC5820ECPoint.getEncoded(false), curve.m16298getA().getEncoded(), curve.m16299getB().getEncoded(), eCParameterSpec.m16269getG().getEncoded(false))).toString() : new Fingerprint(abstractC5820ECPoint.getEncoded(false)).toString();
    }

    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof ECPrivateKey) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) privateKey;
            ECParameterSpec parameters = eCPrivateKey.getParameters();
            if (parameters == null) {
                parameters = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
            }
            if (!(eCPrivateKey.getParameters() instanceof ECNamedCurveParameterSpec)) {
                return new ECPrivateKeyParameters(eCPrivateKey.mo16093getD(), new ECDomainParameters(parameters.getCurve(), parameters.m16269getG(), parameters.m16271getN(), parameters.m16270getH(), parameters.m16272getSeed()));
            }
            return new ECPrivateKeyParameters(eCPrivateKey.mo16093getD(), new ECNamedDomainParameters(ECNamedCurveTable.m14728getOID(((ECNamedCurveParameterSpec) eCPrivateKey.getParameters()).m16266getName()), parameters.getCurve(), parameters.m16269getG(), parameters.m16271getN(), parameters.m16270getH(), parameters.m16272getSeed()));
        }
        if (privateKey instanceof java.security.interfaces.ECPrivateKey) {
            java.security.interfaces.ECPrivateKey eCPrivateKey2 = (java.security.interfaces.ECPrivateKey) privateKey;
            ECParameterSpec eCParameterSpecConvertSpec = C5617EC5Util.convertSpec(eCPrivateKey2.getParams());
            return new ECPrivateKeyParameters(eCPrivateKey2.getS(), new ECDomainParameters(eCParameterSpecConvertSpec.getCurve(), eCParameterSpecConvertSpec.m16269getG(), eCParameterSpecConvertSpec.m16271getN(), eCParameterSpecConvertSpec.m16270getH(), eCParameterSpecConvertSpec.m16272getSeed()));
        }
        try {
            byte[] encoded = privateKey.getEncoded();
            if (encoded == null) {
                throw new InvalidKeyException("no encoding for EC private key");
            }
            PrivateKey privateKey2 = BouncyCastleProvider.getPrivateKey(PrivateKeyInfo.getInstance(encoded));
            if (privateKey2 instanceof java.security.interfaces.ECPrivateKey) {
                return generatePrivateKeyParameter(privateKey2);
            }
            throw new InvalidKeyException("can't identify EC private key.");
        } catch (Exception e) {
            throw new InvalidKeyException("cannot identify EC private key: " + e.toString());
        }
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
            ECParameterSpec parameters = eCPublicKey.getParameters();
            return new ECPublicKeyParameters(eCPublicKey.mo16095getQ(), new ECDomainParameters(parameters.getCurve(), parameters.m16269getG(), parameters.m16271getN(), parameters.m16270getH(), parameters.m16272getSeed()));
        }
        if (publicKey instanceof java.security.interfaces.ECPublicKey) {
            java.security.interfaces.ECPublicKey eCPublicKey2 = (java.security.interfaces.ECPublicKey) publicKey;
            ECParameterSpec eCParameterSpecConvertSpec = C5617EC5Util.convertSpec(eCPublicKey2.getParams());
            return new ECPublicKeyParameters(C5617EC5Util.convertPoint(eCPublicKey2.getParams(), eCPublicKey2.getW()), new ECDomainParameters(eCParameterSpecConvertSpec.getCurve(), eCParameterSpecConvertSpec.m16269getG(), eCParameterSpecConvertSpec.m16271getN(), eCParameterSpecConvertSpec.m16270getH(), eCParameterSpecConvertSpec.m16272getSeed()));
        }
        try {
            byte[] encoded = publicKey.getEncoded();
            if (encoded == null) {
                throw new InvalidKeyException("no encoding for EC public key");
            }
            PublicKey publicKey2 = BouncyCastleProvider.getPublicKey(SubjectPublicKeyInfo.getInstance(encoded));
            if (publicKey2 instanceof java.security.interfaces.ECPublicKey) {
                return generatePublicKeyParameter(publicKey2);
            }
            throw new InvalidKeyException("cannot identify EC public key.");
        } catch (Exception e) {
            throw new InvalidKeyException("cannot identify EC public key: " + e.toString());
        }
    }

    public static String getCurveName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return ECNamedCurveTable.m14727getName(aSN1ObjectIdentifier);
    }

    public static ECDomainParameters getDomainParameters(ProviderConfiguration providerConfiguration, X962Parameters x962Parameters) {
        ECDomainParameters eCDomainParameters;
        if (x962Parameters.isNamedCurve()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(x962Parameters.getParameters());
            X9ECParameters namedCurveByOid = getNamedCurveByOid(aSN1ObjectIdentifier);
            if (namedCurveByOid == null) {
                namedCurveByOid = (X9ECParameters) providerConfiguration.getAdditionalECParameters().get(aSN1ObjectIdentifier);
            }
            return new ECNamedDomainParameters(aSN1ObjectIdentifier, namedCurveByOid);
        }
        if (x962Parameters.isImplicitlyCA()) {
            ECParameterSpec ecImplicitlyCa = providerConfiguration.getEcImplicitlyCa();
            eCDomainParameters = new ECDomainParameters(ecImplicitlyCa.getCurve(), ecImplicitlyCa.m16269getG(), ecImplicitlyCa.m16271getN(), ecImplicitlyCa.m16270getH(), ecImplicitlyCa.m16272getSeed());
        } else {
            X9ECParameters x9ECParameters = X9ECParameters.getInstance(x962Parameters.getParameters());
            eCDomainParameters = new ECDomainParameters(x9ECParameters.getCurve(), x9ECParameters.m14735getG(), x9ECParameters.m14737getN(), x9ECParameters.m14736getH(), x9ECParameters.m14738getSeed());
        }
        return eCDomainParameters;
    }

    public static String getNameFrom(AlgorithmParameterSpec algorithmParameterSpec) {
        return SpecUtil.getNameFrom(algorithmParameterSpec);
    }

    public static X9ECParameters getNamedCurveByName(String str) {
        X9ECParameters byName = CustomNamedCurves.getByName(str);
        return byName == null ? ECNamedCurveTable.getByName(str) : byName;
    }

    public static X9ECParameters getNamedCurveByOid(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParameters byOID = CustomNamedCurves.getByOID(aSN1ObjectIdentifier);
        return byOID == null ? ECNamedCurveTable.getByOID(aSN1ObjectIdentifier) : byOID;
    }

    public static ASN1ObjectIdentifier getNamedCurveOid(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            return null;
        }
        int iIndexOf = strTrim.indexOf(32);
        if (iIndexOf > 0) {
            strTrim = strTrim.substring(iIndexOf + 1);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifierTryFromID = ASN1ObjectIdentifier.tryFromID(strTrim);
        return aSN1ObjectIdentifierTryFromID != null ? aSN1ObjectIdentifierTryFromID : ECNamedCurveTable.m14728getOID(strTrim);
    }

    public static int getOrderBitLength(ProviderConfiguration providerConfiguration, BigInteger bigInteger, BigInteger bigInteger2) {
        ECParameterSpec ecImplicitlyCa;
        if (bigInteger != null) {
            return bigInteger.bitLength();
        }
        if (providerConfiguration != null && (ecImplicitlyCa = providerConfiguration.getEcImplicitlyCa()) != null) {
            return ecImplicitlyCa.m16271getN().bitLength();
        }
        return bigInteger2.bitLength();
    }

    public static String privateKeyToString(String str, BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        AbstractC5820ECPoint abstractC5820ECPointNormalize = new FixedPointCombMultiplier().multiply(eCParameterSpec.m16269getG(), bigInteger).normalize();
        sb.append(str);
        sb.append(" Private Key [");
        sb.append(generateKeyFingerprint(abstractC5820ECPointNormalize, eCParameterSpec));
        sb.append("]");
        sb.append(strLineSeparator);
        sb.append("            X: ");
        sb.append(abstractC5820ECPointNormalize.getAffineXCoord().toBigInteger().toString(16));
        sb.append(strLineSeparator);
        sb.append("            Y: ");
        sb.append(abstractC5820ECPointNormalize.getAffineYCoord().toBigInteger().toString(16));
        sb.append(strLineSeparator);
        return sb.toString();
    }

    public static String publicKeyToString(String str, AbstractC5820ECPoint abstractC5820ECPoint, ECParameterSpec eCParameterSpec) {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        sb.append(str);
        sb.append(" Public Key [");
        sb.append(generateKeyFingerprint(abstractC5820ECPoint, eCParameterSpec));
        sb.append("]");
        sb.append(strLineSeparator);
        sb.append("            X: ");
        sb.append(abstractC5820ECPoint.getAffineXCoord().toBigInteger().toString(16));
        sb.append(strLineSeparator);
        sb.append("            Y: ");
        sb.append(abstractC5820ECPoint.getAffineYCoord().toBigInteger().toString(16));
        sb.append(strLineSeparator);
        return sb.toString();
    }

    public static ECDomainParameters getDomainParameters(ProviderConfiguration providerConfiguration, ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec instanceof ECNamedCurveParameterSpec) {
            ECNamedCurveParameterSpec eCNamedCurveParameterSpec = (ECNamedCurveParameterSpec) eCParameterSpec;
            return new ECNamedDomainParameters(getNamedCurveOid(eCNamedCurveParameterSpec.m16266getName()), eCNamedCurveParameterSpec.getCurve(), eCNamedCurveParameterSpec.m16269getG(), eCNamedCurveParameterSpec.m16271getN(), eCNamedCurveParameterSpec.m16270getH(), eCNamedCurveParameterSpec.m16272getSeed());
        }
        if (eCParameterSpec != null) {
            return new ECDomainParameters(eCParameterSpec.getCurve(), eCParameterSpec.m16269getG(), eCParameterSpec.m16271getN(), eCParameterSpec.m16270getH(), eCParameterSpec.m16272getSeed());
        }
        ECParameterSpec ecImplicitlyCa = providerConfiguration.getEcImplicitlyCa();
        return new ECDomainParameters(ecImplicitlyCa.getCurve(), ecImplicitlyCa.m16269getG(), ecImplicitlyCa.m16271getN(), ecImplicitlyCa.m16270getH(), ecImplicitlyCa.m16272getSeed());
    }

    public static ASN1ObjectIdentifier getNamedCurveOid(ECParameterSpec eCParameterSpec) {
        Enumeration names = ECNamedCurveTable.getNames();
        while (names.hasMoreElements()) {
            String str = (String) names.nextElement();
            X9ECParameters byName = ECNamedCurveTable.getByName(str);
            if (byName.m14737getN().equals(eCParameterSpec.m16271getN()) && byName.m14736getH().equals(eCParameterSpec.m16270getH()) && byName.getCurve().m16297equals(eCParameterSpec.getCurve()) && byName.m14735getG().m16333equals(eCParameterSpec.m16269getG())) {
                return ECNamedCurveTable.m14728getOID(str);
            }
        }
        return null;
    }
}
