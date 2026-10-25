package p131o;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import p131o.AbstractC2006G3;

/* renamed from: o.Moer */
/* loaded from: classes.dex */
public class C2463Moer extends TextView {

    /* renamed from: AZxh */
    public final C2171IVlxe f9610AZxh;

    /* renamed from: JHa */
    public mjFkc f9611JHa;

    /* renamed from: KLFTb */
    public boolean f9612KLFTb;

    /* renamed from: ZfxDd */
    public C3038Vdz f9613ZfxDd;

    /* renamed from: mjFkc */
    public final C2266JrJO f9614mjFkc;

    /* renamed from: wA */
    public final C4884xROA f9615wA;

    /* renamed from: xJ */
    public Future f9616xJ;

    /* renamed from: o.Moer$AZxh */
    public class AZxh implements mjFkc {
        public AZxh() {
        }

        @Override // p131o.C2463Moer.mjFkc
        /* renamed from: AZxh */
        public void mo9550AZxh(TextClassifier textClassifier) {
            C2463Moer.super.setTextClassifier(textClassifier);
        }

        @Override // p131o.C2463Moer.mjFkc
        /* renamed from: ETF */
        public int mo9551ETF() {
            return C2463Moer.super.getAutoSizeStepGranularity();
        }

        @Override // p131o.C2463Moer.mjFkc
        /* renamed from: JHa */
        public int mo9552JHa() {
            return C2463Moer.super.getAutoSizeMaxTextSize();
        }

        @Override // p131o.C2463Moer.mjFkc
        /* renamed from: KLFTb */
        public TextClassifier mo9553KLFTb() {
            return C2463Moer.super.getTextClassifier();
        }

        @Override // p131o.C2463Moer.mjFkc
        /* renamed from: VA */
        public void mo9554VA(int i) {
            C2463Moer.super.setAutoSizeTextTypeWithDefaults(i);
        }

        @Override // p131o.C2463Moer.mjFkc
        /* renamed from: lgHUyS */
        public int mo9555lgHUyS() {
            return C2463Moer.super.getAutoSizeTextType();
        }

        @Override // p131o.C2463Moer.mjFkc
        /* renamed from: mjFkc */
        public void mo9556mjFkc(int[] iArr, int i) {
            C2463Moer.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }

        @Override // p131o.C2463Moer.mjFkc
        /* renamed from: qdMbNW */
        public int mo9557qdMbNW() {
            return C2463Moer.super.getAutoSizeMinTextSize();
        }

        @Override // p131o.C2463Moer.mjFkc
        /* renamed from: wA */
        public int[] mo9558wA() {
            return C2463Moer.super.getAutoSizeTextAvailableSizes();
        }

        @Override // p131o.C2463Moer.mjFkc
        /* renamed from: xJ */
        public void mo9559xJ(int i, int i2, int i3, int i4) {
            C2463Moer.super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }
    }

    /* renamed from: o.Moer$mjFkc */
    public interface mjFkc {
        /* renamed from: AZxh */
        void mo9550AZxh(TextClassifier textClassifier);

        /* renamed from: Dt */
        void mo9560Dt(int i);

        /* renamed from: ETF */
        int mo9551ETF();

        /* renamed from: JHa */
        int mo9552JHa();

        /* renamed from: KLFTb */
        TextClassifier mo9553KLFTb();

        /* renamed from: VA */
        void mo9554VA(int i);

        /* renamed from: ZfxDd */
        void mo9561ZfxDd(int i);

        /* renamed from: lgHUyS */
        int mo9555lgHUyS();

        /* renamed from: mjFkc */
        void mo9556mjFkc(int[] iArr, int i);

        /* renamed from: qdMbNW */
        int mo9557qdMbNW();

        /* renamed from: wA */
        int[] mo9558wA();

        /* renamed from: xJ */
        void mo9559xJ(int i, int i2, int i3, int i4);
    }

    /* renamed from: o.Moer$wA */
    public class wA extends AZxh {
        public wA() {
            super();
        }

        @Override // p131o.C2463Moer.mjFkc
        /* renamed from: Dt */
        public void mo9560Dt(int i) {
            C2463Moer.super.setFirstBaselineToTopHeight(i);
        }

        @Override // p131o.C2463Moer.mjFkc
        /* renamed from: ZfxDd */
        public void mo9561ZfxDd(int i) {
            C2463Moer.super.setLastBaselineToBottomHeight(i);
        }
    }

    public C2463Moer(Context context) {
        this(context, null);
    }

