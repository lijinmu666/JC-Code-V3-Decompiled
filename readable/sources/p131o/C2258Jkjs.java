package p131o;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.p020emoji2.p021text.C0084wA;

/* renamed from: o.Jkjs */
/* loaded from: classes.dex */
public final class C2258Jkjs {

    /* renamed from: mjFkc */
    public final AZxh f9035mjFkc;

    /* renamed from: o.Jkjs$AZxh */
    public static class AZxh {
        /* renamed from: AZxh */
        public abstract void mo9039AZxh(boolean z);

        /* renamed from: mjFkc */
        public abstract InputFilter[] mo9040mjFkc(InputFilter[] inputFilterArr);

        /* renamed from: wA */
        public abstract void mo9041wA(boolean z);
    }

    /* renamed from: o.Jkjs$mjFkc */
    public static class mjFkc extends AZxh {

        /* renamed from: AZxh */
        public final C2199IxLrZ f9036AZxh;

        /* renamed from: mjFkc */
        public final TextView f9037mjFkc;

        /* renamed from: wA */
        public boolean f9038wA = true;

        public mjFkc(TextView textView) {
            this.f9037mjFkc = textView;
            this.f9036AZxh = new C2199IxLrZ(textView);
        }

        @Override // p131o.C2258Jkjs.AZxh
        /* renamed from: AZxh */
        public void mo9039AZxh(boolean z) {
            if (z) {
                m9042Dt();
            }
        }

        /* renamed from: Dt */
        public void m9042Dt() {
            this.f9037mjFkc.setTransformationMethod(m9046VA(this.f9037mjFkc.getTransformationMethod()));
        }

        /* renamed from: ETF */
        public final TransformationMethod m9043ETF(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof C4184mz) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new C4184mz(transformationMethod);
        }

        /* renamed from: JHa */
        public final InputFilter[] m9044JHa(InputFilter[] inputFilterArr) {
            SparseArray sparseArrayM9045KLFTb = m9045KLFTb(inputFilterArr);
            if (sparseArrayM9045KLFTb.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArrayM9045KLFTb.size()];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (sparseArrayM9045KLFTb.indexOfKey(i2) < 0) {
                    inputFilterArr2[i] = inputFilterArr[i2];
                    i++;
                }
            }
            return inputFilterArr2;
        }

        /* renamed from: KLFTb */
        public final SparseArray m9045KLFTb(InputFilter[] inputFilterArr) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < inputFilterArr.length; i++) {
                InputFilter inputFilter = inputFilterArr[i];
                if (inputFilter instanceof C2199IxLrZ) {
                    sparseArray.put(i, inputFilter);
                }
            }
            return sparseArray;
        }

        /* renamed from: VA */
        public TransformationMethod m9046VA(TransformationMethod transformationMethod) {
            return this.f9038wA ? m9043ETF(transformationMethod) : m9048lgHUyS(transformationMethod);
        }

        /* renamed from: ZfxDd */
        public final InputFilter[] m9047ZfxDd(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f9036AZxh) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f9036AZxh;
            return inputFilterArr2;
        }

        /* renamed from: lgHUyS */
        public final TransformationMethod m9048lgHUyS(TransformationMethod transformationMethod) {
            return transformationMethod instanceof C4184mz ? ((C4184mz) transformationMethod).m12819mjFkc() : transformationMethod;
        }

        @Override // p131o.C2258Jkjs.AZxh
        /* renamed from: mjFkc */
        public InputFilter[] mo9040mjFkc(InputFilter[] inputFilterArr) {
            return !this.f9038wA ? m9044JHa(inputFilterArr) : m9047ZfxDd(inputFilterArr);
        }

        /* renamed from: qdMbNW */
        public final void m9049qdMbNW() {
            this.f9037mjFkc.setFilters(mo9040mjFkc(this.f9037mjFkc.getFilters()));
        }

        @Override // p131o.C2258Jkjs.AZxh
        /* renamed from: wA */
        public void mo9041wA(boolean z) {
            this.f9038wA = z;
            m9042Dt();
            m9049qdMbNW();
        }

        /* renamed from: xJ */
        public void m9050xJ(boolean z) {
            this.f9038wA = z;
        }
    }

    /* renamed from: o.Jkjs$wA */
    public static class wA extends AZxh {

        /* renamed from: mjFkc */
        public final mjFkc f9039mjFkc;

        public wA(TextView textView) {
            this.f9039mjFkc = new mjFkc(textView);
        }

        @Override // p131o.C2258Jkjs.AZxh
        /* renamed from: AZxh */
        public void mo9039AZxh(boolean z) {
            if (m9051ZfxDd()) {
                return;
            }
            this.f9039mjFkc.mo9039AZxh(z);
        }

        /* renamed from: ZfxDd */
        public final boolean m9051ZfxDd() {
            return !C0084wA.m691lgHUyS();
        }

        @Override // p131o.C2258Jkjs.AZxh
        /* renamed from: mjFkc */
        public InputFilter[] mo9040mjFkc(InputFilter[] inputFilterArr) {
            return m9051ZfxDd() ? inputFilterArr : this.f9039mjFkc.mo9040mjFkc(inputFilterArr);
        }

        @Override // p131o.C2258Jkjs.AZxh
        /* renamed from: wA */
        public void mo9041wA(boolean z) {
            if (m9051ZfxDd()) {
                this.f9039mjFkc.m9050xJ(z);
            } else {
                this.f9039mjFkc.mo9041wA(z);
            }
        }
    }

    public C2258Jkjs(TextView textView, boolean z) {
        AbstractC2280K3.m9122lgHUyS(textView, "textView cannot be null");
        if (z) {
            this.f9035mjFkc = new mjFkc(textView);
        } else {
            this.f9035mjFkc = new wA(textView);
        }
    }

    /* renamed from: AZxh */
    public void m9036AZxh(boolean z) {
        this.f9035mjFkc.mo9039AZxh(z);
    }

    /* renamed from: mjFkc */
    public InputFilter[] m9037mjFkc(InputFilter[] inputFilterArr) {
        return this.f9035mjFkc.mo9040mjFkc(inputFilterArr);
    }

    /* renamed from: wA */
    public void m9038wA(boolean z) {
        this.f9035mjFkc.mo9041wA(z);
    }
}
