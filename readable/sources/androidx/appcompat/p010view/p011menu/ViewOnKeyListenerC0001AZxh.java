package androidx.appcompat.p010view.p011menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.p010view.p011menu.InterfaceC0012xJ;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p131o.AbstractC2139I4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3203Y1;
import p131o.AbstractC4056l;
import p131o.AbstractC4256o4;
import p131o.C3269Z1;
import p131o.InterfaceC3133X1;

/* renamed from: androidx.appcompat.view.menu.AZxh */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC0001AZxh extends AbstractC3203Y1 implements InterfaceC0012xJ, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: BAnRFn */
    public static final int f206BAnRFn = AbstractC2139I4.f8671KLFTb;

    /* renamed from: AZxh */
    public final Context f207AZxh;

    /* renamed from: Gd */
    public InterfaceC0012xJ.mjFkc f210Gd;

    /* renamed from: HGpJ */
    public ViewTreeObserver f211HGpJ;

    /* renamed from: IEE */
    public boolean f212IEE;

    /* renamed from: JHa */
    public final boolean f213JHa;

    /* renamed from: KLFTb */
    public final int f214KLFTb;

    /* renamed from: Pq */
    public boolean f216Pq;

    /* renamed from: VocHEe */
    public boolean f219VocHEe;

    /* renamed from: ZfxDd */
    public final int f221ZfxDd;

    /* renamed from: diqgf */
    public int f222diqgf;

    /* renamed from: eyqo */
    public int f223eyqo;

    /* renamed from: huTpC */
    public boolean f225huTpC;

    /* renamed from: qGY */
    public View f227qGY;

    /* renamed from: rkYL */
    public View f229rkYL;

    /* renamed from: vI */
    public PopupWindow.OnDismissListener f230vI;

    /* renamed from: wA */
    public final int f231wA;

    /* renamed from: xJ */
    public final Handler f232xJ;

    /* renamed from: lgHUyS */
    public final List f226lgHUyS = new ArrayList();

    /* renamed from: qdMbNW */
    public final List f228qdMbNW = new ArrayList();

    /* renamed from: Dt */
    public final ViewTreeObserver.OnGlobalLayoutListener f208Dt = new mjFkc();

    /* renamed from: ETF */
    public final View.OnAttachStateChangeListener f209ETF = new AZxh();

    /* renamed from: VA */
    public final InterfaceC3133X1 f218VA = new wA();

    /* renamed from: MiMN */
    public int f215MiMN = 0;

    /* renamed from: YoKzxo */
    public int f220YoKzxo = 0;

    /* renamed from: Ucbh */
    public boolean f217Ucbh = false;

    /* renamed from: fehf */
    public int f224fehf = m28mByQ();

    /* renamed from: androidx.appcompat.view.menu.AZxh$AZxh */
    public class AZxh implements View.OnAttachStateChangeListener {
        public AZxh() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = ViewOnKeyListenerC0001AZxh.this.f211HGpJ;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    ViewOnKeyListenerC0001AZxh.this.f211HGpJ = view.getViewTreeObserver();
                }
                ViewOnKeyListenerC0001AZxh viewOnKeyListenerC0001AZxh = ViewOnKeyListenerC0001AZxh.this;
                viewOnKeyListenerC0001AZxh.f211HGpJ.removeGlobalOnLayoutListener(viewOnKeyListenerC0001AZxh.f208Dt);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.AZxh$ZfxDd */
    public static class ZfxDd {

        /* renamed from: AZxh */
        public final C0007ZfxDd f234AZxh;

        /* renamed from: mjFkc */
        public final C3269Z1 f235mjFkc;

        /* renamed from: wA */
        public final int f236wA;

        public ZfxDd(C3269Z1 c3269z1, C0007ZfxDd c0007ZfxDd, int i) {
            this.f235mjFkc = c3269z1;
            this.f234AZxh = c0007ZfxDd;
            this.f236wA = i;
        }

        /* renamed from: mjFkc */
        public ListView m32mjFkc() {
            return this.f235mjFkc.mo12KLFTb();
        }
    }

    /* renamed from: androidx.appcompat.view.menu.AZxh$mjFkc */
    public class mjFkc implements ViewTreeObserver.OnGlobalLayoutListener {
        public mjFkc() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!ViewOnKeyListenerC0001AZxh.this.mo9Dt() || ViewOnKeyListenerC0001AZxh.this.f228qdMbNW.size() <= 0 || ((ZfxDd) ViewOnKeyListenerC0001AZxh.this.f228qdMbNW.get(0)).f235mjFkc.m11263rkYL()) {
                return;
            }
            View view = ViewOnKeyListenerC0001AZxh.this.f227qGY;
            if (view == null || !view.isShown()) {
                ViewOnKeyListenerC0001AZxh.this.mo21ZfxDd();
                return;
            }
            Iterator it = ViewOnKeyListenerC0001AZxh.this.f228qdMbNW.iterator();
            while (it.hasNext()) {
                ((ZfxDd) it.next()).f235mjFkc.mo29mjFkc();
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.AZxh$wA */
    public class wA implements InterfaceC3133X1 {

        /* renamed from: androidx.appcompat.view.menu.AZxh$wA$mjFkc */
        public class mjFkc implements Runnable {

            /* renamed from: AZxh */
            public final /* synthetic */ MenuItem f239AZxh;

            /* renamed from: mjFkc */
            public final /* synthetic */ ZfxDd f241mjFkc;

            /* renamed from: wA */
            public final /* synthetic */ C0007ZfxDd f242wA;

            public mjFkc(ZfxDd zfxDd, MenuItem menuItem, C0007ZfxDd c0007ZfxDd) {
                this.f241mjFkc = zfxDd;
                this.f239AZxh = menuItem;
                this.f242wA = c0007ZfxDd;
            }

            @Override // java.lang.Runnable
            public void run() {
                ZfxDd zfxDd = this.f241mjFkc;
                if (zfxDd != null) {
                    ViewOnKeyListenerC0001AZxh.this.f219VocHEe = true;
                    zfxDd.f234AZxh.m126ZfxDd(false);
                    ViewOnKeyListenerC0001AZxh.this.f219VocHEe = false;
                }
                if (this.f239AZxh.isEnabled() && this.f239AZxh.hasSubMenu()) {
                    this.f242wA.m108CqaNbM(this.f239AZxh, 4);
                }
            }
        }

        public wA() {
        }

        @Override // p131o.InterfaceC3133X1
        /* renamed from: AZxh */
        public void mo33AZxh(C0007ZfxDd c0007ZfxDd, MenuItem menuItem) {
            ViewOnKeyListenerC0001AZxh.this.f232xJ.removeCallbacksAndMessages(null);
            int size = ViewOnKeyListenerC0001AZxh.this.f228qdMbNW.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (c0007ZfxDd == ((ZfxDd) ViewOnKeyListenerC0001AZxh.this.f228qdMbNW.get(i)).f234AZxh) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            ViewOnKeyListenerC0001AZxh.this.f232xJ.postAtTime(new mjFkc(i2 < ViewOnKeyListenerC0001AZxh.this.f228qdMbNW.size() ? (ZfxDd) ViewOnKeyListenerC0001AZxh.this.f228qdMbNW.get(i2) : null, menuItem, c0007ZfxDd), c0007ZfxDd, SystemClock.uptimeMillis() + 200);
        }

        @Override // p131o.InterfaceC3133X1
        /* renamed from: wA */
        public void mo34wA(C0007ZfxDd c0007ZfxDd, MenuItem menuItem) {
            ViewOnKeyListenerC0001AZxh.this.f232xJ.removeCallbacksAndMessages(c0007ZfxDd);
        }
    }

    public ViewOnKeyListenerC0001AZxh(Context context, View view, int i, int i2, boolean z) {
        this.f207AZxh = context;
        this.f229rkYL = view;
        this.f221ZfxDd = i;
        this.f214KLFTb = i2;
        this.f213JHa = z;
        Resources resources = context.getResources();
        this.f231wA = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(AbstractC4256o4.f15497AZxh));
        this.f232xJ = new Handler();
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: AZxh */
    public void mo7AZxh(C0007ZfxDd c0007ZfxDd, boolean z) {
        int iM8BAnRFn = m8BAnRFn(c0007ZfxDd);
        if (iM8BAnRFn < 0) {
            return;
        }
        int i = iM8BAnRFn + 1;
        if (i < this.f228qdMbNW.size()) {
            ((ZfxDd) this.f228qdMbNW.get(i)).f234AZxh.m126ZfxDd(false);
        }
        ZfxDd zfxDd = (ZfxDd) this.f228qdMbNW.remove(iM8BAnRFn);
        zfxDd.f234AZxh.m144zvd(this);
        if (this.f219VocHEe) {
            zfxDd.f235mjFkc.m11165Ne(null);
            zfxDd.f235mjFkc.m11250Pq(0);
        }
        zfxDd.f235mjFkc.mo21ZfxDd();
        int size = this.f228qdMbNW.size();
        if (size > 0) {
            this.f224fehf = ((ZfxDd) this.f228qdMbNW.get(size - 1)).f236wA;
        } else {
            this.f224fehf = m28mByQ();
        }
        if (size != 0) {
            if (z) {
                ((ZfxDd) this.f228qdMbNW.get(0)).f234AZxh.m126ZfxDd(false);
                return;
            }
            return;
        }
        mo21ZfxDd();
        InterfaceC0012xJ.mjFkc mjfkc = this.f210Gd;
        if (mjfkc != null) {
            mjfkc.mo162AZxh(c0007ZfxDd, true);
        }
        ViewTreeObserver viewTreeObserver = this.f211HGpJ;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f211HGpJ.removeGlobalOnLayoutListener(this.f208Dt);
            }
            this.f211HGpJ = null;
        }
        this.f227qGY.removeOnAttachStateChangeListener(this.f209ETF);
        this.f230vI.onDismiss();
    }

    /* renamed from: BAnRFn */
    public final int m8BAnRFn(C0007ZfxDd c0007ZfxDd) {
        int size = this.f228qdMbNW.size();
        for (int i = 0; i < size; i++) {
            if (c0007ZfxDd == ((ZfxDd) this.f228qdMbNW.get(i)).f234AZxh) {
                return i;
            }
        }
        return -1;
    }

    @Override // p131o.InterfaceC2674Q6
    /* renamed from: Dt */
    public boolean mo9Dt() {
        return this.f228qdMbNW.size() > 0 && ((ZfxDd) this.f228qdMbNW.get(0)).f235mjFkc.mo9Dt();
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: Gd */
    public void mo10Gd(int i) {
        this.f216Pq = true;
        this.f223eyqo = i;
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: JHa */
    public boolean mo11JHa(SubMenuC0004Dt subMenuC0004Dt) {
        for (ZfxDd zfxDd : this.f228qdMbNW) {
            if (subMenuC0004Dt == zfxDd.f234AZxh) {
                zfxDd.m32mjFkc().requestFocus();
                return true;
            }
        }
        if (!subMenuC0004Dt.hasVisibleItems()) {
            return false;
        }
        mo13MiMN(subMenuC0004Dt);
        InterfaceC0012xJ.mjFkc mjfkc = this.f210Gd;
        if (mjfkc != null) {
            mjfkc.mo163wA(subMenuC0004Dt);
        }
        return true;
    }

    @Override // p131o.InterfaceC2674Q6
    /* renamed from: KLFTb */
    public ListView mo12KLFTb() {
        if (this.f228qdMbNW.isEmpty()) {
            return null;
        }
        return ((ZfxDd) this.f228qdMbNW.get(r1.size() - 1)).m32mjFkc();
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: MiMN */
    public void mo13MiMN(C0007ZfxDd c0007ZfxDd) {
        c0007ZfxDd.m107AZxh(this, this.f207AZxh);
        if (mo9Dt()) {
            m14Ne(c0007ZfxDd);
        } else {
            this.f226lgHUyS.add(c0007ZfxDd);
        }
    }

    /* renamed from: Ne */
    public final void m14Ne(C0007ZfxDd c0007ZfxDd) {
        ZfxDd zfxDd;
        View viewM30wJVbdd;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f207AZxh);
        C0011wA c0011wA = new C0011wA(c0007ZfxDd, layoutInflaterFrom, this.f213JHa, f206BAnRFn);
        if (!mo9Dt() && this.f217Ucbh) {
            c0011wA.m159ZfxDd(true);
        } else if (mo9Dt()) {
            c0011wA.m159ZfxDd(AbstractC3203Y1.m11038HGpJ(c0007ZfxDd));
        }
        int iM11039qGY = AbstractC3203Y1.m11039qGY(c0011wA, null, this.f207AZxh, this.f231wA);
        C3269Z1 c3269z1M19VocHEe = m19VocHEe();
        c3269z1M19VocHEe.m11257fehf(c0011wA);
        c3269z1M19VocHEe.m11255diqgf(iM11039qGY);
        c3269z1M19VocHEe.m11256eyqo(this.f220YoKzxo);
        if (this.f228qdMbNW.size() > 0) {
            List list = this.f228qdMbNW;
            zfxDd = (ZfxDd) list.get(list.size() - 1);
            viewM30wJVbdd = m30wJVbdd(zfxDd, c0007ZfxDd);
        } else {
            zfxDd = null;
            viewM30wJVbdd = null;
        }
        if (viewM30wJVbdd != null) {
            c3269z1M19VocHEe.m11168xrEuO(false);
            c3269z1M19VocHEe.m11166OjSQV(null);
            int iM15OjSQV = m15OjSQV(iM11039qGY);
            boolean z = iM15OjSQV == 1;
            this.f224fehf = iM15OjSQV;
            c3269z1M19VocHEe.m11247IEE(viewM30wJVbdd);
            if ((this.f220YoKzxo & 5) != 5) {
                iM11039qGY = z ? viewM30wJVbdd.getWidth() : 0 - iM11039qGY;
            } else if (!z) {
                iM11039qGY = 0 - viewM30wJVbdd.getWidth();
            }
            c3269z1M19VocHEe.m11258huTpC(iM11039qGY);
            c3269z1M19VocHEe.m11243BAnRFn(true);
            c3269z1M19VocHEe.m11265wJVbdd(0);
        } else {
            if (this.f212IEE) {
                c3269z1M19VocHEe.m11258huTpC(this.f222diqgf);
            }
            if (this.f216Pq) {
                c3269z1M19VocHEe.m11265wJVbdd(this.f223eyqo);
            }
            c3269z1M19VocHEe.m11251Ucbh(m11042rkYL());
        }
        this.f228qdMbNW.add(new ZfxDd(c3269z1M19VocHEe, c0007ZfxDd, this.f224fehf));
        c3269z1M19VocHEe.mo29mjFkc();
        ListView listViewMo12KLFTb = c3269z1M19VocHEe.mo12KLFTb();
        listViewMo12KLFTb.setOnKeyListener(this);
        if (zfxDd == null && this.f225huTpC && c0007ZfxDd.m129eyqo() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(AbstractC2139I4.f8676qdMbNW, (ViewGroup) listViewMo12KLFTb, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(c0007ZfxDd.m129eyqo());
            listViewMo12KLFTb.addHeaderView(frameLayout, null, false);
            c3269z1M19VocHEe.mo29mjFkc();
        }
    }

    /* renamed from: OjSQV */
    public final int m15OjSQV(int i) {
        List list = this.f228qdMbNW;
        ListView listViewM32mjFkc = ((ZfxDd) list.get(list.size() - 1)).m32mjFkc();
        int[] iArr = new int[2];
        listViewM32mjFkc.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f227qGY.getWindowVisibleDisplayFrame(rect);
        return this.f224fehf == 1 ? (iArr[0] + listViewM32mjFkc.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: Pq */
    public void mo16Pq(boolean z) {
        this.f217Ucbh = z;
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: Ucbh */
    public void mo17Ucbh(PopupWindow.OnDismissListener onDismissListener) {
        this.f230vI = onDismissListener;
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: VA */
    public void mo18VA(InterfaceC0012xJ.mjFkc mjfkc) {
        this.f210Gd = mjfkc;
    }

    /* renamed from: VocHEe */
    public final C3269Z1 m19VocHEe() {
        C3269Z1 c3269z1 = new C3269Z1(this.f207AZxh, null, this.f221ZfxDd, this.f214KLFTb);
        c3269z1.m11164CqaNbM(this.f218VA);
        c3269z1.m11253VocHEe(this);
        c3269z1.m11264vI(this);
        c3269z1.m11247IEE(this.f229rkYL);
        c3269z1.m11256eyqo(this.f220YoKzxo);
        c3269z1.m11246HGpJ(true);
        c3269z1.m11245Gd(2);
        return c3269z1;
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: YoKzxo */
    public boolean mo20YoKzxo() {
        return false;
    }

    @Override // p131o.InterfaceC2674Q6
    /* renamed from: ZfxDd */
    public void mo21ZfxDd() {
        int size = this.f228qdMbNW.size();
        if (size > 0) {
            ZfxDd[] zfxDdArr = (ZfxDd[]) this.f228qdMbNW.toArray(new ZfxDd[size]);
            for (int i = size - 1; i >= 0; i--) {
                ZfxDd zfxDd = zfxDdArr[i];
                if (zfxDd.f235mjFkc.mo9Dt()) {
                    zfxDd.f235mjFkc.mo21ZfxDd();
                }
            }
        }
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: diqgf */
    public void mo22diqgf(int i) {
        if (this.f215MiMN != i) {
            this.f215MiMN = i;
            this.f220YoKzxo = AbstractC4056l.m12647AZxh(i, AbstractC2876T9.m10276huTpC(this.f229rkYL));
        }
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: eyqo */
    public void mo23eyqo(int i) {
        this.f212IEE = true;
        this.f222diqgf = i;
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: fehf */
    public void mo24fehf(View view) {
        if (this.f229rkYL != view) {
            this.f229rkYL = view;
            this.f220YoKzxo = AbstractC4056l.m12647AZxh(this.f215MiMN, AbstractC2876T9.m10276huTpC(view));
        }
    }

    @Override // p131o.AbstractC3203Y1
    /* renamed from: huTpC */
    public void mo25huTpC(boolean z) {
        this.f225huTpC = z;
    }

    /* renamed from: lB */
    public final MenuItem m26lB(C0007ZfxDd c0007ZfxDd, C0007ZfxDd c0007ZfxDd2) {
        int size = c0007ZfxDd.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0007ZfxDd.getItem(i);
            if (item.hasSubMenu() && c0007ZfxDd2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: lgHUyS */
    public boolean mo27lgHUyS() {
        return false;
    }

    /* renamed from: mByQ */
    public final int m28mByQ() {
        return AbstractC2876T9.m10276huTpC(this.f229rkYL) == 1 ? 0 : 1;
    }

    @Override // p131o.InterfaceC2674Q6
    /* renamed from: mjFkc */
    public void mo29mjFkc() {
        if (mo9Dt()) {
            return;
        }
        Iterator it = this.f226lgHUyS.iterator();
        while (it.hasNext()) {
            m14Ne((C0007ZfxDd) it.next());
        }
        this.f226lgHUyS.clear();
        View view = this.f229rkYL;
        this.f227qGY = view;
        if (view != null) {
            boolean z = this.f211HGpJ == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f211HGpJ = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f208Dt);
            }
            this.f227qGY.addOnAttachStateChangeListener(this.f209ETF);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        ZfxDd zfxDd;
        int size = this.f228qdMbNW.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                zfxDd = null;
                break;
            }
            zfxDd = (ZfxDd) this.f228qdMbNW.get(i);
            if (!zfxDd.f235mjFkc.mo9Dt()) {
                break;
            } else {
                i++;
            }
        }
        if (zfxDd != null) {
            zfxDd.f234AZxh.m126ZfxDd(false);
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

    /* renamed from: wJVbdd */
    public final View m30wJVbdd(ZfxDd zfxDd, C0007ZfxDd c0007ZfxDd) {
        C0011wA c0011wA;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemM26lB = m26lB(zfxDd.f234AZxh, c0007ZfxDd);
        if (menuItemM26lB == null) {
            return null;
        }
        ListView listViewM32mjFkc = zfxDd.m32mjFkc();
        ListAdapter adapter = listViewM32mjFkc.getAdapter();
        int i = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            c0011wA = (C0011wA) headerViewListAdapter.getWrappedAdapter();
        } else {
            c0011wA = (C0011wA) adapter;
            headersCount = 0;
        }
        int count = c0011wA.getCount();
        while (true) {
            if (i >= count) {
                i = -1;
                break;
            }
            if (menuItemM26lB == c0011wA.getItem(i)) {
                break;
            }
            i++;
        }
        if (i != -1 && (firstVisiblePosition = (i + headersCount) - listViewM32mjFkc.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewM32mjFkc.getChildCount()) {
            return listViewM32mjFkc.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: xJ */
    public void mo31xJ(boolean z) {
        Iterator it = this.f228qdMbNW.iterator();
        while (it.hasNext()) {
            AbstractC3203Y1.m11040vI(((ZfxDd) it.next()).m32mjFkc().getAdapter()).notifyDataSetChanged();
        }
    }
}
