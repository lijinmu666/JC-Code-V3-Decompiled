package p131o;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* renamed from: o.J6 */
/* loaded from: classes.dex */
public class C2210J6 {

    /* renamed from: mjFkc */
    public final C2283K6[] f8871mjFkc = new C2283K6[4];

    /* renamed from: AZxh */
    public final Matrix[] f8863AZxh = new Matrix[4];

    /* renamed from: wA */
    public final Matrix[] f8873wA = new Matrix[4];

    /* renamed from: ZfxDd */
    public final PointF f8869ZfxDd = new PointF();

    /* renamed from: KLFTb */
    public final Path f8867KLFTb = new Path();

    /* renamed from: JHa */
    public final Path f8866JHa = new Path();

    /* renamed from: xJ */
    public final C2283K6 f8874xJ = new C2283K6();

    /* renamed from: lgHUyS */
    public final float[] f8870lgHUyS = new float[2];

    /* renamed from: qdMbNW */
    public final float[] f8872qdMbNW = new float[2];

    /* renamed from: Dt */
    public final Path f8864Dt = new Path();

    /* renamed from: ETF */
    public final Path f8865ETF = new Path();

    /* renamed from: VA */
    public boolean f8868VA = true;

    /* renamed from: o.J6$AZxh */
    public interface AZxh {
        /* renamed from: AZxh */
        void mo8905AZxh(C2283K6 c2283k6, Matrix matrix, int i);

        /* renamed from: mjFkc */
        void mo8906mjFkc(C2283K6 c2283k6, Matrix matrix, int i);
    }

    /* renamed from: o.J6$mjFkc */
    public static class mjFkc {

        /* renamed from: mjFkc */
        public static final C2210J6 f8875mjFkc = new C2210J6();
    }

    /* renamed from: o.J6$wA */
    public static final class wA {

        /* renamed from: AZxh */
        public final Path f8876AZxh;

        /* renamed from: KLFTb */
        public final float f8877KLFTb;

        /* renamed from: ZfxDd */
        public final AZxh f8878ZfxDd;

        /* renamed from: mjFkc */
        public final C2141I6 f8879mjFkc;

        /* renamed from: wA */
        public final RectF f8880wA;

        public wA(C2141I6 c2141i6, float f, RectF rectF, AZxh aZxh, Path path) {
            this.f8878ZfxDd = aZxh;
            this.f8879mjFkc = c2141i6;
            this.f8877KLFTb = f;
            this.f8880wA = rectF;
            this.f8876AZxh = path;
        }
    }

    public C2210J6() {
        for (int i = 0; i < 4; i++) {
            this.f8871mjFkc[i] = new C2283K6();
            this.f8863AZxh[i] = new Matrix();
            this.f8873wA[i] = new Matrix();
        }
    }

    /* renamed from: ETF */
    public static C2210J6 m8891ETF() {
        return mjFkc.f8875mjFkc;
    }

