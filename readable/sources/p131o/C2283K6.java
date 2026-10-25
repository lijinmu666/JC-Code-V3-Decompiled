package p131o;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: o.K6 */
/* loaded from: classes.dex */
public class C2283K6 {

    /* renamed from: AZxh */
    public float f9107AZxh;

    /* renamed from: JHa */
    public float f9108JHa;

    /* renamed from: KLFTb */
    public float f9109KLFTb;

    /* renamed from: ZfxDd */
    public float f9110ZfxDd;

    /* renamed from: mjFkc */
    public float f9112mjFkc;

    /* renamed from: qdMbNW */
    public boolean f9113qdMbNW;

    /* renamed from: wA */
    public float f9114wA;

    /* renamed from: xJ */
    public final List f9115xJ = new ArrayList();

    /* renamed from: lgHUyS */
    public final List f9111lgHUyS = new ArrayList();

    /* renamed from: o.K6$AZxh */
    public static class AZxh extends xJ {

        /* renamed from: wA */
        public final ZfxDd f9116wA;

        public AZxh(ZfxDd zfxDd) {
            this.f9116wA = zfxDd;
        }

        @Override // p131o.C2283K6.xJ
        /* renamed from: mjFkc */
        public void mo9148mjFkc(Matrix matrix, C2073H6 c2073h6, int i, Canvas canvas) {
            c2073h6.m8514mjFkc(canvas, matrix, new RectF(this.f9116wA.m9163ETF(), this.f9116wA.m9173rkYL(), this.f9116wA.m9167VA(), this.f9116wA.m9162Dt()), i, this.f9116wA.m9165MiMN(), this.f9116wA.m9168YoKzxo());
        }
    }

    /* renamed from: o.K6$JHa */
    public static abstract class JHa {

        /* renamed from: mjFkc */
        public final Matrix f9117mjFkc = new Matrix();

        /* renamed from: mjFkc */
        public abstract void mo9149mjFkc(Matrix matrix, Path path);
    }

    /* renamed from: o.K6$KLFTb */
    public static class KLFTb extends JHa {

        /* renamed from: AZxh */
        public float f9118AZxh;

        /* renamed from: wA */
        public float f9119wA;

