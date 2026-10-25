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
import org.bouncycastle.p246its.ITSPublicEncryptionKey;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.BasePublicEncryptionKey;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccCurvePoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccP256CurvePoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccP384CurvePoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.PublicEncryptionKey;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.SymmAlgorithm;

/* loaded from: classes2.dex */
public class JceITSPublicEncryptionKey extends ITSPublicEncryptionKey {

    /* renamed from: helper */
    private final JcaJceHelper f21332helper;

    /* renamed from: org.bouncycastle.its.jcajce.JceITSPublicEncryptionKey$Builder */
    public static class C5465Builder {

        /* renamed from: helper */
        private JcaJceHelper f21333helper = new DefaultJcaJceHelper();

        /* renamed from: build */
        public JceITSPublicEncryptionKey m16039build(PublicKey publicKey) {
            return new JceITSPublicEncryptionKey(publicKey, this.f21333helper);
        }

        public C5465Builder setProvider(String str) {
            this.f21333helper = new NamedJcaJceHelper(str);
            return this;
        }

        /* renamed from: build */
        public JceITSPublicEncryptionKey m16040build(PublicEncryptionKey publicEncryptionKey) {
            return new JceITSPublicEncryptionKey(publicEncryptionKey, this.f21333helper);
        }

        public C5465Builder setProvider(Provider provider) {
            this.f21333helper = new ProviderJcaJceHelper(provider);
            return this;
        }
    }

    public JceITSPublicEncryptionKey(PublicKey publicKey, JcaJceHelper jcaJceHelper) {
        super(fromPublicKey(publicKey));
        this.f21332helper = jcaJceHelper;
    }

    public static PublicEncryptionKey fromPublicKey(PublicKey publicKey) {
        if (!(publicKey instanceof ECPublicKey)) {
            throw new IllegalArgumentException("must be ECPublicKey instance");
        }
        ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()).getAlgorithm().getParameters());
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) SECObjectIdentifiers.secp256r1)) {
            return new PublicEncryptionKey(SymmAlgorithm.aes128Ccm, new BasePublicEncryptionKey.C5940Builder().setChoice(0).setValue(EccP256CurvePoint.uncompressedP256(eCPublicKey.getW().getAffineX(), eCPublicKey.getW().getAffineY())).createBasePublicEncryptionKey());
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) TeleTrusTObjectIdentifiers.brainpoolP256r1)) {
            return new PublicEncryptionKey(SymmAlgorithm.aes128Ccm, new BasePublicEncryptionKey.C5940Builder().setChoice(1).setValue(EccP256CurvePoint.uncompressedP256(eCPublicKey.getW().getAffineX(), eCPublicKey.getW().getAffineY())).createBasePublicEncryptionKey());
        }
        throw new IllegalArgumentException("unknown curve in public encryption key");
    }

    /* renamed from: getKey */
    public PublicKey m16038getKey() {
        X9ECParameters byOID;
        BasePublicEncryptionKey publicKey = this.encryptionKey.getPublicKey();
        int choice = publicKey.getChoice();
        if (choice == 0) {
            byOID = NISTNamedCurves.getByOID(SECObjectIdentifiers.secp256r1);
        } else {
            if (choice != 1) {
                throw new IllegalStateException("unknown key type");
            }
            byOID = TeleTrusTNamedCurves.getByOID(TeleTrusTObjectIdentifiers.brainpoolP256r1);
        }
        if (!(this.encryptionKey.getPublicKey().getBasePublicEncryptionKey() instanceof EccCurvePoint)) {
            throw new IllegalStateException("extension to public verification key not supported");
        }
        EccCurvePoint eccCurvePoint = (EccCurvePoint) publicKey.getBasePublicEncryptionKey();
        AbstractC5817ECCurve curve = byOID.getCurve();
        if (!(eccCurvePoint instanceof EccP256CurvePoint) && !(eccCurvePoint instanceof EccP384CurvePoint)) {
            throw new IllegalStateException("unknown key type");
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = curve.decodePoint(eccCurvePoint.getEncodedPoint()).normalize();
        try {
            return this.f21332helper.createKeyFactory("EC").generatePublic(new ECPublicKeySpec(C5454ECUtil.convertPoint(abstractC5820ECPointNormalize), C5454ECUtil.convertToSpec(byOID)));
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public JceITSPublicEncryptionKey(PublicEncryptionKey publicEncryptionKey, JcaJceHelper jcaJceHelper) {
        super(publicEncryptionKey);
        this.f21332helper = jcaJceHelper;
    }
}
