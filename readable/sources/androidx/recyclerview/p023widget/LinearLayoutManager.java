package androidx.recyclerview.p023widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.p023widget.RecyclerView;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.AbstractC0159qGY implements RecyclerView.AbstractC0162vI.AZxh {

    /* renamed from: BAnRFn */
    public int f1493BAnRFn;

    /* renamed from: CqaNbM */
    public int[] f1494CqaNbM;

    /* renamed from: Gd */
    public boolean f1495Gd;

    /* renamed from: HGpJ */
    public boolean f1496HGpJ;

    /* renamed from: Ne */
    public int f1497Ne;

    /* renamed from: OjSQV */
    public final C0130AZxh f1498OjSQV;

    /* renamed from: Pq */
    public int f1499Pq;

    /* renamed from: Ucbh */
    public boolean f1500Ucbh;

    /* renamed from: VocHEe */
    public int f1501VocHEe;

    /* renamed from: diqgf */
    public C0133wA f1502diqgf;

    /* renamed from: eyqo */
    public AbstractC0178qdMbNW f1503eyqo;

    /* renamed from: huTpC */
    public boolean f1504huTpC;

    /* renamed from: lB */
    public boolean f1505lB;

    /* renamed from: mByQ */
    public final C0132mjFkc f1506mByQ;

    /* renamed from: vI */
    public boolean f1507vI;

    /* renamed from: wJVbdd */
    public C0131ZfxDd f1508wJVbdd;

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$AZxh */
    public static class C0130AZxh {

        /* renamed from: AZxh */
        public boolean f1509AZxh;

        /* renamed from: ZfxDd */
        public boolean f1510ZfxDd;

        /* renamed from: mjFkc */
        public int f1511mjFkc;

        /* renamed from: wA */
        public boolean f1512wA;

        /* renamed from: mjFkc */
        public void m1365mjFkc() {
            this.f1511mjFkc = 0;
            this.f1509AZxh = false;
            this.f1512wA = false;
            this.f1510ZfxDd = false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$ZfxDd */
    public static class C0131ZfxDd implements Parcelable {

        /* renamed from: CREATOR */
        public static final Parcelable.Creator<C0131ZfxDd> f1513CREATOR = new mjFkc();

        /* renamed from: AZxh */
        public int f1514AZxh;

        /* renamed from: mjFkc */
        public int f1515mjFkc;

        /* renamed from: wA */
        public boolean f1516wA;

        /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$ZfxDd$mjFkc */
        public class mjFkc implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
            public C0131ZfxDd[] newArray(int i) {
                return new C0131ZfxDd[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public C0131ZfxDd createFromParcel(Parcel parcel) {
                return new C0131ZfxDd(parcel);
            }
        }

        public C0131ZfxDd() {
        }

        /* renamed from: AZxh */
        public void m1366AZxh() {
            this.f1515mjFkc = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: mjFkc */
        public boolean m1367mjFkc() {
            return this.f1515mjFkc >= 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1515mjFkc);
            parcel.writeInt(this.f1514AZxh);
            parcel.writeInt(this.f1516wA ? 1 : 0);
        }

        public C0131ZfxDd(Parcel parcel) {
            this.f1515mjFkc = parcel.readInt();
            this.f1514AZxh = parcel.readInt();
            this.f1516wA = parcel.readInt() == 1;
        }

        public C0131ZfxDd(C0131ZfxDd c0131ZfxDd) {
            this.f1515mjFkc = c0131ZfxDd.f1515mjFkc;
            this.f1514AZxh = c0131ZfxDd.f1514AZxh;
            this.f1516wA = c0131ZfxDd.f1516wA;
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$mjFkc */
    public static class C0132mjFkc {

        /* renamed from: AZxh */
        public int f1517AZxh;

        /* renamed from: KLFTb */
        public boolean f1518KLFTb;

        /* renamed from: ZfxDd */
        public boolean f1519ZfxDd;

        /* renamed from: mjFkc */
        public AbstractC0178qdMbNW f1520mjFkc;

        /* renamed from: wA */
        public int f1521wA;

        public C0132mjFkc() {
            m1371KLFTb();
        }

        /* renamed from: AZxh */
        public void m1370AZxh(View view, int i) {
            if (this.f1519ZfxDd) {
                this.f1521wA = this.f1520mjFkc.mo2055ZfxDd(view) + this.f1520mjFkc.m2060rkYL();
            } else {
                this.f1521wA = this.f1520mjFkc.mo2061xJ(view);
            }
            this.f1517AZxh = i;
        }

        /* renamed from: KLFTb */
        public void m1371KLFTb() {
            this.f1517AZxh = -1;
            this.f1521wA = Integer.MIN_VALUE;
            this.f1519ZfxDd = false;
            this.f1518KLFTb = false;
        }

        /* renamed from: ZfxDd */
        public boolean m1372ZfxDd(View view, RecyclerView.C0148VocHEe c0148VocHEe) {
            RecyclerView.C0153fehf c0153fehf = (RecyclerView.C0153fehf) view.getLayoutParams();
            return !c0153fehf.m1654wA() && c0153fehf.m1653mjFkc() >= 0 && c0153fehf.m1653mjFkc() < c0148VocHEe.m1624AZxh();
        }

        /* renamed from: mjFkc */
        public void m1373mjFkc() {
            this.f1521wA = this.f1519ZfxDd ? this.f1520mjFkc.mo2059qdMbNW() : this.f1520mjFkc.mo2051MiMN();
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1517AZxh + ", mCoordinate=" + this.f1521wA + ", mLayoutFromEnd=" + this.f1519ZfxDd + ", mValid=" + this.f1518KLFTb + '}';
        }

        /* renamed from: wA */
        public void m1374wA(View view, int i) {
            int iM2060rkYL = this.f1520mjFkc.m2060rkYL();
            if (iM2060rkYL >= 0) {
                m1370AZxh(view, i);
                return;
            }
            this.f1517AZxh = i;
            if (this.f1519ZfxDd) {
                int iMo2059qdMbNW = (this.f1520mjFkc.mo2059qdMbNW() - iM2060rkYL) - this.f1520mjFkc.mo2055ZfxDd(view);
                this.f1521wA = this.f1520mjFkc.mo2059qdMbNW() - iMo2059qdMbNW;
                if (iMo2059qdMbNW > 0) {
                    int iMo2050KLFTb = this.f1521wA - this.f1520mjFkc.mo2050KLFTb(view);
                    int iMo2051MiMN = this.f1520mjFkc.mo2051MiMN();
                    int iMin = iMo2050KLFTb - (iMo2051MiMN + Math.min(this.f1520mjFkc.mo2061xJ(view) - iMo2051MiMN, 0));
                    if (iMin < 0) {
                        this.f1521wA += Math.min(iMo2059qdMbNW, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iMo2061xJ = this.f1520mjFkc.mo2061xJ(view);
            int iMo2051MiMN2 = iMo2061xJ - this.f1520mjFkc.mo2051MiMN();
            this.f1521wA = iMo2061xJ;
            if (iMo2051MiMN2 > 0) {
                int iMo2059qdMbNW2 = (this.f1520mjFkc.mo2059qdMbNW() - Math.min(0, (this.f1520mjFkc.mo2059qdMbNW() - iM2060rkYL) - this.f1520mjFkc.mo2055ZfxDd(view))) - (iMo2061xJ + this.f1520mjFkc.mo2050KLFTb(view));
                if (iMo2059qdMbNW2 < 0) {
                    this.f1521wA -= Math.min(iMo2051MiMN2, -iMo2059qdMbNW2);
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$wA */
    public static class C0133wA {

        /* renamed from: AZxh */
        public int f1522AZxh;

        /* renamed from: ETF */
        public int f1524ETF;

        /* renamed from: JHa */
        public int f1525JHa;

        /* renamed from: KLFTb */
        public int f1526KLFTb;

        /* renamed from: MiMN */
        public boolean f1527MiMN;

        /* renamed from: ZfxDd */
        public int f1529ZfxDd;

        /* renamed from: wA */
        public int f1533wA;

        /* renamed from: xJ */
        public int f1534xJ;

        /* renamed from: mjFkc */
        public boolean f1531mjFkc = true;

        /* renamed from: lgHUyS */
        public int f1530lgHUyS = 0;

        /* renamed from: qdMbNW */
        public int f1532qdMbNW = 0;

        /* renamed from: Dt */
        public boolean f1523Dt = false;

        /* renamed from: VA */
        public List f1528VA = null;

        /* renamed from: AZxh */
        public void m1375AZxh(View view) {
            View viewM1376JHa = m1376JHa(view);
            if (viewM1376JHa == null) {
                this.f1529ZfxDd = -1;
            } else {
                this.f1529ZfxDd = ((RecyclerView.C0153fehf) viewM1376JHa.getLayoutParams()).m1653mjFkc();
            }
        }

        /* renamed from: JHa */
        public View m1376JHa(View view) {
            int iM1653mjFkc;
            int size = this.f1528VA.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = ((RecyclerView.AbstractC0157mByQ) this.f1528VA.get(i2)).f1700mjFkc;
                RecyclerView.C0153fehf c0153fehf = (RecyclerView.C0153fehf) view3.getLayoutParams();
                if (view3 != view && !c0153fehf.m1654wA() && (iM1653mjFkc = (c0153fehf.m1653mjFkc() - this.f1529ZfxDd) * this.f1526KLFTb) >= 0 && iM1653mjFkc < i) {
                    view2 = view3;
                    if (iM1653mjFkc == 0) {
                        break;
                    }
                    i = iM1653mjFkc;
                }
            }
            return view2;
        }

        /* renamed from: KLFTb */
        public final View m1377KLFTb() {
            int size = this.f1528VA.size();
            for (int i = 0; i < size; i++) {
                View view = ((RecyclerView.AbstractC0157mByQ) this.f1528VA.get(i)).f1700mjFkc;
                RecyclerView.C0153fehf c0153fehf = (RecyclerView.C0153fehf) view.getLayoutParams();
                if (!c0153fehf.m1654wA() && this.f1529ZfxDd == c0153fehf.m1653mjFkc()) {
                    m1375AZxh(view);
                    return view;
                }
            }
            return null;
        }

        /* renamed from: ZfxDd */
        public View m1378ZfxDd(RecyclerView.C0146Ucbh c0146Ucbh) {
            if (this.f1528VA != null) {
                return m1377KLFTb();
            }
            View viewM1616rkYL = c0146Ucbh.m1616rkYL(this.f1529ZfxDd);
            this.f1529ZfxDd += this.f1526KLFTb;
            return viewM1616rkYL;
        }

        /* renamed from: mjFkc */
        public void m1379mjFkc() {
            m1375AZxh(null);
        }

        /* renamed from: wA */
        public boolean m1380wA(RecyclerView.C0148VocHEe c0148VocHEe) {
            int i = this.f1529ZfxDd;
            return i >= 0 && i < c0148VocHEe.m1624AZxh();
        }
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f1499Pq = 1;
        this.f1504huTpC = false;
        this.f1495Gd = false;
        this.f1496HGpJ = false;
        this.f1507vI = true;
        this.f1501VocHEe = -1;
        this.f1493BAnRFn = Integer.MIN_VALUE;
        this.f1508wJVbdd = null;
        this.f1506mByQ = new C0132mjFkc();
        this.f1498OjSQV = new C0130AZxh();
        this.f1497Ne = 2;
        this.f1494CqaNbM = new int[2];
        m1309EeoThB(i);
        m1342cdjp(z);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0162vI.AZxh
    /* renamed from: AZxh */
    public PointF mo1304AZxh(int i) {
        if (m1817zvd() == 0) {
            return null;
        }
        int i2 = (i < m1799tQ(m1743KLMXS(0))) != this.f1495Gd ? -1 : 1;
        return this.f1499Pq == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    /* renamed from: ArO */
    public boolean m1305ArO() {
        return this.f1503eyqo.mo2047ETF() == 0 && this.f1503eyqo.mo2057lgHUyS() == 0;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: BxruE */
    public int mo1230BxruE(int i, RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        if (this.f1499Pq == 1) {
            return 0;
        }
        return m1346jTNPnW(i, c0146Ucbh, c0148VocHEe);
    }

    /* renamed from: CcoH */
    public int m1306CcoH(RecyclerView.C0146Ucbh c0146Ucbh, C0133wA c0133wA, RecyclerView.C0148VocHEe c0148VocHEe, boolean z) {
        int i = c0133wA.f1533wA;
        int i2 = c0133wA.f1534xJ;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                c0133wA.f1534xJ = i2 + i;
            }
            m1359tPvjn(c0146Ucbh, c0133wA);
        }
        int i3 = c0133wA.f1533wA + c0133wA.f1530lgHUyS;
        C0130AZxh c0130AZxh = this.f1498OjSQV;
        while (true) {
            if ((!c0133wA.f1527MiMN && i3 <= 0) || !c0133wA.m1380wA(c0148VocHEe)) {
                break;
            }
            c0130AZxh.m1365mjFkc();
            mo1242Sx(c0146Ucbh, c0148VocHEe, c0133wA, c0130AZxh);
            if (!c0130AZxh.f1509AZxh) {
                c0133wA.f1522AZxh += c0130AZxh.f1511mjFkc * c0133wA.f1525JHa;
                if (!c0130AZxh.f1512wA || c0133wA.f1528VA != null || !c0148VocHEe.m1626KLFTb()) {
                    int i4 = c0133wA.f1533wA;
                    int i5 = c0130AZxh.f1511mjFkc;
                    c0133wA.f1533wA = i4 - i5;
                    i3 -= i5;
                }
                int i6 = c0133wA.f1534xJ;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + c0130AZxh.f1511mjFkc;
                    c0133wA.f1534xJ = i7;
                    int i8 = c0133wA.f1533wA;
                    if (i8 < 0) {
                        c0133wA.f1534xJ = i7 + i8;
                    }
                    m1359tPvjn(c0146Ucbh, c0133wA);
                }
                if (z && c0130AZxh.f1510ZfxDd) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - c0133wA.f1533wA;
    }

    /* renamed from: CqAnRZ */
    public final View m1307CqAnRZ() {
        return this.f1495Gd ? m1313HX() : m1320MC();
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Dp */
    public void mo1308Dp(AccessibilityEvent accessibilityEvent) {
        super.mo1308Dp(accessibilityEvent);
        if (m1817zvd() > 0) {
            accessibilityEvent.setFromIndex(m1364zPp());
            accessibilityEvent.setToIndex(m1340aDq());
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: ERt */
    public boolean mo1231ERt() {
        return this.f1508wJVbdd == null && this.f1500Ucbh == this.f1496HGpJ;
    }

    /* renamed from: EeoThB */
    public void m1309EeoThB(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        mo1351lgHUyS(null);
        if (i != this.f1499Pq || this.f1503eyqo == null) {
            AbstractC0178qdMbNW abstractC0178qdMbNWM2043AZxh = AbstractC0178qdMbNW.m2043AZxh(this, i);
            this.f1503eyqo = abstractC0178qdMbNWM2043AZxh;
            this.f1506mByQ.f1520mjFkc = abstractC0178qdMbNWM2043AZxh;
            this.f1499Pq = i;
            m1788mzUGzO();
        }
    }

    /* renamed from: EoC */
    public View m1310EoC(boolean z, boolean z2) {
        return this.f1495Gd ? m1330TvfBiy(0, m1817zvd(), z, z2) : m1330TvfBiy(m1817zvd() - 1, -1, z, z2);
    }

    /* renamed from: Es */
    public final void m1311Es(C0132mjFkc c0132mjFkc) {
        m1319LlB(c0132mjFkc.f1517AZxh, c0132mjFkc.f1521wA);
    }

    /* renamed from: HExgdj */
    public final int m1312HExgdj(RecyclerView.C0148VocHEe c0148VocHEe) {
        if (m1817zvd() == 0) {
            return 0;
        }
        m1358qrxT();
        return AbstractC0172VA.m1967wA(c0148VocHEe, this.f1503eyqo, m1363xbjHT(!this.f1507vI, true), m1310EoC(!this.f1507vI, true), this, this.f1507vI);
    }

    /* renamed from: HX */
    public final View m1313HX() {
        return m1361vZ(0, m1817zvd());
    }

    /* renamed from: Hk */
    public final int m1314Hk(int i, RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, boolean z) {
        int iMo2051MiMN;
        int iMo2051MiMN2 = i - this.f1503eyqo.mo2051MiMN();
        if (iMo2051MiMN2 <= 0) {
            return 0;
        }
        int i2 = -m1346jTNPnW(iMo2051MiMN2, c0146Ucbh, c0148VocHEe);
        int i3 = i + i2;
        if (!z || (iMo2051MiMN = i3 - this.f1503eyqo.mo2051MiMN()) <= 0) {
            return i2;
        }
        this.f1503eyqo.mo2048IEE(-iMo2051MiMN);
        return i2 - iMo2051MiMN;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: IEE */
    public int mo1315IEE(RecyclerView.C0148VocHEe c0148VocHEe) {
        return m1353np(c0148VocHEe);
    }

    /* renamed from: IPpyV */
    public final void m1316IPpyV(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, C0132mjFkc c0132mjFkc) {
        if (m1334UPU(c0148VocHEe, c0132mjFkc) || m1321MFekjo(c0146Ucbh, c0148VocHEe, c0132mjFkc)) {
            return;
        }
        c0132mjFkc.m1373mjFkc();
        c0132mjFkc.f1517AZxh = this.f1496HGpJ ? c0148VocHEe.m1624AZxh() - 1 : 0;
    }

    /* renamed from: JOe */
    public void mo1317JOe(RecyclerView.C0148VocHEe c0148VocHEe, int[] iArr) {
        int i;
        int iM1338XyP = m1338XyP(c0148VocHEe);
        if (this.f1502diqgf.f1525JHa == -1) {
            i = 0;
        } else {
            i = iM1338XyP;
            iM1338XyP = 0;
        }
        iArr[0] = iM1338XyP;
        iArr[1] = i;
    }

    /* renamed from: KSf */
    public int m1318KSf(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.f1499Pq == 1) ? 1 : Integer.MIN_VALUE : this.f1499Pq == 0 ? 1 : Integer.MIN_VALUE : this.f1499Pq == 1 ? -1 : Integer.MIN_VALUE : this.f1499Pq == 0 ? -1 : Integer.MIN_VALUE : (this.f1499Pq != 1 && m1347jY()) ? -1 : 1 : (this.f1499Pq != 1 && m1347jY()) ? 1 : -1;
    }

    /* renamed from: LlB */
    public final void m1319LlB(int i, int i2) {
        this.f1502diqgf.f1533wA = this.f1503eyqo.mo2059qdMbNW() - i2;
        C0133wA c0133wA = this.f1502diqgf;
        c0133wA.f1526KLFTb = this.f1495Gd ? -1 : 1;
        c0133wA.f1529ZfxDd = i;
        c0133wA.f1525JHa = 1;
        c0133wA.f1522AZxh = i2;
        c0133wA.f1534xJ = Integer.MIN_VALUE;
    }

    /* renamed from: MC */
    public final View m1320MC() {
        return m1361vZ(m1817zvd() - 1, -1);
    }

    /* renamed from: MFekjo */
    public final boolean m1321MFekjo(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, C0132mjFkc c0132mjFkc) {
        View viewMo1274xfXeiC;
        boolean z = false;
        if (m1817zvd() == 0) {
            return false;
        }
        View viewM1738JYn = m1738JYn();
        if (viewM1738JYn != null && c0132mjFkc.m1372ZfxDd(viewM1738JYn, c0148VocHEe)) {
            c0132mjFkc.m1374wA(viewM1738JYn, m1799tQ(viewM1738JYn));
            return true;
        }
        boolean z2 = this.f1500Ucbh;
        boolean z3 = this.f1496HGpJ;
        if (z2 != z3 || (viewMo1274xfXeiC = mo1274xfXeiC(c0146Ucbh, c0148VocHEe, c0132mjFkc.f1519ZfxDd, z3)) == null) {
            return false;
        }
        c0132mjFkc.m1370AZxh(viewMo1274xfXeiC, m1799tQ(viewMo1274xfXeiC));
        if (!c0148VocHEe.m1626KLFTb() && mo1231ERt()) {
            int iMo2061xJ = this.f1503eyqo.mo2061xJ(viewMo1274xfXeiC);
            int iMo2055ZfxDd = this.f1503eyqo.mo2055ZfxDd(viewMo1274xfXeiC);
            int iMo2051MiMN = this.f1503eyqo.mo2051MiMN();
            int iMo2059qdMbNW = this.f1503eyqo.mo2059qdMbNW();
            boolean z4 = iMo2055ZfxDd <= iMo2051MiMN && iMo2061xJ < iMo2051MiMN;
            if (iMo2061xJ >= iMo2059qdMbNW && iMo2055ZfxDd > iMo2059qdMbNW) {
                z = true;
            }
            if (z4 || z) {
                if (c0132mjFkc.f1519ZfxDd) {
                    iMo2051MiMN = iMo2059qdMbNW;
                }
                c0132mjFkc.f1521wA = iMo2051MiMN;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: MiMN */
    public boolean mo1322MiMN() {
        return this.f1499Pq == 1;
    }

    /* renamed from: Mpf */
    public final int m1323Mpf(int i, RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, boolean z) {
        int iMo2059qdMbNW;
        int iMo2059qdMbNW2 = this.f1503eyqo.mo2059qdMbNW() - i;
        if (iMo2059qdMbNW2 <= 0) {
            return 0;
        }
        int i2 = -m1346jTNPnW(-iMo2059qdMbNW2, c0146Ucbh, c0148VocHEe);
        int i3 = i + i2;
        if (!z || (iMo2059qdMbNW = this.f1503eyqo.mo2059qdMbNW() - i3) <= 0) {
            return i2;
        }
        this.f1503eyqo.mo2048IEE(iMo2059qdMbNW);
        return iMo2059qdMbNW + i2;
    }

    /* renamed from: Otxclu */
    public final void m1324Otxclu(RecyclerView.C0146Ucbh c0146Ucbh, int i, int i2) {
        int iM1817zvd = m1817zvd();
        if (i < 0) {
            return;
        }
        int iMo2057lgHUyS = (this.f1503eyqo.mo2057lgHUyS() - i) + i2;
        if (this.f1495Gd) {
            for (int i3 = 0; i3 < iM1817zvd; i3++) {
                View viewM1743KLMXS = m1743KLMXS(i3);
                if (this.f1503eyqo.mo2061xJ(viewM1743KLMXS) < iMo2057lgHUyS || this.f1503eyqo.mo2056fehf(viewM1743KLMXS) < iMo2057lgHUyS) {
                    m1329TFbkuO(c0146Ucbh, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = iM1817zvd - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View viewM1743KLMXS2 = m1743KLMXS(i5);
            if (this.f1503eyqo.mo2061xJ(viewM1743KLMXS2) < iMo2057lgHUyS || this.f1503eyqo.mo2056fehf(viewM1743KLMXS2) < iMo2057lgHUyS) {
                m1329TFbkuO(c0146Ucbh, i4, i5);
                return;
            }
        }
    }

    /* renamed from: OzIs */
    public final void m1325OzIs(RecyclerView.C0146Ucbh c0146Ucbh, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int iM1817zvd = m1817zvd();
        if (!this.f1495Gd) {
            for (int i4 = 0; i4 < iM1817zvd; i4++) {
                View viewM1743KLMXS = m1743KLMXS(i4);
                if (this.f1503eyqo.mo2055ZfxDd(viewM1743KLMXS) > i3 || this.f1503eyqo.mo2058qGY(viewM1743KLMXS) > i3) {
                    m1329TFbkuO(c0146Ucbh, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = iM1817zvd - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View viewM1743KLMXS2 = m1743KLMXS(i6);
            if (this.f1503eyqo.mo2055ZfxDd(viewM1743KLMXS2) > i3 || this.f1503eyqo.mo2058qGY(viewM1743KLMXS2) > i3) {
                m1329TFbkuO(c0146Ucbh, i5, i6);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Pq */
    public int mo1240Pq(RecyclerView.C0148VocHEe c0148VocHEe) {
        return m1326QyMqpM(c0148VocHEe);
    }

    /* renamed from: QyMqpM */
    public final int m1326QyMqpM(RecyclerView.C0148VocHEe c0148VocHEe) {
        if (m1817zvd() == 0) {
            return 0;
        }
        m1358qrxT();
        return AbstractC0172VA.m1965AZxh(c0148VocHEe, this.f1503eyqo, m1363xbjHT(!this.f1507vI, true), m1310EoC(!this.f1507vI, true), this, this.f1507vI, this.f1495Gd);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: QyqF */
    public int mo1241QyqF(int i, RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        if (this.f1499Pq == 0) {
            return 0;
        }
        return m1346jTNPnW(i, c0146Ucbh, c0148VocHEe);
    }

    /* renamed from: RWb */
    public final void m1327RWb() {
        if (this.f1499Pq == 1 || !m1347jY()) {
            this.f1495Gd = this.f1504huTpC;
        } else {
            this.f1495Gd = !this.f1504huTpC;
        }
    }

    /* renamed from: Rsp */
    public final View m1328Rsp() {
        return this.f1495Gd ? m1320MC() : m1313HX();
    }

    /* renamed from: Sx */
    public void mo1242Sx(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, C0133wA c0133wA, C0130AZxh c0130AZxh) {
        int i;
        int i2;
        int i3;
        int iM1783jm;
        int iMo2049JHa;
        View viewM1378ZfxDd = c0133wA.m1378ZfxDd(c0146Ucbh);
        if (viewM1378ZfxDd == null) {
            c0130AZxh.f1509AZxh = true;
            return;
        }
        RecyclerView.C0153fehf c0153fehf = (RecyclerView.C0153fehf) viewM1378ZfxDd.getLayoutParams();
        if (c0133wA.f1528VA == null) {
            if (this.f1495Gd == (c0133wA.f1525JHa == -1)) {
                m1742KLFTb(viewM1378ZfxDd);
            } else {
                m1736JHa(viewM1378ZfxDd, 0);
            }
        } else {
            if (this.f1495Gd == (c0133wA.f1525JHa == -1)) {
                m1810wA(viewM1378ZfxDd);
            } else {
                m1772ZfxDd(viewM1378ZfxDd, 0);
            }
        }
        mo1770XtE(viewM1378ZfxDd, 0, 0);
        c0130AZxh.f1511mjFkc = this.f1503eyqo.mo2050KLFTb(viewM1378ZfxDd);
        if (this.f1499Pq == 1) {
            if (m1347jY()) {
                iMo2049JHa = m1755SOS() - m1719ANMGZc();
                iM1783jm = iMo2049JHa - this.f1503eyqo.mo2049JHa(viewM1378ZfxDd);
            } else {
                iM1783jm = m1783jm();
                iMo2049JHa = this.f1503eyqo.mo2049JHa(viewM1378ZfxDd) + iM1783jm;
            }
            if (c0133wA.f1525JHa == -1) {
                int i4 = c0133wA.f1522AZxh;
                i3 = i4;
                i2 = iMo2049JHa;
                i = i4 - c0130AZxh.f1511mjFkc;
            } else {
                int i5 = c0133wA.f1522AZxh;
                i = i5;
                i2 = iMo2049JHa;
                i3 = c0130AZxh.f1511mjFkc + i5;
            }
        } else {
            int iM1777dm = m1777dm();
            int iMo2049JHa2 = this.f1503eyqo.mo2049JHa(viewM1378ZfxDd) + iM1777dm;
            if (c0133wA.f1525JHa == -1) {
                int i6 = c0133wA.f1522AZxh;
                i2 = i6;
                i = iM1777dm;
                i3 = iMo2049JHa2;
                iM1783jm = i6 - c0130AZxh.f1511mjFkc;
            } else {
                int i7 = c0133wA.f1522AZxh;
                i = iM1777dm;
                i2 = c0130AZxh.f1511mjFkc + i7;
                i3 = iMo2049JHa2;
                iM1783jm = i7;
            }
        }
        m1767XFUzSY(viewM1378ZfxDd, iM1783jm, i, i2, i3);
        if (c0153fehf.m1654wA() || c0153fehf.m1651AZxh()) {
            c0130AZxh.f1512wA = true;
        }
        c0130AZxh.f1510ZfxDd = viewM1378ZfxDd.hasFocusable();
    }

    /* renamed from: TFbkuO */
    public final void m1329TFbkuO(RecyclerView.C0146Ucbh c0146Ucbh, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                m1763Vu(i, c0146Ucbh);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                m1763Vu(i3, c0146Ucbh);
            }
        }
    }

    /* renamed from: TvfBiy */
    public View m1330TvfBiy(int i, int i2, boolean z, boolean z2) {
        m1358qrxT();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        return this.f1499Pq == 0 ? this.f1712KLFTb.m2063mjFkc(i, i2, i3, i4) : this.f1711JHa.m2063mjFkc(i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Tw */
    public void mo1331Tw(int i) {
        this.f1501VocHEe = i;
        this.f1493BAnRFn = Integer.MIN_VALUE;
        C0131ZfxDd c0131ZfxDd = this.f1508wJVbdd;
        if (c0131ZfxDd != null) {
            c0131ZfxDd.m1366AZxh();
        }
        m1788mzUGzO();
    }

    /* renamed from: UDcil */
    public int m1332UDcil() {
        return this.f1499Pq;
    }

    /* renamed from: UOnCkw */
    public boolean m1333UOnCkw() {
        return this.f1507vI;
    }

    /* renamed from: UPU */
    public final boolean m1334UPU(RecyclerView.C0148VocHEe c0148VocHEe, C0132mjFkc c0132mjFkc) {
        int i;
        if (!c0148VocHEe.m1626KLFTb() && (i = this.f1501VocHEe) != -1) {
            if (i >= 0 && i < c0148VocHEe.m1624AZxh()) {
                c0132mjFkc.f1517AZxh = this.f1501VocHEe;
                C0131ZfxDd c0131ZfxDd = this.f1508wJVbdd;
                if (c0131ZfxDd != null && c0131ZfxDd.m1367mjFkc()) {
                    boolean z = this.f1508wJVbdd.f1516wA;
                    c0132mjFkc.f1519ZfxDd = z;
                    if (z) {
                        c0132mjFkc.f1521wA = this.f1503eyqo.mo2059qdMbNW() - this.f1508wJVbdd.f1514AZxh;
                    } else {
                        c0132mjFkc.f1521wA = this.f1503eyqo.mo2051MiMN() + this.f1508wJVbdd.f1514AZxh;
                    }
                    return true;
                }
                if (this.f1493BAnRFn != Integer.MIN_VALUE) {
                    boolean z2 = this.f1495Gd;
                    c0132mjFkc.f1519ZfxDd = z2;
                    if (z2) {
                        c0132mjFkc.f1521wA = this.f1503eyqo.mo2059qdMbNW() - this.f1493BAnRFn;
                    } else {
                        c0132mjFkc.f1521wA = this.f1503eyqo.mo2051MiMN() + this.f1493BAnRFn;
                    }
                    return true;
                }
                View viewMo1362wJVbdd = mo1362wJVbdd(this.f1501VocHEe);
                if (viewMo1362wJVbdd == null) {
                    if (m1817zvd() > 0) {
                        c0132mjFkc.f1519ZfxDd = (this.f1501VocHEe < m1799tQ(m1743KLMXS(0))) == this.f1495Gd;
                    }
                    c0132mjFkc.m1373mjFkc();
                } else {
                    if (this.f1503eyqo.mo2050KLFTb(viewMo1362wJVbdd) > this.f1503eyqo.mo2054YoKzxo()) {
                        c0132mjFkc.m1373mjFkc();
                        return true;
                    }
                    if (this.f1503eyqo.mo2061xJ(viewMo1362wJVbdd) - this.f1503eyqo.mo2051MiMN() < 0) {
                        c0132mjFkc.f1521wA = this.f1503eyqo.mo2051MiMN();
                        c0132mjFkc.f1519ZfxDd = false;
                        return true;
                    }
                    if (this.f1503eyqo.mo2059qdMbNW() - this.f1503eyqo.mo2055ZfxDd(viewMo1362wJVbdd) < 0) {
                        c0132mjFkc.f1521wA = this.f1503eyqo.mo2059qdMbNW();
                        c0132mjFkc.f1519ZfxDd = true;
                        return true;
                    }
                    c0132mjFkc.f1521wA = c0132mjFkc.f1519ZfxDd ? this.f1503eyqo.mo2055ZfxDd(viewMo1362wJVbdd) + this.f1503eyqo.m2060rkYL() : this.f1503eyqo.mo2061xJ(viewMo1362wJVbdd);
                }
                return true;
            }
            this.f1501VocHEe = -1;
            this.f1493BAnRFn = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Ucbh */
    public int mo1243Ucbh(RecyclerView.C0148VocHEe c0148VocHEe) {
        return m1326QyMqpM(c0148VocHEe);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: VA */
    public boolean mo1335VA() {
        return this.f1499Pq == 0;
    }

    /* renamed from: Vptz */
    public C0133wA m1336Vptz() {
        return new C0133wA();
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: XD */
    public void mo1337XD(RecyclerView recyclerView, RecyclerView.C0146Ucbh c0146Ucbh) {
        super.mo1337XD(recyclerView, c0146Ucbh);
        if (this.f1505lB) {
            m1797sqndV(c0146Ucbh);
            c0146Ucbh.m1619wA();
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Xxz */
    public void mo1245Xxz(RecyclerView.C0148VocHEe c0148VocHEe) {
        super.mo1245Xxz(c0148VocHEe);
        this.f1508wJVbdd = null;
        this.f1501VocHEe = -1;
        this.f1493BAnRFn = Integer.MIN_VALUE;
        this.f1506mByQ.m1371KLFTb();
    }

    /* renamed from: XyP */
    public int m1338XyP(RecyclerView.C0148VocHEe c0148VocHEe) {
        if (c0148VocHEe.m1627ZfxDd()) {
            return this.f1503eyqo.mo2054YoKzxo();
        }
        return 0;
    }

    /* renamed from: ZGL */
    public final void m1339ZGL(int i, int i2) {
        this.f1502diqgf.f1533wA = i2 - this.f1503eyqo.mo2051MiMN();
        C0133wA c0133wA = this.f1502diqgf;
        c0133wA.f1529ZfxDd = i;
        c0133wA.f1526KLFTb = this.f1495Gd ? 1 : -1;
        c0133wA.f1525JHa = -1;
        c0133wA.f1522AZxh = i2;
        c0133wA.f1534xJ = Integer.MIN_VALUE;
    }

    /* renamed from: aDq */
    public int m1340aDq() {
        View viewM1330TvfBiy = m1330TvfBiy(m1817zvd() - 1, -1, false, true);
        if (viewM1330TvfBiy == null) {
            return -1;
        }
        return m1799tQ(viewM1330TvfBiy);
    }

    /* renamed from: bWIyu */
    public final View m1341bWIyu() {
        return m1743KLMXS(this.f1495Gd ? m1817zvd() - 1 : 0);
    }

    /* renamed from: cdjp */
    public void m1342cdjp(boolean z) {
        mo1351lgHUyS(null);
        if (z == this.f1504huTpC) {
            return;
        }
        this.f1504huTpC = z;
        m1788mzUGzO();
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: dGDT */
    public void mo1248dGDT(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        int i;
        int i2;
        int i3;
        int i4;
        int iM1323Mpf;
        int i5;
        View viewMo1362wJVbdd;
        int iMo2061xJ;
        int iMo2059qdMbNW;
        int i6 = -1;
        if (!(this.f1508wJVbdd == null && this.f1501VocHEe == -1) && c0148VocHEe.m1624AZxh() == 0) {
            m1797sqndV(c0146Ucbh);
            return;
        }
        C0131ZfxDd c0131ZfxDd = this.f1508wJVbdd;
        if (c0131ZfxDd != null && c0131ZfxDd.m1367mjFkc()) {
            this.f1501VocHEe = this.f1508wJVbdd.f1515mjFkc;
        }
        m1358qrxT();
        this.f1502diqgf.f1531mjFkc = false;
        m1327RWb();
        View viewM1738JYn = m1738JYn();
        C0132mjFkc c0132mjFkc = this.f1506mByQ;
        if (!c0132mjFkc.f1518KLFTb || this.f1501VocHEe != -1 || this.f1508wJVbdd != null) {
            c0132mjFkc.m1371KLFTb();
            C0132mjFkc c0132mjFkc2 = this.f1506mByQ;
            c0132mjFkc2.f1519ZfxDd = this.f1495Gd ^ this.f1496HGpJ;
            m1316IPpyV(c0146Ucbh, c0148VocHEe, c0132mjFkc2);
            this.f1506mByQ.f1518KLFTb = true;
        } else if (viewM1738JYn != null && (this.f1503eyqo.mo2061xJ(viewM1738JYn) >= this.f1503eyqo.mo2059qdMbNW() || this.f1503eyqo.mo2055ZfxDd(viewM1738JYn) <= this.f1503eyqo.mo2051MiMN())) {
            this.f1506mByQ.m1374wA(viewM1738JYn, m1799tQ(viewM1738JYn));
        }
        C0133wA c0133wA = this.f1502diqgf;
        c0133wA.f1525JHa = c0133wA.f1524ETF >= 0 ? 1 : -1;
        int[] iArr = this.f1494CqaNbM;
        iArr[0] = 0;
        iArr[1] = 0;
        mo1317JOe(c0148VocHEe, iArr);
        int iMax = Math.max(0, this.f1494CqaNbM[0]) + this.f1503eyqo.mo2051MiMN();
        int iMax2 = Math.max(0, this.f1494CqaNbM[1]) + this.f1503eyqo.mo2046Dt();
        if (c0148VocHEe.m1626KLFTb() && (i5 = this.f1501VocHEe) != -1 && this.f1493BAnRFn != Integer.MIN_VALUE && (viewMo1362wJVbdd = mo1362wJVbdd(i5)) != null) {
            if (this.f1495Gd) {
                iMo2059qdMbNW = this.f1503eyqo.mo2059qdMbNW() - this.f1503eyqo.mo2055ZfxDd(viewMo1362wJVbdd);
                iMo2061xJ = this.f1493BAnRFn;
            } else {
                iMo2061xJ = this.f1503eyqo.mo2061xJ(viewMo1362wJVbdd) - this.f1503eyqo.mo2051MiMN();
                iMo2059qdMbNW = this.f1493BAnRFn;
            }
            int i7 = iMo2059qdMbNW - iMo2061xJ;
            if (i7 > 0) {
                iMax += i7;
            } else {
                iMax2 -= i7;
            }
        }
        C0132mjFkc c0132mjFkc3 = this.f1506mByQ;
        if (!c0132mjFkc3.f1519ZfxDd ? !this.f1495Gd : this.f1495Gd) {
            i6 = 1;
        }
        mo1269wGscSa(c0146Ucbh, c0148VocHEe, c0132mjFkc3, i6);
        m1729Gd(c0146Ucbh);
        this.f1502diqgf.f1527MiMN = m1305ArO();
        this.f1502diqgf.f1523Dt = c0148VocHEe.m1626KLFTb();
        this.f1502diqgf.f1532qdMbNW = 0;
        C0132mjFkc c0132mjFkc4 = this.f1506mByQ;
        if (c0132mjFkc4.f1519ZfxDd) {
            m1348jpz(c0132mjFkc4);
            C0133wA c0133wA2 = this.f1502diqgf;
            c0133wA2.f1530lgHUyS = iMax;
            m1306CcoH(c0146Ucbh, c0133wA2, c0148VocHEe, false);
            C0133wA c0133wA3 = this.f1502diqgf;
            i2 = c0133wA3.f1522AZxh;
            int i8 = c0133wA3.f1529ZfxDd;
            int i9 = c0133wA3.f1533wA;
            if (i9 > 0) {
                iMax2 += i9;
            }
            m1311Es(this.f1506mByQ);
            C0133wA c0133wA4 = this.f1502diqgf;
            c0133wA4.f1530lgHUyS = iMax2;
            c0133wA4.f1529ZfxDd += c0133wA4.f1526KLFTb;
            m1306CcoH(c0146Ucbh, c0133wA4, c0148VocHEe, false);
            C0133wA c0133wA5 = this.f1502diqgf;
            i = c0133wA5.f1522AZxh;
            int i10 = c0133wA5.f1533wA;
            if (i10 > 0) {
                m1339ZGL(i8, i2);
                C0133wA c0133wA6 = this.f1502diqgf;
                c0133wA6.f1530lgHUyS = i10;
                m1306CcoH(c0146Ucbh, c0133wA6, c0148VocHEe, false);
                i2 = this.f1502diqgf.f1522AZxh;
            }
        } else {
            m1311Es(c0132mjFkc4);
            C0133wA c0133wA7 = this.f1502diqgf;
            c0133wA7.f1530lgHUyS = iMax2;
            m1306CcoH(c0146Ucbh, c0133wA7, c0148VocHEe, false);
            C0133wA c0133wA8 = this.f1502diqgf;
            i = c0133wA8.f1522AZxh;
            int i11 = c0133wA8.f1529ZfxDd;
            int i12 = c0133wA8.f1533wA;
            if (i12 > 0) {
                iMax += i12;
            }
            m1348jpz(this.f1506mByQ);
            C0133wA c0133wA9 = this.f1502diqgf;
            c0133wA9.f1530lgHUyS = iMax;
            c0133wA9.f1529ZfxDd += c0133wA9.f1526KLFTb;
            m1306CcoH(c0146Ucbh, c0133wA9, c0148VocHEe, false);
            C0133wA c0133wA10 = this.f1502diqgf;
            i2 = c0133wA10.f1522AZxh;
            int i13 = c0133wA10.f1533wA;
            if (i13 > 0) {
                m1319LlB(i11, i);
                C0133wA c0133wA11 = this.f1502diqgf;
                c0133wA11.f1530lgHUyS = i13;
                m1306CcoH(c0146Ucbh, c0133wA11, c0148VocHEe, false);
                i = this.f1502diqgf.f1522AZxh;
            }
        }
        if (m1817zvd() > 0) {
            if (this.f1495Gd ^ this.f1496HGpJ) {
                int iM1323Mpf2 = m1323Mpf(i, c0146Ucbh, c0148VocHEe, true);
                i3 = i2 + iM1323Mpf2;
                i4 = i + iM1323Mpf2;
                iM1323Mpf = m1314Hk(i3, c0146Ucbh, c0148VocHEe, false);
            } else {
                int iM1314Hk = m1314Hk(i2, c0146Ucbh, c0148VocHEe, true);
                i3 = i2 + iM1314Hk;
                i4 = i + iM1314Hk;
                iM1323Mpf = m1323Mpf(i4, c0146Ucbh, c0148VocHEe, false);
            }
            i2 = i3 + iM1323Mpf;
            i = i4 + iM1323Mpf;
        }
        m1355peCqC(c0146Ucbh, c0148VocHEe, i2, i);
        if (c0148VocHEe.m1626KLFTb()) {
            this.f1506mByQ.m1371KLFTb();
        } else {
            this.f1503eyqo.m2052Pq();
        }
        this.f1500Ucbh = this.f1496HGpJ;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: diqgf */
    public int mo1249diqgf(RecyclerView.C0148VocHEe c0148VocHEe) {
        return m1312HExgdj(c0148VocHEe);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: dkKKW */
    public Parcelable mo1343dkKKW() {
        if (this.f1508wJVbdd != null) {
            return new C0131ZfxDd(this.f1508wJVbdd);
        }
        C0131ZfxDd c0131ZfxDd = new C0131ZfxDd();
        if (m1817zvd() > 0) {
            m1358qrxT();
            boolean z = this.f1500Ucbh ^ this.f1495Gd;
            c0131ZfxDd.f1516wA = z;
            if (z) {
                View viewM1354oJ = m1354oJ();
                c0131ZfxDd.f1514AZxh = this.f1503eyqo.mo2059qdMbNW() - this.f1503eyqo.mo2055ZfxDd(viewM1354oJ);
                c0131ZfxDd.f1515mjFkc = m1799tQ(viewM1354oJ);
            } else {
                View viewM1341bWIyu = m1341bWIyu();
                c0131ZfxDd.f1515mjFkc = m1799tQ(viewM1341bWIyu);
                c0131ZfxDd.f1514AZxh = this.f1503eyqo.mo2061xJ(viewM1341bWIyu) - this.f1503eyqo.mo2051MiMN();
            }
        } else {
            c0131ZfxDd.m1366AZxh();
        }
        return c0131ZfxDd;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: eyqo */
    public int mo1344eyqo(RecyclerView.C0148VocHEe c0148VocHEe) {
        return m1353np(c0148VocHEe);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: fehf */
    public void mo1345fehf(int i, RecyclerView.AbstractC0159qGY.wA wAVar) {
        boolean z;
        int i2;
        C0131ZfxDd c0131ZfxDd = this.f1508wJVbdd;
        if (c0131ZfxDd == null || !c0131ZfxDd.m1367mjFkc()) {
            m1327RWb();
            z = this.f1495Gd;
            i2 = this.f1501VocHEe;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            C0131ZfxDd c0131ZfxDd2 = this.f1508wJVbdd;
            z = c0131ZfxDd2.f1516wA;
            i2 = c0131ZfxDd2.f1515mjFkc;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.f1497Ne && i2 >= 0 && i2 < i; i4++) {
            wAVar.mo1300mjFkc(i2, 0);
            i2 += i3;
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: gtr */
    public View mo1255gtr(View view, int i, RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        int iM1318KSf;
        m1327RWb();
        if (m1817zvd() == 0 || (iM1318KSf = m1318KSf(i)) == Integer.MIN_VALUE) {
            return null;
        }
        m1358qrxT();
        m1349kOlLW(iM1318KSf, (int) (this.f1503eyqo.mo2054YoKzxo() * 0.33333334f), false, c0148VocHEe);
        C0133wA c0133wA = this.f1502diqgf;
        c0133wA.f1534xJ = Integer.MIN_VALUE;
        c0133wA.f1531mjFkc = false;
        m1306CcoH(c0146Ucbh, c0133wA, c0148VocHEe, true);
        View viewM1328Rsp = iM1318KSf == -1 ? m1328Rsp() : m1307CqAnRZ();
        View viewM1341bWIyu = iM1318KSf == -1 ? m1341bWIyu() : m1354oJ();
        if (!viewM1341bWIyu.hasFocusable()) {
            return viewM1328Rsp;
        }
        if (viewM1328Rsp == null) {
            return null;
        }
        return viewM1341bWIyu;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: huTpC */
    public int mo1256huTpC(RecyclerView.C0148VocHEe c0148VocHEe) {
        return m1312HExgdj(c0148VocHEe);
    }

    /* renamed from: jTNPnW */
    public int m1346jTNPnW(int i, RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        if (m1817zvd() == 0 || i == 0) {
            return 0;
        }
        m1358qrxT();
        this.f1502diqgf.f1531mjFkc = true;
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        m1349kOlLW(i2, iAbs, true, c0148VocHEe);
        C0133wA c0133wA = this.f1502diqgf;
        int iM1306CcoH = c0133wA.f1534xJ + m1306CcoH(c0146Ucbh, c0133wA, c0148VocHEe, false);
        if (iM1306CcoH < 0) {
            return 0;
        }
        if (iAbs > iM1306CcoH) {
            i = i2 * iM1306CcoH;
        }
        this.f1503eyqo.mo2048IEE(-i);
        this.f1502diqgf.f1524ETF = i;
        return i;
    }

    /* renamed from: jY */
    public boolean m1347jY() {
        return m1764WGXroI() == 1;
    }

    /* renamed from: jpz */
    public final void m1348jpz(C0132mjFkc c0132mjFkc) {
        m1339ZGL(c0132mjFkc.f1517AZxh, c0132mjFkc.f1521wA);
    }

    /* renamed from: kOlLW */
    public final void m1349kOlLW(int i, int i2, boolean z, RecyclerView.C0148VocHEe c0148VocHEe) {
        int iMo2051MiMN;
        this.f1502diqgf.f1527MiMN = m1305ArO();
        this.f1502diqgf.f1525JHa = i;
        int[] iArr = this.f1494CqaNbM;
        iArr[0] = 0;
        iArr[1] = 0;
        mo1317JOe(c0148VocHEe, iArr);
        int iMax = Math.max(0, this.f1494CqaNbM[0]);
        int iMax2 = Math.max(0, this.f1494CqaNbM[1]);
        boolean z2 = i == 1;
        C0133wA c0133wA = this.f1502diqgf;
        int i3 = z2 ? iMax2 : iMax;
        c0133wA.f1530lgHUyS = i3;
        if (!z2) {
            iMax = iMax2;
        }
        c0133wA.f1532qdMbNW = iMax;
        if (z2) {
            c0133wA.f1530lgHUyS = i3 + this.f1503eyqo.mo2046Dt();
            View viewM1354oJ = m1354oJ();
            C0133wA c0133wA2 = this.f1502diqgf;
            c0133wA2.f1526KLFTb = this.f1495Gd ? -1 : 1;
            int iM1799tQ = m1799tQ(viewM1354oJ);
            C0133wA c0133wA3 = this.f1502diqgf;
            c0133wA2.f1529ZfxDd = iM1799tQ + c0133wA3.f1526KLFTb;
            c0133wA3.f1522AZxh = this.f1503eyqo.mo2055ZfxDd(viewM1354oJ);
            iMo2051MiMN = this.f1503eyqo.mo2055ZfxDd(viewM1354oJ) - this.f1503eyqo.mo2059qdMbNW();
        } else {
            View viewM1341bWIyu = m1341bWIyu();
            this.f1502diqgf.f1530lgHUyS += this.f1503eyqo.mo2051MiMN();
            C0133wA c0133wA4 = this.f1502diqgf;
            c0133wA4.f1526KLFTb = this.f1495Gd ? 1 : -1;
            int iM1799tQ2 = m1799tQ(viewM1341bWIyu);
            C0133wA c0133wA5 = this.f1502diqgf;
            c0133wA4.f1529ZfxDd = iM1799tQ2 + c0133wA5.f1526KLFTb;
            c0133wA5.f1522AZxh = this.f1503eyqo.mo2061xJ(viewM1341bWIyu);
            iMo2051MiMN = (-this.f1503eyqo.mo2061xJ(viewM1341bWIyu)) + this.f1503eyqo.mo2051MiMN();
        }
        C0133wA c0133wA6 = this.f1502diqgf;
        c0133wA6.f1533wA = i2;
        if (z) {
            c0133wA6.f1533wA = i2 - iMo2051MiMN;
        }
        c0133wA6.f1534xJ = iMo2051MiMN;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: kism */
    public boolean mo1350kism() {
        return true;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: lgHUyS */
    public void mo1351lgHUyS(String str) {
        if (this.f1508wJVbdd == null) {
            super.mo1351lgHUyS(str);
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: mByQ */
    public RecyclerView.C0153fehf mo1263mByQ() {
        return new RecyclerView.C0153fehf(-2, -2);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: mPWV */
    public void mo1352mPWV(Parcelable parcelable) {
        if (parcelable instanceof C0131ZfxDd) {
            C0131ZfxDd c0131ZfxDd = (C0131ZfxDd) parcelable;
            this.f1508wJVbdd = c0131ZfxDd;
            if (this.f1501VocHEe != -1) {
                c0131ZfxDd.m1366AZxh();
            }
            m1788mzUGzO();
        }
    }

    /* renamed from: np */
    public final int m1353np(RecyclerView.C0148VocHEe c0148VocHEe) {
        if (m1817zvd() == 0) {
            return 0;
        }
        m1358qrxT();
        return AbstractC0172VA.m1966mjFkc(c0148VocHEe, this.f1503eyqo, m1363xbjHT(!this.f1507vI, true), m1310EoC(!this.f1507vI, true), this, this.f1507vI);
    }

    /* renamed from: oJ */
    public final View m1354oJ() {
        return m1743KLMXS(this.f1495Gd ? 0 : m1817zvd() - 1);
    }

    /* renamed from: pJeaSR */
    public void mo1265pJeaSR(RecyclerView.C0148VocHEe c0148VocHEe, C0133wA c0133wA, RecyclerView.AbstractC0159qGY.wA wAVar) {
        int i = c0133wA.f1529ZfxDd;
        if (i < 0 || i >= c0148VocHEe.m1624AZxh()) {
            return;
        }
        wAVar.mo1300mjFkc(i, Math.max(0, c0133wA.f1534xJ));
    }

    /* renamed from: peCqC */
    public final void m1355peCqC(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, int i, int i2) {
        if (!c0148VocHEe.m1630xJ() || m1817zvd() == 0 || c0148VocHEe.m1626KLFTb() || !mo1231ERt()) {
            return;
        }
        List listM1584ETF = c0146Ucbh.m1584ETF();
        int size = listM1584ETF.size();
        int iM1799tQ = m1799tQ(m1743KLMXS(0));
        int iMo2050KLFTb = 0;
        int iMo2050KLFTb2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView.AbstractC0157mByQ abstractC0157mByQ = (RecyclerView.AbstractC0157mByQ) listM1584ETF.get(i3);
            if (!abstractC0157mByQ.m1692Ucbh()) {
                if ((abstractC0157mByQ.m1688MiMN() < iM1799tQ) != this.f1495Gd) {
                    iMo2050KLFTb += this.f1503eyqo.mo2050KLFTb(abstractC0157mByQ.f1700mjFkc);
                } else {
                    iMo2050KLFTb2 += this.f1503eyqo.mo2050KLFTb(abstractC0157mByQ.f1700mjFkc);
                }
            }
        }
        this.f1502diqgf.f1528VA = listM1584ETF;
        if (iMo2050KLFTb > 0) {
            m1339ZGL(m1799tQ(m1341bWIyu()), i);
            C0133wA c0133wA = this.f1502diqgf;
            c0133wA.f1530lgHUyS = iMo2050KLFTb;
            c0133wA.f1533wA = 0;
            c0133wA.m1379mjFkc();
            m1306CcoH(c0146Ucbh, this.f1502diqgf, c0148VocHEe, false);
        }
        if (iMo2050KLFTb2 > 0) {
            m1319LlB(m1799tQ(m1354oJ()), i2);
            C0133wA c0133wA2 = this.f1502diqgf;
            c0133wA2.f1530lgHUyS = iMo2050KLFTb2;
            c0133wA2.f1533wA = 0;
            c0133wA2.m1379mjFkc();
            m1306CcoH(c0146Ucbh, this.f1502diqgf, c0148VocHEe, false);
        }
        this.f1502diqgf.f1528VA = null;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: qGY */
    public void mo1356qGY(int i, int i2, RecyclerView.C0148VocHEe c0148VocHEe, RecyclerView.AbstractC0159qGY.wA wAVar) {
        if (this.f1499Pq != 0) {
            i = i2;
        }
        if (m1817zvd() == 0 || i == 0) {
            return;
        }
        m1358qrxT();
        m1349kOlLW(i > 0 ? 1 : -1, Math.abs(i), true, c0148VocHEe);
        mo1265pJeaSR(c0148VocHEe, this.f1502diqgf, wAVar);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: qGgY */
    public void mo1357qGgY(RecyclerView recyclerView, RecyclerView.C0148VocHEe c0148VocHEe, int i) {
        C0181xJ c0181xJ = new C0181xJ(recyclerView.getContext());
        c0181xJ.m1843qGY(i);
        m1807vUsV(c0181xJ);
    }

    /* renamed from: qrxT */
    public void m1358qrxT() {
        if (this.f1502diqgf == null) {
            this.f1502diqgf = m1336Vptz();
        }
    }

    /* renamed from: tPvjn */
    public final void m1359tPvjn(RecyclerView.C0146Ucbh c0146Ucbh, C0133wA c0133wA) {
        if (!c0133wA.f1531mjFkc || c0133wA.f1527MiMN) {
            return;
        }
        int i = c0133wA.f1534xJ;
        int i2 = c0133wA.f1532qdMbNW;
        if (c0133wA.f1525JHa == -1) {
            m1324Otxclu(c0146Ucbh, i, i2);
        } else {
            m1325OzIs(c0146Ucbh, i, i2);
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: ui */
    public boolean mo1360ui() {
        return (m1741JrJO() == 1073741824 || m1751Qr() == 1073741824 || !m1749NKyg()) ? false : true;
    }

    /* renamed from: vZ */
    public View m1361vZ(int i, int i2) {
        int i3;
        int i4;
        m1358qrxT();
        if (i2 <= i && i2 >= i) {
            return m1743KLMXS(i);
        }
        if (this.f1503eyqo.mo2061xJ(m1743KLMXS(i)) < this.f1503eyqo.mo2051MiMN()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return this.f1499Pq == 0 ? this.f1712KLFTb.m2063mjFkc(i, i2, i3, i4) : this.f1711JHa.m2063mjFkc(i, i2, i3, i4);
    }

    /* renamed from: wGscSa */
    public void mo1269wGscSa(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, C0132mjFkc c0132mjFkc, int i) {
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: wJVbdd */
    public View mo1362wJVbdd(int i) {
        int iM1817zvd = m1817zvd();
        if (iM1817zvd == 0) {
            return null;
        }
        int iM1799tQ = i - m1799tQ(m1743KLMXS(0));
        if (iM1799tQ >= 0 && iM1799tQ < iM1817zvd) {
            View viewM1743KLMXS = m1743KLMXS(iM1799tQ);
            if (m1799tQ(viewM1743KLMXS) == i) {
                return viewM1743KLMXS;
            }
        }
        return super.mo1362wJVbdd(i);
    }

    /* renamed from: xBQUgd */
    public void mo1270xBQUgd(boolean z) {
        mo1351lgHUyS(null);
        if (this.f1496HGpJ == z) {
            return;
        }
        this.f1496HGpJ = z;
        m1788mzUGzO();
    }

    /* renamed from: xbjHT */
    public View m1363xbjHT(boolean z, boolean z2) {
        return this.f1495Gd ? m1330TvfBiy(m1817zvd() - 1, -1, z, z2) : m1330TvfBiy(0, m1817zvd(), z, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0077  */
    /* renamed from: xfXeiC */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View mo1274xfXeiC(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, boolean z, boolean z2) {
        int i;
        int iM1817zvd;
        int i2;
        m1358qrxT();
        int iM1817zvd2 = m1817zvd();
        if (z2) {
            iM1817zvd = m1817zvd() - 1;
            i = -1;
            i2 = -1;
        } else {
            i = iM1817zvd2;
            iM1817zvd = 0;
            i2 = 1;
        }
        int iM1624AZxh = c0148VocHEe.m1624AZxh();
        int iMo2051MiMN = this.f1503eyqo.mo2051MiMN();
        int iMo2059qdMbNW = this.f1503eyqo.mo2059qdMbNW();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (iM1817zvd != i) {
            View viewM1743KLMXS = m1743KLMXS(iM1817zvd);
            int iM1799tQ = m1799tQ(viewM1743KLMXS);
            int iMo2061xJ = this.f1503eyqo.mo2061xJ(viewM1743KLMXS);
            int iMo2055ZfxDd = this.f1503eyqo.mo2055ZfxDd(viewM1743KLMXS);
            if (iM1799tQ >= 0 && iM1799tQ < iM1624AZxh) {
                if (!((RecyclerView.C0153fehf) viewM1743KLMXS.getLayoutParams()).m1654wA()) {
                    boolean z3 = iMo2055ZfxDd <= iMo2051MiMN && iMo2061xJ < iMo2051MiMN;
                    boolean z4 = iMo2061xJ >= iMo2059qdMbNW && iMo2055ZfxDd > iMo2059qdMbNW;
                    if (!z3 && !z4) {
                        return viewM1743KLMXS;
                    }
                    if (z) {
                        if (z4) {
                            view2 = viewM1743KLMXS;
                        } else if (view == null) {
                            view = viewM1743KLMXS;
                        }
                    } else if (!z3) {
                        if (view == null) {
                        }
                    }
                } else if (view3 == null) {
                    view3 = viewM1743KLMXS;
                }
            }
            iM1817zvd += i2;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    /* renamed from: zPp */
    public int m1364zPp() {
        View viewM1330TvfBiy = m1330TvfBiy(0, m1817zvd(), false, true);
        if (viewM1330TvfBiy == null) {
            return -1;
        }
        return m1799tQ(viewM1330TvfBiy);
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1499Pq = 1;
        this.f1504huTpC = false;
        this.f1495Gd = false;
        this.f1496HGpJ = false;
        this.f1507vI = true;
        this.f1501VocHEe = -1;
        this.f1493BAnRFn = Integer.MIN_VALUE;
        this.f1508wJVbdd = null;
        this.f1506mByQ = new C0132mjFkc();
        this.f1498OjSQV = new C0130AZxh();
        this.f1497Ne = 2;
        this.f1494CqaNbM = new int[2];
        RecyclerView.AbstractC0159qGY.ZfxDd zfxDdM1718yfx = RecyclerView.AbstractC0159qGY.m1718yfx(context, attributeSet, i, i2);
        m1309EeoThB(zfxDdM1718yfx.f1728mjFkc);
        m1342cdjp(zfxDdM1718yfx.f1729wA);
        mo1270xBQUgd(zfxDdM1718yfx.f1727ZfxDd);
    }
}
