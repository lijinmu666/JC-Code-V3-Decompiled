package org.bouncycastle.p191cms.p193jcajce;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.p306jcajce.JceAsymmetricKeyUnwrapper;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.cryptopro.Gost2814789EncryptedKey;
import org.bouncycastle.p133asn1.cryptopro.GostR3410KeyTransport;
import org.bouncycastle.p133asn1.cryptopro.GostR3410TransportParameters;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.KEMRecipientInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.KeyTransRecipient;
import org.bouncycastle.p249jcajce.p279spec.GOST28147WrapParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.UserKeyingMaterialSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public abstract class JceKeyTransRecipient implements KeyTransRecipient {
    protected EnvelopedDataHelper contentHelper;
    protected Map extraMappings;

    /* renamed from: helper */
    protected EnvelopedDataHelper f19107helper;
    private PrivateKey recipientKey;
    protected boolean unwrappedKeyMustBeEncodable;
    protected boolean validateKeySize;

    public JceKeyTransRecipient(PrivateKey privateKey) {
        EnvelopedDataHelper envelopedDataHelper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
        this.f19107helper = envelopedDataHelper;
        this.contentHelper = envelopedDataHelper;
        this.extraMappings = new HashMap();
        this.validateKeySize = false;
        this.recipientKey = CMSUtils.cleanPrivateKey(privateKey);
    }

    public Key extractSecretKey(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, byte[] bArr) throws IllegalStateException, InvalidKeySpecException, CMSException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        EnvelopedDataHelper envelopedDataHelper;
        if (CMSUtils.m14918isGOST(algorithmIdentifier.getAlgorithm())) {
            try {
                GostR3410KeyTransport gostR3410KeyTransport = GostR3410KeyTransport.getInstance(bArr);
                GostR3410TransportParameters transportParameters = gostR3410KeyTransport.getTransportParameters();
                PublicKey publicKeyGeneratePublic = this.f19107helper.createKeyFactory(algorithmIdentifier.getAlgorithm()).generatePublic(new X509EncodedKeySpec(transportParameters.getEphemeralPublicKey().getEncoded()));
                KeyAgreement keyAgreementCreateKeyAgreement = this.f19107helper.createKeyAgreement(algorithmIdentifier.getAlgorithm());
                keyAgreementCreateKeyAgreement.init(this.recipientKey, new UserKeyingMaterialSpec(transportParameters.m14581getUkm()));
                keyAgreementCreateKeyAgreement.doPhase(publicKeyGeneratePublic, true);
                ASN1ObjectIdentifier aSN1ObjectIdentifier = CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_KeyWrap;
                SecretKey secretKeyGenerateSecret = keyAgreementCreateKeyAgreement.generateSecret(aSN1ObjectIdentifier.m14433getId());
                Cipher cipherCreateCipher = this.f19107helper.createCipher(aSN1ObjectIdentifier);
                cipherCreateCipher.init(4, secretKeyGenerateSecret, new GOST28147WrapParameterSpec(transportParameters.getEncryptionParamSet(), transportParameters.m14581getUkm()));
                Gost2814789EncryptedKey sessionEncryptedKey = gostR3410KeyTransport.getSessionEncryptedKey();
                return cipherCreateCipher.unwrap(C6238Arrays.concatenate(sessionEncryptedKey.getEncryptedKey(), sessionEncryptedKey.getMacKey()), this.f19107helper.getBaseCipherName(algorithmIdentifier2.getAlgorithm()), 3);
            } catch (Exception e) {
                throw new CMSException("exception unwrapping key: " + e.getMessage(), e);
            }
        }
        if (CMSObjectIdentifiers.id_ori_kem.m14446equals((ASN1Primitive) algorithmIdentifier.getAlgorithm())) {
            JceAsymmetricKeyUnwrapper mustProduceEncodableUnwrappedKey = this.f19107helper.createAsymmetricUnwrapper(KEMRecipientInfo.getInstance(algorithmIdentifier.getParameters()).m14543getKem(), this.recipientKey).setMustProduceEncodableUnwrappedKey(this.unwrappedKeyMustBeEncodable);
            if (!this.extraMappings.isEmpty()) {
                for (ASN1ObjectIdentifier aSN1ObjectIdentifier2 : this.extraMappings.keySet()) {
                    mustProduceEncodableUnwrappedKey.setAlgorithmMapping(aSN1ObjectIdentifier2, (String) this.extraMappings.get(aSN1ObjectIdentifier2));
                }
            }
            try {
                Key jceKey = this.f19107helper.getJceKey(algorithmIdentifier2, mustProduceEncodableUnwrappedKey.generateUnwrappedKey(algorithmIdentifier2, bArr));
                if (this.validateKeySize) {
                    this.f19107helper.keySizeCheck(algorithmIdentifier2, jceKey);
                }
                return jceKey;
            } catch (OperatorException e2) {
                throw new CMSException("exception unwrapping key: " + e2.getMessage(), e2);
            }
        }
        JceAsymmetricKeyUnwrapper mustProduceEncodableUnwrappedKey2 = this.f19107helper.createAsymmetricUnwrapper(algorithmIdentifier, this.recipientKey).setMustProduceEncodableUnwrappedKey(this.unwrappedKeyMustBeEncodable);
        if (!this.extraMappings.isEmpty()) {
            for (ASN1ObjectIdentifier aSN1ObjectIdentifier3 : this.extraMappings.keySet()) {
                mustProduceEncodableUnwrappedKey2.setAlgorithmMapping(aSN1ObjectIdentifier3, (String) this.extraMappings.get(aSN1ObjectIdentifier3));
            }
        }
        try {
            Key jceKey2 = this.f19107helper.getJceKey(algorithmIdentifier2, mustProduceEncodableUnwrappedKey2.generateUnwrappedKey(algorithmIdentifier2, bArr));
            if (this.validateKeySize) {
                if (bArr.equals(CMSObjectIdentifiers.id_alg_cek_hkdf_sha256)) {
                    envelopedDataHelper = this.f19107helper;
                    algorithmIdentifier2 = AlgorithmIdentifier.getInstance(algorithmIdentifier2.getParameters());
                } else {
                    envelopedDataHelper = this.f19107helper;
                }
                envelopedDataHelper.keySizeCheck(algorithmIdentifier2, jceKey2);
            }
            return jceKey2;
        } catch (OperatorException e3) {
            throw new CMSException("exception unwrapping key: " + e3.getMessage(), e3);
        }
    }

    public JceKeyTransRecipient setAlgorithmMapping(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        this.extraMappings.put(aSN1ObjectIdentifier, str);
        return this;
    }

    public JceKeyTransRecipient setContentProvider(String str) {
        this.contentHelper = CMSUtils.createContentHelper(str);
        return this;
    }

    public JceKeyTransRecipient setKeySizeValidation(boolean z) {
        this.validateKeySize = z;
        return this;
    }

    public JceKeyTransRecipient setMustProduceEncodableUnwrappedKey(boolean z) {
        this.unwrappedKeyMustBeEncodable = z;
        return this;
    }

    public JceKeyTransRecipient setProvider(String str) {
        EnvelopedDataHelper envelopedDataHelper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(str));
        this.f19107helper = envelopedDataHelper;
        this.contentHelper = envelopedDataHelper;
        return this;
    }

    public JceKeyTransRecipient setContentProvider(Provider provider) {
        this.contentHelper = CMSUtils.createContentHelper(provider);
        return this;
    }

    public JceKeyTransRecipient setProvider(Provider provider) {
        EnvelopedDataHelper envelopedDataHelper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(provider));
        this.f19107helper = envelopedDataHelper;
        this.contentHelper = envelopedDataHelper;
        return this;
    }
}
