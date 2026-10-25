package p131o;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: o.UE */
/* loaded from: classes.dex */
public abstract class AbstractC2944UE {
    /* renamed from: AZxh */
    public static boolean m10479AZxh(Set set, Collection collection) {
        collection.getClass();
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return m10481wA(set, collection.iterator());
        }
        Iterator it = set.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    /* renamed from: mjFkc */
    public static int m10480mjFkc(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    /* renamed from: wA */
    public static boolean m10481wA(Set set, Iterator it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }
}
