package org.bouncycastle.p249jcajce.provider.asymmetric.compositesignatures;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.bouncycastle.internal.p231asn1.p237iana.IANAObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p249jcajce.CompositePrivateKey;
import org.bouncycastle.p249jcajce.CompositePublicKey;
import org.bouncycastle.p249jcajce.interfaces.InterfaceC5484BCKey;
import org.bouncycastle.p249jcajce.p279spec.CompositeSignatureSpec;
import org.bouncycastle.p249jcajce.p279spec.ContextParameterSpec;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.SpecUtil;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Exceptions;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SignatureSpi extends java.security.SignatureSpi {
    private static final String ML_DSA_44 = "ML-DSA-44";
    private static final String ML_DSA_65 = "ML-DSA-65";
    private static final String ML_DSA_87 = "ML-DSA-87";
    private static final HashMap<ASN1ObjectIdentifier, AlgorithmParameterSpec> algorithmsParameterSpecs;
    private static final Map<String, String> canonicalNames;
    private static final HashMap<ASN1ObjectIdentifier, byte[]> domainSeparators;

    /* renamed from: prefix */
    private static final byte[] f21412prefix = C6255Hex.m18338decode("436f6d706f73697465416c676f726974686d5369676e61747572657332303235");
    private ASN1ObjectIdentifier algorithm;

    /* renamed from: algs */
    private String[] f21413algs;
    private InterfaceC5277Digest baseDigest;
    private Signature[] componentSignatures;
    private Key compositeKey;
    private ContextParameterSpec contextSpec;

    /* renamed from: domain */
    private byte[] f21414domain;
    private AlgorithmParameters engineParams;

    /* renamed from: helper */
    private JcaJceHelper f21415helper;
    private final boolean isPrehash;
    private InterfaceC5277Digest preHashDigest;

    /* renamed from: random */
    private final SecureRandom f21416random;
    private boolean unprimed;

    public static final class COMPOSITE extends SignatureSpi {
        public COMPOSITE() {
            super(null, null, false);
        }
    }

    public static final class ErasableOutputStream extends ByteArrayOutputStream {
        /* renamed from: getBuf */
        public byte[] m16086getBuf() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public static final class MLDSA44_ECDSA_P256_SHA256 extends SignatureSpi {
        public MLDSA44_ECDSA_P256_SHA256() {
            super(IANAObjectIdentifiers.id_MLDSA44_ECDSA_P256_SHA256, new SHA256Digest());
        }
    }

    public static final class MLDSA44_ECDSA_P256_SHA256_PREHASH extends SignatureSpi {
        public MLDSA44_ECDSA_P256_SHA256_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA44_ECDSA_P256_SHA256, new SHA256Digest(), true);
        }
    }

    public static final class MLDSA44_Ed25519_SHA512 extends SignatureSpi {
        public MLDSA44_Ed25519_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA44_Ed25519_SHA512, new SHA512Digest());
        }
    }

    public static final class MLDSA44_Ed25519_SHA512_PREHASH extends SignatureSpi {
        public MLDSA44_Ed25519_SHA512_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA44_Ed25519_SHA512, new SHA512Digest(), true);
        }
    }

    public static final class MLDSA44_RSA2048_PKCS15_SHA256 extends SignatureSpi {
        public MLDSA44_RSA2048_PKCS15_SHA256() {
            super(IANAObjectIdentifiers.id_MLDSA44_RSA2048_PKCS15_SHA256, new SHA256Digest());
        }
    }

    public static final class MLDSA44_RSA2048_PKCS15_SHA256_PREHASH extends SignatureSpi {
        public MLDSA44_RSA2048_PKCS15_SHA256_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA44_RSA2048_PKCS15_SHA256, new SHA256Digest(), true);
        }
    }

    public static final class MLDSA44_RSA2048_PSS_SHA256 extends SignatureSpi {
        public MLDSA44_RSA2048_PSS_SHA256() {
            super(IANAObjectIdentifiers.id_MLDSA44_RSA2048_PSS_SHA256, new SHA256Digest());
        }
    }

    public static final class MLDSA44_RSA2048_PSS_SHA256_PREHASH extends SignatureSpi {
        public MLDSA44_RSA2048_PSS_SHA256_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA44_RSA2048_PSS_SHA256, new SHA256Digest(), true);
        }
    }

    public static final class MLDSA65_ECDSA_P256_SHA512 extends SignatureSpi {
        public MLDSA65_ECDSA_P256_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA65_ECDSA_P256_SHA512, new SHA512Digest());
        }
    }

    public static final class MLDSA65_ECDSA_P256_SHA512_PREHASH extends SignatureSpi {
        public MLDSA65_ECDSA_P256_SHA512_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA65_ECDSA_P256_SHA512, new SHA512Digest(), true);
        }
    }

    public static final class MLDSA65_ECDSA_P384_SHA512 extends SignatureSpi {
        public MLDSA65_ECDSA_P384_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA65_ECDSA_P384_SHA512, new SHA512Digest());
        }
    }

    public static final class MLDSA65_ECDSA_P384_SHA512_PREHASH extends SignatureSpi {
        public MLDSA65_ECDSA_P384_SHA512_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA65_ECDSA_P384_SHA512, new SHA512Digest(), true);
        }
    }

    public static final class MLDSA65_ECDSA_brainpoolP256r1_SHA512 extends SignatureSpi {
        public MLDSA65_ECDSA_brainpoolP256r1_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA65_ECDSA_brainpoolP256r1_SHA512, new SHA512Digest());
        }
    }

    public static final class MLDSA65_ECDSA_brainpoolP256r1_SHA512_PREHASH extends SignatureSpi {
        public MLDSA65_ECDSA_brainpoolP256r1_SHA512_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA65_ECDSA_brainpoolP256r1_SHA512, new SHA512Digest(), true);
        }
    }

    public static final class MLDSA65_Ed25519_SHA512 extends SignatureSpi {
        public MLDSA65_Ed25519_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA65_Ed25519_SHA512, new SHA512Digest());
        }
    }

    public static final class MLDSA65_Ed25519_SHA512_PREHASH extends SignatureSpi {
        public MLDSA65_Ed25519_SHA512_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA65_Ed25519_SHA512, new SHA512Digest(), true);
        }
    }

    public static final class MLDSA65_RSA3072_PKCS15_SHA512 extends SignatureSpi {
        public MLDSA65_RSA3072_PKCS15_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA65_RSA3072_PKCS15_SHA512, new SHA512Digest());
        }
    }

    public static final class MLDSA65_RSA3072_PKCS15_SHA512_PREHASH extends SignatureSpi {
        public MLDSA65_RSA3072_PKCS15_SHA512_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA65_RSA3072_PKCS15_SHA512, new SHA512Digest(), true);
        }
    }

    public static final class MLDSA65_RSA3072_PSS_SHA512 extends SignatureSpi {
        public MLDSA65_RSA3072_PSS_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA65_RSA3072_PSS_SHA512, new SHA512Digest());
        }
    }

    public static final class MLDSA65_RSA3072_PSS_SHA512_PREHASH extends SignatureSpi {
        public MLDSA65_RSA3072_PSS_SHA512_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA65_RSA3072_PSS_SHA512, new SHA512Digest(), true);
        }
    }

    public static final class MLDSA65_RSA4096_PKCS15_SHA512 extends SignatureSpi {
        public MLDSA65_RSA4096_PKCS15_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA65_RSA4096_PKCS15_SHA512, new SHA512Digest());
        }
    }

    public static final class MLDSA65_RSA4096_PKCS15_SHA512_PREHASH extends SignatureSpi {
        public MLDSA65_RSA4096_PKCS15_SHA512_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA65_RSA4096_PKCS15_SHA512, new SHA512Digest(), true);
        }
    }

    public static final class MLDSA65_RSA4096_PSS_SHA512 extends SignatureSpi {
        public MLDSA65_RSA4096_PSS_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA65_RSA4096_PSS_SHA512, new SHA512Digest());
        }
    }

    public static final class MLDSA65_RSA4096_PSS_SHA512_PREHASH extends SignatureSpi {
        public MLDSA65_RSA4096_PSS_SHA512_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA65_RSA4096_PSS_SHA512, new SHA512Digest(), true);
        }
    }

    public static final class MLDSA87_ECDSA_P384_SHA512 extends SignatureSpi {
        public MLDSA87_ECDSA_P384_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA87_ECDSA_P384_SHA512, new SHA512Digest());
        }
    }

    public static final class MLDSA87_ECDSA_P384_SHA512_PREHASH extends SignatureSpi {
        public MLDSA87_ECDSA_P384_SHA512_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA87_ECDSA_P384_SHA512, new SHA512Digest(), true);
        }
    }

    public static final class MLDSA87_ECDSA_P521_SHA512 extends SignatureSpi {
        public MLDSA87_ECDSA_P521_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA87_ECDSA_P521_SHA512, new SHA512Digest());
        }
    }

    public static final class MLDSA87_ECDSA_P521_SHA512_PREHASH extends SignatureSpi {
        public MLDSA87_ECDSA_P521_SHA512_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA87_ECDSA_P521_SHA512, new SHA512Digest(), true);
        }
    }

    public static final class MLDSA87_ECDSA_brainpoolP384r1_SHA512 extends SignatureSpi {
        public MLDSA87_ECDSA_brainpoolP384r1_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA87_ECDSA_brainpoolP384r1_SHA512, new SHA512Digest());
        }
    }

    public static final class MLDSA87_ECDSA_brainpoolP384r1_SHA512_PREHASH extends SignatureSpi {
        public MLDSA87_ECDSA_brainpoolP384r1_SHA512_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA87_ECDSA_brainpoolP384r1_SHA512, new SHA512Digest(), true);
        }
    }

    public static final class MLDSA87_Ed448_SHAKE256 extends SignatureSpi {
        public MLDSA87_Ed448_SHAKE256() {
            super(IANAObjectIdentifiers.id_MLDSA87_Ed448_SHAKE256, new SHAKEDigest(256));
        }
    }

    public static final class MLDSA87_Ed448_SHAKE256_PREHASH extends SignatureSpi {
        public MLDSA87_Ed448_SHAKE256_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA87_Ed448_SHAKE256, new SHAKEDigest(256), true);
        }
    }

    public static final class MLDSA87_RSA3072_PSS_SHA512 extends SignatureSpi {
        public MLDSA87_RSA3072_PSS_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA87_RSA3072_PSS_SHA512, new SHA512Digest());
        }
    }

    public static final class MLDSA87_RSA3072_PSS_SHA512_PREHASH extends SignatureSpi {
        public MLDSA87_RSA3072_PSS_SHA512_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA87_RSA3072_PSS_SHA512, new SHA512Digest(), true);
        }
    }

    public static final class MLDSA87_RSA4096_PSS_SHA512 extends SignatureSpi {
        public MLDSA87_RSA4096_PSS_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA87_RSA4096_PSS_SHA512, new SHA512Digest());
        }
    }

    public static final class MLDSA87_RSA4096_PSS_SHA512_PREHASH extends SignatureSpi {
        public MLDSA87_RSA4096_PSS_SHA512_PREHASH() {
            super(IANAObjectIdentifiers.id_MLDSA87_RSA4096_PSS_SHA512, new SHA512Digest(), true);
        }
    }

    public static class NullDigest implements InterfaceC5277Digest {

        /* renamed from: bOut */
        private final OpenByteArrayOutputStream f21417bOut = new OpenByteArrayOutputStream();
        private final int expectedSize;

        public static class OpenByteArrayOutputStream extends ByteArrayOutputStream {
            private OpenByteArrayOutputStream() {
            }

            /* renamed from: copy */
            public void m16087copy(byte[] bArr, int i) {
                System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArr, i, size());
            }

            @Override // java.io.ByteArrayOutputStream
            public void reset() {
                super.reset();
                C6238Arrays.m18227clear(((ByteArrayOutputStream) this).buf);
            }
        }

        public NullDigest(int i) {
            this.expectedSize = i;
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: doFinal */
        public int mo14967doFinal(byte[] bArr, int i) {
            int size = this.f21417bOut.size();
            if (size != this.expectedSize) {
                throw new IllegalStateException("provided pre-hash digest is the wrong length");
            }
            this.f21417bOut.m16087copy(bArr, i);
            mo14968reset();
            return size;
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        public String getAlgorithmName() {
            return "NULL";
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        public int getDigestSize() {
            return this.f21417bOut.size();
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: reset */
        public void mo14968reset() {
            this.f21417bOut.reset();
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: update */
        public void mo14969update(byte b) throws IOException {
            this.f21417bOut.write(b);
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: update */
        public void mo14970update(byte[] bArr, int i, int i2) throws IOException {
            this.f21417bOut.write(bArr, i, i2);
        }
    }

    static {
        HashMap map = new HashMap();
        canonicalNames = map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        domainSeparators = linkedHashMap;
        HashMap<ASN1ObjectIdentifier, AlgorithmParameterSpec> map2 = new HashMap<>();
        algorithmsParameterSpecs = map2;
        map.put("MLDSA44", ML_DSA_44);
        map.put("MLDSA65", ML_DSA_65);
        map.put("MLDSA87", ML_DSA_87);
        map.put(NISTObjectIdentifiers.id_ml_dsa_44.m14433getId(), ML_DSA_44);
        map.put(NISTObjectIdentifiers.id_ml_dsa_65.m14433getId(), ML_DSA_65);
        map.put(NISTObjectIdentifiers.id_ml_dsa_87.m14433getId(), ML_DSA_87);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = IANAObjectIdentifiers.id_MLDSA44_RSA2048_PSS_SHA256;
        linkedHashMap.put(aSN1ObjectIdentifier, C6255Hex.m18338decode("434f4d505349472d4d4c44534134342d525341323034382d5053532d534841323536"));
        linkedHashMap.put(IANAObjectIdentifiers.id_MLDSA44_RSA2048_PKCS15_SHA256, C6255Hex.m18338decode("434f4d505349472d4d4c44534134342d525341323034382d504b435331352d534841323536"));
        linkedHashMap.put(IANAObjectIdentifiers.id_MLDSA44_Ed25519_SHA512, C6255Hex.m18338decode("434f4d505349472d4d4c44534134342d456432353531392d534841353132"));
        linkedHashMap.put(IANAObjectIdentifiers.id_MLDSA44_ECDSA_P256_SHA256, C6255Hex.m18338decode("434f4d505349472d4d4c44534134342d45434453412d503235362d534841323536"));
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = IANAObjectIdentifiers.id_MLDSA65_RSA3072_PSS_SHA512;
        linkedHashMap.put(aSN1ObjectIdentifier2, C6255Hex.m18338decode("434f4d505349472d4d4c44534136352d525341333037322d5053532d534841353132"));
        linkedHashMap.put(IANAObjectIdentifiers.id_MLDSA65_RSA3072_PKCS15_SHA512, C6255Hex.m18338decode("434f4d505349472d4d4c44534136352d525341333037322d504b435331352d534841353132"));
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = IANAObjectIdentifiers.id_MLDSA65_RSA4096_PSS_SHA512;
        linkedHashMap.put(aSN1ObjectIdentifier3, C6255Hex.m18338decode("434f4d505349472d4d4c44534136352d525341343039362d5053532d534841353132"));
        linkedHashMap.put(IANAObjectIdentifiers.id_MLDSA65_RSA4096_PKCS15_SHA512, C6255Hex.m18338decode("434f4d505349472d4d4c44534136352d525341343039362d504b435331352d534841353132"));
        linkedHashMap.put(IANAObjectIdentifiers.id_MLDSA65_ECDSA_P256_SHA512, C6255Hex.m18338decode("434f4d505349472d4d4c44534136352d45434453412d503235362d534841353132"));
        linkedHashMap.put(IANAObjectIdentifiers.id_MLDSA65_ECDSA_P384_SHA512, C6255Hex.m18338decode("434f4d505349472d4d4c44534136352d45434453412d503338342d534841353132"));
        linkedHashMap.put(IANAObjectIdentifiers.id_MLDSA65_ECDSA_brainpoolP256r1_SHA512, C6255Hex.m18338decode("434f4d505349472d4d4c44534136352d45434453412d42503235362d534841353132"));
        linkedHashMap.put(IANAObjectIdentifiers.id_MLDSA65_Ed25519_SHA512, C6255Hex.m18338decode("434f4d505349472d4d4c44534136352d456432353531392d534841353132"));
        linkedHashMap.put(IANAObjectIdentifiers.id_MLDSA87_ECDSA_brainpoolP384r1_SHA512, C6255Hex.m18338decode("434f4d505349472d4d4c44534138372d45434453412d42503338342d534841353132"));
        linkedHashMap.put(IANAObjectIdentifiers.id_MLDSA87_Ed448_SHAKE256, C6255Hex.m18338decode("434f4d505349472d4d4c44534138372d45643434382d5348414b45323536"));
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = IANAObjectIdentifiers.id_MLDSA87_RSA3072_PSS_SHA512;
        linkedHashMap.put(aSN1ObjectIdentifier4, C6255Hex.m18338decode("434f4d505349472d4d4c44534138372d525341333037322d5053532d534841353132"));
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = IANAObjectIdentifiers.id_MLDSA87_RSA4096_PSS_SHA512;
        linkedHashMap.put(aSN1ObjectIdentifier5, C6255Hex.m18338decode("434f4d505349472d4d4c44534138372d525341343039362d5053532d534841353132"));
        linkedHashMap.put(IANAObjectIdentifiers.id_MLDSA87_ECDSA_P384_SHA512, C6255Hex.m18338decode("434f4d505349472d4d4c44534138372d45434453412d503338342d534841353132"));
        linkedHashMap.put(IANAObjectIdentifiers.id_MLDSA87_ECDSA_P521_SHA512, C6255Hex.m18338decode("434f4d505349472d4d4c44534138372d45434453412d503532312d534841353132"));
        map2.put(aSN1ObjectIdentifier, new PSSParameterSpec(XMSSKeyParameters.f23621SHA_256, "MGF1", new MGF1ParameterSpec(XMSSKeyParameters.f23621SHA_256), 32, 1));
        map2.put(aSN1ObjectIdentifier2, new PSSParameterSpec(XMSSKeyParameters.f23621SHA_256, "MGF1", new MGF1ParameterSpec(XMSSKeyParameters.f23621SHA_256), 32, 1));
        map2.put(aSN1ObjectIdentifier3, new PSSParameterSpec("SHA-384", "MGF1", new MGF1ParameterSpec("SHA-384"), 48, 1));
        map2.put(aSN1ObjectIdentifier5, new PSSParameterSpec("SHA-384", "MGF1", new MGF1ParameterSpec("SHA-384"), 48, 1));
        map2.put(aSN1ObjectIdentifier4, new PSSParameterSpec(XMSSKeyParameters.f23621SHA_256, "MGF1", new MGF1ParameterSpec(XMSSKeyParameters.f23621SHA_256), 32, 1));
    }

    public SignatureSpi(ASN1ObjectIdentifier aSN1ObjectIdentifier, InterfaceC5277Digest interfaceC5277Digest) {
        this(aSN1ObjectIdentifier, interfaceC5277Digest, false);
    }

    private void baseSigInit() throws InvalidAlgorithmParameterException {
        try {
            this.componentSignatures[0].setParameter(new ContextParameterSpec(this.f21414domain));
            AlgorithmParameterSpec algorithmParameterSpec = algorithmsParameterSpecs.get(this.algorithm);
            if (algorithmParameterSpec != null) {
                this.componentSignatures[1].setParameter(algorithmParameterSpec);
            }
            this.unprimed = false;
        } catch (InvalidAlgorithmParameterException unused) {
            throw new IllegalStateException("unable to set context on ML-DSA");
        }
    }

    private void createComponentSignatures(List list, List<Provider> list2) {
        int i = 0;
        try {
            if (list2 != null) {
                while (i != this.componentSignatures.length) {
                    if (list2.get(i) == null) {
                        this.componentSignatures[i] = getDefaultSignature(this.f21413algs[i], list.get(i));
                    } else {
                        this.componentSignatures[i] = Signature.getInstance(this.f21413algs[i], list2.get(i));
                    }
                    i++;
                }
                return;
            }
            while (true) {
                Signature[] signatureArr = this.componentSignatures;
                if (i == signatureArr.length) {
                    return;
                }
                signatureArr[i] = getDefaultSignature(this.f21413algs[i], list.get(i));
                i++;
            }
        } catch (GeneralSecurityException e) {
            throw Exceptions.illegalStateException(e.getMessage(), e);
        }
    }

    private String getCanonicalName(String str) {
        String str2 = canonicalNames.get(str);
        return str2 != null ? str2 : str;
    }

    private Signature getDefaultSignature(String str, Object obj) {
        return obj instanceof InterfaceC5484BCKey ? this.f21415helper.createSignature(str) : Signature.getInstance(str);
    }

    private void processPreHashedMessage(byte[] bArr) throws SignatureException {
        int digestSize = this.baseDigest.getDigestSize();
        byte[] bArr2 = new byte[digestSize];
        try {
            this.preHashDigest.mo14967doFinal(bArr2, 0);
            int i = 0;
            while (true) {
                Signature[] signatureArr = this.componentSignatures;
                if (i >= signatureArr.length) {
                    return;
                }
                Signature signature = signatureArr[i];
                signature.update(f21412prefix);
                signature.update(this.f21414domain);
                ContextParameterSpec contextParameterSpec = this.contextSpec;
                if (contextParameterSpec == null) {
                    signature.update((byte) 0);
                } else {
                    byte[] context = contextParameterSpec.getContext();
                    signature.update((byte) context.length);
                    signature.update(context);
                }
                if (bArr != null) {
                    signature.update(bArr, 0, bArr.length);
                }
                signature.update(bArr2, 0, digestSize);
                i++;
            }
        } catch (IllegalStateException e) {
            throw new SignatureException(e.getMessage());
        }
    }

    private void sigInitSign() throws InvalidKeyException {
        CompositePrivateKey compositePrivateKey = (CompositePrivateKey) this.compositeKey;
        int i = 0;
        while (true) {
            Signature[] signatureArr = this.componentSignatures;
            if (i >= signatureArr.length) {
                this.unprimed = true;
                return;
            } else {
                signatureArr[i].initSign(compositePrivateKey.getPrivateKeys().get(i));
                i++;
            }
        }
    }

    private void sigInitVerify() throws InvalidKeyException {
        CompositePublicKey compositePublicKey = (CompositePublicKey) this.compositeKey;
        int i = 0;
        while (true) {
            Signature[] signatureArr = this.componentSignatures;
            if (i >= signatureArr.length) {
                this.unprimed = true;
                return;
            } else {
                signatureArr[i].initVerify(compositePublicKey.getPublicKeys().get(i));
                i++;
            }
        }
    }

    public static byte[][] splitCompositeSignature(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        int length = bArr.length - i;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        System.arraycopy(bArr, i, bArr3, 0, length);
        return new byte[][]{bArr2, bArr3};
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public final AlgorithmParameters engineGetParameters() throws InvalidParameterSpecException {
        if (this.engineParams == null && this.contextSpec != null) {
            try {
                AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f21415helper.createAlgorithmParameters("CONTEXT");
                this.engineParams = algorithmParametersCreateAlgorithmParameters;
                algorithmParametersCreateAlgorithmParameters.init(this.contextSpec);
            } catch (Exception e) {
                throw Exceptions.illegalStateException(e.toString(), e);
            }
        }
        return this.engineParams;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof CompositePrivateKey)) {
            throw new InvalidKeyException("Private key is not composite.");
        }
        this.compositeKey = privateKey;
        CompositePrivateKey compositePrivateKey = (CompositePrivateKey) privateKey;
        if (this.algorithm == null) {
            ASN1ObjectIdentifier algorithm = compositePrivateKey.getAlgorithmIdentifier().getAlgorithm();
            this.algorithm = algorithm;
            InterfaceC5277Digest digest = CompositeIndex.getDigest(algorithm);
            this.baseDigest = digest;
            if (this.isPrehash) {
                digest = new NullDigest(digest.getDigestSize());
            }
            this.preHashDigest = digest;
            this.f21414domain = domainSeparators.get(algorithm);
            String[] pairing = CompositeIndex.getPairing(algorithm);
            this.f21413algs = pairing;
            this.componentSignatures = new Signature[pairing.length];
        } else if (!compositePrivateKey.getAlgorithmIdentifier().getAlgorithm().m14446equals((ASN1Primitive) this.algorithm)) {
            throw new InvalidKeyException("provided composite public key cannot be used with the composite signature algorithm");
        }
        createComponentSignatures(compositePrivateKey.getPrivateKeys(), compositePrivateKey.getProviders());
        sigInitSign();
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof CompositePublicKey)) {
            throw new InvalidKeyException("public key is not composite");
        }
        this.compositeKey = publicKey;
        CompositePublicKey compositePublicKey = (CompositePublicKey) publicKey;
        if (this.algorithm == null) {
            ASN1ObjectIdentifier algorithm = SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()).getAlgorithm().getAlgorithm();
            this.algorithm = algorithm;
            InterfaceC5277Digest digest = CompositeIndex.getDigest(algorithm);
            this.baseDigest = digest;
            if (this.isPrehash) {
                digest = new NullDigest(digest.getDigestSize());
            }
            this.preHashDigest = digest;
            this.f21414domain = domainSeparators.get(algorithm);
            String[] pairing = CompositeIndex.getPairing(algorithm);
            this.f21413algs = pairing;
            this.componentSignatures = new Signature[pairing.length];
        } else if (!compositePublicKey.getAlgorithmIdentifier().getAlgorithm().m14446equals((ASN1Primitive) this.algorithm)) {
            throw new InvalidKeyException("provided composite public key cannot be used with the composite signature algorithm");
        }
        createComponentSignatures(compositePublicKey.getPublicKeys(), compositePublicKey.getProviders());
        sigInitVerify();
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        this.f21416random.nextBytes(new byte[32]);
        if (this.preHashDigest != null) {
            processPreHashedMessage(null);
        }
        byte[] bArrSign = this.componentSignatures[0].sign();
        byte[] bArrSign2 = this.componentSignatures[1].sign();
        byte[] bArr = new byte[bArrSign.length + bArrSign2.length];
        System.arraycopy(bArrSign, 0, bArr, 0, bArrSign.length);
        System.arraycopy(bArrSign2, 0, bArr, bArrSign.length, bArrSign2.length);
        return bArr;
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) throws SignatureException, InvalidAlgorithmParameterException {
        if (this.unprimed) {
            baseSigInit();
        }
        InterfaceC5277Digest interfaceC5277Digest = this.preHashDigest;
        if (interfaceC5277Digest != null) {
            interfaceC5277Digest.mo14969update(b);
            return;
        }
        int i = 0;
        while (true) {
            Signature[] signatureArr = this.componentSignatures;
            if (i >= signatureArr.length) {
                return;
            }
            signatureArr[i].update(b);
            i++;
        }
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        int i = 0;
        byte[][] bArrSplitCompositeSignature = splitCompositeSignature(bArr, this.f21413algs[0].indexOf("44") > 0 ? 2420 : this.f21413algs[0].indexOf("65") > 0 ? 3309 : this.f21413algs[0].indexOf("87") > 0 ? 4627 : 0);
        if (this.preHashDigest != null) {
            processPreHashedMessage(null);
        }
        boolean z = false;
        while (true) {
            Signature[] signatureArr = this.componentSignatures;
            if (i >= signatureArr.length) {
                return !z;
            }
            if (!signatureArr[i].verify(bArrSplitCompositeSignature[i])) {
                z = true;
            }
            i++;
        }
    }

    public SignatureSpi(ASN1ObjectIdentifier aSN1ObjectIdentifier, InterfaceC5277Digest interfaceC5277Digest, boolean z) {
        this.f21416random = CryptoServicesRegistrar.getSecureRandom();
        this.f21415helper = new BCJcaJceHelper();
        this.engineParams = null;
        this.unprimed = true;
        this.algorithm = aSN1ObjectIdentifier;
        this.isPrehash = z;
        if (aSN1ObjectIdentifier != null) {
            this.baseDigest = interfaceC5277Digest;
            this.preHashDigest = z ? new NullDigest(interfaceC5277Digest.getDigestSize()) : interfaceC5277Digest;
            this.f21414domain = domainSeparators.get(aSN1ObjectIdentifier);
            String[] pairing = CompositeIndex.getPairing(aSN1ObjectIdentifier);
            this.f21413algs = pairing;
            this.componentSignatures = new Signature[pairing.length];
        }
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        if (!this.unprimed) {
            throw new InvalidAlgorithmParameterException("attempt to set parameter after update");
        }
        if (algorithmParameterSpec instanceof ContextParameterSpec) {
            this.contextSpec = (ContextParameterSpec) algorithmParameterSpec;
            try {
                if (this.compositeKey instanceof PublicKey) {
                    sigInitVerify();
                } else {
                    sigInitSign();
                }
                return;
            } catch (InvalidKeyException e) {
                throw new InvalidAlgorithmParameterException("keys invalid on reset: " + e.getMessage(), e);
            }
        }
        if (algorithmParameterSpec instanceof CompositeSignatureSpec) {
            CompositeSignatureSpec compositeSignatureSpec = (CompositeSignatureSpec) algorithmParameterSpec;
            this.preHashDigest = compositeSignatureSpec.isPrehashMode() ? new NullDigest(this.baseDigest.getDigestSize()) : this.baseDigest;
            AlgorithmParameterSpec secondarySpec = compositeSignatureSpec.getSecondarySpec();
            if (secondarySpec == null || (secondarySpec instanceof ContextParameterSpec)) {
                this.contextSpec = (ContextParameterSpec) compositeSignatureSpec.getSecondarySpec();
                return;
            }
            byte[] contextFrom = SpecUtil.getContextFrom(secondarySpec);
            if (contextFrom == null) {
                throw new InvalidAlgorithmParameterException("unknown parameterSpec passed to composite signature");
            }
            this.contextSpec = new ContextParameterSpec(contextFrom);
            return;
        }
        byte[] contextFrom2 = SpecUtil.getContextFrom(algorithmParameterSpec);
        if (contextFrom2 != null) {
            this.contextSpec = new ContextParameterSpec(contextFrom2);
            try {
                if (this.compositeKey instanceof PublicKey) {
                    sigInitVerify();
                } else {
                    sigInitSign();
                }
            } catch (InvalidKeyException e2) {
                throw new InvalidAlgorithmParameterException("keys invalid on reset: " + e2.getMessage(), e2);
            }
        }
        throw new InvalidAlgorithmParameterException("unknown parameterSpec passed to composite signature");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException, InvalidAlgorithmParameterException {
        if (this.unprimed) {
            baseSigInit();
        }
        InterfaceC5277Digest interfaceC5277Digest = this.preHashDigest;
        if (interfaceC5277Digest != null) {
            interfaceC5277Digest.mo14970update(bArr, i, i2);
            return;
        }
        int i3 = 0;
        while (true) {
            Signature[] signatureArr = this.componentSignatures;
            if (i3 >= signatureArr.length) {
                return;
            }
            signatureArr[i3].update(bArr, i, i2);
            i3++;
        }
    }
}
