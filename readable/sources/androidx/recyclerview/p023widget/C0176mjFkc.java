package androidx.recyclerview.p023widget;

import androidx.recyclerview.p023widget.C0175lgHUyS;
import androidx.recyclerview.p023widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import p131o.C1733C3;
import p131o.InterfaceC1601A3;

/* renamed from: androidx.recyclerview.widget.mjFkc */
/* loaded from: classes.dex */
public final class C0176mjFkc implements C0175lgHUyS.mjFkc {

    /* renamed from: AZxh */
    public final ArrayList f1854AZxh;

    /* renamed from: JHa */
    public final boolean f1855JHa;

    /* renamed from: KLFTb */
    public Runnable f1856KLFTb;

    /* renamed from: ZfxDd */
    public final mjFkc f1857ZfxDd;

    /* renamed from: lgHUyS */
    public int f1858lgHUyS;

    /* renamed from: mjFkc */
    public InterfaceC1601A3 f1859mjFkc;

    /* renamed from: wA */
    public final ArrayList f1860wA;

    /* renamed from: xJ */
    public final C0175lgHUyS f1861xJ;

    /* renamed from: androidx.recyclerview.widget.mjFkc$AZxh */
    public static final class AZxh {

        /* renamed from: AZxh */
        public int f1862AZxh;

        /* renamed from: ZfxDd */
        public int f1863ZfxDd;

        /* renamed from: mjFkc */
        public int f1864mjFkc;

        /* renamed from: wA */
        public Object f1865wA;

        public AZxh(int i, int i2, int i3, Object obj) {
            this.f1864mjFkc = i;
            this.f1862AZxh = i2;
            this.f1863ZfxDd = i3;
            this.f1865wA = obj;
        }

