package p131o;

import java.util.List;
import java.util.ListIterator;

/* renamed from: o.hC */
/* loaded from: classes.dex */
public final class C3808hC extends C3279ZB implements ListIterator {

    /* renamed from: ZfxDd */
    public final /* synthetic */ C4003kC f13996ZfxDd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3808hC(C4003kC c4003kC) {
        super(c4003kC);
        this.f13996ZfxDd = c4003kC;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        boolean zIsEmpty = this.f13996ZfxDd.isEmpty();
        m11193AZxh();
        ((ListIterator) this.f12013mjFkc).add(obj);
        this.f13996ZfxDd.f14512JHa.f15363ZfxDd++;
        if (zIsEmpty) {
            this.f13996ZfxDd.m11719mjFkc();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        m11193AZxh();
        return ((ListIterator) this.f12013mjFkc).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        m11193AZxh();
        return ((ListIterator) this.f12013mjFkc).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        m11193AZxh();
        return ((ListIterator) this.f12013mjFkc).previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        m11193AZxh();
        return ((ListIterator) this.f12013mjFkc).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        m11193AZxh();
        ((ListIterator) this.f12013mjFkc).set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3808hC(C4003kC c4003kC, int i) {
        super(c4003kC, ((List) c4003kC.f13324AZxh).listIterator(i));
        this.f13996ZfxDd = c4003kC;
    }
}
