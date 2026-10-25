package androidx.p017core.p019widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import java.util.ArrayList;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import p131o.AbstractC2042Gd;
import p131o.AbstractC2876T9;
import p131o.AbstractC2967UXIO;
import p131o.AbstractC3666f4;
import p131o.AbstractC4721v2;
import p131o.C1801D2;
import p131o.C2005G2;
import p131o.C2454MiMN;
import p131o.C2971Ucbh;
import p131o.C3294ZODYfo;
import p131o.InterfaceC1932F2;
import p131o.InterfaceC3194XvQLwQ;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements InterfaceC1932F2 {

    /* renamed from: AZxh */
    public long f959AZxh;

    /* renamed from: BAnRFn */
    public C3294ZODYfo f960BAnRFn;

    /* renamed from: Dt */
    public View f961Dt;

    /* renamed from: ETF */
    public boolean f962ETF;

    /* renamed from: Gd */
    public final C2005G2 f963Gd;

    /* renamed from: HGpJ */
    public final C1801D2 f964HGpJ;

    /* renamed from: IEE */
    public int f965IEE;

    /* renamed from: JHa */
    public EdgeEffect f966JHa;

    /* renamed from: KLFTb */
    public EdgeEffect f967KLFTb;

    /* renamed from: MiMN */
    public boolean f968MiMN;

    /* renamed from: Pq */
    public final int[] f969Pq;

    /* renamed from: Ucbh */
    public int f970Ucbh;

    /* renamed from: VA */
    public VelocityTracker f971VA;

    /* renamed from: VocHEe */
    public final C0074wA f972VocHEe;

    /* renamed from: YoKzxo */
    public boolean f973YoKzxo;

    /* renamed from: ZfxDd */
    public OverScroller f974ZfxDd;

    /* renamed from: diqgf */
    public final int[] f975diqgf;

    /* renamed from: eyqo */
    public int f976eyqo;

    /* renamed from: fehf */
    public int f977fehf;

    /* renamed from: huTpC */
    public C0071KLFTb f978huTpC;

    /* renamed from: lgHUyS */
    public boolean f979lgHUyS;

    /* renamed from: mjFkc */
    public final float f980mjFkc;

    /* renamed from: qGY */
    public int f981qGY;

    /* renamed from: qdMbNW */
    public boolean f982qdMbNW;

    /* renamed from: rkYL */
    public int f983rkYL;

    /* renamed from: vI */
    public float f984vI;

    /* renamed from: wA */
    public final Rect f985wA;

    /* renamed from: xJ */
    public int f986xJ;

    /* renamed from: lB */
    public static final float f956lB = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* renamed from: wJVbdd */
    public static final C0073mjFkc f958wJVbdd = new C0073mjFkc();

    /* renamed from: mByQ */
    public static final int[] f957mByQ = {R.attr.fillViewport};

    /* renamed from: androidx.core.widget.NestedScrollView$AZxh */
    public static class C0070AZxh {
        /* renamed from: mjFkc */
        public static boolean m615mjFkc(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    /* renamed from: androidx.core.widget.NestedScrollView$KLFTb */
    public static class C0071KLFTb extends View.BaseSavedState {

        /* renamed from: CREATOR */
        public static final Parcelable.Creator<C0071KLFTb> f987CREATOR = new mjFkc();

        /* renamed from: mjFkc */
        public int f988mjFkc;

        /* renamed from: androidx.core.widget.NestedScrollView$KLFTb$mjFkc */
        public class mjFkc implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
            public C0071KLFTb[] newArray(int i) {
                return new C0071KLFTb[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public C0071KLFTb createFromParcel(Parcel parcel) {
                return new C0071KLFTb(parcel);
            }
        }

        public C0071KLFTb(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f988mjFkc + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f988mjFkc);
        }

        public C0071KLFTb(Parcel parcel) {
            super(parcel);
            this.f988mjFkc = parcel.readInt();
        }
    }

    /* renamed from: androidx.core.widget.NestedScrollView$ZfxDd */
    public interface InterfaceC0072ZfxDd {
    }

    /* renamed from: androidx.core.widget.NestedScrollView$mjFkc */
    public static class C0073mjFkc extends C2454MiMN {
        @Override // p131o.C2454MiMN
        /* renamed from: Dt */
        public boolean mo618Dt(View view, int i, Bundle bundle) {
            if (super.mo618Dt(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i != 4096) {
                if (i == 8192 || i == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m581JYn(0, iMax, true);
                    return true;
                }
                if (i != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.m581JYn(0, iMin, true);
            return true;
        }

        @Override // p131o.C2454MiMN
        /* renamed from: JHa */
        public void mo619JHa(View view, AccessibilityEvent accessibilityEvent) {
            super.mo619JHa(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AbstractC2042Gd.m8447mjFkc(accessibilityEvent, nestedScrollView.getScrollX());
            AbstractC2042Gd.m8446AZxh(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // p131o.C2454MiMN
        /* renamed from: xJ */
        public void mo620xJ(View view, C2971Ucbh c2971Ucbh) {
            int scrollRange;
            super.mo620xJ(view, c2971Ucbh);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c2971Ucbh.m10572bbzow(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            c2971Ucbh.m10584kism(true);
            if (nestedScrollView.getScrollY() > 0) {
                c2971Ucbh.m10531AZxh(C2971Ucbh.mjFkc.f10865IEE);
                c2971Ucbh.m10531AZxh(C2971Ucbh.mjFkc.f10887lB);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                c2971Ucbh.m10531AZxh(C2971Ucbh.mjFkc.f10885fehf);
                c2971Ucbh.m10531AZxh(C2971Ucbh.mjFkc.f10889mByQ);
            }
        }
    }

    /* renamed from: androidx.core.widget.NestedScrollView$wA */
    public class C0074wA implements InterfaceC3194XvQLwQ {
        public C0074wA() {
        }

        @Override // p131o.InterfaceC3194XvQLwQ
        /* renamed from: AZxh */
        public float mo621AZxh() {
            return -NestedScrollView.this.getVerticalScrollFactorCompat();
        }

        @Override // p131o.InterfaceC3194XvQLwQ
        /* renamed from: mjFkc */
        public boolean mo622mjFkc(float f) {
            if (f == 0.0f) {
                return false;
            }
            mo623wA();
            NestedScrollView.this.m589Ucbh((int) f);
            return true;
        }

        @Override // p131o.InterfaceC3194XvQLwQ
        /* renamed from: wA */
        public void mo623wA() {
            NestedScrollView.this.f974ZfxDd.abortAnimation();
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3666f4.f13521wA);
    }

    /* renamed from: OjSQV */
    public static boolean m569OjSQV(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && m569OjSQV((View) parent, view2);
    }

    /* renamed from: VA */
    public static int m570VA(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    @Override // p131o.InterfaceC1863E2
    /* renamed from: AZxh */
    public void mo189AZxh(View view, int i) {
        this.f963Gd.m8394ZfxDd(view, i);
        m602nxI(i);
    }

    /* renamed from: BAnRFn */
    public final void m572BAnRFn() {
        this.f974ZfxDd = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(PKIFailureInfo.transactionIdInUse);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f983rkYL = viewConfiguration.getScaledTouchSlop();
        this.f981qGY = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f977fehf = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    /* renamed from: CqaNbM */
    public final void m573CqaNbM(int i, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f964HGpJ.m7957KLFTb(0, scrollY2, 0, i - scrollY2, null, i2, iArr);
    }

    /* renamed from: Dt */
    public final boolean m574Dt() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            return overScrollMode == 1 && getScrollRange() > 0;
        }
        return true;
    }

    /* renamed from: ETF */
    public final boolean m575ETF() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    /* renamed from: GMIER */
    public final void m576GMIER(int i, int i2, int i3, boolean z) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f959AZxh > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f974ZfxDd.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY, i3);
            m590Vnb(z);
        } else {
            if (!this.f974ZfxDd.isFinished()) {
                m612xJ();
            }
            scrollBy(i, i2);
        }
        this.f959AZxh = AnimationUtils.currentAnimationTimeMillis();
    }

    /* renamed from: Gd */
    public final float m577Gd(int i) {
        double dLog = Math.log((Math.abs(i) * 0.35f) / (this.f980mjFkc * 0.015f));
        float f = f956lB;
        return (float) (this.f980mjFkc * 0.015f * Math.exp((f / (f - 1.0d)) * dLog));
    }

    /* renamed from: HGpJ */
    public boolean m578HGpJ(int i) {
        return this.f964HGpJ.m7954ETF(i);
    }

    /* renamed from: IEE */
    public final boolean m579IEE(int i) {
        if (AbstractC2967UXIO.m10508AZxh(this.f967KLFTb) != 0.0f) {
            if (m592WrLQs(this.f967KLFTb, i)) {
                this.f967KLFTb.onAbsorb(i);
            } else {
                m589Ucbh(-i);
            }
        } else {
            if (AbstractC2967UXIO.m10508AZxh(this.f966JHa) == 0.0f) {
                return false;
            }
            int i2 = -i;
            if (m592WrLQs(this.f966JHa, i2)) {
                this.f966JHa.onAbsorb(i2);
            } else {
                m589Ucbh(i2);
            }
        }
        return true;
    }

    @Override // p131o.InterfaceC1863E2
    /* renamed from: JHa */
    public boolean mo193JHa(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    /* renamed from: JYgkl */
    public boolean m580JYgkl(int i, int i2) {
        return this.f964HGpJ.m7965qGY(i, i2);
    }

    /* renamed from: JYn */
    public void m581JYn(int i, int i2, boolean z) {
        m608uHVRx(i, i2, 250, z);
    }

    /* renamed from: JrJO */
    public final boolean m582JrJO(MotionEvent motionEvent) {
        boolean z;
        if (AbstractC2967UXIO.m10508AZxh(this.f967KLFTb) != 0.0f) {
            AbstractC2967UXIO.m10509ZfxDd(this.f967KLFTb, 0.0f, motionEvent.getX() / getWidth());
            z = true;
        } else {
            z = false;
        }
        if (AbstractC2967UXIO.m10508AZxh(this.f966JHa) == 0.0f) {
            return z;
        }
        AbstractC2967UXIO.m10509ZfxDd(this.f966JHa, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    @Override // p131o.InterfaceC1863E2
    /* renamed from: KLFTb */
    public void mo194KLFTb(View view, int i, int i2, int i3, int i4, int i5) {
        m573CqaNbM(i4, i5, null);
    }

    /* renamed from: KLMXS */
    public boolean m583KLMXS(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int overScrollMode = getOverScrollMode();
        boolean z4 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z5 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z6 = overScrollMode == 0 || (overScrollMode == 1 && z4);
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        int i9 = i3 + i;
        int i10 = !z6 ? 0 : i7;
        int i11 = i4 + i2;
        int i12 = !z7 ? 0 : i8;
        int i13 = -i10;
        int i14 = i10 + i5;
        int i15 = -i12;
        int i16 = i12 + i6;
        if (i9 > i14) {
            i9 = i14;
            z2 = true;
        } else if (i9 < i13) {
            z2 = true;
            i9 = i13;
        } else {
            z2 = false;
        }
        if (i11 > i16) {
            i11 = i16;
            z3 = true;
        } else if (i11 < i15) {
            z3 = true;
            i11 = i15;
        } else {
            z3 = false;
        }
        if (z3 && !m578HGpJ(1)) {
            this.f974ZfxDd.springBack(i9, i11, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i9, i11, z2, z3);
        return z2 || z3;
    }

    /* renamed from: KRTLGT */
    public final void m584KRTLGT(int i, int i2) {
        m576GMIER(i, i2, 250, false);
    }

    /* renamed from: MiMN */
    public int m585MiMN(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i2 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i - verticalFadingEdgeLength : i;
        int i3 = rect.bottom;
        if (i3 > i2 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i2, (childAt.getBottom() + layoutParams.bottomMargin) - i);
        }
        if (rect.top >= scrollY || i3 >= i2) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i2 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    /* renamed from: NPj */
    public final boolean m586NPj(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z = false;
        boolean z2 = i == 33;
        View viewM597eyqo = m597eyqo(z2, i2, i3);
        if (viewM597eyqo == null) {
            viewM597eyqo = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m610vadzgd(z2 ? i2 - scrollY : i3 - i4, 0, 1, true);
            z = true;
        }
        if (viewM597eyqo != findFocus()) {
            viewM597eyqo.requestFocus(i);
        }
        return z;
    }

    /* renamed from: Ne */
    public final boolean m587Ne(View view, int i, int i2) {
        view.getDrawingRect(this.f985wA);
        offsetDescendantRectToMyCoords(view, this.f985wA);
        return this.f985wA.bottom + i >= getScrollY() && this.f985wA.top - i <= getScrollY() + i2;
    }

    /* renamed from: Pq */
    public final void m588Pq() {
        this.f965IEE = -1;
        this.f962ETF = false;
        m595cMLeY();
        m602nxI(0);
        this.f967KLFTb.onRelease();
        this.f966JHa.onRelease();
    }

    /* renamed from: Ucbh */
    public void m589Ucbh(int i) {
        if (getChildCount() > 0) {
            this.f974ZfxDd.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            m590Vnb(true);
        }
    }

    /* renamed from: Vnb */
    public final void m590Vnb(boolean z) {
        if (z) {
            m580JYgkl(2, 1);
        } else {
            m602nxI(1);
        }
        this.f970Ucbh = getScrollY();
        postInvalidateOnAnimation();
    }

    /* renamed from: VocHEe */
    public final void m591VocHEe() {
        VelocityTracker velocityTracker = this.f971VA;
        if (velocityTracker == null) {
            this.f971VA = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    /* renamed from: WrLQs */
    public final boolean m592WrLQs(EdgeEffect edgeEffect, int i) {
        if (i > 0) {
            return true;
        }
        return m577Gd(-i) < AbstractC2967UXIO.m10508AZxh(edgeEffect) * ((float) getHeight());
    }

    /* renamed from: YoKzxo */
    public int m593YoKzxo(int i) {
        int height = getHeight();
        if (i > 0 && AbstractC2967UXIO.m10508AZxh(this.f967KLFTb) != 0.0f) {
            int iRound = Math.round(((-height) / 4.0f) * AbstractC2967UXIO.m10509ZfxDd(this.f967KLFTb, ((-i) * 4.0f) / height, 0.5f));
            if (iRound != i) {
                this.f967KLFTb.finish();
            }
            return i - iRound;
        }
        if (i >= 0 || AbstractC2967UXIO.m10508AZxh(this.f966JHa) == 0.0f) {
            return i;
        }
        float f = height;
        int iRound2 = Math.round((f / 4.0f) * AbstractC2967UXIO.m10509ZfxDd(this.f966JHa, (i * 4.0f) / f, 0.5f));
        if (iRound2 != i) {
            this.f966JHa.finish();
        }
        return i - iRound2;
    }

    @Override // p131o.InterfaceC1932F2
    /* renamed from: ZfxDd */
    public void mo198ZfxDd(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        m573CqaNbM(i4, i5, iArr);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    /* renamed from: aqHPIZ */
    public final boolean m594aqHPIZ(Rect rect, boolean z) {
        int iM585MiMN = m585MiMN(rect);
        boolean z2 = iM585MiMN != 0;
        if (z2) {
            if (z) {
                scrollBy(0, iM585MiMN);
            } else {
                m584KRTLGT(0, iM585MiMN);
            }
        }
        return z2;
    }

    /* renamed from: cMLeY */
    public final void m595cMLeY() {
        VelocityTracker velocityTracker = this.f971VA;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f971VA = null;
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f974ZfxDd.isFinished()) {
            return;
        }
        this.f974ZfxDd.computeScrollOffset();
        int currY = this.f974ZfxDd.getCurrY();
        int iM593YoKzxo = m593YoKzxo(currY - this.f970Ucbh);
        this.f970Ucbh = currY;
        int[] iArr = this.f975diqgf;
        iArr[1] = 0;
        m607rkYL(0, iM593YoKzxo, iArr, null, 1);
        int i = iM593YoKzxo - this.f975diqgf[1];
        int scrollRange = getScrollRange();
        if (i != 0) {
            int scrollY = getScrollY();
            m583KLMXS(0, i, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i2 = i - scrollY2;
            int[] iArr2 = this.f975diqgf;
            iArr2[1] = 0;
            m604qGY(0, scrollY2, 0, i2, this.f969Pq, 1, iArr2);
            i = i2 - this.f975diqgf[1];
        }
        if (i != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                if (i < 0) {
                    if (this.f967KLFTb.isFinished()) {
                        this.f967KLFTb.onAbsorb((int) this.f974ZfxDd.getCurrVelocity());
                    }
                } else if (this.f966JHa.isFinished()) {
                    this.f966JHa.onAbsorb((int) this.f974ZfxDd.getCurrVelocity());
                }
            }
            m612xJ();
        }
        if (this.f974ZfxDd.isFinished()) {
            m602nxI(1);
        } else {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    /* renamed from: diqgf */
    public boolean m596diqgf(KeyEvent keyEvent) {
        this.f985wA.setEmpty();
        if (!m575ETF()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            return keyEvent.isAltPressed() ? m599huTpC(33) : m605qdMbNW(33);
        }
        if (keyCode == 20) {
            return keyEvent.isAltPressed() ? m599huTpC(130) : m605qdMbNW(130);
        }
        if (keyCode == 62) {
            m614zvd(keyEvent.isShiftPressed() ? 33 : 130);
            return false;
        }
        if (keyCode == 92) {
            return m599huTpC(33);
        }
        if (keyCode == 93) {
            return m599huTpC(130);
        }
        if (keyCode == 122) {
            m614zvd(33);
            return false;
        }
        if (keyCode != 123) {
            return false;
        }
        m614zvd(130);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m596diqgf(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f964HGpJ.m7964mjFkc(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f964HGpJ.m7952AZxh(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return m607rkYL(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f964HGpJ.m7956JHa(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        int paddingLeft2 = 0;
        if (!this.f967KLFTb.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (C0070AZxh.m615mjFkc(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            if (C0070AZxh.m615mjFkc(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            this.f967KLFTb.setSize(width, height);
            if (this.f967KLFTb.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave);
        }
        if (this.f966JHa.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (C0070AZxh.m615mjFkc(this)) {
            width2 -= getPaddingLeft() + getPaddingRight();
            paddingLeft2 = getPaddingLeft();
        }
        if (C0070AZxh.m615mjFkc(this)) {
            height2 -= getPaddingTop() + getPaddingBottom();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        this.f966JHa.setSize(width2, height2);
        if (this.f966JHa.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(iSave2);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /* renamed from: eyqo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View m597eyqo(boolean z, int i, int i2) {
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                boolean z3 = i < top && bottom < i2;
                if (view == null) {
                    view = view2;
                    z2 = z3;
                } else {
                    boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z2) {
                        if (z3 && z4) {
                            view = view2;
                        }
                    } else if (z3) {
                        view = view2;
                        z2 = true;
                    } else if (z4) {
                    }
                }
            }
        }
        return view;
    }

    /* renamed from: fehf */
    public final void m598fehf(int i) {
        if (i != 0) {
            if (this.f973YoKzxo) {
                m584KRTLGT(0, i);
            } else {
                scrollBy(0, i);
            }
        }
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f963Gd.m8395mjFkc();
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public float getVerticalScrollFactorCompat() {
        if (this.f984vI == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f984vI = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f984vI;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return m578HGpJ(0);
    }

    /* renamed from: huTpC */
    public boolean m599huTpC(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.f985wA;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f985wA.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f985wA;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f985wA;
        return m586NPj(i, rect3.top, rect3.bottom);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f964HGpJ.m7959VA();
    }

    /* renamed from: lB */
    public final void m600lB() {
        if (this.f971VA == null) {
            this.f971VA = VelocityTracker.obtain();
        }
    }

    /* renamed from: mByQ */
    public final boolean m601mByQ(View view) {
        return !m587Ne(view, 0, getHeight());
    }

    @Override // android.view.ViewGroup
    public void measureChild(View view, int i, int i2) {
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // p131o.InterfaceC1863E2
    /* renamed from: mjFkc */
    public void mo201mjFkc(View view, View view2, int i, int i2) {
        this.f963Gd.m8396wA(view, view2, i, i2);
        m580JYgkl(2, i2);
    }

    /* renamed from: nxI */
    public void m602nxI(int i) {
        this.f964HGpJ.m7955IEE(i);
    }

    /* renamed from: oCFDzJ */
    public final void m603oCFDzJ(View view) {
        view.getDrawingRect(this.f985wA);
        offsetDescendantRectToMyCoords(view, this.f985wA);
        int iM585MiMN = m585MiMN(this.f985wA);
        if (iM585MiMN != 0) {
            scrollBy(0, iM585MiMN);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f982qdMbNW = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i;
        int width;
        float axisValue;
        if (motionEvent.getAction() == 8 && !this.f962ETF) {
            if (AbstractC4721v2.m13744mjFkc(motionEvent, 2)) {
                i = 9;
                axisValue = motionEvent.getAxisValue(9);
                width = (int) motionEvent.getX();
            } else if (AbstractC4721v2.m13744mjFkc(motionEvent, 4194304)) {
                float axisValue2 = motionEvent.getAxisValue(26);
                width = getWidth() / 2;
                i = 26;
                axisValue = axisValue2;
            } else {
                i = 0;
                width = 0;
                axisValue = 0.0f;
            }
            if (axisValue != 0.0f) {
                m610vadzgd(-((int) (axisValue * getVerticalScrollFactorCompat())), width, 1, AbstractC4721v2.m13744mjFkc(motionEvent, 8194));
                if (i != 0) {
                    this.f960BAnRFn.m11200xJ(motionEvent, i);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = true;
        if (action == 2 && this.f962ETF) {
            return true;
        }
        int i = action & 255;
        if (i == 0) {
            int y = (int) motionEvent.getY();
            if (m609vI((int) motionEvent.getX(), y)) {
                this.f986xJ = y;
                this.f965IEE = motionEvent.getPointerId(0);
                m591VocHEe();
                this.f971VA.addMovement(motionEvent);
                this.f974ZfxDd.computeScrollOffset();
                if (!m582JrJO(motionEvent) && this.f974ZfxDd.isFinished()) {
                    z = false;
                }
                this.f962ETF = z;
                m580JYgkl(2, 0);
            } else {
                if (!m582JrJO(motionEvent) && this.f974ZfxDd.isFinished()) {
                    z = false;
                }
                this.f962ETF = z;
                m595cMLeY();
            }
        } else if (i == 1) {
            this.f962ETF = false;
            this.f965IEE = -1;
            m595cMLeY();
            if (this.f974ZfxDd.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            m602nxI(0);
        } else if (i == 2) {
            int i2 = this.f965IEE;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                } else {
                    int y2 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y2 - this.f986xJ) > this.f983rkYL && (2 & getNestedScrollAxes()) == 0) {
                        this.f962ETF = true;
                        this.f986xJ = y2;
                        m600lB();
                        this.f971VA.addMovement(motionEvent);
                        this.f976eyqo = 0;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
        } else if (i != 3) {
            if (i == 6) {
                m613xrEuO(motionEvent);
            }
        }
        return this.f962ETF;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int measuredHeight = 0;
        this.f979lgHUyS = false;
        View view = this.f961Dt;
        if (view != null && m569OjSQV(view, this)) {
            m603oCFDzJ(this.f961Dt);
        }
        this.f961Dt = null;
        if (!this.f982qdMbNW) {
            if (this.f978huTpC != null) {
                scrollTo(getScrollX(), this.f978huTpC.f988mjFkc);
                this.f978huTpC = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iM570VA = m570VA(scrollY, paddingTop, measuredHeight);
            if (iM570VA != scrollY) {
                scrollTo(getScrollX(), iM570VA);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f982qdMbNW = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f968MiMN && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        m589Ucbh((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        mo208wA(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        m573CqaNbM(i4, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        mo201mjFkc(view, view2, i, 0);
    }

    @Override // android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (viewFindNextFocus == null || m601mByQ(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0071KLFTb)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0071KLFTb c0071KLFTb = (C0071KLFTb) parcelable;
        super.onRestoreInstanceState(c0071KLFTb.getSuperState());
        this.f978huTpC = c0071KLFTb;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        C0071KLFTb c0071KLFTb = new C0071KLFTb(super.onSaveInstanceState());
        c0071KLFTb.f988mjFkc = getScrollY();
        return c0071KLFTb;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !m587Ne(viewFindFocus, 0, i4)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f985wA);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f985wA);
        m598fehf(m585MiMN(this.f985wA));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return mo193JHa(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        mo189AZxh(view, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        m600lB();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f976eyqo = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.f976eyqo);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f971VA;
                velocityTracker.computeCurrentVelocity(NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE, this.f977fehf);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f965IEE);
                if (Math.abs(yVelocity) >= this.f981qGY) {
                    if (!m579IEE(yVelocity)) {
                        int i = -yVelocity;
                        float f = i;
                        if (!dispatchNestedPreFling(0.0f, f)) {
                            dispatchNestedFling(0.0f, f, true);
                            m589Ucbh(i);
                        }
                    }
                } else if (this.f974ZfxDd.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                m588Pq();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f965IEE);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f965IEE + " in onTouchEvent");
                } else {
                    int y = (int) motionEvent.getY(iFindPointerIndex);
                    int i2 = this.f986xJ - y;
                    int iM606rWxwaT = i2 - m606rWxwaT(i2, motionEvent.getX(iFindPointerIndex));
                    if (!this.f962ETF && Math.abs(iM606rWxwaT) > this.f983rkYL) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f962ETF = true;
                        iM606rWxwaT = iM606rWxwaT > 0 ? iM606rWxwaT - this.f983rkYL : iM606rWxwaT + this.f983rkYL;
                    }
                    if (this.f962ETF) {
                        int iM610vadzgd = m610vadzgd(iM606rWxwaT, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                        this.f986xJ = y - iM610vadzgd;
                        this.f976eyqo += iM610vadzgd;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f962ETF && getChildCount() > 0 && this.f974ZfxDd.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                m588Pq();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f986xJ = (int) motionEvent.getY(actionIndex);
                this.f965IEE = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                m613xrEuO(motionEvent);
                this.f986xJ = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f965IEE));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.f962ETF && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f974ZfxDd.isFinished()) {
                m612xJ();
            }
            m611wJVbdd((int) motionEvent.getY(), motionEvent.getPointerId(0));
        }
        VelocityTracker velocityTracker2 = this.f971VA;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    /* renamed from: qGY */
    public void m604qGY(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        this.f964HGpJ.m7957KLFTb(i, i2, i3, i4, iArr, i5, iArr2);
    }

    /* renamed from: qdMbNW */
    public boolean m605qdMbNW(int i) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !m587Ne(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m610vadzgd(maxScrollAmount, 0, 1, true);
        } else {
            viewFindNextFocus.getDrawingRect(this.f985wA);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f985wA);
            m610vadzgd(m585MiMN(this.f985wA), 0, 1, true);
            viewFindNextFocus.requestFocus(i);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && m601mByQ(viewFindFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(PKIFailureInfo.unsupportedVersion);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* renamed from: rWxwaT */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m606rWxwaT(int i, float f) {
        float fM10509ZfxDd;
        int iRound;
        float width = f / getWidth();
        float height = i / getHeight();
        float f2 = 0.0f;
        if (AbstractC2967UXIO.m10508AZxh(this.f967KLFTb) == 0.0f) {
            if (AbstractC2967UXIO.m10508AZxh(this.f966JHa) != 0.0f) {
                fM10509ZfxDd = AbstractC2967UXIO.m10509ZfxDd(this.f966JHa, height, 1.0f - width);
                if (AbstractC2967UXIO.m10508AZxh(this.f966JHa) == 0.0f) {
                    this.f966JHa.onRelease();
                }
            }
            iRound = Math.round(f2 * getHeight());
            if (iRound != 0) {
                invalidate();
            }
            return iRound;
        }
        fM10509ZfxDd = -AbstractC2967UXIO.m10509ZfxDd(this.f967KLFTb, -height, width);
        if (AbstractC2967UXIO.m10508AZxh(this.f967KLFTb) == 0.0f) {
            this.f967KLFTb.onRelease();
        }
        f2 = fM10509ZfxDd;
        iRound = Math.round(f2 * getHeight());
        if (iRound != 0) {
        }
        return iRound;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f979lgHUyS) {
            this.f961Dt = view2;
        } else {
            m603oCFDzJ(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m594aqHPIZ(rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m595cMLeY();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f979lgHUyS = true;
        super.requestLayout();
    }

    /* renamed from: rkYL */
    public boolean m607rkYL(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.f964HGpJ.m7961ZfxDd(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iM570VA = m570VA(i, width, width2);
            int iM570VA2 = m570VA(i2, height, height2);
            if (iM570VA == getScrollX() && iM570VA2 == getScrollY()) {
                return;
            }
            super.scrollTo(iM570VA, iM570VA2);
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f968MiMN) {
            this.f968MiMN = z;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.f964HGpJ.m7958MiMN(z);
    }

    public void setOnScrollChangeListener(InterfaceC0072ZfxDd interfaceC0072ZfxDd) {
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f973YoKzxo = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return m580JYgkl(i, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        m602nxI(0);
    }

    /* renamed from: uHVRx */
    public void m608uHVRx(int i, int i2, int i3, boolean z) {
        m576GMIER(i - getScrollX(), i2 - getScrollY(), i3, z);
    }

    /* renamed from: vI */
    public final boolean m609vI(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    /* renamed from: vadzgd */
    public final int m610vadzgd(int i, int i2, int i3, boolean z) {
        int i4;
        int i5;
        VelocityTracker velocityTracker;
        if (i3 == 1) {
            m580JYgkl(2, i3);
        }
        boolean z2 = false;
        if (m607rkYL(0, i, this.f975diqgf, this.f969Pq, i3)) {
            i4 = i - this.f975diqgf[1];
            i5 = this.f969Pq[1];
        } else {
            i4 = i;
            i5 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        boolean z3 = m574Dt() && !z;
        boolean z4 = m583KLMXS(0, i4, 0, scrollY, 0, scrollRange, 0, 0, true) && !m578HGpJ(i3);
        int scrollY2 = getScrollY() - scrollY;
        int[] iArr = this.f975diqgf;
        iArr[1] = 0;
        m604qGY(0, scrollY2, 0, i4 - scrollY2, this.f969Pq, i3, iArr);
        int i6 = i5 + this.f969Pq[1];
        int i7 = i4 - this.f975diqgf[1];
        int i8 = scrollY + i7;
        if (i8 < 0) {
            if (z3) {
                AbstractC2967UXIO.m10509ZfxDd(this.f967KLFTb, (-i7) / getHeight(), i2 / getWidth());
                if (!this.f966JHa.isFinished()) {
                    this.f966JHa.onRelease();
                }
            }
        } else if (i8 > scrollRange && z3) {
            AbstractC2967UXIO.m10509ZfxDd(this.f966JHa, i7 / getHeight(), 1.0f - (i2 / getWidth()));
            if (!this.f967KLFTb.isFinished()) {
                this.f967KLFTb.onRelease();
            }
        }
        if (this.f967KLFTb.isFinished() && this.f966JHa.isFinished()) {
            z2 = z4;
        } else {
            postInvalidateOnAnimation();
        }
        if (z2 && i3 == 0 && (velocityTracker = this.f971VA) != null) {
            velocityTracker.clear();
        }
        if (i3 == 1) {
            m602nxI(i3);
            this.f967KLFTb.onRelease();
            this.f966JHa.onRelease();
        }
        return i6;
    }

    @Override // p131o.InterfaceC1863E2
    /* renamed from: wA */
    public void mo208wA(View view, int i, int i2, int[] iArr, int i3) {
        m607rkYL(i, i2, iArr, null, i3);
    }

    /* renamed from: wJVbdd */
    public final void m611wJVbdd(int i, int i2) {
        this.f986xJ = i;
        this.f965IEE = i2;
        m580JYgkl(2, 0);
    }

    /* renamed from: xJ */
    public final void m612xJ() {
        this.f974ZfxDd.abortAnimation();
        m602nxI(1);
    }

    /* renamed from: xrEuO */
    public final void m613xrEuO(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f965IEE) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f986xJ = (int) motionEvent.getY(i);
            this.f965IEE = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f971VA;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* renamed from: zvd */
    public boolean m614zvd(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.f985wA.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f985wA;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f985wA.top = getScrollY() - height;
            Rect rect2 = this.f985wA;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f985wA;
        int i2 = rect3.top;
        int i3 = height + i2;
        rect3.bottom = i3;
        return m586NPj(i, i2, i3);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f985wA = new Rect();
        this.f979lgHUyS = true;
        this.f982qdMbNW = false;
        this.f961Dt = null;
        this.f962ETF = false;
        this.f973YoKzxo = true;
        this.f965IEE = -1;
        this.f969Pq = new int[2];
        this.f975diqgf = new int[2];
        C0074wA c0074wA = new C0074wA();
        this.f972VocHEe = c0074wA;
        this.f960BAnRFn = new C3294ZODYfo(getContext(), c0074wA);
        this.f967KLFTb = AbstractC2967UXIO.m10510mjFkc(context, attributeSet);
        this.f966JHa = AbstractC2967UXIO.m10510mjFkc(context, attributeSet);
        this.f980mjFkc = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        m572BAnRFn();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f957mByQ, i, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f963Gd = new C2005G2(this);
        this.f964HGpJ = new C1801D2(this);
        setNestedScrollingEnabled(true);
        AbstractC2876T9.m10265alEkx(this, f958wJVbdd);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
