package p131o;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.p106markers.KMappedMarker;

/* renamed from: o.h9 */
/* loaded from: classes.dex */
public final class C3805h9 implements Iterator, KMappedMarker {

    /* renamed from: AZxh */
    public final List f13981AZxh = new ArrayList();

    /* renamed from: mjFkc */
    public final Function1 f13982mjFkc;

    /* renamed from: wA */
    public Iterator f13983wA;

    public C3805h9(Iterator it, Function1 function1) {
        this.f13982mjFkc = function1;
        this.f13983wA = it;
    }

    /* renamed from: AZxh */
    public final void m12212AZxh(Object obj) {
        Iterator it = (Iterator) this.f13982mjFkc.mo2237invoke(obj);
        if (it != null && it.hasNext()) {
            this.f13981AZxh.add(this.f13983wA);
            this.f13983wA = it;
        } else {
            while (!this.f13983wA.hasNext() && !this.f13981AZxh.isEmpty()) {
                this.f13983wA = (Iterator) CollectionsKt.m5859last(this.f13981AZxh);
                CollectionsKt.removeLast(this.f13981AZxh);
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13983wA.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        Object next = this.f13983wA.next();
        m12212AZxh(next);
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
