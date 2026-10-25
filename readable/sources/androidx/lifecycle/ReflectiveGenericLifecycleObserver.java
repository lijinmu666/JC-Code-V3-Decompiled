package androidx.lifecycle;

import androidx.lifecycle.AbstractC0112wA;
import androidx.lifecycle.C0110mjFkc;
import java.lang.reflect.InvocationTargetException;
import p131o.InterfaceC3068W0;

@Deprecated
/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements InterfaceC0104KLFTb {

    /* renamed from: AZxh */
    public final C0110mjFkc.mjFkc f1377AZxh;

    /* renamed from: mjFkc */
    public final Object f1378mjFkc;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1378mjFkc = obj;
        this.f1377AZxh = C0110mjFkc.f1382wA.m1077wA(obj.getClass());
    }

    @Override // androidx.lifecycle.InterfaceC0104KLFTb
    /* renamed from: VA */
    public void mo4VA(InterfaceC3068W0 interfaceC3068W0, AbstractC0112wA.mjFkc mjfkc) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f1377AZxh.m1081mjFkc(interfaceC3068W0, mjfkc, this.f1378mjFkc);
    }
}
