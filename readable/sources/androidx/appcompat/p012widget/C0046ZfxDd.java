package androidx.appcompat.p012widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import p131o.AbstractC2545O4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3407b5;
import p131o.AbstractC3862i4;
import p131o.AbstractC4591t4;
import p131o.AbstractC4768vjlshU;
import p131o.C1606A8;
import p131o.C4807wJVbdd;
import p131o.InterfaceC3066VzXmn;

/* renamed from: androidx.appcompat.widget.ZfxDd */
/* loaded from: classes.dex */
public class C0046ZfxDd implements InterfaceC3066VzXmn {

    /* renamed from: AZxh */
    public int f616AZxh;

    /* renamed from: Dt */
    public CharSequence f617Dt;

    /* renamed from: ETF */
    public Window.Callback f618ETF;

    /* renamed from: JHa */
    public Drawable f619JHa;

    /* renamed from: KLFTb */
    public Drawable f620KLFTb;

    /* renamed from: MiMN */
    public int f621MiMN;

    /* renamed from: VA */
    public boolean f622VA;

    /* renamed from: YoKzxo */
    public int f623YoKzxo;

    /* renamed from: ZfxDd */
    public Drawable f624ZfxDd;

    /* renamed from: lgHUyS */
    public CharSequence f625lgHUyS;

    /* renamed from: mjFkc */
    public C0044Toolbar f626mjFkc;

    /* renamed from: qdMbNW */
    public CharSequence f627qdMbNW;

    /* renamed from: rkYL */
    public Drawable f628rkYL;

    /* renamed from: wA */
    public View f629wA;

    /* renamed from: xJ */
    public boolean f630xJ;

    /* renamed from: androidx.appcompat.widget.ZfxDd$mjFkc */
    public class mjFkc implements View.OnClickListener {

        /* renamed from: mjFkc */
        public final C4807wJVbdd f632mjFkc;

        public mjFkc() {
            this.f632mjFkc = new C4807wJVbdd(C0046ZfxDd.this.f626mjFkc.getContext(), 0, R.id.home, 0, 0, C0046ZfxDd.this.f625lgHUyS);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C0046ZfxDd c0046ZfxDd = C0046ZfxDd.this;
            Window.Callback callback = c0046ZfxDd.f618ETF;
            if (callback == null || !c0046ZfxDd.f622VA) {
                return;
            }
            callback.onMenuItemSelected(0, this.f632mjFkc);
        }
    }

    public C0046ZfxDd(C0044Toolbar c0044Toolbar, boolean z) {
        this(c0044Toolbar, z, AbstractC2545O4.f9912mjFkc, AbstractC4591t4.f16623YoKzxo);
    }

    @Override // p131o.InterfaceC3066VzXmn
    /* renamed from: AZxh */
    public void mo329AZxh(Window.Callback callback) {
        this.f618ETF = callback;
    }

    /* renamed from: Dt */
    public void m330Dt(int i) {
        m331ETF(i == 0 ? null : m334KLFTb().getString(i));
    }

    /* renamed from: ETF */
    public void m331ETF(CharSequence charSequence) {
        this.f617Dt = charSequence;
        m342qGY();
    }