    private C3038Vdz getEmojiTextViewHelper() {
        if (this.f9613ZfxDd == null) {
            this.f9613ZfxDd = new C3038Vdz(this);
        }
        return this.f9613ZfxDd;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C2266JrJO c2266JrJO = this.f9614mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9055AZxh();
        }
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8749AZxh();
        }
    }

    /* renamed from: fehf */
    public final void m9549fehf() {
        Future future = this.f9616xJ;
        if (future != null) {
            try {
                this.f9616xJ = null;
                AbstractC4793w7.m13819mjFkc(future.get());
                AbstractC4065l8.m12663VA(this, null);
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (AbstractC4689ua.f16857AZxh) {
            return getSuperCaller().mo9552JHa();
        }
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            return c2171IVlxe.m8757KLFTb();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (AbstractC4689ua.f16857AZxh) {
            return getSuperCaller().mo9557qdMbNW();
        }
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            return c2171IVlxe.m8756JHa();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (AbstractC4689ua.f16857AZxh) {
            return getSuperCaller().mo9551ETF();
        }
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            return c2171IVlxe.m8776xJ();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (AbstractC4689ua.f16857AZxh) {
            return getSuperCaller().mo9558wA();
        }
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        return c2171IVlxe != null ? c2171IVlxe.m8769lgHUyS() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (AbstractC4689ua.f16857AZxh) {
            return getSuperCaller().mo9555lgHUyS() == 1 ? 1 : 0;
        }
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            return c2171IVlxe.m8772qdMbNW();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC4065l8.m12670rkYL(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return AbstractC4065l8.m12657AZxh(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return AbstractC4065l8.m12671wA(this);
    }

    public mjFkc getSuperCaller() {
        if (this.f9611JHa == null) {
            this.f9611JHa = new wA();
        }
        return this.f9611JHa;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C2266JrJO c2266JrJO = this.f9614mjFkc;
        if (c2266JrJO != null) {
            return c2266JrJO.m9064wA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C2266JrJO c2266JrJO = this.f9614mjFkc;
        if (c2266JrJO != null) {
            return c2266JrJO.m9060ZfxDd();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f9610AZxh.m8751Dt();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f9610AZxh.m8752ETF();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        m9549fehf();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return getSuperCaller().mo9553KLFTb();
    }

    public AbstractC2006G3.mjFkc getTextMetricsParamsCompat() {
        return AbstractC4065l8.m12661KLFTb(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f9610AZxh.m8755IEE(this, inputConnectionOnCreateInputConnection, editorInfo);
        return AbstractC3971jm.m12442mjFkc(inputConnectionOnCreateInputConnection, editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8773rkYL(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        m9549fehf();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe == null || AbstractC4689ua.f16857AZxh || !c2171IVlxe.m8761VA()) {
            return;
        }
        this.f9610AZxh.m8775wA();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().m10701wA(z);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (AbstractC4689ua.f16857AZxh) {
            getSuperCaller().mo9559xJ(i, i2, i3, i4);
            return;
        }
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8764diqgf(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (AbstractC4689ua.f16857AZxh) {
            getSuperCaller().mo9556mjFkc(iArr, i);
            return;
        }
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8765eyqo(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (AbstractC4689ua.f16857AZxh) {
            getSuperCaller().mo9554VA(i);
            return;
        }
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8760Ucbh(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2266JrJO c2266JrJO = this.f9614mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9058JHa(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C2266JrJO c2266JrJO = this.f9614mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9065xJ(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8771qGY();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8771qGY();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8771qGY();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8771qGY();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC4065l8.m12668qGY(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().m10699ZfxDd(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().m10700mjFkc(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        getSuperCaller().mo9560Dt(i);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        getSuperCaller().mo9561ZfxDd(i);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        AbstractC4065l8.m12659ETF(this, i);
    }

    public void setPrecomputedText(AbstractC2006G3 abstractC2006G3) {
        AbstractC4065l8.m12663VA(this, abstractC2006G3);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2266JrJO c2266JrJO = this.f9614mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9063qdMbNW(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2266JrJO c2266JrJO = this.f9614mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9056Dt(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f9610AZxh.m8767huTpC(colorStateList);
        this.f9610AZxh.m8749AZxh();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f9610AZxh.m8753Gd(mode);
        this.f9610AZxh.m8749AZxh();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8766fehf(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        getSuperCaller().mo9550AZxh(textClassifier);
    }

    public void setTextFuture(Future<AbstractC2006G3> future) {
        this.f9616xJ = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(AbstractC2006G3.mjFkc mjfkc) {
        AbstractC4065l8.m12664YoKzxo(this, mjfkc);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (AbstractC4689ua.f16857AZxh) {
            super.setTextSize(i, f);
            return;
        }
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8762VocHEe(i, f);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i) {
        if (this.f9612KLFTb) {
            return;
        }
        Typeface typefaceM12759mjFkc = (typeface == null || i <= 0) ? null : AbstractC4130m9.m12759mjFkc(getContext(), typeface, i);
        this.f9612KLFTb = true;
        if (typefaceM12759mjFkc != null) {
            typeface = typefaceM12759mjFkc;
        }
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.f9612KLFTb = false;
        }
    }

    public C2463Moer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public C2463Moer(Context context, AttributeSet attributeSet, int i) {
        super(C4861x8.m13900AZxh(context), attributeSet, i);
        this.f9612KLFTb = false;
        this.f9611JHa = null;
        AbstractC4326p8.m13067mjFkc(this, getContext());
        C2266JrJO c2266JrJO = new C2266JrJO(this);
        this.f9614mjFkc = c2266JrJO;
        c2266JrJO.m9059KLFTb(attributeSet, i);
        C2171IVlxe c2171IVlxe = new C2171IVlxe(this);
        this.f9610AZxh = c2171IVlxe;
        c2171IVlxe.m8758MiMN(attributeSet, i);
        c2171IVlxe.m8749AZxh();
        this.f9615wA = new C4884xROA(this);
        getEmojiTextViewHelper().m10698AZxh(attributeSet, i);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? AbstractC4768vjlshU.m13794AZxh(context, i) : null, i2 != 0 ? AbstractC4768vjlshU.m13794AZxh(context, i2) : null, i3 != 0 ? AbstractC4768vjlshU.m13794AZxh(context, i3) : null, i4 != 0 ? AbstractC4768vjlshU.m13794AZxh(context, i4) : null);
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8771qGY();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? AbstractC4768vjlshU.m13794AZxh(context, i) : null, i2 != 0 ? AbstractC4768vjlshU.m13794AZxh(context, i2) : null, i3 != 0 ? AbstractC4768vjlshU.m13794AZxh(context, i3) : null, i4 != 0 ? AbstractC4768vjlshU.m13794AZxh(context, i4) : null);
        C2171IVlxe c2171IVlxe = this.f9610AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8771qGY();
        }
    }
}
