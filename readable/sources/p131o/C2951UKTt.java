package p131o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: o.UKTt */
/* loaded from: classes.dex */
public class C2951UKTt extends AbstractC1897Ea {

    /* renamed from: o.UKTt$AZxh */
    public static class AZxh extends AnimatorListenerAdapter {

        /* renamed from: AZxh */
        public boolean f10815AZxh = false;

        /* renamed from: mjFkc */
        public final View f10816mjFkc;

        public AZxh(View view) {
            this.f10816mjFkc = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC4623ta.m13638xJ(this.f10816mjFkc, 1.0f);
            if (this.f10815AZxh) {
                this.f10816mjFkc.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (AbstractC2876T9.m10299xrEuO(this.f10816mjFkc) && this.f10816mjFkc.getLayerType() == 0) {
                this.f10815AZxh = true;
                this.f10816mjFkc.setLayerType(2, null);
            }
        }
    }

    /* renamed from: o.UKTt$mjFkc */
    public class mjFkc extends AbstractC2549O8 {

        /* renamed from: mjFkc */
        public final /* synthetic */ View f10818mjFkc;

        public mjFkc(View view) {
            this.f10818mjFkc = view;
        }

        @Override // p131o.AbstractC2485N8.JHa
        /* renamed from: wA */
        public void mo8146wA(AbstractC2485N8 abstractC2485N8) {
            AbstractC4623ta.m13638xJ(this.f10818mjFkc, 1.0f);
            AbstractC4623ta.m13635mjFkc(this.f10818mjFkc);
            abstractC2485N8.mo9616aqHPIZ(this);
        }
    }

    public C2951UKTt(int i) {
        m8140tQ(i);
    }

    /* renamed from: vjlshU */
    public static float m10482vjlshU(C2875T8 c2875t8, float f) {
        Float f2;
        return (c2875t8 == null || (f2 = (Float) c2875t8.f10646mjFkc.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    @Override // p131o.AbstractC1897Ea, p131o.AbstractC2485N8
    /* renamed from: VA */
    public void mo8133VA(C2875T8 c2875t8) {
        super.mo8133VA(c2875t8);
        c2875t8.f10646mjFkc.put("android:fade:transitionAlpha", Float.valueOf(AbstractC4623ta.m13637wA(c2875t8.f10645AZxh)));
    }

    @Override // p131o.AbstractC1897Ea
    /* renamed from: alEkx */
    public Animator mo8135alEkx(ViewGroup viewGroup, View view, C2875T8 c2875t8, C2875T8 c2875t82) {
        AbstractC4623ta.m13632KLFTb(view);
        return m10483yfx(view, m10482vjlshU(c2875t8, 1.0f), 0.0f);
    }

    @Override // p131o.AbstractC1897Ea
    /* renamed from: jm */
    public Animator mo8137jm(ViewGroup viewGroup, View view, C2875T8 c2875t8, C2875T8 c2875t82) {
        float fM10482vjlshU = m10482vjlshU(c2875t8, 0.0f);
        return m10483yfx(view, fM10482vjlshU != 1.0f ? fM10482vjlshU : 0.0f, 1.0f);
    }

    /* renamed from: yfx */
    public final Animator m10483yfx(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        AbstractC4623ta.m13638xJ(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) AbstractC4623ta.f16703AZxh, f2);
        objectAnimatorOfFloat.addListener(new AZxh(view));
        mo9627mjFkc(new mjFkc(view));
        return objectAnimatorOfFloat;
    }

    public C2951UKTt() {
    }
}