    /* renamed from: IEE */
    public final void m332IEE() {
        Drawable drawable;
        int i = this.f616AZxh;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f620KLFTb) == null) {
            drawable = this.f624ZfxDd;
        }
        this.f626mjFkc.m313setLogo(drawable);
    }

    /* renamed from: JHa */
    public void m333JHa(View view) {
        View view2 = this.f629wA;
        if (view2 != null && (this.f616AZxh & 16) != 0) {
            this.f626mjFkc.removeView(view2);
        }
        this.f629wA = view;
        if (view == null || (this.f616AZxh & 16) == 0) {
            return;
        }
        this.f626mjFkc.addView(view);
    }

    /* renamed from: KLFTb */
    public Context m334KLFTb() {
        return this.f626mjFkc.getContext();
    }

    /* renamed from: MiMN */
    public void m335MiMN(CharSequence charSequence) {
        this.f627qdMbNW = charSequence;
        if ((this.f616AZxh & 8) != 0) {
            this.f626mjFkc.setSubtitle(charSequence);
        }
    }

    /* renamed from: VA */
    public void m336VA(Drawable drawable) {
        this.f619JHa = drawable;
        m339fehf();
    }

    /* renamed from: YoKzxo */
    public void m337YoKzxo(CharSequence charSequence) {
        this.f630xJ = true;
        m344rkYL(charSequence);
    }

    /* renamed from: ZfxDd */
    public final int m338ZfxDd() {
        if (this.f626mjFkc.getNavigationIcon() == null) {
            return 11;
        }
        this.f628rkYL = this.f626mjFkc.getNavigationIcon();
        return 15;
    }

    /* renamed from: fehf */
    public final void m339fehf() {
        if ((this.f616AZxh & 4) == 0) {
            this.f626mjFkc.setNavigationIcon((Drawable) null);
            return;
        }
        C0044Toolbar c0044Toolbar = this.f626mjFkc;
        Drawable drawable = this.f619JHa;
        if (drawable == null) {
            drawable = this.f628rkYL;
        }
        c0044Toolbar.setNavigationIcon(drawable);
    }

    @Override // p131o.InterfaceC3066VzXmn
    public CharSequence getTitle() {
        return this.f626mjFkc.getTitle();
    }

    /* renamed from: lgHUyS */
    public void m340lgHUyS(int i) {
        View view;
        int i2 = this.f616AZxh ^ i;
        this.f616AZxh = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m342qGY();
                }
                m339fehf();
            }
            if ((i2 & 3) != 0) {
                m332IEE();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f626mjFkc.setTitle(this.f625lgHUyS);
                    this.f626mjFkc.setSubtitle(this.f627qdMbNW);
                } else {
                    this.f626mjFkc.setTitle((CharSequence) null);
                    this.f626mjFkc.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.f629wA) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f626mjFkc.addView(view);
            } else {
                this.f626mjFkc.removeView(view);
            }
        }
    }

    @Override // p131o.InterfaceC3066VzXmn
    /* renamed from: mjFkc */
    public void mo341mjFkc(CharSequence charSequence) {
        if (this.f630xJ) {
            return;
        }
        m344rkYL(charSequence);
    }

    /* renamed from: qGY */
    public final void m342qGY() {
        if ((this.f616AZxh & 4) != 0) {
            if (TextUtils.isEmpty(this.f617Dt)) {
                this.f626mjFkc.setNavigationContentDescription(this.f623YoKzxo);
            } else {
                this.f626mjFkc.setNavigationContentDescription(this.f617Dt);
            }
        }
    }

    /* renamed from: qdMbNW */
    public void m343qdMbNW(Drawable drawable) {
        this.f620KLFTb = drawable;
        m332IEE();
    }

    /* renamed from: rkYL */
    public final void m344rkYL(CharSequence charSequence) {
        this.f625lgHUyS = charSequence;
        if ((this.f616AZxh & 8) != 0) {
            this.f626mjFkc.setTitle(charSequence);
            if (this.f630xJ) {
                AbstractC2876T9.m10301yfx(this.f626mjFkc.getRootView(), charSequence);
            }
        }
    }

    @Override // p131o.InterfaceC3066VzXmn
    /* renamed from: setIcon */
    public void mo345setIcon(int i) {
        mo346setIcon(i != 0 ? AbstractC4768vjlshU.m13794AZxh(m334KLFTb(), i) : null);
    }

    @Override // p131o.InterfaceC3066VzXmn
    /* renamed from: wA */
    public void mo347wA(int i) {
        m343qdMbNW(i != 0 ? AbstractC4768vjlshU.m13794AZxh(m334KLFTb(), i) : null);
    }

    /* renamed from: xJ */
    public void m348xJ(int i) {
        if (i == this.f623YoKzxo) {
            return;
        }
        this.f623YoKzxo = i;
        if (TextUtils.isEmpty(this.f626mjFkc.getNavigationContentDescription())) {
            m330Dt(this.f623YoKzxo);
        }
    }

    public C0046ZfxDd(C0044Toolbar c0044Toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.f621MiMN = 0;
        this.f623YoKzxo = 0;
        this.f626mjFkc = c0044Toolbar;
        this.f625lgHUyS = c0044Toolbar.getTitle();
        this.f627qdMbNW = c0044Toolbar.getSubtitle();
        this.f630xJ = this.f625lgHUyS != null;
        this.f619JHa = c0044Toolbar.getNavigationIcon();
        C1606A8 c1606a8M7575diqgf = C1606A8.m7575diqgf(c0044Toolbar.getContext(), null, AbstractC3407b5.f12991mjFkc, AbstractC3862i4.f14120wA, 0);
        this.f628rkYL = c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f12859Dt);
        if (z) {
            CharSequence charSequenceM7591rkYL = c1606a8M7575diqgf.m7591rkYL(AbstractC3407b5.f13002qGY);
            if (!TextUtils.isEmpty(charSequenceM7591rkYL)) {
                m337YoKzxo(charSequenceM7591rkYL);
            }
            CharSequence charSequenceM7591rkYL2 = c1606a8M7575diqgf.m7591rkYL(AbstractC3407b5.f12948YoKzxo);
            if (!TextUtils.isEmpty(charSequenceM7591rkYL2)) {
                m335MiMN(charSequenceM7591rkYL2);
            }
            Drawable drawableM7593xJ = c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f12929VA);
            if (drawableM7593xJ != null) {
                m343qdMbNW(drawableM7593xJ);
            }
            Drawable drawableM7593xJ2 = c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f12861ETF);
            if (drawableM7593xJ2 != null) {
                mo346setIcon(drawableM7593xJ2);
            }
            if (this.f619JHa == null && (drawable = this.f628rkYL) != null) {
                m336VA(drawable);
            }
            m340lgHUyS(c1606a8M7575diqgf.m7577Dt(AbstractC3407b5.f12987lgHUyS, 0));
            int iM7581MiMN = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f13034xJ, 0);
            if (iM7581MiMN != 0) {
                m333JHa(LayoutInflater.from(this.f626mjFkc.getContext()).inflate(iM7581MiMN, (ViewGroup) this.f626mjFkc, false));
                m340lgHUyS(this.f616AZxh | 16);
            }
            int iM7582VA = c1606a8M7575diqgf.m7582VA(AbstractC3407b5.f13004qdMbNW, 0);
            if (iM7582VA > 0) {
                ViewGroup.LayoutParams layoutParams = this.f626mjFkc.getLayoutParams();
                layoutParams.height = iM7582VA;
                this.f626mjFkc.setLayoutParams(layoutParams);
            }
            int iM7580KLFTb = c1606a8M7575diqgf.m7580KLFTb(AbstractC3407b5.f12881JHa, -1);
            int iM7580KLFTb2 = c1606a8M7575diqgf.m7580KLFTb(AbstractC3407b5.f12888KLFTb, -1);
            if (iM7580KLFTb >= 0 || iM7580KLFTb2 >= 0) {
                this.f626mjFkc.m291OjSQV(Math.max(iM7580KLFTb, 0), Math.max(iM7580KLFTb2, 0));
            }
            int iM7581MiMN2 = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12969fehf, 0);
            if (iM7581MiMN2 != 0) {
                C0044Toolbar c0044Toolbar2 = this.f626mjFkc;
                c0044Toolbar2.m280CqaNbM(c0044Toolbar2.getContext(), iM7581MiMN2);
            }
            int iM7581MiMN3 = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f13009rkYL, 0);
            if (iM7581MiMN3 != 0) {
                C0044Toolbar c0044Toolbar3 = this.f626mjFkc;
                c0044Toolbar3.m290Ne(c0044Toolbar3.getContext(), iM7581MiMN3);
            }
            int iM7581MiMN4 = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12899MiMN, 0);
            if (iM7581MiMN4 != 0) {
                this.f626mjFkc.setPopupTheme(iM7581MiMN4);
            }
        } else {
            this.f616AZxh = m338ZfxDd();
        }
        c1606a8M7575diqgf.m7585eyqo();
        m348xJ(i);
        this.f617Dt = this.f626mjFkc.getNavigationContentDescription();
        this.f626mjFkc.setNavigationOnClickListener(new mjFkc());
    }

    @Override // p131o.InterfaceC3066VzXmn
    /* renamed from: setIcon */
    public void mo346setIcon(Drawable drawable) {
        this.f624ZfxDd = drawable;
        m332IEE();
    }
}
