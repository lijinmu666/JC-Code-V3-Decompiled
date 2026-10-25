package androidx.appcompat.p012widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.p010view.p011menu.AbstractC0009mjFkc;
import androidx.appcompat.p010view.p011menu.ActionMenuItemView;
import androidx.appcompat.p010view.p011menu.C0005JHa;
import androidx.appcompat.p010view.p011menu.C0006KLFTb;
import androidx.appcompat.p010view.p011menu.C0007ZfxDd;
import androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS;
import androidx.appcompat.p010view.p011menu.InterfaceC0012xJ;
import androidx.appcompat.p010view.p011menu.SubMenuC0004Dt;
import androidx.appcompat.p012widget.ActionMenuView;
import java.util.ArrayList;
import p131o.AbstractC2139I4;
import p131o.AbstractC2143I8;
import p131o.AbstractC3862i4;
import p131o.AbstractC4332pCk;
import p131o.AbstractViewOnTouchListenerC4375prww;
import p131o.C3584dm;
import p131o.C4068lB;
import p131o.InterfaceC2674Q6;

/* renamed from: androidx.appcompat.widget.mjFkc */
/* loaded from: classes.dex */
public class C0047mjFkc extends AbstractC0009mjFkc {

    /* renamed from: BAnRFn */
    public final JHa f633BAnRFn;

    /* renamed from: Dt */
    public ZfxDd f634Dt;

    /* renamed from: ETF */
    public Drawable f635ETF;

    /* renamed from: Gd */
    public KLFTb f636Gd;

    /* renamed from: HGpJ */
    public mjFkc f637HGpJ;

    /* renamed from: IEE */
    public boolean f638IEE;

    /* renamed from: MiMN */
    public boolean f639MiMN;

    /* renamed from: Pq */
    public boolean f640Pq;

    /* renamed from: Ucbh */
    public int f641Ucbh;

    /* renamed from: VA */
    public boolean f642VA;

    /* renamed from: VocHEe */
    public AZxh f643VocHEe;

    /* renamed from: YoKzxo */
    public boolean f644YoKzxo;

    /* renamed from: diqgf */
    public boolean f645diqgf;

    /* renamed from: eyqo */
    public boolean f646eyqo;

    /* renamed from: fehf */
    public int f647fehf;

    /* renamed from: huTpC */
    public final SparseBooleanArray f648huTpC;

    /* renamed from: lB */
    public int f649lB;

    /* renamed from: qGY */
    public int f650qGY;

    /* renamed from: rkYL */
    public int f651rkYL;

    /* renamed from: vI */
    public wA f652vI;

    /* renamed from: androidx.appcompat.widget.mjFkc$AZxh */
    public class AZxh extends ActionMenuItemView.AbstractC0002AZxh {
        public AZxh() {
        }

        @Override // androidx.appcompat.p010view.p011menu.ActionMenuItemView.AbstractC0002AZxh
        /* renamed from: mjFkc */
        public InterfaceC2674Q6 mo43mjFkc() {
            mjFkc mjfkc = C0047mjFkc.this.f637HGpJ;
            if (mjfkc != null) {
                return mjfkc.m68wA();
            }
            return null;
        }
    }

    /* renamed from: androidx.appcompat.widget.mjFkc$JHa */
    public class JHa implements InterfaceC0012xJ.mjFkc {
        public JHa() {
        }

        @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ.mjFkc
        /* renamed from: AZxh */
        public void mo162AZxh(C0007ZfxDd c0007ZfxDd, boolean z) {
            if (c0007ZfxDd instanceof SubMenuC0004Dt) {
                c0007ZfxDd.mo52vI().m126ZfxDd(false);
            }
            InterfaceC0012xJ.mjFkc mjfkcM150MiMN = C0047mjFkc.this.m150MiMN();
            if (mjfkcM150MiMN != null) {
                mjfkcM150MiMN.mo162AZxh(c0007ZfxDd, z);
            }
        }

