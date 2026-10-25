package org.bouncycastle.p314pqc.p334jcajce.provider.p339hqc;

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
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p314pqc.p334jcajce.provider.p349util.BaseKeyFactorySpi;

/* loaded from: classes2.dex */
public class HQCKeyFactorySpi extends BaseKeyFactorySpi {

    /* renamed from: keyOids */
    private static final Set<ASN1ObjectIdentifier> f23754keyOids;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyFactorySpi$HQC128 */
    public static class C6178HQC128 extends HQCKeyFactorySpi {
        public C6178HQC128() {
            super(BCObjectIdentifiers.f18023hqc128);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyFactorySpi$HQC192 */
    public static class C6179HQC192 extends HQCKeyFactorySpi {
        public C6179HQC192() {
            super(BCObjectIdentifiers.f18024hqc192);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyFactorySpi$HQC256 */
    public static class C6180HQC256 extends HQCKeyFactorySpi {
        public C6180HQC256() {
            super(BCObjectIdentifiers.f18025hqc256);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f23754keyOids = hashSet;
        hashSet.add(BCObjectIdentifiers.f18023hqc128);
        hashSet.add(BCObjectIdentifiers.f18024hqc192);
        hashSet.add(BCObjectIdentifiers.f18025hqc256);
    }

    public HQCKeyFactorySpi() {
        super(f23754keyOids);
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return generatePrivate(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        }
        throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.provider.p349util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                return generatePublic(SubjectPublicKeyInfo.getInstance(((X509EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        }
        throw new InvalidKeySpecException("Unknown key specification: " + keySpec + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof BCHQCPrivateKey) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
        } else {
            if (!(key instanceof BCHQCPublicKey)) {
                throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + ".");
            }
            if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new X509EncodedKeySpec(key.getEncoded());
            }
        }
        throw new InvalidKeySpecException("Unknown key specification: " + cls + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        if ((key instanceof BCHQCPrivateKey) || (key instanceof BCHQCPublicKey)) {
            return key;
        }
        throw new InvalidKeyException("Unsupported key type");
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) {
        return new BCHQCPrivateKey(privateKeyInfo);
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return new BCHQCPublicKey(subjectPublicKeyInfo);
    }

    public HQCKeyFactorySpi(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        super(aSN1ObjectIdentifier);
    }
}
