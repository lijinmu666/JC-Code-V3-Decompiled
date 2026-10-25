package androidx.recyclerview.p023widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.p023widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p131o.AbstractC2876T9;

/* renamed from: androidx.recyclerview.widget.wA */
/* loaded from: classes.dex */
public class C0180wA extends AbstractC0134MiMN {

    /* renamed from: Pq */
    public static TimeInterpolator f1882Pq;

    /* renamed from: lgHUyS */
    public ArrayList f1890lgHUyS = new ArrayList();

    /* renamed from: qdMbNW */
    public ArrayList f1892qdMbNW = new ArrayList();

    /* renamed from: Dt */
    public ArrayList f1883Dt = new ArrayList();

    /* renamed from: ETF */
    public ArrayList f1884ETF = new ArrayList();

    /* renamed from: VA */
    public ArrayList f1887VA = new ArrayList();

    /* renamed from: MiMN */
    public ArrayList f1886MiMN = new ArrayList();

    /* renamed from: YoKzxo */
    public ArrayList f1888YoKzxo = new ArrayList();

    /* renamed from: rkYL */
    public ArrayList f1893rkYL = new ArrayList();

    /* renamed from: qGY */
    public ArrayList f1891qGY = new ArrayList();

    /* renamed from: fehf */
    public ArrayList f1889fehf = new ArrayList();

    /* renamed from: IEE */
    public ArrayList f1885IEE = new ArrayList();

    /* renamed from: androidx.recyclerview.widget.wA$AZxh */
    public class AZxh implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ ArrayList f1895mjFkc;

