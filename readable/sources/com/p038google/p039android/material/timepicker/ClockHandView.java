package com.p038google.p039android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p133asn1.p174x509.DisplayText;
import p131o.AbstractC2506NPj;
import p131o.AbstractC2737R4;
import p131o.AbstractC2800S1;
import p131o.AbstractC2876T9;
import p131o.AbstractC3340a5;
import p131o.AbstractC3800h4;
import p131o.AbstractC4191n4;
import p131o.AbstractC4557sa;
import p131o.AbstractC4923y2;

/* loaded from: classes.dex */
class ClockHandView extends View {

    /* renamed from: AZxh */
    public final TimeInterpolator f2949AZxh;

    /* renamed from: Dt */
    public final List f2950Dt;

    /* renamed from: ETF */
    public final int f2951ETF;

    /* renamed from: IEE */
    public double f2952IEE;

    /* renamed from: JHa */
    public float f2953JHa;

    /* renamed from: KLFTb */
    public float f2954KLFTb;

    /* renamed from: MiMN */
    public final Paint f2955MiMN;

    /* renamed from: Pq */
    public int f2956Pq;

    /* renamed from: VA */
    public final float f2957VA;

    /* renamed from: YoKzxo */
    public final RectF f2958YoKzxo;

    /* renamed from: ZfxDd */
    public boolean f2959ZfxDd;

    /* renamed from: diqgf */
    public int f2960diqgf;

    /* renamed from: fehf */
    public boolean f2961fehf;

    /* renamed from: lgHUyS */
    public final int f2962lgHUyS;

    /* renamed from: mjFkc */
    public final int f2963mjFkc;

    /* renamed from: qGY */
    public float f2964qGY;

    /* renamed from: qdMbNW */
    public boolean f2965qdMbNW;

    /* renamed from: rkYL */
    public final int f2966rkYL;

    /* renamed from: wA */
    public final ValueAnimator f2967wA;

    /* renamed from: xJ */
    public boolean f2968xJ;

    /* renamed from: com.google.android.material.timepicker.ClockHandView$AZxh */
    public interface InterfaceC0297AZxh {
        /* renamed from: mjFkc */
        void mo3295mjFkc(float f, boolean z);
    }

