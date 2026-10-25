package p131o;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* renamed from: o.t9 */
/* loaded from: classes.dex */
public class C4596t9 implements Spannable {

    /* renamed from: AZxh */
    public Spannable f16655AZxh;

    /* renamed from: mjFkc */
    public boolean f16656mjFkc = false;

    /* renamed from: o.t9$AZxh */
    public static class AZxh {
        /* renamed from: mjFkc */
        public abstract boolean mo13606mjFkc(CharSequence charSequence);
    }

    /* renamed from: o.t9$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static IntStream m13607AZxh(CharSequence charSequence) {
            return charSequence.codePoints();
        }

        /* renamed from: mjFkc */
        public static IntStream m13608mjFkc(CharSequence charSequence) {
            return charSequence.chars();
        }
    }

    /* renamed from: o.t9$wA */
    public static class wA extends AZxh {
        @Override // p131o.C4596t9.AZxh
        /* renamed from: mjFkc */
        public boolean mo13606mjFkc(CharSequence charSequence) {
            return charSequence instanceof PrecomputedText;
        }
    }

    public C4596t9(Spannable spannable) {
        this.f16655AZxh = spannable;
    }

    /* renamed from: wA */
    public static AZxh m13603wA() {
        return new wA();
    }

    /* renamed from: AZxh */
    public Spannable m13604AZxh() {
        return this.f16655AZxh;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.f16655AZxh.charAt(i);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return mjFkc.m13608mjFkc(this.f16655AZxh);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return mjFkc.m13607AZxh(this.f16655AZxh);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f16655AZxh.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f16655AZxh.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f16655AZxh.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public Object[] getSpans(int i, int i2, Class cls) {
        return this.f16655AZxh.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f16655AZxh.length();
    }

    /* renamed from: mjFkc */
    public final void m13605mjFkc() {
        Spannable spannable = this.f16655AZxh;
        if (!this.f16656mjFkc && m13603wA().mo13606mjFkc(spannable)) {
            this.f16655AZxh = new SpannableString(spannable);
        }
        this.f16656mjFkc = true;
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f16655AZxh.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        m13605mjFkc();
        this.f16655AZxh.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        m13605mjFkc();
        this.f16655AZxh.setSpan(obj, i, i2, i3);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.f16655AZxh.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f16655AZxh.toString();
    }

    public C4596t9(CharSequence charSequence) {
        this.f16655AZxh = new SpannableString(charSequence);
    }
}
