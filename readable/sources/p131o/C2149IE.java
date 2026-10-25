package p131o;

import java.util.AbstractMap;
import java.util.Objects;

/* renamed from: o.IE */
/* loaded from: classes.dex */
public final class C2149IE extends AbstractC2219JD {

    /* renamed from: wA */
    public final /* synthetic */ C2291KE f8716wA;

    public C2149IE(C2291KE c2291ke) {
        this.f8716wA = c2291ke;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        AbstractC3168XW.m10944mjFkc(i, this.f8716wA.f9137KLFTb, "index");
        int i2 = i + i;
        Object obj = this.f8716wA.f9138ZfxDd[i2];
        Objects.requireNonNull(obj);
        Object obj2 = this.f8716wA.f9138ZfxDd[i2 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f8716wA.f9137KLFTb;
    }
}
