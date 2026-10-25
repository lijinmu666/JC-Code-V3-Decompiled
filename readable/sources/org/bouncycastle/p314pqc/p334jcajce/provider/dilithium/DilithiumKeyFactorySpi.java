package org.bouncycastle.p314pqc.p334jcajce.provider.dilithium;

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
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p314pqc.p334jcajce.provider.p349util.BaseKeyFactorySpi;

/* loaded from: classes2.dex */
public class DilithiumKeyFactorySpi extends BaseKeyFactorySpi {

    /* renamed from: keyOids */
    private static final Set<ASN1ObjectIdentifier> f23724keyOids;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.dilithium.DilithiumKeyFactorySpi$Base2 */
    public static class C6162Base2 extends DilithiumKeyFactorySpi {
        public C6162Base2() {
            super(BCObjectIdentifiers.dilithium2);
        }
    }

    public static class Base2_AES extends DilithiumKeyFactorySpi {
        public Base2_AES() {
            super(BCObjectIdentifiers.dilithium2_aes);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.dilithium.DilithiumKeyFactorySpi$Base3 */
    public static class C6163Base3 extends DilithiumKeyFactorySpi {
        public C6163Base3() {
            super(BCObjectIdentifiers.dilithium3);
        }
    }

    public static class Base3_AES extends DilithiumKeyFactorySpi {
        public Base3_AES() {
            super(BCObjectIdentifiers.dilithium3_aes);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.dilithium.DilithiumKeyFactorySpi$Base5 */
    public static class C6164Base5 extends DilithiumKeyFactorySpi {
        public C6164Base5() {
            super(BCObjectIdentifiers.dilithium5);
        }
    }

    public static class Base5_AES extends DilithiumKeyFactorySpi {
        public Base5_AES() {
            super(BCObjectIdentifiers.dilithium5_aes);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f23724keyOids = hashSet;
        hashSet.add(BCObjectIdentifiers.dilithium2);
        hashSet.add(BCObjectIdentifiers.dilithium3);
        hashSet.add(BCObjectIdentifiers.dilithium5);
        hashSet.add(BCObjectIdentifiers.dilithium2_aes);
        hashSet.add(BCObjectIdentifiers.dilithium3_aes);
        hashSet.add(BCObjectIdentifiers.dilithium5_aes);
    }

    public DilithiumKeyFactorySpi() {
        super(f23724keyOids);
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof BCDilithiumPrivateKey) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
        } else {
            if (!(key instanceof BCDilithiumPublicKey)) {
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
        if ((key instanceof BCDilithiumPrivateKey) || (key instanceof BCDilithiumPublicKey)) {
            return key;
        }
        throw new InvalidKeyException("Unsupported key type");
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) {
        return new BCDilithiumPrivateKey(privateKeyInfo);
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return new BCDilithiumPublicKey(subjectPublicKeyInfo);
    }

    public DilithiumKeyFactorySpi(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        super(aSN1ObjectIdentifier);
    }
}
