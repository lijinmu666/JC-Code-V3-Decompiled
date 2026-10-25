package p131o;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import p131o.C2141I6;

/* renamed from: o.J1 */
/* loaded from: classes.dex */
public class C2205J1 {

    /* renamed from: Dt */
    public Drawable f8829Dt;

    /* renamed from: ETF */
    public ColorStateList f8830ETF;

    /* renamed from: Gd */
    public final int f8831Gd;

    /* renamed from: IEE */
    public C2542O1 f8833IEE;

    /* renamed from: JHa */
    public int f8834JHa;

    /* renamed from: KLFTb */
    public int f8835KLFTb;

    /* renamed from: MiMN */
    public C2141I6 f8836MiMN;

    /* renamed from: Ucbh */
    public final TimeInterpolator f8838Ucbh;

    /* renamed from: VA */
    public ColorStateList f8839VA;

    /* renamed from: YoKzxo */
    public ColorStateList f8840YoKzxo;

    /* renamed from: ZfxDd */
    public final C2542O1 f8841ZfxDd;

    /* renamed from: diqgf */
    public boolean f8842diqgf;

    /* renamed from: eyqo */
    public ValueAnimator f8843eyqo;

    /* renamed from: fehf */
    public C2542O1 f8844fehf;

    /* renamed from: huTpC */
    public final int f8845huTpC;

    /* renamed from: lgHUyS */
    public int f8846lgHUyS;

    /* renamed from: mjFkc */
    public final C2068H1 f8847mjFkc;

    /* renamed from: qGY */
    public LayerDrawable f8848qGY;

    /* renamed from: qdMbNW */
    public Drawable f8849qdMbNW;

    /* renamed from: rkYL */
    public Drawable f8850rkYL;

    /* renamed from: wA */
    public final C2542O1 f8851wA;

    /* renamed from: xJ */
    public int f8852xJ;

    /* renamed from: vI */
    public static final double f8827vI = Math.cos(Math.toRadians(45.0d));

    /* renamed from: VocHEe */
    public static final Drawable f8826VocHEe = null;

    /* renamed from: AZxh */
    public final Rect f8828AZxh = new Rect();

    /* renamed from: Pq */
    public boolean f8837Pq = false;

    /* renamed from: HGpJ */
    public float f8832HGpJ = 0.0f;

    /* renamed from: o.J1$mjFkc */
    public class mjFkc extends InsetDrawable {
        public mjFkc(Drawable drawable, int i, int i2, int i3, int i4) {
            super(drawable, i, i2, i3, i4);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public C2205J1(C2068H1 c2068h1, AttributeSet attributeSet, int i, int i2) {
        this.f8847mjFkc = c2068h1;
        C2542O1 c2542o1 = new C2542O1(c2068h1.getContext(), attributeSet, i, i2);
        this.f8851wA = c2542o1;
        c2542o1.m9827cMLeY(c2068h1.getContext());
        c2542o1.m9821WGXroI(-12303292);
        C2141I6.AZxh aZxhM8670Ucbh = c2542o1.m9833lB().m8670Ucbh();
        TypedArray typedArrayObtainStyledAttributes = c2068h1.getContext().obtainStyledAttributes(attributeSet, AbstractC3340a5.f12400JYgkl, i, AbstractC2737R4.f10373mjFkc);
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC3340a5.f12405JrJO)) {
            aZxhM8670Ucbh.m8710rkYL(typedArrayObtainStyledAttributes.getDimension(AbstractC3340a5.f12405JrJO, 0.0f));
        }
        this.f8841ZfxDd = new C2542O1();
        m8867nxI(aZxhM8670Ucbh.m8698MiMN());
        this.f8838Ucbh = AbstractC4923y2.m13988xJ(c2068h1.getContext(), AbstractC3800h4.f13944lB, AbstractC2506NPj.f9739mjFkc);
        this.f8845huTpC = AbstractC4923y2.m13983JHa(c2068h1.getContext(), AbstractC3800h4.f13925Gd, 300);
        this.f8831Gd = AbstractC4923y2.m13983JHa(c2068h1.getContext(), AbstractC3800h4.f13943huTpC, 300);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: ANMGZc */
    public void m8820ANMGZc() {
        this.f8851wA.m9801GMIER(this.f8847mjFkc.getCardElevation());
    }

