package org.bouncycastle.p194crypto.agreement.p196jpake;

import java.math.BigInteger;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class JPAKERound2Payload {

    /* renamed from: a */
    private final BigInteger f19205a;
    private final BigInteger[] knowledgeProofForX2s;
    private final String participantId;

    public JPAKERound2Payload(String str, BigInteger bigInteger, BigInteger[] bigIntegerArr) {
        JPAKEUtil.validateNotNull(str, "participantId");
        JPAKEUtil.validateNotNull(bigInteger, "a");
        JPAKEUtil.validateNotNull(bigIntegerArr, "knowledgeProofForX2s");
        this.participantId = str;
        this.f19205a = bigInteger;
        this.knowledgeProofForX2s = C6238Arrays.m18246copyOf(bigIntegerArr, bigIntegerArr.length);
    }

    /* renamed from: getA */
    public BigInteger m15026getA() {
        return this.f19205a;
    }

    public BigInteger[] getKnowledgeProofForX2s() {
        BigInteger[] bigIntegerArr = this.knowledgeProofForX2s;
        return C6238Arrays.m18246copyOf(bigIntegerArr, bigIntegerArr.length);
    }

    public String getParticipantId() {
        return this.participantId;
    }
}
