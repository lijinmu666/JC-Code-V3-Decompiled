package p131o;

import java.util.Iterator;
import java.util.Set;

/* renamed from: o.GC */
/* loaded from: classes.dex */
public abstract class AbstractC2015GC {
    /* renamed from: mjFkc */
    public static int m8415mjFkc(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }
}
