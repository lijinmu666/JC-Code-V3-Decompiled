package p131o;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.p015widget.AbstractC0050AZxh;
import androidx.constraintlayout.p015widget.ConstraintLayout;

/* renamed from: o.Ca */
/* loaded from: classes.dex */
public abstract class AbstractC1767Ca extends AbstractC0050AZxh {

    /* renamed from: Dt */
    public boolean f7634Dt;

    /* renamed from: qdMbNW */
    public boolean f7635qdMbNW;

    public AbstractC1767Ca(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: YoKzxo */
    public abstract void mo369YoKzxo(AbstractC1832Da abstractC1832Da, int i, int i2);

    @Override // androidx.constraintlayout.p015widget.AbstractC0050AZxh, android.view.View
    public void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.f7635qdMbNW || this.f7634Dt) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i = 0; i < this.f663AZxh; i++) {
                View viewM400lgHUyS = constraintLayout.m400lgHUyS(this.f668mjFkc[i]);
                if (viewM400lgHUyS != null) {
                    if (this.f7635qdMbNW) {
                        viewM400lgHUyS.setVisibility(visibility);
                    }
                    if (this.f7634Dt && elevation > 0.0f) {
                        viewM400lgHUyS.setTranslationZ(viewM400lgHUyS.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        m383wA();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        m383wA();
    }

    @Override // androidx.constraintlayout.p015widget.AbstractC0050AZxh
    /* renamed from: xJ */
    public void mo371xJ(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.mo371xJ(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC3005V4.f11127dGDT);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == AbstractC3005V4.f11034NV) {
                    this.f7635qdMbNW = true;
                } else if (index == AbstractC3005V4.f11191oaI) {
                    this.f7634Dt = true;
                }
            }
        }
    }
}
