package androidx.fragment.p022app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.p022app.AbstractC0086Dt;
import androidx.fragment.p022app.AbstractC0094ZfxDd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p131o.AbstractC2280K3;
import p131o.AbstractC2318KbpP;
import p131o.AbstractC2876T9;
import p131o.AbstractC3277Z9;
import p131o.C1726BxruE;
import p131o.C4633tjSezt;
import p131o.ViewTreeObserverOnPreDrawListenerC3799h3;

/* renamed from: androidx.fragment.app.wA */
/* loaded from: classes.dex */
public class C0098wA extends AbstractC0086Dt {

    /* renamed from: androidx.fragment.app.wA$AZxh */
    public class AZxh implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ AbstractC0086Dt.KLFTb f1287AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ List f1288mjFkc;

        public AZxh(List list, AbstractC0086Dt.KLFTb kLFTb) {
            this.f1288mjFkc = list;
            this.f1287AZxh = kLFTb;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1288mjFkc.contains(this.f1287AZxh)) {
                this.f1288mjFkc.remove(this.f1287AZxh);
                C0098wA.this.m989IEE(this.f1287AZxh);
            }
        }
    }

    /* renamed from: androidx.fragment.app.wA$Dt */
    public class Dt implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ MiMN f1291mjFkc;

        public Dt(MiMN miMN) {
            this.f1291mjFkc = miMN;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1291mjFkc.m1004mjFkc();
        }
    }

    /* renamed from: androidx.fragment.app.wA$ETF */
    public static class ETF extends VA {

        /* renamed from: KLFTb */
        public AbstractC0094ZfxDd.mjFkc f1292KLFTb;

        /* renamed from: ZfxDd */
        public boolean f1293ZfxDd;

        /* renamed from: wA */
        public boolean f1294wA;

        public ETF(AbstractC0086Dt.KLFTb kLFTb, C1726BxruE c1726BxruE, boolean z) {
            super(kLFTb, c1726BxruE);
            this.f1293ZfxDd = false;
            this.f1294wA = z;
        }

        /* renamed from: KLFTb */
        public AbstractC0094ZfxDd.mjFkc m995KLFTb(Context context) throws Resources.NotFoundException {
            if (this.f1293ZfxDd) {
                return this.f1292KLFTb;
            }
            AbstractC0094ZfxDd.mjFkc mjfkcM954AZxh = AbstractC0094ZfxDd.m954AZxh(context, m1002AZxh().m741JHa(), m1002AZxh().m742KLFTb() == AbstractC0086Dt.KLFTb.wA.VISIBLE, this.f1294wA);
            this.f1292KLFTb = mjfkcM954AZxh;
            this.f1293ZfxDd = true;
            return mjfkcM954AZxh;
        }
    }

    /* renamed from: androidx.fragment.app.wA$JHa */
    public class JHa implements C1726BxruE.mjFkc {

        /* renamed from: AZxh */
        public final /* synthetic */ ViewGroup f1295AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ View f1297mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ ETF f1298wA;

        public JHa(View view, ViewGroup viewGroup, ETF etf) {
            this.f1297mjFkc = view;
            this.f1295AZxh = viewGroup;
            this.f1298wA = etf;
        }

        @Override // p131o.C1726BxruE.mjFkc
        /* renamed from: mjFkc */
        public void mo752mjFkc() {
            this.f1297mjFkc.clearAnimation();
            this.f1295AZxh.endViewTransition(this.f1297mjFkc);
            this.f1298wA.m1004mjFkc();
        }
    }

    /* renamed from: androidx.fragment.app.wA$KLFTb */
    public class KLFTb implements Animation.AnimationListener {

        /* renamed from: AZxh */
        public final /* synthetic */ View f1299AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ ViewGroup f1301mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ ETF f1302wA;

        /* renamed from: androidx.fragment.app.wA$KLFTb$mjFkc */
        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                KLFTb kLFTb = KLFTb.this;
                kLFTb.f1301mjFkc.endViewTransition(kLFTb.f1299AZxh);
                KLFTb.this.f1302wA.m1004mjFkc();
            }
        }

        public KLFTb(ViewGroup viewGroup, View view, ETF etf) {
            this.f1301mjFkc = viewGroup;
            this.f1299AZxh = view;
            this.f1302wA = etf;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f1301mjFkc.post(new mjFkc());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: androidx.fragment.app.wA$MiMN */
    public static class MiMN extends VA {

        /* renamed from: KLFTb */
        public final Object f1304KLFTb;

        /* renamed from: ZfxDd */
        public final boolean f1305ZfxDd;

        /* renamed from: wA */
        public final Object f1306wA;

        public MiMN(AbstractC0086Dt.KLFTb kLFTb, C1726BxruE c1726BxruE, boolean z, boolean z2) {
            super(kLFTb, c1726BxruE);
            if (kLFTb.m742KLFTb() == AbstractC0086Dt.KLFTb.wA.VISIBLE) {
                this.f1306wA = z ? kLFTb.m741JHa().m824mByQ() : kLFTb.m741JHa().m828qGY();
                this.f1305ZfxDd = z ? kLFTb.m741JHa().m763ETF() : kLFTb.m741JHa().m762Dt();
            } else {
                this.f1306wA = z ? kLFTb.m741JHa().m781Ne() : kLFTb.m741JHa().m783Pq();
                this.f1305ZfxDd = true;
            }
            if (!z2) {
                this.f1304KLFTb = null;
            } else if (z) {
                this.f1304KLFTb = kLFTb.m741JHa().m845xrEuO();
            } else {
                this.f1304KLFTb = kLFTb.m741JHa().m760CqaNbM();
            }
        }

        /* renamed from: Dt */
        public boolean m996Dt() {
            return this.f1305ZfxDd;
        }

        /* renamed from: JHa */
        public final AbstractC2318KbpP m997JHa(Object obj) {
            if (obj == null) {
                return null;
            }
            AbstractC2318KbpP abstractC2318KbpP = AbstractC0097qdMbNW.f1284AZxh;
            if (abstractC2318KbpP != null && abstractC2318KbpP.mo9255KLFTb(obj)) {
                return abstractC2318KbpP;
            }
            AbstractC2318KbpP abstractC2318KbpP2 = AbstractC0097qdMbNW.f1286wA;
            if (abstractC2318KbpP2 != null && abstractC2318KbpP2.mo9255KLFTb(obj)) {
                return abstractC2318KbpP2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + m1002AZxh().m741JHa() + " is not a valid framework Transition or AndroidX Transition");
        }

        /* renamed from: KLFTb */
        public AbstractC2318KbpP m998KLFTb() {
            AbstractC2318KbpP abstractC2318KbpPM997JHa = m997JHa(this.f1306wA);
            AbstractC2318KbpP abstractC2318KbpPM997JHa2 = m997JHa(this.f1304KLFTb);
            if (abstractC2318KbpPM997JHa == null || abstractC2318KbpPM997JHa2 == null || abstractC2318KbpPM997JHa == abstractC2318KbpPM997JHa2) {
                return abstractC2318KbpPM997JHa != null ? abstractC2318KbpPM997JHa : abstractC2318KbpPM997JHa2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + m1002AZxh().m741JHa() + " returned Transition " + this.f1306wA + " which uses a different Transition  type than its shared element transition " + this.f1304KLFTb);
        }

        /* renamed from: lgHUyS */
        public Object m999lgHUyS() {
            return this.f1306wA;
        }

        /* renamed from: qdMbNW */
        public boolean m1000qdMbNW() {
            return this.f1304KLFTb != null;
        }

        /* renamed from: xJ */
        public Object m1001xJ() {
            return this.f1304KLFTb;
        }
    }

    /* renamed from: androidx.fragment.app.wA$VA */
    public static class VA {

        /* renamed from: AZxh */
        public final C1726BxruE f1307AZxh;

        /* renamed from: mjFkc */
        public final AbstractC0086Dt.KLFTb f1308mjFkc;

        public VA(AbstractC0086Dt.KLFTb kLFTb, C1726BxruE c1726BxruE) {
            this.f1308mjFkc = kLFTb;
            this.f1307AZxh = c1726BxruE;
        }

        /* renamed from: AZxh */
        public AbstractC0086Dt.KLFTb m1002AZxh() {
            return this.f1308mjFkc;
        }

        /* renamed from: ZfxDd */
        public boolean m1003ZfxDd() {
            AbstractC0086Dt.KLFTb.wA wAVar;
            AbstractC0086Dt.KLFTb.wA wAVarM754qdMbNW = AbstractC0086Dt.KLFTb.wA.m754qdMbNW(this.f1308mjFkc.m741JHa().f1140mByQ);
            AbstractC0086Dt.KLFTb.wA wAVarM742KLFTb = this.f1308mjFkc.m742KLFTb();
            return wAVarM754qdMbNW == wAVarM742KLFTb || !(wAVarM754qdMbNW == (wAVar = AbstractC0086Dt.KLFTb.wA.VISIBLE) || wAVarM742KLFTb == wAVar);
        }

        /* renamed from: mjFkc */
        public void m1004mjFkc() {
            this.f1308mjFkc.m744ZfxDd(this.f1307AZxh);
        }

        /* renamed from: wA */
        public C1726BxruE m1005wA() {
            return this.f1307AZxh;
        }
    }

    /* renamed from: androidx.fragment.app.wA$ZfxDd */
    public class ZfxDd implements C1726BxruE.mjFkc {

        /* renamed from: mjFkc */
        public final /* synthetic */ Animator f1310mjFkc;

        public ZfxDd(Animator animator) {
            this.f1310mjFkc = animator;
        }

        @Override // p131o.C1726BxruE.mjFkc
        /* renamed from: mjFkc */
        public void mo752mjFkc() {
            this.f1310mjFkc.end();
        }
    }

    /* renamed from: androidx.fragment.app.wA$lgHUyS */
    public class lgHUyS implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ View f1311AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ AbstractC2318KbpP f1313mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ Rect f1314wA;

        public lgHUyS(AbstractC2318KbpP abstractC2318KbpP, View view, Rect rect) {
            this.f1313mjFkc = abstractC2318KbpP;
            this.f1311AZxh = view;
            this.f1314wA = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1313mjFkc.m9263lgHUyS(this.f1311AZxh, this.f1314wA);
        }
    }

    /* renamed from: androidx.fragment.app.wA$mjFkc */
    public static /* synthetic */ class mjFkc {

        /* renamed from: mjFkc */
        public static final /* synthetic */ int[] f1315mjFkc;

        static {
            int[] iArr = new int[AbstractC0086Dt.KLFTb.wA.m756values().length];
            f1315mjFkc = iArr;
            try {
                iArr[AbstractC0086Dt.KLFTb.wA.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1315mjFkc[AbstractC0086Dt.KLFTb.wA.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1315mjFkc[AbstractC0086Dt.KLFTb.wA.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1315mjFkc[AbstractC0086Dt.KLFTb.wA.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: androidx.fragment.app.wA$qdMbNW */
    public class qdMbNW implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ ArrayList f1317mjFkc;

        public qdMbNW(ArrayList arrayList) {
            this.f1317mjFkc = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC0097qdMbNW.m986ZfxDd(this.f1317mjFkc, 4);
        }
    }

    /* renamed from: androidx.fragment.app.wA$wA */
    public class wA extends AnimatorListenerAdapter {

        /* renamed from: AZxh */
        public final /* synthetic */ View f1318AZxh;

        /* renamed from: KLFTb */
        public final /* synthetic */ ETF f1320KLFTb;

        /* renamed from: ZfxDd */
        public final /* synthetic */ AbstractC0086Dt.KLFTb f1321ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ ViewGroup f1322mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ boolean f1323wA;

        public wA(ViewGroup viewGroup, View view, boolean z, AbstractC0086Dt.KLFTb kLFTb, ETF etf) {
            this.f1322mjFkc = viewGroup;
            this.f1318AZxh = view;
            this.f1323wA = z;
            this.f1321ZfxDd = kLFTb;
            this.f1320KLFTb = etf;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1322mjFkc.endViewTransition(this.f1318AZxh);
            if (this.f1323wA) {
                this.f1321ZfxDd.m742KLFTb().m757KLFTb(this.f1318AZxh);
            }
            this.f1320KLFTb.m1004mjFkc();
        }
    }

    /* renamed from: androidx.fragment.app.wA$xJ */
    public class xJ implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ AbstractC0086Dt.KLFTb f1324AZxh;

        /* renamed from: ZfxDd */
        public final /* synthetic */ C4633tjSezt f1326ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ AbstractC0086Dt.KLFTb f1327mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ boolean f1328wA;

        public xJ(AbstractC0086Dt.KLFTb kLFTb, AbstractC0086Dt.KLFTb kLFTb2, boolean z, C4633tjSezt c4633tjSezt) {
            this.f1327mjFkc = kLFTb;
            this.f1324AZxh = kLFTb2;
            this.f1328wA = z;
            this.f1326ZfxDd = c4633tjSezt;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC0097qdMbNW.m987mjFkc(this.f1327mjFkc.m741JHa(), this.f1324AZxh.m741JHa(), this.f1328wA, this.f1326ZfxDd, false);
        }
    }

    public C0098wA(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* renamed from: IEE */
    public void m989IEE(AbstractC0086Dt.KLFTb kLFTb) {
        kLFTb.m742KLFTb().m757KLFTb(kLFTb.m741JHa().f1140mByQ);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0082  */
    @Override // androidx.fragment.p022app.AbstractC0086Dt
    /* renamed from: JHa */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo726JHa(List list, boolean z) throws Resources.NotFoundException {
        Iterator it = list.iterator();
        AbstractC0086Dt.KLFTb kLFTb = null;
        AbstractC0086Dt.KLFTb kLFTb2 = null;
        while (it.hasNext()) {
            AbstractC0086Dt.KLFTb kLFTb3 = (AbstractC0086Dt.KLFTb) it.next();
            AbstractC0086Dt.KLFTb.wA wAVarM754qdMbNW = AbstractC0086Dt.KLFTb.wA.m754qdMbNW(kLFTb3.m741JHa().f1140mByQ);
            int i = mjFkc.f1315mjFkc[kLFTb3.m742KLFTb().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                if (wAVarM754qdMbNW == AbstractC0086Dt.KLFTb.wA.VISIBLE && kLFTb == null) {
                    kLFTb = kLFTb3;
                }
            } else if (i == 4 && wAVarM754qdMbNW != AbstractC0086Dt.KLFTb.wA.VISIBLE) {
                kLFTb2 = kLFTb3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            AbstractC0086Dt.KLFTb kLFTb4 = (AbstractC0086Dt.KLFTb) it2.next();
            C1726BxruE c1726BxruE = new C1726BxruE();
            kLFTb4.m739Dt(c1726BxruE);
            arrayList.add(new ETF(kLFTb4, c1726BxruE, z));
            C1726BxruE c1726BxruE2 = new C1726BxruE();
            kLFTb4.m739Dt(c1726BxruE2);
            boolean z2 = false;
            if (z) {
                if (kLFTb4 == kLFTb) {
                    z2 = true;
                }
            } else if (kLFTb4 == kLFTb2) {
            }
            arrayList2.add(new MiMN(kLFTb4, c1726BxruE2, z, z2));
            kLFTb4.m746mjFkc(new AZxh(arrayList3, kLFTb4));
        }
        Map mapM994huTpC = m994huTpC(arrayList2, arrayList3, z, kLFTb, kLFTb2);
        m991Ucbh(arrayList, arrayList3, mapM994huTpC.containsValue(Boolean.TRUE), mapM994huTpC);
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            m989IEE((AbstractC0086Dt.KLFTb) it3.next());
        }
        arrayList3.clear();
    }

    /* renamed from: Pq */
    public void m990Pq(ArrayList arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (AbstractC3277Z9.m11188mjFkc(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                m990Pq(arrayList, childAt);
            }
        }
    }

    /* renamed from: Ucbh */
    public final void m991Ucbh(List list, List list2, boolean z, Map map) throws Resources.NotFoundException {
        ViewGroup viewGroupM728VA = m728VA();
        Context context = viewGroupM728VA.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            ETF etf = (ETF) it.next();
            if (etf.m1003ZfxDd()) {
                etf.m1004mjFkc();
            } else {
                AbstractC0094ZfxDd.mjFkc mjfkcM995KLFTb = etf.m995KLFTb(context);
                if (mjfkcM995KLFTb == null) {
                    etf.m1004mjFkc();
                } else {
                    Animator animator = mjfkcM995KLFTb.f1252AZxh;
                    if (animator == null) {
                        arrayList.add(etf);
                    } else {
                        AbstractC0086Dt.KLFTb kLFTbM1002AZxh = etf.m1002AZxh();
                        Fragment fragmentM741JHa = kLFTbM1002AZxh.m741JHa();
                        if (Boolean.TRUE.equals(map.get(kLFTbM1002AZxh))) {
                            if (AbstractC0093KLFTb.m857dm(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragmentM741JHa + " as this Fragment was involved in a Transition.");
                            }
                            etf.m1004mjFkc();
                        } else {
                            boolean z3 = kLFTbM1002AZxh.m742KLFTb() == AbstractC0086Dt.KLFTb.wA.GONE;
                            if (z3) {
                                list2.remove(kLFTbM1002AZxh);
                            }
                            View view = fragmentM741JHa.f1140mByQ;
                            viewGroupM728VA.startViewTransition(view);
                            animator.addListener(new wA(viewGroupM728VA, view, z3, kLFTbM1002AZxh, etf));
                            animator.setTarget(view);
                            animator.start();
                            etf.m1005wA().m7740AZxh(new ZfxDd(animator));
                            z2 = true;
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ETF etf2 = (ETF) it2.next();
            AbstractC0086Dt.KLFTb kLFTbM1002AZxh2 = etf2.m1002AZxh();
            Fragment fragmentM741JHa2 = kLFTbM1002AZxh2.m741JHa();
            if (z) {
                if (AbstractC0093KLFTb.m857dm(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentM741JHa2 + " as Animations cannot run alongside Transitions.");
                }
                etf2.m1004mjFkc();
            } else if (z2) {
                if (AbstractC0093KLFTb.m857dm(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentM741JHa2 + " as Animations cannot run alongside Animators.");
                }
                etf2.m1004mjFkc();
            } else {
                View view2 = fragmentM741JHa2.f1140mByQ;
                Animation animation = (Animation) AbstractC2280K3.m9126xJ(((AbstractC0094ZfxDd.mjFkc) AbstractC2280K3.m9126xJ(etf2.m995KLFTb(context))).f1253mjFkc);
                if (kLFTbM1002AZxh2.m742KLFTb() != AbstractC0086Dt.KLFTb.wA.REMOVED) {
                    view2.startAnimation(animation);
                    etf2.m1004mjFkc();
                } else {
                    viewGroupM728VA.startViewTransition(view2);
                    AbstractC0094ZfxDd.AZxh aZxh = new AbstractC0094ZfxDd.AZxh(animation, viewGroupM728VA, view2);
                    aZxh.setAnimationListener(new KLFTb(viewGroupM728VA, view2, etf2));
                    view2.startAnimation(aZxh);
                }
                etf2.m1005wA().m7740AZxh(new JHa(view2, viewGroupM728VA, etf2));
            }
        }
    }

    /* renamed from: diqgf */
    public void m992diqgf(Map map, View view) {
        String strM10281mByQ = AbstractC2876T9.m10281mByQ(view);
        if (strM10281mByQ != null) {
            map.put(strM10281mByQ, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    m992diqgf(map, childAt);
                }
            }
        }
    }

    /* renamed from: eyqo */
    public void m993eyqo(C4633tjSezt c4633tjSezt, Collection collection) {
        Iterator it = c4633tjSezt.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(AbstractC2876T9.m10281mByQ((View) ((Map.Entry) it.next()).getValue()))) {
                it.remove();
            }
        }
    }

    /* renamed from: huTpC */
    public final Map m994huTpC(List list, List list2, boolean z, AbstractC0086Dt.KLFTb kLFTb, AbstractC0086Dt.KLFTb kLFTb2) {
        View view;
        Object obj;
        ArrayList arrayList;
        Object obj2;
        ArrayList arrayList2;
        AbstractC0086Dt.KLFTb kLFTb3;
        AbstractC0086Dt.KLFTb kLFTb4;
        View view2;
        Object objMo9252ETF;
        C4633tjSezt c4633tjSezt;
        ArrayList arrayList3;
        AbstractC0086Dt.KLFTb kLFTb5;
        ArrayList arrayList4;
        Rect rect;
        View view3;
        AbstractC2318KbpP abstractC2318KbpP;
        AbstractC0086Dt.KLFTb kLFTb6;
        View view4;
        boolean z2 = z;
        AbstractC0086Dt.KLFTb kLFTb7 = kLFTb;
        AbstractC0086Dt.KLFTb kLFTb8 = kLFTb2;
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        AbstractC2318KbpP abstractC2318KbpP2 = null;
        while (it.hasNext()) {
            MiMN miMN = (MiMN) it.next();
            if (!miMN.m1003ZfxDd()) {
                AbstractC2318KbpP abstractC2318KbpPM998KLFTb = miMN.m998KLFTb();
                if (abstractC2318KbpP2 == null) {
                    abstractC2318KbpP2 = abstractC2318KbpPM998KLFTb;
                } else if (abstractC2318KbpPM998KLFTb != null && abstractC2318KbpP2 != abstractC2318KbpPM998KLFTb) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + miMN.m1002AZxh().m741JHa() + " returned Transition " + miMN.m999lgHUyS() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (abstractC2318KbpP2 == null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                MiMN miMN2 = (MiMN) it2.next();
                map.put(miMN2.m1002AZxh(), Boolean.FALSE);
                miMN2.m1004mjFkc();
            }
            return map;
        }
        View view5 = new View(m728VA().getContext());
        Rect rect2 = new Rect();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        C4633tjSezt c4633tjSezt2 = new C4633tjSezt();
        Iterator it3 = list.iterator();
        Object obj3 = null;
        View view6 = null;
        boolean z3 = false;
        while (it3.hasNext()) {
            MiMN miMN3 = (MiMN) it3.next();
            if (!miMN3.m1000qdMbNW() || kLFTb7 == null || kLFTb8 == null) {
                c4633tjSezt = c4633tjSezt2;
                arrayList3 = arrayList6;
                kLFTb5 = kLFTb7;
                arrayList4 = arrayList5;
                rect = rect2;
                view3 = view5;
                abstractC2318KbpP = abstractC2318KbpP2;
                kLFTb6 = kLFTb8;
                view6 = view6;
            } else {
                Object objMo9261eyqo = abstractC2318KbpP2.mo9261eyqo(abstractC2318KbpP2.mo9254JHa(miMN3.m1001xJ()));
                ArrayList arrayListM774KLMXS = kLFTb2.m741JHa().m774KLMXS();
                ArrayList arrayListM774KLMXS2 = kLFTb.m741JHa().m774KLMXS();
                ArrayList arrayListM848zvd = kLFTb.m741JHa().m848zvd();
                View view7 = view6;
                int i = 0;
                while (i < arrayListM848zvd.size()) {
                    int iIndexOf = arrayListM774KLMXS.indexOf(arrayListM848zvd.get(i));
                    ArrayList arrayList7 = arrayListM848zvd;
                    if (iIndexOf != -1) {
                        arrayListM774KLMXS.set(iIndexOf, arrayListM774KLMXS2.get(i));
                    }
                    i++;
                    arrayListM848zvd = arrayList7;
                }
                ArrayList arrayListM848zvd2 = kLFTb2.m741JHa().m848zvd();
                if (z2) {
                    kLFTb.m741JHa().m812fehf();
                    kLFTb2.m741JHa().m806diqgf();
                } else {
                    kLFTb.m741JHa().m806diqgf();
                    kLFTb2.m741JHa().m812fehf();
                }
                int i2 = 0;
                for (int size = arrayListM774KLMXS.size(); i2 < size; size = size) {
                    c4633tjSezt2.m10821put((String) arrayListM774KLMXS.get(i2), (String) arrayListM848zvd2.get(i2));
                    i2++;
                }
                C4633tjSezt c4633tjSezt3 = new C4633tjSezt();
                m992diqgf(c4633tjSezt3, kLFTb.m741JHa().f1140mByQ);
                c4633tjSezt3.m13647rkYL(arrayListM774KLMXS);
                c4633tjSezt2.m13647rkYL(c4633tjSezt3.keySet());
                C4633tjSezt c4633tjSezt4 = new C4633tjSezt();
                m992diqgf(c4633tjSezt4, kLFTb2.m741JHa().f1140mByQ);
                c4633tjSezt4.m13647rkYL(arrayListM848zvd2);
                c4633tjSezt4.m13647rkYL(c4633tjSezt2.values());
                AbstractC0097qdMbNW.m988wA(c4633tjSezt2, c4633tjSezt4);
                m993eyqo(c4633tjSezt3, c4633tjSezt2.keySet());
                m993eyqo(c4633tjSezt4, c4633tjSezt2.values());
                if (c4633tjSezt2.m10818isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    c4633tjSezt = c4633tjSezt2;
                    arrayList3 = arrayList6;
                    kLFTb5 = kLFTb7;
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    abstractC2318KbpP = abstractC2318KbpP2;
                    view6 = view7;
                    obj3 = null;
                    kLFTb6 = kLFTb8;
                } else {
                    AbstractC0097qdMbNW.m987mjFkc(kLFTb2.m741JHa(), kLFTb.m741JHa(), z2, c4633tjSezt3, true);
                    c4633tjSezt = c4633tjSezt2;
                    ArrayList arrayList8 = arrayList6;
                    ViewTreeObserverOnPreDrawListenerC3799h3.m12163mjFkc(m728VA(), new xJ(kLFTb2, kLFTb, z, c4633tjSezt4));
                    arrayList5.addAll(c4633tjSezt3.values());
                    if (arrayListM774KLMXS.isEmpty()) {
                        view6 = view7;
                    } else {
                        view6 = (View) c4633tjSezt3.m10817get((String) arrayListM774KLMXS.get(0));
                        abstractC2318KbpP2.mo9265qGY(objMo9261eyqo, view6);
                    }
                    arrayList3 = arrayList8;
                    arrayList3.addAll(c4633tjSezt4.values());
                    if (!arrayListM848zvd2.isEmpty() && (view4 = (View) c4633tjSezt4.m10817get((String) arrayListM848zvd2.get(0))) != null) {
                        ViewTreeObserverOnPreDrawListenerC3799h3.m12163mjFkc(m728VA(), new lgHUyS(abstractC2318KbpP2, view4, rect2));
                        z3 = true;
                    }
                    abstractC2318KbpP2.mo9257Pq(objMo9261eyqo, view5, arrayList5);
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    abstractC2318KbpP = abstractC2318KbpP2;
                    abstractC2318KbpP2.mo9259YoKzxo(objMo9261eyqo, null, null, null, null, objMo9261eyqo, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    kLFTb5 = kLFTb;
                    map.put(kLFTb5, bool);
                    kLFTb6 = kLFTb2;
                    map.put(kLFTb6, bool);
                    obj3 = objMo9261eyqo;
                }
            }
            kLFTb7 = kLFTb5;
            arrayList5 = arrayList4;
            rect2 = rect;
            view5 = view3;
            kLFTb8 = kLFTb6;
            c4633tjSezt2 = c4633tjSezt;
            z2 = z;
            arrayList6 = arrayList3;
            abstractC2318KbpP2 = abstractC2318KbpP;
        }
        View view8 = view6;
        C4633tjSezt c4633tjSezt5 = c4633tjSezt2;
        ArrayList arrayList9 = arrayList6;
        AbstractC0086Dt.KLFTb kLFTb9 = kLFTb7;
        ArrayList arrayList10 = arrayList5;
        Rect rect3 = rect2;
        View view9 = view5;
        AbstractC2318KbpP abstractC2318KbpP3 = abstractC2318KbpP2;
        boolean z4 = false;
        AbstractC0086Dt.KLFTb kLFTb10 = kLFTb8;
        ArrayList arrayList11 = new ArrayList();
        Iterator it4 = list.iterator();
        Object obj4 = null;
        Object objMo9252ETF2 = null;
        while (it4.hasNext()) {
            MiMN miMN4 = (MiMN) it4.next();
            if (miMN4.m1003ZfxDd()) {
                map.put(miMN4.m1002AZxh(), Boolean.FALSE);
                miMN4.m1004mjFkc();
            } else {
                Object objMo9254JHa = abstractC2318KbpP3.mo9254JHa(miMN4.m999lgHUyS());
                AbstractC0086Dt.KLFTb kLFTbM1002AZxh = miMN4.m1002AZxh();
                boolean z5 = (obj3 == null || !(kLFTbM1002AZxh == kLFTb9 || kLFTbM1002AZxh == kLFTb10)) ? z4 : true;
                if (objMo9254JHa == null) {
                    if (!z5) {
                        map.put(kLFTbM1002AZxh, Boolean.FALSE);
                        miMN4.m1004mjFkc();
                    }
                    arrayList2 = arrayList9;
                    arrayList = arrayList10;
                    view = view9;
                    objMo9252ETF = obj4;
                    kLFTb3 = kLFTb10;
                    view2 = view8;
                } else {
                    ArrayList arrayList12 = new ArrayList();
                    Object obj5 = obj4;
                    m990Pq(arrayList12, kLFTbM1002AZxh.m741JHa().f1140mByQ);
                    if (z5) {
                        if (kLFTbM1002AZxh == kLFTb9) {
                            arrayList12.removeAll(arrayList10);
                        } else {
                            arrayList12.removeAll(arrayList9);
                        }
                    }
                    if (arrayList12.isEmpty()) {
                        abstractC2318KbpP3.mo9264mjFkc(objMo9254JHa, view9);
                        arrayList2 = arrayList9;
                        arrayList = arrayList10;
                        view = view9;
                        kLFTb4 = kLFTbM1002AZxh;
                        obj2 = objMo9252ETF2;
                        kLFTb3 = kLFTb10;
                        obj = obj5;
                    } else {
                        abstractC2318KbpP3.mo9250AZxh(objMo9254JHa, arrayList12);
                        view = view9;
                        obj = obj5;
                        arrayList = arrayList10;
                        obj2 = objMo9252ETF2;
                        arrayList2 = arrayList9;
                        kLFTb3 = kLFTb10;
                        abstractC2318KbpP3.mo9259YoKzxo(objMo9254JHa, objMo9254JHa, arrayList12, null, null, null, null);
                        if (kLFTbM1002AZxh.m742KLFTb() == AbstractC0086Dt.KLFTb.wA.GONE) {
                            kLFTb4 = kLFTbM1002AZxh;
                            list2.remove(kLFTb4);
                            ArrayList arrayList13 = new ArrayList(arrayList12);
                            arrayList13.remove(kLFTb4.m741JHa().f1140mByQ);
                            abstractC2318KbpP3.mo9256MiMN(objMo9254JHa, kLFTb4.m741JHa().f1140mByQ, arrayList13);
                            ViewTreeObserverOnPreDrawListenerC3799h3.m12163mjFkc(m728VA(), new qdMbNW(arrayList12));
                        } else {
                            kLFTb4 = kLFTbM1002AZxh;
                        }
                    }
                    if (kLFTb4.m742KLFTb() == AbstractC0086Dt.KLFTb.wA.VISIBLE) {
                        arrayList11.addAll(arrayList12);
                        if (z3) {
                            abstractC2318KbpP3.mo9266rkYL(objMo9254JHa, rect3);
                        }
                        view2 = view8;
                    } else {
                        view2 = view8;
                        abstractC2318KbpP3.mo9265qGY(objMo9254JHa, view2);
                    }
                    map.put(kLFTb4, Boolean.TRUE);
                    if (miMN4.m996Dt()) {
                        objMo9252ETF2 = abstractC2318KbpP3.mo9252ETF(obj2, objMo9254JHa, null);
                        objMo9252ETF = obj;
                    } else {
                        objMo9252ETF = abstractC2318KbpP3.mo9252ETF(obj, objMo9254JHa, null);
                        objMo9252ETF2 = obj2;
                    }
                }
                kLFTb10 = kLFTb3;
                obj4 = objMo9252ETF;
                view8 = view2;
                view9 = view;
                arrayList10 = arrayList;
                arrayList9 = arrayList2;
                z4 = false;
            }
        }
        ArrayList arrayList14 = arrayList9;
        ArrayList arrayList15 = arrayList10;
        AbstractC0086Dt.KLFTb kLFTb11 = kLFTb10;
        Object objMo9251Dt = abstractC2318KbpP3.mo9251Dt(objMo9252ETF2, obj4, obj3);
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            MiMN miMN5 = (MiMN) it5.next();
            if (!miMN5.m1003ZfxDd()) {
                Object objM999lgHUyS = miMN5.m999lgHUyS();
                AbstractC0086Dt.KLFTb kLFTbM1002AZxh2 = miMN5.m1002AZxh();
                boolean z6 = obj3 != null && (kLFTbM1002AZxh2 == kLFTb9 || kLFTbM1002AZxh2 == kLFTb11);
                if (objM999lgHUyS != null || z6) {
                    if (AbstractC2876T9.m10287rWxwaT(m728VA())) {
                        abstractC2318KbpP3.mo9262fehf(miMN5.m1002AZxh().m741JHa(), objMo9251Dt, miMN5.m1005wA(), new Dt(miMN5));
                    } else {
                        if (AbstractC0093KLFTb.m857dm(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Container " + m728VA() + " has not been laid out. Completing operation " + kLFTbM1002AZxh2);
                        }
                        miMN5.m1004mjFkc();
                    }
                }
            }
        }
        if (!AbstractC2876T9.m10287rWxwaT(m728VA())) {
            return map;
        }
        AbstractC0097qdMbNW.m986ZfxDd(arrayList11, 4);
        ArrayList arrayListM9258VA = abstractC2318KbpP3.m9258VA(arrayList14);
        abstractC2318KbpP3.mo9267wA(m728VA(), objMo9251Dt);
        abstractC2318KbpP3.m9253IEE(m728VA(), arrayList15, arrayList14, arrayListM9258VA, c4633tjSezt5);
        AbstractC0097qdMbNW.m986ZfxDd(arrayList11, 0);
        abstractC2318KbpP3.mo9260diqgf(obj3, arrayList15, arrayList14);
        return map;
    }
}
