package p131o;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.p038google.p039android.material.p058button.MaterialButton;

/* renamed from: o.G1 */
/* loaded from: classes.dex */
public class C2004G1 {

    /* renamed from: AZxh */
    public C2141I6 f8281AZxh;

    /* renamed from: Dt */
    public ColorStateList f8282Dt;

    /* renamed from: ETF */
    public ColorStateList f8283ETF;

    /* renamed from: JHa */
    public int f8285JHa;

    /* renamed from: KLFTb */
    public int f8286KLFTb;

    /* renamed from: MiMN */
    public Drawable f8287MiMN;

    /* renamed from: Pq */
    public LayerDrawable f8288Pq;

    /* renamed from: VA */
    public ColorStateList f8289VA;

    /* renamed from: ZfxDd */
    public int f8291ZfxDd;

    /* renamed from: diqgf */
    public int f8292diqgf;

    /* renamed from: fehf */
    public boolean f8293fehf;

    /* renamed from: lgHUyS */
    public int f8294lgHUyS;

    /* renamed from: mjFkc */
    public final MaterialButton f8295mjFkc;

    /* renamed from: qdMbNW */
    public PorterDuff.Mode f8297qdMbNW;

    /* renamed from: wA */
    public int f8299wA;

    /* renamed from: xJ */
    public int f8300xJ;

    /* renamed from: eyqo */
    public static final boolean f8280eyqo = true;

    /* renamed from: Ucbh */
    public static final boolean f8279Ucbh = false;

    /* renamed from: YoKzxo */
    public boolean f8290YoKzxo = false;

    /* renamed from: rkYL */
    public boolean f8298rkYL = false;

    /* renamed from: qGY */
    public boolean f8296qGY = false;

    /* renamed from: IEE */
    public boolean f8284IEE = true;

    public C2004G1(MaterialButton materialButton, C2141I6 c2141i6) {
        this.f8295mjFkc = materialButton;
        this.f8281AZxh = c2141i6;
    }

    /* renamed from: AZxh */
    public int m8356AZxh() {
        return this.f8300xJ;
    }

    /* renamed from: BAnRFn */
    public void m8357BAnRFn(ColorStateList colorStateList) {
        if (this.f8283ETF != colorStateList) {
            this.f8283ETF = colorStateList;
            m8366KLMXS();
        }
    }

    /* renamed from: CqaNbM */
    public final void m8358CqaNbM() {
        this.f8295mjFkc.setInternalBackground(m8383mjFkc());
        C2542O1 c2542o1M8364JHa = m8364JHa();
        if (c2542o1M8364JHa != null) {
            c2542o1M8364JHa.m9801GMIER(this.f8292diqgf);
            c2542o1M8364JHa.setState(this.f8295mjFkc.getDrawableState());
        }
    }

    /* renamed from: Dt */
    public ColorStateList m8359Dt() {
        return this.f8283ETF;
    }

    /* renamed from: ETF */
    public int m8360ETF() {
        return this.f8294lgHUyS;
    }

    /* renamed from: Gd */
    public void m8361Gd(int i) {
        m8368Ne(i, this.f8285JHa);
    }

    /* renamed from: HGpJ */
    public void m8362HGpJ(ColorStateList colorStateList) {
        if (this.f8289VA != colorStateList) {
            this.f8289VA = colorStateList;
            boolean z = f8280eyqo;
            if (z && (this.f8295mjFkc.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f8295mjFkc.getBackground()).setColor(AbstractC1735C5.m7750mjFkc(colorStateList));
            } else {
                if (z || !(this.f8295mjFkc.getBackground() instanceof C1668B5)) {
                    return;
                }
                ((C1668B5) this.f8295mjFkc.getBackground()).setTintList(AbstractC1735C5.m7750mjFkc(colorStateList));
            }
        }
    }

