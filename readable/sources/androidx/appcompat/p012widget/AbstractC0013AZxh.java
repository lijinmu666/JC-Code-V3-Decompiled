package androidx.appcompat.p012widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import p131o.AbstractC2876T9;
import p131o.AbstractC3407b5;
import p131o.AbstractC4056l;
import p131o.AbstractC4689ua;
import p131o.C1606A8;

/* renamed from: androidx.appcompat.widget.AZxh */
/* loaded from: classes.dex */
public abstract class AbstractC0013AZxh extends ViewGroup {

    /* renamed from: AZxh */
    public int f385AZxh;

    /* renamed from: Dt */
    public int[] f386Dt;

    /* renamed from: ETF */
    public Drawable f387ETF;

    /* renamed from: JHa */
    public int f388JHa;

    /* renamed from: KLFTb */
    public int f389KLFTb;

    /* renamed from: MiMN */
    public int f390MiMN;

    /* renamed from: VA */
    public int f391VA;

    /* renamed from: YoKzxo */
    public int f392YoKzxo;

    /* renamed from: ZfxDd */
    public int f393ZfxDd;

    /* renamed from: lgHUyS */
    public boolean f394lgHUyS;

    /* renamed from: mjFkc */
    public boolean f395mjFkc;

    /* renamed from: qdMbNW */
    public int[] f396qdMbNW;

    /* renamed from: rkYL */
    public int f397rkYL;

    /* renamed from: wA */
    public int f398wA;

    /* renamed from: xJ */
    public float f399xJ;

