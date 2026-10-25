package org.bouncycastle.p249jcajce.provider.asymmetric.p264util;

import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.p133asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.p133asn1.p176x9.ECNamedCurveTable;
import org.bouncycastle.p133asn1.p176x9.X962Parameters;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p133asn1.p176x9.X9ECParametersHolder;
import org.bouncycastle.p194crypto.p200ec.CustomNamedCurves;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p249jcajce.provider.p266config.ProviderConfiguration;
import org.bouncycastle.p281jce.ECGOST3410NamedCurveTable;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveParameterSpec;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveSpec;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p294field.FiniteField;
import org.bouncycastle.p284math.p294field.Polynomial;
import org.bouncycastle.p284math.p294field.PolynomialExtensionField;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util */
/* loaded from: classes2.dex */
public class C5617EC5Util {

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util$CustomCurves */
    public static class CustomCurves {
        private static Map CURVE_MAP = createCurveMap();

        private CustomCurves() {
        }

        private static Map createCurveMap() {
            HashMap map = new HashMap();
            Enumeration names = CustomNamedCurves.getNames();
            while (names.hasMoreElements()) {
                String str = (String) names.nextElement();
                X9ECParametersHolder byNameLazy = ECNamedCurveTable.getByNameLazy(str);
                if (byNameLazy != null) {
                    AbstractC5817ECCurve curve = byNameLazy.getCurve();
                    if (ECAlgorithms.isFpCurve(curve)) {
                        map.put(curve, CustomNamedCurves.getByNameLazy(str).getCurve());
                    }
                }
            }
            AbstractC5817ECCurve curve2 = CustomNamedCurves.getByNameLazy("Curve25519").getCurve();
            map.put(new AbstractC5817ECCurve.Fp(curve2.getField().getCharacteristic(), curve2.m16298getA().toBigInteger(), curve2.m16299getB().toBigInteger(), curve2.getOrder(), curve2.getCofactor(), true), curve2);
            return map;
        }

        public static AbstractC5817ECCurve substitute(AbstractC5817ECCurve abstractC5817ECCurve) {
            AbstractC5817ECCurve abstractC5817ECCurve2 = (AbstractC5817ECCurve) CURVE_MAP.get(abstractC5817ECCurve);
            return abstractC5817ECCurve2 != null ? abstractC5817ECCurve2 : abstractC5817ECCurve;
        }
    }

    public static EllipticCurve convertCurve(AbstractC5817ECCurve abstractC5817ECCurve, byte[] bArr) {
        return new EllipticCurve(convertField(abstractC5817ECCurve.getField()), abstractC5817ECCurve.m16298getA().toBigInteger(), abstractC5817ECCurve.m16299getB().toBigInteger(), null);
    }

    public static ECField convertField(FiniteField finiteField) {
        if (ECAlgorithms.isFpField(finiteField)) {
            return new ECFieldFp(finiteField.getCharacteristic());
        }
        Polynomial minimalPolynomial = ((PolynomialExtensionField) finiteField).getMinimalPolynomial();
        int[] exponentsPresent = minimalPolynomial.getExponentsPresent();
        return new ECFieldF2m(minimalPolynomial.getDegree(), C6238Arrays.reverseInPlace(C6238Arrays.copyOfRange(exponentsPresent, 1, exponentsPresent.length - 1)));
    }

    public static ECPoint convertPoint(AbstractC5820ECPoint abstractC5820ECPoint) {
        AbstractC5820ECPoint abstractC5820ECPointNormalize = abstractC5820ECPoint.normalize();
        return new ECPoint(abstractC5820ECPointNormalize.getAffineXCoord().toBigInteger(), abstractC5820ECPointNormalize.getAffineYCoord().toBigInteger());
    }

