package p131o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.p007view.WindowInsetsAnimation$Callback;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import p131o.C3372ab;

/* renamed from: o.Na */
/* loaded from: classes.dex */
public final class C2514Na {

    /* renamed from: mjFkc */
    public KLFTb f9767mjFkc;

    /* renamed from: o.Na$AZxh */
    public static abstract class AZxh {

        /* renamed from: AZxh */
        public final int f9768AZxh;

        /* renamed from: mjFkc */
        public WindowInsets f9769mjFkc;

        public AZxh(int i) {
            this.f9768AZxh = i;
        }

        /* renamed from: AZxh */
        public abstract void mo9697AZxh(C2514Na c2514Na);

        /* renamed from: KLFTb */
        public abstract mjFkc mo9698KLFTb(C2514Na c2514Na, mjFkc mjfkc);

        /* renamed from: ZfxDd */
        public abstract C3372ab mo9699ZfxDd(C3372ab c3372ab, List list);

        /* renamed from: mjFkc */
        public final int m9700mjFkc() {
            return this.f9768AZxh;
        }

        /* renamed from: wA */
        public abstract void mo9701wA(C2514Na c2514Na);
    }

    /* renamed from: o.Na$KLFTb */
    public static class KLFTb {

        /* renamed from: AZxh */
        public float f9770AZxh;

        /* renamed from: ZfxDd */
        public final long f9771ZfxDd;

        /* renamed from: mjFkc */
        public final int f9772mjFkc;

        /* renamed from: wA */
        public final Interpolator f9773wA;

        public KLFTb(int i, Interpolator interpolator, long j) {
            this.f9772mjFkc = i;
            this.f9773wA = interpolator;
            this.f9771ZfxDd = j;
        }

        /* renamed from: AZxh */
        public float mo9702AZxh() {
            Interpolator interpolator = this.f9773wA;
            return interpolator != null ? interpolator.getInterpolation(this.f9770AZxh) : this.f9770AZxh;
        }

        /* renamed from: ZfxDd */
        public void mo9703ZfxDd(float f) {
            this.f9770AZxh = f;
        }

        /* renamed from: mjFkc */
        public long mo9704mjFkc() {
            return this.f9771ZfxDd;
        }

        /* renamed from: wA */
        public int mo9705wA() {
            return this.f9772mjFkc;
        }
    }

    /* renamed from: o.Na$wA */
    public static class wA extends KLFTb {

        /* renamed from: KLFTb */
        public static final Interpolator f9782KLFTb = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

        /* renamed from: JHa */
        public static final Interpolator f9781JHa = new C2432MLqR();

        /* renamed from: xJ */
        public static final Interpolator f9783xJ = new DecelerateInterpolator();

        /* renamed from: o.Na$wA$mjFkc */
        public static class mjFkc implements View.OnApplyWindowInsetsListener {

            /* renamed from: AZxh */
            public C3372ab f9784AZxh;

            /* renamed from: mjFkc */
            public final AZxh f9785mjFkc;

            /* renamed from: o.Na$wA$mjFkc$AZxh */
            public class AZxh extends AnimatorListenerAdapter {

                /* renamed from: AZxh */
                public final /* synthetic */ View f9786AZxh;

                /* renamed from: mjFkc */
                public final /* synthetic */ C2514Na f9787mjFkc;

                public AZxh(C2514Na c2514Na, View view) {
                    this.f9787mjFkc = c2514Na;
                    this.f9786AZxh = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.f9787mjFkc.m9694KLFTb(1.0f);
                    wA.m9726qdMbNW(this.f9786AZxh, this.f9787mjFkc);
                }
            }

            /* renamed from: o.Na$wA$mjFkc$mjFkc, reason: collision with other inner class name */
            public class C6360mjFkc implements ValueAnimator.AnimatorUpdateListener {

                /* renamed from: AZxh */
                public final /* synthetic */ C3372ab f9789AZxh;

                /* renamed from: KLFTb */
                public final /* synthetic */ View f9791KLFTb;

                /* renamed from: ZfxDd */
                public final /* synthetic */ int f9792ZfxDd;

                /* renamed from: mjFkc */
                public final /* synthetic */ C2514Na f9793mjFkc;

                /* renamed from: wA */
                public final /* synthetic */ C3372ab f9794wA;

