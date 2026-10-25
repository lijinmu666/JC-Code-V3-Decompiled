package androidx.fragment.p022app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.ArrayList;
import org.conscrypt.BuildConfig;
import p131o.AbstractC2876T9;
import p131o.AbstractC3206Y4;
import p131o.C3372ab;

/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* renamed from: AZxh */
    public ArrayList f1178AZxh;

    /* renamed from: ZfxDd */
    public boolean f1179ZfxDd;

    /* renamed from: mjFkc */
    public ArrayList f1180mjFkc;

    /* renamed from: wA */
    public View.OnApplyWindowInsetsListener f1181wA;

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (AbstractC0093KLFTb.m856JBhc(view) != null) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (AbstractC0093KLFTb.m856JBhc(view) != null) {
            return super.addViewInLayout(view, i, layoutParams, z);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        C3372ab c3372abM11330Pq = C3372ab.m11330Pq(windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f1181wA;
        C3372ab c3372abM11330Pq2 = onApplyWindowInsetsListener != null ? C3372ab.m11330Pq(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets)) : AbstractC2876T9.m10228GMIER(this, c3372abM11330Pq);
        if (!c3372abM11330Pq2.m11339YoKzxo()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                AbstractC2876T9.m10234JHa(getChildAt(i), c3372abM11330Pq2);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f1179ZfxDd && this.f1180mjFkc != null) {
            for (int i = 0; i < this.f1180mjFkc.size(); i++) {
                super.drawChild(canvas, (View) this.f1180mjFkc.get(i), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        ArrayList arrayList;
        if (!this.f1179ZfxDd || (arrayList = this.f1180mjFkc) == null || arrayList.size() <= 0 || !this.f1180mjFkc.contains(view)) {
            return super.drawChild(canvas, view, j);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        ArrayList arrayList = this.f1178AZxh;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList arrayList2 = this.f1180mjFkc;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f1179ZfxDd = true;
            }
        }
        super.endViewTransition(view);
    }

    /* renamed from: mjFkc */
    public final void m852mjFkc(View view) {
        ArrayList arrayList = this.f1178AZxh;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.f1180mjFkc == null) {
            this.f1180mjFkc = new ArrayList();
        }
        this.f1180mjFkc.add(view);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            m852mjFkc(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        if (z) {
            m852mjFkc(view);
        }
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        m852mjFkc(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        m852mjFkc(getChildAt(i));
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        m852mjFkc(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            m852mjFkc(getChildAt(i3));
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            m852mjFkc(getChildAt(i3));
        }
        super.removeViewsInLayout(i, i2);
    }

    public void setDrawDisappearingViewsLast(boolean z) {
        this.f1179ZfxDd = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f1181wA = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f1178AZxh == null) {
                this.f1178AZxh = new ArrayList();
            }
            this.f1178AZxh.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, int i) {
        String str;
        super(context, attributeSet, i);
        this.f1179ZfxDd = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3206Y4.f11795lgHUyS);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(AbstractC3206Y4.f11797qdMbNW);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
        }
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, AbstractC0093KLFTb abstractC0093KLFTb) {
        String str;
        super(context, attributeSet);
        this.f1179ZfxDd = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3206Y4.f11795lgHUyS);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(AbstractC3206Y4.f11797qdMbNW) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(AbstractC3206Y4.f11789Dt);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        Fragment fragmentM926oCFDzJ = abstractC0093KLFTb.m926oCFDzJ(id);
        if (classAttribute != null && fragmentM926oCFDzJ == null) {
            if (id <= 0) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = BuildConfig.f24315FLAVOR;
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment fragmentMo951mjFkc = abstractC0093KLFTb.m872JYgkl().mo951mjFkc(context.getClassLoader(), classAttribute);
            fragmentMo951mjFkc.m769JBhc(context, attributeSet, null);
            abstractC0093KLFTb.m864Dt().m964YoKzxo(true).m968wA(this, fragmentMo951mjFkc, string).mo966lgHUyS();
        }
        abstractC0093KLFTb.m915gtIJp(this);
    }
}