        public AZxh(ArrayList arrayList) {
            this.f1895mjFkc = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1895mjFkc.iterator();
            while (it.hasNext()) {
                C0180wA.this.m2075aqHPIZ((qdMbNW) it.next());
            }
            this.f1895mjFkc.clear();
            C0180wA.this.f1888YoKzxo.remove(this.f1895mjFkc);
        }
    }

    /* renamed from: androidx.recyclerview.widget.wA$Dt */
    public static class Dt {

        /* renamed from: AZxh */
        public int f1896AZxh;

        /* renamed from: KLFTb */
        public int f1897KLFTb;

        /* renamed from: ZfxDd */
        public int f1898ZfxDd;

        /* renamed from: mjFkc */
        public RecyclerView.AbstractC0157mByQ f1899mjFkc;

        /* renamed from: wA */
        public int f1900wA;

        public Dt(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, int i, int i2, int i3, int i4) {
            this.f1899mjFkc = abstractC0157mByQ;
            this.f1896AZxh = i;
            this.f1900wA = i2;
            this.f1898ZfxDd = i3;
            this.f1897KLFTb = i4;
        }
    }

    /* renamed from: androidx.recyclerview.widget.wA$JHa */
    public class JHa extends AnimatorListenerAdapter {

        /* renamed from: AZxh */
        public final /* synthetic */ int f1901AZxh;

        /* renamed from: KLFTb */
        public final /* synthetic */ ViewPropertyAnimator f1903KLFTb;

        /* renamed from: ZfxDd */
        public final /* synthetic */ int f1904ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ RecyclerView.AbstractC0157mByQ f1905mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ View f1906wA;

        public JHa(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1905mjFkc = abstractC0157mByQ;
            this.f1901AZxh = i;
            this.f1906wA = view;
            this.f1904ZfxDd = i2;
            this.f1903KLFTb = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f1901AZxh != 0) {
                this.f1906wA.setTranslationX(0.0f);
            }
            if (this.f1904ZfxDd != 0) {
                this.f1906wA.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1903KLFTb.setListener(null);
            C0180wA.this.m1397mByQ(this.f1905mjFkc);
            C0180wA.this.f1891qGY.remove(this.f1905mjFkc);
            C0180wA.this.m2078uHVRx();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C0180wA.this.m1390OjSQV(this.f1905mjFkc);
        }
    }

    /* renamed from: androidx.recyclerview.widget.wA$KLFTb */
    public class KLFTb extends AnimatorListenerAdapter {

        /* renamed from: AZxh */
        public final /* synthetic */ View f1907AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ RecyclerView.AbstractC0157mByQ f1909mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ ViewPropertyAnimator f1910wA;

        public KLFTb(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1909mjFkc = abstractC0157mByQ;
            this.f1907AZxh = view;
            this.f1910wA = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1907AZxh.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1910wA.setListener(null);
            C0180wA.this.m1392VocHEe(this.f1909mjFkc);
            C0180wA.this.f1893rkYL.remove(this.f1909mjFkc);
            C0180wA.this.m2078uHVRx();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C0180wA.this.m1382BAnRFn(this.f1909mjFkc);
        }
    }

    /* renamed from: androidx.recyclerview.widget.wA$ZfxDd */
    public class ZfxDd extends AnimatorListenerAdapter {

        /* renamed from: AZxh */
        public final /* synthetic */ ViewPropertyAnimator f1911AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ RecyclerView.AbstractC0157mByQ f1913mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ View f1914wA;

        public ZfxDd(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1913mjFkc = abstractC0157mByQ;
            this.f1911AZxh = viewPropertyAnimator;
            this.f1914wA = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1911AZxh.setListener(null);
            this.f1914wA.setAlpha(1.0f);
            C0180wA.this.m1389Ne(this.f1913mjFkc);
            C0180wA.this.f1889fehf.remove(this.f1913mjFkc);
            C0180wA.this.m2078uHVRx();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C0180wA.this.m1383CqaNbM(this.f1913mjFkc);
        }
    }

    /* renamed from: androidx.recyclerview.widget.wA$lgHUyS */
    public class lgHUyS extends AnimatorListenerAdapter {

        /* renamed from: AZxh */
        public final /* synthetic */ ViewPropertyAnimator f1915AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ qdMbNW f1917mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ View f1918wA;

        public lgHUyS(qdMbNW qdmbnw, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1917mjFkc = qdmbnw;
            this.f1915AZxh = viewPropertyAnimator;
            this.f1918wA = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1915AZxh.setListener(null);
            this.f1918wA.setAlpha(1.0f);
            this.f1918wA.setTranslationX(0.0f);
            this.f1918wA.setTranslationY(0.0f);
            C0180wA.this.m1396lB(this.f1917mjFkc.f1921AZxh, false);
            C0180wA.this.f1885IEE.remove(this.f1917mjFkc.f1921AZxh);
            C0180wA.this.m2078uHVRx();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C0180wA.this.m1403wJVbdd(this.f1917mjFkc.f1921AZxh, false);
        }
    }

    /* renamed from: androidx.recyclerview.widget.wA$mjFkc */
    public class mjFkc implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ ArrayList f1920mjFkc;

        public mjFkc(ArrayList arrayList) {
            this.f1920mjFkc = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1920mjFkc.iterator();
            while (it.hasNext()) {
                Dt dt = (Dt) it.next();
                C0180wA.this.m2074WrLQs(dt.f1899mjFkc, dt.f1896AZxh, dt.f1900wA, dt.f1898ZfxDd, dt.f1897KLFTb);
            }
            this.f1920mjFkc.clear();
            C0180wA.this.f1886MiMN.remove(this.f1920mjFkc);
        }
    }

    /* renamed from: androidx.recyclerview.widget.wA$wA */
    public class wA implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ ArrayList f1928mjFkc;

        public wA(ArrayList arrayList) {
            this.f1928mjFkc = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1928mjFkc.iterator();
            while (it.hasNext()) {
                C0180wA.this.m2077oCFDzJ((RecyclerView.AbstractC0157mByQ) it.next());
            }
            this.f1928mjFkc.clear();
            C0180wA.this.f1887VA.remove(this.f1928mjFkc);
        }
    }

    /* renamed from: androidx.recyclerview.widget.wA$xJ */
    public class xJ extends AnimatorListenerAdapter {

        /* renamed from: AZxh */
        public final /* synthetic */ ViewPropertyAnimator f1929AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ qdMbNW f1931mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ View f1932wA;

        public xJ(qdMbNW qdmbnw, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1931mjFkc = qdmbnw;
            this.f1929AZxh = viewPropertyAnimator;
            this.f1932wA = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1929AZxh.setListener(null);
            this.f1932wA.setAlpha(1.0f);
            this.f1932wA.setTranslationX(0.0f);
            this.f1932wA.setTranslationY(0.0f);
            C0180wA.this.m1396lB(this.f1931mjFkc.f1925mjFkc, true);
            C0180wA.this.f1885IEE.remove(this.f1931mjFkc.f1925mjFkc);
            C0180wA.this.m2078uHVRx();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C0180wA.this.m1403wJVbdd(this.f1931mjFkc.f1925mjFkc, true);
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0144MiMN
    /* renamed from: Dt */
    public void mo1558Dt(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        View view = abstractC0157mByQ.f1700mjFkc;
        view.animate().cancel();
        int size = this.f1883Dt.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((Dt) this.f1883Dt.get(size)).f1899mjFkc == abstractC0157mByQ) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                m1397mByQ(abstractC0157mByQ);
                this.f1883Dt.remove(size);
            }
        }
        m2071JYn(this.f1884ETF, abstractC0157mByQ);
        if (this.f1890lgHUyS.remove(abstractC0157mByQ)) {
            view.setAlpha(1.0f);
            m1389Ne(abstractC0157mByQ);
        }
        if (this.f1892qdMbNW.remove(abstractC0157mByQ)) {
            view.setAlpha(1.0f);
            m1392VocHEe(abstractC0157mByQ);
        }
        for (int size2 = this.f1888YoKzxo.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f1888YoKzxo.get(size2);
            m2071JYn(arrayList, abstractC0157mByQ);
            if (arrayList.isEmpty()) {
                this.f1888YoKzxo.remove(size2);
            }
        }
        for (int size3 = this.f1886MiMN.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.f1886MiMN.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((Dt) arrayList2.get(size4)).f1899mjFkc == abstractC0157mByQ) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    m1397mByQ(abstractC0157mByQ);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f1886MiMN.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f1887VA.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.f1887VA.get(size5);
            if (arrayList3.remove(abstractC0157mByQ)) {
                view.setAlpha(1.0f);
                m1392VocHEe(abstractC0157mByQ);
                if (arrayList3.isEmpty()) {
                    this.f1887VA.remove(size5);
                }
            }
        }
        this.f1889fehf.remove(abstractC0157mByQ);
        this.f1893rkYL.remove(abstractC0157mByQ);
        this.f1885IEE.remove(abstractC0157mByQ);
        this.f1891qGY.remove(abstractC0157mByQ);
        m2078uHVRx();
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0144MiMN
    /* renamed from: ETF */
    public void mo1559ETF() {
        int size = this.f1883Dt.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            Dt dt = (Dt) this.f1883Dt.get(size);
            View view = dt.f1899mjFkc.f1700mjFkc;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            m1397mByQ(dt.f1899mjFkc);
            this.f1883Dt.remove(size);
        }
        for (int size2 = this.f1890lgHUyS.size() - 1; size2 >= 0; size2--) {
            m1389Ne((RecyclerView.AbstractC0157mByQ) this.f1890lgHUyS.get(size2));
            this.f1890lgHUyS.remove(size2);
        }
        int size3 = this.f1892qdMbNW.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.AbstractC0157mByQ abstractC0157mByQ = (RecyclerView.AbstractC0157mByQ) this.f1892qdMbNW.get(size3);
            abstractC0157mByQ.f1700mjFkc.setAlpha(1.0f);
            m1392VocHEe(abstractC0157mByQ);
            this.f1892qdMbNW.remove(size3);
        }
        for (int size4 = this.f1884ETF.size() - 1; size4 >= 0; size4--) {
            m2070JYgkl((qdMbNW) this.f1884ETF.get(size4));
        }
        this.f1884ETF.clear();
        if (mo1570qGY()) {
            for (int size5 = this.f1886MiMN.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.f1886MiMN.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    Dt dt2 = (Dt) arrayList.get(size6);
                    View view2 = dt2.f1899mjFkc.f1700mjFkc;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    m1397mByQ(dt2.f1899mjFkc);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f1886MiMN.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f1887VA.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.f1887VA.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.AbstractC0157mByQ abstractC0157mByQ2 = (RecyclerView.AbstractC0157mByQ) arrayList2.get(size8);
                    abstractC0157mByQ2.f1700mjFkc.setAlpha(1.0f);
                    m1392VocHEe(abstractC0157mByQ2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f1887VA.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f1888YoKzxo.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.f1888YoKzxo.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    m2070JYgkl((qdMbNW) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f1888YoKzxo.remove(arrayList3);
                    }
                }
            }
            m2069GMIER(this.f1889fehf);
            m2069GMIER(this.f1891qGY);
            m2069GMIER(this.f1893rkYL);
            m2069GMIER(this.f1885IEE);
            m1571qdMbNW();
        }
    }

    /* renamed from: GMIER */
    public void m2069GMIER(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((RecyclerView.AbstractC0157mByQ) list.get(size)).f1700mjFkc.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.p023widget.AbstractC0134MiMN
    /* renamed from: Gd */
    public boolean mo1384Gd(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, RecyclerView.AbstractC0157mByQ abstractC0157mByQ2, int i, int i2, int i3, int i4) {
        if (abstractC0157mByQ == abstractC0157mByQ2) {
            return mo1385HGpJ(abstractC0157mByQ, i, i2, i3, i4);
        }
        float translationX = abstractC0157mByQ.f1700mjFkc.getTranslationX();
        float translationY = abstractC0157mByQ.f1700mjFkc.getTranslationY();
        float alpha = abstractC0157mByQ.f1700mjFkc.getAlpha();
        m2076nxI(abstractC0157mByQ);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        abstractC0157mByQ.f1700mjFkc.setTranslationX(translationX);
        abstractC0157mByQ.f1700mjFkc.setTranslationY(translationY);
        abstractC0157mByQ.f1700mjFkc.setAlpha(alpha);
        if (abstractC0157mByQ2 != null) {
            m2076nxI(abstractC0157mByQ2);
            abstractC0157mByQ2.f1700mjFkc.setTranslationX(-i5);
            abstractC0157mByQ2.f1700mjFkc.setTranslationY(-i6);
            abstractC0157mByQ2.f1700mjFkc.setAlpha(0.0f);
        }
        this.f1884ETF.add(new qdMbNW(abstractC0157mByQ, abstractC0157mByQ2, i, i2, i3, i4));
        return true;
    }

    @Override // androidx.recyclerview.p023widget.AbstractC0134MiMN
    /* renamed from: HGpJ */
    public boolean mo1385HGpJ(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, int i, int i2, int i3, int i4) {
        View view = abstractC0157mByQ.f1700mjFkc;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) abstractC0157mByQ.f1700mjFkc.getTranslationY());
        m2076nxI(abstractC0157mByQ);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            m1397mByQ(abstractC0157mByQ);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.f1883Dt.add(new Dt(abstractC0157mByQ, translationX, translationY, i3, i4));
        return true;
    }

    /* renamed from: JYgkl */
    public final void m2070JYgkl(qdMbNW qdmbnw) {
        RecyclerView.AbstractC0157mByQ abstractC0157mByQ = qdmbnw.f1925mjFkc;
        if (abstractC0157mByQ != null) {
            m2072JrJO(qdmbnw, abstractC0157mByQ);
        }
        RecyclerView.AbstractC0157mByQ abstractC0157mByQ2 = qdmbnw.f1921AZxh;
        if (abstractC0157mByQ2 != null) {
            m2072JrJO(qdmbnw, abstractC0157mByQ2);
        }
    }

    /* renamed from: JYn */
    public final void m2071JYn(List list, RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        for (int size = list.size() - 1; size >= 0; size--) {
            qdMbNW qdmbnw = (qdMbNW) list.get(size);
            if (m2072JrJO(qdmbnw, abstractC0157mByQ) && qdmbnw.f1925mjFkc == null && qdmbnw.f1921AZxh == null) {
                list.remove(qdmbnw);
            }
        }
    }

    /* renamed from: JrJO */
    public final boolean m2072JrJO(qdMbNW qdmbnw, RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        boolean z = false;
        if (qdmbnw.f1921AZxh == abstractC0157mByQ) {
            qdmbnw.f1921AZxh = null;
        } else {
            if (qdmbnw.f1925mjFkc != abstractC0157mByQ) {
                return false;
            }
            qdmbnw.f1925mjFkc = null;
            z = true;
        }
        abstractC0157mByQ.f1700mjFkc.setAlpha(1.0f);
        abstractC0157mByQ.f1700mjFkc.setTranslationX(0.0f);
        abstractC0157mByQ.f1700mjFkc.setTranslationY(0.0f);
        m1396lB(abstractC0157mByQ, z);
        return true;
    }

    /* renamed from: KRTLGT */
    public final void m2073KRTLGT(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        View view = abstractC0157mByQ.f1700mjFkc;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f1889fehf.add(abstractC0157mByQ);
        viewPropertyAnimatorAnimate.setDuration(m1572rkYL()).alpha(0.0f).setListener(new ZfxDd(abstractC0157mByQ, viewPropertyAnimatorAnimate, view)).start();
    }

    /* renamed from: WrLQs */
    public void m2074WrLQs(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, int i, int i2, int i3, int i4) {
        View view = abstractC0157mByQ.f1700mjFkc;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f1891qGY.add(abstractC0157mByQ);
        viewPropertyAnimatorAnimate.setDuration(m1565YoKzxo()).setListener(new JHa(abstractC0157mByQ, i5, view, i6, viewPropertyAnimatorAnimate)).start();
    }

    /* renamed from: aqHPIZ */
    public void m2075aqHPIZ(qdMbNW qdmbnw) {
        RecyclerView.AbstractC0157mByQ abstractC0157mByQ = qdmbnw.f1925mjFkc;
        View view = abstractC0157mByQ == null ? null : abstractC0157mByQ.f1700mjFkc;
        RecyclerView.AbstractC0157mByQ abstractC0157mByQ2 = qdmbnw.f1921AZxh;
        View view2 = abstractC0157mByQ2 != null ? abstractC0157mByQ2.f1700mjFkc : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m1561MiMN());
            this.f1885IEE.add(qdmbnw.f1925mjFkc);
            duration.translationX(qdmbnw.f1923KLFTb - qdmbnw.f1926wA);
            duration.translationY(qdmbnw.f1922JHa - qdmbnw.f1924ZfxDd);
            duration.alpha(0.0f).setListener(new xJ(qdmbnw, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.f1885IEE.add(qdmbnw.f1921AZxh);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(m1561MiMN()).alpha(1.0f).setListener(new lgHUyS(qdmbnw, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0144MiMN
    /* renamed from: eyqo */
    public void mo1567eyqo() {
        boolean zIsEmpty = this.f1890lgHUyS.isEmpty();
        boolean zIsEmpty2 = this.f1883Dt.isEmpty();
        boolean zIsEmpty3 = this.f1884ETF.isEmpty();
        boolean zIsEmpty4 = this.f1892qdMbNW.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
            return;
        }
        Iterator it = this.f1890lgHUyS.iterator();
        while (it.hasNext()) {
            m2073KRTLGT((RecyclerView.AbstractC0157mByQ) it.next());
        }
        this.f1890lgHUyS.clear();
        if (!zIsEmpty2) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f1883Dt);
            this.f1886MiMN.add(arrayList);
            this.f1883Dt.clear();
            mjFkc mjfkc = new mjFkc(arrayList);
            if (zIsEmpty) {
                mjfkc.run();
            } else {
                AbstractC2876T9.m10261XV(((Dt) arrayList.get(0)).f1899mjFkc.f1700mjFkc, mjfkc, m1572rkYL());
            }
        }
        if (!zIsEmpty3) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.f1884ETF);
            this.f1888YoKzxo.add(arrayList2);
            this.f1884ETF.clear();
            AZxh aZxh = new AZxh(arrayList2);
            if (zIsEmpty) {
                aZxh.run();
            } else {
                AbstractC2876T9.m10261XV(((qdMbNW) arrayList2.get(0)).f1925mjFkc.f1700mjFkc, aZxh, m1572rkYL());
            }
        }
        if (zIsEmpty4) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(this.f1892qdMbNW);
        this.f1887VA.add(arrayList3);
        this.f1892qdMbNW.clear();
        wA wAVar = new wA(arrayList3);
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            wAVar.run();
        } else {
            AbstractC2876T9.m10261XV(((RecyclerView.AbstractC0157mByQ) arrayList3.get(0)).f1700mjFkc, wAVar, (!zIsEmpty ? m1572rkYL() : 0L) + Math.max(!zIsEmpty2 ? m1565YoKzxo() : 0L, zIsEmpty3 ? 0L : m1561MiMN()));
        }
    }

    @Override // androidx.recyclerview.p023widget.AbstractC0134MiMN
    /* renamed from: huTpC */
    public boolean mo1395huTpC(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        m2076nxI(abstractC0157mByQ);
        abstractC0157mByQ.f1700mjFkc.setAlpha(0.0f);
        this.f1892qdMbNW.add(abstractC0157mByQ);
        return true;
    }

    /* renamed from: nxI */
    public final void m2076nxI(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        if (f1882Pq == null) {
            f1882Pq = new ValueAnimator().getInterpolator();
        }
        abstractC0157mByQ.f1700mjFkc.animate().setInterpolator(f1882Pq);
        mo1558Dt(abstractC0157mByQ);
    }

    /* renamed from: oCFDzJ */
    public void m2077oCFDzJ(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        View view = abstractC0157mByQ.f1700mjFkc;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f1893rkYL.add(abstractC0157mByQ);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(m1564VA()).setListener(new KLFTb(abstractC0157mByQ, view, viewPropertyAnimatorAnimate)).start();
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0144MiMN
    /* renamed from: qGY */
    public boolean mo1570qGY() {
        return (this.f1892qdMbNW.isEmpty() && this.f1884ETF.isEmpty() && this.f1883Dt.isEmpty() && this.f1890lgHUyS.isEmpty() && this.f1891qGY.isEmpty() && this.f1889fehf.isEmpty() && this.f1893rkYL.isEmpty() && this.f1885IEE.isEmpty() && this.f1886MiMN.isEmpty() && this.f1887VA.isEmpty() && this.f1888YoKzxo.isEmpty()) ? false : true;
    }

    /* renamed from: uHVRx */
    public void m2078uHVRx() {
        if (mo1570qGY()) {
            return;
        }
        m1571qdMbNW();
    }

    @Override // androidx.recyclerview.p023widget.AbstractC0134MiMN
    /* renamed from: vI */
    public boolean mo1400vI(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        m2076nxI(abstractC0157mByQ);
        this.f1890lgHUyS.add(abstractC0157mByQ);
        return true;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0144MiMN
    /* renamed from: xJ */
    public boolean mo1573xJ(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, List list) {
        return !list.isEmpty() || super.mo1573xJ(abstractC0157mByQ, list);
    }

    /* renamed from: androidx.recyclerview.widget.wA$qdMbNW */
    public static class qdMbNW {

        /* renamed from: AZxh */
        public RecyclerView.AbstractC0157mByQ f1921AZxh;

        /* renamed from: JHa */
        public int f1922JHa;

        /* renamed from: KLFTb */
        public int f1923KLFTb;

        /* renamed from: ZfxDd */
        public int f1924ZfxDd;

        /* renamed from: mjFkc */
        public RecyclerView.AbstractC0157mByQ f1925mjFkc;

        /* renamed from: wA */
        public int f1926wA;

        public qdMbNW(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, RecyclerView.AbstractC0157mByQ abstractC0157mByQ2) {
            this.f1925mjFkc = abstractC0157mByQ;
            this.f1921AZxh = abstractC0157mByQ2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f1925mjFkc + ", newHolder=" + this.f1921AZxh + ", fromX=" + this.f1926wA + ", fromY=" + this.f1924ZfxDd + ", toX=" + this.f1923KLFTb + ", toY=" + this.f1922JHa + '}';
        }

        public qdMbNW(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, RecyclerView.AbstractC0157mByQ abstractC0157mByQ2, int i, int i2, int i3, int i4) {
            this(abstractC0157mByQ, abstractC0157mByQ2);
            this.f1926wA = i;
            this.f1924ZfxDd = i2;
            this.f1923KLFTb = i3;
            this.f1922JHa = i4;
        }
    }
}
