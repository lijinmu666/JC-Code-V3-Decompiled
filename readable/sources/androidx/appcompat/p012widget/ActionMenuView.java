package androidx.appcompat.p012widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.p010view.p011menu.ActionMenuItemView;
import androidx.appcompat.p010view.p011menu.C0006KLFTb;
import androidx.appcompat.p010view.p011menu.C0007ZfxDd;
import androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS;
import androidx.appcompat.p010view.p011menu.InterfaceC0012xJ;
import androidx.appcompat.p012widget.AbstractC0013AZxh;
import p131o.AbstractC4689ua;

/* loaded from: classes.dex */
public class ActionMenuView extends AbstractC0013AZxh implements C0007ZfxDd.AZxh, InterfaceC0008lgHUyS {

    /* renamed from: Gd */
    public int f455Gd;

    /* renamed from: HGpJ */
    public int f456HGpJ;

    /* renamed from: IEE */
    public int f457IEE;

    /* renamed from: Pq */
    public boolean f458Pq;

    /* renamed from: Ucbh */
    public C0007ZfxDd.mjFkc f459Ucbh;

    /* renamed from: VocHEe */
    public InterfaceC0021KLFTb f460VocHEe;

    /* renamed from: diqgf */
    public C0047mjFkc f461diqgf;

    /* renamed from: eyqo */
    public InterfaceC0012xJ.mjFkc f462eyqo;

    /* renamed from: fehf */
    public Context f463fehf;

    /* renamed from: huTpC */
    public boolean f464huTpC;

    /* renamed from: qGY */
    public C0007ZfxDd f465qGY;

    /* renamed from: vI */
    public int f466vI;

    /* renamed from: androidx.appcompat.widget.ActionMenuView$AZxh */
    public static class C0020AZxh implements InterfaceC0012xJ.mjFkc {
        @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ.mjFkc
        /* renamed from: AZxh */
        public void mo162AZxh(C0007ZfxDd c0007ZfxDd, boolean z) {
        }

