package org.bouncycastle.operator.p306jcajce;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.bouncycastle.operator.AsymmetricKeyUnwrapper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.p133asn1.p139cms.GenericHybridParameters;
import org.bouncycastle.p133asn1.p139cms.RsaKemParameters;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.p221util.DEROtherInfo;
import org.bouncycastle.p249jcajce.p279spec.KTSParameterSpec;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class JceKTSKeyUnwrapper extends AsymmetricKeyUnwrapper {
    private Map extraMappings;

    /* renamed from: helper */
    private OperatorHelper f22914helper;
    private byte[] partyUInfo;
    private byte[] partyVInfo;

    /* renamed from: privKey */
    private PrivateKey f22915privKey;

    public JceKTSKeyUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey, byte[] bArr, byte[] bArr2) {
        super(algorithmIdentifier);
        this.f22914helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.extraMappings = new HashMap();
        this.f22915privKey = privateKey;
        this.partyUInfo = C6238Arrays.m18231clone(bArr);
        this.partyVInfo = C6238Arrays.m18231clone(bArr2);
    }

    @Override // org.bouncycastle.operator.KeyUnwrapper
    public GenericKey generateUnwrappedKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) throws InvalidKeyException, OperatorException, InvalidAlgorithmParameterException {
        GenericHybridParameters genericHybridParameters = GenericHybridParameters.getInstance(getAlgorithmIdentifier().getParameters());
        Cipher cipherCreateAsymmetricWrapper = this.f22914helper.createAsymmetricWrapper(getAlgorithmIdentifier(), this.extraMappings);
        String wrappingAlgorithmName = this.f22914helper.getWrappingAlgorithmName(genericHybridParameters.m14538getDem().getAlgorithm());
        RsaKemParameters rsaKemParameters = RsaKemParameters.getInstance(genericHybridParameters.m14539getKem().getParameters());
        try {
            cipherCreateAsymmetricWrapper.init(4, this.f22915privKey, new KTSParameterSpec.C5801Builder(wrappingAlgorithmName, rsaKemParameters.getKeyLength().intValue() * 8, new DEROtherInfo.C5403Builder(genericHybridParameters.m14538getDem(), this.partyUInfo, this.partyVInfo).m15924build().getEncoded()).withKdfAlgorithm(rsaKemParameters.getKeyDerivationFunction()).m16204build());
            return new JceGenericKey(algorithmIdentifier, cipherCreateAsymmetricWrapper.unwrap(bArr, this.f22914helper.getKeyAlgorithmName(algorithmIdentifier.getAlgorithm()), 3));
        } catch (Exception e) {
            throw new OperatorException("Unable to unwrap contents key: " + e.getMessage(), e);
        }
    }

    public JceKTSKeyUnwrapper setProvider(String str) {
        this.f22914helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JceKTSKeyUnwrapper setProvider(Provider provider) {
        this.f22914helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }
}
