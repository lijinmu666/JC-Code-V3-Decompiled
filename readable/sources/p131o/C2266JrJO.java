package p131o;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: o.JrJO */
/* loaded from: classes.dex */
public class C2266JrJO {

    /* renamed from: JHa */
    public C4929y8 f9053JHa;

    /* renamed from: KLFTb */
    public C4929y8 f9054KLFTb;

    /* renamed from: ZfxDd */
    public C4929y8 f9055ZfxDd;

    /* renamed from: mjFkc */
    public final View f9056mjFkc;

    /* renamed from: wA */
    public int f9057wA = -1;

    /* renamed from: AZxh */
    public final C3442bbzow f9052AZxh = C3442bbzow.m11532AZxh();

    public C2266JrJO(View view) {
        this.f9056mjFkc = view;
    }

    /* renamed from: AZxh */
    public void m9055AZxh() {
        Drawable background = this.f9056mjFkc.getBackground();
        if (background != null) {
            if (m9057ETF() && m9062mjFkc(background)) {
                return;
            }
            C4929y8 c4929y8 = this.f9054KLFTb;
            if (c4929y8 != null) {
                C3442bbzow.m11536xJ(background, c4929y8, this.f9056mjFkc.getDrawableState());
                return;
            }
            C4929y8 c4929y82 = this.f9055ZfxDd;
            if (c4929y82 != null) {
                C3442bbzow.m11536xJ(background, c4929y82, this.f9056mjFkc.getDrawableState());
            }
        }
    }

    /* renamed from: Dt */
    public void m9056Dt(PorterDuff.Mode mode) {
        if (this.f9054KLFTb == null) {
            this.f9054KLFTb = new C4929y8();
        }
        C4929y8 c4929y8 = this.f9054KLFTb;
        c4929y8.f17478AZxh = mode;
        c4929y8.f17481wA = true;
        m9055AZxh();
    }

    /* renamed from: ETF */
    public final boolean m9057ETF() {
        return this.f9055ZfxDd != null;
    }

    /* renamed from: JHa */
    public void m9058JHa(Drawable drawable) {
        this.f9057wA = -1;
        m9061lgHUyS(null);
        m9055AZxh();
    }

    /* renamed from: KLFTb */
    public void m9059KLFTb(AttributeSet attributeSet, int i) {
        C1606A8 c1606a8M7575diqgf = C1606A8.m7575diqgf(this.f9056mjFkc.getContext(), attributeSet, AbstractC3407b5.f12864Es, i, 0);
        View view = this.f9056mjFkc;
        AbstractC2876T9.m10277jm(view, view.getContext(), AbstractC3407b5.f12864Es, attributeSet, c1606a8M7575diqgf.m7589qGY(), i, 0);
        try {
            if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f12949ZGL)) {
                this.f9057wA = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12949ZGL, -1);
                ColorStateList colorStateListM11537KLFTb = this.f9052AZxh.m11537KLFTb(this.f9056mjFkc.getContext(), this.f9057wA);
                if (colorStateListM11537KLFTb != null) {
                    m9061lgHUyS(colorStateListM11537KLFTb);
                }
            }
            if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f12980jpz)) {
                AbstractC2876T9.m10298xROA(this.f9056mjFkc, c1606a8M7575diqgf.m7592wA(AbstractC3407b5.f12980jpz));
            }
            if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f12964eEOGOh)) {
                AbstractC2876T9.m10232IVlxe(this.f9056mjFkc, AbstractC3397awnh.m11433ZfxDd(c1606a8M7575diqgf.m7577Dt(AbstractC3407b5.f12964eEOGOh, -1), null));
            }
            c1606a8M7575diqgf.m7585eyqo();
        } catch (Throwable th) {
            c1606a8M7575diqgf.m7585eyqo();
            throw th;
        }
    }

    /* renamed from: ZfxDd */
    public PorterDuff.Mode m9060ZfxDd() {
        C4929y8 c4929y8 = this.f9054KLFTb;
        if (c4929y8 != null) {
            return c4929y8.f17478AZxh;
        }
        return null;
    }

    /* renamed from: lgHUyS */
    public void m9061lgHUyS(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f9055ZfxDd == null) {
                this.f9055ZfxDd = new C4929y8();
            }
            C4929y8 c4929y8 = this.f9055ZfxDd;
            c4929y8.f17480mjFkc = colorStateList;
            c4929y8.f17479ZfxDd = true;
        } else {
            this.f9055ZfxDd = null;
        }
        m9055AZxh();
    }

    /* renamed from: mjFkc */
    public final boolean m9062mjFkc(Drawable drawable) {
        if (this.f9053JHa == null) {
            this.f9053JHa = new C4929y8();
        }
        C4929y8 c4929y8 = this.f9053JHa;
        c4929y8.m13995mjFkc();
        ColorStateList colorStateListM10263YoKzxo = AbstractC2876T9.m10263YoKzxo(this.f9056mjFkc);
        if (colorStateListM10263YoKzxo != null) {
            c4929y8.f17479ZfxDd = true;
            c4929y8.f17480mjFkc = colorStateListM10263YoKzxo;
        }
        PorterDuff.Mode modeM10288rkYL = AbstractC2876T9.m10288rkYL(this.f9056mjFkc);
        if (modeM10288rkYL != null) {
            c4929y8.f17481wA = true;
            c4929y8.f17478AZxh = modeM10288rkYL;
        }
        if (!c4929y8.f17479ZfxDd && !c4929y8.f17481wA) {
            return false;
        }
        C3442bbzow.m11536xJ(drawable, c4929y8, this.f9056mjFkc.getDrawableState());
        return true;
    }

    /* renamed from: qdMbNW */
    public void m9063qdMbNW(ColorStateList colorStateList) {
        if (this.f9054KLFTb == null) {
            this.f9054KLFTb = new C4929y8();
        }
        C4929y8 c4929y8 = this.f9054KLFTb;
        c4929y8.f17480mjFkc = colorStateList;
        c4929y8.f17479ZfxDd = true;
        m9055AZxh();
    }

    /* renamed from: wA */
    public ColorStateList m9064wA() {
        C4929y8 c4929y8 = this.f9054KLFTb;
        if (c4929y8 != null) {
            return c4929y8.f17480mjFkc;
        }
        return null;
    }

    /* renamed from: xJ */
    public void m9065xJ(int i) {
        this.f9057wA = i;
        C3442bbzow c3442bbzow = this.f9052AZxh;
        m9061lgHUyS(c3442bbzow != null ? c3442bbzow.m11537KLFTb(this.f9056mjFkc.getContext(), i) : null);
        m9055AZxh();
    }
}