    /* renamed from: androidx.appcompat.widget.AZxh$mjFkc */
    public static class mjFkc extends LinearLayout.LayoutParams {
        public mjFkc(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public mjFkc(int i, int i2) {
            super(i, i2);
        }

        public mjFkc(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public AbstractC0013AZxh(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: ETF */
    private void m164ETF(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View viewM169IEE = m169IEE(i3);
            if (viewM169IEE.getVisibility() != 8) {
                mjFkc mjfkc = (mjFkc) viewM169IEE.getLayoutParams();
                if (((LinearLayout.LayoutParams) mjfkc).width == -1) {
                    int i4 = ((LinearLayout.LayoutParams) mjfkc).height;
                    ((LinearLayout.LayoutParams) mjfkc).height = viewM169IEE.getMeasuredHeight();
                    measureChildWithMargins(viewM169IEE, iMakeMeasureSpec, 0, i2, 0);
                    ((LinearLayout.LayoutParams) mjfkc).height = i4;
                }
            }
        }
    }

    /* renamed from: vI */
    private void m165vI(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    /* renamed from: Dt */
    public final void m166Dt(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View viewM169IEE = m169IEE(i3);
            if (viewM169IEE.getVisibility() != 8) {
                mjFkc mjfkc = (mjFkc) viewM169IEE.getLayoutParams();
                if (((LinearLayout.LayoutParams) mjfkc).height == -1) {
                    int i4 = ((LinearLayout.LayoutParams) mjfkc).width;
                    ((LinearLayout.LayoutParams) mjfkc).width = viewM169IEE.getMeasuredWidth();
                    measureChildWithMargins(viewM169IEE, i2, 0, iMakeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) mjfkc).width = i4;
                }
            }
        }
    }

    /* renamed from: Gd */
    public int m167Gd(int i) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x032f  */
    /* renamed from: HGpJ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m168HGpJ(int i, int i2) {
        int i3;
        int iCombineMeasuredStates;
        int i4;
        int iMax;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int iMax2;
        int i15;
        View view;
        int iMax3;
        boolean z;
        this.f388JHa = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i16 = this.f385AZxh;
        boolean z2 = this.f394lgHUyS;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int iMax4 = 0;
        int i20 = 0;
        int iM183rkYL = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = true;
        float f = 0.0f;
        while (true) {
            int i21 = 8;
            int i22 = iMax4;
            if (iM183rkYL >= virtualChildCount) {
                int i23 = i17;
                int i24 = i19;
                int i25 = i20;
                int i26 = mode2;
                int iMax5 = i18;
                int i27 = virtualChildCount;
                if (this.f388JHa > 0) {
                    i3 = i27;
                    if (m172Pq(i3)) {
                        this.f388JHa += this.f390MiMN;
                    }
                } else {
                    i3 = i27;
                }
                if (z2 && (i26 == Integer.MIN_VALUE || i26 == 0)) {
                    this.f388JHa = 0;
                    int iM183rkYL2 = 0;
                    while (iM183rkYL2 < i3) {
                        View viewM169IEE = m169IEE(iM183rkYL2);
                        if (viewM169IEE == null) {
                            this.f388JHa += m167Gd(iM183rkYL2);
                        } else if (viewM169IEE.getVisibility() == i21) {
                            iM183rkYL2 += m183rkYL(viewM169IEE, iM183rkYL2);
                        } else {
                            mjFkc mjfkc = (mjFkc) viewM169IEE.getLayoutParams();
                            int i28 = this.f388JHa;
                            this.f388JHa = Math.max(i28, i28 + i24 + ((LinearLayout.LayoutParams) mjfkc).topMargin + ((LinearLayout.LayoutParams) mjfkc).bottomMargin + m178fehf(viewM169IEE));
                        }
                        iM183rkYL2++;
                        i21 = 8;
                    }
                }
                int paddingTop = this.f388JHa + getPaddingTop() + getPaddingBottom();
                this.f388JHa = paddingTop;
                int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0);
                int i29 = (16777215 & iResolveSizeAndState) - this.f388JHa;
                if (z3 || (i29 != 0 && f > 0.0f)) {
                    float f2 = this.f399xJ;
                    if (f2 > 0.0f) {
                        f = f2;
                    }
                    this.f388JHa = 0;
                    int i30 = i29;
                    int i31 = i25;
                    iCombineMeasuredStates = i23;
                    int i32 = 0;
                    while (i32 < i3) {
                        View viewM169IEE2 = m169IEE(i32);
                        if (viewM169IEE2.getVisibility() == 8) {
                            i5 = i30;
                        } else {
                            mjFkc mjfkc2 = (mjFkc) viewM169IEE2.getLayoutParams();
                            float f3 = ((LinearLayout.LayoutParams) mjfkc2).weight;
                            if (f3 > 0.0f) {
                                int i33 = (int) ((i30 * f3) / f);
                                float f4 = f - f3;
                                i5 = i30 - i33;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + ((LinearLayout.LayoutParams) mjfkc2).leftMargin + ((LinearLayout.LayoutParams) mjfkc2).rightMargin, ((LinearLayout.LayoutParams) mjfkc2).width);
                                if (((LinearLayout.LayoutParams) mjfkc2).height == 0) {
                                    i8 = 1073741824;
                                    if (i26 == 1073741824) {
                                        if (i33 <= 0) {
                                            i33 = 0;
                                        }
                                        viewM169IEE2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i33, 1073741824));
                                    }
                                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewM169IEE2.getMeasuredState() & (-256));
                                    f = f4;
                                } else {
                                    i8 = 1073741824;
                                }
                                int measuredHeight = viewM169IEE2.getMeasuredHeight() + i33;
                                if (measuredHeight < 0) {
                                    measuredHeight = 0;
                                }
                                viewM169IEE2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i8));
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewM169IEE2.getMeasuredState() & (-256));
                                f = f4;
                            } else {
                                i5 = i30;
                            }
                            int i34 = ((LinearLayout.LayoutParams) mjfkc2).leftMargin + ((LinearLayout.LayoutParams) mjfkc2).rightMargin;
                            int measuredWidth = viewM169IEE2.getMeasuredWidth() + i34;
                            iMax5 = Math.max(iMax5, measuredWidth);
                            float f5 = f;
                            if (mode != 1073741824) {
                                i6 = iCombineMeasuredStates;
                                i7 = -1;
                                if (((LinearLayout.LayoutParams) mjfkc2).width != -1) {
                                }
                                int iMax6 = Math.max(i31, i34);
                                boolean z6 = !z5 && ((LinearLayout.LayoutParams) mjfkc2).width == i7;
                                int i35 = this.f388JHa;
                                this.f388JHa = Math.max(i35, viewM169IEE2.getMeasuredHeight() + i35 + ((LinearLayout.LayoutParams) mjfkc2).topMargin + ((LinearLayout.LayoutParams) mjfkc2).bottomMargin + m178fehf(viewM169IEE2));
                                z5 = z6;
                                iCombineMeasuredStates = i6;
                                i31 = iMax6;
                                f = f5;
                            } else {
                                i6 = iCombineMeasuredStates;
                                i7 = -1;
                            }
                            i34 = measuredWidth;
                            int iMax62 = Math.max(i31, i34);
                            if (z5) {
                                int i352 = this.f388JHa;
                                this.f388JHa = Math.max(i352, viewM169IEE2.getMeasuredHeight() + i352 + ((LinearLayout.LayoutParams) mjfkc2).topMargin + ((LinearLayout.LayoutParams) mjfkc2).bottomMargin + m178fehf(viewM169IEE2));
                                z5 = z6;
                                iCombineMeasuredStates = i6;
                                i31 = iMax62;
                                f = f5;
                            }
                        }
                        i32++;
                        i30 = i5;
                    }
                    i4 = i;
                    this.f388JHa += getPaddingTop() + getPaddingBottom();
                    iMax = i31;
                } else {
                    iMax = Math.max(i25, i22);
                    if (z2 && i26 != 1073741824) {
                        for (int i36 = 0; i36 < i3; i36++) {
                            View viewM169IEE3 = m169IEE(i36);
                            if (viewM169IEE3 != null && viewM169IEE3.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((mjFkc) viewM169IEE3.getLayoutParams())).weight > 0.0f) {
                                viewM169IEE3.measure(View.MeasureSpec.makeMeasureSpec(viewM169IEE3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i24, 1073741824));
                            }
                        }
                    }
                    i4 = i;
                    iCombineMeasuredStates = i23;
                }
                if (z5 || mode == 1073741824) {
                    iMax = iMax5;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i4, iCombineMeasuredStates), iResolveSizeAndState);
                if (z4) {
                    m164ETF(i3, i2);
                    return;
                }
                return;
            }
            View viewM169IEE4 = m169IEE(iM183rkYL);
            if (viewM169IEE4 == null) {
                this.f388JHa += m167Gd(iM183rkYL);
                i12 = mode2;
                iMax4 = i22;
                i14 = virtualChildCount;
            } else {
                int i37 = i17;
                if (viewM169IEE4.getVisibility() == 8) {
                    iM183rkYL += m183rkYL(viewM169IEE4, iM183rkYL);
                    iMax4 = i22;
                    i17 = i37;
                    i14 = virtualChildCount;
                    i12 = mode2;
                } else {
                    if (m172Pq(iM183rkYL)) {
                        this.f388JHa += this.f390MiMN;
                    }
                    mjFkc mjfkc3 = (mjFkc) viewM169IEE4.getLayoutParams();
                    float f6 = ((LinearLayout.LayoutParams) mjfkc3).weight;
                    float f7 = f + f6;
                    if (mode2 == 1073741824 && ((LinearLayout.LayoutParams) mjfkc3).height == 0 && f6 > 0.0f) {
                        int i38 = this.f388JHa;
                        this.f388JHa = Math.max(i38, ((LinearLayout.LayoutParams) mjfkc3).topMargin + i38 + ((LinearLayout.LayoutParams) mjfkc3).bottomMargin);
                        iMax3 = i19;
                        view = viewM169IEE4;
                        iMax2 = i20;
                        z3 = true;
                        i10 = i37;
                        i11 = i18;
                        i12 = mode2;
                        i13 = i22;
                        i14 = virtualChildCount;
                        i15 = iM183rkYL;
                    } else {
                        int i39 = i18;
                        if (((LinearLayout.LayoutParams) mjfkc3).height != 0 || f6 <= 0.0f) {
                            i9 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) mjfkc3).height = -2;
                            i9 = 0;
                        }
                        i10 = i37;
                        int i40 = i9;
                        i11 = i39;
                        int i41 = i19;
                        i12 = mode2;
                        i13 = i22;
                        i14 = virtualChildCount;
                        iMax2 = i20;
                        i15 = iM183rkYL;
                        m173Ucbh(viewM169IEE4, iM183rkYL, i, 0, i2, f7 == 0.0f ? this.f388JHa : 0);
                        if (i40 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) mjfkc3).height = i40;
                        }
                        int measuredHeight2 = viewM169IEE4.getMeasuredHeight();
                        int i42 = this.f388JHa;
                        view = viewM169IEE4;
                        this.f388JHa = Math.max(i42, i42 + measuredHeight2 + ((LinearLayout.LayoutParams) mjfkc3).topMargin + ((LinearLayout.LayoutParams) mjfkc3).bottomMargin + m178fehf(view));
                        iMax3 = z2 ? Math.max(measuredHeight2, i41) : i41;
                    }
                    if (i16 >= 0 && i16 == i15 + 1) {
                        this.f398wA = this.f388JHa;
                    }
                    if (i15 < i16 && ((LinearLayout.LayoutParams) mjfkc3).weight > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || ((LinearLayout.LayoutParams) mjfkc3).width != -1) {
                        z = false;
                    } else {
                        z = true;
                        z4 = true;
                    }
                    int i43 = ((LinearLayout.LayoutParams) mjfkc3).leftMargin + ((LinearLayout.LayoutParams) mjfkc3).rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i43;
                    int iMax7 = Math.max(i11, measuredWidth2);
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(i10, view.getMeasuredState());
                    z5 = z5 && ((LinearLayout.LayoutParams) mjfkc3).width == -1;
                    if (((LinearLayout.LayoutParams) mjfkc3).weight > 0.0f) {
                        if (!z) {
                            i43 = measuredWidth2;
                        }
                        iMax4 = Math.max(i13, i43);
                    } else {
                        if (!z) {
                            i43 = measuredWidth2;
                        }
                        iMax2 = Math.max(iMax2, i43);
                        iMax4 = i13;
                    }
                    int iM183rkYL3 = m183rkYL(view, i15) + i15;
                    i19 = iMax3;
                    i18 = iMax7;
                    f = f7;
                    i20 = iMax2;
                    iM183rkYL = iM183rkYL3;
                    i17 = iCombineMeasuredStates2;
                }
            }
            iM183rkYL++;
            virtualChildCount = i14;
            mode2 = i12;
        }
    }

    /* renamed from: IEE */
    public View m169IEE(int i) {
        return getChildAt(i);
    }

    /* renamed from: JHa */
    public void m170JHa(Canvas canvas) {
        int right;
        int left;
        int i;
        int virtualChildCount = getVirtualChildCount();
        boolean zM13718mjFkc = AbstractC4689ua.m13718mjFkc(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View viewM169IEE = m169IEE(i2);
            if (viewM169IEE != null && viewM169IEE.getVisibility() != 8 && m172Pq(i2)) {
                mjFkc mjfkc = (mjFkc) viewM169IEE.getLayoutParams();
                m182qdMbNW(canvas, zM13718mjFkc ? viewM169IEE.getRight() + ((LinearLayout.LayoutParams) mjfkc).rightMargin : (viewM169IEE.getLeft() - ((LinearLayout.LayoutParams) mjfkc).leftMargin) - this.f391VA);
            }
        }
        if (m172Pq(virtualChildCount)) {
            View viewM169IEE2 = m169IEE(virtualChildCount - 1);
            if (viewM169IEE2 != null) {
                mjFkc mjfkc2 = (mjFkc) viewM169IEE2.getLayoutParams();
                if (zM13718mjFkc) {
                    left = viewM169IEE2.getLeft() - ((LinearLayout.LayoutParams) mjfkc2).leftMargin;
                    i = this.f391VA;
                    right = left - i;
                } else {
                    right = viewM169IEE2.getRight() + ((LinearLayout.LayoutParams) mjfkc2).rightMargin;
                }
            } else if (zM13718mjFkc) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.f391VA;
                right = left - i;
            }
            m182qdMbNW(canvas, right);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: MiMN, reason: merged with bridge method [inline-methods] */
    public mjFkc generateLayoutParams(AttributeSet attributeSet) {
        return new mjFkc(getContext(), attributeSet);
    }

    /* renamed from: Pq */
    public boolean m172Pq(int i) {
        if (i == 0) {
            return (this.f392YoKzxo & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.f392YoKzxo & 4) != 0;
        }
        if ((this.f392YoKzxo & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: Ucbh */
    public void m173Ucbh(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    @Override // android.view.ViewGroup
    /* renamed from: VA, reason: merged with bridge method [inline-methods] */
    public mjFkc generateDefaultLayoutParams() {
        int i = this.f393ZfxDd;
        if (i == 0) {
            return new mjFkc(-2, -2);
        }
        if (i == 1) {
            return new mjFkc(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: YoKzxo, reason: merged with bridge method [inline-methods] */
    public mjFkc generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new mjFkc(layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof mjFkc;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0100  */
    /* renamed from: diqgf */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m176diqgf(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        int measuredHeight;
        boolean zM13718mjFkc = AbstractC4689ua.m13718mjFkc(this);
        int paddingTop = getPaddingTop();
        int i12 = i4 - i2;
        int paddingBottom = i12 - getPaddingBottom();
        int paddingBottom2 = (i12 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i13 = this.f389KLFTb;
        int i14 = i13 & 112;
        boolean z2 = this.f395mjFkc;
        int[] iArr = this.f396qdMbNW;
        int[] iArr2 = this.f386Dt;
        int iM12647AZxh = AbstractC4056l.m12647AZxh(8388615 & i13, AbstractC2876T9.m10276huTpC(this));
        boolean z3 = true;
        int paddingLeft = iM12647AZxh != 1 ? iM12647AZxh != 5 ? getPaddingLeft() : ((getPaddingLeft() + i3) - i) - this.f388JHa : getPaddingLeft() + (((i3 - i) - this.f388JHa) / 2);
        if (zM13718mjFkc) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int iM183rkYL = 0;
        while (iM183rkYL < virtualChildCount) {
            int i15 = i5 + (i6 * iM183rkYL);
            View viewM169IEE = m169IEE(i15);
            if (viewM169IEE == null) {
                paddingLeft += m167Gd(i15);
                z = z3;
                i7 = paddingTop;
                i8 = virtualChildCount;
                i9 = i14;
            } else if (viewM169IEE.getVisibility() != 8) {
                int measuredWidth = viewM169IEE.getMeasuredWidth();
                int measuredHeight2 = viewM169IEE.getMeasuredHeight();
                mjFkc mjfkc = (mjFkc) viewM169IEE.getLayoutParams();
                int i16 = iM183rkYL;
                if (z2) {
                    i8 = virtualChildCount;
                    int baseline = ((LinearLayout.LayoutParams) mjfkc).height != -1 ? viewM169IEE.getBaseline() : -1;
                    i10 = ((LinearLayout.LayoutParams) mjfkc).gravity;
                    if (i10 < 0) {
                        i10 = i14;
                    }
                    i11 = i10 & 112;
                    i9 = i14;
                    if (i11 == 16) {
                        if (i11 == 48) {
                            measuredHeight = ((LinearLayout.LayoutParams) mjfkc).topMargin + paddingTop;
                            if (baseline != -1) {
                                z = true;
                                measuredHeight += iArr[1] - baseline;
                            }
                        } else if (i11 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            measuredHeight = (paddingBottom - measuredHeight2) - ((LinearLayout.LayoutParams) mjfkc).bottomMargin;
                            if (baseline != -1) {
                                measuredHeight -= iArr2[2] - (viewM169IEE.getMeasuredHeight() - baseline);
                            }
                        }
                        z = true;
                    } else {
                        z = true;
                        measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + ((LinearLayout.LayoutParams) mjfkc).topMargin) - ((LinearLayout.LayoutParams) mjfkc).bottomMargin;
                    }
                    if (m172Pq(i15)) {
                        paddingLeft += this.f391VA;
                    }
                    int i17 = ((LinearLayout.LayoutParams) mjfkc).leftMargin + paddingLeft;
                    i7 = paddingTop;
                    m165vI(viewM169IEE, i17 + m181qGY(viewM169IEE), measuredHeight, measuredWidth, measuredHeight2);
                    int iM178fehf = i17 + measuredWidth + ((LinearLayout.LayoutParams) mjfkc).rightMargin + m178fehf(viewM169IEE);
                    iM183rkYL = i16 + m183rkYL(viewM169IEE, i15);
                    paddingLeft = iM178fehf;
                    iM183rkYL++;
                    virtualChildCount = i8;
                    i14 = i9;
                    z3 = z;
                    paddingTop = i7;
                } else {
                    i8 = virtualChildCount;
                }
                i10 = ((LinearLayout.LayoutParams) mjfkc).gravity;
                if (i10 < 0) {
                }
                i11 = i10 & 112;
                i9 = i14;
                if (i11 == 16) {
                }
                if (m172Pq(i15)) {
                }
                int i172 = ((LinearLayout.LayoutParams) mjfkc).leftMargin + paddingLeft;
                i7 = paddingTop;
                m165vI(viewM169IEE, i172 + m181qGY(viewM169IEE), measuredHeight, measuredWidth, measuredHeight2);
                int iM178fehf2 = i172 + measuredWidth + ((LinearLayout.LayoutParams) mjfkc).rightMargin + m178fehf(viewM169IEE);
                iM183rkYL = i16 + m183rkYL(viewM169IEE, i15);
                paddingLeft = iM178fehf2;
                iM183rkYL++;
                virtualChildCount = i8;
                i14 = i9;
                z3 = z;
                paddingTop = i7;
            } else {
                i7 = paddingTop;
                i8 = virtualChildCount;
                i9 = i14;
                z = true;
            }
            iM183rkYL++;
            virtualChildCount = i8;
            i14 = i9;
            z3 = z;
            paddingTop = i7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /* renamed from: eyqo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m177eyqo(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int paddingLeft = getPaddingLeft();
        int i9 = i3 - i;
        int paddingRight = i9 - getPaddingRight();
        int paddingRight2 = (i9 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i10 = this.f389KLFTb;
        int i11 = i10 & 112;
        int i12 = i10 & 8388615;
        int paddingTop = i11 != 16 ? i11 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.f388JHa : getPaddingTop() + (((i4 - i2) - this.f388JHa) / 2);
        int iM183rkYL = 0;
        while (iM183rkYL < virtualChildCount) {
            View viewM169IEE = m169IEE(iM183rkYL);
            if (viewM169IEE == null) {
                paddingTop += m167Gd(iM183rkYL);
            } else {
                if (viewM169IEE.getVisibility() != 8) {
                    int measuredWidth = viewM169IEE.getMeasuredWidth();
                    int measuredHeight = viewM169IEE.getMeasuredHeight();
                    mjFkc mjfkc = (mjFkc) viewM169IEE.getLayoutParams();
                    int i13 = ((LinearLayout.LayoutParams) mjfkc).gravity;
                    if (i13 < 0) {
                        i13 = i12;
                    }
                    int iM12647AZxh = AbstractC4056l.m12647AZxh(i13, AbstractC2876T9.m10276huTpC(this)) & 7;
                    if (iM12647AZxh == 1) {
                        i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) mjfkc).leftMargin;
                        i6 = ((LinearLayout.LayoutParams) mjfkc).rightMargin;
                    } else if (iM12647AZxh != 5) {
                        i7 = ((LinearLayout.LayoutParams) mjfkc).leftMargin + paddingLeft;
                        int i14 = i7;
                        if (m172Pq(iM183rkYL)) {
                            paddingTop += this.f390MiMN;
                        }
                        int i15 = paddingTop + ((LinearLayout.LayoutParams) mjfkc).topMargin;
                        m165vI(viewM169IEE, i14, i15 + m181qGY(viewM169IEE), measuredWidth, measuredHeight);
                        int iM178fehf = i15 + measuredHeight + ((LinearLayout.LayoutParams) mjfkc).bottomMargin + m178fehf(viewM169IEE);
                        iM183rkYL += m183rkYL(viewM169IEE, iM183rkYL);
                        paddingTop = iM178fehf;
                        i8 = 1;
                    } else {
                        i5 = paddingRight - measuredWidth;
                        i6 = ((LinearLayout.LayoutParams) mjfkc).rightMargin;
                    }
                    i7 = i5 - i6;
                    int i142 = i7;
                    if (m172Pq(iM183rkYL)) {
                    }
                    int i152 = paddingTop + ((LinearLayout.LayoutParams) mjfkc).topMargin;
                    m165vI(viewM169IEE, i142, i152 + m181qGY(viewM169IEE), measuredWidth, measuredHeight);
                    int iM178fehf2 = i152 + measuredHeight + ((LinearLayout.LayoutParams) mjfkc).bottomMargin + m178fehf(viewM169IEE);
                    iM183rkYL += m183rkYL(viewM169IEE, iM183rkYL);
                    paddingTop = iM178fehf2;
                    i8 = 1;
                }
                iM183rkYL += i8;
            }
            i8 = 1;
            iM183rkYL += i8;
        }
    }

    /* renamed from: fehf */
    public int m178fehf(View view) {
        return 0;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.f385AZxh < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.f385AZxh;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f385AZxh == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f398wA;
        if (this.f393ZfxDd == 1 && (i = this.f389KLFTb & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f388JHa) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f388JHa;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((mjFkc) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f385AZxh;
    }

    public Drawable getDividerDrawable() {
        return this.f387ETF;
    }

    public int getDividerPadding() {
        return this.f397rkYL;
    }

    public int getDividerWidth() {
        return this.f391VA;
    }

    public int getGravity() {
        return this.f389KLFTb;
    }

    public int getOrientation() {
        return this.f393ZfxDd;
    }

    public int getShowDividers() {
        return this.f392YoKzxo;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f399xJ;
    }

    /* JADX WARN: Removed duplicated region for block: B:200:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d9  */
    /* renamed from: huTpC */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m179huTpC(int i, int i2) {
        int[] iArr;
        int i3;
        int iMax;
        int iCombineMeasuredStates;
        int i4;
        int i5;
        int iMax2;
        int i6;
        int i7;
        float f;
        int i8;
        int baseline;
        int i9;
        int i10;
        int i11;
        char c;
        int i12;
        int i13;
        boolean z;
        boolean z2;
        View view;
        int i14;
        boolean z3;
        int measuredHeight;
        int iM183rkYL;
        int baseline2;
        int i15;
        this.f388JHa = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.f396qdMbNW == null || this.f386Dt == null) {
            this.f396qdMbNW = new int[4];
            this.f386Dt = new int[4];
        }
        int[] iArr2 = this.f396qdMbNW;
        int[] iArr3 = this.f386Dt;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z4 = this.f395mjFkc;
        boolean z5 = this.f394lgHUyS;
        int i16 = 1073741824;
        boolean z6 = mode == 1073741824;
        int iM183rkYL2 = 0;
        int iMax3 = 0;
        int iMax4 = 0;
        int iMax5 = 0;
        int iMax6 = 0;
        boolean z7 = false;
        int iCombineMeasuredStates2 = 0;
        boolean z8 = false;
        boolean z9 = true;
        float f2 = 0.0f;
        while (true) {
            iArr = iArr3;
            if (iM183rkYL2 >= virtualChildCount) {
                break;
            }
            View viewM169IEE = m169IEE(iM183rkYL2);
            if (viewM169IEE == null) {
                this.f388JHa += m167Gd(iM183rkYL2);
            } else if (viewM169IEE.getVisibility() == 8) {
                iM183rkYL2 += m183rkYL(viewM169IEE, iM183rkYL2);
            } else {
                if (m172Pq(iM183rkYL2)) {
                    this.f388JHa += this.f391VA;
                }
                mjFkc mjfkc = (mjFkc) viewM169IEE.getLayoutParams();
                float f3 = ((LinearLayout.LayoutParams) mjfkc).weight;
                float f4 = f2 + f3;
                if (mode == i16 && ((LinearLayout.LayoutParams) mjfkc).width == 0 && f3 > 0.0f) {
                    if (z6) {
                        this.f388JHa += ((LinearLayout.LayoutParams) mjfkc).leftMargin + ((LinearLayout.LayoutParams) mjfkc).rightMargin;
                    } else {
                        int i17 = this.f388JHa;
                        this.f388JHa = Math.max(i17, ((LinearLayout.LayoutParams) mjfkc).leftMargin + i17 + ((LinearLayout.LayoutParams) mjfkc).rightMargin);
                    }
                    if (z4) {
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        viewM169IEE.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        i13 = iM183rkYL2;
                        z = z5;
                        z2 = z4;
                        view = viewM169IEE;
                    } else {
                        i13 = iM183rkYL2;
                        z = z5;
                        z2 = z4;
                        view = viewM169IEE;
                        z7 = true;
                        i14 = 1073741824;
                        if (mode2 == i14 && ((LinearLayout.LayoutParams) mjfkc).height == -1) {
                            z3 = true;
                            z8 = true;
                        } else {
                            z3 = false;
                        }
                        int i18 = ((LinearLayout.LayoutParams) mjfkc).topMargin + ((LinearLayout.LayoutParams) mjfkc).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i18;
                        iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, view.getMeasuredState());
                        if (z2 && (baseline2 = view.getBaseline()) != -1) {
                            i15 = ((LinearLayout.LayoutParams) mjfkc).gravity;
                            if (i15 < 0) {
                                i15 = this.f389KLFTb;
                            }
                            int i19 = (((i15 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i19] = Math.max(iArr2[i19], baseline2);
                            iArr[i19] = Math.max(iArr[i19], measuredHeight - baseline2);
                        }
                        iMax4 = Math.max(iMax4, measuredHeight);
                        z9 = !z9 && ((LinearLayout.LayoutParams) mjfkc).height == -1;
                        if (((LinearLayout.LayoutParams) mjfkc).weight <= 0.0f) {
                            if (!z3) {
                                i18 = measuredHeight;
                            }
                            iMax6 = Math.max(iMax6, i18);
                        } else {
                            int i20 = iMax6;
                            if (!z3) {
                                i18 = measuredHeight;
                            }
                            iMax5 = Math.max(iMax5, i18);
                            iMax6 = i20;
                        }
                        int i21 = i13;
                        iM183rkYL = m183rkYL(view, i21) + i21;
                        f2 = f4;
                        int i22 = iM183rkYL + 1;
                        iArr3 = iArr;
                        z5 = z;
                        z4 = z2;
                        i16 = i14;
                        iM183rkYL2 = i22;
                    }
                } else {
                    if (((LinearLayout.LayoutParams) mjfkc).width != 0 || f3 <= 0.0f) {
                        c = 65534;
                        i12 = Integer.MIN_VALUE;
                    } else {
                        c = 65534;
                        ((LinearLayout.LayoutParams) mjfkc).width = -2;
                        i12 = 0;
                    }
                    i13 = iM183rkYL2;
                    int i23 = i12;
                    z = z5;
                    z2 = z4;
                    m173Ucbh(viewM169IEE, i13, i, f4 == 0.0f ? this.f388JHa : 0, i2, 0);
                    if (i23 != Integer.MIN_VALUE) {
                        ((LinearLayout.LayoutParams) mjfkc).width = i23;
                    }
                    int measuredWidth = viewM169IEE.getMeasuredWidth();
                    if (z6) {
                        view = viewM169IEE;
                        this.f388JHa += ((LinearLayout.LayoutParams) mjfkc).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) mjfkc).rightMargin + m178fehf(view);
                    } else {
                        view = viewM169IEE;
                        int i24 = this.f388JHa;
                        this.f388JHa = Math.max(i24, i24 + measuredWidth + ((LinearLayout.LayoutParams) mjfkc).leftMargin + ((LinearLayout.LayoutParams) mjfkc).rightMargin + m178fehf(view));
                    }
                    if (z) {
                        iMax3 = Math.max(measuredWidth, iMax3);
                    }
                }
                i14 = 1073741824;
                if (mode2 == i14) {
                    z3 = false;
                    int i182 = ((LinearLayout.LayoutParams) mjfkc).topMargin + ((LinearLayout.LayoutParams) mjfkc).bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i182;
                    iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, view.getMeasuredState());
                    if (z2) {
                        i15 = ((LinearLayout.LayoutParams) mjfkc).gravity;
                        if (i15 < 0) {
                        }
                        int i192 = (((i15 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i192] = Math.max(iArr2[i192], baseline2);
                        iArr[i192] = Math.max(iArr[i192], measuredHeight - baseline2);
                    }
                    iMax4 = Math.max(iMax4, measuredHeight);
                    if (z9) {
                        if (((LinearLayout.LayoutParams) mjfkc).weight <= 0.0f) {
                        }
                        int i212 = i13;
                        iM183rkYL = m183rkYL(view, i212) + i212;
                        f2 = f4;
                    }
                }
                int i222 = iM183rkYL + 1;
                iArr3 = iArr;
                z5 = z;
                z4 = z2;
                i16 = i14;
                iM183rkYL2 = i222;
            }
            z = z5;
            z2 = z4;
            int i25 = i16;
            iM183rkYL = iM183rkYL2;
            i14 = i25;
            int i2222 = iM183rkYL + 1;
            iArr3 = iArr;
            z5 = z;
            z4 = z2;
            i16 = i14;
            iM183rkYL2 = i2222;
        }
        boolean z10 = z5;
        boolean z11 = z4;
        int i26 = iMax4;
        int i27 = iMax5;
        int i28 = iMax6;
        int i29 = iCombineMeasuredStates2;
        if (this.f388JHa > 0 && m172Pq(virtualChildCount)) {
            this.f388JHa += this.f391VA;
        }
        int i30 = iArr2[1];
        if (i30 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            iMax = i26;
            i3 = i29;
        } else {
            i3 = i29;
            iMax = Math.max(i26, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i30, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z10 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f388JHa = 0;
            int iM183rkYL3 = 0;
            while (iM183rkYL3 < virtualChildCount) {
                View viewM169IEE2 = m169IEE(iM183rkYL3);
                if (viewM169IEE2 == null) {
                    this.f388JHa += m167Gd(iM183rkYL3);
                } else if (viewM169IEE2.getVisibility() == 8) {
                    iM183rkYL3 += m183rkYL(viewM169IEE2, iM183rkYL3);
                } else {
                    mjFkc mjfkc2 = (mjFkc) viewM169IEE2.getLayoutParams();
                    if (z6) {
                        this.f388JHa += ((LinearLayout.LayoutParams) mjfkc2).leftMargin + iMax3 + ((LinearLayout.LayoutParams) mjfkc2).rightMargin + m178fehf(viewM169IEE2);
                    } else {
                        int i31 = this.f388JHa;
                        i11 = iMax;
                        this.f388JHa = Math.max(i31, i31 + iMax3 + ((LinearLayout.LayoutParams) mjfkc2).leftMargin + ((LinearLayout.LayoutParams) mjfkc2).rightMargin + m178fehf(viewM169IEE2));
                        iM183rkYL3++;
                        iMax = i11;
                    }
                }
                i11 = iMax;
                iM183rkYL3++;
                iMax = i11;
            }
        }
        int iMax7 = iMax;
        int paddingLeft = this.f388JHa + getPaddingLeft() + getPaddingRight();
        this.f388JHa = paddingLeft;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0);
        int i32 = (16777215 & iResolveSizeAndState) - this.f388JHa;
        if (z7 || (i32 != 0 && f2 > 0.0f)) {
            float f5 = this.f399xJ;
            if (f5 > 0.0f) {
                f2 = f5;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.f388JHa = 0;
            int i33 = i27;
            int iMax8 = -1;
            iCombineMeasuredStates = i3;
            int i34 = 0;
            while (i34 < virtualChildCount) {
                View viewM169IEE3 = m169IEE(i34);
                if (viewM169IEE3 == null || viewM169IEE3.getVisibility() == 8) {
                    i6 = i32;
                    i7 = virtualChildCount;
                } else {
                    mjFkc mjfkc3 = (mjFkc) viewM169IEE3.getLayoutParams();
                    float f6 = ((LinearLayout.LayoutParams) mjfkc3).weight;
                    if (f6 > 0.0f) {
                        int i35 = (int) ((i32 * f6) / f2);
                        float f7 = f2 - f6;
                        int i36 = i32 - i35;
                        i7 = virtualChildCount;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + ((LinearLayout.LayoutParams) mjfkc3).topMargin + ((LinearLayout.LayoutParams) mjfkc3).bottomMargin, ((LinearLayout.LayoutParams) mjfkc3).height);
                        if (((LinearLayout.LayoutParams) mjfkc3).width == 0) {
                            i10 = 1073741824;
                            if (mode == 1073741824) {
                                if (i35 <= 0) {
                                    i35 = 0;
                                }
                                viewM169IEE3.measure(View.MeasureSpec.makeMeasureSpec(i35, 1073741824), childMeasureSpec);
                            }
                            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewM169IEE3.getMeasuredState() & (-16777216));
                            f2 = f7;
                            i6 = i36;
                        } else {
                            i10 = 1073741824;
                        }
                        int measuredWidth2 = viewM169IEE3.getMeasuredWidth() + i35;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        viewM169IEE3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i10), childMeasureSpec);
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewM169IEE3.getMeasuredState() & (-16777216));
                        f2 = f7;
                        i6 = i36;
                    } else {
                        i6 = i32;
                        i7 = virtualChildCount;
                    }
                    if (z6) {
                        this.f388JHa += viewM169IEE3.getMeasuredWidth() + ((LinearLayout.LayoutParams) mjfkc3).leftMargin + ((LinearLayout.LayoutParams) mjfkc3).rightMargin + m178fehf(viewM169IEE3);
                        f = f2;
                    } else {
                        int i37 = this.f388JHa;
                        f = f2;
                        this.f388JHa = Math.max(i37, viewM169IEE3.getMeasuredWidth() + i37 + ((LinearLayout.LayoutParams) mjfkc3).leftMargin + ((LinearLayout.LayoutParams) mjfkc3).rightMargin + m178fehf(viewM169IEE3));
                    }
                    boolean z12 = mode2 != 1073741824 && ((LinearLayout.LayoutParams) mjfkc3).height == -1;
                    int i38 = ((LinearLayout.LayoutParams) mjfkc3).topMargin + ((LinearLayout.LayoutParams) mjfkc3).bottomMargin;
                    int measuredHeight2 = viewM169IEE3.getMeasuredHeight() + i38;
                    iMax8 = Math.max(iMax8, measuredHeight2);
                    if (!z12) {
                        i38 = measuredHeight2;
                    }
                    int iMax9 = Math.max(i33, i38);
                    if (z9) {
                        i8 = -1;
                        boolean z13 = ((LinearLayout.LayoutParams) mjfkc3).height == -1;
                        if (z11 && (baseline = viewM169IEE3.getBaseline()) != i8) {
                            i9 = ((LinearLayout.LayoutParams) mjfkc3).gravity;
                            if (i9 < 0) {
                                i9 = this.f389KLFTb;
                            }
                            int i39 = (((i9 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i39] = Math.max(iArr2[i39], baseline);
                            iArr[i39] = Math.max(iArr[i39], measuredHeight2 - baseline);
                        }
                        z9 = z13;
                        i33 = iMax9;
                        f2 = f;
                    } else {
                        i8 = -1;
                    }
                    if (z11) {
                        i9 = ((LinearLayout.LayoutParams) mjfkc3).gravity;
                        if (i9 < 0) {
                        }
                        int i392 = (((i9 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i392] = Math.max(iArr2[i392], baseline);
                        iArr[i392] = Math.max(iArr[i392], measuredHeight2 - baseline);
                    }
                    z9 = z13;
                    i33 = iMax9;
                    f2 = f;
                }
                i34++;
                i32 = i6;
                virtualChildCount = i7;
            }
            i4 = i2;
            i5 = virtualChildCount;
            this.f388JHa += getPaddingLeft() + getPaddingRight();
            int i40 = iArr2[1];
            iMax7 = (i40 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? iMax8 : Math.max(iMax8, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i40, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            iMax2 = i33;
        } else {
            iMax2 = Math.max(i27, i28);
            if (z10 && mode != 1073741824) {
                for (int i41 = 0; i41 < virtualChildCount; i41++) {
                    View viewM169IEE4 = m169IEE(i41);
                    if (viewM169IEE4 != null && viewM169IEE4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((mjFkc) viewM169IEE4.getLayoutParams())).weight > 0.0f) {
                        viewM169IEE4.measure(View.MeasureSpec.makeMeasureSpec(iMax3, 1073741824), View.MeasureSpec.makeMeasureSpec(viewM169IEE4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i4 = i2;
            i5 = virtualChildCount;
            iCombineMeasuredStates = i3;
        }
        if (z9 || mode2 == 1073741824) {
            iMax2 = iMax7;
        }
        setMeasuredDimension(iResolveSizeAndState | ((-16777216) & iCombineMeasuredStates), View.resolveSizeAndState(Math.max(iMax2 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, iCombineMeasuredStates << 16));
        if (z8) {
            m166Dt(i5, i);
        }
    }

    /* renamed from: lgHUyS */
    public void m180lgHUyS(Canvas canvas, int i) {
        this.f387ETF.setBounds(getPaddingLeft() + this.f397rkYL, i, (getWidth() - getPaddingRight()) - this.f397rkYL, this.f390MiMN + i);
        this.f387ETF.draw(canvas);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f387ETF == null) {
            return;
        }
        if (this.f393ZfxDd == 1) {
            m184xJ(canvas);
        } else {
            m170JHa(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f393ZfxDd == 1) {
            m177eyqo(i, i2, i3, i4);
        } else {
            m176diqgf(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f393ZfxDd == 1) {
            m168HGpJ(i, i2);
        } else {
            m179huTpC(i, i2);
        }
    }

    /* renamed from: qGY */
    public int m181qGY(View view) {
        return 0;
    }

    /* renamed from: qdMbNW */
    public void m182qdMbNW(Canvas canvas, int i) {
        this.f387ETF.setBounds(i, getPaddingTop() + this.f397rkYL, this.f391VA + i, (getHeight() - getPaddingBottom()) - this.f397rkYL);
        this.f387ETF.draw(canvas);
    }

    /* renamed from: rkYL */
    public int m183rkYL(View view, int i) {
        return 0;
    }

    public void setBaselineAligned(boolean z) {
        this.f395mjFkc = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.f385AZxh = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f387ETF) {
            return;
        }
        this.f387ETF = drawable;
        if (drawable != null) {
            this.f391VA = drawable.getIntrinsicWidth();
            this.f390MiMN = drawable.getIntrinsicHeight();
        } else {
            this.f391VA = 0;
            this.f390MiMN = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.f397rkYL = i;
    }

    public void setGravity(int i) {
        if (this.f389KLFTb != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f389KLFTb = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.f389KLFTb;
        if ((8388615 & i3) != i2) {
            this.f389KLFTb = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f394lgHUyS = z;
    }

    public void setOrientation(int i) {
        if (this.f393ZfxDd != i) {
            this.f393ZfxDd = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.f392YoKzxo) {
            requestLayout();
        }
        this.f392YoKzxo = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.f389KLFTb;
        if ((i3 & 112) != i2) {
            this.f389KLFTb = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.f399xJ = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* renamed from: xJ */
    public void m184xJ(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View viewM169IEE = m169IEE(i);
            if (viewM169IEE != null && viewM169IEE.getVisibility() != 8 && m172Pq(i)) {
                m180lgHUyS(canvas, (viewM169IEE.getTop() - ((LinearLayout.LayoutParams) ((mjFkc) viewM169IEE.getLayoutParams())).topMargin) - this.f390MiMN);
            }
        }
        if (m172Pq(virtualChildCount)) {
            View viewM169IEE2 = m169IEE(virtualChildCount - 1);
            m180lgHUyS(canvas, viewM169IEE2 == null ? (getHeight() - getPaddingBottom()) - this.f390MiMN : viewM169IEE2.getBottom() + ((LinearLayout.LayoutParams) ((mjFkc) viewM169IEE2.getLayoutParams())).bottomMargin);
        }
    }

    public AbstractC0013AZxh(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f395mjFkc = true;
        this.f385AZxh = -1;
        this.f398wA = 0;
        this.f389KLFTb = 8388659;
        C1606A8 c1606a8M7575diqgf = C1606A8.m7575diqgf(context, attributeSet, AbstractC3407b5.f12984kism, i, 0);
        AbstractC2876T9.m10277jm(this, context, AbstractC3407b5.f12984kism, attributeSet, c1606a8M7575diqgf.m7589qGY(), i, 0);
        int iM7577Dt = c1606a8M7575diqgf.m7577Dt(AbstractC3407b5.f13041yX, -1);
        if (iM7577Dt >= 0) {
            setOrientation(iM7577Dt);
        }
        int iM7577Dt2 = c1606a8M7575diqgf.m7577Dt(AbstractC3407b5.f13016tjSezt, -1);
        if (iM7577Dt2 >= 0) {
            setGravity(iM7577Dt2);
        }
        boolean zM7588mjFkc = c1606a8M7575diqgf.m7588mjFkc(AbstractC3407b5.f12971gYa, true);
        if (!zM7588mjFkc) {
            setBaselineAligned(zM7588mjFkc);
        }
        this.f399xJ = c1606a8M7575diqgf.m7587lgHUyS(AbstractC3407b5.f12967fFz, -1.0f);
        this.f385AZxh = c1606a8M7575diqgf.m7577Dt(AbstractC3407b5.f12893LREOK, -1);
        this.f394lgHUyS = c1606a8M7575diqgf.m7588mjFkc(AbstractC3407b5.f12945XtE, false);
        setDividerDrawable(c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f12943XbiWeM));
        this.f392YoKzxo = c1606a8M7575diqgf.m7577Dt(AbstractC3407b5.f12982jx, 0);
        this.f397rkYL = c1606a8M7575diqgf.m7579JHa(AbstractC3407b5.f12941XFUzSY, 0);
        c1606a8M7575diqgf.m7585eyqo();
    }
}
