package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Locale;
import p131o.AbstractC4592t5;

/* renamed from: o.IVlxe */
/* loaded from: classes.dex */
public class C2171IVlxe {

    /* renamed from: AZxh */
    public C4929y8 f8741AZxh;

    /* renamed from: Dt */
    public int f8742Dt = 0;

    /* renamed from: ETF */
    public int f8743ETF = -1;

    /* renamed from: JHa */
    public C4929y8 f8744JHa;

    /* renamed from: KLFTb */
    public C4929y8 f8745KLFTb;

    /* renamed from: MiMN */
    public boolean f8746MiMN;

    /* renamed from: VA */
    public Typeface f8747VA;

    /* renamed from: ZfxDd */
    public C4929y8 f8748ZfxDd;

    /* renamed from: lgHUyS */
    public C4929y8 f8749lgHUyS;

    /* renamed from: mjFkc */
    public final TextView f8750mjFkc;

    /* renamed from: qdMbNW */
    public final C2850SmIWf f8751qdMbNW;

    /* renamed from: wA */
    public C4929y8 f8752wA;

    /* renamed from: xJ */
    public C4929y8 f8753xJ;

    /* renamed from: o.IVlxe$AZxh */
    public class AZxh implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ Typeface f8754AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ TextView f8756mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ int f8757wA;

