package org.bouncycastle.p307pkcs.p309jcajce;

import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.operator.AlgorithmNameFinder;
import org.bouncycastle.operator.DefaultAlgorithmNameFinder;
import org.bouncycastle.operator.DefaultSecretKeySizeProvider;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.operator.SecretKeySizeProvider;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p133asn1.p158misc.MiscObjectIdentifiers;
import org.bouncycastle.p133asn1.p158misc.ScryptParams;
import org.bouncycastle.p133asn1.p166pkcs.EncryptionScheme;
import org.bouncycastle.p133asn1.p166pkcs.KeyDerivationFunc;
import org.bouncycastle.p133asn1.p166pkcs.PBES2Parameters;
import org.bouncycastle.p133asn1.p166pkcs.PBKDF2Params;
import org.bouncycastle.p133asn1.p166pkcs.PKCS12PBEParams;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.p221util.PBKDF2Config;
import org.bouncycastle.p194crypto.p221util.PBKDFConfig;
import org.bouncycastle.p194crypto.p221util.ScryptConfig;
import org.bouncycastle.p249jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.p249jcajce.p250io.CipherOutputStream;
import org.bouncycastle.p249jcajce.p279spec.ScryptKeySpec;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;

/* loaded from: classes2.dex */
public class JcePKCSPBEOutputEncryptorBuilder {
    private ASN1ObjectIdentifier algorithm;
    private AlgorithmNameFinder algorithmNameFinder;

    /* renamed from: helper */
    private JcaJceHelper f22971helper;
    private int iterationCount;
    private ASN1ObjectIdentifier keyEncAlgorithm;
    private SecretKeySizeProvider keySizeProvider;

    /* renamed from: pbkdf */
    private final PBKDFConfig f22972pbkdf;
    private PBKDF2Config.C5422Builder pbkdfBuilder;

    /* renamed from: random */
    private SecureRandom f22973random;

    public JcePKCSPBEOutputEncryptorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f22971helper = new DefaultJcaJceHelper();
        this.keySizeProvider = DefaultSecretKeySizeProvider.INSTANCE;
        this.algorithmNameFinder = new DefaultAlgorithmNameFinder();
        this.iterationCount = 1024;
        this.pbkdfBuilder = new PBKDF2Config.C5422Builder();
        this.f22972pbkdf = null;
        if (isPKCS12(aSN1ObjectIdentifier)) {
            this.algorithm = aSN1ObjectIdentifier;
        } else {
            this.algorithm = PKCSObjectIdentifiers.id_PBES2;
        }
        this.keyEncAlgorithm = aSN1ObjectIdentifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] PKCS12PasswordToBytes(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[(cArr.length + 1) * 2];
        for (int i = 0; i != cArr.length; i++) {
            int i2 = i * 2;
            char c = cArr[i];
            bArr[i2] = (byte) (c >>> '\b');
            bArr[i2 + 1] = (byte) c;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] PKCS5PasswordToBytes(char[] cArr) {
        if (cArr == null) {
            return new byte[0];
        }
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) cArr[i];
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPKCS12(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return aSN1ObjectIdentifier.m14435on(PKCSObjectIdentifiers.pkcs_12PbeIds) || aSN1ObjectIdentifier.m14435on(BCObjectIdentifiers.bc_pbe_sha1_pkcs12) || aSN1ObjectIdentifier.m14435on(BCObjectIdentifiers.bc_pbe_sha256_pkcs12);
    }

    private SecretKey simplifyPbeKey(SecretKey secretKey) {
        return (!this.algorithmNameFinder.hasAlgorithmName(this.keyEncAlgorithm) || this.algorithmNameFinder.getAlgorithmName(this.keyEncAlgorithm).indexOf("AES") < 0) ? secretKey : new SecretKeySpec(secretKey.getEncoded(), "AES");
    }

    /* renamed from: build */
    public OutputEncryptor m17426build(final char[] cArr) throws InvalidKeySpecException, OperatorCreationException, InvalidKeyException {
        Cipher cipherCreateCipher;
        final AlgorithmIdentifier algorithmIdentifier;
        final Cipher cipherCreateCipher2;
        if (this.f22973random == null) {
            this.f22973random = new SecureRandom();
        }
        try {
            if (isPKCS12(this.algorithm)) {
                byte[] bArr = new byte[20];
                this.f22973random.nextBytes(bArr);
                cipherCreateCipher2 = this.f22971helper.createCipher(this.algorithm.m14433getId());
                cipherCreateCipher2.init(1, new PKCS12KeyWithParameters(cArr, bArr, this.iterationCount));
                algorithmIdentifier = new AlgorithmIdentifier(this.algorithm, new PKCS12PBEParams(bArr, this.iterationCount));
            } else {
                if (!this.algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_PBES2)) {
                    throw new OperatorCreationException("unrecognised algorithm");
                }
                PBKDFConfig pBKDFConfigM15929build = this.f22972pbkdf;
                if (pBKDFConfigM15929build == null) {
                    pBKDFConfigM15929build = this.pbkdfBuilder.m15929build();
                }
                ASN1ObjectIdentifier aSN1ObjectIdentifier = MiscObjectIdentifiers.id_scrypt;
                if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) pBKDFConfigM15929build.getAlgorithm())) {
                    ScryptConfig scryptConfig = (ScryptConfig) pBKDFConfigM15929build;
                    byte[] bArr2 = new byte[scryptConfig.getSaltLength()];
                    this.f22973random.nextBytes(bArr2);
                    ScryptParams scryptParams = new ScryptParams(bArr2, scryptConfig.getCostParameter(), scryptConfig.getBlockSize(), scryptConfig.getParallelizationParameter());
                    SecretKey secretKeyGenerateSecret = this.f22971helper.createSecretKeyFactory("SCRYPT").generateSecret(new ScryptKeySpec(cArr, bArr2, scryptConfig.getCostParameter(), scryptConfig.getBlockSize(), scryptConfig.getParallelizationParameter(), this.keySizeProvider.getKeySize(new AlgorithmIdentifier(this.keyEncAlgorithm))));
                    cipherCreateCipher = this.f22971helper.createCipher(this.keyEncAlgorithm.m14433getId());
                    cipherCreateCipher.init(1, simplifyPbeKey(secretKeyGenerateSecret), this.f22973random);
                    algorithmIdentifier = new AlgorithmIdentifier(this.algorithm, cipherCreateCipher.getParameters() != null ? new PBES2Parameters(new KeyDerivationFunc(aSN1ObjectIdentifier, scryptParams), new EncryptionScheme(this.keyEncAlgorithm, ASN1Primitive.fromByteArray(cipherCreateCipher.getParameters().getEncoded()))) : new PBES2Parameters(new KeyDerivationFunc(aSN1ObjectIdentifier, scryptParams), new EncryptionScheme(this.keyEncAlgorithm)));
                } else {
                    PBKDF2Config pBKDF2Config = (PBKDF2Config) pBKDFConfigM15929build;
                    byte[] bArr3 = new byte[pBKDF2Config.getSaltLength()];
                    this.f22973random.nextBytes(bArr3);
                    SecretKey secretKeyGenerateSecret2 = this.f22971helper.createSecretKeyFactory(JceUtils.getAlgorithm(pBKDF2Config.m15928getPRF().getAlgorithm())).generateSecret(new PBEKeySpec(cArr, bArr3, pBKDF2Config.getIterationCount(), this.keySizeProvider.getKeySize(new AlgorithmIdentifier(this.keyEncAlgorithm))));
                    cipherCreateCipher = this.f22971helper.createCipher(this.keyEncAlgorithm.m14433getId());
                    cipherCreateCipher.init(1, simplifyPbeKey(secretKeyGenerateSecret2), this.f22973random);
                    algorithmIdentifier = new AlgorithmIdentifier(this.algorithm, cipherCreateCipher.getParameters() != null ? new PBES2Parameters(new KeyDerivationFunc(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(bArr3, pBKDF2Config.getIterationCount(), pBKDF2Config.m15928getPRF())), new EncryptionScheme(this.keyEncAlgorithm, ASN1Primitive.fromByteArray(cipherCreateCipher.getParameters().getEncoded()))) : new PBES2Parameters(new KeyDerivationFunc(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(bArr3, pBKDF2Config.getIterationCount(), pBKDF2Config.m15928getPRF())), new EncryptionScheme(this.keyEncAlgorithm)));
                }
                cipherCreateCipher2 = cipherCreateCipher;
            }
            return new OutputEncryptor(this) { // from class: org.bouncycastle.pkcs.jcajce.JcePKCSPBEOutputEncryptorBuilder.1

                /* renamed from: this$0 */
                final /* synthetic */ JcePKCSPBEOutputEncryptorBuilder f22974this$0;

                {
                    this.f22974this$0 = this;
                }

                @Override // org.bouncycastle.operator.OutputEncryptor
                public AlgorithmIdentifier getAlgorithmIdentifier() {
                    return algorithmIdentifier;
                }

                @Override // org.bouncycastle.operator.OutputEncryptor
                /* renamed from: getKey */
                public GenericKey mo14795getKey() {
                    return this.f22974this$0.isPKCS12(algorithmIdentifier.getAlgorithm()) ? new GenericKey(algorithmIdentifier, JcePKCSPBEOutputEncryptorBuilder.PKCS12PasswordToBytes(cArr)) : new GenericKey(algorithmIdentifier, JcePKCSPBEOutputEncryptorBuilder.PKCS5PasswordToBytes(cArr));
                }

                @Override // org.bouncycastle.operator.OutputEncryptor
                public OutputStream getOutputStream(OutputStream outputStream) {
                    return new CipherOutputStream(outputStream, cipherCreateCipher2);
                }
            };
        } catch (Exception e) {
            throw new OperatorCreationException("unable to create OutputEncryptor: " + e.getMessage(), e);
        }
    }

    public JcePKCSPBEOutputEncryptorBuilder setIterationCount(int i) {
        if (this.f22972pbkdf != null) {
            throw new IllegalStateException("set iteration count using PBKDFDef");
        }
        this.iterationCount = i;
        this.pbkdfBuilder.withIterationCount(i);
        return this;
    }

    public JcePKCSPBEOutputEncryptorBuilder setKeySizeProvider(SecretKeySizeProvider secretKeySizeProvider) {
        this.keySizeProvider = secretKeySizeProvider;
        return this;
    }

    /* renamed from: setPRF */
    public JcePKCSPBEOutputEncryptorBuilder m17427setPRF(AlgorithmIdentifier algorithmIdentifier) {
        if (this.f22972pbkdf != null) {
            throw new IllegalStateException("set PRF count using PBKDFDef");
        }
        this.pbkdfBuilder.m15930withPRF(algorithmIdentifier);
        return this;
    }

    public JcePKCSPBEOutputEncryptorBuilder setProvider(String str) {
        this.f22971helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcePKCSPBEOutputEncryptorBuilder setRandom(SecureRandom secureRandom) {
        this.f22973random = secureRandom;
        return this;
    }

    public JcePKCSPBEOutputEncryptorBuilder(PBKDFConfig pBKDFConfig, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f22971helper = new DefaultJcaJceHelper();
        this.keySizeProvider = DefaultSecretKeySizeProvider.INSTANCE;
        this.algorithmNameFinder = new DefaultAlgorithmNameFinder();
        this.iterationCount = 1024;
        this.pbkdfBuilder = new PBKDF2Config.C5422Builder();
        this.algorithm = PKCSObjectIdentifiers.id_PBES2;
        this.f22972pbkdf = pBKDFConfig;
        this.keyEncAlgorithm = aSN1ObjectIdentifier;
    }

    public JcePKCSPBEOutputEncryptorBuilder setProvider(Provider provider) {
        this.f22971helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
