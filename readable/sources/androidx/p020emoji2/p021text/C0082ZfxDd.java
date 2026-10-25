package androidx.p020emoji2.p021text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.p020emoji2.p021text.C0080JHa;
import androidx.p020emoji2.p021text.C0084wA;
import java.util.Arrays;
import p131o.AbstractC1992Frh;
import p131o.C3541d7;
import p131o.C4596t9;
import p131o.C4742vL;

/* renamed from: androidx.emoji2.text.ZfxDd */
/* loaded from: classes.dex */
public final class C0082ZfxDd {

    /* renamed from: AZxh */
    public final C0080JHa f1015AZxh;

    /* renamed from: KLFTb */
    public final int[] f1016KLFTb;

    /* renamed from: ZfxDd */
    public final boolean f1017ZfxDd;

    /* renamed from: mjFkc */
    public final C0084wA.qdMbNW f1018mjFkc;

    /* renamed from: wA */
    public C0084wA.ZfxDd f1019wA;

    /* renamed from: androidx.emoji2.text.ZfxDd$AZxh */
    public static final class AZxh {

        /* renamed from: AZxh */
        public final C0080JHa.mjFkc f1020AZxh;

        /* renamed from: JHa */
        public int f1021JHa;

        /* renamed from: KLFTb */
        public int f1022KLFTb;

        /* renamed from: ZfxDd */
        public C0080JHa.mjFkc f1023ZfxDd;

        /* renamed from: lgHUyS */
        public final int[] f1024lgHUyS;

        /* renamed from: mjFkc */
        public int f1025mjFkc = 1;

        /* renamed from: wA */
        public C0080JHa.mjFkc f1026wA;

        /* renamed from: xJ */
        public final boolean f1027xJ;

        public AZxh(C0080JHa.mjFkc mjfkc, boolean z, int[] iArr) {
            this.f1020AZxh = mjfkc;
            this.f1026wA = mjfkc;
            this.f1027xJ = z;
            this.f1024lgHUyS = iArr;
        }

        /* renamed from: JHa */
        public static boolean m666JHa(int i) {
            return i == 65038;
        }

        /* renamed from: ZfxDd */
        public static boolean m667ZfxDd(int i) {
            return i == 65039;
        }

        /* renamed from: AZxh */
        public C4742vL m668AZxh() {
            return this.f1026wA.m646AZxh();
        }

        /* renamed from: KLFTb */
        public boolean m669KLFTb() {
            return this.f1025mjFkc == 2 && this.f1026wA.m646AZxh() != null && (this.f1021JHa > 1 || m670lgHUyS());
        }

        /* renamed from: lgHUyS */
        public final boolean m670lgHUyS() {
            if (this.f1026wA.m646AZxh().m13770Dt() || m667ZfxDd(this.f1022KLFTb)) {
                return true;
            }
            if (this.f1027xJ) {
                if (this.f1024lgHUyS == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f1024lgHUyS, this.f1026wA.m646AZxh().m13769AZxh(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: mjFkc */
        public int m671mjFkc(int i) {
            C0080JHa.mjFkc mjfkcM647mjFkc = this.f1026wA.m647mjFkc(i);
            int iM673xJ = 2;
            if (this.f1025mjFkc != 2) {
                if (mjfkcM647mjFkc == null) {
                    iM673xJ = m673xJ();
                } else {
                    this.f1025mjFkc = 2;
                    this.f1026wA = mjfkcM647mjFkc;
                    this.f1021JHa = 1;
                }
            } else if (mjfkcM647mjFkc != null) {
                this.f1026wA = mjfkcM647mjFkc;
                this.f1021JHa++;
            } else if (m666JHa(i)) {
                iM673xJ = m673xJ();
            } else if (!m667ZfxDd(i)) {
                if (this.f1026wA.m646AZxh() != null) {
                    iM673xJ = 3;
                    if (this.f1021JHa != 1 || m670lgHUyS()) {
                        this.f1023ZfxDd = this.f1026wA;
                        m673xJ();
                    } else {
                        iM673xJ = m673xJ();
                    }
                } else {
                    iM673xJ = m673xJ();
                }
            }
            this.f1022KLFTb = i;
            return iM673xJ;
        }

        /* renamed from: wA */
        public C4742vL m672wA() {
            return this.f1023ZfxDd.m646AZxh();
        }

        /* renamed from: xJ */
        public final int m673xJ() {
            this.f1025mjFkc = 1;
            this.f1026wA = this.f1020AZxh;
            this.f1021JHa = 0;
            return 1;
        }
    }

    /* renamed from: androidx.emoji2.text.ZfxDd$mjFkc */
    public static final class mjFkc {
        /* renamed from: AZxh */
        public static int m674AZxh(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            if (i < 0 || length < i || i2 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i2 != 0) {
                    if (i >= length) {
                        if (z) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = charSequence.charAt(i);
                    if (z) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i2--;
                        i++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i2--;
                        i++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i++;
                        z = true;
                    }
                }
                return i;
            }
        }

        /* renamed from: mjFkc */
        public static int m675mjFkc(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            if (i < 0 || length < i || i2 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i2 != 0) {
                    i--;
                    if (i < 0) {
                        return z ? -1 : 0;
                    }
                    char cCharAt = charSequence.charAt(i);
                    if (z) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        i2--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i2--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z = true;
                    }
                }
                return i;
            }
        }
    }

