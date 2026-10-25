package androidx.recyclerview.p023widget;

import android.view.View;
import androidx.recyclerview.p023widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.MiMN */
/* loaded from: classes.dex */
public abstract class AbstractC0134MiMN extends RecyclerView.AbstractC0144MiMN {

    /* renamed from: xJ */
    public boolean f1535xJ = true;

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0144MiMN
    /* renamed from: AZxh */
    public boolean mo1381AZxh(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, RecyclerView.AbstractC0157mByQ abstractC0157mByQ2, RecyclerView.AbstractC0144MiMN.AZxh aZxh, RecyclerView.AbstractC0144MiMN.AZxh aZxh2) {
        int i;
        int i2;
        int i3 = aZxh.f1639mjFkc;
        int i4 = aZxh.f1637AZxh;
        if (abstractC0157mByQ2.m1687KLMXS()) {
            int i5 = aZxh.f1639mjFkc;
            i2 = aZxh.f1637AZxh;
            i = i5;
        } else {
            i = aZxh2.f1639mjFkc;
            i2 = aZxh2.f1637AZxh;
        }
        return mo1384Gd(abstractC0157mByQ, abstractC0157mByQ2, i3, i4, i, i2);
    }

    /* renamed from: BAnRFn */
    public final void m1382BAnRFn(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        m1387KLMXS(abstractC0157mByQ);
    }

    /* renamed from: CqaNbM */
    public final void m1383CqaNbM(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        m1401vadzgd(abstractC0157mByQ);
    }

    /* renamed from: Gd */
    public abstract boolean mo1384Gd(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, RecyclerView.AbstractC0157mByQ abstractC0157mByQ2, int i, int i2, int i3, int i4);

    /* renamed from: HGpJ */
    public abstract boolean mo1385HGpJ(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, int i, int i2, int i3, int i4);

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0144MiMN
    /* renamed from: JHa */
    public boolean mo1386JHa(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        return !this.f1535xJ || abstractC0157mByQ.m1698diqgf();
    }

    /* renamed from: KLMXS */
    public void m1387KLMXS(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
    }

    /* renamed from: NPj */
    public void m1388NPj(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
    }

    /* renamed from: Ne */
    public final void m1389Ne(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        m1388NPj(abstractC0157mByQ);
        m1569lgHUyS(abstractC0157mByQ);
    }

    /* renamed from: OjSQV */
    public final void m1390OjSQV(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        m1391Vnb(abstractC0157mByQ);
    }

    /* renamed from: Vnb */
    public void m1391Vnb(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
    }

    /* renamed from: VocHEe */
    public final void m1392VocHEe(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        m1404xrEuO(abstractC0157mByQ);
        m1569lgHUyS(abstractC0157mByQ);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0144MiMN
    /* renamed from: ZfxDd */
    public boolean mo1393ZfxDd(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, RecyclerView.AbstractC0144MiMN.AZxh aZxh, RecyclerView.AbstractC0144MiMN.AZxh aZxh2) {
        int i = aZxh.f1639mjFkc;
        int i2 = aZxh2.f1639mjFkc;
        if (i != i2 || aZxh.f1637AZxh != aZxh2.f1637AZxh) {
            return mo1385HGpJ(abstractC0157mByQ, i, aZxh.f1637AZxh, i2, aZxh2.f1637AZxh);
        }
        m1397mByQ(abstractC0157mByQ);
        return false;
    }

    /* renamed from: cMLeY */
    public void m1394cMLeY(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, boolean z) {
    }

    /* renamed from: huTpC */
    public abstract boolean mo1395huTpC(RecyclerView.AbstractC0157mByQ abstractC0157mByQ);

    /* renamed from: lB */
    public final void m1396lB(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, boolean z) {
        m1405zvd(abstractC0157mByQ, z);
        m1569lgHUyS(abstractC0157mByQ);
    }

    /* renamed from: mByQ */
    public final void m1397mByQ(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        m1399rWxwaT(abstractC0157mByQ);
        m1569lgHUyS(abstractC0157mByQ);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0144MiMN
    /* renamed from: mjFkc */
    public boolean mo1398mjFkc(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, RecyclerView.AbstractC0144MiMN.AZxh aZxh, RecyclerView.AbstractC0144MiMN.AZxh aZxh2) {
        int i;
        int i2;
        return (aZxh == null || ((i = aZxh.f1639mjFkc) == (i2 = aZxh2.f1639mjFkc) && aZxh.f1637AZxh == aZxh2.f1637AZxh)) ? mo1395huTpC(abstractC0157mByQ) : mo1385HGpJ(abstractC0157mByQ, i, aZxh.f1637AZxh, i2, aZxh2.f1637AZxh);
    }

    /* renamed from: rWxwaT */
    public void m1399rWxwaT(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
    }

    /* renamed from: vI */
    public abstract boolean mo1400vI(RecyclerView.AbstractC0157mByQ abstractC0157mByQ);

    /* renamed from: vadzgd */
    public void m1401vadzgd(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0144MiMN
    /* renamed from: wA */
    public boolean mo1402wA(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, RecyclerView.AbstractC0144MiMN.AZxh aZxh, RecyclerView.AbstractC0144MiMN.AZxh aZxh2) {
        int i = aZxh.f1639mjFkc;
        int i2 = aZxh.f1637AZxh;
        View view = abstractC0157mByQ.f1700mjFkc;
        int left = aZxh2 == null ? view.getLeft() : aZxh2.f1639mjFkc;
        int top = aZxh2 == null ? view.getTop() : aZxh2.f1637AZxh;
        if (abstractC0157mByQ.m1692Ucbh() || (i == left && i2 == top)) {
            return mo1400vI(abstractC0157mByQ);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return mo1385HGpJ(abstractC0157mByQ, i, i2, left, top);
    }

    /* renamed from: wJVbdd */
    public final void m1403wJVbdd(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, boolean z) {
        m1394cMLeY(abstractC0157mByQ, z);
    }

    /* renamed from: xrEuO */
    public void m1404xrEuO(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
    }

    /* renamed from: zvd */
    public void m1405zvd(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, boolean z) {
    }
}
