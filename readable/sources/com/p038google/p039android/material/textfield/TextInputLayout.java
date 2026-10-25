package com.p038google.p039android.material.textfield;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.p038google.p039android.material.internal.CheckableImageButton;
import com.p038google.p039android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.conscrypt.BuildConfig;
import p131o.AbstractC1599A1;
import p131o.AbstractC1803D4;
import p131o.AbstractC1942FBR;
import p131o.AbstractC1987FoPRDo;
import p131o.AbstractC2345L1;
import p131o.AbstractC2478N1;
import p131o.AbstractC2481N4;
import p131o.AbstractC2506NPj;
import p131o.AbstractC2614P8;
import p131o.AbstractC2734R1;
import p131o.AbstractC2737R4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3340a5;
import p131o.AbstractC3397awnh;
import p131o.AbstractC3800h4;
import p131o.AbstractC3995k4;
import p131o.AbstractC4065l8;
import p131o.AbstractC4191n4;
import p131o.AbstractC4260o8;
import p131o.AbstractC4294ofHOBL;
import p131o.AbstractC4332pCk;
import p131o.AbstractC4512rtBEoQ;
import p131o.AbstractC4557sa;
import p131o.AbstractC4768vjlshU;
import p131o.AbstractC4796wA;
import p131o.AbstractC4923y2;
import p131o.C1606A8;
import p131o.C1786CqAnRZ;
import p131o.C2141I6;
import p131o.C2255Jidt;
import p131o.C2276K;
import p131o.C2454MiMN;
import p131o.C2463Moer;
import p131o.C2542O1;
import p131o.C2951UKTt;
import p131o.C2971Ucbh;
import p131o.C3442bbzow;
import p131o.C3803h7;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {

    /* renamed from: kism */
    public static final int f2812kism = AbstractC2737R4.f10367KLFTb;

    /* renamed from: tjSezt */
    public static final int[][] f2813tjSezt = {new int[]{R.attr.state_pressed}, new int[0]};

    /* renamed from: ANMGZc */
    public int f2814ANMGZc;

    /* renamed from: AZxh */
    public final C3803h7 f2815AZxh;

    /* renamed from: BAnRFn */
    public CharSequence f2816BAnRFn;

    /* renamed from: CqaNbM */
    public C2542O1 f2817CqaNbM;

    /* renamed from: Dt */
    public final C2276K f2818Dt;

    /* renamed from: ETF */
    public boolean f2819ETF;

    /* renamed from: GMIER */
    public final Rect f2820GMIER;

    /* renamed from: Gd */
    public C2951UKTt f2821Gd;

    /* renamed from: HGpJ */
    public ColorStateList f2822HGpJ;

    /* renamed from: IEE */
    public CharSequence f2823IEE;

    /* renamed from: IVlxe */
    public boolean f2824IVlxe;

    /* renamed from: JBhc */
    public ColorStateList f2825JBhc;

    /* renamed from: JHa */
    public int f2826JHa;

    /* renamed from: JYgkl */
    public Drawable f2827JYgkl;

    /* renamed from: JYn */
    public Typeface f2828JYn;

    /* renamed from: JrJO */
    public int f2829JrJO;

    /* renamed from: KLFTb */
    public CharSequence f2830KLFTb;

    /* renamed from: KLMXS */
    public C2141I6 f2831KLMXS;

    /* renamed from: KRTLGT */
    public final Rect f2832KRTLGT;

    /* renamed from: MiMN */
    public boolean f2833MiMN;

    /* renamed from: Moer */
    public final C1786CqAnRZ f2834Moer;

    /* renamed from: NKyg */
    public boolean f2835NKyg;

    /* renamed from: NPj */
    public int f2836NPj;

    /* renamed from: Ne */
    public boolean f2837Ne;

    /* renamed from: OjSQV */
    public StateListDrawable f2838OjSQV;

    /* renamed from: Pq */
    public boolean f2839Pq;

    /* renamed from: Qr */
    public ValueAnimator f2840Qr;

    /* renamed from: SOS */
    public boolean f2841SOS;

    /* renamed from: SmIWf */
    public boolean f2842SmIWf;

    /* renamed from: SwgkN */
    public ColorStateList f2843SwgkN;

    /* renamed from: Ucbh */
    public int f2844Ucbh;

    /* renamed from: VA */
    public int f2845VA;

    /* renamed from: Vdz */
    public int f2846Vdz;

    /* renamed from: Vnb */
    public int f2847Vnb;

    /* renamed from: VocHEe */
    public boolean f2848VocHEe;

    /* renamed from: WGXroI */
    public Drawable f2849WGXroI;

    /* renamed from: WrLQs */
    public int f2850WrLQs;

    /* renamed from: XV */
    public int f2851XV;

    /* renamed from: YoKzxo */
    public InterfaceC0284JHa f2852YoKzxo;

    /* renamed from: ZfxDd */
    public EditText f2853ZfxDd;

    /* renamed from: alEkx */
    public ColorStateList f2854alEkx;

    /* renamed from: aqHPIZ */
    public int f2855aqHPIZ;

    /* renamed from: bbzow */
    public Drawable f2856bbzow;

    /* renamed from: cMLeY */
    public final int f2857cMLeY;

    /* renamed from: diqgf */
    public TextView f2858diqgf;

    /* renamed from: dm */
    public int f2859dm;

    /* renamed from: eyqo */
    public ColorStateList f2860eyqo;

    /* renamed from: fehf */
    public int f2861fehf;

    /* renamed from: gtIJp */
    public boolean f2862gtIJp;

    /* renamed from: huTpC */
    public C2951UKTt f2863huTpC;

    /* renamed from: jm */
    public int f2864jm;

    /* renamed from: lB */
    public boolean f2865lB;

    /* renamed from: lgHUyS */
    public int f2866lgHUyS;

    /* renamed from: mByQ */
    public C2542O1 f2867mByQ;

    /* renamed from: mjFkc */
    public final FrameLayout f2868mjFkc;

    /* renamed from: nxI */
    public final LinkedHashSet f2869nxI;

    /* renamed from: oCFDzJ */
    public int f2870oCFDzJ;

    /* renamed from: qGY */
    public int f2871qGY;

    /* renamed from: qdMbNW */
    public int f2872qdMbNW;

    /* renamed from: rWxwaT */
    public int f2873rWxwaT;

    /* renamed from: rkYL */
    public TextView f2874rkYL;

    /* renamed from: tQ */
    public int f2875tQ;

    /* renamed from: uHVRx */
    public final RectF f2876uHVRx;

    /* renamed from: vI */
    public ColorStateList f2877vI;

    /* renamed from: vadzgd */
    public int f2878vadzgd;

    /* renamed from: vjlshU */
    public int f2879vjlshU;

    /* renamed from: wA */
    public final C0291mjFkc f2880wA;

    /* renamed from: wJVbdd */
    public C2542O1 f2881wJVbdd;

    /* renamed from: xJ */
    public int f2882xJ;

    /* renamed from: xROA */
    public int f2883xROA;

    /* renamed from: xrEuO */
    public C2542O1 f2884xrEuO;

    /* renamed from: yfx */
    public int f2885yfx;

    /* renamed from: zvd */
    public boolean f2886zvd;

    /* renamed from: com.google.android.material.textfield.TextInputLayout$AZxh */
    public class RunnableC0283AZxh implements Runnable {
        public RunnableC0283AZxh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f2880wA.m3257lgHUyS();
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$JHa */
    public interface InterfaceC0284JHa {
        /* renamed from: mjFkc */
        int mo3197mjFkc(Editable editable);
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$KLFTb */
    public static class C0285KLFTb extends C2454MiMN {

        /* renamed from: ZfxDd */
        public final TextInputLayout f2888ZfxDd;

        public C0285KLFTb(TextInputLayout textInputLayout) {
            this.f2888ZfxDd = textInputLayout;
        }

        @Override // p131o.C2454MiMN
        /* renamed from: lgHUyS */
        public void mo1224lgHUyS(View view, AccessibilityEvent accessibilityEvent) {
            super.mo1224lgHUyS(view, accessibilityEvent);
            this.f2888ZfxDd.f2880wA.m3224MiMN().mo7818qGY(view, accessibilityEvent);
        }

        @Override // p131o.C2454MiMN
        /* renamed from: xJ */
        public void mo620xJ(View view, C2971Ucbh c2971Ucbh) {
            super.mo620xJ(view, c2971Ucbh);
            EditText editText = this.f2888ZfxDd.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence charSequenceM3171getHint = this.f2888ZfxDd.m3171getHint();
            CharSequence error = this.f2888ZfxDd.getError();
            CharSequence placeholderText = this.f2888ZfxDd.getPlaceholderText();
            int counterMaxLength = this.f2888ZfxDd.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f2888ZfxDd.getCounterOverflowDescription();
            boolean zIsEmpty = TextUtils.isEmpty(text);
            boolean zIsEmpty2 = TextUtils.isEmpty(charSequenceM3171getHint);
            boolean zM3149NPj = this.f2888ZfxDd.m3149NPj();
            boolean zIsEmpty3 = TextUtils.isEmpty(error);
            boolean z = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
            String string = !zIsEmpty2 ? charSequenceM3171getHint.toString() : BuildConfig.f24315FLAVOR;
            this.f2888ZfxDd.f2815AZxh.m12208vI(c2971Ucbh);
            if (!zIsEmpty) {
                c2971Ucbh.m10547LREOK(text);
            } else if (!TextUtils.isEmpty(string)) {
                c2971Ucbh.m10547LREOK(string);
                if (!zM3149NPj && placeholderText != null) {
                    c2971Ucbh.m10547LREOK(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                c2971Ucbh.m10547LREOK(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                c2971Ucbh.m10602xROA(string);
                c2971Ucbh.m10595tjSezt(zIsEmpty);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            c2971Ucbh.m10549Moer(counterMaxLength);
            if (z) {
                if (zIsEmpty3) {
                    error = counterOverflowDescription;
                }
                c2971Ucbh.m10575dm(error);
            }
            View viewM9099diqgf = this.f2888ZfxDd.f2818Dt.m9099diqgf();
            if (viewM9099diqgf != null) {
                c2971Ucbh.m10539IVlxe(viewM9099diqgf);
            }
            this.f2888ZfxDd.f2880wA.m3224MiMN().mo7820rkYL(view, c2971Ucbh);
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$ZfxDd */
    public class C0286ZfxDd implements ValueAnimator.AnimatorUpdateListener {
        public C0286ZfxDd() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.f2834Moer.m7901bbzow(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$lgHUyS */
    public static class C0287lgHUyS extends AbstractC4796wA {

        /* renamed from: CREATOR */
        public static final Parcelable.Creator<C0287lgHUyS> f2890CREATOR = new mjFkc();

        /* renamed from: ZfxDd */
        public boolean f2891ZfxDd;

        /* renamed from: wA */
        public CharSequence f2892wA;

        /* renamed from: com.google.android.material.textfield.TextInputLayout$lgHUyS$mjFkc */
        public class mjFkc implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
            public C0287lgHUyS createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0287lgHUyS(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public C0287lgHUyS createFromParcel(Parcel parcel) {
                return new C0287lgHUyS(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: wA, reason: merged with bridge method [inline-methods] */
            public C0287lgHUyS[] newArray(int i) {
                return new C0287lgHUyS[i];
            }
        }

        public C0287lgHUyS(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f2892wA) + "}";
        }

        @Override // p131o.AbstractC4796wA, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f2892wA, parcel, i);
            parcel.writeInt(this.f2891ZfxDd ? 1 : 0);
        }

        public C0287lgHUyS(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2892wA = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f2891ZfxDd = parcel.readInt() == 1;
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$mjFkc */
    public class C0288mjFkc implements TextWatcher {
        public C0288mjFkc() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.m3154SmIWf(!r0.f2862gtIJp);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.f2819ETF) {
                textInputLayout.m3131ANMGZc(editable);
            }
            if (TextInputLayout.this.f2839Pq) {
                TextInputLayout.this.m3172gtIJp(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$wA */
    public class RunnableC0289wA implements Runnable {
        public RunnableC0289wA() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f2853ZfxDd.requestLayout();
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$xJ */
    public interface InterfaceC0290xJ {
        /* renamed from: mjFkc */
        void mo3201mjFkc(TextInputLayout textInputLayout);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3800h4.f13955xrEuO);
    }

    /* renamed from: KLMXS */
    public static Drawable m3122KLMXS(Context context, C2542O1 c2542o1, int i, int[][] iArr) {
        int iM9307wA = AbstractC2345L1.m9307wA(context, AbstractC3800h4.f13945lgHUyS, "TextInputLayout");
        C2542O1 c2542o12 = new C2542O1(c2542o1.m9833lB());
        int iM9306qdMbNW = AbstractC2345L1.m9306qdMbNW(i, iM9307wA, 0.1f);
        c2542o12.m9841uHVRx(new ColorStateList(iArr, new int[]{iM9306qdMbNW, 0}));
        c2542o12.setTint(iM9307wA);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iM9306qdMbNW, iM9307wA});
        C2542O1 c2542o13 = new C2542O1(c2542o1.m9833lB());
        c2542o13.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, c2542o12, c2542o13), c2542o1});
    }

    /* renamed from: Ne */
    public static Drawable m3123Ne(C2542O1 c2542o1, int i, int i2, int[][] iArr) {
        return new RippleDrawable(new ColorStateList(iArr, new int[]{AbstractC2345L1.m9306qdMbNW(i2, i, 0.1f), i}), c2542o1, c2542o1);
    }

    /* renamed from: alEkx */
    public static void m3125alEkx(Context context, TextView textView, int i, int i2, boolean z) {
        textView.setContentDescription(context.getString(z ? AbstractC2481N4.f9653wA : AbstractC2481N4.f9635AZxh, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    /* renamed from: aqHPIZ */
    public static /* synthetic */ int m3126aqHPIZ(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f2853ZfxDd;
        if (!(editText instanceof AutoCompleteTextView) || AbstractC4512rtBEoQ.m13401mjFkc(editText)) {
            return this.f2881wJVbdd;
        }
        int iM9303ZfxDd = AbstractC2345L1.m9303ZfxDd(this.f2853ZfxDd, AbstractC3800h4.f13939ZfxDd);
        int i = this.f2873rWxwaT;
        if (i == 2) {
            return m3122KLMXS(getContext(), this.f2881wJVbdd, iM9303ZfxDd, f2813tjSezt);
        }
        if (i == 1) {
            return m3123Ne(this.f2881wJVbdd, this.f2850WrLQs, iM9303ZfxDd, f2813tjSezt);
        }
        return null;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.f2838OjSQV == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f2838OjSQV = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.f2838OjSQV.addState(new int[0], m3150OjSQV(false));
        }
        return this.f2838OjSQV;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.f2867mByQ == null) {
            this.f2867mByQ = m3150OjSQV(true);
        }
        return this.f2867mByQ;
    }

    private void setEditText(EditText editText) {
        if (this.f2853ZfxDd != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f2853ZfxDd = editText;
        int i = this.f2826JHa;
        if (i != -1) {
            setMinEms(i);
        } else {
            setMinWidth(this.f2866lgHUyS);
        }
        int i2 = this.f2882xJ;
        if (i2 != -1) {
            setMaxEms(i2);
        } else {
            setMaxWidth(this.f2872qdMbNW);
        }
        this.f2837Ne = false;
        m3162WrLQs();
        setTextInputAccessibilityDelegate(new C0285KLFTb(this));
        this.f2834Moer.m7899alEkx(this.f2853ZfxDd.getTypeface());
        this.f2834Moer.m7894WGXroI(this.f2853ZfxDd.getTextSize());
        this.f2834Moer.m7878JYgkl(this.f2853ZfxDd.getLetterSpacing());
        int gravity = this.f2853ZfxDd.getGravity();
        this.f2834Moer.m7895WrLQs((gravity & (-113)) | 48);
        this.f2834Moer.m7910nxI(gravity);
        this.f2853ZfxDd.addTextChangedListener(new C0288mjFkc());
        if (this.f2843SwgkN == null) {
            this.f2843SwgkN = this.f2853ZfxDd.getHintTextColors();
        }
        if (this.f2848VocHEe) {
            if (TextUtils.isEmpty(this.f2816BAnRFn)) {
                CharSequence hint = this.f2853ZfxDd.getHint();
                this.f2830KLFTb = hint;
                m3186setHint(hint);
                this.f2853ZfxDd.setHint((CharSequence) null);
            }
            this.f2865lB = true;
        }
        if (this.f2874rkYL != null) {
            m3131ANMGZc(this.f2853ZfxDd.getText());
        }
        m3191vjlshU();
        this.f2818Dt.m9083JHa();
        this.f2815AZxh.bringToFront();
        this.f2880wA.bringToFront();
        m3132BAnRFn();
        this.f2880wA.m3266tjSezt();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        m3153SOS(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f2816BAnRFn)) {
            return;
        }
        this.f2816BAnRFn = charSequence;
        this.f2834Moer.m7907jm(charSequence);
        if (this.f2824IVlxe) {
            return;
        }
        m3145KRTLGT();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.f2839Pq == z) {
            return;
        }
        if (z) {
            m3182qdMbNW();
        } else {
            m3142JYgkl();
            this.f2858diqgf = null;
        }
        this.f2839Pq = z;
    }

    /* renamed from: uHVRx */
    public static void m3128uHVRx(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m3128uHVRx((ViewGroup) childAt, z);
            }
        }
    }

    /* renamed from: ANMGZc */
    public void m3131ANMGZc(Editable editable) {
        int iMo3197mjFkc = this.f2852YoKzxo.mo3197mjFkc(editable);
        boolean z = this.f2833MiMN;
        int i = this.f2845VA;
        if (i == -1) {
            this.f2874rkYL.setText(String.valueOf(iMo3197mjFkc));
            this.f2874rkYL.setContentDescription(null);
            this.f2833MiMN = false;
        } else {
            this.f2833MiMN = iMo3197mjFkc > i;
            m3125alEkx(getContext(), this.f2874rkYL, iMo3197mjFkc, this.f2845VA, this.f2833MiMN);
            if (z != this.f2833MiMN) {
                m3168dm();
            }
            this.f2874rkYL.setText(C2255Jidt.m9007wA().m9008Dt(getContext().getString(AbstractC2481N4.f9645ZfxDd, Integer.valueOf(iMo3197mjFkc), Integer.valueOf(this.f2845VA))));
        }
        if (this.f2853ZfxDd == null || z == this.f2833MiMN) {
            return;
        }
        m3154SmIWf(false);
        m3188tjSezt();
        m3191vjlshU();
    }

    /* renamed from: BAnRFn */
    public final void m3132BAnRFn() {
        Iterator it = this.f2869nxI.iterator();
        while (it.hasNext()) {
            ((InterfaceC0290xJ) it.next()).mo3201mjFkc(this);
        }
    }

    /* renamed from: CqaNbM */
    public final int m3133CqaNbM(int i, boolean z) {
        int compoundPaddingLeft = i + this.f2853ZfxDd.getCompoundPaddingLeft();
        return (getPrefixText() == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
    }

    /* renamed from: Dt */
    public final void m3134Dt() {
        if (this.f2853ZfxDd == null || this.f2873rWxwaT != 1) {
            return;
        }
        if (AbstractC2478N1.m9579xJ(getContext())) {
            EditText editText = this.f2853ZfxDd;
            AbstractC2876T9.m10274gYa(editText, AbstractC2876T9.m10224BAnRFn(editText), getResources().getDimensionPixelSize(AbstractC4191n4.f15313IEE), AbstractC2876T9.m10257VocHEe(this.f2853ZfxDd), getResources().getDimensionPixelSize(AbstractC4191n4.f15333fehf));
        } else if (AbstractC2478N1.m9574JHa(getContext())) {
            EditText editText2 = this.f2853ZfxDd;
            AbstractC2876T9.m10274gYa(editText2, AbstractC2876T9.m10224BAnRFn(editText2), getResources().getDimensionPixelSize(AbstractC4191n4.f15340qGY), AbstractC2876T9.m10257VocHEe(this.f2853ZfxDd), getResources().getDimensionPixelSize(AbstractC4191n4.f15343rkYL));
        }
    }

    /* renamed from: ETF */
    public void m3135ETF(float f) {
        if (this.f2834Moer.m7873Gd() == f) {
            return;
        }
        if (this.f2840Qr == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f2840Qr = valueAnimator;
            valueAnimator.setInterpolator(AbstractC4923y2.m13988xJ(getContext(), AbstractC3800h4.f13921BAnRFn, AbstractC2506NPj.f9736AZxh));
            this.f2840Qr.setDuration(AbstractC4923y2.m13983JHa(getContext(), AbstractC3800h4.f13935Ucbh, 167));
            this.f2840Qr.addUpdateListener(new C0286ZfxDd());
        }
        this.f2840Qr.setFloatValues(this.f2834Moer.m7873Gd(), f);
        this.f2840Qr.start();
    }

    /* renamed from: GMIER */
    public final void m3136GMIER() {
        if (!m3160VocHEe() || this.f2824IVlxe) {
            return;
        }
        m3137Gd();
        m3145KRTLGT();
    }

    /* renamed from: Gd */
    public final void m3137Gd() {
        if (m3160VocHEe()) {
            ((AbstractC1987FoPRDo) this.f2881wJVbdd).m8326vjlshU();
        }
    }

    /* renamed from: HGpJ */
    public final void m3138HGpJ(boolean z) {
        ValueAnimator valueAnimator = this.f2840Qr;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f2840Qr.cancel();
        }
        if (z && this.f2841SOS) {
            m3135ETF(1.0f);
        } else {
            this.f2834Moer.m7901bbzow(1.0f);
        }
        this.f2824IVlxe = false;
        if (m3160VocHEe()) {
            m3145KRTLGT();
        }
        m3148NKyg();
        this.f2815AZxh.m12186ETF(false);
        this.f2880wA.m3228Ne(false);
    }

    /* renamed from: IEE */
    public final int m3139IEE(Rect rect, Rect rect2, float f) {
        return m3180oCFDzJ() ? (int) (rect2.top + f) : rect.bottom - this.f2853ZfxDd.getCompoundPaddingBottom();
    }

    /* renamed from: IVlxe */
    public final boolean m3140IVlxe() {
        int iMax;
        if (this.f2853ZfxDd == null || this.f2853ZfxDd.getMeasuredHeight() >= (iMax = Math.max(this.f2880wA.getMeasuredHeight(), this.f2815AZxh.getMeasuredHeight()))) {
            return false;
        }
        this.f2853ZfxDd.setMinimumHeight(iMax);
        return true;
    }

    /* renamed from: JBhc */
    public final void m3141JBhc() {
        if (this.f2873rWxwaT == 1) {
            if (AbstractC2478N1.m9579xJ(getContext())) {
                this.f2847Vnb = getResources().getDimensionPixelSize(AbstractC4191n4.f15331diqgf);
            } else if (AbstractC2478N1.m9574JHa(getContext())) {
                this.f2847Vnb = getResources().getDimensionPixelSize(AbstractC4191n4.f15321Pq);
            }
        }
    }

    /* renamed from: JYgkl */
    public final void m3142JYgkl() {
        TextView textView = this.f2858diqgf;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* renamed from: JYn */
    public void m3143JYn() {
        this.f2815AZxh.m12195VA();
    }

    /* renamed from: JrJO */
    public final void m3144JrJO() {
        EditText editText = this.f2853ZfxDd;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i = this.f2873rWxwaT;
                if (i == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    /* renamed from: KRTLGT */
    public final void m3145KRTLGT() {
        if (m3160VocHEe()) {
            RectF rectF = this.f2876uHVRx;
            this.f2834Moer.m7915rkYL(rectF, this.f2853ZfxDd.getWidth(), this.f2853ZfxDd.getGravity());
            if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
                return;
            }
            m3164YoKzxo(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.f2836NPj);
            ((AbstractC1987FoPRDo) this.f2881wJVbdd).m8325IVlxe(rectF);
        }
    }

    /* renamed from: MiMN */
    public final void m3146MiMN() {
        if (this.f2817CqaNbM == null || this.f2884xrEuO == null) {
            return;
        }
        if (m3173huTpC()) {
            this.f2817CqaNbM.m9841uHVRx(this.f2853ZfxDd.isFocused() ? ColorStateList.valueOf(this.f2846Vdz) : ColorStateList.valueOf(this.f2855aqHPIZ));
            this.f2884xrEuO.m9841uHVRx(ColorStateList.valueOf(this.f2855aqHPIZ));
        }
        invalidate();
    }

    /* renamed from: Moer */
    public final void m3147Moer() {
        if (this.f2873rWxwaT != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2868mjFkc.getLayoutParams();
            int iM3169eyqo = m3169eyqo();
            if (iM3169eyqo != layoutParams.topMargin) {
                layoutParams.topMargin = iM3169eyqo;
                this.f2868mjFkc.requestLayout();
            }
        }
    }

    /* renamed from: NKyg */
    public final void m3148NKyg() {
        EditText editText = this.f2853ZfxDd;
        m3172gtIJp(editText == null ? null : editText.getText());
    }

    /* renamed from: NPj */
    public final boolean m3149NPj() {
        return this.f2824IVlxe;
    }

    /* renamed from: OjSQV */
    public final C2542O1 m3150OjSQV(boolean z) throws Resources.NotFoundException {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(AbstractC4191n4.f15324Vnb);
        float f = z ? dimensionPixelOffset : 0.0f;
        float dimensionPixelOffset2 = getResources().getDimensionPixelOffset(AbstractC4191n4.f15309Dt);
        int dimensionPixelOffset3 = getResources().getDimensionPixelOffset(AbstractC4191n4.f15330cMLeY);
        C2141I6 c2141i6M8698MiMN = C2141I6.m8661mjFkc().m8702VocHEe(f).m8708mByQ(f).m8700Pq(dimensionPixelOffset).m8706huTpC(dimensionPixelOffset).m8698MiMN();
        C2542O1 c2542o1M9792MiMN = C2542O1.m9792MiMN(getContext(), dimensionPixelOffset2);
        c2542o1M9792MiMN.setShapeAppearanceModel(c2141i6M8698MiMN);
        c2542o1M9792MiMN.m9806JYgkl(0, dimensionPixelOffset3, 0, dimensionPixelOffset3);
        return c2542o1M9792MiMN;
    }

    /* renamed from: Pq */
    public final int m3151Pq(Rect rect, float f) {
        return m3180oCFDzJ() ? (int) (rect.centerY() - (f / 2.0f)) : rect.top + this.f2853ZfxDd.getCompoundPaddingTop();
    }

    /* renamed from: Qr */
    public final void m3152Qr() {
        EditText editText;
        if (this.f2858diqgf == null || (editText = this.f2853ZfxDd) == null) {
            return;
        }
        this.f2858diqgf.setGravity(editText.getGravity());
        this.f2858diqgf.setPadding(this.f2853ZfxDd.getCompoundPaddingLeft(), this.f2853ZfxDd.getCompoundPaddingTop(), this.f2853ZfxDd.getCompoundPaddingRight(), this.f2853ZfxDd.getCompoundPaddingBottom());
    }

    /* renamed from: SOS */
    public final void m3153SOS(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f2853ZfxDd;
        boolean z3 = false;
        boolean z4 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f2853ZfxDd;
        if (editText2 != null && editText2.hasFocus()) {
            z3 = true;
        }
        ColorStateList colorStateList2 = this.f2843SwgkN;
        if (colorStateList2 != null) {
            this.f2834Moer.m7914rWxwaT(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.f2843SwgkN;
            this.f2834Moer.m7914rWxwaT(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f2883xROA) : this.f2883xROA));
        } else if (m3161WGXroI()) {
            this.f2834Moer.m7914rWxwaT(this.f2818Dt.m9082IEE());
        } else if (this.f2833MiMN && (textView = this.f2874rkYL) != null) {
            this.f2834Moer.m7914rWxwaT(textView.getTextColors());
        } else if (z3 && (colorStateList = this.f2825JBhc) != null) {
            this.f2834Moer.m7900aqHPIZ(colorStateList);
        }
        if (z4 || !this.f2842SmIWf || (isEnabled() && z3)) {
            if (z2 || this.f2824IVlxe) {
                m3138HGpJ(z);
                return;
            }
            return;
        }
        if (z2 || !this.f2824IVlxe) {
            m3178mByQ(z);
        }
    }

    /* renamed from: SmIWf */
    public void m3154SmIWf(boolean z) {
        m3153SOS(z, false);
    }

    /* renamed from: SwgkN */
    public final void m3155SwgkN() {
        if (this.f2858diqgf == null || !this.f2839Pq || TextUtils.isEmpty(this.f2823IEE)) {
            return;
        }
        this.f2858diqgf.setText(this.f2823IEE);
        AbstractC2614P8.m9950mjFkc(this.f2868mjFkc, this.f2863huTpC);
        this.f2858diqgf.setVisibility(0);
        this.f2858diqgf.bringToFront();
        announceForAccessibility(this.f2823IEE);
    }

    /* renamed from: Ucbh */
    public final boolean m3156Ucbh() {
        return this.f2873rWxwaT == 2 && m3173huTpC();
    }

    /* renamed from: VA */
    public final void m3157VA() {
        C2542O1 c2542o1 = this.f2881wJVbdd;
        if (c2542o1 == null) {
            return;
        }
        C2141I6 c2141i6M9833lB = c2542o1.m9833lB();
        C2141I6 c2141i6 = this.f2831KLMXS;
        if (c2141i6M9833lB != c2141i6) {
            this.f2881wJVbdd.setShapeAppearanceModel(c2141i6);
        }
        if (m3156Ucbh()) {
            this.f2881wJVbdd.m9823XV(this.f2836NPj, this.f2855aqHPIZ);
        }
        int iM3181qGY = m3181qGY();
        this.f2850WrLQs = iM3181qGY;
        this.f2881wJVbdd.m9841uHVRx(ColorStateList.valueOf(iM3181qGY));
        m3146MiMN();
        m3193xROA();
    }

    /* renamed from: Vdz */
    public final void m3158Vdz(Rect rect) {
        C2542O1 c2542o1 = this.f2817CqaNbM;
        if (c2542o1 != null) {
            int i = rect.bottom;
            c2542o1.setBounds(rect.left, i - this.f2878vadzgd, rect.right, i);
        }
        C2542O1 c2542o12 = this.f2884xrEuO;
        if (c2542o12 != null) {
            int i2 = rect.bottom;
            c2542o12.setBounds(rect.left, i2 - this.f2870oCFDzJ, rect.right, i2);
        }
    }

    /* renamed from: Vnb */
    public boolean m3159Vnb() {
        return this.f2818Dt.m9076BAnRFn();
    }

    /* renamed from: VocHEe */
    public final boolean m3160VocHEe() {
        return this.f2848VocHEe && !TextUtils.isEmpty(this.f2816BAnRFn) && (this.f2881wJVbdd instanceof AbstractC1987FoPRDo);
    }

    /* renamed from: WGXroI */
    public boolean m3161WGXroI() {
        return this.f2818Dt.m9092VA();
    }

    /* renamed from: WrLQs */
    public final void m3162WrLQs() {
        m3184rkYL();
        m3193xROA();
        m3188tjSezt();
        m3141JBhc();
        m3134Dt();
        if (this.f2873rWxwaT != 0) {
            m3147Moer();
        }
        m3144JrJO();
    }

    /* renamed from: XV */
    public final boolean m3163XV() {
        return (this.f2880wA.m3229OjSQV() || ((this.f2880wA.m3268vI() && m3166cMLeY()) || this.f2880wA.m3253huTpC() != null)) && this.f2880wA.getMeasuredWidth() > 0;
    }

    /* renamed from: YoKzxo */
    public final void m3164YoKzxo(RectF rectF) {
        float f = rectF.left;
        int i = this.f2857cMLeY;
        rectF.left = f - i;
        rectF.right += i;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f2868mjFkc.addView(view, layoutParams2);
        this.f2868mjFkc.setLayoutParams(layoutParams);
        m3147Moer();
        setEditText((EditText) view);
    }

    /* renamed from: bbzow */
    public final boolean m3165bbzow() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f2815AZxh.getMeasuredWidth() > 0;
    }

    /* renamed from: cMLeY */
    public boolean m3166cMLeY() {
        return this.f2880wA.m3258mByQ();
    }

    /* renamed from: diqgf */
    public final Rect m3167diqgf(Rect rect) {
        if (this.f2853ZfxDd == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f2820GMIER;
        float fM7906huTpC = this.f2834Moer.m7906huTpC();
        rect2.left = rect.left + this.f2853ZfxDd.getCompoundPaddingLeft();
        rect2.top = m3151Pq(rect, fM7906huTpC);
        rect2.right = rect.right - this.f2853ZfxDd.getCompoundPaddingRight();
        rect2.bottom = m3139IEE(rect, rect2, fM7906huTpC);
        return rect2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.f2853ZfxDd;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.f2830KLFTb != null) {
            boolean z = this.f2865lB;
            this.f2865lB = false;
            CharSequence hint = editText.getHint();
            this.f2853ZfxDd.setHint(this.f2830KLFTb);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.f2853ZfxDd.setHint(hint);
                this.f2865lB = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        viewStructure.setChildCount(this.f2868mjFkc.getChildCount());
        for (int i2 = 0; i2 < this.f2868mjFkc.getChildCount(); i2++) {
            View childAt = this.f2868mjFkc.getChildAt(i2);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i2);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i);
            if (childAt == this.f2853ZfxDd) {
                viewStructureNewChild.setHint(m3171getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.f2862gtIJp = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f2862gtIJp = false;
    }

    /* renamed from: dm */
    public final void m3168dm() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f2874rkYL;
        if (textView != null) {
            m3179nxI(textView, this.f2833MiMN ? this.f2871qGY : this.f2861fehf);
            if (!this.f2833MiMN && (colorStateList2 = this.f2822HGpJ) != null) {
                this.f2874rkYL.setTextColor(colorStateList2);
            }
            if (!this.f2833MiMN || (colorStateList = this.f2877vI) == null) {
                return;
            }
            this.f2874rkYL.setTextColor(colorStateList);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        m3192wJVbdd(canvas);
        m3176lB(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f2835NKyg) {
            return;
        }
        this.f2835NKyg = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        C1786CqAnRZ c1786CqAnRZ = this.f2834Moer;
        boolean zM7891Vdz = c1786CqAnRZ != null ? c1786CqAnRZ.m7891Vdz(drawableState) : false;
        if (this.f2853ZfxDd != null) {
            m3154SmIWf(AbstractC2876T9.m10287rWxwaT(this) && isEnabled());
        }
        m3191vjlshU();
        m3188tjSezt();
        if (zM7891Vdz) {
            invalidate();
        }
        this.f2835NKyg = false;
    }

    /* renamed from: eyqo */
    public final int m3169eyqo() {
        float fM7905fehf;
        if (!this.f2848VocHEe) {
            return 0;
        }
        int i = this.f2873rWxwaT;
        if (i == 0) {
            fM7905fehf = this.f2834Moer.m7905fehf();
        } else {
            if (i != 2) {
                return 0;
            }
            fM7905fehf = this.f2834Moer.m7905fehf() / 2.0f;
        }
        return (int) fM7905fehf;
    }

    /* renamed from: fehf */
    public final Rect m3170fehf(Rect rect) {
        if (this.f2853ZfxDd == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f2820GMIER;
        boolean zM13503KLFTb = AbstractC4557sa.m13503KLFTb(this);
        rect2.bottom = rect.bottom;
        int i = this.f2873rWxwaT;
        if (i == 1) {
            rect2.left = m3133CqaNbM(rect.left, zM13503KLFTb);
            rect2.top = rect.top + this.f2847Vnb;
            rect2.right = m3194xrEuO(rect.right, zM13503KLFTb);
            return rect2;
        }
        if (i != 2) {
            rect2.left = m3133CqaNbM(rect.left, zM13503KLFTb);
            rect2.top = getPaddingTop();
            rect2.right = m3194xrEuO(rect.right, zM13503KLFTb);
            return rect2;
        }
        rect2.left = rect.left + this.f2853ZfxDd.getPaddingLeft();
        rect2.top = rect.top - m3169eyqo();
        rect2.right = rect.right - this.f2853ZfxDd.getPaddingRight();
        return rect2;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f2853ZfxDd;
        return editText != null ? editText.getBaseline() + getPaddingTop() + m3169eyqo() : super.getBaseline();
    }

    public C2542O1 getBoxBackground() {
        int i = this.f2873rWxwaT;
        if (i == 1 || i == 2) {
            return this.f2881wJVbdd;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f2850WrLQs;
    }

    public int getBoxBackgroundMode() {
        return this.f2873rWxwaT;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.f2847Vnb;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return AbstractC4557sa.m13503KLFTb(this) ? this.f2831KLMXS.m8664Dt().mo9185mjFkc(this.f2876uHVRx) : this.f2831KLMXS.m8671VA().mo9185mjFkc(this.f2876uHVRx);
    }

    public float getBoxCornerRadiusBottomStart() {
        return AbstractC4557sa.m13503KLFTb(this) ? this.f2831KLMXS.m8671VA().mo9185mjFkc(this.f2876uHVRx) : this.f2831KLMXS.m8664Dt().mo9185mjFkc(this.f2876uHVRx);
    }

    public float getBoxCornerRadiusTopEnd() {
        return AbstractC4557sa.m13503KLFTb(this) ? this.f2831KLMXS.m8668IEE().mo9185mjFkc(this.f2876uHVRx) : this.f2831KLMXS.m8673diqgf().mo9185mjFkc(this.f2876uHVRx);
    }

    public float getBoxCornerRadiusTopStart() {
        return AbstractC4557sa.m13503KLFTb(this) ? this.f2831KLMXS.m8673diqgf().mo9185mjFkc(this.f2876uHVRx) : this.f2831KLMXS.m8668IEE().mo9185mjFkc(this.f2876uHVRx);
    }

    public int getBoxStrokeColor() {
        return this.f2814ANMGZc;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f2854alEkx;
    }

    public int getBoxStrokeWidth() {
        return this.f2878vadzgd;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f2870oCFDzJ;
    }

    public int getCounterMaxLength() {
        return this.f2845VA;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f2819ETF && this.f2833MiMN && (textView = this.f2874rkYL) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f2877vI;
    }

    public ColorStateList getCounterTextColor() {
        return this.f2822HGpJ;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f2843SwgkN;
    }

    public EditText getEditText() {
        return this.f2853ZfxDd;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f2880wA.m3236VA();
    }

    public Drawable getEndIconDrawable() {
        return this.f2880wA.m3243YoKzxo();
    }

    public int getEndIconMinSize() {
        return this.f2880wA.m3264rkYL();
    }

    public int getEndIconMode() {
        return this.f2880wA.m3261qGY();
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f2880wA.m3251fehf();
    }

    public CheckableImageButton getEndIconView() {
        return this.f2880wA.m3216IEE();
    }

    public CharSequence getError() {
        if (this.f2818Dt.m9094VocHEe()) {
            return this.f2818Dt.m9107qGY();
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f2818Dt.m9096YoKzxo();
    }

    public CharSequence getErrorContentDescription() {
        return this.f2818Dt.m9110rkYL();
    }

    public int getErrorCurrentTextColors() {
        return this.f2818Dt.m9101fehf();
    }

    public Drawable getErrorIconDrawable() {
        return this.f2880wA.m3230Pq();
    }

    public CharSequence getHelperText() {
        if (this.f2818Dt.m9076BAnRFn()) {
            return this.f2818Dt.m9090Pq();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f2818Dt.m9100eyqo();
    }

    /* renamed from: getHint */
    public CharSequence m3171getHint() {
        if (this.f2848VocHEe) {
            return this.f2816BAnRFn;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.f2834Moer.m7905fehf();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.f2834Moer.m7902diqgf();
    }

    public ColorStateList getHintTextColor() {
        return this.f2825JBhc;
    }

    public InterfaceC0284JHa getLengthCounter() {
        return this.f2852YoKzxo;
    }

    public int getMaxEms() {
        return this.f2882xJ;
    }

    public int getMaxWidth() {
        return this.f2872qdMbNW;
    }

    public int getMinEms() {
        return this.f2826JHa;
    }

    public int getMinWidth() {
        return this.f2866lgHUyS;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f2880wA.m3250eyqo();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f2880wA.m3235Ucbh();
    }

    public CharSequence getPlaceholderText() {
        if (this.f2839Pq) {
            return this.f2823IEE;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f2844Ucbh;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f2860eyqo;
    }

    public CharSequence getPrefixText() {
        return this.f2815AZxh.m12204mjFkc();
    }

    public ColorStateList getPrefixTextColor() {
        return this.f2815AZxh.m12183AZxh();
    }

    public TextView getPrefixTextView() {
        return this.f2815AZxh.m12209wA();
    }

    public C2141I6 getShapeAppearanceModel() {
        return this.f2831KLMXS;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f2815AZxh.m12198ZfxDd();
    }

    public Drawable getStartIconDrawable() {
        return this.f2815AZxh.m12191KLFTb();
    }

    public int getStartIconMinSize() {
        return this.f2815AZxh.m12190JHa();
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f2815AZxh.m12210xJ();
    }

    public CharSequence getSuffixText() {
        return this.f2880wA.m3253huTpC();
    }

    public ColorStateList getSuffixTextColor() {
        return this.f2880wA.m3214Gd();
    }

    public TextView getSuffixTextView() {
        return this.f2880wA.m3215HGpJ();
    }

    public Typeface getTypeface() {
        return this.f2828JYn;
    }

    /* renamed from: gtIJp */
    public final void m3172gtIJp(Editable editable) {
        if (this.f2852YoKzxo.mo3197mjFkc(editable) != 0 || this.f2824IVlxe) {
            m3196zvd();
        } else {
            m3155SwgkN();
        }
    }

    /* renamed from: huTpC */
    public final boolean m3173huTpC() {
        return this.f2836NPj > -1 && this.f2855aqHPIZ != 0;
    }

    /* renamed from: jm */
    public final void m3174jm() {
        if (this.f2874rkYL != null) {
            EditText editText = this.f2853ZfxDd;
            m3131ANMGZc(editText == null ? null : editText.getText());
        }
    }

    /* renamed from: kism */
    public final void m3175kism(boolean z, boolean z2) {
        int defaultColor = this.f2854alEkx.getDefaultColor();
        int colorForState = this.f2854alEkx.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f2854alEkx.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.f2855aqHPIZ = colorForState2;
        } else if (z2) {
            this.f2855aqHPIZ = colorForState;
        } else {
            this.f2855aqHPIZ = defaultColor;
        }
    }

    /* renamed from: lB */
    public final void m3176lB(Canvas canvas) {
        C2542O1 c2542o1;
        if (this.f2884xrEuO == null || (c2542o1 = this.f2817CqaNbM) == null) {
            return;
        }
        c2542o1.draw(canvas);
        if (this.f2853ZfxDd.isFocused()) {
            Rect bounds = this.f2884xrEuO.getBounds();
            Rect bounds2 = this.f2817CqaNbM.getBounds();
            float fM7873Gd = this.f2834Moer.m7873Gd();
            int iCenterX = bounds2.centerX();
            bounds.left = AbstractC2506NPj.m9657wA(iCenterX, bounds2.left, fM7873Gd);
            bounds.right = AbstractC2506NPj.m9657wA(iCenterX, bounds2.right, fM7873Gd);
            this.f2884xrEuO.draw(canvas);
        }
    }

    /* renamed from: lgHUyS */
    public void m3177lgHUyS(InterfaceC0290xJ interfaceC0290xJ) {
        this.f2869nxI.add(interfaceC0290xJ);
        if (this.f2853ZfxDd != null) {
            interfaceC0290xJ.mo3201mjFkc(this);
        }
    }

    /* renamed from: mByQ */
    public final void m3178mByQ(boolean z) {
        ValueAnimator valueAnimator = this.f2840Qr;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f2840Qr.cancel();
        }
        if (z && this.f2841SOS) {
            m3135ETF(0.0f);
        } else {
            this.f2834Moer.m7901bbzow(0.0f);
        }
        if (m3160VocHEe() && ((AbstractC1987FoPRDo) this.f2881wJVbdd).m8328yfx()) {
            m3137Gd();
        }
        this.f2824IVlxe = true;
        m3196zvd();
        this.f2815AZxh.m12186ETF(true);
        this.f2880wA.m3228Ne(true);
    }

    /* renamed from: nxI */
    public void m3179nxI(TextView textView, int i) {
        try {
            AbstractC4065l8.m12662MiMN(textView, i);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        AbstractC4065l8.m12662MiMN(textView, AbstractC2737R4.f10363AZxh);
        textView.setTextColor(AbstractC4294ofHOBL.m12996mjFkc(getContext(), AbstractC3995k4.f14446mjFkc));
    }

    /* renamed from: oCFDzJ */
    public final boolean m3180oCFDzJ() {
        return this.f2873rWxwaT == 1 && this.f2853ZfxDd.getMinLines() <= 1;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f2834Moer.m7869CqaNbM(configuration);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.f2853ZfxDd;
        if (editText != null) {
            Rect rect = this.f2832KRTLGT;
            AbstractC1942FBR.m8270mjFkc(this, editText, rect);
            m3158Vdz(rect);
            if (this.f2848VocHEe) {
                this.f2834Moer.m7894WGXroI(this.f2853ZfxDd.getTextSize());
                int gravity = this.f2853ZfxDd.getGravity();
                this.f2834Moer.m7895WrLQs((gravity & (-113)) | 48);
                this.f2834Moer.m7910nxI(gravity);
                this.f2834Moer.m7885NPj(m3170fehf(rect));
                this.f2834Moer.m7879JYn(m3167diqgf(rect));
                this.f2834Moer.m7882KLMXS();
                if (!m3160VocHEe() || this.f2824IVlxe) {
                    return;
                }
                m3145KRTLGT();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        boolean zM3140IVlxe = m3140IVlxe();
        boolean zM3195yfx = m3195yfx();
        if (zM3140IVlxe || zM3195yfx) {
            this.f2853ZfxDd.post(new RunnableC0289wA());
        }
        m3152Qr();
        this.f2880wA.m3266tjSezt();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0287lgHUyS)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0287lgHUyS c0287lgHUyS = (C0287lgHUyS) parcelable;
        super.onRestoreInstanceState(c0287lgHUyS.m13824mjFkc());
        setError(c0287lgHUyS.f2892wA);
        if (c0287lgHUyS.f2891ZfxDd) {
            post(new RunnableC0283AZxh());
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z = i == 1;
        if (z != this.f2886zvd) {
            float fMo9185mjFkc = this.f2831KLMXS.m8668IEE().mo9185mjFkc(this.f2876uHVRx);
            float fMo9185mjFkc2 = this.f2831KLMXS.m8673diqgf().mo9185mjFkc(this.f2876uHVRx);
            C2141I6 c2141i6M8698MiMN = C2141I6.m8661mjFkc().m8711vI(this.f2831KLMXS.m8669Pq()).m8712wJVbdd(this.f2831KLMXS.m8675fehf()).m8697IEE(this.f2831KLMXS.m8665ETF()).m8701Ucbh(this.f2831KLMXS.m8679qdMbNW()).m8702VocHEe(fMo9185mjFkc2).m8708mByQ(fMo9185mjFkc).m8700Pq(this.f2831KLMXS.m8671VA().mo9185mjFkc(this.f2876uHVRx)).m8706huTpC(this.f2831KLMXS.m8664Dt().mo9185mjFkc(this.f2876uHVRx)).m8698MiMN();
            this.f2886zvd = z;
            setShapeAppearanceModel(c2141i6M8698MiMN);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        C0287lgHUyS c0287lgHUyS = new C0287lgHUyS(super.onSaveInstanceState());
        if (m3161WGXroI()) {
            c0287lgHUyS.f2892wA = getError();
        }
        c0287lgHUyS.f2891ZfxDd = this.f2880wA.m3271wJVbdd();
        return c0287lgHUyS;
    }

    /* renamed from: qGY */
    public final int m3181qGY() {
        return this.f2873rWxwaT == 1 ? AbstractC2345L1.m9304lgHUyS(AbstractC2345L1.m9302KLFTb(this, AbstractC3800h4.f13945lgHUyS, 0), this.f2850WrLQs) : this.f2850WrLQs;
    }

    /* renamed from: qdMbNW */
    public final void m3182qdMbNW() {
        TextView textView = this.f2858diqgf;
        if (textView != null) {
            this.f2868mjFkc.addView(textView);
            this.f2858diqgf.setVisibility(0);
        }
    }

    /* renamed from: rWxwaT */
    public boolean m3183rWxwaT() {
        return this.f2818Dt.m9094VocHEe();
    }

    /* renamed from: rkYL */
    public final void m3184rkYL() {
        int i = this.f2873rWxwaT;
        if (i == 0) {
            this.f2881wJVbdd = null;
            this.f2817CqaNbM = null;
            this.f2884xrEuO = null;
            return;
        }
        if (i == 1) {
            this.f2881wJVbdd = new C2542O1(this.f2831KLMXS);
            this.f2817CqaNbM = new C2542O1();
            this.f2884xrEuO = new C2542O1();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(this.f2873rWxwaT + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.f2848VocHEe || (this.f2881wJVbdd instanceof AbstractC1987FoPRDo)) {
                this.f2881wJVbdd = new C2542O1(this.f2831KLMXS);
            } else {
                this.f2881wJVbdd = AbstractC1987FoPRDo.m8324tQ(this.f2831KLMXS);
            }
            this.f2817CqaNbM = null;
            this.f2884xrEuO = null;
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.f2850WrLQs != i) {
            this.f2850WrLQs = i;
            this.f2859dm = i;
            this.f2885yfx = i;
            this.f2879vjlshU = i;
            m3157VA();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(AbstractC4294ofHOBL.m12996mjFkc(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f2859dm = defaultColor;
        this.f2850WrLQs = defaultColor;
        this.f2875tQ = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f2885yfx = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f2879vjlshU = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        m3157VA();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.f2873rWxwaT) {
            return;
        }
        this.f2873rWxwaT = i;
        if (this.f2853ZfxDd != null) {
            m3162WrLQs();
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.f2847Vnb = i;
    }

    public void setBoxCornerFamily(int i) {
        this.f2831KLMXS = this.f2831KLMXS.m8670Ucbh().m8696HGpJ(i, this.f2831KLMXS.m8668IEE()).m8707lB(i, this.f2831KLMXS.m8673diqgf()).m8705fehf(i, this.f2831KLMXS.m8664Dt()).m8704eyqo(i, this.f2831KLMXS.m8671VA()).m8698MiMN();
        m3157VA();
    }

    public void setBoxStrokeColor(int i) {
        if (this.f2814ANMGZc != i) {
            this.f2814ANMGZc = i;
            m3188tjSezt();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f2846Vdz = colorStateList.getDefaultColor();
            this.f2883xROA = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f2864jm = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f2814ANMGZc = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f2814ANMGZc != colorStateList.getDefaultColor()) {
            this.f2814ANMGZc = colorStateList.getDefaultColor();
        }
        m3188tjSezt();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f2854alEkx != colorStateList) {
            this.f2854alEkx = colorStateList;
            m3188tjSezt();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.f2878vadzgd = i;
        m3188tjSezt();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.f2870oCFDzJ = i;
        m3188tjSezt();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.f2819ETF != z) {
            if (z) {
                C2463Moer c2463Moer = new C2463Moer(getContext());
                this.f2874rkYL = c2463Moer;
                c2463Moer.setId(AbstractC1803D4.f7825xrEuO);
                Typeface typeface = this.f2828JYn;
                if (typeface != null) {
                    this.f2874rkYL.setTypeface(typeface);
                }
                this.f2874rkYL.setMaxLines(1);
                this.f2818Dt.m9084KLFTb(this.f2874rkYL, 2);
                AbstractC1599A1.m7547ZfxDd((ViewGroup.MarginLayoutParams) this.f2874rkYL.getLayoutParams(), getResources().getDimensionPixelOffset(AbstractC4191n4.f15326WrLQs));
                m3168dm();
                m3174jm();
            } else {
                this.f2818Dt.m9103lB(this.f2874rkYL, 2);
                this.f2874rkYL = null;
            }
            this.f2819ETF = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.f2845VA != i) {
            if (i > 0) {
                this.f2845VA = i;
            } else {
                this.f2845VA = -1;
            }
            if (this.f2819ETF) {
                m3174jm();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.f2871qGY != i) {
            this.f2871qGY = i;
            m3168dm();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f2877vI != colorStateList) {
            this.f2877vI = colorStateList;
            m3168dm();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.f2861fehf != i) {
            this.f2861fehf = i;
            m3168dm();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f2822HGpJ != colorStateList) {
            this.f2822HGpJ = colorStateList;
            m3168dm();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f2843SwgkN = colorStateList;
        this.f2825JBhc = colorStateList;
        if (this.f2853ZfxDd != null) {
            m3154SmIWf(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        m3128uHVRx(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.f2880wA.m3263rWxwaT(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.f2880wA.m3238Vnb(z);
    }

    public void setEndIconContentDescription(int i) {
        this.f2880wA.m3227NPj(i);
    }

    public void setEndIconDrawable(int i) {
        this.f2880wA.m3260oCFDzJ(i);
    }

    public void setEndIconMinSize(int i) {
        this.f2880wA.m3241WrLQs(i);
    }

    public void setEndIconMode(int i) {
        this.f2880wA.m3223KRTLGT(i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        this.f2880wA.m3213GMIER(onClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f2880wA.m3267uHVRx(onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        this.f2880wA.m3220JYn(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        this.f2880wA.m3219JYgkl(colorStateList);
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        this.f2880wA.m3221JrJO(mode);
    }

    public void setEndIconVisible(boolean z) {
        this.f2880wA.m3259nxI(z);
    }

    public void setError(CharSequence charSequence) {
        if (!this.f2818Dt.m9094VocHEe()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f2818Dt.m9102huTpC();
        } else {
            this.f2818Dt.m9106oCFDzJ(charSequence);
        }
    }

    public void setErrorAccessibilityLiveRegion(int i) {
        this.f2818Dt.m9105mByQ(i);
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f2818Dt.m9089OjSQV(charSequence);
    }

    public void setErrorEnabled(boolean z) {
        this.f2818Dt.m9088Ne(z);
    }

    public void setErrorIconDrawable(int i) {
        this.f2880wA.m3240WGXroI(i);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        this.f2880wA.m3246bbzow(onClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f2880wA.m3234SwgkN(onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.f2880wA.m3218JBhc(colorStateList);
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        this.f2880wA.m3237Vdz(mode);
    }

    public void setErrorTextAppearance(int i) {
        this.f2818Dt.m9077CqaNbM(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f2818Dt.m9115xrEuO(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.f2842SmIWf != z) {
            this.f2842SmIWf = z;
            m3154SmIWf(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (m3159Vnb()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!m3159Vnb()) {
                setHelperTextEnabled(true);
            }
            this.f2818Dt.m9097aqHPIZ(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f2818Dt.m9098cMLeY(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.f2818Dt.m9116zvd(z);
    }

    public void setHelperTextTextAppearance(int i) {
        this.f2818Dt.m9085KLMXS(i);
    }

    /* renamed from: setHint */
    public void m3186setHint(CharSequence charSequence) {
        if (this.f2848VocHEe) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.f2841SOS = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f2848VocHEe) {
            this.f2848VocHEe = z;
            if (z) {
                CharSequence hint = this.f2853ZfxDd.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f2816BAnRFn)) {
                        m3186setHint(hint);
                    }
                    this.f2853ZfxDd.setHint((CharSequence) null);
                }
                this.f2865lB = true;
            } else {
                this.f2865lB = false;
                if (!TextUtils.isEmpty(this.f2816BAnRFn) && TextUtils.isEmpty(this.f2853ZfxDd.getHint())) {
                    this.f2853ZfxDd.setHint(this.f2816BAnRFn);
                }
                setHintInternal(null);
            }
            if (this.f2853ZfxDd != null) {
                m3147Moer();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.f2834Moer.m7918vadzgd(i);
        this.f2825JBhc = this.f2834Moer.m7912qGY();
        if (this.f2853ZfxDd != null) {
            m3154SmIWf(false);
            m3147Moer();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f2825JBhc != colorStateList) {
            if (this.f2843SwgkN == null) {
                this.f2834Moer.m7900aqHPIZ(colorStateList);
            }
            this.f2825JBhc = colorStateList;
            if (this.f2853ZfxDd != null) {
                m3154SmIWf(false);
            }
        }
    }

    public void setLengthCounter(InterfaceC0284JHa interfaceC0284JHa) {
        this.f2852YoKzxo = interfaceC0284JHa;
    }

    public void setMaxEms(int i) {
        this.f2882xJ = i;
        EditText editText = this.f2853ZfxDd;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxEms(i);
    }

    public void setMaxWidth(int i) {
        this.f2872qdMbNW = i;
        EditText editText = this.f2853ZfxDd;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.f2826JHa = i;
        EditText editText = this.f2853ZfxDd;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinEms(i);
    }

    public void setMinWidth(int i) {
        this.f2866lgHUyS = i;
        EditText editText = this.f2853ZfxDd;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinWidth(i);
    }

    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        this.f2880wA.m3208ANMGZc(i);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        this.f2880wA.m3249dm(i);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        this.f2880wA.m3276yfx(z);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f2880wA.m3270vjlshU(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f2880wA.m3273xROA(mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f2858diqgf == null) {
            C2463Moer c2463Moer = new C2463Moer(getContext());
            this.f2858diqgf = c2463Moer;
            c2463Moer.setId(AbstractC1803D4.f7808cMLeY);
            AbstractC2876T9.m10244NKyg(this.f2858diqgf, 2);
            C2951UKTt c2951UKTtM3189vI = m3189vI();
            this.f2863huTpC = c2951UKTtM3189vI;
            c2951UKTtM3189vI.mo9614XV(67L);
            this.f2821Gd = m3189vI();
            setPlaceholderTextAppearance(this.f2844Ucbh);
            setPlaceholderTextColor(this.f2860eyqo);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f2839Pq) {
                setPlaceholderTextEnabled(true);
            }
            this.f2823IEE = charSequence;
        }
        m3148NKyg();
    }

    public void setPlaceholderTextAppearance(int i) {
        this.f2844Ucbh = i;
        TextView textView = this.f2858diqgf;
        if (textView != null) {
            AbstractC4065l8.m12662MiMN(textView, i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f2860eyqo != colorStateList) {
            this.f2860eyqo = colorStateList;
            TextView textView = this.f2858diqgf;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f2815AZxh.m12192MiMN(charSequence);
    }

    public void setPrefixTextAppearance(int i) {
        this.f2815AZxh.m12197YoKzxo(i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f2815AZxh.m12207rkYL(colorStateList);
    }

    public void setShapeAppearanceModel(C2141I6 c2141i6) {
        C2542O1 c2542o1 = this.f2881wJVbdd;
        if (c2542o1 == null || c2542o1.m9833lB() == c2141i6) {
            return;
        }
        this.f2831KLMXS = c2141i6;
        m3157VA();
    }

    public void setStartIconCheckable(boolean z) {
        this.f2815AZxh.m12205qGY(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? AbstractC4768vjlshU.m13794AZxh(getContext(), i) : null);
    }

    public void setStartIconMinSize(int i) {
        this.f2815AZxh.m12193Pq(i);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        this.f2815AZxh.m12199diqgf(onClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f2815AZxh.m12200eyqo(onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        this.f2815AZxh.m12194Ucbh(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        this.f2815AZxh.m12202huTpC(colorStateList);
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        this.f2815AZxh.m12187Gd(mode);
    }

    public void setStartIconVisible(boolean z) {
        this.f2815AZxh.m12188HGpJ(z);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f2880wA.m3217IVlxe(charSequence);
    }

    public void setSuffixTextAppearance(int i) {
        this.f2880wA.m3225Moer(i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f2880wA.m3233SmIWf(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(C0285KLFTb c0285KLFTb) {
        EditText editText = this.f2853ZfxDd;
        if (editText != null) {
            AbstractC2876T9.m10265alEkx(editText, c0285KLFTb);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f2828JYn) {
            this.f2828JYn = typeface;
            this.f2834Moer.m7899alEkx(typeface);
            this.f2818Dt.m9093Vnb(typeface);
            TextView textView = this.f2874rkYL;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    /* renamed from: tQ */
    public final void m3187tQ(boolean z) {
        ColorStateList colorStateListM9301JHa = AbstractC2345L1.m9301JHa(getContext(), AbstractC3800h4.f13952wA);
        EditText editText = this.f2853ZfxDd;
        if (editText == null || editText.getTextCursorDrawable() == null || colorStateListM9301JHa == null) {
            return;
        }
        Drawable textCursorDrawable = this.f2853ZfxDd.getTextCursorDrawable();
        if (z) {
            ColorStateList colorStateList = this.f2854alEkx;
            colorStateListM9301JHa = colorStateList != null ? colorStateList : ColorStateList.valueOf(this.f2855aqHPIZ);
        }
        AbstractC4332pCk.m13081qdMbNW(textCursorDrawable, colorStateListM9301JHa);
    }

    /* renamed from: tjSezt */
    public void m3188tjSezt() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.f2881wJVbdd == null || this.f2873rWxwaT == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.f2853ZfxDd) != null && editText2.hasFocus());
        boolean z3 = isHovered() || ((editText = this.f2853ZfxDd) != null && editText.isHovered());
        if (m3161WGXroI() || (this.f2874rkYL != null && this.f2833MiMN)) {
            z = true;
        }
        if (!isEnabled()) {
            this.f2855aqHPIZ = this.f2883xROA;
        } else if (m3161WGXroI()) {
            if (this.f2854alEkx != null) {
                m3175kism(z2, z3);
            } else {
                this.f2855aqHPIZ = getErrorCurrentTextColors();
            }
        } else if (!this.f2833MiMN || (textView = this.f2874rkYL) == null) {
            if (z2) {
                this.f2855aqHPIZ = this.f2814ANMGZc;
            } else if (z3) {
                this.f2855aqHPIZ = this.f2864jm;
            } else {
                this.f2855aqHPIZ = this.f2846Vdz;
            }
        } else if (this.f2854alEkx != null) {
            m3175kism(z2, z3);
        } else {
            this.f2855aqHPIZ = textView.getCurrentTextColor();
        }
        m3187tQ(z);
        this.f2880wA.m3210CqaNbM();
        m3143JYn();
        if (this.f2873rWxwaT == 2) {
            int i = this.f2836NPj;
            if (z2 && isEnabled()) {
                this.f2836NPj = this.f2870oCFDzJ;
            } else {
                this.f2836NPj = this.f2878vadzgd;
            }
            if (this.f2836NPj != i) {
                m3136GMIER();
            }
        }
        if (this.f2873rWxwaT == 1) {
            if (!isEnabled()) {
                this.f2850WrLQs = this.f2875tQ;
            } else if (z3 && !z2) {
                this.f2850WrLQs = this.f2879vjlshU;
            } else if (z2) {
                this.f2850WrLQs = this.f2885yfx;
            } else {
                this.f2850WrLQs = this.f2859dm;
            }
        }
        m3157VA();
    }

    /* renamed from: vI */
    public final C2951UKTt m3189vI() {
        C2951UKTt c2951UKTt = new C2951UKTt();
        c2951UKTt.mo9601JYn(AbstractC4923y2.m13983JHa(getContext(), AbstractC3800h4.f13925Gd, 87));
        c2951UKTt.mo9602JrJO(AbstractC4923y2.m13988xJ(getContext(), AbstractC3800h4.f13944lB, AbstractC2506NPj.f9739mjFkc));
        return c2951UKTt;
    }

    /* renamed from: vadzgd */
    public boolean m3190vadzgd() {
        return this.f2865lB;
    }

    /* renamed from: vjlshU */
    public void m3191vjlshU() {
        Drawable background;
        TextView textView;
        EditText editText = this.f2853ZfxDd;
        if (editText == null || this.f2873rWxwaT != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (AbstractC3397awnh.m11434mjFkc(background)) {
            background = background.mutate();
        }
        if (m3161WGXroI()) {
            background.setColorFilter(C3442bbzow.m11534ZfxDd(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f2833MiMN && (textView = this.f2874rkYL) != null) {
            background.setColorFilter(C3442bbzow.m11534ZfxDd(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            AbstractC4332pCk.m13080mjFkc(background);
            this.f2853ZfxDd.refreshDrawableState();
        }
    }

    /* renamed from: wJVbdd */
    public final void m3192wJVbdd(Canvas canvas) {
        if (this.f2848VocHEe) {
            this.f2834Moer.m7890VA(canvas);
        }
    }

    /* renamed from: xROA */
    public void m3193xROA() {
        EditText editText = this.f2853ZfxDd;
        if (editText == null || this.f2881wJVbdd == null) {
            return;
        }
        if ((this.f2837Ne || editText.getBackground() == null) && this.f2873rWxwaT != 0) {
            AbstractC2876T9.m10294vjlshU(this.f2853ZfxDd, getEditTextBoxBackground());
            this.f2837Ne = true;
        }
    }

    /* renamed from: xrEuO */
    public final int m3194xrEuO(int i, boolean z) {
        int compoundPaddingRight = i - this.f2853ZfxDd.getCompoundPaddingRight();
        return (getPrefixText() == null || !z) ? compoundPaddingRight : compoundPaddingRight + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
    }

    /* renamed from: yfx */
    public boolean m3195yfx() {
        boolean z;
        if (this.f2853ZfxDd == null) {
            return false;
        }
        boolean z2 = true;
        if (m3165bbzow()) {
            int measuredWidth = this.f2815AZxh.getMeasuredWidth() - this.f2853ZfxDd.getPaddingLeft();
            if (this.f2827JYgkl == null || this.f2829JrJO != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f2827JYgkl = colorDrawable;
                this.f2829JrJO = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] drawableArrM12667mjFkc = AbstractC4065l8.m12667mjFkc(this.f2853ZfxDd);
            Drawable drawable = drawableArrM12667mjFkc[0];
            Drawable drawable2 = this.f2827JYgkl;
            if (drawable != drawable2) {
                AbstractC4065l8.m12666lgHUyS(this.f2853ZfxDd, drawable2, drawableArrM12667mjFkc[1], drawableArrM12667mjFkc[2], drawableArrM12667mjFkc[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.f2827JYgkl != null) {
                Drawable[] drawableArrM12667mjFkc2 = AbstractC4065l8.m12667mjFkc(this.f2853ZfxDd);
                AbstractC4065l8.m12666lgHUyS(this.f2853ZfxDd, null, drawableArrM12667mjFkc2[1], drawableArrM12667mjFkc2[2], drawableArrM12667mjFkc2[3]);
                this.f2827JYgkl = null;
                z = true;
            }
            z = false;
        }
        if (m3163XV()) {
            int measuredWidth2 = this.f2880wA.m3215HGpJ().getMeasuredWidth() - this.f2853ZfxDd.getPaddingRight();
            CheckableImageButton checkableImageButtonM3212ETF = this.f2880wA.m3212ETF();
            if (checkableImageButtonM3212ETF != null) {
                measuredWidth2 = measuredWidth2 + checkableImageButtonM3212ETF.getMeasuredWidth() + AbstractC1599A1.m7546AZxh((ViewGroup.MarginLayoutParams) checkableImageButtonM3212ETF.getLayoutParams());
            }
            Drawable[] drawableArrM12667mjFkc3 = AbstractC4065l8.m12667mjFkc(this.f2853ZfxDd);
            Drawable drawable3 = this.f2849WGXroI;
            if (drawable3 == null || this.f2851XV == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f2849WGXroI = colorDrawable2;
                    this.f2851XV = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = drawableArrM12667mjFkc3[2];
                Drawable drawable5 = this.f2849WGXroI;
                if (drawable4 != drawable5) {
                    this.f2856bbzow = drawable4;
                    AbstractC4065l8.m12666lgHUyS(this.f2853ZfxDd, drawableArrM12667mjFkc3[0], drawableArrM12667mjFkc3[1], drawable5, drawableArrM12667mjFkc3[3]);
                } else {
                    z2 = z;
                }
            } else {
                this.f2851XV = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                AbstractC4065l8.m12666lgHUyS(this.f2853ZfxDd, drawableArrM12667mjFkc3[0], drawableArrM12667mjFkc3[1], this.f2849WGXroI, drawableArrM12667mjFkc3[3]);
            }
        } else {
            if (this.f2849WGXroI == null) {
                return z;
            }
            Drawable[] drawableArrM12667mjFkc4 = AbstractC4065l8.m12667mjFkc(this.f2853ZfxDd);
            if (drawableArrM12667mjFkc4[2] == this.f2849WGXroI) {
                AbstractC4065l8.m12666lgHUyS(this.f2853ZfxDd, drawableArrM12667mjFkc4[0], drawableArrM12667mjFkc4[1], this.f2856bbzow, drawableArrM12667mjFkc4[3]);
            } else {
                z2 = z;
            }
            this.f2849WGXroI = null;
        }
        return z2;
    }

    /* renamed from: zvd */
    public final void m3196zvd() {
        TextView textView = this.f2858diqgf;
        if (textView == null || !this.f2839Pq) {
            return;
        }
        textView.setText((CharSequence) null);
        AbstractC2614P8.m9950mjFkc(this.f2868mjFkc, this.f2821Gd);
        this.f2858diqgf.setVisibility(4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = f2812kism;
        super(AbstractC2734R1.m10039wA(context, attributeSet, i, i2), attributeSet, i);
        this.f2826JHa = -1;
        this.f2882xJ = -1;
        this.f2866lgHUyS = -1;
        this.f2872qdMbNW = -1;
        this.f2818Dt = new C2276K(this);
        this.f2852YoKzxo = new InterfaceC0284JHa() { // from class: o.b8
            @Override // com.p038google.p039android.material.textfield.TextInputLayout.InterfaceC0284JHa
            /* renamed from: mjFkc */
            public final int mo3197mjFkc(Editable editable) {
                return TextInputLayout.m3126aqHPIZ(editable);
            }
        };
        this.f2832KRTLGT = new Rect();
        this.f2820GMIER = new Rect();
        this.f2876uHVRx = new RectF();
        this.f2869nxI = new LinkedHashSet();
        C1786CqAnRZ c1786CqAnRZ = new C1786CqAnRZ(this);
        this.f2834Moer = c1786CqAnRZ;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f2868mjFkc = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        TimeInterpolator timeInterpolator = AbstractC2506NPj.f9739mjFkc;
        c1786CqAnRZ.m7866ANMGZc(timeInterpolator);
        c1786CqAnRZ.m7876JBhc(timeInterpolator);
        c1786CqAnRZ.m7895WrLQs(8388659);
        C1606A8 c1606a8M12942qdMbNW = AbstractC4260o8.m12942qdMbNW(context2, attributeSet, AbstractC3340a5.f12436OGo, i, i2, AbstractC3340a5.f12517YxdwU, AbstractC3340a5.f12378HPA, AbstractC3340a5.f12353EqDGZ, AbstractC3340a5.f12661tyXzYJ, AbstractC3340a5.f12628pVOu);
        C3803h7 c3803h7 = new C3803h7(this, c1606a8M12942qdMbNW);
        this.f2815AZxh = c3803h7;
        this.f2848VocHEe = c1606a8M12942qdMbNW.m7588mjFkc(AbstractC3340a5.f12683wMV, true);
        m3186setHint(c1606a8M12942qdMbNW.m7591rkYL(AbstractC3340a5.f12610mz));
        this.f2841SOS = c1606a8M12942qdMbNW.m7588mjFkc(AbstractC3340a5.f12528aQ, true);
        this.f2842SmIWf = c1606a8M12942qdMbNW.m7588mjFkc(AbstractC3340a5.f12475UKTt, true);
        if (c1606a8M12942qdMbNW.m7586fehf(AbstractC3340a5.f12670vBFMCS)) {
            setMinEms(c1606a8M12942qdMbNW.m7577Dt(AbstractC3340a5.f12670vBFMCS, -1));
        } else if (c1606a8M12942qdMbNW.m7586fehf(AbstractC3340a5.f12698yRYQP)) {
            setMinWidth(c1606a8M12942qdMbNW.m7579JHa(AbstractC3340a5.f12698yRYQP, -1));
        }
        if (c1606a8M12942qdMbNW.m7586fehf(AbstractC3340a5.f12389Ipwl)) {
            setMaxEms(c1606a8M12942qdMbNW.m7577Dt(AbstractC3340a5.f12389Ipwl, -1));
        } else if (c1606a8M12942qdMbNW.m7586fehf(AbstractC3340a5.f12404Jkjs)) {
            setMaxWidth(c1606a8M12942qdMbNW.m7579JHa(AbstractC3340a5.f12404Jkjs, -1));
        }
        this.f2831KLMXS = C2141I6.m8658KLFTb(context2, attributeSet, i, i2).m8698MiMN();
        this.f2857cMLeY = context2.getResources().getDimensionPixelOffset(AbstractC4191n4.f15345vadzgd);
        this.f2847Vnb = c1606a8M12942qdMbNW.m7580KLFTb(AbstractC3340a5.f12590jxC, 0);
        this.f2878vadzgd = c1606a8M12942qdMbNW.m7579JHa(AbstractC3340a5.f12332CO, context2.getResources().getDimensionPixelSize(AbstractC4191n4.f15339oCFDzJ));
        this.f2870oCFDzJ = c1606a8M12942qdMbNW.m7579JHa(AbstractC3340a5.f12666uhQ, context2.getResources().getDimensionPixelSize(AbstractC4191n4.f15329aqHPIZ));
        this.f2836NPj = this.f2878vadzgd;
        float fM7584ZfxDd = c1606a8M12942qdMbNW.m7584ZfxDd(AbstractC3340a5.f12622ofUPN, -1.0f);
        float fM7584ZfxDd2 = c1606a8M12942qdMbNW.m7584ZfxDd(AbstractC3340a5.f12437ORe, -1.0f);
        float fM7584ZfxDd3 = c1606a8M12942qdMbNW.m7584ZfxDd(AbstractC3340a5.f12547dXmy, -1.0f);
        float fM7584ZfxDd4 = c1606a8M12942qdMbNW.m7584ZfxDd(AbstractC3340a5.f12579jIShy, -1.0f);
        C2141I6.AZxh aZxhM8670Ucbh = this.f2831KLMXS.m8670Ucbh();
        if (fM7584ZfxDd >= 0.0f) {
            aZxhM8670Ucbh.m8702VocHEe(fM7584ZfxDd);
        }
        if (fM7584ZfxDd2 >= 0.0f) {
            aZxhM8670Ucbh.m8708mByQ(fM7584ZfxDd2);
        }
        if (fM7584ZfxDd3 >= 0.0f) {
            aZxhM8670Ucbh.m8706huTpC(fM7584ZfxDd3);
        }
        if (fM7584ZfxDd4 >= 0.0f) {
            aZxhM8670Ucbh.m8700Pq(fM7584ZfxDd4);
        }
        this.f2831KLMXS = aZxhM8670Ucbh.m8698MiMN();
        ColorStateList colorStateListM9573AZxh = AbstractC2478N1.m9573AZxh(context2, c1606a8M12942qdMbNW, AbstractC3340a5.f12525ZxmHEb);
        if (colorStateListM9573AZxh != null) {
            int defaultColor = colorStateListM9573AZxh.getDefaultColor();
            this.f2859dm = defaultColor;
            this.f2850WrLQs = defaultColor;
            if (colorStateListM9573AZxh.isStateful()) {
                this.f2875tQ = colorStateListM9573AZxh.getColorForState(new int[]{-16842910}, -1);
                this.f2885yfx = colorStateListM9573AZxh.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.f2879vjlshU = colorStateListM9573AZxh.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.f2885yfx = this.f2859dm;
                ColorStateList colorStateListM13795mjFkc = AbstractC4768vjlshU.m13795mjFkc(context2, AbstractC3995k4.f14447wA);
                this.f2875tQ = colorStateListM13795mjFkc.getColorForState(new int[]{-16842910}, -1);
                this.f2879vjlshU = colorStateListM13795mjFkc.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.f2850WrLQs = 0;
            this.f2859dm = 0;
            this.f2875tQ = 0;
            this.f2885yfx = 0;
            this.f2879vjlshU = 0;
        }
        if (c1606a8M12942qdMbNW.m7586fehf(AbstractC3340a5.f12366Frh)) {
            ColorStateList colorStateListM7592wA = c1606a8M12942qdMbNW.m7592wA(AbstractC3340a5.f12366Frh);
            this.f2825JBhc = colorStateListM7592wA;
            this.f2843SwgkN = colorStateListM7592wA;
        }
        ColorStateList colorStateListM9573AZxh2 = AbstractC2478N1.m9573AZxh(context2, c1606a8M12942qdMbNW, AbstractC3340a5.f12331CBhInx);
        this.f2814ANMGZc = c1606a8M12942qdMbNW.m7576AZxh(AbstractC3340a5.f12331CBhInx, 0);
        this.f2846Vdz = AbstractC4294ofHOBL.m12996mjFkc(context2, AbstractC3995k4.f14445ZfxDd);
        this.f2883xROA = AbstractC4294ofHOBL.m12996mjFkc(context2, AbstractC3995k4.f14444KLFTb);
        this.f2864jm = AbstractC4294ofHOBL.m12996mjFkc(context2, AbstractC3995k4.f14443JHa);
        if (colorStateListM9573AZxh2 != null) {
            setBoxStrokeColorStateList(colorStateListM9573AZxh2);
        }
        if (c1606a8M12942qdMbNW.m7586fehf(AbstractC3340a5.f12677vdbwS)) {
            setBoxStrokeErrorColor(AbstractC2478N1.m9573AZxh(context2, c1606a8M12942qdMbNW, AbstractC3340a5.f12677vdbwS));
        }
        if (c1606a8M12942qdMbNW.m7581MiMN(AbstractC3340a5.f12628pVOu, -1) != -1) {
            setHintTextAppearance(c1606a8M12942qdMbNW.m7581MiMN(AbstractC3340a5.f12628pVOu, 0));
        }
        int iM7581MiMN = c1606a8M12942qdMbNW.m7581MiMN(AbstractC3340a5.f12353EqDGZ, 0);
        CharSequence charSequenceM7591rkYL = c1606a8M12942qdMbNW.m7591rkYL(AbstractC3340a5.f12481Uj);
        int iM7577Dt = c1606a8M12942qdMbNW.m7577Dt(AbstractC3340a5.f12574iBHnK, 1);
        boolean zM7588mjFkc = c1606a8M12942qdMbNW.m7588mjFkc(AbstractC3340a5.f12356FNhf, false);
        int iM7581MiMN2 = c1606a8M12942qdMbNW.m7581MiMN(AbstractC3340a5.f12661tyXzYJ, 0);
        boolean zM7588mjFkc2 = c1606a8M12942qdMbNW.m7588mjFkc(AbstractC3340a5.f12537bXx, false);
        CharSequence charSequenceM7591rkYL2 = c1606a8M12942qdMbNW.m7591rkYL(AbstractC3340a5.f12422MLqR);
        int iM7581MiMN3 = c1606a8M12942qdMbNW.m7581MiMN(AbstractC3340a5.f12385IRE, 0);
        CharSequence charSequenceM7591rkYL3 = c1606a8M12942qdMbNW.m7591rkYL(AbstractC3340a5.f12608mh);
        boolean zM7588mjFkc3 = c1606a8M12942qdMbNW.m7588mjFkc(AbstractC3340a5.f12662uAgKP, false);
        setCounterMaxLength(c1606a8M12942qdMbNW.m7577Dt(AbstractC3340a5.f12484UmFn, -1));
        this.f2861fehf = c1606a8M12942qdMbNW.m7581MiMN(AbstractC3340a5.f12517YxdwU, 0);
        this.f2871qGY = c1606a8M12942qdMbNW.m7581MiMN(AbstractC3340a5.f12378HPA, 0);
        setBoxBackgroundMode(c1606a8M12942qdMbNW.m7577Dt(AbstractC3340a5.f12606mYYU, 0));
        setErrorContentDescription(charSequenceM7591rkYL);
        setErrorAccessibilityLiveRegion(iM7577Dt);
        setCounterOverflowTextAppearance(this.f2871qGY);
        setHelperTextTextAppearance(iM7581MiMN2);
        setErrorTextAppearance(iM7581MiMN);
        setCounterTextAppearance(this.f2861fehf);
        setPlaceholderText(charSequenceM7591rkYL3);
        setPlaceholderTextAppearance(iM7581MiMN3);
        if (c1606a8M12942qdMbNW.m7586fehf(AbstractC3340a5.f12636qpjZLY)) {
            setErrorTextColor(c1606a8M12942qdMbNW.m7592wA(AbstractC3340a5.f12636qpjZLY));
        }
        if (c1606a8M12942qdMbNW.m7586fehf(AbstractC3340a5.f12485UokA)) {
            setHelperTextColor(c1606a8M12942qdMbNW.m7592wA(AbstractC3340a5.f12485UokA));
        }
        if (c1606a8M12942qdMbNW.m7586fehf(AbstractC3340a5.f12633qMaC)) {
            setHintTextColor(c1606a8M12942qdMbNW.m7592wA(AbstractC3340a5.f12633qMaC));
        }
        if (c1606a8M12942qdMbNW.m7586fehf(AbstractC3340a5.f12430NBXYLM)) {
            setCounterTextColor(c1606a8M12942qdMbNW.m7592wA(AbstractC3340a5.f12430NBXYLM));
        }
        if (c1606a8M12942qdMbNW.m7586fehf(AbstractC3340a5.f12684wfQA)) {
            setCounterOverflowTextColor(c1606a8M12942qdMbNW.m7592wA(AbstractC3340a5.f12684wfQA));
        }
        if (c1606a8M12942qdMbNW.m7586fehf(AbstractC3340a5.f12473Tz)) {
            setPlaceholderTextColor(c1606a8M12942qdMbNW.m7592wA(AbstractC3340a5.f12473Tz));
        }
        C0291mjFkc c0291mjFkc = new C0291mjFkc(this, c1606a8M12942qdMbNW);
        this.f2880wA = c0291mjFkc;
        boolean zM7588mjFkc4 = c1606a8M12942qdMbNW.m7588mjFkc(AbstractC3340a5.f12673vL, true);
        c1606a8M12942qdMbNW.m7585eyqo();
        AbstractC2876T9.m10244NKyg(this, 2);
        AbstractC2876T9.m10278kism(this, 1);
        frameLayout.addView(c3803h7);
        frameLayout.addView(c0291mjFkc);
        addView(frameLayout);
        setEnabled(zM7588mjFkc4);
        setHelperTextEnabled(zM7588mjFkc2);
        setErrorEnabled(zM7588mjFkc);
        setCounterEnabled(zM7588mjFkc3);
        setHelperText(charSequenceM7591rkYL2);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        this.f2880wA.m3269vadzgd(charSequence);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f2880wA.m3245aqHPIZ(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f2880wA.m3242XV(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f2880wA.m3244alEkx(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f2880wA.m3265tQ(drawable);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.f2815AZxh.m12201fehf(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f2815AZxh.m12189IEE(drawable);
    }

    /* renamed from: setHint */
    public void m3185setHint(int i) {
        m3186setHint(i != 0 ? getResources().getText(i) : null);
    }
}
