package p094kotlin.p105jvm.internal;

import p094kotlin.SinceKotlin;
import p094kotlin.p113reflect.KCallable;
import p094kotlin.p113reflect.KMutableProperty2;
import p094kotlin.p113reflect.KProperty2;

/* loaded from: classes.dex */
public abstract class MutablePropertyReference2 extends MutablePropertyReference implements KMutableProperty2 {
    public MutablePropertyReference2() {
    }

    @Override // p094kotlin.p105jvm.internal.CallableReference
    public KCallable computeReflected() {
        return Reflection.mutableProperty2(this);
    }

    @Override // p094kotlin.p113reflect.KProperty2
    @SinceKotlin(m5061version = "1.1")
    public Object getDelegate(Object obj, Object obj2) {
        return ((KMutableProperty2) getReflected()).getDelegate(obj, obj2);
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke */
    public Object mo2167invoke(Object obj, Object obj2) {
        return mo6328get(obj, obj2);
    }

    @SinceKotlin(m5061version = "1.4")
    public MutablePropertyReference2(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @Override // p094kotlin.p113reflect.KProperty, p094kotlin.p113reflect.KProperty0
    public KProperty2.InterfaceC1251Getter getGetter() {
        return ((KMutableProperty2) getReflected()).getGetter();
    }

    @Override // p094kotlin.p113reflect.KMutableProperty, p094kotlin.p113reflect.KMutableProperty0
    public KMutableProperty2.InterfaceC1246Setter getSetter() {
        return ((KMutableProperty2) getReflected()).getSetter();
    }
}