        public AZxh(TextView textView, Typeface typeface, int i) {
            this.f8756mjFkc = textView;
            this.f8754AZxh = typeface;
            this.f8757wA = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8756mjFkc.setTypeface(this.f8754AZxh, this.f8757wA);
        }
    }

    /* renamed from: o.IVlxe$JHa */
    public static class JHa {
        /* renamed from: mjFkc */
        public static Typeface m8777mjFkc(Typeface typeface, int i, boolean z) {
            return Typeface.create(typeface, i, z);
        }
    }

    /* renamed from: o.IVlxe$KLFTb */
    public static class KLFTb {
        /* renamed from: AZxh */
        public static void m8778AZxh(TextView textView, int i, int i2, int i3, int i4) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }

        /* renamed from: ZfxDd */
        public static boolean m8779ZfxDd(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }

        /* renamed from: mjFkc */
        public static int m8780mjFkc(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        /* renamed from: wA */
        public static void m8781wA(TextView textView, int[] iArr, int i) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }
    }

    /* renamed from: o.IVlxe$ZfxDd */
    public static class ZfxDd {
        /* renamed from: AZxh */
        public static void m8782AZxh(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }

        /* renamed from: mjFkc */
        public static LocaleList m8783mjFkc(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* renamed from: o.IVlxe$mjFkc */
    public class mjFkc extends AbstractC4592t5.KLFTb {

        /* renamed from: AZxh */
        public final /* synthetic */ int f8758AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ int f8760mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ WeakReference f8761wA;

        public mjFkc(int i, int i2, WeakReference weakReference) {
            this.f8760mjFkc = i;
            this.f8758AZxh = i2;
            this.f8761wA = weakReference;
        }

        @Override // p131o.AbstractC4592t5.KLFTb
        /* renamed from: lgHUyS */
        public void m13593JHa(int i) {
        }

        @Override // p131o.AbstractC4592t5.KLFTb
        /* renamed from: qdMbNW */
        public void m13596xJ(Typeface typeface) {
            int i = this.f8760mjFkc;
            if (i != -1) {
                typeface = JHa.m8777mjFkc(typeface, i, (this.f8758AZxh & 2) != 0);
            }
            C2171IVlxe.this.m8763YoKzxo(this.f8761wA, typeface);
        }
    }

    /* renamed from: o.IVlxe$wA */
    public static class wA {
        /* renamed from: AZxh */
        public static void m8786AZxh(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        /* renamed from: mjFkc */
        public static Drawable[] m8787mjFkc(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        /* renamed from: wA */
        public static void m8788wA(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    public C2171IVlxe(TextView textView) {
        this.f8750mjFkc = textView;
        this.f8751qdMbNW = new C2850SmIWf(textView);
    }

    /* renamed from: ZfxDd */
    public static C4929y8 m8748ZfxDd(Context context, C3442bbzow c3442bbzow, int i) {
        ColorStateList colorStateListM11537KLFTb = c3442bbzow.m11537KLFTb(context, i);
        if (colorStateListM11537KLFTb == null) {
            return null;
        }
        C4929y8 c4929y8 = new C4929y8();
        c4929y8.f17479ZfxDd = true;
        c4929y8.f17480mjFkc = colorStateListM11537KLFTb;
        return c4929y8;
    }

    /* renamed from: AZxh */
    public void m8749AZxh() {
        if (this.f8741AZxh != null || this.f8752wA != null || this.f8748ZfxDd != null || this.f8745KLFTb != null) {
            Drawable[] compoundDrawables = this.f8750mjFkc.getCompoundDrawables();
            m8770mjFkc(compoundDrawables[0], this.f8741AZxh);
            m8770mjFkc(compoundDrawables[1], this.f8752wA);
            m8770mjFkc(compoundDrawables[2], this.f8748ZfxDd);
            m8770mjFkc(compoundDrawables[3], this.f8745KLFTb);
        }
        if (this.f8744JHa == null && this.f8753xJ == null) {
            return;
        }
        Drawable[] drawableArrM8787mjFkc = wA.m8787mjFkc(this.f8750mjFkc);
        m8770mjFkc(drawableArrM8787mjFkc[0], this.f8744JHa);
        m8770mjFkc(drawableArrM8787mjFkc[2], this.f8753xJ);
    }

    /* renamed from: BAnRFn */
    public final void m8750BAnRFn(int i, float f) {
        this.f8751qdMbNW.m10177diqgf(i, f);
    }

    /* renamed from: Dt */
    public ColorStateList m8751Dt() {
        C4929y8 c4929y8 = this.f8749lgHUyS;
        if (c4929y8 != null) {
            return c4929y8.f17480mjFkc;
        }
        return null;
    }

    /* renamed from: ETF */
    public PorterDuff.Mode m8752ETF() {
        C4929y8 c4929y8 = this.f8749lgHUyS;
        if (c4929y8 != null) {
            return c4929y8.f17478AZxh;
        }
        return null;
    }

    /* renamed from: Gd */
    public void m8753Gd(PorterDuff.Mode mode) {
        if (this.f8749lgHUyS == null) {
            this.f8749lgHUyS = new C4929y8();
        }
        C4929y8 c4929y8 = this.f8749lgHUyS;
        c4929y8.f17478AZxh = mode;
        c4929y8.f17481wA = mode != null;
        m8774vI();
    }

    /* renamed from: HGpJ */
    public final void m8754HGpJ(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] drawableArrM8787mjFkc = wA.m8787mjFkc(this.f8750mjFkc);
            TextView textView = this.f8750mjFkc;
            if (drawable5 == null) {
                drawable5 = drawableArrM8787mjFkc[0];
            }
            if (drawable2 == null) {
                drawable2 = drawableArrM8787mjFkc[1];
            }
            if (drawable6 == null) {
                drawable6 = drawableArrM8787mjFkc[2];
            }
            if (drawable4 == null) {
                drawable4 = drawableArrM8787mjFkc[3];
            }
            wA.m8786AZxh(textView, drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] drawableArrM8787mjFkc2 = wA.m8787mjFkc(this.f8750mjFkc);
        Drawable drawable7 = drawableArrM8787mjFkc2[0];
        if (drawable7 != null || drawableArrM8787mjFkc2[2] != null) {
            TextView textView2 = this.f8750mjFkc;
            if (drawable2 == null) {
                drawable2 = drawableArrM8787mjFkc2[1];
            }
            Drawable drawable8 = drawableArrM8787mjFkc2[2];
            if (drawable4 == null) {
                drawable4 = drawableArrM8787mjFkc2[3];
            }
            wA.m8786AZxh(textView2, drawable7, drawable2, drawable8, drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f8750mjFkc.getCompoundDrawables();
        TextView textView3 = this.f8750mjFkc;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    /* renamed from: IEE */
    public void m8755IEE(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        AbstractC3260YuaD.m11140KLFTb(editorInfo, textView.getText());
    }

    /* renamed from: JHa */
    public int m8756JHa() {
        return this.f8751qdMbNW.m10188xJ();
    }

    /* renamed from: KLFTb */
    public int m8757KLFTb() {
        return this.f8751qdMbNW.m10170JHa();
    }

    /* renamed from: MiMN */
    public void m8758MiMN(AttributeSet attributeSet, int i) {
        boolean zM7588mjFkc;
        boolean z;
        String strM7583YoKzxo;
        String strM7583YoKzxo2;
        Context context = this.f8750mjFkc.getContext();
        C3442bbzow c3442bbzowM11532AZxh = C3442bbzow.m11532AZxh();
        C1606A8 c1606a8M7575diqgf = C1606A8.m7575diqgf(context, attributeSet, AbstractC3407b5.f13045zvd, i, 0);
        TextView textView = this.f8750mjFkc;
        AbstractC2876T9.m10277jm(textView, textView.getContext(), AbstractC3407b5.f13045zvd, attributeSet, c1606a8M7575diqgf.m7589qGY(), i, 0);
        int iM7581MiMN = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12958cMLeY, -1);
        if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f12903NPj)) {
            this.f8741AZxh = m8748ZfxDd(context, c3442bbzowM11532AZxh, c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12903NPj, 0));
        }
        if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f13007rWxwaT)) {
            this.f8752wA = m8748ZfxDd(context, c3442bbzowM11532AZxh, c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f13007rWxwaT, 0));
        }
        if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f13026vadzgd)) {
            this.f8748ZfxDd = m8748ZfxDd(context, c3442bbzowM11532AZxh, c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f13026vadzgd, 0));
        }
        if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f12933Vnb)) {
            this.f8745KLFTb = m8748ZfxDd(context, c3442bbzowM11532AZxh, c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12933Vnb, 0));
        }
        if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f12996oCFDzJ)) {
            this.f8744JHa = m8748ZfxDd(context, c3442bbzowM11532AZxh, c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12996oCFDzJ, 0));
        }
        if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f12954aqHPIZ)) {
            this.f8753xJ = m8748ZfxDd(context, c3442bbzowM11532AZxh, c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12954aqHPIZ, 0));
        }
        c1606a8M7575diqgf.m7585eyqo();
        boolean z2 = this.f8750mjFkc.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z3 = true;
        if (iM7581MiMN != -1) {
            C1606A8 c1606a8M7573IEE = C1606A8.m7573IEE(context, iM7581MiMN, AbstractC3407b5.f12892KSf);
            if (z2 || !c1606a8M7573IEE.m7586fehf(AbstractC3407b5.f12897MC)) {
                zM7588mjFkc = false;
                z = false;
            } else {
                zM7588mjFkc = c1606a8M7573IEE.m7588mjFkc(AbstractC3407b5.f12897MC, false);
                z = true;
            }
            m8768lB(context, c1606a8M7573IEE);
            strM7583YoKzxo = c1606a8M7573IEE.m7586fehf(AbstractC3407b5.f12952aDq) ? c1606a8M7573IEE.m7583YoKzxo(AbstractC3407b5.f12952aDq) : null;
            strM7583YoKzxo2 = c1606a8M7573IEE.m7586fehf(AbstractC3407b5.f13044zPp) ? c1606a8M7573IEE.m7583YoKzxo(AbstractC3407b5.f13044zPp) : null;
            c1606a8M7573IEE.m7585eyqo();
        } else {
            zM7588mjFkc = false;
            z = false;
            strM7583YoKzxo = null;
            strM7583YoKzxo2 = null;
        }
        C1606A8 c1606a8M7575diqgf2 = C1606A8.m7575diqgf(context, attributeSet, AbstractC3407b5.f12892KSf, i, 0);
        if (z2 || !c1606a8M7575diqgf2.m7586fehf(AbstractC3407b5.f12897MC)) {
            z3 = z;
        } else {
            zM7588mjFkc = c1606a8M7575diqgf2.m7588mjFkc(AbstractC3407b5.f12897MC, false);
        }
        if (c1606a8M7575diqgf2.m7586fehf(AbstractC3407b5.f12952aDq)) {
            strM7583YoKzxo = c1606a8M7575diqgf2.m7583YoKzxo(AbstractC3407b5.f12952aDq);
        }
        if (c1606a8M7575diqgf2.m7586fehf(AbstractC3407b5.f13044zPp)) {
            strM7583YoKzxo2 = c1606a8M7575diqgf2.m7583YoKzxo(AbstractC3407b5.f13044zPp);
        }
        if (c1606a8M7575diqgf2.m7586fehf(AbstractC3407b5.f12935Vptz) && c1606a8M7575diqgf2.m7579JHa(AbstractC3407b5.f12935Vptz, -1) == 0) {
            this.f8750mjFkc.setTextSize(0, 0.0f);
        }
        m8768lB(context, c1606a8M7575diqgf2);
        c1606a8M7575diqgf2.m7585eyqo();
        if (!z2 && z3) {
            m8759Pq(zM7588mjFkc);
        }
        Typeface typeface = this.f8747VA;
        if (typeface != null) {
            if (this.f8743ETF == -1) {
                this.f8750mjFkc.setTypeface(typeface, this.f8742Dt);
            } else {
                this.f8750mjFkc.setTypeface(typeface);
            }
        }
        if (strM7583YoKzxo2 != null) {
            KLFTb.m8779ZfxDd(this.f8750mjFkc, strM7583YoKzxo2);
        }
        if (strM7583YoKzxo != null) {
            ZfxDd.m8782AZxh(this.f8750mjFkc, ZfxDd.m8783mjFkc(strM7583YoKzxo));
        }
        this.f8751qdMbNW.m10185rkYL(attributeSet, i);
        if (AbstractC4689ua.f16857AZxh && this.f8751qdMbNW.m10166Dt() != 0) {
            int[] iArrM10184qdMbNW = this.f8751qdMbNW.m10184qdMbNW();
            if (iArrM10184qdMbNW.length > 0) {
                if (KLFTb.m8780mjFkc(this.f8750mjFkc) != -1.0f) {
                    KLFTb.m8778AZxh(this.f8750mjFkc, this.f8751qdMbNW.m10188xJ(), this.f8751qdMbNW.m10170JHa(), this.f8751qdMbNW.m10181lgHUyS(), 0);
                } else {
                    KLFTb.m8781wA(this.f8750mjFkc, iArrM10184qdMbNW, 0);
                }
            }
        }
        C1606A8 c1606a8M7574Pq = C1606A8.m7574Pq(context, attributeSet, AbstractC3407b5.f12938WrLQs);
        int iM7581MiMN2 = c1606a8M7574Pq.m7581MiMN(AbstractC3407b5.f12937WGXroI, -1);
        Drawable drawableM11538wA = iM7581MiMN2 != -1 ? c3442bbzowM11532AZxh.m11538wA(context, iM7581MiMN2) : null;
        int iM7581MiMN3 = c1606a8M7574Pq.m7581MiMN(AbstractC3407b5.f12930Vdz, -1);
        Drawable drawableM11538wA2 = iM7581MiMN3 != -1 ? c3442bbzowM11532AZxh.m11538wA(context, iM7581MiMN3) : null;
        int iM7581MiMN4 = c1606a8M7574Pq.m7581MiMN(AbstractC3407b5.f12942XV, -1);
        Drawable drawableM11538wA3 = iM7581MiMN4 != -1 ? c3442bbzowM11532AZxh.m11538wA(context, iM7581MiMN4) : null;
        int iM7581MiMN5 = c1606a8M7574Pq.m7581MiMN(AbstractC3407b5.f12887JrJO, -1);
        Drawable drawableM11538wA4 = iM7581MiMN5 != -1 ? c3442bbzowM11532AZxh.m11538wA(context, iM7581MiMN5) : null;
        int iM7581MiMN6 = c1606a8M7574Pq.m7581MiMN(AbstractC3407b5.f12956bbzow, -1);
        Drawable drawableM11538wA5 = iM7581MiMN6 != -1 ? c3442bbzowM11532AZxh.m11538wA(context, iM7581MiMN6) : null;
        int iM7581MiMN7 = c1606a8M7574Pq.m7581MiMN(AbstractC3407b5.f12995nxI, -1);
        m8754HGpJ(drawableM11538wA, drawableM11538wA2, drawableM11538wA3, drawableM11538wA4, drawableM11538wA5, iM7581MiMN7 != -1 ? c3442bbzowM11532AZxh.m11538wA(context, iM7581MiMN7) : null);
        if (c1606a8M7574Pq.m7586fehf(AbstractC3407b5.f12920SwgkN)) {
            AbstractC4065l8.m12660JHa(this.f8750mjFkc, c1606a8M7574Pq.m7592wA(AbstractC3407b5.f12920SwgkN));
        }
        if (c1606a8M7574Pq.m7586fehf(AbstractC3407b5.f12880JBhc)) {
            AbstractC4065l8.m12672xJ(this.f8750mjFkc, AbstractC3397awnh.m11433ZfxDd(c1606a8M7574Pq.m7577Dt(AbstractC3407b5.f12880JBhc, -1), null));
        }
        int iM7579JHa = c1606a8M7574Pq.m7579JHa(AbstractC3407b5.f12847ANMGZc, -1);
        int iM7579JHa2 = c1606a8M7574Pq.m7579JHa(AbstractC3407b5.f12953alEkx, -1);
        int iM7579JHa3 = c1606a8M7574Pq.m7579JHa(AbstractC3407b5.f12963dm, -1);
        c1606a8M7574Pq.m7585eyqo();
        if (iM7579JHa != -1) {
            AbstractC4065l8.m12669qdMbNW(this.f8750mjFkc, iM7579JHa);
        }
        if (iM7579JHa2 != -1) {
            AbstractC4065l8.m12658Dt(this.f8750mjFkc, iM7579JHa2);
        }
        if (iM7579JHa3 != -1) {
            AbstractC4065l8.m12659ETF(this.f8750mjFkc, iM7579JHa3);
        }
    }

    /* renamed from: Pq */
    public void m8759Pq(boolean z) {
        this.f8750mjFkc.setAllCaps(z);
    }

    /* renamed from: Ucbh */
    public void m8760Ucbh(int i) {
        this.f8751qdMbNW.m10169IEE(i);
    }

    /* renamed from: VA */
    public boolean m8761VA() {
        return this.f8751qdMbNW.m10175YoKzxo();
    }

    /* renamed from: VocHEe */
    public void m8762VocHEe(int i, float f) {
        if (AbstractC4689ua.f16857AZxh || m8761VA()) {
            return;
        }
        m8750BAnRFn(i, f);
    }

    /* renamed from: YoKzxo */
    public void m8763YoKzxo(WeakReference weakReference, Typeface typeface) {
        if (this.f8746MiMN) {
            this.f8747VA = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                if (AbstractC2876T9.m10268cMLeY(textView)) {
                    textView.post(new AZxh(textView, typeface, this.f8742Dt));
                } else {
                    textView.setTypeface(typeface, this.f8742Dt);
                }
            }
        }
    }

    /* renamed from: diqgf */
    public void m8764diqgf(int i, int i2, int i3, int i4) {
        this.f8751qdMbNW.m10183qGY(i, i2, i3, i4);
    }

    /* renamed from: eyqo */
    public void m8765eyqo(int[] iArr, int i) {
        this.f8751qdMbNW.m10179fehf(iArr, i);
    }

    /* renamed from: fehf */
    public void m8766fehf(Context context, int i) {
        String strM7583YoKzxo;
        C1606A8 c1606a8M7573IEE = C1606A8.m7573IEE(context, i, AbstractC3407b5.f12892KSf);
        if (c1606a8M7573IEE.m7586fehf(AbstractC3407b5.f12897MC)) {
            m8759Pq(c1606a8M7573IEE.m7588mjFkc(AbstractC3407b5.f12897MC, false));
        }
        if (c1606a8M7573IEE.m7586fehf(AbstractC3407b5.f12935Vptz) && c1606a8M7573IEE.m7579JHa(AbstractC3407b5.f12935Vptz, -1) == 0) {
            this.f8750mjFkc.setTextSize(0, 0.0f);
        }
        m8768lB(context, c1606a8M7573IEE);
        if (c1606a8M7573IEE.m7586fehf(AbstractC3407b5.f13044zPp) && (strM7583YoKzxo = c1606a8M7573IEE.m7583YoKzxo(AbstractC3407b5.f13044zPp)) != null) {
            KLFTb.m8779ZfxDd(this.f8750mjFkc, strM7583YoKzxo);
        }
        c1606a8M7573IEE.m7585eyqo();
        Typeface typeface = this.f8747VA;
        if (typeface != null) {
            this.f8750mjFkc.setTypeface(typeface, this.f8742Dt);
        }
    }

    /* renamed from: huTpC */
    public void m8767huTpC(ColorStateList colorStateList) {
        if (this.f8749lgHUyS == null) {
            this.f8749lgHUyS = new C4929y8();
        }
        C4929y8 c4929y8 = this.f8749lgHUyS;
        c4929y8.f17480mjFkc = colorStateList;
        c4929y8.f17479ZfxDd = colorStateList != null;
        m8774vI();
    }

    /* renamed from: lB */
    public final void m8768lB(Context context, C1606A8 c1606a8) {
        String strM7583YoKzxo;
        this.f8742Dt = c1606a8.m7577Dt(AbstractC3407b5.f12855CcoH, this.f8742Dt);
        int iM7577Dt = c1606a8.m7577Dt(AbstractC3407b5.f12863EoC, -1);
        this.f8743ETF = iM7577Dt;
        if (iM7577Dt != -1) {
            this.f8742Dt &= 2;
        }
        if (!c1606a8.m7586fehf(AbstractC3407b5.f12872HX) && !c1606a8.m7586fehf(AbstractC3407b5.f13037xbjHT)) {
            if (c1606a8.m7586fehf(AbstractC3407b5.f13005qrxT)) {
                this.f8746MiMN = false;
                int iM7577Dt2 = c1606a8.m7577Dt(AbstractC3407b5.f13005qrxT, 1);
                if (iM7577Dt2 == 1) {
                    this.f8747VA = Typeface.SANS_SERIF;
                    return;
                } else if (iM7577Dt2 == 2) {
                    this.f8747VA = Typeface.SERIF;
                    return;
                } else {
                    if (iM7577Dt2 != 3) {
                        return;
                    }
                    this.f8747VA = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f8747VA = null;
        int i = c1606a8.m7586fehf(AbstractC3407b5.f13037xbjHT) ? AbstractC3407b5.f13037xbjHT : AbstractC3407b5.f12872HX;
        int i2 = this.f8743ETF;
        int i3 = this.f8742Dt;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceM7590qdMbNW = c1606a8.m7590qdMbNW(i, this.f8742Dt, new mjFkc(i2, i3, new WeakReference(this.f8750mjFkc)));
                if (typefaceM7590qdMbNW != null) {
                    if (this.f8743ETF != -1) {
                        this.f8747VA = JHa.m8777mjFkc(Typeface.create(typefaceM7590qdMbNW, 0), this.f8743ETF, (this.f8742Dt & 2) != 0);
                    } else {
                        this.f8747VA = typefaceM7590qdMbNW;
                    }
                }
                this.f8746MiMN = this.f8747VA == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f8747VA != null || (strM7583YoKzxo = c1606a8.m7583YoKzxo(i)) == null) {
            return;
        }
        if (this.f8743ETF != -1) {
            this.f8747VA = JHa.m8777mjFkc(Typeface.create(strM7583YoKzxo, 0), this.f8743ETF, (this.f8742Dt & 2) != 0);
        } else {
            this.f8747VA = Typeface.create(strM7583YoKzxo, this.f8742Dt);
        }
    }

    /* renamed from: lgHUyS */
    public int[] m8769lgHUyS() {
        return this.f8751qdMbNW.m10184qdMbNW();
    }

    /* renamed from: mjFkc */
    public final void m8770mjFkc(Drawable drawable, C4929y8 c4929y8) {
        if (drawable == null || c4929y8 == null) {
            return;
        }
        C3442bbzow.m11536xJ(drawable, c4929y8, this.f8750mjFkc.getDrawableState());
    }

    /* renamed from: qGY */
    public void m8771qGY() {
        m8749AZxh();
    }

    /* renamed from: qdMbNW */
    public int m8772qdMbNW() {
        return this.f8751qdMbNW.m10166Dt();
    }

    /* renamed from: rkYL */
    public void m8773rkYL(boolean z, int i, int i2, int i3, int i4) {
        if (AbstractC4689ua.f16857AZxh) {
            return;
        }
        m8775wA();
    }

    /* renamed from: vI */
    public final void m8774vI() {
        C4929y8 c4929y8 = this.f8749lgHUyS;
        this.f8741AZxh = c4929y8;
        this.f8752wA = c4929y8;
        this.f8748ZfxDd = c4929y8;
        this.f8745KLFTb = c4929y8;
        this.f8744JHa = c4929y8;
        this.f8753xJ = c4929y8;
    }

    /* renamed from: wA */
    public void m8775wA() {
        this.f8751qdMbNW.m10182mjFkc();
    }

    /* renamed from: xJ */
    public int m8776xJ() {
        return this.f8751qdMbNW.m10181lgHUyS();
    }
}