    /* renamed from: IEE */
    public void m8363IEE(TypedArray typedArray) {
        this.f8299wA = typedArray.getDimensionPixelOffset(AbstractC3340a5.f12411KSf, 0);
        this.f8291ZfxDd = typedArray.getDimensionPixelOffset(AbstractC3340a5.f12493Vptz, 0);
        this.f8286KLFTb = typedArray.getDimensionPixelOffset(AbstractC3340a5.f12638qrxT, 0);
        this.f8285JHa = typedArray.getDimensionPixelOffset(AbstractC3340a5.f12335CcoH, 0);
        if (typedArray.hasValue(AbstractC3340a5.f12702zPp)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(AbstractC3340a5.f12702zPp, -1);
            this.f8300xJ = dimensionPixelSize;
            m8387vI(this.f8281AZxh.m8676huTpC(dimensionPixelSize));
            this.f8296qGY = true;
        }
        this.f8294lgHUyS = typedArray.getDimensionPixelSize(AbstractC3340a5.f12618oJ, 0);
        this.f8297qdMbNW = AbstractC4557sa.m13502JHa(typedArray.getInt(AbstractC3340a5.f12694xbjHT, -1), PorterDuff.Mode.SRC_IN);
        this.f8282Dt = AbstractC2478N1.m9577mjFkc(this.f8295mjFkc.getContext(), typedArray, AbstractC3340a5.f12352EoC);
        this.f8283ETF = AbstractC2478N1.m9577mjFkc(this.f8295mjFkc.getContext(), typedArray, AbstractC3340a5.f12381Hk);
        this.f8289VA = AbstractC2478N1.m9577mjFkc(this.f8295mjFkc.getContext(), typedArray, AbstractC3340a5.f12428Mpf);
        this.f8293fehf = typedArray.getBoolean(AbstractC3340a5.f12380HX, false);
        this.f8292diqgf = typedArray.getDimensionPixelSize(AbstractC3340a5.f12419MC, 0);
        this.f8284IEE = typedArray.getBoolean(AbstractC3340a5.f12536bWIyu, true);
        int iM10224BAnRFn = AbstractC2876T9.m10224BAnRFn(this.f8295mjFkc);
        int paddingTop = this.f8295mjFkc.getPaddingTop();
        int iM10257VocHEe = AbstractC2876T9.m10257VocHEe(this.f8295mjFkc);
        int paddingBottom = this.f8295mjFkc.getPaddingBottom();
        if (typedArray.hasValue(AbstractC3340a5.f12374HExgdj)) {
            m8376diqgf();
        } else {
            m8358CqaNbM();
        }
        AbstractC2876T9.m10274gYa(this.f8295mjFkc, iM10224BAnRFn + this.f8299wA, paddingTop + this.f8286KLFTb, iM10257VocHEe + this.f8291ZfxDd, paddingBottom + this.f8285JHa);
    }

    /* renamed from: JHa */
    public C2542O1 m8364JHa() {
        return m8390xJ(false);
    }

    /* renamed from: KLFTb */
    public InterfaceC2350L6 m8365KLFTb() {
        LayerDrawable layerDrawable = this.f8288Pq;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f8288Pq.getNumberOfLayers() > 2 ? (InterfaceC2350L6) this.f8288Pq.getDrawable(2) : (InterfaceC2350L6) this.f8288Pq.getDrawable(1);
    }

    /* renamed from: KLMXS */
    public final void m8366KLMXS() {
        C2542O1 c2542o1M8364JHa = m8364JHa();
        C2542O1 c2542o1M8374YoKzxo = m8374YoKzxo();
        if (c2542o1M8364JHa != null) {
            c2542o1M8364JHa.m9826bbzow(this.f8294lgHUyS, this.f8283ETF);
            if (c2542o1M8374YoKzxo != null) {
                c2542o1M8374YoKzxo.m9823XV(this.f8294lgHUyS, this.f8290YoKzxo ? AbstractC2345L1.m9303ZfxDd(this.f8295mjFkc, AbstractC3800h4.f13945lgHUyS) : 0);
            }
        }
    }

    /* renamed from: MiMN */
    public PorterDuff.Mode m8367MiMN() {
        return this.f8297qdMbNW;
    }

