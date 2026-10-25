package androidx.recyclerview.p023widget;

import androidx.recyclerview.p023widget.C0176mjFkc;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.lgHUyS */
/* loaded from: classes.dex */
public class C0175lgHUyS {

    /* renamed from: mjFkc */
    public final mjFkc f1853mjFkc;

    /* renamed from: androidx.recyclerview.widget.lgHUyS$mjFkc */
    public interface mjFkc {
        /* renamed from: AZxh */
        C0176mjFkc.AZxh mo1999AZxh(int i, int i2, int i3, Object obj);

        /* renamed from: mjFkc */
        void mo2000mjFkc(C0176mjFkc.AZxh aZxh);
    }

    public C0175lgHUyS(mjFkc mjfkc) {
        this.f1853mjFkc = mjfkc;
    }

    /* renamed from: AZxh */
    public void m1993AZxh(List list) {
        while (true) {
            int iM1997mjFkc = m1997mjFkc(list);
            if (iM1997mjFkc == -1) {
                return;
            } else {
                m1996ZfxDd(list, iM1997mjFkc, iM1997mjFkc + 1);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* renamed from: JHa */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m1994JHa(List list, int i, C0176mjFkc.AZxh aZxh, int i2, C0176mjFkc.AZxh aZxh2) {
        C0176mjFkc.AZxh aZxhMo1999AZxh;
        int i3;
        int i4;
        int i5 = aZxh.f1863ZfxDd;
        int i6 = aZxh2.f1862AZxh;
        C0176mjFkc.AZxh aZxhMo1999AZxh2 = null;
        if (i5 >= i6) {
            int i7 = aZxh2.f1863ZfxDd;
            if (i5 < i6 + i7) {
                aZxh2.f1863ZfxDd = i7 - 1;
                aZxhMo1999AZxh = this.f1853mjFkc.mo1999AZxh(4, aZxh.f1862AZxh, 1, aZxh2.f1865wA);
            }
            i3 = aZxh.f1862AZxh;
            i4 = aZxh2.f1862AZxh;
            if (i3 > i4) {
                aZxh2.f1862AZxh = i4 + 1;
            } else {
                int i8 = aZxh2.f1863ZfxDd;
                if (i3 < i4 + i8) {
                    int i9 = (i4 + i8) - i3;
                    aZxhMo1999AZxh2 = this.f1853mjFkc.mo1999AZxh(4, i3 + 1, i9, aZxh2.f1865wA);
                    aZxh2.f1863ZfxDd -= i9;
                }
            }
            list.set(i2, aZxh);
            if (aZxh2.f1863ZfxDd <= 0) {
                list.set(i, aZxh2);
            } else {
                list.remove(i);
                this.f1853mjFkc.mo2000mjFkc(aZxh2);
            }
            if (aZxhMo1999AZxh != null) {
                list.add(i, aZxhMo1999AZxh);
            }
            if (aZxhMo1999AZxh2 == null) {
                list.add(i, aZxhMo1999AZxh2);
                return;
            }
            return;
        }
        aZxh2.f1862AZxh = i6 - 1;
        aZxhMo1999AZxh = null;
        i3 = aZxh.f1862AZxh;
        i4 = aZxh2.f1862AZxh;
        if (i3 > i4) {
        }
        list.set(i2, aZxh);
        if (aZxh2.f1863ZfxDd <= 0) {
        }
        if (aZxhMo1999AZxh != null) {
        }
        if (aZxhMo1999AZxh2 == null) {
        }
    }

    /* renamed from: KLFTb */
    public void m1995KLFTb(List list, int i, C0176mjFkc.AZxh aZxh, int i2, C0176mjFkc.AZxh aZxh2) {
        boolean z;
        int i3 = aZxh.f1862AZxh;
        int i4 = aZxh.f1863ZfxDd;
        boolean z2 = false;
        if (i3 < i4) {
            if (aZxh2.f1862AZxh == i3 && aZxh2.f1863ZfxDd == i4 - i3) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (aZxh2.f1862AZxh == i4 + 1 && aZxh2.f1863ZfxDd == i3 - i4) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i5 = aZxh2.f1862AZxh;
        if (i4 < i5) {
            aZxh2.f1862AZxh = i5 - 1;
        } else {
            int i6 = aZxh2.f1863ZfxDd;
            if (i4 < i5 + i6) {
                aZxh2.f1863ZfxDd = i6 - 1;
                aZxh.f1864mjFkc = 2;
                aZxh.f1863ZfxDd = 1;
                if (aZxh2.f1863ZfxDd == 0) {
                    list.remove(i2);
                    this.f1853mjFkc.mo2000mjFkc(aZxh2);
                    return;
                }
                return;
            }
        }
        int i7 = aZxh.f1862AZxh;
        int i8 = aZxh2.f1862AZxh;
        C0176mjFkc.AZxh aZxhMo1999AZxh = null;
        if (i7 <= i8) {
            aZxh2.f1862AZxh = i8 + 1;
        } else {
            int i9 = aZxh2.f1863ZfxDd;
            if (i7 < i8 + i9) {
                aZxhMo1999AZxh = this.f1853mjFkc.mo1999AZxh(2, i7 + 1, (i8 + i9) - i7, null);
                aZxh2.f1863ZfxDd = aZxh.f1862AZxh - aZxh2.f1862AZxh;
            }
        }
        if (z2) {
            list.set(i, aZxh2);
            list.remove(i2);
            this.f1853mjFkc.mo2000mjFkc(aZxh);
            return;
        }
        if (z) {
            if (aZxhMo1999AZxh != null) {
                int i10 = aZxh.f1862AZxh;
                if (i10 > aZxhMo1999AZxh.f1862AZxh) {
                    aZxh.f1862AZxh = i10 - aZxhMo1999AZxh.f1863ZfxDd;
                }
                int i11 = aZxh.f1863ZfxDd;
                if (i11 > aZxhMo1999AZxh.f1862AZxh) {
                    aZxh.f1863ZfxDd = i11 - aZxhMo1999AZxh.f1863ZfxDd;
                }
            }
            int i12 = aZxh.f1862AZxh;
            if (i12 > aZxh2.f1862AZxh) {
                aZxh.f1862AZxh = i12 - aZxh2.f1863ZfxDd;
            }
            int i13 = aZxh.f1863ZfxDd;
            if (i13 > aZxh2.f1862AZxh) {
                aZxh.f1863ZfxDd = i13 - aZxh2.f1863ZfxDd;
            }
        } else {
            if (aZxhMo1999AZxh != null) {
                int i14 = aZxh.f1862AZxh;
                if (i14 >= aZxhMo1999AZxh.f1862AZxh) {
                    aZxh.f1862AZxh = i14 - aZxhMo1999AZxh.f1863ZfxDd;
                }
                int i15 = aZxh.f1863ZfxDd;
                if (i15 >= aZxhMo1999AZxh.f1862AZxh) {
                    aZxh.f1863ZfxDd = i15 - aZxhMo1999AZxh.f1863ZfxDd;
                }
            }
            int i16 = aZxh.f1862AZxh;
            if (i16 >= aZxh2.f1862AZxh) {
                aZxh.f1862AZxh = i16 - aZxh2.f1863ZfxDd;
            }
            int i17 = aZxh.f1863ZfxDd;
            if (i17 >= aZxh2.f1862AZxh) {
                aZxh.f1863ZfxDd = i17 - aZxh2.f1863ZfxDd;
            }
        }
        list.set(i, aZxh2);
        if (aZxh.f1862AZxh != aZxh.f1863ZfxDd) {
            list.set(i2, aZxh);
        } else {
            list.remove(i2);
        }
        if (aZxhMo1999AZxh != null) {
            list.add(i, aZxhMo1999AZxh);
        }
    }

    /* renamed from: ZfxDd */
    public final void m1996ZfxDd(List list, int i, int i2) {
        C0176mjFkc.AZxh aZxh = (C0176mjFkc.AZxh) list.get(i);
        C0176mjFkc.AZxh aZxh2 = (C0176mjFkc.AZxh) list.get(i2);
        int i3 = aZxh2.f1864mjFkc;
        if (i3 == 1) {
            m1998wA(list, i, aZxh, i2, aZxh2);
        } else if (i3 == 2) {
            m1995KLFTb(list, i, aZxh, i2, aZxh2);
        } else {
            if (i3 != 4) {
                return;
            }
            m1994JHa(list, i, aZxh, i2, aZxh2);
        }
    }

    /* renamed from: mjFkc */
    public final int m1997mjFkc(List list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((C0176mjFkc.AZxh) list.get(size)).f1864mjFkc != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    /* renamed from: wA */
    public final void m1998wA(List list, int i, C0176mjFkc.AZxh aZxh, int i2, C0176mjFkc.AZxh aZxh2) {
        int i3 = aZxh.f1863ZfxDd;
        int i4 = aZxh2.f1862AZxh;
        int i5 = i3 < i4 ? -1 : 0;
        int i6 = aZxh.f1862AZxh;
        if (i6 < i4) {
            i5++;
        }
        if (i4 <= i6) {
            aZxh.f1862AZxh = i6 + aZxh2.f1863ZfxDd;
        }
        int i7 = aZxh2.f1862AZxh;
        if (i7 <= i3) {
            aZxh.f1863ZfxDd = i3 + aZxh2.f1863ZfxDd;
        }
        aZxh2.f1862AZxh = i7 + i5;
        list.set(i, aZxh2);
        list.set(i2, aZxh);
    }
}