    public static ECParameterSpec convertSpec(EllipticCurve ellipticCurve, org.bouncycastle.p281jce.p282spec.ECParameterSpec eCParameterSpec) {
        ECPoint eCPointConvertPoint = convertPoint(eCParameterSpec.m16269getG());
        return eCParameterSpec instanceof ECNamedCurveParameterSpec ? new ECNamedCurveSpec(((ECNamedCurveParameterSpec) eCParameterSpec).m16266getName(), ellipticCurve, eCPointConvertPoint, eCParameterSpec.m16271getN(), eCParameterSpec.m16270getH()) : new ECParameterSpec(ellipticCurve, eCPointConvertPoint, eCParameterSpec.m16271getN(), eCParameterSpec.m16270getH().intValue());
    }

    public static ECParameterSpec convertToSpec(X962Parameters x962Parameters, AbstractC5817ECCurve abstractC5817ECCurve) {
        ECParameterSpec eCNamedCurveSpec;
        if (x962Parameters.isNamedCurve()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) x962Parameters.getParameters();
            X9ECParameters namedCurveByOid = C5618ECUtil.getNamedCurveByOid(aSN1ObjectIdentifier);
            if (namedCurveByOid == null) {
                Map additionalECParameters = BouncyCastleProvider.CONFIGURATION.getAdditionalECParameters();
                if (!additionalECParameters.isEmpty()) {
                    namedCurveByOid = (X9ECParameters) additionalECParameters.get(aSN1ObjectIdentifier);
                }
            }
            return new ECNamedCurveSpec(C5618ECUtil.getCurveName(aSN1ObjectIdentifier), convertCurve(abstractC5817ECCurve, namedCurveByOid.m14738getSeed()), convertPoint(namedCurveByOid.m14735getG()), namedCurveByOid.m14737getN(), namedCurveByOid.m14736getH());
        }
        if (x962Parameters.isImplicitlyCA()) {
            return null;
        }
        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(x962Parameters.getParameters());
        if (aSN1Sequence.mo14450size() > 3) {
            X9ECParameters x9ECParameters = X9ECParameters.getInstance(aSN1Sequence);
            EllipticCurve ellipticCurveConvertCurve = convertCurve(abstractC5817ECCurve, x9ECParameters.m14738getSeed());
            eCNamedCurveSpec = x9ECParameters.m14736getH() != null ? new ECParameterSpec(ellipticCurveConvertCurve, convertPoint(x9ECParameters.m14735getG()), x9ECParameters.m14737getN(), x9ECParameters.m14736getH().intValue()) : new ECParameterSpec(ellipticCurveConvertCurve, convertPoint(x9ECParameters.m14735getG()), x9ECParameters.m14737getN(), 1);
        } else {
            GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = GOST3410PublicKeyAlgParameters.getInstance(aSN1Sequence);
            ECNamedCurveParameterSpec parameterSpec = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.m14570getName(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet()));
            eCNamedCurveSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.m14570getName(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet()), convertCurve(parameterSpec.getCurve(), parameterSpec.m16272getSeed()), convertPoint(parameterSpec.m16269getG()), parameterSpec.m16271getN(), parameterSpec.m16270getH());
        }
        return eCNamedCurveSpec;
    }

    public static AbstractC5817ECCurve getCurve(ProviderConfiguration providerConfiguration, X962Parameters x962Parameters) {
        Set acceptableNamedCurves = providerConfiguration.getAcceptableNamedCurves();
        if (!x962Parameters.isNamedCurve()) {
            if (x962Parameters.isImplicitlyCA()) {
                return providerConfiguration.getEcImplicitlyCa().getCurve();
            }
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(x962Parameters.getParameters());
            if (acceptableNamedCurves.isEmpty()) {
                return (aSN1Sequence.mo14450size() > 3 ? X9ECParameters.getInstance(aSN1Sequence) : ECGOST3410NamedCurves.getByOIDX9(ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0)))).getCurve();
            }
            throw new IllegalStateException("encoded parameters not acceptable");
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(x962Parameters.getParameters());
        if (!acceptableNamedCurves.isEmpty() && !acceptableNamedCurves.contains(aSN1ObjectIdentifier)) {
            throw new IllegalStateException("named curve not acceptable");
        }
        X9ECParameters namedCurveByOid = C5618ECUtil.getNamedCurveByOid(aSN1ObjectIdentifier);
        if (namedCurveByOid == null) {
            namedCurveByOid = (X9ECParameters) providerConfiguration.getAdditionalECParameters().get(aSN1ObjectIdentifier);
        }
        return namedCurveByOid.getCurve();
    }

    public static ECDomainParameters getDomainParameters(ProviderConfiguration providerConfiguration, ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec != null) {
            return C5618ECUtil.getDomainParameters(providerConfiguration, convertSpec(eCParameterSpec));
        }
        org.bouncycastle.p281jce.p282spec.ECParameterSpec ecImplicitlyCa = providerConfiguration.getEcImplicitlyCa();
        return new ECDomainParameters(ecImplicitlyCa.getCurve(), ecImplicitlyCa.m16269getG(), ecImplicitlyCa.m16271getN(), ecImplicitlyCa.m16270getH(), ecImplicitlyCa.m16272getSeed());
    }

    public static AbstractC5817ECCurve convertCurve(EllipticCurve ellipticCurve) {
        ECField field = ellipticCurve.getField();
        BigInteger a = ellipticCurve.getA();
        BigInteger b = ellipticCurve.getB();
        if (field instanceof ECFieldFp) {
            return CustomCurves.substitute(new AbstractC5817ECCurve.Fp(((ECFieldFp) field).getP(), a, b, null, null));
        }
        ECFieldF2m eCFieldF2m = (ECFieldF2m) field;
        int m = eCFieldF2m.getM();
        int[] iArrConvertMidTerms = C5618ECUtil.convertMidTerms(eCFieldF2m.getMidTermsOfReductionPolynomial());
        return new AbstractC5817ECCurve.F2m(m, iArrConvertMidTerms[0], iArrConvertMidTerms[1], iArrConvertMidTerms[2], a, b, (BigInteger) null, (BigInteger) null);
    }

    public static AbstractC5820ECPoint convertPoint(ECParameterSpec eCParameterSpec, ECPoint eCPoint) {
        return convertPoint(convertCurve(eCParameterSpec.getCurve()), eCPoint);
    }

    public static org.bouncycastle.p281jce.p282spec.ECParameterSpec convertSpec(ECParameterSpec eCParameterSpec) {
        AbstractC5817ECCurve abstractC5817ECCurveConvertCurve = convertCurve(eCParameterSpec.getCurve());
        AbstractC5820ECPoint abstractC5820ECPointConvertPoint = convertPoint(abstractC5817ECCurveConvertCurve, eCParameterSpec.getGenerator());
        BigInteger order = eCParameterSpec.getOrder();
        BigInteger bigIntegerValueOf = BigInteger.valueOf(eCParameterSpec.getCofactor());
        byte[] seed = eCParameterSpec.getCurve().getSeed();
        return eCParameterSpec instanceof ECNamedCurveSpec ? new ECNamedCurveParameterSpec(((ECNamedCurveSpec) eCParameterSpec).m16267getName(), abstractC5817ECCurveConvertCurve, abstractC5820ECPointConvertPoint, order, bigIntegerValueOf, seed) : new org.bouncycastle.p281jce.p282spec.ECParameterSpec(abstractC5817ECCurveConvertCurve, abstractC5820ECPointConvertPoint, order, bigIntegerValueOf, seed);
    }

    public static ECParameterSpec convertToSpec(X9ECParameters x9ECParameters) {
        return new ECParameterSpec(convertCurve(x9ECParameters.getCurve(), null), convertPoint(x9ECParameters.m14735getG()), x9ECParameters.m14737getN(), x9ECParameters.m14736getH().intValue());
    }

    public static AbstractC5820ECPoint convertPoint(AbstractC5817ECCurve abstractC5817ECCurve, ECPoint eCPoint) {
        return abstractC5817ECCurve.createPoint(eCPoint.getAffineX(), eCPoint.getAffineY());
    }

    public static ECParameterSpec convertToSpec(ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(convertCurve(eCDomainParameters.getCurve(), null), convertPoint(eCDomainParameters.m15720getG()), eCDomainParameters.m15723getN(), eCDomainParameters.m15721getH().intValue());
    }
}
