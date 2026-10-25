package org.bouncycastle.p191cms.p193jcajce;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import org.bouncycastle.operator.DefaultSecretKeySizeProvider;
import org.bouncycastle.operator.SecretKeySizeProvider;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.cryptopro.Gost2814789EncryptedKey;
import org.bouncycastle.p133asn1.cryptopro.Gost2814789KeyWrapParameters;
import org.bouncycastle.p133asn1.p139cms.p140ecc.ECCCMSSharedInfo;
import org.bouncycastle.p133asn1.p139cms.p140ecc.MQVuserKeyingMaterial;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.KeyAgreeRecipient;
import org.bouncycastle.p249jcajce.p279spec.GOST28147WrapParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.MQVParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.UserKeyingMaterialSpec;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public abstract class JceKeyAgreeRecipient implements KeyAgreeRecipient {
    private static KeyMaterialGenerator ecc_cms_Generator;
    private static KeyMaterialGenerator old_ecc_cms_Generator;
    private static final Set possibleOldMessages;
    private static KeyMaterialGenerator simple_ecc_cmsGenerator;
    protected EnvelopedDataHelper contentHelper;

    /* renamed from: helper */
    protected EnvelopedDataHelper f19102helper;
    private SecretKeySizeProvider keySizeProvider;
    private AlgorithmIdentifier privKeyAlgID;
    private PrivateKey recipientKey;
    protected EnvelopedDataHelper unwrappingHelper;

    static {
        HashSet hashSet = new HashSet();
        possibleOldMessages = hashSet;
        hashSet.add(X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme);
        hashSet.add(X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme);
        old_ecc_cms_Generator = new KeyMaterialGenerator() { // from class: org.bouncycastle.cms.jcajce.JceKeyAgreeRecipient.1
            @Override // org.bouncycastle.p191cms.p193jcajce.KeyMaterialGenerator
            public byte[] generateKDFMaterial(AlgorithmIdentifier algorithmIdentifier, int i, byte[] bArr) {
                try {
                    return new ECCCMSSharedInfo(new AlgorithmIdentifier(algorithmIdentifier.getAlgorithm(), C5103DERNull.INSTANCE), bArr, AbstractC6245Pack.intToBigEndian(i)).getEncoded(ASN1Encoding.f17902DER);
                } catch (IOException e) {
                    throw new IllegalStateException("Unable to create KDF material: " + e);
                }
            }
        };
        simple_ecc_cmsGenerator = new KeyMaterialGenerator() { // from class: org.bouncycastle.cms.jcajce.JceKeyAgreeRecipient.2
            @Override // org.bouncycastle.p191cms.p193jcajce.KeyMaterialGenerator
            public byte[] generateKDFMaterial(AlgorithmIdentifier algorithmIdentifier, int i, byte[] bArr) {
                return bArr;
            }
        };
        ecc_cms_Generator = new RFC5753KeyMaterialGenerator();
    }

    public JceKeyAgreeRecipient(PrivateKey privateKey) {
        EnvelopedDataHelper envelopedDataHelper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
        this.f19102helper = envelopedDataHelper;
        this.contentHelper = envelopedDataHelper;
        this.unwrappingHelper = envelopedDataHelper;
        this.keySizeProvider = new DefaultSecretKeySizeProvider();
        this.privKeyAlgID = null;
        this.recipientKey = CMSUtils.cleanPrivateKey(privateKey);
    }

    private SecretKey calculateAgreedWrapKey(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, PublicKey publicKey, ASN1OctetString aSN1OctetString, PrivateKey privateKey, KeyMaterialGenerator keyMaterialGenerator) throws IllegalStateException, InvalidKeySpecException, CMSException, InvalidKeyException, InvalidAlgorithmParameterException {
        PrivateKey privateKeyCleanPrivateKey = CMSUtils.cleanPrivateKey(privateKey);
        UserKeyingMaterialSpec userKeyingMaterialSpec = null;
        userKeyingMaterialSpec = null;
        if (CMSUtils.m14919isMQV(algorithmIdentifier.getAlgorithm())) {
            MQVuserKeyingMaterial mQVuserKeyingMaterial = MQVuserKeyingMaterial.getInstance(aSN1OctetString.getOctets());
            PublicKey publicKeyGeneratePublic = this.f19102helper.createKeyFactory(algorithmIdentifier.getAlgorithm()).generatePublic(new X509EncodedKeySpec(new SubjectPublicKeyInfo(getPrivateKeyAlgorithmIdentifier(), mQVuserKeyingMaterial.getEphemeralPublicKey().getPublicKeyData()).getEncoded()));
            KeyAgreement keyAgreementCreateKeyAgreement = this.f19102helper.createKeyAgreement(algorithmIdentifier.getAlgorithm());
            byte[] octets = mQVuserKeyingMaterial.getAddedukm() != null ? mQVuserKeyingMaterial.getAddedukm().getOctets() : null;
            KeyMaterialGenerator keyMaterialGenerator2 = old_ecc_cms_Generator;
            if (keyMaterialGenerator == keyMaterialGenerator2) {
                octets = keyMaterialGenerator2.generateKDFMaterial(algorithmIdentifier2, this.keySizeProvider.getKeySize(algorithmIdentifier2), octets);
            }
            keyAgreementCreateKeyAgreement.init(privateKeyCleanPrivateKey, new MQVParameterSpec(privateKeyCleanPrivateKey, publicKeyGeneratePublic, octets));
            keyAgreementCreateKeyAgreement.doPhase(publicKey, true);
            return keyAgreementCreateKeyAgreement.generateSecret(algorithmIdentifier2.getAlgorithm().m14433getId());
        }
        KeyAgreement keyAgreementCreateKeyAgreement2 = this.f19102helper.createKeyAgreement(algorithmIdentifier.getAlgorithm());
        if (CMSUtils.m14917isEC(algorithmIdentifier.getAlgorithm())) {
            int keySize = this.keySizeProvider.getKeySize(algorithmIdentifier2);
            userKeyingMaterialSpec = new UserKeyingMaterialSpec(aSN1OctetString != null ? keyMaterialGenerator.generateKDFMaterial(algorithmIdentifier2, keySize, aSN1OctetString.getOctets()) : keyMaterialGenerator.generateKDFMaterial(algorithmIdentifier2, keySize, null));
        } else if (CMSUtils.isRFC2631(algorithmIdentifier.getAlgorithm())) {
            if (aSN1OctetString != null) {
                userKeyingMaterialSpec = new UserKeyingMaterialSpec(aSN1OctetString.getOctets());
            }
        } else {
            if (!CMSUtils.m14918isGOST(algorithmIdentifier.getAlgorithm())) {
                throw new CMSException("Unknown key agreement algorithm: " + algorithmIdentifier.getAlgorithm());
            }
            if (aSN1OctetString != null) {
                userKeyingMaterialSpec = new UserKeyingMaterialSpec(aSN1OctetString.getOctets());
            }
        }
        keyAgreementCreateKeyAgreement2.init(privateKeyCleanPrivateKey, userKeyingMaterialSpec);
        keyAgreementCreateKeyAgreement2.doPhase(publicKey, true);
        return keyAgreementCreateKeyAgreement2.generateSecret(algorithmIdentifier2.getAlgorithm().m14433getId());
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Key extractSecretKey(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, SubjectPublicKeyInfo subjectPublicKeyInfo, ASN1OctetString aSN1OctetString, byte[] bArr) throws InvalidKeySpecException, CMSException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            try {
                AlgorithmIdentifier algorithmIdentifier3 = AlgorithmIdentifier.getInstance(algorithmIdentifier.getParameters());
                ASN1ObjectIdentifier algorithm = algorithmIdentifier3.getAlgorithm();
                PublicKey publicKeyGeneratePublic = this.f19102helper.createKeyFactory(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()).generatePublic(new X509EncodedKeySpec(subjectPublicKeyInfo.getEncoded()));
                try {
                    SecretKey secretKeyCalculateAgreedWrapKey = calculateAgreedWrapKey(algorithmIdentifier, algorithmIdentifier3, publicKeyGeneratePublic, aSN1OctetString, this.recipientKey, ecc_cms_Generator);
                    if (!CryptoProObjectIdentifiers.id_Gost28147_89_None_KeyWrap.m14446equals((ASN1Primitive) algorithm) && !CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_KeyWrap.m14446equals((ASN1Primitive) algorithm)) {
                        return unwrapSessionKey(algorithm, secretKeyCalculateAgreedWrapKey, algorithmIdentifier2.getAlgorithm(), bArr);
                    }
                    Gost2814789EncryptedKey gost2814789EncryptedKey = Gost2814789EncryptedKey.getInstance(bArr);
                    Gost2814789KeyWrapParameters gost2814789KeyWrapParameters = Gost2814789KeyWrapParameters.getInstance(algorithmIdentifier3.getParameters());
                    Cipher cipherCreateCipher = this.f19102helper.createCipher(algorithm);
                    cipherCreateCipher.init(4, secretKeyCalculateAgreedWrapKey, new GOST28147WrapParameterSpec(gost2814789KeyWrapParameters.getEncryptionParamSet(), aSN1OctetString.getOctets()));
                    return cipherCreateCipher.unwrap(C6238Arrays.concatenate(gost2814789EncryptedKey.getEncryptedKey(), gost2814789EncryptedKey.getMacKey()), this.f19102helper.getBaseCipherName(algorithmIdentifier2.getAlgorithm()), 3);
                } catch (InvalidKeyException e) {
                    if (possibleOldMessages.contains(algorithmIdentifier.getAlgorithm())) {
                        return unwrapSessionKey(algorithm, calculateAgreedWrapKey(algorithmIdentifier, algorithmIdentifier3, publicKeyGeneratePublic, aSN1OctetString, this.recipientKey, old_ecc_cms_Generator), algorithmIdentifier2.getAlgorithm(), bArr);
                    }
                    if (aSN1OctetString == null) {
                        throw e;
                    }
                    try {
                        return unwrapSessionKey(algorithm, calculateAgreedWrapKey(algorithmIdentifier, algorithmIdentifier3, publicKeyGeneratePublic, aSN1OctetString, this.recipientKey, simple_ecc_cmsGenerator), algorithmIdentifier2.getAlgorithm(), bArr);
                    } catch (InvalidKeyException unused) {
                        throw e;
                    }
                }
            } catch (InvalidKeyException e2) {
                throw new CMSException("key invalid in message.", e2);
            }
        } catch (NoSuchAlgorithmException e3) {
            throw new CMSException("can't find algorithm.", e3);
        } catch (InvalidKeySpecException e4) {
            throw new CMSException("originator key spec invalid.", e4);
        } catch (NoSuchPaddingException e5) {
            throw new CMSException("required padding not supported.", e5);
        } catch (Exception e6) {
            throw new CMSException("originator key invalid.", e6);
        }
    }

    @Override // org.bouncycastle.p191cms.KeyAgreeRecipient
    public AlgorithmIdentifier getPrivateKeyAlgorithmIdentifier() {
        if (this.privKeyAlgID == null) {
            this.privKeyAlgID = PrivateKeyInfo.getInstance(this.recipientKey.getEncoded()).getPrivateKeyAlgorithm();
        }
        return this.privKeyAlgID;
    }

    public JceKeyAgreeRecipient setContentProvider(String str) {
        this.contentHelper = CMSUtils.createContentHelper(str);
        return this;
    }

    public JceKeyAgreeRecipient setPrivateKeyAlgorithmIdentifier(AlgorithmIdentifier algorithmIdentifier) {
        this.privKeyAlgID = algorithmIdentifier;
        return this;
    }

    public JceKeyAgreeRecipient setProvider(String str) {
        EnvelopedDataHelper envelopedDataHelper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(str));
        this.f19102helper = envelopedDataHelper;
        this.contentHelper = envelopedDataHelper;
        this.unwrappingHelper = envelopedDataHelper;
        return this;
    }

    public JceKeyAgreeRecipient setUnwrappingProvider(String str) {
        this.unwrappingHelper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(str));
        return this;
    }

    public Key unwrapSessionKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, SecretKey secretKey, ASN1ObjectIdentifier aSN1ObjectIdentifier2, byte[] bArr) throws CMSException, InvalidKeyException {
        Cipher cipherCreateCipher = this.unwrappingHelper.createCipher(aSN1ObjectIdentifier);
        cipherCreateCipher.init(4, secretKey);
        return cipherCreateCipher.unwrap(bArr, this.f19102helper.getBaseCipherName(aSN1ObjectIdentifier2), 3);
    }

    public JceKeyAgreeRecipient setContentProvider(Provider provider) {
        this.contentHelper = CMSUtils.createContentHelper(provider);
        return this;
    }

    public JceKeyAgreeRecipient setProvider(Provider provider) {
        EnvelopedDataHelper envelopedDataHelper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(provider));
        this.f19102helper = envelopedDataHelper;
        this.contentHelper = envelopedDataHelper;
        this.unwrappingHelper = envelopedDataHelper;
        return this;
    }

    public JceKeyAgreeRecipient setUnwrappingProvider(Provider provider) {
        this.unwrappingHelper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(provider));
        return this;
    }
}
