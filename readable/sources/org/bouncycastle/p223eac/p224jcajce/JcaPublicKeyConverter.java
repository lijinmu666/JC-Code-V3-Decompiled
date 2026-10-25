package org.bouncycastle.p223eac.p224jcajce;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.RSAPublicKeySpec;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p143eac.EACObjectIdentifiers;
import org.bouncycastle.p133asn1.p143eac.ECDSAPublicKey;
import org.bouncycastle.p133asn1.p143eac.PublicKeyDataObject;
import org.bouncycastle.p133asn1.p143eac.RSAPublicKey;
import org.bouncycastle.p223eac.EACException;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p294field.FiniteField;
import org.bouncycastle.p284math.p294field.Polynomial;
import org.bouncycastle.p284math.p294field.PolynomialExtensionField;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class JcaPublicKeyConverter {

    /* renamed from: helper */
    private EACHelper f21154helper = new DefaultEACHelper();

    private static EllipticCurve convertCurve(AbstractC5817ECCurve abstractC5817ECCurve) {
        return new EllipticCurve(convertField(abstractC5817ECCurve.getField()), abstractC5817ECCurve.m16298getA().toBigInteger(), abstractC5817ECCurve.m16299getB().toBigInteger(), null);
    }

    private static ECField convertField(FiniteField finiteField) {
        if (ECAlgorithms.isFpField(finiteField)) {
            return new ECFieldFp(finiteField.getCharacteristic());
        }
        Polynomial minimalPolynomial = ((PolynomialExtensionField) finiteField).getMinimalPolynomial();
        int[] exponentsPresent = minimalPolynomial.getExponentsPresent();
        return new ECFieldF2m(minimalPolynomial.getDegree(), C6238Arrays.reverseInPlace(C6238Arrays.copyOfRange(exponentsPresent, 1, exponentsPresent.length - 1)));
    }

    private static AbstractC5820ECPoint convertPoint(AbstractC5817ECCurve abstractC5817ECCurve, ECPoint eCPoint) {
        return abstractC5817ECCurve.createPoint(eCPoint.getAffineX(), eCPoint.getAffineY());
    }

    private PublicKey getECPublicKeyPublicKey(ECDSAPublicKey eCDSAPublicKey) throws EACException {
        try {
            return this.f21154helper.createKeyFactory("ECDSA").generatePublic(new ECPublicKeySpec(getPublicPoint(eCDSAPublicKey), getParams(eCDSAPublicKey)));
        } catch (NoSuchAlgorithmException e) {
            throw new EACException("cannot find algorithm ECDSA: " + e.getMessage(), e);
        } catch (NoSuchProviderException e2) {
            throw new EACException("cannot find provider: " + e2.getMessage(), e2);
        }
    }

    private ECParameterSpec getParams(ECDSAPublicKey eCDSAPublicKey) {
        if (!eCDSAPublicKey.hasParameters()) {
            throw new IllegalArgumentException("Public key does not contains EC Params");
        }
        AbstractC5817ECCurve.Fp fp = new AbstractC5817ECCurve.Fp(eCDSAPublicKey.getPrimeModulusP(), eCDSAPublicKey.getFirstCoefA(), eCDSAPublicKey.getSecondCoefB(), eCDSAPublicKey.getOrderOfBasePointR(), eCDSAPublicKey.getCofactorF());
        AbstractC5820ECPoint abstractC5820ECPointDecodePoint = fp.decodePoint(eCDSAPublicKey.getBasePointG());
        return new ECParameterSpec(convertCurve(fp), new ECPoint(abstractC5820ECPointDecodePoint.getAffineXCoord().toBigInteger(), abstractC5820ECPointDecodePoint.getAffineYCoord().toBigInteger()), eCDSAPublicKey.getOrderOfBasePointR(), eCDSAPublicKey.getCofactorF().intValue());
    }

    private ECPoint getPublicPoint(ECDSAPublicKey eCDSAPublicKey) {
        if (!eCDSAPublicKey.hasParameters()) {
            throw new IllegalArgumentException("Public key does not contains EC Params");
        }
        AbstractC5820ECPoint.Fp fp = (AbstractC5820ECPoint.Fp) new AbstractC5817ECCurve.Fp(eCDSAPublicKey.getPrimeModulusP(), eCDSAPublicKey.getFirstCoefA(), eCDSAPublicKey.getSecondCoefB(), eCDSAPublicKey.getOrderOfBasePointR(), eCDSAPublicKey.getCofactorF()).decodePoint(eCDSAPublicKey.getPublicPointY());
        return new ECPoint(fp.getAffineXCoord().toBigInteger(), fp.getAffineYCoord().toBigInteger());
    }

    /* renamed from: getKey */
    public PublicKey m15948getKey(PublicKeyDataObject publicKeyDataObject) throws EACException {
        if (publicKeyDataObject.getUsage().m14435on(EACObjectIdentifiers.id_TA_ECDSA)) {
            return getECPublicKeyPublicKey((ECDSAPublicKey) publicKeyDataObject);
        }
        RSAPublicKey rSAPublicKey = (RSAPublicKey) publicKeyDataObject;
        try {
            return this.f21154helper.createKeyFactory("RSA").generatePublic(new RSAPublicKeySpec(rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent()));
        } catch (NoSuchAlgorithmException e) {
            throw new EACException("cannot find algorithm ECDSA: " + e.getMessage(), e);
        } catch (NoSuchProviderException e2) {
            throw new EACException("cannot find provider: " + e2.getMessage(), e2);
        }
    }

    public PublicKeyDataObject getPublicKeyDataObject(ASN1ObjectIdentifier aSN1ObjectIdentifier, PublicKey publicKey) {
        if (publicKey instanceof java.security.interfaces.RSAPublicKey) {
            java.security.interfaces.RSAPublicKey rSAPublicKey = (java.security.interfaces.RSAPublicKey) publicKey;
            return new RSAPublicKey(aSN1ObjectIdentifier, rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
        }
        ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
        ECParameterSpec params = eCPublicKey.getParams();
        EllipticCurve curve = params.getCurve();
        AbstractC5817ECCurve abstractC5817ECCurveConvertCurve = convertCurve(curve, params.getOrder(), params.getCofactor());
        return new ECDSAPublicKey(aSN1ObjectIdentifier, ((ECFieldFp) curve.getField()).getP(), curve.getA(), curve.getB(), convertPoint(abstractC5817ECCurveConvertCurve, params.getGenerator()).getEncoded(false), params.getOrder(), convertPoint(abstractC5817ECCurveConvertCurve, eCPublicKey.getW()).getEncoded(false), params.getCofactor());
    }

    public JcaPublicKeyConverter setProvider(String str) {
        this.f21154helper = new NamedEACHelper(str);
        return this;
    }

    private static AbstractC5817ECCurve convertCurve(EllipticCurve ellipticCurve, BigInteger bigInteger, int i) {
        ECField field = ellipticCurve.getField();
        BigInteger a = ellipticCurve.getA();
        BigInteger b = ellipticCurve.getB();
        if (field instanceof ECFieldFp) {
            return new AbstractC5817ECCurve.Fp(((ECFieldFp) field).getP(), a, b, bigInteger, BigInteger.valueOf(i));
        }
        throw new IllegalStateException("not implemented yet!!!");
    }

    public JcaPublicKeyConverter setProvider(Provider provider) {
        this.f21154helper = new ProviderEACHelper(provider);
        return this;
    }
}
