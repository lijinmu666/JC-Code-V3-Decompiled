package org.bouncycastle.p191cms.p193jcajce;

import java.io.OutputStream;
import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.p306jcajce.JceGenericKey;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.RecipientOperator;
import org.bouncycastle.p249jcajce.p250io.MacOutputStream;

/* loaded from: classes2.dex */
public class JceKEKAuthenticatedRecipient extends JceKEKRecipient {
    public JceKEKAuthenticatedRecipient(SecretKey secretKey) {
        super(secretKey);
    }

    @Override // org.bouncycastle.p191cms.KEKRecipient
    public RecipientOperator getRecipientOperator(AlgorithmIdentifier algorithmIdentifier, final AlgorithmIdentifier algorithmIdentifier2, byte[] bArr) throws CMSException {
        final Key keyExtractSecretKey = extractSecretKey(algorithmIdentifier, algorithmIdentifier2, bArr);
        final Mac macCreateContentMac = this.contentHelper.createContentMac(keyExtractSecretKey, algorithmIdentifier2);
        return new RecipientOperator(new MacCalculator(this) { // from class: org.bouncycastle.cms.jcajce.JceKEKAuthenticatedRecipient.1

            /* renamed from: this$0 */
            final /* synthetic */ JceKEKAuthenticatedRecipient f19090this$0;

            {
                this.f19090this$0 = this;
            }

            @Override // org.bouncycastle.operator.MacCalculator
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return algorithmIdentifier2;
            }

            @Override // org.bouncycastle.operator.MacCalculator
            /* renamed from: getKey */
            public GenericKey mo14789getKey() {
                return new JceGenericKey(algorithmIdentifier2, keyExtractSecretKey);
            }

            @Override // org.bouncycastle.operator.MacCalculator
            /* renamed from: getMac */
            public byte[] mo14790getMac() {
                return macCreateContentMac.doFinal();
            }

            @Override // org.bouncycastle.operator.MacCalculator
            public OutputStream getOutputStream() {
                return new MacOutputStream(macCreateContentMac);
            }
        });
    }
}
