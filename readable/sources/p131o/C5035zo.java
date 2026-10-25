package p131o;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.p022app.Fragment;
import java.util.ArrayList;
import java.util.List;

/* renamed from: o.zo */
/* loaded from: classes.dex */
public class C5035zo extends AbstractC2318KbpP {

    /* renamed from: o.zo$AZxh */
    public class AZxh implements Transition.TransitionListener {

        /* renamed from: AZxh */
        public final /* synthetic */ ArrayList f17714AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ View f17715mjFkc;

        public AZxh(View view, ArrayList arrayList) {
            this.f17715mjFkc = view;
            this.f17714AZxh = arrayList;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.f17715mjFkc.setVisibility(8);
            int size = this.f17714AZxh.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f17714AZxh.get(i)).setVisibility(0);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }
    }

    /* renamed from: o.zo$KLFTb */
    public class KLFTb extends Transition.EpicenterCallback {

        /* renamed from: mjFkc */
        public final /* synthetic */ Rect f17718mjFkc;

        public KLFTb(Rect rect) {
            this.f17718mjFkc = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.f17718mjFkc;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f17718mjFkc;
        }
    }

    /* renamed from: o.zo$ZfxDd */
    public class ZfxDd implements Transition.TransitionListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ Runnable f17720mjFkc;

        public ZfxDd(Runnable runnable) {
            this.f17720mjFkc = runnable;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            this.f17720mjFkc.run();
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }
    }

    /* renamed from: o.zo$mjFkc */
    public class mjFkc extends Transition.EpicenterCallback {

        /* renamed from: mjFkc */
        public final /* synthetic */ Rect f17722mjFkc;

        public mjFkc(Rect rect) {
            this.f17722mjFkc = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            return this.f17722mjFkc;
        }
    }

    /* renamed from: o.zo$wA */
    public class wA implements Transition.TransitionListener {

        /* renamed from: AZxh */
        public final /* synthetic */ ArrayList f17723AZxh;

        /* renamed from: JHa */
        public final /* synthetic */ ArrayList f17724JHa;

        /* renamed from: KLFTb */
        public final /* synthetic */ Object f17725KLFTb;

        /* renamed from: ZfxDd */
        public final /* synthetic */ ArrayList f17726ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ Object f17727mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ Object f17728wA;

        public wA(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f17727mjFkc = obj;
            this.f17723AZxh = arrayList;
            this.f17728wA = obj2;
            this.f17726ZfxDd = arrayList2;
            this.f17725KLFTb = obj3;
            this.f17724JHa = arrayList3;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            Object obj = this.f17727mjFkc;
            if (obj != null) {
                C5035zo.this.m14130huTpC(obj, this.f17723AZxh, null);
            }
            Object obj2 = this.f17728wA;
            if (obj2 != null) {
                C5035zo.this.m14130huTpC(obj2, this.f17726ZfxDd, null);
            }
            Object obj3 = this.f17725KLFTb;
            if (obj3 != null) {
                C5035zo.this.m14130huTpC(obj3, this.f17724JHa, null);
            }
        }
    }

    /* renamed from: Ucbh */
    public static boolean m14129Ucbh(Transition transition) {
        return (AbstractC2318KbpP.m9248qdMbNW(transition.getTargetIds()) && AbstractC2318KbpP.m9248qdMbNW(transition.getTargetNames()) && AbstractC2318KbpP.m9248qdMbNW(transition.getTargetTypes())) ? false : true;
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: AZxh */
    public void mo9250AZxh(Object obj, ArrayList arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                mo9250AZxh(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
            return;
        }
        if (m14129Ucbh(transition) || !AbstractC2318KbpP.m9248qdMbNW(transition.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            transition.addTarget((View) arrayList.get(i));
            i++;
        }
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: Dt */
    public Object mo9251Dt(Object obj, Object obj2, Object obj3) {
        Transition ordering = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (ordering != null && transition != null) {
            ordering = new TransitionSet().addTransition(ordering).addTransition(transition).setOrdering(1);
        } else if (ordering == null) {
            ordering = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return ordering;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (ordering != null) {
            transitionSet.addTransition(ordering);
        }
        transitionSet.addTransition(transition2);
        return transitionSet;
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: ETF */
    public Object mo9252ETF(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: JHa */
    public Object mo9254JHa(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: KLFTb */
    public boolean mo9255KLFTb(Object obj) {
        return obj instanceof Transition;
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: MiMN */
    public void mo9256MiMN(Object obj, View view, ArrayList arrayList) {
        ((Transition) obj).addListener(new AZxh(view, arrayList));
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: Pq */
    public void mo9257Pq(Object obj, View view, ArrayList arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            AbstractC2318KbpP.m9247ZfxDd(targets, (View) arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        mo9250AZxh(transitionSet, arrayList);
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: YoKzxo */
    public void mo9259YoKzxo(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((Transition) obj).addListener(new wA(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: diqgf */
    public void mo9260diqgf(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            m14130huTpC(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: eyqo */
    public Object mo9261eyqo(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: fehf */
    public void mo9262fehf(Fragment fragment, Object obj, C1726BxruE c1726BxruE, Runnable runnable) {
        ((Transition) obj).addListener(new ZfxDd(runnable));
    }

    /* renamed from: huTpC */
    public void m14130huTpC(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                m14130huTpC(transitionSet.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (m14129Ucbh(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        int size = arrayList2 == null ? 0 : arrayList2.size();
        while (i < size) {
            transition.addTarget((View) arrayList2.get(i));
            i++;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            transition.removeTarget((View) arrayList.get(size2));
        }
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: mjFkc */
    public void mo9264mjFkc(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: qGY */
    public void mo9265qGY(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            m9263lgHUyS(view, rect);
            ((Transition) obj).setEpicenterCallback(new mjFkc(rect));
        }
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: rkYL */
    public void mo9266rkYL(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new KLFTb(rect));
        }
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: wA */
    public void mo9267wA(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }
}
