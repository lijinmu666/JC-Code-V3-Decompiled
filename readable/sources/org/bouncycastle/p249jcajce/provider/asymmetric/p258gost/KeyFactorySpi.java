package org.bouncycastle.p249jcajce.provider.asymmetric.p258gost;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseKeyFactorySpi;
import org.bouncycastle.p281jce.interfaces.GOST3410PrivateKey;
import org.bouncycastle.p281jce.interfaces.GOST3410PublicKey;
import org.bouncycastle.p281jce.p282spec.GOST3410PrivateKeySpec;
import org.bouncycastle.p281jce.p282spec.GOST3410PublicKeyParameterSetSpec;
import org.bouncycastle.p281jce.p282spec.GOST3410PublicKeySpec;

/* loaded from: classes2.dex */
public class KeyFactorySpi extends BaseKeyFactorySpi {
    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        return keySpec instanceof GOST3410PrivateKeySpec ? new BCGOST3410PrivateKey((GOST3410PrivateKeySpec) keySpec) : super.engineGeneratePrivate(keySpec);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) {
        return keySpec instanceof GOST3410PublicKeySpec ? new BCGOST3410PublicKey((GOST3410PublicKeySpec) keySpec) : super.engineGeneratePublic(keySpec);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key key, Class cls) {
        if (cls.isAssignableFrom(GOST3410PublicKeySpec.class) && (key instanceof GOST3410PublicKey)) {
            GOST3410PublicKey gOST3410PublicKey = (GOST3410PublicKey) key;
            GOST3410PublicKeyParameterSetSpec publicKeyParameters = gOST3410PublicKey.getParameters().getPublicKeyParameters();
            return new GOST3410PublicKeySpec(gOST3410PublicKey.mo16117getY(), publicKeyParameters.m16286getP(), publicKeyParameters.m16287getQ(), publicKeyParameters.m16285getA());
        }
        if (!cls.isAssignableFrom(GOST3410PrivateKeySpec.class) || !(key instanceof GOST3410PrivateKey)) {
            return super.engineGetKeySpec(key, cls);
        }
        GOST3410PrivateKey gOST3410PrivateKey = (GOST3410PrivateKey) key;
        GOST3410PublicKeyParameterSetSpec publicKeyParameters2 = gOST3410PrivateKey.getParameters().getPublicKeyParameters();
        return new GOST3410PrivateKeySpec(gOST3410PrivateKey.mo16115getX(), publicKeyParameters2.m16286getP(), publicKeyParameters2.m16287getQ(), publicKeyParameters2.m16285getA());
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key instanceof GOST3410PublicKey) {
            return new BCGOST3410PublicKey((GOST3410PublicKey) key);
        }
        if (key instanceof GOST3410PrivateKey) {
            return new BCGOST3410PrivateKey((GOST3410PrivateKey) key);
        }
        throw new InvalidKeyException("key type unknown");
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier algorithm = privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
        if (algorithm.m14446equals((ASN1Primitive) CryptoProObjectIdentifiers.gostR3410_94)) {
            return new BCGOST3410PrivateKey(privateKeyInfo);
        }
        throw new IOException("algorithm identifier " + algorithm + " in key not recognised");
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
        if (algorithm.m14446equals((ASN1Primitive) CryptoProObjectIdentifiers.gostR3410_94)) {
            return new BCGOST3410PublicKey(subjectPublicKeyInfo);
        }
        throw new IOException("algorithm identifier " + algorithm + " in key not recognised");
    }
}