        @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ.mjFkc
        /* renamed from: wA */
        public boolean mo163wA(C0007ZfxDd c0007ZfxDd) {
            if (c0007ZfxDd == C0047mjFkc.this.f354wA) {
                return false;
            }
            C0047mjFkc.this.f649lB = ((SubMenuC0004Dt) c0007ZfxDd).getItem().getItemId();
            InterfaceC0012xJ.mjFkc mjfkcM150MiMN = C0047mjFkc.this.m150MiMN();
            if (mjfkcM150MiMN != null) {
                return mjfkcM150MiMN.mo163wA(c0007ZfxDd);
            }
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.mjFkc$KLFTb */
    public class KLFTb extends C0005JHa {
        public KLFTb(Context context, C0007ZfxDd c0007ZfxDd, View view, boolean z) {
            super(context, c0007ZfxDd, view, z, AbstractC3862i4.f14106JHa);
            m65lgHUyS(8388613);
            m57Dt(C0047mjFkc.this.f633BAnRFn);
        }

        @Override // androidx.appcompat.p010view.p011menu.C0005JHa
        /* renamed from: KLFTb */
        public void mo60KLFTb() {
            if (C0047mjFkc.this.f354wA != null) {
                C0047mjFkc.this.f354wA.close();
            }
            C0047mjFkc.this.f636Gd = null;
            super.mo60KLFTb();
        }
    }

    /* renamed from: androidx.appcompat.widget.mjFkc$ZfxDd */
    public class ZfxDd extends C3584dm implements ActionMenuView.InterfaceC0023mjFkc {

        /* renamed from: androidx.appcompat.widget.mjFkc$ZfxDd$mjFkc */
        public class mjFkc extends AbstractViewOnTouchListenerC4375prww {

            /* renamed from: Dt */
            public final /* synthetic */ C0047mjFkc f657Dt;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public mjFkc(View view, C0047mjFkc c0047mjFkc) {
                super(view);
                this.f657Dt = c0047mjFkc;
            }

            @Override // p131o.AbstractViewOnTouchListenerC4375prww
            /* renamed from: AZxh */
            public InterfaceC2674Q6 mo44AZxh() {
                KLFTb kLFTb = C0047mjFkc.this.f636Gd;
                if (kLFTb == null) {
                    return null;
                }
                return kLFTb.m68wA();
            }

            @Override // p131o.AbstractViewOnTouchListenerC4375prww
            /* renamed from: ZfxDd */
            public boolean mo368ZfxDd() {
                C0047mjFkc c0047mjFkc = C0047mjFkc.this;
                if (c0047mjFkc.f652vI != null) {
                    return false;
                }
                c0047mjFkc.m366vI();
                return true;
            }

            @Override // p131o.AbstractViewOnTouchListenerC4375prww
            /* renamed from: wA */
            public boolean mo45wA() {
                C0047mjFkc.this.m357CqaNbM();
                return true;
            }
        }

        public ZfxDd(Context context) {
            super(context, null, AbstractC3862i4.f14107KLFTb);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            AbstractC2143I8.m8717mjFkc(this, getContentDescription());
            setOnTouchListener(new mjFkc(this, C0047mjFkc.this));
        }

        @Override // androidx.appcompat.p012widget.ActionMenuView.InterfaceC0023mjFkc
        /* renamed from: AZxh */
        public boolean mo35AZxh() {
            return false;
        }

        @Override // androidx.appcompat.p012widget.ActionMenuView.InterfaceC0023mjFkc
        /* renamed from: mjFkc */
        public boolean mo40mjFkc() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            C0047mjFkc.this.m357CqaNbM();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                AbstractC4332pCk.m13075JHa(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* renamed from: androidx.appcompat.widget.mjFkc$mjFkc */
    public class mjFkc extends C0005JHa {
        public mjFkc(Context context, SubMenuC0004Dt subMenuC0004Dt, View view) {
            super(context, subMenuC0004Dt, view, false, AbstractC3862i4.f14106JHa);
            if (!((C0006KLFTb) subMenuC0004Dt.getItem()).m73ETF()) {
                View view2 = C0047mjFkc.this.f634Dt;
                m59JHa(view2 == null ? (View) C0047mjFkc.this.f353qdMbNW : view2);
            }
            m57Dt(C0047mjFkc.this.f633BAnRFn);
        }

        @Override // androidx.appcompat.p010view.p011menu.C0005JHa
        /* renamed from: KLFTb */
        public void mo60KLFTb() {
            C0047mjFkc c0047mjFkc = C0047mjFkc.this;
            c0047mjFkc.f637HGpJ = null;
            c0047mjFkc.f649lB = 0;
            super.mo60KLFTb();
        }
    }

    /* renamed from: androidx.appcompat.widget.mjFkc$wA */
    public class wA implements Runnable {

        /* renamed from: mjFkc */
        public KLFTb f661mjFkc;

        public wA(KLFTb kLFTb) {
            this.f661mjFkc = kLFTb;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0047mjFkc.this.f354wA != null) {
                C0047mjFkc.this.f354wA.m142wA();
            }
            View view = (View) C0047mjFkc.this.f353qdMbNW;
            if (view != null && view.getWindowToken() != null && this.f661mjFkc.m61MiMN()) {
                C0047mjFkc.this.f636Gd = this.f661mjFkc;
            }
            C0047mjFkc.this.f652vI = null;
        }
    }

    public C0047mjFkc(Context context) {
        super(context, AbstractC2139I4.f8677wA, AbstractC2139I4.f8667AZxh);
        this.f648huTpC = new SparseBooleanArray();
        this.f633BAnRFn = new JHa();
    }

    @Override // androidx.appcompat.p010view.p011menu.AbstractC0009mjFkc, androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: AZxh */
    public void mo7AZxh(C0007ZfxDd c0007ZfxDd, boolean z) {
        m363huTpC();
        super.mo7AZxh(c0007ZfxDd, z);
    }

    /* renamed from: BAnRFn */
    public boolean m356BAnRFn() {
        KLFTb kLFTb = this.f636Gd;
        return kLFTb != null && kLFTb.m64ZfxDd();
    }

    /* renamed from: CqaNbM */
    public boolean m357CqaNbM() {
        C0007ZfxDd c0007ZfxDd;
        if (!this.f639MiMN || m356BAnRFn() || (c0007ZfxDd = this.f354wA) == null || this.f353qdMbNW == null || this.f652vI != null || c0007ZfxDd.m120Ucbh().isEmpty()) {
            return false;
        }
        wA wAVar = new wA(new KLFTb(this.f347AZxh, this.f354wA, this.f634Dt, true));
        this.f652vI = wAVar;
        ((View) this.f353qdMbNW).post(wAVar);
        return true;
    }

    @Override // androidx.appcompat.p010view.p011menu.AbstractC0009mjFkc
    /* renamed from: Dt */
    public boolean mo147Dt(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f634Dt) {
            return false;
        }
        return super.mo147Dt(viewGroup, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Gd */
    public final View m358Gd(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f353qdMbNW;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof InterfaceC0008lgHUyS.mjFkc) && ((InterfaceC0008lgHUyS.mjFkc) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: HGpJ */
    public Drawable m359HGpJ() {
        ZfxDd zfxDd = this.f634Dt;
        if (zfxDd != null) {
            return zfxDd.getDrawable();
        }
        if (this.f642VA) {
            return this.f635ETF;
        }
        return null;
    }

    @Override // androidx.appcompat.p010view.p011menu.AbstractC0009mjFkc, androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: JHa */
    public boolean mo11JHa(SubMenuC0004Dt subMenuC0004Dt) {
        boolean z = false;
        if (!subMenuC0004Dt.hasVisibleItems()) {
            return false;
        }
        SubMenuC0004Dt subMenuC0004Dt2 = subMenuC0004Dt;
        while (subMenuC0004Dt2.m48JYn() != this.f354wA) {
            subMenuC0004Dt2 = (SubMenuC0004Dt) subMenuC0004Dt2.m48JYn();
        }
        View viewM358Gd = m358Gd(subMenuC0004Dt2.getItem());
        if (viewM358Gd == null) {
            return false;
        }
        this.f649lB = subMenuC0004Dt.getItem().getItemId();
        int size = subMenuC0004Dt.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = subMenuC0004Dt.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        mjFkc mjfkc = new mjFkc(this.f347AZxh, subMenuC0004Dt, viewM358Gd);
        this.f637HGpJ = mjfkc;
        mjfkc.m69xJ(z);
        this.f637HGpJ.m58ETF();
        super.mo11JHa(subMenuC0004Dt);
        return true;
    }

    /* renamed from: Ne */
    public void m360Ne(boolean z) {
        this.f639MiMN = z;
        this.f644YoKzxo = true;
    }

    /* renamed from: OjSQV */
    public void m361OjSQV(Drawable drawable) {
        ZfxDd zfxDd = this.f634Dt;
        if (zfxDd != null) {
            zfxDd.setImageDrawable(drawable);
        } else {
            this.f642VA = true;
            this.f635ETF = drawable;
        }
    }

    /* renamed from: VocHEe */
    public boolean m362VocHEe() {
        mjFkc mjfkc = this.f637HGpJ;
        if (mjfkc == null) {
            return false;
        }
        mjfkc.m56AZxh();
        return true;
    }

    @Override // androidx.appcompat.p010view.p011menu.AbstractC0009mjFkc
    /* renamed from: YoKzxo */
    public View mo151YoKzxo(C0006KLFTb c0006KLFTb, View view, ViewGroup viewGroup) {
        View actionView = c0006KLFTb.getActionView();
        if (actionView == null || c0006KLFTb.m93qdMbNW()) {
            actionView = super.mo151YoKzxo(c0006KLFTb, view, viewGroup);
        }
        actionView.setVisibility(c0006KLFTb.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.p010view.p011menu.AbstractC0009mjFkc
    /* renamed from: ZfxDd */
    public void mo152ZfxDd(C0006KLFTb c0006KLFTb, InterfaceC0008lgHUyS.mjFkc mjfkc) {
        mjfkc.mo38ZfxDd(c0006KLFTb, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) mjfkc;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f353qdMbNW);
        if (this.f643VocHEe == null) {
            this.f643VocHEe = new AZxh();
        }
        actionMenuItemView.setPopupCallback(this.f643VocHEe);
    }

    /* renamed from: huTpC */
    public boolean m363huTpC() {
        return m362VocHEe() | m366vI();
    }

    /* renamed from: lB */
    public void m364lB(Configuration configuration) {
        if (!this.f638IEE) {
            this.f647fehf = C4068lB.m12686mjFkc(this.f347AZxh).m12689wA();
        }
        C0007ZfxDd c0007ZfxDd = this.f354wA;
        if (c0007ZfxDd != null) {
            c0007ZfxDd.m117Ne(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: lgHUyS */
    public boolean mo27lgHUyS() {
        ArrayList arrayListM123VocHEe;
        int size;
        int i;
        int iM210xrEuO;
        boolean z;
        int i2;
        C0047mjFkc c0047mjFkc = this;
        C0007ZfxDd c0007ZfxDd = c0047mjFkc.f354wA;
        View view = null;
        ?? r3 = 0;
        if (c0007ZfxDd != null) {
            arrayListM123VocHEe = c0007ZfxDd.m123VocHEe();
            size = arrayListM123VocHEe.size();
        } else {
            arrayListM123VocHEe = null;
            size = 0;
        }
        int i3 = c0047mjFkc.f647fehf;
        int i4 = c0047mjFkc.f650qGY;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) c0047mjFkc.f353qdMbNW;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            C0006KLFTb c0006KLFTb = (C0006KLFTb) arrayListM123VocHEe.get(i7);
            if (c0006KLFTb.m84YoKzxo()) {
                i5++;
            } else if (c0006KLFTb.m79MiMN()) {
                i6++;
            } else {
                z2 = true;
            }
            if (c0047mjFkc.f646eyqo && c0006KLFTb.isActionViewExpanded()) {
                i3 = 0;
            }
        }
        if (c0047mjFkc.f639MiMN && (z2 || i6 + i5 > i3)) {
            i3--;
        }
        int i8 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = c0047mjFkc.f648huTpC;
        sparseBooleanArray.clear();
        if (c0047mjFkc.f640Pq) {
            int i9 = c0047mjFkc.f641Ucbh;
            iM210xrEuO = i4 / i9;
            i = i9 + ((i4 % i9) / iM210xrEuO);
        } else {
            i = 0;
            iM210xrEuO = 0;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            C0006KLFTb c0006KLFTb2 = (C0006KLFTb) arrayListM123VocHEe.get(i10);
            if (c0006KLFTb2.m84YoKzxo()) {
                View viewMo151YoKzxo = c0047mjFkc.mo151YoKzxo(c0006KLFTb2, view, viewGroup);
                if (c0047mjFkc.f640Pq) {
                    iM210xrEuO -= ActionMenuView.m210xrEuO(viewMo151YoKzxo, i, iM210xrEuO, iMakeMeasureSpec, r3);
                } else {
                    viewMo151YoKzxo.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewMo151YoKzxo.getMeasuredWidth();
                i4 -= measuredWidth;
                if (i11 == 0) {
                    i11 = measuredWidth;
                }
                int groupId = c0006KLFTb2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                c0006KLFTb2.m86diqgf(true);
                z = r3;
                i2 = size;
            } else if (c0006KLFTb2.m79MiMN()) {
                int groupId2 = c0006KLFTb2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i8 > 0 || z3) && i4 > 0 && (!c0047mjFkc.f640Pq || iM210xrEuO > 0);
                boolean z5 = z4;
                i2 = size;
                if (z4) {
                    View viewMo151YoKzxo2 = c0047mjFkc.mo151YoKzxo(c0006KLFTb2, null, viewGroup);
                    if (c0047mjFkc.f640Pq) {
                        int iM210xrEuO2 = ActionMenuView.m210xrEuO(viewMo151YoKzxo2, i, iM210xrEuO, iMakeMeasureSpec, 0);
                        iM210xrEuO -= iM210xrEuO2;
                        if (iM210xrEuO2 == 0) {
                            z5 = false;
                        }
                    } else {
                        viewMo151YoKzxo2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z6 = z5;
                    int measuredWidth2 = viewMo151YoKzxo2.getMeasuredWidth();
                    i4 -= measuredWidth2;
                    if (i11 == 0) {
                        i11 = measuredWidth2;
                    }
                    z4 = z6 & (!c0047mjFkc.f640Pq ? i4 + i11 <= 0 : i4 < 0);
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i12 = 0; i12 < i10; i12++) {
                        C0006KLFTb c0006KLFTb3 = (C0006KLFTb) arrayListM123VocHEe.get(i12);
                        if (c0006KLFTb3.getGroupId() == groupId2) {
                            if (c0006KLFTb3.m73ETF()) {
                                i8++;
                            }
                            c0006KLFTb3.m86diqgf(false);
                        }
                    }
                }
                if (z4) {
                    i8--;
                }
                c0006KLFTb2.m86diqgf(z4);
                z = false;
            } else {
                z = r3;
                i2 = size;
                c0006KLFTb2.m86diqgf(z);
            }
            i10++;
            r3 = z;
            size = i2;
            view = null;
            c0047mjFkc = this;
        }
        return true;
    }

    /* renamed from: mByQ */
    public void m365mByQ(ActionMenuView actionMenuView) {
        this.f353qdMbNW = actionMenuView;
        actionMenuView.m214Ne(this.f354wA);
    }

    @Override // androidx.appcompat.p010view.p011menu.AbstractC0009mjFkc
    /* renamed from: rkYL */
    public boolean mo155rkYL(int i, C0006KLFTb c0006KLFTb) {
        return c0006KLFTb.m73ETF();
    }

    /* renamed from: vI */
    public boolean m366vI() {
        Object obj;
        wA wAVar = this.f652vI;
        if (wAVar != null && (obj = this.f353qdMbNW) != null) {
            ((View) obj).removeCallbacks(wAVar);
            this.f652vI = null;
            return true;
        }
        KLFTb kLFTb = this.f636Gd;
        if (kLFTb == null) {
            return false;
        }
        kLFTb.m56AZxh();
        return true;
    }

    @Override // androidx.appcompat.p010view.p011menu.AbstractC0009mjFkc, androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: wA */
    public void mo156wA(Context context, C0007ZfxDd c0007ZfxDd) {
        super.mo156wA(context, c0007ZfxDd);
        Resources resources = context.getResources();
        C4068lB c4068lBM12686mjFkc = C4068lB.m12686mjFkc(context);
        if (!this.f644YoKzxo) {
            this.f639MiMN = c4068lBM12686mjFkc.m12688ZfxDd();
        }
        if (!this.f645diqgf) {
            this.f651rkYL = c4068lBM12686mjFkc.m12687AZxh();
        }
        if (!this.f638IEE) {
            this.f647fehf = c4068lBM12686mjFkc.m12689wA();
        }
        int measuredWidth = this.f651rkYL;
        if (this.f639MiMN) {
            if (this.f634Dt == null) {
                ZfxDd zfxDd = new ZfxDd(this.f352mjFkc);
                this.f634Dt = zfxDd;
                if (this.f642VA) {
                    zfxDd.setImageDrawable(this.f635ETF);
                    this.f635ETF = null;
                    this.f642VA = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f634Dt.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f634Dt.getMeasuredWidth();
        } else {
            this.f634Dt = null;
        }
        this.f650qGY = measuredWidth;
        this.f641Ucbh = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    /* renamed from: wJVbdd */
    public void m367wJVbdd(boolean z) {
        this.f646eyqo = z;
    }

    @Override // androidx.appcompat.p010view.p011menu.AbstractC0009mjFkc, androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: xJ */
    public void mo31xJ(boolean z) {
        super.mo31xJ(z);
        ((View) this.f353qdMbNW).requestLayout();
        C0007ZfxDd c0007ZfxDd = this.f354wA;
        boolean z2 = false;
        if (c0007ZfxDd != null) {
            ArrayList arrayListM112IEE = c0007ZfxDd.m112IEE();
            int size = arrayListM112IEE.size();
            for (int i = 0; i < size; i++) {
                ((C0006KLFTb) arrayListM112IEE.get(i)).m97xJ();
            }
        }
        C0007ZfxDd c0007ZfxDd2 = this.f354wA;
        ArrayList arrayListM120Ucbh = c0007ZfxDd2 != null ? c0007ZfxDd2.m120Ucbh() : null;
        if (this.f639MiMN && arrayListM120Ucbh != null) {
            int size2 = arrayListM120Ucbh.size();
            if (size2 == 1) {
                z2 = !((C0006KLFTb) arrayListM120Ucbh.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.f634Dt == null) {
                this.f634Dt = new ZfxDd(this.f352mjFkc);
            }
            ViewGroup viewGroup = (ViewGroup) this.f634Dt.getParent();
            if (viewGroup != this.f353qdMbNW) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f634Dt);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f353qdMbNW;
                actionMenuView.addView(this.f634Dt, actionMenuView.m220mByQ());
            }
        } else {
            ZfxDd zfxDd = this.f634Dt;
            if (zfxDd != null) {
                Object parent = zfxDd.getParent();
                Object obj = this.f353qdMbNW;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f634Dt);
                }
            }
        }
        ((ActionMenuView) this.f353qdMbNW).setOverflowReserved(this.f639MiMN);
    }
}
