package p131o;

import p122kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* renamed from: o.eF */
/* loaded from: classes.dex */
public abstract class AbstractC3614eF extends AbstractC3742gF {
    /* renamed from: mjFkc */
    public static int m11828mjFkc(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }
}
