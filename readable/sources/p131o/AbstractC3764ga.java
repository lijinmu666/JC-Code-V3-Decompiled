package p131o;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: o.ga */
/* loaded from: classes.dex */
public abstract class AbstractC3764ga {

    /* renamed from: mjFkc */
    public final Map f13735mjFkc = new HashMap();

    /* renamed from: AZxh */
    public final Set f13734AZxh = new LinkedHashSet();

    /* renamed from: wA */
    public volatile boolean f13736wA = false;

    /* renamed from: AZxh */
    public void mo11578AZxh() {
    }

    /* renamed from: mjFkc */
    public Object m12013mjFkc(String str) {
        Object obj;
        Map map = this.f13735mjFkc;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            obj = this.f13735mjFkc.get(str);
        }
        return obj;
    }
}
