package androidx.appcompat.p012widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import p131o.AbstractC1865E4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3862i4;
import p131o.C2005G2;
import p131o.C2798S;
import p131o.C3372ab;
import p131o.InterfaceC1863E2;
import p131o.InterfaceC1932F2;
import p131o.InterfaceC3066VzXmn;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC1863E2, InterfaceC1932F2 {

    /* renamed from: mByQ */
    public static final int[] f421mByQ = {AbstractC3862i4.f14102AZxh, R.attr.windowContentOverlay};

    /* renamed from: AZxh */
    public int f422AZxh;

    /* renamed from: BAnRFn */
    public final Runnable f423BAnRFn;

    /* renamed from: Dt */
    public boolean f424Dt;

    /* renamed from: ETF */
    public boolean f425ETF;

    /* renamed from: Gd */
    public C3372ab f426Gd;

    /* renamed from: HGpJ */
    public OverScroller f427HGpJ;

    /* renamed from: IEE */
    public final Rect f428IEE;

    /* renamed from: JHa */
    public Drawable f429JHa;

    /* renamed from: KLFTb */
    public InterfaceC3066VzXmn f430KLFTb;

    /* renamed from: MiMN */
    public int f431MiMN;

    /* renamed from: Pq */
    public final Rect f432Pq;

    /* renamed from: Ucbh */
    public C3372ab f433Ucbh;

    /* renamed from: VA */
    public int f434VA;

    /* renamed from: VocHEe */
    public final AnimatorListenerAdapter f435VocHEe;

    /* renamed from: YoKzxo */
    public final Rect f436YoKzxo;

    /* renamed from: ZfxDd */
    public ActionBarContainer f437ZfxDd;

    /* renamed from: diqgf */
    public final Rect f438diqgf;

    /* renamed from: eyqo */
    public C3372ab f439eyqo;

    /* renamed from: fehf */
    public final Rect f440fehf;

    /* renamed from: huTpC */
    public C3372ab f441huTpC;

    /* renamed from: lB */
    public final Runnable f442lB;

    /* renamed from: lgHUyS */
    public boolean f443lgHUyS;

    /* renamed from: mjFkc */
    public int f444mjFkc;

    /* renamed from: qGY */
    public final Rect f445qGY;

    /* renamed from: qdMbNW */
    public boolean f446qdMbNW;

    /* renamed from: rkYL */
    public final Rect f447rkYL;

    /* renamed from: vI */
    public ViewPropertyAnimator f448vI;

    /* renamed from: wA */
    public ContentFrameLayout f449wA;

    /* renamed from: wJVbdd */
    public final C2005G2 f450wJVbdd;

    /* renamed from: xJ */
    public boolean f451xJ;

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$AZxh */
    public class RunnableC0015AZxh implements Runnable {
        public RunnableC0015AZxh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.m196VA();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f448vI = actionBarOverlayLayout.f437ZfxDd.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f435VocHEe);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$KLFTb */
    public static class C0016KLFTb extends ViewGroup.MarginLayoutParams {
        public C0016KLFTb(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0016KLFTb(int i, int i2) {
            super(i, i2);
        }

        public C0016KLFTb(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$ZfxDd */
    public interface InterfaceC0017ZfxDd {
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$mjFkc */
    public class C0018mjFkc extends AnimatorListenerAdapter {
        public C0018mjFkc() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f448vI = null;
            actionBarOverlayLayout.f425ETF = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f448vI = null;
            actionBarOverlayLayout.f425ETF = false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$wA */
    public class RunnableC0019wA implements Runnable {
        public RunnableC0019wA() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.m196VA();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f448vI = actionBarOverlayLayout.f437ZfxDd.animate().translationY(-ActionBarOverlayLayout.this.f437ZfxDd.getHeight()).setListener(ActionBarOverlayLayout.this.f435VocHEe);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f422AZxh = 0;
        this.f436YoKzxo = new Rect();
        this.f447rkYL = new Rect();
        this.f445qGY = new Rect();
        this.f440fehf = new Rect();
        this.f428IEE = new Rect();
        this.f432Pq = new Rect();
        this.f438diqgf = new Rect();
        C3372ab c3372ab = C3372ab.f12772AZxh;
        this.f439eyqo = c3372ab;
        this.f433Ucbh = c3372ab;
        this.f441huTpC = c3372ab;
        this.f426Gd = c3372ab;
        this.f435VocHEe = new C0018mjFkc();
        this.f423BAnRFn = new RunnableC0015AZxh();
        this.f442lB = new RunnableC0019wA();
        m195MiMN(context);
        this.f450wJVbdd = new C2005G2(this);
    }

    @Override // p131o.InterfaceC1863E2
    /* renamed from: AZxh */
    public void mo189AZxh(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: Dt, reason: merged with bridge method [inline-methods] */
    public C0016KLFTb generateLayoutParams(AttributeSet attributeSet) {
        return new C0016KLFTb(getContext(), attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ETF */
    public final InterfaceC3066VzXmn m191ETF(View view) {
        if (view instanceof InterfaceC3066VzXmn) {
            return (InterfaceC3066VzXmn) view;
        }
        if (view instanceof C0044Toolbar) {
            return ((C0044Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    /* renamed from: IEE */
    public final boolean m192IEE(float f) {
        this.f427HGpJ.fling(0, 0, 0, (int) f, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f427HGpJ.getFinalY() > this.f437ZfxDd.getHeight();
    }

    @Override // p131o.InterfaceC1863E2
    /* renamed from: JHa */
    public boolean mo193JHa(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // p131o.InterfaceC1863E2
    /* renamed from: KLFTb */
    public void mo194KLFTb(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    /* renamed from: MiMN */
    public final void m195MiMN(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f421mByQ);
        this.f444mjFkc = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f429JHa = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f451xJ = context.getApplicationInfo().targetSdkVersion < 19;
        this.f427HGpJ = new OverScroller(context);
    }

    /* renamed from: VA */
    public void m196VA() {
        removeCallbacks(this.f423BAnRFn);
        removeCallbacks(this.f442lB);
        ViewPropertyAnimator viewPropertyAnimator = this.f448vI;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    /* renamed from: YoKzxo */
    public final void m197YoKzxo() {
        m196VA();
        postDelayed(this.f442lB, 600L);
    }

    @Override // p131o.InterfaceC1932F2
    /* renamed from: ZfxDd */
    public void mo198ZfxDd(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        mo194KLFTb(view, i, i2, i3, i4, i5);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0016KLFTb;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f429JHa == null || this.f451xJ) {
            return;
        }
        int bottom = this.f437ZfxDd.getVisibility() == 0 ? (int) (this.f437ZfxDd.getBottom() + this.f437ZfxDd.getTranslationY() + 0.5f) : 0;
        this.f429JHa.setBounds(0, bottom, getWidth(), this.f429JHa.getIntrinsicHeight() + bottom);
        this.f429JHa.draw(canvas);
    }

    /* renamed from: fehf */
    public final void m199fehf() {
        m196VA();
        this.f423BAnRFn.run();
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f437ZfxDd;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f450wJVbdd.m8395mjFkc();
    }

    public CharSequence getTitle() {
        m202qGY();
        return this.f430KLFTb.getTitle();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: lgHUyS */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m200lgHUyS(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        C0016KLFTb c0016KLFTb = (C0016KLFTb) view.getLayoutParams();
        if (z) {
            int i = ((ViewGroup.MarginLayoutParams) c0016KLFTb).leftMargin;
            int i2 = rect.left;
            if (i != i2) {
                ((ViewGroup.MarginLayoutParams) c0016KLFTb).leftMargin = i2;
                z5 = true;
            } else {
                z5 = false;
            }
        }
        if (z2) {
            int i3 = ((ViewGroup.MarginLayoutParams) c0016KLFTb).topMargin;
            int i4 = rect.top;
            if (i3 != i4) {
                ((ViewGroup.MarginLayoutParams) c0016KLFTb).topMargin = i4;
                z5 = true;
            }
        }
        if (z4) {
            int i5 = ((ViewGroup.MarginLayoutParams) c0016KLFTb).rightMargin;
            int i6 = rect.right;
            if (i5 != i6) {
                ((ViewGroup.MarginLayoutParams) c0016KLFTb).rightMargin = i6;
                z5 = true;
            }
        }
        if (z3) {
            int i7 = ((ViewGroup.MarginLayoutParams) c0016KLFTb).bottomMargin;
            int i8 = rect.bottom;
            if (i7 != i8) {
                ((ViewGroup.MarginLayoutParams) c0016KLFTb).bottomMargin = i8;
                return true;
            }
        }
        return z5;
    }

    @Override // p131o.InterfaceC1863E2
    /* renamed from: mjFkc */
    public void mo201mjFkc(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        m202qGY();
        C3372ab c3372abM11331diqgf = C3372ab.m11331diqgf(windowInsets, this);
        boolean zM200lgHUyS = m200lgHUyS(this.f437ZfxDd, new Rect(c3372abM11331diqgf.m11346qdMbNW(), c3372abM11331diqgf.m11334ETF(), c3372abM11331diqgf.m11333Dt(), c3372abM11331diqgf.m11343lgHUyS()), true, true, false, true);
        AbstractC2876T9.m10238KLFTb(this, c3372abM11331diqgf, this.f436YoKzxo);
        Rect rect = this.f436YoKzxo;
        C3372ab c3372abM11338VA = c3372abM11331diqgf.m11338VA(rect.left, rect.top, rect.right, rect.bottom);
        this.f439eyqo = c3372abM11338VA;
        boolean z = true;
        if (!this.f433Ucbh.m11341equals(c3372abM11338VA)) {
            this.f433Ucbh = this.f439eyqo;
            zM200lgHUyS = true;
        }
        if (this.f447rkYL.equals(this.f436YoKzxo)) {
            z = zM200lgHUyS;
        } else {
            this.f447rkYL.set(this.f436YoKzxo);
        }
        if (z) {
            requestLayout();
        }
        return c3372abM11331diqgf.m11344mjFkc().m11348wA().m11332AZxh().m11335IEE();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m195MiMN(getContext());
        AbstractC2876T9.m10255Vdz(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m196VA();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0016KLFTb c0016KLFTb = (C0016KLFTb) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) c0016KLFTb).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) c0016KLFTb).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measuredHeight;
        m202qGY();
        measureChildWithMargins(this.f437ZfxDd, i, 0, i2, 0);
        C0016KLFTb c0016KLFTb = (C0016KLFTb) this.f437ZfxDd.getLayoutParams();
        int iMax = Math.max(0, this.f437ZfxDd.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0016KLFTb).leftMargin + ((ViewGroup.MarginLayoutParams) c0016KLFTb).rightMargin);
        int iMax2 = Math.max(0, this.f437ZfxDd.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0016KLFTb).topMargin + ((ViewGroup.MarginLayoutParams) c0016KLFTb).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f437ZfxDd.getMeasuredState());
        boolean z = (AbstractC2876T9.m10247OjSQV(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f444mjFkc;
            if (this.f446qdMbNW && this.f437ZfxDd.getTabContainer() != null) {
                measuredHeight += this.f444mjFkc;
            }
        } else {
            measuredHeight = this.f437ZfxDd.getVisibility() != 8 ? this.f437ZfxDd.getMeasuredHeight() : 0;
        }
        this.f445qGY.set(this.f436YoKzxo);
        C3372ab c3372ab = this.f439eyqo;
        this.f441huTpC = c3372ab;
        if (this.f443lgHUyS || z) {
            this.f441huTpC = new C3372ab.AZxh(this.f441huTpC).m11351ZfxDd(C2798S.m10118AZxh(c3372ab.m11346qdMbNW(), this.f441huTpC.m11334ETF() + measuredHeight, this.f441huTpC.m11333Dt(), this.f441huTpC.m11343lgHUyS())).m11352mjFkc();
        } else {
            Rect rect = this.f445qGY;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            this.f441huTpC = c3372ab.m11338VA(0, measuredHeight, 0, 0);
        }
        m200lgHUyS(this.f449wA, this.f445qGY, true, true, true, true);
        if (!this.f426Gd.m11341equals(this.f441huTpC)) {
            C3372ab c3372ab2 = this.f441huTpC;
            this.f426Gd = c3372ab2;
            AbstractC2876T9.m10234JHa(this.f449wA, c3372ab2);
        }
        measureChildWithMargins(this.f449wA, i, 0, i2, 0);
        C0016KLFTb c0016KLFTb2 = (C0016KLFTb) this.f449wA.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f449wA.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0016KLFTb2).leftMargin + ((ViewGroup.MarginLayoutParams) c0016KLFTb2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f449wA.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0016KLFTb2).topMargin + ((ViewGroup.MarginLayoutParams) c0016KLFTb2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f449wA.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f424Dt || !z) {
            return false;
        }
        if (m192IEE(f2)) {
            m209xJ();
        } else {
            m199fehf();
        }
        this.f425ETF = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.f434VA + i2;
        this.f434VA = i5;
        setActionBarHideOffset(i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f450wJVbdd.m8393AZxh(view, view2, i);
        this.f434VA = getActionBarHideOffset();
        m196VA();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f437ZfxDd.getVisibility() != 0) {
            return false;
        }
        return this.f424Dt;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (!this.f424Dt || this.f425ETF) {
            return;
        }
        if (this.f434VA <= this.f437ZfxDd.getHeight()) {
            m204rkYL();
        } else {
            m197YoKzxo();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        m202qGY();
        this.f431MiMN = i;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f422AZxh = i;
    }

    /* renamed from: qGY */
    public void m202qGY() {
        if (this.f449wA == null) {
            this.f449wA = (ContentFrameLayout) findViewById(AbstractC1865E4.f7929AZxh);
            this.f437ZfxDd = (ActionBarContainer) findViewById(AbstractC1865E4.f7955wA);
            this.f430KLFTb = m191ETF(findViewById(AbstractC1865E4.f7950mjFkc));
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: qdMbNW, reason: merged with bridge method [inline-methods] */
    public C0016KLFTb generateDefaultLayoutParams() {
        return new C0016KLFTb(-1, -1);
    }

    /* renamed from: rkYL */
    public final void m204rkYL() {
        m196VA();
        postDelayed(this.f423BAnRFn, 600L);
    }

    public void setActionBarHideOffset(int i) {
        m196VA();
        this.f437ZfxDd.setTranslationY(-Math.max(0, Math.min(i, this.f437ZfxDd.getHeight())));
    }

    public void setActionBarVisibilityCallback(InterfaceC0017ZfxDd interfaceC0017ZfxDd) {
        if (getWindowToken() != null) {
            throw null;
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f446qdMbNW = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f424Dt) {
            this.f424Dt = z;
            if (z) {
                return;
            }
            m196VA();
            setActionBarHideOffset(0);
        }
    }

    /* renamed from: setIcon */
    public void m205setIcon(int i) {
        m202qGY();
        this.f430KLFTb.mo345setIcon(i);
    }

    /* renamed from: setLogo */
    public void m207setLogo(int i) {
        m202qGY();
        this.f430KLFTb.mo347wA(i);
    }

    public void setOverlayMode(boolean z) {
        this.f443lgHUyS = z;
        this.f451xJ = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Window.Callback callback) {
        m202qGY();
        this.f430KLFTb.mo329AZxh(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        m202qGY();
        this.f430KLFTb.mo341mjFkc(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // p131o.InterfaceC1863E2
    /* renamed from: wA */
    public void mo208wA(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    /* renamed from: xJ */
    public final void m209xJ() {
        m196VA();
        this.f442lB.run();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0016KLFTb(layoutParams);
    }

    /* renamed from: setIcon */
    public void m206setIcon(Drawable drawable) {
        m202qGY();
        this.f430KLFTb.mo346setIcon(drawable);
    }
}