    public C0082ZfxDd(C0080JHa c0080JHa, C0084wA.qdMbNW qdmbnw, C0084wA.ZfxDd zfxDd, boolean z, int[] iArr) {
        this.f1018mjFkc = qdmbnw;
        this.f1015AZxh = c0080JHa;
        this.f1019wA = zfxDd;
        this.f1017ZfxDd = z;
        this.f1016KLFTb = iArr;
    }

    /* renamed from: AZxh */
    public static boolean m658AZxh(Editable editable, KeyEvent keyEvent, boolean z) {
        AbstractC1992Frh[] abstractC1992FrhArr;
        if (m662xJ(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!m659JHa(selectionStart, selectionEnd) && (abstractC1992FrhArr = (AbstractC1992Frh[]) editable.getSpans(selectionStart, selectionEnd, AbstractC1992Frh.class)) != null && abstractC1992FrhArr.length > 0) {
            for (AbstractC1992Frh abstractC1992Frh : abstractC1992FrhArr) {
                int spanStart = editable.getSpanStart(abstractC1992Frh);
                int spanEnd = editable.getSpanEnd(abstractC1992Frh);
                if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: JHa */
    public static boolean m659JHa(int i, int i2) {
        return i == -1 || i2 == -1 || i != i2;
    }

    /* renamed from: ZfxDd */
    public static boolean m660ZfxDd(Editable editable, int i, KeyEvent keyEvent) {
        if (!(i != 67 ? i != 112 ? false : m658AZxh(editable, keyEvent, true) : m658AZxh(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    /* renamed from: wA */
    public static boolean m661wA(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && i >= 0 && i2 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (m659JHa(selectionStart, selectionEnd)) {
                return false;
            }
            if (z) {
                iMax = mjFkc.m675mjFkc(editable, selectionStart, Math.max(i, 0));
                iMin = mjFkc.m674AZxh(editable, selectionEnd, Math.max(i2, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - i, 0);
                iMin = Math.min(selectionEnd + i2, editable.length());
            }
            AbstractC1992Frh[] abstractC1992FrhArr = (AbstractC1992Frh[]) editable.getSpans(iMax, iMin, AbstractC1992Frh.class);
            if (abstractC1992FrhArr != null && abstractC1992FrhArr.length > 0) {
                for (AbstractC1992Frh abstractC1992Frh : abstractC1992FrhArr) {
                    int spanStart = editable.getSpanStart(abstractC1992Frh);
                    int spanEnd = editable.getSpanEnd(abstractC1992Frh);
                    iMax = Math.min(spanStart, iMax);
                    iMin = Math.max(spanEnd, iMin);
                }
                int iMax2 = Math.max(iMax, 0);
                int iMin2 = Math.min(iMin, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(iMax2, iMin2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    /* renamed from: xJ */
    public static boolean m662xJ(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    /* renamed from: KLFTb */
    public final boolean m663KLFTb(CharSequence charSequence, int i, int i2, C4742vL c4742vL) {
        if (c4742vL.m13774ZfxDd() == 0) {
            c4742vL.m13771ETF(this.f1019wA.mo625mjFkc(charSequence, i, i2, c4742vL.m13775lgHUyS()));
        }
        return c4742vL.m13774ZfxDd() == 2;
    }

    /* renamed from: lgHUyS */
    public CharSequence m664lgHUyS(CharSequence charSequence, int i, int i2, int i3, boolean z) {
        C4596t9 c4596t9;
        int iCharCount;
        AbstractC1992Frh[] abstractC1992FrhArr;
        boolean z2 = charSequence instanceof C3541d7;
        if (z2) {
            ((C3541d7) charSequence).m11703mjFkc();
        }
        if (!z2) {
            try {
                c4596t9 = charSequence instanceof Spannable ? new C4596t9((Spannable) charSequence) : (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i + (-1), i2 + 1, AbstractC1992Frh.class) > i2) ? null : new C4596t9(charSequence);
            } finally {
                if (z2) {
                    ((C3541d7) charSequence).m11701ZfxDd();
                }
            }
        }
        if (c4596t9 != null && (abstractC1992FrhArr = (AbstractC1992Frh[]) c4596t9.getSpans(i, i2, AbstractC1992Frh.class)) != null && abstractC1992FrhArr.length > 0) {
            for (AbstractC1992Frh abstractC1992Frh : abstractC1992FrhArr) {
                int spanStart = c4596t9.getSpanStart(abstractC1992Frh);
                int spanEnd = c4596t9.getSpanEnd(abstractC1992Frh);
                if (spanStart != i2) {
                    c4596t9.removeSpan(abstractC1992Frh);
                }
                i = Math.min(spanStart, i);
                i2 = Math.max(spanEnd, i2);
            }
        }
        if (i != i2 && i < charSequence.length()) {
            if (i3 != Integer.MAX_VALUE && c4596t9 != null) {
                i3 -= ((AbstractC1992Frh[]) c4596t9.getSpans(0, c4596t9.length(), AbstractC1992Frh.class)).length;
            }
            AZxh aZxh = new AZxh(this.f1015AZxh.m639JHa(), this.f1017ZfxDd, this.f1016KLFTb);
            int iCodePointAt = Character.codePointAt(charSequence, i);
            int i4 = 0;
            C4596t9 c4596t92 = c4596t9;
            loop1: while (true) {
                iCharCount = i;
                while (i < i2 && i4 < i3) {
                    int iM671mjFkc = aZxh.m671mjFkc(iCodePointAt);
                    if (iM671mjFkc == 1) {
                        iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                        if (iCharCount < i2) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        }
                        i = iCharCount;
                    } else if (iM671mjFkc == 2) {
                        i += Character.charCount(iCodePointAt);
                        if (i < i2) {
                            iCodePointAt = Character.codePointAt(charSequence, i);
                        }
                    } else if (iM671mjFkc == 3) {
                        if (z || !m663KLFTb(charSequence, iCharCount, i, aZxh.m672wA())) {
                            if (c4596t92 == null) {
                                c4596t92 = new C4596t9((Spannable) new SpannableString(charSequence));
                            }
                            m665mjFkc(c4596t92, aZxh.m672wA(), iCharCount, i);
                            i4++;
                        }
                    }
                }
                break loop1;
            }
            if (aZxh.m669KLFTb() && i4 < i3 && (z || !m663KLFTb(charSequence, iCharCount, i, aZxh.m668AZxh()))) {
                if (c4596t92 == null) {
                    c4596t92 = new C4596t9(charSequence);
                }
                m665mjFkc(c4596t92, aZxh.m668AZxh(), iCharCount, i);
            }
            if (c4596t92 == null) {
                if (z2) {
                    ((C3541d7) charSequence).m11701ZfxDd();
                }
                return charSequence;
            }
            Spannable spannableM13604AZxh = c4596t92.m13604AZxh();
            if (z2) {
                ((C3541d7) charSequence).m11701ZfxDd();
            }
            return spannableM13604AZxh;
        }
        return charSequence;
    }

    /* renamed from: mjFkc */
    public final void m665mjFkc(Spannable spannable, C4742vL c4742vL, int i, int i2) {
        spannable.setSpan(this.f1018mjFkc.m715mjFkc(c4742vL), i, i2, 33);
    }
}
