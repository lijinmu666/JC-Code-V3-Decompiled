package androidx.appcompat.p012widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.p010view.p011menu.C0006KLFTb;
import androidx.appcompat.p010view.p011menu.C0007ZfxDd;
import androidx.appcompat.p010view.p011menu.InterfaceC0012xJ;
import androidx.appcompat.p010view.p011menu.SubMenuC0004Dt;
import androidx.appcompat.p012widget.ActionMenuView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p094kotlin.p119time.DurationKt;
import p131o.AbstractC1599A1;
import p131o.AbstractC2143I8;
import p131o.AbstractC2876T9;
import p131o.AbstractC3053VocHEe;
import p131o.AbstractC3407b5;
import p131o.AbstractC3862i4;
import p131o.AbstractC4056l;
import p131o.AbstractC4689ua;
import p131o.AbstractC4768vjlshU;
import p131o.AbstractC4796wA;
import p131o.C1606A8;
import p131o.C1622ANMGZc;
import p131o.C2140I5;
import p131o.C2463Moer;
import p131o.C3002V1;
import p131o.C3584dm;
import p131o.C4726v7;
import p131o.InterfaceC2923TvfBiy;
import p131o.InterfaceC3066VzXmn;

/* renamed from: androidx.appcompat.widget.Toolbar */
/* loaded from: classes.dex */
public class C0044Toolbar extends ViewGroup {

    /* renamed from: AZxh */
    public TextView f556AZxh;

    /* renamed from: BAnRFn */
    public boolean f557BAnRFn;

    /* renamed from: CqaNbM */
    public ArrayList f558CqaNbM;

    /* renamed from: Dt */
    public Context f559Dt;

    /* renamed from: ETF */
    public int f560ETF;

    /* renamed from: Gd */
    public CharSequence f561Gd;

    /* renamed from: HGpJ */
    public CharSequence f562HGpJ;

    /* renamed from: IEE */
    public int f563IEE;

    /* renamed from: JHa */
    public Drawable f564JHa;

    /* renamed from: KLFTb */
    public ImageView f565KLFTb;

    /* renamed from: KLMXS */
    public C0046ZfxDd f566KLMXS;

    /* renamed from: MiMN */
    public int f567MiMN;

    /* renamed from: NPj */
    public boolean f568NPj;

    /* renamed from: Ne */
    public final C3002V1 f569Ne;

    /* renamed from: OjSQV */
    public final int[] f570OjSQV;

    /* renamed from: Pq */
    public int f571Pq;

    /* renamed from: Ucbh */
    public int f572Ucbh;

    /* renamed from: VA */
    public int f573VA;

    /* renamed from: Vnb */
    public C0007ZfxDd.mjFkc f574Vnb;

    /* renamed from: VocHEe */
    public ColorStateList f575VocHEe;

    /* renamed from: WrLQs */
    public final Runnable f576WrLQs;

    /* renamed from: YoKzxo */
    public int f577YoKzxo;

    /* renamed from: ZfxDd */
    public ImageButton f578ZfxDd;

    /* renamed from: aqHPIZ */
    public boolean f579aqHPIZ;

    /* renamed from: cMLeY */
    public JHa f580cMLeY;

    /* renamed from: diqgf */
    public C2140I5 f581diqgf;

    /* renamed from: eyqo */
    public int f582eyqo;

    /* renamed from: fehf */
    public int f583fehf;

    /* renamed from: huTpC */
    public int f584huTpC;

    /* renamed from: lB */
    public boolean f585lB;

    /* renamed from: lgHUyS */
    public ImageButton f586lgHUyS;

    /* renamed from: mByQ */
    public final ArrayList f587mByQ;

    /* renamed from: mjFkc */
    public ActionMenuView f588mjFkc;

    /* renamed from: oCFDzJ */
    public OnBackInvokedDispatcher f589oCFDzJ;

    /* renamed from: qGY */
    public int f590qGY;

    /* renamed from: qdMbNW */
    public View f591qdMbNW;

    /* renamed from: rWxwaT */
    public InterfaceC0012xJ.mjFkc f592rWxwaT;

    /* renamed from: rkYL */
    public int f593rkYL;

    /* renamed from: vI */
    public ColorStateList f594vI;

    /* renamed from: vadzgd */
    public OnBackInvokedCallback f595vadzgd;

    /* renamed from: wA */
    public TextView f596wA;

    /* renamed from: wJVbdd */
    public final ArrayList f597wJVbdd;

    /* renamed from: xJ */
    public CharSequence f598xJ;

    /* renamed from: xrEuO */
    public final ActionMenuView.InterfaceC0021KLFTb f599xrEuO;

    /* renamed from: zvd */
    public C0047mjFkc f600zvd;

    /* renamed from: androidx.appcompat.widget.Toolbar$AZxh */
    public class AZxh implements Runnable {
        public AZxh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0044Toolbar.this.m319zvd();
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$JHa */
    public class JHa implements InterfaceC0012xJ {

        /* renamed from: AZxh */
        public C0006KLFTb f602AZxh;

        /* renamed from: mjFkc */
        public C0007ZfxDd f603mjFkc;

        public JHa() {
        }

        @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
        /* renamed from: AZxh */
        public void mo7AZxh(C0007ZfxDd c0007ZfxDd, boolean z) {
        }

        @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
        /* renamed from: ETF */
        public boolean mo148ETF(C0007ZfxDd c0007ZfxDd, C0006KLFTb c0006KLFTb) {
            C0044Toolbar.this.m287KLFTb();
            ViewParent parent = C0044Toolbar.this.f586lgHUyS.getParent();
            C0044Toolbar c0044Toolbar = C0044Toolbar.this;
            if (parent != c0044Toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(c0044Toolbar.f586lgHUyS);
                }
                C0044Toolbar c0044Toolbar2 = C0044Toolbar.this;
                c0044Toolbar2.addView(c0044Toolbar2.f586lgHUyS);
            }
            C0044Toolbar.this.f591qdMbNW = c0006KLFTb.getActionView();
            this.f602AZxh = c0006KLFTb;
            ViewParent parent2 = C0044Toolbar.this.f591qdMbNW.getParent();
            C0044Toolbar c0044Toolbar3 = C0044Toolbar.this;
            if (parent2 != c0044Toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(c0044Toolbar3.f591qdMbNW);
                }
                xJ xJVarGenerateDefaultLayoutParams = C0044Toolbar.this.generateDefaultLayoutParams();
                C0044Toolbar c0044Toolbar4 = C0044Toolbar.this;
                xJVarGenerateDefaultLayoutParams.f11370mjFkc = (c0044Toolbar4.f577YoKzxo & 112) | 8388611;
                xJVarGenerateDefaultLayoutParams.f611AZxh = 2;
                c0044Toolbar4.f591qdMbNW.setLayoutParams(xJVarGenerateDefaultLayoutParams);
                C0044Toolbar c0044Toolbar5 = C0044Toolbar.this;
                c0044Toolbar5.addView(c0044Toolbar5.f591qdMbNW);
            }
            C0044Toolbar.this.m307mByQ();
            C0044Toolbar.this.requestLayout();
            c0006KLFTb.m88fehf(true);
            KeyEvent.Callback callback = C0044Toolbar.this.f591qdMbNW;
            if (callback instanceof InterfaceC2923TvfBiy) {
                ((InterfaceC2923TvfBiy) callback).mo232AZxh();
            }
            C0044Toolbar.this.m298cMLeY();
            return true;
        }

