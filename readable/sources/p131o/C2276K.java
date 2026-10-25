package p131o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.p038google.p039android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;
import org.conscrypt.BuildConfig;

/* renamed from: o.K */
/* loaded from: classes.dex */
public final class C2276K {

    /* renamed from: AZxh */
    public final int f9070AZxh;

    /* renamed from: BAnRFn */
    public Typeface f9071BAnRFn;

    /* renamed from: Dt */
    public int f9072Dt;

    /* renamed from: ETF */
    public FrameLayout f9073ETF;

    /* renamed from: Gd */
    public boolean f9074Gd;

    /* renamed from: HGpJ */
    public TextView f9075HGpJ;

    /* renamed from: IEE */
    public TextView f9076IEE;

    /* renamed from: JHa */
    public final TimeInterpolator f9077JHa;

    /* renamed from: KLFTb */
    public final TimeInterpolator f9078KLFTb;

    /* renamed from: MiMN */
    public final float f9079MiMN;

    /* renamed from: Pq */
    public CharSequence f9080Pq;

    /* renamed from: Ucbh */
    public ColorStateList f9081Ucbh;

    /* renamed from: VA */
    public Animator f9082VA;

    /* renamed from: VocHEe */
    public ColorStateList f9083VocHEe;

    /* renamed from: YoKzxo */
    public int f9084YoKzxo;

    /* renamed from: ZfxDd */
    public final TimeInterpolator f9085ZfxDd;

    /* renamed from: diqgf */
    public int f9086diqgf;

    /* renamed from: eyqo */
    public int f9087eyqo;

    /* renamed from: fehf */
    public boolean f9088fehf;

    /* renamed from: huTpC */
    public CharSequence f9089huTpC;

    /* renamed from: lgHUyS */
    public final TextInputLayout f9090lgHUyS;

    /* renamed from: mjFkc */
    public final int f9091mjFkc;

    /* renamed from: qGY */
    public CharSequence f9092qGY;

    /* renamed from: qdMbNW */
    public LinearLayout f9093qdMbNW;

    /* renamed from: rkYL */
    public int f9094rkYL;

    /* renamed from: vI */
    public int f9095vI;

    /* renamed from: wA */
    public final int f9096wA;

    /* renamed from: xJ */
    public final Context f9097xJ;

    /* renamed from: o.K$AZxh */
    public class AZxh extends View.AccessibilityDelegate {
        public AZxh() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText editText = C2276K.this.f9090lgHUyS.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    /* renamed from: o.K$mjFkc */
    public class mjFkc extends AnimatorListenerAdapter {

        /* renamed from: AZxh */
        public final /* synthetic */ TextView f9099AZxh;

        /* renamed from: ZfxDd */
        public final /* synthetic */ TextView f9101ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ int f9102mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ int f9103wA;

        public mjFkc(int i, TextView textView, int i2, TextView textView2) {
            this.f9102mjFkc = i;
            this.f9099AZxh = textView;
            this.f9103wA = i2;
            this.f9101ZfxDd = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C2276K.this.f9084YoKzxo = this.f9102mjFkc;
            C2276K.this.f9082VA = null;
            TextView textView = this.f9099AZxh;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f9103wA == 1 && C2276K.this.f9076IEE != null) {
                    C2276K.this.f9076IEE.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f9101ZfxDd;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f9101ZfxDd.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f9101ZfxDd;
            if (textView != null) {
                textView.setVisibility(0);
                this.f9101ZfxDd.setAlpha(0.0f);
            }
        }
    }

    public C2276K(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f9097xJ = context;
        this.f9090lgHUyS = textInputLayout;
        this.f9079MiMN = context.getResources().getDimensionPixelSize(AbstractC4191n4.f15315KLFTb);
        this.f9091mjFkc = AbstractC4923y2.m13983JHa(context, AbstractC3800h4.f13951vI, 217);
        this.f9070AZxh = AbstractC4923y2.m13983JHa(context, AbstractC3800h4.f13935Ucbh, 167);
        this.f9096wA = AbstractC4923y2.m13983JHa(context, AbstractC3800h4.f13951vI, 167);
        this.f9085ZfxDd = AbstractC4923y2.m13988xJ(context, AbstractC3800h4.f13937VocHEe, AbstractC2506NPj.f9738ZfxDd);
        int i = AbstractC3800h4.f13937VocHEe;
        TimeInterpolator timeInterpolator = AbstractC2506NPj.f9739mjFkc;
        this.f9078KLFTb = AbstractC4923y2.m13988xJ(context, i, timeInterpolator);
        this.f9077JHa = AbstractC4923y2.m13988xJ(context, AbstractC3800h4.f13944lB, timeInterpolator);
    }