        /* renamed from: equals */
        public boolean m2021equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AZxh)) {
                return false;
            }
            AZxh aZxh = (AZxh) obj;
            int i = this.f1864mjFkc;
            if (i != aZxh.f1864mjFkc) {
                return false;
            }
            if (i == 8 && Math.abs(this.f1863ZfxDd - this.f1862AZxh) == 1 && this.f1863ZfxDd == aZxh.f1862AZxh && this.f1862AZxh == aZxh.f1863ZfxDd) {
                return true;
            }
            if (this.f1863ZfxDd != aZxh.f1863ZfxDd || this.f1862AZxh != aZxh.f1862AZxh) {
                return false;
            }
            Object obj2 = this.f1865wA;
            if (obj2 != null) {
                if (!obj2.equals(aZxh.f1865wA)) {
                    return false;
                }
            } else if (aZxh.f1865wA != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f1864mjFkc * 31) + this.f1862AZxh) * 31) + this.f1863ZfxDd;
        }

        /* renamed from: mjFkc */
        public String m2022mjFkc() {
            int i = this.f1864mjFkc;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + m2022mjFkc() + ",s:" + this.f1862AZxh + "c:" + this.f1863ZfxDd + ",p:" + this.f1865wA + "]";
        }
    }

    /* renamed from: androidx.recyclerview.widget.mjFkc$mjFkc */
    public interface mjFkc {
        /* renamed from: AZxh */
        void mo1548AZxh(AZxh aZxh);

        /* renamed from: JHa */
        void mo1549JHa(int i, int i2);

        /* renamed from: KLFTb */
        void mo1550KLFTb(int i, int i2);

        /* renamed from: ZfxDd */
        void mo1551ZfxDd(int i, int i2);

        /* renamed from: lgHUyS */
        void mo1552lgHUyS(int i, int i2, Object obj);

        /* renamed from: mjFkc */
        void mo1553mjFkc(int i, int i2);

        /* renamed from: wA */
        RecyclerView.AbstractC0157mByQ mo1555wA(int i);

        /* renamed from: xJ */
        void mo1556xJ(AZxh aZxh);
    }

    public C0176mjFkc(mjFkc mjfkc) {
        this(mjfkc, false);
    }

    @Override // androidx.recyclerview.p023widget.C0175lgHUyS.mjFkc
    /* renamed from: AZxh */
    public AZxh mo1999AZxh(int i, int i2, int i3, Object obj) {
        AZxh aZxh = (AZxh) this.f1859mjFkc.mo7550AZxh();
        if (aZxh == null) {
            return new AZxh(i, i2, i3, obj);
        }
        aZxh.f1864mjFkc = i;
        aZxh.f1862AZxh = i2;
        aZxh.f1863ZfxDd = i3;
        aZxh.f1865wA = obj;
        return aZxh;
    }

    /* renamed from: Dt */
    public void m2001Dt() {
        m2017qdMbNW();
        int size = this.f1854AZxh.size();
        for (int i = 0; i < size; i++) {
            AZxh aZxh = (AZxh) this.f1854AZxh.get(i);
            int i2 = aZxh.f1864mjFkc;
            if (i2 == 1) {
                this.f1857ZfxDd.mo1548AZxh(aZxh);
                this.f1857ZfxDd.mo1550KLFTb(aZxh.f1862AZxh, aZxh.f1863ZfxDd);
            } else if (i2 == 2) {
                this.f1857ZfxDd.mo1548AZxh(aZxh);
                this.f1857ZfxDd.mo1549JHa(aZxh.f1862AZxh, aZxh.f1863ZfxDd);
            } else if (i2 == 4) {
                this.f1857ZfxDd.mo1548AZxh(aZxh);
                this.f1857ZfxDd.mo1552lgHUyS(aZxh.f1862AZxh, aZxh.f1863ZfxDd, aZxh.f1865wA);
            } else if (i2 == 8) {
                this.f1857ZfxDd.mo1548AZxh(aZxh);
                this.f1857ZfxDd.mo1553mjFkc(aZxh.f1862AZxh, aZxh.f1863ZfxDd);
            }
            Runnable runnable = this.f1856KLFTb;
            if (runnable != null) {
                runnable.run();
            }
        }
        m2012diqgf(this.f1854AZxh);
        this.f1858lgHUyS = 0;
    }

    /* renamed from: ETF */
    public final void m2002ETF(AZxh aZxh) {
        int i;
        int i2 = aZxh.f1864mjFkc;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iM2008Ucbh = m2008Ucbh(aZxh.f1862AZxh, i2);
        int i3 = aZxh.f1862AZxh;
        int i4 = aZxh.f1864mjFkc;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + aZxh);
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < aZxh.f1863ZfxDd; i6++) {
            int iM2008Ucbh2 = m2008Ucbh(aZxh.f1862AZxh + (i * i6), aZxh.f1864mjFkc);
            int i7 = aZxh.f1864mjFkc;
            if (i7 == 2 ? iM2008Ucbh2 != iM2008Ucbh : !(i7 == 4 && iM2008Ucbh2 == iM2008Ucbh + 1)) {
                AZxh aZxhMo1999AZxh = mo1999AZxh(i7, iM2008Ucbh, i5, aZxh.f1865wA);
                m2009VA(aZxhMo1999AZxh, i3);
                mo2000mjFkc(aZxhMo1999AZxh);
                if (aZxh.f1864mjFkc == 4) {
                    i3 += i5;
                }
                i5 = 1;
                iM2008Ucbh = iM2008Ucbh2;
            } else {
                i5++;
            }
        }
        Object obj = aZxh.f1865wA;
        mo2000mjFkc(aZxh);
        if (i5 > 0) {
            AZxh aZxhMo1999AZxh2 = mo1999AZxh(aZxh.f1864mjFkc, iM2008Ucbh, i5, obj);
            m2009VA(aZxhMo1999AZxh2, i3);
            mo2000mjFkc(aZxhMo1999AZxh2);
        }
    }

    /* renamed from: IEE */
    public final void m2003IEE(AZxh aZxh) {
        this.f1860wA.add(aZxh);
        int i = aZxh.f1864mjFkc;
        if (i == 1) {
            this.f1857ZfxDd.mo1550KLFTb(aZxh.f1862AZxh, aZxh.f1863ZfxDd);
            return;
        }
        if (i == 2) {
            this.f1857ZfxDd.mo1551ZfxDd(aZxh.f1862AZxh, aZxh.f1863ZfxDd);
            return;
        }
        if (i == 4) {
            this.f1857ZfxDd.mo1552lgHUyS(aZxh.f1862AZxh, aZxh.f1863ZfxDd, aZxh.f1865wA);
        } else {
            if (i == 8) {
                this.f1857ZfxDd.mo1553mjFkc(aZxh.f1862AZxh, aZxh.f1863ZfxDd);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + aZxh);
        }
    }

    /* renamed from: JHa */
    public final void m2004JHa(AZxh aZxh) {
        boolean z;
        char c;
        int i = aZxh.f1862AZxh;
        int i2 = aZxh.f1863ZfxDd + i;
        char c2 = 65535;
        int i3 = i;
        int i4 = 0;
        while (i3 < i2) {
            if (this.f1857ZfxDd.mo1555wA(i3) != null || m2015lgHUyS(i3)) {
                if (c2 == 0) {
                    m2002ETF(mo1999AZxh(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    m2003IEE(mo1999AZxh(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            c2 = c;
        }
        if (i4 != aZxh.f1863ZfxDd) {
            mo2000mjFkc(aZxh);
            aZxh = mo1999AZxh(2, i, i4, null);
        }
        if (c2 == 0) {
            m2002ETF(aZxh);
        } else {
            m2003IEE(aZxh);
        }
    }

    /* renamed from: KLFTb */
    public int m2005KLFTb(int i) {
        int size = this.f1854AZxh.size();
        for (int i2 = 0; i2 < size; i2++) {
            AZxh aZxh = (AZxh) this.f1854AZxh.get(i2);
            int i3 = aZxh.f1864mjFkc;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = aZxh.f1862AZxh;
                    if (i4 <= i) {
                        int i5 = aZxh.f1863ZfxDd;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = aZxh.f1862AZxh;
                    if (i6 == i) {
                        i = aZxh.f1863ZfxDd;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (aZxh.f1863ZfxDd <= i) {
                            i++;
                        }
                    }
                }
            } else if (aZxh.f1862AZxh <= i) {
                i += aZxh.f1863ZfxDd;
            }
        }
        return i;
    }

    /* renamed from: MiMN */
    public int m2006MiMN(int i) {
        return m2010YoKzxo(i, 0);
    }

    /* renamed from: Pq */
    public void m2007Pq() {
        this.f1861xJ.m1993AZxh(this.f1854AZxh);
        int size = this.f1854AZxh.size();
        for (int i = 0; i < size; i++) {
            AZxh aZxh = (AZxh) this.f1854AZxh.get(i);
            int i2 = aZxh.f1864mjFkc;
            if (i2 == 1) {
                m2019wA(aZxh);
            } else if (i2 == 2) {
                m2004JHa(aZxh);
            } else if (i2 == 4) {
                m2020xJ(aZxh);
            } else if (i2 == 8) {
                m2011ZfxDd(aZxh);
            }
            Runnable runnable = this.f1856KLFTb;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1854AZxh.clear();
    }

    /* renamed from: Ucbh */
    public final int m2008Ucbh(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.f1860wA.size() - 1; size >= 0; size--) {
            AZxh aZxh = (AZxh) this.f1860wA.get(size);
            int i5 = aZxh.f1864mjFkc;
            if (i5 == 8) {
                int i6 = aZxh.f1862AZxh;
                int i7 = aZxh.f1863ZfxDd;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            aZxh.f1862AZxh = i6 + 1;
                            aZxh.f1863ZfxDd = i7 + 1;
                        } else if (i2 == 2) {
                            aZxh.f1862AZxh = i6 - 1;
                            aZxh.f1863ZfxDd = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        aZxh.f1863ZfxDd = i7 + 1;
                    } else if (i2 == 2) {
                        aZxh.f1863ZfxDd = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        aZxh.f1862AZxh = i6 + 1;
                    } else if (i2 == 2) {
                        aZxh.f1862AZxh = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = aZxh.f1862AZxh;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= aZxh.f1863ZfxDd;
                    } else if (i5 == 2) {
                        i += aZxh.f1863ZfxDd;
                    }
                } else if (i2 == 1) {
                    aZxh.f1862AZxh = i8 + 1;
                } else if (i2 == 2) {
                    aZxh.f1862AZxh = i8 - 1;
                }
            }
        }
        for (int size2 = this.f1860wA.size() - 1; size2 >= 0; size2--) {
            AZxh aZxh2 = (AZxh) this.f1860wA.get(size2);
            if (aZxh2.f1864mjFkc == 8) {
                int i9 = aZxh2.f1863ZfxDd;
                if (i9 == aZxh2.f1862AZxh || i9 < 0) {
                    this.f1860wA.remove(size2);
                    mo2000mjFkc(aZxh2);
                }
            } else if (aZxh2.f1863ZfxDd <= 0) {
                this.f1860wA.remove(size2);
                mo2000mjFkc(aZxh2);
            }
        }
        return i;
    }

    /* renamed from: VA */
    public void m2009VA(AZxh aZxh, int i) {
        this.f1857ZfxDd.mo1556xJ(aZxh);
        int i2 = aZxh.f1864mjFkc;
        if (i2 == 2) {
            this.f1857ZfxDd.mo1549JHa(i, aZxh.f1863ZfxDd);
        } else {
            if (i2 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f1857ZfxDd.mo1552lgHUyS(i, aZxh.f1863ZfxDd, aZxh.f1865wA);
        }
    }

    /* renamed from: YoKzxo */
    public int m2010YoKzxo(int i, int i2) {
        int size = this.f1860wA.size();
        while (i2 < size) {
            AZxh aZxh = (AZxh) this.f1860wA.get(i2);
            int i3 = aZxh.f1864mjFkc;
            if (i3 == 8) {
                int i4 = aZxh.f1862AZxh;
                if (i4 == i) {
                    i = aZxh.f1863ZfxDd;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (aZxh.f1863ZfxDd <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = aZxh.f1862AZxh;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = aZxh.f1863ZfxDd;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += aZxh.f1863ZfxDd;
                }
            }
            i2++;
        }
        return i;
    }

    /* renamed from: ZfxDd */
    public final void m2011ZfxDd(AZxh aZxh) {
        m2003IEE(aZxh);
    }

    /* renamed from: diqgf */
    public void m2012diqgf(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo2000mjFkc((AZxh) list.get(i));
        }
        list.clear();
    }

    /* renamed from: eyqo */
    public void m2013eyqo() {
        m2012diqgf(this.f1854AZxh);
        m2012diqgf(this.f1860wA);
        this.f1858lgHUyS = 0;
    }

    /* renamed from: fehf */
    public boolean m2014fehf() {
        return (this.f1860wA.isEmpty() || this.f1854AZxh.isEmpty()) ? false : true;
    }

    /* renamed from: lgHUyS */
    public final boolean m2015lgHUyS(int i) {
        int size = this.f1860wA.size();
        for (int i2 = 0; i2 < size; i2++) {
            AZxh aZxh = (AZxh) this.f1860wA.get(i2);
            int i3 = aZxh.f1864mjFkc;
            if (i3 == 8) {
                if (m2010YoKzxo(aZxh.f1863ZfxDd, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = aZxh.f1862AZxh;
                int i5 = aZxh.f1863ZfxDd + i4;
                while (i4 < i5) {
                    if (m2010YoKzxo(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.p023widget.C0175lgHUyS.mjFkc
    /* renamed from: mjFkc */
    public void mo2000mjFkc(AZxh aZxh) {
        if (this.f1855JHa) {
            return;
        }
        aZxh.f1865wA = null;
        this.f1859mjFkc.mo7551mjFkc(aZxh);
    }

    /* renamed from: qGY */
    public boolean m2016qGY() {
        return this.f1854AZxh.size() > 0;
    }

    /* renamed from: qdMbNW */
    public void m2017qdMbNW() {
        int size = this.f1860wA.size();
        for (int i = 0; i < size; i++) {
            this.f1857ZfxDd.mo1548AZxh((AZxh) this.f1860wA.get(i));
        }
        m2012diqgf(this.f1860wA);
        this.f1858lgHUyS = 0;
    }

    /* renamed from: rkYL */
    public boolean m2018rkYL(int i) {
        return (this.f1858lgHUyS & i) != 0;
    }

    /* renamed from: wA */
    public final void m2019wA(AZxh aZxh) {
        m2003IEE(aZxh);
    }

    /* renamed from: xJ */
    public final void m2020xJ(AZxh aZxh) {
        int i = aZxh.f1862AZxh;
        int i2 = aZxh.f1863ZfxDd + i;
        int i3 = 0;
        boolean z = -1;
        int i4 = i;
        while (i < i2) {
            if (this.f1857ZfxDd.mo1555wA(i) != null || m2015lgHUyS(i)) {
                if (!z) {
                    m2002ETF(mo1999AZxh(4, i4, i3, aZxh.f1865wA));
                    i4 = i;
                    i3 = 0;
                }
                z = true;
            } else {
                if (z) {
                    m2003IEE(mo1999AZxh(4, i4, i3, aZxh.f1865wA));
                    i4 = i;
                    i3 = 0;
                }
                z = false;
            }
            i3++;
            i++;
        }
        if (i3 != aZxh.f1863ZfxDd) {
            Object obj = aZxh.f1865wA;
            mo2000mjFkc(aZxh);
            aZxh = mo1999AZxh(4, i4, i3, obj);
        }
        if (z) {
            m2003IEE(aZxh);
        } else {
            m2002ETF(aZxh);
        }
    }

    public C0176mjFkc(mjFkc mjfkc, boolean z) {
        this.f1859mjFkc = new C1733C3(30);
        this.f1854AZxh = new ArrayList();
        this.f1860wA = new ArrayList();
        this.f1858lgHUyS = 0;
        this.f1857ZfxDd = mjfkc;
        this.f1855JHa = z;
        this.f1861xJ = new C0175lgHUyS(this);
    }
}
