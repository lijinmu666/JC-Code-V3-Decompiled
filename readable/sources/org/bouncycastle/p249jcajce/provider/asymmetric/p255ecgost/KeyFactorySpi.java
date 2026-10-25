package org.bouncycastle.p249jcajce.provider.asymmetric.p255ecgost;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.KeySpec;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseKeyFactorySpi;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5617EC5Util;
import org.bouncycastle.p281jce.p282spec.ECParameterSpec;
import org.bouncycastle.p281jce.p282spec.ECPrivateKeySpec;
import org.bouncycastle.p281jce.p282spec.ECPublicKeySpec;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;

/* loaded from: classes2.dex */
public class KeyFactorySpi extends BaseKeyFactorySpi {
    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        return keySpec instanceof ECPrivateKeySpec ? new BCECGOST3410PrivateKey((ECPrivateKeySpec) keySpec) : keySpec instanceof java.security.spec.ECPrivateKeySpec ? new BCECGOST3410PrivateKey((java.security.spec.ECPrivateKeySpec) keySpec) : super.engineGeneratePrivate(keySpec);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) {
        return keySpec instanceof ECPublicKeySpec ? new BCECGOST3410PublicKey((ECPublicKeySpec) keySpec, BouncyCastleProvider.CONFIGURATION) : keySpec instanceof java.security.spec.ECPublicKeySpec ? new BCECGOST3410PublicKey((java.security.spec.ECPublicKeySpec) keySpec) : super.engineGeneratePublic(keySpec);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key key, Class cls) {
        if (cls.isAssignableFrom(java.security.spec.ECPublicKeySpec.class) && (key instanceof ECPublicKey)) {
            ECPublicKey eCPublicKey = (ECPublicKey) key;
            if (eCPublicKey.getParams() != null) {
                return new java.security.spec.ECPublicKeySpec(eCPublicKey.getW(), eCPublicKey.getParams());
            }
            ECParameterSpec ecImplicitlyCa = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
            return new java.security.spec.ECPublicKeySpec(eCPublicKey.getW(), C5617EC5Util.convertSpec(C5617EC5Util.convertCurve(ecImplicitlyCa.getCurve(), ecImplicitlyCa.m16272getSeed()), ecImplicitlyCa));
        }
        if (cls.isAssignableFrom(java.security.spec.ECPrivateKeySpec.class) && (key instanceof ECPrivateKey)) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) key;
            if (eCPrivateKey.getParams() != null) {
                return new java.security.spec.ECPrivateKeySpec(eCPrivateKey.getS(), eCPrivateKey.getParams());
            }
            ECParameterSpec ecImplicitlyCa2 = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
            return new java.security.spec.ECPrivateKeySpec(eCPrivateKey.getS(), C5617EC5Util.convertSpec(C5617EC5Util.convertCurve(ecImplicitlyCa2.getCurve(), ecImplicitlyCa2.m16272getSeed()), ecImplicitlyCa2));
        }
        if (cls.isAssignableFrom(ECPublicKeySpec.class) && (key instanceof ECPublicKey)) {
            ECPublicKey eCPublicKey2 = (ECPublicKey) key;
            if (eCPublicKey2.getParams() != null) {
                return new ECPublicKeySpec(C5617EC5Util.convertPoint(eCPublicKey2.getParams(), eCPublicKey2.getW()), C5617EC5Util.convertSpec(eCPublicKey2.getParams()));
            }
            return new ECPublicKeySpec(C5617EC5Util.convertPoint(eCPublicKey2.getParams(), eCPublicKey2.getW()), BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa());
        }
        if (!cls.isAssignableFrom(ECPrivateKeySpec.class) || !(key instanceof ECPrivateKey)) {
            return super.engineGetKeySpec(key, cls);
        }
        ECPrivateKey eCPrivateKey2 = (ECPrivateKey) key;
        if (eCPrivateKey2.getParams() != null) {
            return new ECPrivateKeySpec(eCPrivateKey2.getS(), C5617EC5Util.convertSpec(eCPrivateKey2.getParams()));
        }
        return new ECPrivateKeySpec(eCPrivateKey2.getS(), BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa());
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        throw new InvalidKeyException("key type unknown");
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier algorithm = privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
        if (!algorithm.m14446equals((ASN1Primitive) CryptoProObjectIdentifiers.gostR3410_2001) && !algorithm.m14446equals((ASN1Primitive) CryptoProObjectIdentifiers.gostR3410_2001DH) && !algorithm.m14446equals((ASN1Primitive) CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_ESDH)) {
            throw new IOException("algorithm identifier " + algorithm + " in key not recognised");
        }
        return new BCECGOST3410PrivateKey(privateKeyInfo);
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
        if (!algorithm.m14446equals((ASN1Primitive) CryptoProObjectIdentifiers.gostR3410_2001) && !algorithm.m14446equals((ASN1Primitive) CryptoProObjectIdentifiers.gostR3410_2001DH) && !algorithm.m14446equals((ASN1Primitive) CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_ESDH)) {
            throw new IOException("algorithm identifier " + algorithm + " in key not recognised");
        }
        return new BCECGOST3410PublicKey(subjectPublicKeyInfo);
    }
}
