package androidx.recyclerview.p023widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.p023widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.AZxh */
/* loaded from: classes.dex */
public class C0122AZxh {

    /* renamed from: mjFkc */
    public final AZxh f1443mjFkc;

    /* renamed from: AZxh */
    public final mjFkc f1442AZxh = new mjFkc();

    /* renamed from: wA */
    public final List f1444wA = new ArrayList();

    /* renamed from: androidx.recyclerview.widget.AZxh$AZxh */
    public interface AZxh {
        /* renamed from: AZxh */
        void mo1185AZxh(View view);

        /* renamed from: Dt */
        void mo1186Dt(View view, int i, ViewGroup.LayoutParams layoutParams);

        /* renamed from: ETF */
        int mo1187ETF(View view);

        /* renamed from: JHa */
        void mo1188JHa(View view, int i);

        /* renamed from: KLFTb */
        void mo1189KLFTb(View view);

        /* renamed from: ZfxDd */
        void mo1190ZfxDd(int i);

        /* renamed from: lgHUyS */
        void mo1191lgHUyS(int i);

        /* renamed from: mjFkc */
        View mo1192mjFkc(int i);

        /* renamed from: qdMbNW */
        void mo1193qdMbNW();

        /* renamed from: wA */
        RecyclerView.AbstractC0157mByQ mo1194wA(View view);

        /* renamed from: xJ */
        int mo1195xJ();
    }

    /* renamed from: androidx.recyclerview.widget.AZxh$mjFkc */
    public static class mjFkc {

        /* renamed from: AZxh */
        public mjFkc f1445AZxh;

        /* renamed from: mjFkc */
        public long f1446mjFkc = 0;

