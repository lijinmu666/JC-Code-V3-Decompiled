package org.bouncycastle.p191cms.p193jcajce;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.RecipientOperator;

/* loaded from: classes2.dex */
public class JcePasswordAuthEnvelopedRecipient extends JcePasswordRecipient {
    public JcePasswordAuthEnvelopedRecipient(char[] cArr) {
        super(cArr);
    }

    @Override // org.bouncycastle.p191cms.PasswordRecipient
    public RecipientOperator getRecipientOperator(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, byte[] bArr, byte[] bArr2) throws CMSException, InvalidKeyException, InvalidAlgorithmParameterException {
        return new RecipientOperator(new CMSInputAEADDecryptor(algorithmIdentifier2, this.f19110helper.createContentCipher(extractSecretKey(algorithmIdentifier, algorithmIdentifier2, bArr, bArr2), algorithmIdentifier2)));
    }
}
