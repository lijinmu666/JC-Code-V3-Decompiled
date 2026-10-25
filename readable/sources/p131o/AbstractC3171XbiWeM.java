package p131o;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* renamed from: o.XbiWeM */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC3171XbiWeM {
    /* renamed from: mjFkc */
    public static /* synthetic */ boolean m10947mjFkc(AtomicReferenceArray atomicReferenceArray, int i, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i, obj, obj2)) {
            if (atomicReferenceArray.get(i) != obj) {
                return false;
            }
        }
        return true;
    }
}
