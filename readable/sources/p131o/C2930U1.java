package p131o;

import android.text.InputFilter;
import android.text.Spanned;
import org.conscrypt.BuildConfig;

/* renamed from: o.U1 */
/* loaded from: classes.dex */
public class C2930U1 implements InputFilter {

    /* renamed from: mjFkc */
    public int f10765mjFkc;

    public C2930U1(int i) {
        this.f10765mjFkc = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i3, i4, charSequence.subSequence(i, i2).toString());
            if (Integer.parseInt(sb.toString()) <= this.f10765mjFkc) {
                return null;
            }
            return BuildConfig.f24315FLAVOR;
        } catch (NumberFormatException unused) {
            return BuildConfig.f24315FLAVOR;
        }
    }
}
