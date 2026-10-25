package org.bouncycastle.p191cms.p193jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.operator.DefaultSecretKeySizeProvider;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCaptureStream;
import org.bouncycastle.operator.OutputAEADEncryptor;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.operator.SecretKeySizeProvider;
import org.bouncycastle.operator.p306jcajce.JceGenericKey;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.GCMParameters;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSAlgorithm;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p213params.HKDFParameters;
import org.bouncycastle.p249jcajce.p250io.CipherOutputStream;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class JceCMSContentEncryptorBuilder {
    private static final SecretKeySizeProvider KEY_SIZE_PROVIDER = DefaultSecretKeySizeProvider.INSTANCE;
    private static final byte[] hkdfSalt = C6250Strings.toByteArray("The Cryptographic Message Syntax");
    private AlgorithmIdentifier algorithmIdentifier;
    private AlgorithmParameters algorithmParameters;
    private final ASN1ObjectIdentifier encryptionOID;

    /* renamed from: helper */
    private EnvelopedDataHelper f19071helper;
    private ASN1ObjectIdentifier kdfAlgorithm;

    /* renamed from: keySize */
    private final int f19072keySize;

    /* renamed from: random */
    private SecureRandom f19073random;

    public class CMSAuthOutputEncryptor extends CMSOutEncryptor implements OutputAEADEncryptor {

        /* renamed from: macOut */
        private MacCaptureStream f19074macOut;

        public CMSAuthOutputEncryptor(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2, SecretKey secretKey, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws CMSException, InvalidKeyException, InvalidAlgorithmParameterException {
            super();
            m14937init(aSN1ObjectIdentifier, aSN1ObjectIdentifier2, secretKey, algorithmParameters, secureRandom);
        }

        @Override // org.bouncycastle.operator.AADProcessor
        public OutputStream getAADStream() {
            if (JceCMSContentEncryptorBuilder.checkForAEAD()) {
                return new JceAADStream(this.f19076cipher);
            }
            return null;
        }

        @Override // org.bouncycastle.operator.OutputEncryptor
        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return this.algorithmIdentifier;
        }

        @Override // org.bouncycastle.operator.OutputEncryptor
        /* renamed from: getKey */
        public GenericKey mo14795getKey() {
            return new JceGenericKey(this.algorithmIdentifier, this.f19077encKey);
        }

        @Override // org.bouncycastle.operator.AADProcessor
        /* renamed from: getMAC */
        public byte[] mo14908getMAC() {
            return this.f19074macOut.m17386getMac();
        }

        @Override // org.bouncycastle.operator.OutputEncryptor
        public OutputStream getOutputStream(OutputStream outputStream) {
            AlgorithmIdentifier algorithmIdentifier = JceCMSContentEncryptorBuilder.this.kdfAlgorithm != null ? AlgorithmIdentifier.getInstance(this.algorithmIdentifier.getParameters()) : this.algorithmIdentifier;
            if (CMSAlgorithm.ChaCha20Poly1305.m14446equals((ASN1Primitive) this.algorithmIdentifier.getAlgorithm())) {
                this.f19074macOut = new MacCaptureStream(outputStream, 16);
            } else {
                this.f19074macOut = new MacCaptureStream(outputStream, GCMParameters.getInstance(algorithmIdentifier.getParameters()).getIcvLen());
            }
            return new CipherOutputStream(this.f19074macOut, this.f19076cipher);
        }
    }

    public class CMSOutEncryptor {
        protected AlgorithmIdentifier algorithmIdentifier;

        /* renamed from: cipher */
        protected Cipher f19076cipher;

        /* renamed from: encKey */
        protected SecretKey f19077encKey;

        private CMSOutEncryptor() {
        }

        private void applyKdf(ASN1ObjectIdentifier aSN1ObjectIdentifier, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws CMSException, InvalidKeyException, InvalidAlgorithmParameterException {
            HKDFBytesGenerator hKDFBytesGenerator = new HKDFBytesGenerator(new SHA256Digest());
            byte[] encoded = this.f19077encKey.getEncoded();
            try {
                hKDFBytesGenerator.mo14966init(new HKDFParameters(encoded, JceCMSContentEncryptorBuilder.hkdfSalt, this.algorithmIdentifier.getEncoded(ASN1Encoding.f17902DER)));
                hKDFBytesGenerator.generateBytes(encoded, 0, encoded.length);
                try {
                    this.f19076cipher.init(1, new SecretKeySpec(encoded, this.f19077encKey.getAlgorithm()), algorithmParameters, secureRandom);
                    this.algorithmIdentifier = new AlgorithmIdentifier(aSN1ObjectIdentifier, this.algorithmIdentifier);
                } catch (GeneralSecurityException e) {
                    throw new CMSException("unable to initialize cipher: " + e.getMessage(), e);
                }
            } catch (IOException e2) {
                throw new CMSException("unable to encode enc algorithm parameters", e2);
            }
        }

        /* renamed from: init */
        public void m14937init(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2, SecretKey secretKey, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws CMSException, InvalidKeyException, InvalidAlgorithmParameterException {
            this.f19077encKey = secretKey;
            SecureRandom secureRandom2 = CryptoServicesRegistrar.getSecureRandom(secureRandom);
            this.f19076cipher = JceCMSContentEncryptorBuilder.this.f19071helper.createCipher(aSN1ObjectIdentifier2);
            if (algorithmParameters == null) {
                algorithmParameters = JceCMSContentEncryptorBuilder.this.f19071helper.generateParameters(aSN1ObjectIdentifier2, secretKey, secureRandom2);
            }
            if (algorithmParameters != null) {
                this.algorithmIdentifier = JceCMSContentEncryptorBuilder.this.f19071helper.getAlgorithmIdentifier(aSN1ObjectIdentifier2, algorithmParameters);
                if (aSN1ObjectIdentifier != null) {
                    applyKdf(aSN1ObjectIdentifier, algorithmParameters, secureRandom2);
                    return;
                }
                try {
                    this.f19076cipher.init(1, secretKey, algorithmParameters, secureRandom2);
                    return;
                } catch (GeneralSecurityException e) {
                    throw new CMSException("unable to initialize cipher: " + e.getMessage(), e);
                }
            }
            try {
                this.f19076cipher.init(1, secretKey, algorithmParameters, secureRandom2);
                AlgorithmParameters parameters = this.f19076cipher.getParameters();
                this.algorithmIdentifier = JceCMSContentEncryptorBuilder.this.f19071helper.getAlgorithmIdentifier(aSN1ObjectIdentifier2, parameters);
                if (aSN1ObjectIdentifier != null) {
                    applyKdf(aSN1ObjectIdentifier, parameters, secureRandom2);
                }
            } catch (GeneralSecurityException e2) {
                throw new CMSException("unable to initialize cipher: " + e2.getMessage(), e2);
            }
        }
    }

    public class CMSOutputEncryptor extends CMSOutEncryptor implements OutputEncryptor {
        public CMSOutputEncryptor(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2, SecretKey secretKey, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws CMSException, InvalidKeyException, InvalidAlgorithmParameterException {
            super();
            m14937init(aSN1ObjectIdentifier, aSN1ObjectIdentifier2, secretKey, algorithmParameters, secureRandom);
        }

        @Override // org.bouncycastle.operator.OutputEncryptor
        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return this.algorithmIdentifier;
        }

        @Override // org.bouncycastle.operator.OutputEncryptor
        /* renamed from: getKey */
        public GenericKey mo14795getKey() {
            return new JceGenericKey(this.algorithmIdentifier, this.f19077encKey);
        }

        @Override // org.bouncycastle.operator.OutputEncryptor
        public OutputStream getOutputStream(OutputStream outputStream) {
            return new CipherOutputStream(outputStream, this.f19076cipher);
        }
    }

    public JceCMSContentEncryptorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this(aSN1ObjectIdentifier, KEY_SIZE_PROVIDER.getKeySize(aSN1ObjectIdentifier));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkForAEAD() {
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.bouncycastle.cms.jcajce.JceCMSContentEncryptorBuilder.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    return Boolean.valueOf(Cipher.class.getMethod("updateAAD", byte[].class) != null);
                } catch (Exception unused) {
                    return Boolean.FALSE;
                }
            }
        })).booleanValue();
    }

    /* renamed from: build */
    public OutputEncryptor m14934build() throws CMSException {
        KeyGenerator keyGeneratorCreateKeyGenerator = this.f19071helper.createKeyGenerator(this.encryptionOID);
        SecureRandom secureRandom = CryptoServicesRegistrar.getSecureRandom(this.f19073random);
        this.f19073random = secureRandom;
        int i = this.f19072keySize;
        if (i < 0) {
            keyGeneratorCreateKeyGenerator.init(secureRandom);
        } else {
            keyGeneratorCreateKeyGenerator.init(i, secureRandom);
        }
        return m14935build(keyGeneratorCreateKeyGenerator.generateKey());
    }

    public JceCMSContentEncryptorBuilder setAlgorithmParameters(AlgorithmParameters algorithmParameters) {
        this.algorithmParameters = algorithmParameters;
        return this;
    }

    public JceCMSContentEncryptorBuilder setEnableSha256HKdf(boolean z) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        if (!z) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = this.kdfAlgorithm;
            if (aSN1ObjectIdentifier2 != null) {
                if (!aSN1ObjectIdentifier2.m14446equals((ASN1Primitive) CMSObjectIdentifiers.id_alg_cek_hkdf_sha256)) {
                    throw new IllegalStateException("SHA256 HKDF not enabled");
                }
                aSN1ObjectIdentifier = null;
            }
            return this;
        }
        aSN1ObjectIdentifier = CMSObjectIdentifiers.id_alg_cek_hkdf_sha256;
        this.kdfAlgorithm = aSN1ObjectIdentifier;
        return this;
    }

    public JceCMSContentEncryptorBuilder setProvider(String str) {
        this.f19071helper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(str));
        return this;
    }

    public JceCMSContentEncryptorBuilder setSecureRandom(SecureRandom secureRandom) {
        this.f19073random = secureRandom;
        return this;
    }

    public JceCMSContentEncryptorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i) {
        int i2;
        this.f19071helper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
        this.encryptionOID = aSN1ObjectIdentifier;
        int keySize = KEY_SIZE_PROVIDER.getKeySize(aSN1ObjectIdentifier);
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.des_EDE3_CBC)) {
            i2 = 168;
            if (i != 168 && i != keySize) {
                throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
            }
        } else {
            if (!aSN1ObjectIdentifier.m14446equals((ASN1Primitive) OIWObjectIdentifiers.f18454desCBC)) {
                if (keySize > 0 && keySize != i) {
                    throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
                }
                this.f19072keySize = i;
                return;
            }
            i2 = 56;
            if (i != 56 && i != keySize) {
                throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
            }
        }
        this.f19072keySize = i2;
    }

    /* renamed from: build */
    public OutputEncryptor m14935build(SecretKey secretKey) throws CMSException, IOException {
        ASN1Encodable parameters;
        if (this.algorithmParameters != null) {
            return this.f19071helper.isAuthEnveloped(this.encryptionOID) ? new CMSAuthOutputEncryptor(this.kdfAlgorithm, this.encryptionOID, secretKey, this.algorithmParameters, this.f19073random) : new CMSOutputEncryptor(this.kdfAlgorithm, this.encryptionOID, secretKey, this.algorithmParameters, this.f19073random);
        }
        AlgorithmIdentifier algorithmIdentifier = this.algorithmIdentifier;
        if (algorithmIdentifier != null && (parameters = algorithmIdentifier.getParameters()) != null && !parameters.equals(C5103DERNull.INSTANCE)) {
            try {
                AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f19071helper.createAlgorithmParameters(this.algorithmIdentifier.getAlgorithm());
                this.algorithmParameters = algorithmParametersCreateAlgorithmParameters;
                algorithmParametersCreateAlgorithmParameters.init(parameters.toASN1Primitive().getEncoded());
            } catch (Exception e) {
                throw new CMSException("unable to process provided algorithmIdentifier: " + e.toString(), e);
            }
        }
        return this.f19071helper.isAuthEnveloped(this.encryptionOID) ? new CMSAuthOutputEncryptor(this.kdfAlgorithm, this.encryptionOID, secretKey, this.algorithmParameters, this.f19073random) : new CMSOutputEncryptor(this.kdfAlgorithm, this.encryptionOID, secretKey, this.algorithmParameters, this.f19073random);
    }

    public JceCMSContentEncryptorBuilder setProvider(Provider provider) {
        this.f19071helper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(provider));
        return this;
    }

    public JceCMSContentEncryptorBuilder(AlgorithmIdentifier algorithmIdentifier) {
        this(algorithmIdentifier.getAlgorithm(), KEY_SIZE_PROVIDER.getKeySize(algorithmIdentifier.getAlgorithm()));
        this.algorithmIdentifier = algorithmIdentifier;
    }

    /* renamed from: build */
    public OutputEncryptor m14936build(byte[] bArr) {
        return m14935build(new SecretKeySpec(bArr, this.f19071helper.getBaseCipherName(this.encryptionOID)));
    }
}