    /* renamed from: Ne */
    public final void m8368Ne(int i, int i2) {
        int iM10224BAnRFn = AbstractC2876T9.m10224BAnRFn(this.f8295mjFkc);
        int paddingTop = this.f8295mjFkc.getPaddingTop();
        int iM10257VocHEe = AbstractC2876T9.m10257VocHEe(this.f8295mjFkc);
        int paddingBottom = this.f8295mjFkc.getPaddingBottom();
        int i3 = this.f8286KLFTb;
        int i4 = this.f8285JHa;
        this.f8285JHa = i2;
        this.f8286KLFTb = i;
        if (!this.f8298rkYL) {
            m8358CqaNbM();
        }
        AbstractC2876T9.m10274gYa(this.f8295mjFkc, iM10224BAnRFn, (paddingTop + i) - i3, iM10257VocHEe, (paddingBottom + i2) - i4);
    }

    /* renamed from: OjSQV */
    public void m8369OjSQV(boolean z) {
        this.f8284IEE = z;
    }

    /* renamed from: Pq */
    public void m8370Pq(int i) {
        if (m8364JHa() != null) {
            m8364JHa().setTint(i);
        }
    }

    /* renamed from: Ucbh */
    public void m8371Ucbh(int i) {
        if (this.f8296qGY && this.f8300xJ == i) {
            return;
        }
        this.f8300xJ = i;
        this.f8296qGY = true;
        m8387vI(this.f8281AZxh.m8676huTpC(i));
    }

    /* renamed from: VA */
    public ColorStateList m8372VA() {
        return this.f8282Dt;
    }

    /* renamed from: VocHEe */
    public void m8373VocHEe(boolean z) {
        this.f8290YoKzxo = z;
        m8366KLMXS();
    }

    /* renamed from: YoKzxo */
    public final C2542O1 m8374YoKzxo() {
        return m8390xJ(true);
    }

    /* renamed from: ZfxDd */
    public int m8375ZfxDd() {
        return this.f8286KLFTb;
    }

    /* renamed from: diqgf */
    public void m8376diqgf() {
        this.f8298rkYL = true;
        this.f8295mjFkc.setSupportBackgroundTintList(this.f8282Dt);
        this.f8295mjFkc.setSupportBackgroundTintMode(this.f8297qdMbNW);
    }

    /* renamed from: eyqo */
    public void m8377eyqo(boolean z) {
        this.f8293fehf = z;
    }

    /* renamed from: fehf */
    public boolean m8378fehf() {
        return this.f8284IEE;
    }

    /* renamed from: huTpC */
    public void m8379huTpC(int i) {
        m8368Ne(this.f8286KLFTb, i);
    }

    /* renamed from: lB */
    public void m8380lB(int i) {
        if (this.f8294lgHUyS != i) {
            this.f8294lgHUyS = i;
            m8366KLMXS();
        }
    }

    /* renamed from: lgHUyS */
    public ColorStateList m8381lgHUyS() {
        return this.f8289VA;
    }

    /* renamed from: mByQ */
    public void m8382mByQ(PorterDuff.Mode mode) {
        if (this.f8297qdMbNW != mode) {
            this.f8297qdMbNW = mode;
            if (m8364JHa() == null || this.f8297qdMbNW == null) {
                return;
            }
            AbstractC4332pCk.m13073Dt(m8364JHa(), this.f8297qdMbNW);
        }
    }

