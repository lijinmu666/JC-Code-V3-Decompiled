package org.bouncycastle.p191cms.p193jcajce;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.PasswordRecipientInfoGenerator;

/* loaded from: classes2.dex */
public class JcePasswordRecipientInfoGenerator extends PasswordRecipientInfoGenerator {

    /* renamed from: helper */
    private EnvelopedDataHelper f19111helper;

    public JcePasswordRecipientInfoGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier, char[] cArr) {
        super(aSN1ObjectIdentifier, cArr);
        this.f19111helper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
    }

    @Override // org.bouncycastle.p191cms.PasswordRecipientInfoGenerator
    public byte[] calculateDerivedKey(int i, AlgorithmIdentifier algorithmIdentifier, int i2) {
        return this.f19111helper.calculateDerivedKey(i, this.password, algorithmIdentifier, i2);
    }

    @Override // org.bouncycastle.p191cms.PasswordRecipientInfoGenerator
    public byte[] generateEncryptedBytes(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, GenericKey genericKey) throws CMSException, InvalidKeyException, InvalidAlgorithmParameterException {
        Key jceKey = this.f19111helper.getJceKey(genericKey);
        Cipher cipherCreateRFC3211Wrapper = this.f19111helper.createRFC3211Wrapper(algorithmIdentifier.getAlgorithm());
        try {
            cipherCreateRFC3211Wrapper.init(3, new SecretKeySpec(bArr, cipherCreateRFC3211Wrapper.getAlgorithm()), new IvParameterSpec(ASN1OctetString.getInstance(algorithmIdentifier.getParameters()).getOctets()));
            return cipherCreateRFC3211Wrapper.wrap(jceKey);
        } catch (GeneralSecurityException e) {
            throw new CMSException("cannot process content encryption key: " + e.getMessage(), e);
        }
    }

    public JcePasswordRecipientInfoGenerator setProvider(String str) {
        this.f19111helper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(str));
        return this;
    }

    public JcePasswordRecipientInfoGenerator setProvider(Provider provider) {
        this.f19111helper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(provider));
        return this;
    }
}