    /* renamed from: com.google.android.material.timepicker.ClockHandView$mjFkc */
    public class C0298mjFkc extends AnimatorListenerAdapter {
        public C0298mjFkc() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3800h4.f13927IEE);
    }

    /* renamed from: AZxh */
    public void m3299AZxh(InterfaceC0297AZxh interfaceC0297AZxh) {
        this.f2950Dt.add(interfaceC0297AZxh);
    }

    /* renamed from: Dt */
    public final Pair m3300Dt(float f) {
        float fM3314xJ = m3314xJ();
        if (Math.abs(fM3314xJ - f) > 180.0f) {
            if (fM3314xJ > 180.0f && f < 180.0f) {
                f += 360.0f;
            }
            if (fM3314xJ < 180.0f && f > 180.0f) {
                fM3314xJ += 360.0f;
            }
        }
        return new Pair(Float.valueOf(fM3314xJ), Float.valueOf(f));
    }

    /* renamed from: ETF */
    public final boolean m3301ETF(float f, float f2, boolean z, boolean z2, boolean z3) {
        float fM3302JHa = m3302JHa(f, f2);
        boolean z4 = false;
        boolean z5 = m3314xJ() != fM3302JHa;
        if (z2 && z5) {
            return true;
        }
        if (!z5 && !z) {
            return false;
        }
        if (z3 && this.f2959ZfxDd) {
            z4 = true;
        }
        m3312rkYL(fM3302JHa, z4);
        return true;
    }

    /* renamed from: JHa */
    public final int m3302JHa(float f, float f2) {
        int degrees = (int) Math.toDegrees(Math.atan2(f2 - (getHeight() / 2), f - (getWidth() / 2)));
        int i = degrees + 90;
        return i < 0 ? degrees + 450 : i;
    }

    /* renamed from: KLFTb */
    public RectF m3303KLFTb() {
        return this.f2958YoKzxo;
    }

    /* renamed from: MiMN */
    public void m3304MiMN(int i) {
        this.f2956Pq = i;
        invalidate();
    }

    /* renamed from: VA */
    public final /* synthetic */ void m3305VA(ValueAnimator valueAnimator) {
        m3310qGY(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    /* renamed from: YoKzxo */
    public void m3306YoKzxo(float f) {
        m3312rkYL(f, false);
    }

    /* renamed from: ZfxDd */
    public final void m3307ZfxDd(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f = width;
        float fM3309lgHUyS = m3309lgHUyS(this.f2960diqgf);
        float fCos = (((float) Math.cos(this.f2952IEE)) * fM3309lgHUyS) + f;
        float f2 = height;
        float fSin = (fM3309lgHUyS * ((float) Math.sin(this.f2952IEE))) + f2;
        this.f2955MiMN.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f2951ETF, this.f2955MiMN);
        double dSin = Math.sin(this.f2952IEE);
        double dCos = Math.cos(this.f2952IEE);
        this.f2955MiMN.setStrokeWidth(this.f2966rkYL);
        canvas.drawLine(f, f2, width + ((int) (dCos * d)), height + ((int) (d * dSin)), this.f2955MiMN);
        canvas.drawCircle(f, f2, this.f2957VA, this.f2955MiMN);
    }

    /* renamed from: fehf */
    public void m3308fehf(boolean z) {
        if (this.f2965qdMbNW && !z) {
            this.f2960diqgf = 1;
        }
        this.f2965qdMbNW = z;
        invalidate();
    }

    /* renamed from: lgHUyS */
    public final int m3309lgHUyS(int i) {
        int i2 = this.f2956Pq;
        return i == 2 ? Math.round(i2 * 0.66f) : i2;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m3307ZfxDd(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f2967wA.isRunning()) {
            return;
        }
        m3306YoKzxo(m3314xJ());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked == 0) {
            this.f2954KLFTb = x;
            this.f2953JHa = y;
            this.f2968xJ = true;
            this.f2961fehf = false;
            z = true;
            z2 = false;
            z3 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i = (int) (x - this.f2954KLFTb);
            int i2 = (int) (y - this.f2953JHa);
            this.f2968xJ = (i * i) + (i2 * i2) > this.f2962lgHUyS;
            z2 = this.f2961fehf;
            boolean z4 = actionMasked == 1;
            if (this.f2965qdMbNW) {
                m3313wA(x, y);
            }
            z3 = z4;
            z = false;
        } else {
            z2 = false;
            z = false;
            z3 = false;
        }
        this.f2961fehf |= m3301ETF(x, y, z2, z, z3);
        return true;
    }

    /* renamed from: qGY */
    public final void m3310qGY(float f, boolean z) {
        float f2 = f % 360.0f;
        this.f2964qGY = f2;
        this.f2952IEE = Math.toRadians(f2 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fM3309lgHUyS = m3309lgHUyS(this.f2960diqgf);
        float fCos = width + (((float) Math.cos(this.f2952IEE)) * fM3309lgHUyS);
        float fSin = height + (fM3309lgHUyS * ((float) Math.sin(this.f2952IEE)));
        RectF rectF = this.f2958YoKzxo;
        int i = this.f2951ETF;
        rectF.set(fCos - i, fSin - i, fCos + i, fSin + i);
        Iterator it = this.f2950Dt.iterator();
        while (it.hasNext()) {
            ((InterfaceC0297AZxh) it.next()).mo3295mjFkc(f2, z);
        }
        invalidate();
    }

    /* renamed from: qdMbNW */
    public int m3311qdMbNW() {
        return this.f2951ETF;
    }

    /* renamed from: rkYL */
    public void m3312rkYL(float f, boolean z) {
        ValueAnimator valueAnimator = this.f2967wA;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            m3310qGY(f, false);
            return;
        }
        Pair pairM3300Dt = m3300Dt(f);
        this.f2967wA.setFloatValues(((Float) pairM3300Dt.first).floatValue(), ((Float) pairM3300Dt.second).floatValue());
        this.f2967wA.setDuration(this.f2963mjFkc);
        this.f2967wA.setInterpolator(this.f2949AZxh);
        this.f2967wA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.mjFkc
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f2980mjFkc.m3305VA(valueAnimator2);
            }
        });
        this.f2967wA.addListener(new C0298mjFkc());
        this.f2967wA.start();
    }

    /* renamed from: wA */
    public final void m3313wA(float f, float f2) {
        this.f2960diqgf = AbstractC2800S1.m10129mjFkc((float) (getWidth() / 2), (float) (getHeight() / 2), f, f2) > ((float) m3309lgHUyS(2)) + AbstractC4557sa.m13501AZxh(getContext(), 12) ? 1 : 2;
    }

    /* renamed from: xJ */
    public float m3314xJ() {
        return this.f2964qGY;
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2967wA = new ValueAnimator();
        this.f2950Dt = new ArrayList();
        Paint paint = new Paint();
        this.f2955MiMN = paint;
        this.f2958YoKzxo = new RectF();
        this.f2960diqgf = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3340a5.f12553eQ, i, AbstractC2737R4.f10368MiMN);
        this.f2963mjFkc = AbstractC4923y2.m13983JHa(context, AbstractC3800h4.f13940diqgf, DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE);
        this.f2949AZxh = AbstractC4923y2.m13988xJ(context, AbstractC3800h4.f13921BAnRFn, AbstractC2506NPj.f9736AZxh);
        this.f2956Pq = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC3340a5.f12587jtz, 0);
        this.f2951ETF = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC3340a5.f12507XgAT, 0);
        this.f2966rkYL = getResources().getDimensionPixelSize(AbstractC4191n4.f15317MiMN);
        this.f2957VA = r7.getDimensionPixelSize(AbstractC4191n4.f15310ETF);
        int color = typedArrayObtainStyledAttributes.getColor(AbstractC3340a5.f12360FbxKQm, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        m3306YoKzxo(0.0f);
        this.f2962lgHUyS = ViewConfiguration.get(context).getScaledTouchSlop();
        AbstractC2876T9.m10244NKyg(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }
}
