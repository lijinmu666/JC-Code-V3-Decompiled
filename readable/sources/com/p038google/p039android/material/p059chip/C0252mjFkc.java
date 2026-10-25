package com.p038google.p039android.material.p059chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.conscrypt.BuildConfig;
import p131o.AbstractC1735C5;
import p131o.AbstractC2052GmK;
import p131o.AbstractC2345L1;
import p131o.AbstractC2398LsBneK;
import p131o.AbstractC2478N1;
import p131o.AbstractC3340a5;
import p131o.AbstractC4260o8;
import p131o.AbstractC4332pCk;
import p131o.AbstractC4557sa;
import p131o.AbstractC4768vjlshU;
import p131o.AbstractC4898xfXeiC;
import p131o.C2255Jidt;
import p131o.C2542O1;
import p131o.C3008V7;
import p131o.C3343a8;
import p131o.C4788w2;

/* renamed from: com.google.android.material.chip.mjFkc */
/* loaded from: classes.dex */
public class C0252mjFkc extends C2542O1 implements Drawable.Callback, C3343a8.AZxh {

    /* renamed from: giT */
    public static final int[] f2545giT = {R.attr.state_enabled};

    /* renamed from: sRqPfw */
    public static final ShapeDrawable f2546sRqPfw = new ShapeDrawable(new OvalShape());

    /* renamed from: ANMGZc */
    public final Paint f2547ANMGZc;

    /* renamed from: BAnRFn */
    public float f2548BAnRFn;

    /* renamed from: CqaNbM */
    public boolean f2549CqaNbM;

    /* renamed from: GMIER */
    public Drawable f2550GMIER;

    /* renamed from: IVlxe */
    public int f2551IVlxe;

    /* renamed from: JBhc */
    public float f2552JBhc;

    /* renamed from: JYgkl */
    public C4788w2 f2553JYgkl;

    /* renamed from: JYn */
    public C4788w2 f2554JYn;

    /* renamed from: JrJO */
    public float f2555JrJO;

    /* renamed from: KLMXS */
    public ColorStateList f2556KLMXS;

    /* renamed from: KRTLGT */
    public boolean f2557KRTLGT;

    /* renamed from: LREOK */
    public ColorStateList f2558LREOK;

    /* renamed from: Moer */
    public int f2559Moer;

    /* renamed from: NKyg */
    public int f2560NKyg;

    /* renamed from: NPj */
    public Drawable f2561NPj;

    /* renamed from: Ne */
    public CharSequence f2562Ne;

    /* renamed from: OjSQV */
    public ColorStateList f2563OjSQV;

    /* renamed from: Qr */
    public int f2564Qr;

    /* renamed from: SOS */
    public int f2565SOS;

    /* renamed from: SmIWf */
    public int f2566SmIWf;

    /* renamed from: SwgkN */
    public float f2567SwgkN;

    /* renamed from: Vdz */
    public float f2568Vdz;

    /* renamed from: Vgyli */
    public int f2569Vgyli;

    /* renamed from: Vnb */
    public Drawable f2570Vnb;

    /* renamed from: VocHEe */
    public ColorStateList f2571VocHEe;

    /* renamed from: WGXroI */
    public float f2572WGXroI;

    /* renamed from: WrLQs */
    public boolean f2573WrLQs;

    /* renamed from: XFUzSY */
    public boolean f2574XFUzSY;

    /* renamed from: XV */
    public float f2575XV;

    /* renamed from: XbiWeM */
    public int[] f2576XbiWeM;

    /* renamed from: XtE */
    public ColorStateList f2577XtE;

    /* renamed from: alEkx */
    public final Paint f2578alEkx;

    /* renamed from: aqHPIZ */
    public CharSequence f2579aqHPIZ;

    /* renamed from: bbzow */
    public float f2580bbzow;

    /* renamed from: cMLeY */
    public boolean f2581cMLeY;

    /* renamed from: dm */
    public final Paint.FontMetrics f2582dm;

    /* renamed from: fFz */
    public PorterDuff.Mode f2583fFz;

    /* renamed from: gYa */
    public PorterDuffColorFilter f2584gYa;

    /* renamed from: gtIJp */
    public boolean f2585gtIJp;

    /* renamed from: jm */
    public final Context f2586jm;

    /* renamed from: jx */
    public WeakReference f2587jx;

    /* renamed from: kism */
    public int f2588kism;

    /* renamed from: lB */
    public float f2589lB;

    /* renamed from: lti */
    public boolean f2590lti;

    /* renamed from: mByQ */
    public float f2591mByQ;

    /* renamed from: nxI */
    public float f2592nxI;

    /* renamed from: oCFDzJ */
    public float f2593oCFDzJ;

    /* renamed from: rWxwaT */
    public boolean f2594rWxwaT;

    /* renamed from: tISON */
    public boolean f2595tISON;

    /* renamed from: tQ */
    public final RectF f2596tQ;

    /* renamed from: tjSezt */
    public int f2597tjSezt;

    /* renamed from: uH */
    public TextUtils.TruncateAt f2598uH;

    /* renamed from: uHVRx */
    public ColorStateList f2599uHVRx;

    /* renamed from: vI */
    public ColorStateList f2600vI;

    /* renamed from: vadzgd */
    public ColorStateList f2601vadzgd;

    /* renamed from: vjlshU */
    public final Path f2602vjlshU;

    /* renamed from: wJVbdd */
    public ColorStateList f2603wJVbdd;

    /* renamed from: xROA */
    public final C3343a8 f2604xROA;

    /* renamed from: xrEuO */
    public Drawable f2605xrEuO;

    /* renamed from: yX */
    public ColorFilter f2606yX;

    /* renamed from: yfx */
    public final PointF f2607yfx;

    /* renamed from: zvd */
    public float f2608zvd;

    /* renamed from: com.google.android.material.chip.mjFkc$mjFkc */
    public interface mjFkc {
        /* renamed from: mjFkc */
        void mo2733mjFkc();
    }

    public C0252mjFkc(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f2589lB = -1.0f;
        this.f2547ANMGZc = new Paint(1);
        this.f2582dm = new Paint.FontMetrics();
        this.f2596tQ = new RectF();
        this.f2607yfx = new PointF();
        this.f2602vjlshU = new Path();
        this.f2597tjSezt = 255;
        this.f2583fFz = PorterDuff.Mode.SRC_IN;
        this.f2587jx = new WeakReference(null);
        m9827cMLeY(context);
        this.f2586jm = context;
        C3343a8 c3343a8 = new C3343a8(this);
        this.f2604xROA = c3343a8;
        this.f2562Ne = BuildConfig.f24315FLAVOR;
        c3343a8.m11299KLFTb().density = context.getResources().getDisplayMetrics().density;
        this.f2578alEkx = null;
        int[] iArr = f2545giT;
        setState(iArr);
        m2786Mpf(iArr);
        this.f2595tISON = true;
        if (AbstractC1735C5.f7559mjFkc) {
            f2546sRqPfw.setTint(-1);
        }
    }

