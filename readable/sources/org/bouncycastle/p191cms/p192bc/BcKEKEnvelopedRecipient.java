package org.bouncycastle.p191cms.p192bc;

import java.io.InputStream;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.operator.p305bc.BcSymmetricKeyUnwrapper;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.RecipientOperator;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.StreamCipher;
import org.bouncycastle.p194crypto.p206io.CipherInputStream;
import org.bouncycastle.p194crypto.p213params.KeyParameter;

/* loaded from: classes2.dex */
public class BcKEKEnvelopedRecipient extends BcKEKRecipient {
    public BcKEKEnvelopedRecipient(BcSymmetricKeyUnwrapper bcSymmetricKeyUnwrapper) {
        super(bcSymmetricKeyUnwrapper);
    }

    @Override // org.bouncycastle.p191cms.KEKRecipient
    public RecipientOperator getRecipientOperator(AlgorithmIdentifier algorithmIdentifier, final AlgorithmIdentifier algorithmIdentifier2, byte[] bArr) throws CMSException {
        final Object objCreateContentCipher = EnvelopedDataHelper.createContentCipher(false, (KeyParameter) extractSecretKey(algorithmIdentifier, algorithmIdentifier2, bArr), algorithmIdentifier2);
        return new RecipientOperator(new InputDecryptor(this) { // from class: org.bouncycastle.cms.bc.BcKEKEnvelopedRecipient.1

            /* renamed from: this$0 */
            final /* synthetic */ BcKEKEnvelopedRecipient f19054this$0;

            {
                this.f19054this$0 = this;
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
