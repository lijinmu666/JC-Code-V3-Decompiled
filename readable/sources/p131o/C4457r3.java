package p131o;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.p038google.p039android.material.textfield.C0291mjFkc;

/* renamed from: o.r3 */
/* loaded from: classes.dex */
public class C4457r3 extends AbstractC1743CBhInx {

    /* renamed from: JHa */
    public EditText f16277JHa;

    /* renamed from: KLFTb */
    public int f16278KLFTb;

    /* renamed from: xJ */
    public final View.OnClickListener f16279xJ;

    public C4457r3(C0291mjFkc c0291mjFkc, int i) {
        super(c0291mjFkc);
        this.f16278KLFTb = AbstractC4458r4.f16284mjFkc;
        this.f16279xJ = new View.OnClickListener() { // from class: o.q3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f16014mjFkc.m13333HGpJ(view);
            }
        };
        if (i != 0) {
            this.f16278KLFTb = i;
        }
    }

    /* renamed from: Gd */
    public static boolean m13332Gd(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: HGpJ */
    public /* synthetic */ void m13333HGpJ(View view) {
        EditText editText = this.f16277JHa;
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        if (m13335huTpC()) {
            this.f16277JHa.setTransformationMethod(null);
        } else {
            this.f16277JHa.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (selectionEnd >= 0) {
            this.f16277JHa.setSelection(selectionEnd);
        }
        m7805IEE();
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: AZxh */
    public void mo7802AZxh(CharSequence charSequence, int i, int i2, int i3) {
        m7805IEE();
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: JHa */
    public View.OnClickListener mo7806JHa() {
        return this.f16279xJ;
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: MiMN */
    public boolean mo7808MiMN() {
        return !m13335huTpC();
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: Pq */
    public void mo7809Pq() {
        if (m13332Gd(this.f16277JHa)) {
            this.f16277JHa.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: VA */
    public boolean mo7810VA() {
        return true;
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: YoKzxo */
    public void mo7811YoKzxo(EditText editText) {
        this.f16277JHa = editText;
        m7805IEE();
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: ZfxDd */
    public int mo7812ZfxDd() {
        return this.f16278KLFTb;
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: eyqo */
    public void mo7814eyqo() {
        EditText editText = this.f16277JHa;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* renamed from: huTpC */
    public final boolean m13335huTpC() {
        EditText editText = this.f16277JHa;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // p131o.AbstractC1743CBhInx
    /* renamed from: wA */
    public int mo7821wA() {
        return AbstractC2481N4.f9642Pq;
    }
}
