package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import p131o.AbstractC4592t5;

/* renamed from: o.V7 */
/* loaded from: classes.dex */
public class C3008V7 {

    /* renamed from: AZxh */
    public final ColorStateList f11280AZxh;

    /* renamed from: Dt */
    public final float f11281Dt;

    /* renamed from: ETF */
    public final boolean f11282ETF;

    /* renamed from: JHa */
    public final int f11283JHa;

    /* renamed from: KLFTb */
    public final int f11284KLFTb;

    /* renamed from: MiMN */
    public ColorStateList f11285MiMN;

    /* renamed from: VA */
    public final float f11286VA;

    /* renamed from: YoKzxo */
    public float f11287YoKzxo;

    /* renamed from: ZfxDd */
    public final String f11288ZfxDd;

    /* renamed from: fehf */
    public Typeface f11289fehf;

    /* renamed from: lgHUyS */
    public final float f11290lgHUyS;

    /* renamed from: mjFkc */
    public final ColorStateList f11291mjFkc;

    /* renamed from: qGY */
    public boolean f11292qGY = false;

    /* renamed from: qdMbNW */
    public final float f11293qdMbNW;

    /* renamed from: rkYL */
    public final int f11294rkYL;

    /* renamed from: wA */
    public final ColorStateList f11295wA;

    /* renamed from: xJ */
    public final boolean f11296xJ;

    /* renamed from: o.V7$AZxh */
    public class AZxh extends AbstractC3139X7 {

        /* renamed from: AZxh */
        public final /* synthetic */ TextPaint f11297AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ Context f11299mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ AbstractC3139X7 f11300wA;

        public AZxh(Context context, TextPaint textPaint, AbstractC3139X7 abstractC3139X7) {
            this.f11299mjFkc = context;
            this.f11297AZxh = textPaint;
            this.f11300wA = abstractC3139X7;
        }

        @Override // p131o.AbstractC3139X7
        /* renamed from: AZxh */
        public void mo2738AZxh(Typeface typeface, boolean z) {
            C3008V7.this.m10675qGY(this.f11299mjFkc, this.f11297AZxh, typeface);
            this.f11300wA.mo2738AZxh(typeface, z);
        }

        @Override // p131o.AbstractC3139X7
        /* renamed from: mjFkc */
        public void mo2739mjFkc(int i) {
            this.f11300wA.mo2739mjFkc(i);
        }
    }

    /* renamed from: o.V7$mjFkc */
    public class mjFkc extends AbstractC4592t5.KLFTb {

        /* renamed from: mjFkc */
        public final /* synthetic */ AbstractC3139X7 f11302mjFkc;

        public mjFkc(AbstractC3139X7 abstractC3139X7) {
            this.f11302mjFkc = abstractC3139X7;
        }

        @Override // p131o.AbstractC4592t5.KLFTb
        /* renamed from: lgHUyS */
        public void m13593JHa(int i) {
            C3008V7.this.f11292qGY = true;
            this.f11302mjFkc.mo2739mjFkc(i);
        }

        @Override // p131o.AbstractC4592t5.KLFTb
        /* renamed from: qdMbNW */
        public void m13596xJ(Typeface typeface) {
            C3008V7 c3008v7 = C3008V7.this;
            c3008v7.f11289fehf = Typeface.create(typeface, c3008v7.f11284KLFTb);
            C3008V7.this.f11292qGY = true;
            this.f11302mjFkc.mo2738AZxh(C3008V7.this.f11289fehf, false);
        }
    }

