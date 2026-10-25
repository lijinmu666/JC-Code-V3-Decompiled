package p131o;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* renamed from: o.H6 */
/* loaded from: classes.dex */
public class C2073H6 {

    /* renamed from: AZxh */
    public final Paint f8537AZxh;

    /* renamed from: JHa */
    public int f8538JHa;

    /* renamed from: KLFTb */
    public int f8539KLFTb;

    /* renamed from: ZfxDd */
    public int f8540ZfxDd;

    /* renamed from: lgHUyS */
    public final Paint f8541lgHUyS;

    /* renamed from: mjFkc */
    public final Paint f8542mjFkc;

    /* renamed from: wA */
    public final Paint f8543wA;

    /* renamed from: xJ */
    public final Path f8544xJ;

    /* renamed from: qdMbNW */
    public static final int[] f8536qdMbNW = new int[3];

    /* renamed from: Dt */
    public static final float[] f8533Dt = {0.0f, 0.5f, 1.0f};

    /* renamed from: ETF */
    public static final int[] f8534ETF = new int[4];

    /* renamed from: VA */
    public static final float[] f8535VA = {0.0f, 0.0f, 0.5f, 1.0f};

    public C2073H6() {
        this(-16777216);
    }

    /* renamed from: AZxh */
    public void m8512AZxh(Canvas canvas, Matrix matrix, RectF rectF, int i) {
        rectF.bottom += i;
        rectF.offset(0.0f, -i);
        int[] iArr = f8536qdMbNW;
        iArr[0] = this.f8538JHa;
        iArr[1] = this.f8539KLFTb;
        iArr[2] = this.f8540ZfxDd;
        Paint paint = this.f8543wA;
        float f = rectF.left;
        paint.setShader(new LinearGradient(f, rectF.top, f, rectF.bottom, iArr, f8533Dt, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f8543wA);
        canvas.restore();
    }

    /* renamed from: ZfxDd */
    public void m8513ZfxDd(int i) {
        this.f8540ZfxDd = AbstractC4898xfXeiC.m13959ETF(i, 68);
        this.f8539KLFTb = AbstractC4898xfXeiC.m13959ETF(i, 20);
        this.f8538JHa = AbstractC4898xfXeiC.m13959ETF(i, 0);
        this.f8542mjFkc.setColor(this.f8540ZfxDd);
    }

    /* renamed from: mjFkc */
    public void m8514mjFkc(Canvas canvas, Matrix matrix, RectF rectF, int i, float f, float f2) {
        boolean z = f2 < 0.0f;
        Path path = this.f8544xJ;
        if (z) {
            int[] iArr = f8534ETF;
            iArr[0] = 0;
            iArr[1] = this.f8538JHa;
            iArr[2] = this.f8539KLFTb;
            iArr[3] = this.f8540ZfxDd;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f, f2);
            path.close();
            float f3 = -i;
            rectF.inset(f3, f3);
            int[] iArr2 = f8534ETF;
            iArr2[0] = 0;
            iArr2[1] = this.f8540ZfxDd;
            iArr2[2] = this.f8539KLFTb;
            iArr2[3] = this.f8538JHa;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f4 = 1.0f - (i / fWidth);
        float[] fArr = f8535VA;
        fArr[1] = f4;
        fArr[2] = ((1.0f - f4) / 2.0f) + f4;
        this.f8537AZxh.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, f8534ETF, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f8541lgHUyS);
        }
        canvas.drawArc(rectF, f, f2, true, this.f8537AZxh);
        canvas.restore();
    }

    /* renamed from: wA */
    public Paint m8515wA() {
        return this.f8542mjFkc;
    }

    public C2073H6(int i) {
        this.f8544xJ = new Path();
        Paint paint = new Paint();
        this.f8541lgHUyS = paint;
        this.f8542mjFkc = new Paint();
        m8513ZfxDd(i);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f8537AZxh = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f8543wA = new Paint(paint2);
    }
}
