package p131o;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.p020emoji2.p021text.C0080JHa;

/* renamed from: o.vL */
/* loaded from: classes.dex */
public class C4742vL {

    /* renamed from: ZfxDd */
    public static final ThreadLocal f17020ZfxDd = new ThreadLocal();

    /* renamed from: AZxh */
    public final C0080JHa f17021AZxh;

    /* renamed from: mjFkc */
    public final int f17022mjFkc;

    /* renamed from: wA */
    public volatile int f17023wA = 0;

    public C4742vL(C0080JHa c0080JHa, int i) {
        this.f17021AZxh = c0080JHa;
        this.f17022mjFkc = i;
    }

    /* renamed from: AZxh */
    public int m13769AZxh(int i) {
        return m13779xJ().m11596lgHUyS(i);
    }

    /* renamed from: Dt */
    public boolean m13770Dt() {
        return m13779xJ().m11590Dt();
    }

    /* renamed from: ETF */
    public void m13771ETF(boolean z) {
        this.f17023wA = z ? 2 : 1;
    }

    /* renamed from: JHa */
    public int m13772JHa() {
        return m13779xJ().m11594VA();
    }

    /* renamed from: KLFTb */
    public short m13773KLFTb() {
        return m13779xJ().m11591ETF();
    }

    /* renamed from: ZfxDd */
    public int m13774ZfxDd() {
        return this.f17023wA;
    }

    /* renamed from: lgHUyS */
    public short m13775lgHUyS() {
        return m13779xJ().m11593MiMN();
    }

    /* renamed from: mjFkc */
    public void m13776mjFkc(Canvas canvas, float f, float f2, Paint paint) {
        Typeface typefaceM645xJ = this.f17021AZxh.m645xJ();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceM645xJ);
        canvas.drawText(this.f17021AZxh.m644wA(), this.f17022mjFkc * 2, 2, f, f2, paint);
        paint.setTypeface(typeface);
    }

    /* renamed from: qdMbNW */
    public short m13777qdMbNW() {
        return m13779xJ().m11595YoKzxo();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(m13772JHa()));
        sb.append(", codepoints:");
        int iM13778wA = m13778wA();
        for (int i = 0; i < iM13778wA; i++) {
            sb.append(Integer.toHexString(m13769AZxh(i)));
            sb.append(" ");
        }
        return sb.toString();
    }

    /* renamed from: wA */
    public int m13778wA() {
        return m13779xJ().m11597qdMbNW();
    }

    /* renamed from: xJ */
    public final C3471c2 m13779xJ() {
        ThreadLocal threadLocal = f17020ZfxDd;
        C3471c2 c3471c2 = (C3471c2) threadLocal.get();
        if (c3471c2 == null) {
            c3471c2 = new C3471c2();
            threadLocal.set(c3471c2);
        }
        this.f17021AZxh.m641ZfxDd().m11643Dt(c3471c2, this.f17022mjFkc);
        return c3471c2;
    }
}
