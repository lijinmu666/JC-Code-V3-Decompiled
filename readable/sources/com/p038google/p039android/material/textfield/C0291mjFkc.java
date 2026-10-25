package com.p038google.p039android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.p038google.p039android.material.internal.CheckableImageButton;
import com.p038google.p039android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p131o.AbstractC1599A1;
import p131o.AbstractC1743CBhInx;
import p131o.AbstractC1803D4;
import p131o.AbstractC2002G;
import p131o.AbstractC2007G4;
import p131o.AbstractC2478N1;
import p131o.AbstractC2481N4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3340a5;
import p131o.AbstractC4065l8;
import p131o.AbstractC4191n4;
import p131o.AbstractC4195n8;
import p131o.AbstractC4332pCk;
import p131o.AbstractC4502rkYL;
import p131o.AbstractC4557sa;
import p131o.AbstractC4768vjlshU;
import p131o.AbstractC4793w7;
import p131o.C1606A8;
import p131o.C1916EoC;
import p131o.C2137I2;
import p131o.C2217JBjLUy;
import p131o.C2463Moer;
import p131o.C4457r3;
import p131o.C5037zpm;

/* renamed from: com.google.android.material.textfield.mjFkc */
/* loaded from: classes.dex */
public class C0291mjFkc extends LinearLayout {

    /* renamed from: AZxh */
    public final FrameLayout f2895AZxh;

    /* renamed from: Dt */
    public final LinkedHashSet f2896Dt;

    /* renamed from: ETF */
    public ColorStateList f2897ETF;

    /* renamed from: IEE */
    public boolean f2898IEE;

    /* renamed from: JHa */
    public View.OnLongClickListener f2899JHa;

    /* renamed from: KLFTb */
    public PorterDuff.Mode f2900KLFTb;

    /* renamed from: MiMN */
    public int f2901MiMN;

    /* renamed from: Pq */
    public EditText f2902Pq;

    /* renamed from: Ucbh */
    public final TextWatcher f2903Ucbh;

    /* renamed from: VA */
    public PorterDuff.Mode f2904VA;

    /* renamed from: YoKzxo */
    public ImageView.ScaleType f2905YoKzxo;

    /* renamed from: ZfxDd */
    public ColorStateList f2906ZfxDd;

    /* renamed from: diqgf */
    public final AccessibilityManager f2907diqgf;

    /* renamed from: eyqo */
    public AbstractC4502rkYL.mjFkc f2908eyqo;

    /* renamed from: fehf */
    public final TextView f2909fehf;

    /* renamed from: huTpC */
    public final TextInputLayout.InterfaceC0290xJ f2910huTpC;

    /* renamed from: lgHUyS */
    public final ZfxDd f2911lgHUyS;

    /* renamed from: mjFkc */
    public final TextInputLayout f2912mjFkc;

    /* renamed from: qGY */
    public CharSequence f2913qGY;

    /* renamed from: qdMbNW */
    public int f2914qdMbNW;

    /* renamed from: rkYL */
    public View.OnLongClickListener f2915rkYL;

    /* renamed from: wA */
    public final CheckableImageButton f2916wA;

    /* renamed from: xJ */
    public final CheckableImageButton f2917xJ;

    /* renamed from: com.google.android.material.textfield.mjFkc$AZxh */
    public class AZxh implements TextInputLayout.InterfaceC0290xJ {
        public AZxh() {
        }

