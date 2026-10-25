package org.bouncycastle.p177cert.p179cmp;

import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p138cmp.C5114PKIBody;
import org.bouncycastle.p133asn1.p138cmp.Challenge;
import org.bouncycastle.p133asn1.p138cmp.POPODecKeyChallContent;

/* loaded from: classes2.dex */
public class POPODecryptionKeyChallengeContent {

    /* renamed from: content */
    private final ASN1Sequence f18812content;
    private final DigestCalculatorProvider owfCalcProvider;

    public POPODecryptionKeyChallengeContent(POPODecKeyChallContent pOPODecKeyChallContent, DigestCalculatorProvider digestCalculatorProvider) {
        this.f18812content = ASN1Sequence.getInstance(pOPODecKeyChallContent.toASN1Primitive());
        this.owfCalcProvider = digestCalculatorProvider;
    }

    public static POPODecryptionKeyChallengeContent fromPKIBody(C5114PKIBody c5114PKIBody, DigestCalculatorProvider digestCalculatorProvider) {
        if (c5114PKIBody.m14517getType() == 5) {
            return new POPODecryptionKeyChallengeContent(POPODecKeyChallContent.getInstance(c5114PKIBody.getContent()), digestCalculatorProvider);
        }
        throw new IllegalArgumentException("content of PKIBody wrong type: " + c5114PKIBody.m14517getType());
    }

    public POPODecKeyChallContent toASN1Structure() {
        return POPODecKeyChallContent.getInstance(this.f18812content);
    }

    public ChallengeContent[] toChallengeArray() throws CMPException {
        int iMo14450size = this.f18812content.mo14450size();
        ChallengeContent[] challengeContentArr = new ChallengeContent[iMo14450size];
        DigestCalculator digestCalculatorMo14763get = null;
        for (int i = 0; i != iMo14450size; i++) {
            Challenge challenge = Challenge.getInstance(this.f18812content.getObjectAt(i));
            if (challenge.m14502getOwf() != null) {
                try {
                    digestCalculatorMo14763get = this.owfCalcProvider.mo14763get(challenge.m14502getOwf());
                } catch (OperatorCreationException e) {
                    throw new CMPException(e.getMessage(), e);
                }
            }
            challengeContentArr[i] = new ChallengeContent(Challenge.getInstance(this.f18812content.getObjectAt(i)), digestCalculatorMo14763get);
        }
        return challengeContentArr;
    }
}
