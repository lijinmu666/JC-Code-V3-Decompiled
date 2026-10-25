package org.bouncycastle.p249jcajce;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import org.bouncycastle.p194crypto.p221util.PBKDF2Config;
import org.bouncycastle.p194crypto.p221util.PBKDFConfig;

/* loaded from: classes2.dex */
public class BCFKSLoadStoreParameter extends BCLoadStoreParameter {
    private final X509Certificate[] certificates;

    /* renamed from: encAlg */
    private final EncryptionAlgorithm f21334encAlg;

    /* renamed from: macAlg */
    private final MacAlgorithm f21335macAlg;

    /* renamed from: sigAlg */
    private final SignatureAlgorithm f21336sigAlg;

    /* renamed from: sigKey */
    private final Key f21337sigKey;
    private final PBKDFConfig storeConfig;
    private final CertChainValidator validator;

    /* renamed from: org.bouncycastle.jcajce.BCFKSLoadStoreParameter$Builder */
    public static class C5467Builder {

        /* renamed from: certs */
        private X509Certificate[] f21338certs;

        /* renamed from: encAlg */
        private EncryptionAlgorithm f21339encAlg;

        /* renamed from: in */
        private final InputStream f21340in;

        /* renamed from: macAlg */
        private MacAlgorithm f21341macAlg;

        /* renamed from: out */
        private final OutputStream f21342out;
        private final KeyStore.ProtectionParameter protectionParameter;

        /* renamed from: sigAlg */
        private SignatureAlgorithm f21343sigAlg;

        /* renamed from: sigKey */
        private final Key f21344sigKey;
        private PBKDFConfig storeConfig;
        private CertChainValidator validator;

        public C5467Builder() {
            this((OutputStream) null, (KeyStore.ProtectionParameter) null);
        }

        /* renamed from: build */
        public BCFKSLoadStoreParameter m16043build() {
            return new BCFKSLoadStoreParameter(this);
        }

        public C5467Builder withCertificates(X509Certificate[] x509CertificateArr) {
            int length = x509CertificateArr.length;
            X509Certificate[] x509CertificateArr2 = new X509Certificate[length];
            System.arraycopy(x509CertificateArr, 0, x509CertificateArr2, 0, length);
            this.f21338certs = x509CertificateArr2;
            return this;
        }

        public C5467Builder withStoreEncryptionAlgorithm(EncryptionAlgorithm encryptionAlgorithm) {
            this.f21339encAlg = encryptionAlgorithm;
            return this;
        }

        public C5467Builder withStoreMacAlgorithm(MacAlgorithm macAlgorithm) {
            this.f21341macAlg = macAlgorithm;
            return this;
        }

        public C5467Builder withStorePBKDFConfig(PBKDFConfig pBKDFConfig) {
            this.storeConfig = pBKDFConfig;
            return this;
        }

        public C5467Builder withStoreSignatureAlgorithm(SignatureAlgorithm signatureAlgorithm) {
            this.f21343sigAlg = signatureAlgorithm;
            return this;
        }

        public C5467Builder(InputStream inputStream, KeyStore.ProtectionParameter protectionParameter) {
            this.storeConfig = new PBKDF2Config.C5422Builder().withIterationCount(16384).withSaltLength(64).m15930withPRF(PBKDF2Config.PRF_SHA512).m15929build();
            this.f21339encAlg = EncryptionAlgorithm.AES256_CCM;
            this.f21341macAlg = MacAlgorithm.HmacSHA512;
            this.f21343sigAlg = SignatureAlgorithm.SHA512withECDSA;
            this.f21338certs = null;
            this.f21340in = inputStream;
            this.f21342out = null;
            this.protectionParameter = protectionParameter;
            this.f21344sigKey = null;
        }

        public C5467Builder(InputStream inputStream, PublicKey publicKey) {
            this.storeConfig = new PBKDF2Config.C5422Builder().withIterationCount(16384).withSaltLength(64).m15930withPRF(PBKDF2Config.PRF_SHA512).m15929build();
            this.f21339encAlg = EncryptionAlgorithm.AES256_CCM;
            this.f21341macAlg = MacAlgorithm.HmacSHA512;
            this.f21343sigAlg = SignatureAlgorithm.SHA512withECDSA;
            this.f21338certs = null;
            this.f21340in = inputStream;
            this.f21342out = null;
            this.protectionParameter = null;
            this.f21344sigKey = publicKey;
        }

