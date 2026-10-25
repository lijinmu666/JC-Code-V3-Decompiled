package p094kotlin.p105jvm.internal;

import p094kotlin.SinceKotlin;
import p094kotlin.p113reflect.KCallable;
import p094kotlin.p113reflect.KProperty0;

/* loaded from: classes.dex */
public abstract class PropertyReference0 extends PropertyReference implements KProperty0 {
    public PropertyReference0() {
    }

    @Override // p094kotlin.p105jvm.internal.CallableReference
    public KCallable computeReflected() {
        return Reflection.property0(this);
    }

    @Override // p094kotlin.p113reflect.KProperty0
    @SinceKotlin(m5061version = "1.1")
    public Object getDelegate() {
        return ((KProperty0) getReflected()).getDelegate();
    }

    @Override // p094kotlin.p105jvm.functions.Function0
    /* renamed from: invoke */
    public Object mo4323invoke() {
        return mo6323get();
    }

    @SinceKotlin(m5061version = "1.1")
    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // p094kotlin.p113reflect.KProperty, p094kotlin.p113reflect.KProperty0
    public KProperty0.InterfaceC1249Getter getGetter() {
        return ((KProperty0) getReflected()).getGetter();
    }

    @SinceKotlin(m5061version = "1.4")
    public PropertyReference0(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
