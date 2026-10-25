package p131o;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: o.B5 */
/* loaded from: classes.dex */
public class C1668B5 extends Drawable implements InterfaceC2350L6 {

    /* renamed from: mjFkc */
    public AZxh f7437mjFkc;

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        AZxh aZxh = this.f7437mjFkc;
        if (aZxh.f7438AZxh) {
            aZxh.f7439mjFkc.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f7437mjFkc;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f7437mjFkc.f7439mjFkc.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
    public C1668B5 mutate() {
        this.f7437mjFkc = new AZxh(this.f7437mjFkc);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f7437mjFkc.f7439mjFkc.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f7437mjFkc.f7439mjFkc.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zM7749AZxh = AbstractC1735C5.m7749AZxh(iArr);
        AZxh aZxh = this.f7437mjFkc;
        if (aZxh.f7438AZxh == zM7749AZxh) {
            return zOnStateChange;
        }
        aZxh.f7438AZxh = zM7749AZxh;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f7437mjFkc.f7439mjFkc.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f7437mjFkc.f7439mjFkc.setColorFilter(colorFilter);
    }

    @Override // p131o.InterfaceC2350L6
    public void setShapeAppearanceModel(C2141I6 c2141i6) {
        this.f7437mjFkc.f7439mjFkc.setShapeAppearanceModel(c2141i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        this.f7437mjFkc.f7439mjFkc.setTint(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f7437mjFkc.f7439mjFkc.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f7437mjFkc.f7439mjFkc.setTintMode(mode);
    }

    public C1668B5(C2141I6 c2141i6) {
        this(new AZxh(new C2542O1(c2141i6)));
    }

    /* renamed from: o.B5$AZxh */
    public static final class AZxh extends Drawable.ConstantState {

        /* renamed from: AZxh */
        public boolean f7438AZxh;

        /* renamed from: mjFkc */
        public C2542O1 f7439mjFkc;

        public AZxh(C2542O1 c2542o1) {
            this.f7439mjFkc = c2542o1;
            this.f7438AZxh = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public C1668B5 newDrawable() {
            return new C1668B5(new AZxh(this));
        }

        public AZxh(AZxh aZxh) {
            this.f7439mjFkc = (C2542O1) aZxh.f7439mjFkc.getConstantState().newDrawable();
            this.f7438AZxh = aZxh.f7438AZxh;
        }
    }

    public C1668B5(AZxh aZxh) {
        this.f7437mjFkc = aZxh;
    }
}
