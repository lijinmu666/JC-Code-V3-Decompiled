package p094kotlin.p105jvm.internal;

import p094kotlin.SinceKotlin;
import p094kotlin.p113reflect.InterfaceC1242KClass;
import p094kotlin.p113reflect.KDeclarationContainer;

/* loaded from: classes.dex */
public class PropertyReference2Impl extends PropertyReference2 {
    public PropertyReference2Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(((ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof InterfaceC1242KClass) ? 1 : 0);
    }

    @Override // p094kotlin.p113reflect.KProperty2
    /* renamed from: get */
    public Object mo6328get(Object obj, Object obj2) {
        return getGetter().mo6289call(obj, obj2);
    }

    @SinceKotlin(m5061version = "1.4")
    public PropertyReference2Impl(Class cls, String str, String str2, int i) {
        super(cls, str, str2, i);
    }
}
