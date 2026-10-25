package p094kotlin.p105jvm.internal;

import p094kotlin.SinceKotlin;
import p094kotlin.p113reflect.InterfaceC1242KClass;
import p094kotlin.p113reflect.KDeclarationContainer;

/* loaded from: classes.dex */
public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    public MutablePropertyReference1Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof InterfaceC1242KClass) ? 1 : 0);
    }

    @Override // p094kotlin.p113reflect.KProperty1
    /* renamed from: get */
    public Object mo2259get(Object obj) {
        return getGetter().mo6289call(obj);
    }

    @Override // p094kotlin.p113reflect.KMutableProperty1
    /* renamed from: set */
    public void mo6327set(Object obj, Object obj2) {
        getSetter().mo6289call(obj, obj2);
    }

    @SinceKotlin(m5061version = "1.4")
    public MutablePropertyReference1Impl(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @SinceKotlin(m5061version = "1.4")
    public MutablePropertyReference1Impl(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