                public C6360mjFkc(C2514Na c2514Na, C3372ab c3372ab, C3372ab c3372ab2, int i, View view) {
                    this.f9793mjFkc = c2514Na;
                    this.f9789AZxh = c3372ab;
                    this.f9794wA = c3372ab2;
                    this.f9792ZfxDd = i;
                    this.f9791KLFTb = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f9793mjFkc.m9694KLFTb(valueAnimator.getAnimatedFraction());
                    wA.m9718ETF(this.f9791KLFTb, wA.m9727rkYL(this.f9789AZxh, this.f9794wA, this.f9793mjFkc.m9693AZxh(), this.f9792ZfxDd), Collections.singletonList(this.f9793mjFkc));
                }
            }

            /* renamed from: o.Na$wA$mjFkc$wA, reason: collision with other inner class name */
            public class RunnableC6361wA implements Runnable {

                /* renamed from: AZxh */
                public final /* synthetic */ C2514Na f9795AZxh;

                /* renamed from: ZfxDd */
                public final /* synthetic */ ValueAnimator f9797ZfxDd;

                /* renamed from: mjFkc */
                public final /* synthetic */ View f9798mjFkc;

                /* renamed from: wA */
                public final /* synthetic */ mjFkc f9799wA;

                public RunnableC6361wA(View view, C2514Na c2514Na, mjFkc mjfkc, ValueAnimator valueAnimator) {
                    this.f9798mjFkc = view;
                    this.f9795AZxh = c2514Na;
                    this.f9799wA = mjfkc;
                    this.f9797ZfxDd = valueAnimator;
                }

                @Override // java.lang.Runnable
                public void run() {
                    wA.m9722VA(this.f9798mjFkc, this.f9795AZxh, this.f9799wA);
                    this.f9797ZfxDd.start();
                }
            }

            public mjFkc(View view, AZxh aZxh) {
                this.f9785mjFkc = aZxh;
                C3372ab c3372abM10279lB = AbstractC2876T9.m10279lB(view);
                this.f9784AZxh = c3372abM10279lB != null ? new C3372ab.AZxh(c3372abM10279lB).m11352mjFkc() : null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                int iM9720KLFTb;
                if (!view.isLaidOut()) {
                    this.f9784AZxh = C3372ab.m11331diqgf(windowInsets, view);
                    return wA.m9721MiMN(view, windowInsets);
                }
                C3372ab c3372abM11331diqgf = C3372ab.m11331diqgf(windowInsets, view);
                if (this.f9784AZxh == null) {
                    this.f9784AZxh = AbstractC2876T9.m10279lB(view);
                }
                if (this.f9784AZxh == null) {
                    this.f9784AZxh = c3372abM11331diqgf;
                    return wA.m9721MiMN(view, windowInsets);
                }
                AZxh aZxhM9723YoKzxo = wA.m9723YoKzxo(view);
                if ((aZxhM9723YoKzxo == null || !Objects.equals(aZxhM9723YoKzxo.f9769mjFkc, windowInsets)) && (iM9720KLFTb = wA.m9720KLFTb(c3372abM11331diqgf, this.f9784AZxh)) != 0) {
                    C3372ab c3372ab = this.f9784AZxh;
                    C2514Na c2514Na = new C2514Na(iM9720KLFTb, wA.m9728xJ(iM9720KLFTb, c3372abM11331diqgf, c3372ab), 160L);
                    c2514Na.m9694KLFTb(0.0f);
                    ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(c2514Na.m9695mjFkc());
                    mjFkc mjfkcM9719JHa = wA.m9719JHa(c3372abM11331diqgf, c3372ab, iM9720KLFTb);
                    wA.m9717Dt(view, c2514Na, windowInsets, false);
                    duration.addUpdateListener(new C6360mjFkc(c2514Na, c3372abM11331diqgf, c3372ab, iM9720KLFTb, view));
                    duration.addListener(new AZxh(c2514Na, view));
                    ViewTreeObserverOnPreDrawListenerC3799h3.m12163mjFkc(view, new RunnableC6361wA(view, c2514Na, mjfkcM9719JHa, duration));
                    this.f9784AZxh = c3372abM11331diqgf;
                    return wA.m9721MiMN(view, windowInsets);
                }
                return wA.m9721MiMN(view, windowInsets);
            }
        }

        public wA(int i, Interpolator interpolator, long j) {
            super(i, interpolator, j);
        }

        /* renamed from: Dt */
        public static void m9717Dt(View view, C2514Na c2514Na, WindowInsets windowInsets, boolean z) {
            AZxh aZxhM9723YoKzxo = m9723YoKzxo(view);
            if (aZxhM9723YoKzxo != null) {
                aZxhM9723YoKzxo.f9769mjFkc = windowInsets;
                if (!z) {
                    aZxhM9723YoKzxo.mo9701wA(c2514Na);
                    z = aZxhM9723YoKzxo.m9700mjFkc() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    m9717Dt(viewGroup.getChildAt(i), c2514Na, windowInsets, z);
                }
            }
        }

