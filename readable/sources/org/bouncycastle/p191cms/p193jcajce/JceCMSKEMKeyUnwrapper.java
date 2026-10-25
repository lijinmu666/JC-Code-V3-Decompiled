package org.bouncycastle.p191cms.p193jcajce;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.bouncycastle.operator.AsymmetricKeyUnwrapper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.p306jcajce.JceGenericKey;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p139cms.CMSORIforKEMOtherInfo;
import org.bouncycastle.p133asn1.p139cms.KEMRecipientInfo;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p249jcajce.p279spec.KTSParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
class JceCMSKEMKeyUnwrapper extends AsymmetricKeyUnwrapper {
    private Map extraMappings;

    /* renamed from: helper */
    private JcaJceExtHelper f19080helper;
    private final int kekLength;
    private PrivateKey privateKey;
    private final AlgorithmIdentifier symWrapAlgorithm;

    public JceCMSKEMKeyUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey) {
        super(PrivateKeyInfo.getInstance(privateKey.getEncoded()).getPrivateKeyAlgorithm());
        this.f19080helper = new DefaultJcaJceExtHelper();
        this.extraMappings = new HashMap();
        KEMRecipientInfo kEMRecipientInfo = KEMRecipientInfo.getInstance(algorithmIdentifier.getParameters());
        this.privateKey = privateKey;
        this.symWrapAlgorithm = algorithmIdentifier;
        this.kekLength = CMSUtils.getKekSize(kEMRecipientInfo.m14545getWrap().getAlgorithm());
    }

    @Override // org.bouncycastle.operator.KeyUnwrapper
    public GenericKey generateUnwrappedKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) throws InvalidKeyException, OperatorException, InvalidAlgorithmParameterException {
        KEMRecipientInfo kEMRecipientInfo = KEMRecipientInfo.getInstance(this.symWrapAlgorithm.getParameters());
        AlgorithmIdentifier algorithmIdentifierM14545getWrap = kEMRecipientInfo.m14545getWrap();
        try {
            byte[] encoded = new CMSORIforKEMOtherInfo(algorithmIdentifierM14545getWrap, this.kekLength, kEMRecipientInfo.m14544getUkm()).getEncoded();
            if (!(this.privateKey instanceof RSAPrivateKey)) {
                Cipher cipherCreateAsymmetricWrapper = CMSUtils.createAsymmetricWrapper(this.f19080helper, kEMRecipientInfo.m14543getKem().getAlgorithm(), new HashMap());
                String wrapAlgorithmName = CMSUtils.getWrapAlgorithmName(algorithmIdentifierM14545getWrap.getAlgorithm());
                cipherCreateAsymmetricWrapper.init(4, this.privateKey, new KTSParameterSpec.C5801Builder(wrapAlgorithmName, this.kekLength * 8, encoded).withKdfAlgorithm(kEMRecipientInfo.m14542getKdf()).m16204build());
                return new JceGenericKey(algorithmIdentifier, cipherCreateAsymmetricWrapper.unwrap(C6238Arrays.concatenate(kEMRecipientInfo.getKemct().getOctets(), kEMRecipientInfo.getEncryptedKey().getOctets()), wrapAlgorithmName, 3));
            }
            Cipher cipherCreateAsymmetricWrapper2 = CMSUtils.createAsymmetricWrapper(this.f19080helper, kEMRecipientInfo.m14543getKem().getAlgorithm(), new HashMap());
            try {
                String wrapAlgorithmName2 = CMSUtils.getWrapAlgorithmName(algorithmIdentifierM14545getWrap.getAlgorithm());
                cipherCreateAsymmetricWrapper2.init(4, this.privateKey, new KTSParameterSpec.C5801Builder(wrapAlgorithmName2, this.kekLength * 8, encoded).withKdfAlgorithm(kEMRecipientInfo.m14542getKdf()).m16204build());
                return new JceGenericKey(algorithmIdentifier, cipherCreateAsymmetricWrapper2.unwrap(C6238Arrays.concatenate(kEMRecipientInfo.getKemct().getOctets(), kEMRecipientInfo.getEncryptedKey().getOctets()), wrapAlgorithmName2, 3));
            } catch (Exception e) {
                throw new OperatorException("Unable to wrap contents key: " + e.getMessage(), e);
            }
        } catch (Exception e2) {
            throw new OperatorException("exception encrypting key: " + e2.getMessage(), e2);
        }
    }

    public int getKekLength() {
        return this.kekLength;
    }

    public JceCMSKEMKeyUnwrapper setAlgorithmMapping(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        this.extraMappings.put(aSN1ObjectIdentifier, str);
        return this;
    }

    public JceCMSKEMKeyUnwrapper setProvider(String str) {
        this.f19080helper = new NamedJcaJceExtHelper(str);
        return this;
    }

    public JceCMSKEMKeyUnwrapper setProvider(Provider provider) {
        this.f19080helper = new ProviderJcaJceExtHelper(provider);
        return this;
    }
}
