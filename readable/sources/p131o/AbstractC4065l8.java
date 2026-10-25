package p131o;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.view.ActionMode;
import android.widget.TextView;
import p131o.AbstractC2006G3;

/* renamed from: o.l8 */
/* loaded from: classes.dex */
public abstract class AbstractC4065l8 {

    /* renamed from: o.l8$AZxh */
    public static class AZxh {
        /* renamed from: AZxh */
        public static String[] m12673AZxh(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        /* renamed from: ZfxDd */
        public static void m12674ZfxDd(TextView textView, int i) {
            textView.setFirstBaselineToTopHeight(i);
        }

        /* renamed from: mjFkc */
        public static CharSequence m12675mjFkc(PrecomputedText precomputedText) {
            return precomputedText;
        }

        /* renamed from: wA */
        public static PrecomputedText.Params m12676wA(TextView textView) {
            return textView.getTextMetricsParams();
        }
    }

    /* renamed from: o.l8$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static ColorStateList m12677AZxh(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        /* renamed from: JHa */
        public static void m12678JHa(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        /* renamed from: KLFTb */
        public static void m12679KLFTb(TextView textView, int i) {
            textView.setBreakStrategy(i);
        }

        /* renamed from: ZfxDd */
        public static int m12680ZfxDd(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        /* renamed from: lgHUyS */
        public static void m12681lgHUyS(TextView textView, int i) {
            textView.setHyphenationFrequency(i);
        }

        /* renamed from: mjFkc */
        public static int m12682mjFkc(TextView textView) {
            return textView.getBreakStrategy();
        }

        /* renamed from: wA */
        public static PorterDuff.Mode m12683wA(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        /* renamed from: xJ */
        public static void m12684xJ(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }
    }

    /* renamed from: o.l8$wA */
    public static class wA implements ActionMode.Callback {
        /* renamed from: mjFkc */
        public abstract ActionMode.Callback m12685mjFkc();
    }

    /* renamed from: AZxh */
    public static int m12657AZxh(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    /* renamed from: Dt */
    public static void m12658Dt(TextView textView, int i) {
        AbstractC2280K3.m9121ZfxDd(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    /* renamed from: ETF */
    public static void m12659ETF(TextView textView, int i) {
        AbstractC2280K3.m9121ZfxDd(i);
        if (i != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i - r0, 1.0f);
        }
    }

    /* renamed from: JHa */
    public static void m12660JHa(TextView textView, ColorStateList colorStateList) {
        AbstractC2280K3.m9126xJ(textView);
        mjFkc.m12678JHa(textView, colorStateList);
    }

    /* renamed from: KLFTb */
    public static AbstractC2006G3.mjFkc m12661KLFTb(TextView textView) {
        return new AbstractC2006G3.mjFkc(AZxh.m12676wA(textView));
    }

    /* renamed from: MiMN */
    public static void m12662MiMN(TextView textView, int i) {
        textView.setTextAppearance(i);
    }

    /* renamed from: VA */
    public static void m12663VA(TextView textView, AbstractC2006G3 abstractC2006G3) {
        throw null;
    }

    /* renamed from: YoKzxo */
    public static void m12664YoKzxo(TextView textView, AbstractC2006G3.mjFkc mjfkc) {
        textView.setTextDirection(m12665ZfxDd(mjfkc.m8399ZfxDd()));
        textView.getPaint().set(mjfkc.m8398KLFTb());
        mjFkc.m12679KLFTb(textView, mjfkc.m8397AZxh());
        mjFkc.m12681lgHUyS(textView, mjfkc.m8402wA());
    }

    /* renamed from: ZfxDd */
    public static int m12665ZfxDd(TextDirectionHeuristic textDirectionHeuristic) {
        TextDirectionHeuristic textDirectionHeuristic2;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        if (textDirectionHeuristic == textDirectionHeuristic3 || textDirectionHeuristic == (textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return 6;
        }
        return textDirectionHeuristic == textDirectionHeuristic3 ? 7 : 1;
    }

    /* renamed from: lgHUyS */
    public static void m12666lgHUyS(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    /* renamed from: mjFkc */
    public static Drawable[] m12667mjFkc(TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }

    /* renamed from: qGY */
    public static ActionMode.Callback m12668qGY(TextView textView, ActionMode.Callback callback) {
        return callback;
    }

    /* renamed from: qdMbNW */
    public static void m12669qdMbNW(TextView textView, int i) {
        AbstractC2280K3.m9121ZfxDd(i);
        AZxh.m12674ZfxDd(textView, i);
    }

    /* renamed from: rkYL */
    public static ActionMode.Callback m12670rkYL(ActionMode.Callback callback) {
        return callback instanceof wA ? ((wA) callback).m12685mjFkc() : callback;
    }

    /* renamed from: wA */
    public static int m12671wA(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    /* renamed from: xJ */
    public static void m12672xJ(TextView textView, PorterDuff.Mode mode) {
        AbstractC2280K3.m9126xJ(textView);
        mjFkc.m12684xJ(textView, mode);
    }
}
