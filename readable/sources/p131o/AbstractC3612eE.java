package p131o;

import java.util.List;
import java.util.RandomAccess;

/* renamed from: o.eE */
/* loaded from: classes.dex */
public abstract class AbstractC3612eE {
    /* renamed from: mjFkc */
    public static List m11820mjFkc(List list, InterfaceC3301ZV interfaceC3301ZV) {
        return list instanceof RandomAccess ? new C3215YD(list, interfaceC3301ZV) : new C3483cE(list, interfaceC3301ZV);
    }
}
