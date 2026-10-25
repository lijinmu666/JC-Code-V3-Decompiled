package org.bouncycastle.p249jcajce.provider.asymmetric.p256edec;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.internal.p231asn1.p235edec.EdECObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.Ed25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.Ed25519PublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.Ed448PublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519PublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.X448PublicKeyParameters;
import org.bouncycastle.p194crypto.p221util.OpenSSHPrivateKeyUtil;
import org.bouncycastle.p194crypto.p221util.OpenSSHPublicKeyUtil;
import org.bouncycastle.p249jcajce.interfaces.EdDSAPublicKey;
import org.bouncycastle.p249jcajce.interfaces.XDHPublicKey;
import org.bouncycastle.p249jcajce.p279spec.EdDSAParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.OpenSSHPrivateKeySpec;
import org.bouncycastle.p249jcajce.p279spec.OpenSSHPublicKeySpec;
import org.bouncycastle.p249jcajce.p279spec.RawEncodedKeySpec;
import org.bouncycastle.p249jcajce.p279spec.XDHParameterSpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseKeyFactorySpi;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class KeyFactorySpi extends BaseKeyFactorySpi implements AsymmetricKeyInfoConverter {
    private static final byte Ed25519_type = 112;
    private static final byte Ed448_type = 113;
    private static final byte x25519_type = 110;
    private static final byte x448_type = 111;
    String algorithm;

    /* renamed from: isXdh */
    private final boolean f21545isXdh;
    private final int specificBase;
    static final byte[] x448Prefix = C6255Hex.m18338decode("3042300506032b656f033900");
    static final byte[] x25519Prefix = C6255Hex.m18338decode("302a300506032b656e032100");
    static final byte[] Ed448Prefix = C6255Hex.m18338decode("3043300506032b6571033a00");
    static final byte[] Ed25519Prefix = C6255Hex.m18338decode("302a300506032b6570032100");

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$Ed25519 */
    public static class C5556Ed25519 extends KeyFactorySpi {
        public C5556Ed25519() {
            super(EdDSAParameterSpec.f21918Ed25519, false, 112);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$Ed448 */
    public static class C5557Ed448 extends KeyFactorySpi {
        public C5557Ed448() {
            super(EdDSAParameterSpec.f21919Ed448, false, 113);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$EdDSA */
    public static class C5558EdDSA extends KeyFactorySpi {
        public C5558EdDSA() {
            super("EdDSA", false, 0);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$X25519 */
    public static class C5559X25519 extends KeyFactorySpi {
        public C5559X25519() {
            super(XDHParameterSpec.f21951X25519, true, 110);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$X448 */
    public static class C5560X448 extends KeyFactorySpi {
        public C5560X448() {
            super(XDHParameterSpec.f21952X448, true, 111);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$XDH */
    public static class C5561XDH extends KeyFactorySpi {
        public C5561XDH() {
            super("XDH", true, 0);
        }
    }

    public KeyFactorySpi(String str, boolean z, int i) {
        this.algorithm = str;
        this.f21545isXdh = z;
        this.specificBase = i;
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        if (!(keySpec instanceof OpenSSHPrivateKeySpec)) {
            return super.engineGeneratePrivate(keySpec);
        }
        AsymmetricKeyParameter privateKeyBlob = OpenSSHPrivateKeyUtil.parsePrivateKeyBlob(((OpenSSHPrivateKeySpec) keySpec).getEncoded());
        if (privateKeyBlob instanceof Ed25519PrivateKeyParameters) {
            return new BCEdDSAPrivateKey((Ed25519PrivateKeyParameters) privateKeyBlob);
        }
        throw new IllegalStateException("openssh private key not Ed25519 private key");
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509EncodedKeySpec) {
            byte[] encoded = ((X509EncodedKeySpec) keySpec).getEncoded();
            int i = this.specificBase;
            if (i == 0 || i == encoded[8]) {
                if (encoded[9] == 5 && encoded[10] == 0) {
                    SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(encoded);
                    try {
                        encoded = new SubjectPublicKeyInfo(new AlgorithmIdentifier(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), subjectPublicKeyInfo.getPublicKeyData().getBytes()).getEncoded(ASN1Encoding.f17902DER);
                    } catch (IOException e) {
                        throw new InvalidKeySpecException("attempt to reconstruct key failed: " + e.getMessage());
                    }
                }
                switch (encoded[8]) {
                    case 110:
                        return new BCXDHPublicKey(x25519Prefix, encoded);
                    case 111:
                        return new BCXDHPublicKey(x448Prefix, encoded);
                    case 112:
                        return new BCEdDSAPublicKey(Ed25519Prefix, encoded);
                    case 113:
                        return new BCEdDSAPublicKey(Ed448Prefix, encoded);
                    default:
                        return super.engineGeneratePublic(keySpec);
                }
            }
        } else {
            if (keySpec instanceof RawEncodedKeySpec) {
                byte[] encoded2 = ((RawEncodedKeySpec) keySpec).getEncoded();
                switch (this.specificBase) {
                    case 110:
                        return new BCXDHPublicKey(new X25519PublicKeyParameters(encoded2));
                    case 111:
                        return new BCXDHPublicKey(new X448PublicKeyParameters(encoded2));
                    case 112:
                        return new BCEdDSAPublicKey(new Ed25519PublicKeyParameters(encoded2));
                    case 113:
                        return new BCEdDSAPublicKey(new Ed448PublicKeyParameters(encoded2));
                    default:
                        throw new InvalidKeySpecException("factory not a specific type, cannot recognise raw encoding");
                }
            }
            if (keySpec instanceof OpenSSHPublicKeySpec) {
                AsymmetricKeyParameter publicKey = OpenSSHPublicKeyUtil.parsePublicKey(((OpenSSHPublicKeySpec) keySpec).getEncoded());
                if (publicKey instanceof Ed25519PublicKeyParameters) {
                    return new BCEdDSAPublicKey(new byte[0], ((Ed25519PublicKeyParameters) publicKey).getEncoded());
                }
                throw new IllegalStateException("openssh public key not Ed25519 public key");
            }
        }
        return super.engineGeneratePublic(keySpec);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(OpenSSHPrivateKeySpec.class) && (key instanceof BCEdDSAPrivateKey)) {
            try {
                return new OpenSSHPrivateKeySpec(OpenSSHPrivateKeyUtil.encodePrivateKey(new Ed25519PrivateKeyParameters(ASN1OctetString.getInstance(ASN1Primitive.fromByteArray(ASN1OctetString.getInstance(ASN1Sequence.getInstance(key.getEncoded()).getObjectAt(2)).getOctets())).getOctets())));
            } catch (IOException e) {
                throw new InvalidKeySpecException(e.getMessage(), e.getCause());
            }
        }
        if (!cls.isAssignableFrom(OpenSSHPublicKeySpec.class) || !(key instanceof BCEdDSAPublicKey)) {
            if (cls.isAssignableFrom(RawEncodedKeySpec.class)) {
                if (key instanceof XDHPublicKey) {
                    return new RawEncodedKeySpec(((XDHPublicKey) key).getUEncoding());
                }
                if (key instanceof EdDSAPublicKey) {
                    return new RawEncodedKeySpec(((EdDSAPublicKey) key).getPointEncoding());
                }
            }
            return super.engineGetKeySpec(key, cls);
        }
        try {
            byte[] encoded = key.getEncoded();
            byte[] bArr = Ed25519Prefix;
            if (C6238Arrays.areEqual(bArr, 0, bArr.length, encoded, 0, encoded.length - 32)) {
                return new OpenSSHPublicKeySpec(OpenSSHPublicKeyUtil.encodePublicKey(new Ed25519PublicKeyParameters(encoded, bArr.length)));
            }
            throw new InvalidKeySpecException("Invalid Ed25519 public key encoding");
        } catch (IOException e2) {
            throw new InvalidKeySpecException(e2.getMessage(), e2.getCause());
        }
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        throw new InvalidKeyException("key type unknown");
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier algorithm = privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
        if (this.f21545isXdh) {
            int i = this.specificBase;
            if ((i == 0 || i == 111) && algorithm.m14446equals((ASN1Primitive) EdECObjectIdentifiers.f21248id_X448)) {
                return new BCXDHPrivateKey(privateKeyInfo);
            }
            int i2 = this.specificBase;
            if ((i2 == 0 || i2 == 110) && algorithm.m14446equals((ASN1Primitive) EdECObjectIdentifiers.id_X25519)) {
                return new BCXDHPrivateKey(privateKeyInfo);
            }
        } else {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = EdECObjectIdentifiers.id_Ed448;
            if (algorithm.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) || algorithm.m14446equals((ASN1Primitive) EdECObjectIdentifiers.id_Ed25519)) {
                int i3 = this.specificBase;
                if ((i3 == 0 || i3 == 113) && algorithm.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                    return new BCEdDSAPrivateKey(privateKeyInfo);
                }
                int i4 = this.specificBase;
                if ((i4 == 0 || i4 == 112) && algorithm.m14446equals((ASN1Primitive) EdECObjectIdentifiers.id_Ed25519)) {
                    return new BCEdDSAPrivateKey(privateKeyInfo);
                }
            }
        }
        throw new IOException("algorithm identifier " + algorithm + " in key not recognized");
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
        if (this.f21545isXdh) {
            int i = this.specificBase;
            if ((i == 0 || i == 111) && algorithm.m14446equals((ASN1Primitive) EdECObjectIdentifiers.f21248id_X448)) {
                return new BCXDHPublicKey(subjectPublicKeyInfo);
            }
            int i2 = this.specificBase;
            if ((i2 == 0 || i2 == 110) && algorithm.m14446equals((ASN1Primitive) EdECObjectIdentifiers.id_X25519)) {
                return new BCXDHPublicKey(subjectPublicKeyInfo);
            }
        } else {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = EdECObjectIdentifiers.id_Ed448;
            if (algorithm.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) || algorithm.m14446equals((ASN1Primitive) EdECObjectIdentifiers.id_Ed25519)) {
                int i3 = this.specificBase;
                if ((i3 == 0 || i3 == 113) && algorithm.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                    return new BCEdDSAPublicKey(subjectPublicKeyInfo);
                }
                int i4 = this.specificBase;
                if ((i4 == 0 || i4 == 112) && algorithm.m14446equals((ASN1Primitive) EdECObjectIdentifiers.id_Ed25519)) {
                    return new BCEdDSAPublicKey(subjectPublicKeyInfo);
                }
            }
        }
        throw new IOException("algorithm identifier " + algorithm + " in key not recognized");
    }
}
