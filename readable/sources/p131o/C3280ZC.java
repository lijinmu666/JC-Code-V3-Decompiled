package p131o;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* renamed from: o.ZC */
/* loaded from: classes.dex */
public final class C3280ZC extends AbstractCollection {

    /* renamed from: mjFkc */
    public final /* synthetic */ C4333pD f12015mjFkc;

    public C3280ZC(C4333pD c4333pD) {
        this.f12015mjFkc = c4333pD;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f12015mjFkc.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        C4333pD c4333pD = this.f12015mjFkc;
        Map mapM13121rkYL = c4333pD.m13121rkYL();
        return mapM13121rkYL != null ? mapM13121rkYL.values().iterator() : new C2356LC(c4333pD);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f12015mjFkc.size();
    }
}
