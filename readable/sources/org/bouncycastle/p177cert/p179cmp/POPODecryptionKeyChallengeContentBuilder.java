package org.bouncycastle.p177cert.p179cmp;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p138cmp.Challenge;
import org.bouncycastle.p133asn1.p138cmp.POPODecKeyChallContent;
import org.bouncycastle.p133asn1.p139cms.EnvelopedData;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p191cms.CMSEnvelopedDataGenerator;
import org.bouncycastle.p191cms.CMSProcessableByteArray;
import org.bouncycastle.p191cms.RecipientInfoGenerator;
import org.bouncycastle.p191cms.p193jcajce.JceCMSContentEncryptorBuilder;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class POPODecryptionKeyChallengeContentBuilder {
    private final ASN1ObjectIdentifier challengeEncAlg;
    private ASN1EncodableVector challenges = new ASN1EncodableVector();
    private final DigestCalculator owfCalculator;

    public POPODecryptionKeyChallengeContentBuilder(DigestCalculator digestCalculator, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.owfCalculator = digestCalculator;
        this.challengeEncAlg = aSN1ObjectIdentifier;
    }

    public POPODecryptionKeyChallengeContentBuilder addChallenge(RecipientInfoGenerator recipientInfoGenerator, GeneralName generalName, byte[] bArr) throws CMPException, IOException {
        ASN1EncodableVector aSN1EncodableVector;
        Challenge challenge;
        byte[] bArrM18231clone = C6238Arrays.m18231clone(bArr);
        try {
            OutputStream outputStream = this.owfCalculator.getOutputStream();
            outputStream.write(new ASN1Integer(bArrM18231clone).getEncoded());
            outputStream.close();
            try {
                CMSEnvelopedDataGenerator cMSEnvelopedDataGenerator = new CMSEnvelopedDataGenerator();
                cMSEnvelopedDataGenerator.addRecipientInfoGenerator(recipientInfoGenerator);
                EnvelopedData envelopedData = EnvelopedData.getInstance(cMSEnvelopedDataGenerator.generate(new CMSProcessableByteArray(new Challenge.C5112Rand(bArr, generalName).getEncoded()), new JceCMSContentEncryptorBuilder(this.challengeEncAlg).setProvider(BouncyCastleProvider.PROVIDER_NAME).m14934build()).toASN1Structure().getContent());
                if (this.challenges.m14424size() == 0) {
                    aSN1EncodableVector = this.challenges;
                    challenge = new Challenge(this.owfCalculator.getAlgorithmIdentifier(), this.owfCalculator.getDigest(), envelopedData);
                } else {
                    aSN1EncodableVector = this.challenges;
                    challenge = new Challenge(this.owfCalculator.getDigest(), envelopedData);
                }
                aSN1EncodableVector.m14420add(challenge);
                return this;
            } catch (Exception e) {
                throw new CMPException("unable to encrypt challenge", e);
            }
        } catch (IOException e2) {
            throw new CMPException("unable to calculate witness", e2);
        }
    }

    /* renamed from: build */
    public POPODecryptionKeyChallengeContent m14762build() {
        return new POPODecryptionKeyChallengeContent(POPODecKeyChallContent.getInstance(new DERSequence(this.challenges)), new DigestCalculatorProvider() { // from class: org.bouncycastle.cert.cmp.POPODecryptionKeyChallengeContentBuilder.1
            @Override // org.bouncycastle.operator.DigestCalculatorProvider
            /* renamed from: get */
            public DigestCalculator mo14763get(AlgorithmIdentifier algorithmIdentifier) {
                return POPODecryptionKeyChallengeContentBuilder.this.owfCalculator;
            }
        });
    }
}
