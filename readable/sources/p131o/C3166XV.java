package p131o;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* renamed from: o.XV */
/* loaded from: classes.dex */
public class C3166XV {

    /* renamed from: JHa */
    public boolean f11621JHa;

    /* renamed from: mjFkc */
    public final CompoundButton f11624mjFkc;

    /* renamed from: AZxh */
    public ColorStateList f11620AZxh = null;

    /* renamed from: wA */
    public PorterDuff.Mode f11625wA = null;

    /* renamed from: ZfxDd */
    public boolean f11623ZfxDd = false;

    /* renamed from: KLFTb */
    public boolean f11622KLFTb = false;

    public C3166XV(CompoundButton compoundButton) {
        this.f11624mjFkc = compoundButton;
    }

    /* renamed from: AZxh */
    public int m10931AZxh(int i) {
        return i;
    }

    /* renamed from: JHa */
    public void m10932JHa() {
        if (this.f11621JHa) {
            this.f11621JHa = false;
        } else {
            this.f11621JHa = true;
            m10936mjFkc();
        }
    }

    /* renamed from: KLFTb */
    public void m10933KLFTb(AttributeSet attributeSet, int i) {
        int iM7581MiMN;
        int iM7581MiMN2;
        C1606A8 c1606a8M7575diqgf = C1606A8.m7575diqgf(this.f11624mjFkc.getContext(), attributeSet, AbstractC3407b5.f12900Moer, i, 0);
        CompoundButton compoundButton = this.f11624mjFkc;
        AbstractC2876T9.m10277jm(compoundButton, compoundButton.getContext(), AbstractC3407b5.f12900Moer, attributeSet, c1606a8M7575diqgf.m7589qGY(), i, 0);
        try {
            if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f12918SOS) && (iM7581MiMN2 = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12918SOS, 0)) != 0) {
                try {
                    CompoundButton compoundButton2 = this.f11624mjFkc;
                    compoundButton2.setButtonDrawable(AbstractC4768vjlshU.m13794AZxh(compoundButton2.getContext(), iM7581MiMN2));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f12919SmIWf) && (iM7581MiMN = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12919SmIWf, 0)) != 0) {
                CompoundButton compoundButton3 = this.f11624mjFkc;
                compoundButton3.setButtonDrawable(AbstractC4768vjlshU.m13794AZxh(compoundButton3.getContext(), iM7581MiMN));
            }
            if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f12910Qr)) {
                AbstractC2424MFekjo.m9494AZxh(this.f11624mjFkc, c1606a8M7575diqgf.m7592wA(AbstractC3407b5.f12910Qr));
            }
            if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f12902NKyg)) {
                AbstractC2424MFekjo.m9496wA(this.f11624mjFkc, AbstractC3397awnh.m11433ZfxDd(c1606a8M7575diqgf.m7577Dt(AbstractC3407b5.f12902NKyg, -1), null));
            }
        } finally {
            c1606a8M7575diqgf.m7585eyqo();
        }
    }

    /* renamed from: ZfxDd */
    public PorterDuff.Mode m10934ZfxDd() {
        return this.f11625wA;
    }

    /* renamed from: lgHUyS */
    public void m10935lgHUyS(PorterDuff.Mode mode) {
        this.f11625wA = mode;
        this.f11622KLFTb = true;
        m10936mjFkc();
    }

    /* renamed from: mjFkc */
    public void m10936mjFkc() {
        Drawable drawableM9495mjFkc = AbstractC2424MFekjo.m9495mjFkc(this.f11624mjFkc);
        if (drawableM9495mjFkc != null) {
            if (this.f11623ZfxDd || this.f11622KLFTb) {
                Drawable drawableMutate = AbstractC4332pCk.m13077VA(drawableM9495mjFkc).mutate();
                if (this.f11623ZfxDd) {
                    AbstractC4332pCk.m13081qdMbNW(drawableMutate, this.f11620AZxh);
                }
                if (this.f11622KLFTb) {
                    AbstractC4332pCk.m13073Dt(drawableMutate, this.f11625wA);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f11624mjFkc.getDrawableState());
                }
                this.f11624mjFkc.setButtonDrawable(drawableMutate);
            }
        }
    }

    /* renamed from: wA */
    public ColorStateList m10937wA() {
        return this.f11620AZxh;
    }

    /* renamed from: xJ */
    public void m10938xJ(ColorStateList colorStateList) {
        this.f11620AZxh = colorStateList;
        this.f11623ZfxDd = true;
        m10936mjFkc();
    }
}
