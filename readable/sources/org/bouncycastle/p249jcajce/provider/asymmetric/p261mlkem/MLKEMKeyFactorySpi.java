package org.bouncycastle.p249jcajce.provider.asymmetric.p261mlkem;

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
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.p213params.MLKEMParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPublicKeyParameters;
import org.bouncycastle.p249jcajce.p279spec.MLKEMPrivateKeySpec;
import org.bouncycastle.p249jcajce.p279spec.MLKEMPublicKeySpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BasePQCKeyFactorySpi;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class MLKEMKeyFactorySpi extends BasePQCKeyFactorySpi {

    /* renamed from: keyOids */
    private static final Set<ASN1ObjectIdentifier> f21585keyOids;

    public static class MLKEM1024 extends MLKEMKeyFactorySpi {
        public MLKEM1024() {
            super(NISTObjectIdentifiers.id_alg_ml_kem_1024);
        }
    }

    public static class MLKEM512 extends MLKEMKeyFactorySpi {
        public MLKEM512() {
            super(NISTObjectIdentifiers.id_alg_ml_kem_512);
        }
    }

    public static class MLKEM768 extends MLKEMKeyFactorySpi {
        public MLKEM768() {
            super(NISTObjectIdentifiers.id_alg_ml_kem_768);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f21585keyOids = hashSet;
        hashSet.add(NISTObjectIdentifiers.id_alg_ml_kem_512);
        hashSet.add(NISTObjectIdentifiers.id_alg_ml_kem_768);
        hashSet.add(NISTObjectIdentifiers.id_alg_ml_kem_1024);
    }

    public MLKEMKeyFactorySpi() {
        super(f21585keyOids);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BasePQCKeyFactorySpi, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters;
        if (!(keySpec instanceof MLKEMPrivateKeySpec)) {
            return super.engineGeneratePrivate(keySpec);
        }
        MLKEMPrivateKeySpec mLKEMPrivateKeySpec = (MLKEMPrivateKeySpec) keySpec;
        MLKEMParameters parameters = C5592Utils.getParameters(mLKEMPrivateKeySpec.getParameterSpec().m16208getName());
        if (mLKEMPrivateKeySpec.m16210isSeed()) {
            mLKEMPrivateKeyParameters = new MLKEMPrivateKeyParameters(parameters, mLKEMPrivateKeySpec.m16209getSeed());
        } else {
            mLKEMPrivateKeyParameters = new MLKEMPrivateKeyParameters(parameters, mLKEMPrivateKeySpec.getPrivateData());
            byte[] publicData = mLKEMPrivateKeySpec.getPublicData();
            if (publicData != null && !C6238Arrays.constantTimeAreEqual(publicData, mLKEMPrivateKeyParameters.getPublicKey())) {
                throw new InvalidKeySpecException("public key data does not match private key data");
            }
        }
        return new BCMLKEMPrivateKey(mLKEMPrivateKeyParameters);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BasePQCKeyFactorySpi, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (!(keySpec instanceof MLKEMPublicKeySpec)) {
            return super.engineGeneratePublic(keySpec);
        }
        MLKEMPublicKeySpec mLKEMPublicKeySpec = (MLKEMPublicKeySpec) keySpec;
        return new BCMLKEMPublicKey(new MLKEMPublicKeyParameters(C5592Utils.getParameters(mLKEMPublicKeySpec.getParameterSpec().m16208getName()), mLKEMPublicKeySpec.getPublicData()));
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof BCMLKEMPrivateKey) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
            if (MLKEMPrivateKeySpec.class.isAssignableFrom(cls)) {
                BCMLKEMPrivateKey bCMLKEMPrivateKey = (BCMLKEMPrivateKey) key;
                byte[] bArrMo16082getSeed = bCMLKEMPrivateKey.mo16082getSeed();
                return bArrMo16082getSeed != null ? new MLKEMPrivateKeySpec(bCMLKEMPrivateKey.getParameterSpec(), bArrMo16082getSeed) : new MLKEMPrivateKeySpec(bCMLKEMPrivateKey.getParameterSpec(), bCMLKEMPrivateKey.getPrivateData(), bCMLKEMPrivateKey.getPublicKey().getPublicData());
            }
            if (MLKEMPublicKeySpec.class.isAssignableFrom(cls)) {
                BCMLKEMPrivateKey bCMLKEMPrivateKey2 = (BCMLKEMPrivateKey) key;
                return new MLKEMPublicKeySpec(bCMLKEMPrivateKey2.getParameterSpec(), bCMLKEMPrivateKey2.getPublicKey().getPublicData());
            }
        } else {
            if (!(key instanceof BCMLKEMPublicKey)) {
                throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + ".");
            }
            if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new X509EncodedKeySpec(key.getEncoded());
            }
            if (MLKEMPublicKeySpec.class.isAssignableFrom(cls)) {
                BCMLKEMPublicKey bCMLKEMPublicKey = (BCMLKEMPublicKey) key;
                return new MLKEMPublicKeySpec(bCMLKEMPublicKey.getParameterSpec(), bCMLKEMPublicKey.getPublicData());
            }
        }
        throw new InvalidKeySpecException("unknown key specification: " + cls + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        if ((key instanceof BCMLKEMPrivateKey) || (key instanceof BCMLKEMPublicKey)) {
            return key;
        }
        throw new InvalidKeyException("unsupported key type");
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) {
        return new BCMLKEMPrivateKey(privateKeyInfo);
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return new BCMLKEMPublicKey(subjectPublicKeyInfo);
    }

    public MLKEMKeyFactorySpi(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        super(aSN1ObjectIdentifier);
    }
}
