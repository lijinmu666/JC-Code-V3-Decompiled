package p131o;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* renamed from: o.VocHEe */
/* loaded from: classes.dex */
public abstract class AbstractC3053VocHEe extends ViewGroup.MarginLayoutParams {

    /* renamed from: mjFkc */
    public int f11370mjFkc;

    public AbstractC3053VocHEe(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11370mjFkc = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3407b5.f12875IEE);
        this.f11370mjFkc = typedArrayObtainStyledAttributes.getInt(AbstractC3407b5.f12909Pq, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public AbstractC3053VocHEe(int i, int i2) {
        super(i, i2);
        this.f11370mjFkc = 8388627;
    }

    public AbstractC3053VocHEe(AbstractC3053VocHEe abstractC3053VocHEe) {
        super((ViewGroup.MarginLayoutParams) abstractC3053VocHEe);
        this.f11370mjFkc = 0;
        this.f11370mjFkc = abstractC3053VocHEe.f11370mjFkc;
    }

    public AbstractC3053VocHEe(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f11370mjFkc = 0;
    }
}