        @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
        /* renamed from: JHa */
        public boolean mo11JHa(SubMenuC0004Dt subMenuC0004Dt) {
            return false;
        }

        @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
        /* renamed from: lgHUyS */
        public boolean mo27lgHUyS() {
            return false;
        }

        @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
        /* renamed from: qdMbNW */
        public boolean mo154qdMbNW(C0007ZfxDd c0007ZfxDd, C0006KLFTb c0006KLFTb) {
            KeyEvent.Callback callback = C0044Toolbar.this.f591qdMbNW;
            if (callback instanceof InterfaceC2923TvfBiy) {
                ((InterfaceC2923TvfBiy) callback).mo240KLFTb();
            }
            C0044Toolbar c0044Toolbar = C0044Toolbar.this;
            c0044Toolbar.removeView(c0044Toolbar.f591qdMbNW);
            C0044Toolbar c0044Toolbar2 = C0044Toolbar.this;
            c0044Toolbar2.removeView(c0044Toolbar2.f586lgHUyS);
            C0044Toolbar c0044Toolbar3 = C0044Toolbar.this;
            c0044Toolbar3.f591qdMbNW = null;
            c0044Toolbar3.m308mjFkc();
            this.f602AZxh = null;
            C0044Toolbar.this.requestLayout();
            c0006KLFTb.m88fehf(false);
            C0044Toolbar.this.m298cMLeY();
            return true;
        }

        @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
        /* renamed from: wA */
        public void mo156wA(Context context, C0007ZfxDd c0007ZfxDd) {
            C0006KLFTb c0006KLFTb;
            C0007ZfxDd c0007ZfxDd2 = this.f603mjFkc;
            if (c0007ZfxDd2 != null && (c0006KLFTb = this.f602AZxh) != null) {
                c0007ZfxDd2.mo49KLFTb(c0006KLFTb);
            }
            this.f603mjFkc = c0007ZfxDd;
        }

        @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
        /* renamed from: xJ */
        public void mo31xJ(boolean z) {
            if (this.f602AZxh != null) {
                C0007ZfxDd c0007ZfxDd = this.f603mjFkc;
                if (c0007ZfxDd != null) {
                    int size = c0007ZfxDd.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f603mjFkc.getItem(i) == this.f602AZxh) {
                            return;
                        }
                    }
                }
                mo154qdMbNW(this.f603mjFkc, this.f602AZxh);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$KLFTb */
    public static class KLFTb {
        /* renamed from: AZxh */
        public static OnBackInvokedCallback m320AZxh(final Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new OnBackInvokedCallback() { // from class: o.G8
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    runnable.run();
                }
            };
        }

        /* renamed from: ZfxDd */
        public static void m321ZfxDd(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }

