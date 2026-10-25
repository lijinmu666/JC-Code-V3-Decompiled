package p131o;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* renamed from: o.a8 */
/* loaded from: classes.dex */
public class C3343a8 {

    /* renamed from: JHa */
    public C3008V7 f12724JHa;

    /* renamed from: wA */
    public float f12728wA;

    /* renamed from: mjFkc */
    public final TextPaint f12727mjFkc = new TextPaint(1);

    /* renamed from: AZxh */
    public final AbstractC3139X7 f12723AZxh = new mjFkc();

    /* renamed from: ZfxDd */
    public boolean f12726ZfxDd = true;

    /* renamed from: KLFTb */
    public WeakReference f12725KLFTb = new WeakReference(null);

    /* renamed from: o.a8$AZxh */
    public interface AZxh {
        int[] getState();

        /* renamed from: mjFkc */
        void mo2846mjFkc();

        boolean onStateChange(int[] iArr);
    }

    /* renamed from: o.a8$mjFkc */
    public class mjFkc extends AbstractC3139X7 {
        public mjFkc() {
        }

        @Override // p131o.AbstractC3139X7
        /* renamed from: AZxh */
        public void mo2738AZxh(Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            C3343a8.this.f12726ZfxDd = true;
            AZxh aZxh = (AZxh) C3343a8.this.f12725KLFTb.get();
            if (aZxh != null) {
                aZxh.mo2846mjFkc();
            }
        }

        @Override // p131o.AbstractC3139X7
        /* renamed from: mjFkc */
        public void mo2739mjFkc(int i) {
            C3343a8.this.f12726ZfxDd = true;
            AZxh aZxh = (AZxh) C3343a8.this.f12725KLFTb.get();
            if (aZxh != null) {
                aZxh.mo2846mjFkc();
            }
        }
    }

    public C3343a8(AZxh aZxh) {
        m11304xJ(aZxh);
    }

    /* renamed from: Dt */
    public void m11297Dt(Context context) {
        this.f12724JHa.m10672YoKzxo(context, this.f12727mjFkc, this.f12723AZxh);
    }

    /* renamed from: JHa */
    public float m11298JHa(String str) {
        if (!this.f12726ZfxDd) {
            return this.f12728wA;
        }
        float fM11303wA = m11303wA(str);
        this.f12728wA = fM11303wA;
        this.f12726ZfxDd = false;
        return fM11303wA;
    }

    /* renamed from: KLFTb */
    public TextPaint m11299KLFTb() {
        return this.f12727mjFkc;
    }

    /* renamed from: ZfxDd */
    public C3008V7 m11300ZfxDd() {
        return this.f12724JHa;
    }

    /* renamed from: lgHUyS */
    public void m11301lgHUyS(C3008V7 c3008v7, Context context) {
        if (this.f12724JHa != c3008v7) {
            this.f12724JHa = c3008v7;
            if (c3008v7 != null) {
                c3008v7.m10677rkYL(context, this.f12727mjFkc, this.f12723AZxh);
                AZxh aZxh = (AZxh) this.f12725KLFTb.get();
                if (aZxh != null) {
                    this.f12727mjFkc.drawableState = aZxh.getState();
                }
                c3008v7.m10672YoKzxo(context, this.f12727mjFkc, this.f12723AZxh);
                this.f12726ZfxDd = true;
            }
            AZxh aZxh2 = (AZxh) this.f12725KLFTb.get();
            if (aZxh2 != null) {
                aZxh2.mo2846mjFkc();
                aZxh2.onStateChange(aZxh2.getState());
            }
        }
    }

    /* renamed from: qdMbNW */
    public void m11302qdMbNW(boolean z) {
        this.f12726ZfxDd = z;
    }

    /* renamed from: wA */
    public final float m11303wA(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f12727mjFkc.measureText(charSequence, 0, charSequence.length());
    }

    /* renamed from: xJ */
    public void m11304xJ(AZxh aZxh) {
        this.f12725KLFTb = new WeakReference(aZxh);
    }
}