    /* renamed from: AZxh */
    public void m8821AZxh(boolean z) {
        float f = z ? 1.0f : 0.0f;
        float f2 = z ? 1.0f - this.f8832HGpJ : this.f8832HGpJ;
        ValueAnimator valueAnimator = this.f8843eyqo;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f8843eyqo = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f8832HGpJ, f);
        this.f8843eyqo = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o.I1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f8666mjFkc.m8880xrEuO(valueAnimator2);
            }
        });
        this.f8843eyqo.setInterpolator(this.f8838Ucbh);
        this.f8843eyqo.setDuration((long) ((z ? this.f8845huTpC : this.f8831Gd) * f2));
        this.f8843eyqo.start();
    }

    /* renamed from: BAnRFn */
    public int m8822BAnRFn() {
        return this.f8846lgHUyS;
    }

    /* renamed from: CqaNbM */
    public final boolean m8823CqaNbM() {
        return (this.f8852xJ & 8388613) == 8388613;
    }

    /* renamed from: Dt */
    public final C2542O1 m8824Dt() {
        return new C2542O1(this.f8836MiMN);
    }

    /* renamed from: ETF */
    public void m8825ETF() {
        Drawable drawable = this.f8850rkYL;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i = bounds.bottom;
            this.f8850rkYL.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
            this.f8850rkYL.setBounds(bounds.left, bounds.top, bounds.right, i);
        }
    }

    /* renamed from: GMIER */
    public void m8826GMIER(int i) {
        this.f8834JHa = i;
    }

    /* renamed from: Gd */
    public ColorStateList m8827Gd() {
        return this.f8830ETF;
    }

    /* renamed from: HGpJ */
    public C2141I6 m8828HGpJ() {
        return this.f8836MiMN;
    }

    /* renamed from: IEE */
    public int m8829IEE() {
        return this.f8834JHa;
    }

    /* renamed from: JBhc */
    public final boolean m8830JBhc() {
        return this.f8847mjFkc.getPreventCornerOverlap() && m8879xJ() && this.f8847mjFkc.getUseCompatPadding();
    }

    /* renamed from: JHa */
    public final float m8831JHa() {
        return (this.f8847mjFkc.getMaxCardElevation() * 1.5f) + (m8830JBhc() ? m8877wA() : 0.0f);
    }

    /* renamed from: JYgkl */
    public void m8832JYgkl(float f) {
        this.f8851wA.m9807JYn(f);
        C2542O1 c2542o1 = this.f8841ZfxDd;
        if (c2542o1 != null) {
            c2542o1.m9807JYn(f);
        }
        C2542O1 c2542o12 = this.f8833IEE;
        if (c2542o12 != null) {
            c2542o12.m9807JYn(f);
        }
    }

    /* renamed from: JYn */
    public void m8833JYn(float f) {
        m8867nxI(this.f8836MiMN.m8676huTpC(f));
        this.f8849qdMbNW.invalidateSelf();
        if (m8830JBhc() || m8843SwgkN()) {
            m8863jm();
        }
        if (m8830JBhc()) {
            m8859dm();
        }
    }

    /* renamed from: JrJO */
    public void m8834JrJO(ColorStateList colorStateList) {
        this.f8830ETF = colorStateList;
        m8873tQ();
    }

    /* renamed from: KLFTb */
    public final float m8835KLFTb() {
        return this.f8847mjFkc.getMaxCardElevation() + (m8830JBhc() ? m8877wA() : 0.0f);
    }

    /* renamed from: KLMXS */
    public void m8836KLMXS(TypedArray typedArray) {
        ColorStateList colorStateListM9577mjFkc = AbstractC2478N1.m9577mjFkc(this.f8847mjFkc.getContext(), typedArray, AbstractC3340a5.f12425MlqoT);
        this.f8840YoKzxo = colorStateListM9577mjFkc;
        if (colorStateListM9577mjFkc == null) {
            this.f8840YoKzxo = ColorStateList.valueOf(-1);
        }
        this.f8846lgHUyS = typedArray.getDimensionPixelSize(AbstractC3340a5.f12650sZ, 0);
        boolean z = typedArray.getBoolean(AbstractC3340a5.f12323BABY, false);
        this.f8842diqgf = z;
        this.f8847mjFkc.setLongClickable(z);
        this.f8839VA = AbstractC2478N1.m9577mjFkc(this.f8847mjFkc.getContext(), typedArray, AbstractC3340a5.f12576ih);
        m8855aqHPIZ(AbstractC2478N1.m9578wA(this.f8847mjFkc.getContext(), typedArray, AbstractC3340a5.f12639qtZIjO));
        m8826GMIER(typedArray.getDimensionPixelSize(AbstractC3340a5.f12597kw, 0));
        m8837KRTLGT(typedArray.getDimensionPixelSize(AbstractC3340a5.f12567gjvQ, 0));
        this.f8852xJ = typedArray.getInteger(AbstractC3340a5.f12693xVYW, 8388661);
        ColorStateList colorStateListM9577mjFkc2 = AbstractC2478N1.m9577mjFkc(this.f8847mjFkc.getContext(), typedArray, AbstractC3340a5.f12412KbE);
        this.f8830ETF = colorStateListM9577mjFkc2;
        if (colorStateListM9577mjFkc2 == null) {
            this.f8830ETF = ColorStateList.valueOf(AbstractC2345L1.m9303ZfxDd(this.f8847mjFkc, AbstractC3800h4.f13939ZfxDd));
        }
        m8847Vnb(AbstractC2478N1.m9577mjFkc(this.f8847mjFkc.getContext(), typedArray, AbstractC3340a5.f12561gJsSk));
        m8873tQ();
        m8820ANMGZc();
        m8881yfx();
        this.f8847mjFkc.setBackgroundInternal(m8878wJVbdd(this.f8851wA));
        Drawable drawableM8858diqgf = this.f8847mjFkc.isClickable() ? m8858diqgf() : this.f8841ZfxDd;
        this.f8849qdMbNW = drawableM8858diqgf;
        this.f8847mjFkc.setForeground(m8878wJVbdd(drawableM8858diqgf));
    }

    /* renamed from: KRTLGT */
    public void m8837KRTLGT(int i) {
        this.f8835KLFTb = i;
    }

    /* renamed from: MiMN */
    public ColorStateList m8838MiMN() {
        return this.f8851wA.m9802Gd();
    }

    /* renamed from: NPj */
    public void m8839NPj(boolean z) {
        this.f8842diqgf = z;
    }

    /* renamed from: Ne */
    public final boolean m8840Ne() {
        return (this.f8852xJ & 80) == 80;
    }

    /* renamed from: OjSQV */
    public boolean m8841OjSQV() {
        return this.f8842diqgf;
    }

    /* renamed from: Pq */
    public ColorStateList m8842Pq() {
        return this.f8839VA;
    }

    /* renamed from: SwgkN */
    public final boolean m8843SwgkN() {
        return this.f8847mjFkc.getPreventCornerOverlap() && !m8879xJ();
    }

    /* renamed from: Ucbh */
    public final float m8844Ucbh() {
        if (this.f8847mjFkc.getPreventCornerOverlap() && this.f8847mjFkc.getUseCompatPadding()) {
            return (float) ((1.0d - f8827vI) * this.f8847mjFkc.getCardViewRadius());
        }
        return 0.0f;
    }

    /* renamed from: VA */
    public C2542O1 m8845VA() {
        return this.f8851wA;
    }

    /* renamed from: Vdz */
    public void m8846Vdz() {
        Drawable drawable = this.f8849qdMbNW;
        Drawable drawableM8858diqgf = this.f8847mjFkc.isClickable() ? m8858diqgf() : this.f8841ZfxDd;
        this.f8849qdMbNW = drawableM8858diqgf;
        if (drawable != drawableM8858diqgf) {
            m8854alEkx(drawableM8858diqgf);
        }
    }

    /* renamed from: Vnb */
    public void m8847Vnb(ColorStateList colorStateList) {
        C2542O1 c2542o1 = this.f8841ZfxDd;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        c2542o1.m9841uHVRx(colorStateList);
    }

    /* renamed from: VocHEe */
    public ColorStateList m8848VocHEe() {
        return this.f8840YoKzxo;
    }

    /* renamed from: WGXroI */
    public void m8849WGXroI(ColorStateList colorStateList) {
        if (this.f8840YoKzxo == colorStateList) {
            return;
        }
        this.f8840YoKzxo = colorStateList;
        m8881yfx();
    }

    /* renamed from: WrLQs */
    public void m8850WrLQs(int i) {
        this.f8852xJ = i;
        m8882zvd(this.f8847mjFkc.getMeasuredWidth(), this.f8847mjFkc.getMeasuredHeight());
    }

    /* renamed from: XV */
    public void m8851XV(int i) {
        if (i == this.f8846lgHUyS) {
            return;
        }
        this.f8846lgHUyS = i;
        m8881yfx();
    }

    /* renamed from: YoKzxo */
    public ColorStateList m8852YoKzxo() {
        return this.f8841ZfxDd.m9802Gd();
    }

    /* renamed from: ZfxDd */
    public final float m8853ZfxDd(AbstractC4638tnpR abstractC4638tnpR, float f) {
        if (abstractC4638tnpR instanceof C2072H5) {
            return (float) ((1.0d - f8827vI) * f);
        }
        if (abstractC4638tnpR instanceof C2990UqgK) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    /* renamed from: alEkx */
    public final void m8854alEkx(Drawable drawable) {
        if (this.f8847mjFkc.getForeground() instanceof InsetDrawable) {
            ((InsetDrawable) this.f8847mjFkc.getForeground()).setDrawable(drawable);
        } else {
            this.f8847mjFkc.setForeground(m8878wJVbdd(drawable));
        }
    }

    /* renamed from: aqHPIZ */
    public void m8855aqHPIZ(Drawable drawable) {
        if (drawable != null) {
            Drawable drawableMutate = AbstractC4332pCk.m13077VA(drawable).mutate();
            this.f8829Dt = drawableMutate;
            AbstractC4332pCk.m13081qdMbNW(drawableMutate, this.f8839VA);
            m8876vadzgd(this.f8847mjFkc.isChecked());
        } else {
            this.f8829Dt = f8826VocHEe;
        }
        LayerDrawable layerDrawable = this.f8848qGY;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(AbstractC1803D4.f7821vI, this.f8829Dt);
        }
    }

    /* renamed from: bbzow */
    public void m8856bbzow(int i, int i2, int i3, int i4) {
        this.f8828AZxh.set(i, i2, i3, i4);
        m8863jm();
    }

    /* renamed from: cMLeY */
    public void m8857cMLeY(boolean z) {
        this.f8837Pq = z;
    }

    /* renamed from: diqgf */
    public final Drawable m8858diqgf() {
        if (this.f8850rkYL == null) {
            this.f8850rkYL = m8870qdMbNW();
        }
        if (this.f8848qGY == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f8850rkYL, this.f8841ZfxDd, this.f8829Dt});
            this.f8848qGY = layerDrawable;
            layerDrawable.setId(2, AbstractC1803D4.f7821vI);
        }
        return this.f8848qGY;
    }

    /* renamed from: dm */
    public void m8859dm() {
        if (!m8866mByQ()) {
            this.f8847mjFkc.setBackgroundInternal(m8878wJVbdd(this.f8851wA));
        }
        this.f8847mjFkc.setForeground(m8878wJVbdd(this.f8849qdMbNW));
    }

    /* renamed from: eyqo */
    public float m8860eyqo() {
        return this.f8851wA.m9835mByQ();
    }

    /* renamed from: fehf */
    public int m8861fehf() {
        return this.f8835KLFTb;
    }

    /* renamed from: huTpC */
    public float m8862huTpC() {
        return this.f8851wA.m9803HGpJ();
    }

    /* renamed from: jm */
    public void m8863jm() {
        int iM8877wA = (int) (((m8843SwgkN() || m8830JBhc()) ? m8877wA() : 0.0f) - m8844Ucbh());
        C2068H1 c2068h1 = this.f8847mjFkc;
        Rect rect = this.f8828AZxh;
        c2068h1.m8493xJ(rect.left + iM8877wA, rect.top + iM8877wA, rect.right + iM8877wA, rect.bottom + iM8877wA);
    }

    /* renamed from: lB */
    public Rect m8864lB() {
        return this.f8828AZxh;
    }

    /* renamed from: lgHUyS */
    public final Drawable m8865lgHUyS() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        C2542O1 c2542o1M8824Dt = m8824Dt();
        this.f8844fehf = c2542o1M8824Dt;
        c2542o1M8824Dt.m9841uHVRx(this.f8830ETF);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.f8844fehf);
        return stateListDrawable;
    }

    /* renamed from: mByQ */
    public boolean m8866mByQ() {
        return this.f8837Pq;
    }

    /* renamed from: nxI */
    public void m8867nxI(C2141I6 c2141i6) {
        this.f8836MiMN = c2141i6;
        this.f8851wA.setShapeAppearanceModel(c2141i6);
        this.f8851wA.m9836nxI(!r0.m9811NPj());
        C2542O1 c2542o1 = this.f8841ZfxDd;
        if (c2542o1 != null) {
            c2542o1.setShapeAppearanceModel(c2141i6);
        }
        C2542O1 c2542o12 = this.f8833IEE;
        if (c2542o12 != null) {
            c2542o12.setShapeAppearanceModel(c2141i6);
        }
        C2542O1 c2542o13 = this.f8844fehf;
        if (c2542o13 != null) {
            c2542o13.setShapeAppearanceModel(c2141i6);
        }
    }

    /* renamed from: oCFDzJ */
    public void m8868oCFDzJ(boolean z, boolean z2) {
        Drawable drawable = this.f8829Dt;
        if (drawable != null) {
            if (z2) {
                m8821AZxh(z);
            } else {
                drawable.setAlpha(z ? 255 : 0);
                this.f8832HGpJ = z ? 1.0f : 0.0f;
            }
        }
    }

    /* renamed from: qGY */
    public int m8869qGY() {
        return this.f8852xJ;
    }

    /* renamed from: qdMbNW */
    public final Drawable m8870qdMbNW() {
        if (!AbstractC1735C5.f7559mjFkc) {
            return m8865lgHUyS();
        }
        this.f8833IEE = m8824Dt();
        return new RippleDrawable(this.f8830ETF, null, this.f8833IEE);
    }

    /* renamed from: rWxwaT */
    public void m8871rWxwaT(ColorStateList colorStateList) {
        this.f8851wA.m9841uHVRx(colorStateList);
    }

    /* renamed from: rkYL */
    public Drawable m8872rkYL() {
        return this.f8829Dt;
    }

    /* renamed from: tQ */
    public final void m8873tQ() {
        Drawable drawable;
        if (AbstractC1735C5.f7559mjFkc && (drawable = this.f8850rkYL) != null) {
            ((RippleDrawable) drawable).setColor(this.f8830ETF);
            return;
        }
        C2542O1 c2542o1 = this.f8844fehf;
        if (c2542o1 != null) {
            c2542o1.m9841uHVRx(this.f8830ETF);
        }
    }

    /* renamed from: uHVRx */
    public void m8874uHVRx(ColorStateList colorStateList) {
        this.f8839VA = colorStateList;
        Drawable drawable = this.f8829Dt;
        if (drawable != null) {
            AbstractC4332pCk.m13081qdMbNW(drawable, colorStateList);
        }
    }

    /* renamed from: vI */
    public int m8875vI() {
        ColorStateList colorStateList = this.f8840YoKzxo;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    /* renamed from: vadzgd */
    public void m8876vadzgd(boolean z) {
        m8868oCFDzJ(z, false);
    }

    /* renamed from: wA */
    public final float m8877wA() {
        return Math.max(Math.max(m8853ZfxDd(this.f8836MiMN.m8675fehf(), this.f8851wA.m9835mByQ()), m8853ZfxDd(this.f8836MiMN.m8669Pq(), this.f8851wA.m9813OjSQV())), Math.max(m8853ZfxDd(this.f8836MiMN.m8665ETF(), this.f8851wA.m9828diqgf()), m8853ZfxDd(this.f8836MiMN.m8679qdMbNW(), this.f8851wA.m9814Pq())));
    }

    /* renamed from: wJVbdd */
    public final Drawable m8878wJVbdd(Drawable drawable) {
        int iCeil;
        int iCeil2;
        if (this.f8847mjFkc.getUseCompatPadding()) {
            iCeil2 = (int) Math.ceil(m8831JHa());
            iCeil = (int) Math.ceil(m8835KLFTb());
        } else {
            iCeil = 0;
            iCeil2 = 0;
        }
        return new mjFkc(drawable, iCeil, iCeil2, iCeil, iCeil2);
    }

    /* renamed from: xJ */
    public final boolean m8879xJ() {
        return this.f8851wA.m9811NPj();
    }

    /* renamed from: xrEuO */
    public final /* synthetic */ void m8880xrEuO(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f8829Dt.setAlpha((int) (255.0f * fFloatValue));
        this.f8832HGpJ = fFloatValue;
    }

    /* renamed from: yfx */
    public void m8881yfx() {
        this.f8841ZfxDd.m9826bbzow(this.f8846lgHUyS, this.f8840YoKzxo);
    }

    /* renamed from: zvd */
    public void m8882zvd(int i, int i2) {
        int iCeil;
        int iCeil2;
        int i3;
        int i4;
        if (this.f8848qGY != null) {
            if (this.f8847mjFkc.getUseCompatPadding()) {
                iCeil = (int) Math.ceil(m8831JHa() * 2.0f);
                iCeil2 = (int) Math.ceil(m8835KLFTb() * 2.0f);
            } else {
                iCeil = 0;
                iCeil2 = 0;
            }
            int i5 = m8823CqaNbM() ? ((i - this.f8835KLFTb) - this.f8834JHa) - iCeil2 : this.f8835KLFTb;
            int i6 = m8840Ne() ? this.f8835KLFTb : ((i2 - this.f8835KLFTb) - this.f8834JHa) - iCeil;
            int i7 = m8823CqaNbM() ? this.f8835KLFTb : ((i - this.f8835KLFTb) - this.f8834JHa) - iCeil2;
            int i8 = m8840Ne() ? ((i2 - this.f8835KLFTb) - this.f8834JHa) - iCeil : this.f8835KLFTb;
            if (AbstractC2876T9.m10276huTpC(this.f8847mjFkc) == 1) {
                i4 = i7;
                i3 = i5;
            } else {
                i3 = i7;
                i4 = i5;
            }
            this.f8848qGY.setLayerInset(2, i4, i8, i3, i6);
        }
    }
}
