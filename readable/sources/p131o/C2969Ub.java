package p131o;

import com.p038google.p039android.p042gms.p046common.p047api.C0210Status;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: o.Ub */
/* loaded from: classes.dex */
public final class C2969Ub {

    /* renamed from: mjFkc */
    public final Map f10852mjFkc = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: AZxh */
    public final Map f10851AZxh = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: AZxh */
    public final void m10518AZxh(C1806D7 c1806d7, boolean z) {
        this.f10851AZxh.put(c1806d7, Boolean.valueOf(z));
        c1806d7.m7977mjFkc().mo7663AZxh(new C2836Sb(this, c1806d7));
    }

    /* renamed from: JHa */
    public final void m10519JHa(boolean z, C0210Status c0210Status) {
        HashMap map;
        HashMap map2;
        synchronized (this.f10852mjFkc) {
            map = new HashMap(this.f10852mjFkc);
        }
        synchronized (this.f10851AZxh) {
            map2 = new HashMap(this.f10851AZxh);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                AbstractC4793w7.m13819mjFkc(entry.getKey());
                throw null;
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((C1806D7) entry2.getKey()).m7976ZfxDd(new C3121WrLQs(c0210Status));
            }
        }
    }

    /* renamed from: KLFTb */
    public final boolean m10520KLFTb() {
        return (this.f10852mjFkc.isEmpty() && this.f10851AZxh.isEmpty()) ? false : true;
    }

    /* renamed from: ZfxDd */
    public final void m10521ZfxDd() {
        m10519JHa(false, C3795h.f13898qGY);
    }

    /* renamed from: wA */
    public final void m10522wA(int i, String str) {
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb.append(" due to service disconnection.");
        } else if (i == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        m10519JHa(true, new C0210Status(20, sb.toString()));
    }
}
