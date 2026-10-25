package p094kotlin.p105jvm.internal;

import p094kotlin.SinceKotlin;
import p094kotlin.p113reflect.KCallable;
import p094kotlin.p113reflect.KMutableProperty0;
import p094kotlin.p113reflect.KProperty0;

/* loaded from: classes.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements KMutableProperty0 {
    public MutablePropertyReference0() {
    }

    @Override // p094kotlin.p105jvm.internal.CallableReference
    public KCallable computeReflected() {
        return Reflection.mutableProperty0(this);
    }

    @Override // p094kotlin.p113reflect.KProperty0
    @SinceKotlin(m5061version = "1.1")
    public Object getDelegate() {
        return ((KMutableProperty0) getReflected()).getDelegate();
    }

    @Override // p094kotlin.p105jvm.functions.Function0
    /* renamed from: invoke */
    public Object mo4323invoke() {
        return mo6323get();
    }

    @SinceKotlin(m5061version = "1.1")
    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    @Override // p094kotlin.p113reflect.KProperty, p094kotlin.p113reflect.KProperty0
    public KProperty0.InterfaceC1249Getter getGetter() {
        return ((KMutableProperty0) getReflected()).getGetter();
    }

    @Override // p094kotlin.p113reflect.KMutableProperty, p094kotlin.p113reflect.KMutableProperty0
    public KMutableProperty0.InterfaceC1244Setter getSetter() {
        return ((KMutableProperty0) getReflected()).getSetter();
    }

    @SinceKotlin(m5061version = "1.4")
    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
