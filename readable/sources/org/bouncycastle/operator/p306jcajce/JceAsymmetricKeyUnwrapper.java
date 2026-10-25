package org.bouncycastle.operator.p306jcajce;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.ProviderException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.operator.AsymmetricKeyUnwrapper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;

/* loaded from: classes2.dex */
public class JceAsymmetricKeyUnwrapper extends AsymmetricKeyUnwrapper {
    private Map extraMappings;

    /* renamed from: helper */
    private OperatorHelper f22905helper;

    /* renamed from: privKey */
    private PrivateKey f22906privKey;
    private boolean unwrappedKeyMustBeEncodable;

    public JceAsymmetricKeyUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey) {
        super(algorithmIdentifier);
        this.f22905helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.extraMappings = new HashMap();
        this.f22906privKey = privateKey;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0030 A[Catch: IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException | Exception -> 0x0053, TryCatch #0 {IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException | Exception -> 0x0053, blocks: (B:5:0x001a, B:7:0x002a, B:9:0x0035, B:8:0x0030), top: B:44:0x001a }] */
    @Override // org.bouncycastle.operator.KeyUnwrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GenericKey generateUnwrappedKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) throws NoSuchAlgorithmException, IOException, InvalidKeyException, OperatorException, InvalidAlgorithmParameterException {
        byte[] encoded;
        try {
            Cipher cipherCreateAsymmetricWrapper = this.f22905helper.createAsymmetricWrapper(getAlgorithmIdentifier(), this.extraMappings);
            AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f22905helper.createAlgorithmParameters(getAlgorithmIdentifier());
            Key secretKeySpec = null;
            if (algorithmParametersCreateAlgorithmParameters != null) {
                try {
                    if (getAlgorithmIdentifier().getAlgorithm().m14446equals((ASN1Primitive) OIWObjectIdentifiers.elGamalAlgorithm)) {
                        cipherCreateAsymmetricWrapper.init(4, this.f22906privKey);
                    } else {
                        cipherCreateAsymmetricWrapper.init(4, this.f22906privKey, algorithmParametersCreateAlgorithmParameters);
                    }
                    Key keyUnwrap = cipherCreateAsymmetricWrapper.unwrap(bArr, this.f22905helper.getKeyAlgorithmName(algorithmIdentifier.getAlgorithm()), 3);
                    if (!this.unwrappedKeyMustBeEncodable || ((encoded = keyUnwrap.getEncoded()) != null && encoded.length != 0)) {
                        secretKeySpec = keyUnwrap;
                    }
                } catch (IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException | Exception unused) {
                }
            }
            if (secretKeySpec == null) {
                if (algorithmParametersCreateAlgorithmParameters != null) {
                    cipherCreateAsymmetricWrapper.init(2, this.f22906privKey, algorithmParametersCreateAlgorithmParameters);
                } else {
                    cipherCreateAsymmetricWrapper.init(2, this.f22906privKey);
                }
                secretKeySpec = new SecretKeySpec(cipherCreateAsymmetricWrapper.doFinal(bArr), algorithmIdentifier.getAlgorithm().m14433getId());
            }
            return new JceGenericKey(algorithmIdentifier, secretKeySpec);
        } catch (InvalidAlgorithmParameterException e) {
            throw new OperatorException("invalid algorithm parameters: " + e.getMessage(), e);
        } catch (InvalidKeyException e2) {
            throw new OperatorException("key invalid: " + e2.getMessage(), e2);
        } catch (BadPaddingException e3) {
            throw new OperatorException("bad padding: " + e3.getMessage(), e3);
        } catch (IllegalBlockSizeException e4) {
            throw new OperatorException("illegal blocksize: " + e4.getMessage(), e4);
        }
    }

    public JceAsymmetricKeyUnwrapper setAlgorithmMapping(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        this.extraMappings.put(aSN1ObjectIdentifier, str);
        return this;
    }

    public JceAsymmetricKeyUnwrapper setMustProduceEncodableUnwrappedKey(boolean z) {
        this.unwrappedKeyMustBeEncodable = z;
        return this;
    }

    public JceAsymmetricKeyUnwrapper setProvider(String str) {
        this.f22905helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JceAsymmetricKeyUnwrapper setProvider(Provider provider) {
        this.f22905helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }
}
