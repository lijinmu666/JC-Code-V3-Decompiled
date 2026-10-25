package org.bouncycastle.p177cert.p180crmf.p182jcajce;

import java.io.OutputStream;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.bouncycastle.operator.DefaultSecretKeySizeProvider;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.operator.SecretKeySizeProvider;
import org.bouncycastle.operator.p306jcajce.JceGenericKey;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p177cert.p180crmf.CRMFException;
import org.bouncycastle.p249jcajce.p250io.CipherOutputStream;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;

/* loaded from: classes2.dex */
public class JceCRMFEncryptorBuilder {
    private static final SecretKeySizeProvider KEY_SIZE_PROVIDER = DefaultSecretKeySizeProvider.INSTANCE;
    private final ASN1ObjectIdentifier encryptionOID;

    /* renamed from: helper */
    private CRMFHelper f18857helper;

    /* renamed from: keySize */
    private final int f18858keySize;

    /* renamed from: random */
    private SecureRandom f18859random;

    public class CRMFOutputEncryptor implements OutputEncryptor {
        private AlgorithmIdentifier algorithmIdentifier;

        /* renamed from: cipher */
        private Cipher f18860cipher;

        /* renamed from: encKey */
        private SecretKey f18861encKey;

        public CRMFOutputEncryptor(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, SecureRandom secureRandom) throws CRMFException, InvalidKeyException, InvalidAlgorithmParameterException {
            KeyGenerator keyGeneratorCreateKeyGenerator = JceCRMFEncryptorBuilder.this.f18857helper.createKeyGenerator(aSN1ObjectIdentifier);
            secureRandom = secureRandom == null ? new SecureRandom() : secureRandom;
            i = i < 0 ? JceCRMFEncryptorBuilder.KEY_SIZE_PROVIDER.getKeySize(aSN1ObjectIdentifier) : i;
            if (i < 0) {
                keyGeneratorCreateKeyGenerator.init(secureRandom);
            } else {
                keyGeneratorCreateKeyGenerator.init(i, secureRandom);
            }
            this.f18860cipher = JceCRMFEncryptorBuilder.this.f18857helper.createCipher(aSN1ObjectIdentifier);
            this.f18861encKey = keyGeneratorCreateKeyGenerator.generateKey();
            AlgorithmParameters algorithmParametersGenerateParameters = JceCRMFEncryptorBuilder.this.f18857helper.generateParameters(aSN1ObjectIdentifier, this.f18861encKey, secureRandom);
            try {
                this.f18860cipher.init(1, this.f18861encKey, algorithmParametersGenerateParameters, secureRandom);
                this.algorithmIdentifier = JceCRMFEncryptorBuilder.this.f18857helper.getAlgorithmIdentifier(aSN1ObjectIdentifier, algorithmParametersGenerateParameters == null ? this.f18860cipher.getParameters() : algorithmParametersGenerateParameters);
            } catch (GeneralSecurityException e) {
                throw new CRMFException("unable to initialize cipher: " + e.getMessage(), e);
            }
        }

        @Override // org.bouncycastle.operator.OutputEncryptor
        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return this.algorithmIdentifier;
        }

        @Override // org.bouncycastle.operator.OutputEncryptor
        /* renamed from: getKey */
        public GenericKey mo14795getKey() {
            return new JceGenericKey(this.algorithmIdentifier, this.f18861encKey);
        }

        @Override // org.bouncycastle.operator.OutputEncryptor
        public OutputStream getOutputStream(OutputStream outputStream) {
            return new CipherOutputStream(outputStream, this.f18860cipher);
        }
    }

    public JceCRMFEncryptorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this(aSN1ObjectIdentifier, -1);
    }

    /* renamed from: build */
    public OutputEncryptor m14803build() {
        return new CRMFOutputEncryptor(this.encryptionOID, this.f18858keySize, this.f18859random);
    }

    public JceCRMFEncryptorBuilder setProvider(String str) {
        this.f18857helper = new CRMFHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JceCRMFEncryptorBuilder setSecureRandom(SecureRandom secureRandom) {
        this.f18859random = secureRandom;
        return this;
    }

    public JceCRMFEncryptorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i) {
        this.f18857helper = new CRMFHelper(new DefaultJcaJceHelper());
        this.encryptionOID = aSN1ObjectIdentifier;
        this.f18858keySize = i;
    }

    public JceCRMFEncryptorBuilder setProvider(Provider provider) {
        this.f18857helper = new CRMFHelper(new ProviderJcaJceHelper(provider));
        return this;
    }
}
