package androidx.appcompat.p010view.p011menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.p010view.p011menu.InterfaceC0012xJ;
import p131o.AbstractC2139I4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3203Y1;
import p131o.AbstractC4256o4;
import p131o.C3269Z1;

/* renamed from: androidx.appcompat.view.menu.qdMbNW */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC0010qdMbNW extends AbstractC3203Y1 implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, InterfaceC0012xJ, View.OnKeyListener {

    /* renamed from: Ucbh */
    public static final int f356Ucbh = AbstractC2139I4.f8668Dt;

    /* renamed from: AZxh */
    public final Context f357AZxh;

    /* renamed from: IEE */
    public boolean f360IEE;

    /* renamed from: JHa */
    public final int f361JHa;

    /* renamed from: KLFTb */
    public final boolean f362KLFTb;

    /* renamed from: MiMN */
    public View f363MiMN;

    /* renamed from: Pq */
    public int f364Pq;

    /* renamed from: VA */
    public PopupWindow.OnDismissListener f365VA;

    /* renamed from: YoKzxo */
    public View f366YoKzxo;

    /* renamed from: ZfxDd */
    public final C0011wA f367ZfxDd;

    /* renamed from: eyqo */
    public boolean f369eyqo;

    /* renamed from: fehf */
    public boolean f370fehf;

    /* renamed from: lgHUyS */
    public final int f371lgHUyS;

    /* renamed from: qGY */
    public ViewTreeObserver f372qGY;

    /* renamed from: qdMbNW */
    public final C3269Z1 f373qdMbNW;

    /* renamed from: rkYL */
    public InterfaceC0012xJ.mjFkc f374rkYL;

    /* renamed from: wA */
    public final C0007ZfxDd f375wA;

    /* renamed from: xJ */
    public final int f376xJ;

    /* renamed from: Dt */
    public final ViewTreeObserver.OnGlobalLayoutListener f358Dt = new mjFkc();

    /* renamed from: ETF */
    public final View.OnAttachStateChangeListener f359ETF = new AZxh();

    /* renamed from: diqgf */
    public int f368diqgf = 0;

    /* renamed from: androidx.appcompat.view.menu.qdMbNW$AZxh */
    public class AZxh implements View.OnAttachStateChangeListener {
        public AZxh() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = ViewOnKeyListenerC0010qdMbNW.this.f372qGY;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    ViewOnKeyListenerC0010qdMbNW.this.f372qGY = view.getViewTreeObserver();
                }
                ViewOnKeyListenerC0010qdMbNW viewOnKeyListenerC0010qdMbNW = ViewOnKeyListenerC0010qdMbNW.this;
                viewOnKeyListenerC0010qdMbNW.f372qGY.removeGlobalOnLayoutListener(viewOnKeyListenerC0010qdMbNW.f358Dt);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.qdMbNW$mjFkc */
    public class mjFkc implements ViewTreeObserver.OnGlobalLayoutListener {
        public mjFkc() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!ViewOnKeyListenerC0010qdMbNW.this.mo9Dt() || ViewOnKeyListenerC0010qdMbNW.this.f373qdMbNW.m11263rkYL()) {
                return;
            }
            View view = ViewOnKeyListenerC0010qdMbNW.this.f366YoKzxo;
            if (view == null || !view.isShown()) {
                ViewOnKeyListenerC0010qdMbNW.this.mo21ZfxDd();
            } else {
                ViewOnKeyListenerC0010qdMbNW.this.f373qdMbNW.mo29mjFkc();
            }
        }
    }

    public ViewOnKeyListenerC0010qdMbNW(Context context, C0007ZfxDd c0007ZfxDd, View view, int i, int i2, boolean z) {
        this.f357AZxh = context;
        this.f375wA = c0007ZfxDd;
        this.f362KLFTb = z;
        this.f367ZfxDd = new C0011wA(c0007ZfxDd, LayoutInflater.from(context), z, f356Ucbh);
        this.f376xJ = i;
        this.f371lgHUyS = i2;
        Resources resources = context.getResources();
        this.f361JHa = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(AbstractC4256o4.f15497AZxh));
        this.f363MiMN = view;
        this.f373qdMbNW = new C3269Z1(context, null, i, i2);
        c0007ZfxDd.m107AZxh(this, context);
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: AZxh */
    public void mo7AZxh(C0007ZfxDd c0007ZfxDd, boolean z) {
        if (c0007ZfxDd != this.f375wA) {
            return;
        }
        mo21ZfxDd();
        InterfaceC0012xJ.mjFkc mjfkc = this.f374rkYL;
        if (mjfkc != null) {
            mjfkc.mo162AZxh(c0007ZfxDd, z);
        }
    }

    @Override // p131o.InterfaceC2674Q6
    /* renamed from: Dt */
    public boolean mo9Dt() {
        return !this.f370fehf && this.f373qdMbNW.mo9Dt();
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: Gd */
    public void mo10Gd(int i) {
        this.f373qdMbNW.m11265wJVbdd(i);
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: JHa */
    public boolean mo11JHa(SubMenuC0004Dt subMenuC0004Dt) {
        if (subMenuC0004Dt.hasVisibleItems()) {
            C0005JHa c0005JHa = new C0005JHa(this.f357AZxh, subMenuC0004Dt, this.f366YoKzxo, this.f362KLFTb, this.f376xJ, this.f371lgHUyS);
            c0005JHa.m57Dt(this.f374rkYL);
            c0005JHa.m69xJ(AbstractC3203Y1.m11038HGpJ(subMenuC0004Dt));
            c0005JHa.m67qdMbNW(this.f365VA);
            this.f365VA = null;
            this.f375wA.m126ZfxDd(false);
            int iM11244ETF = this.f373qdMbNW.m11244ETF();
            int iM11249MiMN = this.f373qdMbNW.m11249MiMN();
            if ((Gravity.getAbsoluteGravity(this.f368diqgf, AbstractC2876T9.m10276huTpC(this.f363MiMN)) & 7) == 5) {
                iM11244ETF += this.f363MiMN.getWidth();
            }
            if (c0005JHa.m63YoKzxo(iM11244ETF, iM11249MiMN)) {
                InterfaceC0012xJ.mjFkc mjfkc = this.f374rkYL;
                if (mjfkc == null) {
                    return true;
                }
                mjfkc.mo163wA(subMenuC0004Dt);
                return true;
            }
        }
        return false;
    }

    @Override // p131o.InterfaceC2674Q6
    /* renamed from: KLFTb */
    public ListView mo12KLFTb() {
        return this.f373qdMbNW.mo12KLFTb();
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: MiMN */
    public void mo13MiMN(C0007ZfxDd c0007ZfxDd) {
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: Pq */
    public void mo16Pq(boolean z) {
        this.f367ZfxDd.m159ZfxDd(z);
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: Ucbh */
    public void mo17Ucbh(PopupWindow.OnDismissListener onDismissListener) {
        this.f365VA = onDismissListener;
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: VA */
    public void mo18VA(InterfaceC0012xJ.mjFkc mjfkc) {
        this.f374rkYL = mjfkc;
    }

    /* renamed from: VocHEe */
    public final boolean m157VocHEe() {
        View view;
        if (mo9Dt()) {
            return true;
        }
        if (this.f370fehf || (view = this.f363MiMN) == null) {
            return false;
        }
        this.f366YoKzxo = view;
        this.f373qdMbNW.m11264vI(this);
        this.f373qdMbNW.m11253VocHEe(this);
        this.f373qdMbNW.m11246HGpJ(true);
        View view2 = this.f366YoKzxo;
        boolean z = this.f372qGY == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f372qGY = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f358Dt);
        }
        view2.addOnAttachStateChangeListener(this.f359ETF);
        this.f373qdMbNW.m11247IEE(view2);
        this.f373qdMbNW.m11256eyqo(this.f368diqgf);
        if (!this.f360IEE) {
            this.f364Pq = AbstractC3203Y1.m11039qGY(this.f367ZfxDd, null, this.f357AZxh, this.f361JHa);
            this.f360IEE = true;
        }
        this.f373qdMbNW.m11255diqgf(this.f364Pq);
        this.f373qdMbNW.m11245Gd(2);
        this.f373qdMbNW.m11251Ucbh(m11042rkYL());
        this.f373qdMbNW.mo29mjFkc();
        ListView listViewMo12KLFTb = this.f373qdMbNW.mo12KLFTb();
        listViewMo12KLFTb.setOnKeyListener(this);
        if (this.f369eyqo && this.f375wA.m129eyqo() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f357AZxh).inflate(AbstractC2139I4.f8676qdMbNW, (ViewGroup) listViewMo12KLFTb, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f375wA.m129eyqo());
            }
            frameLayout.setEnabled(false);
            listViewMo12KLFTb.addHeaderView(frameLayout, null, false);
        }
        this.f373qdMbNW.m11257fehf(this.f367ZfxDd);
        this.f373qdMbNW.mo29mjFkc();
        return true;
    }

    @Override // p131o.InterfaceC2674Q6
    /* renamed from: ZfxDd */
    public void mo21ZfxDd() {
        if (mo9Dt()) {
            this.f373qdMbNW.mo21ZfxDd();
        }
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: diqgf */
    public void mo22diqgf(int i) {
        this.f368diqgf = i;
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: eyqo */
    public void mo23eyqo(int i) {
        this.f373qdMbNW.m11258huTpC(i);
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: fehf */
    public void mo24fehf(View view) {
        this.f363MiMN = view;
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: huTpC */
    public void mo25huTpC(boolean z) {
        this.f369eyqo = z;
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: lgHUyS */
    public boolean mo27lgHUyS() {
        return false;
    }

    @Override // p131o.InterfaceC2674Q6
    /* renamed from: mjFkc */
    public void mo29mjFkc() {
        if (!m157VocHEe()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f370fehf = true;
        this.f375wA.close();
        ViewTreeObserver viewTreeObserver = this.f372qGY;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f372qGY = this.f366YoKzxo.getViewTreeObserver();
            }
            this.f372qGY.removeGlobalOnLayoutListener(this.f358Dt);
            this.f372qGY = null;
        }
        this.f366YoKzxo.removeOnAttachStateChangeListener(this.f359ETF);
        PopupWindow.OnDismissListener onDismissListener = this.f365VA;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo21ZfxDd();
        return true;
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: xJ */
    public void mo31xJ(boolean z) {
        this.f360IEE = false;
        C0011wA c0011wA = this.f367ZfxDd;
        if (c0011wA != null) {
            c0011wA.notifyDataSetChanged();
        }
    }
}
