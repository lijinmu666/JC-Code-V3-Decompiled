package p131o;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.p038google.p039android.material.internal.CheckableImageButton;
import com.p038google.p039android.material.textfield.TextInputLayout;

/* renamed from: o.h7 */
/* loaded from: classes.dex */
public class C3803h7 extends LinearLayout {

    /* renamed from: AZxh */
    public final TextView f13971AZxh;

    /* renamed from: Dt */
    public boolean f13972Dt;

    /* renamed from: JHa */
    public PorterDuff.Mode f13973JHa;

    /* renamed from: KLFTb */
    public ColorStateList f13974KLFTb;

    /* renamed from: ZfxDd */
    public final CheckableImageButton f13975ZfxDd;

    /* renamed from: lgHUyS */
    public ImageView.ScaleType f13976lgHUyS;

    /* renamed from: mjFkc */
    public final TextInputLayout f13977mjFkc;

    /* renamed from: qdMbNW */
    public View.OnLongClickListener f13978qdMbNW;

    /* renamed from: wA */
    public CharSequence f13979wA;

    /* renamed from: xJ */
    public int f13980xJ;

    public C3803h7(TextInputLayout textInputLayout, C1606A8 c1606a8) {
        super(textInputLayout.getContext());
        this.f13977mjFkc = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(AbstractC2007G4.f8313KLFTb, (ViewGroup) this, false);
        this.f13975ZfxDd = checkableImageButton;
        AbstractC2002G.m8348KLFTb(checkableImageButton);
        C2463Moer c2463Moer = new C2463Moer(getContext());
        this.f13971AZxh = c2463Moer;
        m12206qdMbNW(c1606a8);
        m12203lgHUyS(c1606a8);
        addView(checkableImageButton);
        addView(c2463Moer);
    }

    /* renamed from: AZxh */
    public ColorStateList m12183AZxh() {
        return this.f13971AZxh.getTextColors();
    }

    /* renamed from: BAnRFn */
    public final void m12184BAnRFn() {
        int i = (this.f13979wA == null || this.f13972Dt) ? 8 : 0;
        setVisibility((this.f13975ZfxDd.getVisibility() == 0 || i == 0) ? 0 : 8);
        this.f13971AZxh.setVisibility(i);
        this.f13977mjFkc.m3195yfx();
    }

    /* renamed from: Dt */
    public boolean m12185Dt() {
        return this.f13975ZfxDd.getVisibility() == 0;
    }

    /* renamed from: ETF */
    public void m12186ETF(boolean z) {
        this.f13972Dt = z;
        m12184BAnRFn();
    }

    /* renamed from: Gd */
    public void m12187Gd(PorterDuff.Mode mode) {
        if (this.f13973JHa != mode) {
            this.f13973JHa = mode;
            AbstractC2002G.m8351mjFkc(this.f13977mjFkc, this.f13975ZfxDd, this.f13974KLFTb, mode);
        }
    }

    /* renamed from: HGpJ */
    public void m12188HGpJ(boolean z) {
        if (m12185Dt() != z) {
            this.f13975ZfxDd.setVisibility(z ? 0 : 8);
            m12196VocHEe();
            m12184BAnRFn();
        }
    }

    /* renamed from: IEE */
    public void m12189IEE(Drawable drawable) {
        this.f13975ZfxDd.setImageDrawable(drawable);
        if (drawable != null) {
            AbstractC2002G.m8351mjFkc(this.f13977mjFkc, this.f13975ZfxDd, this.f13974KLFTb, this.f13973JHa);
            m12188HGpJ(true);
            m12195VA();
        } else {
            m12188HGpJ(false);
            m12199diqgf(null);
            m12200eyqo(null);
            m12201fehf(null);
        }
    }

    /* renamed from: JHa */
    public int m12190JHa() {
        return this.f13980xJ;
    }

    /* renamed from: KLFTb */
    public Drawable m12191KLFTb() {
        return this.f13975ZfxDd.getDrawable();
    }

    /* renamed from: MiMN */
    public void m12192MiMN(CharSequence charSequence) {
        this.f13979wA = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f13971AZxh.setText(charSequence);
        m12184BAnRFn();
    }