        public C5467Builder(InputStream inputStream, CertChainValidator certChainValidator) {
            this.storeConfig = new PBKDF2Config.C5422Builder().withIterationCount(16384).withSaltLength(64).m15930withPRF(PBKDF2Config.PRF_SHA512).m15929build();
            this.f21339encAlg = EncryptionAlgorithm.AES256_CCM;
            this.f21341macAlg = MacAlgorithm.HmacSHA512;
            this.f21343sigAlg = SignatureAlgorithm.SHA512withECDSA;
            this.f21338certs = null;
            this.f21340in = inputStream;
            this.f21342out = null;
            this.protectionParameter = null;
            this.validator = certChainValidator;
            this.f21344sigKey = null;
        }

        public C5467Builder(InputStream inputStream, char[] cArr) {
            this(inputStream, new KeyStore.PasswordProtection(cArr));
        }

        public C5467Builder(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter) {
            this.storeConfig = new PBKDF2Config.C5422Builder().withIterationCount(16384).withSaltLength(64).m15930withPRF(PBKDF2Config.PRF_SHA512).m15929build();
            this.f21339encAlg = EncryptionAlgorithm.AES256_CCM;
            this.f21341macAlg = MacAlgorithm.HmacSHA512;
            this.f21343sigAlg = SignatureAlgorithm.SHA512withECDSA;
            this.f21338certs = null;
            this.f21340in = null;
            this.f21342out = outputStream;
            this.protectionParameter = protectionParameter;
            this.f21344sigKey = null;
        }

        public C5467Builder(OutputStream outputStream, PrivateKey privateKey) {
            this.storeConfig = new PBKDF2Config.C5422Builder().withIterationCount(16384).withSaltLength(64).m15930withPRF(PBKDF2Config.PRF_SHA512).m15929build();
            this.f21339encAlg = EncryptionAlgorithm.AES256_CCM;
            this.f21341macAlg = MacAlgorithm.HmacSHA512;
            this.f21343sigAlg = SignatureAlgorithm.SHA512withECDSA;
            this.f21338certs = null;
            this.f21340in = null;
            this.f21342out = outputStream;
            this.protectionParameter = null;
            this.f21344sigKey = privateKey;
        }

        public C5467Builder(OutputStream outputStream, char[] cArr) {
            this(outputStream, new KeyStore.PasswordProtection(cArr));
        }
    }

    public interface CertChainValidator {
        /* renamed from: isValid */
        boolean m16044isValid(X509Certificate[] x509CertificateArr);
    }

    public enum EncryptionAlgorithm {
        AES256_CCM,
        AES256_KWP
    }

    public enum MacAlgorithm {
        HmacSHA512,
        HmacSHA3_512
    }

    public enum SignatureAlgorithm {
        SHA512withDSA,
        SHA3_512withDSA,
        SHA512withECDSA,
        SHA3_512withECDSA,
        SHA512withRSA,
        SHA3_512withRSA
    }

    private BCFKSLoadStoreParameter(C5467Builder c5467Builder) {
        super(c5467Builder.f21340in, c5467Builder.f21342out, c5467Builder.protectionParameter);
        this.storeConfig = c5467Builder.storeConfig;
        this.f21334encAlg = c5467Builder.f21339encAlg;
        this.f21335macAlg = c5467Builder.f21341macAlg;
        this.f21336sigAlg = c5467Builder.f21343sigAlg;
        this.f21337sigKey = c5467Builder.f21344sigKey;
        this.certificates = c5467Builder.f21338certs;
        this.validator = c5467Builder.validator;
    }

    public CertChainValidator getCertChainValidator() {
        return this.validator;
    }

    public X509Certificate[] getStoreCertificates() {
        return this.certificates;
    }

    public EncryptionAlgorithm getStoreEncryptionAlgorithm() {
        return this.f21334encAlg;
    }

    public MacAlgorithm getStoreMacAlgorithm() {
        return this.f21335macAlg;
    }

    public PBKDFConfig getStorePBKDFConfig() {
        return this.storeConfig;
    }

    public SignatureAlgorithm getStoreSignatureAlgorithm() {
        return this.f21336sigAlg;
    }

    public Key getStoreSignatureKey() {
        return this.f21337sigKey;
    }
}
