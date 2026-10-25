package org.bouncycastle.p191cms.p193jcajce;

import java.io.InputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.RecipientOperator;
import org.bouncycastle.p249jcajce.p250io.CipherInputStream;

/* loaded from: classes2.dex */
public class JceKEKEnvelopedRecipient extends JceKEKRecipient {
    public JceKEKEnvelopedRecipient(SecretKey secretKey) {
        super(secretKey);
    }

    @Override // org.bouncycastle.p191cms.KEKRecipient
    public RecipientOperator getRecipientOperator(AlgorithmIdentifier algorithmIdentifier, final AlgorithmIdentifier algorithmIdentifier2, byte[] bArr) throws CMSException {
        final Cipher cipherCreateContentCipher = this.contentHelper.createContentCipher(extractSecretKey(algorithmIdentifier, algorithmIdentifier2, bArr), algorithmIdentifier2);
        return new RecipientOperator(new InputDecryptor(this) { // from class: org.bouncycastle.cms.jcajce.JceKEKEnvelopedRecipient.1

            /* renamed from: this$0 */
            final /* synthetic */ JceKEKEnvelopedRecipient f19091this$0;

            {
                this.f19091this$0 = this;
            }

            @Override // org.bouncycastle.operator.InputDecryptor
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return algorithmIdentifier2;
            }

            @Override // org.bouncycastle.operator.InputDecryptor
            public InputStream getInputStream(InputStream inputStream) {
                return new CipherInputStream(inputStream, cipherCreateContentCipher);
            }
        });
    }
}
