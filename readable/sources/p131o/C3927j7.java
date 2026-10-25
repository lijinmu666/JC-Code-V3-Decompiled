package p131o;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import org.conscrypt.BuildConfig;

/* renamed from: o.j7 */
/* loaded from: classes.dex */
public final class C3927j7 {

    /* renamed from: YoKzxo */
    public static final int f14255YoKzxo = 1;

    /* renamed from: AZxh */
    public final TextPaint f14256AZxh;

    /* renamed from: KLFTb */
    public int f14260KLFTb;

    /* renamed from: VA */
    public boolean f14262VA;

    /* renamed from: mjFkc */
    public CharSequence f14265mjFkc;

    /* renamed from: wA */
    public final int f14267wA;

    /* renamed from: ZfxDd */
    public int f14263ZfxDd = 0;

    /* renamed from: JHa */
    public Layout.Alignment f14259JHa = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: xJ */
    public int f14268xJ = Integer.MAX_VALUE;

    /* renamed from: lgHUyS */
    public float f14264lgHUyS = 0.0f;

    /* renamed from: qdMbNW */
    public float f14266qdMbNW = 1.0f;

    /* renamed from: Dt */
    public int f14257Dt = f14255YoKzxo;

    /* renamed from: ETF */
    public boolean f14258ETF = true;

    /* renamed from: MiMN */
    public TextUtils.TruncateAt f14261MiMN = null;

    /* renamed from: o.j7$mjFkc */
    public static class mjFkc extends Exception {
    }

    public C3927j7(CharSequence charSequence, TextPaint textPaint, int i) {
        this.f14265mjFkc = charSequence;
        this.f14256AZxh = textPaint;
        this.f14267wA = i;
        this.f14260KLFTb = charSequence.length();
    }

    /* renamed from: AZxh */
    public static C3927j7 m12383AZxh(CharSequence charSequence, TextPaint textPaint, int i) {
        return new C3927j7(charSequence, textPaint, i);
    }

    /* renamed from: Dt */
    public C3927j7 m12384Dt(InterfaceC3998k7 interfaceC3998k7) {
        return this;
    }

    /* renamed from: JHa */
    public C3927j7 m12385JHa(boolean z) {
        this.f14258ETF = z;
        return this;
    }

    /* renamed from: KLFTb */
    public C3927j7 m12386KLFTb(int i) {
        this.f14257Dt = i;
        return this;
    }

    /* renamed from: ZfxDd */
    public C3927j7 m12387ZfxDd(TextUtils.TruncateAt truncateAt) {
        this.f14261MiMN = truncateAt;
        return this;
    }

    /* renamed from: lgHUyS */
    public C3927j7 m12388lgHUyS(float f, float f2) {
        this.f14264lgHUyS = f;
        this.f14266qdMbNW = f2;
        return this;
    }

    /* renamed from: mjFkc */
    public StaticLayout m12389mjFkc() {
        if (this.f14265mjFkc == null) {
            this.f14265mjFkc = BuildConfig.f24315FLAVOR;
        }
        int iMax = Math.max(0, this.f14267wA);
        CharSequence charSequenceEllipsize = this.f14265mjFkc;
        if (this.f14268xJ == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f14256AZxh, iMax, this.f14261MiMN);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f14260KLFTb);
        this.f14260KLFTb = iMin;
        if (this.f14262VA && this.f14268xJ == 1) {
            this.f14259JHa = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.f14263ZfxDd, iMin, this.f14256AZxh, iMax);
        builderObtain.setAlignment(this.f14259JHa);
        builderObtain.setIncludePad(this.f14258ETF);
        builderObtain.setTextDirection(this.f14262VA ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f14261MiMN;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f14268xJ);
        float f = this.f14264lgHUyS;
        if (f != 0.0f || this.f14266qdMbNW != 1.0f) {
            builderObtain.setLineSpacing(f, this.f14266qdMbNW);
        }
        if (this.f14268xJ > 1) {
            builderObtain.setHyphenationFrequency(this.f14257Dt);
        }
        return builderObtain.build();
    }

    /* renamed from: qdMbNW */
    public C3927j7 m12390qdMbNW(int i) {
        this.f14268xJ = i;
        return this;
    }

    /* renamed from: wA */
    public C3927j7 m12391wA(Layout.Alignment alignment) {
        this.f14259JHa = alignment;
        return this;
    }

    /* renamed from: xJ */
    public C3927j7 m12392xJ(boolean z) {
        this.f14262VA = z;
        return this;
    }
}
