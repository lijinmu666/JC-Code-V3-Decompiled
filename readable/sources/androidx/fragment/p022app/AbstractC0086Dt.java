package androidx.fragment.p022app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.BuildConfig;
import p131o.AbstractC2876T9;
import p131o.AbstractC4925y4;
import p131o.C1726BxruE;
import p131o.InterfaceC3669f7;

/* renamed from: androidx.fragment.app.Dt */
/* loaded from: classes.dex */
public abstract class AbstractC0086Dt {

    /* renamed from: mjFkc */
    public final ViewGroup f1079mjFkc;

    /* renamed from: AZxh */
    public final ArrayList f1076AZxh = new ArrayList();

    /* renamed from: wA */
    public final ArrayList f1080wA = new ArrayList();

    /* renamed from: ZfxDd */
    public boolean f1078ZfxDd = false;

    /* renamed from: KLFTb */
    public boolean f1077KLFTb = false;

    /* renamed from: androidx.fragment.app.Dt$AZxh */
    public class AZxh implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ ZfxDd f1082mjFkc;

        public AZxh(ZfxDd zfxDd) {
            this.f1082mjFkc = zfxDd;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC0086Dt.this.f1076AZxh.remove(this.f1082mjFkc);
            AbstractC0086Dt.this.f1080wA.remove(this.f1082mjFkc);
        }
    }

    /* renamed from: androidx.fragment.app.Dt$KLFTb */
    public static class KLFTb {

        /* renamed from: AZxh */
        public AZxh f1083AZxh;

        /* renamed from: mjFkc */
        public wA f1087mjFkc;

        /* renamed from: wA */
        public final Fragment f1088wA;

        /* renamed from: ZfxDd */
        public final List f1086ZfxDd = new ArrayList();

        /* renamed from: KLFTb */
        public final HashSet f1085KLFTb = new HashSet();

        /* renamed from: JHa */
        public boolean f1084JHa = false;

        /* renamed from: xJ */
        public boolean f1089xJ = false;

        /* renamed from: androidx.fragment.app.Dt$KLFTb$AZxh */
        public enum AZxh {
            NONE,
            ADDING,
            REMOVING
        }

        /* renamed from: androidx.fragment.app.Dt$KLFTb$mjFkc */
        public class mjFkc implements C1726BxruE.mjFkc {
            public mjFkc() {
            }

            @Override // p131o.C1726BxruE.mjFkc
            /* renamed from: mjFkc */
            public void mo752mjFkc() {
                KLFTb.this.m738AZxh();
            }
        }

        /* renamed from: androidx.fragment.app.Dt$KLFTb$wA */
        public enum wA {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            /* renamed from: lgHUyS */
            public static wA m753lgHUyS(int i) {
                if (i == 0) {
                    return VISIBLE;
                }
                if (i == 4) {
                    return INVISIBLE;
                }
                if (i == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i);
            }

            /* renamed from: qdMbNW */
            public static wA m754qdMbNW(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : m753lgHUyS(view.getVisibility());
            }

            /* renamed from: KLFTb */
            public void m757KLFTb(View view) {
                int i = wA.f1104mjFkc[ordinal()];
                if (i == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (AbstractC0093KLFTb.m857dm(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    if (AbstractC0093KLFTb.m857dm(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i == 3) {
                    if (AbstractC0093KLFTb.m857dm(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i != 4) {
                    return;
                }
                if (AbstractC0093KLFTb.m857dm(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        public KLFTb(wA wAVar, AZxh aZxh, Fragment fragment, C1726BxruE c1726BxruE) {
            this.f1087mjFkc = wAVar;
            this.f1083AZxh = aZxh;
            this.f1088wA = fragment;
            c1726BxruE.m7740AZxh(new mjFkc());
        }

        /* renamed from: AZxh */
        public final void m738AZxh() {
            if (m745lgHUyS()) {
                return;
            }
            this.f1084JHa = true;
            if (this.f1085KLFTb.isEmpty()) {
                mo748wA();
                return;
            }
            Iterator it = new ArrayList(this.f1085KLFTb).iterator();
            while (it.hasNext()) {
                ((C1726BxruE) it.next()).m7741mjFkc();
            }
        }

        /* renamed from: Dt */
        public final void m739Dt(C1726BxruE c1726BxruE) {
            mo743VA();
            this.f1085KLFTb.add(c1726BxruE);
        }

        /* renamed from: ETF */
        public final void m740ETF(wA wAVar, AZxh aZxh) {
            int i = wA.f1103AZxh[aZxh.ordinal()];
            if (i == 1) {
                if (this.f1087mjFkc == wA.REMOVED) {
                    if (AbstractC0093KLFTb.m857dm(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f1088wA + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f1083AZxh + " to ADDING.");
                    }
                    this.f1087mjFkc = wA.VISIBLE;
                    this.f1083AZxh = AZxh.ADDING;
                    return;
                }
                return;
            }
            if (i == 2) {
                if (AbstractC0093KLFTb.m857dm(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f1088wA + " mFinalState = " + this.f1087mjFkc + " -> REMOVED. mLifecycleImpact  = " + this.f1083AZxh + " to REMOVING.");
                }
                this.f1087mjFkc = wA.REMOVED;
                this.f1083AZxh = AZxh.REMOVING;
                return;
            }
            if (i == 3 && this.f1087mjFkc != wA.REMOVED) {
                if (AbstractC0093KLFTb.m857dm(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f1088wA + " mFinalState = " + this.f1087mjFkc + " -> " + wAVar + ". ");
                }
                this.f1087mjFkc = wAVar;
            }
        }

        /* renamed from: JHa */
        public final Fragment m741JHa() {
            return this.f1088wA;
        }

        /* renamed from: KLFTb */
        public wA m742KLFTb() {
            return this.f1087mjFkc;
        }

        /* renamed from: VA */
        public abstract void mo743VA();

        /* renamed from: ZfxDd */
        public final void m744ZfxDd(C1726BxruE c1726BxruE) {
            if (this.f1085KLFTb.remove(c1726BxruE) && this.f1085KLFTb.isEmpty()) {
                mo748wA();
            }
        }

        /* renamed from: lgHUyS */
        public final boolean m745lgHUyS() {
            return this.f1084JHa;
        }

        /* renamed from: mjFkc */
        public final void m746mjFkc(Runnable runnable) {
            this.f1086ZfxDd.add(runnable);
        }

        /* renamed from: qdMbNW */
        public final boolean m747qdMbNW() {
            return this.f1089xJ;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f1087mjFkc + "} {mLifecycleImpact = " + this.f1083AZxh + "} {mFragment = " + this.f1088wA + "}";
        }

        /* renamed from: wA */
        public void mo748wA() {
            if (this.f1089xJ) {
                return;
            }
            if (AbstractC0093KLFTb.m857dm(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f1089xJ = true;
            Iterator it = this.f1086ZfxDd.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        /* renamed from: xJ */
        public AZxh m749xJ() {
            return this.f1083AZxh;
        }
    }

    /* renamed from: androidx.fragment.app.Dt$ZfxDd */
    public static class ZfxDd extends KLFTb {

        /* renamed from: lgHUyS */
        public final C0099xJ f1100lgHUyS;

        public ZfxDd(KLFTb.wA wAVar, KLFTb.AZxh aZxh, C0099xJ c0099xJ, C1726BxruE c1726BxruE) {
            super(wAVar, aZxh, c0099xJ.m1008ETF(), c1726BxruE);
            this.f1100lgHUyS = c0099xJ;
        }

        @Override // androidx.fragment.p022app.AbstractC0086Dt.KLFTb
        /* renamed from: VA */
        public void mo743VA() {
            if (m749xJ() == KLFTb.AZxh.ADDING) {
                Fragment fragmentM1008ETF = this.f1100lgHUyS.m1008ETF();
                View viewFindFocus = fragmentM1008ETF.f1140mByQ.findFocus();
                if (viewFindFocus != null) {
                    fragmentM1008ETF.m791Vgyli(viewFindFocus);
                    if (AbstractC0093KLFTb.m857dm(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragmentM1008ETF);
                    }
                }
                View viewM799XbiWeM = m741JHa().m799XbiWeM();
                if (viewM799XbiWeM.getParent() == null) {
                    this.f1100lgHUyS.m1006AZxh();
                    viewM799XbiWeM.setAlpha(0.0f);
                }
                if (viewM799XbiWeM.getAlpha() == 0.0f && viewM799XbiWeM.getVisibility() == 0) {
                    viewM799XbiWeM.setVisibility(4);
                }
                viewM799XbiWeM.setAlpha(fragmentM1008ETF.m842wJVbdd());
            }
        }

        @Override // androidx.fragment.p022app.AbstractC0086Dt.KLFTb
        /* renamed from: wA */
        public void mo748wA() {
            super.mo748wA();
            this.f1100lgHUyS.m1012MiMN();
        }
    }

    /* renamed from: androidx.fragment.app.Dt$mjFkc */
    public class mjFkc implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ ZfxDd f1102mjFkc;

        public mjFkc(ZfxDd zfxDd) {
            this.f1102mjFkc = zfxDd;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbstractC0086Dt.this.f1076AZxh.contains(this.f1102mjFkc)) {
                this.f1102mjFkc.m742KLFTb().m757KLFTb(this.f1102mjFkc.m741JHa().f1140mByQ);
            }
        }
    }

    /* renamed from: androidx.fragment.app.Dt$wA */
    public static /* synthetic */ class wA {

        /* renamed from: AZxh */
        public static final /* synthetic */ int[] f1103AZxh;

        /* renamed from: mjFkc */
        public static final /* synthetic */ int[] f1104mjFkc;

        static {
            int[] iArr = new int[KLFTb.AZxh.m751values().length];
            f1103AZxh = iArr;
            try {
                iArr[KLFTb.AZxh.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1103AZxh[KLFTb.AZxh.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1103AZxh[KLFTb.AZxh.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[KLFTb.wA.m756values().length];
            f1104mjFkc = iArr2;
            try {
                iArr2[KLFTb.wA.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1104mjFkc[KLFTb.wA.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1104mjFkc[KLFTb.wA.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1104mjFkc[KLFTb.wA.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public AbstractC0086Dt(ViewGroup viewGroup) {
        this.f1079mjFkc = viewGroup;
    }

    /* renamed from: MiMN */
    public static AbstractC0086Dt m721MiMN(ViewGroup viewGroup, AbstractC0093KLFTb abstractC0093KLFTb) {
        return m722YoKzxo(viewGroup, abstractC0093KLFTb.m889SwgkN());
    }

    /* renamed from: YoKzxo */
    public static AbstractC0086Dt m722YoKzxo(ViewGroup viewGroup, InterfaceC3669f7 interfaceC3669f7) {
        Object tag = viewGroup.getTag(AbstractC4925y4.f17474AZxh);
        if (tag instanceof AbstractC0086Dt) {
            return (AbstractC0086Dt) tag;
        }
        AbstractC0086Dt abstractC0086DtMo949mjFkc = interfaceC3669f7.mo949mjFkc(viewGroup);
        viewGroup.setTag(AbstractC4925y4.f17474AZxh, abstractC0086DtMo949mjFkc);
        return abstractC0086DtMo949mjFkc;
    }

    /* renamed from: AZxh */
    public void m723AZxh(KLFTb.wA wAVar, C0099xJ c0099xJ) {
        if (AbstractC0093KLFTb.m857dm(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + c0099xJ.m1008ETF());
        }
        m732mjFkc(wAVar, KLFTb.AZxh.ADDING, c0099xJ);
    }

    /* renamed from: Dt */
    public void m724Dt() {
        String str;
        String str2;
        boolean zM10268cMLeY = AbstractC2876T9.m10268cMLeY(this.f1079mjFkc);
        synchronized (this.f1076AZxh) {
            try {
                m733qGY();
                Iterator it = this.f1076AZxh.iterator();
                while (it.hasNext()) {
                    ((KLFTb) it.next()).mo743VA();
                }
                Iterator it2 = new ArrayList(this.f1080wA).iterator();
                while (it2.hasNext()) {
                    KLFTb kLFTb = (KLFTb) it2.next();
                    if (AbstractC0093KLFTb.m857dm(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        if (zM10268cMLeY) {
                            str2 = BuildConfig.f24315FLAVOR;
                        } else {
                            str2 = "Container " + this.f1079mjFkc + " is not attached to window. ";
                        }
                        sb.append(str2);
                        sb.append("Cancelling running operation ");
                        sb.append(kLFTb);
                        Log.v("FragmentManager", sb.toString());
                    }
                    kLFTb.m738AZxh();
                }
                Iterator it3 = new ArrayList(this.f1076AZxh).iterator();
                while (it3.hasNext()) {
                    KLFTb kLFTb2 = (KLFTb) it3.next();
                    if (AbstractC0093KLFTb.m857dm(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (zM10268cMLeY) {
                            str = BuildConfig.f24315FLAVOR;
                        } else {
                            str = "Container " + this.f1079mjFkc + " is not attached to window. ";
                        }
                        sb2.append(str);
                        sb2.append("Cancelling pending operation ");
                        sb2.append(kLFTb2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    kLFTb2.m738AZxh();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: ETF */
    public KLFTb.AZxh m725ETF(C0099xJ c0099xJ) {
        KLFTb kLFTbM731lgHUyS = m731lgHUyS(c0099xJ.m1008ETF());
        KLFTb.AZxh aZxhM749xJ = kLFTbM731lgHUyS != null ? kLFTbM731lgHUyS.m749xJ() : null;
        KLFTb kLFTbM734qdMbNW = m734qdMbNW(c0099xJ.m1008ETF());
        return (kLFTbM734qdMbNW == null || !(aZxhM749xJ == null || aZxhM749xJ == KLFTb.AZxh.NONE)) ? aZxhM749xJ : kLFTbM734qdMbNW.m749xJ();
    }

    /* renamed from: JHa */
    public abstract void mo726JHa(List list, boolean z);

    /* renamed from: KLFTb */
    public void m727KLFTb(C0099xJ c0099xJ) {
        if (AbstractC0093KLFTb.m857dm(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + c0099xJ.m1008ETF());
        }
        m732mjFkc(KLFTb.wA.VISIBLE, KLFTb.AZxh.NONE, c0099xJ);
    }

    /* renamed from: VA */
    public ViewGroup m728VA() {
        return this.f1079mjFkc;
    }

    /* renamed from: ZfxDd */
    public void m729ZfxDd(C0099xJ c0099xJ) {
        if (AbstractC0093KLFTb.m857dm(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + c0099xJ.m1008ETF());
        }
        m732mjFkc(KLFTb.wA.REMOVED, KLFTb.AZxh.REMOVING, c0099xJ);
    }

    /* renamed from: fehf */
    public void m730fehf(boolean z) {
        this.f1078ZfxDd = z;
    }

    /* renamed from: lgHUyS */
    public final KLFTb m731lgHUyS(Fragment fragment) {
        Iterator it = this.f1076AZxh.iterator();
        while (it.hasNext()) {
            KLFTb kLFTb = (KLFTb) it.next();
            if (kLFTb.m741JHa().m808equals(fragment) && !kLFTb.m745lgHUyS()) {
                return kLFTb;
            }
        }
        return null;
    }

    /* renamed from: mjFkc */
    public final void m732mjFkc(KLFTb.wA wAVar, KLFTb.AZxh aZxh, C0099xJ c0099xJ) {
        synchronized (this.f1076AZxh) {
            try {
                C1726BxruE c1726BxruE = new C1726BxruE();
                KLFTb kLFTbM731lgHUyS = m731lgHUyS(c0099xJ.m1008ETF());
                if (kLFTbM731lgHUyS != null) {
                    kLFTbM731lgHUyS.m740ETF(wAVar, aZxh);
                    return;
                }
                ZfxDd zfxDd = new ZfxDd(wAVar, aZxh, c0099xJ, c1726BxruE);
                this.f1076AZxh.add(zfxDd);
                zfxDd.m746mjFkc(new mjFkc(zfxDd));
                zfxDd.m746mjFkc(new AZxh(zfxDd));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: qGY */
    public final void m733qGY() {
        Iterator it = this.f1076AZxh.iterator();
        while (it.hasNext()) {
            KLFTb kLFTb = (KLFTb) it.next();
            if (kLFTb.m749xJ() == KLFTb.AZxh.ADDING) {
                kLFTb.m740ETF(KLFTb.wA.m753lgHUyS(kLFTb.m741JHa().m799XbiWeM().getVisibility()), KLFTb.AZxh.NONE);
            }
        }
    }

    /* renamed from: qdMbNW */
    public final KLFTb m734qdMbNW(Fragment fragment) {
        Iterator it = this.f1080wA.iterator();
        while (it.hasNext()) {
            KLFTb kLFTb = (KLFTb) it.next();
            if (kLFTb.m741JHa().m808equals(fragment) && !kLFTb.m745lgHUyS()) {
                return kLFTb;
            }
        }
        return null;
    }

    /* renamed from: rkYL */
    public void m735rkYL() {
        synchronized (this.f1076AZxh) {
            try {
                m733qGY();
                this.f1077KLFTb = false;
                int size = this.f1076AZxh.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    KLFTb kLFTb = (KLFTb) this.f1076AZxh.get(size);
                    KLFTb.wA wAVarM754qdMbNW = KLFTb.wA.m754qdMbNW(kLFTb.m741JHa().f1140mByQ);
                    KLFTb.wA wAVarM742KLFTb = kLFTb.m742KLFTb();
                    KLFTb.wA wAVar = KLFTb.wA.VISIBLE;
                    if (wAVarM742KLFTb == wAVar && wAVarM754qdMbNW != wAVar) {
                        this.f1077KLFTb = kLFTb.m741JHa().m803aqHPIZ();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: wA */
    public void m736wA(C0099xJ c0099xJ) {
        if (AbstractC0093KLFTb.m857dm(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + c0099xJ.m1008ETF());
        }
        m732mjFkc(KLFTb.wA.GONE, KLFTb.AZxh.NONE, c0099xJ);
    }

    /* renamed from: xJ */
    public void m737xJ() {
        if (this.f1077KLFTb) {
            return;
        }
        if (!AbstractC2876T9.m10268cMLeY(this.f1079mjFkc)) {
            m724Dt();
            this.f1078ZfxDd = false;
            return;
        }
        synchronized (this.f1076AZxh) {
            try {
                if (!this.f1076AZxh.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f1080wA);
                    this.f1080wA.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        KLFTb kLFTb = (KLFTb) it.next();
                        if (AbstractC0093KLFTb.m857dm(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + kLFTb);
                        }
                        kLFTb.m738AZxh();
                        if (!kLFTb.m747qdMbNW()) {
                            this.f1080wA.add(kLFTb);
                        }
                    }
                    m733qGY();
                    ArrayList arrayList2 = new ArrayList(this.f1076AZxh);
                    this.f1076AZxh.clear();
                    this.f1080wA.addAll(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((KLFTb) it2.next()).mo743VA();
                    }
                    mo726JHa(arrayList2, this.f1078ZfxDd);
                    this.f1078ZfxDd = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