        @Override // com.p038google.p039android.material.textfield.TextInputLayout.InterfaceC0290xJ
        /* renamed from: mjFkc */
        public void mo3201mjFkc(TextInputLayout textInputLayout) {
            if (C0291mjFkc.this.f2902Pq == textInputLayout.getEditText()) {
                return;
            }
            if (C0291mjFkc.this.f2902Pq != null) {
                C0291mjFkc.this.f2902Pq.removeTextChangedListener(C0291mjFkc.this.f2903Ucbh);
                if (C0291mjFkc.this.f2902Pq.getOnFocusChangeListener() == C0291mjFkc.this.m3224MiMN().mo7807KLFTb()) {
                    C0291mjFkc.this.f2902Pq.setOnFocusChangeListener(null);
                }
            }
            C0291mjFkc.this.f2902Pq = textInputLayout.getEditText();
            if (C0291mjFkc.this.f2902Pq != null) {
                C0291mjFkc.this.f2902Pq.addTextChangedListener(C0291mjFkc.this.f2903Ucbh);
            }
            C0291mjFkc.this.m3224MiMN().mo7811YoKzxo(C0291mjFkc.this.f2902Pq);
            C0291mjFkc c0291mjFkc = C0291mjFkc.this;
            c0291mjFkc.m3254jm(c0291mjFkc.m3224MiMN());
        }
    }

    /* renamed from: com.google.android.material.textfield.mjFkc$ZfxDd */
    public static class ZfxDd {

        /* renamed from: AZxh */
        public final C0291mjFkc f2919AZxh;

        /* renamed from: ZfxDd */
        public final int f2920ZfxDd;

        /* renamed from: mjFkc */
        public final SparseArray f2921mjFkc = new SparseArray();

        /* renamed from: wA */
        public final int f2922wA;

        public ZfxDd(C0291mjFkc c0291mjFkc, C1606A8 c1606a8) {
            this.f2919AZxh = c0291mjFkc;
            this.f2922wA = c1606a8.m7581MiMN(AbstractC3340a5.f12341Dc, 0);
            this.f2920ZfxDd = c1606a8.m7581MiMN(AbstractC3340a5.f12426MoUZ, 0);
        }

        /* renamed from: AZxh */
        public final AbstractC1743CBhInx m3279AZxh(int i) {
            if (i == -1) {
                return new C2217JBjLUy(this.f2919AZxh);
            }
            if (i == 0) {
                return new C2137I2(this.f2919AZxh);
            }
            if (i == 1) {
                return new C4457r3(this.f2919AZxh, this.f2920ZfxDd);
            }
            if (i == 2) {
                return new C1916EoC(this.f2919AZxh);
            }
            if (i == 3) {
                return new C5037zpm(this.f2919AZxh);
            }
            throw new IllegalArgumentException("Invalid end icon mode: " + i);
        }

        /* renamed from: wA */
        public AbstractC1743CBhInx m3280wA(int i) {
            AbstractC1743CBhInx abstractC1743CBhInx = (AbstractC1743CBhInx) this.f2921mjFkc.get(i);
            if (abstractC1743CBhInx != null) {
                return abstractC1743CBhInx;
            }
            AbstractC1743CBhInx abstractC1743CBhInxM3279AZxh = m3279AZxh(i);
            this.f2921mjFkc.append(i, abstractC1743CBhInxM3279AZxh);
            return abstractC1743CBhInxM3279AZxh;
        }
    }

    /* renamed from: com.google.android.material.textfield.mjFkc$mjFkc */
    public class mjFkc extends AbstractC4195n8 {
        public mjFkc() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            C0291mjFkc.this.m3224MiMN().mo7817mjFkc(editable);
        }

