package androidx.recyclerview.p023widget;

import androidx.recyclerview.p023widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p131o.AbstractC2352L8;

/* renamed from: androidx.recyclerview.widget.KLFTb */
/* loaded from: classes.dex */
public final class RunnableC0129KLFTb implements Runnable {

    /* renamed from: AZxh */
    public long f1480AZxh;

    /* renamed from: wA */
    public long f1483wA;

    /* renamed from: KLFTb */
    public static final ThreadLocal f1479KLFTb = new ThreadLocal();

    /* renamed from: JHa */
    public static Comparator f1478JHa = new mjFkc();

    /* renamed from: mjFkc */
    public ArrayList f1482mjFkc = new ArrayList();

    /* renamed from: ZfxDd */
    public ArrayList f1481ZfxDd = new ArrayList();

    /* renamed from: androidx.recyclerview.widget.KLFTb$AZxh */
    public static class AZxh implements RecyclerView.AbstractC0159qGY.wA {

        /* renamed from: AZxh */
        public int f1484AZxh;

        /* renamed from: ZfxDd */
        public int f1485ZfxDd;

        /* renamed from: mjFkc */
        public int f1486mjFkc;

        /* renamed from: wA */
        public int[] f1487wA;

        /* renamed from: AZxh */
        public void m1297AZxh() {
            int[] iArr = this.f1487wA;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1485ZfxDd = 0;
        }

        /* renamed from: KLFTb */
        public void m1298KLFTb(int i, int i2) {
            this.f1486mjFkc = i;
            this.f1484AZxh = i2;
        }

