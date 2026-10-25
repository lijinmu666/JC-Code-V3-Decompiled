package androidx.appcompat.p010view.p011menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS;
import p131o.AbstractC1865E4;
import p131o.AbstractC2139I4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3407b5;
import p131o.AbstractC3862i4;
import p131o.C1606A8;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements InterfaceC0008lgHUyS.mjFkc, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: AZxh */
    public ImageView f303AZxh;

    /* renamed from: Dt */
    public Drawable f304Dt;

    /* renamed from: ETF */
    public int f305ETF;

    /* renamed from: JHa */
    public TextView f306JHa;

    /* renamed from: KLFTb */
    public CheckBox f307KLFTb;

    /* renamed from: MiMN */
    public boolean f308MiMN;

    /* renamed from: VA */
    public Context f309VA;

    /* renamed from: YoKzxo */
    public Drawable f310YoKzxo;

    /* renamed from: ZfxDd */
    public TextView f311ZfxDd;

    /* renamed from: fehf */
    public boolean f312fehf;

    /* renamed from: lgHUyS */
    public ImageView f313lgHUyS;

    /* renamed from: mjFkc */
    public C0006KLFTb f314mjFkc;

    /* renamed from: qGY */
    public LayoutInflater f315qGY;

    /* renamed from: qdMbNW */
    public LinearLayout f316qdMbNW;

    /* renamed from: rkYL */
    public boolean f317rkYL;

    /* renamed from: wA */
    public RadioButton f318wA;

    /* renamed from: xJ */
    public ImageView f319xJ;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3862i4.f14117qGY);
    }

    private LayoutInflater getInflater() {
        if (this.f315qGY == null) {
            this.f315qGY = LayoutInflater.from(getContext());
        }
        return this.f315qGY;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f319xJ;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: AZxh */
    public final void m98AZxh(View view, int i) {
        LinearLayout linearLayout = this.f316qdMbNW;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    /* renamed from: JHa */
    public final void m99JHa() {
        ImageView imageView = (ImageView) getInflater().inflate(AbstractC2139I4.f8678xJ, (ViewGroup) this, false);
        this.f303AZxh = imageView;
        m98AZxh(imageView, 0);
    }

    /* renamed from: KLFTb */
    public final void m100KLFTb() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(AbstractC2139I4.f8670JHa, (ViewGroup) this, false);
        this.f307KLFTb = checkBox;
        m102mjFkc(checkBox);
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS.mjFkc
    /* renamed from: ZfxDd */
    public void mo38ZfxDd(C0006KLFTb c0006KLFTb, int i) {
        this.f314mjFkc = c0006KLFTb;
        setVisibility(c0006KLFTb.isVisible() ? 0 : 8);
        setTitle(c0006KLFTb.m90lgHUyS(this));
        setCheckable(c0006KLFTb.isCheckable());
        m101lgHUyS(c0006KLFTb.m95vI(), c0006KLFTb.m78KLFTb());
        m103setIcon(c0006KLFTb.getIcon());
        setEnabled(c0006KLFTb.isEnabled());
        setSubMenuArrowVisible(c0006KLFTb.hasSubMenu());
        setContentDescription(c0006KLFTb.getContentDescription());
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f313lgHUyS;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f313lgHUyS.getLayoutParams();
        rect.top += this.f313lgHUyS.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS.mjFkc
    public C0006KLFTb getItemData() {
        return this.f314mjFkc;
    }

    /* renamed from: lgHUyS */
    public void m101lgHUyS(boolean z, char c) {
        int i = (z && this.f314mjFkc.m95vI()) ? 0 : 8;
        if (i == 0) {
            this.f306JHa.setText(this.f314mjFkc.m77JHa());
        }
        if (this.f306JHa.getVisibility() != i) {
            this.f306JHa.setVisibility(i);
        }
    }

    /* renamed from: mjFkc */
    public final void m102mjFkc(View view) {
        m98AZxh(view, -1);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        AbstractC2876T9.m10294vjlshU(this, this.f304Dt);
        TextView textView = (TextView) findViewById(AbstractC1865E4.f7942VocHEe);
        this.f311ZfxDd = textView;
        int i = this.f305ETF;
        if (i != -1) {
            textView.setTextAppearance(this.f309VA, i);
        }
        this.f306JHa = (TextView) findViewById(AbstractC1865E4.f7940Ucbh);
        ImageView imageView = (ImageView) findViewById(AbstractC1865E4.f7934HGpJ);
        this.f319xJ = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f310YoKzxo);
        }
        this.f313lgHUyS = (ImageView) findViewById(AbstractC1865E4.f7938MiMN);
        this.f316qdMbNW = (LinearLayout) findViewById(AbstractC1865E4.f7952qdMbNW);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f303AZxh != null && this.f308MiMN) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f303AZxh.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        View view;
        if (!z && this.f318wA == null && this.f307KLFTb == null) {
            return;
        }
        if (this.f314mjFkc.m82VA()) {
            if (this.f318wA == null) {
                m104xJ();
            }
            compoundButton = this.f318wA;
            view = this.f307KLFTb;
        } else {
            if (this.f307KLFTb == null) {
                m100KLFTb();
            }
            compoundButton = this.f307KLFTb;
            view = this.f318wA;
        }
        if (z) {
            compoundButton.setChecked(this.f314mjFkc.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f307KLFTb;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f318wA;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f314mjFkc.m82VA()) {
            if (this.f318wA == null) {
                m104xJ();
            }
            compoundButton = this.f318wA;
        } else {
            if (this.f307KLFTb == null) {
                m100KLFTb();
            }
            compoundButton = this.f307KLFTb;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f312fehf = z;
        this.f308MiMN = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f313lgHUyS;
        if (imageView != null) {
            imageView.setVisibility((this.f317rkYL || !z) ? 8 : 0);
        }
    }

    /* renamed from: setIcon */
    public void m103setIcon(Drawable drawable) {
        boolean z = this.f314mjFkc.m75HGpJ() || this.f312fehf;
        if (z || this.f308MiMN) {
            ImageView imageView = this.f303AZxh;
            if (imageView == null && drawable == null && !this.f308MiMN) {
                return;
            }
            if (imageView == null) {
                m99JHa();
            }
            if (drawable == null && !this.f308MiMN) {
                this.f303AZxh.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f303AZxh;
            if (!z) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f303AZxh.getVisibility() != 0) {
                this.f303AZxh.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f311ZfxDd.getVisibility() != 8) {
                this.f311ZfxDd.setVisibility(8);
            }
        } else {
            this.f311ZfxDd.setText(charSequence);
            if (this.f311ZfxDd.getVisibility() != 0) {
                this.f311ZfxDd.setVisibility(0);
            }
        }
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS.mjFkc
    /* renamed from: wA */
    public boolean mo42wA() {
        return false;
    }

    /* renamed from: xJ */
    public final void m104xJ() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(AbstractC2139I4.f8674lgHUyS, (ViewGroup) this, false);
        this.f318wA = radioButton;
        m102mjFkc(radioButton);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        C1606A8 c1606a8M7575diqgf = C1606A8.m7575diqgf(getContext(), attributeSet, AbstractC3407b5.f12999oaI, i, 0);
        this.f304Dt = c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f12936Vu);
        this.f305ETF = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12914RWyiuY, -1);
        this.f308MiMN = c1606a8M7575diqgf.m7588mjFkc(AbstractC3407b5.f13022uxlM, false);
        this.f309VA = context;
        this.f310YoKzxo = c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f12998oVXlhB);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, AbstractC3862i4.f14111YoKzxo, 0);
        this.f317rkYL = typedArrayObtainStyledAttributes.hasValue(0);
        c1606a8M7575diqgf.m7585eyqo();
        typedArrayObtainStyledAttributes.recycle();
    }
}
