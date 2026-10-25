package org.bouncycastle.p314pqc.p334jcajce.provider.p337falcon;

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
public class FalconKeyFactorySpi extends BaseKeyFactorySpi {

    /* renamed from: keyOids */
    private static final Set<ASN1ObjectIdentifier> f23733keyOids;

    public static class Falcon1024 extends FalconKeyFactorySpi {
        public Falcon1024() {
            super(BCObjectIdentifiers.falcon_1024);
        }
    }

    public static class Falcon512 extends FalconKeyFactorySpi {
        public Falcon512() {
            super(BCObjectIdentifiers.falcon_512);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f23733keyOids = hashSet;
        hashSet.add(BCObjectIdentifiers.falcon_512);
        hashSet.add(BCObjectIdentifiers.falcon_1024);
    }

    public FalconKeyFactorySpi() {
        super(f23733keyOids);
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof BCFalconPrivateKey) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
        } else {
            if (!(key instanceof BCFalconPublicKey)) {
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
        if ((key instanceof BCFalconPrivateKey) || (key instanceof BCFalconPublicKey)) {
            return key;
        }
        throw new InvalidKeyException("Unsupported key type");
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) {
        return new BCFalconPrivateKey(privateKeyInfo);
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return new BCFalconPublicKey(subjectPublicKeyInfo);
    }

    public FalconKeyFactorySpi(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        super(aSN1ObjectIdentifier);
    }
}
