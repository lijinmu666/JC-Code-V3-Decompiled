package p131o;

import java.util.AbstractMap;
import java.util.Objects;

/* renamed from: o.rC */
/* loaded from: classes.dex */
public final class C4466rC extends AbstractC2878TB {

    /* renamed from: wA */
    public final /* synthetic */ C4667uC f16308wA;

    public C4466rC(C4667uC c4667uC) {
        this.f16308wA = c4667uC;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        AbstractC4284oV.m12960mjFkc(i, this.f16308wA.f16809KLFTb, "index");
        int i2 = i + i;
        Object obj = this.f16308wA.f16810ZfxDd[i2];
        Objects.requireNonNull(obj);
        Object obj2 = this.f16308wA.f16810ZfxDd[i2 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f16308wA.f16809KLFTb;
    }
}
