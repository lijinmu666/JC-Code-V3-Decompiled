package p131o;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;

/* renamed from: o.G3 */
/* loaded from: classes.dex */
public abstract class AbstractC2006G3 implements Spannable {

    /* renamed from: o.G3$mjFkc */
    public static final class mjFkc {

        /* renamed from: AZxh */
        public final TextDirectionHeuristic f8303AZxh;

        /* renamed from: KLFTb */
        public final PrecomputedText.Params f8304KLFTb;

        /* renamed from: ZfxDd */
        public final int f8305ZfxDd;

        /* renamed from: mjFkc */
        public final TextPaint f8306mjFkc;

        /* renamed from: wA */
        public final int f8307wA;

        public mjFkc(PrecomputedText.Params params) {
            this.f8306mjFkc = params.getTextPaint();
            this.f8303AZxh = params.getTextDirection();
            this.f8307wA = params.getBreakStrategy();
            this.f8305ZfxDd = params.getHyphenationFrequency();
            this.f8304KLFTb = params;
        }

        /* renamed from: AZxh */
        public int m8397AZxh() {
            return this.f8307wA;
        }

        /* renamed from: KLFTb */
        public TextPaint m8398KLFTb() {
            return this.f8306mjFkc;
        }

        /* renamed from: ZfxDd */
        public TextDirectionHeuristic m8399ZfxDd() {
            return this.f8303AZxh;
        }

        /* renamed from: equals */
        public boolean m8400equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof mjFkc)) {
                return false;
            }
            mjFkc mjfkc = (mjFkc) obj;
            return m8401mjFkc(mjfkc) && this.f8303AZxh == mjfkc.m8399ZfxDd();
        }

        public int hashCode() {
            return AbstractC3003V2.m10657AZxh(Float.valueOf(this.f8306mjFkc.getTextSize()), Float.valueOf(this.f8306mjFkc.getTextScaleX()), Float.valueOf(this.f8306mjFkc.getTextSkewX()), Float.valueOf(this.f8306mjFkc.getLetterSpacing()), Integer.valueOf(this.f8306mjFkc.getFlags()), this.f8306mjFkc.getTextLocales(), this.f8306mjFkc.getTypeface(), Boolean.valueOf(this.f8306mjFkc.isElegantTextHeight()), this.f8303AZxh, Integer.valueOf(this.f8307wA), Integer.valueOf(this.f8305ZfxDd));
        }

        /* renamed from: mjFkc */
        public boolean m8401mjFkc(mjFkc mjfkc) {
            if (this.f8307wA == mjfkc.m8397AZxh() && this.f8305ZfxDd == mjfkc.m8402wA() && this.f8306mjFkc.getTextSize() == mjfkc.m8398KLFTb().getTextSize() && this.f8306mjFkc.getTextScaleX() == mjfkc.m8398KLFTb().getTextScaleX() && this.f8306mjFkc.getTextSkewX() == mjfkc.m8398KLFTb().getTextSkewX() && this.f8306mjFkc.getLetterSpacing() == mjfkc.m8398KLFTb().getLetterSpacing() && TextUtils.equals(this.f8306mjFkc.getFontFeatureSettings(), mjfkc.m8398KLFTb().getFontFeatureSettings()) && this.f8306mjFkc.getFlags() == mjfkc.m8398KLFTb().getFlags() && this.f8306mjFkc.getTextLocales().equals(mjfkc.m8398KLFTb().getTextLocales())) {
                return this.f8306mjFkc.getTypeface() == null ? mjfkc.m8398KLFTb().getTypeface() == null : this.f8306mjFkc.getTypeface().equals(mjfkc.m8398KLFTb().getTypeface());
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f8306mjFkc.getTextSize());
            sb.append(", textScaleX=" + this.f8306mjFkc.getTextScaleX());
            sb.append(", textSkewX=" + this.f8306mjFkc.getTextSkewX());
            sb.append(", letterSpacing=" + this.f8306mjFkc.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f8306mjFkc.isElegantTextHeight());
            sb.append(", textLocale=" + this.f8306mjFkc.getTextLocales());
            sb.append(", typeface=" + this.f8306mjFkc.getTypeface());
            sb.append(", variationSettings=" + this.f8306mjFkc.getFontVariationSettings());
            sb.append(", textDir=" + this.f8303AZxh);
            sb.append(", breakStrategy=" + this.f8307wA);
            sb.append(", hyphenationFrequency=" + this.f8305ZfxDd);
            sb.append("}");
            return sb.toString();
        }

        /* renamed from: wA */
        public int m8402wA() {
            return this.f8305ZfxDd;
        }
    }
}
