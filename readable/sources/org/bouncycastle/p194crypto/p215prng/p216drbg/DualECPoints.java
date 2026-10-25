package org.bouncycastle.p194crypto.p215prng.p216drbg;

import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class DualECPoints {
    private final int cofactor;

    /* renamed from: p */
    private final AbstractC5820ECPoint f20904p;

    /* renamed from: q */
    private final AbstractC5820ECPoint f20905q;
    private final int securityStrength;

    public DualECPoints(int i, AbstractC5820ECPoint abstractC5820ECPoint, AbstractC5820ECPoint abstractC5820ECPoint2, int i2) {
        if (!abstractC5820ECPoint.getCurve().m16297equals(abstractC5820ECPoint2.getCurve())) {
            throw new IllegalArgumentException("points need to be on the same curve");
        }
        this.securityStrength = i;
        this.f20904p = abstractC5820ECPoint;
        this.f20905q = abstractC5820ECPoint2;
        this.cofactor = i2;
    }

    /* renamed from: log2 */
    private static int m15846log2(int i) {
        int i2 = 0;
        while (true) {
            i >>= 1;
            if (i == 0) {
                return i2;
            }
            i2++;
        }
    }

    public int getCofactor() {
        return this.cofactor;
    }

    public int getMaxOutlen() {
        return ((this.f20904p.getCurve().getFieldSize() - (m15846log2(this.cofactor) + 13)) / 8) * 8;
    }

    /* renamed from: getP */
    public AbstractC5820ECPoint m15847getP() {
        return this.f20904p;
    }

    /* renamed from: getQ */
    public AbstractC5820ECPoint m15848getQ() {
        return this.f20905q;
    }

    public int getSecurityStrength() {
        return this.securityStrength;
    }

    public int getSeedLen() {
        return this.f20904p.getCurve().getFieldSize();
    }
}
