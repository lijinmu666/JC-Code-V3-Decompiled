package p131o;

import java.util.AbstractMap;

/* renamed from: o.AW */
/* loaded from: classes.dex */
public final class C1632AW extends AbstractC4618tS {

    /* renamed from: wA */
    public final /* synthetic */ C2701QW f7370wA;

    public C1632AW(C2701QW c2701qw) {
        this.f7370wA = c2701qw;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        AbstractC2623PH.m9956mjFkc(i, this.f7370wA.f10185KLFTb, "index");
        C2701QW c2701qw = this.f7370wA;
        int i2 = i + i;
        Object obj = c2701qw.f10186ZfxDd[i2];
        obj.getClass();
        Object obj2 = c2701qw.f10186ZfxDd[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7370wA.f10185KLFTb;
    }
}
