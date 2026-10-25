package p131o;

import java.util.HashMap;
import java.util.Map;

/* renamed from: o.pl */
/* loaded from: classes.dex */
public final class C4368pl {

    /* renamed from: AZxh */
    public final Map f15966AZxh = new HashMap();

    /* renamed from: mjFkc */
    public final int f15967mjFkc;

    public C4368pl(int i) {
        this.f15967mjFkc = i;
    }

    /* renamed from: AZxh */
    public final synchronized boolean m13136AZxh(Object obj, long j) {
        if (this.f15966AZxh.size() != this.f15967mjFkc) {
            this.f15966AZxh.put(Long.valueOf(j), obj);
            return true;
        }
        C2782Rm.f10471AZxh.m10099wA(this, "Buffer is full. Drop frame " + j, new Object[0]);
        return false;
    }

    /* renamed from: mjFkc */
    public final synchronized void m13137mjFkc(long j) {
        this.f15966AZxh.remove(Long.valueOf(j));
    }
}
