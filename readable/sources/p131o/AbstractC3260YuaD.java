package p131o;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;

/* renamed from: o.YuaD */
/* loaded from: classes.dex */
public abstract class AbstractC3260YuaD {

    /* renamed from: mjFkc */
    public static final String[] f11920mjFkc = new String[0];

    /* renamed from: o.YuaD$mjFkc */
    public static class mjFkc {
        /* renamed from: mjFkc */
        public static void m11145mjFkc(EditorInfo editorInfo, CharSequence charSequence, int i) {
            editorInfo.setInitialSurroundingSubText(charSequence, i);
        }
    }

    /* renamed from: AZxh */
    public static boolean m11138AZxh(int i) {
        int i2 = i & 4095;
        return i2 == 129 || i2 == 225 || i2 == 18;
    }

    /* renamed from: JHa */
    public static void m11139JHa(EditorInfo editorInfo, CharSequence charSequence, int i, int i2) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i2);
    }

    /* renamed from: KLFTb */
    public static void m11140KLFTb(EditorInfo editorInfo, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            mjFkc.m11145mjFkc(editorInfo, charSequence, 0);
        } else {
            m11141ZfxDd(editorInfo, charSequence, 0);
        }
    }

    /* renamed from: ZfxDd */
    public static void m11141ZfxDd(EditorInfo editorInfo, CharSequence charSequence, int i) {
        AbstractC2280K3.m9126xJ(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            mjFkc.m11145mjFkc(editorInfo, charSequence, i);
            return;
        }
        int i2 = editorInfo.initialSelStart;
        int i3 = editorInfo.initialSelEnd;
        int i4 = i2 > i3 ? i3 - i : i2 - i;
        int i5 = i2 > i3 ? i2 - i : i3 - i;
        int length = charSequence.length();
        if (i < 0 || i4 < 0 || i5 > length) {
            m11139JHa(editorInfo, null, 0, 0);
            return;
        }
        if (m11138AZxh(editorInfo.inputType)) {
            m11139JHa(editorInfo, null, 0, 0);
        } else if (length <= 2048) {
            m11139JHa(editorInfo, charSequence, i4, i5);
        } else {
            m11144xJ(editorInfo, charSequence, i4, i5);
        }
    }

    /* renamed from: mjFkc */
    public static boolean m11142mjFkc(CharSequence charSequence, int i, int i2) {
        if (i2 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i));
        }
        if (i2 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i));
    }

    /* renamed from: wA */
    public static void m11143wA(EditorInfo editorInfo, String[] strArr) {
        editorInfo.contentMimeTypes = strArr;
    }

    /* renamed from: xJ */
    public static void m11144xJ(EditorInfo editorInfo, CharSequence charSequence, int i, int i2) {
        int i3 = i2 - i;
        int i4 = i3 > 1024 ? 0 : i3;
        int i5 = 2048 - i4;
        int iMin = Math.min(charSequence.length() - i2, i5 - Math.min(i, (int) (i5 * 0.8d)));
        int iMin2 = Math.min(i, i5 - iMin);
        int i6 = i - iMin2;
        if (m11142mjFkc(charSequence, i6, 0)) {
            i6++;
            iMin2--;
        }
        if (m11142mjFkc(charSequence, (i2 + iMin) - 1, 1)) {
            iMin--;
        }
        m11139JHa(editorInfo, i4 != i3 ? TextUtils.concat(charSequence.subSequence(i6, i6 + iMin2), charSequence.subSequence(i2, iMin + i2)) : charSequence.subSequence(i6, iMin2 + i4 + iMin + i6), iMin2, i4 + iMin2);
    }
}
