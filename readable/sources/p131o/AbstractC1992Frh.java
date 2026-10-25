package p131o;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* renamed from: o.Frh */
/* loaded from: classes.dex */
public abstract class AbstractC1992Frh extends ReplacementSpan {

    /* renamed from: AZxh */
    public final C4742vL f8268AZxh;

    /* renamed from: mjFkc */
    public final Paint.FontMetricsInt f8271mjFkc = new Paint.FontMetricsInt();

    /* renamed from: wA */
    public short f8272wA = -1;

    /* renamed from: ZfxDd */
    public short f8270ZfxDd = -1;

    /* renamed from: KLFTb */
    public float f8269KLFTb = 1.0f;

    public AbstractC1992Frh(C4742vL c4742vL) {
        AbstractC2280K3.m9122lgHUyS(c4742vL, "metadata cannot be null");
        this.f8268AZxh = c4742vL;
    }

    /* renamed from: AZxh */
    public final int m8334AZxh() {
        return this.f8272wA;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f8271mjFkc);
        Paint.FontMetricsInt fontMetricsInt2 = this.f8271mjFkc;
        this.f8269KLFTb = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f8268AZxh.m13773KLFTb();
        this.f8270ZfxDd = (short) (this.f8268AZxh.m13773KLFTb() * this.f8269KLFTb);
        short sM13777qdMbNW = (short) (this.f8268AZxh.m13777qdMbNW() * this.f8269KLFTb);
        this.f8272wA = sM13777qdMbNW;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f8271mjFkc;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sM13777qdMbNW;
    }

    /* renamed from: mjFkc */
    public final C4742vL m8335mjFkc() {
        return this.f8268AZxh;
    }
}
