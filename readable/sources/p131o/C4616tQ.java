package p131o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* renamed from: o.tQ */
/* loaded from: classes.dex */
public class C4616tQ extends PopupWindow {

    /* renamed from: AZxh */
    public static final boolean f16699AZxh = false;

    /* renamed from: mjFkc */
    public boolean f16700mjFkc;

    public C4616tQ(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m13624mjFkc(context, attributeSet, i, i2);
    }

    /* renamed from: AZxh */
    public final void m13623AZxh(boolean z) {
        if (f16699AZxh) {
            this.f16700mjFkc = z;
        } else {
            AbstractC1933F3.m8252mjFkc(this, z);
        }
    }

    /* renamed from: mjFkc */
    public final void m13624mjFkc(Context context, AttributeSet attributeSet, int i, int i2) {
        C1606A8 c1606a8M7575diqgf = C1606A8.m7575diqgf(context, attributeSet, AbstractC3407b5.f12854CTcA, i, i2);
        if (c1606a8M7575diqgf.m7586fehf(AbstractC3407b5.f12867Fztqa)) {
            m13623AZxh(c1606a8M7575diqgf.m7588mjFkc(AbstractC3407b5.f12867Fztqa, false));
        }
        setBackgroundDrawable(c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f12894LeWm));
        c1606a8M7575diqgf.m7585eyqo();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (f16699AZxh && this.f16700mjFkc) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        if (f16699AZxh && this.f16700mjFkc) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f16699AZxh && this.f16700mjFkc) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }
}
