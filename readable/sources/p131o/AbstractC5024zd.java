package p131o;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: o.zd */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC5024zd {
    /* renamed from: mjFkc */
    public static /* synthetic */ boolean m14125mjFkc(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!atomicReference.compareAndSet(obj, obj2)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }
}
