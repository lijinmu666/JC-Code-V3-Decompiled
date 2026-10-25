package org.bouncycastle.p302openssl.p304jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.operator.p306jcajce.JceGenericKey;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.EncryptionScheme;
import org.bouncycastle.p133asn1.p166pkcs.KeyDerivationFunc;
import org.bouncycastle.p133asn1.p166pkcs.PBES2Parameters;
import org.bouncycastle.p133asn1.p166pkcs.PBKDF2Params;
import org.bouncycastle.p133asn1.p166pkcs.PKCS12PBEParams;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p249jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.p249jcajce.p250io.CipherOutputStream;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;

/* loaded from: classes2.dex */
public class JceOpenSSLPKCS8EncryptorBuilder {

    /* renamed from: algOID */
    private ASN1ObjectIdentifier f22837algOID;

    /* renamed from: cipher */
    private Cipher f22838cipher;

    /* renamed from: key */
    private SecretKey f22840key;
    private AlgorithmParameterGenerator paramGen;

    /* renamed from: params */
    private AlgorithmParameters f22841params;
    private char[] password;

    /* renamed from: random */
    private SecureRandom f22843random;

    /* renamed from: salt */
    byte[] f22844salt;
    public static final String AES_128_CBC = NISTObjectIdentifiers.id_aes128_CBC.m14433getId();
    public static final String AES_192_CBC = NISTObjectIdentifiers.id_aes192_CBC.m14433getId();
    public static final String AES_256_CBC = NISTObjectIdentifiers.id_aes256_CBC.m14433getId();
    public static final String DES3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC.m14433getId();
    public static final String PBE_SHA1_RC4_128 = PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4.m14433getId();
    public static final String PBE_SHA1_RC4_40 = PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC4.m14433getId();
    public static final String PBE_SHA1_3DES = PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC.m14433getId();
    public static final String PBE_SHA1_2DES = PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC.m14433getId();
    public static final String PBE_SHA1_RC2_128 = PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC.m14433getId();
    public static final String PBE_SHA1_RC2_40 = PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC.m14433getId();

    /* renamed from: helper */
    private JcaJceHelper f22839helper = new DefaultJcaJceHelper();

