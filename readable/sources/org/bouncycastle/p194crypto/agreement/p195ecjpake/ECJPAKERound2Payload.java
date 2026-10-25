package org.bouncycastle.p194crypto.agreement.p195ecjpake;

import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class ECJPAKERound2Payload {

    /* renamed from: a */
    private final AbstractC5820ECPoint f19181a;
    private final ECSchnorrZKP knowledgeProofForX2s;
    private final String participantId;

    public ECJPAKERound2Payload(String str, AbstractC5820ECPoint abstractC5820ECPoint, ECSchnorrZKP eCSchnorrZKP) {
        ECJPAKEUtil.validateNotNull(str, "participantId");
        ECJPAKEUtil.validateNotNull(abstractC5820ECPoint, "a");
        ECJPAKEUtil.validateNotNull(eCSchnorrZKP, "knowledgeProofForX2s");
        this.participantId = str;
        this.f19181a = abstractC5820ECPoint;
        this.knowledgeProofForX2s = eCSchnorrZKP;
    }

    /* renamed from: getA */
    public AbstractC5820ECPoint m15018getA() {
        return this.f19181a;
    }

    public ECSchnorrZKP getKnowledgeProofForX2s() {
        return this.knowledgeProofForX2s;
    }

    public String getParticipantId() {
        return this.participantId;
    }
}
