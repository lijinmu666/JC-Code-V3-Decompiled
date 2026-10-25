package org.bouncycastle.p191cms.p193jcajce;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import org.bouncycastle.operator.DefaultSecretKeySizeProvider;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.SecretKeySizeProvider;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.cryptopro.Gost2814789EncryptedKey;
import org.bouncycastle.p133asn1.p139cms.KeyAgreeRecipientIdentifier;
import org.bouncycastle.p133asn1.p139cms.RecipientEncryptedKey;
import org.bouncycastle.p133asn1.p139cms.RecipientKeyIdentifier;
import org.bouncycastle.p133asn1.p139cms.p140ecc.MQVuserKeyingMaterial;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.KeyAgreeRecipientInfoGenerator;
import org.bouncycastle.p249jcajce.p279spec.GOST28147WrapParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.MQVParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.UserKeyingMaterialSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class JceKeyAgreeRecipientInfoGenerator extends KeyAgreeRecipientInfoGenerator {
    private static KeyMaterialGenerator ecc_cms_Generator = new RFC5753KeyMaterialGenerator();
    private KeyPair ephemeralKP;

    /* renamed from: helper */
    private EnvelopedDataHelper f19103helper;
    private SecretKeySizeProvider keySizeProvider;

    /* renamed from: random */
    private SecureRandom f19104random;
    private List recipientIDs;
    private List recipientKeys;
    private PrivateKey senderPrivateKey;
    private PublicKey senderPublicKey;
    private byte[] userKeyingMaterial;
    private EnvelopedDataHelper wrappingHelper;

    public JceKeyAgreeRecipientInfoGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier, PrivateKey privateKey, PublicKey publicKey, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        super(aSN1ObjectIdentifier, SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()), aSN1ObjectIdentifier2);
        this.keySizeProvider = new DefaultSecretKeySizeProvider();
        this.recipientIDs = new ArrayList();
        this.recipientKeys = new ArrayList();
        this.f19103helper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
        this.wrappingHelper = null;
        this.senderPublicKey = publicKey;
        this.senderPrivateKey = CMSUtils.cleanPrivateKey(privateKey);
    }

    /* renamed from: init */
    private void m14941init(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CMSException, IOException, InvalidAlgorithmParameterException {
        if (this.f19104random == null) {
            this.f19104random = new SecureRandom();
        }
        if (CMSUtils.m14919isMQV(aSN1ObjectIdentifier) && this.ephemeralKP == null) {
            try {
                SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(this.senderPublicKey.getEncoded());
                AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f19103helper.createAlgorithmParameters(aSN1ObjectIdentifier);
                algorithmParametersCreateAlgorithmParameters.init(subjectPublicKeyInfo.getAlgorithm().getParameters().toASN1Primitive().getEncoded());
                KeyPairGenerator keyPairGeneratorCreateKeyPairGenerator = this.f19103helper.createKeyPairGenerator(aSN1ObjectIdentifier);
                keyPairGeneratorCreateKeyPairGenerator.initialize(algorithmParametersCreateAlgorithmParameters.getParameterSpec(AlgorithmParameterSpec.class), this.f19104random);
                this.ephemeralKP = keyPairGeneratorCreateKeyPairGenerator.generateKeyPair();
            } catch (Exception e) {
                throw new CMSException("cannot determine MQV ephemeral key pair parameters from public key: " + e, e);
            }
        }
    }

    public JceKeyAgreeRecipientInfoGenerator addRecipient(X509Certificate x509Certificate) {
        this.recipientIDs.add(new KeyAgreeRecipientIdentifier(CMSUtils.getIssuerAndSerialNumber(x509Certificate)));
        this.recipientKeys.add(x509Certificate.getPublicKey());
        return this;
    }

    @Override // org.bouncycastle.p191cms.KeyAgreeRecipientInfoGenerator
    public ASN1Sequence generateRecipientEncryptedKeys(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, GenericKey genericKey) throws IllegalStateException, IllegalBlockSizeException, CMSException, NoSuchAlgorithmException, IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        UserKeyingMaterialSpec userKeyingMaterialSpec;
        AlgorithmParameterSpec mQVParameterSpec;
        byte[] encoded;
        if (this.recipientIDs.isEmpty()) {
            throw new CMSException("No recipients associated with generator - use addRecipient()");
        }
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        m14941init(algorithm);
        PrivateKey privateKey = this.senderPrivateKey;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (int i = 0; i != this.recipientIDs.size(); i++) {
            PublicKey publicKey = (PublicKey) this.recipientKeys.get(i);
            KeyAgreeRecipientIdentifier keyAgreeRecipientIdentifier = (KeyAgreeRecipientIdentifier) this.recipientIDs.get(i);
            try {
                ASN1ObjectIdentifier algorithm2 = algorithmIdentifier2.getAlgorithm();
                if (CMSUtils.m14919isMQV(algorithm)) {
                    mQVParameterSpec = new MQVParameterSpec(this.ephemeralKP, publicKey, this.userKeyingMaterial);
                } else {
                    if (CMSUtils.m14917isEC(algorithm)) {
                        userKeyingMaterialSpec = new UserKeyingMaterialSpec(ecc_cms_Generator.generateKDFMaterial(algorithmIdentifier2, this.keySizeProvider.getKeySize(algorithm2), this.userKeyingMaterial));
                    } else if (CMSUtils.isRFC2631(algorithm)) {
                        byte[] bArr = this.userKeyingMaterial;
                        if (bArr != null) {
                            userKeyingMaterialSpec = new UserKeyingMaterialSpec(bArr);
                        } else {
                            if (algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_alg_SSDH)) {
                                throw new CMSException("User keying material must be set for static keys.");
                            }
                            mQVParameterSpec = null;
                        }
                    } else {
                        if (!CMSUtils.m14918isGOST(algorithm)) {
                            throw new CMSException("Unknown key agreement algorithm: " + algorithm);
                        }
                        byte[] bArr2 = this.userKeyingMaterial;
                        if (bArr2 == null) {
                            throw new CMSException("User keying material must be set for static keys.");
                        }
                        userKeyingMaterialSpec = new UserKeyingMaterialSpec(bArr2);
                    }
                    mQVParameterSpec = userKeyingMaterialSpec;
                }
                KeyAgreement keyAgreementCreateKeyAgreement = this.f19103helper.createKeyAgreement(algorithm);
                keyAgreementCreateKeyAgreement.init(privateKey, mQVParameterSpec, this.f19104random);
                keyAgreementCreateKeyAgreement.doPhase(publicKey, true);
                SecretKey secretKeyGenerateSecret = keyAgreementCreateKeyAgreement.generateSecret(algorithm2.m14433getId());
                EnvelopedDataHelper envelopedDataHelper = this.wrappingHelper;
                if (envelopedDataHelper == null) {
                    envelopedDataHelper = this.f19103helper;
                }
                Cipher cipherCreateCipher = envelopedDataHelper.createCipher(algorithm2);
                if (CryptoProObjectIdentifiers.id_Gost28147_89_None_KeyWrap.m14446equals((ASN1Primitive) algorithm2) || CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_KeyWrap.m14446equals((ASN1Primitive) algorithm2)) {
                    cipherCreateCipher.init(3, secretKeyGenerateSecret, new GOST28147WrapParameterSpec(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_A_ParamSet, this.userKeyingMaterial));
                    byte[] bArrWrap = cipherCreateCipher.wrap(envelopedDataHelper.getJceKey(genericKey));
                    encoded = new Gost2814789EncryptedKey(C6238Arrays.copyOfRange(bArrWrap, 0, bArrWrap.length - 4), C6238Arrays.copyOfRange(bArrWrap, bArrWrap.length - 4, bArrWrap.length)).getEncoded(ASN1Encoding.f17902DER);
                } else {
                    cipherCreateCipher.init(3, secretKeyGenerateSecret, this.f19104random);
                    encoded = cipherCreateCipher.wrap(envelopedDataHelper.getJceKey(genericKey));
                }
                aSN1EncodableVector.m14420add(new RecipientEncryptedKey(keyAgreeRecipientIdentifier, new DEROctetString(encoded)));
            } catch (IOException e) {
                throw new CMSException("unable to encode wrapped key: " + e.getMessage(), e);
            } catch (GeneralSecurityException e2) {
                throw new CMSException("cannot perform agreement step: " + e2.getMessage(), e2);
            }
        }
        return new DERSequence(aSN1EncodableVector);
    }

    @Override // org.bouncycastle.p191cms.KeyAgreeRecipientInfoGenerator
    public byte[] getUserKeyingMaterial(AlgorithmIdentifier algorithmIdentifier) throws CMSException, IOException, InvalidAlgorithmParameterException {
        m14941init(algorithmIdentifier.getAlgorithm());
        KeyPair keyPair = this.ephemeralKP;
        if (keyPair == null) {
            return this.userKeyingMaterial;
        }
        try {
            return new MQVuserKeyingMaterial(createOriginatorPublicKey(SubjectPublicKeyInfo.getInstance(keyPair.getPublic().getEncoded())), DEROctetString.fromContentsOptional(this.userKeyingMaterial)).getEncoded();
        } catch (IOException e) {
            throw new CMSException("unable to encode user keying material: " + e.getMessage(), e);
        }
    }

    public JceKeyAgreeRecipientInfoGenerator setKeyWrappingProvider(String str) {
        this.wrappingHelper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(str));
        return this;
    }

    public JceKeyAgreeRecipientInfoGenerator setProvider(String str) {
        this.f19103helper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(str));
        return this;
    }

    public JceKeyAgreeRecipientInfoGenerator setSecureRandom(SecureRandom secureRandom) {
        this.f19104random = secureRandom;
        return this;
    }

    public JceKeyAgreeRecipientInfoGenerator setUserKeyingMaterial(byte[] bArr) {
        this.userKeyingMaterial = C6238Arrays.m18231clone(bArr);
        return this;
    }

    public JceKeyAgreeRecipientInfoGenerator addRecipient(byte[] bArr, PublicKey publicKey) {
        this.recipientIDs.add(new KeyAgreeRecipientIdentifier(new RecipientKeyIdentifier(bArr)));
        this.recipientKeys.add(publicKey);
        return this;
    }

    public JceKeyAgreeRecipientInfoGenerator setKeyWrappingProvider(Provider provider) {
        this.wrappingHelper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(provider));
        return this;
    }

    public JceKeyAgreeRecipientInfoGenerator setProvider(Provider provider) {
        this.f19103helper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(provider));
        return this;
    }
}
