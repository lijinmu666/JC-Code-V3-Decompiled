package org.bouncycastle.p284math.p285ec;

/* loaded from: classes2.dex */
public class WNafPreCompInfo implements PreCompInfo {
    volatile int promotionCountdown = 4;
    protected int confWidth = -1;

    /* renamed from: preComp */
    protected AbstractC5820ECPoint[] f22147preComp = null;
    protected AbstractC5820ECPoint[] preCompNeg = null;

    /* renamed from: twice */
    protected AbstractC5820ECPoint f22148twice = null;

    /* renamed from: width */
    protected int f22149width = -1;

    public int decrementPromotionCountdown() {
        int i = this.promotionCountdown;
        if (i <= 0) {
            return i;
        }
        int i2 = i - 1;
        this.promotionCountdown = i2;
        return i2;
    }

    public int getConfWidth() {
        return this.confWidth;
    }

    public AbstractC5820ECPoint[] getPreComp() {
        return this.f22147preComp;
    }

    public AbstractC5820ECPoint[] getPreCompNeg() {
        return this.preCompNeg;
    }

    public int getPromotionCountdown() {
        return this.promotionCountdown;
    }

    public AbstractC5820ECPoint getTwice() {
        return this.f22148twice;
    }

    public int getWidth() {
        return this.f22149width;
    }

    public boolean isPromoted() {
        return this.promotionCountdown <= 0;
    }

    public void setConfWidth(int i) {
        this.confWidth = i;
    }

    public void setPreComp(AbstractC5820ECPoint[] abstractC5820ECPointArr) {
        this.f22147preComp = abstractC5820ECPointArr;
    }

    public void setPreCompNeg(AbstractC5820ECPoint[] abstractC5820ECPointArr) {
        this.preCompNeg = abstractC5820ECPointArr;
    }

    public void setPromotionCountdown(int i) {
        this.promotionCountdown = i;
    }

    public void setTwice(AbstractC5820ECPoint abstractC5820ECPoint) {
        this.f22148twice = abstractC5820ECPoint;
    }

    public void setWidth(int i) {
        this.f22149width = i;
    }
}