        /* renamed from: ETF */
        public static void m9718ETF(View view, C3372ab c3372ab, List list) {
            AZxh aZxhM9723YoKzxo = m9723YoKzxo(view);
            if (aZxhM9723YoKzxo != null) {
                c3372ab = aZxhM9723YoKzxo.mo9699ZfxDd(c3372ab, list);
                if (aZxhM9723YoKzxo.m9700mjFkc() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    m9718ETF(viewGroup.getChildAt(i), c3372ab, list);
                }
            }
        }

        /* renamed from: JHa */
        public static mjFkc m9719JHa(C3372ab c3372ab, C3372ab c3372ab2, int i) {
            C2798S c2798sM11336JHa = c3372ab.m11336JHa(i);
            C2798S c2798sM11336JHa2 = c3372ab2.m11336JHa(i);
            return new mjFkc(C2798S.m10118AZxh(Math.min(c2798sM11336JHa.f10508mjFkc, c2798sM11336JHa2.f10508mjFkc), Math.min(c2798sM11336JHa.f10506AZxh, c2798sM11336JHa2.f10506AZxh), Math.min(c2798sM11336JHa.f10509wA, c2798sM11336JHa2.f10509wA), Math.min(c2798sM11336JHa.f10507ZfxDd, c2798sM11336JHa2.f10507ZfxDd)), C2798S.m10118AZxh(Math.max(c2798sM11336JHa.f10508mjFkc, c2798sM11336JHa2.f10508mjFkc), Math.max(c2798sM11336JHa.f10506AZxh, c2798sM11336JHa2.f10506AZxh), Math.max(c2798sM11336JHa.f10509wA, c2798sM11336JHa2.f10509wA), Math.max(c2798sM11336JHa.f10507ZfxDd, c2798sM11336JHa2.f10507ZfxDd)));
        }

        /* renamed from: KLFTb */
        public static int m9720KLFTb(C3372ab c3372ab, C3372ab c3372ab2) {
            int i = 0;
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if (!c3372ab.m11336JHa(i2).m10123equals(c3372ab2.m11336JHa(i2))) {
                    i |= i2;
                }
            }
            return i;
        }

