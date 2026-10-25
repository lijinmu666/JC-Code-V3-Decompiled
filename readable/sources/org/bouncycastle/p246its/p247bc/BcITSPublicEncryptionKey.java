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
import org.bouncycastle.p246its.ITSPublicEncryptionKey;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.BasePublicEncryptionKey;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccCurvePoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccP256CurvePoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccP384CurvePoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.PublicEncryptionKey;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.SymmAlgorithm;

/* loaded from: classes2.dex */
public class BcITSPublicEncryptionKey extends ITSPublicEncryptionKey {
    public BcITSPublicEncryptionKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        super(fromKeyParameters((ECPublicKeyParameters) asymmetricKeyParameter));
    }

    public static PublicEncryptionKey fromKeyParameters(ECPublicKeyParameters eCPublicKeyParameters) {
        ASN1ObjectIdentifier aSN1ObjectIdentifierM15726getName = ((ECNamedDomainParameters) eCPublicKeyParameters.getParameters()).m15726getName();
        AbstractC5820ECPoint abstractC5820ECPointM15728getQ = eCPublicKeyParameters.m15728getQ();
        if (aSN1ObjectIdentifierM15726getName.m14446equals((ASN1Primitive) SECObjectIdentifiers.secp256r1)) {
            return new PublicEncryptionKey(SymmAlgorithm.aes128Ccm, new BasePublicEncryptionKey.C5940Builder().setChoice(0).setValue(EccP256CurvePoint.uncompressedP256(abstractC5820ECPointM15728getQ.getAffineXCoord().toBigInteger(), abstractC5820ECPointM15728getQ.getAffineYCoord().toBigInteger())).createBasePublicEncryptionKey());
        }
        if (aSN1ObjectIdentifierM15726getName.m14446equals((ASN1Primitive) TeleTrusTObjectIdentifiers.brainpoolP256r1)) {
            return new PublicEncryptionKey(SymmAlgorithm.aes128Ccm, new BasePublicEncryptionKey.C5940Builder().setChoice(1).setValue(EccP256CurvePoint.uncompressedP256(abstractC5820ECPointM15728getQ.getAffineXCoord().toBigInteger(), abstractC5820ECPointM15728getQ.getAffineYCoord().toBigInteger())).createBasePublicEncryptionKey());
        }
        throw new IllegalArgumentException("unknown curve in public encryption key");
    }

    /* renamed from: getKey */
    public AsymmetricKeyParameter m16018getKey() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        X9ECParameters byOID;
        BasePublicEncryptionKey publicKey = this.encryptionKey.getPublicKey();
        int choice = publicKey.getChoice();
        if (choice == 0) {
            aSN1ObjectIdentifier = SECObjectIdentifiers.secp256r1;
            byOID = NISTNamedCurves.getByOID(aSN1ObjectIdentifier);
        } else {
            if (choice != 1) {
                throw new IllegalStateException("unknown key type");
            }
            aSN1ObjectIdentifier = TeleTrusTObjectIdentifiers.brainpoolP256r1;
            byOID = TeleTrusTNamedCurves.getByOID(aSN1ObjectIdentifier);
        }
        AbstractC5817ECCurve curve = byOID.getCurve();
        if (!(this.encryptionKey.getPublicKey().getBasePublicEncryptionKey() instanceof EccCurvePoint)) {
            throw new IllegalStateException("extension to public verification key not supported");
        }
        EccCurvePoint eccCurvePoint = (EccCurvePoint) publicKey.getBasePublicEncryptionKey();
        if ((eccCurvePoint instanceof EccP256CurvePoint) || (eccCurvePoint instanceof EccP384CurvePoint)) {
            return new ECPublicKeyParameters(curve.decodePoint(eccCurvePoint.getEncodedPoint()).normalize(), new ECNamedDomainParameters(aSN1ObjectIdentifier, byOID));
        }
        throw new IllegalStateException("unknown key type");
    }

    public BcITSPublicEncryptionKey(PublicEncryptionKey publicEncryptionKey) {
        super(publicEncryptionKey);
    }
}
