package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* renamed from: o.WGXroI */
/* loaded from: classes.dex */
public abstract class AbstractC3085WGXroI extends CheckBox {

    /* renamed from: AZxh */
    public final C2266JrJO f11452AZxh;

    /* renamed from: ZfxDd */
    public C3038Vdz f11453ZfxDd;

    /* renamed from: mjFkc */
    public final C3166XV f11454mjFkc;

    /* renamed from: wA */
    public final C2171IVlxe f11455wA;

    public AbstractC3085WGXroI(Context context, AttributeSet attributeSet, int i) {
        super(C4861x8.m13900AZxh(context), attributeSet, i);
        AbstractC4326p8.m13067mjFkc(this, getContext());
        C3166XV c3166xv = new C3166XV(this);
        this.f11454mjFkc = c3166xv;
        c3166xv.m10933KLFTb(attributeSet, i);
        C2266JrJO c2266JrJO = new C2266JrJO(this);
        this.f11452AZxh = c2266JrJO;
        c2266JrJO.m9059KLFTb(attributeSet, i);
        C2171IVlxe c2171IVlxe = new C2171IVlxe(this);
        this.f11455wA = c2171IVlxe;
        c2171IVlxe.m8758MiMN(attributeSet, i);
        getEmojiTextViewHelper().m10698AZxh(attributeSet, i);
    }

    private C3038Vdz getEmojiTextViewHelper() {
        if (this.f11453ZfxDd == null) {
            this.f11453ZfxDd = new C3038Vdz(this);
        }
        return this.f11453ZfxDd;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C2266JrJO c2266JrJO = this.f11452AZxh;
        if (c2266JrJO != null) {
            c2266JrJO.m9055AZxh();
        }
        C2171IVlxe c2171IVlxe = this.f11455wA;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8749AZxh();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C3166XV c3166xv = this.f11454mjFkc;
        return c3166xv != null ? c3166xv.m10931AZxh(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C2266JrJO c2266JrJO = this.f11452AZxh;
        if (c2266JrJO != null) {
            return c2266JrJO.m9064wA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C2266JrJO c2266JrJO = this.f11452AZxh;
        if (c2266JrJO != null) {
            return c2266JrJO.m9060ZfxDd();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        C3166XV c3166xv = this.f11454mjFkc;
        if (c3166xv != null) {
            return c3166xv.m10937wA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C3166XV c3166xv = this.f11454mjFkc;
        if (c3166xv != null) {
            return c3166xv.m10934ZfxDd();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f11455wA.m8751Dt();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f11455wA.m8752ETF();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().m10701wA(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2266JrJO c2266JrJO = this.f11452AZxh;
        if (c2266JrJO != null) {
            c2266JrJO.m9058JHa(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C2266JrJO c2266JrJO = this.f11452AZxh;
        if (c2266JrJO != null) {
            c2266JrJO.m9065xJ(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C3166XV c3166xv = this.f11454mjFkc;
        if (c3166xv != null) {
            c3166xv.m10932JHa();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C2171IVlxe c2171IVlxe = this.f11455wA;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8771qGY();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C2171IVlxe c2171IVlxe = this.f11455wA;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8771qGY();
        }
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().m10699ZfxDd(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().m10700mjFkc(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2266JrJO c2266JrJO = this.f11452AZxh;
        if (c2266JrJO != null) {
            c2266JrJO.m9063qdMbNW(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2266JrJO c2266JrJO = this.f11452AZxh;
        if (c2266JrJO != null) {
            c2266JrJO.m9056Dt(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C3166XV c3166xv = this.f11454mjFkc;
        if (c3166xv != null) {
            c3166xv.m10938xJ(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C3166XV c3166xv = this.f11454mjFkc;
        if (c3166xv != null) {
            c3166xv.m10935lgHUyS(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f11455wA.m8767huTpC(colorStateList);
        this.f11455wA.m8749AZxh();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f11455wA.m8753Gd(mode);
        this.f11455wA.m8749AZxh();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(AbstractC4768vjlshU.m13794AZxh(getContext(), i));
    }
}
