package org.bouncycastle.p194crypto.agreement.p195ecjpake;

import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class ECJPAKERound1Payload {

    /* renamed from: gx1 */
    private final AbstractC5820ECPoint f19179gx1;

    /* renamed from: gx2 */
    private final AbstractC5820ECPoint f19180gx2;
    private final ECSchnorrZKP knowledgeProofForX1;
    private final ECSchnorrZKP knowledgeProofForX2;
    private final String participantId;

    public ECJPAKERound1Payload(String str, AbstractC5820ECPoint abstractC5820ECPoint, AbstractC5820ECPoint abstractC5820ECPoint2, ECSchnorrZKP eCSchnorrZKP, ECSchnorrZKP eCSchnorrZKP2) {
        ECJPAKEUtil.validateNotNull(str, "participantId");
        ECJPAKEUtil.validateNotNull(abstractC5820ECPoint, "gx1");
        ECJPAKEUtil.validateNotNull(abstractC5820ECPoint2, "gx2");
        ECJPAKEUtil.validateNotNull(eCSchnorrZKP, "knowledgeProofForX1");
        ECJPAKEUtil.validateNotNull(eCSchnorrZKP2, "knowledgeProofForX2");
        this.participantId = str;
        this.f19179gx1 = abstractC5820ECPoint;
        this.f19180gx2 = abstractC5820ECPoint2;
        this.knowledgeProofForX1 = eCSchnorrZKP;
        this.knowledgeProofForX2 = eCSchnorrZKP2;
    }

    /* renamed from: getGx1 */
    public AbstractC5820ECPoint m15016getGx1() {
        return this.f19179gx1;
    }

    /* renamed from: getGx2 */
    public AbstractC5820ECPoint m15017getGx2() {
        return this.f19180gx2;
    }

    public ECSchnorrZKP getKnowledgeProofForX1() {
        return this.knowledgeProofForX1;
    }

    public ECSchnorrZKP getKnowledgeProofForX2() {
        return this.knowledgeProofForX2;
    }

    public String getParticipantId() {
        return this.participantId;
    }
}
