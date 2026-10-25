package p131o;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: o.TC */
/* loaded from: classes.dex */
public abstract class AbstractC2879TC implements Iterator {

    /* renamed from: AZxh */
    public int f10672AZxh;

    /* renamed from: ZfxDd */
    public final /* synthetic */ C4333pD f10673ZfxDd;

    /* renamed from: mjFkc */
    public int f10674mjFkc;

    /* renamed from: wA */
    public int f10675wA = -1;

    public /* synthetic */ AbstractC2879TC(C4333pD c4333pD, AbstractC2745RC abstractC2745RC) {
        this.f10673ZfxDd = c4333pD;
        this.f10674mjFkc = c4333pD.f15921KLFTb;
        this.f10672AZxh = c4333pD.m13118lgHUyS();
    }

    /* renamed from: AZxh */
    public abstract Object mo8272AZxh(int i);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f10672AZxh >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        m10404wA();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f10672AZxh;
        this.f10675wA = i;
        Object objMo8272AZxh = mo8272AZxh(i);
        this.f10672AZxh = this.f10673ZfxDd.m13120qdMbNW(this.f10672AZxh);
        return objMo8272AZxh;
    }

    @Override // java.util.Iterator
    public final void remove() {
        m10404wA();
        AbstractC3168XW.m10943ZfxDd(this.f10675wA >= 0, "no calls to next() since the last call to remove()");
        this.f10674mjFkc += 32;
        int i = this.f10675wA;
        C4333pD c4333pD = this.f10673ZfxDd;
        c4333pD.remove(C4333pD.m13095Dt(c4333pD, i));
        this.f10672AZxh--;
        this.f10675wA = -1;
    }

    /* renamed from: wA */
    public final void m10404wA() {
        if (this.f10673ZfxDd.f15921KLFTb != this.f10674mjFkc) {
            throw new ConcurrentModificationException();
        }
    }
}
