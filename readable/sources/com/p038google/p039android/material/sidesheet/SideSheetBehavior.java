package com.p038google.p039android.material.sidesheet;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import p131o.AbstractC2478N1;
import p131o.AbstractC2481N4;
import p131o.AbstractC2547O6;
import p131o.AbstractC2737R4;
import p131o.AbstractC2868T1;
import p131o.AbstractC2876T9;
import p131o.AbstractC3340a5;
import p131o.AbstractC4793w7;
import p131o.AbstractC4796wA;
import p131o.C1603A5;
import p131o.C2141I6;
import p131o.C2542O1;
import p131o.C2971Ucbh;
import p131o.C3211Y9;
import p131o.InterfaceC2087HGpJ;

/* loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.AbstractC0058AZxh {

    /* renamed from: Gd */
    public static final int f2695Gd = AbstractC2481N4.f9646diqgf;

    /* renamed from: HGpJ */
    public static final int f2696HGpJ = AbstractC2737R4.f10366JHa;

    /* renamed from: AZxh */
    public float f2697AZxh;

    /* renamed from: Dt */
    public int f2698Dt;

    /* renamed from: ETF */
    public C3211Y9 f2699ETF;

    /* renamed from: IEE */
    public WeakReference f2700IEE;

    /* renamed from: JHa */
    public final C0263wA f2701JHa;

    /* renamed from: KLFTb */
    public C2141I6 f2702KLFTb;

    /* renamed from: MiMN */
    public float f2703MiMN;

    /* renamed from: Pq */
    public int f2704Pq;

    /* renamed from: Ucbh */
    public final Set f2705Ucbh;

    /* renamed from: VA */
    public boolean f2706VA;

    /* renamed from: YoKzxo */
    public int f2707YoKzxo;

    /* renamed from: ZfxDd */
    public ColorStateList f2708ZfxDd;

    /* renamed from: diqgf */
    public VelocityTracker f2709diqgf;

    /* renamed from: eyqo */
    public int f2710eyqo;

    /* renamed from: fehf */
    public WeakReference f2711fehf;

    /* renamed from: huTpC */
    public final C3211Y9.wA f2712huTpC;

    /* renamed from: lgHUyS */
    public boolean f2713lgHUyS;

    /* renamed from: mjFkc */
    public AbstractC2547O6 f2714mjFkc;

    /* renamed from: qGY */
    public int f2715qGY;

    /* renamed from: qdMbNW */
    public int f2716qdMbNW;

    /* renamed from: rkYL */
    public int f2717rkYL;

    /* renamed from: wA */
    public C2542O1 f2718wA;

    /* renamed from: xJ */
    public float f2719xJ;

    /* renamed from: com.google.android.material.sidesheet.SideSheetBehavior$mjFkc */
    public class C0262mjFkc extends C3211Y9.wA {
        public C0262mjFkc() {
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: AZxh */
        public int mo2483AZxh(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: Dt */
        public void mo2484Dt(int i) {
            if (i == 1 && SideSheetBehavior.this.f2713lgHUyS) {
                SideSheetBehavior.this.m2993NKyg(1);
            }
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: ETF */
        public void mo2485ETF(View view, int i, int i2, int i3, int i4) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            View viewM2987JYgkl = SideSheetBehavior.this.m2987JYgkl();
            if (viewM2987JYgkl != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewM2987JYgkl.getLayoutParams()) != null) {
                SideSheetBehavior.this.f2714mjFkc.mo7561qdMbNW(marginLayoutParams, view.getLeft(), view.getRight());
                viewM2987JYgkl.setLayoutParams(marginLayoutParams);
            }
            SideSheetBehavior.this.m2990KRTLGT(view, i);
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: MiMN */
        public boolean mo2486MiMN(View view, int i) {
            return (SideSheetBehavior.this.f2716qdMbNW == 1 || SideSheetBehavior.this.f2711fehf == null || SideSheetBehavior.this.f2711fehf.get() != view) ? false : true;
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: VA */
        public void mo2487VA(View view, float f, float f2) {
            int iMo7562wA = SideSheetBehavior.this.f2714mjFkc.mo7562wA(view, f, f2);
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.m2982yX(view, iMo7562wA, sideSheetBehavior.m3010tjSezt());
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: ZfxDd */
        public int mo2489ZfxDd(View view) {
            return SideSheetBehavior.this.f2717rkYL;
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: mjFkc */
        public int mo2490mjFkc(View view, int i, int i2) {
            return AbstractC2868T1.m10211AZxh(i, SideSheetBehavior.this.m3007nxI(), SideSheetBehavior.this.f2717rkYL);
        }
    }

    /* renamed from: com.google.android.material.sidesheet.SideSheetBehavior$wA */
    public class C0263wA {

        /* renamed from: AZxh */
        public boolean f2723AZxh;

        /* renamed from: mjFkc */
        public int f2725mjFkc;

        /* renamed from: wA */
        public final Runnable f2726wA = new Runnable() { // from class: o.T6
            @Override // java.lang.Runnable
            public final void run() {
                this.f10641mjFkc.m3019wA();
            }
        };

        public C0263wA() {
        }

        /* renamed from: AZxh */
        public void m3018AZxh(int i) {
            if (SideSheetBehavior.this.f2711fehf == null || SideSheetBehavior.this.f2711fehf.get() == null) {
                return;
            }
            this.f2725mjFkc = i;
            if (this.f2723AZxh) {
                return;
            }
            AbstractC2876T9.m10258WGXroI((View) SideSheetBehavior.this.f2711fehf.get(), this.f2726wA);
            this.f2723AZxh = true;
        }

        /* renamed from: wA */
        public final /* synthetic */ void m3019wA() {
            this.f2723AZxh = false;
            if (SideSheetBehavior.this.f2699ETF != null && SideSheetBehavior.this.f2699ETF.m11055ETF(true)) {
                m3018AZxh(this.f2725mjFkc);
            } else if (SideSheetBehavior.this.f2716qdMbNW == 2) {
                SideSheetBehavior.this.m2993NKyg(this.f2725mjFkc);
            }
        }
    }

    public SideSheetBehavior() {
        this.f2701JHa = new C0263wA();
        this.f2713lgHUyS = true;
        this.f2716qdMbNW = 5;
        this.f2698Dt = 5;
        this.f2703MiMN = 0.1f;
        this.f2704Pq = -1;
        this.f2705Ucbh = new LinkedHashSet();
        this.f2712huTpC = new C0262mjFkc();
    }

    /* renamed from: IVlxe */
    private void m2967IVlxe(View view, Runnable runnable) {
        if (m3002alEkx(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* renamed from: WrLQs */
    private void m2972WrLQs(Context context) {
        if (this.f2702KLFTb == null) {
            return;
        }
        C2542O1 c2542o1 = new C2542O1(this.f2702KLFTb);
        this.f2718wA = c2542o1;
        c2542o1.m9827cMLeY(context);
        ColorStateList colorStateList = this.f2708ZfxDd;
        if (colorStateList != null) {
            this.f2718wA.m9841uHVRx(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f2718wA.setTint(typedValue.data);
    }

    /* renamed from: aqHPIZ */
    private InterfaceC2087HGpJ m2973aqHPIZ(final int i) {
        return new InterfaceC2087HGpJ() { // from class: o.R6
            @Override // p131o.InterfaceC2087HGpJ
            /* renamed from: mjFkc */
            public final boolean mo2482mjFkc(View view, InterfaceC2087HGpJ.mjFkc mjfkc) {
                return this.f10379mjFkc.m3004dm(i, view, mjfkc);
            }
        };
    }

    /* renamed from: gYa */
    private void m2975gYa() {
        View view;
        WeakReference weakReference = this.f2711fehf;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        AbstractC2876T9.m10267bbzow(view, PKIFailureInfo.transactionIdInUse);
        AbstractC2876T9.m10267bbzow(view, 1048576);
        if (this.f2716qdMbNW != 5) {
            m2980vjlshU(view, C2971Ucbh.mjFkc.f10864HGpJ, 5);
        }
        if (this.f2716qdMbNW != 3) {
            m2980vjlshU(view, C2971Ucbh.mjFkc.f10886huTpC, 3);
        }
    }

    /* renamed from: gtIJp */
    private boolean m2976gtIJp() {
        return this.f2699ETF != null && (this.f2713lgHUyS || this.f2716qdMbNW == 1);
    }

    /* renamed from: uHVRx */
    private int m2979uHVRx(int i, int i2, int i3, int i4) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i2, i4);
        if (i3 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), 1073741824);
        }
        if (size != 0) {
            i3 = Math.min(size, i3);
        }
        return View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
    }

    /* renamed from: vjlshU */
    private void m2980vjlshU(View view, C2971Ucbh.mjFkc mjfkc, int i) {
        AbstractC2876T9.m10233JBhc(view, mjfkc, null, m2973aqHPIZ(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: yX */
    public void m2982yX(View view, int i, boolean z) {
        if (!this.f2714mjFkc.mo7559lgHUyS(view, i, z)) {
            m2993NKyg(i);
        } else {
            m2993NKyg(2);
            this.f2701JHa.m3018AZxh(i);
        }
    }

    /* renamed from: ANMGZc */
    public final boolean m2984ANMGZc(MotionEvent motionEvent) {
        return m2976gtIJp() && m3011vadzgd((float) this.f2710eyqo, motionEvent.getX()) > ((float) this.f2699ETF.m11069eyqo());
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: Dt */
    public void mo487Dt() {
        super.mo487Dt();
        this.f2711fehf = null;
        this.f2699ETF = null;
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: ETF */
    public boolean mo488ETF(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        C3211Y9 c3211y9;
        if (!m3006kism(view)) {
            this.f2706VA = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m3012xROA();
        }
        if (this.f2709diqgf == null) {
            this.f2709diqgf = VelocityTracker.obtain();
        }
        this.f2709diqgf.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f2710eyqo = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f2706VA) {
            this.f2706VA = false;
            return false;
        }
        return (this.f2706VA || (c3211y9 = this.f2699ETF) == null || !c3211y9.m11061Ne(motionEvent)) ? false : true;
    }

    /* renamed from: GMIER */
    public final void m2985GMIER(View view) {
        if (AbstractC2876T9.m10227ETF(view) == null) {
            AbstractC2876T9.m10301yfx(view, view.getResources().getString(f2695Gd));
        }
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: Gd */
    public void mo489Gd(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        C0261AZxh c0261AZxh = (C0261AZxh) parcelable;
        if (c0261AZxh.m13824mjFkc() != null) {
            super.mo489Gd(coordinatorLayout, view, c0261AZxh.m13824mjFkc());
        }
        int i = c0261AZxh.f2721wA;
        if (i == 1 || i == 2) {
            i = 5;
        }
        this.f2716qdMbNW = i;
        this.f2698Dt = i;
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: HGpJ */
    public Parcelable mo490HGpJ(CoordinatorLayout coordinatorLayout, View view) {
        return new C0261AZxh(super.mo490HGpJ(coordinatorLayout, view), this);
    }

    /* renamed from: JBhc */
    public int m2986JBhc() {
        return this.f2717rkYL;
    }

    /* renamed from: JYgkl */
    public View m2987JYgkl() {
        WeakReference weakReference = this.f2700IEE;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    /* renamed from: JYn */
    public int m2988JYn() {
        return this.f2707YoKzxo;
    }

    /* renamed from: JrJO */
    public final int m2989JrJO() {
        return 0;
    }

    /* renamed from: KRTLGT */
    public final void m2990KRTLGT(View view, int i) {
        if (this.f2705Ucbh.isEmpty()) {
            return;
        }
        this.f2714mjFkc.mo7552AZxh(i);
        Iterator it = this.f2705Ucbh.iterator();
        if (it.hasNext()) {
            AbstractC4793w7.m13819mjFkc(it.next());
            throw null;
        }
    }

    /* renamed from: LREOK */
    public final void m2991LREOK(View view) {
        int i = this.f2716qdMbNW == 5 ? 4 : 0;
        if (view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: MiMN */
    public boolean mo494MiMN(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(m2979uHVRx(i, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, -1, marginLayoutParams.width), m2979uHVRx(i3, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, -1, marginLayoutParams.height));
        return true;
    }

    /* renamed from: Moer */
    public void m2992Moer(int i) {
        this.f2704Pq = i;
        m3008oCFDzJ();
        WeakReference weakReference = this.f2711fehf;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (i == -1 || !AbstractC2876T9.m10287rWxwaT(view)) {
                return;
            }
            view.requestLayout();
        }
    }

    /* renamed from: NKyg */
    public void m2993NKyg(int i) {
        View view;
        if (this.f2716qdMbNW == i) {
            return;
        }
        this.f2716qdMbNW = i;
        if (i == 3 || i == 5) {
            this.f2698Dt = i;
        }
        WeakReference weakReference = this.f2711fehf;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        m2991LREOK(view);
        Iterator it = this.f2705Ucbh.iterator();
        if (it.hasNext()) {
            AbstractC4793w7.m13819mjFkc(it.next());
            throw null;
        }
        m2975gYa();
    }

    /* renamed from: NPj */
    public final int m2994NPj(int i, View view) {
        int i2 = this.f2716qdMbNW;
        if (i2 == 1 || i2 == 2) {
            return i - this.f2714mjFkc.mo7555JHa(view);
        }
        if (i2 == 3) {
            return 0;
        }
        if (i2 == 5) {
            return this.f2714mjFkc.mo7556KLFTb();
        }
        throw new IllegalStateException("Unexpected value: " + this.f2716qdMbNW);
    }

    /* renamed from: Qr */
    public void m2995Qr(final int i) {
        if (i == 1 || i == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        WeakReference weakReference = this.f2711fehf;
        if (weakReference == null || weakReference.get() == null) {
            m2993NKyg(i);
        } else {
            m2967IVlxe((View) this.f2711fehf.get(), new Runnable() { // from class: o.S6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10516mjFkc.m3009tQ(i);
                }
            });
        }
    }

    /* renamed from: SOS */
    public final void m2996SOS(int i) {
        AbstractC2547O6 abstractC2547O6 = this.f2714mjFkc;
        if (abstractC2547O6 == null || abstractC2547O6.mo7563xJ() != i) {
            if (i == 0) {
                this.f2714mjFkc = new C1603A5(this);
                return;
            }
            throw new IllegalArgumentException("Invalid sheet edge position value: " + i + ". Must be 0");
        }
    }

    /* renamed from: SmIWf */
    public void m2997SmIWf(boolean z) {
        this.f2713lgHUyS = z;
    }

    /* renamed from: SwgkN */
    public int m2998SwgkN(int i) {
        if (i == 3) {
            return m3007nxI();
        }
        if (i == 5) {
            return this.f2714mjFkc.mo7556KLFTb();
        }
        throw new IllegalArgumentException("Invalid state to get outer edge offset: " + i);
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: VA */
    public boolean mo497VA(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (AbstractC2876T9.m10269diqgf(coordinatorLayout) && !AbstractC2876T9.m10269diqgf(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.f2711fehf == null) {
            this.f2711fehf = new WeakReference(view);
            C2542O1 c2542o1 = this.f2718wA;
            if (c2542o1 != null) {
                AbstractC2876T9.m10294vjlshU(view, c2542o1);
                C2542O1 c2542o12 = this.f2718wA;
                float fM10231IEE = this.f2719xJ;
                if (fM10231IEE == -1.0f) {
                    fM10231IEE = AbstractC2876T9.m10231IEE(view);
                }
                c2542o12.m9801GMIER(fM10231IEE);
            } else {
                ColorStateList colorStateList = this.f2708ZfxDd;
                if (colorStateList != null) {
                    AbstractC2876T9.m10298xROA(view, colorStateList);
                }
            }
            m2991LREOK(view);
            m2975gYa();
            if (AbstractC2876T9.m10271eyqo(view) == 0) {
                AbstractC2876T9.m10244NKyg(view, 1);
            }
            m2985GMIER(view);
        }
        if (this.f2699ETF == null) {
            this.f2699ETF = C3211Y9.m11049MiMN(coordinatorLayout, this.f2712huTpC);
        }
        int iMo7555JHa = this.f2714mjFkc.mo7555JHa(view);
        coordinatorLayout.m462Ne(view, i);
        this.f2717rkYL = coordinatorLayout.getWidth();
        this.f2707YoKzxo = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.f2715qGY = marginLayoutParams != null ? this.f2714mjFkc.mo7560mjFkc(marginLayoutParams) : 0;
        AbstractC2876T9.m10259WrLQs(view, m2994NPj(iMo7555JHa, view));
        m3013yfx(coordinatorLayout);
        Iterator it = this.f2705Ucbh.iterator();
        while (it.hasNext()) {
            AbstractC4793w7.m13819mjFkc(it.next());
        }
        return true;
    }

    /* renamed from: Vdz */
    public int m2999Vdz() {
        return 500;
    }

    /* renamed from: WGXroI */
    public float m3000WGXroI() {
        return this.f2703MiMN;
    }

    /* renamed from: XV */
    public float m3001XV() {
        return 0.5f;
    }

    /* renamed from: alEkx */
    public final boolean m3002alEkx(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && AbstractC2876T9.m10268cMLeY(view);
    }

    /* renamed from: bbzow */
    public int m3003bbzow() {
        return this.f2715qGY;
    }

    /* renamed from: dm */
    public final /* synthetic */ boolean m3004dm(int i, View view, InterfaceC2087HGpJ.mjFkc mjfkc) {
        m2995Qr(i);
        return true;
    }

    /* renamed from: jm */
    public C3211Y9 m3005jm() {
        return this.f2699ETF;
    }

    /* renamed from: kism */
    public final boolean m3006kism(View view) {
        return (view.isShown() || AbstractC2876T9.m10227ETF(view) != null) && this.f2713lgHUyS;
    }

    /* renamed from: nxI */
    public int m3007nxI() {
        return this.f2714mjFkc.mo7558ZfxDd();
    }

    /* renamed from: oCFDzJ */
    public final void m3008oCFDzJ() {
        WeakReference weakReference = this.f2700IEE;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f2700IEE = null;
    }

    /* renamed from: tQ */
    public final /* synthetic */ void m3009tQ(int i) {
        View view = (View) this.f2711fehf.get();
        if (view != null) {
            m2982yX(view, i, false);
        }
    }

    /* renamed from: tjSezt */
    public boolean m3010tjSezt() {
        return true;
    }

    /* renamed from: vadzgd */
    public final float m3011vadzgd(float f, float f2) {
        return Math.abs(f - f2);
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: wJVbdd */
    public boolean mo513wJVbdd(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f2716qdMbNW == 1 && actionMasked == 0) {
            return true;
        }
        if (m2976gtIJp()) {
            this.f2699ETF.m11079vI(motionEvent);
        }
        if (actionMasked == 0) {
            m3012xROA();
        }
        if (this.f2709diqgf == null) {
            this.f2709diqgf = VelocityTracker.obtain();
        }
        this.f2709diqgf.addMovement(motionEvent);
        if (m2976gtIJp() && actionMasked == 2 && !this.f2706VA && m2984ANMGZc(motionEvent)) {
            this.f2699ETF.m11051AZxh(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f2706VA;
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: xJ */
    public void mo514xJ(CoordinatorLayout.C0060KLFTb c0060KLFTb) {
        super.mo514xJ(c0060KLFTb);
        this.f2711fehf = null;
        this.f2699ETF = null;
    }

    /* renamed from: xROA */
    public final void m3012xROA() {
        VelocityTracker velocityTracker = this.f2709diqgf;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2709diqgf = null;
        }
    }

    /* renamed from: yfx */
    public final void m3013yfx(CoordinatorLayout coordinatorLayout) {
        int i;
        View viewFindViewById;
        if (this.f2700IEE != null || (i = this.f2704Pq) == -1 || (viewFindViewById = coordinatorLayout.findViewById(i)) == null) {
            return;
        }
        this.f2700IEE = new WeakReference(viewFindViewById);
    }

    /* renamed from: com.google.android.material.sidesheet.SideSheetBehavior$AZxh */
    public static class C0261AZxh extends AbstractC4796wA {

        /* renamed from: CREATOR */
        public static final Parcelable.Creator<C0261AZxh> f2720CREATOR = new mjFkc();

        /* renamed from: wA */
        public final int f2721wA;

        /* renamed from: com.google.android.material.sidesheet.SideSheetBehavior$AZxh$mjFkc */
        public class mjFkc implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
            public C0261AZxh createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0261AZxh(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public C0261AZxh createFromParcel(Parcel parcel) {
                return new C0261AZxh(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: wA, reason: merged with bridge method [inline-methods] */
            public C0261AZxh[] newArray(int i) {
                return new C0261AZxh[i];
            }
        }

        public C0261AZxh(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2721wA = parcel.readInt();
        }

        @Override // p131o.AbstractC4796wA, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2721wA);
        }

        public C0261AZxh(Parcelable parcelable, SideSheetBehavior sideSheetBehavior) {
            super(parcelable);
            this.f2721wA = sideSheetBehavior.f2716qdMbNW;
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2701JHa = new C0263wA();
        this.f2713lgHUyS = true;
        this.f2716qdMbNW = 5;
        this.f2698Dt = 5;
        this.f2703MiMN = 0.1f;
        this.f2704Pq = -1;
        this.f2705Ucbh = new LinkedHashSet();
        this.f2712huTpC = new C0262mjFkc();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3340a5.f12355FBR);
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC3340a5.f12330CBEvIj)) {
            this.f2708ZfxDd = AbstractC2478N1.m9577mjFkc(context, typedArrayObtainStyledAttributes, AbstractC3340a5.f12330CBEvIj);
        }
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC3340a5.f12395JGvOM)) {
            this.f2702KLFTb = C2141I6.m8658KLFTb(context, attributeSet, 0, f2696HGpJ).m8698MiMN();
        }
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC3340a5.f12580jKf)) {
            m2992Moer(typedArrayObtainStyledAttributes.getResourceId(AbstractC3340a5.f12580jKf, -1));
        }
        m2972WrLQs(context);
        this.f2719xJ = typedArrayObtainStyledAttributes.getDimension(AbstractC3340a5.f12320Ab, -1.0f);
        m2997SmIWf(typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12563gYsXfP, true));
        typedArrayObtainStyledAttributes.recycle();
        m2996SOS(m2989JrJO());
        this.f2697AZxh = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
