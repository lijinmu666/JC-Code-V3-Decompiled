package com.p038google.p039android.material.carousel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.p023widget.RecyclerView;
import com.p038google.p039android.material.carousel.C0249mjFkc;
import p131o.AbstractC2868T1;
import p131o.AbstractC4191n4;
import p131o.AbstractC4946yP;
import p131o.InterfaceC4810wLtdyQ;

/* renamed from: com.google.android.material.carousel.wA */
/* loaded from: classes.dex */
public final class C0250wA extends AbstractC4946yP {

    /* renamed from: mjFkc */
    public final boolean f2511mjFkc;

    /* renamed from: AZxh */
    public static final int[] f2508AZxh = {1};

    /* renamed from: wA */
    public static final int[] f2510wA = {1, 0};

    /* renamed from: ZfxDd */
    public static final int[] f2509ZfxDd = {0};

    /* renamed from: com.google.android.material.carousel.wA$mjFkc */
    public static final class mjFkc {

        /* renamed from: AZxh */
        public float f2512AZxh;

        /* renamed from: JHa */
        public float f2513JHa;

        /* renamed from: KLFTb */
        public float f2514KLFTb;

        /* renamed from: ZfxDd */
        public final int f2515ZfxDd;

        /* renamed from: lgHUyS */
        public final float f2516lgHUyS;

        /* renamed from: mjFkc */
        public final int f2517mjFkc;

        /* renamed from: wA */
        public final int f2518wA;

        /* renamed from: xJ */
        public final int f2519xJ;

        public mjFkc(int i, float f, float f2, float f3, int i2, float f4, int i3, float f5, int i4, float f6) {
            this.f2517mjFkc = i;
            this.f2512AZxh = AbstractC2868T1.m10212mjFkc(f, f2, f3);
            this.f2518wA = i2;
            this.f2514KLFTb = f4;
            this.f2515ZfxDd = i3;
            this.f2513JHa = f5;
            this.f2519xJ = i4;
            m2707wA(f6, f2, f3, f5);
            this.f2516lgHUyS = m2703AZxh(f5);
        }

        /* renamed from: AZxh */
        public final float m2703AZxh(float f) {
            if (m2704KLFTb()) {
                return Math.abs(f - this.f2513JHa) * this.f2517mjFkc;
            }
            return Float.MAX_VALUE;
        }

        /* renamed from: KLFTb */
        public final boolean m2704KLFTb() {
            int i = this.f2519xJ;
            if (i <= 0 || this.f2518wA <= 0 || this.f2515ZfxDd <= 0) {
                return i <= 0 || this.f2518wA <= 0 || this.f2513JHa > this.f2512AZxh;
            }
            float f = this.f2513JHa;
            float f2 = this.f2514KLFTb;
            return f > f2 && f2 > this.f2512AZxh;
        }

        /* renamed from: ZfxDd */
        public final float m2705ZfxDd() {
            return (this.f2513JHa * this.f2519xJ) + (this.f2514KLFTb * this.f2515ZfxDd) + (this.f2512AZxh * this.f2518wA);
        }

        /* renamed from: mjFkc */
        public final float m2706mjFkc(float f, int i, float f2, int i2, int i3) {
            if (i <= 0) {
                f2 = 0.0f;
            }
            float f3 = i;
            float f4 = i2 / 2.0f;
            return (f - ((f3 + f4) * f2)) / (i3 + f4);
        }

        public String toString() {
            return "Arrangement [priority=" + this.f2517mjFkc + ", smallCount=" + this.f2518wA + ", smallSize=" + this.f2512AZxh + ", mediumCount=" + this.f2515ZfxDd + ", mediumSize=" + this.f2514KLFTb + ", largeCount=" + this.f2519xJ + ", largeSize=" + this.f2513JHa + ", cost=" + this.f2516lgHUyS + "]";
        }

