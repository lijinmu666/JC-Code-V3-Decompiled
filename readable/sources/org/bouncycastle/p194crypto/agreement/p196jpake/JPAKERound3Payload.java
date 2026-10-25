package org.bouncycastle.p194crypto.agreement.p196jpake;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class JPAKERound3Payload {

    /* renamed from: macTag */
    private final BigInteger f19206macTag;
    private final String participantId;

    public JPAKERound3Payload(String str, BigInteger bigInteger) {
        this.participantId = str;
        this.f19206macTag = bigInteger;
    }

    public BigInteger getMacTag() {
        return this.f19206macTag;
    }

    public String getParticipantId() {
        return this.participantId;
    }
}
