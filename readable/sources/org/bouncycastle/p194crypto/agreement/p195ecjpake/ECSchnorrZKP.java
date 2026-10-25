package org.bouncycastle.p194crypto.agreement.p195ecjpake;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class ECSchnorrZKP {

    /* renamed from: V */
    private final AbstractC5820ECPoint f19185V;

    /* renamed from: r */
    private final BigInteger f19186r;

    public ECSchnorrZKP(AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger) {
        this.f19185V = abstractC5820ECPoint;
        this.f19186r = bigInteger;
    }

    /* renamed from: getV */
    public AbstractC5820ECPoint m15019getV() {
        return this.f19185V;
    }

    /* renamed from: getr */
    public BigInteger m15020getr() {
        return this.f19186r;
    }
}
