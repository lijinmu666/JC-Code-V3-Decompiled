package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* renamed from: o.ANMGZc */
/* loaded from: classes.dex */
public class C1622ANMGZc extends ImageButton {

    /* renamed from: AZxh */
    public final C3383alEkx f7354AZxh;

    /* renamed from: mjFkc */
    public final C2266JrJO f7355mjFkc;

    /* renamed from: wA */
    public boolean f7356wA;

    public C1622ANMGZc(Context context, AttributeSet attributeSet, int i) {
        super(C4861x8.m13900AZxh(context), attributeSet, i);
        this.f7356wA = false;
        AbstractC4326p8.m13067mjFkc(this, getContext());
        C2266JrJO c2266JrJO = new C2266JrJO(this);
        this.f7355mjFkc = c2266JrJO;
        c2266JrJO.m9059KLFTb(attributeSet, i);
        C3383alEkx c3383alEkx = new C3383alEkx(this);
        this.f7354AZxh = c3383alEkx;
        c3383alEkx.m11408xJ(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C2266JrJO c2266JrJO = this.f7355mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9055AZxh();
        }
        C3383alEkx c3383alEkx = this.f7354AZxh;
        if (c3383alEkx != null) {
            c3383alEkx.m11407wA();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C2266JrJO c2266JrJO = this.f7355mjFkc;
        if (c2266JrJO != null) {
            return c2266JrJO.m9064wA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C2266JrJO c2266JrJO = this.f7355mjFkc;
        if (c2266JrJO != null) {
            return c2266JrJO.m9060ZfxDd();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C3383alEkx c3383alEkx = this.f7354AZxh;
        if (c3383alEkx != null) {
            return c3383alEkx.m11403ZfxDd();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C3383alEkx c3383alEkx = this.f7354AZxh;
        if (c3383alEkx != null) {
            return c3383alEkx.m11401KLFTb();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f7354AZxh.m11400JHa() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2266JrJO c2266JrJO = this.f7355mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9058JHa(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C2266JrJO c2266JrJO = this.f7355mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9065xJ(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C3383alEkx c3383alEkx = this.f7354AZxh;
        if (c3383alEkx != null) {
            c3383alEkx.m11407wA();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C3383alEkx c3383alEkx = this.f7354AZxh;
        if (c3383alEkx != null && drawable != null && !this.f7356wA) {
            c3383alEkx.m11404lgHUyS(drawable);
        }
        super.setImageDrawable(drawable);
        C3383alEkx c3383alEkx2 = this.f7354AZxh;
        if (c3383alEkx2 != null) {
            c3383alEkx2.m11407wA();
            if (this.f7356wA) {
                return;
            }
            this.f7354AZxh.m11397AZxh();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.f7356wA = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.f7354AZxh.m11406qdMbNW(i);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C3383alEkx c3383alEkx = this.f7354AZxh;
        if (c3383alEkx != null) {
            c3383alEkx.m11407wA();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2266JrJO c2266JrJO = this.f7355mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9063qdMbNW(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2266JrJO c2266JrJO = this.f7355mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9056Dt(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C3383alEkx c3383alEkx = this.f7354AZxh;
        if (c3383alEkx != null) {
            c3383alEkx.m11398Dt(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C3383alEkx c3383alEkx = this.f7354AZxh;
        if (c3383alEkx != null) {
            c3383alEkx.m11399ETF(mode);
        }
    }
}