    /* renamed from: Pq */
    public void m12193Pq(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i != this.f13980xJ) {
            this.f13980xJ = i;
            AbstractC2002G.m8354xJ(this.f13975ZfxDd, i);
        }
    }

    /* renamed from: Ucbh */
    public void m12194Ucbh(ImageView.ScaleType scaleType) {
        this.f13976lgHUyS = scaleType;
        AbstractC2002G.m8346Dt(this.f13975ZfxDd, scaleType);
    }

    /* renamed from: VA */
    public void m12195VA() {
        AbstractC2002G.m8349ZfxDd(this.f13977mjFkc, this.f13975ZfxDd, this.f13974KLFTb);
    }

    /* renamed from: VocHEe */
    public void m12196VocHEe() {
        EditText editText = this.f13977mjFkc.f2853ZfxDd;
        if (editText == null) {
            return;
        }
        AbstractC2876T9.m10274gYa(this.f13971AZxh, m12185Dt() ? 0 : AbstractC2876T9.m10224BAnRFn(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(AbstractC4191n4.f15311Gd), editText.getCompoundPaddingBottom());
    }

    /* renamed from: YoKzxo */
    public void m12197YoKzxo(int i) {
        AbstractC4065l8.m12662MiMN(this.f13971AZxh, i);
    }

    /* renamed from: ZfxDd */
    public CharSequence m12198ZfxDd() {
        return this.f13975ZfxDd.getContentDescription();
    }

    /* renamed from: diqgf */
    public void m12199diqgf(View.OnClickListener onClickListener) {
        AbstractC2002G.m8350lgHUyS(this.f13975ZfxDd, onClickListener, this.f13978qdMbNW);
    }

    /* renamed from: eyqo */
    public void m12200eyqo(View.OnLongClickListener onLongClickListener) {
        this.f13978qdMbNW = onLongClickListener;
        AbstractC2002G.m8352qdMbNW(this.f13975ZfxDd, onLongClickListener);
    }

    /* renamed from: fehf */
    public void m12201fehf(CharSequence charSequence) {
        if (m12198ZfxDd() != charSequence) {
            this.f13975ZfxDd.setContentDescription(charSequence);
        }
    }

    /* renamed from: huTpC */
    public void m12202huTpC(ColorStateList colorStateList) {
        if (this.f13974KLFTb != colorStateList) {
            this.f13974KLFTb = colorStateList;
            AbstractC2002G.m8351mjFkc(this.f13977mjFkc, this.f13975ZfxDd, colorStateList, this.f13973JHa);
        }
    }

    /* renamed from: lgHUyS */
    public final void m12203lgHUyS(C1606A8 c1606a8) {
        this.f13971AZxh.setVisibility(8);
        this.f13971AZxh.setId(AbstractC1803D4.f7819rWxwaT);
        this.f13971AZxh.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        AbstractC2876T9.m10289tQ(this.f13971AZxh, 1);
        m12197YoKzxo(c1606a8.m7581MiMN(AbstractC3340a5.f12634qbGbxJ, 0));
        if (c1606a8.m7586fehf(AbstractC3340a5.f12630prww)) {
            m12207rkYL(c1606a8.m7592wA(AbstractC3340a5.f12630prww));
        }
        m12192MiMN(c1606a8.m7591rkYL(AbstractC3340a5.f12614niM));
    }

    /* renamed from: mjFkc */
    public CharSequence m12204mjFkc() {
        return this.f13979wA;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m12196VocHEe();
    }

    /* renamed from: qGY */
    public void m12205qGY(boolean z) {
        this.f13975ZfxDd.setCheckable(z);
    }

    /* renamed from: qdMbNW */
    public final void m12206qdMbNW(C1606A8 c1606a8) {
        if (AbstractC2478N1.m9574JHa(getContext())) {
            AbstractC1599A1.m7549wA((ViewGroup.MarginLayoutParams) this.f13975ZfxDd.getLayoutParams(), 0);
        }
        m12199diqgf(null);
        m12200eyqo(null);
        if (c1606a8.m7586fehf(AbstractC3340a5.f12340DanUFX)) {
            this.f13974KLFTb = AbstractC2478N1.m9573AZxh(getContext(), c1606a8, AbstractC3340a5.f12340DanUFX);
        }
        if (c1606a8.m7586fehf(AbstractC3340a5.f12458RleMQT)) {
            this.f13973JHa = AbstractC4557sa.m13502JHa(c1606a8.m7577Dt(AbstractC3340a5.f12458RleMQT, -1), null);
        }
        if (c1606a8.m7586fehf(AbstractC3340a5.f12533bL)) {
            m12189IEE(c1606a8.m7593xJ(AbstractC3340a5.f12533bL));
            if (c1606a8.m7586fehf(AbstractC3340a5.f12583jeHSg)) {
                m12201fehf(c1606a8.m7591rkYL(AbstractC3340a5.f12583jeHSg));
            }
            m12205qGY(c1606a8.m7588mjFkc(AbstractC3340a5.f12459RnaHj, true));
        }
        m12193Pq(c1606a8.m7579JHa(AbstractC3340a5.f12526aAlqX, getResources().getDimensionPixelSize(AbstractC4191n4.f15342rWxwaT)));
        if (c1606a8.m7586fehf(AbstractC3340a5.f12449Qs)) {
            m12194Ucbh(AbstractC2002G.m8345AZxh(c1606a8.m7577Dt(AbstractC3340a5.f12449Qs, -1)));
        }
    }

    /* renamed from: rkYL */
    public void m12207rkYL(ColorStateList colorStateList) {
        this.f13971AZxh.setTextColor(colorStateList);
    }

    /* renamed from: vI */
    public void m12208vI(C2971Ucbh c2971Ucbh) {
        if (this.f13971AZxh.getVisibility() != 0) {
            c2971Ucbh.m10578fFz(this.f13975ZfxDd);
        } else {
            c2971Ucbh.m10539IVlxe(this.f13971AZxh);
            c2971Ucbh.m10578fFz(this.f13971AZxh);
        }
    }

    /* renamed from: wA */
    public TextView m12209wA() {
        return this.f13971AZxh;
    }

    /* renamed from: xJ */
    public ImageView.ScaleType m12210xJ() {
        return this.f13976lgHUyS;
    }
}
