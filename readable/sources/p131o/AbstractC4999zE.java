package p131o;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

/* renamed from: o.zE */
/* loaded from: classes.dex */
public abstract class AbstractC4999zE extends AbstractMap {

    /* renamed from: AZxh */
    public transient Collection f17642AZxh;

    /* renamed from: mjFkc */
    public transient Set f17643mjFkc;

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.f17643mjFkc;
        if (set != null) {
            return set;
        }
        Set setMo9492mjFkc = mo9492mjFkc();
        this.f17643mjFkc = setMo9492mjFkc;
        return setMo9492mjFkc;
    }

    /* renamed from: mjFkc */
    public abstract Set mo9492mjFkc();

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.f17642AZxh;
        if (collection != null) {
            return collection;
        }
        C4201nE c4201nE = new C4201nE(this);
        this.f17642AZxh = c4201nE;
        return c4201nE;
    }
}
