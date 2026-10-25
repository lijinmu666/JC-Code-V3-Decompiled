package org.bouncycastle.p302openssl.p304jcajce;

import java.io.IOException;
import java.io.InputStream;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.operator.InputDecryptorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.p166pkcs.EncryptionScheme;
import org.bouncycastle.p133asn1.p166pkcs.KeyDerivationFunc;
import org.bouncycastle.p133asn1.p166pkcs.PBEParameter;
import org.bouncycastle.p133asn1.p166pkcs.PBES2Parameters;
import org.bouncycastle.p133asn1.p166pkcs.PBKDF2Params;
import org.bouncycastle.p133asn1.p166pkcs.PKCS12PBEParams;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.CharToByteConverter;
import org.bouncycastle.p249jcajce.PBKDF1KeyWithParameters;
import org.bouncycastle.p249jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.p249jcajce.p250io.CipherInputStream;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p302openssl.PEMException;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class JceOpenSSLPKCS8DecryptorProviderBuilder {

    /* renamed from: helper */
    private JcaJceHelper f22833helper = new DefaultJcaJceHelper();

    /* renamed from: build */
    public InputDecryptorProvider m17370build(final char[] cArr) {
        return new InputDecryptorProvider(this) { // from class: org.bouncycastle.openssl.jcajce.JceOpenSSLPKCS8DecryptorProviderBuilder.1

            /* renamed from: this$0 */
            final /* synthetic */ JceOpenSSLPKCS8DecryptorProviderBuilder f22834this$0;

            {
                this.f22834this$0 = this;
            }

            @Override // org.bouncycastle.operator.InputDecryptorProvider
            /* renamed from: get */
            public InputDecryptor mo17371get(final AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException, IOException, InvalidKeyException, InvalidAlgorithmParameterException {
                final Cipher cipherCreateCipher;
                Key pBKDF1KeyWithParameters;
                try {
                    if (PEMUtilities.isPKCS5Scheme2(algorithmIdentifier.getAlgorithm())) {
                        PBES2Parameters pBES2Parameters = PBES2Parameters.getInstance(algorithmIdentifier.getParameters());
                        KeyDerivationFunc keyDerivationFunc = pBES2Parameters.getKeyDerivationFunc();
                        EncryptionScheme encryptionScheme = pBES2Parameters.getEncryptionScheme();
                        PBKDF2Params pBKDF2Params = (PBKDF2Params) keyDerivationFunc.getParameters();
                        int iIntValue = pBKDF2Params.getIterationCount().intValue();
                        byte[] bArrM14635getSalt = pBKDF2Params.m14635getSalt();
                        String strM14433getId = encryptionScheme.getAlgorithm().m14433getId();
                        SecretKey secretKeyGenerateSecretKeyForPKCS5Scheme2 = PEMUtilities.isHmacSHA1(pBKDF2Params.m14634getPrf()) ? PEMUtilities.generateSecretKeyForPKCS5Scheme2(this.f22834this$0.f22833helper, strM14433getId, cArr, bArrM14635getSalt, iIntValue) : PEMUtilities.generateSecretKeyForPKCS5Scheme2(this.f22834this$0.f22833helper, strM14433getId, cArr, bArrM14635getSalt, iIntValue, pBKDF2Params.m14634getPrf());
                        cipherCreateCipher = this.f22834this$0.f22833helper.createCipher(PEMUtilities.getCipherName(encryptionScheme.getAlgorithm()));
                        AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f22834this$0.f22833helper.createAlgorithmParameters(strM14433getId);
                        algorithmParametersCreateAlgorithmParameters.init(encryptionScheme.getParameters().toASN1Primitive().getEncoded());
                        cipherCreateCipher.init(2, secretKeyGenerateSecretKeyForPKCS5Scheme2, algorithmParametersCreateAlgorithmParameters);
                    } else {
                        if (PEMUtilities.isPKCS12(algorithmIdentifier.getAlgorithm())) {
                            PKCS12PBEParams pKCS12PBEParams = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
                            cipherCreateCipher = this.f22834this$0.f22833helper.createCipher(PEMUtilities.getCipherName(algorithmIdentifier.getAlgorithm()));
                            pBKDF1KeyWithParameters = new PKCS12KeyWithParameters(cArr, pKCS12PBEParams.m14636getIV(), pKCS12PBEParams.getIterations().intValue());
                        } else {
                            if (!PEMUtilities.isPKCS5Scheme1(algorithmIdentifier.getAlgorithm())) {
                                throw new PEMException("Unknown algorithm: " + algorithmIdentifier.getAlgorithm());
                            }
                            PBEParameter pBEParameter = PBEParameter.getInstance(algorithmIdentifier.getParameters());
                            cipherCreateCipher = this.f22834this$0.f22833helper.createCipher(PEMUtilities.getCipherName(algorithmIdentifier.getAlgorithm()));
                            pBKDF1KeyWithParameters = new PBKDF1KeyWithParameters(cArr, new CharToByteConverter() { // from class: org.bouncycastle.openssl.jcajce.JceOpenSSLPKCS8DecryptorProviderBuilder.1.1
                                @Override // org.bouncycastle.p194crypto.CharToByteConverter
                                /* renamed from: convert */
                                public byte[] mo14954convert(char[] cArr2) {
                                    return C6250Strings.toByteArray(cArr2);
                                }

                                @Override // org.bouncycastle.p194crypto.CharToByteConverter
                                /* renamed from: getType */
                                public String mo14955getType() {
                                    return "ASCII";
                                }
                            }, pBEParameter.m14633getSalt(), pBEParameter.getIterationCount().intValue());
                        }
                        cipherCreateCipher.init(2, pBKDF1KeyWithParameters);
                    }
                    return new InputDecryptor(this) { // from class: org.bouncycastle.openssl.jcajce.JceOpenSSLPKCS8DecryptorProviderBuilder.1.2

                        /* renamed from: this$1 */
                        final /* synthetic */ C59871 f22836this$1;

                        {
                            this.f22836this$1 = this;
                        }

                        @Override // org.bouncycastle.operator.InputDecryptor
                        public AlgorithmIdentifier getAlgorithmIdentifier() {
                            return algorithmIdentifier;
                        }

                        @Override // org.bouncycastle.operator.InputDecryptor
                        public InputStream getInputStream(InputStream inputStream) {
                            return new CipherInputStream(inputStream, cipherCreateCipher);
                        }
                    };
                } catch (IOException e) {
                    throw new OperatorCreationException(algorithmIdentifier.getAlgorithm() + " not available: " + e.getMessage(), e);
                } catch (GeneralSecurityException e2) {
                    throw new OperatorCreationException(algorithmIdentifier.getAlgorithm() + " not available: " + e2.getMessage(), e2);
                }
            }
        };
    }

    public JceOpenSSLPKCS8DecryptorProviderBuilder setProvider(String str) {
        this.f22833helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JceOpenSSLPKCS8DecryptorProviderBuilder setProvider(Provider provider) {
        this.f22833helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
