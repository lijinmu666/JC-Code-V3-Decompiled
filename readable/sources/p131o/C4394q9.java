package p131o;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import androidx.p020emoji2.p021text.C0084wA;

/* renamed from: o.q9 */
/* loaded from: classes.dex */
public final class C4394q9 extends AbstractC1992Frh {

    /* renamed from: JHa */
    public static Paint f16022JHa;

    public C4394q9(C4742vL c4742vL) {
        super(c4742vL);
    }

    /* renamed from: wA */
    public static Paint m13182wA() {
        if (f16022JHa == null) {
            TextPaint textPaint = new TextPaint();
            f16022JHa = textPaint;
            textPaint.setColor(C0084wA.m688AZxh().m708wA());
            f16022JHa.setStyle(Paint.Style.FILL);
        }
        return f16022JHa;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (C0084wA.m688AZxh().m706qdMbNW()) {
            canvas.drawRect(f, i3, f + m8334AZxh(), i5, m13182wA());
        }
        m8335mjFkc().m13776mjFkc(canvas, f, i4, paint);
    }
}
