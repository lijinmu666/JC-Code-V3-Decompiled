package p131o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.p012widget.AbstractC0013AZxh;

/* renamed from: o.niM */
/* loaded from: classes.dex */
public abstract class AbstractC4232niM extends AbstractC0013AZxh {

    /* renamed from: IEE */
    public final Rect f15447IEE;

    /* renamed from: Pq */
    public int f15448Pq;

    /* renamed from: diqgf */
    public boolean f15449diqgf;

    /* renamed from: eyqo */
    public boolean f15450eyqo;

    /* renamed from: fehf */
    public final Rect f15451fehf;

    /* renamed from: qGY */
    public Drawable f15452qGY;

    public AbstractC4232niM(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15451fehf = new Rect();
        this.f15447IEE = new Rect();
        this.f15448Pq = 119;
        this.f15449diqgf = true;
        this.f15450eyqo = false;
        TypedArray typedArrayM12940lgHUyS = AbstractC4260o8.m12940lgHUyS(context, attributeSet, AbstractC3340a5.f12367Fztqa, i, 0, new int[0]);
        this.f15448Pq = typedArrayM12940lgHUyS.getInt(AbstractC3340a5.f12489VfB, this.f15448Pq);
        Drawable drawable = typedArrayM12940lgHUyS.getDrawable(AbstractC3340a5.f12611mzUGzO);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f15449diqgf = typedArrayM12940lgHUyS.getBoolean(AbstractC3340a5.f12382Htq, true);
        typedArrayM12940lgHUyS.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f15452qGY;
        if (drawable != null) {
            if (this.f15450eyqo) {
                this.f15450eyqo = false;
                Rect rect = this.f15451fehf;
                Rect rect2 = this.f15447IEE;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f15449diqgf) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f15448Pq, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.f15452qGY;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f15452qGY;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f15452qGY.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f15452qGY;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f15448Pq;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f15452qGY;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.p012widget.AbstractC0013AZxh, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f15450eyqo = z | this.f15450eyqo;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f15450eyqo = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f15452qGY;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f15452qGY);
            }
            this.f15452qGY = drawable;
            this.f15450eyqo = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f15448Pq == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i) {
        if (this.f15448Pq != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f15448Pq = i;
            if (i == 119 && this.f15452qGY != null) {
                this.f15452qGY.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f15452qGY;
    }
}
