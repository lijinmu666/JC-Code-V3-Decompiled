package p131o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.p038google.p039android.material.textfield.C0291mjFkc;

/* renamed from: o.EoC */
/* loaded from: classes.dex */
public class C1916EoC extends AbstractC1743CBhInx {

    /* renamed from: Dt */
    public final View.OnClickListener f8046Dt;

    /* renamed from: ETF */
    public final View.OnFocusChangeListener f8047ETF;

    /* renamed from: JHa */
    public final int f8048JHa;

    /* renamed from: KLFTb */
    public final int f8049KLFTb;

    /* renamed from: MiMN */
    public ValueAnimator f8050MiMN;

    /* renamed from: VA */
    public AnimatorSet f8051VA;

    /* renamed from: lgHUyS */
    public final TimeInterpolator f8052lgHUyS;

    /* renamed from: qdMbNW */
    public EditText f8053qdMbNW;

    /* renamed from: xJ */
    public final TimeInterpolator f8054xJ;

    /* renamed from: o.EoC$AZxh */
    public class AZxh extends AnimatorListenerAdapter {
        public AZxh() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1916EoC.this.f7592AZxh.m3259nxI(false);
        }
    }

    /* renamed from: o.EoC$mjFkc */
    public class mjFkc extends AnimatorListenerAdapter {
        public mjFkc() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C1916EoC.this.f7592AZxh.m3259nxI(true);
        }
    }

    public C1916EoC(C0291mjFkc c0291mjFkc) {
        super(c0291mjFkc);
        this.f8046Dt = new View.OnClickListener() { // from class: o.KSf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f9188mjFkc.m8181Ne(view);
            }
        };
        this.f8047ETF = new View.OnFocusChangeListener() { // from class: o.Vptz
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.f11371mjFkc.m8179CqaNbM(view, z);
            }
        };
        this.f8049KLFTb = AbstractC4923y2.m13983JHa(c0291mjFkc.getContext(), AbstractC3800h4.f13926HGpJ, 100);
        this.f8048JHa = AbstractC4923y2.m13983JHa(c0291mjFkc.getContext(), AbstractC3800h4.f13926HGpJ, 150);
        this.f8054xJ = AbstractC4923y2.m13988xJ(c0291mjFkc.getContext(), AbstractC3800h4.f13944lB, AbstractC2506NPj.f9739mjFkc);
        this.f8052lgHUyS = AbstractC4923y2.m13988xJ(c0291mjFkc.getContext(), AbstractC3800h4.f13921BAnRFn, AbstractC2506NPj.f9738ZfxDd);
    }

    /* renamed from: BAnRFn */
    public final ValueAnimator m8178BAnRFn(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f8054xJ);
        valueAnimatorOfFloat.setDuration(this.f8049KLFTb);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o.qrxT
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f16242mjFkc.m8185mByQ(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    /* renamed from: CqaNbM */
    public final /* synthetic */ void m8179CqaNbM(View view, boolean z) {
        m8183VocHEe(m8180KLMXS());
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: JHa */
    public View.OnClickListener mo7806JHa() {
        return this.f8046Dt;
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: KLFTb */
    public View.OnFocusChangeListener mo7807KLFTb() {
        return this.f8047ETF;
    }

    /* renamed from: KLMXS */
    public final boolean m8180KLMXS() {
        EditText editText = this.f8053qdMbNW;
        return editText != null && (editText.hasFocus() || this.f7593ZfxDd.hasFocus()) && this.f8053qdMbNW.getText().length() > 0;
    }

    /* renamed from: Ne */
    public final /* synthetic */ void m8181Ne(View view) {
        EditText editText = this.f8053qdMbNW;
        if (editText == null) {
            return;
        }
        Editable text = editText.getText();
        if (text != null) {
            text.clear();
        }
        m7805IEE();
    }

    /* renamed from: OjSQV */
    public final /* synthetic */ void m8182OjSQV(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f7593ZfxDd.setScaleX(fFloatValue);
        this.f7593ZfxDd.setScaleY(fFloatValue);
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: Pq */
    public void mo7809Pq() {
        m8186wJVbdd();
    }

    /* renamed from: VocHEe */
    public final void m8183VocHEe(boolean z) {
        boolean z2 = this.f7592AZxh.m3258mByQ() == z;
        if (z && !this.f8051VA.isRunning()) {
            this.f8050MiMN.cancel();
            this.f8051VA.start();
            if (z2) {
                this.f8051VA.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.f8051VA.cancel();
        this.f8050MiMN.start();
        if (z2) {
            this.f8050MiMN.end();
        }
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: YoKzxo */
    public void mo7811YoKzxo(EditText editText) {
        this.f8053qdMbNW = editText;
        this.f7594mjFkc.setEndIconVisible(m8180KLMXS());
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: ZfxDd */
    public int mo7812ZfxDd() {
        return AbstractC4458r4.f16281JHa;
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: eyqo */
    public void mo7814eyqo() {
        EditText editText = this.f8053qdMbNW;
        if (editText != null) {
            editText.post(new Runnable() { // from class: o.CcoH
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7641mjFkc.m8187xrEuO();
                }
            });
        }
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: fehf */
    public void mo7815fehf(boolean z) {
        if (this.f7592AZxh.m3253huTpC() == null) {
            return;
        }
        m8183VocHEe(z);
    }

    /* renamed from: lB */
    public final ValueAnimator m8184lB() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f8052lgHUyS);
        valueAnimatorOfFloat.setDuration(this.f8048JHa);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o.HX
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f8613mjFkc.m8182OjSQV(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    /* renamed from: mByQ */
    public final /* synthetic */ void m8185mByQ(ValueAnimator valueAnimator) {
        this.f7593ZfxDd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: mjFkc */
    public void mo7817mjFkc(Editable editable) {
        if (this.f7592AZxh.m3253huTpC() != null) {
            return;
        }
        m8183VocHEe(m8180KLMXS());
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: wA */
    public int mo7821wA() {
        return AbstractC2481N4.f9640KLFTb;
    }

    /* renamed from: wJVbdd */
    public final void m8186wJVbdd() {
        ValueAnimator valueAnimatorM8184lB = m8184lB();
        ValueAnimator valueAnimatorM8178BAnRFn = m8178BAnRFn(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f8051VA = animatorSet;
        animatorSet.playTogether(valueAnimatorM8184lB, valueAnimatorM8178BAnRFn);
        this.f8051VA.addListener(new mjFkc());
        ValueAnimator valueAnimatorM8178BAnRFn2 = m8178BAnRFn(1.0f, 0.0f);
        this.f8050MiMN = valueAnimatorM8178BAnRFn2;
        valueAnimatorM8178BAnRFn2.addListener(new AZxh());
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: xJ */
    public View.OnFocusChangeListener mo7822xJ() {
        return this.f8047ETF;
    }

    /* renamed from: xrEuO */
    public final /* synthetic */ void m8187xrEuO() {
        m8183VocHEe(true);
    }
}