        @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ.mjFkc
        /* renamed from: wA */
        public boolean mo163wA(C0007ZfxDd c0007ZfxDd) {
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$KLFTb */
    public interface InterfaceC0021KLFTb {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$ZfxDd */
    public class C0022ZfxDd implements C0007ZfxDd.mjFkc {
        public C0022ZfxDd() {
        }

        @Override // androidx.appcompat.p010view.p011menu.C0007ZfxDd.mjFkc
        /* renamed from: AZxh */
        public void mo145AZxh(C0007ZfxDd c0007ZfxDd) {
            C0007ZfxDd.mjFkc mjfkc = ActionMenuView.this.f459Ucbh;
            if (mjfkc != null) {
                mjfkc.mo145AZxh(c0007ZfxDd);
            }
        }

        @Override // androidx.appcompat.p010view.p011menu.C0007ZfxDd.mjFkc
        /* renamed from: mjFkc */
        public boolean mo146mjFkc(C0007ZfxDd c0007ZfxDd, MenuItem menuItem) {
            InterfaceC0021KLFTb interfaceC0021KLFTb = ActionMenuView.this.f460VocHEe;
            return interfaceC0021KLFTb != null && interfaceC0021KLFTb.onMenuItemClick(menuItem);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$mjFkc */
    public interface InterfaceC0023mjFkc {
        /* renamed from: AZxh */
        boolean mo35AZxh();

        /* renamed from: mjFkc */
        boolean mo40mjFkc();
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$wA */
    public static class C0024wA extends AbstractC0013AZxh.mjFkc {

        /* renamed from: AZxh */
        public int f468AZxh;

        /* renamed from: JHa */
        public boolean f469JHa;

        /* renamed from: KLFTb */
        public boolean f470KLFTb;

        /* renamed from: ZfxDd */
        public boolean f471ZfxDd;

        /* renamed from: mjFkc */
        public boolean f472mjFkc;

        /* renamed from: wA */
        public int f473wA;

        public C0024wA(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0024wA(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0024wA(C0024wA c0024wA) {
            super(c0024wA);
            this.f472mjFkc = c0024wA.f472mjFkc;
        }

        public C0024wA(int i, int i2) {
            super(i, i2);
            this.f472mjFkc = false;
        }
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* renamed from: xrEuO */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m210xrEuO(View view, int i, int i2, int i3, int i4) {
        int i5;
        C0024wA c0024wA = (C0024wA) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = false;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.m36IEE();
        if (i2 > 0) {
            i5 = 2;
            if (!z2 || i2 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), iMakeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i6 = measuredWidth / i;
                if (measuredWidth % i != 0) {
                    i6++;
                }
                if (!z2 || i6 >= 2) {
                    i5 = i6;
                }
            } else {
                i5 = 0;
            }
        }
        if (!c0024wA.f472mjFkc && z2) {
            z = true;
        }
        c0024wA.f471ZfxDd = z;
        c0024wA.f468AZxh = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), iMakeMeasureSpec);
        return i5;
    }

    @Override // androidx.appcompat.p012widget.AbstractC0013AZxh, android.view.ViewGroup
    /* renamed from: BAnRFn, reason: merged with bridge method [inline-methods] */
    public C0024wA generateDefaultLayoutParams() {
        C0024wA c0024wA = new C0024wA(-2, -2);
        ((LinearLayout.LayoutParams) c0024wA).gravity = 16;
        return c0024wA;
    }

    /* renamed from: CqaNbM */
    public boolean m212CqaNbM() {
        C0047mjFkc c0047mjFkc = this.f461diqgf;
        return c0047mjFkc != null && c0047mjFkc.m356BAnRFn();
    }

    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* renamed from: KLMXS */
    public final void m213KLMXS(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        boolean z2;
        boolean z3;
        int i7;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
        int i8 = size - paddingLeft;
        int i9 = this.f456HGpJ;
        int i10 = i8 / i9;
        int i11 = i8 % i9;
        if (i10 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i12 = i9 + (i11 / i10);
        int childCount = getChildCount();
        int iMax = 0;
        int i13 = 0;
        boolean z4 = false;
        int i14 = 0;
        int iMax2 = 0;
        int i15 = 0;
        long j = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            int i16 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z5 = childAt instanceof ActionMenuItemView;
                int i17 = i14 + 1;
                if (z5) {
                    int i18 = this.f466vI;
                    i7 = i17;
                    r14 = 0;
                    childAt.setPadding(i18, 0, i18, 0);
                } else {
                    i7 = i17;
                    r14 = 0;
                }
                C0024wA c0024wA = (C0024wA) childAt.getLayoutParams();
                c0024wA.f469JHa = r14;
                c0024wA.f473wA = r14;
                c0024wA.f468AZxh = r14;
                c0024wA.f471ZfxDd = r14;
                ((LinearLayout.LayoutParams) c0024wA).leftMargin = r14;
                ((LinearLayout.LayoutParams) c0024wA).rightMargin = r14;
                c0024wA.f470KLFTb = z5 && ((ActionMenuItemView) childAt).m36IEE();
                int iM210xrEuO = m210xrEuO(childAt, i12, c0024wA.f472mjFkc ? 1 : i10, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iM210xrEuO);
                if (c0024wA.f471ZfxDd) {
                    i15++;
                }
                if (c0024wA.f472mjFkc) {
                    z4 = true;
                }
                i10 -= iM210xrEuO;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iM210xrEuO == 1) {
                    j |= 1 << i13;
                    iMax = iMax;
                }
                i14 = i7;
            }
            i13++;
            size2 = i16;
        }
        int i19 = size2;
        boolean z6 = z4 && i14 == 2;
        boolean z7 = false;
        while (i15 > 0 && i10 > 0) {
            int i20 = Integer.MAX_VALUE;
            int i21 = 0;
            int i22 = 0;
            long j2 = 0;
            while (i22 < childCount) {
                boolean z8 = z7;
                C0024wA c0024wA2 = (C0024wA) getChildAt(i22).getLayoutParams();
                int i23 = iMax;
                if (c0024wA2.f471ZfxDd) {
                    int i24 = c0024wA2.f468AZxh;
                    if (i24 < i20) {
                        j2 = 1 << i22;
                        i20 = i24;
                        i21 = 1;
                    } else if (i24 == i20) {
                        i21++;
                        j2 |= 1 << i22;
                    }
                }
                i22++;
                iMax = i23;
                z7 = z8;
            }
            z = z7;
            i5 = iMax;
            j |= j2;
            if (i21 > i10) {
                i3 = mode;
                i4 = i8;
                break;
            }
            int i25 = i20 + 1;
            int i26 = 0;
            while (i26 < childCount) {
                View childAt2 = getChildAt(i26);
                C0024wA c0024wA3 = (C0024wA) childAt2.getLayoutParams();
                int i27 = i8;
                int i28 = mode;
                long j3 = 1 << i26;
                if ((j2 & j3) == 0) {
                    if (c0024wA3.f468AZxh == i25) {
                        j |= j3;
                    }
                    z3 = z6;
                } else {
                    if (z6 && c0024wA3.f470KLFTb && i10 == 1) {
                        int i29 = this.f466vI;
                        z3 = z6;
                        childAt2.setPadding(i29 + i12, 0, i29, 0);
                    } else {
                        z3 = z6;
                    }
                    c0024wA3.f468AZxh++;
                    c0024wA3.f469JHa = true;
                    i10--;
                }
                i26++;
                mode = i28;
                i8 = i27;
                z6 = z3;
            }
            iMax = i5;
            z7 = true;
        }
        i3 = mode;
        i4 = i8;
        z = z7;
        i5 = iMax;
        boolean z9 = !z4 && i14 == 1;
        if (i10 <= 0 || j == 0 || (i10 >= i14 - 1 && !z9 && iMax2 <= 1)) {
            i6 = 0;
            z2 = z;
        } else {
            float fBitCount = Long.bitCount(j);
            if (z9) {
                i6 = 0;
            } else {
                i6 = 0;
                if ((j & 1) != 0 && !((C0024wA) getChildAt(0).getLayoutParams()).f470KLFTb) {
                    fBitCount -= 0.5f;
                }
                int i30 = childCount - 1;
                if ((j & (1 << i30)) != 0 && !((C0024wA) getChildAt(i30).getLayoutParams()).f470KLFTb) {
                    fBitCount -= 0.5f;
                }
            }
            int i31 = fBitCount > 0.0f ? (int) ((i10 * i12) / fBitCount) : i6;
            z2 = z;
            for (int i32 = i6; i32 < childCount; i32++) {
                if ((j & (1 << i32)) != 0) {
                    View childAt3 = getChildAt(i32);
                    C0024wA c0024wA4 = (C0024wA) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c0024wA4.f473wA = i31;
                        c0024wA4.f469JHa = true;
                        if (i32 == 0 && !c0024wA4.f470KLFTb) {
                            ((LinearLayout.LayoutParams) c0024wA4).leftMargin = (-i31) / 2;
                        }
                        z2 = true;
                    } else if (c0024wA4.f472mjFkc) {
                        c0024wA4.f473wA = i31;
                        c0024wA4.f469JHa = true;
                        ((LinearLayout.LayoutParams) c0024wA4).rightMargin = (-i31) / 2;
                        z2 = true;
                    } else {
                        if (i32 != 0) {
                            ((LinearLayout.LayoutParams) c0024wA4).leftMargin = i31 / 2;
                        }
                        if (i32 != childCount - 1) {
                            ((LinearLayout.LayoutParams) c0024wA4).rightMargin = i31 / 2;
                        }
                    }
                }
            }
        }
        if (z2) {
            for (int i33 = i6; i33 < childCount; i33++) {
                View childAt4 = getChildAt(i33);
                C0024wA c0024wA5 = (C0024wA) childAt4.getLayoutParams();
                if (c0024wA5.f469JHa) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((c0024wA5.f468AZxh * i12) + c0024wA5.f473wA, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i4, i3 != 1073741824 ? i5 : i19);
    }

    /* renamed from: Ne */
    public void m214Ne(C0007ZfxDd c0007ZfxDd) {
        this.f465qGY = c0007ZfxDd;
    }

    /* renamed from: OjSQV */
    public boolean m215OjSQV(int i) {
        boolean zMo40mjFkc = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof InterfaceC0023mjFkc)) {
            zMo40mjFkc = ((InterfaceC0023mjFkc) childAt).mo40mjFkc();
        }
        return (i <= 0 || !(childAt2 instanceof InterfaceC0023mjFkc)) ? zMo40mjFkc : zMo40mjFkc | ((InterfaceC0023mjFkc) childAt2).mo35AZxh();
    }

    /* renamed from: VocHEe */
    public void m216VocHEe() {
        C0047mjFkc c0047mjFkc = this.f461diqgf;
        if (c0047mjFkc != null) {
            c0047mjFkc.m363huTpC();
        }
    }

    /* renamed from: cMLeY */
    public void m217cMLeY(InterfaceC0012xJ.mjFkc mjfkc, C0007ZfxDd.mjFkc mjfkc2) {
        this.f462eyqo = mjfkc;
        this.f459Ucbh = mjfkc2;
    }

    @Override // androidx.appcompat.p012widget.AbstractC0013AZxh, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0024wA;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    /* renamed from: getMenu */
    public Menu m218getMenu() {
        if (this.f465qGY == null) {
            Context context = getContext();
            C0007ZfxDd c0007ZfxDd = new C0007ZfxDd(context);
            this.f465qGY = c0007ZfxDd;
            c0007ZfxDd.mo50cMLeY(new C0022ZfxDd());
            C0047mjFkc c0047mjFkc = new C0047mjFkc(context);
            this.f461diqgf = c0047mjFkc;
            c0047mjFkc.m360Ne(true);
            C0047mjFkc c0047mjFkc2 = this.f461diqgf;
            InterfaceC0012xJ.mjFkc c0020AZxh = this.f462eyqo;
            if (c0020AZxh == null) {
                c0020AZxh = new C0020AZxh();
            }
            c0047mjFkc2.mo18VA(c0020AZxh);
            this.f465qGY.m107AZxh(this.f461diqgf, this.f463fehf);
            this.f461diqgf.m365mByQ(this);
        }
        return this.f465qGY;
    }

    public Drawable getOverflowIcon() {
        m218getMenu();
        return this.f461diqgf.m359HGpJ();
    }

    public int getPopupTheme() {
        return this.f457IEE;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.p012widget.AbstractC0013AZxh, android.view.ViewGroup
    /* renamed from: lB, reason: merged with bridge method [inline-methods] */
    public C0024wA generateLayoutParams(AttributeSet attributeSet) {
        return new C0024wA(getContext(), attributeSet);
    }

    /* renamed from: mByQ */
    public C0024wA m220mByQ() {
        C0024wA c0024wAGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        c0024wAGenerateDefaultLayoutParams.f472mjFkc = true;
        return c0024wAGenerateDefaultLayoutParams;
    }

    @Override // androidx.appcompat.p010view.p011menu.C0007ZfxDd.AZxh
    /* renamed from: mjFkc */
    public boolean mo55mjFkc(C0006KLFTb c0006KLFTb) {
        return this.f465qGY.m108CqaNbM(c0006KLFTb, 0);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0047mjFkc c0047mjFkc = this.f461diqgf;
        if (c0047mjFkc != null) {
            c0047mjFkc.mo31xJ(false);
            if (this.f461diqgf.m356BAnRFn()) {
                this.f461diqgf.m366vI();
                this.f461diqgf.m357CqaNbM();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m216VocHEe();
    }

    @Override // androidx.appcompat.p012widget.AbstractC0013AZxh, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int paddingLeft;
        if (!this.f464huTpC) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i5 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i6 = i3 - i;
        int paddingRight = (i6 - getPaddingRight()) - getPaddingLeft();
        boolean zM13718mjFkc = AbstractC4689ua.m13718mjFkc(this);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                C0024wA c0024wA = (C0024wA) childAt.getLayoutParams();
                if (c0024wA.f472mjFkc) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (m215OjSQV(i9)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zM13718mjFkc) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) c0024wA).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) c0024wA).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i10 = i5 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i10, width, measuredHeight + i10);
                    paddingRight -= measuredWidth;
                    i7 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) c0024wA).leftMargin) + ((LinearLayout.LayoutParams) c0024wA).rightMargin;
                    m215OjSQV(i9);
                    i8++;
                }
            }
        }
        if (childCount == 1 && i7 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i11 = (i6 / 2) - (measuredWidth2 / 2);
            int i12 = i5 - (measuredHeight2 / 2);
            childAt2.layout(i11, i12, measuredWidth2 + i11, measuredHeight2 + i12);
            return;
        }
        int i13 = i8 - (i7 ^ 1);
        int iMax = Math.max(0, i13 > 0 ? paddingRight / i13 : 0);
        if (zM13718mjFkc) {
            int width2 = getWidth() - getPaddingRight();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt3 = getChildAt(i14);
                C0024wA c0024wA2 = (C0024wA) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !c0024wA2.f472mjFkc) {
                    int i15 = width2 - ((LinearLayout.LayoutParams) c0024wA2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i16 = i5 - (measuredHeight3 / 2);
                    childAt3.layout(i15 - measuredWidth3, i16, i15, measuredHeight3 + i16);
                    width2 = i15 - ((measuredWidth3 + ((LinearLayout.LayoutParams) c0024wA2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt4 = getChildAt(i17);
            C0024wA c0024wA3 = (C0024wA) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !c0024wA3.f472mjFkc) {
                int i18 = paddingLeft2 + ((LinearLayout.LayoutParams) c0024wA3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i5 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth4, measuredHeight4 + i19);
                paddingLeft2 = i18 + measuredWidth4 + ((LinearLayout.LayoutParams) c0024wA3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.p012widget.AbstractC0013AZxh, android.view.View
    public void onMeasure(int i, int i2) {
        C0007ZfxDd c0007ZfxDd;
        boolean z = this.f464huTpC;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.f464huTpC = z2;
        if (z != z2) {
            this.f455Gd = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.f464huTpC && (c0007ZfxDd = this.f465qGY) != null && size != this.f455Gd) {
            this.f455Gd = size;
            c0007ZfxDd.m117Ne(true);
        }
        int childCount = getChildCount();
        if (this.f464huTpC && childCount > 0) {
            m213KLMXS(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            C0024wA c0024wA = (C0024wA) getChildAt(i3).getLayoutParams();
            ((LinearLayout.LayoutParams) c0024wA).rightMargin = 0;
            ((LinearLayout.LayoutParams) c0024wA).leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    /* renamed from: rWxwaT */
    public boolean m221rWxwaT() {
        C0047mjFkc c0047mjFkc = this.f461diqgf;
        return c0047mjFkc != null && c0047mjFkc.m357CqaNbM();
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f461diqgf.m367wJVbdd(z);
    }

    public void setOnMenuItemClickListener(InterfaceC0021KLFTb interfaceC0021KLFTb) {
        this.f460VocHEe = interfaceC0021KLFTb;
    }

    public void setOverflowIcon(Drawable drawable) {
        m218getMenu();
        this.f461diqgf.m361OjSQV(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f458Pq = z;
    }

    public void setPopupTheme(int i) {
        if (this.f457IEE != i) {
            this.f457IEE = i;
            if (i == 0) {
                this.f463fehf = getContext();
            } else {
                this.f463fehf = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(C0047mjFkc c0047mjFkc) {
        this.f461diqgf = c0047mjFkc;
        c0047mjFkc.m365mByQ(this);
    }

    @Override // androidx.appcompat.p012widget.AbstractC0013AZxh, android.view.ViewGroup
    /* renamed from: wJVbdd, reason: merged with bridge method [inline-methods] */
    public C0024wA generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        C0024wA c0024wA = layoutParams instanceof C0024wA ? new C0024wA((C0024wA) layoutParams) : new C0024wA(layoutParams);
        if (((LinearLayout.LayoutParams) c0024wA).gravity <= 0) {
            ((LinearLayout.LayoutParams) c0024wA).gravity = 16;
        }
        return c0024wA;
    }

    /* renamed from: zvd */
    public C0007ZfxDd m223zvd() {
        return this.f465qGY;
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f456HGpJ = (int) (56.0f * f);
        this.f466vI = (int) (f * 4.0f);
        this.f463fehf = context;
        this.f457IEE = 0;
    }
}