    /* renamed from: BAnRFn */
    public boolean m9076BAnRFn() {
        return this.f9074Gd;
    }

    /* renamed from: CqaNbM */
    public void m9077CqaNbM(int i) {
        this.f9087eyqo = i;
        TextView textView = this.f9076IEE;
        if (textView != null) {
            this.f9090lgHUyS.m3179nxI(textView, i);
        }
    }

    /* renamed from: Dt */
    public final ObjectAnimator m9078Dt(TextView textView, boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(z ? this.f9070AZxh : this.f9096wA);
        objectAnimatorOfFloat.setInterpolator(z ? this.f9078KLFTb : this.f9077JHa);
        return objectAnimatorOfFloat;
    }

    /* renamed from: ETF */
    public final ObjectAnimator m9079ETF(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f9079MiMN, 0.0f);
        objectAnimatorOfFloat.setDuration(this.f9091mjFkc);
        objectAnimatorOfFloat.setInterpolator(this.f9085ZfxDd);
        return objectAnimatorOfFloat;
    }

    /* renamed from: Gd */
    public void m9080Gd() {
        m9104lgHUyS();
        int i = this.f9084YoKzxo;
        if (i == 2) {
            this.f9094rkYL = 0;
        }
        m9095WrLQs(i, this.f9094rkYL, m9112vadzgd(this.f9075HGpJ, BuildConfig.f24315FLAVOR));
    }

    /* renamed from: HGpJ */
    public final boolean m9081HGpJ(int i) {
        return (i != 1 || this.f9076IEE == null || TextUtils.isEmpty(this.f9092qGY)) ? false : true;
    }

