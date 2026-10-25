package androidx.appcompat.p012widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
import p131o.AbstractC3407b5;

/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: AZxh */
    public int f612AZxh;

    /* renamed from: ZfxDd */
    public LayoutInflater f613ZfxDd;

    /* renamed from: mjFkc */
    public int f614mjFkc;

    /* renamed from: wA */
    public WeakReference f615wA;

    /* renamed from: androidx.appcompat.widget.ViewStubCompat$mjFkc */
    public interface InterfaceC0045mjFkc {
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f612AZxh;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f613ZfxDd;
    }

    public int getLayoutResource() {
        return this.f614mjFkc;
    }

    /* renamed from: mjFkc */
    public View m328mjFkc() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f614mjFkc == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflaterFrom = this.f613ZfxDd;
        if (layoutInflaterFrom == null) {
            layoutInflaterFrom = LayoutInflater.from(getContext());
        }
        View viewInflate = layoutInflaterFrom.inflate(this.f614mjFkc, viewGroup, false);
        int i = this.f612AZxh;
        if (i != -1) {
            viewInflate.setId(i);
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(viewInflate, iIndexOfChild);
        }
        this.f615wA = new WeakReference(viewInflate);
        return viewInflate;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f612AZxh = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f613ZfxDd = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f614mjFkc = i;
    }

    public void setOnInflateListener(InterfaceC0045mjFkc interfaceC0045mjFkc) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        WeakReference weakReference = this.f615wA;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i);
            return;
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m328mjFkc();
        }
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f614mjFkc = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3407b5.f12851BABY, i, 0);
        this.f612AZxh = typedArrayObtainStyledAttributes.getResourceId(AbstractC3407b5.f13036xVYW, -1);
        this.f614mjFkc = typedArrayObtainStyledAttributes.getResourceId(AbstractC3407b5.f13006qtZIjO, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(AbstractC3407b5.f12970gJsSk, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
