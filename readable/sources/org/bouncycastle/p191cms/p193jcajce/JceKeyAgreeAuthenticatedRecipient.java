package org.bouncycastle.p191cms.p193jcajce;

import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Mac;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.p306jcajce.JceGenericKey;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.RecipientOperator;
import org.bouncycastle.p249jcajce.p250io.MacOutputStream;

/* loaded from: classes2.dex */
public class JceKeyAgreeAuthenticatedRecipient extends JceKeyAgreeRecipient {
    public JceKeyAgreeAuthenticatedRecipient(PrivateKey privateKey) {
        super(privateKey);
    }

    @Override // org.bouncycastle.p191cms.KeyAgreeRecipient
    public RecipientOperator getRecipientOperator(AlgorithmIdentifier algorithmIdentifier, final AlgorithmIdentifier algorithmIdentifier2, SubjectPublicKeyInfo subjectPublicKeyInfo, ASN1OctetString aSN1OctetString, byte[] bArr) throws InvalidKeySpecException, CMSException, InvalidKeyException, InvalidAlgorithmParameterException {
        final Key keyExtractSecretKey = extractSecretKey(algorithmIdentifier, algorithmIdentifier2, subjectPublicKeyInfo, aSN1OctetString, bArr);
        final Mac macCreateContentMac = this.contentHelper.createContentMac(keyExtractSecretKey, algorithmIdentifier2);
        return new RecipientOperator(new MacCalculator(this) { // from class: org.bouncycastle.cms.jcajce.JceKeyAgreeAuthenticatedRecipient.1

            /* renamed from: this$0 */
            final /* synthetic */ JceKeyAgreeAuthenticatedRecipient f19100this$0;

            {
                this.f19100this$0 = this;
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