        /* renamed from: ZfxDd */
        public boolean m1299ZfxDd(int i) {
            if (this.f1487wA != null) {
                int i2 = this.f1485ZfxDd * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f1487wA[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY.wA
        /* renamed from: mjFkc */
        public void mo1300mjFkc(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.f1485ZfxDd;
            int i4 = i3 * 2;
            int[] iArr = this.f1487wA;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f1487wA = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i4 >= iArr.length) {
                int[] iArr3 = new int[i3 * 4];
                this.f1487wA = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f1487wA;
            iArr4[i4] = i;
            iArr4[i4 + 1] = i2;
            this.f1485ZfxDd++;
        }

        /* renamed from: wA */
        public void m1301wA(RecyclerView recyclerView, boolean z) {
            this.f1485ZfxDd = 0;
            int[] iArr = this.f1487wA;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.AbstractC0159qGY abstractC0159qGY = recyclerView.f1587YoKzxo;
            if (recyclerView.f1568MiMN == null || abstractC0159qGY == null || !abstractC0159qGY.m1815yX()) {
                return;
            }
            if (z) {
                if (!recyclerView.f1565KLFTb.m2016qGY()) {
                    abstractC0159qGY.mo1345fehf(recyclerView.f1568MiMN.mo1665ZfxDd(), this);
                }
            } else if (!recyclerView.m1462SmIWf()) {
                abstractC0159qGY.mo1356qGY(this.f1486mjFkc, this.f1484AZxh, recyclerView.f1581Vdz, this);
            }
            int i = this.f1485ZfxDd;
            if (i > abstractC0159qGY.f1713MiMN) {
                abstractC0159qGY.f1713MiMN = i;
                abstractC0159qGY.f1715YoKzxo = z;
                recyclerView.f1617wA.m1618vadzgd();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.KLFTb$mjFkc */
    public class mjFkc implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public int compare(wA wAVar, wA wAVar2) {
            RecyclerView recyclerView = wAVar.f1490ZfxDd;
            if ((recyclerView == null) != (wAVar2.f1490ZfxDd == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = wAVar.f1491mjFkc;
            if (z != wAVar2.f1491mjFkc) {
                return z ? -1 : 1;
            }
            int i = wAVar2.f1488AZxh - wAVar.f1488AZxh;
            if (i != 0) {
                return i;
            }
            int i2 = wAVar.f1492wA - wAVar2.f1492wA;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    }

    /* renamed from: androidx.recyclerview.widget.KLFTb$wA */
    public static class wA {

        /* renamed from: AZxh */
        public int f1488AZxh;

        /* renamed from: KLFTb */
        public int f1489KLFTb;

        /* renamed from: ZfxDd */
        public RecyclerView f1490ZfxDd;

        /* renamed from: mjFkc */
        public boolean f1491mjFkc;

        /* renamed from: wA */
        public int f1492wA;

        /* renamed from: mjFkc */
        public void m1303mjFkc() {
            this.f1491mjFkc = false;
            this.f1488AZxh = 0;
            this.f1492wA = 0;
            this.f1490ZfxDd = null;
            this.f1489KLFTb = 0;
        }
    }

    /* renamed from: KLFTb */
    public static boolean m1287KLFTb(RecyclerView recyclerView, int i) {
        int iM1166Dt = recyclerView.f1561JHa.m1166Dt();
        for (int i2 = 0; i2 < iM1166Dt; i2++) {
            RecyclerView.AbstractC0157mByQ abstractC0157mByQM1414dm = RecyclerView.m1414dm(recyclerView.f1561JHa.m1181qdMbNW(i2));
            if (abstractC0157mByQM1414dm.f1704wA == i && !abstractC0157mByQM1414dm.m1698diqgf()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: AZxh */
    public final void m1288AZxh() {
        wA wAVar;
        int size = this.f1482mjFkc.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = (RecyclerView) this.f1482mjFkc.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f1560JBhc.m1301wA(recyclerView, false);
                i += recyclerView.f1560JBhc.f1485ZfxDd;
            }
        }
        this.f1481ZfxDd.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f1482mjFkc.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                AZxh aZxh = recyclerView2.f1560JBhc;
                int iAbs = Math.abs(aZxh.f1486mjFkc) + Math.abs(aZxh.f1484AZxh);
                for (int i5 = 0; i5 < aZxh.f1485ZfxDd * 2; i5 += 2) {
                    if (i3 >= this.f1481ZfxDd.size()) {
                        wAVar = new wA();
                        this.f1481ZfxDd.add(wAVar);
                    } else {
                        wAVar = (wA) this.f1481ZfxDd.get(i3);
                    }
                    int[] iArr = aZxh.f1487wA;
                    int i6 = iArr[i5 + 1];
                    wAVar.f1491mjFkc = i6 <= iAbs;
                    wAVar.f1488AZxh = iAbs;
                    wAVar.f1492wA = i6;
                    wAVar.f1490ZfxDd = recyclerView2;
                    wAVar.f1489KLFTb = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.f1481ZfxDd, f1478JHa);
    }

    /* renamed from: Dt */
    public void m1289Dt(RecyclerView recyclerView) {
        boolean zRemove = this.f1482mjFkc.remove(recyclerView);
        if (RecyclerView.f1542gYa && !zRemove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
    }

    /* renamed from: JHa */
    public void m1290JHa(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow()) {
            if (RecyclerView.f1542gYa && !this.f1482mjFkc.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            }
            if (this.f1480AZxh == 0) {
                this.f1480AZxh = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        recyclerView.f1560JBhc.m1298KLFTb(i, i2);
    }

    /* renamed from: ZfxDd */
    public final void m1291ZfxDd(long j) {
        for (int i = 0; i < this.f1481ZfxDd.size(); i++) {
            wA wAVar = (wA) this.f1481ZfxDd.get(i);
            if (wAVar.f1490ZfxDd == null) {
                return;
            }
            m1295wA(wAVar, j);
            wAVar.m1303mjFkc();
        }
    }

    /* renamed from: lgHUyS */
    public final void m1292lgHUyS(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.f1603mByQ && recyclerView.f1561JHa.m1166Dt() != 0) {
            recyclerView.m1481Xxz();
        }
        AZxh aZxh = recyclerView.f1560JBhc;
        aZxh.m1301wA(recyclerView, true);
        if (aZxh.f1485ZfxDd != 0) {
            try {
                AbstractC2352L8.m9358mjFkc("RV Nested Prefetch");
                recyclerView.f1581Vdz.m1625JHa(recyclerView.f1568MiMN);
                for (int i = 0; i < aZxh.f1485ZfxDd * 2; i += 2) {
                    m1294qdMbNW(recyclerView, aZxh.f1487wA[i], j);
                }
            } finally {
                AbstractC2352L8.m9357AZxh();
            }
        }
    }

    /* renamed from: mjFkc */
    public void m1293mjFkc(RecyclerView recyclerView) {
        if (RecyclerView.f1542gYa && this.f1482mjFkc.contains(recyclerView)) {
            throw new IllegalStateException("RecyclerView already present in worker list!");
        }
        this.f1482mjFkc.add(recyclerView);
    }

    /* renamed from: qdMbNW */
    public final RecyclerView.AbstractC0157mByQ m1294qdMbNW(RecyclerView recyclerView, int i, long j) {
        if (m1287KLFTb(recyclerView, i)) {
            return null;
        }
        RecyclerView.C0146Ucbh c0146Ucbh = recyclerView.f1617wA;
        try {
            recyclerView.m1474XD();
            RecyclerView.AbstractC0157mByQ abstractC0157mByQM1598Vnb = c0146Ucbh.m1598Vnb(i, false, j);
            if (abstractC0157mByQM1598Vnb != null) {
                if (!abstractC0157mByQM1598Vnb.m1691Pq() || abstractC0157mByQM1598Vnb.m1698diqgf()) {
                    c0146Ucbh.m1611mjFkc(abstractC0157mByQM1598Vnb, false);
                } else {
                    c0146Ucbh.m1593Ne(abstractC0157mByQM1598Vnb.f1700mjFkc);
                }
            }
            recyclerView.m1425Dp(false);
            return abstractC0157mByQM1598Vnb;
        } catch (Throwable th) {
            recyclerView.m1425Dp(false);
            throw th;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            AbstractC2352L8.m9358mjFkc("RV Prefetch");
            if (!this.f1482mjFkc.isEmpty()) {
                int size = this.f1482mjFkc.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = (RecyclerView) this.f1482mjFkc.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    m1296xJ(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f1483wA);
                    this.f1480AZxh = 0L;
                    AbstractC2352L8.m9357AZxh();
                }
            }
        } finally {
            this.f1480AZxh = 0L;
            AbstractC2352L8.m9357AZxh();
        }
    }

    /* renamed from: wA */
    public final void m1295wA(wA wAVar, long j) {
        RecyclerView.AbstractC0157mByQ abstractC0157mByQM1294qdMbNW = m1294qdMbNW(wAVar.f1490ZfxDd, wAVar.f1489KLFTb, wAVar.f1491mjFkc ? LongCompanionObject.MAX_VALUE : j);
        if (abstractC0157mByQM1294qdMbNW == null || abstractC0157mByQM1294qdMbNW.f1687AZxh == null || !abstractC0157mByQM1294qdMbNW.m1691Pq() || abstractC0157mByQM1294qdMbNW.m1698diqgf()) {
            return;
        }
        m1292lgHUyS((RecyclerView) abstractC0157mByQM1294qdMbNW.f1687AZxh.get(), j);
    }

    /* renamed from: xJ */
    public void m1296xJ(long j) {
        m1288AZxh();
        m1291ZfxDd(j);
    }
}
