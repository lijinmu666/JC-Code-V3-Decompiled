package org.bouncycastle.p307pkcs.p309jcajce;

import java.io.IOException;
import java.io.InputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.operator.DefaultSecretKeySizeProvider;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.operator.InputDecryptorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.SecretKeySizeProvider;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.cryptopro.GOST28147Parameters;
import org.bouncycastle.p133asn1.p158misc.MiscObjectIdentifiers;
import org.bouncycastle.p133asn1.p158misc.ScryptParams;
import org.bouncycastle.p133asn1.p166pkcs.PBEParameter;
import org.bouncycastle.p133asn1.p166pkcs.PBES2Parameters;
import org.bouncycastle.p133asn1.p166pkcs.PBKDF2Params;
import org.bouncycastle.p133asn1.p166pkcs.PKCS12PBEParams;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.PasswordConverter;
import org.bouncycastle.p249jcajce.PBKDF1Key;
import org.bouncycastle.p249jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.p249jcajce.p250io.CipherInputStream;
import org.bouncycastle.p249jcajce.p279spec.GOST28147ParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.PBKDF2KeySpec;
import org.bouncycastle.p249jcajce.p279spec.ScryptKeySpec;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;

/* loaded from: classes2.dex */
public class JcePKCSPBEInputDecryptorProviderBuilder {

    /* renamed from: helper */
    private JcaJceHelper f22967helper = new DefaultJcaJceHelper();
    private boolean wrongPKCS12Zero = false;
    private SecretKeySizeProvider keySizeProvider = DefaultSecretKeySizeProvider.INSTANCE;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCCMorGCM(ASN1Encodable aSN1Encodable) {
        ASN1Encodable parameters = AlgorithmIdentifier.getInstance(aSN1Encodable).getParameters();
        if (!(parameters instanceof ASN1Sequence)) {
            return false;
        }
        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(parameters);
        if (aSN1Sequence.mo14450size() == 2) {
            return aSN1Sequence.getObjectAt(1) instanceof ASN1Integer;
        }
        return false;
    }

