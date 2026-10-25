package org.bouncycastle.p246its;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p246its.operator.ETSIDataEncryptor;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.AesCcmCiphertext;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.EncryptedData;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.SequenceOfRecipientInfo;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.SymmetricCiphertext;

/* loaded from: classes2.dex */
public class ETSIEncryptedDataBuilder {
    private final List<ETSIRecipientInfoBuilder> recipientInfoBuilders = new ArrayList();

    public void addRecipientInfoBuilder(ETSIRecipientInfoBuilder eTSIRecipientInfoBuilder) {
        this.recipientInfoBuilders.add(eTSIRecipientInfoBuilder);
    }

    /* renamed from: build */
    public ETSIEncryptedData m15992build(ETSIDataEncryptor eTSIDataEncryptor, byte[] bArr) {
        byte[] bArrMo16034encrypt = eTSIDataEncryptor.mo16034encrypt(bArr);
        byte[] bArrMo16035getKey = eTSIDataEncryptor.mo16035getKey();
        byte[] nonce = eTSIDataEncryptor.getNonce();
        SequenceOfRecipientInfo.C5934Builder c5934BuilderM17241builder = SequenceOfRecipientInfo.m17241builder();
        Iterator<ETSIRecipientInfoBuilder> it = this.recipientInfoBuilders.iterator();
        while (it.hasNext()) {
            c5934BuilderM17241builder.addRecipients(it.next().m15995build(bArrMo16035getKey));
        }
        return new ETSIEncryptedData(EncryptedData.m17225builder().setRecipients(c5934BuilderM17241builder.createSequenceOfRecipientInfo()).setCiphertext(SymmetricCiphertext.aes128ccm(AesCcmCiphertext.m17215builder().setCcmCiphertext(bArrMo16034encrypt).setNonce(nonce).createAesCcmCiphertext())).createEncryptedData());
    }
}