        /* renamed from: AZxh */
        public int m1196AZxh(int i) {
            mjFkc mjfkc = this.f1445AZxh;
            if (mjfkc == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f1446mjFkc);
                }
                return Long.bitCount(((1 << i) - 1) & this.f1446mjFkc);
            }
            if (i >= 64) {
                return mjfkc.m1196AZxh(i - 64) + Long.bitCount(this.f1446mjFkc);
            }
            return Long.bitCount(((1 << i) - 1) & this.f1446mjFkc);
        }

        /* renamed from: JHa */
        public boolean m1197JHa(int i) {
            if (i >= 64) {
                m1202wA();
                return this.f1445AZxh.m1197JHa(i - 64);
            }
            long j = 1 << i;
            long j2 = this.f1446mjFkc;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.f1446mjFkc = j3;
            long j4 = j - 1;
            this.f1446mjFkc = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            mjFkc mjfkc = this.f1445AZxh;
            if (mjfkc != null) {
                if (mjfkc.m1199ZfxDd(0)) {
                    m1200lgHUyS(63);
                }
                this.f1445AZxh.m1197JHa(0);
            }
            return z;
        }

        /* renamed from: KLFTb */
        public void m1198KLFTb(int i, boolean z) {
            if (i >= 64) {
                m1202wA();
                this.f1445AZxh.m1198KLFTb(i - 64, z);
                return;
            }
            long j = this.f1446mjFkc;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.f1446mjFkc = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                m1200lgHUyS(i);
            } else {
                m1201mjFkc(i);
            }
            if (z2 || this.f1445AZxh != null) {
                m1202wA();
                this.f1445AZxh.m1198KLFTb(0, z2);
            }
        }

        /* renamed from: ZfxDd */
        public boolean m1199ZfxDd(int i) {
            if (i < 64) {
                return ((1 << i) & this.f1446mjFkc) != 0;
            }
            m1202wA();
            return this.f1445AZxh.m1199ZfxDd(i - 64);
        }

        /* renamed from: lgHUyS */
        public void m1200lgHUyS(int i) {
            if (i < 64) {
                this.f1446mjFkc |= 1 << i;
            } else {
                m1202wA();
                this.f1445AZxh.m1200lgHUyS(i - 64);
            }
        }

        /* renamed from: mjFkc */
        public void m1201mjFkc(int i) {
            if (i < 64) {
                this.f1446mjFkc &= ~(1 << i);
                return;
            }
            mjFkc mjfkc = this.f1445AZxh;
            if (mjfkc != null) {
                mjfkc.m1201mjFkc(i - 64);
            }
        }

        public String toString() {
            if (this.f1445AZxh == null) {
                return Long.toBinaryString(this.f1446mjFkc);
            }
            return this.f1445AZxh.toString() + "xx" + Long.toBinaryString(this.f1446mjFkc);
        }

        /* renamed from: wA */
        public final void m1202wA() {
            if (this.f1445AZxh == null) {
                this.f1445AZxh = new mjFkc();
            }
        }

        /* renamed from: xJ */
        public void m1203xJ() {
            this.f1446mjFkc = 0L;
            mjFkc mjfkc = this.f1445AZxh;
            if (mjfkc != null) {
                mjfkc.m1203xJ();
            }
        }
    }

    public C0122AZxh(AZxh aZxh) {
        this.f1443mjFkc = aZxh;
    }

    /* renamed from: AZxh */
    public void m1165AZxh(View view, boolean z) {
        m1179mjFkc(view, -1, z);
    }

    /* renamed from: Dt */
    public int m1166Dt() {
        return this.f1443mjFkc.mo1195xJ();
    }

    /* renamed from: ETF */
    public void m1167ETF(View view) {
        int iMo1187ETF = this.f1443mjFkc.mo1187ETF(view);
        if (iMo1187ETF >= 0) {
            this.f1442AZxh.m1200lgHUyS(iMo1187ETF);
            m1173VA(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    /* renamed from: IEE */
    public boolean m1168IEE(View view) {
        int iMo1187ETF = this.f1443mjFkc.mo1187ETF(view);
        if (iMo1187ETF == -1) {
            m1176diqgf(view);
            return true;
        }
        if (!this.f1442AZxh.m1199ZfxDd(iMo1187ETF)) {
            return false;
        }
        this.f1442AZxh.m1197JHa(iMo1187ETF);
        m1176diqgf(view);
        this.f1443mjFkc.mo1191lgHUyS(iMo1187ETF);
        return true;
    }

    /* renamed from: JHa */
    public View m1169JHa(int i) {
        return this.f1443mjFkc.mo1192mjFkc(m1178lgHUyS(i));
    }

    /* renamed from: KLFTb */
    public View m1170KLFTb(int i) {
        int size = this.f1444wA.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.f1444wA.get(i2);
            RecyclerView.AbstractC0157mByQ abstractC0157mByQMo1194wA = this.f1443mjFkc.mo1194wA(view);
            if (abstractC0157mByQMo1194wA.m1688MiMN() == i && !abstractC0157mByQMo1194wA.m1698diqgf() && !abstractC0157mByQMo1194wA.m1692Ucbh()) {
                return view;
            }
        }
        return null;
    }

    /* renamed from: MiMN */
    public int m1171MiMN(View view) {
        int iMo1187ETF = this.f1443mjFkc.mo1187ETF(view);
        if (iMo1187ETF == -1 || this.f1442AZxh.m1199ZfxDd(iMo1187ETF)) {
            return -1;
        }
        return iMo1187ETF - this.f1442AZxh.m1196AZxh(iMo1187ETF);
    }

    /* renamed from: Pq */
    public void m1172Pq(View view) {
        int iMo1187ETF = this.f1443mjFkc.mo1187ETF(view);
        if (iMo1187ETF < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f1442AZxh.m1199ZfxDd(iMo1187ETF)) {
            this.f1442AZxh.m1201mjFkc(iMo1187ETF);
            m1176diqgf(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    /* renamed from: VA */
    public final void m1173VA(View view) {
        this.f1444wA.add(view);
        this.f1443mjFkc.mo1185AZxh(view);
    }

    /* renamed from: YoKzxo */
    public boolean m1174YoKzxo(View view) {
        return this.f1444wA.contains(view);
    }

    /* renamed from: ZfxDd */
    public void m1175ZfxDd(int i) {
        int iM1178lgHUyS = m1178lgHUyS(i);
        this.f1442AZxh.m1197JHa(iM1178lgHUyS);
        this.f1443mjFkc.mo1190ZfxDd(iM1178lgHUyS);
    }

    /* renamed from: diqgf */
    public final boolean m1176diqgf(View view) {
        if (!this.f1444wA.remove(view)) {
            return false;
        }
        this.f1443mjFkc.mo1189KLFTb(view);
        return true;
    }

    /* renamed from: fehf */
    public void m1177fehf(int i) {
        int iM1178lgHUyS = m1178lgHUyS(i);
        View viewMo1192mjFkc = this.f1443mjFkc.mo1192mjFkc(iM1178lgHUyS);
        if (viewMo1192mjFkc == null) {
            return;
        }
        if (this.f1442AZxh.m1197JHa(iM1178lgHUyS)) {
            m1176diqgf(viewMo1192mjFkc);
        }
        this.f1443mjFkc.mo1191lgHUyS(iM1178lgHUyS);
    }

    /* renamed from: lgHUyS */
    public final int m1178lgHUyS(int i) {
        if (i < 0) {
            return -1;
        }
        int iMo1195xJ = this.f1443mjFkc.mo1195xJ();
        int i2 = i;
        while (i2 < iMo1195xJ) {
            int iM1196AZxh = i - (i2 - this.f1442AZxh.m1196AZxh(i2));
            if (iM1196AZxh == 0) {
                while (this.f1442AZxh.m1199ZfxDd(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iM1196AZxh;
        }
        return -1;
    }

    /* renamed from: mjFkc */
    public void m1179mjFkc(View view, int i, boolean z) {
        int iMo1195xJ = i < 0 ? this.f1443mjFkc.mo1195xJ() : m1178lgHUyS(i);
        this.f1442AZxh.m1198KLFTb(iMo1195xJ, z);
        if (z) {
            m1173VA(view);
        }
        this.f1443mjFkc.mo1188JHa(view, iMo1195xJ);
    }

    /* renamed from: qGY */
    public void m1180qGY(View view) {
        int iMo1187ETF = this.f1443mjFkc.mo1187ETF(view);
        if (iMo1187ETF < 0) {
            return;
        }
        if (this.f1442AZxh.m1197JHa(iMo1187ETF)) {
            m1176diqgf(view);
        }
        this.f1443mjFkc.mo1191lgHUyS(iMo1187ETF);
    }

    /* renamed from: qdMbNW */
    public View m1181qdMbNW(int i) {
        return this.f1443mjFkc.mo1192mjFkc(i);
    }

    /* renamed from: rkYL */
    public void m1182rkYL() {
        this.f1442AZxh.m1203xJ();
        for (int size = this.f1444wA.size() - 1; size >= 0; size--) {
            this.f1443mjFkc.mo1189KLFTb((View) this.f1444wA.get(size));
            this.f1444wA.remove(size);
        }
        this.f1443mjFkc.mo1193qdMbNW();
    }

    public String toString() {
        return this.f1442AZxh.toString() + ", hidden list:" + this.f1444wA.size();
    }

    /* renamed from: wA */
    public void m1183wA(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iMo1195xJ = i < 0 ? this.f1443mjFkc.mo1195xJ() : m1178lgHUyS(i);
        this.f1442AZxh.m1198KLFTb(iMo1195xJ, z);
        if (z) {
            m1173VA(view);
        }
        this.f1443mjFkc.mo1186Dt(view, iMo1195xJ, layoutParams);
    }

    /* renamed from: xJ */
    public int m1184xJ() {
        return this.f1443mjFkc.mo1195xJ() - this.f1444wA.size();
    }
}
