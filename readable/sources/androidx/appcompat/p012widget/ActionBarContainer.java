package androidx.appcompat.p012widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import p131o.AbstractC1865E4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3407b5;
import p131o.C1675BAnRFn;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: AZxh */
    public View f400AZxh;

    /* renamed from: Dt */
    public int f401Dt;

    /* renamed from: JHa */
    public Drawable f402JHa;

    /* renamed from: KLFTb */
    public Drawable f403KLFTb;

    /* renamed from: ZfxDd */
    public View f404ZfxDd;

    /* renamed from: lgHUyS */
    public boolean f405lgHUyS;

    /* renamed from: mjFkc */
    public boolean f406mjFkc;

    /* renamed from: qdMbNW */
    public boolean f407qdMbNW;

    /* renamed from: wA */
    public View f408wA;

    /* renamed from: xJ */
    public Drawable f409xJ;

    /* renamed from: androidx.appcompat.widget.ActionBarContainer$mjFkc */
    public static class C0014mjFkc {
        /* renamed from: mjFkc */
        public static void m187mjFkc(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC2876T9.m10294vjlshU(this, new C1675BAnRFn(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3407b5.f12991mjFkc);
        this.f403KLFTb = typedArrayObtainStyledAttributes.getDrawable(AbstractC3407b5.f12849AZxh);
        this.f402JHa = typedArrayObtainStyledAttributes.getDrawable(AbstractC3407b5.f12951ZfxDd);
        this.f401Dt = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC3407b5.f13004qdMbNW, -1);
        boolean z = true;
        if (getId() == AbstractC1865E4.f7933Gd) {
            this.f405lgHUyS = true;
            this.f409xJ = typedArrayObtainStyledAttributes.getDrawable(AbstractC3407b5.f13028wA);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f405lgHUyS ? this.f403KLFTb != null || this.f402JHa != null : this.f409xJ != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    /* renamed from: AZxh */
    public final boolean m185AZxh(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f403KLFTb;
        if (drawable != null && drawable.isStateful()) {
            this.f403KLFTb.setState(getDrawableState());
        }
        Drawable drawable2 = this.f402JHa;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f402JHa.setState(getDrawableState());
        }
        Drawable drawable3 = this.f409xJ;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f409xJ.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f400AZxh;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f403KLFTb;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f402JHa;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f409xJ;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    /* renamed from: mjFkc */
    public final int m186mjFkc(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f408wA = findViewById(AbstractC1865E4.f7950mjFkc);
        this.f404ZfxDd = findViewById(AbstractC1865E4.f7936JHa);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f406mjFkc || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[PHI: r0
      0x0048: PHI (r0v8 boolean) = (r0v1 boolean), (r0v1 boolean), (r0v0 boolean) binds: [B:31:0x00a5, B:33:0x00a9, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f400AZxh;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i5 = layoutParams.bottomMargin;
            view.layout(i, measuredHeight2 - i5, i3, measuredHeight - i5);
        }
        if (this.f405lgHUyS) {
            Drawable drawable2 = this.f409xJ;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = z3;
            }
        } else {
            if (this.f403KLFTb != null) {
                if (this.f408wA.getVisibility() == 0) {
                    this.f403KLFTb.setBounds(this.f408wA.getLeft(), this.f408wA.getTop(), this.f408wA.getRight(), this.f408wA.getBottom());
                } else {
                    View view2 = this.f404ZfxDd;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f403KLFTb.setBounds(0, 0, 0, 0);
                    } else {
                        this.f403KLFTb.setBounds(this.f404ZfxDd.getLeft(), this.f404ZfxDd.getTop(), this.f404ZfxDd.getRight(), this.f404ZfxDd.getBottom());
                    }
                }
                z3 = true;
            }
            this.f407qdMbNW = z4;
            if (z4 && (drawable = this.f402JHa) != null) {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        if (this.f408wA == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i3 = this.f401Dt) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f408wA == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        View view = this.f400AZxh;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!m185AZxh(this.f408wA) ? m186mjFkc(this.f408wA) : !m185AZxh(this.f404ZfxDd) ? m186mjFkc(this.f404ZfxDd) : 0) + m186mjFkc(this.f400AZxh), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f403KLFTb;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f403KLFTb);
        }
        this.f403KLFTb = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f408wA;
            if (view != null) {
                this.f403KLFTb.setBounds(view.getLeft(), this.f408wA.getTop(), this.f408wA.getRight(), this.f408wA.getBottom());
            }
        }
        boolean z = false;
        if (!this.f405lgHUyS ? !(this.f403KLFTb != null || this.f402JHa != null) : this.f409xJ == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        C0014mjFkc.m187mjFkc(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f409xJ;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f409xJ);
        }
        this.f409xJ = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f405lgHUyS && (drawable2 = this.f409xJ) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f405lgHUyS ? !(this.f403KLFTb != null || this.f402JHa != null) : this.f409xJ == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        C0014mjFkc.m187mjFkc(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f402JHa;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f402JHa);
        }
        this.f402JHa = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f407qdMbNW && (drawable2 = this.f402JHa) != null) {
                drawable2.setBounds(this.f400AZxh.getLeft(), this.f400AZxh.getTop(), this.f400AZxh.getRight(), this.f400AZxh.getBottom());
            }
        }
        boolean z = false;
        if (!this.f405lgHUyS ? !(this.f403KLFTb != null || this.f402JHa != null) : this.f409xJ == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        C0014mjFkc.m187mjFkc(this);
    }

    public void setTabContainer(AbstractC0048wA abstractC0048wA) {
        View view = this.f400AZxh;
        if (view != null) {
            removeView(view);
        }
        this.f400AZxh = abstractC0048wA;
    }

    public void setTransitioning(boolean z) {
        this.f406mjFkc = z;
        setDescendantFocusability(z ? 393216 : PKIFailureInfo.transactionIdInUse);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f403KLFTb;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f402JHa;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f409xJ;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f403KLFTb && !this.f405lgHUyS) || (drawable == this.f402JHa && this.f407qdMbNW) || ((drawable == this.f409xJ && this.f405lgHUyS) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }
}
