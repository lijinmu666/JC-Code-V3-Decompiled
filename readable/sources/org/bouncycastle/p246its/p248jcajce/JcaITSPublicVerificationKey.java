package org.bouncycastle.p246its.p248jcajce;

import java.security.Provider;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPublicKeySpec;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p161nist.NISTNamedCurves;
import org.bouncycastle.p133asn1.p167sec.SECObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTNamedCurves;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p246its.ITSPublicVerificationKey;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccCurvePoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccP256CurvePoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccP384CurvePoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.Point256;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.Point384;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.PublicVerificationKey;

/* loaded from: classes2.dex */
public class JcaITSPublicVerificationKey extends ITSPublicVerificationKey {

    /* renamed from: helper */
    private final JcaJceHelper f21322helper;

    /* renamed from: org.bouncycastle.its.jcajce.JcaITSPublicVerificationKey$Builder */
    public static class C5460Builder {

        /* renamed from: helper */
        private JcaJceHelper f21323helper = new DefaultJcaJceHelper();

        /* renamed from: build */
        public JcaITSPublicVerificationKey m16032build(PublicKey publicKey) {
            return new JcaITSPublicVerificationKey(publicKey, this.f21323helper);
        }

        public C5460Builder setProvider(String str) {
            this.f21323helper = new NamedJcaJceHelper(str);
            return this;
        }

        /* renamed from: build */
        public JcaITSPublicVerificationKey m16033build(PublicVerificationKey publicVerificationKey) {
            return new JcaITSPublicVerificationKey(publicVerificationKey, this.f21323helper);
        }

        public C5460Builder setProvider(Provider provider) {
            this.f21323helper = new ProviderJcaJceHelper(provider);
            return this;
        }
    }

    public JcaITSPublicVerificationKey(PublicKey publicKey, JcaJceHelper jcaJceHelper) {
        super(fromKeyParameters((ECPublicKey) publicKey));
        this.f21322helper = jcaJceHelper;
    }

    public static PublicVerificationKey fromKeyParameters(ECPublicKey eCPublicKey) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(SubjectPublicKeyInfo.getInstance(eCPublicKey.getEncoded()).getAlgorithm().getParameters());
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) SECObjectIdentifiers.secp256r1)) {
            return new PublicVerificationKey(0, EccP256CurvePoint.uncompressedP256(Point256.m17291builder().m17294setX(eCPublicKey.getW().getAffineX()).m17297setY(eCPublicKey.getW().getAffineY()).createPoint256()));
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) TeleTrusTObjectIdentifiers.brainpoolP256r1)) {
            return new PublicVerificationKey(1, EccP256CurvePoint.uncompressedP256(Point256.m17291builder().m17294setX(eCPublicKey.getW().getAffineX()).m17297setY(eCPublicKey.getW().getAffineY()).createPoint256()));
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) TeleTrusTObjectIdentifiers.brainpoolP384r1)) {
            return new PublicVerificationKey(2, EccP384CurvePoint.uncompressedP384(Point384.m17300builder().m17303setX(eCPublicKey.getW().getAffineX()).m17306setY(eCPublicKey.getW().getAffineY()).createPoint384()));
        }
        throw new IllegalArgumentException("unknown curve in public encryption key");
    }

    /* renamed from: getKey */
    public PublicKey m16031getKey() {
        X9ECParameters byOID;
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
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
            byOID = NISTNamedCurves.getByOID(SECObjectIdentifiers.secp256r1);
        }
        AbstractC5817ECCurve curve = byOID.getCurve();
        if (!(this.verificationKey.getPublicVerificationKey() instanceof EccCurvePoint)) {
            throw new IllegalStateException("extension to public verification key not supported");
        }
        EccCurvePoint eccCurvePoint = (EccCurvePoint) this.verificationKey.getPublicVerificationKey();
        if (!(eccCurvePoint instanceof EccP256CurvePoint) && !(eccCurvePoint instanceof EccP384CurvePoint)) {
            throw new IllegalStateException("unknown key type");
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = curve.decodePoint(eccCurvePoint.getEncodedPoint()).normalize();
        try {
            return this.f21322helper.createKeyFactory("EC").generatePublic(new ECPublicKeySpec(C5454ECUtil.convertPoint(abstractC5820ECPointNormalize), C5454ECUtil.convertToSpec(byOID)));
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public JcaITSPublicVerificationKey(PublicVerificationKey publicVerificationKey, JcaJceHelper jcaJceHelper) {
        super(publicVerificationKey);
        this.f21322helper = jcaJceHelper;
    }
}
