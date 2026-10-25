package p131o;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.p010view.p011menu.C0006KLFTb;
import androidx.appcompat.p010view.p011menu.C0007ZfxDd;
import androidx.appcompat.p010view.p011menu.C0011wA;
import androidx.appcompat.p010view.p011menu.ListMenuItemView;

/* renamed from: o.Z1 */
/* loaded from: classes.dex */
public class C3269Z1 extends AbstractC3336a1 implements InterfaceC3133X1 {

    /* renamed from: Ne */
    public InterfaceC3133X1 f11952Ne;

    /* renamed from: o.Z1$AZxh */
    public static class AZxh {
        /* renamed from: mjFkc */
        public static void m11169mjFkc(PopupWindow popupWindow, boolean z) {
            popupWindow.setTouchModal(z);
        }
    }

    /* renamed from: o.Z1$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static void m11170AZxh(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }

        /* renamed from: mjFkc */
        public static void m11171mjFkc(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }
    }

    /* renamed from: o.Z1$wA */
    public static class wA extends AbstractC2511NU {

        /* renamed from: MiMN */
        public final int f11953MiMN;

        /* renamed from: YoKzxo */
        public final int f11954YoKzxo;

        /* renamed from: qGY */
        public MenuItem f11955qGY;

        /* renamed from: rkYL */
        public InterfaceC3133X1 f11956rkYL;

        /* renamed from: o.Z1$wA$mjFkc */
        public static class mjFkc {
            /* renamed from: mjFkc */
            public static int m11172mjFkc(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public wA(Context context, boolean z) {
            super(context, z);
            if (1 == mjFkc.m11172mjFkc(context.getResources().getConfiguration())) {
                this.f11953MiMN = 21;
                this.f11954YoKzxo = 22;
            } else {
                this.f11953MiMN = 22;
                this.f11954YoKzxo = 21;
            }
        }

        @Override // p131o.AbstractC2511NU
        /* renamed from: KLFTb */
        public /* bridge */ /* synthetic */ boolean mo9663KLFTb(MotionEvent motionEvent, int i) {
            return super.mo9663KLFTb(motionEvent, i);
        }

        @Override // p131o.AbstractC2511NU
        /* renamed from: ZfxDd */
        public /* bridge */ /* synthetic */ int mo9667ZfxDd(int i, int i2, int i3, int i4, int i5) {
            return super.mo9667ZfxDd(i, i2, i3, i4, i5);
        }

        @Override // p131o.AbstractC2511NU, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // p131o.AbstractC2511NU, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // p131o.AbstractC2511NU, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // p131o.AbstractC2511NU, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // p131o.AbstractC2511NU, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            C0011wA c0011wA;
            int headersCount;
            int iPointToPosition;
            int i;
            if (this.f11956rkYL != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    c0011wA = (C0011wA) headerViewListAdapter.getWrappedAdapter();
                } else {
                    c0011wA = (C0011wA) adapter;
                    headersCount = 0;
                }
                C0006KLFTb item = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i = iPointToPosition - headersCount) < 0 || i >= c0011wA.getCount()) ? null : c0011wA.getItem(i);
                MenuItem menuItem = this.f11955qGY;
                if (menuItem != item) {
                    C0007ZfxDd c0007ZfxDdM158AZxh = c0011wA.m158AZxh();
                    if (menuItem != null) {
                        this.f11956rkYL.mo34wA(c0007ZfxDdM158AZxh, menuItem);
                    }
                    this.f11955qGY = item;
                    if (item != null) {
                        this.f11956rkYL.mo33AZxh(c0007ZfxDdM158AZxh, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f11953MiMN) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i != this.f11954YoKzxo) {
                return super.onKeyDown(i, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (C0011wA) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (C0011wA) adapter).m158AZxh().m126ZfxDd(false);
            return true;
        }

        @Override // p131o.AbstractC2511NU, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(InterfaceC3133X1 interfaceC3133X1) {
            this.f11956rkYL = interfaceC3133X1;
        }

        @Override // p131o.AbstractC2511NU, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    public C3269Z1(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // p131o.InterfaceC3133X1
    /* renamed from: AZxh */
    public void mo33AZxh(C0007ZfxDd c0007ZfxDd, MenuItem menuItem) {
        InterfaceC3133X1 interfaceC3133X1 = this.f11952Ne;
        if (interfaceC3133X1 != null) {
            interfaceC3133X1.mo33AZxh(c0007ZfxDd, menuItem);
        }
    }

    /* renamed from: CqaNbM */
    public void m11164CqaNbM(InterfaceC3133X1 interfaceC3133X1) {
        this.f11952Ne = interfaceC3133X1;
    }

    /* renamed from: Ne */
    public void m11165Ne(Object obj) {
        mjFkc.m11170AZxh(this.f12283OjSQV, (Transition) obj);
    }

    /* renamed from: OjSQV */
    public void m11166OjSQV(Object obj) {
        mjFkc.m11171mjFkc(this.f12283OjSQV, (Transition) obj);
    }

    @Override // p131o.AbstractC3336a1
    /* renamed from: lgHUyS */
    public AbstractC2511NU mo11167lgHUyS(Context context, boolean z) {
        wA wAVar = new wA(context, z);
        wAVar.setHoverListener(this);
        return wAVar;
    }

    @Override // p131o.InterfaceC3133X1
    /* renamed from: wA */
    public void mo34wA(C0007ZfxDd c0007ZfxDd, MenuItem menuItem) {
        InterfaceC3133X1 interfaceC3133X1 = this.f11952Ne;
        if (interfaceC3133X1 != null) {
            interfaceC3133X1.mo34wA(c0007ZfxDd, menuItem);
        }
    }

    /* renamed from: xrEuO */
    public void m11168xrEuO(boolean z) {
        AZxh.m11169mjFkc(this.f12283OjSQV, z);
    }
}