    /* renamed from: AZxh */
    public final void m8892AZxh(wA wAVar, int i) {
        this.f8870lgHUyS[0] = this.f8871mjFkc[i].m9129ETF();
        this.f8870lgHUyS[1] = this.f8871mjFkc[i].m9135VA();
        this.f8863AZxh[i].mapPoints(this.f8870lgHUyS);
        if (i == 0) {
            Path path = wAVar.f8876AZxh;
            float[] fArr = this.f8870lgHUyS;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = wAVar.f8876AZxh;
            float[] fArr2 = this.f8870lgHUyS;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f8871mjFkc[i].m9137ZfxDd(this.f8863AZxh[i], wAVar.f8876AZxh);
        AZxh aZxh = wAVar.f8878ZfxDd;
        if (aZxh != null) {
            aZxh.mo8905AZxh(this.f8871mjFkc[i], this.f8863AZxh[i], i);
        }
    }

    /* renamed from: Dt */
    public final C4475rKxis m8893Dt(int i, C2141I6 c2141i6) {
        return i != 1 ? i != 2 ? i != 3 ? c2141i6.m8680rkYL() : c2141i6.m8678qGY() : c2141i6.m8672YoKzxo() : c2141i6.m8677lgHUyS();
    }

    /* renamed from: JHa */
    public final void m8894JHa(int i, RectF rectF, PointF pointF) {
        if (i == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    /* renamed from: KLFTb */
    public void m8895KLFTb(C2141I6 c2141i6, float f, RectF rectF, AZxh aZxh, Path path) {
        path.rewind();
        this.f8867KLFTb.rewind();
        this.f8866JHa.rewind();
        this.f8866JHa.addRect(rectF, Path.Direction.CW);
        wA wAVar = new wA(c2141i6, f, rectF, aZxh, path);
        for (int i = 0; i < 4; i++) {
            m8896MiMN(wAVar, i);
            m8898YoKzxo(i);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            m8892AZxh(wAVar, i2);
            m8903wA(wAVar, i2);
        }
        path.close();
        this.f8867KLFTb.close();
        if (this.f8867KLFTb.isEmpty()) {
            return;
        }
        path.op(this.f8867KLFTb, Path.Op.UNION);
    }

    /* renamed from: MiMN */
    public final void m8896MiMN(wA wAVar, int i) {
        m8900lgHUyS(i, wAVar.f8879mjFkc).m13649AZxh(this.f8871mjFkc[i], 90.0f, wAVar.f8877KLFTb, wAVar.f8880wA, m8904xJ(i, wAVar.f8879mjFkc));
        float fM8901mjFkc = m8901mjFkc(i);
        this.f8863AZxh[i].reset();
        m8894JHa(i, wAVar.f8880wA, this.f8869ZfxDd);
        Matrix matrix = this.f8863AZxh[i];
        PointF pointF = this.f8869ZfxDd;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f8863AZxh[i].preRotate(fM8901mjFkc);
    }

    /* renamed from: VA */
    public final boolean m8897VA(Path path, int i) {
        this.f8865ETF.reset();
        this.f8871mjFkc[i].m9137ZfxDd(this.f8863AZxh[i], this.f8865ETF);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f8865ETF.computeBounds(rectF, true);
        path.op(this.f8865ETF, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    /* renamed from: YoKzxo */
    public final void m8898YoKzxo(int i) {
        this.f8870lgHUyS[0] = this.f8871mjFkc[i].m9144qdMbNW();
        this.f8870lgHUyS[1] = this.f8871mjFkc[i].m9128Dt();
        this.f8863AZxh[i].mapPoints(this.f8870lgHUyS);
        float fM8901mjFkc = m8901mjFkc(i);
        this.f8873wA[i].reset();
        Matrix matrix = this.f8873wA[i];
        float[] fArr = this.f8870lgHUyS;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f8873wA[i].preRotate(fM8901mjFkc);
    }

    /* renamed from: ZfxDd */
    public void m8899ZfxDd(C2141I6 c2141i6, float f, RectF rectF, Path path) {
        m8895KLFTb(c2141i6, f, rectF, null, path);
    }

    /* renamed from: lgHUyS */
    public final AbstractC4638tnpR m8900lgHUyS(int i, C2141I6 c2141i6) {
        return i != 1 ? i != 2 ? i != 3 ? c2141i6.m8669Pq() : c2141i6.m8675fehf() : c2141i6.m8679qdMbNW() : c2141i6.m8665ETF();
    }

    /* renamed from: mjFkc */
    public final float m8901mjFkc(int i) {
        return ((i + 1) % 4) * 90;
    }

    /* renamed from: qdMbNW */
    public final float m8902qdMbNW(RectF rectF, int i) {
        float[] fArr = this.f8870lgHUyS;
        C2283K6 c2283k6 = this.f8871mjFkc[i];
        fArr[0] = c2283k6.f9114wA;
        fArr[1] = c2283k6.f9110ZfxDd;
        this.f8863AZxh[i].mapPoints(fArr);
        return (i == 1 || i == 3) ? Math.abs(rectF.centerX() - this.f8870lgHUyS[0]) : Math.abs(rectF.centerY() - this.f8870lgHUyS[1]);
    }

    /* renamed from: wA */
    public final void m8903wA(wA wAVar, int i) {
        int i2 = (i + 1) % 4;
        this.f8870lgHUyS[0] = this.f8871mjFkc[i].m9144qdMbNW();
        this.f8870lgHUyS[1] = this.f8871mjFkc[i].m9128Dt();
        this.f8863AZxh[i].mapPoints(this.f8870lgHUyS);
        this.f8872qdMbNW[0] = this.f8871mjFkc[i2].m9129ETF();
        this.f8872qdMbNW[1] = this.f8871mjFkc[i2].m9135VA();
        this.f8863AZxh[i2].mapPoints(this.f8872qdMbNW);
        float f = this.f8870lgHUyS[0];
        float[] fArr = this.f8872qdMbNW;
        float fMax = Math.max(((float) Math.hypot(f - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float fM8902qdMbNW = m8902qdMbNW(wAVar.f8880wA, i);
        this.f8874xJ.m9136YoKzxo(0.0f, 0.0f);
        C4475rKxis c4475rKxisM8893Dt = m8893Dt(i, wAVar.f8879mjFkc);
        c4475rKxisM8893Dt.m13372AZxh(fMax, fM8902qdMbNW, wAVar.f8877KLFTb, this.f8874xJ);
        this.f8864Dt.reset();
        this.f8874xJ.m9137ZfxDd(this.f8873wA[i], this.f8864Dt);
        if (this.f8868VA && (c4475rKxisM8893Dt.m13373mjFkc() || m8897VA(this.f8864Dt, i) || m8897VA(this.f8864Dt, i2))) {
            Path path = this.f8864Dt;
            path.op(path, this.f8866JHa, Path.Op.DIFFERENCE);
            this.f8870lgHUyS[0] = this.f8874xJ.m9129ETF();
            this.f8870lgHUyS[1] = this.f8874xJ.m9135VA();
            this.f8873wA[i].mapPoints(this.f8870lgHUyS);
            Path path2 = this.f8867KLFTb;
            float[] fArr2 = this.f8870lgHUyS;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f8874xJ.m9137ZfxDd(this.f8873wA[i], this.f8867KLFTb);
        } else {
            this.f8874xJ.m9137ZfxDd(this.f8873wA[i], wAVar.f8876AZxh);
        }
        AZxh aZxh = wAVar.f8878ZfxDd;
        if (aZxh != null) {
            aZxh.mo8906mjFkc(this.f8874xJ, this.f8873wA[i], i);
        }
    }

    /* renamed from: xJ */
    public final InterfaceC3498cQmsjG m8904xJ(int i, C2141I6 c2141i6) {
        return i != 1 ? i != 2 ? i != 3 ? c2141i6.m8673diqgf() : c2141i6.m8668IEE() : c2141i6.m8664Dt() : c2141i6.m8671VA();
    }
}
