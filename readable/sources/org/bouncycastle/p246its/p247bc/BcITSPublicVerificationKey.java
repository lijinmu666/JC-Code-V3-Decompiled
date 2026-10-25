package org.bouncycastle.p246its.p247bc;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p161nist.NISTNamedCurves;
import org.bouncycastle.p133asn1.p167sec.SECObjectIdentifiers;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTNamedCurves;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ECNamedDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p246its.ITSPublicVerificationKey;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccCurvePoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccP256CurvePoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccP384CurvePoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.Point256;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.Point384;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.PublicVerificationKey;

/* loaded from: classes2.dex */
public class BcITSPublicVerificationKey extends ITSPublicVerificationKey {
    public BcITSPublicVerificationKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        super(fromKeyParameters((ECPublicKeyParameters) asymmetricKeyParameter));
    }

    public static PublicVerificationKey fromKeyParameters(ECPublicKeyParameters eCPublicKeyParameters) {
        ASN1ObjectIdentifier aSN1ObjectIdentifierM15726getName = ((ECNamedDomainParameters) eCPublicKeyParameters.getParameters()).m15726getName();
        AbstractC5820ECPoint abstractC5820ECPointM15728getQ = eCPublicKeyParameters.m15728getQ();
        if (aSN1ObjectIdentifierM15726getName.m14446equals((ASN1Primitive) SECObjectIdentifiers.secp256r1)) {
            return new PublicVerificationKey(0, EccP256CurvePoint.uncompressedP256(Point256.m17291builder().m17294setX(abstractC5820ECPointM15728getQ.getAffineXCoord().toBigInteger()).m17297setY(abstractC5820ECPointM15728getQ.getAffineYCoord().toBigInteger()).createPoint256()));
        }
        if (aSN1ObjectIdentifierM15726getName.m14446equals((ASN1Primitive) TeleTrusTObjectIdentifiers.brainpoolP256r1)) {
            return new PublicVerificationKey(1, EccP256CurvePoint.uncompressedP256(Point256.m17291builder().m17294setX(abstractC5820ECPointM15728getQ.getAffineXCoord().toBigInteger()).m17297setY(abstractC5820ECPointM15728getQ.getAffineYCoord().toBigInteger()).createPoint256()));
        }
        if (aSN1ObjectIdentifierM15726getName.m14446equals((ASN1Primitive) TeleTrusTObjectIdentifiers.brainpoolP384r1)) {
            return new PublicVerificationKey(2, EccP384CurvePoint.uncompressedP384(Point384.m17300builder().m17303setX(abstractC5820ECPointM15728getQ.getAffineXCoord().toBigInteger()).m17306setY(abstractC5820ECPointM15728getQ.getAffineYCoord().toBigInteger()).createPoint384()));
        }
        throw new IllegalArgumentException("unknown curve in public encryption key");
    }

    /* renamed from: getKey */
    public AsymmetricKeyParameter m16019getKey() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        X9ECParameters byOID;
        int choice = this.verificationKey.getChoice();
        if (choice != 0) {
            if (choice == 1) {
                aSN1ObjectIdentifier = TeleTrusTObjectIdentifiers.brainpoolP256r1;
            } else {
                if (choice != 2) {
                    throw new IllegalStateException("unknown key type");
                }
                aSN1ObjectIdentifier = TeleTrusTObjectIdentifiers.brainpoolP384r1;
            }
            byOID = TeleTrusTNamedCurves.getByOID(aSN1ObjectIdentifier);
        } else {
            aSN1ObjectIdentifier = SECObjectIdentifiers.secp256r1;
            byOID = NISTNamedCurves.getByOID(aSN1ObjectIdentifier);
        }
        AbstractC5817ECCurve curve = byOID.getCurve();
        if (!(this.verificationKey.getPublicVerificationKey() instanceof EccCurvePoint)) {
            throw new IllegalStateException("extension to public verification key not supported");
        }
        EccCurvePoint eccCurvePoint = (EccCurvePoint) this.verificationKey.getPublicVerificationKey();
        if ((eccCurvePoint instanceof EccP256CurvePoint) || (eccCurvePoint instanceof EccP384CurvePoint)) {
            return new ECPublicKeyParameters(curve.decodePoint(eccCurvePoint.getEncodedPoint()).normalize(), new ECNamedDomainParameters(aSN1ObjectIdentifier, byOID));
        }
        throw new IllegalStateException("unknown key type");
    }

    public BcITSPublicVerificationKey(PublicVerificationKey publicVerificationKey) {
        super(publicVerificationKey);
    }
}