    /* renamed from: mjFkc */
    public final Drawable m8383mjFkc() {
        C2542O1 c2542o1 = new C2542O1(this.f8281AZxh);
        c2542o1.m9827cMLeY(this.f8295mjFkc.getContext());
        AbstractC4332pCk.m13081qdMbNW(c2542o1, this.f8282Dt);
        PorterDuff.Mode mode = this.f8297qdMbNW;
        if (mode != null) {
            AbstractC4332pCk.m13073Dt(c2542o1, mode);
        }
        c2542o1.m9826bbzow(this.f8294lgHUyS, this.f8283ETF);
        C2542O1 c2542o12 = new C2542O1(this.f8281AZxh);
        c2542o12.setTint(0);
        c2542o12.m9823XV(this.f8294lgHUyS, this.f8290YoKzxo ? AbstractC2345L1.m9303ZfxDd(this.f8295mjFkc, AbstractC3800h4.f13945lgHUyS) : 0);
        if (f8280eyqo) {
            C2542O1 c2542o13 = new C2542O1(this.f8281AZxh);
            this.f8287MiMN = c2542o13;
            AbstractC4332pCk.m13079lgHUyS(c2542o13, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(AbstractC1735C5.m7750mjFkc(this.f8289VA), m8392zvd(new LayerDrawable(new Drawable[]{c2542o12, c2542o1})), this.f8287MiMN);
            this.f8288Pq = rippleDrawable;
            return rippleDrawable;
        }
        C1668B5 c1668b5 = new C1668B5(this.f8281AZxh);
        this.f8287MiMN = c1668b5;
        AbstractC4332pCk.m13081qdMbNW(c1668b5, AbstractC1735C5.m7750mjFkc(this.f8289VA));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{c2542o12, c2542o1, this.f8287MiMN});
        this.f8288Pq = layerDrawable;
        return m8392zvd(layerDrawable);
    }

    /* renamed from: qGY */
    public boolean m8384qGY() {
        return this.f8293fehf;
    }

    /* renamed from: qdMbNW */
    public C2141I6 m8385qdMbNW() {
        return this.f8281AZxh;
    }

    /* renamed from: rkYL */
    public boolean m8386rkYL() {
        return this.f8298rkYL;
    }

    /* renamed from: vI */
    public void m8387vI(C2141I6 c2141i6) {
        this.f8281AZxh = c2141i6;
        m8391xrEuO(c2141i6);
    }

    /* renamed from: wA */
    public int m8388wA() {
        return this.f8285JHa;
    }

    /* renamed from: wJVbdd */
    public void m8389wJVbdd(ColorStateList colorStateList) {
        if (this.f8282Dt != colorStateList) {
            this.f8282Dt = colorStateList;
            if (m8364JHa() != null) {
                AbstractC4332pCk.m13081qdMbNW(m8364JHa(), this.f8282Dt);
            }
        }
    }

    /* renamed from: xJ */
    public final C2542O1 m8390xJ(boolean z) {
        LayerDrawable layerDrawable = this.f8288Pq;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return f8280eyqo ? (C2542O1) ((LayerDrawable) ((InsetDrawable) this.f8288Pq.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0) : (C2542O1) this.f8288Pq.getDrawable(!z ? 1 : 0);
    }

    /* renamed from: xrEuO */
    public final void m8391xrEuO(C2141I6 c2141i6) {
        if (f8279Ucbh && !this.f8298rkYL) {
            int iM10224BAnRFn = AbstractC2876T9.m10224BAnRFn(this.f8295mjFkc);
            int paddingTop = this.f8295mjFkc.getPaddingTop();
            int iM10257VocHEe = AbstractC2876T9.m10257VocHEe(this.f8295mjFkc);
            int paddingBottom = this.f8295mjFkc.getPaddingBottom();
            m8358CqaNbM();
            AbstractC2876T9.m10274gYa(this.f8295mjFkc, iM10224BAnRFn, paddingTop, iM10257VocHEe, paddingBottom);
            return;
        }
        if (m8364JHa() != null) {
            m8364JHa().setShapeAppearanceModel(c2141i6);
        }
        if (m8374YoKzxo() != null) {
            m8374YoKzxo().setShapeAppearanceModel(c2141i6);
        }
        if (m8365KLFTb() != null) {
            m8365KLFTb().setShapeAppearanceModel(c2141i6);
        }
    }

    /* renamed from: zvd */
    public final InsetDrawable m8392zvd(Drawable drawable) {
        return new InsetDrawable(drawable, this.f8299wA, this.f8286KLFTb, this.f8291ZfxDd, this.f8285JHa);
    }
}
