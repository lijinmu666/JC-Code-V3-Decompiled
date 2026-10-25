package p131o;

import java.util.List;
import java.util.RandomAccess;

/* renamed from: o.bt */
/* loaded from: classes.dex */
public abstract class AbstractC3461bt {
    /* renamed from: mjFkc */
    public static List m11575mjFkc(List list, InterfaceC5040zs interfaceC5040zs) {
        return list instanceof RandomAccess ? new C3058Vs(list, interfaceC5040zs) : new C3392at(list, interfaceC5040zs);
    }
}
