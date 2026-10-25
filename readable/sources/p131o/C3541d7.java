package p131o;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: o.d7 */
/* loaded from: classes.dex */
public final class C3541d7 extends SpannableStringBuilder {

    /* renamed from: AZxh */
    public final List f13309AZxh;

    /* renamed from: mjFkc */
    public final Class f13310mjFkc;

    /* renamed from: o.d7$mjFkc */
    public static class mjFkc implements TextWatcher, SpanWatcher {

        /* renamed from: AZxh */
        public final AtomicInteger f13311AZxh = new AtomicInteger(0);

        /* renamed from: mjFkc */
        public final Object f13312mjFkc;

        public mjFkc(Object obj) {
            this.f13312mjFkc = obj;
        }

        /* renamed from: AZxh */
        public final boolean m11706AZxh(Object obj) {
            return obj instanceof AbstractC1992Frh;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f13312mjFkc).afterTextChanged(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ((TextWatcher) this.f13312mjFkc).beforeTextChanged(charSequence, i, i2, i3);
        }

        /* renamed from: mjFkc */
        public final void m11707mjFkc() {
            this.f13311AZxh.incrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
            if (this.f13311AZxh.get() <= 0 || !m11706AZxh(obj)) {
                ((SpanWatcher) this.f13312mjFkc).onSpanAdded(spannable, obj, i, i2);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
            if (this.f13311AZxh.get() <= 0 || !m11706AZxh(obj)) {
                ((SpanWatcher) this.f13312mjFkc).onSpanChanged(spannable, obj, i, i2, i3, i4);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
            if (this.f13311AZxh.get() <= 0 || !m11706AZxh(obj)) {
                ((SpanWatcher) this.f13312mjFkc).onSpanRemoved(spannable, obj, i, i2);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ((TextWatcher) this.f13312mjFkc).onTextChanged(charSequence, i, i2, i3);
        }

        /* renamed from: wA */
        public final void m11708wA() {
            this.f13311AZxh.decrementAndGet();
        }
    }

    public C3541d7(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f13309AZxh = new ArrayList();
        AbstractC2280K3.m9122lgHUyS(cls, "watcherClass cannot be null");
        this.f13310mjFkc = cls;
    }

    /* renamed from: wA */
    public static C3541d7 m11697wA(Class cls, CharSequence charSequence) {
        return new C3541d7(cls, charSequence);
    }

    /* renamed from: AZxh */
    public final void m11698AZxh() {
        for (int i = 0; i < this.f13309AZxh.size(); i++) {
            ((mjFkc) this.f13309AZxh.get(i)).m11707mjFkc();
        }
    }

    /* renamed from: JHa */
    public final mjFkc m11699JHa(Object obj) {
        for (int i = 0; i < this.f13309AZxh.size(); i++) {
            mjFkc mjfkc = (mjFkc) this.f13309AZxh.get(i);
            if (mjfkc.f13312mjFkc == obj) {
                return mjfkc;
            }
        }
        return null;
    }

    /* renamed from: KLFTb */
    public final void m11700KLFTb() {
        for (int i = 0; i < this.f13309AZxh.size(); i++) {
            ((mjFkc) this.f13309AZxh.get(i)).onTextChanged(this, 0, length(), length());
        }
    }

    /* renamed from: ZfxDd */
    public void m11701ZfxDd() {
        m11704qdMbNW();
        m11700KLFTb();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object obj) {
        mjFkc mjfkcM11699JHa;
        if (m11702lgHUyS(obj) && (mjfkcM11699JHa = m11699JHa(obj)) != null) {
            obj = mjfkcM11699JHa;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object obj) {
        mjFkc mjfkcM11699JHa;
        if (m11702lgHUyS(obj) && (mjfkcM11699JHa = m11699JHa(obj)) != null) {
            obj = mjfkcM11699JHa;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object obj) {
        mjFkc mjfkcM11699JHa;
        if (m11702lgHUyS(obj) && (mjfkcM11699JHa = m11699JHa(obj)) != null) {
            obj = mjfkcM11699JHa;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public Object[] getSpans(int i, int i2, Class cls) {
        if (!m11705xJ(cls)) {
            return super.getSpans(i, i2, cls);
        }
        mjFkc[] mjfkcArr = (mjFkc[]) super.getSpans(i, i2, mjFkc.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, mjfkcArr.length);
        for (int i3 = 0; i3 < mjfkcArr.length; i3++) {
            objArr[i3] = mjfkcArr[i3].f13312mjFkc;
        }
        return objArr;
    }

    /* renamed from: lgHUyS */
    public final boolean m11702lgHUyS(Object obj) {
        return obj != null && m11705xJ(obj.getClass());
    }

    /* renamed from: mjFkc */
    public void m11703mjFkc() {
        m11698AZxh();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        if (cls == null || m11705xJ(cls)) {
            cls = mjFkc.class;
        }
        return super.nextSpanTransition(i, i2, cls);
    }

    /* renamed from: qdMbNW */
    public final void m11704qdMbNW() {
        for (int i = 0; i < this.f13309AZxh.size(); i++) {
            ((mjFkc) this.f13309AZxh.get(i)).m11708wA();
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object obj) {
        mjFkc mjfkcM11699JHa;
        if (m11702lgHUyS(obj)) {
            mjfkcM11699JHa = m11699JHa(obj);
            if (mjfkcM11699JHa != null) {
                obj = mjfkcM11699JHa;
            }
        } else {
            mjfkcM11699JHa = null;
        }
        super.removeSpan(obj);
        if (mjfkcM11699JHa != null) {
            this.f13309AZxh.remove(mjfkcM11699JHa);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (m11702lgHUyS(obj)) {
            mjFkc mjfkc = new mjFkc(obj);
            this.f13309AZxh.add(mjfkc);
            obj = mjfkc;
        }
        super.setSpan(obj, i, i2, i3);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return new C3541d7(this.f13310mjFkc, this, i, i2);
    }

    /* renamed from: xJ */
    public final boolean m11705xJ(Class cls) {
        return this.f13310mjFkc == cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder delete(int i, int i2) {
        super.delete(i, i2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i, CharSequence charSequence) {
        super.insert(i, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence) {
        m11698AZxh();
        super.replace(i, i2, charSequence);
        m11704qdMbNW();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i, CharSequence charSequence, int i2, int i3) {
        super.insert(i, charSequence, i2, i3);
        return this;
    }

    public C3541d7(Class cls, CharSequence charSequence, int i, int i2) {
        super(charSequence, i, i2);
        this.f13309AZxh = new ArrayList();
        AbstractC2280K3.m9122lgHUyS(cls, "watcherClass cannot be null");
        this.f13310mjFkc = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        m11698AZxh();
        super.replace(i, i2, charSequence, i3, i4);
        m11704qdMbNW();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(char c) {
        super.append(c);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence, int i, int i2) {
        super.append(charSequence, i, i2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i) {
        super.append(charSequence, obj, i);
        return this;
    }
}