    /* renamed from: IEE */
    public ColorStateList m9082IEE() {
        TextView textView = this.f9076IEE;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* renamed from: JHa */
    public void m9083JHa() {
        if (m9114xJ()) {
            EditText editText = this.f9090lgHUyS.getEditText();
            boolean zM9574JHa = AbstractC2478N1.m9574JHa(this.f9097xJ);
            AbstractC2876T9.m10274gYa(this.f9093qdMbNW, m9091Ucbh(zM9574JHa, AbstractC4191n4.f15322Ucbh, AbstractC2876T9.m10224BAnRFn(editText)), m9091Ucbh(zM9574JHa, AbstractC4191n4.f15334huTpC, this.f9097xJ.getResources().getDimensionPixelSize(AbstractC4191n4.f15332eyqo)), m9091Ucbh(zM9574JHa, AbstractC4191n4.f15322Ucbh, AbstractC2876T9.m10257VocHEe(editText)), 0);
        }
    }

    /* renamed from: KLFTb */
    public void m9084KLFTb(TextView textView, int i) {
        if (this.f9093qdMbNW == null && this.f9073ETF == null) {
            LinearLayout linearLayout = new LinearLayout(this.f9097xJ);
            this.f9093qdMbNW = linearLayout;
            linearLayout.setOrientation(0);
            this.f9090lgHUyS.addView(this.f9093qdMbNW, -1, -2);
            this.f9073ETF = new FrameLayout(this.f9097xJ);
            this.f9093qdMbNW.addView(this.f9073ETF, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f9090lgHUyS.getEditText() != null) {
                m9083JHa();
            }
        }
        if (m9111vI(i)) {
            this.f9073ETF.setVisibility(0);
            this.f9073ETF.addView(textView);
        } else {
            this.f9093qdMbNW.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f9093qdMbNW.setVisibility(0);
        this.f9072Dt++;
    }

    /* renamed from: KLMXS */
    public void m9085KLMXS(int i) {
        this.f9095vI = i;
        TextView textView = this.f9075HGpJ;
        if (textView != null) {
            AbstractC4065l8.m12662MiMN(textView, i);
        }
    }

    /* renamed from: MiMN */
    public final TextView m9086MiMN(int i) {
        if (i == 1) {
            return this.f9076IEE;
        }
        if (i != 2) {
            return null;
        }
        return this.f9075HGpJ;
    }

    /* renamed from: NPj */
    public final void m9087NPj(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: Ne */
    public void m9088Ne(boolean z) {
        if (this.f9088fehf == z) {
            return;
        }
        m9104lgHUyS();
        if (z) {
            C2463Moer c2463Moer = new C2463Moer(this.f9097xJ);
            this.f9076IEE = c2463Moer;
            c2463Moer.setId(AbstractC1803D4.f7797KLMXS);
            this.f9076IEE.setTextAlignment(5);
            Typeface typeface = this.f9071BAnRFn;
            if (typeface != null) {
                this.f9076IEE.setTypeface(typeface);
            }
            m9077CqaNbM(this.f9087eyqo);
            m9115xrEuO(this.f9081Ucbh);
            m9089OjSQV(this.f9080Pq);
            m9105mByQ(this.f9086diqgf);
            this.f9076IEE.setVisibility(4);
            m9084KLFTb(this.f9076IEE, 0);
        } else {
            m9102huTpC();
            m9103lB(this.f9076IEE, 0);
            this.f9076IEE = null;
            this.f9090lgHUyS.m3191vjlshU();
            this.f9090lgHUyS.m3188tjSezt();
        }
        this.f9088fehf = z;
    }

    /* renamed from: OjSQV */
    public void m9089OjSQV(CharSequence charSequence) {
        this.f9080Pq = charSequence;
        TextView textView = this.f9076IEE;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* renamed from: Pq */
    public CharSequence m9090Pq() {
        return this.f9089huTpC;
    }

    /* renamed from: Ucbh */
    public final int m9091Ucbh(boolean z, int i, int i2) {
        return z ? this.f9097xJ.getResources().getDimensionPixelSize(i) : i2;
    }

    /* renamed from: VA */
    public boolean m9092VA() {
        return m9081HGpJ(this.f9094rkYL);
    }

    /* renamed from: Vnb */
    public void m9093Vnb(Typeface typeface) {
        if (typeface != this.f9071BAnRFn) {
            this.f9071BAnRFn = typeface;
            m9109rWxwaT(this.f9076IEE, typeface);
            m9109rWxwaT(this.f9075HGpJ, typeface);
        }
    }

    /* renamed from: VocHEe */
    public boolean m9094VocHEe() {
        return this.f9088fehf;
    }

    /* renamed from: WrLQs */
    public final void m9095WrLQs(int i, int i2, boolean z) {
        if (i == i2) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f9082VA = animatorSet;
            ArrayList arrayList = new ArrayList();
            m9108qdMbNW(arrayList, this.f9074Gd, this.f9075HGpJ, 2, i, i2);
            m9108qdMbNW(arrayList, this.f9088fehf, this.f9076IEE, 1, i, i2);
            AbstractC4757vadzgd.m13784mjFkc(animatorSet, arrayList);
            animatorSet.addListener(new mjFkc(i2, m9086MiMN(i), i, m9086MiMN(i2)));
            animatorSet.start();
        } else {
            m9113wJVbdd(i, i2);
        }
        this.f9090lgHUyS.m3191vjlshU();
        this.f9090lgHUyS.m3154SmIWf(z);
        this.f9090lgHUyS.m3188tjSezt();
    }

    /* renamed from: YoKzxo */
    public int m9096YoKzxo() {
        return this.f9086diqgf;
    }

    /* renamed from: aqHPIZ */
    public void m9097aqHPIZ(CharSequence charSequence) {
        m9104lgHUyS();
        this.f9089huTpC = charSequence;
        this.f9075HGpJ.setText(charSequence);
        int i = this.f9084YoKzxo;
        if (i != 2) {
            this.f9094rkYL = 2;
        }
        m9095WrLQs(i, this.f9094rkYL, m9112vadzgd(this.f9075HGpJ, charSequence));
    }

    /* renamed from: cMLeY */
    public void m9098cMLeY(ColorStateList colorStateList) {
        this.f9083VocHEe = colorStateList;
        TextView textView = this.f9075HGpJ;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* renamed from: diqgf */
    public View m9099diqgf() {
        return this.f9075HGpJ;
    }

    /* renamed from: eyqo */
    public int m9100eyqo() {
        TextView textView = this.f9075HGpJ;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* renamed from: fehf */
    public int m9101fehf() {
        TextView textView = this.f9076IEE;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* renamed from: huTpC */
    public void m9102huTpC() {
        this.f9092qGY = null;
        m9104lgHUyS();
        if (this.f9084YoKzxo == 1) {
            if (!this.f9074Gd || TextUtils.isEmpty(this.f9089huTpC)) {
                this.f9094rkYL = 0;
            } else {
                this.f9094rkYL = 2;
            }
        }
        m9095WrLQs(this.f9084YoKzxo, this.f9094rkYL, m9112vadzgd(this.f9076IEE, BuildConfig.f24315FLAVOR));
    }

    /* renamed from: lB */
    public void m9103lB(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.f9093qdMbNW == null) {
            return;
        }
        if (!m9111vI(i) || (frameLayout = this.f9073ETF) == null) {
            this.f9093qdMbNW.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i2 = this.f9072Dt - 1;
        this.f9072Dt = i2;
        m9087NPj(this.f9093qdMbNW, i2);
    }

    /* renamed from: lgHUyS */
    public void m9104lgHUyS() {
        Animator animator = this.f9082VA;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* renamed from: mByQ */
    public void m9105mByQ(int i) {
        this.f9086diqgf = i;
        TextView textView = this.f9076IEE;
        if (textView != null) {
            AbstractC2876T9.m10289tQ(textView, i);
        }
    }

    /* renamed from: oCFDzJ */
    public void m9106oCFDzJ(CharSequence charSequence) {
        m9104lgHUyS();
        this.f9092qGY = charSequence;
        this.f9076IEE.setText(charSequence);
        int i = this.f9084YoKzxo;
        if (i != 1) {
            this.f9094rkYL = 1;
        }
        m9095WrLQs(i, this.f9094rkYL, m9112vadzgd(this.f9076IEE, charSequence));
    }

    /* renamed from: qGY */
    public CharSequence m9107qGY() {
        return this.f9092qGY;
    }

    /* renamed from: qdMbNW */
    public final void m9108qdMbNW(List list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            ObjectAnimator objectAnimatorM9078Dt = m9078Dt(textView, i3 == i);
            if (i == i3 && i2 != 0) {
                objectAnimatorM9078Dt.setStartDelay(this.f9096wA);
            }
            list.add(objectAnimatorM9078Dt);
            if (i3 != i || i2 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorM9079ETF = m9079ETF(textView);
            objectAnimatorM9079ETF.setStartDelay(this.f9096wA);
            list.add(objectAnimatorM9079ETF);
        }
    }

    /* renamed from: rWxwaT */
    public final void m9109rWxwaT(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    /* renamed from: rkYL */
    public CharSequence m9110rkYL() {
        return this.f9080Pq;
    }

    /* renamed from: vI */
    public boolean m9111vI(int i) {
        return i == 0 || i == 1;
    }

    /* renamed from: vadzgd */
    public final boolean m9112vadzgd(TextView textView, CharSequence charSequence) {
        return AbstractC2876T9.m10287rWxwaT(this.f9090lgHUyS) && this.f9090lgHUyS.isEnabled() && !(this.f9094rkYL == this.f9084YoKzxo && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    /* renamed from: wJVbdd */
    public final void m9113wJVbdd(int i, int i2) {
        TextView textViewM9086MiMN;
        TextView textViewM9086MiMN2;
        if (i == i2) {
            return;
        }
        if (i2 != 0 && (textViewM9086MiMN2 = m9086MiMN(i2)) != null) {
            textViewM9086MiMN2.setVisibility(0);
            textViewM9086MiMN2.setAlpha(1.0f);
        }
        if (i != 0 && (textViewM9086MiMN = m9086MiMN(i)) != null) {
            textViewM9086MiMN.setVisibility(4);
            if (i == 1) {
                textViewM9086MiMN.setText((CharSequence) null);
            }
        }
        this.f9084YoKzxo = i2;
    }

    /* renamed from: xJ */
    public final boolean m9114xJ() {
        return (this.f9093qdMbNW == null || this.f9090lgHUyS.getEditText() == null) ? false : true;
    }

    /* renamed from: xrEuO */
    public void m9115xrEuO(ColorStateList colorStateList) {
        this.f9081Ucbh = colorStateList;
        TextView textView = this.f9076IEE;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* renamed from: zvd */
    public void m9116zvd(boolean z) {
        if (this.f9074Gd == z) {
            return;
        }
        m9104lgHUyS();
        if (z) {
            C2463Moer c2463Moer = new C2463Moer(this.f9097xJ);
            this.f9075HGpJ = c2463Moer;
            c2463Moer.setId(AbstractC1803D4.f7826zvd);
            this.f9075HGpJ.setTextAlignment(5);
            Typeface typeface = this.f9071BAnRFn;
            if (typeface != null) {
                this.f9075HGpJ.setTypeface(typeface);
            }
            this.f9075HGpJ.setVisibility(4);
            AbstractC2876T9.m10289tQ(this.f9075HGpJ, 1);
            m9085KLMXS(this.f9095vI);
            m9098cMLeY(this.f9083VocHEe);
            m9084KLFTb(this.f9075HGpJ, 1);
            this.f9075HGpJ.setAccessibilityDelegate(new AZxh());
        } else {
            m9080Gd();
            m9103lB(this.f9075HGpJ, 1);
            this.f9075HGpJ = null;
            this.f9090lgHUyS.m3191vjlshU();
            this.f9090lgHUyS.m3188tjSezt();
        }
        this.f9074Gd = z;
    }
}
