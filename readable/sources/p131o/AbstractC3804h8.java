package p131o;

import com.p038google.p039android.p042gms.dynamite.DynamiteModule;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: o.h8 */
/* loaded from: classes.dex */
public abstract class AbstractC3804h8 {
    /* renamed from: mjFkc */
    public static boolean m12211mjFkc(AtomicReference atomicReference, String str) {
        if (atomicReference.get() != null) {
            return ((Boolean) atomicReference.get()).booleanValue();
        }
        boolean z = DynamiteModule.m2400mjFkc(C3922j2.m12339wA().m12340AZxh(), str) > 0;
        atomicReference.set(Boolean.valueOf(z));
        return z;
    }
}
