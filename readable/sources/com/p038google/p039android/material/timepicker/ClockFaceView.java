package com.p038google.p039android.material.timepicker;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.p038google.p039android.material.timepicker.ClockHandView;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import org.conscrypt.BuildConfig;
import p131o.AbstractC1803D4;
import p131o.AbstractC2007G4;
import p131o.AbstractC2478N1;
import p131o.AbstractC2737R4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3340a5;
import p131o.AbstractC3539d5;
import p131o.AbstractC3800h4;
import p131o.AbstractC3995k4;
import p131o.AbstractC4191n4;
import p131o.AbstractC4768vjlshU;
import p131o.C2454MiMN;
import p131o.C2971Ucbh;

/* loaded from: classes.dex */
class ClockFaceView extends AbstractC3539d5 implements ClockHandView.InterfaceC0297AZxh {

    /* renamed from: BAnRFn */
    public final Rect f2932BAnRFn;

    /* renamed from: CqaNbM */
    public final float[] f2933CqaNbM;

    /* renamed from: KLMXS */
    public final int f2934KLMXS;

    /* renamed from: NPj */
    public final ColorStateList f2935NPj;

    /* renamed from: Ne */
    public final int[] f2936Ne;

    /* renamed from: OjSQV */
    public final C2454MiMN f2937OjSQV;

    /* renamed from: Vnb */
    public float f2938Vnb;

    /* renamed from: VocHEe */
    public final ClockHandView f2939VocHEe;

    /* renamed from: cMLeY */
    public final int f2940cMLeY;

    /* renamed from: lB */
    public final RectF f2941lB;

    /* renamed from: mByQ */
    public final SparseArray f2942mByQ;

    /* renamed from: rWxwaT */
    public String[] f2943rWxwaT;

    /* renamed from: wJVbdd */
    public final Rect f2944wJVbdd;

    /* renamed from: xrEuO */
    public final int f2945xrEuO;

    /* renamed from: zvd */
    public final int f2946zvd;

    /* renamed from: com.google.android.material.timepicker.ClockFaceView$AZxh */
    public class C0295AZxh extends C2454MiMN {
        public C0295AZxh() {
        }

