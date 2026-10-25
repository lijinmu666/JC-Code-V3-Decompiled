package p131o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.p038google.p039android.material.textfield.C0291mjFkc;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p131o.AbstractC4502rkYL;

/* renamed from: o.zpm */
/* loaded from: classes.dex */
public class C5037zpm extends AbstractC1743CBhInx {

    /* renamed from: Pq */
    public static final boolean f17730Pq = true;

    /* renamed from: Dt */
    public final View.OnFocusChangeListener f17731Dt;

    /* renamed from: ETF */
    public final AbstractC4502rkYL.mjFkc f17732ETF;

    /* renamed from: IEE */
    public ValueAnimator f17733IEE;

    /* renamed from: JHa */
    public final int f17734JHa;

    /* renamed from: KLFTb */
    public final int f17735KLFTb;

    /* renamed from: MiMN */
    public boolean f17736MiMN;

    /* renamed from: VA */
    public boolean f17737VA;

    /* renamed from: YoKzxo */
    public boolean f17738YoKzxo;

    /* renamed from: fehf */
    public ValueAnimator f17739fehf;

    /* renamed from: lgHUyS */
    public AutoCompleteTextView f17740lgHUyS;

    /* renamed from: qGY */
    public AccessibilityManager f17741qGY;

    /* renamed from: qdMbNW */
    public final View.OnClickListener f17742qdMbNW;

    /* renamed from: rkYL */
    public long f17743rkYL;

    /* renamed from: xJ */
    public final TimeInterpolator f17744xJ;