    /* renamed from: build */
    public InputDecryptorProvider m17425build(final char[] cArr) {
        return new InputDecryptorProvider(this) { // from class: org.bouncycastle.pkcs.jcajce.JcePKCSPBEInputDecryptorProviderBuilder.1

            /* renamed from: cipher */
            private Cipher f22968cipher;
            private AlgorithmIdentifier encryptionAlg;

            /* renamed from: this$0 */
            final /* synthetic */ JcePKCSPBEInputDecryptorProviderBuilder f22969this$0;

            {
                this.f22969this$0 = this;
            }

            @Override // org.bouncycastle.operator.InputDecryptorProvider
            /* renamed from: get */
            public InputDecryptor mo17371get(AlgorithmIdentifier algorithmIdentifier) throws InvalidKeySpecException, OperatorCreationException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
                SecretKey secretKeyGenerateSecret;
                ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
                try {
                    if (algorithm.m14435on(PKCSObjectIdentifiers.pkcs_12PbeIds)) {
                        PKCS12PBEParams pKCS12PBEParams = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
                        Cipher cipherCreateCipher = this.f22969this$0.f22967helper.createCipher(algorithm.m14433getId());
                        this.f22968cipher = cipherCreateCipher;
                        cipherCreateCipher.init(2, new PKCS12KeyWithParameters(cArr, this.f22969this$0.wrongPKCS12Zero, pKCS12PBEParams.m14636getIV(), pKCS12PBEParams.getIterations().intValue()));
                        this.encryptionAlg = algorithmIdentifier;
                    } else if (algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_PBES2)) {
                        PBES2Parameters pBES2Parameters = PBES2Parameters.getInstance(algorithmIdentifier.getParameters());
                        if (MiscObjectIdentifiers.id_scrypt.m14446equals((ASN1Primitive) pBES2Parameters.getKeyDerivationFunc().getAlgorithm())) {
                            ScryptParams scryptParams = ScryptParams.getInstance(pBES2Parameters.getKeyDerivationFunc().getParameters());
                            secretKeyGenerateSecret = this.f22969this$0.f22967helper.createSecretKeyFactory("SCRYPT").generateSecret(new ScryptKeySpec(cArr, scryptParams.m14619getSalt(), scryptParams.getCostParameter().intValue(), scryptParams.getBlockSize().intValue(), scryptParams.getParallelizationParameter().intValue(), this.f22969this$0.keySizeProvider.getKeySize(AlgorithmIdentifier.getInstance(pBES2Parameters.getEncryptionScheme()))));
                        } else {
                            SecretKeyFactory secretKeyFactoryCreateSecretKeyFactory = this.f22969this$0.f22967helper.createSecretKeyFactory(pBES2Parameters.getKeyDerivationFunc().getAlgorithm().m14433getId());
                            PBKDF2Params pBKDF2Params = PBKDF2Params.getInstance(pBES2Parameters.getKeyDerivationFunc().getParameters());
                            AlgorithmIdentifier algorithmIdentifier2 = AlgorithmIdentifier.getInstance(pBES2Parameters.getEncryptionScheme());
                            secretKeyGenerateSecret = pBKDF2Params.isDefaultPrf() ? secretKeyFactoryCreateSecretKeyFactory.generateSecret(new PBEKeySpec(cArr, pBKDF2Params.m14635getSalt(), pBKDF2Params.getIterationCount().intValue(), this.f22969this$0.keySizeProvider.getKeySize(algorithmIdentifier2))) : secretKeyFactoryCreateSecretKeyFactory.generateSecret(new PBKDF2KeySpec(cArr, pBKDF2Params.m14635getSalt(), pBKDF2Params.getIterationCount().intValue(), this.f22969this$0.keySizeProvider.getKeySize(algorithmIdentifier2), pBKDF2Params.m14634getPrf()));
                        }
                        this.f22968cipher = this.f22969this$0.f22967helper.createCipher(pBES2Parameters.getEncryptionScheme().getAlgorithm().m14433getId());
                        this.encryptionAlg = AlgorithmIdentifier.getInstance(pBES2Parameters.getEncryptionScheme());
                        ASN1Encodable parameters = pBES2Parameters.getEncryptionScheme().getParameters();
                        if (parameters instanceof ASN1OctetString) {
                            this.f22968cipher.init(2, secretKeyGenerateSecret, new IvParameterSpec(ASN1OctetString.getInstance(parameters).getOctets()));
                        } else if ((parameters instanceof ASN1Sequence) && this.f22969this$0.isCCMorGCM(pBES2Parameters.getEncryptionScheme())) {
                            AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f22969this$0.f22967helper.createAlgorithmParameters(pBES2Parameters.getEncryptionScheme().getAlgorithm().m14433getId());
                            algorithmParametersCreateAlgorithmParameters.init(((ASN1Sequence) parameters).getEncoded());
                            this.f22968cipher.init(2, secretKeyGenerateSecret, algorithmParametersCreateAlgorithmParameters);
                        } else if (parameters == null) {
                            this.f22968cipher.init(2, secretKeyGenerateSecret);
                        } else {
                            GOST28147Parameters gOST28147Parameters = GOST28147Parameters.getInstance(parameters);
                            this.f22968cipher.init(2, secretKeyGenerateSecret, new GOST28147ParameterSpec(gOST28147Parameters.getEncryptionParamSet(), gOST28147Parameters.m14575getIV()));
                        }
                    } else {
                        if (!algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC) && !algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC)) {
                            throw new OperatorCreationException("unable to create InputDecryptor: algorithm " + algorithm + " unknown.");
                        }
                        PBEParameter pBEParameter = PBEParameter.getInstance(algorithmIdentifier.getParameters());
                        Cipher cipherCreateCipher2 = this.f22969this$0.f22967helper.createCipher(algorithm.m14433getId());
                        this.f22968cipher = cipherCreateCipher2;
                        cipherCreateCipher2.init(2, new PBKDF1Key(cArr, PasswordConverter.ASCII), new PBEParameterSpec(pBEParameter.m14633getSalt(), pBEParameter.getIterationCount().intValue()));
                    }
                    return new InputDecryptor() { // from class: org.bouncycastle.pkcs.jcajce.JcePKCSPBEInputDecryptorProviderBuilder.1.1
                        @Override // org.bouncycastle.operator.InputDecryptor
                        public AlgorithmIdentifier getAlgorithmIdentifier() {
                            return C60381.this.encryptionAlg;
                        }

                        @Override // org.bouncycastle.operator.InputDecryptor
                        public InputStream getInputStream(InputStream inputStream) {
                            return new CipherInputStream(inputStream, C60381.this.f22968cipher);
                        }
                    };
                } catch (Exception e) {
                    throw new OperatorCreationException("unable to create InputDecryptor: " + e.getMessage(), e);
                }
            }
        };
    }

    public JcePKCSPBEInputDecryptorProviderBuilder setKeySizeProvider(SecretKeySizeProvider secretKeySizeProvider) {
        this.keySizeProvider = secretKeySizeProvider;
        return this;
    }

    public JcePKCSPBEInputDecryptorProviderBuilder setProvider(String str) {
        this.f22967helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcePKCSPBEInputDecryptorProviderBuilder setTryWrongPKCS12Zero(boolean z) {
        this.wrongPKCS12Zero = z;
        return this;
    }

    public JcePKCSPBEInputDecryptorProviderBuilder setProvider(Provider provider) {
        this.f22967helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