    /* renamed from: NKyg */
    public static C0252mjFkc m2746NKyg(Context context, AttributeSet attributeSet, int i, int i2) {
        C0252mjFkc c0252mjFkc = new C0252mjFkc(context, attributeSet, i, i2);
        c0252mjFkc.m2851oVXlhB(attributeSet, i, i2);
        return c0252mjFkc;
    }

    /* renamed from: RWyiuY */
    public static boolean m2747RWyiuY(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    /* renamed from: Vu */
    public static boolean m2748Vu(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    /* renamed from: knzZ */
    public static boolean m2749knzZ(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: uxlM */
    public static boolean m2750uxlM(C3008V7 c3008v7) {
        return (c3008v7 == null || c3008v7.m10676qdMbNW() == null || !c3008v7.m10676qdMbNW().isStateful()) ? false : true;
    }

    /* renamed from: APn */
    public boolean m2751APn() {
        return this.f2574XFUzSY;
    }

    /* renamed from: ArO */
    public void m2752ArO(boolean z) {
        this.f2595tISON = z;
    }

    /* renamed from: BABY */
    public final boolean m2753BABY() {
        return this.f2594rWxwaT && this.f2570Vnb != null;
    }

    /* renamed from: BxruE */
    public void m2754BxruE(ColorStateList colorStateList) {
        if (this.f2599uHVRx != colorStateList) {
            this.f2599uHVRx = colorStateList;
            if (m2790Qr()) {
                AbstractC4332pCk.m13081qdMbNW(this.f2550GMIER, colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* renamed from: CTcA */
    public void m2755CTcA() {
        mjFkc mjfkc = (mjFkc) this.f2587jx.get();
        if (mjfkc != null) {
            mjfkc.mo2733mjFkc();
        }
    }

    /* renamed from: CcoH */
    public void m2756CcoH(float f) {
        if (this.f2591mByQ != f) {
            this.f2591mByQ = f;
            this.f2547ANMGZc.setStrokeWidth(f);
            if (this.f2590lti) {
                super.m9804JBhc(f);
            }
            invalidateSelf();
        }
    }

    /* renamed from: CqAnRZ */
    public void m2757CqAnRZ(int i) {
        m2801TvfBiy(this.f2586jm.getResources().getDimension(i));
    }

    /* renamed from: Dp */
    public ColorStateList m2758Dp() {
        return this.f2603wJVbdd;
    }

    /* renamed from: ERt */
    public void m2759ERt(int i) {
        m2763FOJ(AbstractC4768vjlshU.m13795mjFkc(this.f2586jm, i));
    }

    /* renamed from: EeoThB */
    public void m2760EeoThB(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = BuildConfig.f24315FLAVOR;
        }
        if (TextUtils.equals(this.f2562Ne, charSequence)) {
            return;
        }
        this.f2562Ne = charSequence;
        this.f2604xROA.m11302qdMbNW(true);
        invalidateSelf();
        m2755CTcA();
    }

    /* renamed from: EoC */
    public final void m2761EoC(ColorStateList colorStateList) {
        if (this.f2600vI != colorStateList) {
            this.f2600vI = colorStateList;
            onStateChange(getState());
        }
    }

    /* renamed from: Es */
    public void m2762Es(boolean z) {
        if (this.f2574XFUzSY != z) {
            this.f2574XFUzSY = z;
            m2857qtZIjO();
            onStateChange(getState());
        }
    }

    /* renamed from: FOJ */
    public void m2763FOJ(ColorStateList colorStateList) {
        this.f2581cMLeY = true;
        if (this.f2556KLMXS != colorStateList) {
            this.f2556KLMXS = colorStateList;
            if (m2827eEOGOh()) {
                AbstractC4332pCk.m13081qdMbNW(this.f2605xrEuO, colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* renamed from: FbxKQm */
    public ColorStateList m2764FbxKQm() {
        return this.f2601vadzgd;
    }

    /* renamed from: Fztqa */
    public void m2765Fztqa(boolean z) {
        if (this.f2573WrLQs != z) {
            this.f2573WrLQs = z;
            float fM2864tQ = m2864tQ();
            if (!z && this.f2585gtIJp) {
                this.f2585gtIJp = false;
            }
            float fM2864tQ2 = m2864tQ();
            invalidateSelf();
            if (fM2864tQ != fM2864tQ2) {
                m2755CTcA();
            }
        }
    }

    /* renamed from: HExgdj */
    public void m2766HExgdj(float f) {
        if (this.f2555JrJO != f) {
            this.f2555JrJO = f;
            invalidateSelf();
            m2755CTcA();
        }
    }

    /* renamed from: HX */
    public void m2767HX(int i) {
        m2756CcoH(this.f2586jm.getResources().getDimension(i));
    }

    /* renamed from: Hk */
    public void m2768Hk(ColorStateList colorStateList) {
        if (this.f2601vadzgd != colorStateList) {
            this.f2601vadzgd = colorStateList;
            if (m2753BABY()) {
                AbstractC4332pCk.m13081qdMbNW(this.f2570Vnb, colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* renamed from: Htq */
    public void m2769Htq(int i) {
        m2806VfB(AbstractC4768vjlshU.m13794AZxh(this.f2586jm, i));
    }

    /* renamed from: IPpyV */
    public void m2770IPpyV(float f) {
        C3008V7 c3008v7M2825dkKKW = m2825dkKKW();
        if (c3008v7M2825dkKKW != null) {
            c3008v7M2825dkKKW.m10671VA(f);
            this.f2604xROA.m11299KLFTb().setTextSize(f);
            mo2846mjFkc();
        }
    }

    /* renamed from: IVlxe */
    public float m2771IVlxe() {
        if (m2753BABY()) {
            return this.f2567SwgkN + this.f2593oCFDzJ + this.f2552JBhc;
        }
        return 0.0f;
    }

    /* renamed from: IvRQOa */
    public final ColorFilter m2772IvRQOa() {
        ColorFilter colorFilter = this.f2606yX;
        return colorFilter != null ? colorFilter : this.f2584gYa;
    }

    /* renamed from: IyS */
    public final float m2773IyS() {
        Drawable drawable = this.f2585gtIJp ? this.f2550GMIER : this.f2605xrEuO;
        float f = this.f2608zvd;
        return (f > 0.0f || drawable == null) ? f : drawable.getIntrinsicWidth();
    }

    /* renamed from: JOe */
    public void m2774JOe(int i) {
        m2853pJeaSR(this.f2586jm.getResources().getBoolean(i));
    }

    /* renamed from: Jidt */
    public float m2775Jidt() {
        return this.f2575XV;
    }

    /* renamed from: Jk */
    public ColorStateList m2776Jk() {
        return this.f2563OjSQV;
    }

    /* renamed from: KRckQg */
    public C4788w2 m2777KRckQg() {
        return this.f2554JYn;
    }

    /* renamed from: KSf */
    public void m2778KSf(int i) {
        m2766HExgdj(this.f2586jm.getResources().getDimension(i));
    }

    /* renamed from: LREOK */
    public final void m2779LREOK(Canvas canvas, Rect rect) {
        if (m2753BABY()) {
            m2872vjlshU(rect, this.f2596tQ);
            RectF rectF = this.f2596tQ;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.f2570Vnb.setBounds(0, 0, (int) this.f2596tQ.width(), (int) this.f2596tQ.height());
            if (AbstractC1735C5.f7559mjFkc) {
                this.f2561NPj.setBounds(this.f2570Vnb.getBounds());
                this.f2561NPj.jumpToCurrentState();
                this.f2561NPj.draw(canvas);
            } else {
                this.f2570Vnb.draw(canvas);
            }
            canvas.translate(-f, -f2);
        }
    }

    /* renamed from: LeWm */
    public final boolean m2780LeWm(int[] iArr, int[] iArr2) {
        boolean z;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.f2600vI;
        int iM9817VA = m9817VA(colorStateList != null ? colorStateList.getColorForState(iArr, this.f2551IVlxe) : 0);
        boolean state = true;
        if (this.f2551IVlxe != iM9817VA) {
            this.f2551IVlxe = iM9817VA;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.f2571VocHEe;
        int iM9817VA2 = m9817VA(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f2559Moer) : 0);
        if (this.f2559Moer != iM9817VA2) {
            this.f2559Moer = iM9817VA2;
            zOnStateChange = true;
        }
        int iM9304lgHUyS = AbstractC2345L1.m9304lgHUyS(iM9817VA, iM9817VA2);
        if ((this.f2566SmIWf != iM9304lgHUyS) | (m9802Gd() == null)) {
            this.f2566SmIWf = iM9304lgHUyS;
            m9841uHVRx(ColorStateList.valueOf(iM9304lgHUyS));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.f2603wJVbdd;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f2565SOS) : 0;
        if (this.f2565SOS != colorForState) {
            this.f2565SOS = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.f2577XtE == null || !AbstractC1735C5.m7749AZxh(iArr)) ? 0 : this.f2577XtE.getColorForState(iArr, this.f2564Qr);
        if (this.f2564Qr != colorForState2) {
            this.f2564Qr = colorForState2;
            if (this.f2574XFUzSY) {
                zOnStateChange = true;
            }
        }
        int colorForState3 = (this.f2604xROA.m11300ZfxDd() == null || this.f2604xROA.m11300ZfxDd().m10676qdMbNW() == null) ? 0 : this.f2604xROA.m11300ZfxDd().m10676qdMbNW().getColorForState(iArr, this.f2560NKyg);
        if (this.f2560NKyg != colorForState3) {
            this.f2560NKyg = colorForState3;
            zOnStateChange = true;
        }
        boolean z2 = m2749knzZ(getState(), R.attr.state_checked) && this.f2573WrLQs;
        if (this.f2585gtIJp == z2 || this.f2550GMIER == null) {
            z = false;
        } else {
            float fM2864tQ = m2864tQ();
            this.f2585gtIJp = z2;
            if (fM2864tQ != m2864tQ()) {
                zOnStateChange = true;
                z = true;
            } else {
                z = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.f2558LREOK;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f2588kism) : 0;
        if (this.f2588kism != colorForState4) {
            this.f2588kism = colorForState4;
            this.f2584gYa = AbstractC2052GmK.m8460AZxh(this, this.f2558LREOK, this.f2583fFz);
        } else {
            state = zOnStateChange;
        }
        if (m2748Vu(this.f2605xrEuO)) {
            state |= this.f2605xrEuO.setState(iArr);
        }
        if (m2748Vu(this.f2550GMIER)) {
            state |= this.f2550GMIER.setState(iArr);
        }
        if (m2748Vu(this.f2570Vnb)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.f2570Vnb.setState(iArr3);
        }
        if (AbstractC1735C5.f7559mjFkc && m2748Vu(this.f2561NPj)) {
            state |= this.f2561NPj.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z) {
            m2755CTcA();
        }
        return state;
    }

    /* renamed from: LlB */
    public void m2781LlB(int i) {
        m2842kOlLW(this.f2586jm.getResources().getDimension(i));
    }

    /* renamed from: LsBneK */
    public void m2782LsBneK(boolean z) {
        if (this.f2557KRTLGT != z) {
            boolean zM2839jpz = m2839jpz();
            this.f2557KRTLGT = z;
            boolean zM2839jpz2 = m2839jpz();
            if (zM2839jpz != zM2839jpz2) {
                if (zM2839jpz2) {
                    m2820alEkx(this.f2550GMIER);
                } else {
                    m2831gJsSk(this.f2550GMIER);
                }
                invalidateSelf();
                m2755CTcA();
            }
        }
    }

    /* renamed from: MC */
    public void m2783MC(float f) {
        if (this.f2552JBhc != f) {
            this.f2552JBhc = f;
            invalidateSelf();
            if (m2753BABY()) {
                m2755CTcA();
            }
        }
    }

    /* renamed from: MFekjo */
    public void m2784MFekjo(float f) {
        if (this.f2580bbzow != f) {
            this.f2580bbzow = f;
            invalidateSelf();
            m2755CTcA();
        }
    }

    /* renamed from: Moer */
    public final void m2785Moer(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.f2562Ne != null) {
            float fM2864tQ = this.f2555JrJO + m2864tQ() + this.f2575XV;
            float fM2771IVlxe = this.f2568Vdz + m2771IVlxe() + this.f2580bbzow;
            if (AbstractC4332pCk.m13072AZxh(this) == 0) {
                rectF.left = rect.left + fM2864tQ;
                rectF.right = rect.right - fM2771IVlxe;
            } else {
                rectF.left = rect.left + fM2771IVlxe;
                rectF.right = rect.right - fM2864tQ;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    /* renamed from: Mpf */
    public boolean m2786Mpf(int[] iArr) {
        if (Arrays.equals(this.f2576XbiWeM, iArr)) {
            return false;
        }
        this.f2576XbiWeM = iArr;
        if (m2753BABY()) {
            return m2780LeWm(getState(), iArr);
        }
        return false;
    }

    /* renamed from: NV */
    public float m2787NV() {
        return this.f2580bbzow;
    }

    /* renamed from: Otxclu */
    public void m2788Otxclu(ColorStateList colorStateList) {
        if (this.f2563OjSQV != colorStateList) {
            this.f2563OjSQV = colorStateList;
            m2857qtZIjO();
            onStateChange(getState());
        }
    }

    /* renamed from: OzIs */
    public void m2789OzIs(int i) {
        m2788Otxclu(AbstractC4768vjlshU.m13795mjFkc(this.f2586jm, i));
    }

    /* renamed from: Qr */
    public final boolean m2790Qr() {
        return this.f2557KRTLGT && this.f2550GMIER != null && this.f2573WrLQs;
    }

    /* renamed from: QyMqpM */
    public void m2791QyMqpM(int i) {
        m2849np(this.f2586jm.getResources().getDimension(i));
    }

    /* renamed from: QyqF */
    public void m2792QyqF(int i) {
        m2782LsBneK(this.f2586jm.getResources().getBoolean(i));
    }

    /* renamed from: RWb */
    public void m2793RWb(C4788w2 c4788w2) {
        this.f2554JYn = c4788w2;
    }

    /* renamed from: Rc */
    public CharSequence m2794Rc() {
        return this.f2579aqHPIZ;
    }

    /* renamed from: Rsp */
    public void m2795Rsp(float f) {
        if (this.f2567SwgkN != f) {
            this.f2567SwgkN = f;
            invalidateSelf();
            if (m2753BABY()) {
                m2755CTcA();
            }
        }
    }

    /* renamed from: SKTn */
    public float m2796SKTn() {
        return this.f2552JBhc;
    }

    /* renamed from: SOS */
    public Paint.Align m2797SOS(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.f2562Ne != null) {
            float fM2864tQ = this.f2555JrJO + m2864tQ() + this.f2575XV;
            if (AbstractC4332pCk.m13072AZxh(this) == 0) {
                pointF.x = rect.left + fM2864tQ;
            } else {
                pointF.x = rect.right - fM2864tQ;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - m2798SmIWf();
        }
        return align;
    }

    /* renamed from: SmIWf */
    public final float m2798SmIWf() {
        this.f2604xROA.m11299KLFTb().getFontMetrics(this.f2582dm);
        Paint.FontMetrics fontMetrics = this.f2582dm;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    /* renamed from: Sx */
    public void m2799Sx(float f) {
        if (this.f2572WGXroI != f) {
            float fM2864tQ = m2864tQ();
            this.f2572WGXroI = f;
            float fM2864tQ2 = m2864tQ();
            invalidateSelf();
            if (fM2864tQ != fM2864tQ2) {
                m2755CTcA();
            }
        }
    }

    /* renamed from: TFbkuO */
    public void m2800TFbkuO(int i) {
        this.f2569Vgyli = i;
    }

    /* renamed from: TvfBiy */
    public void m2801TvfBiy(float f) {
        if (this.f2593oCFDzJ != f) {
            this.f2593oCFDzJ = f;
            invalidateSelf();
            if (m2753BABY()) {
                m2755CTcA();
            }
        }
    }

    /* renamed from: Tw */
    public void m2802Tw(int i) {
        m2754BxruE(AbstractC4768vjlshU.m13795mjFkc(this.f2586jm, i));
    }

    /* renamed from: UDcil */
    public void m2803UDcil(TextUtils.TruncateAt truncateAt) {
        this.f2598uH = truncateAt;
    }

    /* renamed from: UOnCkw */
    public void m2804UOnCkw(int i) {
        m2838jY(C4788w2.m13812wA(this.f2586jm, i));
    }

    /* renamed from: UPU */
    public void m2805UPU(int i) {
        m2784MFekjo(this.f2586jm.getResources().getDimension(i));
    }

    /* renamed from: VfB */
    public void m2806VfB(Drawable drawable) {
        if (this.f2550GMIER != drawable) {
            float fM2864tQ = m2864tQ();
            this.f2550GMIER = drawable;
            float fM2864tQ2 = m2864tQ();
            m2831gJsSk(this.f2550GMIER);
            m2820alEkx(this.f2550GMIER);
            invalidateSelf();
            if (fM2864tQ != fM2864tQ2) {
                m2755CTcA();
            }
        }
    }

    /* renamed from: Vgyli */
    public float m2807Vgyli() {
        return this.f2568Vdz;
    }

    /* renamed from: Vptz */
    public void m2808Vptz(ColorStateList colorStateList) {
        if (this.f2603wJVbdd != colorStateList) {
            this.f2603wJVbdd = colorStateList;
            if (this.f2590lti) {
                m9815SwgkN(colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* renamed from: XD */
    public float m2809XD() {
        return this.f2548BAnRFn;
    }

    /* renamed from: XDdeP */
    public float m2810XDdeP() {
        return this.f2567SwgkN;
    }

    /* renamed from: XFUzSY */
    public final void m2811XFUzSY(Canvas canvas, Rect rect) {
        if (this.f2562Ne != null) {
            Paint.Align alignM2797SOS = m2797SOS(rect, this.f2607yfx);
            m2785Moer(rect, this.f2596tQ);
            if (this.f2604xROA.m11300ZfxDd() != null) {
                this.f2604xROA.m11299KLFTb().drawableState = getState();
                this.f2604xROA.m11297Dt(this.f2586jm);
            }
            this.f2604xROA.m11299KLFTb().setTextAlign(alignM2797SOS);
            int iSave = 0;
            boolean z = Math.round(this.f2604xROA.m11298JHa(m2845mPWV().toString())) > Math.round(this.f2596tQ.width());
            if (z) {
                iSave = canvas.save();
                canvas.clipRect(this.f2596tQ);
            }
            CharSequence charSequenceEllipsize = this.f2562Ne;
            if (z && this.f2598uH != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f2604xROA.m11299KLFTb(), this.f2596tQ.width(), this.f2598uH);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.f2607yfx;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.f2604xROA.m11299KLFTb());
            if (z) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    /* renamed from: XbiWeM */
    public final void m2812XbiWeM(Canvas canvas, Rect rect) {
        Paint paint = this.f2578alEkx;
        if (paint != null) {
            paint.setColor(AbstractC4898xfXeiC.m13959ETF(-16777216, 127));
            canvas.drawRect(rect, this.f2578alEkx);
            if (m2827eEOGOh() || m2839jpz()) {
                m2826dm(rect, this.f2596tQ);
                canvas.drawRect(this.f2596tQ, this.f2578alEkx);
            }
            if (this.f2562Ne != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f2578alEkx);
            }
            if (m2753BABY()) {
                m2872vjlshU(rect, this.f2596tQ);
                canvas.drawRect(this.f2596tQ, this.f2578alEkx);
            }
            this.f2578alEkx.setColor(AbstractC4898xfXeiC.m13959ETF(-65536, 127));
            m2884yfx(rect, this.f2596tQ);
            canvas.drawRect(this.f2596tQ, this.f2578alEkx);
            this.f2578alEkx.setColor(AbstractC4898xfXeiC.m13959ETF(-16711936, 127));
            m2877xROA(rect, this.f2596tQ);
            canvas.drawRect(this.f2596tQ, this.f2578alEkx);
        }
    }

    /* renamed from: XgAT */
    public final float m2813XgAT() {
        Drawable drawable = this.f2585gtIJp ? this.f2550GMIER : this.f2605xrEuO;
        float f = this.f2608zvd;
        if (f > 0.0f || drawable == null) {
            return f;
        }
        float fCeil = (float) Math.ceil(AbstractC4557sa.m13501AZxh(this.f2586jm, 24));
        return ((float) drawable.getIntrinsicHeight()) <= fCeil ? drawable.getIntrinsicHeight() : fCeil;
    }

    /* renamed from: XtE */
    public Drawable m2814XtE() {
        return this.f2550GMIER;
    }

    /* renamed from: Xxz */
    public float m2815Xxz() {
        return this.f2572WGXroI;
    }

    /* renamed from: XyP */
    public void m2816XyP(mjFkc mjfkc) {
        this.f2587jx = new WeakReference(mjfkc);
    }

    /* renamed from: ZGL */
    public boolean m2817ZGL() {
        return this.f2595tISON;
    }

    /* renamed from: Zdbk */
    public float m2818Zdbk() {
        return this.f2592nxI;
    }

    /* renamed from: aDq */
    public void m2819aDq(int i) {
        m2783MC(this.f2586jm.getResources().getDimension(i));
    }

    /* renamed from: alEkx */
    public final void m2820alEkx(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        AbstractC4332pCk.m13083xJ(drawable, AbstractC4332pCk.m13072AZxh(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f2570Vnb) {
            if (drawable.isStateful()) {
                drawable.setState(m2828eQ());
            }
            AbstractC4332pCk.m13081qdMbNW(drawable, this.f2601vadzgd);
            return;
        }
        Drawable drawable2 = this.f2605xrEuO;
        if (drawable == drawable2 && this.f2581cMLeY) {
            AbstractC4332pCk.m13081qdMbNW(drawable2, this.f2556KLMXS);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    /* renamed from: bWIyu */
    public void m2821bWIyu(boolean z) {
        if (this.f2594rWxwaT != z) {
            boolean zM2753BABY = m2753BABY();
            this.f2594rWxwaT = z;
            boolean zM2753BABY2 = m2753BABY();
            if (zM2753BABY != zM2753BABY2) {
                if (zM2753BABY2) {
                    m2820alEkx(this.f2570Vnb);
                } else {
                    m2831gJsSk(this.f2570Vnb);
                }
                invalidateSelf();
                m2755CTcA();
            }
        }
    }

    /* renamed from: bc */
    public void m2822bc(int i) {
        m2876xCVa(this.f2586jm.getResources().getDimension(i));
    }

    /* renamed from: cdjp */
    public void m2823cdjp(C3008V7 c3008v7) {
        this.f2604xROA.m11301lgHUyS(c3008v7, this.f2586jm);
    }

    /* renamed from: dGDT */
    public C4788w2 m2824dGDT() {
        return this.f2553JYgkl;
    }

    /* renamed from: dkKKW */
    public C3008V7 m2825dkKKW() {
        return this.f2604xROA.m11300ZfxDd();
    }

    /* renamed from: dm */
    public final void m2826dm(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (m2827eEOGOh() || m2839jpz()) {
            float f = this.f2555JrJO + this.f2592nxI;
            float fM2773IyS = m2773IyS();
            if (AbstractC4332pCk.m13072AZxh(this) == 0) {
                float f2 = rect.left + f;
                rectF.left = f2;
                rectF.right = f2 + fM2773IyS;
            } else {
                float f3 = rect.right - f;
                rectF.right = f3;
                rectF.left = f3 - fM2773IyS;
            }
            float fM2813XgAT = m2813XgAT();
            float fExactCenterY = rect.exactCenterY() - (fM2813XgAT / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fM2813XgAT;
        }
    }

    @Override // p131o.C2542O1, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i = this.f2597tjSezt;
        int iM9395mjFkc = i < 255 ? AbstractC2398LsBneK.m9395mjFkc(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i) : 0;
        m2832gYa(canvas, bounds);
        m2843kism(canvas, bounds);
        if (this.f2590lti) {
            super.draw(canvas);
        }
        m2882yX(canvas, bounds);
        m2829fFz(canvas, bounds);
        m2865tjSezt(canvas, bounds);
        m2834gtIJp(canvas, bounds);
        if (this.f2595tISON) {
            m2811XFUzSY(canvas, bounds);
        }
        m2779LREOK(canvas, bounds);
        m2812XbiWeM(canvas, bounds);
        if (this.f2597tjSezt < 255) {
            canvas.restoreToCount(iM9395mjFkc);
        }
    }

    /* renamed from: eEOGOh */
    public final boolean m2827eEOGOh() {
        return this.f2549CqaNbM && this.f2605xrEuO != null;
    }

    /* renamed from: eQ */
    public int[] m2828eQ() {
        return this.f2576XbiWeM;
    }

    /* renamed from: fFz */
    public final void m2829fFz(Canvas canvas, Rect rect) {
        this.f2547ANMGZc.setColor(this.f2564Qr);
        this.f2547ANMGZc.setStyle(Paint.Style.FILL);
        this.f2596tQ.set(rect);
        if (!this.f2590lti) {
            canvas.drawRoundRect(this.f2596tQ, m2862tISON(), m2862tISON(), this.f2547ANMGZc);
        } else {
            m9834lgHUyS(new RectF(rect), this.f2602vjlshU);
            super.m9837qGY(canvas, this.f2547ANMGZc, this.f2602vjlshU, m9829eyqo());
        }
    }

    /* renamed from: fLidf */
    public float m2830fLidf() {
        return this.f2591mByQ;
    }

    /* renamed from: gJsSk */
    public final void m2831gJsSk(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    /* renamed from: gYa */
    public final void m2832gYa(Canvas canvas, Rect rect) {
        if (this.f2590lti) {
            return;
        }
        this.f2547ANMGZc.setColor(this.f2551IVlxe);
        this.f2547ANMGZc.setStyle(Paint.Style.FILL);
        this.f2596tQ.set(rect);
        canvas.drawRoundRect(this.f2596tQ, m2862tISON(), m2862tISON(), this.f2547ANMGZc);
    }

    @Override // p131o.C2542O1, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2597tjSezt;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f2606yX;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f2548BAnRFn;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f2555JrJO + m2864tQ() + this.f2575XV + this.f2604xROA.m11298JHa(m2845mPWV().toString()) + this.f2580bbzow + m2771IVlxe() + this.f2568Vdz), this.f2569Vgyli);
    }

    @Override // p131o.C2542O1, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // p131o.C2542O1, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f2590lti) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f2589lB);
        } else {
            outline.setRoundRect(bounds, this.f2589lB);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    /* renamed from: giT */
    public float m2833giT() {
        return this.f2608zvd;
    }

    /* renamed from: gtIJp */
    public final void m2834gtIJp(Canvas canvas, Rect rect) {
        if (m2839jpz()) {
            m2826dm(rect, this.f2596tQ);
            RectF rectF = this.f2596tQ;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.f2550GMIER.setBounds(0, 0, (int) this.f2596tQ.width(), (int) this.f2596tQ.height());
            this.f2550GMIER.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    /* renamed from: gtr */
    public float m2835gtr() {
        return this.f2555JrJO;
    }

    /* renamed from: hvGY */
    public Drawable m2836hvGY() {
        Drawable drawable = this.f2570Vnb;
        if (drawable != null) {
            return AbstractC4332pCk.m13074ETF(drawable);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // p131o.C2542O1, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return m2747RWyiuY(this.f2600vI) || m2747RWyiuY(this.f2571VocHEe) || m2747RWyiuY(this.f2603wJVbdd) || (this.f2574XFUzSY && m2747RWyiuY(this.f2577XtE)) || m2750uxlM(this.f2604xROA.m11300ZfxDd()) || m2790Qr() || m2748Vu(this.f2605xrEuO) || m2748Vu(this.f2550GMIER) || m2747RWyiuY(this.f2558LREOK);
    }

    /* renamed from: jTNPnW */
    public void m2837jTNPnW(int i) {
        m2793RWb(C4788w2.m13812wA(this.f2586jm, i));
    }

    /* renamed from: jY */
    public void m2838jY(C4788w2 c4788w2) {
        this.f2553JYgkl = c4788w2;
    }

    /* renamed from: jpz */
    public final boolean m2839jpz() {
        return this.f2557KRTLGT && this.f2550GMIER != null && this.f2585gtIJp;
    }

    /* renamed from: jtz */
    public void m2840jtz(RectF rectF) {
        m2877xROA(getBounds(), rectF);
    }

    /* renamed from: jx */
    public ColorStateList m2841jx() {
        return this.f2599uHVRx;
    }

    /* renamed from: kOlLW */
    public void m2842kOlLW(float f) {
        if (this.f2575XV != f) {
            this.f2575XV = f;
            invalidateSelf();
            m2755CTcA();
        }
    }

    /* renamed from: kism */
    public final void m2843kism(Canvas canvas, Rect rect) {
        if (this.f2590lti) {
            return;
        }
        this.f2547ANMGZc.setColor(this.f2559Moer);
        this.f2547ANMGZc.setStyle(Paint.Style.FILL);
        this.f2547ANMGZc.setColorFilter(m2772IvRQOa());
        this.f2596tQ.set(rect);
        canvas.drawRoundRect(this.f2596tQ, m2862tISON(), m2862tISON(), this.f2547ANMGZc);
    }

    /* renamed from: lti */
    public Drawable m2844lti() {
        Drawable drawable = this.f2605xrEuO;
        if (drawable != null) {
            return AbstractC4332pCk.m13074ETF(drawable);
        }
        return null;
    }

    /* renamed from: mPWV */
    public CharSequence m2845mPWV() {
        return this.f2562Ne;
    }

    @Override // p131o.C3343a8.AZxh
    /* renamed from: mjFkc */
    public void mo2846mjFkc() {
        m2755CTcA();
        invalidateSelf();
    }

    /* renamed from: mzUGzO */
    public void m2847mzUGzO(int i) {
        m2765Fztqa(this.f2586jm.getResources().getBoolean(i));
    }

    /* renamed from: nUaNy */
    public void m2848nUaNy(ColorStateList colorStateList) {
        if (this.f2571VocHEe != colorStateList) {
            this.f2571VocHEe = colorStateList;
            onStateChange(getState());
        }
    }

    /* renamed from: np */
    public void m2849np(float f) {
        if (this.f2548BAnRFn != f) {
            this.f2548BAnRFn = f;
            invalidateSelf();
            m2755CTcA();
        }
    }

    /* renamed from: oJ */
    public void m2850oJ(int i) {
        m2768Hk(AbstractC4768vjlshU.m13795mjFkc(this.f2586jm, i));
    }

    /* renamed from: oVXlhB */
    public final void m2851oVXlhB(AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayM12940lgHUyS = AbstractC4260o8.m12940lgHUyS(this.f2586jm, attributeSet, AbstractC3340a5.f12496WGXroI, i, i2, new int[0]);
        this.f2590lti = typedArrayM12940lgHUyS.hasValue(AbstractC3340a5.f12500XD);
        m2761EoC(AbstractC2478N1.m9577mjFkc(this.f2586jm, typedArrayM12940lgHUyS, AbstractC3340a5.f12562gYa));
        m2848nUaNy(AbstractC2478N1.m9577mjFkc(this.f2586jm, typedArrayM12940lgHUyS, AbstractC3340a5.f12701yfx));
        m2849np(typedArrayM12940lgHUyS.getDimension(AbstractC3340a5.f12431NKyg, 0.0f));
        if (typedArrayM12940lgHUyS.hasValue(AbstractC3340a5.f12678vjlshU)) {
            m2876xCVa(typedArrayM12940lgHUyS.getDimension(AbstractC3340a5.f12678vjlshU, 0.0f));
        }
        m2808Vptz(AbstractC2478N1.m9577mjFkc(this.f2586jm, typedArrayM12940lgHUyS, AbstractC3340a5.f12658tjSezt));
        m2756CcoH(typedArrayM12940lgHUyS.getDimension(AbstractC3340a5.f12699yX, 0.0f));
        m2788Otxclu(AbstractC2478N1.m9577mjFkc(this.f2586jm, typedArrayM12940lgHUyS, AbstractC3340a5.f12648sRqPfw));
        m2760EeoThB(typedArrayM12940lgHUyS.getText(AbstractC3340a5.f12488Vdz));
        C3008V7 c3008v7M9575KLFTb = AbstractC2478N1.m9575KLFTb(this.f2586jm, typedArrayM12940lgHUyS, AbstractC3340a5.f12504XV);
        c3008v7M9575KLFTb.m10671VA(typedArrayM12940lgHUyS.getDimension(AbstractC3340a5.f12538bbzow, c3008v7M9575KLFTb.m10666Dt()));
        m2823cdjp(c3008v7M9575KLFTb);
        int i3 = typedArrayM12940lgHUyS.getInt(AbstractC3340a5.f12468SwgkN, 0);
        if (i3 == 1) {
            m2803UDcil(TextUtils.TruncateAt.START);
        } else if (i3 == 2) {
            m2803UDcil(TextUtils.TruncateAt.MIDDLE);
        } else if (i3 == 3) {
            m2803UDcil(TextUtils.TruncateAt.END);
        }
        m2853pJeaSR(typedArrayM12940lgHUyS.getBoolean(AbstractC3340a5.f12448Qr, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            m2853pJeaSR(typedArrayM12940lgHUyS.getBoolean(AbstractC3340a5.f12427Moer, false));
        }
        m2869ui(AbstractC2478N1.m9578wA(this.f2586jm, typedArrayM12940lgHUyS, AbstractC3340a5.f12387IVlxe));
        if (typedArrayM12940lgHUyS.hasValue(AbstractC3340a5.f12462SOS)) {
            m2763FOJ(AbstractC2478N1.m9577mjFkc(this.f2586jm, typedArrayM12940lgHUyS, AbstractC3340a5.f12462SOS));
        }
        m2855qGgY(typedArrayM12940lgHUyS.getDimension(AbstractC3340a5.f12466SmIWf, -1.0f));
        m2821bWIyu(typedArrayM12940lgHUyS.getBoolean(AbstractC3340a5.f12663uH, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            m2821bWIyu(typedArrayM12940lgHUyS.getBoolean(AbstractC3340a5.f12555fFz, false));
        }
        m2879xbjHT(AbstractC2478N1.m9578wA(this.f2586jm, typedArrayM12940lgHUyS, AbstractC3340a5.f12414LREOK));
        m2768Hk(AbstractC2478N1.m9577mjFkc(this.f2586jm, typedArrayM12940lgHUyS, AbstractC3340a5.f12589jx));
        m2801TvfBiy(typedArrayM12940lgHUyS.getDimension(AbstractC3340a5.f12503XFUzSY, 0.0f));
        m2765Fztqa(typedArrayM12940lgHUyS.getBoolean(AbstractC3340a5.f12584jm, false));
        m2782LsBneK(typedArrayM12940lgHUyS.getBoolean(AbstractC3340a5.f12657tQ, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            m2782LsBneK(typedArrayM12940lgHUyS.getBoolean(AbstractC3340a5.f12529alEkx, false));
        }
        m2806VfB(AbstractC2478N1.m9578wA(this.f2586jm, typedArrayM12940lgHUyS, AbstractC3340a5.f12317ANMGZc));
        if (typedArrayM12940lgHUyS.hasValue(AbstractC3340a5.f12550dm)) {
            m2754BxruE(AbstractC2478N1.m9577mjFkc(this.f2586jm, typedArrayM12940lgHUyS, AbstractC3340a5.f12550dm));
        }
        m2793RWb(C4788w2.m13809AZxh(this.f2586jm, typedArrayM12940lgHUyS, AbstractC3340a5.f12570gtr));
        m2838jY(C4788w2.m13809AZxh(this.f2586jm, typedArrayM12940lgHUyS, AbstractC3340a5.f12490Vgyli));
        m2766HExgdj(typedArrayM12940lgHUyS.getDimension(AbstractC3340a5.f12595kism, 0.0f));
        m2873wGscSa(typedArrayM12940lgHUyS.getDimension(AbstractC3340a5.f12566giT, 0.0f));
        m2799Sx(typedArrayM12940lgHUyS.getDimension(AbstractC3340a5.f12602lti, 0.0f));
        m2842kOlLW(typedArrayM12940lgHUyS.getDimension(AbstractC3340a5.f12556fLidf, 0.0f));
        m2784MFekjo(typedArrayM12940lgHUyS.getDimension(AbstractC3340a5.f12342Dp, 0.0f));
        m2795Rsp(typedArrayM12940lgHUyS.getDimension(AbstractC3340a5.f12508XtE, 0.0f));
        m2783MC(typedArrayM12940lgHUyS.getDimension(AbstractC3340a5.f12506XbiWeM, 0.0f));
        m2874wLtdyQ(typedArrayM12940lgHUyS.getDimension(AbstractC3340a5.f12692xROA, 0.0f));
        m2800TFbkuO(typedArrayM12940lgHUyS.getDimensionPixelSize(AbstractC3340a5.f12393JBhc, Integer.MAX_VALUE));
        typedArrayM12940lgHUyS.recycle();
    }

    /* renamed from: oaI */
    public boolean m2852oaI() {
        return this.f2594rWxwaT;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (m2827eEOGOh()) {
            zOnLayoutDirectionChanged |= AbstractC4332pCk.m13083xJ(this.f2605xrEuO, i);
        }
        if (m2839jpz()) {
            zOnLayoutDirectionChanged |= AbstractC4332pCk.m13083xJ(this.f2550GMIER, i);
        }
        if (m2753BABY()) {
            zOnLayoutDirectionChanged |= AbstractC4332pCk.m13083xJ(this.f2570Vnb, i);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        boolean zOnLevelChange = super.onLevelChange(i);
        if (m2827eEOGOh()) {
            zOnLevelChange |= this.f2605xrEuO.setLevel(i);
        }
        if (m2839jpz()) {
            zOnLevelChange |= this.f2550GMIER.setLevel(i);
        }
        if (m2753BABY()) {
            zOnLevelChange |= this.f2570Vnb.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // p131o.C2542O1, android.graphics.drawable.Drawable, p131o.C3343a8.AZxh
    public boolean onStateChange(int[] iArr) {
        if (this.f2590lti) {
            super.onStateChange(iArr);
        }
        return m2780LeWm(iArr, m2828eQ());
    }

    /* renamed from: pJeaSR */
    public void m2853pJeaSR(boolean z) {
        if (this.f2549CqaNbM != z) {
            boolean zM2827eEOGOh = m2827eEOGOh();
            this.f2549CqaNbM = z;
            boolean zM2827eEOGOh2 = m2827eEOGOh();
            if (zM2827eEOGOh != zM2827eEOGOh2) {
                if (zM2827eEOGOh2) {
                    m2820alEkx(this.f2605xrEuO);
                } else {
                    m2831gJsSk(this.f2605xrEuO);
                }
                invalidateSelf();
                m2755CTcA();
            }
        }
    }

    /* renamed from: peCqC */
    public void m2854peCqC(int i) {
        m2799Sx(this.f2586jm.getResources().getDimension(i));
    }

    /* renamed from: qGgY */
    public void m2855qGgY(float f) {
        if (this.f2608zvd != f) {
            float fM2864tQ = m2864tQ();
            this.f2608zvd = f;
            float fM2864tQ2 = m2864tQ();
            invalidateSelf();
            if (fM2864tQ != fM2864tQ2) {
                m2755CTcA();
            }
        }
    }

    /* renamed from: qrxT */
    public void m2856qrxT(int i) {
        m2808Vptz(AbstractC4768vjlshU.m13795mjFkc(this.f2586jm, i));
    }

    /* renamed from: qtZIjO */
    public final void m2857qtZIjO() {
        this.f2577XtE = this.f2574XFUzSY ? AbstractC1735C5.m7750mjFkc(this.f2563OjSQV) : null;
    }

    /* renamed from: rdJr */
    public float m2858rdJr() {
        return this.f2593oCFDzJ;
    }

    /* renamed from: sRqPfw */
    public ColorStateList m2859sRqPfw() {
        return this.f2556KLMXS;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // p131o.C2542O1, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f2597tjSezt != i) {
            this.f2597tjSezt = i;
            invalidateSelf();
        }
    }

    @Override // p131o.C2542O1, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f2606yX != colorFilter) {
            this.f2606yX = colorFilter;
            invalidateSelf();
        }
    }

    @Override // p131o.C2542O1, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f2558LREOK != colorStateList) {
            this.f2558LREOK = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // p131o.C2542O1, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f2583fFz != mode) {
            this.f2583fFz = mode;
            this.f2584gYa = AbstractC2052GmK.m8460AZxh(this, this.f2558LREOK, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (m2827eEOGOh()) {
            visible |= this.f2605xrEuO.setVisible(z, z2);
        }
        if (m2839jpz()) {
            visible |= this.f2550GMIER.setVisible(z, z2);
        }
        if (m2753BABY()) {
            visible |= this.f2570Vnb.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    /* renamed from: sqndV */
    public boolean m2860sqndV() {
        return m2748Vu(this.f2570Vnb);
    }

    /* renamed from: tAfC */
    public TextUtils.TruncateAt m2861tAfC() {
        return this.f2598uH;
    }

    /* renamed from: tISON */
    public float m2862tISON() {
        return this.f2590lti ? m9835mByQ() : this.f2589lB;
    }

    /* renamed from: tPvjn */
    public void m2863tPvjn(int i) {
        m2873wGscSa(this.f2586jm.getResources().getDimension(i));
    }

    /* renamed from: tQ */
    public float m2864tQ() {
        if (m2827eEOGOh() || m2839jpz()) {
            return this.f2592nxI + m2773IyS() + this.f2572WGXroI;
        }
        return 0.0f;
    }

    /* renamed from: tjSezt */
    public final void m2865tjSezt(Canvas canvas, Rect rect) {
        if (m2827eEOGOh()) {
            m2826dm(rect, this.f2596tQ);
            RectF rectF = this.f2596tQ;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.f2605xrEuO.setBounds(0, 0, (int) this.f2596tQ.width(), (int) this.f2596tQ.height());
            this.f2605xrEuO.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    /* renamed from: tpGcn */
    public void m2866tpGcn(int i) {
        m2869ui(AbstractC4768vjlshU.m13794AZxh(this.f2586jm, i));
    }

    /* renamed from: uH */
    public ColorStateList m2867uH() {
        return this.f2571VocHEe;
    }

    /* renamed from: ub */
    public void m2868ub(int i) {
        m2848nUaNy(AbstractC4768vjlshU.m13795mjFkc(this.f2586jm, i));
    }

    /* renamed from: ui */
    public void m2869ui(Drawable drawable) {
        Drawable drawableM2844lti = m2844lti();
        if (drawableM2844lti != drawable) {
            float fM2864tQ = m2864tQ();
            this.f2605xrEuO = drawable != null ? AbstractC4332pCk.m13077VA(drawable).mutate() : null;
            float fM2864tQ2 = m2864tQ();
            m2831gJsSk(drawableM2844lti);
            if (m2827eEOGOh()) {
                m2820alEkx(this.f2605xrEuO);
            }
            invalidateSelf();
            if (fM2864tQ != fM2864tQ2) {
                m2755CTcA();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* renamed from: vUsV */
    public void m2870vUsV(int i) {
        m2855qGgY(this.f2586jm.getResources().getDimension(i));
    }

    /* renamed from: vZ */
    public void m2871vZ(int i) {
        m2879xbjHT(AbstractC4768vjlshU.m13794AZxh(this.f2586jm, i));
    }

    /* renamed from: vjlshU */
    public final void m2872vjlshU(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (m2753BABY()) {
            float f = this.f2568Vdz + this.f2552JBhc;
            if (AbstractC4332pCk.m13072AZxh(this) == 0) {
                float f2 = rect.right - f;
                rectF.right = f2;
                rectF.left = f2 - this.f2593oCFDzJ;
            } else {
                float f3 = rect.left + f;
                rectF.left = f3;
                rectF.right = f3 + this.f2593oCFDzJ;
            }
            float fExactCenterY = rect.exactCenterY();
            float f4 = this.f2593oCFDzJ;
            float f5 = fExactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    /* renamed from: wGscSa */
    public void m2873wGscSa(float f) {
        if (this.f2592nxI != f) {
            float fM2864tQ = m2864tQ();
            this.f2592nxI = f;
            float fM2864tQ2 = m2864tQ();
            invalidateSelf();
            if (fM2864tQ != fM2864tQ2) {
                m2755CTcA();
            }
        }
    }

    /* renamed from: wLtdyQ */
    public void m2874wLtdyQ(float f) {
        if (this.f2568Vdz != f) {
            this.f2568Vdz = f;
            invalidateSelf();
            m2755CTcA();
        }
    }

    /* renamed from: xBQUgd */
    public void m2875xBQUgd(int i) {
        m2823cdjp(new C3008V7(this.f2586jm, i));
    }

    /* renamed from: xCVa */
    public void m2876xCVa(float f) {
        if (this.f2589lB != f) {
            this.f2589lB = f;
            setShapeAppearanceModel(m9833lB().m8676huTpC(f));
        }
    }

    /* renamed from: xROA */
    public final void m2877xROA(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (m2753BABY()) {
            float f = this.f2568Vdz + this.f2552JBhc + this.f2593oCFDzJ + this.f2567SwgkN + this.f2580bbzow;
            if (AbstractC4332pCk.m13072AZxh(this) == 0) {
                float f2 = rect.right;
                rectF.right = f2;
                rectF.left = f2 - f;
            } else {
                int i = rect.left;
                rectF.left = i;
                rectF.right = i + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    /* renamed from: xVYW */
    public final void m2878xVYW() {
        this.f2561NPj = new RippleDrawable(AbstractC1735C5.m7750mjFkc(m2776Jk()), this.f2570Vnb, f2546sRqPfw);
    }

    /* renamed from: xbjHT */
    public void m2879xbjHT(Drawable drawable) {
        Drawable drawableM2836hvGY = m2836hvGY();
        if (drawableM2836hvGY != drawable) {
            float fM2771IVlxe = m2771IVlxe();
            this.f2570Vnb = drawable != null ? AbstractC4332pCk.m13077VA(drawable).mutate() : null;
            if (AbstractC1735C5.f7559mjFkc) {
                m2878xVYW();
            }
            float fM2771IVlxe2 = m2771IVlxe();
            m2831gJsSk(drawableM2836hvGY);
            if (m2753BABY()) {
                m2820alEkx(this.f2570Vnb);
            }
            invalidateSelf();
            if (fM2771IVlxe != fM2771IVlxe2) {
                m2755CTcA();
            }
        }
    }

    /* renamed from: xfXeiC */
    public void m2880xfXeiC(int i) {
        m2795Rsp(this.f2586jm.getResources().getDimension(i));
    }

    /* renamed from: yP */
    public void m2881yP(int i) {
        m2874wLtdyQ(this.f2586jm.getResources().getDimension(i));
    }

    /* renamed from: yX */
    public final void m2882yX(Canvas canvas, Rect rect) {
        if (this.f2591mByQ <= 0.0f || this.f2590lti) {
            return;
        }
        this.f2547ANMGZc.setColor(this.f2565SOS);
        this.f2547ANMGZc.setStyle(Paint.Style.STROKE);
        if (!this.f2590lti) {
            this.f2547ANMGZc.setColorFilter(m2772IvRQOa());
        }
        RectF rectF = this.f2596tQ;
        float f = rect.left;
        float f2 = this.f2591mByQ;
        rectF.set(f + (f2 / 2.0f), rect.top + (f2 / 2.0f), rect.right - (f2 / 2.0f), rect.bottom - (f2 / 2.0f));
        float f3 = this.f2589lB - (this.f2591mByQ / 2.0f);
        canvas.drawRoundRect(this.f2596tQ, f3, f3, this.f2547ANMGZc);
    }

    /* renamed from: ybBTr */
    public boolean m2883ybBTr() {
        return this.f2573WrLQs;
    }

    /* renamed from: yfx */
    public final void m2884yfx(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (m2753BABY()) {
            float f = this.f2568Vdz + this.f2552JBhc + this.f2593oCFDzJ + this.f2567SwgkN + this.f2580bbzow;
            if (AbstractC4332pCk.m13072AZxh(this) == 0) {
                rectF.right = rect.right - f;
            } else {
                rectF.left = rect.left + f;
            }
        }
    }

    /* renamed from: zPp */
    public void m2885zPp(CharSequence charSequence) {
        if (this.f2579aqHPIZ != charSequence) {
            this.f2579aqHPIZ = C2255Jidt.m9007wA().m9012lgHUyS(charSequence);
            invalidateSelf();
        }
    }
}