    /* renamed from: o.zpm$mjFkc */
    public class mjFkc extends AnimatorListenerAdapter {
        public mjFkc() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C5037zpm.this.m7805IEE();
            C5037zpm.this.f17733IEE.start();
        }
    }

    public C5037zpm(C0291mjFkc c0291mjFkc) {
        super(c0291mjFkc);
        this.f17742qdMbNW = new View.OnClickListener() { // from class: o.gcD
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13741mjFkc.m14134KLMXS(view);
            }
        };
        this.f17731Dt = new View.OnFocusChangeListener() { // from class: o.ilrRDI
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.f14175mjFkc.m14142zvd(view, z);
            }
        };
        this.f17732ETF = new AbstractC4502rkYL.mjFkc() { // from class: o.PX
            @Override // p131o.AbstractC4502rkYL.mjFkc
            public final void onTouchExplorationStateChanged(boolean z) {
                this.f10088mjFkc.m14148cMLeY(z);
            }
        };
        this.f17743rkYL = LongCompanionObject.MAX_VALUE;
        this.f17734JHa = AbstractC4923y2.m13983JHa(c0291mjFkc.getContext(), AbstractC3800h4.f13926HGpJ, 67);
        this.f17735KLFTb = AbstractC4923y2.m13983JHa(c0291mjFkc.getContext(), AbstractC3800h4.f13926HGpJ, 50);
        this.f17744xJ = AbstractC4923y2.m13988xJ(c0291mjFkc.getContext(), AbstractC3800h4.f13944lB, AbstractC2506NPj.f9739mjFkc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: KLMXS */
    public /* synthetic */ void m14134KLMXS(View view) {
        m14150oCFDzJ();
    }

    /* renamed from: OjSQV */
    private void m14135OjSQV() {
        this.f17733IEE = m14149mByQ(this.f17734JHa, 0.0f, 1.0f);
        ValueAnimator valueAnimatorM14149mByQ = m14149mByQ(this.f17735KLFTb, 1.0f, 0.0f);
        this.f17739fehf = valueAnimatorM14149mByQ;
        valueAnimatorM14149mByQ.addListener(new mjFkc());
    }

    /* renamed from: wJVbdd */
    public static AutoCompleteTextView m14141wJVbdd(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zvd */
    public /* synthetic */ void m14142zvd(View view, boolean z) {
        this.f17737VA = z;
        m7805IEE();
        if (z) {
            return;
        }
        m14144NPj(false);
        this.f17736MiMN = false;
    }

    /* renamed from: CqaNbM */
    public final /* synthetic */ void m14143CqaNbM() {
        boolean zIsPopupShowing = this.f17740lgHUyS.isPopupShowing();
        m14144NPj(zIsPopupShowing);
        this.f17736MiMN = zIsPopupShowing;
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: Dt */
    public boolean mo7803Dt() {
        return true;
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: ETF */
    public boolean mo7804ETF() {
        return this.f17737VA;
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: JHa */
    public View.OnClickListener mo7806JHa() {
        return this.f17742qdMbNW;
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: KLFTb */
    public View.OnFocusChangeListener mo7807KLFTb() {
        return this.f17731Dt;
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: MiMN */
    public boolean mo7808MiMN() {
        return this.f17738YoKzxo;
    }

    /* renamed from: NPj */
    public final void m14144NPj(boolean z) {
        if (this.f17738YoKzxo != z) {
            this.f17738YoKzxo = z;
            this.f17733IEE.cancel();
            this.f17739fehf.start();
        }
    }

    /* renamed from: Ne */
    public final boolean m14145Ne() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f17743rkYL;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: Pq */
    public void mo7809Pq() {
        m14135OjSQV();
        this.f17741qGY = (AccessibilityManager) this.f7595wA.getSystemService("accessibility");
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: VA */
    public boolean mo7810VA() {
        return true;
    }

    /* renamed from: Vnb */
    public final /* synthetic */ void m14146Vnb() {
        m14147aqHPIZ();
        m14144NPj(false);
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: YoKzxo */
    public void mo7811YoKzxo(EditText editText) {
        this.f17740lgHUyS = m14141wJVbdd(editText);
        m14152vadzgd();
        this.f7594mjFkc.setErrorIconDrawable((Drawable) null);
        if (!AbstractC4512rtBEoQ.m13401mjFkc(editText) && this.f17741qGY.isTouchExplorationEnabled()) {
            AbstractC2876T9.m10244NKyg(this.f7593ZfxDd, 2);
        }
        this.f7594mjFkc.setEndIconVisible(true);
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: ZfxDd */
    public int mo7812ZfxDd() {
        return f17730Pq ? AbstractC4458r4.f16283ZfxDd : AbstractC4458r4.f16282KLFTb;
    }

    /* renamed from: aqHPIZ */
    public final void m14147aqHPIZ() {
        this.f17736MiMN = true;
        this.f17743rkYL = System.currentTimeMillis();
    }

    /* renamed from: cMLeY */
    public final /* synthetic */ void m14148cMLeY(boolean z) {
        AutoCompleteTextView autoCompleteTextView = this.f17740lgHUyS;
        if (autoCompleteTextView == null || AbstractC4512rtBEoQ.m13401mjFkc(autoCompleteTextView)) {
            return;
        }
        AbstractC2876T9.m10244NKyg(this.f7593ZfxDd, z ? 2 : 1);
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: diqgf */
    public boolean mo7813diqgf() {
        return true;
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: eyqo */
    public void mo7814eyqo() {
        AutoCompleteTextView autoCompleteTextView = this.f17740lgHUyS;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            if (f17730Pq) {
                this.f17740lgHUyS.setOnDismissListener(null);
            }
        }
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: lgHUyS */
    public AbstractC4502rkYL.mjFkc mo7816lgHUyS() {
        return this.f17732ETF;
    }

    /* renamed from: mByQ */
    public final ValueAnimator m14149mByQ(int i, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f17744xJ);
        valueAnimatorOfFloat.setDuration(i);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o.boLb
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f13149mjFkc.m14153xrEuO(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: mjFkc */
    public void mo7817mjFkc(Editable editable) {
        if (this.f17741qGY.isTouchExplorationEnabled() && AbstractC4512rtBEoQ.m13401mjFkc(this.f17740lgHUyS) && !this.f7593ZfxDd.hasFocus()) {
            this.f17740lgHUyS.dismissDropDown();
        }
        this.f17740lgHUyS.post(new Runnable() { // from class: o.FoO
            @Override // java.lang.Runnable
            public final void run() {
                this.f8253mjFkc.m14143CqaNbM();
            }
        });
    }

    /* renamed from: oCFDzJ */
    public final void m14150oCFDzJ() {
        if (this.f17740lgHUyS == null) {
            return;
        }
        if (m14145Ne()) {
            this.f17736MiMN = false;
        }
        if (this.f17736MiMN) {
            this.f17736MiMN = false;
            return;
        }
        if (f17730Pq) {
            m14144NPj(!this.f17738YoKzxo);
        } else {
            this.f17738YoKzxo = !this.f17738YoKzxo;
            m7805IEE();
        }
        if (!this.f17738YoKzxo) {
            this.f17740lgHUyS.dismissDropDown();
        } else {
            this.f17740lgHUyS.requestFocus();
            this.f17740lgHUyS.showDropDown();
        }
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: qGY */
    public void mo7818qGY(View view, AccessibilityEvent accessibilityEvent) {
        if (!this.f17741qGY.isEnabled() || AbstractC4512rtBEoQ.m13401mjFkc(this.f17740lgHUyS)) {
            return;
        }
        boolean z = accessibilityEvent.getEventType() == 32768 && this.f17738YoKzxo && !this.f17740lgHUyS.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z) {
            m14150oCFDzJ();
            m14147aqHPIZ();
        }
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: qdMbNW */
    public boolean mo7819qdMbNW(int i) {
        return i != 0;
    }

    /* renamed from: rWxwaT */
    public final /* synthetic */ boolean m14151rWxwaT(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (m14145Ne()) {
                this.f17736MiMN = false;
            }
            m14150oCFDzJ();
            m14147aqHPIZ();
        }
        return false;
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: rkYL */
    public void mo7820rkYL(View view, C2971Ucbh c2971Ucbh) {
        if (!AbstractC4512rtBEoQ.m13401mjFkc(this.f17740lgHUyS)) {
            c2971Ucbh.m10572bbzow(Spinner.class.getName());
        }
        if (c2971Ucbh.m10598vadzgd()) {
            c2971Ucbh.m10602xROA(null);
        }
    }

    /* renamed from: vadzgd */
    public final void m14152vadzgd() {
        this.f17740lgHUyS.setOnTouchListener(new View.OnTouchListener() { // from class: o.gq
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f13846mjFkc.m14151rWxwaT(view, motionEvent);
            }
        });
        if (f17730Pq) {
            this.f17740lgHUyS.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: o.jCFSyK
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public final void onDismiss() {
                    this.f14279mjFkc.m14146Vnb();
                }
            });
        }
        this.f17740lgHUyS.setThreshold(0);
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: wA */
    public int mo7821wA() {
        return AbstractC2481N4.f9654xJ;
    }

    /* renamed from: xrEuO */
    public final /* synthetic */ void m14153xrEuO(ValueAnimator valueAnimator) {
        this.f7593ZfxDd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
