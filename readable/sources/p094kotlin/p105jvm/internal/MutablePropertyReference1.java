package p094kotlin.p105jvm.internal;

import p094kotlin.SinceKotlin;
import p094kotlin.p113reflect.KCallable;
import p094kotlin.p113reflect.KMutableProperty1;
import p094kotlin.p113reflect.KProperty1;

/* loaded from: classes.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements KMutableProperty1 {
    public MutablePropertyReference1() {
    }

    @Override // p094kotlin.p105jvm.internal.CallableReference
    public KCallable computeReflected() {
        return Reflection.mutableProperty1(this);
    }

    @Override // p094kotlin.p113reflect.KProperty1
    @SinceKotlin(m5061version = "1.1")
    public Object getDelegate(Object obj) {
        return ((KMutableProperty1) getReflected()).getDelegate(obj);
    }

    @Override // p094kotlin.p105jvm.functions.Function1
    /* renamed from: invoke */
    public Object mo2237invoke(Object obj) {
        return mo2259get(obj);
    }

    @SinceKotlin(m5061version = "1.1")
    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    @Override // p094kotlin.p113reflect.KProperty, p094kotlin.p113reflect.KProperty0
    public KProperty1.InterfaceC1250Getter getGetter() {
        return ((KMutableProperty1) getReflected()).getGetter();
    }

    @Override // p094kotlin.p113reflect.KMutableProperty, p094kotlin.p113reflect.KMutableProperty0
    public KMutableProperty1.InterfaceC1245Setter getSetter() {
        return ((KMutableProperty1) getReflected()).getSetter();
    }

    @SinceKotlin(m5061version = "1.4")
    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
