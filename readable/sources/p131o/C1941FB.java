package p131o;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* renamed from: o.FB */
/* loaded from: classes.dex */
public final class C1941FB extends AbstractC3935jE {

    /* renamed from: mjFkc */
    public final /* synthetic */ C2419MB f8138mjFkc;

    public C1941FB(C2419MB c2419mb) {
        this.f8138mjFkc = c2419mb;
    }

    @Override // p131o.AbstractC3935jE, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Set setEntrySet = this.f8138mjFkc.f9557wA.entrySet();
        setEntrySet.getClass();
        try {
            return setEntrySet.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new C2146IB(this.f8138mjFkc);
    }

    @Override // p131o.AbstractC3935jE
    /* renamed from: mjFkc */
    public final Map mo8268mjFkc() {
        return this.f8138mjFkc;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Objects.requireNonNull(entry);
        C2419MB c2419mb = this.f8138mjFkc;
        AbstractC4199nC.m12859YoKzxo(c2419mb.f9556ZfxDd, entry.getKey());
        return true;
    }
}
