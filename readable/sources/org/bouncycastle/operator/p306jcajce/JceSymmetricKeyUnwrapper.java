package org.bouncycastle.operator.p306jcajce;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.SymmetricKeyUnwrapper;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;

/* loaded from: classes2.dex */
public class JceSymmetricKeyUnwrapper extends SymmetricKeyUnwrapper {

    /* renamed from: helper */
    private OperatorHelper f22918helper;
    private SecretKey secretKey;

    public JceSymmetricKeyUnwrapper(AlgorithmIdentifier algorithmIdentifier, SecretKey secretKey) {
        super(algorithmIdentifier);
        this.f22918helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.secretKey = secretKey;
    }

    @Override // org.bouncycastle.operator.KeyUnwrapper
    public GenericKey generateUnwrappedKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) throws InvalidKeyException, OperatorException {
        try {
            Cipher cipherCreateSymmetricWrapper = this.f22918helper.createSymmetricWrapper(getAlgorithmIdentifier().getAlgorithm());
            cipherCreateSymmetricWrapper.init(4, this.secretKey);
            return new JceGenericKey(algorithmIdentifier, cipherCreateSymmetricWrapper.unwrap(bArr, this.f22918helper.getKeyAlgorithmName(algorithmIdentifier.getAlgorithm()), 3));
        } catch (InvalidKeyException e) {
            throw new OperatorException("key invalid in message.", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new OperatorException("can't find algorithm.", e2);
        }
    }

    public JceSymmetricKeyUnwrapper setProvider(String str) {
        this.f22918helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JceSymmetricKeyUnwrapper setProvider(Provider provider) {
        this.f22918helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }
}
