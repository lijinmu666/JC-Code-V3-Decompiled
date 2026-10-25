package p131o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* renamed from: o.I6 */
/* loaded from: classes.dex */
public class C2141I6 {

    /* renamed from: MiMN */
    public static final InterfaceC3498cQmsjG f8687MiMN = new C3801h5(0.5f);

    /* renamed from: AZxh */
    public AbstractC4638tnpR f8688AZxh;

    /* renamed from: Dt */
    public C4475rKxis f8689Dt;

    /* renamed from: ETF */
    public C4475rKxis f8690ETF;

    /* renamed from: JHa */
    public InterfaceC3498cQmsjG f8691JHa;

    /* renamed from: KLFTb */
    public InterfaceC3498cQmsjG f8692KLFTb;

    /* renamed from: VA */
    public C4475rKxis f8693VA;

    /* renamed from: ZfxDd */
    public AbstractC4638tnpR f8694ZfxDd;

    /* renamed from: lgHUyS */
    public InterfaceC3498cQmsjG f8695lgHUyS;

    /* renamed from: mjFkc */
    public AbstractC4638tnpR f8696mjFkc;

    /* renamed from: qdMbNW */
    public C4475rKxis f8697qdMbNW;

    /* renamed from: wA */
    public AbstractC4638tnpR f8698wA;

    /* renamed from: xJ */
    public InterfaceC3498cQmsjG f8699xJ;

    /* renamed from: o.I6$wA */
    public interface wA {
        /* renamed from: mjFkc */
        InterfaceC3498cQmsjG mo8713mjFkc(InterfaceC3498cQmsjG interfaceC3498cQmsjG);
    }

    /* renamed from: AZxh */
    public static AZxh m8656AZxh(Context context, int i, int i2) {
        return m8662wA(context, i, i2, 0);
    }

    /* renamed from: JHa */
    public static AZxh m8657JHa(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        return m8663xJ(context, attributeSet, i, i2, new C3311ZfxDd(i3));
    }

    /* renamed from: KLFTb */
    public static AZxh m8658KLFTb(Context context, AttributeSet attributeSet, int i, int i2) {
        return m8657JHa(context, attributeSet, i, i2, 0);
    }