        /* renamed from: mjFkc */
        public static OnBackInvokedDispatcher m322mjFkc(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        /* renamed from: wA */
        public static void m323wA(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(DurationKt.NANOS_IN_MILLIS, (OnBackInvokedCallback) obj2);
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$ZfxDd */
    public class ZfxDd implements View.OnClickListener {
        public ZfxDd() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C0044Toolbar.this.m297ZfxDd();
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$lgHUyS */
    public interface lgHUyS {
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$mjFkc */
    public class mjFkc implements ActionMenuView.InterfaceC0021KLFTb {
        public mjFkc() {
        }

        @Override // androidx.appcompat.p012widget.ActionMenuView.InterfaceC0021KLFTb
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (C0044Toolbar.this.f569Ne.m10654AZxh(menuItem)) {
                return true;
            }
            C0044Toolbar.this.getClass();
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$wA */
    public class wA implements C0007ZfxDd.mjFkc {
        public wA() {
        }

        @Override // androidx.appcompat.p010view.p011menu.C0007ZfxDd.mjFkc
        /* renamed from: AZxh */
        public void mo145AZxh(C0007ZfxDd c0007ZfxDd) {
            if (!C0044Toolbar.this.f588mjFkc.m212CqaNbM()) {
                C0044Toolbar.this.f569Ne.m10656wA(c0007ZfxDd);
            }
            C0007ZfxDd.mjFkc mjfkc = C0044Toolbar.this.f574Vnb;
            if (mjfkc != null) {
                mjfkc.mo145AZxh(c0007ZfxDd);
            }
        }

        @Override // androidx.appcompat.p010view.p011menu.C0007ZfxDd.mjFkc
        /* renamed from: mjFkc */
        public boolean mo146mjFkc(C0007ZfxDd c0007ZfxDd, MenuItem menuItem) {
            C0007ZfxDd.mjFkc mjfkc = C0044Toolbar.this.f574Vnb;
            return mjfkc != null && mjfkc.mo146mjFkc(c0007ZfxDd, menuItem);
        }
    }

    public C0044Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3862i4.f14113diqgf);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menuM303getMenu = m303getMenu();
        for (int i = 0; i < menuM303getMenu.size(); i++) {
            arrayList.add(menuM303getMenu.getItem(i));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new C4726v7(getContext());
    }

    /* renamed from: AZxh */
    public final void m278AZxh(List list, int i) {
        boolean z = AbstractC2876T9.m10276huTpC(this) == 1;
        int childCount = getChildCount();
        int iM12647AZxh = AbstractC4056l.m12647AZxh(i, AbstractC2876T9.m10276huTpC(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                xJ xJVar = (xJ) childAt.getLayoutParams();
                if (xJVar.f611AZxh == 0 && m288KLMXS(childAt) && m296YoKzxo(xJVar.f11370mjFkc) == iM12647AZxh) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            xJ xJVar2 = (xJ) childAt2.getLayoutParams();
            if (xJVar2.f611AZxh == 0 && m288KLMXS(childAt2) && m296YoKzxo(xJVar2.f11370mjFkc) == iM12647AZxh) {
                list.add(childAt2);
            }
        }
    }

    /* renamed from: BAnRFn */
    public final void m279BAnRFn(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* renamed from: CqaNbM */
    public void m280CqaNbM(Context context, int i) {
        this.f573VA = i;
        TextView textView = this.f556AZxh;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    /* renamed from: Dt */
    public final void m281Dt() {
        if (this.f578ZfxDd == null) {
            this.f578ZfxDd = new C1622ANMGZc(getContext(), null, AbstractC3862i4.f14109Pq);
            xJ xJVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            xJVarGenerateDefaultLayoutParams.f11370mjFkc = (this.f577YoKzxo & 112) | 8388611;
            this.f578ZfxDd.setLayoutParams(xJVarGenerateDefaultLayoutParams);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: ETF, reason: merged with bridge method [inline-methods] */
    public xJ generateDefaultLayoutParams() {
        return new xJ(-2, -2);
    }

    /* renamed from: Gd */
    public boolean m283Gd() {
        ActionMenuView actionMenuView = this.f588mjFkc;
        return actionMenuView != null && actionMenuView.m212CqaNbM();
    }

    /* renamed from: HGpJ */
    public final int m284HGpJ(View view, int i, int[] iArr, int i2) {
        xJ xJVar = (xJ) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) xJVar).leftMargin - iArr[0];
        int iMax = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int iM311rkYL = m311rkYL(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iM311rkYL, iMax + measuredWidth, view.getMeasuredHeight() + iM311rkYL);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) xJVar).rightMargin;
    }

    /* renamed from: IEE */
    public final int m285IEE(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    /* renamed from: JHa */
    public final void m286JHa() {
        if (this.f581diqgf == null) {
            this.f581diqgf = new C2140I5();
        }
    }

    /* renamed from: KLFTb */
    public void m287KLFTb() {
        if (this.f586lgHUyS == null) {
            C1622ANMGZc c1622ANMGZc = new C1622ANMGZc(getContext(), null, AbstractC3862i4.f14109Pq);
            this.f586lgHUyS = c1622ANMGZc;
            c1622ANMGZc.setImageDrawable(this.f564JHa);
            this.f586lgHUyS.setContentDescription(this.f598xJ);
            xJ xJVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            xJVarGenerateDefaultLayoutParams.f11370mjFkc = (this.f577YoKzxo & 112) | 8388611;
            xJVarGenerateDefaultLayoutParams.f611AZxh = 2;
            this.f586lgHUyS.setLayoutParams(xJVarGenerateDefaultLayoutParams);
            this.f586lgHUyS.setOnClickListener(new ZfxDd());
        }
    }

    /* renamed from: KLMXS */
    public final boolean m288KLMXS(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    @Override // android.view.ViewGroup
    /* renamed from: MiMN, reason: merged with bridge method [inline-methods] */
    public xJ generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof xJ ? new xJ((xJ) layoutParams) : layoutParams instanceof AbstractC3053VocHEe ? new xJ((AbstractC3053VocHEe) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new xJ((ViewGroup.MarginLayoutParams) layoutParams) : new xJ(layoutParams);
    }

    /* renamed from: Ne */
    public void m290Ne(Context context, int i) {
        this.f567MiMN = i;
        TextView textView = this.f596wA;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    /* renamed from: OjSQV */
    public void m291OjSQV(int i, int i2) {
        m286JHa();
        this.f581diqgf.m8655xJ(i, i2);
    }

    /* renamed from: Pq */
    public final int m292Pq(List list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int measuredWidth = 0;
        while (i3 < size) {
            View view = (View) list.get(i3);
            xJ xJVar = (xJ) view.getLayoutParams();
            int i4 = ((ViewGroup.MarginLayoutParams) xJVar).leftMargin - i;
            int i5 = ((ViewGroup.MarginLayoutParams) xJVar).rightMargin - i2;
            int iMax = Math.max(0, i4);
            int iMax2 = Math.max(0, i5);
            int iMax3 = Math.max(0, -i4);
            int iMax4 = Math.max(0, -i5);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i3++;
            i2 = iMax4;
            i = iMax3;
        }
        return measuredWidth;
    }

    /* renamed from: Ucbh */
    public void m293Ucbh() {
        Iterator it = this.f558CqaNbM.iterator();
        while (it.hasNext()) {
            m303getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        m305lB();
    }

    @Override // android.view.ViewGroup
    /* renamed from: VA, reason: merged with bridge method [inline-methods] */
    public xJ generateLayoutParams(AttributeSet attributeSet) {
        return new xJ(getContext(), attributeSet);
    }

    /* renamed from: VocHEe */
    public final int m295VocHEe(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + iMax + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    /* renamed from: YoKzxo */
    public final int m296YoKzxo(int i) {
        int iM10276huTpC = AbstractC2876T9.m10276huTpC(this);
        int iM12647AZxh = AbstractC4056l.m12647AZxh(i, iM10276huTpC) & 7;
        return (iM12647AZxh == 1 || iM12647AZxh == 3 || iM12647AZxh == 5) ? iM12647AZxh : iM10276huTpC == 1 ? 5 : 3;
    }

    /* renamed from: ZfxDd */
    public void m297ZfxDd() {
        JHa jHa = this.f580cMLeY;
        C0006KLFTb c0006KLFTb = jHa == null ? null : jHa.f602AZxh;
        if (c0006KLFTb != null) {
            c0006KLFTb.collapseActionView();
        }
    }

    /* renamed from: cMLeY */
    public void m298cMLeY() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherM322mjFkc = KLFTb.m322mjFkc(this);
            boolean z = m299diqgf() && onBackInvokedDispatcherM322mjFkc != null && AbstractC2876T9.m10268cMLeY(this) && this.f579aqHPIZ;
            if (z && this.f589oCFDzJ == null) {
                if (this.f595vadzgd == null) {
                    this.f595vadzgd = KLFTb.m320AZxh(new Runnable() { // from class: o.E8
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f7964mjFkc.m297ZfxDd();
                        }
                    });
                }
                KLFTb.m323wA(onBackInvokedDispatcherM322mjFkc, this.f595vadzgd);
                this.f589oCFDzJ = onBackInvokedDispatcherM322mjFkc;
                return;
            }
            if (z || (onBackInvokedDispatcher = this.f589oCFDzJ) == null) {
                return;
            }
            KLFTb.m321ZfxDd(onBackInvokedDispatcher, this.f595vadzgd);
            this.f589oCFDzJ = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof xJ);
    }

    /* renamed from: diqgf */
    public boolean m299diqgf() {
        JHa jHa = this.f580cMLeY;
        return (jHa == null || jHa.f602AZxh == null) ? false : true;
    }

    /* renamed from: eyqo */
    public void mo300eyqo(int i) {
        getMenuInflater().inflate(i, m303getMenu());
    }

    /* renamed from: fehf */
    public final int m301fehf(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return AbstractC1599A1.m7546AZxh(marginLayoutParams) + AbstractC1599A1.m7548mjFkc(marginLayoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f586lgHUyS;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f586lgHUyS;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        C2140I5 c2140i5 = this.f581diqgf;
        if (c2140i5 != null) {
            return c2140i5.m8653mjFkc();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.f572Ucbh;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        C2140I5 c2140i5 = this.f581diqgf;
        if (c2140i5 != null) {
            return c2140i5.m8649AZxh();
        }
        return 0;
    }

    public int getContentInsetRight() {
        C2140I5 c2140i5 = this.f581diqgf;
        if (c2140i5 != null) {
            return c2140i5.m8654wA();
        }
        return 0;
    }

    public int getContentInsetStart() {
        C2140I5 c2140i5 = this.f581diqgf;
        if (c2140i5 != null) {
            return c2140i5.m8652ZfxDd();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.f582eyqo;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        C0007ZfxDd c0007ZfxDdM223zvd;
        ActionMenuView actionMenuView = this.f588mjFkc;
        return (actionMenuView == null || (c0007ZfxDdM223zvd = actionMenuView.m223zvd()) == null || !c0007ZfxDdM223zvd.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f572Ucbh, 0));
    }

    public int getCurrentContentInsetLeft() {
        return AbstractC2876T9.m10276huTpC(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return AbstractC2876T9.m10276huTpC(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f582eyqo, 0)) : getContentInsetStart();
    }

    /* renamed from: getLogo */
    public Drawable m302getLogo() {
        ImageView imageView = this.f565KLFTb;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f565KLFTb;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    /* renamed from: getMenu */
    public Menu m303getMenu() {
        m306lgHUyS();
        return this.f588mjFkc.m218getMenu();
    }

    public View getNavButtonView() {
        return this.f578ZfxDd;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f578ZfxDd;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f578ZfxDd;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public C0047mjFkc getOuterActionMenuPresenter() {
        return this.f600zvd;
    }

    public Drawable getOverflowIcon() {
        m306lgHUyS();
        return this.f588mjFkc.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f559Dt;
    }

    public int getPopupTheme() {
        return this.f560ETF;
    }

    public CharSequence getSubtitle() {
        return this.f562HGpJ;
    }

    public final TextView getSubtitleTextView() {
        return this.f596wA;
    }

    public CharSequence getTitle() {
        return this.f561Gd;
    }

    public int getTitleMarginBottom() {
        return this.f571Pq;
    }

    public int getTitleMarginEnd() {
        return this.f583fehf;
    }

    public int getTitleMarginStart() {
        return this.f590qGY;
    }

    public int getTitleMarginTop() {
        return this.f563IEE;
    }

    public final TextView getTitleTextView() {
        return this.f556AZxh;
    }

    public InterfaceC3066VzXmn getWrapper() {
        if (this.f566KLMXS == null) {
            this.f566KLMXS = new C0046ZfxDd(this, true);
        }
        return this.f566KLMXS;
    }

    /* renamed from: huTpC */
    public final boolean m304huTpC(View view) {
        return view.getParent() == this || this.f587mByQ.contains(view);
    }

    /* renamed from: lB */
    public final void m305lB() {
        Menu menuM303getMenu = m303getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.f569Ne.m10655mjFkc(menuM303getMenu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f558CqaNbM = currentMenuItems2;
    }

    /* renamed from: lgHUyS */
    public final void m306lgHUyS() {
        m310qdMbNW();
        if (this.f588mjFkc.m223zvd() == null) {
            C0007ZfxDd c0007ZfxDd = (C0007ZfxDd) this.f588mjFkc.m218getMenu();
            if (this.f580cMLeY == null) {
                this.f580cMLeY = new JHa();
            }
            this.f588mjFkc.setExpandedActionViewsExclusive(true);
            c0007ZfxDd.m107AZxh(this.f580cMLeY, this.f559Dt);
            m298cMLeY();
        }
    }

    /* renamed from: mByQ */
    public void m307mByQ() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((xJ) childAt.getLayoutParams()).f611AZxh != 2 && childAt != this.f588mjFkc) {
                removeViewAt(childCount);
                this.f587mByQ.add(childAt);
            }
        }
    }

    /* renamed from: mjFkc */
    public void m308mjFkc() {
        for (int size = this.f587mByQ.size() - 1; size >= 0; size--) {
            addView((View) this.f587mByQ.get(size));
        }
        this.f587mByQ.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m298cMLeY();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f576WrLQs);
        m298cMLeY();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f585lB = false;
        }
        if (!this.f585lB) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f585lB = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f585lB = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x02a1 A[LOOP:0: B:106:0x029f->B:107:0x02a1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02c3 A[LOOP:1: B:109:0x02c1->B:110:0x02c3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02fc A[LOOP:2: B:118:0x02fa->B:119:0x02fc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0227  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iM284HGpJ;
        int iM314vI;
        boolean zM288KLMXS;
        boolean zM288KLMXS2;
        int i5;
        int measuredHeight;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int paddingTop;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int size;
        int iM284HGpJ2;
        int i16;
        int size2;
        int i17;
        int i18;
        int size3;
        boolean z2 = AbstractC2876T9.m10276huTpC(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i19 = width - paddingRight;
        int[] iArr = this.f570OjSQV;
        iArr[1] = 0;
        iArr[0] = 0;
        int iM10229Gd = AbstractC2876T9.m10229Gd(this);
        int iMin = iM10229Gd >= 0 ? Math.min(iM10229Gd, i4 - i2) : 0;
        if (!m288KLMXS(this.f578ZfxDd)) {
            iM284HGpJ = paddingLeft;
        } else {
            if (z2) {
                iM314vI = m314vI(this.f578ZfxDd, i19, iArr, iMin);
                iM284HGpJ = paddingLeft;
                if (m288KLMXS(this.f586lgHUyS)) {
                    if (z2) {
                        iM314vI = m314vI(this.f586lgHUyS, iM314vI, iArr, iMin);
                    } else {
                        iM284HGpJ = m284HGpJ(this.f586lgHUyS, iM284HGpJ, iArr, iMin);
                    }
                }
                if (m288KLMXS(this.f588mjFkc)) {
                    if (z2) {
                        iM284HGpJ = m284HGpJ(this.f588mjFkc, iM284HGpJ, iArr, iMin);
                    } else {
                        iM314vI = m314vI(this.f588mjFkc, iM314vI, iArr, iMin);
                    }
                }
                int currentContentInsetLeft = getCurrentContentInsetLeft();
                int currentContentInsetRight = getCurrentContentInsetRight();
                iArr[0] = Math.max(0, currentContentInsetLeft - iM284HGpJ);
                iArr[1] = Math.max(0, currentContentInsetRight - (i19 - iM314vI));
                int iMax = Math.max(iM284HGpJ, currentContentInsetLeft);
                int iMin2 = Math.min(iM314vI, i19 - currentContentInsetRight);
                if (m288KLMXS(this.f591qdMbNW)) {
                    if (z2) {
                        iMin2 = m314vI(this.f591qdMbNW, iMin2, iArr, iMin);
                    } else {
                        iMax = m284HGpJ(this.f591qdMbNW, iMax, iArr, iMin);
                    }
                }
                if (m288KLMXS(this.f565KLFTb)) {
                    if (z2) {
                        iMin2 = m314vI(this.f565KLFTb, iMin2, iArr, iMin);
                    } else {
                        iMax = m284HGpJ(this.f565KLFTb, iMax, iArr, iMin);
                    }
                }
                zM288KLMXS = m288KLMXS(this.f556AZxh);
                zM288KLMXS2 = m288KLMXS(this.f596wA);
                if (zM288KLMXS) {
                    i5 = paddingRight;
                    measuredHeight = 0;
                } else {
                    xJ xJVar = (xJ) this.f556AZxh.getLayoutParams();
                    i5 = paddingRight;
                    measuredHeight = ((ViewGroup.MarginLayoutParams) xJVar).topMargin + this.f556AZxh.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) xJVar).bottomMargin;
                }
                if (zM288KLMXS2) {
                    i6 = width;
                } else {
                    xJ xJVar2 = (xJ) this.f596wA.getLayoutParams();
                    i6 = width;
                    measuredHeight += ((ViewGroup.MarginLayoutParams) xJVar2).topMargin + this.f596wA.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) xJVar2).bottomMargin;
                }
                if (!zM288KLMXS || zM288KLMXS2) {
                    TextView textView = !zM288KLMXS ? this.f556AZxh : this.f596wA;
                    TextView textView2 = !zM288KLMXS2 ? this.f596wA : this.f556AZxh;
                    xJ xJVar3 = (xJ) textView.getLayoutParams();
                    xJ xJVar4 = (xJ) textView2.getLayoutParams();
                    boolean z3 = (zM288KLMXS && this.f556AZxh.getMeasuredWidth() > 0) || (zM288KLMXS2 && this.f596wA.getMeasuredWidth() > 0);
                    i7 = this.f584huTpC & 112;
                    i8 = paddingLeft;
                    if (i7 == 48) {
                        i9 = iMax;
                        i10 = iMin;
                        paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) xJVar3).topMargin + this.f563IEE;
                    } else if (i7 != 80) {
                        int iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                        int i20 = ((ViewGroup.MarginLayoutParams) xJVar3).topMargin;
                        i10 = iMin;
                        int i21 = this.f563IEE;
                        i9 = iMax;
                        if (iMax2 < i20 + i21) {
                            iMax2 = i20 + i21;
                        } else {
                            int i22 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                            int i23 = ((ViewGroup.MarginLayoutParams) xJVar3).bottomMargin;
                            int i24 = this.f571Pq;
                            if (i22 < i23 + i24) {
                                iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) xJVar4).bottomMargin + i24) - i22));
                            }
                        }
                        paddingTop = paddingTop2 + iMax2;
                    } else {
                        i9 = iMax;
                        i10 = iMin;
                        paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) xJVar4).bottomMargin) - this.f571Pq) - measuredHeight;
                    }
                    if (!z2) {
                        i11 = 0;
                        int i25 = (z3 ? this.f590qGY : 0) - iArr[0];
                        iMax = i9 + Math.max(0, i25);
                        iArr[0] = Math.max(0, -i25);
                        if (zM288KLMXS) {
                            xJ xJVar5 = (xJ) this.f556AZxh.getLayoutParams();
                            int measuredWidth = this.f556AZxh.getMeasuredWidth() + iMax;
                            int measuredHeight2 = this.f556AZxh.getMeasuredHeight() + paddingTop;
                            this.f556AZxh.layout(iMax, paddingTop, measuredWidth, measuredHeight2);
                            i12 = measuredWidth + this.f583fehf;
                            paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) xJVar5).bottomMargin;
                        } else {
                            i12 = iMax;
                        }
                        if (zM288KLMXS2) {
                            int i26 = paddingTop + ((ViewGroup.MarginLayoutParams) ((xJ) this.f596wA.getLayoutParams())).topMargin;
                            int measuredWidth2 = this.f596wA.getMeasuredWidth() + iMax;
                            this.f596wA.layout(iMax, i26, measuredWidth2, this.f596wA.getMeasuredHeight() + i26);
                            i13 = measuredWidth2 + this.f583fehf;
                        } else {
                            i13 = iMax;
                        }
                        if (z3) {
                            iMax = Math.max(i12, i13);
                        }
                        m278AZxh(this.f597wJVbdd, 3);
                        size = this.f597wJVbdd.size();
                        iM284HGpJ2 = iMax;
                        for (i16 = i11; i16 < size; i16++) {
                            iM284HGpJ2 = m284HGpJ((View) this.f597wJVbdd.get(i16), iM284HGpJ2, iArr, i10);
                        }
                        int i27 = i10;
                        m278AZxh(this.f597wJVbdd, 5);
                        size2 = this.f597wJVbdd.size();
                        for (i17 = i11; i17 < size2; i17++) {
                            iMin2 = m314vI((View) this.f597wJVbdd.get(i17), iMin2, iArr, i27);
                        }
                        m278AZxh(this.f597wJVbdd, 1);
                        int iM292Pq = m292Pq(this.f597wJVbdd, iArr);
                        i18 = (i8 + (((i6 - i8) - i5) / 2)) - (iM292Pq / 2);
                        int i28 = iM292Pq + i18;
                        if (i18 >= iM284HGpJ2) {
                            iM284HGpJ2 = i28 > iMin2 ? i18 - (i28 - iMin2) : i18;
                        }
                        size3 = this.f597wJVbdd.size();
                        while (i11 < size3) {
                            iM284HGpJ2 = m284HGpJ((View) this.f597wJVbdd.get(i11), iM284HGpJ2, iArr, i27);
                            i11++;
                        }
                        this.f597wJVbdd.clear();
                    }
                    int i29 = (z3 ? this.f590qGY : 0) - iArr[1];
                    iMin2 -= Math.max(0, i29);
                    iArr[1] = Math.max(0, -i29);
                    if (zM288KLMXS) {
                        xJ xJVar6 = (xJ) this.f556AZxh.getLayoutParams();
                        int measuredWidth3 = iMin2 - this.f556AZxh.getMeasuredWidth();
                        int measuredHeight3 = this.f556AZxh.getMeasuredHeight() + paddingTop;
                        this.f556AZxh.layout(measuredWidth3, paddingTop, iMin2, measuredHeight3);
                        i14 = measuredWidth3 - this.f583fehf;
                        paddingTop = measuredHeight3 + ((ViewGroup.MarginLayoutParams) xJVar6).bottomMargin;
                    } else {
                        i14 = iMin2;
                    }
                    if (zM288KLMXS2) {
                        int i30 = paddingTop + ((ViewGroup.MarginLayoutParams) ((xJ) this.f596wA.getLayoutParams())).topMargin;
                        this.f596wA.layout(iMin2 - this.f596wA.getMeasuredWidth(), i30, iMin2, this.f596wA.getMeasuredHeight() + i30);
                        i15 = iMin2 - this.f583fehf;
                    } else {
                        i15 = iMin2;
                    }
                    if (z3) {
                        iMin2 = Math.min(i14, i15);
                    }
                    iMax = i9;
                } else {
                    i8 = paddingLeft;
                    i10 = iMin;
                }
                i11 = 0;
                m278AZxh(this.f597wJVbdd, 3);
                size = this.f597wJVbdd.size();
                iM284HGpJ2 = iMax;
                while (i16 < size) {
                }
                int i272 = i10;
                m278AZxh(this.f597wJVbdd, 5);
                size2 = this.f597wJVbdd.size();
                while (i17 < size2) {
                }
                m278AZxh(this.f597wJVbdd, 1);
                int iM292Pq2 = m292Pq(this.f597wJVbdd, iArr);
                i18 = (i8 + (((i6 - i8) - i5) / 2)) - (iM292Pq2 / 2);
                int i282 = iM292Pq2 + i18;
                if (i18 >= iM284HGpJ2) {
                }
                size3 = this.f597wJVbdd.size();
                while (i11 < size3) {
                }
                this.f597wJVbdd.clear();
            }
            iM284HGpJ = m284HGpJ(this.f578ZfxDd, paddingLeft, iArr, iMin);
        }
        iM314vI = i19;
        if (m288KLMXS(this.f586lgHUyS)) {
        }
        if (m288KLMXS(this.f588mjFkc)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - iM284HGpJ);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i19 - iM314vI));
        int iMax3 = Math.max(iM284HGpJ, currentContentInsetLeft2);
        int iMin22 = Math.min(iM314vI, i19 - currentContentInsetRight2);
        if (m288KLMXS(this.f591qdMbNW)) {
        }
        if (m288KLMXS(this.f565KLFTb)) {
        }
        zM288KLMXS = m288KLMXS(this.f556AZxh);
        zM288KLMXS2 = m288KLMXS(this.f596wA);
        if (zM288KLMXS) {
        }
        if (zM288KLMXS2) {
        }
        if (zM288KLMXS) {
            if (!zM288KLMXS) {
            }
            if (!zM288KLMXS2) {
            }
            xJ xJVar32 = (xJ) textView.getLayoutParams();
            xJ xJVar42 = (xJ) textView2.getLayoutParams();
            if (zM288KLMXS) {
                i7 = this.f584huTpC & 112;
                i8 = paddingLeft;
                if (i7 == 48) {
                }
                if (!z2) {
                }
            } else {
                i7 = this.f584huTpC & 112;
                i8 = paddingLeft;
                if (i7 == 48) {
                }
                if (!z2) {
                }
            }
        }
        m278AZxh(this.f597wJVbdd, 3);
        size = this.f597wJVbdd.size();
        iM284HGpJ2 = iMax3;
        while (i16 < size) {
        }
        int i2722 = i10;
        m278AZxh(this.f597wJVbdd, 5);
        size2 = this.f597wJVbdd.size();
        while (i17 < size2) {
        }
        m278AZxh(this.f597wJVbdd, 1);
        int iM292Pq22 = m292Pq(this.f597wJVbdd, iArr);
        i18 = (i8 + (((i6 - i8) - i5) / 2)) - (iM292Pq22 / 2);
        int i2822 = iM292Pq22 + i18;
        if (i18 >= iM284HGpJ2) {
        }
        size3 = this.f597wJVbdd.size();
        while (i11 < size3) {
        }
        this.f597wJVbdd.clear();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int measuredHeight;
        int iCombineMeasuredStates2;
        int iMax2;
        int[] iArr = this.f570OjSQV;
        boolean zM13718mjFkc = AbstractC4689ua.m13718mjFkc(this);
        int i3 = !zM13718mjFkc ? 1 : 0;
        if (m288KLMXS(this.f578ZfxDd)) {
            m279BAnRFn(this.f578ZfxDd, i, 0, i2, 0, this.f593rkYL);
            measuredWidth = this.f578ZfxDd.getMeasuredWidth() + m301fehf(this.f578ZfxDd);
            iMax = Math.max(0, this.f578ZfxDd.getMeasuredHeight() + m285IEE(this.f578ZfxDd));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f578ZfxDd.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (m288KLMXS(this.f586lgHUyS)) {
            m279BAnRFn(this.f586lgHUyS, i, 0, i2, 0, this.f593rkYL);
            measuredWidth = this.f586lgHUyS.getMeasuredWidth() + m301fehf(this.f586lgHUyS);
            iMax = Math.max(iMax, this.f586lgHUyS.getMeasuredHeight() + m285IEE(this.f586lgHUyS));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f586lgHUyS.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth);
        iArr[zM13718mjFkc ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (m288KLMXS(this.f588mjFkc)) {
            m279BAnRFn(this.f588mjFkc, i, iMax3, i2, 0, this.f593rkYL);
            measuredWidth2 = this.f588mjFkc.getMeasuredWidth() + m301fehf(this.f588mjFkc);
            iMax = Math.max(iMax, this.f588mjFkc.getMeasuredHeight() + m285IEE(this.f588mjFkc));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f588mjFkc.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[i3] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (m288KLMXS(this.f591qdMbNW)) {
            iMax4 += m295VocHEe(this.f591qdMbNW, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.f591qdMbNW.getMeasuredHeight() + m285IEE(this.f591qdMbNW));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f591qdMbNW.getMeasuredState());
        }
        if (m288KLMXS(this.f565KLFTb)) {
            iMax4 += m295VocHEe(this.f565KLFTb, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.f565KLFTb.getMeasuredHeight() + m285IEE(this.f565KLFTb));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f565KLFTb.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (((xJ) childAt.getLayoutParams()).f611AZxh == 0 && m288KLMXS(childAt)) {
                iMax4 += m295VocHEe(childAt, i, iMax4, i2, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + m285IEE(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i5 = this.f563IEE + this.f571Pq;
        int i6 = this.f590qGY + this.f583fehf;
        if (m288KLMXS(this.f556AZxh)) {
            m295VocHEe(this.f556AZxh, i, iMax4 + i6, i2, i5, iArr);
            int measuredWidth3 = this.f556AZxh.getMeasuredWidth() + m301fehf(this.f556AZxh);
            measuredHeight = this.f556AZxh.getMeasuredHeight() + m285IEE(this.f556AZxh);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f556AZxh.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            measuredHeight = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (m288KLMXS(this.f596wA)) {
            iMax2 = Math.max(iMax2, m295VocHEe(this.f596wA, i, iMax4 + i6, i2, measuredHeight + i5, iArr));
            measuredHeight += this.f596wA.getMeasuredHeight() + m285IEE(this.f596wA);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f596wA.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2), m318xrEuO() ? 0 : View.resolveSizeAndState(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof qdMbNW)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        qdMbNW qdmbnw = (qdMbNW) parcelable;
        super.onRestoreInstanceState(qdmbnw.m13824mjFkc());
        ActionMenuView actionMenuView = this.f588mjFkc;
        C0007ZfxDd c0007ZfxDdM223zvd = actionMenuView != null ? actionMenuView.m223zvd() : null;
        int i = qdmbnw.f609wA;
        if (i != 0 && this.f580cMLeY != null && c0007ZfxDdM223zvd != null && (menuItemFindItem = c0007ZfxDdM223zvd.findItem(i)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (qdmbnw.f608ZfxDd) {
            m316wJVbdd();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        m286JHa();
        this.f581diqgf.m8650JHa(i == 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        C0006KLFTb c0006KLFTb;
        qdMbNW qdmbnw = new qdMbNW(super.onSaveInstanceState());
        JHa jHa = this.f580cMLeY;
        if (jHa != null && (c0006KLFTb = jHa.f602AZxh) != null) {
            qdmbnw.f609wA = c0006KLFTb.getItemId();
        }
        qdmbnw.f608ZfxDd = m283Gd();
        return qdmbnw;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f557BAnRFn = false;
        }
        if (!this.f557BAnRFn) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f557BAnRFn = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f557BAnRFn = false;
        }
        return true;
    }

    /* renamed from: qGY */
    public final int m309qGY(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.f584huTpC & 112;
    }

    /* renamed from: qdMbNW */
    public final void m310qdMbNW() {
        if (this.f588mjFkc == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f588mjFkc = actionMenuView;
            actionMenuView.setPopupTheme(this.f560ETF);
            this.f588mjFkc.setOnMenuItemClickListener(this.f599xrEuO);
            this.f588mjFkc.m217cMLeY(this.f592rWxwaT, new wA());
            xJ xJVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            xJVarGenerateDefaultLayoutParams.f11370mjFkc = (this.f577YoKzxo & 112) | 8388613;
            this.f588mjFkc.setLayoutParams(xJVarGenerateDefaultLayoutParams);
            m315wA(this.f588mjFkc, false);
        }
    }

    /* renamed from: rkYL */
    public final int m311rkYL(View view, int i) {
        xJ xJVar = (xJ) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int iM309qGY = m309qGY(xJVar.f11370mjFkc);
        if (iM309qGY == 48) {
            return getPaddingTop() - i2;
        }
        if (iM309qGY == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) xJVar).bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i3 = ((ViewGroup.MarginLayoutParams) xJVar).topMargin;
        if (iMax < i3) {
            iMax = i3;
        } else {
            int i4 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i5 = ((ViewGroup.MarginLayoutParams) xJVar).bottomMargin;
            if (i4 < i5) {
                iMax = Math.max(0, iMax - (i5 - i4));
            }
        }
        return paddingTop + iMax;
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.f579aqHPIZ != z) {
            this.f579aqHPIZ = z;
            m298cMLeY();
        }
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(AbstractC4768vjlshU.m13794AZxh(getContext(), i));
    }

    public void setCollapsible(boolean z) {
        this.f568NPj = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f572Ucbh) {
            this.f572Ucbh = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f582eyqo) {
            this.f582eyqo = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    /* renamed from: setLogo */
    public void m312setLogo(int i) {
        m313setLogo(AbstractC4768vjlshU.m13794AZxh(getContext(), i));
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(AbstractC4768vjlshU.m13794AZxh(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m281Dt();
        this.f578ZfxDd.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(lgHUyS lghuys) {
    }

    public void setOverflowIcon(Drawable drawable) {
        m306lgHUyS();
        this.f588mjFkc.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f560ETF != i) {
            this.f560ETF = i;
            if (i == 0) {
                this.f559Dt = getContext();
            } else {
                this.f559Dt = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleMarginBottom(int i) {
        this.f571Pq = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.f583fehf = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.f590qGY = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.f563IEE = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    /* renamed from: vI */
    public final int m314vI(View view, int i, int[] iArr, int i2) {
        xJ xJVar = (xJ) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) xJVar).rightMargin - iArr[1];
        int iMax = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int iM311rkYL = m311rkYL(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iM311rkYL, iMax, view.getMeasuredHeight() + iM311rkYL);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) xJVar).leftMargin);
    }

    /* renamed from: wA */
    public final void m315wA(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        xJ xJVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (xJ) layoutParams;
        xJVarGenerateDefaultLayoutParams.f611AZxh = 1;
        if (!z || this.f591qdMbNW == null) {
            addView(view, xJVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(xJVarGenerateDefaultLayoutParams);
            this.f587mByQ.add(view);
        }
    }

    /* renamed from: wJVbdd */
    public final void m316wJVbdd() {
        removeCallbacks(this.f576WrLQs);
        post(this.f576WrLQs);
    }

    /* renamed from: xJ */
    public final void m317xJ() {
        if (this.f565KLFTb == null) {
            this.f565KLFTb = new C3584dm(getContext());
        }
    }

    /* renamed from: xrEuO */
    public final boolean m318xrEuO() {
        if (!this.f568NPj) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m288KLMXS(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: zvd */
    public boolean m319zvd() {
        ActionMenuView actionMenuView = this.f588mjFkc;
        return actionMenuView != null && actionMenuView.m221rWxwaT();
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$xJ */
    public static class xJ extends AbstractC3053VocHEe {

        /* renamed from: AZxh */
        public int f611AZxh;

        public xJ(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f611AZxh = 0;
        }

        /* renamed from: mjFkc */
        public void m327mjFkc(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public xJ(int i, int i2) {
            super(i, i2);
            this.f611AZxh = 0;
            this.f11370mjFkc = 8388627;
        }

        public xJ(xJ xJVar) {
            super((AbstractC3053VocHEe) xJVar);
            this.f611AZxh = 0;
            this.f611AZxh = xJVar.f611AZxh;
        }

        public xJ(AbstractC3053VocHEe abstractC3053VocHEe) {
            super(abstractC3053VocHEe);
            this.f611AZxh = 0;
        }

        public xJ(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f611AZxh = 0;
            m327mjFkc(marginLayoutParams);
        }

        public xJ(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f611AZxh = 0;
        }
    }

    public C0044Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f584huTpC = 8388627;
        this.f597wJVbdd = new ArrayList();
        this.f587mByQ = new ArrayList();
        this.f570OjSQV = new int[2];
        this.f569Ne = new C3002V1(new Runnable() { // from class: o.F8
            @Override // java.lang.Runnable
            public final void run() {
                this.f8136mjFkc.m293Ucbh();
            }
        });
        this.f558CqaNbM = new ArrayList();
        this.f599xrEuO = new mjFkc();
        this.f576WrLQs = new AZxh();
        C1606A8 c1606a8M7575diqgf = C1606A8.m7575diqgf(getContext(), attributeSet, AbstractC3407b5.f13025vZ, i, 0);
        AbstractC2876T9.m10277jm(this, context, AbstractC3407b5.f13025vZ, attributeSet, c1606a8M7575diqgf.m7589qGY(), i, 0);
        this.f573VA = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12876IPpyV, 0);
        this.f567MiMN = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12908OzIs, 0);
        this.f584huTpC = c1606a8M7575diqgf.m7578ETF(AbstractC3407b5.f12923TvfBiy, this.f584huTpC);
        this.f577YoKzxo = c1606a8M7575diqgf.m7578ETF(AbstractC3407b5.f12856CqAnRZ, 48);
        int iM7580KLFTb = c1606a8M7575diqgf.m7580KLFTb(AbstractC3407b5.f12977jTNPnW, 0);
        iM7580KLFTb = c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f12927UPU) ? c1606a8M7575diqgf.m7580KLFTb(AbstractC3407b5.f12927UPU, iM7580KLFTb) : iM7580KLFTb;
        this.f571Pq = iM7580KLFTb;
        this.f563IEE = iM7580KLFTb;
        this.f583fehf = iM7580KLFTb;
        this.f590qGY = iM7580KLFTb;
        int iM7580KLFTb2 = c1606a8M7575diqgf.m7580KLFTb(AbstractC3407b5.f13032xBQUgd, -1);
        if (iM7580KLFTb2 >= 0) {
            this.f590qGY = iM7580KLFTb2;
        }
        int iM7580KLFTb3 = c1606a8M7575diqgf.m7580KLFTb(AbstractC3407b5.f12959cdjp, -1);
        if (iM7580KLFTb3 >= 0) {
            this.f583fehf = iM7580KLFTb3;
        }
        int iM7580KLFTb4 = c1606a8M7575diqgf.m7580KLFTb(AbstractC3407b5.f12898MFekjo, -1);
        if (iM7580KLFTb4 >= 0) {
            this.f563IEE = iM7580KLFTb4;
        }
        int iM7580KLFTb5 = c1606a8M7575diqgf.m7580KLFTb(AbstractC3407b5.f12862EeoThB, -1);
        if (iM7580KLFTb5 >= 0) {
            this.f571Pq = iM7580KLFTb5;
        }
        this.f593rkYL = c1606a8M7575diqgf.m7579JHa(AbstractC3407b5.f12921Sx, -1);
        int iM7580KLFTb6 = c1606a8M7575diqgf.m7580KLFTb(AbstractC3407b5.f12947XyP, Integer.MIN_VALUE);
        int iM7580KLFTb7 = c1606a8M7575diqgf.m7580KLFTb(AbstractC3407b5.f12901Mpf, Integer.MIN_VALUE);
        int iM7579JHa = c1606a8M7575diqgf.m7579JHa(AbstractC3407b5.f12997oJ, 0);
        int iM7579JHa2 = c1606a8M7575diqgf.m7579JHa(AbstractC3407b5.f12955bWIyu, 0);
        m286JHa();
        this.f581diqgf.m8651KLFTb(iM7579JHa, iM7579JHa2);
        if (iM7580KLFTb6 != Integer.MIN_VALUE || iM7580KLFTb7 != Integer.MIN_VALUE) {
            this.f581diqgf.m8655xJ(iM7580KLFTb6, iM7580KLFTb7);
        }
        this.f582eyqo = c1606a8M7575diqgf.m7580KLFTb(AbstractC3407b5.f12925UDcil, Integer.MIN_VALUE);
        this.f572Ucbh = c1606a8M7575diqgf.m7580KLFTb(AbstractC3407b5.f12873Hk, Integer.MIN_VALUE);
        this.f564JHa = c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f13038xfXeiC);
        this.f598xJ = c1606a8M7575diqgf.m7591rkYL(AbstractC3407b5.f12916Rsp);
        CharSequence charSequenceM7591rkYL = c1606a8M7575diqgf.m7591rkYL(AbstractC3407b5.f12913RWb);
        if (!TextUtils.isEmpty(charSequenceM7591rkYL)) {
            setTitle(charSequenceM7591rkYL);
        }
        CharSequence charSequenceM7591rkYL2 = c1606a8M7575diqgf.m7591rkYL(AbstractC3407b5.f12907Otxclu);
        if (!TextUtils.isEmpty(charSequenceM7591rkYL2)) {
            setSubtitle(charSequenceM7591rkYL2);
        }
        this.f559Dt = getContext();
        setPopupTheme(c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12922TFbkuO, 0));
        Drawable drawableM7593xJ = c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f13014tPvjn);
        if (drawableM7593xJ != null) {
            setNavigationIcon(drawableM7593xJ);
        }
        CharSequence charSequenceM7591rkYL3 = c1606a8M7575diqgf.m7591rkYL(AbstractC3407b5.f13029wGscSa);
        if (!TextUtils.isEmpty(charSequenceM7591rkYL3)) {
            setNavigationContentDescription(charSequenceM7591rkYL3);
        }
        Drawable drawableM7593xJ2 = c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f12978jY);
        if (drawableM7593xJ2 != null) {
            m313setLogo(drawableM7593xJ2);
        }
        CharSequence charSequenceM7591rkYL4 = c1606a8M7575diqgf.m7591rkYL(AbstractC3407b5.f12926UOnCkw);
        if (!TextUtils.isEmpty(charSequenceM7591rkYL4)) {
            setLogoDescription(charSequenceM7591rkYL4);
        }
        if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f12983kOlLW)) {
            setTitleTextColor(c1606a8M7575diqgf.m7592wA(AbstractC3407b5.f12983kOlLW));
        }
        if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f12850ArO)) {
            setSubtitleTextColor(c1606a8M7575diqgf.m7592wA(AbstractC3407b5.f12850ArO));
        }
        if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f13001peCqC)) {
            mo300eyqo(c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f13001peCqC, 0));
        }
        c1606a8M7575diqgf.m7585eyqo();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m287KLFTb();
        }
        ImageButton imageButton = this.f586lgHUyS;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            m287KLFTb();
            this.f586lgHUyS.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f586lgHUyS;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f564JHa);
            }
        }
    }

    /* renamed from: setLogo */
    public void m313setLogo(Drawable drawable) {
        if (drawable != null) {
            m317xJ();
            if (!m304huTpC(this.f565KLFTb)) {
                m315wA(this.f565KLFTb, true);
            }
        } else {
            ImageView imageView = this.f565KLFTb;
            if (imageView != null && m304huTpC(imageView)) {
                removeView(this.f565KLFTb);
                this.f587mByQ.remove(this.f565KLFTb);
            }
        }
        ImageView imageView2 = this.f565KLFTb;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m317xJ();
        }
        ImageView imageView = this.f565KLFTb;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m281Dt();
        }
        ImageButton imageButton = this.f578ZfxDd;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            AbstractC2143I8.m8717mjFkc(this.f578ZfxDd, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m281Dt();
            if (!m304huTpC(this.f578ZfxDd)) {
                m315wA(this.f578ZfxDd, true);
            }
        } else {
            ImageButton imageButton = this.f578ZfxDd;
            if (imageButton != null && m304huTpC(imageButton)) {
                removeView(this.f578ZfxDd);
                this.f587mByQ.remove(this.f578ZfxDd);
            }
        }
        ImageButton imageButton2 = this.f578ZfxDd;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f596wA;
            if (textView != null && m304huTpC(textView)) {
                removeView(this.f596wA);
                this.f587mByQ.remove(this.f596wA);
            }
        } else {
            if (this.f596wA == null) {
                Context context = getContext();
                C2463Moer c2463Moer = new C2463Moer(context);
                this.f596wA = c2463Moer;
                c2463Moer.setSingleLine();
                this.f596wA.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f567MiMN;
                if (i != 0) {
                    this.f596wA.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f575VocHEe;
                if (colorStateList != null) {
                    this.f596wA.setTextColor(colorStateList);
                }
            }
            if (!m304huTpC(this.f596wA)) {
                m315wA(this.f596wA, true);
            }
        }
        TextView textView2 = this.f596wA;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f562HGpJ = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f575VocHEe = colorStateList;
        TextView textView = this.f596wA;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f556AZxh;
            if (textView != null && m304huTpC(textView)) {
                removeView(this.f556AZxh);
                this.f587mByQ.remove(this.f556AZxh);
            }
        } else {
            if (this.f556AZxh == null) {
                Context context = getContext();
                C2463Moer c2463Moer = new C2463Moer(context);
                this.f556AZxh = c2463Moer;
                c2463Moer.setSingleLine();
                this.f556AZxh.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f573VA;
                if (i != 0) {
                    this.f556AZxh.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f594vI;
                if (colorStateList != null) {
                    this.f556AZxh.setTextColor(colorStateList);
                }
            }
            if (!m304huTpC(this.f556AZxh)) {
                m315wA(this.f556AZxh, true);
            }
        }
        TextView textView2 = this.f556AZxh;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f561Gd = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f594vI = colorStateList;
        TextView textView = this.f556AZxh;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$qdMbNW */
    public static class qdMbNW extends AbstractC4796wA {

        /* renamed from: CREATOR */
        public static final Parcelable.Creator<qdMbNW> f607CREATOR = new mjFkc();

        /* renamed from: ZfxDd */
        public boolean f608ZfxDd;

        /* renamed from: wA */
        public int f609wA;

        /* renamed from: androidx.appcompat.widget.Toolbar$qdMbNW$mjFkc */
        public class mjFkc implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
            public qdMbNW createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new qdMbNW(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public qdMbNW createFromParcel(Parcel parcel) {
                return new qdMbNW(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: wA, reason: merged with bridge method [inline-methods] */
            public qdMbNW[] newArray(int i) {
                return new qdMbNW[i];
            }
        }

        public qdMbNW(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f609wA = parcel.readInt();
            this.f608ZfxDd = parcel.readInt() != 0;
        }

        @Override // p131o.AbstractC4796wA, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f609wA);
            parcel.writeInt(this.f608ZfxDd ? 1 : 0);
        }

        public qdMbNW(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
