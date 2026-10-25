package p131o;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: o.Vdz */
/* loaded from: classes.dex */
public class C3038Vdz {

    /* renamed from: AZxh */
    public final C2258Jkjs f11350AZxh;

    /* renamed from: mjFkc */
    public final TextView f11351mjFkc;

    public C3038Vdz(TextView textView) {
        this.f11351mjFkc = textView;
        this.f11350AZxh = new C2258Jkjs(textView, false);
    }

    /* renamed from: AZxh */
    public void m10698AZxh(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.f11351mjFkc.getContext().obtainStyledAttributes(attributeSet, AbstractC3407b5.f12938WrLQs, i, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(AbstractC3407b5.f12979jm) ? typedArrayObtainStyledAttributes.getBoolean(AbstractC3407b5.f12979jm, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            m10699ZfxDd(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* renamed from: ZfxDd */
    public void m10699ZfxDd(boolean z) {
        this.f11350AZxh.m9038wA(z);
    }

    /* renamed from: mjFkc */
    public InputFilter[] m10700mjFkc(InputFilter[] inputFilterArr) {
        return this.f11350AZxh.m9037mjFkc(inputFilterArr);
    }

    /* renamed from: wA */
    public void m10701wA(boolean z) {
        this.f11350AZxh.m9036AZxh(z);
    }
}