    public C3008V7(Context context, int i) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, AbstractC3340a5.f12441PX);
        m10671VA(typedArrayObtainStyledAttributes.getDimension(AbstractC3340a5.f12363FoO, 0.0f));
        m10667ETF(AbstractC2478N1.m9577mjFkc(context, typedArrayObtainStyledAttributes, AbstractC3340a5.f12604mL));
        this.f11291mjFkc = AbstractC2478N1.m9577mjFkc(context, typedArrayObtainStyledAttributes, AbstractC3340a5.f12479UXIO);
        this.f11280AZxh = AbstractC2478N1.m9577mjFkc(context, typedArrayObtainStyledAttributes, AbstractC3340a5.f12418LyQ);
        this.f11284KLFTb = typedArrayObtainStyledAttributes.getInt(AbstractC3340a5.f12361FiDh, 0);
        this.f11283JHa = typedArrayObtainStyledAttributes.getInt(AbstractC3340a5.f12706zpm, 1);
        int iM9576ZfxDd = AbstractC2478N1.m9576ZfxDd(typedArrayObtainStyledAttributes, AbstractC3340a5.f12594khjiU, AbstractC3340a5.f12564gb);
        this.f11294rkYL = typedArrayObtainStyledAttributes.getResourceId(iM9576ZfxDd, 0);
        this.f11288ZfxDd = typedArrayObtainStyledAttributes.getString(iM9576ZfxDd);
        this.f11296xJ = typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12512YDiFPt, false);
        this.f11295wA = AbstractC2478N1.m9577mjFkc(context, typedArrayObtainStyledAttributes, AbstractC3340a5.f12641rKxis);
        this.f11290lgHUyS = typedArrayObtainStyledAttributes.getFloat(AbstractC3340a5.f12646rtBEoQ, 0.0f);
        this.f11293qdMbNW = typedArrayObtainStyledAttributes.getFloat(AbstractC3340a5.f12516YuaD, 0.0f);
        this.f11281Dt = typedArrayObtainStyledAttributes.getFloat(AbstractC3340a5.f12668uube, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i, AbstractC3340a5.f12523Zj);
        this.f11282ETF = typedArrayObtainStyledAttributes2.hasValue(AbstractC3340a5.f12327BWNgxc);
        this.f11286VA = typedArrayObtainStyledAttributes2.getFloat(AbstractC3340a5.f12327BWNgxc, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    /* renamed from: Dt */
    public float m10666Dt() {
        return this.f11287YoKzxo;
    }

    /* renamed from: ETF */
    public void m10667ETF(ColorStateList colorStateList) {
        this.f11285MiMN = colorStateList;
    }

    /* renamed from: JHa */
    public Typeface m10668JHa(Context context) {
        if (this.f11292qGY) {
            return this.f11289fehf;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceM13587xJ = AbstractC4592t5.m13587xJ(context, this.f11294rkYL);
                this.f11289fehf = typefaceM13587xJ;
                if (typefaceM13587xJ != null) {
                    this.f11289fehf = Typeface.create(typefaceM13587xJ, this.f11284KLFTb);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e) {
                Log.d("TextAppearance", "Error loading font " + this.f11288ZfxDd, e);
            }
        }
        m10673ZfxDd();
        this.f11292qGY = true;
        return this.f11289fehf;
    }

    /* renamed from: KLFTb */
    public Typeface m10669KLFTb() {
        m10673ZfxDd();
        return this.f11289fehf;
    }

    /* renamed from: MiMN */
    public final boolean m10670MiMN(Context context) {
        if (AbstractC3075W7.m10830mjFkc()) {
            return true;
        }
        int i = this.f11294rkYL;
        return (i != 0 ? AbstractC4592t5.m13586wA(context, i) : null) != null;
    }

    /* renamed from: VA */
    public void m10671VA(float f) {
        this.f11287YoKzxo = f;
    }

    /* renamed from: YoKzxo */
    public void m10672YoKzxo(Context context, TextPaint textPaint, AbstractC3139X7 abstractC3139X7) {
        m10677rkYL(context, textPaint, abstractC3139X7);
        ColorStateList colorStateList = this.f11285MiMN;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f = this.f11281Dt;
        float f2 = this.f11290lgHUyS;
        float f3 = this.f11293qdMbNW;
        ColorStateList colorStateList2 = this.f11295wA;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    /* renamed from: ZfxDd */
    public final void m10673ZfxDd() {
        String str;
        if (this.f11289fehf == null && (str = this.f11288ZfxDd) != null) {
            this.f11289fehf = Typeface.create(str, this.f11284KLFTb);
        }
        if (this.f11289fehf == null) {
            int i = this.f11283JHa;
            if (i == 1) {
                this.f11289fehf = Typeface.SANS_SERIF;
            } else if (i == 2) {
                this.f11289fehf = Typeface.SERIF;
            } else if (i != 3) {
                this.f11289fehf = Typeface.DEFAULT;
            } else {
                this.f11289fehf = Typeface.MONOSPACE;
            }
            this.f11289fehf = Typeface.create(this.f11289fehf, this.f11284KLFTb);
        }
    }

    /* renamed from: lgHUyS */
    public void m10674lgHUyS(Context context, AbstractC3139X7 abstractC3139X7) {
        if (m10670MiMN(context)) {
            m10668JHa(context);
        } else {
            m10673ZfxDd();
        }
        int i = this.f11294rkYL;
        if (i == 0) {
            this.f11292qGY = true;
        }
        if (this.f11292qGY) {
            abstractC3139X7.mo2738AZxh(this.f11289fehf, true);
            return;
        }
        try {
            AbstractC4592t5.m13585qdMbNW(context, i, new mjFkc(abstractC3139X7), null);
        } catch (Resources.NotFoundException unused) {
            this.f11292qGY = true;
            abstractC3139X7.mo2739mjFkc(1);
        } catch (Exception e) {
            Log.d("TextAppearance", "Error loading font " + this.f11288ZfxDd, e);
            this.f11292qGY = true;
            abstractC3139X7.mo2739mjFkc(-3);
        }
    }

    /* renamed from: qGY */
    public void m10675qGY(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceM13492mjFkc = AbstractC4529s9.m13492mjFkc(context, typeface);
        if (typefaceM13492mjFkc != null) {
            typeface = typefaceM13492mjFkc;
        }
        textPaint.setTypeface(typeface);
        int i = this.f11284KLFTb & (~typeface.getStyle());
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f11287YoKzxo);
        if (this.f11282ETF) {
            textPaint.setLetterSpacing(this.f11286VA);
        }
    }

    /* renamed from: qdMbNW */
    public ColorStateList m10676qdMbNW() {
        return this.f11285MiMN;
    }

    /* renamed from: rkYL */
    public void m10677rkYL(Context context, TextPaint textPaint, AbstractC3139X7 abstractC3139X7) {
        if (m10670MiMN(context)) {
            m10675qGY(context, textPaint, m10668JHa(context));
        } else {
            m10678xJ(context, textPaint, abstractC3139X7);
        }
    }

    /* renamed from: xJ */
    public void m10678xJ(Context context, TextPaint textPaint, AbstractC3139X7 abstractC3139X7) {
        m10675qGY(context, textPaint, m10669KLFTb());
        m10674lgHUyS(context, new AZxh(context, textPaint, abstractC3139X7));
    }
}
