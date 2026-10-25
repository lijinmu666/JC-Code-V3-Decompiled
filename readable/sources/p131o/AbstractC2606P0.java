package p131o;

import java.util.HashMap;
import java.util.Map;

/* renamed from: o.P0 */
/* loaded from: classes.dex */
public abstract class AbstractC2606P0 {

    /* renamed from: mjFkc */
    public final Map f10030mjFkc = new HashMap();

    /* renamed from: AZxh */
    public Object m9937AZxh(Object obj) {
        synchronized (this.f10030mjFkc) {
            try {
                if (this.f10030mjFkc.containsKey(obj)) {
                    return this.f10030mjFkc.get(obj);
                }
                Object objMo9938mjFkc = mo9938mjFkc(obj);
                this.f10030mjFkc.put(obj, objMo9938mjFkc);
                return objMo9938mjFkc;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: mjFkc */
    public abstract Object mo9938mjFkc(Object obj);
}
