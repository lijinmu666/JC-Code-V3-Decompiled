package p131o;

import p094kotlin.p105jvm.internal.Intrinsics;

/* renamed from: o.C3 */
/* loaded from: classes.dex */
public class C1733C3 implements InterfaceC1601A3 {

    /* renamed from: AZxh */
    public int f7547AZxh;

    /* renamed from: mjFkc */
    public final Object[] f7548mjFkc;

    public C1733C3(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f7548mjFkc = new Object[i];
    }

    @Override // p131o.InterfaceC1601A3
    /* renamed from: AZxh */
    public Object mo7550AZxh() {
        int i = this.f7547AZxh;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object obj = this.f7548mjFkc[i2];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        this.f7548mjFkc[i2] = null;
        this.f7547AZxh--;
        return obj;
    }

    @Override // p131o.InterfaceC1601A3
    /* renamed from: mjFkc */
    public boolean mo7551mjFkc(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (m7748wA(instance)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i = this.f7547AZxh;
        Object[] objArr = this.f7548mjFkc;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = instance;
        this.f7547AZxh = i + 1;
        return true;
    }

    /* renamed from: wA */
    public final boolean m7748wA(Object obj) {
        int i = this.f7547AZxh;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f7548mjFkc[i2] == obj) {
                return true;
            }
        }
        return false;
    }
}
