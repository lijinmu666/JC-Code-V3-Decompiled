package androidx.recyclerview.p023widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.recyclerview.p023widget.LinearLayoutManager;
import androidx.recyclerview.p023widget.RecyclerView;
import java.util.Arrays;
import p131o.C2971Ucbh;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: KLMXS */
    public int f1454KLMXS;

    /* renamed from: NPj */
    public AbstractC0127wA f1455NPj;

    /* renamed from: Vnb */
    public final SparseIntArray f1456Vnb;

    /* renamed from: cMLeY */
    public View[] f1457cMLeY;

    /* renamed from: oCFDzJ */
    public boolean f1458oCFDzJ;

    /* renamed from: rWxwaT */
    public final SparseIntArray f1459rWxwaT;

    /* renamed from: vadzgd */
    public final Rect f1460vadzgd;

    /* renamed from: xrEuO */
    public boolean f1461xrEuO;

    /* renamed from: zvd */
    public int[] f1462zvd;

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$mjFkc */
    public static final class C0126mjFkc extends AbstractC0127wA {
        @Override // androidx.recyclerview.p023widget.GridLayoutManager.AbstractC0127wA
        /* renamed from: JHa */
        public int mo1277JHa(int i) {
            return 1;
        }

        @Override // androidx.recyclerview.p023widget.GridLayoutManager.AbstractC0127wA
        /* renamed from: KLFTb */
        public int mo1278KLFTb(int i, int i2) {
            return i % i2;
        }
    }

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$wA */
    public static abstract class AbstractC0127wA {

        /* renamed from: mjFkc */
        public final SparseIntArray f1467mjFkc = new SparseIntArray();

        /* renamed from: AZxh */
        public final SparseIntArray f1465AZxh = new SparseIntArray();

        /* renamed from: wA */
        public boolean f1468wA = false;

        /* renamed from: ZfxDd */
        public boolean f1466ZfxDd = false;

        /* renamed from: mjFkc */
        public static int m1279mjFkc(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        /* renamed from: AZxh */
        public int m1280AZxh(int i, int i2) {
            if (!this.f1466ZfxDd) {
                return m1281ZfxDd(i, i2);
            }
            int i3 = this.f1465AZxh.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iM1281ZfxDd = m1281ZfxDd(i, i2);
            this.f1465AZxh.put(i, iM1281ZfxDd);
            return iM1281ZfxDd;
        }

        /* renamed from: JHa */
        public abstract int mo1277JHa(int i);

        /* renamed from: KLFTb */
        public abstract int mo1278KLFTb(int i, int i2);

        /* renamed from: ZfxDd */
        public int m1281ZfxDd(int i, int i2) {
            int i3;
            int i4;
            int iM1283wA;
            int iM1279mjFkc;
            if (!this.f1466ZfxDd || (iM1279mjFkc = m1279mjFkc(this.f1465AZxh, i)) == -1) {
                i3 = 0;
                i4 = 0;
                iM1283wA = 0;
            } else {
                i3 = this.f1465AZxh.get(iM1279mjFkc);
                i4 = iM1279mjFkc + 1;
                iM1283wA = m1283wA(iM1279mjFkc, i2) + mo1277JHa(iM1279mjFkc);
                if (iM1283wA == i2) {
                    i3++;
                    iM1283wA = 0;
                }
            }
            int iMo1277JHa = mo1277JHa(i);
            while (i4 < i) {
                int iMo1277JHa2 = mo1277JHa(i4);
                iM1283wA += iMo1277JHa2;
                if (iM1283wA == i2) {
                    i3++;
                    iM1283wA = 0;
                } else if (iM1283wA > i2) {
                    i3++;
                    iM1283wA = iMo1277JHa2;
                }
                i4++;
            }
            return iM1283wA + iMo1277JHa > i2 ? i3 + 1 : i3;
        }

        /* renamed from: lgHUyS */
        public void m1282lgHUyS() {
            this.f1467mjFkc.clear();
        }

        /* renamed from: wA */
        public int m1283wA(int i, int i2) {
            if (!this.f1468wA) {
                return mo1278KLFTb(i, i2);
            }
            int i3 = this.f1467mjFkc.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iMo1278KLFTb = mo1278KLFTb(i, i2);
            this.f1467mjFkc.put(i, iMo1278KLFTb);
            return iMo1278KLFTb;
        }

        /* renamed from: xJ */
        public void m1284xJ() {
            this.f1465AZxh.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1461xrEuO = false;
        this.f1454KLMXS = -1;
        this.f1459rWxwaT = new SparseIntArray();
        this.f1456Vnb = new SparseIntArray();
        this.f1455NPj = new C0126mjFkc();
        this.f1460vadzgd = new Rect();
        m1262lEKdq(RecyclerView.AbstractC0159qGY.m1718yfx(context, attributeSet, i, i2).f1726AZxh);
    }

    /* renamed from: qtZIjO */
    public static int[] m1228qtZIjO(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    /* renamed from: BABY */
    public final void m1229BABY() {
        int iM1817zvd = m1817zvd();
        for (int i = 0; i < iM1817zvd; i++) {
            C0125AZxh c0125AZxh = (C0125AZxh) m1743KLMXS(i).getLayoutParams();
            int iM1653mjFkc = c0125AZxh.m1653mjFkc();
            this.f1459rWxwaT.put(iM1653mjFkc, c0125AZxh.m1275JHa());
            this.f1456Vnb.put(iM1653mjFkc, c0125AZxh.m1276KLFTb());
        }
    }

    @Override // androidx.recyclerview.p023widget.LinearLayoutManager, androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: BxruE */
    public int mo1230BxruE(int i, RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        m1259joWJO();
        m1235KbE();
        return super.mo1230BxruE(i, c0146Ucbh, c0148VocHEe);
    }

    @Override // androidx.recyclerview.p023widget.LinearLayoutManager, androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: ERt */
    public boolean mo1231ERt() {
        return this.f1508wJVbdd == null && !this.f1461xrEuO;
    }

    /* renamed from: EcuP */
    public final int m1232EcuP(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, int i) {
        if (!c0148VocHEe.m1626KLFTb()) {
            return this.f1455NPj.mo1277JHa(i);
        }
        int i2 = this.f1459rWxwaT.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iM1588JHa = c0146Ucbh.m1588JHa(i);
        if (iM1588JHa != -1) {
            return this.f1455NPj.mo1277JHa(iM1588JHa);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: FbxKQm */
    public void mo1233FbxKQm(RecyclerView recyclerView) {
        this.f1455NPj.m1282lgHUyS();
        this.f1455NPj.m1284xJ();
    }

    /* renamed from: GEj */
    public final void m1234GEj(View view, int i, int i2, boolean z) {
        RecyclerView.C0153fehf c0153fehf = (RecyclerView.C0153fehf) view.getLayoutParams();
        if (z ? m1801tpGcn(view, i, i2, c0153fehf) : m1814yP(view, i, i2, c0153fehf)) {
            view.measure(i, i2);
        }
    }

    /* renamed from: KbE */
    public final void m1235KbE() {
        View[] viewArr = this.f1457cMLeY;
        if (viewArr == null || viewArr.length != this.f1454KLMXS) {
            this.f1457cMLeY = new View[this.f1454KLMXS];
        }
    }

    /* renamed from: MlqoT */
    public int m1236MlqoT(int i, int i2) {
        if (this.f1499Pq != 1 || !m1347jY()) {
            int[] iArr = this.f1462zvd;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.f1462zvd;
        int i3 = this.f1454KLMXS;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: NPj */
    public int mo1237NPj(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        if (this.f1499Pq == 1) {
            return this.f1454KLMXS;
        }
        if (c0148VocHEe.m1624AZxh() < 1) {
            return 0;
        }
        return m1267sZ(c0146Ucbh, c0148VocHEe, c0148VocHEe.m1624AZxh() - 1) + 1;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Ne */
    public RecyclerView.C0153fehf mo1238Ne(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0125AZxh((ViewGroup.MarginLayoutParams) layoutParams) : new C0125AZxh(layoutParams);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: OjSQV */
    public RecyclerView.C0153fehf mo1239OjSQV(Context context, AttributeSet attributeSet) {
        return new C0125AZxh(context, attributeSet);
    }

    @Override // androidx.recyclerview.p023widget.LinearLayoutManager, androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Pq */
    public int mo1240Pq(RecyclerView.C0148VocHEe c0148VocHEe) {
        return this.f1458oCFDzJ ? m1254gjvQ(c0148VocHEe) : super.mo1240Pq(c0148VocHEe);
    }

    @Override // androidx.recyclerview.p023widget.LinearLayoutManager, androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: QyqF */
    public int mo1241QyqF(int i, RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        m1259joWJO();
        m1235KbE();
        return super.mo1241QyqF(i, c0146Ucbh, c0148VocHEe);
    }

    @Override // androidx.recyclerview.p023widget.LinearLayoutManager
    /* renamed from: Sx */
    public void mo1242Sx(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, LinearLayoutManager.C0133wA c0133wA, LinearLayoutManager.C0130AZxh c0130AZxh) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int iMo2049JHa;
        int iMo2049JHa2;
        int iMo2049JHa3;
        int i8;
        int iM1716cMLeY;
        int iM1716cMLeY2;
        View viewM1378ZfxDd;
        int iMo2053VA = this.f1503eyqo.mo2053VA();
        boolean z = iMo2053VA != 1073741824;
        int i9 = m1817zvd() > 0 ? this.f1462zvd[this.f1454KLMXS] : 0;
        if (z) {
            m1259joWJO();
        }
        boolean z2 = c0133wA.f1526KLFTb == 1;
        int iM1247Zerm = this.f1454KLMXS;
        if (!z2) {
            iM1247Zerm = m1247Zerm(c0146Ucbh, c0148VocHEe, c0133wA.f1529ZfxDd) + m1232EcuP(c0146Ucbh, c0148VocHEe, c0133wA.f1529ZfxDd);
        }
        int i10 = 0;
        while (i10 < this.f1454KLMXS && c0133wA.m1380wA(c0148VocHEe) && iM1247Zerm > 0) {
            int i11 = c0133wA.f1529ZfxDd;
            int iM1232EcuP = m1232EcuP(c0146Ucbh, c0148VocHEe, i11);
            if (iM1232EcuP > this.f1454KLMXS) {
                throw new IllegalArgumentException("Item at position " + i11 + " requires " + iM1232EcuP + " spans but GridLayoutManager has only " + this.f1454KLMXS + " spans.");
            }
            iM1247Zerm -= iM1232EcuP;
            if (iM1247Zerm < 0 || (viewM1378ZfxDd = c0133wA.m1378ZfxDd(c0146Ucbh)) == null) {
                break;
            }
            this.f1457cMLeY[i10] = viewM1378ZfxDd;
            i10++;
        }
        if (i10 == 0) {
            c0130AZxh.f1509AZxh = true;
            return;
        }
        m1250eEOGOh(c0146Ucbh, c0148VocHEe, i10, z2);
        float f = 0.0f;
        int i12 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            View view = this.f1457cMLeY[i13];
            if (c0133wA.f1528VA == null) {
                if (z2) {
                    m1742KLFTb(view);
                } else {
                    m1736JHa(view, 0);
                }
            } else if (z2) {
                m1810wA(view);
            } else {
                m1772ZfxDd(view, 0);
            }
            m1725ETF(view, this.f1460vadzgd);
            m1251eHig(view, iMo2053VA, false);
            int iMo2050KLFTb = this.f1503eyqo.mo2050KLFTb(view);
            if (iMo2050KLFTb > i12) {
                i12 = iMo2050KLFTb;
            }
            float fMo2049JHa = (this.f1503eyqo.mo2049JHa(view) * 1.0f) / ((C0125AZxh) view.getLayoutParams()).f1463JHa;
            if (fMo2049JHa > f) {
                f = fMo2049JHa;
            }
        }
        if (z) {
            m1264pCi(f, i9);
            i12 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                View view2 = this.f1457cMLeY[i14];
                m1251eHig(view2, 1073741824, true);
                int iMo2050KLFTb2 = this.f1503eyqo.mo2050KLFTb(view2);
                if (iMo2050KLFTb2 > i12) {
                    i12 = iMo2050KLFTb2;
                }
            }
        }
        for (int i15 = 0; i15 < i10; i15++) {
            View view3 = this.f1457cMLeY[i15];
            if (this.f1503eyqo.mo2050KLFTb(view3) != i12) {
                C0125AZxh c0125AZxh = (C0125AZxh) view3.getLayoutParams();
                Rect rect = c0125AZxh.f1675AZxh;
                int i16 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) c0125AZxh).topMargin + ((ViewGroup.MarginLayoutParams) c0125AZxh).bottomMargin;
                int i17 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) c0125AZxh).leftMargin + ((ViewGroup.MarginLayoutParams) c0125AZxh).rightMargin;
                int iM1236MlqoT = m1236MlqoT(c0125AZxh.f1464KLFTb, c0125AZxh.f1463JHa);
                if (this.f1499Pq == 1) {
                    iM1716cMLeY2 = RecyclerView.AbstractC0159qGY.m1716cMLeY(iM1236MlqoT, 1073741824, i17, ((ViewGroup.MarginLayoutParams) c0125AZxh).width, false);
                    iM1716cMLeY = View.MeasureSpec.makeMeasureSpec(i12 - i16, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12 - i17, 1073741824);
                    iM1716cMLeY = RecyclerView.AbstractC0159qGY.m1716cMLeY(iM1236MlqoT, 1073741824, i16, ((ViewGroup.MarginLayoutParams) c0125AZxh).height, false);
                    iM1716cMLeY2 = iMakeMeasureSpec;
                }
                m1234GEj(view3, iM1716cMLeY2, iM1716cMLeY, true);
            }
        }
        c0130AZxh.f1511mjFkc = i12;
        if (this.f1499Pq == 1) {
            if (c0133wA.f1525JHa == -1) {
                i6 = c0133wA.f1522AZxh;
                i8 = i6 - i12;
            } else {
                i8 = c0133wA.f1522AZxh;
                i6 = i8 + i12;
            }
            i4 = i8;
            i5 = 0;
            i3 = 0;
        } else {
            if (c0133wA.f1525JHa == -1) {
                i2 = c0133wA.f1522AZxh;
                i = i2 - i12;
            } else {
                i = c0133wA.f1522AZxh;
                i2 = i + i12;
            }
            i3 = i;
            i4 = 0;
            i5 = i2;
            i6 = 0;
        }
        int i18 = 0;
        while (i18 < i10) {
            View view4 = this.f1457cMLeY[i18];
            C0125AZxh c0125AZxh2 = (C0125AZxh) view4.getLayoutParams();
            if (this.f1499Pq == 1) {
                if (m1347jY()) {
                    int iM1783jm = m1783jm() + this.f1462zvd[this.f1454KLMXS - c0125AZxh2.f1464KLFTb];
                    iMo2049JHa3 = i6;
                    iMo2049JHa = iM1783jm;
                    iMo2049JHa2 = iM1783jm - this.f1503eyqo.mo2049JHa(view4);
                } else {
                    int iM1783jm2 = m1783jm() + this.f1462zvd[c0125AZxh2.f1464KLFTb];
                    iMo2049JHa3 = i6;
                    iMo2049JHa2 = iM1783jm2;
                    iMo2049JHa = this.f1503eyqo.mo2049JHa(view4) + iM1783jm2;
                }
                i7 = i4;
            } else {
                int iM1777dm = m1777dm() + this.f1462zvd[c0125AZxh2.f1464KLFTb];
                i7 = iM1777dm;
                iMo2049JHa = i5;
                iMo2049JHa2 = i3;
                iMo2049JHa3 = this.f1503eyqo.mo2049JHa(view4) + iM1777dm;
            }
            m1767XFUzSY(view4, iMo2049JHa2, i7, iMo2049JHa, iMo2049JHa3);
            if (c0125AZxh2.m1654wA() || c0125AZxh2.m1651AZxh()) {
                c0130AZxh.f1512wA = true;
            }
            c0130AZxh.f1510ZfxDd |= view4.hasFocusable();
            i18++;
            i6 = iMo2049JHa3;
            i5 = iMo2049JHa;
            i3 = iMo2049JHa2;
            i4 = i7;
        }
        Arrays.fill(this.f1457cMLeY, (Object) null);
    }

    @Override // androidx.recyclerview.p023widget.LinearLayoutManager, androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Ucbh */
    public int mo1243Ucbh(RecyclerView.C0148VocHEe c0148VocHEe) {
        return this.f1458oCFDzJ ? m1254gjvQ(c0148VocHEe) : super.mo1243Ucbh(c0148VocHEe);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: XgAT */
    public void mo1244XgAT(RecyclerView recyclerView, int i, int i2) {
        this.f1455NPj.m1282lgHUyS();
        this.f1455NPj.m1284xJ();
    }

    @Override // androidx.recyclerview.p023widget.LinearLayoutManager, androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Xxz */
    public void mo1245Xxz(RecyclerView.C0148VocHEe c0148VocHEe) {
        super.mo1245Xxz(c0148VocHEe);
        this.f1461xrEuO = false;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: YoKzxo */
    public boolean mo1246YoKzxo(RecyclerView.C0153fehf c0153fehf) {
        return c0153fehf instanceof C0125AZxh;
    }

    /* renamed from: Zerm */
    public final int m1247Zerm(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, int i) {
        if (!c0148VocHEe.m1626KLFTb()) {
            return this.f1455NPj.m1283wA(i, this.f1454KLMXS);
        }
        int i2 = this.f1456Vnb.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iM1588JHa = c0146Ucbh.m1588JHa(i);
        if (iM1588JHa != -1) {
            return this.f1455NPj.m1283wA(iM1588JHa, this.f1454KLMXS);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    @Override // androidx.recyclerview.p023widget.LinearLayoutManager, androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: dGDT */
    public void mo1248dGDT(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        if (c0148VocHEe.m1626KLFTb()) {
            m1229BABY();
        }
        super.mo1248dGDT(c0146Ucbh, c0148VocHEe);
        m1273xVYW();
    }

    @Override // androidx.recyclerview.p023widget.LinearLayoutManager, androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: diqgf */
    public int mo1249diqgf(RecyclerView.C0148VocHEe c0148VocHEe) {
        return this.f1458oCFDzJ ? m1261kw(c0148VocHEe) : super.mo1249diqgf(c0148VocHEe);
    }

    /* renamed from: eEOGOh */
    public final void m1250eEOGOh(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        if (z) {
            i4 = 1;
            i3 = i;
            i2 = 0;
        } else {
            i2 = i - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View view = this.f1457cMLeY[i2];
            C0125AZxh c0125AZxh = (C0125AZxh) view.getLayoutParams();
            int iM1232EcuP = m1232EcuP(c0146Ucbh, c0148VocHEe, m1799tQ(view));
            c0125AZxh.f1463JHa = iM1232EcuP;
            c0125AZxh.f1464KLFTb = i5;
            i5 += iM1232EcuP;
            i2 += i4;
        }
    }

    /* renamed from: eHig */
    public final void m1251eHig(View view, int i, boolean z) {
        int iM1716cMLeY;
        int iM1716cMLeY2;
        C0125AZxh c0125AZxh = (C0125AZxh) view.getLayoutParams();
        Rect rect = c0125AZxh.f1675AZxh;
        int i2 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) c0125AZxh).topMargin + ((ViewGroup.MarginLayoutParams) c0125AZxh).bottomMargin;
        int i3 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) c0125AZxh).leftMargin + ((ViewGroup.MarginLayoutParams) c0125AZxh).rightMargin;
        int iM1236MlqoT = m1236MlqoT(c0125AZxh.f1464KLFTb, c0125AZxh.f1463JHa);
        if (this.f1499Pq == 1) {
            iM1716cMLeY2 = RecyclerView.AbstractC0159qGY.m1716cMLeY(iM1236MlqoT, i, i3, ((ViewGroup.MarginLayoutParams) c0125AZxh).width, false);
            iM1716cMLeY = RecyclerView.AbstractC0159qGY.m1716cMLeY(this.f1503eyqo.mo2054YoKzxo(), m1741JrJO(), i2, ((ViewGroup.MarginLayoutParams) c0125AZxh).height, true);
        } else {
            int iM1716cMLeY3 = RecyclerView.AbstractC0159qGY.m1716cMLeY(iM1236MlqoT, i, i2, ((ViewGroup.MarginLayoutParams) c0125AZxh).height, false);
            int iM1716cMLeY4 = RecyclerView.AbstractC0159qGY.m1716cMLeY(this.f1503eyqo.mo2054YoKzxo(), m1751Qr(), i3, ((ViewGroup.MarginLayoutParams) c0125AZxh).width, true);
            iM1716cMLeY = iM1716cMLeY3;
            iM1716cMLeY2 = iM1716cMLeY4;
        }
        m1234GEj(view, iM1716cMLeY2, iM1716cMLeY, z);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: eQ */
    public void mo1252eQ(RecyclerView recyclerView, int i, int i2) {
        this.f1455NPj.m1282lgHUyS();
        this.f1455NPj.m1284xJ();
    }

    /* renamed from: gJsSk */
    public final void m1253gJsSk(int i) {
        this.f1462zvd = m1228qtZIjO(this.f1462zvd, this.f1454KLMXS, i);
    }

    /* renamed from: gjvQ */
    public final int m1254gjvQ(RecyclerView.C0148VocHEe c0148VocHEe) {
        if (m1817zvd() != 0 && c0148VocHEe.m1624AZxh() != 0) {
            m1358qrxT();
            boolean zM1333UOnCkw = m1333UOnCkw();
            View viewM1363xbjHT = m1363xbjHT(!zM1333UOnCkw, true);
            View viewM1310EoC = m1310EoC(!zM1333UOnCkw, true);
            if (viewM1363xbjHT != null && viewM1310EoC != null) {
                int iM1280AZxh = this.f1455NPj.m1280AZxh(m1799tQ(viewM1363xbjHT), this.f1454KLMXS);
                int iM1280AZxh2 = this.f1455NPj.m1280AZxh(m1799tQ(viewM1310EoC), this.f1454KLMXS);
                int iMax = this.f1495Gd ? Math.max(0, ((this.f1455NPj.m1280AZxh(c0148VocHEe.m1624AZxh() - 1, this.f1454KLMXS) + 1) - Math.max(iM1280AZxh, iM1280AZxh2)) - 1) : Math.max(0, Math.min(iM1280AZxh, iM1280AZxh2));
                if (zM1333UOnCkw) {
                    return Math.round((iMax * (Math.abs(this.f1503eyqo.mo2055ZfxDd(viewM1310EoC) - this.f1503eyqo.mo2061xJ(viewM1363xbjHT)) / ((this.f1455NPj.m1280AZxh(m1799tQ(viewM1310EoC), this.f1454KLMXS) - this.f1455NPj.m1280AZxh(m1799tQ(viewM1363xbjHT), this.f1454KLMXS)) + 1))) + (this.f1503eyqo.mo2051MiMN() - this.f1503eyqo.mo2061xJ(viewM1363xbjHT)));
                }
                return iMax;
            }
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d1, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010f  */
    @Override // androidx.recyclerview.p023widget.LinearLayoutManager, androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: gtr */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View mo1255gtr(View view, int i, RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        int iM1817zvd;
        int i2;
        int iM1817zvd2;
        View view2;
        View view3;
        int i3;
        int i4;
        int i5;
        int i6;
        RecyclerView.C0146Ucbh c0146Ucbh2 = c0146Ucbh;
        RecyclerView.C0148VocHEe c0148VocHEe2 = c0148VocHEe;
        View viewM1786lB = m1786lB(view);
        View view4 = null;
        if (viewM1786lB == null) {
            return null;
        }
        C0125AZxh c0125AZxh = (C0125AZxh) viewM1786lB.getLayoutParams();
        int i7 = c0125AZxh.f1464KLFTb;
        int i8 = c0125AZxh.f1463JHa + i7;
        if (super.mo1255gtr(view, i, c0146Ucbh, c0148VocHEe) == null) {
            return null;
        }
        if ((m1318KSf(i) == 1) != this.f1495Gd) {
            iM1817zvd2 = m1817zvd() - 1;
            iM1817zvd = -1;
            i2 = -1;
        } else {
            iM1817zvd = m1817zvd();
            i2 = 1;
            iM1817zvd2 = 0;
        }
        boolean z = this.f1499Pq == 1 && m1347jY();
        int iM1267sZ = m1267sZ(c0146Ucbh2, c0148VocHEe2, iM1817zvd2);
        int i9 = -1;
        int i10 = -1;
        int iMin = 0;
        int iMin2 = 0;
        int i11 = iM1817zvd2;
        View view5 = null;
        while (i11 != iM1817zvd) {
            int iM1267sZ2 = m1267sZ(c0146Ucbh2, c0148VocHEe2, i11);
            View viewM1743KLMXS = m1743KLMXS(i11);
            if (viewM1743KLMXS == viewM1786lB) {
                break;
            }
            if (!viewM1743KLMXS.hasFocusable() || iM1267sZ2 == iM1267sZ) {
                C0125AZxh c0125AZxh2 = (C0125AZxh) viewM1743KLMXS.getLayoutParams();
                int i12 = c0125AZxh2.f1464KLFTb;
                view2 = viewM1786lB;
                int i13 = c0125AZxh2.f1463JHa + i12;
                if (viewM1743KLMXS.hasFocusable() && i12 == i7 && i13 == i8) {
                    return viewM1743KLMXS;
                }
                if (!(viewM1743KLMXS.hasFocusable() && view4 == null) && (viewM1743KLMXS.hasFocusable() || view5 != null)) {
                    view3 = view5;
                    int iMin3 = Math.min(i13, i8) - Math.max(i12, i7);
                    if (!viewM1743KLMXS.hasFocusable()) {
                        if (view4 == null) {
                            i3 = iMin;
                            i4 = iM1817zvd;
                            if (m1769XbiWeM(viewM1743KLMXS, false, true)) {
                                i5 = iMin2;
                                if (iMin3 > i5) {
                                    i6 = i10;
                                } else if (iMin3 == i5) {
                                    i6 = i10;
                                    if (z == (i12 > i6)) {
                                    }
                                    i11 += i2;
                                    c0146Ucbh2 = c0146Ucbh;
                                    c0148VocHEe2 = c0148VocHEe;
                                    viewM1786lB = view2;
                                    iM1817zvd = i4;
                                } else {
                                    i6 = i10;
                                }
                                if (viewM1743KLMXS.hasFocusable()) {
                                    int i14 = c0125AZxh2.f1464KLFTb;
                                    iMin2 = Math.min(i13, i8) - Math.max(i12, i7);
                                    i10 = i14;
                                    iMin = i3;
                                    view5 = viewM1743KLMXS;
                                } else {
                                    i9 = c0125AZxh2.f1464KLFTb;
                                    i10 = i6;
                                    iMin2 = i5;
                                    view5 = view3;
                                    view4 = viewM1743KLMXS;
                                    iMin = Math.min(i13, i8) - Math.max(i12, i7);
                                }
                                i11 += i2;
                                c0146Ucbh2 = c0146Ucbh;
                                c0148VocHEe2 = c0148VocHEe;
                                viewM1786lB = view2;
                                iM1817zvd = i4;
                            }
                            i10 = i6;
                            iMin2 = i5;
                            iMin = i3;
                            view5 = view3;
                            i11 += i2;
                            c0146Ucbh2 = c0146Ucbh;
                            c0148VocHEe2 = c0148VocHEe;
                            viewM1786lB = view2;
                            iM1817zvd = i4;
                        }
                        i6 = i10;
                        i5 = iMin2;
                        i10 = i6;
                        iMin2 = i5;
                        iMin = i3;
                        view5 = view3;
                        i11 += i2;
                        c0146Ucbh2 = c0146Ucbh;
                        c0148VocHEe2 = c0148VocHEe;
                        viewM1786lB = view2;
                        iM1817zvd = i4;
                    } else if (iMin3 <= iMin) {
                        if (iMin3 == iMin) {
                        }
                    }
                } else {
                    view3 = view5;
                }
                i3 = iMin;
                i4 = iM1817zvd;
                i6 = i10;
                i5 = iMin2;
                if (viewM1743KLMXS.hasFocusable()) {
                }
                i11 += i2;
                c0146Ucbh2 = c0146Ucbh;
                c0148VocHEe2 = c0148VocHEe;
                viewM1786lB = view2;
                iM1817zvd = i4;
            } else {
                if (view4 != null) {
                    break;
                }
                view2 = viewM1786lB;
                view3 = view5;
            }
            i3 = iMin;
            i4 = iM1817zvd;
            i6 = i10;
            i5 = iMin2;
            i10 = i6;
            iMin2 = i5;
            iMin = i3;
            view5 = view3;
            i11 += i2;
            c0146Ucbh2 = c0146Ucbh;
            c0148VocHEe2 = c0148VocHEe;
            viewM1786lB = view2;
            iM1817zvd = i4;
        }
        return view4 != null ? view4 : view5;
    }

    @Override // androidx.recyclerview.p023widget.LinearLayoutManager, androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: huTpC */
    public int mo1256huTpC(RecyclerView.C0148VocHEe c0148VocHEe) {
        return this.f1458oCFDzJ ? m1261kw(c0148VocHEe) : super.mo1256huTpC(c0148VocHEe);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: hvGY */
    public void mo1257hvGY(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, C2971Ucbh c2971Ucbh) {
        super.mo1257hvGY(c0146Ucbh, c0148VocHEe, c2971Ucbh);
        c2971Ucbh.m10572bbzow(GridView.class.getName());
    }

    /* renamed from: ih */
    public final void m1258ih(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, LinearLayoutManager.C0132mjFkc c0132mjFkc, int i) {
        boolean z = i == 1;
        int iM1247Zerm = m1247Zerm(c0146Ucbh, c0148VocHEe, c0132mjFkc.f1517AZxh);
        if (z) {
            while (iM1247Zerm > 0) {
                int i2 = c0132mjFkc.f1517AZxh;
                if (i2 <= 0) {
                    return;
                }
                int i3 = i2 - 1;
                c0132mjFkc.f1517AZxh = i3;
                iM1247Zerm = m1247Zerm(c0146Ucbh, c0148VocHEe, i3);
            }
            return;
        }
        int iM1624AZxh = c0148VocHEe.m1624AZxh() - 1;
        int i4 = c0132mjFkc.f1517AZxh;
        while (i4 < iM1624AZxh) {
            int i5 = i4 + 1;
            int iM1247Zerm2 = m1247Zerm(c0146Ucbh, c0148VocHEe, i5);
            if (iM1247Zerm2 <= iM1247Zerm) {
                break;
            }
            i4 = i5;
            iM1247Zerm = iM1247Zerm2;
        }
        c0132mjFkc.f1517AZxh = i4;
    }

    /* renamed from: joWJO */
    public final void m1259joWJO() {
        int iM1737JYgkl;
        int iM1777dm;
        if (m1332UDcil() == 1) {
            iM1737JYgkl = m1755SOS() - m1719ANMGZc();
            iM1777dm = m1783jm();
        } else {
            iM1737JYgkl = m1737JYgkl() - m1735JBhc();
            iM1777dm = m1777dm();
        }
        m1253gJsSk(iM1737JYgkl - iM1777dm);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: jtz */
    public void mo1260jtz(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f1455NPj.m1282lgHUyS();
        this.f1455NPj.m1284xJ();
    }

    /* renamed from: kw */
    public final int m1261kw(RecyclerView.C0148VocHEe c0148VocHEe) {
        if (m1817zvd() != 0 && c0148VocHEe.m1624AZxh() != 0) {
            m1358qrxT();
            View viewM1363xbjHT = m1363xbjHT(!m1333UOnCkw(), true);
            View viewM1310EoC = m1310EoC(!m1333UOnCkw(), true);
            if (viewM1363xbjHT != null && viewM1310EoC != null) {
                if (!m1333UOnCkw()) {
                    return this.f1455NPj.m1280AZxh(c0148VocHEe.m1624AZxh() - 1, this.f1454KLMXS) + 1;
                }
                int iMo2055ZfxDd = this.f1503eyqo.mo2055ZfxDd(viewM1310EoC) - this.f1503eyqo.mo2061xJ(viewM1363xbjHT);
                int iM1280AZxh = this.f1455NPj.m1280AZxh(m1799tQ(viewM1363xbjHT), this.f1454KLMXS);
                return (int) ((iMo2055ZfxDd / ((this.f1455NPj.m1280AZxh(m1799tQ(viewM1310EoC), this.f1454KLMXS) - iM1280AZxh) + 1)) * (this.f1455NPj.m1280AZxh(c0148VocHEe.m1624AZxh() - 1, this.f1454KLMXS) + 1));
            }
        }
        return 0;
    }

    /* renamed from: lEKdq */
    public void m1262lEKdq(int i) {
        if (i == this.f1454KLMXS) {
            return;
        }
        this.f1461xrEuO = true;
        if (i >= 1) {
            this.f1454KLMXS = i;
            this.f1455NPj.m1282lgHUyS();
            m1788mzUGzO();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    @Override // androidx.recyclerview.p023widget.LinearLayoutManager, androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: mByQ */
    public RecyclerView.C0153fehf mo1263mByQ() {
        return this.f1499Pq == 0 ? new C0125AZxh(-2, -1) : new C0125AZxh(-1, -2);
    }

    /* renamed from: pCi */
    public final void m1264pCi(float f, int i) {
        m1253gJsSk(Math.max(Math.round(f * this.f1454KLMXS), i));
    }

    @Override // androidx.recyclerview.p023widget.LinearLayoutManager
    /* renamed from: pJeaSR */
    public void mo1265pJeaSR(RecyclerView.C0148VocHEe c0148VocHEe, LinearLayoutManager.C0133wA c0133wA, RecyclerView.AbstractC0159qGY.wA wAVar) {
        int iMo1277JHa = this.f1454KLMXS;
        for (int i = 0; i < this.f1454KLMXS && c0133wA.m1380wA(c0148VocHEe) && iMo1277JHa > 0; i++) {
            int i2 = c0133wA.f1529ZfxDd;
            wAVar.mo1300mjFkc(i2, Math.max(0, c0133wA.f1534xJ));
            iMo1277JHa -= this.f1455NPj.mo1277JHa(i2);
            c0133wA.f1529ZfxDd += c0133wA.f1526KLFTb;
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: rdJr */
    public void mo1266rdJr(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, View view, C2971Ucbh c2971Ucbh) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof C0125AZxh)) {
            super.m1754SKTn(view, c2971Ucbh);
            return;
        }
        C0125AZxh c0125AZxh = (C0125AZxh) layoutParams;
        int iM1267sZ = m1267sZ(c0146Ucbh, c0148VocHEe, c0125AZxh.m1653mjFkc());
        if (this.f1499Pq == 0) {
            c2971Ucbh.m10561Vdz(C2971Ucbh.JHa.m10610mjFkc(c0125AZxh.m1276KLFTb(), c0125AZxh.m1275JHa(), iM1267sZ, 1, false, false));
        } else {
            c2971Ucbh.m10561Vdz(C2971Ucbh.JHa.m10610mjFkc(iM1267sZ, 1, c0125AZxh.m1276KLFTb(), c0125AZxh.m1275JHa(), false, false));
        }
    }

    /* renamed from: sZ */
    public final int m1267sZ(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, int i) {
        if (!c0148VocHEe.m1626KLFTb()) {
            return this.f1455NPj.m1280AZxh(i, this.f1454KLMXS);
        }
        int iM1588JHa = c0146Ucbh.m1588JHa(i);
        if (iM1588JHa != -1) {
            return this.f1455NPj.m1280AZxh(iM1588JHa, this.f1454KLMXS);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: tAfC */
    public void mo1268tAfC(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f1455NPj.m1282lgHUyS();
        this.f1455NPj.m1284xJ();
    }

    @Override // androidx.recyclerview.p023widget.LinearLayoutManager
    /* renamed from: wGscSa */
    public void mo1269wGscSa(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, LinearLayoutManager.C0132mjFkc c0132mjFkc, int i) {
        super.mo1269wGscSa(c0146Ucbh, c0148VocHEe, c0132mjFkc, i);
        m1259joWJO();
        if (c0148VocHEe.m1624AZxh() > 0 && !c0148VocHEe.m1626KLFTb()) {
            m1258ih(c0146Ucbh, c0148VocHEe, c0132mjFkc, i);
        }
        m1235KbE();
    }

    @Override // androidx.recyclerview.p023widget.LinearLayoutManager
    /* renamed from: xBQUgd */
    public void mo1270xBQUgd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.mo1270xBQUgd(false);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: xCVa */
    public void mo1271xCVa(Rect rect, int i, int i2) {
        int iM1717rkYL;
        int iM1717rkYL2;
        if (this.f1462zvd == null) {
            super.mo1271xCVa(rect, i, i2);
        }
        int iM1783jm = m1783jm() + m1719ANMGZc();
        int iM1777dm = m1777dm() + m1735JBhc();
        if (this.f1499Pq == 1) {
            iM1717rkYL2 = RecyclerView.AbstractC0159qGY.m1717rkYL(i2, rect.height() + iM1777dm, m1775bbzow());
            int[] iArr = this.f1462zvd;
            iM1717rkYL = RecyclerView.AbstractC0159qGY.m1717rkYL(i, iArr[iArr.length - 1] + iM1783jm, m1757SwgkN());
        } else {
            iM1717rkYL = RecyclerView.AbstractC0159qGY.m1717rkYL(i, rect.width() + iM1783jm, m1757SwgkN());
            int[] iArr2 = this.f1462zvd;
            iM1717rkYL2 = RecyclerView.AbstractC0159qGY.m1717rkYL(i2, iArr2[iArr2.length - 1] + iM1777dm, m1775bbzow());
        }
        m1804ub(iM1717rkYL, iM1717rkYL2);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: xROA */
    public int mo1272xROA(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        if (this.f1499Pq == 0) {
            return this.f1454KLMXS;
        }
        if (c0148VocHEe.m1624AZxh() < 1) {
            return 0;
        }
        return m1267sZ(c0146Ucbh, c0148VocHEe, c0148VocHEe.m1624AZxh() - 1) + 1;
    }

    /* renamed from: xVYW */
    public final void m1273xVYW() {
        this.f1459rWxwaT.clear();
        this.f1456Vnb.clear();
    }

    @Override // androidx.recyclerview.p023widget.LinearLayoutManager
    /* renamed from: xfXeiC */
    public View mo1274xfXeiC(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, boolean z, boolean z2) {
        int i;
        int iM1817zvd;
        int iM1817zvd2 = m1817zvd();
        int i2 = 1;
        if (z2) {
            iM1817zvd = m1817zvd() - 1;
            i = -1;
            i2 = -1;
        } else {
            i = iM1817zvd2;
            iM1817zvd = 0;
        }
        int iM1624AZxh = c0148VocHEe.m1624AZxh();
        m1358qrxT();
        int iMo2051MiMN = this.f1503eyqo.mo2051MiMN();
        int iMo2059qdMbNW = this.f1503eyqo.mo2059qdMbNW();
        View view = null;
        View view2 = null;
        while (iM1817zvd != i) {
            View viewM1743KLMXS = m1743KLMXS(iM1817zvd);
            int iM1799tQ = m1799tQ(viewM1743KLMXS);
            if (iM1799tQ >= 0 && iM1799tQ < iM1624AZxh && m1247Zerm(c0146Ucbh, c0148VocHEe, iM1799tQ) == 0) {
                if (((RecyclerView.C0153fehf) viewM1743KLMXS.getLayoutParams()).m1654wA()) {
                    if (view2 == null) {
                        view2 = viewM1743KLMXS;
                    }
                } else {
                    if (this.f1503eyqo.mo2061xJ(viewM1743KLMXS) < iMo2059qdMbNW && this.f1503eyqo.mo2055ZfxDd(viewM1743KLMXS) >= iMo2051MiMN) {
                        return viewM1743KLMXS;
                    }
                    if (view == null) {
                        view = viewM1743KLMXS;
                    }
                }
            }
            iM1817zvd += i2;
        }
        return view != null ? view : view2;
    }

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$AZxh */
    public static class C0125AZxh extends RecyclerView.C0153fehf {

        /* renamed from: JHa */
        public int f1463JHa;

        /* renamed from: KLFTb */
        public int f1464KLFTb;

        public C0125AZxh(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1464KLFTb = -1;
            this.f1463JHa = 0;
        }

        /* renamed from: JHa */
        public int m1275JHa() {
            return this.f1463JHa;
        }

        /* renamed from: KLFTb */
        public int m1276KLFTb() {
            return this.f1464KLFTb;
        }

        public C0125AZxh(int i, int i2) {
            super(i, i2);
            this.f1464KLFTb = -1;
            this.f1463JHa = 0;
        }

        public C0125AZxh(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1464KLFTb = -1;
            this.f1463JHa = 0;
        }

        public C0125AZxh(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1464KLFTb = -1;
            this.f1463JHa = 0;
        }
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.f1461xrEuO = false;
        this.f1454KLMXS = -1;
        this.f1459rWxwaT = new SparseIntArray();
        this.f1456Vnb = new SparseIntArray();
        this.f1455NPj = new C0126mjFkc();
        this.f1460vadzgd = new Rect();
        m1262lEKdq(i);
    }
}
