package androidx.appcompat.p010view.p011menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.p010view.p011menu.C0007ZfxDd;
import androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS;
import androidx.appcompat.p012widget.ActionMenuView;
import p131o.AbstractC2143I8;
import p131o.AbstractC3407b5;
import p131o.AbstractViewOnTouchListenerC4375prww;
import p131o.C2463Moer;
import p131o.InterfaceC2674Q6;

/* loaded from: classes.dex */
public class ActionMenuItemView extends C2463Moer implements InterfaceC0008lgHUyS.mjFkc, View.OnClickListener, ActionMenuView.InterfaceC0023mjFkc {

    /* renamed from: Dt */
    public Drawable f243Dt;

    /* renamed from: ETF */
    public C0007ZfxDd.AZxh f244ETF;

    /* renamed from: IEE */
    public int f245IEE;

    /* renamed from: MiMN */
    public AbstractC0002AZxh f246MiMN;

    /* renamed from: VA */
    public AbstractViewOnTouchListenerC4375prww f247VA;

    /* renamed from: YoKzxo */
    public boolean f248YoKzxo;

    /* renamed from: fehf */
    public int f249fehf;

    /* renamed from: lgHUyS */
    public C0006KLFTb f250lgHUyS;

    /* renamed from: qGY */
    public int f251qGY;

    /* renamed from: qdMbNW */
    public CharSequence f252qdMbNW;

    /* renamed from: rkYL */
    public boolean f253rkYL;

    /* renamed from: androidx.appcompat.view.menu.ActionMenuItemView$AZxh */
    public static abstract class AbstractC0002AZxh {
        /* renamed from: mjFkc */
        public abstract InterfaceC2674Q6 mo43mjFkc();
    }

    /* renamed from: androidx.appcompat.view.menu.ActionMenuItemView$mjFkc */
    public class C0003mjFkc extends AbstractViewOnTouchListenerC4375prww {
        public C0003mjFkc() {
            super(ActionMenuItemView.this);
        }

        @Override // p131o.AbstractViewOnTouchListenerC4375prww
        /* renamed from: AZxh */
        public InterfaceC2674Q6 mo44AZxh() {
            AbstractC0002AZxh abstractC0002AZxh = ActionMenuItemView.this.f246MiMN;
            if (abstractC0002AZxh != null) {
                return abstractC0002AZxh.mo43mjFkc();
            }
            return null;
        }

        @Override // p131o.AbstractViewOnTouchListenerC4375prww
        /* renamed from: wA */
        public boolean mo45wA() {
            InterfaceC2674Q6 interfaceC2674Q6Mo44AZxh;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            C0007ZfxDd.AZxh aZxh = actionMenuItemView.f244ETF;
            return aZxh != null && aZxh.mo55mjFkc(actionMenuItemView.f250lgHUyS) && (interfaceC2674Q6Mo44AZxh = mo44AZxh()) != null && interfaceC2674Q6Mo44AZxh.mo9Dt();
        }
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.appcompat.p012widget.ActionMenuView.InterfaceC0023mjFkc
    /* renamed from: AZxh */
    public boolean mo35AZxh() {
        return m36IEE() && this.f250lgHUyS.getIcon() == null;
    }

    /* renamed from: IEE */
    public boolean m36IEE() {
        return !TextUtils.isEmpty(getText());
    }

    /* renamed from: Pq */
    public final boolean m37Pq() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS.mjFkc
    /* renamed from: ZfxDd */
    public void mo38ZfxDd(C0006KLFTb c0006KLFTb, int i) {
        this.f250lgHUyS = c0006KLFTb;
        m41setIcon(c0006KLFTb.getIcon());
        setTitle(c0006KLFTb.m90lgHUyS(this));
        setId(c0006KLFTb.getItemId());
        setVisibility(c0006KLFTb.isVisible() ? 0 : 8);
        setEnabled(c0006KLFTb.isEnabled());
        if (c0006KLFTb.hasSubMenu() && this.f247VA == null) {
            this.f247VA = new C0003mjFkc();
        }
    }

    /* renamed from: diqgf */
    public final void m39diqgf() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f252qdMbNW);
        if (this.f243Dt != null && (!this.f250lgHUyS.m83VocHEe() || (!this.f248YoKzxo && !this.f253rkYL))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f252qdMbNW : null);
        CharSequence contentDescription = this.f250lgHUyS.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.f250lgHUyS.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f250lgHUyS.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            AbstractC2143I8.m8717mjFkc(this, z3 ? null : this.f250lgHUyS.getTitle());
        } else {
            AbstractC2143I8.m8717mjFkc(this, tooltipText);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS.mjFkc
    public C0006KLFTb getItemData() {
        return this.f250lgHUyS;
    }

    @Override // androidx.appcompat.p012widget.ActionMenuView.InterfaceC0023mjFkc
    /* renamed from: mjFkc */
    public boolean mo40mjFkc() {
        return m36IEE();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0007ZfxDd.AZxh aZxh = this.f244ETF;
        if (aZxh != null) {
            aZxh.mo55mjFkc(this.f250lgHUyS);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f248YoKzxo = m37Pq();
        m39diqgf();
    }

    @Override // p131o.C2463Moer, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        boolean zM36IEE = m36IEE();
        if (zM36IEE && (i3 = this.f249fehf) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f251qGY) : this.f251qGY;
        if (mode != 1073741824 && this.f251qGY > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i2);
        }
        if (zM36IEE || this.f243Dt == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f243Dt.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AbstractViewOnTouchListenerC4375prww abstractViewOnTouchListenerC4375prww;
        if (this.f250lgHUyS.hasSubMenu() && (abstractViewOnTouchListenerC4375prww = this.f247VA) != null && abstractViewOnTouchListenerC4375prww.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f253rkYL != z) {
            this.f253rkYL = z;
            C0006KLFTb c0006KLFTb = this.f250lgHUyS;
            if (c0006KLFTb != null) {
                c0006KLFTb.m91mjFkc();
            }
        }
    }

    /* renamed from: setIcon */
    public void m41setIcon(Drawable drawable) {
        this.f243Dt = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.f245IEE;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        m39diqgf();
    }

    public void setItemInvoker(C0007ZfxDd.AZxh aZxh) {
        this.f244ETF = aZxh;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.f249fehf = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(AbstractC0002AZxh abstractC0002AZxh) {
        this.f246MiMN = abstractC0002AZxh;
    }

    public void setTitle(CharSequence charSequence) {
        this.f252qdMbNW = charSequence;
        m39diqgf();
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS.mjFkc
    /* renamed from: wA */
    public boolean mo42wA() {
        return true;
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f248YoKzxo = m37Pq();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3407b5.f12961diqgf, i, 0);
        this.f251qGY = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC3407b5.f12966eyqo, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f245IEE = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f249fehf = -1;
        setSaveEnabled(false);
    }
}