        /* renamed from: wA */
        public final void m2707wA(float f, float f2, float f3, float f4) {
            float fM2705ZfxDd = f - m2705ZfxDd();
            int i = this.f2518wA;
            if (i > 0 && fM2705ZfxDd > 0.0f) {
                float f5 = this.f2512AZxh;
                this.f2512AZxh = f5 + Math.min(fM2705ZfxDd / i, f3 - f5);
            } else if (i > 0 && fM2705ZfxDd < 0.0f) {
                float f6 = this.f2512AZxh;
                this.f2512AZxh = f6 + Math.max(fM2705ZfxDd / i, f2 - f6);
            }
            float fM2706mjFkc = m2706mjFkc(f, this.f2518wA, this.f2512AZxh, this.f2515ZfxDd, this.f2519xJ);
            this.f2513JHa = fM2706mjFkc;
            float f7 = (this.f2512AZxh + fM2706mjFkc) / 2.0f;
            this.f2514KLFTb = f7;
            int i2 = this.f2515ZfxDd;
            if (i2 <= 0 || fM2706mjFkc == f4) {
                return;
            }
            float f8 = (f4 - fM2706mjFkc) * this.f2519xJ;
            float fMin = Math.min(Math.abs(f8), f7 * 0.1f * i2);
            if (f8 > 0.0f) {
                this.f2514KLFTb -= fMin / this.f2515ZfxDd;
                this.f2513JHa += fMin / this.f2519xJ;
            } else {
                this.f2514KLFTb += fMin / this.f2515ZfxDd;
                this.f2513JHa -= fMin / this.f2519xJ;
            }
        }
    }

    public C0250wA() {
        this(false);
    }

