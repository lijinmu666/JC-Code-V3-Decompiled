package org.bouncycastle.p194crypto.agreement.p196jpake;

import java.math.BigInteger;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class JPAKERound1Payload {

    /* renamed from: gx1 */
    private final BigInteger f19203gx1;

    /* renamed from: gx2 */
    private final BigInteger f19204gx2;
    private final BigInteger[] knowledgeProofForX1;
    private final BigInteger[] knowledgeProofForX2;
    private final String participantId;

    public JPAKERound1Payload(String str, BigInteger bigInteger, BigInteger bigInteger2, BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2) {
        JPAKEUtil.validateNotNull(str, "participantId");
        JPAKEUtil.validateNotNull(bigInteger, "gx1");
        JPAKEUtil.validateNotNull(bigInteger2, "gx2");
        JPAKEUtil.validateNotNull(bigIntegerArr, "knowledgeProofForX1");
        JPAKEUtil.validateNotNull(bigIntegerArr2, "knowledgeProofForX2");
        this.participantId = str;
        this.f19203gx1 = bigInteger;
        this.f19204gx2 = bigInteger2;
        this.knowledgeProofForX1 = C6238Arrays.m18246copyOf(bigIntegerArr, bigIntegerArr.length);
        this.knowledgeProofForX2 = C6238Arrays.m18246copyOf(bigIntegerArr2, bigIntegerArr2.length);
    }

    /* renamed from: getGx1 */
    public BigInteger m15024getGx1() {
        return this.f19203gx1;
    }

    /* renamed from: getGx2 */
    public BigInteger m15025getGx2() {
        return this.f19204gx2;
    }

    public BigInteger[] getKnowledgeProofForX1() {
        BigInteger[] bigIntegerArr = this.knowledgeProofForX1;
        return C6238Arrays.m18246copyOf(bigIntegerArr, bigIntegerArr.length);
    }

    public BigInteger[] getKnowledgeProofForX2() {
        BigInteger[] bigIntegerArr = this.knowledgeProofForX2;
        return C6238Arrays.m18246copyOf(bigIntegerArr, bigIntegerArr.length);
    }

    public String getParticipantId() {
        return this.participantId;
    }
}
