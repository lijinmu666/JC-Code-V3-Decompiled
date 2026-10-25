package org.bouncycastle.p284math.p295raw;

/* renamed from: org.bouncycastle.math.raw.Nat512 */
/* loaded from: classes2.dex */
public abstract class AbstractC5878Nat512 {
    /* renamed from: mul */
    public static void m17103mul(int[] iArr, int[] iArr2, int[] iArr3) {
        AbstractC5874Nat256.m17079mul(iArr, iArr2, iArr3);
        AbstractC5874Nat256.m17078mul(iArr, 8, iArr2, 8, iArr3, 16);
        int iAddToEachOther = AbstractC5874Nat256.addToEachOther(iArr3, 8, iArr3, 16);
        int iM17061addTo = iAddToEachOther + AbstractC5874Nat256.m17061addTo(iArr3, 24, iArr3, 16, AbstractC5874Nat256.m17061addTo(iArr3, 0, iArr3, 8, 0) + iAddToEachOther);
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        int[] iArrM17068create2 = AbstractC5874Nat256.m17068create();
        boolean z = AbstractC5874Nat256.m17069diff(iArr, 8, iArr, 0, iArrM17068create, 0) != AbstractC5874Nat256.m17069diff(iArr2, 8, iArr2, 0, iArrM17068create2, 0);
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        AbstractC5874Nat256.m17079mul(iArrM17068create, iArrM17068create2, iArrCreateExt);
        AbstractC5869Nat.addWordAt(32, iM17061addTo + (z ? AbstractC5869Nat.m16889addTo(16, iArrCreateExt, 0, iArr3, 8) : AbstractC5869Nat.m16939subFrom(16, iArrCreateExt, 0, iArr3, 8)), iArr3, 24);
    }

    /* renamed from: square */
    public static void m17104square(int[] iArr, int[] iArr2) {
        AbstractC5874Nat256.m17083square(iArr, iArr2);
        AbstractC5874Nat256.m17082square(iArr, 8, iArr2, 16);
        int iAddToEachOther = AbstractC5874Nat256.addToEachOther(iArr2, 8, iArr2, 16);
        int iM17061addTo = iAddToEachOther + AbstractC5874Nat256.m17061addTo(iArr2, 24, iArr2, 16, AbstractC5874Nat256.m17061addTo(iArr2, 0, iArr2, 8, 0) + iAddToEachOther);
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        AbstractC5874Nat256.m17069diff(iArr, 8, iArr, 0, iArrM17068create, 0);
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        AbstractC5874Nat256.m17083square(iArrM17068create, iArrCreateExt);
        AbstractC5869Nat.addWordAt(32, iM17061addTo + AbstractC5869Nat.m16939subFrom(16, iArrCreateExt, 0, iArr2, 8), iArr2, 24);
    }
}
