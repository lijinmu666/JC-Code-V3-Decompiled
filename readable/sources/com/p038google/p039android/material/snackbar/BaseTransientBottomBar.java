package com.p038google.p039android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;
import com.p038google.p039android.material.behavior.SwipeDismissBehavior;
import com.p038google.p039android.material.snackbar.C0282mjFkc;
import java.util.List;
import p131o.AbstractC2007G4;
import p131o.AbstractC2345L1;
import p131o.AbstractC2478N1;
import p131o.AbstractC2506NPj;
import p131o.AbstractC2734R1;
import p131o.AbstractC2876T9;
import p131o.AbstractC3340a5;
import p131o.AbstractC3800h4;
import p131o.AbstractC4191n4;
import p131o.AbstractC4260o8;
import p131o.AbstractC4332pCk;
import p131o.AbstractC4422qb;
import p131o.AbstractC4557sa;
import p131o.AbstractC4793w7;
import p131o.AbstractC4923y2;
import p131o.C2141I6;
import p131o.C2454MiMN;
import p131o.C2542O1;
import p131o.C2971Ucbh;
import p131o.C3372ab;
import p131o.InterfaceC2703QaEQQ;
import p131o.InterfaceC3134X2;

/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar {

    /* renamed from: AZxh */
    public final int f2734AZxh;

    /* renamed from: Dt */
    public final InterfaceC2703QaEQQ f2735Dt;

    /* renamed from: ETF */
    public int f2736ETF;

    /* renamed from: Gd */
    public final AccessibilityManager f2737Gd;

    /* renamed from: IEE */
    public int f2739IEE;

    /* renamed from: JHa */
    public final TimeInterpolator f2740JHa;

    /* renamed from: KLFTb */
    public final TimeInterpolator f2741KLFTb;

    /* renamed from: Pq */
    public int f2743Pq;

    /* renamed from: Ucbh */
    public List f2744Ucbh;

    /* renamed from: VA */
    public boolean f2745VA;

    /* renamed from: ZfxDd */
    public final TimeInterpolator f2747ZfxDd;

    /* renamed from: diqgf */
    public int f2748diqgf;

    /* renamed from: eyqo */
    public boolean f2749eyqo;

    /* renamed from: fehf */
    public int f2750fehf;

    /* renamed from: huTpC */
    public Behavior f2751huTpC;

    /* renamed from: lgHUyS */
    public final Context f2752lgHUyS;

    /* renamed from: mjFkc */
    public final int f2753mjFkc;

    /* renamed from: qGY */
    public int f2754qGY;

    /* renamed from: qdMbNW */
    public final C0267IEE f2755qdMbNW;

    /* renamed from: rkYL */
    public int f2756rkYL;

    /* renamed from: wA */
    public final int f2757wA;

    /* renamed from: xJ */
    public final ViewGroup f2758xJ;

    /* renamed from: vI */
    public static final TimeInterpolator f2732vI = AbstractC2506NPj.f9736AZxh;

    /* renamed from: VocHEe */
    public static final TimeInterpolator f2729VocHEe = AbstractC2506NPj.f9739mjFkc;

    /* renamed from: BAnRFn */
    public static final TimeInterpolator f2727BAnRFn = AbstractC2506NPj.f9738ZfxDd;

    /* renamed from: wJVbdd */
    public static final boolean f2733wJVbdd = false;

    /* renamed from: mByQ */
    public static final int[] f2731mByQ = {AbstractC3800h4.f13933OjSQV};

    /* renamed from: OjSQV */
    public static final String f2728OjSQV = BaseTransientBottomBar.class.getSimpleName();

    /* renamed from: lB */
    public static final Handler f2730lB = new Handler(Looper.getMainLooper(), new C0275lgHUyS());

    /* renamed from: MiMN */
    public boolean f2742MiMN = false;

    /* renamed from: YoKzxo */
    public final Runnable f2746YoKzxo = new RunnableC0278qdMbNW();

    /* renamed from: HGpJ */
    public C0282mjFkc.AZxh f2738HGpJ = new C0271VA();

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$AZxh */
    public class C0264AZxh implements ValueAnimator.AnimatorUpdateListener {
        public C0264AZxh() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f2755qdMbNW.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: VA */
        public final C0274fehf f2760VA = new C0274fehf(this);

        @Override // com.p038google.p039android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: ETF */
        public boolean mo488ETF(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f2760VA.m3085AZxh(coordinatorLayout, view, motionEvent);
            return super.mo488ETF(coordinatorLayout, view, motionEvent);
        }

        @Override // com.p038google.p039android.material.behavior.SwipeDismissBehavior
        /* renamed from: OjSQV */
        public boolean mo2476OjSQV(View view) {
            return this.f2760VA.m3086mjFkc(view);
        }

        /* renamed from: oCFDzJ */
        public final void m3077oCFDzJ(BaseTransientBottomBar baseTransientBottomBar) {
            this.f2760VA.m3087wA(baseTransientBottomBar);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$Dt */
    public class C0265Dt implements InterfaceC3134X2 {
        public C0265Dt() {
        }

        @Override // p131o.InterfaceC3134X2
        /* renamed from: mjFkc */
        public C3372ab mo535mjFkc(View view, C3372ab c3372ab) {
            BaseTransientBottomBar.this.f2756rkYL = c3372ab.m11343lgHUyS();
            BaseTransientBottomBar.this.f2754qGY = c3372ab.m11346qdMbNW();
            BaseTransientBottomBar.this.f2750fehf = c3372ab.m11333Dt();
            BaseTransientBottomBar.this.m3054SwgkN();
            return c3372ab;
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$ETF */
    public class C0266ETF extends C2454MiMN {
        public C0266ETF() {
        }

        @Override // p131o.C2454MiMN
        /* renamed from: Dt */
        public boolean mo618Dt(View view, int i, Bundle bundle) {
            if (i != 1048576) {
                return super.mo618Dt(view, i, bundle);
            }
            BaseTransientBottomBar.this.mo3043Gd();
            return true;
        }

        @Override // p131o.C2454MiMN
        /* renamed from: xJ */
        public void mo620xJ(View view, C2971Ucbh c2971Ucbh) {
            super.mo620xJ(view, c2971Ucbh);
            c2971Ucbh.m10588mjFkc(1048576);
            c2971Ucbh.m10530ANMGZc(true);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$IEE */
    public static class C0267IEE extends FrameLayout {

        /* renamed from: VA */
        public static final View.OnTouchListener f2763VA = new mjFkc();

        /* renamed from: AZxh */
        public C2141I6 f2764AZxh;

        /* renamed from: Dt */
        public Rect f2765Dt;

        /* renamed from: ETF */
        public boolean f2766ETF;

        /* renamed from: JHa */
        public final int f2767JHa;

        /* renamed from: KLFTb */
        public final float f2768KLFTb;

        /* renamed from: ZfxDd */
        public final float f2769ZfxDd;

        /* renamed from: lgHUyS */
        public ColorStateList f2770lgHUyS;

        /* renamed from: mjFkc */
        public BaseTransientBottomBar f2771mjFkc;

        /* renamed from: qdMbNW */
        public PorterDuff.Mode f2772qdMbNW;

        /* renamed from: wA */
        public int f2773wA;

        /* renamed from: xJ */
        public final int f2774xJ;

        /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$IEE$mjFkc */
        public class mjFkc implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public C0267IEE(Context context, AttributeSet attributeSet) {
            super(AbstractC2734R1.m10039wA(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, AbstractC3340a5.f12423MQhVKd);
            if (typedArrayObtainStyledAttributes.hasValue(AbstractC3340a5.f12375HGlNf)) {
                AbstractC2876T9.m10251SmIWf(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC3340a5.f12375HGlNf, 0));
            }
            this.f2773wA = typedArrayObtainStyledAttributes.getInt(AbstractC3340a5.f12326BOPu, 0);
            if (typedArrayObtainStyledAttributes.hasValue(AbstractC3340a5.f12625pCk) || typedArrayObtainStyledAttributes.hasValue(AbstractC3340a5.f12640rB)) {
                this.f2764AZxh = C2141I6.m8658KLFTb(context2, attributeSet, 0, 0).m8698MiMN();
            }
            this.f2769ZfxDd = typedArrayObtainStyledAttributes.getFloat(AbstractC3340a5.f12689xIpq, 1.0f);
            setBackgroundTintList(AbstractC2478N1.m9577mjFkc(context2, typedArrayObtainStyledAttributes, AbstractC3340a5.f12333CRhd));
            setBackgroundTintMode(AbstractC4557sa.m13502JHa(typedArrayObtainStyledAttributes.getInt(AbstractC3340a5.f12543cOuJ, -1), PorterDuff.Mode.SRC_IN));
            this.f2768KLFTb = typedArrayObtainStyledAttributes.getFloat(AbstractC3340a5.f12509XvQLwQ, 1.0f);
            this.f2767JHa = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC3340a5.f12519ZODYfo, -1);
            this.f2774xJ = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC3340a5.f12671vEiZJ, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f2763VA);
            setFocusable(true);
            if (getBackground() == null) {
                AbstractC2876T9.m10294vjlshU(this, m3081ZfxDd());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBaseTransientBottomBar(BaseTransientBottomBar baseTransientBottomBar) {
            this.f2771mjFkc = baseTransientBottomBar;
        }

        /* renamed from: KLFTb */
        public final void m3080KLFTb(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f2765Dt = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        /* renamed from: ZfxDd */
        public final Drawable m3081ZfxDd() {
            int iM9299Dt = AbstractC2345L1.m9299Dt(this, AbstractC3800h4.f13945lgHUyS, AbstractC3800h4.f13929KLFTb, getBackgroundOverlayColorAlpha());
            C2141I6 c2141i6 = this.f2764AZxh;
            Drawable drawableM3032huTpC = c2141i6 != null ? BaseTransientBottomBar.m3032huTpC(iM9299Dt, c2141i6) : BaseTransientBottomBar.m3027Ucbh(iM9299Dt, getResources());
            if (this.f2770lgHUyS == null) {
                return AbstractC4332pCk.m13077VA(drawableM3032huTpC);
            }
            Drawable drawableM13077VA = AbstractC4332pCk.m13077VA(drawableM3032huTpC);
            AbstractC4332pCk.m13081qdMbNW(drawableM13077VA, this.f2770lgHUyS);
            return drawableM13077VA;
        }

        public float getActionTextColorAlpha() {
            return this.f2768KLFTb;
        }

        public int getAnimationMode() {
            return this.f2773wA;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f2769ZfxDd;
        }

        public int getMaxInlineActionWidth() {
            return this.f2774xJ;
        }

        public int getMaxWidth() {
            return this.f2767JHa;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar baseTransientBottomBar = this.f2771mjFkc;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.m3069rWxwaT();
            }
            AbstractC2876T9.m10255Vdz(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar baseTransientBottomBar = this.f2771mjFkc;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.m3055Vnb();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            BaseTransientBottomBar baseTransientBottomBar = this.f2771mjFkc;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.m3050NPj();
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f2767JHa > 0) {
                int measuredWidth = getMeasuredWidth();
                int i3 = this.f2767JHa;
                if (measuredWidth > i3) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
                }
            }
        }

        public void setAnimationMode(int i) {
            this.f2773wA = i;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f2770lgHUyS != null) {
                drawable = AbstractC4332pCk.m13077VA(drawable.mutate());
                AbstractC4332pCk.m13081qdMbNW(drawable, this.f2770lgHUyS);
                AbstractC4332pCk.m13073Dt(drawable, this.f2772qdMbNW);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f2770lgHUyS = colorStateList;
            if (getBackground() != null) {
                Drawable drawableM13077VA = AbstractC4332pCk.m13077VA(getBackground().mutate());
                AbstractC4332pCk.m13081qdMbNW(drawableM13077VA, colorStateList);
                AbstractC4332pCk.m13073Dt(drawableM13077VA, this.f2772qdMbNW);
                if (drawableM13077VA != getBackground()) {
                    super.setBackgroundDrawable(drawableM13077VA);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f2772qdMbNW = mode;
            if (getBackground() != null) {
                Drawable drawableM13077VA = AbstractC4332pCk.m13077VA(getBackground().mutate());
                AbstractC4332pCk.m13073Dt(drawableM13077VA, mode);
                if (drawableM13077VA != getBackground()) {
                    super.setBackgroundDrawable(drawableM13077VA);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.f2766ETF || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            m3080KLFTb((ViewGroup.MarginLayoutParams) layoutParams);
            BaseTransientBottomBar baseTransientBottomBar = this.f2771mjFkc;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.m3054SwgkN();
            }
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f2763VA);
            super.setOnClickListener(onClickListener);
        }

        /* renamed from: wA */
        public void m3082wA(ViewGroup viewGroup) {
            this.f2766ETF = true;
            viewGroup.addView(this);
            this.f2766ETF = false;
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$JHa */
    public class C0268JHa extends AnimatorListenerAdapter {

        /* renamed from: mjFkc */
        public final /* synthetic */ int f2776mjFkc;

        public C0268JHa(int i) {
            this.f2776mjFkc = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.m3072vadzgd(this.f2776mjFkc);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f2735Dt.mo3099AZxh(0, BaseTransientBottomBar.this.f2734AZxh);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$KLFTb */
    public class C0269KLFTb implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: AZxh */
        public final /* synthetic */ int f2777AZxh;

        /* renamed from: mjFkc */
        public int f2778mjFkc;

        public C0269KLFTb(int i) {
            this.f2777AZxh = i;
            this.f2778mjFkc = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f2733wJVbdd) {
                AbstractC2876T9.m10240KRTLGT(BaseTransientBottomBar.this.f2755qdMbNW, iIntValue - this.f2778mjFkc);
            } else {
                BaseTransientBottomBar.this.f2755qdMbNW.setTranslationY(iIntValue);
            }
            this.f2778mjFkc = iIntValue;
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$MiMN */
    public class RunnableC0270MiMN implements Runnable {
        public RunnableC0270MiMN() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseTransientBottomBar.this.m3072vadzgd(3);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$VA */
    public class C0271VA implements C0282mjFkc.AZxh {
        public C0271VA() {
        }

        @Override // com.p038google.p039android.material.snackbar.C0282mjFkc.AZxh
        /* renamed from: AZxh */
        public void mo3083AZxh(int i) {
            Handler handler = BaseTransientBottomBar.f2730lB;
            handler.sendMessage(handler.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }

        @Override // com.p038google.p039android.material.snackbar.C0282mjFkc.AZxh
        /* renamed from: mjFkc */
        public void mo3084mjFkc() {
            Handler handler = BaseTransientBottomBar.f2730lB;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$YoKzxo */
    public class C0272YoKzxo implements SwipeDismissBehavior.InterfaceC0228wA {
        public C0272YoKzxo() {
        }

        @Override // com.p038google.p039android.material.behavior.SwipeDismissBehavior.InterfaceC0228wA
        /* renamed from: AZxh */
        public void mo2492AZxh(int i) {
            if (i == 0) {
                C0282mjFkc.m3103wA().m3106ETF(BaseTransientBottomBar.this.f2738HGpJ);
            } else if (i == 1 || i == 2) {
                C0282mjFkc.m3103wA().m3105Dt(BaseTransientBottomBar.this.f2738HGpJ);
            }
        }

        @Override // com.p038google.p039android.material.behavior.SwipeDismissBehavior.InterfaceC0228wA
        /* renamed from: mjFkc */
        public void mo2493mjFkc(View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.m3044HGpJ(0);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$ZfxDd */
    public class C0273ZfxDd extends AnimatorListenerAdapter {
        public C0273ZfxDd() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.m3068oCFDzJ();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f2735Dt.mo3101mjFkc(BaseTransientBottomBar.this.f2757wA - BaseTransientBottomBar.this.f2753mjFkc, BaseTransientBottomBar.this.f2753mjFkc);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$fehf */
    public static class C0274fehf {

        /* renamed from: mjFkc */
        public C0282mjFkc.AZxh f2784mjFkc;

        public C0274fehf(SwipeDismissBehavior swipeDismissBehavior) {
            swipeDismissBehavior.m2479rWxwaT(0.1f);
            swipeDismissBehavior.m2481zvd(0.6f);
            swipeDismissBehavior.m2477Vnb(0);
        }

        /* renamed from: AZxh */
        public void m3085AZxh(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.m482vI(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    C0282mjFkc.m3103wA().m3105Dt(this.f2784mjFkc);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                C0282mjFkc.m3103wA().m3106ETF(this.f2784mjFkc);
            }
        }

        /* renamed from: mjFkc */
        public boolean m3086mjFkc(View view) {
            return view instanceof C0267IEE;
        }

        /* renamed from: wA */
        public void m3087wA(BaseTransientBottomBar baseTransientBottomBar) {
            this.f2784mjFkc = baseTransientBottomBar.f2738HGpJ;
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$lgHUyS */
    public class C0275lgHUyS implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                ((BaseTransientBottomBar) message.obj).m3045JYgkl();
                return true;
            }
            if (i != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).m3048KLMXS(message.arg1);
            return true;
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$mjFkc */
    public class C0276mjFkc extends AnimatorListenerAdapter {

        /* renamed from: mjFkc */
        public final /* synthetic */ int f2786mjFkc;

        public C0276mjFkc(int i) {
            this.f2786mjFkc = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.m3072vadzgd(this.f2786mjFkc);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$qGY */
    public class C0277qGY extends AnimatorListenerAdapter {
        public C0277qGY() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.m3068oCFDzJ();
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$qdMbNW */
    public class RunnableC0278qdMbNW implements Runnable {
        public RunnableC0278qdMbNW() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f2755qdMbNW == null || baseTransientBottomBar.f2752lgHUyS == null) {
                return;
            }
            int iHeight = (AbstractC4422qb.m13268mjFkc(BaseTransientBottomBar.this.f2752lgHUyS).height() - BaseTransientBottomBar.this.m3041CqaNbM()) + ((int) BaseTransientBottomBar.this.f2755qdMbNW.getTranslationY());
            if (iHeight >= BaseTransientBottomBar.this.f2743Pq) {
                BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                baseTransientBottomBar2.f2748diqgf = baseTransientBottomBar2.f2743Pq;
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f2755qdMbNW.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.f2728OjSQV, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            BaseTransientBottomBar baseTransientBottomBar3 = BaseTransientBottomBar.this;
            baseTransientBottomBar3.f2748diqgf = baseTransientBottomBar3.f2743Pq;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.f2743Pq - iHeight;
            BaseTransientBottomBar.this.f2755qdMbNW.requestLayout();
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$rkYL */
    public class RunnableC0279rkYL implements Runnable {
        public RunnableC0279rkYL() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0267IEE c0267iee = BaseTransientBottomBar.this.f2755qdMbNW;
            if (c0267iee == null) {
                return;
            }
            if (c0267iee.getParent() != null) {
                BaseTransientBottomBar.this.f2755qdMbNW.setVisibility(0);
            }
            if (BaseTransientBottomBar.this.f2755qdMbNW.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.m3067nxI();
            } else {
                BaseTransientBottomBar.this.m3059XV();
            }
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$wA */
    public class C0280wA implements ValueAnimator.AnimatorUpdateListener {
        public C0280wA() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f2755qdMbNW.setScaleX(fFloatValue);
            BaseTransientBottomBar.this.f2755qdMbNW.setScaleY(fFloatValue);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$xJ */
    public class C0281xJ implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: mjFkc */
        public int f2792mjFkc = 0;

        public C0281xJ() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f2733wJVbdd) {
                AbstractC2876T9.m10240KRTLGT(BaseTransientBottomBar.this.f2755qdMbNW, iIntValue - this.f2792mjFkc);
            } else {
                BaseTransientBottomBar.this.f2755qdMbNW.setTranslationY(iIntValue);
            }
            this.f2792mjFkc = iIntValue;
        }
    }

    public BaseTransientBottomBar(Context context, ViewGroup viewGroup, View view, InterfaceC2703QaEQQ interfaceC2703QaEQQ) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (interfaceC2703QaEQQ == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f2758xJ = viewGroup;
        this.f2735Dt = interfaceC2703QaEQQ;
        this.f2752lgHUyS = context;
        AbstractC4260o8.m12941mjFkc(context);
        C0267IEE c0267iee = (C0267IEE) LayoutInflater.from(context).inflate(m3066mByQ(), viewGroup, false);
        this.f2755qdMbNW = c0267iee;
        c0267iee.setBaseTransientBottomBar(this);
        if (view instanceof SnackbarContentLayout) {
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
            snackbarContentLayout.m3102wA(c0267iee.getActionTextColorAlpha());
            snackbarContentLayout.setMaxInlineActionWidth(c0267iee.getMaxInlineActionWidth());
        }
        c0267iee.addView(view);
        AbstractC2876T9.m10289tQ(c0267iee, 1);
        AbstractC2876T9.m10244NKyg(c0267iee, 1);
        AbstractC2876T9.m10250SOS(c0267iee, true);
        AbstractC2876T9.m10300yX(c0267iee, new C0265Dt());
        AbstractC2876T9.m10265alEkx(c0267iee, new C0266ETF());
        this.f2737Gd = (AccessibilityManager) context.getSystemService("accessibility");
        this.f2757wA = AbstractC4923y2.m13983JHa(context, AbstractC3800h4.f13940diqgf, 250);
        this.f2753mjFkc = AbstractC4923y2.m13983JHa(context, AbstractC3800h4.f13940diqgf, 150);
        this.f2734AZxh = AbstractC4923y2.m13983JHa(context, AbstractC3800h4.f13941eyqo, 75);
        this.f2747ZfxDd = AbstractC4923y2.m13988xJ(context, AbstractC3800h4.f13921BAnRFn, f2729VocHEe);
        this.f2740JHa = AbstractC4923y2.m13988xJ(context, AbstractC3800h4.f13921BAnRFn, f2727BAnRFn);
        this.f2741KLFTb = AbstractC4923y2.m13988xJ(context, AbstractC3800h4.f13921BAnRFn, f2732vI);
    }

    /* renamed from: Ucbh */
    public static GradientDrawable m3027Ucbh(int i, Resources resources) throws Resources.NotFoundException {
        float dimension = resources.getDimension(AbstractC4191n4.f15318NPj);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    /* renamed from: huTpC */
    public static C2542O1 m3032huTpC(int i, C2141I6 c2141i6) {
        C2542O1 c2542o1 = new C2542O1(c2141i6);
        c2542o1.m9841uHVRx(ColorStateList.valueOf(i));
        return c2542o1;
    }

    /* renamed from: BAnRFn */
    public int mo3040BAnRFn() {
        return this.f2736ETF;
    }

    /* renamed from: CqaNbM */
    public final int m3041CqaNbM() {
        int[] iArr = new int[2];
        this.f2755qdMbNW.getLocationOnScreen(iArr);
        return iArr[1] + this.f2755qdMbNW.getHeight();
    }

    /* renamed from: GMIER */
    public boolean m3042GMIER() {
        AccessibilityManager accessibilityManager = this.f2737Gd;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    /* renamed from: Gd */
    public void mo3043Gd() {
        m3044HGpJ(3);
    }

    /* renamed from: HGpJ */
    public void m3044HGpJ(int i) {
        C0282mjFkc.m3103wA().m3104AZxh(this.f2738HGpJ, i);
    }

    /* renamed from: JYgkl */
    public final void m3045JYgkl() {
        if (this.f2755qdMbNW.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f2755qdMbNW.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.C0060KLFTb) {
                m3049KRTLGT((CoordinatorLayout.C0060KLFTb) layoutParams);
            }
            this.f2755qdMbNW.m3082wA(this.f2758xJ);
            m3060aqHPIZ();
            this.f2755qdMbNW.setVisibility(4);
        }
        if (AbstractC2876T9.m10287rWxwaT(this.f2755qdMbNW)) {
            m3047JrJO();
        } else {
            this.f2749eyqo = true;
        }
    }

    /* renamed from: JYn */
    public void mo3046JYn() {
        C0282mjFkc.m3103wA().m3109MiMN(mo3040BAnRFn(), this.f2738HGpJ);
    }

    /* renamed from: JrJO */
    public final void m3047JrJO() {
        if (m3042GMIER()) {
            m3053Pq();
            return;
        }
        if (this.f2755qdMbNW.getParent() != null) {
            this.f2755qdMbNW.setVisibility(0);
        }
        m3068oCFDzJ();
    }

    /* renamed from: KLMXS */
    public final void m3048KLMXS(int i) {
        if (m3042GMIER() && this.f2755qdMbNW.getVisibility() == 0) {
            m3063diqgf(i);
        } else {
            m3072vadzgd(i);
        }
    }

    /* renamed from: KRTLGT */
    public final void m3049KRTLGT(CoordinatorLayout.C0060KLFTb c0060KLFTb) {
        SwipeDismissBehavior swipeDismissBehaviorM3065lB = this.f2751huTpC;
        if (swipeDismissBehaviorM3065lB == null) {
            swipeDismissBehaviorM3065lB = m3065lB();
        }
        if (swipeDismissBehaviorM3065lB instanceof Behavior) {
            ((Behavior) swipeDismissBehaviorM3065lB).m3077oCFDzJ(this);
        }
        swipeDismissBehaviorM3065lB.m2478cMLeY(new C0272YoKzxo());
        c0060KLFTb.m524YoKzxo(swipeDismissBehaviorM3065lB);
        if (m3056VocHEe() == null) {
            c0060KLFTb.f934xJ = 80;
        }
    }

    /* renamed from: NPj */
    public void m3050NPj() {
        if (this.f2749eyqo) {
            m3047JrJO();
            this.f2749eyqo = false;
        }
    }

    /* renamed from: Ne */
    public View m3051Ne() {
        return this.f2755qdMbNW;
    }

    /* renamed from: OjSQV */
    public final int m3052OjSQV() {
        int height = this.f2755qdMbNW.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f2755qdMbNW.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* renamed from: Pq */
    public void m3053Pq() {
        this.f2755qdMbNW.post(new RunnableC0279rkYL());
    }

    /* renamed from: SwgkN */
    public final void m3054SwgkN() {
        ViewGroup.LayoutParams layoutParams = this.f2755qdMbNW.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            Log.w(f2728OjSQV, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        if (this.f2755qdMbNW.f2765Dt == null) {
            Log.w(f2728OjSQV, "Unable to update margins because original view margins are not set");
            return;
        }
        if (this.f2755qdMbNW.getParent() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i = this.f2755qdMbNW.f2765Dt.bottom + (m3056VocHEe() != null ? this.f2739IEE : this.f2756rkYL);
        int i2 = this.f2755qdMbNW.f2765Dt.left + this.f2754qGY;
        int i3 = this.f2755qdMbNW.f2765Dt.right + this.f2750fehf;
        int i4 = this.f2755qdMbNW.f2765Dt.top;
        boolean z = (marginLayoutParams.bottomMargin == i && marginLayoutParams.leftMargin == i2 && marginLayoutParams.rightMargin == i3 && marginLayoutParams.topMargin == i4) ? false : true;
        if (z) {
            marginLayoutParams.bottomMargin = i;
            marginLayoutParams.leftMargin = i2;
            marginLayoutParams.rightMargin = i3;
            marginLayoutParams.topMargin = i4;
            this.f2755qdMbNW.requestLayout();
        }
        if ((z || this.f2748diqgf != this.f2743Pq) && m3070uHVRx()) {
            this.f2755qdMbNW.removeCallbacks(this.f2746YoKzxo);
            this.f2755qdMbNW.post(this.f2746YoKzxo);
        }
    }

    /* renamed from: Vnb */
    public void m3055Vnb() {
        if (m3075zvd()) {
            f2730lB.post(new RunnableC0270MiMN());
        }
    }

    /* renamed from: VocHEe */
    public View m3056VocHEe() {
        return null;
    }

    /* renamed from: WGXroI */
    public final void m3057WGXroI(int i) {
        ValueAnimator valueAnimatorM3071vI = m3071vI(1.0f, 0.0f);
        valueAnimatorM3071vI.setDuration(this.f2734AZxh);
        valueAnimatorM3071vI.addListener(new C0276mjFkc(i));
        valueAnimatorM3071vI.start();
    }

    /* renamed from: WrLQs */
    public BaseTransientBottomBar m3058WrLQs(int i) {
        this.f2736ETF = i;
        return this;
    }

    /* renamed from: XV */
    public final void m3059XV() {
        int iM3052OjSQV = m3052OjSQV();
        if (f2733wJVbdd) {
            AbstractC2876T9.m10240KRTLGT(this.f2755qdMbNW, iM3052OjSQV);
        } else {
            this.f2755qdMbNW.setTranslationY(iM3052OjSQV);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iM3052OjSQV, 0);
        valueAnimator.setInterpolator(this.f2741KLFTb);
        valueAnimator.setDuration(this.f2757wA);
        valueAnimator.addListener(new C0273ZfxDd());
        valueAnimator.addUpdateListener(new C0269KLFTb(iM3052OjSQV));
        valueAnimator.start();
    }

    /* renamed from: aqHPIZ */
    public final void m3060aqHPIZ() {
        this.f2739IEE = m3064eyqo();
        m3054SwgkN();
    }

    /* renamed from: bbzow */
    public final void m3061bbzow(int i) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, m3052OjSQV());
        valueAnimator.setInterpolator(this.f2741KLFTb);
        valueAnimator.setDuration(this.f2757wA);
        valueAnimator.addListener(new C0268JHa(i));
        valueAnimator.addUpdateListener(new C0281xJ());
        valueAnimator.start();
    }

    /* renamed from: cMLeY */
    public final boolean m3062cMLeY() {
        ViewGroup.LayoutParams layoutParams = this.f2755qdMbNW.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.C0060KLFTb) && (((CoordinatorLayout.C0060KLFTb) layoutParams).m520KLFTb() instanceof SwipeDismissBehavior);
    }

    /* renamed from: diqgf */
    public final void m3063diqgf(int i) {
        if (this.f2755qdMbNW.getAnimationMode() == 1) {
            m3057WGXroI(i);
        } else {
            m3061bbzow(i);
        }
    }

    /* renamed from: eyqo */
    public final int m3064eyqo() {
        if (m3056VocHEe() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        m3056VocHEe().getLocationOnScreen(iArr);
        int i = iArr[1];
        int[] iArr2 = new int[2];
        this.f2758xJ.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f2758xJ.getHeight()) - i;
    }

    /* renamed from: lB */
    public SwipeDismissBehavior m3065lB() {
        return new Behavior();
    }

    /* renamed from: mByQ */
    public int m3066mByQ() {
        return m3074xrEuO() ? AbstractC2007G4.f8311IEE : AbstractC2007G4.f8323mjFkc;
    }

    /* renamed from: nxI */
    public final void m3067nxI() {
        ValueAnimator valueAnimatorM3071vI = m3071vI(0.0f, 1.0f);
        ValueAnimator valueAnimatorM3073wJVbdd = m3073wJVbdd(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorM3071vI, valueAnimatorM3073wJVbdd);
        animatorSet.setDuration(this.f2753mjFkc);
        animatorSet.addListener(new C0277qGY());
        animatorSet.start();
    }

    /* renamed from: oCFDzJ */
    public void m3068oCFDzJ() {
        int size;
        C0282mjFkc.m3103wA().m3115qdMbNW(this.f2738HGpJ);
        if (this.f2744Ucbh == null || r0.size() - 1 < 0) {
            return;
        }
        AbstractC4793w7.m13819mjFkc(this.f2744Ucbh.get(size));
        throw null;
    }

    /* renamed from: rWxwaT */
    public void m3069rWxwaT() {
        WindowInsets rootWindowInsets = this.f2755qdMbNW.getRootWindowInsets();
        if (rootWindowInsets != null) {
            this.f2743Pq = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            m3054SwgkN();
        }
    }

    /* renamed from: uHVRx */
    public final boolean m3070uHVRx() {
        return this.f2743Pq > 0 && !this.f2745VA && m3062cMLeY();
    }

    /* renamed from: vI */
    public final ValueAnimator m3071vI(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f2747ZfxDd);
        valueAnimatorOfFloat.addUpdateListener(new C0264AZxh());
        return valueAnimatorOfFloat;
    }

    /* renamed from: vadzgd */
    public void m3072vadzgd(int i) {
        int size;
        C0282mjFkc.m3103wA().m3113lgHUyS(this.f2738HGpJ);
        if (this.f2744Ucbh != null && r2.size() - 1 >= 0) {
            AbstractC4793w7.m13819mjFkc(this.f2744Ucbh.get(size));
            throw null;
        }
        ViewParent parent = this.f2755qdMbNW.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f2755qdMbNW);
        }
    }

    /* renamed from: wJVbdd */
    public final ValueAnimator m3073wJVbdd(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f2740JHa);
        valueAnimatorOfFloat.addUpdateListener(new C0280wA());
        return valueAnimatorOfFloat;
    }

    /* renamed from: xrEuO */
    public boolean m3074xrEuO() {
        TypedArray typedArrayObtainStyledAttributes = this.f2752lgHUyS.obtainStyledAttributes(f2731mByQ);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    /* renamed from: zvd */
    public boolean m3075zvd() {
        return C0282mjFkc.m3103wA().m3108KLFTb(this.f2738HGpJ);
    }
}
