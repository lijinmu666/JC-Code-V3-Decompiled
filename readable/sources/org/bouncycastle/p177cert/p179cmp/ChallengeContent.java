package org.bouncycastle.p177cert.p179cmp;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.p138cmp.Challenge;
import org.bouncycastle.p133asn1.p138cmp.PKIHeader;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p191cms.CMSEnvelopedData;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.Recipient;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ChallengeContent {
    private final Challenge challenge;

    /* renamed from: owfCalc */
    private final DigestCalculator f18811owfCalc;

    public ChallengeContent(Challenge challenge, DigestCalculator digestCalculator) {
        this.challenge = challenge;
        this.f18811owfCalc = digestCalculator;
    }

    public byte[] extractChallenge(PKIHeader pKIHeader, Recipient recipient) throws CMPException, IOException {
        try {
            Challenge.C5112Rand c5112Rand = Challenge.C5112Rand.getInstance(new CMSEnvelopedData(new ContentInfo(PKCSObjectIdentifiers.envelopedData, this.challenge.getEncryptedRand())).getRecipientInfos().getRecipients().iterator().next().getContent(recipient));
            if (!C6238Arrays.constantTimeAreEqual(c5112Rand.getSender().getEncoded(), pKIHeader.getSender().getEncoded())) {
                throw new CMPChallengeFailedException("incorrect sender found");
            }
            OutputStream outputStream = this.f18811owfCalc.getOutputStream();
            outputStream.write(c5112Rand.m14503getInt().getEncoded());
            outputStream.close();
            if (C6238Arrays.constantTimeAreEqual(this.challenge.getWitness(), this.f18811owfCalc.getDigest())) {
                return c5112Rand.m14503getInt().getValue().toByteArray();
            }
            throw new CMPChallengeFailedException("corrupted challenge found");
        } catch (IOException e) {
            throw new CMPException(e.getMessage(), e);
        } catch (CMSException e2) {
            throw new CMPException(e2.getMessage(), e2);
        }
    }
}
