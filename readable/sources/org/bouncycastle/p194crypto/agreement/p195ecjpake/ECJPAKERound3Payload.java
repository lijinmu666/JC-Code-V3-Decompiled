package org.bouncycastle.p194crypto.agreement.p195ecjpake;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class ECJPAKERound3Payload {

    /* renamed from: macTag */
    private final BigInteger f19182macTag;
    private final String participantId;

    public ECJPAKERound3Payload(String str, BigInteger bigInteger) {
        this.participantId = str;
        this.f19182macTag = bigInteger;
    }

    public BigInteger getMacTag() {
        return this.f19182macTag;
    }

    public String getParticipantId() {
        return this.participantId;
    }
}