    /* renamed from: MiMN */
    public static InterfaceC3498cQmsjG m8659MiMN(TypedArray typedArray, int i, InterfaceC3498cQmsjG interfaceC3498cQmsjG) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue == null) {
            return interfaceC3498cQmsjG;
        }
        int i2 = typedValuePeekValue.type;
        return i2 == 5 ? new C3311ZfxDd(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics())) : i2 == 6 ? new C3801h5(typedValuePeekValue.getFraction(1.0f, 1.0f)) : interfaceC3498cQmsjG;
    }

    /* renamed from: ZfxDd */
    public static AZxh m8660ZfxDd(Context context, int i, int i2, InterfaceC3498cQmsjG interfaceC3498cQmsjG) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
        if (i2 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i2);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(AbstractC3340a5.f12691xM);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(AbstractC3340a5.f12388Io, 0);
            int i4 = typedArrayObtainStyledAttributes.getInt(AbstractC3340a5.f12351Eey, i3);
            int i5 = typedArrayObtainStyledAttributes.getInt(AbstractC3340a5.f12465SllyO, i3);
            int i6 = typedArrayObtainStyledAttributes.getInt(AbstractC3340a5.f12704zabxk, i3);
            int i7 = typedArrayObtainStyledAttributes.getInt(AbstractC3340a5.f12612nTET, i3);
            InterfaceC3498cQmsjG interfaceC3498cQmsjGM8659MiMN = m8659MiMN(typedArrayObtainStyledAttributes, AbstractC3340a5.f12637qqdo, interfaceC3498cQmsjG);
            InterfaceC3498cQmsjG interfaceC3498cQmsjGM8659MiMN2 = m8659MiMN(typedArrayObtainStyledAttributes, AbstractC3340a5.f12406JtIAgM, interfaceC3498cQmsjGM8659MiMN);
            InterfaceC3498cQmsjG interfaceC3498cQmsjGM8659MiMN3 = m8659MiMN(typedArrayObtainStyledAttributes, AbstractC3340a5.f12453RV, interfaceC3498cQmsjGM8659MiMN);
            InterfaceC3498cQmsjG interfaceC3498cQmsjGM8659MiMN4 = m8659MiMN(typedArrayObtainStyledAttributes, AbstractC3340a5.f12607mZG, interfaceC3498cQmsjGM8659MiMN);
            return new AZxh().m8696HGpJ(i4, interfaceC3498cQmsjGM8659MiMN2).m8707lB(i5, interfaceC3498cQmsjGM8659MiMN3).m8704eyqo(i6, interfaceC3498cQmsjGM8659MiMN4).m8705fehf(i7, m8659MiMN(typedArrayObtainStyledAttributes, AbstractC3340a5.f12445QQi, interfaceC3498cQmsjGM8659MiMN));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: mjFkc */
    public static AZxh m8661mjFkc() {
        return new AZxh();
    }

    /* renamed from: wA */
    public static AZxh m8662wA(Context context, int i, int i2, int i3) {
        return m8660ZfxDd(context, i, i2, new C3311ZfxDd(i3));
    }

    /* renamed from: xJ */
    public static AZxh m8663xJ(Context context, AttributeSet attributeSet, int i, int i2, InterfaceC3498cQmsjG interfaceC3498cQmsjG) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3340a5.f12368GEj, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(AbstractC3340a5.f12600lEKdq, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(AbstractC3340a5.f12585joWJO, 0);
        typedArrayObtainStyledAttributes.recycle();
        return m8660ZfxDd(context, resourceId, resourceId2, interfaceC3498cQmsjG);
    }

    /* renamed from: Dt */
    public InterfaceC3498cQmsjG m8664Dt() {
        return this.f8695lgHUyS;
    }

    /* renamed from: ETF */
    public AbstractC4638tnpR m8665ETF() {
        return this.f8698wA;
    }

    /* renamed from: Gd */
    public C2141I6 m8666Gd(InterfaceC3498cQmsjG interfaceC3498cQmsjG) {
        return m8670Ucbh().m8709qGY(interfaceC3498cQmsjG).m8698MiMN();
    }

    /* renamed from: HGpJ */
    public C2141I6 m8667HGpJ(wA wAVar) {
        return m8670Ucbh().m8694BAnRFn(wAVar.mo8713mjFkc(m8668IEE())).m8699OjSQV(wAVar.mo8713mjFkc(m8673diqgf())).m8703diqgf(wAVar.mo8713mjFkc(m8664Dt())).m8695Gd(wAVar.mo8713mjFkc(m8671VA())).m8698MiMN();
    }

    /* renamed from: IEE */
    public InterfaceC3498cQmsjG m8668IEE() {
        return this.f8692KLFTb;
    }

    /* renamed from: Pq */
    public AbstractC4638tnpR m8669Pq() {
        return this.f8688AZxh;
    }

    /* renamed from: Ucbh */
    public AZxh m8670Ucbh() {
        return new AZxh(this);
    }

    /* renamed from: VA */
    public InterfaceC3498cQmsjG m8671VA() {
        return this.f8699xJ;
    }

    /* renamed from: YoKzxo */
    public C4475rKxis m8672YoKzxo() {
        return this.f8693VA;
    }

    /* renamed from: diqgf */
    public InterfaceC3498cQmsjG m8673diqgf() {
        return this.f8691JHa;
    }

    /* renamed from: eyqo */
    public boolean m8674eyqo(RectF rectF) {
        boolean z = this.f8693VA.getClass().equals(C4475rKxis.class) && this.f8689Dt.getClass().equals(C4475rKxis.class) && this.f8697qdMbNW.getClass().equals(C4475rKxis.class) && this.f8690ETF.getClass().equals(C4475rKxis.class);
        float fMo9185mjFkc = this.f8692KLFTb.mo9185mjFkc(rectF);
        return z && ((this.f8691JHa.mo9185mjFkc(rectF) > fMo9185mjFkc ? 1 : (this.f8691JHa.mo9185mjFkc(rectF) == fMo9185mjFkc ? 0 : -1)) == 0 && (this.f8695lgHUyS.mo9185mjFkc(rectF) > fMo9185mjFkc ? 1 : (this.f8695lgHUyS.mo9185mjFkc(rectF) == fMo9185mjFkc ? 0 : -1)) == 0 && (this.f8699xJ.mo9185mjFkc(rectF) > fMo9185mjFkc ? 1 : (this.f8699xJ.mo9185mjFkc(rectF) == fMo9185mjFkc ? 0 : -1)) == 0) && ((this.f8688AZxh instanceof C2072H5) && (this.f8696mjFkc instanceof C2072H5) && (this.f8698wA instanceof C2072H5) && (this.f8694ZfxDd instanceof C2072H5));
    }

    /* renamed from: fehf */
    public AbstractC4638tnpR m8675fehf() {
        return this.f8696mjFkc;
    }

    /* renamed from: huTpC */
    public C2141I6 m8676huTpC(float f) {
        return m8670Ucbh().m8710rkYL(f).m8698MiMN();
    }

    /* renamed from: lgHUyS */
    public C4475rKxis m8677lgHUyS() {
        return this.f8690ETF;
    }

    /* renamed from: qGY */
    public C4475rKxis m8678qGY() {
        return this.f8697qdMbNW;
    }

    /* renamed from: qdMbNW */
    public AbstractC4638tnpR m8679qdMbNW() {
        return this.f8694ZfxDd;
    }

    /* renamed from: rkYL */
    public C4475rKxis m8680rkYL() {
        return this.f8689Dt;
    }

    public C2141I6(AZxh aZxh) {
        this.f8696mjFkc = aZxh.f8708mjFkc;
        this.f8688AZxh = aZxh.f8700AZxh;
        this.f8698wA = aZxh.f8710wA;
        this.f8694ZfxDd = aZxh.f8706ZfxDd;
        this.f8692KLFTb = aZxh.f8704KLFTb;
        this.f8691JHa = aZxh.f8703JHa;
        this.f8699xJ = aZxh.f8711xJ;
        this.f8695lgHUyS = aZxh.f8707lgHUyS;
        this.f8697qdMbNW = aZxh.f8709qdMbNW;
        this.f8689Dt = aZxh.f8701Dt;
        this.f8690ETF = aZxh.f8702ETF;
        this.f8693VA = aZxh.f8705VA;
    }

    /* renamed from: o.I6$AZxh */
    public static final class AZxh {

        /* renamed from: AZxh */
        public AbstractC4638tnpR f8700AZxh;

        /* renamed from: Dt */
        public C4475rKxis f8701Dt;

        /* renamed from: ETF */
        public C4475rKxis f8702ETF;

        /* renamed from: JHa */
        public InterfaceC3498cQmsjG f8703JHa;

        /* renamed from: KLFTb */
        public InterfaceC3498cQmsjG f8704KLFTb;

        /* renamed from: VA */
        public C4475rKxis f8705VA;

        /* renamed from: ZfxDd */
        public AbstractC4638tnpR f8706ZfxDd;

        /* renamed from: lgHUyS */
        public InterfaceC3498cQmsjG f8707lgHUyS;

        /* renamed from: mjFkc */
        public AbstractC4638tnpR f8708mjFkc;

        /* renamed from: qdMbNW */
        public C4475rKxis f8709qdMbNW;

        /* renamed from: wA */
        public AbstractC4638tnpR f8710wA;

        /* renamed from: xJ */
        public InterfaceC3498cQmsjG f8711xJ;

        public AZxh() {
            this.f8708mjFkc = AbstractC2607P1.m9939AZxh();
            this.f8700AZxh = AbstractC2607P1.m9939AZxh();
            this.f8710wA = AbstractC2607P1.m9939AZxh();
            this.f8706ZfxDd = AbstractC2607P1.m9939AZxh();
            this.f8704KLFTb = new C3311ZfxDd(0.0f);
            this.f8703JHa = new C3311ZfxDd(0.0f);
            this.f8711xJ = new C3311ZfxDd(0.0f);
            this.f8707lgHUyS = new C3311ZfxDd(0.0f);
            this.f8709qdMbNW = AbstractC2607P1.m9944wA();
            this.f8701Dt = AbstractC2607P1.m9944wA();
            this.f8702ETF = AbstractC2607P1.m9944wA();
            this.f8705VA = AbstractC2607P1.m9944wA();
        }

        /* renamed from: YoKzxo */
        public static float m8687YoKzxo(AbstractC4638tnpR abstractC4638tnpR) {
            if (abstractC4638tnpR instanceof C2072H5) {
                return ((C2072H5) abstractC4638tnpR).f8532mjFkc;
            }
            if (abstractC4638tnpR instanceof C2990UqgK) {
                return ((C2990UqgK) abstractC4638tnpR).f10918mjFkc;
            }
            return -1.0f;
        }

        /* renamed from: BAnRFn */
        public AZxh m8694BAnRFn(InterfaceC3498cQmsjG interfaceC3498cQmsjG) {
            this.f8704KLFTb = interfaceC3498cQmsjG;
            return this;
        }

        /* renamed from: Gd */
        public AZxh m8695Gd(InterfaceC3498cQmsjG interfaceC3498cQmsjG) {
            this.f8711xJ = interfaceC3498cQmsjG;
            return this;
        }

        /* renamed from: HGpJ */
        public AZxh m8696HGpJ(int i, InterfaceC3498cQmsjG interfaceC3498cQmsjG) {
            return m8711vI(AbstractC2607P1.m9943mjFkc(i)).m8694BAnRFn(interfaceC3498cQmsjG);
        }

        /* renamed from: IEE */
        public AZxh m8697IEE(AbstractC4638tnpR abstractC4638tnpR) {
            this.f8706ZfxDd = abstractC4638tnpR;
            float fM8687YoKzxo = m8687YoKzxo(abstractC4638tnpR);
            if (fM8687YoKzxo != -1.0f) {
                m8700Pq(fM8687YoKzxo);
            }
            return this;
        }

        /* renamed from: MiMN */
        public C2141I6 m8698MiMN() {
            return new C2141I6(this);
        }

        /* renamed from: OjSQV */
        public AZxh m8699OjSQV(InterfaceC3498cQmsjG interfaceC3498cQmsjG) {
            this.f8703JHa = interfaceC3498cQmsjG;
            return this;
        }

        /* renamed from: Pq */
        public AZxh m8700Pq(float f) {
            this.f8707lgHUyS = new C3311ZfxDd(f);
            return this;
        }

        /* renamed from: Ucbh */
        public AZxh m8701Ucbh(AbstractC4638tnpR abstractC4638tnpR) {
            this.f8710wA = abstractC4638tnpR;
            float fM8687YoKzxo = m8687YoKzxo(abstractC4638tnpR);
            if (fM8687YoKzxo != -1.0f) {
                m8706huTpC(fM8687YoKzxo);
            }
            return this;
        }

        /* renamed from: VocHEe */
        public AZxh m8702VocHEe(float f) {
            this.f8704KLFTb = new C3311ZfxDd(f);
            return this;
        }

        /* renamed from: diqgf */
        public AZxh m8703diqgf(InterfaceC3498cQmsjG interfaceC3498cQmsjG) {
            this.f8707lgHUyS = interfaceC3498cQmsjG;
            return this;
        }

        /* renamed from: eyqo */
        public AZxh m8704eyqo(int i, InterfaceC3498cQmsjG interfaceC3498cQmsjG) {
            return m8701Ucbh(AbstractC2607P1.m9943mjFkc(i)).m8695Gd(interfaceC3498cQmsjG);
        }

        /* renamed from: fehf */
        public AZxh m8705fehf(int i, InterfaceC3498cQmsjG interfaceC3498cQmsjG) {
            return m8697IEE(AbstractC2607P1.m9943mjFkc(i)).m8703diqgf(interfaceC3498cQmsjG);
        }

        /* renamed from: huTpC */
        public AZxh m8706huTpC(float f) {
            this.f8711xJ = new C3311ZfxDd(f);
            return this;
        }

        /* renamed from: lB */
        public AZxh m8707lB(int i, InterfaceC3498cQmsjG interfaceC3498cQmsjG) {
            return m8712wJVbdd(AbstractC2607P1.m9943mjFkc(i)).m8699OjSQV(interfaceC3498cQmsjG);
        }

        /* renamed from: mByQ */
        public AZxh m8708mByQ(float f) {
            this.f8703JHa = new C3311ZfxDd(f);
            return this;
        }

        /* renamed from: qGY */
        public AZxh m8709qGY(InterfaceC3498cQmsjG interfaceC3498cQmsjG) {
            return m8694BAnRFn(interfaceC3498cQmsjG).m8699OjSQV(interfaceC3498cQmsjG).m8695Gd(interfaceC3498cQmsjG).m8703diqgf(interfaceC3498cQmsjG);
        }

        /* renamed from: rkYL */
        public AZxh m8710rkYL(float f) {
            return m8702VocHEe(f).m8708mByQ(f).m8706huTpC(f).m8700Pq(f);
        }

        /* renamed from: vI */
        public AZxh m8711vI(AbstractC4638tnpR abstractC4638tnpR) {
            this.f8708mjFkc = abstractC4638tnpR;
            float fM8687YoKzxo = m8687YoKzxo(abstractC4638tnpR);
            if (fM8687YoKzxo != -1.0f) {
                m8702VocHEe(fM8687YoKzxo);
            }
            return this;
        }

        /* renamed from: wJVbdd */
        public AZxh m8712wJVbdd(AbstractC4638tnpR abstractC4638tnpR) {
            this.f8700AZxh = abstractC4638tnpR;
            float fM8687YoKzxo = m8687YoKzxo(abstractC4638tnpR);
            if (fM8687YoKzxo != -1.0f) {
                m8708mByQ(fM8687YoKzxo);
            }
            return this;
        }

        public AZxh(C2141I6 c2141i6) {
            this.f8708mjFkc = AbstractC2607P1.m9939AZxh();
            this.f8700AZxh = AbstractC2607P1.m9939AZxh();
            this.f8710wA = AbstractC2607P1.m9939AZxh();
            this.f8706ZfxDd = AbstractC2607P1.m9939AZxh();
            this.f8704KLFTb = new C3311ZfxDd(0.0f);
            this.f8703JHa = new C3311ZfxDd(0.0f);
            this.f8711xJ = new C3311ZfxDd(0.0f);
            this.f8707lgHUyS = new C3311ZfxDd(0.0f);
            this.f8709qdMbNW = AbstractC2607P1.m9944wA();
            this.f8701Dt = AbstractC2607P1.m9944wA();
            this.f8702ETF = AbstractC2607P1.m9944wA();
            this.f8705VA = AbstractC2607P1.m9944wA();
            this.f8708mjFkc = c2141i6.f8696mjFkc;
            this.f8700AZxh = c2141i6.f8688AZxh;
            this.f8710wA = c2141i6.f8698wA;
            this.f8706ZfxDd = c2141i6.f8694ZfxDd;
            this.f8704KLFTb = c2141i6.f8692KLFTb;
            this.f8703JHa = c2141i6.f8691JHa;
            this.f8711xJ = c2141i6.f8699xJ;
            this.f8707lgHUyS = c2141i6.f8695lgHUyS;
            this.f8709qdMbNW = c2141i6.f8697qdMbNW;
            this.f8701Dt = c2141i6.f8689Dt;
            this.f8702ETF = c2141i6.f8690ETF;
            this.f8705VA = c2141i6.f8693VA;
        }
    }

    public C2141I6() {
        this.f8696mjFkc = AbstractC2607P1.m9939AZxh();
        this.f8688AZxh = AbstractC2607P1.m9939AZxh();
        this.f8698wA = AbstractC2607P1.m9939AZxh();
        this.f8694ZfxDd = AbstractC2607P1.m9939AZxh();
        this.f8692KLFTb = new C3311ZfxDd(0.0f);
        this.f8691JHa = new C3311ZfxDd(0.0f);
        this.f8699xJ = new C3311ZfxDd(0.0f);
        this.f8695lgHUyS = new C3311ZfxDd(0.0f);
        this.f8697qdMbNW = AbstractC2607P1.m9944wA();
        this.f8689Dt = AbstractC2607P1.m9944wA();
        this.f8690ETF = AbstractC2607P1.m9944wA();
        this.f8693VA = AbstractC2607P1.m9944wA();
    }
}