        @Override // p131o.C2454MiMN
        /* renamed from: Dt */
        public boolean mo618Dt(View view, int i, Bundle bundle) {
            if (i != 16) {
                return super.mo618Dt(view, i, bundle);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            view.getHitRect(ClockFaceView.this.f2932BAnRFn);
            float fCenterX = ClockFaceView.this.f2932BAnRFn.centerX();
            float fCenterY = ClockFaceView.this.f2932BAnRFn.centerY();
            ClockFaceView.this.f2939VocHEe.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fCenterX, fCenterY, 0));
            ClockFaceView.this.f2939VocHEe.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, fCenterX, fCenterY, 0));
            return true;
        }

        @Override // p131o.C2454MiMN
        /* renamed from: xJ */
        public void mo620xJ(View view, C2971Ucbh c2971Ucbh) {
            super.mo620xJ(view, c2971Ucbh);
            int iIntValue = ((Integer) view.getTag(AbstractC1803D4.f7806YoKzxo)).intValue();
            if (iIntValue > 0) {
                c2971Ucbh.m10578fFz((View) ClockFaceView.this.f2942mByQ.get(iIntValue - 1));
            }
            c2971Ucbh.m10561Vdz(C2971Ucbh.JHa.m10610mjFkc(0, 1, iIntValue, 1, false, view.isSelected()));
            c2971Ucbh.m10558SwgkN(true);
            c2971Ucbh.m10531AZxh(C2971Ucbh.mjFkc.f10892qdMbNW);
        }
    }

    /* renamed from: com.google.android.material.timepicker.ClockFaceView$mjFkc */
    public class ViewTreeObserverOnPreDrawListenerC0296mjFkc implements ViewTreeObserver.OnPreDrawListener {
        public ViewTreeObserverOnPreDrawListenerC0296mjFkc() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.mo3291Gd(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f2939VocHEe.m3311qdMbNW()) - ClockFaceView.this.f2945xrEuO);
            return true;
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3800h4.f13927IEE);
    }

    /* renamed from: xrEuO */
    public static float m3289xrEuO(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    /* renamed from: CqaNbM */
    public final TextView m3290CqaNbM(RectF rectF) {
        float f = Float.MAX_VALUE;
        TextView textView = null;
        for (int i = 0; i < this.f2942mByQ.size(); i++) {
            TextView textView2 = (TextView) this.f2942mByQ.get(i);
            if (textView2 != null) {
                textView2.getHitRect(this.f2932BAnRFn);
                this.f2941lB.set(this.f2932BAnRFn);
                this.f2941lB.union(rectF);
                float fWidth = this.f2941lB.width() * this.f2941lB.height();
                if (fWidth < f) {
                    textView = textView2;
                    f = fWidth;
                }
            }
        }
        return textView;
    }

    @Override // p131o.AbstractC3539d5
    /* renamed from: Gd */
    public void mo3291Gd(int i) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (i != m11653huTpC()) {
            super.mo3291Gd(i);
            this.f2939VocHEe.m3304MiMN(m11653huTpC());
        }
    }

    /* renamed from: KLMXS */
    public void m3292KLMXS(String[] strArr, int i) {
        this.f2943rWxwaT = strArr;
        m3297zvd(i);
    }

    /* renamed from: Ne */
    public final RadialGradient m3293Ne(RectF rectF, TextView textView) {
        textView.getHitRect(this.f2932BAnRFn);
        this.f2941lB.set(this.f2932BAnRFn);
        textView.getLineBounds(0, this.f2944wJVbdd);
        RectF rectF2 = this.f2941lB;
        Rect rect = this.f2944wJVbdd;
        rectF2.inset(rect.left, rect.top);
        if (RectF.intersects(rectF, this.f2941lB)) {
            return new RadialGradient(rectF.centerX() - this.f2941lB.left, rectF.centerY() - this.f2941lB.top, rectF.width() * 0.5f, this.f2936Ne, this.f2933CqaNbM, Shader.TileMode.CLAMP);
        }
        return null;
    }

    /* renamed from: OjSQV */
    public final void m3294OjSQV() {
        RectF rectFM3303KLFTb = this.f2939VocHEe.m3303KLFTb();
        TextView textViewM3290CqaNbM = m3290CqaNbM(rectFM3303KLFTb);
        for (int i = 0; i < this.f2942mByQ.size(); i++) {
            TextView textView = (TextView) this.f2942mByQ.get(i);
            if (textView != null) {
                textView.setSelected(textView == textViewM3290CqaNbM);
                textView.getPaint().setShader(m3293Ne(rectFM3303KLFTb, textView));
                textView.invalidate();
            }
        }
    }

    @Override // com.p038google.p039android.material.timepicker.ClockHandView.InterfaceC0297AZxh
    /* renamed from: mjFkc */
    public void mo3295mjFkc(float f, boolean z) {
        if (Math.abs(this.f2938Vnb - f) > 0.001f) {
            this.f2938Vnb = f;
            m3294OjSQV();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C2971Ucbh.m10526XtE(accessibilityNodeInfo).m10540JBhc(C2971Ucbh.KLFTb.m10611mjFkc(1, this.f2943rWxwaT.length, false, 1));
    }

    @Override // androidx.constraintlayout.p015widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m3294OjSQV();
    }

    @Override // androidx.constraintlayout.p015widget.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iM3289xrEuO = (int) (this.f2940cMLeY / m3289xrEuO(this.f2934KLMXS / displayMetrics.heightPixels, this.f2946zvd / displayMetrics.widthPixels, 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iM3289xrEuO, 1073741824);
        setMeasuredDimension(iM3289xrEuO, iM3289xrEuO);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    @Override // p131o.AbstractC3539d5
    /* renamed from: vI */
    public void mo3296vI() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.mo3296vI();
        for (int i = 0; i < this.f2942mByQ.size(); i++) {
            ((TextView) this.f2942mByQ.get(i)).setVisibility(0);
        }
    }

    /* renamed from: zvd */
    public final void m3297zvd(int i) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.f2942mByQ.size();
        boolean z = false;
        for (int i2 = 0; i2 < Math.max(this.f2943rWxwaT.length, size); i2++) {
            TextView textView = (TextView) this.f2942mByQ.get(i2);
            if (i2 >= this.f2943rWxwaT.length) {
                removeView(textView);
                this.f2942mByQ.remove(i2);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(AbstractC2007G4.f8312JHa, (ViewGroup) this, false);
                    this.f2942mByQ.put(i2, textView);
                    addView(textView);
                }
                textView.setText(this.f2943rWxwaT[i2]);
                textView.setTag(AbstractC1803D4.f7806YoKzxo, Integer.valueOf(i2));
                int i3 = (i2 / 12) + 1;
                textView.setTag(AbstractC1803D4.f7818qdMbNW, Integer.valueOf(i3));
                if (i3 > 1) {
                    z = true;
                }
                AbstractC2876T9.m10265alEkx(textView, this.f2937OjSQV);
                textView.setTextColor(this.f2935NPj);
                if (i != 0) {
                    textView.setContentDescription(getResources().getString(i, this.f2943rWxwaT[i2]));
                }
            }
        }
        this.f2939VocHEe.m3308fehf(z);
    }

    public ClockFaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2932BAnRFn = new Rect();
        this.f2941lB = new RectF();
        this.f2944wJVbdd = new Rect();
        this.f2942mByQ = new SparseArray();
        this.f2933CqaNbM = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3340a5.f12461SKTn, i, AbstractC2737R4.f10368MiMN);
        Resources resources = getResources();
        ColorStateList colorStateListM9577mjFkc = AbstractC2478N1.m9577mjFkc(context, typedArrayObtainStyledAttributes, AbstractC3340a5.f12502XDdeP);
        this.f2935NPj = colorStateListM9577mjFkc;
        LayoutInflater.from(context).inflate(AbstractC2007G4.f8328xJ, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(AbstractC1803D4.f7814lgHUyS);
        this.f2939VocHEe = clockHandView;
        this.f2945xrEuO = resources.getDimensionPixelSize(AbstractC4191n4.f15323VA);
        int colorForState = colorStateListM9577mjFkc.getColorForState(new int[]{R.attr.state_selected}, colorStateListM9577mjFkc.getDefaultColor());
        this.f2936Ne = new int[]{colorForState, colorForState, colorStateListM9577mjFkc.getDefaultColor()};
        clockHandView.m3299AZxh(this);
        int defaultColor = AbstractC4768vjlshU.m13795mjFkc(context, AbstractC3995k4.f14442AZxh).getDefaultColor();
        ColorStateList colorStateListM9577mjFkc2 = AbstractC2478N1.m9577mjFkc(context, typedArrayObtainStyledAttributes, AbstractC3340a5.f12643rdJr);
        setBackgroundColor(colorStateListM9577mjFkc2 != null ? colorStateListM9577mjFkc2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC0296mjFkc());
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.f2937OjSQV = new C0295AZxh();
        String[] strArr = new String[12];
        Arrays.fill(strArr, BuildConfig.f24315FLAVOR);
        m3292KLMXS(strArr, 0);
        this.f2934KLMXS = resources.getDimensionPixelSize(AbstractC4191n4.f15312HGpJ);
        this.f2946zvd = resources.getDimensionPixelSize(AbstractC4191n4.f15344vI);
        this.f2940cMLeY = resources.getDimensionPixelSize(AbstractC4191n4.f15327YoKzxo);
    }
}
