package p131o;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: o.G2 */
/* loaded from: classes.dex */
public class C2005G2 {

    /* renamed from: AZxh */
    public int f8301AZxh;

    /* renamed from: mjFkc */
    public int f8302mjFkc;

    public C2005G2(ViewGroup viewGroup) {
    }

    /* renamed from: AZxh */
    public void m8393AZxh(View view, View view2, int i) {
        m8396wA(view, view2, i, 0);
    }

    /* renamed from: ZfxDd */
    public void m8394ZfxDd(View view, int i) {
        if (i == 1) {
            this.f8301AZxh = 0;
        } else {
            this.f8302mjFkc = 0;
        }
    }

    /* renamed from: mjFkc */
    public int m8395mjFkc() {
        return this.f8301AZxh | this.f8302mjFkc;
    }

    /* renamed from: wA */
    public void m8396wA(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.f8301AZxh = i;
        } else {
            this.f8302mjFkc = i;
        }
    }
}
