package androidx.appcompat.p012widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import p131o.AbstractC1865E4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3407b5;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: AZxh */
    public boolean f475AZxh;

    /* renamed from: mjFkc */
    public boolean f476mjFkc;

    /* renamed from: wA */
    public int f477wA;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f477wA = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3407b5.f13027vjlshU);
        AbstractC2876T9.m10277jm(this, context, AbstractC3407b5.f13027vjlshU, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        this.f476mjFkc = typedArrayObtainStyledAttributes.getBoolean(AbstractC3407b5.f13035xROA, true);
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f476mjFkc);
        }
    }

    private void setStacked(boolean z) {
        if (this.f475AZxh != z) {
            if (!z || this.f476mjFkc) {
                this.f475AZxh = z;
                setOrientation(z ? 1 : 0);
                setGravity(z ? 8388613 : 80);
                View viewFindViewById = findViewById(AbstractC1865E4.f7948huTpC);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(z ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    /* renamed from: AZxh */
    public final boolean m228AZxh() {
        return this.f475AZxh;
    }

    /* renamed from: mjFkc */
    public final int m229mjFkc(int i) {
        int childCount = getChildCount();
        while (i < childCount) {
            if (getChildAt(i).getVisibility() == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        boolean z;
        int size = View.MeasureSpec.getSize(i);
        int paddingBottom = 0;
        if (this.f476mjFkc) {
            if (size > this.f477wA && m228AZxh()) {
                setStacked(false);
            }
            this.f477wA = size;
        }
        if (m228AZxh() || View.MeasureSpec.getMode(i) != 1073741824) {
            iMakeMeasureSpec = i;
            z = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(iMakeMeasureSpec, i2);
        if (this.f476mjFkc && !m228AZxh() && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z = true;
        }
        if (z) {
            super.onMeasure(i, i2);
        }
        int iM229mjFkc = m229mjFkc(0);
        if (iM229mjFkc >= 0) {
            View childAt = getChildAt(iM229mjFkc);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (m228AZxh()) {
                int iM229mjFkc2 = m229mjFkc(iM229mjFkc + 1);
                if (iM229mjFkc2 >= 0) {
                    paddingTop += getChildAt(iM229mjFkc2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                paddingBottom = paddingTop;
            } else {
                paddingBottom = paddingTop + getPaddingBottom();
            }
        }
        if (AbstractC2876T9.m10229Gd(this) != paddingBottom) {
            setMinimumHeight(paddingBottom);
            if (i2 == 0) {
                super.onMeasure(i, i2);
            }
        }
    }

    public void setAllowStacking(boolean z) {
        if (this.f476mjFkc != z) {
            this.f476mjFkc = z;
            if (!z && m228AZxh()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
