package p131o;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: o.F5 */
/* loaded from: classes.dex */
public class C1935F5 extends Drawable {

    /* renamed from: Dt */
    public ColorStateList f8123Dt;

    /* renamed from: KLFTb */
    public float f8126KLFTb;

    /* renamed from: ZfxDd */
    public final Rect f8127ZfxDd;

    /* renamed from: lgHUyS */
    public ColorStateList f8128lgHUyS;

    /* renamed from: mjFkc */
    public float f8129mjFkc;

    /* renamed from: qdMbNW */
    public PorterDuffColorFilter f8130qdMbNW;

    /* renamed from: wA */
    public final RectF f8131wA;

    /* renamed from: JHa */
    public boolean f8125JHa = false;

    /* renamed from: xJ */
    public boolean f8132xJ = true;

    /* renamed from: ETF */
    public PorterDuff.Mode f8124ETF = PorterDuff.Mode.SRC_IN;

    /* renamed from: AZxh */
    public final Paint f8122AZxh = new Paint(5);

    public C1935F5(ColorStateList colorStateList, float f) {
        this.f8129mjFkc = f;
        m8260KLFTb(colorStateList);
        this.f8131wA = new RectF();
        this.f8127ZfxDd = new Rect();
    }

    /* renamed from: AZxh */
    public ColorStateList m8258AZxh() {
        return this.f8128lgHUyS;
    }

    /* renamed from: JHa */
    public void m8259JHa(ColorStateList colorStateList) {
        m8260KLFTb(colorStateList);
        invalidateSelf();
    }

    /* renamed from: KLFTb */
    public final void m8260KLFTb(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f8128lgHUyS = colorStateList;
        this.f8122AZxh.setColor(colorStateList.getColorForState(getState(), this.f8128lgHUyS.getDefaultColor()));
    }

    /* renamed from: ZfxDd */
    public float m8261ZfxDd() {
        return this.f8129mjFkc;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f8122AZxh;
        if (this.f8130qdMbNW == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f8130qdMbNW);
            z = true;
        }
        RectF rectF = this.f8131wA;
        float f = this.f8129mjFkc;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f8127ZfxDd, this.f8129mjFkc);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f8123Dt;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f8128lgHUyS) != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* renamed from: lgHUyS */
    public void m8262lgHUyS(float f) {
        if (f == this.f8129mjFkc) {
            return;
        }
        this.f8129mjFkc = f;
        m8264qdMbNW(null);
        invalidateSelf();
    }

    /* renamed from: mjFkc */
    public final PorterDuffColorFilter m8263mjFkc(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m8264qdMbNW(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f8128lgHUyS;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f8122AZxh.getColor();
        if (z) {
            this.f8122AZxh.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f8123Dt;
        if (colorStateList2 == null || (mode = this.f8124ETF) == null) {
            return z;
        }
        this.f8130qdMbNW = m8263mjFkc(colorStateList2, mode);
        return true;
    }

    /* renamed from: qdMbNW */
    public final void m8264qdMbNW(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f8131wA.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f8127ZfxDd.set(rect);
        if (this.f8125JHa) {
            this.f8127ZfxDd.inset((int) Math.ceil(AbstractC2008G5.m8404mjFkc(this.f8126KLFTb, this.f8129mjFkc, this.f8132xJ)), (int) Math.ceil(AbstractC2008G5.m8403AZxh(this.f8126KLFTb, this.f8129mjFkc, this.f8132xJ)));
            this.f8131wA.set(this.f8127ZfxDd);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f8122AZxh.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f8122AZxh.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f8123Dt = colorStateList;
        this.f8130qdMbNW = m8263mjFkc(colorStateList, this.f8124ETF);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f8124ETF = mode;
        this.f8130qdMbNW = m8263mjFkc(this.f8123Dt, mode);
        invalidateSelf();
    }

    /* renamed from: wA */
    public float m8265wA() {
        return this.f8126KLFTb;
    }

    /* renamed from: xJ */
    public void m8266xJ(float f, boolean z, boolean z2) {
        if (f == this.f8126KLFTb && this.f8125JHa == z && this.f8132xJ == z2) {
            return;
        }
        this.f8126KLFTb = f;
        this.f8125JHa = z;
        this.f8132xJ = z2;
        m8264qdMbNW(null);
        invalidateSelf();
    }
}
