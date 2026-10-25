package p131o;

import java.util.Iterator;
import java.util.Set;

/* renamed from: o.BB */
/* loaded from: classes.dex */
public abstract class AbstractC1676BB {
    /* renamed from: mjFkc */
    public static int m7687mjFkc(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }
}
