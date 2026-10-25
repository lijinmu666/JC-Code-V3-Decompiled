package androidx.p020emoji2.p021text;

import android.text.TextPaint;
import androidx.p020emoji2.p021text.C0084wA;
import p131o.AbstractC4321p3;

/* renamed from: androidx.emoji2.text.AZxh */
/* loaded from: classes.dex */
public class C0075AZxh implements C0084wA.ZfxDd {

    /* renamed from: AZxh */
    public static final ThreadLocal f990AZxh = new ThreadLocal();

    /* renamed from: mjFkc */
    public final TextPaint f991mjFkc;

    public C0075AZxh() {
        TextPaint textPaint = new TextPaint();
        this.f991mjFkc = textPaint;
        textPaint.setTextSize(10.0f);
    }

    /* renamed from: AZxh */
    public static StringBuilder m624AZxh() {
        ThreadLocal threadLocal = f990AZxh;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return (StringBuilder) threadLocal.get();
    }

    @Override // androidx.p020emoji2.p021text.C0084wA.ZfxDd
    /* renamed from: mjFkc */
    public boolean mo625mjFkc(CharSequence charSequence, int i, int i2, int i3) {
        StringBuilder sbM624AZxh = m624AZxh();
        sbM624AZxh.setLength(0);
        while (i < i2) {
            sbM624AZxh.append(charSequence.charAt(i));
            i++;
        }
        return AbstractC4321p3.m13060mjFkc(this.f991mjFkc, sbM624AZxh.toString());
    }
}
