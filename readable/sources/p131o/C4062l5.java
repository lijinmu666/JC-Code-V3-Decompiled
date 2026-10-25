package p131o;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: o.l5 */
/* loaded from: classes.dex */
public class C4062l5 {

    /* renamed from: mjFkc */
    public final Map f14671mjFkc = new HashMap();

    /* renamed from: o.l5$mjFkc */
    public static class mjFkc {

        /* renamed from: AZxh */
        public final InterfaceC3339a4 f14672AZxh;

        /* renamed from: mjFkc */
        public final Class f14673mjFkc;

        public mjFkc(Class cls, InterfaceC3339a4 interfaceC3339a4) {
            this.f14673mjFkc = cls;
            this.f14672AZxh = interfaceC3339a4;
        }

        /* renamed from: AZxh */
        public final Class m12655AZxh() {
            return this.f14673mjFkc;
        }

        /* renamed from: mjFkc */
        public final InterfaceC3339a4 m12656mjFkc() {
            return this.f14672AZxh;
        }
    }

    public C4062l5(Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            mjFkc mjfkc = (mjFkc) it.next();
            this.f14671mjFkc.put(mjfkc.m12655AZxh(), mjfkc.m12656mjFkc());
        }
    }
}
