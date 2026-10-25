package p131o;

import java.util.Objects;

/* renamed from: o.QE */
/* loaded from: classes.dex */
public final class C2682QE extends AbstractC2492ND {

    /* renamed from: ZfxDd */
    public final transient Object[] f10156ZfxDd;

    public C2682QE(Object obj, Object[] objArr, int i) {
        this.f10156ZfxDd = objArr;
    }

    /* renamed from: xJ */
    public static C2682QE m10002xJ(int i, Object[] objArr, AbstractC2357LD abstractC2357LD) {
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[1];
        Objects.requireNonNull(obj2);
        AbstractC1744CC.m7823AZxh(obj, obj2);
        return new C2682QE(null, objArr, 1);
    }

    @Override // p131o.AbstractC2492ND
    /* renamed from: KLFTb */
    public final AbstractC2619PD mo9652KLFTb() {
        return new C2422ME(this, new C2555OE(this.f10156ZfxDd, 0, 1));
    }

    @Override // p131o.AbstractC2492ND
    /* renamed from: ZfxDd */
    public final AbstractC2619PD mo9653ZfxDd() {
        return new C2291KE(this, this.f10156ZfxDd, 0, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    @Override // p131o.AbstractC2492ND, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(Object obj) {
        Object obj2;
        if (obj == null) {
            obj2 = null;
        } else {
            Object[] objArr = this.f10156ZfxDd;
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            if (obj3.equals(obj)) {
                obj2 = objArr[1];
                Objects.requireNonNull(obj2);
            }
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // p131o.AbstractC2492ND
    /* renamed from: mjFkc */
    public final AbstractC4998zD mo9654mjFkc() {
        return new C2555OE(this.f10156ZfxDd, 1, 1);
    }

    @Override // java.util.Map
    public final int size() {
        return 1;
    }
}
