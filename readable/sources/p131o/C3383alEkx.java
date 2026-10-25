package p131o;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: o.alEkx */
/* loaded from: classes.dex */
public class C3383alEkx {

    /* renamed from: AZxh */
    public C4929y8 f12811AZxh;

    /* renamed from: KLFTb */
    public int f12812KLFTb = 0;

    /* renamed from: ZfxDd */
    public C4929y8 f12813ZfxDd;

    /* renamed from: mjFkc */
    public final ImageView f12814mjFkc;

    /* renamed from: wA */
    public C4929y8 f12815wA;

    public C3383alEkx(ImageView imageView) {
        this.f12814mjFkc = imageView;
    }

    /* renamed from: AZxh */
    public void m11397AZxh() {
        if (this.f12814mjFkc.getDrawable() != null) {
            this.f12814mjFkc.getDrawable().setLevel(this.f12812KLFTb);
        }
    }

    /* renamed from: Dt */
    public void m11398Dt(ColorStateList colorStateList) {
        if (this.f12815wA == null) {
            this.f12815wA = new C4929y8();
        }
        C4929y8 c4929y8 = this.f12815wA;
        c4929y8.f17480mjFkc = colorStateList;
        c4929y8.f17479ZfxDd = true;
        m11407wA();
    }

    /* renamed from: ETF */
    public void m11399ETF(PorterDuff.Mode mode) {
        if (this.f12815wA == null) {
            this.f12815wA = new C4929y8();
        }
        C4929y8 c4929y8 = this.f12815wA;
        c4929y8.f17478AZxh = mode;
        c4929y8.f17481wA = true;
        m11407wA();
    }

    /* renamed from: JHa */
    public boolean m11400JHa() {
        return !(this.f12814mjFkc.getBackground() instanceof RippleDrawable);
    }

    /* renamed from: KLFTb */
    public PorterDuff.Mode m11401KLFTb() {
        C4929y8 c4929y8 = this.f12815wA;
        if (c4929y8 != null) {
            return c4929y8.f17478AZxh;
        }
        return null;
    }

    /* renamed from: VA */
    public final boolean m11402VA() {
        return this.f12811AZxh != null;
    }

    /* renamed from: ZfxDd */
    public ColorStateList m11403ZfxDd() {
        C4929y8 c4929y8 = this.f12815wA;
        if (c4929y8 != null) {
            return c4929y8.f17480mjFkc;
        }
        return null;
    }

    /* renamed from: lgHUyS */
    public void m11404lgHUyS(Drawable drawable) {
        this.f12812KLFTb = drawable.getLevel();
    }

    /* renamed from: mjFkc */
    public final boolean m11405mjFkc(Drawable drawable) {
        if (this.f12813ZfxDd == null) {
            this.f12813ZfxDd = new C4929y8();
        }
        C4929y8 c4929y8 = this.f12813ZfxDd;
        c4929y8.m13995mjFkc();
        ColorStateList colorStateListM8813mjFkc = AbstractC2203J.m8813mjFkc(this.f12814mjFkc);
        if (colorStateListM8813mjFkc != null) {
            c4929y8.f17479ZfxDd = true;
            c4929y8.f17480mjFkc = colorStateListM8813mjFkc;
        }
        PorterDuff.Mode modeM8811AZxh = AbstractC2203J.m8811AZxh(this.f12814mjFkc);
        if (modeM8811AZxh != null) {
            c4929y8.f17481wA = true;
            c4929y8.f17478AZxh = modeM8811AZxh;
        }
        if (!c4929y8.f17479ZfxDd && !c4929y8.f17481wA) {
            return false;
        }
        C3442bbzow.m11536xJ(drawable, c4929y8, this.f12814mjFkc.getDrawableState());
        return true;
    }

    /* renamed from: qdMbNW */
    public void m11406qdMbNW(int i) {
        if (i != 0) {
            Drawable drawableM13794AZxh = AbstractC4768vjlshU.m13794AZxh(this.f12814mjFkc.getContext(), i);
            if (drawableM13794AZxh != null) {
                AbstractC3397awnh.m11432AZxh(drawableM13794AZxh);
            }
            this.f12814mjFkc.setImageDrawable(drawableM13794AZxh);
        } else {
            this.f12814mjFkc.setImageDrawable(null);
        }
        m11407wA();
    }

    /* renamed from: wA */
    public void m11407wA() {
        Drawable drawable = this.f12814mjFkc.getDrawable();
        if (drawable != null) {
            AbstractC3397awnh.m11432AZxh(drawable);
        }
        if (drawable != null) {
            if (m11402VA() && m11405mjFkc(drawable)) {
                return;
            }
            C4929y8 c4929y8 = this.f12815wA;
            if (c4929y8 != null) {
                C3442bbzow.m11536xJ(drawable, c4929y8, this.f12814mjFkc.getDrawableState());
                return;
            }
            C4929y8 c4929y82 = this.f12811AZxh;
            if (c4929y82 != null) {
                C3442bbzow.m11536xJ(drawable, c4929y82, this.f12814mjFkc.getDrawableState());
            }
        }
    }

    /* renamed from: xJ */
    public void m11408xJ(AttributeSet attributeSet, int i) {
        int iM7581MiMN;
        C1606A8 c1606a8M7575diqgf = C1606A8.m7575diqgf(this.f12814mjFkc.getContext(), attributeSet, AbstractC3407b5.f12906OjSQV, i, 0);
        ImageView imageView = this.f12814mjFkc;
        AbstractC2876T9.m10277jm(imageView, imageView.getContext(), AbstractC3407b5.f12906OjSQV, attributeSet, c1606a8M7575diqgf.m7589qGY(), i, 0);
        try {
            Drawable drawable = this.f12814mjFkc.getDrawable();
            if (drawable == null && (iM7581MiMN = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12905Ne, -1)) != -1 && (drawable = AbstractC4768vjlshU.m13794AZxh(this.f12814mjFkc.getContext(), iM7581MiMN)) != null) {
                this.f12814mjFkc.setImageDrawable(drawable);
            }
            if (drawable != null) {
                AbstractC3397awnh.m11432AZxh(drawable);
            }
            if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f12857CqaNbM)) {
                AbstractC2203J.m8814wA(this.f12814mjFkc, c1606a8M7575diqgf.m7592wA(AbstractC3407b5.f12857CqaNbM));
            }
            if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f13039xrEuO)) {
                AbstractC2203J.m8812ZfxDd(this.f12814mjFkc, AbstractC3397awnh.m11433ZfxDd(c1606a8M7575diqgf.m7577Dt(AbstractC3407b5.f13039xrEuO, -1), null));
            }
            c1606a8M7575diqgf.m7585eyqo();
        } catch (Throwable th) {
            c1606a8M7575diqgf.m7585eyqo();
            throw th;
        }
    }
}
