package org.bouncycastle.p191cms.p193jcajce;

import javax.crypto.SecretKey;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.RecipientOperator;

/* loaded from: classes2.dex */
public class JceKEKAuthEnvelopedRecipient extends JceKEKRecipient {
    public JceKEKAuthEnvelopedRecipient(SecretKey secretKey) {
        super(secretKey);
    }

    @Override // org.bouncycastle.p191cms.KEKRecipient
    public RecipientOperator getRecipientOperator(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, byte[] bArr) throws CMSException {
        return new RecipientOperator(new CMSInputAEADDecryptor(algorithmIdentifier2, this.contentHelper.createContentCipher(extractSecretKey(algorithmIdentifier, algorithmIdentifier2, bArr), algorithmIdentifier2)));
    }
}
