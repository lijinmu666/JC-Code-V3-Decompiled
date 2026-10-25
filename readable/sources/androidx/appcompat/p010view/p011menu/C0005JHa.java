package androidx.appcompat.p010view.p011menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.p010view.p011menu.InterfaceC0012xJ;
import p131o.AbstractC2876T9;
import p131o.AbstractC3203Y1;
import p131o.AbstractC4056l;
import p131o.AbstractC4256o4;

/* renamed from: androidx.appcompat.view.menu.JHa */
/* loaded from: classes.dex */
public class C0005JHa {

    /* renamed from: AZxh */
    public final C0007ZfxDd f260AZxh;

    /* renamed from: Dt */
    public AbstractC3203Y1 f261Dt;

    /* renamed from: ETF */
    public PopupWindow.OnDismissListener f262ETF;

    /* renamed from: JHa */
    public View f263JHa;

    /* renamed from: KLFTb */
    public final int f264KLFTb;

    /* renamed from: VA */
    public final PopupWindow.OnDismissListener f265VA;

    /* renamed from: ZfxDd */
    public final int f266ZfxDd;

    /* renamed from: lgHUyS */
    public boolean f267lgHUyS;

    /* renamed from: mjFkc */
    public final Context f268mjFkc;

    /* renamed from: qdMbNW */
    public InterfaceC0012xJ.mjFkc f269qdMbNW;

    /* renamed from: wA */
    public final boolean f270wA;

    /* renamed from: xJ */
    public int f271xJ;

    /* renamed from: androidx.appcompat.view.menu.JHa$AZxh */
    public static class AZxh {
        /* renamed from: mjFkc */
        public static void m70mjFkc(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.JHa$mjFkc */
    public class mjFkc implements PopupWindow.OnDismissListener {
        public mjFkc() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            C0005JHa.this.mo60KLFTb();
        }
    }

    public C0005JHa(Context context, C0007ZfxDd c0007ZfxDd, View view, boolean z, int i) {
        this(context, c0007ZfxDd, view, z, i, 0);
    }

    /* renamed from: AZxh */
    public void m56AZxh() {
        if (m64ZfxDd()) {
            this.f261Dt.mo21ZfxDd();
        }
    }

    /* renamed from: Dt */
    public void m57Dt(InterfaceC0012xJ.mjFkc mjfkc) {
        this.f269qdMbNW = mjfkc;
        AbstractC3203Y1 abstractC3203Y1 = this.f261Dt;
        if (abstractC3203Y1 != null) {
            abstractC3203Y1.mo18VA(mjfkc);
        }
    }

    /* renamed from: ETF */
    public void m58ETF() {
        if (!m61MiMN()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* renamed from: JHa */
    public void m59JHa(View view) {
        this.f263JHa = view;
    }

    /* renamed from: KLFTb */
    public void mo60KLFTb() {
        this.f261Dt = null;
        PopupWindow.OnDismissListener onDismissListener = this.f262ETF;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    /* renamed from: MiMN */
    public boolean m61MiMN() {
        if (m64ZfxDd()) {
            return true;
        }
        if (this.f263JHa == null) {
            return false;
        }
        m62VA(0, 0, false, false);
        return true;
    }

    /* renamed from: VA */
    public final void m62VA(int i, int i2, boolean z, boolean z2) {
        AbstractC3203Y1 abstractC3203Y1M68wA = m68wA();
        abstractC3203Y1M68wA.mo25huTpC(z2);
        if (z) {
            if ((AbstractC4056l.m12647AZxh(this.f271xJ, AbstractC2876T9.m10276huTpC(this.f263JHa)) & 7) == 5) {
                i -= this.f263JHa.getWidth();
            }
            abstractC3203Y1M68wA.mo23eyqo(i);
            abstractC3203Y1M68wA.mo10Gd(i2);
            int i3 = (int) ((this.f268mjFkc.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            abstractC3203Y1M68wA.m11041IEE(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        abstractC3203Y1M68wA.mo29mjFkc();
    }

    /* renamed from: YoKzxo */
    public boolean m63YoKzxo(int i, int i2) {
        if (m64ZfxDd()) {
            return true;
        }
        if (this.f263JHa == null) {
            return false;
        }
        m62VA(i, i2, true, true);
        return true;
    }

    /* renamed from: ZfxDd */
    public boolean m64ZfxDd() {
        AbstractC3203Y1 abstractC3203Y1 = this.f261Dt;
        return abstractC3203Y1 != null && abstractC3203Y1.mo9Dt();
    }

    /* renamed from: lgHUyS */
    public void m65lgHUyS(int i) {
        this.f271xJ = i;
    }

    /* renamed from: mjFkc */
    public final AbstractC3203Y1 m66mjFkc() {
        Display defaultDisplay = ((WindowManager) this.f268mjFkc.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        AZxh.m70mjFkc(defaultDisplay, point);
        AbstractC3203Y1 viewOnKeyListenerC0001AZxh = Math.min(point.x, point.y) >= this.f268mjFkc.getResources().getDimensionPixelSize(AbstractC4256o4.f15502mjFkc) ? new ViewOnKeyListenerC0001AZxh(this.f268mjFkc, this.f263JHa, this.f266ZfxDd, this.f264KLFTb, this.f270wA) : new ViewOnKeyListenerC0010qdMbNW(this.f268mjFkc, this.f260AZxh, this.f263JHa, this.f266ZfxDd, this.f264KLFTb, this.f270wA);
        viewOnKeyListenerC0001AZxh.mo13MiMN(this.f260AZxh);
        viewOnKeyListenerC0001AZxh.mo17Ucbh(this.f265VA);
        viewOnKeyListenerC0001AZxh.mo24fehf(this.f263JHa);
        viewOnKeyListenerC0001AZxh.mo18VA(this.f269qdMbNW);
        viewOnKeyListenerC0001AZxh.mo16Pq(this.f267lgHUyS);
        viewOnKeyListenerC0001AZxh.mo22diqgf(this.f271xJ);
        return viewOnKeyListenerC0001AZxh;
    }

    /* renamed from: qdMbNW */
    public void m67qdMbNW(PopupWindow.OnDismissListener onDismissListener) {
        this.f262ETF = onDismissListener;
    }

    /* renamed from: wA */
    public AbstractC3203Y1 m68wA() {
        if (this.f261Dt == null) {
            this.f261Dt = m66mjFkc();
        }
        return this.f261Dt;
    }

    /* renamed from: xJ */
    public void m69xJ(boolean z) {
        this.f267lgHUyS = z;
        AbstractC3203Y1 abstractC3203Y1 = this.f261Dt;
        if (abstractC3203Y1 != null) {
            abstractC3203Y1.mo16Pq(z);
        }
    }

    public C0005JHa(Context context, C0007ZfxDd c0007ZfxDd, View view, boolean z, int i, int i2) {
        this.f271xJ = 8388611;
        this.f265VA = new mjFkc();
        this.f268mjFkc = context;
        this.f260AZxh = c0007ZfxDd;
        this.f263JHa = view;
        this.f270wA = z;
        this.f266ZfxDd = i;
        this.f264KLFTb = i2;
    }
}
