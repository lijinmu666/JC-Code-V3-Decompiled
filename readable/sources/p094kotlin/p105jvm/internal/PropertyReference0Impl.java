package p094kotlin.p105jvm.internal;

import p094kotlin.SinceKotlin;
import p094kotlin.p113reflect.InterfaceC1242KClass;
import p094kotlin.p113reflect.KDeclarationContainer;

/* loaded from: classes.dex */
public class PropertyReference0Impl extends PropertyReference0 {
    public PropertyReference0Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof InterfaceC1242KClass) ? 1 : 0);
    }

    @Override // p094kotlin.p113reflect.KProperty0
    /* renamed from: get */
    public Object mo6323get() {
        return getGetter().mo6289call(new Object[0]);
    }

    @SinceKotlin(m5061version = "1.4")
    public PropertyReference0Impl(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @SinceKotlin(m5061version = "1.4")
    public PropertyReference0Impl(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
