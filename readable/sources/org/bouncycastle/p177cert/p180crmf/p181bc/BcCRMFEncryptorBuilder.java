package org.bouncycastle.p177cert.p180crmf.p181bc;

import java.io.OutputStream;
import java.security.SecureRandom;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p221util.CipherFactory;

/* loaded from: classes2.dex */
public class BcCRMFEncryptorBuilder {
    private final ASN1ObjectIdentifier encryptionOID;

    /* renamed from: helper */
    private CRMFHelper f18843helper;

    /* renamed from: keySize */
    private final int f18844keySize;

    /* renamed from: random */
    private SecureRandom f18845random;

    public class CRMFOutputEncryptor implements OutputEncryptor {
        private AlgorithmIdentifier algorithmIdentifier;

        /* renamed from: cipher */
        private Object f18846cipher;

        /* renamed from: encKey */
        private KeyParameter f18847encKey;

        public CRMFOutputEncryptor(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, SecureRandom secureRandom) {
            SecureRandom secureRandom2 = CryptoServicesRegistrar.getSecureRandom(secureRandom);
            this.f18847encKey = new KeyParameter(BcCRMFEncryptorBuilder.this.f18843helper.createKeyGenerator(aSN1ObjectIdentifier, secureRandom2).generateKey());
            this.algorithmIdentifier = BcCRMFEncryptorBuilder.this.f18843helper.generateEncryptionAlgID(aSN1ObjectIdentifier, this.f18847encKey, secureRandom2);
            CRMFHelper unused = BcCRMFEncryptorBuilder.this.f18843helper;
            this.f18846cipher = CRMFHelper.createContentCipher(true, this.f18847encKey, this.algorithmIdentifier);
        }

        @Override // org.bouncycastle.operator.OutputEncryptor
        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return this.algorithmIdentifier;
        }

        @Override // org.bouncycastle.operator.OutputEncryptor
        /* renamed from: getKey */
        public GenericKey mo14795getKey() {
            return new GenericKey(this.algorithmIdentifier, this.f18847encKey.m15773getKey());
        }

        @Override // org.bouncycastle.operator.OutputEncryptor
        public OutputStream getOutputStream(OutputStream outputStream) {
            return CipherFactory.createOutputStream(outputStream, this.f18846cipher);
        }
    }

    public BcCRMFEncryptorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this(aSN1ObjectIdentifier, -1);
    }

    /* renamed from: build */
    public OutputEncryptor m14794build() {
        return new CRMFOutputEncryptor(this.encryptionOID, this.f18844keySize, this.f18845random);
    }

    public BcCRMFEncryptorBuilder setSecureRandom(SecureRandom secureRandom) {
        this.f18845random = secureRandom;
        return this;
    }

    public BcCRMFEncryptorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i) {
        this.f18843helper = new CRMFHelper();
        this.encryptionOID = aSN1ObjectIdentifier;
        this.f18844keySize = i;
    }
}