        /* renamed from: MiMN */
        public static WindowInsets m9721MiMN(View view, WindowInsets windowInsets) {
            return view.getTag(AbstractC4790w4.f17139cMLeY) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        /* renamed from: VA */
        public static void m9722VA(View view, C2514Na c2514Na, mjFkc mjfkc) {
            AZxh aZxhM9723YoKzxo = m9723YoKzxo(view);
            if (aZxhM9723YoKzxo != null) {
                aZxhM9723YoKzxo.mo9698KLFTb(c2514Na, mjfkc);
                if (aZxhM9723YoKzxo.m9700mjFkc() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    m9722VA(viewGroup.getChildAt(i), c2514Na, mjfkc);
                }
            }
        }

        /* renamed from: YoKzxo */
        public static AZxh m9723YoKzxo(View view) {
            Object tag = view.getTag(AbstractC4790w4.f17138aqHPIZ);
            if (tag instanceof mjFkc) {
                return ((mjFkc) tag).f9785mjFkc;
            }
            return null;
        }

        /* renamed from: lgHUyS */
        public static View.OnApplyWindowInsetsListener m9724lgHUyS(View view, AZxh aZxh) {
            return new mjFkc(view, aZxh);
        }

        /* renamed from: qGY */
        public static void m9725qGY(View view, AZxh aZxh) {
            Object tag = view.getTag(AbstractC4790w4.f17139cMLeY);
            if (aZxh == null) {
                view.setTag(AbstractC4790w4.f17138aqHPIZ, null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener(null);
                    return;
                }
                return;
            }
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListenerM9724lgHUyS = m9724lgHUyS(view, aZxh);
            view.setTag(AbstractC4790w4.f17138aqHPIZ, onApplyWindowInsetsListenerM9724lgHUyS);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListenerM9724lgHUyS);
            }
        }

        /* renamed from: qdMbNW */
        public static void m9726qdMbNW(View view, C2514Na c2514Na) {
            AZxh aZxhM9723YoKzxo = m9723YoKzxo(view);
            if (aZxhM9723YoKzxo != null) {
                aZxhM9723YoKzxo.mo9697AZxh(c2514Na);
                if (aZxhM9723YoKzxo.m9700mjFkc() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    m9726qdMbNW(viewGroup.getChildAt(i), c2514Na);
                }
            }
        }

        /* renamed from: rkYL */
        public static C3372ab m9727rkYL(C3372ab c3372ab, C3372ab c3372ab2, float f, int i) {
            C3372ab.AZxh aZxh = new C3372ab.AZxh(c3372ab);
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) == 0) {
                    aZxh.m11350AZxh(i2, c3372ab.m11336JHa(i2));
                } else {
                    C2798S c2798sM11336JHa = c3372ab.m11336JHa(i2);
                    C2798S c2798sM11336JHa2 = c3372ab2.m11336JHa(i2);
                    float f2 = 1.0f - f;
                    aZxh.m11350AZxh(i2, C3372ab.m11329MiMN(c2798sM11336JHa, (int) (((c2798sM11336JHa.f10508mjFkc - c2798sM11336JHa2.f10508mjFkc) * f2) + 0.5d), (int) (((c2798sM11336JHa.f10506AZxh - c2798sM11336JHa2.f10506AZxh) * f2) + 0.5d), (int) (((c2798sM11336JHa.f10509wA - c2798sM11336JHa2.f10509wA) * f2) + 0.5d), (int) (((c2798sM11336JHa.f10507ZfxDd - c2798sM11336JHa2.f10507ZfxDd) * f2) + 0.5d)));
                }
            }
            return aZxh.m11352mjFkc();
        }

        /* renamed from: xJ */
        public static Interpolator m9728xJ(int i, C3372ab c3372ab, C3372ab c3372ab2) {
            return (i & 8) != 0 ? c3372ab.m11336JHa(C3372ab.VA.m11389mjFkc()).f10507ZfxDd > c3372ab2.m11336JHa(C3372ab.VA.m11389mjFkc()).f10507ZfxDd ? f9782KLFTb : f9781JHa : f9783xJ;
        }
    }

    public C2514Na(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f9767mjFkc = new ZfxDd(i, interpolator, j);
        } else {
            this.f9767mjFkc = new wA(i, interpolator, j);
        }
    }

    /* renamed from: JHa */
    public static C2514Na m9691JHa(WindowInsetsAnimation windowInsetsAnimation) {
        return new C2514Na(windowInsetsAnimation);
    }

    /* renamed from: ZfxDd */
    public static void m9692ZfxDd(View view, AZxh aZxh) {
        if (Build.VERSION.SDK_INT >= 30) {
            ZfxDd.m9708lgHUyS(view, aZxh);
        } else {
            wA.m9725qGY(view, aZxh);
        }
    }

    /* renamed from: AZxh */
    public float m9693AZxh() {
        return this.f9767mjFkc.mo9702AZxh();
    }

    /* renamed from: KLFTb */
    public void m9694KLFTb(float f) {
        this.f9767mjFkc.mo9703ZfxDd(f);
    }

    /* renamed from: mjFkc */
    public long m9695mjFkc() {
        return this.f9767mjFkc.mo9704mjFkc();
    }

    /* renamed from: wA */
    public int m9696wA() {
        return this.f9767mjFkc.mo9705wA();
    }

    /* renamed from: o.Na$ZfxDd */
    public static class ZfxDd extends KLFTb {

        /* renamed from: KLFTb */
        public final WindowInsetsAnimation f9774KLFTb;

        /* renamed from: o.Na$ZfxDd$mjFkc */
        public static class mjFkc extends WindowInsetsAnimation$Callback {

            /* renamed from: AZxh */
            public List f9775AZxh;

            /* renamed from: ZfxDd */
            public final HashMap f9776ZfxDd;

            /* renamed from: mjFkc */
            public final AZxh f9777mjFkc;

            /* renamed from: wA */
            public ArrayList f9778wA;

            public mjFkc(AZxh aZxh) {
                super(aZxh.m9700mjFkc());
                this.f9776ZfxDd = new HashMap();
                this.f9777mjFkc = aZxh;
            }

            /* renamed from: mjFkc */
            public final C2514Na m9710mjFkc(WindowInsetsAnimation windowInsetsAnimation) {
                C2514Na c2514Na = (C2514Na) this.f9776ZfxDd.get(windowInsetsAnimation);
                if (c2514Na != null) {
                    return c2514Na;
                }
                C2514Na c2514NaM9691JHa = C2514Na.m9691JHa(windowInsetsAnimation);
                this.f9776ZfxDd.put(windowInsetsAnimation, c2514NaM9691JHa);
                return c2514NaM9691JHa;
            }

            /* renamed from: onEnd */
            public void m9711onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.f9777mjFkc.mo9697AZxh(m9710mjFkc(windowInsetsAnimation));
                this.f9776ZfxDd.remove(windowInsetsAnimation);
            }

            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.f9777mjFkc.mo9701wA(m9710mjFkc(windowInsetsAnimation));
            }

            public WindowInsets onProgress(WindowInsets windowInsets, List list) {
                ArrayList arrayList = this.f9778wA;
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList(list.size());
                    this.f9778wA = arrayList2;
                    this.f9775AZxh = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimationM11129mjFkc = AbstractC3237Ya.m11129mjFkc(list.get(size));
                    C2514Na c2514NaM9710mjFkc = m9710mjFkc(windowInsetsAnimationM11129mjFkc);
                    c2514NaM9710mjFkc.m9694KLFTb(windowInsetsAnimationM11129mjFkc.getFraction());
                    this.f9778wA.add(c2514NaM9710mjFkc);
                }
                return this.f9777mjFkc.mo9699ZfxDd(C3372ab.m11330Pq(windowInsets), this.f9775AZxh).m11335IEE();
            }

            /* renamed from: onStart */
            public WindowInsetsAnimation.Bounds m9712onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.f9777mjFkc.mo9698KLFTb(m9710mjFkc(windowInsetsAnimation), mjFkc.m9713ZfxDd(bounds)).m9716wA();
            }
        }

        public ZfxDd(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f9774KLFTb = windowInsetsAnimation;
        }

        /* renamed from: JHa */
        public static C2798S m9706JHa(WindowInsetsAnimation.Bounds bounds) {
            return C2798S.m10119ZfxDd(bounds.getUpperBound());
        }

        /* renamed from: KLFTb */
        public static WindowInsetsAnimation.Bounds m9707KLFTb(mjFkc mjfkc) {
            AbstractC3169Xa.m10946mjFkc();
            return AbstractC3102Wa.m10837mjFkc(mjfkc.m9715mjFkc().m10122KLFTb(), mjfkc.m9714AZxh().m10122KLFTb());
        }

        /* renamed from: lgHUyS */
        public static void m9708lgHUyS(View view, AZxh aZxh) {
            view.setWindowInsetsAnimationCallback(aZxh != null ? new mjFkc(aZxh) : null);
        }

        /* renamed from: xJ */
        public static C2798S m9709xJ(WindowInsetsAnimation.Bounds bounds) {
            return C2798S.m10119ZfxDd(bounds.getLowerBound());
        }

        @Override // p131o.C2514Na.KLFTb
        /* renamed from: AZxh */
        public float mo9702AZxh() {
            return this.f9774KLFTb.getInterpolatedFraction();
        }

        @Override // p131o.C2514Na.KLFTb
        /* renamed from: ZfxDd */
        public void mo9703ZfxDd(float f) {
            this.f9774KLFTb.setFraction(f);
        }

        @Override // p131o.C2514Na.KLFTb
        /* renamed from: mjFkc */
        public long mo9704mjFkc() {
            return this.f9774KLFTb.getDurationMillis();
        }

        @Override // p131o.C2514Na.KLFTb
        /* renamed from: wA */
        public int mo9705wA() {
            return this.f9774KLFTb.getTypeMask();
        }

        public ZfxDd(int i, Interpolator interpolator, long j) {
            this(AbstractC3034Va.m10693mjFkc(i, interpolator, j));
        }
    }

    /* renamed from: o.Na$mjFkc */
    public static final class mjFkc {

        /* renamed from: AZxh */
        public final C2798S f9779AZxh;

        /* renamed from: mjFkc */
        public final C2798S f9780mjFkc;

        public mjFkc(C2798S c2798s, C2798S c2798s2) {
            this.f9780mjFkc = c2798s;
            this.f9779AZxh = c2798s2;
        }

        /* renamed from: ZfxDd */
        public static mjFkc m9713ZfxDd(WindowInsetsAnimation.Bounds bounds) {
            return new mjFkc(bounds);
        }

        /* renamed from: AZxh */
        public C2798S m9714AZxh() {
            return this.f9779AZxh;
        }

        /* renamed from: mjFkc */
        public C2798S m9715mjFkc() {
            return this.f9780mjFkc;
        }

        public String toString() {
            return "Bounds{lower=" + this.f9780mjFkc + " upper=" + this.f9779AZxh + "}";
        }

        /* renamed from: wA */
        public WindowInsetsAnimation.Bounds m9716wA() {
            return ZfxDd.m9707KLFTb(this);
        }

        public mjFkc(WindowInsetsAnimation.Bounds bounds) {
            this.f9780mjFkc = ZfxDd.m9709xJ(bounds);
            this.f9779AZxh = ZfxDd.m9706JHa(bounds);
        }
    }

    public C2514Na(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f9767mjFkc = new ZfxDd(windowInsetsAnimation);
        }
    }
}
