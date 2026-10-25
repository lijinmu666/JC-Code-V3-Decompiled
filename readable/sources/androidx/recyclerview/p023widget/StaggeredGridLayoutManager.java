package androidx.recyclerview.p023widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.p023widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.AbstractC0159qGY implements RecyclerView.AbstractC0162vI.AZxh {

    /* renamed from: BAnRFn */
    public BitSet f1754BAnRFn;

    /* renamed from: CqaNbM */
    public boolean f1755CqaNbM;

    /* renamed from: Gd */
    public int f1756Gd;

    /* renamed from: HGpJ */
    public final C0128JHa f1757HGpJ;

    /* renamed from: KLMXS */
    public int f1758KLMXS;

    /* renamed from: NPj */
    public int[] f1759NPj;

    /* renamed from: Ne */
    public boolean f1760Ne;

    /* renamed from: Ucbh */
    public AbstractC0178qdMbNW f1763Ucbh;

    /* renamed from: diqgf */
    public C0167JHa[] f1767diqgf;

    /* renamed from: eyqo */
    public AbstractC0178qdMbNW f1768eyqo;

    /* renamed from: huTpC */
    public int f1769huTpC;

    /* renamed from: xrEuO */
    public C0168KLFTb f1776xrEuO;

    /* renamed from: Pq */
    public int f1762Pq = -1;

    /* renamed from: vI */
    public boolean f1773vI = false;

    /* renamed from: VocHEe */
    public boolean f1765VocHEe = false;

    /* renamed from: lB */
    public int f1770lB = -1;

    /* renamed from: wJVbdd */
    public int f1775wJVbdd = Integer.MIN_VALUE;

    /* renamed from: mByQ */
    public C0169ZfxDd f1771mByQ = new C0169ZfxDd();

    /* renamed from: OjSQV */
    public int f1761OjSQV = 2;

    /* renamed from: zvd */
    public final Rect f1777zvd = new Rect();

    /* renamed from: cMLeY */
    public final C0166AZxh f1766cMLeY = new C0166AZxh();

    /* renamed from: rWxwaT */
    public boolean f1772rWxwaT = false;

    /* renamed from: Vnb */
    public boolean f1764Vnb = true;

    /* renamed from: vadzgd */
    public final Runnable f1774vadzgd = new RunnableC0170mjFkc();

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$AZxh */
    public class C0166AZxh {

        /* renamed from: AZxh */
        public int f1778AZxh;

        /* renamed from: JHa */
        public int[] f1779JHa;

        /* renamed from: KLFTb */
        public boolean f1780KLFTb;

        /* renamed from: ZfxDd */
        public boolean f1781ZfxDd;

        /* renamed from: mjFkc */
        public int f1782mjFkc;

        /* renamed from: wA */
        public boolean f1783wA;

        public C0166AZxh() {
            m1919wA();
        }

        /* renamed from: AZxh */
        public void m1916AZxh(int i) {
            if (this.f1783wA) {
                this.f1778AZxh = StaggeredGridLayoutManager.this.f1768eyqo.mo2059qdMbNW() - i;
            } else {
                this.f1778AZxh = StaggeredGridLayoutManager.this.f1768eyqo.mo2051MiMN() + i;
            }
        }

        /* renamed from: ZfxDd */
        public void m1917ZfxDd(C0167JHa[] c0167JHaArr) {
            int length = c0167JHaArr.length;
            int[] iArr = this.f1779JHa;
            if (iArr == null || iArr.length < length) {
                this.f1779JHa = new int[StaggeredGridLayoutManager.this.f1767diqgf.length];
            }
            for (int i = 0; i < length; i++) {
                this.f1779JHa[i] = c0167JHaArr[i].m1937qGY(Integer.MIN_VALUE);
            }
        }

        /* renamed from: mjFkc */
        public void m1918mjFkc() {
            this.f1778AZxh = this.f1783wA ? StaggeredGridLayoutManager.this.f1768eyqo.mo2059qdMbNW() : StaggeredGridLayoutManager.this.f1768eyqo.mo2051MiMN();
        }

        /* renamed from: wA */
        public void m1919wA() {
            this.f1782mjFkc = -1;
            this.f1778AZxh = Integer.MIN_VALUE;
            this.f1783wA = false;
            this.f1781ZfxDd = false;
            this.f1780KLFTb = false;
            int[] iArr = this.f1779JHa;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$JHa */
    public class C0167JHa {

        /* renamed from: KLFTb */
        public final int f1787KLFTb;

        /* renamed from: mjFkc */
        public ArrayList f1789mjFkc = new ArrayList();

        /* renamed from: AZxh */
        public int f1785AZxh = Integer.MIN_VALUE;

        /* renamed from: wA */
        public int f1790wA = Integer.MIN_VALUE;

        /* renamed from: ZfxDd */
        public int f1788ZfxDd = 0;

        public C0167JHa(int i) {
            this.f1787KLFTb = i;
        }

        /* renamed from: AZxh */
        public void m1920AZxh(boolean z, int i) {
            int iM1929VA = z ? m1929VA(Integer.MIN_VALUE) : m1937qGY(Integer.MIN_VALUE);
            m1925KLFTb();
            if (iM1929VA == Integer.MIN_VALUE) {
                return;
            }
            if (!z || iM1929VA >= StaggeredGridLayoutManager.this.f1768eyqo.mo2059qdMbNW()) {
                if (z || iM1929VA <= StaggeredGridLayoutManager.this.f1768eyqo.mo2051MiMN()) {
                    if (i != Integer.MIN_VALUE) {
                        iM1929VA += i;
                    }
                    this.f1790wA = iM1929VA;
                    this.f1785AZxh = iM1929VA;
                }
            }
        }

        /* renamed from: Dt */
        public int m1921Dt() {
            return this.f1788ZfxDd;
        }

        /* renamed from: ETF */
        public int m1922ETF() {
            int i = this.f1790wA;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            m1940wA();
            return this.f1790wA;
        }

        /* renamed from: IEE */
        public void m1923IEE(int i) {
            int i2 = this.f1785AZxh;
            if (i2 != Integer.MIN_VALUE) {
                this.f1785AZxh = i2 + i;
            }
            int i3 = this.f1790wA;
            if (i3 != Integer.MIN_VALUE) {
                this.f1790wA = i3 + i;
            }
        }

        /* renamed from: JHa */
        public int m1924JHa() {
            return StaggeredGridLayoutManager.this.f1773vI ? m1938qdMbNW(this.f1789mjFkc.size() - 1, -1, true) : m1938qdMbNW(0, this.f1789mjFkc.size(), true);
        }

        /* renamed from: KLFTb */
        public void m1925KLFTb() {
            this.f1789mjFkc.clear();
            m1934fehf();
            this.f1788ZfxDd = 0;
        }

        /* renamed from: MiMN */
        public View m1926MiMN(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f1789mjFkc.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.f1789mjFkc.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f1773vI && staggeredGridLayoutManager.m1799tQ(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f1773vI && staggeredGridLayoutManager2.m1799tQ(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f1789mjFkc.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = (View) this.f1789mjFkc.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f1773vI && staggeredGridLayoutManager3.m1799tQ(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f1773vI && staggeredGridLayoutManager4.m1799tQ(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        /* renamed from: Pq */
        public void m1927Pq() {
            int size = this.f1789mjFkc.size();
            View view = (View) this.f1789mjFkc.remove(size - 1);
            C0171wA c0171wAM1930YoKzxo = m1930YoKzxo(view);
            c0171wAM1930YoKzxo.f1811KLFTb = null;
            if (c0171wAM1930YoKzxo.m1654wA() || c0171wAM1930YoKzxo.m1651AZxh()) {
                this.f1788ZfxDd -= StaggeredGridLayoutManager.this.f1768eyqo.mo2050KLFTb(view);
            }
            if (size == 1) {
                this.f1785AZxh = Integer.MIN_VALUE;
            }
            this.f1790wA = Integer.MIN_VALUE;
        }

        /* renamed from: Ucbh */
        public void m1928Ucbh(int i) {
            this.f1785AZxh = i;
            this.f1790wA = i;
        }

        /* renamed from: VA */
        public int m1929VA(int i) {
            int i2 = this.f1790wA;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f1789mjFkc.size() == 0) {
                return i;
            }
            m1940wA();
            return this.f1790wA;
        }

        /* renamed from: YoKzxo */
        public C0171wA m1930YoKzxo(View view) {
            return (C0171wA) view.getLayoutParams();
        }

        /* renamed from: ZfxDd */
        public void m1931ZfxDd() {
            C0169ZfxDd.mjFkc mjfkcM1949JHa;
            View view = (View) this.f1789mjFkc.get(0);
            C0171wA c0171wAM1930YoKzxo = m1930YoKzxo(view);
            this.f1785AZxh = StaggeredGridLayoutManager.this.f1768eyqo.mo2061xJ(view);
            if (c0171wAM1930YoKzxo.f1810JHa && (mjfkcM1949JHa = StaggeredGridLayoutManager.this.f1771mByQ.m1949JHa(c0171wAM1930YoKzxo.m1653mjFkc())) != null && mjfkcM1949JHa.f1805AZxh == -1) {
                this.f1785AZxh -= mjfkcM1949JHa.m1961mjFkc(this.f1787KLFTb);
            }
        }

        /* renamed from: diqgf */
        public void m1932diqgf() {
            View view = (View) this.f1789mjFkc.remove(0);
            C0171wA c0171wAM1930YoKzxo = m1930YoKzxo(view);
            c0171wAM1930YoKzxo.f1811KLFTb = null;
            if (this.f1789mjFkc.size() == 0) {
                this.f1790wA = Integer.MIN_VALUE;
            }
            if (c0171wAM1930YoKzxo.m1654wA() || c0171wAM1930YoKzxo.m1651AZxh()) {
                this.f1788ZfxDd -= StaggeredGridLayoutManager.this.f1768eyqo.mo2050KLFTb(view);
            }
            this.f1785AZxh = Integer.MIN_VALUE;
        }

        /* renamed from: eyqo */
        public void m1933eyqo(View view) {
            C0171wA c0171wAM1930YoKzxo = m1930YoKzxo(view);
            c0171wAM1930YoKzxo.f1811KLFTb = this;
            this.f1789mjFkc.add(0, view);
            this.f1785AZxh = Integer.MIN_VALUE;
            if (this.f1789mjFkc.size() == 1) {
                this.f1790wA = Integer.MIN_VALUE;
            }
            if (c0171wAM1930YoKzxo.m1654wA() || c0171wAM1930YoKzxo.m1651AZxh()) {
                this.f1788ZfxDd += StaggeredGridLayoutManager.this.f1768eyqo.mo2050KLFTb(view);
            }
        }

        /* renamed from: fehf */
        public void m1934fehf() {
            this.f1785AZxh = Integer.MIN_VALUE;
            this.f1790wA = Integer.MIN_VALUE;
        }

        /* renamed from: lgHUyS */
        public int m1935lgHUyS(int i, int i2, boolean z, boolean z2, boolean z3) {
            int iMo2051MiMN = StaggeredGridLayoutManager.this.f1768eyqo.mo2051MiMN();
            int iMo2059qdMbNW = StaggeredGridLayoutManager.this.f1768eyqo.mo2059qdMbNW();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = (View) this.f1789mjFkc.get(i);
                int iMo2061xJ = StaggeredGridLayoutManager.this.f1768eyqo.mo2061xJ(view);
                int iMo2055ZfxDd = StaggeredGridLayoutManager.this.f1768eyqo.mo2055ZfxDd(view);
                boolean z4 = false;
                boolean z5 = !z3 ? iMo2061xJ >= iMo2059qdMbNW : iMo2061xJ > iMo2059qdMbNW;
                if (!z3 ? iMo2055ZfxDd > iMo2051MiMN : iMo2055ZfxDd >= iMo2051MiMN) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (iMo2061xJ >= iMo2051MiMN && iMo2055ZfxDd <= iMo2059qdMbNW) {
                            return StaggeredGridLayoutManager.this.m1799tQ(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.m1799tQ(view);
                        }
                        if (iMo2061xJ < iMo2051MiMN || iMo2055ZfxDd > iMo2059qdMbNW) {
                            return StaggeredGridLayoutManager.this.m1799tQ(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        /* renamed from: mjFkc */
        public void m1936mjFkc(View view) {
            C0171wA c0171wAM1930YoKzxo = m1930YoKzxo(view);
            c0171wAM1930YoKzxo.f1811KLFTb = this;
            this.f1789mjFkc.add(view);
            this.f1790wA = Integer.MIN_VALUE;
            if (this.f1789mjFkc.size() == 1) {
                this.f1785AZxh = Integer.MIN_VALUE;
            }
            if (c0171wAM1930YoKzxo.m1654wA() || c0171wAM1930YoKzxo.m1651AZxh()) {
                this.f1788ZfxDd += StaggeredGridLayoutManager.this.f1768eyqo.mo2050KLFTb(view);
            }
        }

        /* renamed from: qGY */
        public int m1937qGY(int i) {
            int i2 = this.f1785AZxh;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f1789mjFkc.size() == 0) {
                return i;
            }
            m1931ZfxDd();
            return this.f1785AZxh;
        }

        /* renamed from: qdMbNW */
        public int m1938qdMbNW(int i, int i2, boolean z) {
            return m1935lgHUyS(i, i2, false, false, z);
        }

        /* renamed from: rkYL */
        public int m1939rkYL() {
            int i = this.f1785AZxh;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            m1931ZfxDd();
            return this.f1785AZxh;
        }

        /* renamed from: wA */
        public void m1940wA() {
            C0169ZfxDd.mjFkc mjfkcM1949JHa;
            ArrayList arrayList = this.f1789mjFkc;
            View view = (View) arrayList.get(arrayList.size() - 1);
            C0171wA c0171wAM1930YoKzxo = m1930YoKzxo(view);
            this.f1790wA = StaggeredGridLayoutManager.this.f1768eyqo.mo2055ZfxDd(view);
            if (c0171wAM1930YoKzxo.f1810JHa && (mjfkcM1949JHa = StaggeredGridLayoutManager.this.f1771mByQ.m1949JHa(c0171wAM1930YoKzxo.m1653mjFkc())) != null && mjfkcM1949JHa.f1805AZxh == 1) {
                this.f1790wA += mjfkcM1949JHa.m1961mjFkc(this.f1787KLFTb);
            }
        }

        /* renamed from: xJ */
        public int m1941xJ() {
            return StaggeredGridLayoutManager.this.f1773vI ? m1938qdMbNW(0, this.f1789mjFkc.size(), true) : m1938qdMbNW(this.f1789mjFkc.size() - 1, -1, true);
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$KLFTb */
    public static class C0168KLFTb implements Parcelable {

        /* renamed from: CREATOR */
        public static final Parcelable.Creator<C0168KLFTb> f1791CREATOR = new mjFkc();

        /* renamed from: AZxh */
        public int f1792AZxh;

        /* renamed from: Dt */
        public boolean f1793Dt;

        /* renamed from: JHa */
        public int[] f1794JHa;

        /* renamed from: KLFTb */
        public int f1795KLFTb;

        /* renamed from: ZfxDd */
        public int[] f1796ZfxDd;

        /* renamed from: lgHUyS */
        public boolean f1797lgHUyS;

        /* renamed from: mjFkc */
        public int f1798mjFkc;

        /* renamed from: qdMbNW */
        public boolean f1799qdMbNW;

        /* renamed from: wA */
        public int f1800wA;

        /* renamed from: xJ */
        public List f1801xJ;

        /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$KLFTb$mjFkc */
        public class mjFkc implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
            public C0168KLFTb[] newArray(int i) {
                return new C0168KLFTb[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public C0168KLFTb createFromParcel(Parcel parcel) {
                return new C0168KLFTb(parcel);
            }
        }

        public C0168KLFTb() {
        }

        /* renamed from: AZxh */
        public void m1942AZxh() {
            this.f1796ZfxDd = null;
            this.f1800wA = 0;
            this.f1795KLFTb = 0;
            this.f1794JHa = null;
            this.f1801xJ = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: mjFkc */
        public void m1943mjFkc() {
            this.f1796ZfxDd = null;
            this.f1800wA = 0;
            this.f1798mjFkc = -1;
            this.f1792AZxh = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1798mjFkc);
            parcel.writeInt(this.f1792AZxh);
            parcel.writeInt(this.f1800wA);
            if (this.f1800wA > 0) {
                parcel.writeIntArray(this.f1796ZfxDd);
            }
            parcel.writeInt(this.f1795KLFTb);
            if (this.f1795KLFTb > 0) {
                parcel.writeIntArray(this.f1794JHa);
            }
            parcel.writeInt(this.f1797lgHUyS ? 1 : 0);
            parcel.writeInt(this.f1799qdMbNW ? 1 : 0);
            parcel.writeInt(this.f1793Dt ? 1 : 0);
            parcel.writeList(this.f1801xJ);
        }

        public C0168KLFTb(Parcel parcel) {
            this.f1798mjFkc = parcel.readInt();
            this.f1792AZxh = parcel.readInt();
            int i = parcel.readInt();
            this.f1800wA = i;
            if (i > 0) {
                int[] iArr = new int[i];
                this.f1796ZfxDd = iArr;
                parcel.readIntArray(iArr);
            }
            int i2 = parcel.readInt();
            this.f1795KLFTb = i2;
            if (i2 > 0) {
                int[] iArr2 = new int[i2];
                this.f1794JHa = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f1797lgHUyS = parcel.readInt() == 1;
            this.f1799qdMbNW = parcel.readInt() == 1;
            this.f1793Dt = parcel.readInt() == 1;
            this.f1801xJ = parcel.readArrayList(C0169ZfxDd.mjFkc.class.getClassLoader());
        }

        public C0168KLFTb(C0168KLFTb c0168KLFTb) {
            this.f1800wA = c0168KLFTb.f1800wA;
            this.f1798mjFkc = c0168KLFTb.f1798mjFkc;
            this.f1792AZxh = c0168KLFTb.f1792AZxh;
            this.f1796ZfxDd = c0168KLFTb.f1796ZfxDd;
            this.f1795KLFTb = c0168KLFTb.f1795KLFTb;
            this.f1794JHa = c0168KLFTb.f1794JHa;
            this.f1797lgHUyS = c0168KLFTb.f1797lgHUyS;
            this.f1799qdMbNW = c0168KLFTb.f1799qdMbNW;
            this.f1793Dt = c0168KLFTb.f1793Dt;
            this.f1801xJ = c0168KLFTb.f1801xJ;
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$mjFkc */
    public class RunnableC0170mjFkc implements Runnable {
        public RunnableC0170mjFkc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.m1889Vptz();
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$wA */
    public static class C0171wA extends RecyclerView.C0153fehf {

        /* renamed from: JHa */
        public boolean f1810JHa;

        /* renamed from: KLFTb */
        public C0167JHa f1811KLFTb;

        public C0171wA(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* renamed from: KLFTb */
        public boolean m1964KLFTb() {
            return this.f1810JHa;
        }

        public C0171wA(int i, int i2) {
            super(i, i2);
        }

        public C0171wA(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0171wA(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.AbstractC0159qGY.ZfxDd zfxDdM1718yfx = RecyclerView.AbstractC0159qGY.m1718yfx(context, attributeSet, i, i2);
        m1891ZGL(zfxDdM1718yfx.f1728mjFkc);
        m1895eEOGOh(zfxDdM1718yfx.f1726AZxh);
        m1901jpz(zfxDdM1718yfx.f1729wA);
        this.f1757HGpJ = new C0128JHa();
        m1892aDq();
    }

    /* renamed from: CcoH */
    private int m1858CcoH(RecyclerView.C0148VocHEe c0148VocHEe) {
        if (m1817zvd() == 0) {
            return 0;
        }
        return AbstractC0172VA.m1966mjFkc(c0148VocHEe, this.f1768eyqo, m1882Rsp(!this.f1764Vnb), m1866CqAnRZ(!this.f1764Vnb), this, this.f1764Vnb);
    }

    /* renamed from: EoC */
    private int m1859EoC(RecyclerView.C0148VocHEe c0148VocHEe) {
        if (m1817zvd() == 0) {
            return 0;
        }
        return AbstractC0172VA.m1967wA(c0148VocHEe, this.f1768eyqo, m1882Rsp(!this.f1764Vnb), m1866CqAnRZ(!this.f1764Vnb), this, this.f1764Vnb);
    }

    /* renamed from: HX */
    private int m1860HX(RecyclerView.C0148VocHEe c0148VocHEe) {
        if (m1817zvd() == 0) {
            return 0;
        }
        return AbstractC0172VA.m1965AZxh(c0148VocHEe, this.f1768eyqo, m1882Rsp(!this.f1764Vnb), m1866CqAnRZ(!this.f1764Vnb), this, this.f1764Vnb, this.f1765VocHEe);
    }

    /* renamed from: OzIs */
    private void m1861OzIs(View view, int i, int i2, boolean z) {
        m1725ETF(view, this.f1777zvd);
        C0171wA c0171wA = (C0171wA) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) c0171wA).leftMargin;
        Rect rect = this.f1777zvd;
        int iM1874KbE = m1874KbE(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) c0171wA).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) c0171wA).topMargin;
        Rect rect2 = this.f1777zvd;
        int iM1874KbE2 = m1874KbE(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) c0171wA).bottomMargin + rect2.bottom);
        if (z ? m1801tpGcn(view, iM1874KbE, iM1874KbE2, c0171wA) : m1814yP(view, iM1874KbE, iM1874KbE2, c0171wA)) {
            view.measure(iM1874KbE, iM1874KbE2);
        }
    }

    /* renamed from: kOlLW */
    private void m1862kOlLW() {
        if (this.f1769huTpC == 1 || !m1879Otxclu()) {
            this.f1765VocHEe = this.f1773vI;
        } else {
            this.f1765VocHEe = !this.f1773vI;
        }
    }

    /* renamed from: xbjHT */
    private int m1863xbjHT(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.f1769huTpC == 1) ? 1 : Integer.MIN_VALUE : this.f1769huTpC == 0 ? 1 : Integer.MIN_VALUE : this.f1769huTpC == 1 ? -1 : Integer.MIN_VALUE : this.f1769huTpC == 0 ? -1 : Integer.MIN_VALUE : (this.f1769huTpC != 1 && m1879Otxclu()) ? -1 : 1 : (this.f1769huTpC != 1 && m1879Otxclu()) ? 1 : -1;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0162vI.AZxh
    /* renamed from: AZxh */
    public PointF mo1304AZxh(int i) {
        int iM1873KSf = m1873KSf(i);
        PointF pointF = new PointF();
        if (iM1873KSf == 0) {
            return null;
        }
        if (this.f1769huTpC == 0) {
            pointF.x = iM1873KSf;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iM1873KSf;
        }
        return pointF;
    }

    /* renamed from: ArO */
    public final void m1864ArO(View view, C0171wA c0171wA, boolean z) {
        if (c0171wA.f1810JHa) {
            if (this.f1769huTpC == 1) {
                m1861OzIs(view, this.f1758KLMXS, RecyclerView.AbstractC0159qGY.m1716cMLeY(m1737JYgkl(), m1741JrJO(), m1777dm() + m1735JBhc(), ((ViewGroup.MarginLayoutParams) c0171wA).height, true), z);
                return;
            } else {
                m1861OzIs(view, RecyclerView.AbstractC0159qGY.m1716cMLeY(m1755SOS(), m1751Qr(), m1783jm() + m1719ANMGZc(), ((ViewGroup.MarginLayoutParams) c0171wA).width, true), this.f1758KLMXS, z);
                return;
            }
        }
        if (this.f1769huTpC == 1) {
            m1861OzIs(view, RecyclerView.AbstractC0159qGY.m1716cMLeY(this.f1756Gd, m1751Qr(), 0, ((ViewGroup.MarginLayoutParams) c0171wA).width, false), RecyclerView.AbstractC0159qGY.m1716cMLeY(m1737JYgkl(), m1741JrJO(), m1777dm() + m1735JBhc(), ((ViewGroup.MarginLayoutParams) c0171wA).height, true), z);
        } else {
            m1861OzIs(view, RecyclerView.AbstractC0159qGY.m1716cMLeY(m1755SOS(), m1751Qr(), m1783jm() + m1719ANMGZc(), ((ViewGroup.MarginLayoutParams) c0171wA).width, true), RecyclerView.AbstractC0159qGY.m1716cMLeY(this.f1756Gd, m1741JrJO(), 0, ((ViewGroup.MarginLayoutParams) c0171wA).height, false), z);
        }
    }

    /* renamed from: BABY */
    public final void m1865BABY(int i, int i2) {
        for (int i3 = 0; i3 < this.f1762Pq; i3++) {
            if (!this.f1767diqgf[i3].f1789mjFkc.isEmpty()) {
                m1898ih(this.f1767diqgf[i3], i, i2);
            }
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: BxruE */
    public int mo1230BxruE(int i, RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        return m1875LlB(i, c0146Ucbh, c0148VocHEe);
    }

    /* renamed from: CqAnRZ */
    public View m1866CqAnRZ(boolean z) {
        int iMo2051MiMN = this.f1768eyqo.mo2051MiMN();
        int iMo2059qdMbNW = this.f1768eyqo.mo2059qdMbNW();
        View view = null;
        for (int iM1817zvd = m1817zvd() - 1; iM1817zvd >= 0; iM1817zvd--) {
            View viewM1743KLMXS = m1743KLMXS(iM1817zvd);
            int iMo2061xJ = this.f1768eyqo.mo2061xJ(viewM1743KLMXS);
            int iMo2055ZfxDd = this.f1768eyqo.mo2055ZfxDd(viewM1743KLMXS);
            if (iMo2055ZfxDd > iMo2051MiMN && iMo2061xJ < iMo2059qdMbNW) {
                if (iMo2055ZfxDd <= iMo2059qdMbNW || !z) {
                    return viewM1743KLMXS;
                }
                if (view == null) {
                    view = viewM1743KLMXS;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Dp */
    public void mo1308Dp(AccessibilityEvent accessibilityEvent) {
        super.mo1308Dp(accessibilityEvent);
        if (m1817zvd() > 0) {
            View viewM1882Rsp = m1882Rsp(false);
            View viewM1866CqAnRZ = m1866CqAnRZ(false);
            if (viewM1882Rsp == null || viewM1866CqAnRZ == null) {
                return;
            }
            int iM1799tQ = m1799tQ(viewM1882Rsp);
            int iM1799tQ2 = m1799tQ(viewM1866CqAnRZ);
            if (iM1799tQ < iM1799tQ2) {
                accessibilityEvent.setFromIndex(iM1799tQ);
                accessibilityEvent.setToIndex(iM1799tQ2);
            } else {
                accessibilityEvent.setFromIndex(iM1799tQ2);
                accessibilityEvent.setToIndex(iM1799tQ);
            }
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: ERt */
    public boolean mo1231ERt() {
        return this.f1776xrEuO == null;
    }

    /* renamed from: EeoThB */
    public void m1867EeoThB(int i, RecyclerView.C0148VocHEe c0148VocHEe) {
        int iM1893bWIyu;
        int i2;
        if (i > 0) {
            iM1893bWIyu = m1890XyP();
            i2 = 1;
        } else {
            iM1893bWIyu = m1893bWIyu();
            i2 = -1;
        }
        this.f1757HGpJ.f1474mjFkc = true;
        m1897gjvQ(iM1893bWIyu, c0148VocHEe);
        m1868Es(i2);
        C0128JHa c0128JHa = this.f1757HGpJ;
        c0128JHa.f1476wA = iM1893bWIyu + c0128JHa.f1472ZfxDd;
        c0128JHa.f1469AZxh = Math.abs(i);
    }

    /* renamed from: Es */
    public final void m1868Es(int i) {
        C0128JHa c0128JHa = this.f1757HGpJ;
        c0128JHa.f1471KLFTb = i;
        c0128JHa.f1472ZfxDd = this.f1765VocHEe != (i == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: FbxKQm */
    public void mo1233FbxKQm(RecyclerView recyclerView) {
        this.f1771mByQ.m1946AZxh();
        m1788mzUGzO();
    }

    /* renamed from: HExgdj */
    public final void m1869HExgdj(View view, C0171wA c0171wA, C0128JHa c0128JHa) {
        if (c0128JHa.f1471KLFTb == 1) {
            if (c0171wA.f1810JHa) {
                m1872JOe(view);
                return;
            } else {
                c0171wA.f1811KLFTb.m1936mjFkc(view);
                return;
            }
        }
        if (c0171wA.f1810JHa) {
            m1894cdjp(view);
        } else {
            c0171wA.f1811KLFTb.m1933eyqo(view);
        }
    }

    /* renamed from: Hk */
    public final void m1870Hk(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, boolean z) {
        int iMo2059qdMbNW;
        int iM1886UDcil = m1886UDcil(Integer.MIN_VALUE);
        if (iM1886UDcil != Integer.MIN_VALUE && (iMo2059qdMbNW = this.f1768eyqo.mo2059qdMbNW() - iM1886UDcil) > 0) {
            int i = iMo2059qdMbNW - (-m1875LlB(-iMo2059qdMbNW, c0146Ucbh, c0148VocHEe));
            if (!z || i <= 0) {
                return;
            }
            this.f1768eyqo.mo2048IEE(i);
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: IEE */
    public int mo1315IEE(RecyclerView.C0148VocHEe c0148VocHEe) {
        return m1858CcoH(c0148VocHEe);
    }

    /* renamed from: IPpyV */
    public final void m1871IPpyV() {
        if (this.f1763Ucbh.mo2047ETF() == 1073741824) {
            return;
        }
        int iM1817zvd = m1817zvd();
        float fMax = 0.0f;
        for (int i = 0; i < iM1817zvd; i++) {
            View viewM1743KLMXS = m1743KLMXS(i);
            float fMo2050KLFTb = this.f1763Ucbh.mo2050KLFTb(viewM1743KLMXS);
            if (fMo2050KLFTb >= fMax) {
                if (((C0171wA) viewM1743KLMXS.getLayoutParams()).m1964KLFTb()) {
                    fMo2050KLFTb = (fMo2050KLFTb * 1.0f) / this.f1762Pq;
                }
                fMax = Math.max(fMax, fMo2050KLFTb);
            }
        }
        int i2 = this.f1756Gd;
        int iRound = Math.round(fMax * this.f1762Pq);
        if (this.f1763Ucbh.mo2047ETF() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.f1763Ucbh.mo2054YoKzxo());
        }
        m1902kw(iRound);
        if (this.f1756Gd == i2) {
            return;
        }
        for (int i3 = 0; i3 < iM1817zvd; i3++) {
            View viewM1743KLMXS2 = m1743KLMXS(i3);
            C0171wA c0171wA = (C0171wA) viewM1743KLMXS2.getLayoutParams();
            if (!c0171wA.f1810JHa) {
                if (m1879Otxclu() && this.f1769huTpC == 1) {
                    int i4 = this.f1762Pq;
                    int i5 = c0171wA.f1811KLFTb.f1787KLFTb;
                    viewM1743KLMXS2.offsetLeftAndRight(((-((i4 - 1) - i5)) * this.f1756Gd) - ((-((i4 - 1) - i5)) * i2));
                } else {
                    int i6 = c0171wA.f1811KLFTb.f1787KLFTb;
                    int i7 = this.f1756Gd * i6;
                    int i8 = i6 * i2;
                    if (this.f1769huTpC == 1) {
                        viewM1743KLMXS2.offsetLeftAndRight(i7 - i8);
                    } else {
                        viewM1743KLMXS2.offsetTopAndBottom(i7 - i8);
                    }
                }
            }
        }
    }

    /* renamed from: JOe */
    public final void m1872JOe(View view) {
        for (int i = this.f1762Pq - 1; i >= 0; i--) {
            this.f1767diqgf[i].m1936mjFkc(view);
        }
    }

    /* renamed from: KSf */
    public final int m1873KSf(int i) {
        if (m1817zvd() == 0) {
            return this.f1765VocHEe ? 1 : -1;
        }
        return (i < m1893bWIyu()) != this.f1765VocHEe ? -1 : 1;
    }

    /* renamed from: KbE */
    public final int m1874KbE(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    /* renamed from: LlB */
    public int m1875LlB(int i, RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        if (m1817zvd() == 0 || i == 0) {
            return 0;
        }
        m1867EeoThB(i, c0148VocHEe);
        int iM1910vZ = m1910vZ(c0146Ucbh, this.f1757HGpJ, c0148VocHEe);
        if (this.f1757HGpJ.f1469AZxh >= iM1910vZ) {
            i = i < 0 ? -iM1910vZ : iM1910vZ;
        }
        this.f1768eyqo.mo2048IEE(-i);
        this.f1760Ne = this.f1765VocHEe;
        C0128JHa c0128JHa = this.f1757HGpJ;
        c0128JHa.f1469AZxh = 0;
        m1912xBQUgd(c0146Ucbh, c0128JHa);
        return i;
    }

    /* renamed from: MC */
    public final C0169ZfxDd.mjFkc m1876MC(int i) {
        C0169ZfxDd.mjFkc mjfkc = new C0169ZfxDd.mjFkc();
        mjfkc.f1808wA = new int[this.f1762Pq];
        for (int i2 = 0; i2 < this.f1762Pq; i2++) {
            mjfkc.f1808wA[i2] = this.f1767diqgf[i2].m1937qGY(i) - i;
        }
        return mjfkc;
    }

    /* renamed from: MFekjo */
    public final void m1877MFekjo(RecyclerView.C0146Ucbh c0146Ucbh, int i) {
        for (int iM1817zvd = m1817zvd() - 1; iM1817zvd >= 0; iM1817zvd--) {
            View viewM1743KLMXS = m1743KLMXS(iM1817zvd);
            if (this.f1768eyqo.mo2061xJ(viewM1743KLMXS) < i || this.f1768eyqo.mo2056fehf(viewM1743KLMXS) < i) {
                return;
            }
            C0171wA c0171wA = (C0171wA) viewM1743KLMXS.getLayoutParams();
            if (c0171wA.f1810JHa) {
                for (int i2 = 0; i2 < this.f1762Pq; i2++) {
                    if (this.f1767diqgf[i2].f1789mjFkc.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.f1762Pq; i3++) {
                    this.f1767diqgf[i3].m1927Pq();
                }
            } else if (c0171wA.f1811KLFTb.f1789mjFkc.size() == 1) {
                return;
            } else {
                c0171wA.f1811KLFTb.m1927Pq();
            }
            m1752RWyiuY(viewM1743KLMXS, c0146Ucbh);
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: MiMN */
    public boolean mo1322MiMN() {
        return this.f1769huTpC == 1;
    }

    /* renamed from: Mpf */
    public final int m1878Mpf(int i) {
        for (int iM1817zvd = m1817zvd() - 1; iM1817zvd >= 0; iM1817zvd--) {
            int iM1799tQ = m1799tQ(m1743KLMXS(iM1817zvd));
            if (iM1799tQ >= 0 && iM1799tQ < i) {
                return iM1799tQ;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: NV */
    public void mo1750NV(int i) {
        if (i == 0) {
            m1889Vptz();
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Ne */
    public RecyclerView.C0153fehf mo1238Ne(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0171wA((ViewGroup.MarginLayoutParams) layoutParams) : new C0171wA(layoutParams);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: OjSQV */
    public RecyclerView.C0153fehf mo1239OjSQV(Context context, AttributeSet attributeSet) {
        return new C0171wA(context, attributeSet);
    }

    /* renamed from: Otxclu */
    public boolean m1879Otxclu() {
        return m1764WGXroI() == 1;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Pq */
    public int mo1240Pq(RecyclerView.C0148VocHEe c0148VocHEe) {
        return m1860HX(c0148VocHEe);
    }

    /* renamed from: QyMqpM */
    public boolean m1880QyMqpM() {
        int iM1937qGY = this.f1767diqgf[0].m1937qGY(Integer.MIN_VALUE);
        for (int i = 1; i < this.f1762Pq; i++) {
            if (this.f1767diqgf[i].m1937qGY(Integer.MIN_VALUE) != iM1937qGY) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: QyqF */
    public int mo1241QyqF(int i, RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        return m1875LlB(i, c0146Ucbh, c0148VocHEe);
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0155  */
    /* renamed from: RWb */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1881RWb(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, boolean z) {
        C0168KLFTb c0168KLFTb;
        C0166AZxh c0166AZxh = this.f1766cMLeY;
        if (!(this.f1776xrEuO == null && this.f1770lB == -1) && c0148VocHEe.m1624AZxh() == 0) {
            m1797sqndV(c0146Ucbh);
            c0166AZxh.m1919wA();
            return;
        }
        boolean z2 = true;
        boolean z3 = (c0166AZxh.f1780KLFTb && this.f1770lB == -1 && this.f1776xrEuO == null) ? false : true;
        if (z3) {
            c0166AZxh.m1919wA();
            if (this.f1776xrEuO != null) {
                m1905pJeaSR(c0166AZxh);
            } else {
                m1862kOlLW();
                c0166AZxh.f1783wA = this.f1765VocHEe;
            }
            m1913xVYW(c0148VocHEe, c0166AZxh);
            c0166AZxh.f1780KLFTb = true;
        }
        if (this.f1776xrEuO == null && this.f1770lB == -1 && (c0166AZxh.f1783wA != this.f1760Ne || m1879Otxclu() != this.f1755CqaNbM)) {
            this.f1771mByQ.m1946AZxh();
            c0166AZxh.f1781ZfxDd = true;
        }
        if (m1817zvd() > 0 && ((c0168KLFTb = this.f1776xrEuO) == null || c0168KLFTb.f1800wA < 1)) {
            if (c0166AZxh.f1781ZfxDd) {
                for (int i = 0; i < this.f1762Pq; i++) {
                    this.f1767diqgf[i].m1925KLFTb();
                    int i2 = c0166AZxh.f1778AZxh;
                    if (i2 != Integer.MIN_VALUE) {
                        this.f1767diqgf[i].m1928Ucbh(i2);
                    }
                }
            } else if (z3 || this.f1766cMLeY.f1779JHa == null) {
                for (int i3 = 0; i3 < this.f1762Pq; i3++) {
                    this.f1767diqgf[i3].m1920AZxh(this.f1765VocHEe, c0166AZxh.f1778AZxh);
                }
                this.f1766cMLeY.m1917ZfxDd(this.f1767diqgf);
            } else {
                for (int i4 = 0; i4 < this.f1762Pq; i4++) {
                    C0167JHa c0167JHa = this.f1767diqgf[i4];
                    c0167JHa.m1925KLFTb();
                    c0167JHa.m1928Ucbh(this.f1766cMLeY.f1779JHa[i4]);
                }
            }
        }
        m1729Gd(c0146Ucbh);
        this.f1757HGpJ.f1474mjFkc = false;
        this.f1772rWxwaT = false;
        m1902kw(this.f1763Ucbh.mo2054YoKzxo());
        m1897gjvQ(c0166AZxh.f1782mjFkc, c0148VocHEe);
        if (c0166AZxh.f1783wA) {
            m1868Es(-1);
            m1910vZ(c0146Ucbh, this.f1757HGpJ, c0148VocHEe);
            m1868Es(1);
            C0128JHa c0128JHa = this.f1757HGpJ;
            c0128JHa.f1476wA = c0166AZxh.f1782mjFkc + c0128JHa.f1472ZfxDd;
            m1910vZ(c0146Ucbh, c0128JHa, c0148VocHEe);
        } else {
            m1868Es(1);
            m1910vZ(c0146Ucbh, this.f1757HGpJ, c0148VocHEe);
            m1868Es(-1);
            C0128JHa c0128JHa2 = this.f1757HGpJ;
            c0128JHa2.f1476wA = c0166AZxh.f1782mjFkc + c0128JHa2.f1472ZfxDd;
            m1910vZ(c0146Ucbh, c0128JHa2, c0148VocHEe);
        }
        m1871IPpyV();
        if (m1817zvd() > 0) {
            if (this.f1765VocHEe) {
                m1870Hk(c0146Ucbh, c0148VocHEe, true);
                m1904oJ(c0146Ucbh, c0148VocHEe, false);
            } else {
                m1904oJ(c0146Ucbh, c0148VocHEe, true);
                m1870Hk(c0146Ucbh, c0148VocHEe, false);
            }
        }
        if (!z || c0148VocHEe.m1626KLFTb() || this.f1761OjSQV == 0 || m1817zvd() <= 0 || (!this.f1772rWxwaT && m1909tPvjn() == null)) {
            z2 = false;
        } else {
            m1805uxlM(this.f1774vadzgd);
            if (!m1889Vptz()) {
            }
        }
        if (c0148VocHEe.m1626KLFTb()) {
            this.f1766cMLeY.m1919wA();
        }
        this.f1760Ne = c0166AZxh.f1783wA;
        this.f1755CqaNbM = m1879Otxclu();
        if (z2) {
            this.f1766cMLeY.m1919wA();
            m1881RWb(c0146Ucbh, c0148VocHEe, false);
        }
    }

    /* renamed from: Rsp */
    public View m1882Rsp(boolean z) {
        int iMo2051MiMN = this.f1768eyqo.mo2051MiMN();
        int iMo2059qdMbNW = this.f1768eyqo.mo2059qdMbNW();
        int iM1817zvd = m1817zvd();
        View view = null;
        for (int i = 0; i < iM1817zvd; i++) {
            View viewM1743KLMXS = m1743KLMXS(i);
            int iMo2061xJ = this.f1768eyqo.mo2061xJ(viewM1743KLMXS);
            if (this.f1768eyqo.mo2055ZfxDd(viewM1743KLMXS) > iMo2051MiMN && iMo2061xJ < iMo2059qdMbNW) {
                if (iMo2061xJ >= iMo2051MiMN || !z) {
                    return viewM1743KLMXS;
                }
                if (view == null) {
                    view = viewM1743KLMXS;
                }
            }
        }
        return view;
    }

    /* renamed from: Sx */
    public final int m1883Sx(int i) {
        int iM1937qGY = this.f1767diqgf[0].m1937qGY(i);
        for (int i2 = 1; i2 < this.f1762Pq; i2++) {
            int iM1937qGY2 = this.f1767diqgf[i2].m1937qGY(i);
            if (iM1937qGY2 < iM1937qGY) {
                iM1937qGY = iM1937qGY2;
            }
        }
        return iM1937qGY;
    }

    /* renamed from: TFbkuO */
    public void m1884TFbkuO() {
        this.f1771mByQ.m1946AZxh();
        m1788mzUGzO();
    }

    /* renamed from: TvfBiy */
    public final int m1885TvfBiy(int i) {
        int iM1817zvd = m1817zvd();
        for (int i2 = 0; i2 < iM1817zvd; i2++) {
            int iM1799tQ = m1799tQ(m1743KLMXS(i2));
            if (iM1799tQ >= 0 && iM1799tQ < i) {
                return iM1799tQ;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Tw */
    public void mo1331Tw(int i) {
        C0168KLFTb c0168KLFTb = this.f1776xrEuO;
        if (c0168KLFTb != null && c0168KLFTb.f1798mjFkc != i) {
            c0168KLFTb.m1943mjFkc();
        }
        this.f1770lB = i;
        this.f1775wJVbdd = Integer.MIN_VALUE;
        m1788mzUGzO();
    }

    /* renamed from: UDcil */
    public final int m1886UDcil(int i) {
        int iM1929VA = this.f1767diqgf[0].m1929VA(i);
        for (int i2 = 1; i2 < this.f1762Pq; i2++) {
            int iM1929VA2 = this.f1767diqgf[i2].m1929VA(i);
            if (iM1929VA2 > iM1929VA) {
                iM1929VA = iM1929VA2;
            }
        }
        return iM1929VA;
    }

    /* renamed from: UOnCkw */
    public final int m1887UOnCkw(int i) {
        int iM1929VA = this.f1767diqgf[0].m1929VA(i);
        for (int i2 = 1; i2 < this.f1762Pq; i2++) {
            int iM1929VA2 = this.f1767diqgf[i2].m1929VA(i);
            if (iM1929VA2 < iM1929VA) {
                iM1929VA = iM1929VA2;
            }
        }
        return iM1929VA;
    }

    /* renamed from: UPU */
    public final void m1888UPU(RecyclerView.C0146Ucbh c0146Ucbh, int i) {
        while (m1817zvd() > 0) {
            View viewM1743KLMXS = m1743KLMXS(0);
            if (this.f1768eyqo.mo2055ZfxDd(viewM1743KLMXS) > i || this.f1768eyqo.mo2058qGY(viewM1743KLMXS) > i) {
                return;
            }
            C0171wA c0171wA = (C0171wA) viewM1743KLMXS.getLayoutParams();
            if (c0171wA.f1810JHa) {
                for (int i2 = 0; i2 < this.f1762Pq; i2++) {
                    if (this.f1767diqgf[i2].f1789mjFkc.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.f1762Pq; i3++) {
                    this.f1767diqgf[i3].m1932diqgf();
                }
            } else if (c0171wA.f1811KLFTb.f1789mjFkc.size() == 1) {
                return;
            } else {
                c0171wA.f1811KLFTb.m1932diqgf();
            }
            m1752RWyiuY(viewM1743KLMXS, c0146Ucbh);
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Ucbh */
    public int mo1243Ucbh(RecyclerView.C0148VocHEe c0148VocHEe) {
        return m1860HX(c0148VocHEe);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: VA */
    public boolean mo1335VA() {
        return this.f1769huTpC == 0;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Vgyli */
    public void mo1760Vgyli(RecyclerView.AbstractC0156lgHUyS abstractC0156lgHUyS, RecyclerView.AbstractC0156lgHUyS abstractC0156lgHUyS2) {
        this.f1771mByQ.m1946AZxh();
        for (int i = 0; i < this.f1762Pq; i++) {
            this.f1767diqgf[i].m1925KLFTb();
        }
    }

    /* renamed from: Vptz */
    public boolean m1889Vptz() {
        int iM1893bWIyu;
        int iM1890XyP;
        if (m1817zvd() == 0 || this.f1761OjSQV == 0 || !m1782gtIJp()) {
            return false;
        }
        if (this.f1765VocHEe) {
            iM1893bWIyu = m1890XyP();
            iM1890XyP = m1893bWIyu();
        } else {
            iM1893bWIyu = m1893bWIyu();
            iM1890XyP = m1890XyP();
        }
        if (iM1893bWIyu == 0 && m1909tPvjn() != null) {
            this.f1771mByQ.m1946AZxh();
            m1759VfB();
            m1788mzUGzO();
            return true;
        }
        if (!this.f1772rWxwaT) {
            return false;
        }
        int i = this.f1765VocHEe ? -1 : 1;
        int i2 = iM1890XyP + 1;
        C0169ZfxDd.mjFkc mjfkcM1950KLFTb = this.f1771mByQ.m1950KLFTb(iM1893bWIyu, i2, i, true);
        if (mjfkcM1950KLFTb == null) {
            this.f1772rWxwaT = false;
            this.f1771mByQ.m1954ZfxDd(i2);
            return false;
        }
        C0169ZfxDd.mjFkc mjfkcM1950KLFTb2 = this.f1771mByQ.m1950KLFTb(iM1893bWIyu, mjfkcM1950KLFTb.f1807mjFkc, i * (-1), true);
        if (mjfkcM1950KLFTb2 == null) {
            this.f1771mByQ.m1954ZfxDd(mjfkcM1950KLFTb.f1807mjFkc);
        } else {
            this.f1771mByQ.m1954ZfxDd(mjfkcM1950KLFTb2.f1807mjFkc + 1);
        }
        m1759VfB();
        m1788mzUGzO();
        return true;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: XD */
    public void mo1337XD(RecyclerView recyclerView, RecyclerView.C0146Ucbh c0146Ucbh) {
        super.mo1337XD(recyclerView, c0146Ucbh);
        m1805uxlM(this.f1774vadzgd);
        for (int i = 0; i < this.f1762Pq; i++) {
            this.f1767diqgf[i].m1925KLFTb();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: XgAT */
    public void mo1244XgAT(RecyclerView recyclerView, int i, int i2) {
        m1911wGscSa(i, i2, 2);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Xxz */
    public void mo1245Xxz(RecyclerView.C0148VocHEe c0148VocHEe) {
        super.mo1245Xxz(c0148VocHEe);
        this.f1770lB = -1;
        this.f1775wJVbdd = Integer.MIN_VALUE;
        this.f1776xrEuO = null;
        this.f1766cMLeY.m1919wA();
    }

    /* renamed from: XyP */
    public int m1890XyP() {
        int iM1817zvd = m1817zvd();
        if (iM1817zvd == 0) {
            return 0;
        }
        return m1799tQ(m1743KLMXS(iM1817zvd - 1));
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: YoKzxo */
    public boolean mo1246YoKzxo(RecyclerView.C0153fehf c0153fehf) {
        return c0153fehf instanceof C0171wA;
    }

    /* renamed from: ZGL */
    public void m1891ZGL(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        mo1351lgHUyS(null);
        if (i == this.f1769huTpC) {
            return;
        }
        this.f1769huTpC = i;
        AbstractC0178qdMbNW abstractC0178qdMbNW = this.f1768eyqo;
        this.f1768eyqo = this.f1763Ucbh;
        this.f1763Ucbh = abstractC0178qdMbNW;
        m1788mzUGzO();
    }

    /* renamed from: aDq */
    public final void m1892aDq() {
        this.f1768eyqo = AbstractC0178qdMbNW.m2043AZxh(this, this.f1769huTpC);
        this.f1763Ucbh = AbstractC0178qdMbNW.m2043AZxh(this, 1 - this.f1769huTpC);
    }

    /* renamed from: bWIyu */
    public int m1893bWIyu() {
        if (m1817zvd() == 0) {
            return 0;
        }
        return m1799tQ(m1743KLMXS(0));
    }

    /* renamed from: cdjp */
    public final void m1894cdjp(View view) {
        for (int i = this.f1762Pq - 1; i >= 0; i--) {
            this.f1767diqgf[i].m1933eyqo(view);
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: dGDT */
    public void mo1248dGDT(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        m1881RWb(c0146Ucbh, c0148VocHEe, true);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: diqgf */
    public int mo1249diqgf(RecyclerView.C0148VocHEe c0148VocHEe) {
        return m1859EoC(c0148VocHEe);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: dkKKW */
    public Parcelable mo1343dkKKW() {
        int iM1937qGY;
        int iMo2051MiMN;
        int[] iArr;
        if (this.f1776xrEuO != null) {
            return new C0168KLFTb(this.f1776xrEuO);
        }
        C0168KLFTb c0168KLFTb = new C0168KLFTb();
        c0168KLFTb.f1797lgHUyS = this.f1773vI;
        c0168KLFTb.f1799qdMbNW = this.f1760Ne;
        c0168KLFTb.f1793Dt = this.f1755CqaNbM;
        C0169ZfxDd c0169ZfxDd = this.f1771mByQ;
        if (c0169ZfxDd == null || (iArr = c0169ZfxDd.f1803mjFkc) == null) {
            c0168KLFTb.f1795KLFTb = 0;
        } else {
            c0168KLFTb.f1794JHa = iArr;
            c0168KLFTb.f1795KLFTb = iArr.length;
            c0168KLFTb.f1801xJ = c0169ZfxDd.f1802AZxh;
        }
        if (m1817zvd() > 0) {
            c0168KLFTb.f1798mjFkc = this.f1760Ne ? m1890XyP() : m1893bWIyu();
            c0168KLFTb.f1792AZxh = m1914xfXeiC();
            int i = this.f1762Pq;
            c0168KLFTb.f1800wA = i;
            c0168KLFTb.f1796ZfxDd = new int[i];
            for (int i2 = 0; i2 < this.f1762Pq; i2++) {
                if (this.f1760Ne) {
                    iM1937qGY = this.f1767diqgf[i2].m1929VA(Integer.MIN_VALUE);
                    if (iM1937qGY != Integer.MIN_VALUE) {
                        iMo2051MiMN = this.f1768eyqo.mo2059qdMbNW();
                        iM1937qGY -= iMo2051MiMN;
                    }
                } else {
                    iM1937qGY = this.f1767diqgf[i2].m1937qGY(Integer.MIN_VALUE);
                    if (iM1937qGY != Integer.MIN_VALUE) {
                        iMo2051MiMN = this.f1768eyqo.mo2051MiMN();
                        iM1937qGY -= iMo2051MiMN;
                    }
                }
                c0168KLFTb.f1796ZfxDd[i2] = iM1937qGY;
            }
        } else {
            c0168KLFTb.f1798mjFkc = -1;
            c0168KLFTb.f1792AZxh = -1;
            c0168KLFTb.f1800wA = 0;
        }
        return c0168KLFTb;
    }

    /* renamed from: eEOGOh */
    public void m1895eEOGOh(int i) {
        mo1351lgHUyS(null);
        if (i != this.f1762Pq) {
            m1884TFbkuO();
            this.f1762Pq = i;
            this.f1754BAnRFn = new BitSet(this.f1762Pq);
            this.f1767diqgf = new C0167JHa[this.f1762Pq];
            for (int i2 = 0; i2 < this.f1762Pq; i2++) {
                this.f1767diqgf[i2] = new C0167JHa(i2);
            }
            m1788mzUGzO();
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: eQ */
    public void mo1252eQ(RecyclerView recyclerView, int i, int i2) {
        m1911wGscSa(i, i2, 1);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: eyqo */
    public int mo1344eyqo(RecyclerView.C0148VocHEe c0148VocHEe) {
        return m1858CcoH(c0148VocHEe);
    }

    /* renamed from: gJsSk */
    public final boolean m1896gJsSk(RecyclerView.C0148VocHEe c0148VocHEe, C0166AZxh c0166AZxh) {
        c0166AZxh.f1782mjFkc = this.f1760Ne ? m1878Mpf(c0148VocHEe.m1624AZxh()) : m1885TvfBiy(c0148VocHEe.m1624AZxh());
        c0166AZxh.f1778AZxh = Integer.MIN_VALUE;
        return true;
    }

    /* renamed from: gjvQ */
    public final void m1897gjvQ(int i, RecyclerView.C0148VocHEe c0148VocHEe) {
        int iMo2054YoKzxo;
        int iMo2054YoKzxo2;
        int iM1629wA;
        C0128JHa c0128JHa = this.f1757HGpJ;
        boolean z = false;
        c0128JHa.f1469AZxh = 0;
        c0128JHa.f1476wA = i;
        if (!m1778fFz() || (iM1629wA = c0148VocHEe.m1629wA()) == -1) {
            iMo2054YoKzxo = 0;
            iMo2054YoKzxo2 = 0;
        } else {
            if (this.f1765VocHEe == (iM1629wA < i)) {
                iMo2054YoKzxo = this.f1768eyqo.mo2054YoKzxo();
                iMo2054YoKzxo2 = 0;
            } else {
                iMo2054YoKzxo2 = this.f1768eyqo.mo2054YoKzxo();
                iMo2054YoKzxo = 0;
            }
        }
        if (m1761Vnb()) {
            this.f1757HGpJ.f1470JHa = this.f1768eyqo.mo2051MiMN() - iMo2054YoKzxo2;
            this.f1757HGpJ.f1477xJ = this.f1768eyqo.mo2059qdMbNW() + iMo2054YoKzxo;
        } else {
            this.f1757HGpJ.f1477xJ = this.f1768eyqo.mo2057lgHUyS() + iMo2054YoKzxo;
            this.f1757HGpJ.f1470JHa = -iMo2054YoKzxo2;
        }
        C0128JHa c0128JHa2 = this.f1757HGpJ;
        c0128JHa2.f1473lgHUyS = false;
        c0128JHa2.f1474mjFkc = true;
        if (this.f1768eyqo.mo2047ETF() == 0 && this.f1768eyqo.mo2057lgHUyS() == 0) {
            z = true;
        }
        c0128JHa2.f1475qdMbNW = z;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: gtr */
    public View mo1255gtr(View view, int i, RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        View viewM1786lB;
        View viewM1926MiMN;
        if (m1817zvd() == 0 || (viewM1786lB = m1786lB(view)) == null) {
            return null;
        }
        m1862kOlLW();
        int iM1863xbjHT = m1863xbjHT(i);
        if (iM1863xbjHT == Integer.MIN_VALUE) {
            return null;
        }
        C0171wA c0171wA = (C0171wA) viewM1786lB.getLayoutParams();
        boolean z = c0171wA.f1810JHa;
        C0167JHa c0167JHa = c0171wA.f1811KLFTb;
        int iM1890XyP = iM1863xbjHT == 1 ? m1890XyP() : m1893bWIyu();
        m1897gjvQ(iM1890XyP, c0148VocHEe);
        m1868Es(iM1863xbjHT);
        C0128JHa c0128JHa = this.f1757HGpJ;
        c0128JHa.f1476wA = c0128JHa.f1472ZfxDd + iM1890XyP;
        c0128JHa.f1469AZxh = (int) (this.f1768eyqo.mo2054YoKzxo() * 0.33333334f);
        C0128JHa c0128JHa2 = this.f1757HGpJ;
        c0128JHa2.f1473lgHUyS = true;
        c0128JHa2.f1474mjFkc = false;
        m1910vZ(c0146Ucbh, c0128JHa2, c0148VocHEe);
        this.f1760Ne = this.f1765VocHEe;
        if (!z && (viewM1926MiMN = c0167JHa.m1926MiMN(iM1890XyP, iM1863xbjHT)) != null && viewM1926MiMN != viewM1786lB) {
            return viewM1926MiMN;
        }
        if (m1899jTNPnW(iM1863xbjHT)) {
            for (int i2 = this.f1762Pq - 1; i2 >= 0; i2--) {
                View viewM1926MiMN2 = this.f1767diqgf[i2].m1926MiMN(iM1890XyP, iM1863xbjHT);
                if (viewM1926MiMN2 != null && viewM1926MiMN2 != viewM1786lB) {
                    return viewM1926MiMN2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.f1762Pq; i3++) {
                View viewM1926MiMN3 = this.f1767diqgf[i3].m1926MiMN(iM1890XyP, iM1863xbjHT);
                if (viewM1926MiMN3 != null && viewM1926MiMN3 != viewM1786lB) {
                    return viewM1926MiMN3;
                }
            }
        }
        boolean z2 = (this.f1773vI ^ true) == (iM1863xbjHT == -1);
        if (!z) {
            View viewMo1362wJVbdd = mo1362wJVbdd(z2 ? c0167JHa.m1924JHa() : c0167JHa.m1941xJ());
            if (viewMo1362wJVbdd != null && viewMo1362wJVbdd != viewM1786lB) {
                return viewMo1362wJVbdd;
            }
        }
        if (m1899jTNPnW(iM1863xbjHT)) {
            for (int i4 = this.f1762Pq - 1; i4 >= 0; i4--) {
                if (i4 != c0167JHa.f1787KLFTb) {
                    View viewMo1362wJVbdd2 = mo1362wJVbdd(z2 ? this.f1767diqgf[i4].m1924JHa() : this.f1767diqgf[i4].m1941xJ());
                    if (viewMo1362wJVbdd2 != null && viewMo1362wJVbdd2 != viewM1786lB) {
                        return viewMo1362wJVbdd2;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.f1762Pq; i5++) {
                View viewMo1362wJVbdd3 = mo1362wJVbdd(z2 ? this.f1767diqgf[i5].m1924JHa() : this.f1767diqgf[i5].m1941xJ());
                if (viewMo1362wJVbdd3 != null && viewMo1362wJVbdd3 != viewM1786lB) {
                    return viewMo1362wJVbdd3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: huTpC */
    public int mo1256huTpC(RecyclerView.C0148VocHEe c0148VocHEe) {
        return m1859EoC(c0148VocHEe);
    }

    /* renamed from: ih */
    public final void m1898ih(C0167JHa c0167JHa, int i, int i2) {
        int iM1921Dt = c0167JHa.m1921Dt();
        if (i == -1) {
            if (c0167JHa.m1939rkYL() + iM1921Dt <= i2) {
                this.f1754BAnRFn.set(c0167JHa.f1787KLFTb, false);
            }
        } else if (c0167JHa.m1922ETF() - iM1921Dt >= i2) {
            this.f1754BAnRFn.set(c0167JHa.f1787KLFTb, false);
        }
    }

    /* renamed from: jTNPnW */
    public final boolean m1899jTNPnW(int i) {
        if (this.f1769huTpC == 0) {
            return (i == -1) != this.f1765VocHEe;
        }
        return ((i == -1) == this.f1765VocHEe) == m1879Otxclu();
    }

    /* renamed from: jY */
    public final int m1900jY(int i) {
        int iM1937qGY = this.f1767diqgf[0].m1937qGY(i);
        for (int i2 = 1; i2 < this.f1762Pq; i2++) {
            int iM1937qGY2 = this.f1767diqgf[i2].m1937qGY(i);
            if (iM1937qGY2 > iM1937qGY) {
                iM1937qGY = iM1937qGY2;
            }
        }
        return iM1937qGY;
    }

    /* renamed from: jpz */
    public void m1901jpz(boolean z) {
        mo1351lgHUyS(null);
        C0168KLFTb c0168KLFTb = this.f1776xrEuO;
        if (c0168KLFTb != null && c0168KLFTb.f1797lgHUyS != z) {
            c0168KLFTb.f1797lgHUyS = z;
        }
        this.f1773vI = z;
        m1788mzUGzO();
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: jtz */
    public void mo1260jtz(RecyclerView recyclerView, int i, int i2, int i3) {
        m1911wGscSa(i, i2, 8);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: kism */
    public boolean mo1350kism() {
        return this.f1761OjSQV != 0;
    }

    /* renamed from: kw */
    public void m1902kw(int i) {
        this.f1756Gd = i / this.f1762Pq;
        this.f1758KLMXS = View.MeasureSpec.makeMeasureSpec(i, this.f1763Ucbh.mo2047ETF());
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: lgHUyS */
    public void mo1351lgHUyS(String str) {
        if (this.f1776xrEuO == null) {
            super.mo1351lgHUyS(str);
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: mByQ */
    public RecyclerView.C0153fehf mo1263mByQ() {
        return this.f1769huTpC == 0 ? new C0171wA(-2, -1) : new C0171wA(-1, -2);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: mPWV */
    public void mo1352mPWV(Parcelable parcelable) {
        if (parcelable instanceof C0168KLFTb) {
            C0168KLFTb c0168KLFTb = (C0168KLFTb) parcelable;
            this.f1776xrEuO = c0168KLFTb;
            if (this.f1770lB != -1) {
                c0168KLFTb.m1943mjFkc();
                this.f1776xrEuO.m1942AZxh();
            }
            m1788mzUGzO();
        }
    }

    /* renamed from: np */
    public boolean m1903np() {
        int iM1929VA = this.f1767diqgf[0].m1929VA(Integer.MIN_VALUE);
        for (int i = 1; i < this.f1762Pq; i++) {
            if (this.f1767diqgf[i].m1929VA(Integer.MIN_VALUE) != iM1929VA) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: oJ */
    public final void m1904oJ(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, boolean z) {
        int iMo2051MiMN;
        int iM1883Sx = m1883Sx(Integer.MAX_VALUE);
        if (iM1883Sx != Integer.MAX_VALUE && (iMo2051MiMN = iM1883Sx - this.f1768eyqo.mo2051MiMN()) > 0) {
            int iM1875LlB = iMo2051MiMN - m1875LlB(iMo2051MiMN, c0146Ucbh, c0148VocHEe);
            if (!z || iM1875LlB <= 0) {
                return;
            }
            this.f1768eyqo.mo2048IEE(-iM1875LlB);
        }
    }

    /* renamed from: pJeaSR */
    public final void m1905pJeaSR(C0166AZxh c0166AZxh) {
        C0168KLFTb c0168KLFTb = this.f1776xrEuO;
        int i = c0168KLFTb.f1800wA;
        if (i > 0) {
            if (i == this.f1762Pq) {
                for (int i2 = 0; i2 < this.f1762Pq; i2++) {
                    this.f1767diqgf[i2].m1925KLFTb();
                    C0168KLFTb c0168KLFTb2 = this.f1776xrEuO;
                    int iMo2059qdMbNW = c0168KLFTb2.f1796ZfxDd[i2];
                    if (iMo2059qdMbNW != Integer.MIN_VALUE) {
                        iMo2059qdMbNW += c0168KLFTb2.f1799qdMbNW ? this.f1768eyqo.mo2059qdMbNW() : this.f1768eyqo.mo2051MiMN();
                    }
                    this.f1767diqgf[i2].m1928Ucbh(iMo2059qdMbNW);
                }
            } else {
                c0168KLFTb.m1942AZxh();
                C0168KLFTb c0168KLFTb3 = this.f1776xrEuO;
                c0168KLFTb3.f1798mjFkc = c0168KLFTb3.f1792AZxh;
            }
        }
        C0168KLFTb c0168KLFTb4 = this.f1776xrEuO;
        this.f1755CqaNbM = c0168KLFTb4.f1793Dt;
        m1901jpz(c0168KLFTb4.f1797lgHUyS);
        m1862kOlLW();
        C0168KLFTb c0168KLFTb5 = this.f1776xrEuO;
        int i3 = c0168KLFTb5.f1798mjFkc;
        if (i3 != -1) {
            this.f1770lB = i3;
            c0166AZxh.f1783wA = c0168KLFTb5.f1799qdMbNW;
        } else {
            c0166AZxh.f1783wA = this.f1765VocHEe;
        }
        if (c0168KLFTb5.f1795KLFTb > 1) {
            C0169ZfxDd c0169ZfxDd = this.f1771mByQ;
            c0169ZfxDd.f1803mjFkc = c0168KLFTb5.f1794JHa;
            c0169ZfxDd.f1802AZxh = c0168KLFTb5.f1801xJ;
        }
    }

    /* renamed from: peCqC */
    public final C0167JHa m1906peCqC(C0128JHa c0128JHa) {
        int i;
        int i2;
        int i3;
        if (m1899jTNPnW(c0128JHa.f1471KLFTb)) {
            i2 = this.f1762Pq - 1;
            i = -1;
            i3 = -1;
        } else {
            i = this.f1762Pq;
            i2 = 0;
            i3 = 1;
        }
        C0167JHa c0167JHa = null;
        if (c0128JHa.f1471KLFTb == 1) {
            int iMo2051MiMN = this.f1768eyqo.mo2051MiMN();
            int i4 = Integer.MAX_VALUE;
            while (i2 != i) {
                C0167JHa c0167JHa2 = this.f1767diqgf[i2];
                int iM1929VA = c0167JHa2.m1929VA(iMo2051MiMN);
                if (iM1929VA < i4) {
                    c0167JHa = c0167JHa2;
                    i4 = iM1929VA;
                }
                i2 += i3;
            }
            return c0167JHa;
        }
        int iMo2059qdMbNW = this.f1768eyqo.mo2059qdMbNW();
        int i5 = Integer.MIN_VALUE;
        while (i2 != i) {
            C0167JHa c0167JHa3 = this.f1767diqgf[i2];
            int iM1937qGY = c0167JHa3.m1937qGY(iMo2059qdMbNW);
            if (iM1937qGY > i5) {
                c0167JHa = c0167JHa3;
                i5 = iM1937qGY;
            }
            i2 += i3;
        }
        return c0167JHa;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: qGY */
    public void mo1356qGY(int i, int i2, RecyclerView.C0148VocHEe c0148VocHEe, RecyclerView.AbstractC0159qGY.wA wAVar) {
        int iM1929VA;
        int iM1937qGY;
        if (this.f1769huTpC != 0) {
            i = i2;
        }
        if (m1817zvd() == 0 || i == 0) {
            return;
        }
        m1867EeoThB(i, c0148VocHEe);
        int[] iArr = this.f1759NPj;
        if (iArr == null || iArr.length < this.f1762Pq) {
            this.f1759NPj = new int[this.f1762Pq];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f1762Pq; i4++) {
            C0128JHa c0128JHa = this.f1757HGpJ;
            if (c0128JHa.f1472ZfxDd == -1) {
                iM1929VA = c0128JHa.f1470JHa;
                iM1937qGY = this.f1767diqgf[i4].m1937qGY(iM1929VA);
            } else {
                iM1929VA = this.f1767diqgf[i4].m1929VA(c0128JHa.f1477xJ);
                iM1937qGY = this.f1757HGpJ.f1477xJ;
            }
            int i5 = iM1929VA - iM1937qGY;
            if (i5 >= 0) {
                this.f1759NPj[i3] = i5;
                i3++;
            }
        }
        Arrays.sort(this.f1759NPj, 0, i3);
        for (int i6 = 0; i6 < i3 && this.f1757HGpJ.m1286mjFkc(c0148VocHEe); i6++) {
            wAVar.mo1300mjFkc(this.f1757HGpJ.f1476wA, this.f1759NPj[i6]);
            C0128JHa c0128JHa2 = this.f1757HGpJ;
            c0128JHa2.f1476wA += c0128JHa2.f1472ZfxDd;
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: qGgY */
    public void mo1357qGgY(RecyclerView recyclerView, RecyclerView.C0148VocHEe c0148VocHEe, int i) {
        C0181xJ c0181xJ = new C0181xJ(recyclerView.getContext());
        c0181xJ.m1843qGY(i);
        m1807vUsV(c0181xJ);
    }

    /* renamed from: qrxT */
    public final boolean m1907qrxT(C0167JHa c0167JHa) {
        if (this.f1765VocHEe) {
            if (c0167JHa.m1922ETF() < this.f1768eyqo.mo2059qdMbNW()) {
                ArrayList arrayList = c0167JHa.f1789mjFkc;
                return !c0167JHa.m1930YoKzxo((View) arrayList.get(arrayList.size() - 1)).f1810JHa;
            }
        } else if (c0167JHa.m1939rkYL() > this.f1768eyqo.mo2051MiMN()) {
            return !c0167JHa.m1930YoKzxo((View) c0167JHa.f1789mjFkc.get(0)).f1810JHa;
        }
        return false;
    }

    /* renamed from: qtZIjO */
    public boolean m1908qtZIjO(RecyclerView.C0148VocHEe c0148VocHEe, C0166AZxh c0166AZxh) {
        int i;
        if (!c0148VocHEe.m1626KLFTb() && (i = this.f1770lB) != -1) {
            if (i >= 0 && i < c0148VocHEe.m1624AZxh()) {
                C0168KLFTb c0168KLFTb = this.f1776xrEuO;
                if (c0168KLFTb == null || c0168KLFTb.f1798mjFkc == -1 || c0168KLFTb.f1800wA < 1) {
                    View viewMo1362wJVbdd = mo1362wJVbdd(this.f1770lB);
                    if (viewMo1362wJVbdd != null) {
                        c0166AZxh.f1782mjFkc = this.f1765VocHEe ? m1890XyP() : m1893bWIyu();
                        if (this.f1775wJVbdd != Integer.MIN_VALUE) {
                            if (c0166AZxh.f1783wA) {
                                c0166AZxh.f1778AZxh = (this.f1768eyqo.mo2059qdMbNW() - this.f1775wJVbdd) - this.f1768eyqo.mo2055ZfxDd(viewMo1362wJVbdd);
                            } else {
                                c0166AZxh.f1778AZxh = (this.f1768eyqo.mo2051MiMN() + this.f1775wJVbdd) - this.f1768eyqo.mo2061xJ(viewMo1362wJVbdd);
                            }
                            return true;
                        }
                        if (this.f1768eyqo.mo2050KLFTb(viewMo1362wJVbdd) > this.f1768eyqo.mo2054YoKzxo()) {
                            c0166AZxh.f1778AZxh = c0166AZxh.f1783wA ? this.f1768eyqo.mo2059qdMbNW() : this.f1768eyqo.mo2051MiMN();
                            return true;
                        }
                        int iMo2061xJ = this.f1768eyqo.mo2061xJ(viewMo1362wJVbdd) - this.f1768eyqo.mo2051MiMN();
                        if (iMo2061xJ < 0) {
                            c0166AZxh.f1778AZxh = -iMo2061xJ;
                            return true;
                        }
                        int iMo2059qdMbNW = this.f1768eyqo.mo2059qdMbNW() - this.f1768eyqo.mo2055ZfxDd(viewMo1362wJVbdd);
                        if (iMo2059qdMbNW < 0) {
                            c0166AZxh.f1778AZxh = iMo2059qdMbNW;
                            return true;
                        }
                        c0166AZxh.f1778AZxh = Integer.MIN_VALUE;
                    } else {
                        int i2 = this.f1770lB;
                        c0166AZxh.f1782mjFkc = i2;
                        int i3 = this.f1775wJVbdd;
                        if (i3 == Integer.MIN_VALUE) {
                            c0166AZxh.f1783wA = m1873KSf(i2) == 1;
                            c0166AZxh.m1918mjFkc();
                        } else {
                            c0166AZxh.m1916AZxh(i3);
                        }
                        c0166AZxh.f1781ZfxDd = true;
                    }
                } else {
                    c0166AZxh.f1778AZxh = Integer.MIN_VALUE;
                    c0166AZxh.f1782mjFkc = this.f1770lB;
                }
                return true;
            }
            this.f1770lB = -1;
            this.f1775wJVbdd = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: tAfC */
    public void mo1268tAfC(RecyclerView recyclerView, int i, int i2, Object obj) {
        m1911wGscSa(i, i2, 4);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: tISON */
    public void mo1798tISON(int i) {
        super.mo1798tISON(i);
        for (int i2 = 0; i2 < this.f1762Pq; i2++) {
            this.f1767diqgf[i2].m1923IEE(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* renamed from: tPvjn */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View m1909tPvjn() {
        int i;
        int iM1817zvd = m1817zvd();
        int i2 = iM1817zvd - 1;
        BitSet bitSet = new BitSet(this.f1762Pq);
        bitSet.set(0, this.f1762Pq, true);
        char c = (this.f1769huTpC == 1 && m1879Otxclu()) ? (char) 1 : (char) 65535;
        if (this.f1765VocHEe) {
            iM1817zvd = -1;
        } else {
            i2 = 0;
        }
        int i3 = i2 < iM1817zvd ? 1 : -1;
        while (i2 != iM1817zvd) {
            View viewM1743KLMXS = m1743KLMXS(i2);
            C0171wA c0171wA = (C0171wA) viewM1743KLMXS.getLayoutParams();
            if (bitSet.get(c0171wA.f1811KLFTb.f1787KLFTb)) {
                if (m1907qrxT(c0171wA.f1811KLFTb)) {
                    return viewM1743KLMXS;
                }
                bitSet.clear(c0171wA.f1811KLFTb.f1787KLFTb);
            }
            if (!c0171wA.f1810JHa && (i = i2 + i3) != iM1817zvd) {
                View viewM1743KLMXS2 = m1743KLMXS(i);
                if (this.f1765VocHEe) {
                    int iMo2055ZfxDd = this.f1768eyqo.mo2055ZfxDd(viewM1743KLMXS);
                    int iMo2055ZfxDd2 = this.f1768eyqo.mo2055ZfxDd(viewM1743KLMXS2);
                    if (iMo2055ZfxDd < iMo2055ZfxDd2) {
                        return viewM1743KLMXS;
                    }
                    if (iMo2055ZfxDd == iMo2055ZfxDd2) {
                        if ((c0171wA.f1811KLFTb.f1787KLFTb - ((C0171wA) viewM1743KLMXS2.getLayoutParams()).f1811KLFTb.f1787KLFTb < 0) != (c < 0)) {
                            return viewM1743KLMXS;
                        }
                    } else {
                        continue;
                    }
                } else {
                    int iMo2061xJ = this.f1768eyqo.mo2061xJ(viewM1743KLMXS);
                    int iMo2061xJ2 = this.f1768eyqo.mo2061xJ(viewM1743KLMXS2);
                    if (iMo2061xJ > iMo2061xJ2) {
                        return viewM1743KLMXS;
                    }
                    if (iMo2061xJ != iMo2061xJ2) {
                        continue;
                    }
                }
            }
            i2 += i3;
        }
        return null;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: uH */
    public void mo1802uH(int i) {
        super.mo1802uH(i);
        for (int i2 = 0; i2 < this.f1762Pq; i2++) {
            this.f1767diqgf[i2].m1923IEE(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* renamed from: vZ */
    public final int m1910vZ(RecyclerView.C0146Ucbh c0146Ucbh, C0128JHa c0128JHa, RecyclerView.C0148VocHEe c0148VocHEe) {
        C0167JHa c0167JHaM1906peCqC;
        int iMo2050KLFTb;
        int i;
        int iMo2050KLFTb2;
        int iMo2050KLFTb3;
        boolean z;
        ?? r9 = 0;
        this.f1754BAnRFn.set(0, this.f1762Pq, true);
        int i2 = this.f1757HGpJ.f1475qdMbNW ? c0128JHa.f1471KLFTb == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : c0128JHa.f1471KLFTb == 1 ? c0128JHa.f1477xJ + c0128JHa.f1469AZxh : c0128JHa.f1470JHa - c0128JHa.f1469AZxh;
        m1865BABY(c0128JHa.f1471KLFTb, i2);
        int iMo2059qdMbNW = this.f1765VocHEe ? this.f1768eyqo.mo2059qdMbNW() : this.f1768eyqo.mo2051MiMN();
        boolean z2 = false;
        while (c0128JHa.m1286mjFkc(c0148VocHEe) && (this.f1757HGpJ.f1475qdMbNW || !this.f1754BAnRFn.isEmpty())) {
            View viewM1285AZxh = c0128JHa.m1285AZxh(c0146Ucbh);
            C0171wA c0171wA = (C0171wA) viewM1285AZxh.getLayoutParams();
            int iM1653mjFkc = c0171wA.m1653mjFkc();
            int iM1960xJ = this.f1771mByQ.m1960xJ(iM1653mjFkc);
            boolean z3 = iM1960xJ == -1 ? true : r9;
            if (z3) {
                c0167JHaM1906peCqC = c0171wA.f1810JHa ? this.f1767diqgf[r9] : m1906peCqC(c0128JHa);
                this.f1771mByQ.m1953YoKzxo(iM1653mjFkc, c0167JHaM1906peCqC);
            } else {
                c0167JHaM1906peCqC = this.f1767diqgf[iM1960xJ];
            }
            C0167JHa c0167JHa = c0167JHaM1906peCqC;
            c0171wA.f1811KLFTb = c0167JHa;
            if (c0128JHa.f1471KLFTb == 1) {
                m1742KLFTb(viewM1285AZxh);
            } else {
                m1736JHa(viewM1285AZxh, r9);
            }
            m1864ArO(viewM1285AZxh, c0171wA, r9);
            if (c0128JHa.f1471KLFTb == 1) {
                int iM1886UDcil = c0171wA.f1810JHa ? m1886UDcil(iMo2059qdMbNW) : c0167JHa.m1929VA(iMo2059qdMbNW);
                int iMo2050KLFTb4 = this.f1768eyqo.mo2050KLFTb(viewM1285AZxh) + iM1886UDcil;
                if (z3 && c0171wA.f1810JHa) {
                    C0169ZfxDd.mjFkc mjfkcM1915zPp = m1915zPp(iM1886UDcil);
                    mjfkcM1915zPp.f1805AZxh = -1;
                    mjfkcM1915zPp.f1807mjFkc = iM1653mjFkc;
                    this.f1771mByQ.m1956mjFkc(mjfkcM1915zPp);
                }
                i = iMo2050KLFTb4;
                iMo2050KLFTb = iM1886UDcil;
            } else {
                int iM1883Sx = c0171wA.f1810JHa ? m1883Sx(iMo2059qdMbNW) : c0167JHa.m1937qGY(iMo2059qdMbNW);
                iMo2050KLFTb = iM1883Sx - this.f1768eyqo.mo2050KLFTb(viewM1285AZxh);
                if (z3 && c0171wA.f1810JHa) {
                    C0169ZfxDd.mjFkc mjfkcM1876MC = m1876MC(iM1883Sx);
                    mjfkcM1876MC.f1805AZxh = 1;
                    mjfkcM1876MC.f1807mjFkc = iM1653mjFkc;
                    this.f1771mByQ.m1956mjFkc(mjfkcM1876MC);
                }
                i = iM1883Sx;
            }
            if (c0171wA.f1810JHa && c0128JHa.f1472ZfxDd == -1) {
                if (z3) {
                    this.f1772rWxwaT = true;
                } else {
                    if (!(c0128JHa.f1471KLFTb == 1 ? m1903np() : m1880QyMqpM())) {
                        C0169ZfxDd.mjFkc mjfkcM1949JHa = this.f1771mByQ.m1949JHa(iM1653mjFkc);
                        if (mjfkcM1949JHa != null) {
                            mjfkcM1949JHa.f1806ZfxDd = true;
                        }
                        this.f1772rWxwaT = true;
                    }
                }
            }
            m1869HExgdj(viewM1285AZxh, c0171wA, c0128JHa);
            if (m1879Otxclu() && this.f1769huTpC == 1) {
                int iMo2059qdMbNW2 = c0171wA.f1810JHa ? this.f1763Ucbh.mo2059qdMbNW() : this.f1763Ucbh.mo2059qdMbNW() - (((this.f1762Pq - 1) - c0167JHa.f1787KLFTb) * this.f1756Gd);
                iMo2050KLFTb3 = iMo2059qdMbNW2;
                iMo2050KLFTb2 = iMo2059qdMbNW2 - this.f1763Ucbh.mo2050KLFTb(viewM1285AZxh);
            } else {
                int iMo2051MiMN = c0171wA.f1810JHa ? this.f1763Ucbh.mo2051MiMN() : (c0167JHa.f1787KLFTb * this.f1756Gd) + this.f1763Ucbh.mo2051MiMN();
                iMo2050KLFTb2 = iMo2051MiMN;
                iMo2050KLFTb3 = this.f1763Ucbh.mo2050KLFTb(viewM1285AZxh) + iMo2051MiMN;
            }
            if (this.f1769huTpC == 1) {
                m1767XFUzSY(viewM1285AZxh, iMo2050KLFTb2, iMo2050KLFTb, iMo2050KLFTb3, i);
            } else {
                m1767XFUzSY(viewM1285AZxh, iMo2050KLFTb, iMo2050KLFTb2, i, iMo2050KLFTb3);
            }
            if (c0171wA.f1810JHa) {
                m1865BABY(this.f1757HGpJ.f1471KLFTb, i2);
            } else {
                m1898ih(c0167JHa, this.f1757HGpJ.f1471KLFTb, i2);
            }
            m1912xBQUgd(c0146Ucbh, this.f1757HGpJ);
            if (!this.f1757HGpJ.f1473lgHUyS || !viewM1285AZxh.hasFocusable()) {
                z = false;
            } else if (c0171wA.f1810JHa) {
                this.f1754BAnRFn.clear();
                z = false;
            } else {
                z = false;
                this.f1754BAnRFn.set(c0167JHa.f1787KLFTb, false);
            }
            r9 = z;
            z2 = true;
        }
        int i3 = r9;
        if (!z2) {
            m1912xBQUgd(c0146Ucbh, this.f1757HGpJ);
        }
        int iMo2051MiMN2 = this.f1757HGpJ.f1471KLFTb == -1 ? this.f1768eyqo.mo2051MiMN() - m1883Sx(this.f1768eyqo.mo2051MiMN()) : m1886UDcil(this.f1768eyqo.mo2059qdMbNW()) - this.f1768eyqo.mo2059qdMbNW();
        return iMo2051MiMN2 > 0 ? Math.min(c0128JHa.f1469AZxh, iMo2051MiMN2) : i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* renamed from: wGscSa */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1911wGscSa(int i, int i2, int i3) {
        int i4;
        int i5;
        int iM1890XyP = this.f1765VocHEe ? m1890XyP() : m1893bWIyu();
        if (i3 != 8) {
            i4 = i + i2;
        } else {
            if (i >= i2) {
                i4 = i + 1;
                i5 = i2;
                this.f1771mByQ.m1955lgHUyS(i5);
                if (i3 != 1) {
                    this.f1771mByQ.m1947Dt(i, i2);
                } else if (i3 == 2) {
                    this.f1771mByQ.m1948ETF(i, i2);
                } else if (i3 == 8) {
                    this.f1771mByQ.m1948ETF(i, 1);
                    this.f1771mByQ.m1947Dt(i2, 1);
                }
                if (i4 > iM1890XyP) {
                    return;
                }
                if (i5 <= (this.f1765VocHEe ? m1893bWIyu() : m1890XyP())) {
                    m1788mzUGzO();
                    return;
                }
                return;
            }
            i4 = i2 + 1;
        }
        i5 = i;
        this.f1771mByQ.m1955lgHUyS(i5);
        if (i3 != 1) {
        }
        if (i4 > iM1890XyP) {
        }
    }

    /* renamed from: xBQUgd */
    public final void m1912xBQUgd(RecyclerView.C0146Ucbh c0146Ucbh, C0128JHa c0128JHa) {
        if (!c0128JHa.f1474mjFkc || c0128JHa.f1475qdMbNW) {
            return;
        }
        if (c0128JHa.f1469AZxh == 0) {
            if (c0128JHa.f1471KLFTb == -1) {
                m1877MFekjo(c0146Ucbh, c0128JHa.f1477xJ);
                return;
            } else {
                m1888UPU(c0146Ucbh, c0128JHa.f1470JHa);
                return;
            }
        }
        if (c0128JHa.f1471KLFTb != -1) {
            int iM1887UOnCkw = m1887UOnCkw(c0128JHa.f1477xJ) - c0128JHa.f1477xJ;
            m1888UPU(c0146Ucbh, iM1887UOnCkw < 0 ? c0128JHa.f1470JHa : Math.min(iM1887UOnCkw, c0128JHa.f1469AZxh) + c0128JHa.f1470JHa);
        } else {
            int i = c0128JHa.f1470JHa;
            int iM1900jY = i - m1900jY(i);
            m1877MFekjo(c0146Ucbh, iM1900jY < 0 ? c0128JHa.f1477xJ : c0128JHa.f1477xJ - Math.min(iM1900jY, c0128JHa.f1469AZxh));
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: xCVa */
    public void mo1271xCVa(Rect rect, int i, int i2) {
        int iM1717rkYL;
        int iM1717rkYL2;
        int iM1783jm = m1783jm() + m1719ANMGZc();
        int iM1777dm = m1777dm() + m1735JBhc();
        if (this.f1769huTpC == 1) {
            iM1717rkYL2 = RecyclerView.AbstractC0159qGY.m1717rkYL(i2, rect.height() + iM1777dm, m1775bbzow());
            iM1717rkYL = RecyclerView.AbstractC0159qGY.m1717rkYL(i, (this.f1756Gd * this.f1762Pq) + iM1783jm, m1757SwgkN());
        } else {
            iM1717rkYL = RecyclerView.AbstractC0159qGY.m1717rkYL(i, rect.width() + iM1783jm, m1757SwgkN());
            iM1717rkYL2 = RecyclerView.AbstractC0159qGY.m1717rkYL(i2, (this.f1756Gd * this.f1762Pq) + iM1777dm, m1775bbzow());
        }
        m1804ub(iM1717rkYL, iM1717rkYL2);
    }

    /* renamed from: xVYW */
    public void m1913xVYW(RecyclerView.C0148VocHEe c0148VocHEe, C0166AZxh c0166AZxh) {
        if (m1908qtZIjO(c0148VocHEe, c0166AZxh) || m1896gJsSk(c0148VocHEe, c0166AZxh)) {
            return;
        }
        c0166AZxh.m1918mjFkc();
        c0166AZxh.f1782mjFkc = 0;
    }

    /* renamed from: xfXeiC */
    public int m1914xfXeiC() {
        View viewM1866CqAnRZ = this.f1765VocHEe ? m1866CqAnRZ(true) : m1882Rsp(true);
        if (viewM1866CqAnRZ == null) {
            return -1;
        }
        return m1799tQ(viewM1866CqAnRZ);
    }

    /* renamed from: zPp */
    public final C0169ZfxDd.mjFkc m1915zPp(int i) {
        C0169ZfxDd.mjFkc mjfkc = new C0169ZfxDd.mjFkc();
        mjfkc.f1808wA = new int[this.f1762Pq];
        for (int i2 = 0; i2 < this.f1762Pq; i2++) {
            mjfkc.f1808wA[i2] = i - this.f1767diqgf[i2].m1929VA(i);
        }
        return mjfkc;
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$ZfxDd */
    public static class C0169ZfxDd {

        /* renamed from: AZxh */
        public List f1802AZxh;

        /* renamed from: mjFkc */
        public int[] f1803mjFkc;

        /* renamed from: AZxh */
        public void m1946AZxh() {
            int[] iArr = this.f1803mjFkc;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1802AZxh = null;
        }

        /* renamed from: Dt */
        public void m1947Dt(int i, int i2) {
            int[] iArr = this.f1803mjFkc;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            m1959wA(i3);
            int[] iArr2 = this.f1803mjFkc;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.f1803mjFkc, i, i3, -1);
            m1952VA(i, i2);
        }

        /* renamed from: ETF */
        public void m1948ETF(int i, int i2) {
            int[] iArr = this.f1803mjFkc;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            m1959wA(i3);
            int[] iArr2 = this.f1803mjFkc;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.f1803mjFkc;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            m1951MiMN(i, i2);
        }

        /* renamed from: JHa */
        public mjFkc m1949JHa(int i) {
            List list = this.f1802AZxh;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                mjFkc mjfkc = (mjFkc) this.f1802AZxh.get(size);
                if (mjfkc.f1807mjFkc == i) {
                    return mjfkc;
                }
            }
            return null;
        }

        /* renamed from: KLFTb */
        public mjFkc m1950KLFTb(int i, int i2, int i3, boolean z) {
            List list = this.f1802AZxh;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                mjFkc mjfkc = (mjFkc) this.f1802AZxh.get(i4);
                int i5 = mjfkc.f1807mjFkc;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || mjfkc.f1805AZxh == i3 || (z && mjfkc.f1806ZfxDd))) {
                    return mjfkc;
                }
            }
            return null;
        }

        /* renamed from: MiMN */
        public final void m1951MiMN(int i, int i2) {
            List list = this.f1802AZxh;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                mjFkc mjfkc = (mjFkc) this.f1802AZxh.get(size);
                int i4 = mjfkc.f1807mjFkc;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.f1802AZxh.remove(size);
                    } else {
                        mjfkc.f1807mjFkc = i4 - i2;
                    }
                }
            }
        }

        /* renamed from: VA */
        public final void m1952VA(int i, int i2) {
            List list = this.f1802AZxh;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                mjFkc mjfkc = (mjFkc) this.f1802AZxh.get(size);
                int i3 = mjfkc.f1807mjFkc;
                if (i3 >= i) {
                    mjfkc.f1807mjFkc = i3 + i2;
                }
            }
        }

        /* renamed from: YoKzxo */
        public void m1953YoKzxo(int i, C0167JHa c0167JHa) {
            m1959wA(i);
            this.f1803mjFkc[i] = c0167JHa.f1787KLFTb;
        }

        /* renamed from: ZfxDd */
        public int m1954ZfxDd(int i) {
            List list = this.f1802AZxh;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((mjFkc) this.f1802AZxh.get(size)).f1807mjFkc >= i) {
                        this.f1802AZxh.remove(size);
                    }
                }
            }
            return m1955lgHUyS(i);
        }

        /* renamed from: lgHUyS */
        public int m1955lgHUyS(int i) {
            int[] iArr = this.f1803mjFkc;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int iM1957qdMbNW = m1957qdMbNW(i);
            if (iM1957qdMbNW == -1) {
                int[] iArr2 = this.f1803mjFkc;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.f1803mjFkc.length;
            }
            int iMin = Math.min(iM1957qdMbNW + 1, this.f1803mjFkc.length);
            Arrays.fill(this.f1803mjFkc, i, iMin, -1);
            return iMin;
        }

        /* renamed from: mjFkc */
        public void m1956mjFkc(mjFkc mjfkc) {
            if (this.f1802AZxh == null) {
                this.f1802AZxh = new ArrayList();
            }
            int size = this.f1802AZxh.size();
            for (int i = 0; i < size; i++) {
                mjFkc mjfkc2 = (mjFkc) this.f1802AZxh.get(i);
                if (mjfkc2.f1807mjFkc == mjfkc.f1807mjFkc) {
                    this.f1802AZxh.remove(i);
                }
                if (mjfkc2.f1807mjFkc >= mjfkc.f1807mjFkc) {
                    this.f1802AZxh.add(i, mjfkc);
                    return;
                }
            }
            this.f1802AZxh.add(mjfkc);
        }

        /* renamed from: qdMbNW */
        public final int m1957qdMbNW(int i) {
            if (this.f1802AZxh == null) {
                return -1;
            }
            mjFkc mjfkcM1949JHa = m1949JHa(i);
            if (mjfkcM1949JHa != null) {
                this.f1802AZxh.remove(mjfkcM1949JHa);
            }
            int size = this.f1802AZxh.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (((mjFkc) this.f1802AZxh.get(i2)).f1807mjFkc >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            mjFkc mjfkc = (mjFkc) this.f1802AZxh.get(i2);
            this.f1802AZxh.remove(i2);
            return mjfkc.f1807mjFkc;
        }

        /* renamed from: rkYL */
        public int m1958rkYL(int i) {
            int length = this.f1803mjFkc.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* renamed from: wA */
        public void m1959wA(int i) {
            int[] iArr = this.f1803mjFkc;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.f1803mjFkc = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[m1958rkYL(i)];
                this.f1803mjFkc = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f1803mjFkc;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        /* renamed from: xJ */
        public int m1960xJ(int i) {
            int[] iArr = this.f1803mjFkc;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$ZfxDd$mjFkc */
        public static class mjFkc implements Parcelable {

            /* renamed from: CREATOR */
            public static final Parcelable.Creator<mjFkc> f1804CREATOR = new C6348mjFkc();

            /* renamed from: AZxh */
            public int f1805AZxh;

            /* renamed from: ZfxDd */
            public boolean f1806ZfxDd;

            /* renamed from: mjFkc */
            public int f1807mjFkc;

            /* renamed from: wA */
            public int[] f1808wA;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$ZfxDd$mjFkc$mjFkc, reason: collision with other inner class name */
            public class C6348mjFkc implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
                public mjFkc[] newArray(int i) {
                    return new mjFkc[i];
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
                public mjFkc createFromParcel(Parcel parcel) {
                    return new mjFkc(parcel);
                }
            }

            public mjFkc(Parcel parcel) {
                this.f1807mjFkc = parcel.readInt();
                this.f1805AZxh = parcel.readInt();
                this.f1806ZfxDd = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    int[] iArr = new int[i];
                    this.f1808wA = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            /* renamed from: mjFkc */
            public int m1961mjFkc(int i) {
                int[] iArr = this.f1808wA;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1807mjFkc + ", mGapDir=" + this.f1805AZxh + ", mHasUnwantedGapAfter=" + this.f1806ZfxDd + ", mGapPerSpan=" + Arrays.toString(this.f1808wA) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f1807mjFkc);
                parcel.writeInt(this.f1805AZxh);
                parcel.writeInt(this.f1806ZfxDd ? 1 : 0);
                int[] iArr = this.f1808wA;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f1808wA);
                }
            }

            public mjFkc() {
            }
        }
    }
}
