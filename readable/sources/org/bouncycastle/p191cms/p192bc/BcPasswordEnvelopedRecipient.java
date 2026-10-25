package org.bouncycastle.p191cms.p192bc;

import java.io.InputStream;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.RecipientOperator;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.StreamCipher;
import org.bouncycastle.p194crypto.p206io.CipherInputStream;

/* loaded from: classes2.dex */
public class BcPasswordEnvelopedRecipient extends BcPasswordRecipient {
    public BcPasswordEnvelopedRecipient(char[] cArr) {
        super(cArr);
    }

    @Override // org.bouncycastle.p191cms.PasswordRecipient
    public RecipientOperator getRecipientOperator(AlgorithmIdentifier algorithmIdentifier, final AlgorithmIdentifier algorithmIdentifier2, byte[] bArr, byte[] bArr2) throws CMSException {
        final Object objCreateContentCipher = EnvelopedDataHelper.createContentCipher(false, extractSecretKey(algorithmIdentifier, algorithmIdentifier2, bArr, bArr2), algorithmIdentifier2);
        return new RecipientOperator(new InputDecryptor(this) { // from class: org.bouncycastle.cms.bc.BcPasswordEnvelopedRecipient.1

            /* renamed from: this$0 */
            final /* synthetic */ BcPasswordEnvelopedRecipient f19055this$0;

            {
                this.f19055this$0 = this;
            }

            @Override // org.bouncycastle.operator.InputDecryptor
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return algorithmIdentifier2;
            }

            @Override // org.bouncycastle.operator.InputDecryptor
            public InputStream getInputStream(InputStream inputStream) {
                return objCreateContentCipher instanceof BufferedBlockCipher ? new CipherInputStream(inputStream, (BufferedBlockCipher) objCreateContentCipher) : new CipherInputStream(inputStream, (StreamCipher) objCreateContentCipher);
            }
        });
    }
}