    /* renamed from: prf */
    private AlgorithmIdentifier f22842prf = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA1, C5103DERNull.INSTANCE);
    int iterationCount = 2048;

    public JceOpenSSLPKCS8EncryptorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f22837algOID = aSN1ObjectIdentifier;
    }

    /* renamed from: build */
    public OutputEncryptor m17372build() throws OperatorCreationException, InvalidKeyException, InvalidAlgorithmParameterException {
        final AlgorithmIdentifier algorithmIdentifier;
        if (this.f22843random == null) {
            this.f22843random = new SecureRandom();
        }
        try {
            this.f22838cipher = this.f22839helper.createCipher(PEMUtilities.getCipherName(this.f22837algOID));
            if (PEMUtilities.isPKCS5Scheme2(this.f22837algOID)) {
                this.paramGen = this.f22839helper.createAlgorithmParameterGenerator(this.f22837algOID.m14433getId());
            }
            if (PEMUtilities.isPKCS5Scheme2(this.f22837algOID)) {
                byte[] bArr = new byte[PEMUtilities.getSaltSize(this.f22842prf.getAlgorithm())];
                this.f22844salt = bArr;
                this.f22843random.nextBytes(bArr);
                AlgorithmParameters algorithmParametersGenerateParameters = this.paramGen.generateParameters();
                this.f22841params = algorithmParametersGenerateParameters;
                try {
                    EncryptionScheme encryptionScheme = new EncryptionScheme(this.f22837algOID, ASN1Primitive.fromByteArray(algorithmParametersGenerateParameters.getEncoded()));
                    KeyDerivationFunc keyDerivationFunc = new KeyDerivationFunc(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(this.f22844salt, this.iterationCount, this.f22842prf));
                    ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                    aSN1EncodableVector.m14420add(keyDerivationFunc);
                    aSN1EncodableVector.m14420add(encryptionScheme);
                    algorithmIdentifier = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, PBES2Parameters.getInstance(new DERSequence(aSN1EncodableVector)));
                    try {
                        this.f22840key = PEMUtilities.isHmacSHA1(this.f22842prf) ? PEMUtilities.generateSecretKeyForPKCS5Scheme2(this.f22839helper, this.f22837algOID.m14433getId(), this.password, this.f22844salt, this.iterationCount) : PEMUtilities.generateSecretKeyForPKCS5Scheme2(this.f22839helper, this.f22837algOID.m14433getId(), this.password, this.f22844salt, this.iterationCount, this.f22842prf);
                        this.f22838cipher.init(1, this.f22840key, this.f22841params);
                    } catch (GeneralSecurityException e) {
                        throw new OperatorCreationException(e.getMessage(), e);
                    }
                } catch (IOException e2) {
                    throw new OperatorCreationException(e2.getMessage(), e2);
                }
            } else {
                if (!PEMUtilities.isPKCS12(this.f22837algOID)) {
                    throw new OperatorCreationException("unknown algorithm: " + this.f22837algOID, null);
                }
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                byte[] bArr2 = new byte[20];
                this.f22844salt = bArr2;
                this.f22843random.nextBytes(bArr2);
                aSN1EncodableVector2.m14420add(new DEROctetString(this.f22844salt));
                aSN1EncodableVector2.m14420add(ASN1Integer.m14429valueOf(this.iterationCount));
                AlgorithmIdentifier algorithmIdentifier2 = new AlgorithmIdentifier(this.f22837algOID, PKCS12PBEParams.getInstance(new DERSequence(aSN1EncodableVector2)));
                try {
                    this.f22838cipher.init(1, new PKCS12KeyWithParameters(this.password, this.f22844salt, this.iterationCount));
                    algorithmIdentifier = algorithmIdentifier2;
                } catch (GeneralSecurityException e3) {
                    throw new OperatorCreationException(e3.getMessage(), e3);
                }
            }
            return new OutputEncryptor(this) { // from class: org.bouncycastle.openssl.jcajce.JceOpenSSLPKCS8EncryptorBuilder.1

                /* renamed from: this$0 */
                final /* synthetic */ JceOpenSSLPKCS8EncryptorBuilder f22845this$0;

                {
                    this.f22845this$0 = this;
                }

                @Override // org.bouncycastle.operator.OutputEncryptor
                public AlgorithmIdentifier getAlgorithmIdentifier() {
                    return algorithmIdentifier;
                }

                @Override // org.bouncycastle.operator.OutputEncryptor
                /* renamed from: getKey */
                public GenericKey mo14795getKey() {
                    return new JceGenericKey(algorithmIdentifier, this.f22845this$0.f22840key);
                }

                @Override // org.bouncycastle.operator.OutputEncryptor
                public OutputStream getOutputStream(OutputStream outputStream) {
                    return new CipherOutputStream(outputStream, this.f22845this$0.f22838cipher);
                }
            };
        } catch (GeneralSecurityException e4) {
            throw new OperatorCreationException(this.f22837algOID + " not available: " + e4.getMessage(), e4);
        }
    }

    public JceOpenSSLPKCS8EncryptorBuilder setIterationCount(int i) {
        this.iterationCount = i;
        return this;
    }

    /* renamed from: setPRF */
    public JceOpenSSLPKCS8EncryptorBuilder m17373setPRF(AlgorithmIdentifier algorithmIdentifier) {
        this.f22842prf = algorithmIdentifier;
        return this;
    }

    public JceOpenSSLPKCS8EncryptorBuilder setPasssword(char[] cArr) {
        this.password = cArr;
        return this;
    }

    public JceOpenSSLPKCS8EncryptorBuilder setPassword(char[] cArr) {
        this.password = cArr;
        return this;
    }

    public JceOpenSSLPKCS8EncryptorBuilder setProvider(String str) {
        this.f22839helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JceOpenSSLPKCS8EncryptorBuilder setRandom(SecureRandom secureRandom) {
        this.f22843random = secureRandom;
        return this;
    }

    public JceOpenSSLPKCS8EncryptorBuilder setProvider(Provider provider) {
        this.f22839helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
