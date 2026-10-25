package p094kotlin.p105jvm.internal;

import p094kotlin.SinceKotlin;
import p094kotlin.p113reflect.KCallable;
import p094kotlin.p113reflect.KProperty2;

/* loaded from: classes.dex */
public abstract class PropertyReference2 extends PropertyReference implements KProperty2 {
    public PropertyReference2() {
    }

    @Override // p094kotlin.p105jvm.internal.CallableReference
    public KCallable computeReflected() {
        return Reflection.property2(this);
    }

    @Override // p094kotlin.p113reflect.KProperty2
    @SinceKotlin(m5061version = "1.1")
    public Object getDelegate(Object obj, Object obj2) {
        return ((KProperty2) getReflected()).getDelegate(obj, obj2);
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke */
    public Object mo2167invoke(Object obj, Object obj2) {
        return mo6328get(obj, obj2);
    }

    @SinceKotlin(m5061version = "1.4")
    public PropertyReference2(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @Override // p094kotlin.p113reflect.KProperty, p094kotlin.p113reflect.KProperty0
    public KProperty2.InterfaceC1251Getter getGetter() {
        return ((KProperty2) getReflected()).getGetter();
    }
}
