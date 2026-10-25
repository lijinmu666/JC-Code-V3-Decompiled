package p131o;

import java.util.NoSuchElementException;

/* renamed from: o.ox */
/* loaded from: classes.dex */
public final class C4314ox extends AbstractC4381px {

    /* renamed from: AZxh */
    public final int f15887AZxh;

    /* renamed from: mjFkc */
    public int f15888mjFkc = 0;

    /* renamed from: wA */
    public final /* synthetic */ AbstractC4981yx f15889wA;

    public C4314ox(AbstractC4981yx abstractC4981yx) {
        this.f15889wA = abstractC4981yx;
        this.f15887AZxh = abstractC4981yx.mo13326JHa();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f15888mjFkc < this.f15887AZxh;
    }

    @Override // p131o.InterfaceC4516rx
    /* renamed from: mjFkc */
    public final byte mo13049mjFkc() {
        int i = this.f15888mjFkc;
        if (i >= this.f15887AZxh) {
            throw new NoSuchElementException();
        }
        this.f15888mjFkc = i + 1;
        return this.f15889wA.mo13328ZfxDd(i);
    }
}
