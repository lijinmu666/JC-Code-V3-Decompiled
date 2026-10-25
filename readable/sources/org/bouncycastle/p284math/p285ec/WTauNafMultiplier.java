package org.bouncycastle.p284math.p285ec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class WTauNafMultiplier extends AbstractECMultiplier {
    static final String PRECOMP_NAME = "bc_wtnaf";

    private static AbstractC5820ECPoint.AbstractF2m multiplyFromWTnaf(final AbstractC5820ECPoint.AbstractF2m abstractF2m, byte[] bArr) {
        AbstractC5817ECCurve.AbstractF2m abstractF2m2 = (AbstractC5817ECCurve.AbstractF2m) abstractF2m.getCurve();
        final byte bByteValue = abstractF2m2.m16298getA().toBigInteger().byteValue();
        AbstractC5820ECPoint.AbstractF2m[] preComp = ((WTauNafPreCompInfo) abstractF2m2.precompute(abstractF2m, PRECOMP_NAME, new PreCompCallback() { // from class: org.bouncycastle.math.ec.WTauNafMultiplier.1
            @Override // org.bouncycastle.p284math.p285ec.PreCompCallback
            public PreCompInfo precompute(PreCompInfo preCompInfo) {
                if (preCompInfo instanceof WTauNafPreCompInfo) {
                    return preCompInfo;
                }
                WTauNafPreCompInfo wTauNafPreCompInfo = new WTauNafPreCompInfo();
                wTauNafPreCompInfo.setPreComp(C5822Tnaf.getPreComp(abstractF2m, bByteValue));
                return wTauNafPreCompInfo;
            }
        })).getPreComp();
        AbstractC5820ECPoint.AbstractF2m[] abstractF2mArr = new AbstractC5820ECPoint.AbstractF2m[preComp.length];
        for (int i = 0; i < preComp.length; i++) {
            abstractF2mArr[i] = (AbstractC5820ECPoint.AbstractF2m) preComp[i].mo16335negate();
        }
        AbstractC5820ECPoint.AbstractF2m abstractF2m3 = (AbstractC5820ECPoint.AbstractF2m) abstractF2m.getCurve().getInfinity();
        int i2 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            i2++;
            byte b = bArr[length];
            if (b != 0) {
                abstractF2m3 = (AbstractC5820ECPoint.AbstractF2m) abstractF2m3.m16340tauPow(i2).mo16330add(b > 0 ? preComp[b >>> 1] : abstractF2mArr[(-b) >>> 1]);
                i2 = 0;
            }
        }
        return i2 > 0 ? abstractF2m3.m16340tauPow(i2) : abstractF2m3;
    }

    private AbstractC5820ECPoint.AbstractF2m multiplyWTnaf(AbstractC5820ECPoint.AbstractF2m abstractF2m, ZTauElement zTauElement, byte b, byte b2) {
        return multiplyFromWTnaf(abstractF2m, C5822Tnaf.tauAdicWNaf(b2, zTauElement, 4, C5822Tnaf.m16376getTw(b2, 4).intValue(), b == 0 ? C5822Tnaf.f22144alpha0 : C5822Tnaf.f22145alpha1));
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractECMultiplier
    public AbstractC5820ECPoint multiplyPositive(AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger) {
        if (!(abstractC5820ECPoint instanceof AbstractC5820ECPoint.AbstractF2m)) {
            throw new IllegalArgumentException("Only ECPoint.AbstractF2m can be used in WTauNafMultiplier");
        }
        AbstractC5820ECPoint.AbstractF2m abstractF2m = (AbstractC5820ECPoint.AbstractF2m) abstractC5820ECPoint;
        AbstractC5817ECCurve.AbstractF2m abstractF2m2 = (AbstractC5817ECCurve.AbstractF2m) abstractF2m.getCurve();
        byte bByteValue = abstractF2m2.m16298getA().toBigInteger().byteValue();
        byte bM16371getMu = C5822Tnaf.m16371getMu(bByteValue);
        return multiplyWTnaf(abstractF2m, C5822Tnaf.partModReduction(abstractF2m2, bigInteger, bByteValue, bM16371getMu, (byte) 10), bByteValue, bM16371getMu);
    }
}
