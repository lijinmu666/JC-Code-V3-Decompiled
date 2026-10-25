package org.bouncycastle.operator.p306jcajce;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import javax.crypto.Cipher;
import org.bouncycastle.operator.AsymmetricKeyWrapper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.p133asn1.p139cms.GenericHybridParameters;
import org.bouncycastle.p133asn1.p139cms.RsaKemParameters;
import org.bouncycastle.p133asn1.p156iso.ISOIECObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p194crypto.p221util.DEROtherInfo;
import org.bouncycastle.p249jcajce.p279spec.KTSParameterSpec;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class JceKTSKeyWrapper extends AsymmetricKeyWrapper {

    /* renamed from: helper */
    private OperatorHelper f22916helper;
    private final int keySizeInBits;
    private final byte[] partyUInfo;
    private final byte[] partyVInfo;
    private PublicKey publicKey;

    /* renamed from: random */
    private SecureRandom f22917random;
    private final String symmetricWrappingAlg;

    public JceKTSKeyWrapper(PublicKey publicKey, String str, int i, byte[] bArr, byte[] bArr2) {
        super(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_rsa_KEM, new GenericHybridParameters(new AlgorithmIdentifier(ISOIECObjectIdentifiers.id_kem_rsa, new RsaKemParameters(new AlgorithmIdentifier(X9ObjectIdentifiers.id_kdf_kdf3, new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256)), (i + 7) / 8)), JceSymmetricKeyWrapper.determineKeyEncAlg(str, i))));
        this.f22916helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.publicKey = publicKey;
        this.symmetricWrappingAlg = str;
        this.keySizeInBits = i;
        this.partyUInfo = C6238Arrays.m18231clone(bArr);
        this.partyVInfo = C6238Arrays.m18231clone(bArr2);
    }

    @Override // org.bouncycastle.operator.KeyWrapper
    public byte[] generateWrappedKey(GenericKey genericKey) throws InvalidKeyException, OperatorException, InvalidAlgorithmParameterException {
        Cipher cipherCreateAsymmetricWrapper = this.f22916helper.createAsymmetricWrapper(getAlgorithmIdentifier(), new HashMap());
        try {
            cipherCreateAsymmetricWrapper.init(3, this.publicKey, new KTSParameterSpec.C5801Builder(this.symmetricWrappingAlg, this.keySizeInBits, new DEROtherInfo.C5403Builder(JceSymmetricKeyWrapper.determineKeyEncAlg(this.symmetricWrappingAlg, this.keySizeInBits), this.partyUInfo, this.partyVInfo).m15924build().getEncoded()).m16204build(), this.f22917random);
            return cipherCreateAsymmetricWrapper.wrap(OperatorUtils.getJceKey(genericKey));
        } catch (Exception e) {
            throw new OperatorException("Unable to wrap contents key: " + e.getMessage(), e);
        }
    }

    public JceKTSKeyWrapper setProvider(String str) {
        this.f22916helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JceKTSKeyWrapper setSecureRandom(SecureRandom secureRandom) {
        this.f22917random = secureRandom;
        return this;
    }

    public JceKTSKeyWrapper(X509Certificate x509Certificate, String str, int i, byte[] bArr, byte[] bArr2) {
        this(x509Certificate.getPublicKey(), str, i, bArr, bArr2);
    }

    public JceKTSKeyWrapper setProvider(Provider provider) {
        this.f22916helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }
}
