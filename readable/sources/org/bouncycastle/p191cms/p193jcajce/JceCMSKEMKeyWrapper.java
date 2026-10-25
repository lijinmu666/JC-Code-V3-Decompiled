package org.bouncycastle.p191cms.p193jcajce;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import org.bouncycastle.operator.DefaultKemEncapsulationLengthProvider;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.KemEncapsulationLengthProvider;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p139cms.CMSORIforKEMOtherInfo;
import org.bouncycastle.p133asn1.p156iso.ISOIECObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p191cms.KEMKeyWrapper;
import org.bouncycastle.p249jcajce.p279spec.KTSParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
class JceCMSKEMKeyWrapper extends KEMKeyWrapper {
    private byte[] encapsulation;
    private Map extraMappings;

    /* renamed from: helper */
    private JcaJceExtHelper f19081helper;
    private AlgorithmIdentifier kdfAlgorithm;
    private final int kekLength;
    private final KemEncapsulationLengthProvider kemEncLenProvider;
    private PublicKey publicKey;

    /* renamed from: random */
    private SecureRandom f19082random;
    private final AlgorithmIdentifier symWrapAlgorithm;

    public JceCMSKEMKeyWrapper(PublicKey publicKey, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        super(publicKey instanceof RSAPublicKey ? new AlgorithmIdentifier(ISOIECObjectIdentifiers.id_kem_rsa) : SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()).getAlgorithm());
        this.kemEncLenProvider = new DefaultKemEncapsulationLengthProvider();
        this.f19081helper = new DefaultJcaJceExtHelper();
        this.extraMappings = new HashMap();
        this.kdfAlgorithm = new AlgorithmIdentifier(X9ObjectIdentifiers.id_kdf_kdf3, new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256, C5103DERNull.INSTANCE));
        this.publicKey = publicKey;
        this.symWrapAlgorithm = new AlgorithmIdentifier(aSN1ObjectIdentifier);
        this.kekLength = CMSUtils.getKekSize(aSN1ObjectIdentifier);
    }

    private int getKemEncLength(PublicKey publicKey) {
        return this.kemEncLenProvider.getEncapsulationLength(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()).getAlgorithm());
    }

    @Override // org.bouncycastle.operator.KeyWrapper
    public byte[] generateWrappedKey(GenericKey genericKey) throws IllegalBlockSizeException, InvalidKeyException, OperatorException, InvalidAlgorithmParameterException {
        try {
            byte[] encoded = new CMSORIforKEMOtherInfo(this.symWrapAlgorithm, this.kekLength).getEncoded();
            if (this.publicKey instanceof RSAPublicKey) {
                Cipher cipherCreateAsymmetricWrapper = CMSUtils.createAsymmetricWrapper(this.f19081helper, getAlgorithmIdentifier().getAlgorithm(), new HashMap());
                try {
                    cipherCreateAsymmetricWrapper.init(3, this.publicKey, new KTSParameterSpec.C5801Builder(CMSUtils.getWrapAlgorithmName(this.symWrapAlgorithm.getAlgorithm()), this.kekLength * 8, encoded).withKdfAlgorithm(this.kdfAlgorithm).m16204build(), this.f19082random);
                    byte[] bArrWrap = cipherCreateAsymmetricWrapper.wrap(CMSUtils.getJceKey(genericKey));
                    int iBitLength = (((RSAPublicKey) this.publicKey).getModulus().bitLength() + 7) / 8;
                    this.encapsulation = C6238Arrays.copyOfRange(bArrWrap, 0, iBitLength);
                    return C6238Arrays.copyOfRange(bArrWrap, iBitLength, bArrWrap.length);
                } catch (Exception e) {
                    throw new OperatorException("Unable to wrap contents key: " + e.getMessage(), e);
                }
            }
            Cipher cipherCreateAsymmetricWrapper2 = CMSUtils.createAsymmetricWrapper(this.f19081helper, getAlgorithmIdentifier().getAlgorithm(), new HashMap());
            try {
                cipherCreateAsymmetricWrapper2.init(3, this.publicKey, new KTSParameterSpec.C5801Builder(CMSUtils.getWrapAlgorithmName(this.symWrapAlgorithm.getAlgorithm()), this.kekLength * 8, encoded).withKdfAlgorithm(this.kdfAlgorithm).m16204build(), this.f19082random);
                byte[] bArrWrap2 = cipherCreateAsymmetricWrapper2.wrap(CMSUtils.getJceKey(genericKey));
                int kemEncLength = getKemEncLength(this.publicKey);
                this.encapsulation = C6238Arrays.copyOfRange(bArrWrap2, 0, kemEncLength);
                return C6238Arrays.copyOfRange(bArrWrap2, kemEncLength, bArrWrap2.length);
            } catch (Exception e2) {
                throw new OperatorException("Unable to wrap contents key: " + e2.getMessage(), e2);
            }
        } catch (Exception e3) {
            throw new OperatorException("unable to wrap contents key: " + e3.getMessage(), e3);
        }
        throw new OperatorException("unable to wrap contents key: " + e3.getMessage(), e3);
    }

    @Override // org.bouncycastle.p191cms.KEMKeyWrapper
    public byte[] getEncapsulation() {
        return this.encapsulation;
    }

    @Override // org.bouncycastle.p191cms.KEMKeyWrapper
    public AlgorithmIdentifier getKdfAlgorithmIdentifier() {
        return this.kdfAlgorithm;
    }

    @Override // org.bouncycastle.p191cms.KEMKeyWrapper
    public int getKekLength() {
        return this.kekLength;
    }

    @Override // org.bouncycastle.p191cms.KEMKeyWrapper
    public AlgorithmIdentifier getWrapAlgorithmIdentifier() {
        return this.symWrapAlgorithm;
    }

    public JceCMSKEMKeyWrapper setAlgorithmMapping(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        this.extraMappings.put(aSN1ObjectIdentifier, str);
        return this;
    }

    /* renamed from: setKDF */
    public JceCMSKEMKeyWrapper m14938setKDF(AlgorithmIdentifier algorithmIdentifier) {
        this.kdfAlgorithm = algorithmIdentifier;
        return this;
    }

    public JceCMSKEMKeyWrapper setProvider(String str) {
        this.f19081helper = new NamedJcaJceExtHelper(str);
        return this;
    }

    public JceCMSKEMKeyWrapper setSecureRandom(SecureRandom secureRandom) {
        this.f19082random = secureRandom;
        return this;
    }

    public JceCMSKEMKeyWrapper setProvider(Provider provider) {
        this.f19081helper = new ProviderJcaJceExtHelper(provider);
        return this;
    }
}
