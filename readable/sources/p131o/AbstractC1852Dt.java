package p131o;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: o.Dt */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1852Dt {
    /* renamed from: mjFkc */
    public static /* synthetic */ boolean m8064mjFkc(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Object obj, Object obj2, Object obj3) {
        while (!atomicReferenceFieldUpdater.compareAndSet(obj, obj2, obj3)) {
            if (atomicReferenceFieldUpdater.get(obj) != obj2) {
                return false;
            }
        }
        return true;
    }
}
