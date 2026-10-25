package org.bouncycastle.p284math.p295raw;

/* renamed from: org.bouncycastle.math.raw.Nat384 */
/* loaded from: classes2.dex */
public abstract class AbstractC5876Nat384 {
    /* renamed from: mul */
    public static void m17095mul(int[] iArr, int[] iArr2, int[] iArr3) {
        AbstractC5872Nat192.m17025mul(iArr, iArr2, iArr3);
        AbstractC5872Nat192.m17024mul(iArr, 6, iArr2, 6, iArr3, 12);
        int iAddToEachOther = AbstractC5872Nat192.addToEachOther(iArr3, 6, iArr3, 12);
        int iM17008addTo = iAddToEachOther + AbstractC5872Nat192.m17008addTo(iArr3, 18, iArr3, 12, AbstractC5872Nat192.m17008addTo(iArr3, 0, iArr3, 6, 0) + iAddToEachOther);
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        int[] iArrM17014create2 = AbstractC5872Nat192.m17014create();
        boolean z = AbstractC5872Nat192.m17015diff(iArr, 6, iArr, 0, iArrM17014create, 0) != AbstractC5872Nat192.m17015diff(iArr2, 6, iArr2, 0, iArrM17014create2, 0);
        int[] iArrCreateExt = AbstractC5872Nat192.createExt();
        AbstractC5872Nat192.m17025mul(iArrM17014create, iArrM17014create2, iArrCreateExt);
        AbstractC5869Nat.addWordAt(24, iM17008addTo + (z ? AbstractC5869Nat.m16889addTo(12, iArrCreateExt, 0, iArr3, 6) : AbstractC5869Nat.m16939subFrom(12, iArrCreateExt, 0, iArr3, 6)), iArr3, 18);
    }

    /* renamed from: square */
    public static void m17096square(int[] iArr, int[] iArr2) {
        AbstractC5872Nat192.m17028square(iArr, iArr2);
        AbstractC5872Nat192.m17027square(iArr, 6, iArr2, 12);
        int iAddToEachOther = AbstractC5872Nat192.addToEachOther(iArr2, 6, iArr2, 12);
        int iM17008addTo = iAddToEachOther + AbstractC5872Nat192.m17008addTo(iArr2, 18, iArr2, 12, AbstractC5872Nat192.m17008addTo(iArr2, 0, iArr2, 6, 0) + iAddToEachOther);
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        AbstractC5872Nat192.m17015diff(iArr, 6, iArr, 0, iArrM17014create, 0);
        int[] iArrCreateExt = AbstractC5872Nat192.createExt();
        AbstractC5872Nat192.m17028square(iArrM17014create, iArrCreateExt);
        AbstractC5869Nat.addWordAt(24, iM17008addTo + AbstractC5869Nat.m16939subFrom(12, iArrCreateExt, 0, iArr2, 6), iArr2, 18);
    }
}
