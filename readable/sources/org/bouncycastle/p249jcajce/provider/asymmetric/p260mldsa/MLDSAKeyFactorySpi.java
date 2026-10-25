package org.bouncycastle.p249jcajce.provider.asymmetric.p260mldsa;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.p213params.MLDSAParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAPublicKeyParameters;
import org.bouncycastle.p249jcajce.p279spec.MLDSAPrivateKeySpec;
import org.bouncycastle.p249jcajce.p279spec.MLDSAPublicKeySpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BasePQCKeyFactorySpi;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class MLDSAKeyFactorySpi extends BasePQCKeyFactorySpi {
    private static final Set<ASN1ObjectIdentifier> hashKeyOids;
    private static final Set<ASN1ObjectIdentifier> pureKeyOids;
    private final boolean isHashOnly;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.MLDSAKeyFactorySpi$Hash */
    public static class C5576Hash extends MLDSAKeyFactorySpi {
        public C5576Hash() {
            super((Set<ASN1ObjectIdentifier>) MLDSAKeyFactorySpi.hashKeyOids);
        }
    }

    public static class HashMLDSA44 extends MLDSAKeyFactorySpi {
        public HashMLDSA44() {
            super(NISTObjectIdentifiers.id_hash_ml_dsa_44_with_sha512);
        }
    }

    public static class HashMLDSA65 extends MLDSAKeyFactorySpi {
        public HashMLDSA65() {
            super(NISTObjectIdentifiers.id_hash_ml_dsa_65_with_sha512);
        }
    }

    public static class HashMLDSA87 extends MLDSAKeyFactorySpi {
        public HashMLDSA87() {
            super(NISTObjectIdentifiers.id_hash_ml_dsa_87_with_sha512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.MLDSAKeyFactorySpi$MLDSA44 */
    public static class C5577MLDSA44 extends MLDSAKeyFactorySpi {
        public C5577MLDSA44() {
            super(NISTObjectIdentifiers.id_ml_dsa_44);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.MLDSAKeyFactorySpi$MLDSA65 */
    public static class C5578MLDSA65 extends MLDSAKeyFactorySpi {
        public C5578MLDSA65() {
            super(NISTObjectIdentifiers.id_ml_dsa_65);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.MLDSAKeyFactorySpi$MLDSA87 */
    public static class C5579MLDSA87 extends MLDSAKeyFactorySpi {
        public C5579MLDSA87() {
            super(NISTObjectIdentifiers.id_ml_dsa_87);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.MLDSAKeyFactorySpi$Pure */
    public static class C5580Pure extends MLDSAKeyFactorySpi {
        public C5580Pure() {
            super((Set<ASN1ObjectIdentifier>) MLDSAKeyFactorySpi.pureKeyOids);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        pureKeyOids = hashSet;
        HashSet hashSet2 = new HashSet();
        hashKeyOids = hashSet2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_ml_dsa_44;
        hashSet.add(aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_ml_dsa_65;
        hashSet.add(aSN1ObjectIdentifier2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_ml_dsa_87;
        hashSet.add(aSN1ObjectIdentifier3);
        hashSet2.add(aSN1ObjectIdentifier);
        hashSet2.add(aSN1ObjectIdentifier2);
        hashSet2.add(aSN1ObjectIdentifier3);
        hashSet2.add(NISTObjectIdentifiers.id_hash_ml_dsa_44_with_sha512);
        hashSet2.add(NISTObjectIdentifiers.id_hash_ml_dsa_65_with_sha512);
        hashSet2.add(NISTObjectIdentifiers.id_hash_ml_dsa_87_with_sha512);
    }

    public MLDSAKeyFactorySpi(Set<ASN1ObjectIdentifier> set) {
        super(set);
        this.isHashOnly = false;
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BasePQCKeyFactorySpi, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        MLDSAPrivateKeyParameters mLDSAPrivateKeyParameters;
        if (!(keySpec instanceof MLDSAPrivateKeySpec)) {
            return super.engineGeneratePrivate(keySpec);
        }
        MLDSAPrivateKeySpec mLDSAPrivateKeySpec = (MLDSAPrivateKeySpec) keySpec;
        MLDSAParameters parameters = C5590Utils.getParameters(mLDSAPrivateKeySpec.getParameterSpec().m16205getName());
        if (mLDSAPrivateKeySpec.m16207isSeed()) {
            mLDSAPrivateKeyParameters = new MLDSAPrivateKeyParameters(parameters, mLDSAPrivateKeySpec.m16206getSeed());
        } else {
            mLDSAPrivateKeyParameters = new MLDSAPrivateKeyParameters(parameters, mLDSAPrivateKeySpec.getPrivateData(), null);
            byte[] publicData = mLDSAPrivateKeySpec.getPublicData();
            if (publicData != null && !C6238Arrays.constantTimeAreEqual(publicData, mLDSAPrivateKeyParameters.getPublicKey())) {
                throw new InvalidKeySpecException("public key data does not match private key data");
            }
        }
        return new BCMLDSAPrivateKey(mLDSAPrivateKeyParameters);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BasePQCKeyFactorySpi, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (!(keySpec instanceof MLDSAPublicKeySpec)) {
            return super.engineGeneratePublic(keySpec);
        }
        MLDSAPublicKeySpec mLDSAPublicKeySpec = (MLDSAPublicKeySpec) keySpec;
        return new BCMLDSAPublicKey(new MLDSAPublicKeyParameters(C5590Utils.getParameters(mLDSAPublicKeySpec.getParameterSpec().m16205getName()), mLDSAPublicKeySpec.getPublicData()));
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof BCMLDSAPrivateKey) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
            if (MLDSAPrivateKeySpec.class.isAssignableFrom(cls)) {
                BCMLDSAPrivateKey bCMLDSAPrivateKey = (BCMLDSAPrivateKey) key;
                byte[] bArrMo16063getSeed = bCMLDSAPrivateKey.mo16063getSeed();
                return bArrMo16063getSeed != null ? new MLDSAPrivateKeySpec(bCMLDSAPrivateKey.getParameterSpec(), bArrMo16063getSeed) : new MLDSAPrivateKeySpec(bCMLDSAPrivateKey.getParameterSpec(), bCMLDSAPrivateKey.getPrivateData(), bCMLDSAPrivateKey.getPublicKey().getPublicData());
            }
            if (MLDSAPublicKeySpec.class.isAssignableFrom(cls)) {
                BCMLDSAPrivateKey bCMLDSAPrivateKey2 = (BCMLDSAPrivateKey) key;
                return new MLDSAPublicKeySpec(bCMLDSAPrivateKey2.getParameterSpec(), bCMLDSAPrivateKey2.getPublicKey().getPublicData());
            }
        } else {
            if (!(key instanceof BCMLDSAPublicKey)) {
                throw new InvalidKeySpecException("unsupported key type: " + key.getClass() + ".");
            }
            if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new X509EncodedKeySpec(key.getEncoded());
            }
            if (MLDSAPublicKeySpec.class.isAssignableFrom(cls)) {
                BCMLDSAPublicKey bCMLDSAPublicKey = (BCMLDSAPublicKey) key;
                return new MLDSAPublicKeySpec(bCMLDSAPublicKey.getParameterSpec(), bCMLDSAPublicKey.getPublicData());
            }
        }
        throw new InvalidKeySpecException("unknown key specification: " + cls + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        if ((key instanceof BCMLDSAPrivateKey) || (key instanceof BCMLDSAPublicKey)) {
            return key;
        }
        throw new InvalidKeyException("unsupported key type");
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) {
        MLDSAParameters mLDSAParameters;
        BCMLDSAPrivateKey bCMLDSAPrivateKey = new BCMLDSAPrivateKey(privateKeyInfo);
        if (!this.isHashOnly || bCMLDSAPrivateKey.getAlgorithm().indexOf("WITH") > 0) {
            return bCMLDSAPrivateKey;
        }
        MLDSAPrivateKeyParameters keyParams = bCMLDSAPrivateKey.getKeyParams();
        if (keyParams.getParameters().equals(MLDSAParameters.ml_dsa_44)) {
            mLDSAParameters = MLDSAParameters.ml_dsa_44_with_sha512;
        } else if (keyParams.getParameters().equals(MLDSAParameters.ml_dsa_65)) {
            mLDSAParameters = MLDSAParameters.ml_dsa_65_with_sha512;
        } else {
            if (!keyParams.getParameters().equals(MLDSAParameters.ml_dsa_87)) {
                throw new IllegalStateException("unknown ML-DSA parameters");
            }
            mLDSAParameters = MLDSAParameters.ml_dsa_87_with_sha512;
        }
        return new BCMLDSAPrivateKey(new MLDSAPrivateKeyParameters(mLDSAParameters, keyParams.m15780getRho(), keyParams.m15779getK(), keyParams.m15786getTr(), keyParams.m15781getS1(), keyParams.m15782getS2(), keyParams.m15784getT0(), keyParams.m15785getT1(), keyParams.m15783getSeed()));
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return new BCMLDSAPublicKey(subjectPublicKeyInfo);
    }

    public MLDSAKeyFactorySpi(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        super(aSN1ObjectIdentifier);
        this.isHashOnly = aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_hash_ml_dsa_44_with_sha512) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_hash_ml_dsa_65_with_sha512) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_hash_ml_dsa_87_with_sha512);
    }
}
