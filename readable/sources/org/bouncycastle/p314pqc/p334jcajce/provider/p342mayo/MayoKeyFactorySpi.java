package org.bouncycastle.p314pqc.p334jcajce.provider.p342mayo;

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
public class MayoKeyFactorySpi extends BaseKeyFactorySpi {

    /* renamed from: keyOids */
    private static final Set<ASN1ObjectIdentifier> f23780keyOids;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyFactorySpi$Mayo1 */
    public static class C6189Mayo1 extends MayoKeyFactorySpi {
        public C6189Mayo1() {
            super(BCObjectIdentifiers.f18027mayo1);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyFactorySpi$Mayo2 */
    public static class C6190Mayo2 extends MayoKeyFactorySpi {
        public C6190Mayo2() {
            super(BCObjectIdentifiers.f18028mayo2);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyFactorySpi$Mayo3 */
    public static class C6191Mayo3 extends MayoKeyFactorySpi {
        public C6191Mayo3() {
            super(BCObjectIdentifiers.f18029mayo3);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyFactorySpi$Mayo5 */
    public static class C6192Mayo5 extends MayoKeyFactorySpi {
        public C6192Mayo5() {
            super(BCObjectIdentifiers.f18030mayo5);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f23780keyOids = hashSet;
        hashSet.add(BCObjectIdentifiers.f18027mayo1);
        hashSet.add(BCObjectIdentifiers.f18028mayo2);
        hashSet.add(BCObjectIdentifiers.f18029mayo3);
        hashSet.add(BCObjectIdentifiers.f18030mayo5);
    }

    public MayoKeyFactorySpi() {
        super(f23780keyOids);
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof BCMayoPrivateKey) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
        } else {
            if (!(key instanceof BCMayoPublicKey)) {
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
        if ((key instanceof BCMayoPrivateKey) || (key instanceof BCMayoPublicKey)) {
            return key;
        }
        throw new InvalidKeyException("Unsupported key type");
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) {
        return new BCMayoPrivateKey(privateKeyInfo);
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return new BCMayoPublicKey(subjectPublicKeyInfo);
    }

    public MayoKeyFactorySpi(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        super(aSN1ObjectIdentifier);
    }
}
