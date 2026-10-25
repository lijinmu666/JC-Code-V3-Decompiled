package org.bouncycastle.p191cms.p193jcajce;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.PasswordRecipient;

/* loaded from: classes2.dex */
public abstract class JcePasswordRecipient implements PasswordRecipient {
    private char[] password;
    private int schemeID = 1;

    /* renamed from: helper */
    protected EnvelopedDataHelper f19110helper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());

    public JcePasswordRecipient(char[] cArr) {
        this.password = cArr;
    }

    @Override // org.bouncycastle.p191cms.PasswordRecipient
    public byte[] calculateDerivedKey(int i, AlgorithmIdentifier algorithmIdentifier, int i2) {
        return this.f19110helper.calculateDerivedKey(i, this.password, algorithmIdentifier, i2);
    }

    public Key extractSecretKey(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, byte[] bArr, byte[] bArr2) throws CMSException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipherCreateRFC3211Wrapper = this.f19110helper.createRFC3211Wrapper(algorithmIdentifier.getAlgorithm());
        try {
            cipherCreateRFC3211Wrapper.init(4, new SecretKeySpec(bArr, cipherCreateRFC3211Wrapper.getAlgorithm()), new IvParameterSpec(ASN1OctetString.getInstance(algorithmIdentifier.getParameters()).getOctets()));
            return cipherCreateRFC3211Wrapper.unwrap(bArr2, algorithmIdentifier2.getAlgorithm().m14433getId(), 3);
        } catch (GeneralSecurityException e) {
            throw new CMSException("cannot process content encryption key: " + e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.p191cms.PasswordRecipient
    public char[] getPassword() {
        return this.password;
    }

    @Override // org.bouncycastle.p191cms.PasswordRecipient
    public int getPasswordConversionScheme() {
        return this.schemeID;
    }

    public JcePasswordRecipient setPasswordConversionScheme(int i) {
        this.schemeID = i;
        return this;
    }

    public JcePasswordRecipient setProvider(String str) {
        this.f19110helper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(str));
        return this;
    }

    public JcePasswordRecipient setProvider(Provider provider) {
        this.f19110helper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(provider));
        return this;
    }
}