        @Override // p131o.C2283K6.JHa
        /* renamed from: mjFkc */
        public void mo9149mjFkc(Matrix matrix, Path path) {
            Matrix matrix2 = this.f9117mjFkc;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f9118AZxh, this.f9119wA);
            path.transform(matrix);
        }
    }

    /* renamed from: o.K6$ZfxDd */
    public static class ZfxDd extends JHa {

        /* renamed from: lgHUyS */
        public static final RectF f9120lgHUyS = new RectF();

        /* renamed from: AZxh */
        public float f9121AZxh;

        /* renamed from: JHa */
        public float f9122JHa;

        /* renamed from: KLFTb */
        public float f9123KLFTb;

        /* renamed from: ZfxDd */
        public float f9124ZfxDd;

        /* renamed from: wA */
        public float f9125wA;

        /* renamed from: xJ */
        public float f9126xJ;

        public ZfxDd(float f, float f2, float f3, float f4) {
            m9171fehf(f);
            m9170eyqo(f2);
            m9164IEE(f3);
            m9172qGY(f4);
        }

        /* renamed from: Dt */
        public final float m9162Dt() {
            return this.f9123KLFTb;
        }

        /* renamed from: ETF */
        public final float m9163ETF() {
            return this.f9121AZxh;
        }

        /* renamed from: IEE */
        public final void m9164IEE(float f) {
            this.f9124ZfxDd = f;
        }

        /* renamed from: MiMN */
        public final float m9165MiMN() {
            return this.f9122JHa;
        }

        /* renamed from: Pq */
        public final void m9166Pq(float f) {
            this.f9122JHa = f;
        }

        /* renamed from: VA */
        public final float m9167VA() {
            return this.f9124ZfxDd;
        }

        /* renamed from: YoKzxo */
        public final float m9168YoKzxo() {
            return this.f9126xJ;
        }

        /* renamed from: diqgf */
        public final void m9169diqgf(float f) {
            this.f9126xJ = f;
        }

        /* renamed from: eyqo */
        public final void m9170eyqo(float f) {
            this.f9125wA = f;
        }

        /* renamed from: fehf */
        public final void m9171fehf(float f) {
            this.f9121AZxh = f;
        }

        @Override // p131o.C2283K6.JHa
        /* renamed from: mjFkc */
        public void mo9149mjFkc(Matrix matrix, Path path) {
            Matrix matrix2 = this.f9117mjFkc;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f9120lgHUyS;
            rectF.set(m9163ETF(), m9173rkYL(), m9167VA(), m9162Dt());
            path.arcTo(rectF, m9165MiMN(), m9168YoKzxo(), false);
            path.transform(matrix);
        }

        /* renamed from: qGY */
        public final void m9172qGY(float f) {
            this.f9123KLFTb = f;
        }

        /* renamed from: rkYL */
        public final float m9173rkYL() {
            return this.f9125wA;
        }
    }

    /* renamed from: o.K6$mjFkc */
    public class mjFkc extends xJ {

        /* renamed from: ZfxDd */
        public final /* synthetic */ Matrix f9128ZfxDd;

        /* renamed from: wA */
        public final /* synthetic */ List f9129wA;

        public mjFkc(List list, Matrix matrix) {
            this.f9129wA = list;
            this.f9128ZfxDd = matrix;
        }

        @Override // p131o.C2283K6.xJ
        /* renamed from: mjFkc */
        public void mo9148mjFkc(Matrix matrix, C2073H6 c2073h6, int i, Canvas canvas) {
            Iterator it = this.f9129wA.iterator();
            while (it.hasNext()) {
                ((xJ) it.next()).mo9148mjFkc(this.f9128ZfxDd, c2073h6, i, canvas);
            }
        }
    }

    /* renamed from: o.K6$wA */
    public static class wA extends xJ {

        /* renamed from: KLFTb */
        public final float f9130KLFTb;

        /* renamed from: ZfxDd */
        public final float f9131ZfxDd;

        /* renamed from: wA */
        public final KLFTb f9132wA;

        public wA(KLFTb kLFTb, float f, float f2) {
            this.f9132wA = kLFTb;
            this.f9131ZfxDd = f;
            this.f9130KLFTb = f2;
        }

        @Override // p131o.C2283K6.xJ
        /* renamed from: mjFkc */
        public void mo9148mjFkc(Matrix matrix, C2073H6 c2073h6, int i, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f9132wA.f9119wA - this.f9130KLFTb, this.f9132wA.f9118AZxh - this.f9131ZfxDd), 0.0f);
            this.f9134mjFkc.set(matrix);
            this.f9134mjFkc.preTranslate(this.f9131ZfxDd, this.f9130KLFTb);
            this.f9134mjFkc.preRotate(m9174wA());
            c2073h6.m8512AZxh(canvas, this.f9134mjFkc, rectF, i);
        }

        /* renamed from: wA */
        public float m9174wA() {
            return (float) Math.toDegrees(Math.atan((this.f9132wA.f9119wA - this.f9130KLFTb) / (this.f9132wA.f9118AZxh - this.f9131ZfxDd)));
        }
    }

    /* renamed from: o.K6$xJ */
    public static abstract class xJ {

        /* renamed from: AZxh */
        public static final Matrix f9133AZxh = new Matrix();

        /* renamed from: mjFkc */
        public final Matrix f9134mjFkc = new Matrix();

        /* renamed from: AZxh */
        public final void m9175AZxh(C2073H6 c2073h6, int i, Canvas canvas) {
            mo9148mjFkc(f9133AZxh, c2073h6, i, canvas);
        }

        /* renamed from: mjFkc */
        public abstract void mo9148mjFkc(Matrix matrix, C2073H6 c2073h6, int i, Canvas canvas);
    }

    public C2283K6() {
        m9136YoKzxo(0.0f, 0.0f);
    }

    /* renamed from: AZxh */
    public final void m9127AZxh(float f) {
        if (m9147xJ() == f) {
            return;
        }
        float fM9147xJ = ((f - m9147xJ()) + 360.0f) % 360.0f;
        if (fM9147xJ > 180.0f) {
            return;
        }
        ZfxDd zfxDd = new ZfxDd(m9144qdMbNW(), m9128Dt(), m9144qdMbNW(), m9128Dt());
        zfxDd.m9166Pq(m9147xJ());
        zfxDd.m9169diqgf(fM9147xJ);
        this.f9111lgHUyS.add(new AZxh(zfxDd));
        m9143qGY(f);
    }

    /* renamed from: Dt */
    public float m9128Dt() {
        return this.f9110ZfxDd;
    }

    /* renamed from: ETF */
    public float m9129ETF() {
        return this.f9112mjFkc;
    }

    /* renamed from: IEE */
    public final void m9130IEE(float f) {
        this.f9114wA = f;
    }

    /* renamed from: JHa */
    public xJ m9131JHa(Matrix matrix) {
        m9127AZxh(m9141lgHUyS());
        return new mjFkc(new ArrayList(this.f9111lgHUyS), new Matrix(matrix));
    }

    /* renamed from: KLFTb */
    public boolean m9132KLFTb() {
        return this.f9113qdMbNW;
    }

    /* renamed from: MiMN */
    public void m9133MiMN(float f, float f2) {
        KLFTb kLFTb = new KLFTb();
        kLFTb.f9118AZxh = f;
        kLFTb.f9119wA = f2;
        this.f9115xJ.add(kLFTb);
        wA wAVar = new wA(kLFTb, m9144qdMbNW(), m9128Dt());
        m9146wA(wAVar, wAVar.m9174wA() + 270.0f, wAVar.m9174wA() + 270.0f);
        m9130IEE(f);
        m9134Pq(f2);
    }

    /* renamed from: Pq */
    public final void m9134Pq(float f) {
        this.f9110ZfxDd = f;
    }

    /* renamed from: VA */
    public float m9135VA() {
        return this.f9107AZxh;
    }

    /* renamed from: YoKzxo */
    public void m9136YoKzxo(float f, float f2) {
        m9145rkYL(f, f2, 270.0f, 0.0f);
    }

    /* renamed from: ZfxDd */
    public void m9137ZfxDd(Matrix matrix, Path path) {
        int size = this.f9115xJ.size();
        for (int i = 0; i < size; i++) {
            ((JHa) this.f9115xJ.get(i)).mo9149mjFkc(matrix, path);
        }
    }

    /* renamed from: diqgf */
    public final void m9138diqgf(float f) {
        this.f9112mjFkc = f;
    }

    /* renamed from: eyqo */
    public final void m9139eyqo(float f) {
        this.f9107AZxh = f;
    }

    /* renamed from: fehf */
    public final void m9140fehf(float f) {
        this.f9108JHa = f;
    }

    /* renamed from: lgHUyS */
    public final float m9141lgHUyS() {
        return this.f9108JHa;
    }

    /* renamed from: mjFkc */
    public void m9142mjFkc(float f, float f2, float f3, float f4, float f5, float f6) {
        ZfxDd zfxDd = new ZfxDd(f, f2, f3, f4);
        zfxDd.m9166Pq(f5);
        zfxDd.m9169diqgf(f6);
        this.f9115xJ.add(zfxDd);
        AZxh aZxh = new AZxh(zfxDd);
        float f7 = f5 + f6;
        boolean z = f6 < 0.0f;
        if (z) {
            f5 = (f5 + 180.0f) % 360.0f;
        }
        m9146wA(aZxh, f5, z ? (180.0f + f7) % 360.0f : f7);
        double d = f7;
        m9130IEE(((f + f3) * 0.5f) + (((f3 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(d)))));
        m9134Pq(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.sin(Math.toRadians(d)))));
    }

    /* renamed from: qGY */
    public final void m9143qGY(float f) {
        this.f9109KLFTb = f;
    }

    /* renamed from: qdMbNW */
    public float m9144qdMbNW() {
        return this.f9114wA;
    }

    /* renamed from: rkYL */
    public void m9145rkYL(float f, float f2, float f3, float f4) {
        m9138diqgf(f);
        m9139eyqo(f2);
        m9130IEE(f);
        m9134Pq(f2);
        m9143qGY(f3);
        m9140fehf((f3 + f4) % 360.0f);
        this.f9115xJ.clear();
        this.f9111lgHUyS.clear();
        this.f9113qdMbNW = false;
    }

    /* renamed from: wA */
    public final void m9146wA(xJ xJVar, float f, float f2) {
        m9127AZxh(f);
        this.f9111lgHUyS.add(xJVar);
        m9143qGY(f2);
    }

    /* renamed from: xJ */
    public final float m9147xJ() {
        return this.f9109KLFTb;
    }
}
