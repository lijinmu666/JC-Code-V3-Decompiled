package androidx.appcompat.p012widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.p012widget.AbstractC0013AZxh;
import p131o.AbstractC1865E4;
import p131o.AbstractC2876T9;
import p131o.AbstractC4056l;

/* loaded from: classes.dex */
public class AlertDialogLayout extends AbstractC0013AZxh {
    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: VocHEe */
    public static int m224VocHEe(View view) {
        int iM10229Gd = AbstractC2876T9.m10229Gd(view);
        if (iM10229Gd > 0) {
            return iM10229Gd;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return m224VocHEe(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    /* renamed from: BAnRFn */
    public final boolean m225BAnRFn(int i, int i2) {
        int iCombineMeasuredStates;
        int iM224VocHEe;
        int measuredHeight;
        int measuredHeight2;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == AbstractC1865E4.f7930BAnRFn) {
                    view = childAt;
                } else if (id == AbstractC1865E4.f7949lgHUyS) {
                    view2 = childAt;
                } else {
                    if ((id != AbstractC1865E4.f7931Dt && id != AbstractC1865E4.f7932ETF) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i, 0);
            paddingTop += view.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            iCombineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i, 0);
            iM224VocHEe = m224VocHEe(view2);
            measuredHeight = view2.getMeasuredHeight() - iM224VocHEe;
            paddingTop += iM224VocHEe;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        } else {
            iM224VocHEe = 0;
            measuredHeight = 0;
        }
        if (view3 != null) {
            view3.measure(i, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            measuredHeight2 = view3.getMeasuredHeight();
            paddingTop += measuredHeight2;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        } else {
            measuredHeight2 = 0;
        }
        int i4 = size - paddingTop;
        if (view2 != null) {
            int i5 = paddingTop - iM224VocHEe;
            int iMin = Math.min(i4, measuredHeight);
            if (iMin > 0) {
                i4 -= iMin;
                iM224VocHEe += iMin;
            }
            view2.measure(i, View.MeasureSpec.makeMeasureSpec(iM224VocHEe, 1073741824));
            paddingTop = i5 + view2.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        }
        if (view3 != null && i4 > 0) {
            view3.measure(i, View.MeasureSpec.makeMeasureSpec(measuredHeight2 + i4, mode));
            paddingTop = (paddingTop - measuredHeight2) + view3.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        }
        int iMax = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = getChildAt(i6);
            if (childAt2.getVisibility() != 8) {
                iMax = Math.max(iMax, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(iMax + getPaddingLeft() + getPaddingRight(), i, iCombineMeasuredStates), View.resolveSizeAndState(paddingTop, i2, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        m226ETF(childCount, i2);
        return true;
    }

    /* renamed from: ETF */
    public final void m226ETF(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                AbstractC0013AZxh.mjFkc mjfkc = (AbstractC0013AZxh.mjFkc) childAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) mjfkc).width == -1) {
                    int i4 = ((LinearLayout.LayoutParams) mjfkc).height;
                    ((LinearLayout.LayoutParams) mjfkc).height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, iMakeMeasureSpec, 0, i2, 0);
                    ((LinearLayout.LayoutParams) mjfkc).height = i4;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9  */
    @Override // androidx.appcompat.p012widget.AbstractC0013AZxh, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int paddingLeft = getPaddingLeft();
        int i8 = i3 - i;
        int paddingRight = i8 - getPaddingRight();
        int paddingRight2 = (i8 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i9 = gravity & 112;
        int i10 = gravity & 8388615;
        int paddingTop = i9 != 16 ? i9 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - measuredHeight : getPaddingTop() + (((i4 - i2) - measuredHeight) / 2);
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                AbstractC0013AZxh.mjFkc mjfkc = (AbstractC0013AZxh.mjFkc) childAt.getLayoutParams();
                int i12 = ((LinearLayout.LayoutParams) mjfkc).gravity;
                if (i12 < 0) {
                    i12 = i10;
                }
                int iM12647AZxh = AbstractC4056l.m12647AZxh(i12, AbstractC2876T9.m10276huTpC(this)) & 7;
                if (iM12647AZxh == 1) {
                    i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) mjfkc).leftMargin;
                    i6 = ((LinearLayout.LayoutParams) mjfkc).rightMargin;
                } else if (iM12647AZxh != 5) {
                    i7 = ((LinearLayout.LayoutParams) mjfkc).leftMargin + paddingLeft;
                    if (m172Pq(i11)) {
                        paddingTop += intrinsicHeight;
                    }
                    int i13 = paddingTop + ((LinearLayout.LayoutParams) mjfkc).topMargin;
                    m227vI(childAt, i7, i13, measuredWidth, measuredHeight2);
                    paddingTop = i13 + measuredHeight2 + ((LinearLayout.LayoutParams) mjfkc).bottomMargin;
                } else {
                    i5 = paddingRight - measuredWidth;
                    i6 = ((LinearLayout.LayoutParams) mjfkc).rightMargin;
                }
                i7 = i5 - i6;
                if (m172Pq(i11)) {
                }
                int i132 = paddingTop + ((LinearLayout.LayoutParams) mjfkc).topMargin;
                m227vI(childAt, i7, i132, measuredWidth, measuredHeight2);
                paddingTop = i132 + measuredHeight2 + ((LinearLayout.LayoutParams) mjfkc).bottomMargin;
            }
        }
    }

    @Override // androidx.appcompat.p012widget.AbstractC0013AZxh, android.view.View
    public void onMeasure(int i, int i2) {
        if (m225BAnRFn(i, i2)) {
            return;
        }
        super.onMeasure(i, i2);
    }

    /* renamed from: vI */
    public final void m227vI(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }
}