    /* renamed from: wA */
    public static mjFkc m2697wA(float f, float f2, float f3, float f4, int[] iArr, float f5, int[] iArr2, float f6, int[] iArr3) {
        mjFkc mjfkc = null;
        int i = 1;
        for (int i2 : iArr3) {
            int length = iArr2.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = iArr2[i3];
                int length2 = iArr.length;
                int i5 = 0;
                while (i5 < length2) {
                    int i6 = i5;
                    int i7 = length2;
                    int i8 = i3;
                    int i9 = length;
                    mjFkc mjfkc2 = new mjFkc(i, f2, f3, f4, iArr[i5], f5, i4, f6, i2, f);
                    if (mjfkc == null || mjfkc2.f2516lgHUyS < mjfkc.f2516lgHUyS) {
                        if (mjfkc2.f2516lgHUyS == 0.0f) {
                            return mjfkc2;
                        }
                        mjfkc = mjfkc2;
                    }
                    i++;
                    i5 = i6 + 1;
                    length2 = i7;
                    i3 = i8;
                    length = i9;
                }
                i3++;
            }
        }
        return mjfkc;
    }

    /* renamed from: xJ */
    public static int m2698xJ(int[] iArr) {
        int i = Integer.MIN_VALUE;
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    @Override // p131o.AbstractC4946yP
    /* renamed from: AZxh */
    public C0249mjFkc mo2699AZxh(InterfaceC4810wLtdyQ interfaceC4810wLtdyQ, View view) {
        float fMo2670mjFkc = interfaceC4810wLtdyQ.mo2670mjFkc();
        RecyclerView.C0153fehf c0153fehf = (RecyclerView.C0153fehf) view.getLayoutParams();
        float f = ((ViewGroup.MarginLayoutParams) c0153fehf).leftMargin + ((ViewGroup.MarginLayoutParams) c0153fehf).rightMargin;
        float fM2700JHa = m2700JHa(view.getContext()) + f;
        float fM2701KLFTb = m2701KLFTb(view.getContext()) + f;
        float measuredWidth = view.getMeasuredWidth();
        float fMin = Math.min(measuredWidth + f, fMo2670mjFkc);
        float fM10212mjFkc = AbstractC2868T1.m10212mjFkc((measuredWidth / 3.0f) + f, m2700JHa(view.getContext()) + f, m2701KLFTb(view.getContext()) + f);
        float f2 = (fMin + fM10212mjFkc) / 2.0f;
        int[] iArr = f2508AZxh;
        int[] iArr2 = this.f2511mjFkc ? f2509ZfxDd : f2510wA;
        int iMax = (int) Math.max(1.0d, Math.floor(((fMo2670mjFkc - (m2698xJ(iArr2) * f2)) - (m2698xJ(iArr) * fM2701KLFTb)) / fMin));
        int iCeil = (int) Math.ceil(fMo2670mjFkc / fMin);
        int i = (iCeil - iMax) + 1;
        int[] iArr3 = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr3[i2] = iCeil - i2;
        }
        mjFkc mjfkcM2697wA = m2697wA(fMo2670mjFkc, fM10212mjFkc, fM2700JHa, fM2701KLFTb, iArr, f2, iArr2, fMin, iArr3);
        float fM2702ZfxDd = m2702ZfxDd(view.getContext()) + f;
        float f3 = fM2702ZfxDd / 2.0f;
        float f4 = 0.0f - f3;
        float f5 = (mjfkcM2697wA.f2513JHa / 2.0f) + 0.0f;
        float fMax = Math.max(0, mjfkcM2697wA.f2519xJ - 1);
        float f6 = mjfkcM2697wA.f2513JHa;
        float f7 = f5 + (fMax * f6);
        float f8 = (f6 / 2.0f) + f7;
        int i3 = mjfkcM2697wA.f2515ZfxDd;
        if (i3 > 0) {
            f7 = (mjfkcM2697wA.f2514KLFTb / 2.0f) + f8;
        }
        if (i3 > 0) {
            f8 = (mjfkcM2697wA.f2514KLFTb / 2.0f) + f7;
        }
        float f9 = mjfkcM2697wA.f2518wA > 0 ? f8 + (mjfkcM2697wA.f2512AZxh / 2.0f) : f7;
        float fMo2670mjFkc2 = interfaceC4810wLtdyQ.mo2670mjFkc() + f3;
        float fM14003mjFkc = AbstractC4946yP.m14003mjFkc(fM2702ZfxDd, mjfkcM2697wA.f2513JHa, f);
        float fM14003mjFkc2 = AbstractC4946yP.m14003mjFkc(mjfkcM2697wA.f2512AZxh, mjfkcM2697wA.f2513JHa, f);
        float fM14003mjFkc3 = AbstractC4946yP.m14003mjFkc(mjfkcM2697wA.f2514KLFTb, mjfkcM2697wA.f2513JHa, f);
        C0249mjFkc.AZxh aZxhM2693ZfxDd = new C0249mjFkc.AZxh(mjfkcM2697wA.f2513JHa).m2694mjFkc(f4, fM14003mjFkc, fM2702ZfxDd).m2693ZfxDd(f5, 0.0f, mjfkcM2697wA.f2513JHa, mjfkcM2697wA.f2519xJ, true);
        if (mjfkcM2697wA.f2515ZfxDd > 0) {
            aZxhM2693ZfxDd.m2694mjFkc(f7, fM14003mjFkc3, mjfkcM2697wA.f2514KLFTb);
        }
        int i4 = mjfkcM2697wA.f2518wA;
        if (i4 > 0) {
            aZxhM2693ZfxDd.m2695wA(f9, fM14003mjFkc2, mjfkcM2697wA.f2512AZxh, i4);
        }
        aZxhM2693ZfxDd.m2694mjFkc(fMo2670mjFkc2, fM14003mjFkc, fM2702ZfxDd);
        return aZxhM2693ZfxDd.m2692KLFTb();
    }

    /* renamed from: JHa */
    public final float m2700JHa(Context context) {
        return context.getResources().getDimension(AbstractC4191n4.f15341qdMbNW);
    }

    /* renamed from: KLFTb */
    public final float m2701KLFTb(Context context) {
        return context.getResources().getDimension(AbstractC4191n4.f15336lgHUyS);
    }

    /* renamed from: ZfxDd */
    public final float m2702ZfxDd(Context context) {
        return context.getResources().getDimension(AbstractC4191n4.f15348xJ);
    }

    public C0250wA(boolean z) {
        this.f2511mjFkc = z;
    }
}
