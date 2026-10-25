package p131o;

import android.content.Context;
import android.util.SparseIntArray;
import p131o.C3389aqHPIZ;

/* renamed from: o.od */
/* loaded from: classes.dex */
public final class C4291od {

    /* renamed from: AZxh */
    public C3661f f15773AZxh;

    /* renamed from: mjFkc */
    public final SparseIntArray f15774mjFkc = new SparseIntArray();

    public C4291od(C3661f c3661f) {
        AbstractC2138I3.m8648xJ(c3661f);
        this.f15773AZxh = c3661f;
    }

    /* renamed from: AZxh */
    public final int m12990AZxh(Context context, C3389aqHPIZ.JHa jHa) {
        AbstractC2138I3.m8648xJ(context);
        AbstractC2138I3.m8648xJ(jHa);
        int i = 0;
        if (!jHa.m11416KLFTb()) {
            return 0;
        }
        int iMo7624JHa = jHa.mo7624JHa();
        int iM12991mjFkc = m12991mjFkc(context, iMo7624JHa);
        if (iM12991mjFkc == -1) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.f15774mjFkc.size()) {
                    i = -1;
                    break;
                }
                int iKeyAt = this.f15774mjFkc.keyAt(i2);
                if (iKeyAt > iMo7624JHa && this.f15774mjFkc.get(iKeyAt) == 0) {
                    break;
                }
                i2++;
            }
            iM12991mjFkc = i == -1 ? this.f15773AZxh.mo11785lgHUyS(context, iMo7624JHa) : i;
            this.f15774mjFkc.put(iMo7624JHa, iM12991mjFkc);
        }
        return iM12991mjFkc;
    }

    /* renamed from: mjFkc */
    public final int m12991mjFkc(Context context, int i) {
        return this.f15774mjFkc.get(i, -1);
    }

    /* renamed from: wA */
    public final void m12992wA() {
        this.f15774mjFkc.clear();
    }
}