        @Override // p131o.AbstractC4195n8, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            C0291mjFkc.this.m3224MiMN().mo7802AZxh(charSequence, i, i2, i3);
        }
    }

    /* renamed from: com.google.android.material.textfield.mjFkc$wA */
    public class wA implements View.OnAttachStateChangeListener {
        public wA() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            C0291mjFkc.this.m3272xJ();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            C0291mjFkc.this.m3247cMLeY();
        }
    }

    public C0291mjFkc(TextInputLayout textInputLayout, C1606A8 c1606a8) {
        super(textInputLayout.getContext());
        this.f2914qdMbNW = 0;
        this.f2896Dt = new LinkedHashSet();
        this.f2903Ucbh = new mjFkc();
        AZxh aZxh = new AZxh();
        this.f2910huTpC = aZxh;
        this.f2907diqgf = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f2912mjFkc = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f2895AZxh = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonM3262qdMbNW = m3262qdMbNW(this, layoutInflaterFrom, AbstractC1803D4.f7789CqaNbM);
        this.f2916wA = checkableImageButtonM3262qdMbNW;
        CheckableImageButton checkableImageButtonM3262qdMbNW2 = m3262qdMbNW(frameLayout, layoutInflaterFrom, AbstractC1803D4.f7799Ne);
        this.f2917xJ = checkableImageButtonM3262qdMbNW2;
        this.f2911lgHUyS = new ZfxDd(this, c1606a8);
        C2463Moer c2463Moer = new C2463Moer(getContext());
        this.f2909fehf = c2463Moer;
        m3209BAnRFn(c1606a8);
        m3239VocHEe(c1606a8);
        m3256lB(c1606a8);
        frameLayout.addView(checkableImageButtonM3262qdMbNW2);
        addView(c2463Moer);
        addView(frameLayout);
        addView(checkableImageButtonM3262qdMbNW);
        textInputLayout.m3177lgHUyS(aZxh);
        addOnAttachStateChangeListener(new wA());
    }

    /* renamed from: ANMGZc */
    public void m3208ANMGZc(int i) {
        m3244alEkx(i != 0 ? getResources().getText(i) : null);
    }

    /* renamed from: BAnRFn */
    public final void m3209BAnRFn(C1606A8 c1606a8) {
        if (c1606a8.m7586fehf(AbstractC3340a5.f12593khi)) {
            this.f2906ZfxDd = AbstractC2478N1.m9573AZxh(getContext(), c1606a8, AbstractC3340a5.f12593khi);
        }
        if (c1606a8.m7586fehf(AbstractC3340a5.f12592kgk)) {
            this.f2900KLFTb = AbstractC4557sa.m13502JHa(c1606a8.m7577Dt(AbstractC3340a5.f12592kgk, -1), null);
        }
        if (c1606a8.m7586fehf(AbstractC3340a5.f12560gGFLGZ)) {
            m3242XV(c1606a8.m7593xJ(AbstractC3340a5.f12560gGFLGZ));
        }
        this.f2916wA.setContentDescription(getResources().getText(AbstractC2481N4.f9639JHa));
        AbstractC2876T9.m10244NKyg(this.f2916wA, 2);
        this.f2916wA.setClickable(false);
        this.f2916wA.setPressable(false);
        this.f2916wA.setFocusable(false);
    }

    /* renamed from: CqaNbM */
    public void m3210CqaNbM() {
        m3255kism();
        m3222KLMXS();
        m3274xrEuO();
        if (m3224MiMN().mo7813diqgf()) {
            m3226NKyg(this.f2912mjFkc.m3161WGXroI());
        }
    }

    /* renamed from: Dt */
    public final void m3211Dt(int i) {
        Iterator it = this.f2896Dt.iterator();
        if (it.hasNext()) {
            AbstractC4793w7.m13819mjFkc(it.next());
            throw null;
        }
    }

    /* renamed from: ETF */
    public CheckableImageButton m3212ETF() {
        if (m3229OjSQV()) {
            return this.f2916wA;
        }
        if (m3268vI() && m3258mByQ()) {
            return this.f2917xJ;
        }
        return null;
    }

    /* renamed from: GMIER */
    public void m3213GMIER(View.OnClickListener onClickListener) {
        AbstractC2002G.m8350lgHUyS(this.f2917xJ, onClickListener, this.f2915rkYL);
    }

    /* renamed from: Gd */
    public ColorStateList m3214Gd() {
        return this.f2909fehf.getTextColors();
    }

    /* renamed from: HGpJ */
    public TextView m3215HGpJ() {
        return this.f2909fehf;
    }

    /* renamed from: IEE */
    public CheckableImageButton m3216IEE() {
        return this.f2917xJ;
    }

    /* renamed from: IVlxe */
    public void m3217IVlxe(CharSequence charSequence) {
        this.f2913qGY = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f2909fehf.setText(charSequence);
        m3275yX();
    }

    /* renamed from: JBhc */
    public void m3218JBhc(ColorStateList colorStateList) {
        if (this.f2906ZfxDd != colorStateList) {
            this.f2906ZfxDd = colorStateList;
            AbstractC2002G.m8351mjFkc(this.f2912mjFkc, this.f2916wA, colorStateList, this.f2900KLFTb);
        }
    }

    /* renamed from: JYgkl */
    public void m3219JYgkl(ColorStateList colorStateList) {
        if (this.f2897ETF != colorStateList) {
            this.f2897ETF = colorStateList;
            AbstractC2002G.m8351mjFkc(this.f2912mjFkc, this.f2917xJ, colorStateList, this.f2904VA);
        }
    }

    /* renamed from: JYn */
    public void m3220JYn(ImageView.ScaleType scaleType) {
        this.f2905YoKzxo = scaleType;
        AbstractC2002G.m8346Dt(this.f2917xJ, scaleType);
        AbstractC2002G.m8346Dt(this.f2916wA, scaleType);
    }

    /* renamed from: JrJO */
    public void m3221JrJO(PorterDuff.Mode mode) {
        if (this.f2904VA != mode) {
            this.f2904VA = mode;
            AbstractC2002G.m8351mjFkc(this.f2912mjFkc, this.f2917xJ, this.f2897ETF, mode);
        }
    }

    /* renamed from: KLMXS */
    public void m3222KLMXS() {
        AbstractC2002G.m8349ZfxDd(this.f2912mjFkc, this.f2916wA, this.f2906ZfxDd);
    }

    /* renamed from: KRTLGT */
    public void m3223KRTLGT(int i) {
        if (this.f2914qdMbNW == i) {
            return;
        }
        m3231Qr(m3224MiMN());
        int i2 = this.f2914qdMbNW;
        this.f2914qdMbNW = i;
        m3211Dt(i2);
        m3259nxI(i != 0);
        AbstractC1743CBhInx abstractC1743CBhInxM3224MiMN = m3224MiMN();
        m3260oCFDzJ(m3248diqgf(abstractC1743CBhInxM3224MiMN));
        m3227NPj(abstractC1743CBhInxM3224MiMN.mo7821wA());
        m3238Vnb(abstractC1743CBhInxM3224MiMN.mo7810VA());
        if (!abstractC1743CBhInxM3224MiMN.mo7819qdMbNW(this.f2912mjFkc.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + this.f2912mjFkc.getBoxBackgroundMode() + " is not supported by the end icon mode " + i);
        }
        m3232SOS(abstractC1743CBhInxM3224MiMN);
        m3213GMIER(abstractC1743CBhInxM3224MiMN.mo7806JHa());
        EditText editText = this.f2902Pq;
        if (editText != null) {
            abstractC1743CBhInxM3224MiMN.mo7811YoKzxo(editText);
            m3254jm(abstractC1743CBhInxM3224MiMN);
        }
        AbstractC2002G.m8351mjFkc(this.f2912mjFkc, this.f2917xJ, this.f2897ETF, this.f2904VA);
        m3277zvd(true);
    }

    /* renamed from: MiMN */
    public AbstractC1743CBhInx m3224MiMN() {
        return this.f2911lgHUyS.m3280wA(this.f2914qdMbNW);
    }

    /* renamed from: Moer */
    public void m3225Moer(int i) {
        AbstractC4065l8.m12662MiMN(this.f2909fehf, i);
    }

    /* renamed from: NKyg */
    public final void m3226NKyg(boolean z) {
        if (!z || m3243YoKzxo() == null) {
            AbstractC2002G.m8351mjFkc(this.f2912mjFkc, this.f2917xJ, this.f2897ETF, this.f2904VA);
            return;
        }
        Drawable drawableMutate = AbstractC4332pCk.m13077VA(m3243YoKzxo()).mutate();
        AbstractC4332pCk.m13079lgHUyS(drawableMutate, this.f2912mjFkc.getErrorCurrentTextColors());
        this.f2917xJ.setImageDrawable(drawableMutate);
    }

    /* renamed from: NPj */
    public void m3227NPj(int i) {
        m3269vadzgd(i != 0 ? getResources().getText(i) : null);
    }

    /* renamed from: Ne */
    public void m3228Ne(boolean z) {
        this.f2898IEE = z;
        m3275yX();
    }

    /* renamed from: OjSQV */
    public boolean m3229OjSQV() {
        return this.f2916wA.getVisibility() == 0;
    }

    /* renamed from: Pq */
    public Drawable m3230Pq() {
        return this.f2916wA.getDrawable();
    }

    /* renamed from: Qr */
    public final void m3231Qr(AbstractC1743CBhInx abstractC1743CBhInx) {
        m3247cMLeY();
        this.f2908eyqo = null;
        abstractC1743CBhInx.mo7814eyqo();
    }

    /* renamed from: SOS */
    public final void m3232SOS(AbstractC1743CBhInx abstractC1743CBhInx) {
        abstractC1743CBhInx.mo7809Pq();
        this.f2908eyqo = abstractC1743CBhInx.mo7816lgHUyS();
        m3272xJ();
    }

    /* renamed from: SmIWf */
    public void m3233SmIWf(ColorStateList colorStateList) {
        this.f2909fehf.setTextColor(colorStateList);
    }

    /* renamed from: SwgkN */
    public void m3234SwgkN(View.OnLongClickListener onLongClickListener) {
        this.f2899JHa = onLongClickListener;
        AbstractC2002G.m8352qdMbNW(this.f2916wA, onLongClickListener);
    }

    /* renamed from: Ucbh */
    public Drawable m3235Ucbh() {
        return this.f2917xJ.getDrawable();
    }

    /* renamed from: VA */
    public CharSequence m3236VA() {
        return this.f2917xJ.getContentDescription();
    }

    /* renamed from: Vdz */
    public void m3237Vdz(PorterDuff.Mode mode) {
        if (this.f2900KLFTb != mode) {
            this.f2900KLFTb = mode;
            AbstractC2002G.m8351mjFkc(this.f2912mjFkc, this.f2916wA, this.f2906ZfxDd, mode);
        }
    }

    /* renamed from: Vnb */
    public void m3238Vnb(boolean z) {
        this.f2917xJ.setCheckable(z);
    }

    /* renamed from: VocHEe */
    public final void m3239VocHEe(C1606A8 c1606a8) {
        if (!c1606a8.m7586fehf(AbstractC3340a5.f12399JTqL)) {
            if (c1606a8.m7586fehf(AbstractC3340a5.f12626pGB)) {
                this.f2897ETF = AbstractC2478N1.m9573AZxh(getContext(), c1606a8, AbstractC3340a5.f12626pGB);
            }
            if (c1606a8.m7586fehf(AbstractC3340a5.f12379HRWx)) {
                this.f2904VA = AbstractC4557sa.m13502JHa(c1606a8.m7577Dt(AbstractC3340a5.f12379HRWx, -1), null);
            }
        }
        if (c1606a8.m7586fehf(AbstractC3340a5.f12454RW)) {
            m3223KRTLGT(c1606a8.m7577Dt(AbstractC3340a5.f12454RW, 0));
            if (c1606a8.m7586fehf(AbstractC3340a5.f12344DxPQMO)) {
                m3269vadzgd(c1606a8.m7591rkYL(AbstractC3340a5.f12344DxPQMO));
            }
            m3238Vnb(c1606a8.m7588mjFkc(AbstractC3340a5.f12501XDcuxS, true));
        } else if (c1606a8.m7586fehf(AbstractC3340a5.f12399JTqL)) {
            if (c1606a8.m7586fehf(AbstractC3340a5.f12531avDfWJ)) {
                this.f2897ETF = AbstractC2478N1.m9573AZxh(getContext(), c1606a8, AbstractC3340a5.f12531avDfWJ);
            }
            if (c1606a8.m7586fehf(AbstractC3340a5.f12497WjcLD)) {
                this.f2904VA = AbstractC4557sa.m13502JHa(c1606a8.m7577Dt(AbstractC3340a5.f12497WjcLD, -1), null);
            }
            m3223KRTLGT(c1606a8.m7588mjFkc(AbstractC3340a5.f12399JTqL, false) ? 1 : 0);
            m3269vadzgd(c1606a8.m7591rkYL(AbstractC3340a5.f12328BWWRl));
        }
        m3241WrLQs(c1606a8.m7579JHa(AbstractC3340a5.f12599lEH, getResources().getDimensionPixelSize(AbstractC4191n4.f15342rWxwaT)));
        if (c1606a8.m7586fehf(AbstractC3340a5.f12398JQSH)) {
            m3220JYn(AbstractC2002G.m8345AZxh(c1606a8.m7577Dt(AbstractC3340a5.f12398JQSH, -1)));
        }
    }

    /* renamed from: WGXroI */
    public void m3240WGXroI(int i) {
        m3242XV(i != 0 ? AbstractC4768vjlshU.m13794AZxh(getContext(), i) : null);
        m3222KLMXS();
    }

    /* renamed from: WrLQs */
    public void m3241WrLQs(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i != this.f2901MiMN) {
            this.f2901MiMN = i;
            AbstractC2002G.m8354xJ(this.f2917xJ, i);
            AbstractC2002G.m8354xJ(this.f2916wA, i);
        }
    }

    /* renamed from: XV */
    public void m3242XV(Drawable drawable) {
        this.f2916wA.setImageDrawable(drawable);
        m3255kism();
        AbstractC2002G.m8351mjFkc(this.f2912mjFkc, this.f2916wA, this.f2906ZfxDd, this.f2900KLFTb);
    }

    /* renamed from: YoKzxo */
    public Drawable m3243YoKzxo() {
        return this.f2917xJ.getDrawable();
    }

    /* renamed from: alEkx */
    public void m3244alEkx(CharSequence charSequence) {
        this.f2917xJ.setContentDescription(charSequence);
    }

    /* renamed from: aqHPIZ */
    public void m3245aqHPIZ(Drawable drawable) {
        this.f2917xJ.setImageDrawable(drawable);
        if (drawable != null) {
            AbstractC2002G.m8351mjFkc(this.f2912mjFkc, this.f2917xJ, this.f2897ETF, this.f2904VA);
            m3274xrEuO();
        }
    }

    /* renamed from: bbzow */
    public void m3246bbzow(View.OnClickListener onClickListener) {
        AbstractC2002G.m8350lgHUyS(this.f2916wA, onClickListener, this.f2899JHa);
    }

    /* renamed from: cMLeY */
    public final void m3247cMLeY() {
        AccessibilityManager accessibilityManager;
        AbstractC4502rkYL.mjFkc mjfkc = this.f2908eyqo;
        if (mjfkc == null || (accessibilityManager = this.f2907diqgf) == null) {
            return;
        }
        AbstractC4502rkYL.m13396AZxh(accessibilityManager, mjfkc);
    }

    /* renamed from: diqgf */
    public final int m3248diqgf(AbstractC1743CBhInx abstractC1743CBhInx) {
        int i = this.f2911lgHUyS.f2922wA;
        return i == 0 ? abstractC1743CBhInx.mo7812ZfxDd() : i;
    }

    /* renamed from: dm */
    public void m3249dm(int i) {
        m3265tQ(i != 0 ? AbstractC4768vjlshU.m13794AZxh(getContext(), i) : null);
    }

    /* renamed from: eyqo */
    public CharSequence m3250eyqo() {
        return this.f2917xJ.getContentDescription();
    }

    /* renamed from: fehf */
    public ImageView.ScaleType m3251fehf() {
        return this.f2905YoKzxo;
    }

    /* renamed from: gtIJp */
    public final void m3252gtIJp() {
        this.f2895AZxh.setVisibility((this.f2917xJ.getVisibility() != 0 || m3229OjSQV()) ? 8 : 0);
        setVisibility((m3258mByQ() || m3229OjSQV() || !((this.f2913qGY == null || this.f2898IEE) ? 8 : false)) ? 0 : 8);
    }

    /* renamed from: huTpC */
    public CharSequence m3253huTpC() {
        return this.f2913qGY;
    }

    /* renamed from: jm */
    public final void m3254jm(AbstractC1743CBhInx abstractC1743CBhInx) {
        if (this.f2902Pq == null) {
            return;
        }
        if (abstractC1743CBhInx.mo7807KLFTb() != null) {
            this.f2902Pq.setOnFocusChangeListener(abstractC1743CBhInx.mo7807KLFTb());
        }
        if (abstractC1743CBhInx.mo7822xJ() != null) {
            this.f2917xJ.setOnFocusChangeListener(abstractC1743CBhInx.mo7822xJ());
        }
    }

    /* renamed from: kism */
    public final void m3255kism() {
        this.f2916wA.setVisibility(m3230Pq() != null && this.f2912mjFkc.m3183rWxwaT() && this.f2912mjFkc.m3161WGXroI() ? 0 : 8);
        m3252gtIJp();
        m3266tjSezt();
        if (m3268vI()) {
            return;
        }
        this.f2912mjFkc.m3195yfx();
    }

    /* renamed from: lB */
    public final void m3256lB(C1606A8 c1606a8) {
        this.f2909fehf.setVisibility(8);
        this.f2909fehf.setId(AbstractC1803D4.f7804Vnb);
        this.f2909fehf.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        AbstractC2876T9.m10289tQ(this.f2909fehf, 1);
        m3225Moer(c1606a8.m7581MiMN(AbstractC3340a5.f12348EaLbDP, 0));
        if (c1606a8.m7586fehf(AbstractC3340a5.f12571gy)) {
            m3233SmIWf(c1606a8.m7592wA(AbstractC3340a5.f12571gy));
        }
        m3217IVlxe(c1606a8.m7591rkYL(AbstractC3340a5.f12541bzZHlx));
    }

    /* renamed from: lgHUyS */
    public void m3257lgHUyS() {
        this.f2917xJ.performClick();
        this.f2917xJ.jumpDrawablesToCurrentState();
    }

    /* renamed from: mByQ */
    public boolean m3258mByQ() {
        return this.f2895AZxh.getVisibility() == 0 && this.f2917xJ.getVisibility() == 0;
    }

    /* renamed from: nxI */
    public void m3259nxI(boolean z) {
        if (m3258mByQ() != z) {
            this.f2917xJ.setVisibility(z ? 0 : 8);
            m3252gtIJp();
            m3266tjSezt();
            this.f2912mjFkc.m3195yfx();
        }
    }

    /* renamed from: oCFDzJ */
    public void m3260oCFDzJ(int i) {
        m3245aqHPIZ(i != 0 ? AbstractC4768vjlshU.m13794AZxh(getContext(), i) : null);
    }

    /* renamed from: qGY */
    public int m3261qGY() {
        return this.f2914qdMbNW;
    }

    /* renamed from: qdMbNW */
    public final CheckableImageButton m3262qdMbNW(ViewGroup viewGroup, LayoutInflater layoutInflater, int i) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(AbstractC2007G4.f8318ZfxDd, viewGroup, false);
        checkableImageButton.setId(i);
        AbstractC2002G.m8348KLFTb(checkableImageButton);
        if (AbstractC2478N1.m9574JHa(getContext())) {
            AbstractC1599A1.m7547ZfxDd((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    /* renamed from: rWxwaT */
    public void m3263rWxwaT(boolean z) {
        this.f2917xJ.setActivated(z);
    }

    /* renamed from: rkYL */
    public int m3264rkYL() {
        return this.f2901MiMN;
    }

    /* renamed from: tQ */
    public void m3265tQ(Drawable drawable) {
        this.f2917xJ.setImageDrawable(drawable);
    }

    /* renamed from: tjSezt */
    public void m3266tjSezt() {
        if (this.f2912mjFkc.f2853ZfxDd == null) {
            return;
        }
        AbstractC2876T9.m10274gYa(this.f2909fehf, getContext().getResources().getDimensionPixelSize(AbstractC4191n4.f15311Gd), this.f2912mjFkc.f2853ZfxDd.getPaddingTop(), (m3258mByQ() || m3229OjSQV()) ? 0 : AbstractC2876T9.m10257VocHEe(this.f2912mjFkc.f2853ZfxDd), this.f2912mjFkc.f2853ZfxDd.getPaddingBottom());
    }

    /* renamed from: uHVRx */
    public void m3267uHVRx(View.OnLongClickListener onLongClickListener) {
        this.f2915rkYL = onLongClickListener;
        AbstractC2002G.m8352qdMbNW(this.f2917xJ, onLongClickListener);
    }

    /* renamed from: vI */
    public boolean m3268vI() {
        return this.f2914qdMbNW != 0;
    }

    /* renamed from: vadzgd */
    public void m3269vadzgd(CharSequence charSequence) {
        if (m3236VA() != charSequence) {
            this.f2917xJ.setContentDescription(charSequence);
        }
    }

    /* renamed from: vjlshU */
    public void m3270vjlshU(ColorStateList colorStateList) {
        this.f2897ETF = colorStateList;
        AbstractC2002G.m8351mjFkc(this.f2912mjFkc, this.f2917xJ, colorStateList, this.f2904VA);
    }

    /* renamed from: wJVbdd */
    public boolean m3271wJVbdd() {
        return m3268vI() && this.f2917xJ.isChecked();
    }

    /* renamed from: xJ */
    public final void m3272xJ() {
        if (this.f2908eyqo == null || this.f2907diqgf == null || !AbstractC2876T9.m10268cMLeY(this)) {
            return;
        }
        AbstractC4502rkYL.m13397mjFkc(this.f2907diqgf, this.f2908eyqo);
    }

    /* renamed from: xROA */
    public void m3273xROA(PorterDuff.Mode mode) {
        this.f2904VA = mode;
        AbstractC2002G.m8351mjFkc(this.f2912mjFkc, this.f2917xJ, this.f2897ETF, mode);
    }

    /* renamed from: xrEuO */
    public void m3274xrEuO() {
        AbstractC2002G.m8349ZfxDd(this.f2912mjFkc, this.f2917xJ, this.f2897ETF);
    }

    /* renamed from: yX */
    public final void m3275yX() {
        int visibility = this.f2909fehf.getVisibility();
        int i = (this.f2913qGY == null || this.f2898IEE) ? 8 : 0;
        if (visibility != i) {
            m3224MiMN().mo7815fehf(i == 0);
        }
        m3252gtIJp();
        this.f2909fehf.setVisibility(i);
        this.f2912mjFkc.m3195yfx();
    }

    /* renamed from: yfx */
    public void m3276yfx(boolean z) {
        if (z && this.f2914qdMbNW != 1) {
            m3223KRTLGT(1);
        } else {
            if (z) {
                return;
            }
            m3223KRTLGT(0);
        }
    }

    /* renamed from: zvd */
    public void m3277zvd(boolean z) {
        boolean z2;
        boolean zIsActivated;
        boolean zIsChecked;
        AbstractC1743CBhInx abstractC1743CBhInxM3224MiMN = m3224MiMN();
        boolean z3 = true;
        if (!abstractC1743CBhInxM3224MiMN.mo7810VA() || (zIsChecked = this.f2917xJ.isChecked()) == abstractC1743CBhInxM3224MiMN.mo7808MiMN()) {
            z2 = false;
        } else {
            this.f2917xJ.setChecked(!zIsChecked);
            z2 = true;
        }
        if (!abstractC1743CBhInxM3224MiMN.mo7803Dt() || (zIsActivated = this.f2917xJ.isActivated()) == abstractC1743CBhInxM3224MiMN.mo7804ETF()) {
            z3 = z2;
        } else {
            m3263rWxwaT(!zIsActivated);
        }
        if (z || z3) {
            m3274xrEuO();
        }
    }
}
