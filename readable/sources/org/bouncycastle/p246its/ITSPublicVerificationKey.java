package org.bouncycastle.p246its;

import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.PublicVerificationKey;

/* loaded from: classes2.dex */
public class ITSPublicVerificationKey {
    protected final PublicVerificationKey verificationKey;

    public ITSPublicVerificationKey(PublicVerificationKey publicVerificationKey) {
        this.verificationKey = publicVerificationKey;
    }

    public PublicVerificationKey toASN1Structure() {
        return this.verificationKey;
    }
}
