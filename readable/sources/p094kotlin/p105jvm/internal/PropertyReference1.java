package p094kotlin.p105jvm.internal;

import p094kotlin.SinceKotlin;
import p094kotlin.p113reflect.KCallable;
import p094kotlin.p113reflect.KProperty1;

/* loaded from: classes.dex */
public abstract class PropertyReference1 extends PropertyReference implements KProperty1 {
    public PropertyReference1() {
    }

    @Override // p094kotlin.p105jvm.internal.CallableReference
    public KCallable computeReflected() {
        return Reflection.property1(this);
    }

    @Override // p094kotlin.p113reflect.KProperty1
    @SinceKotlin(m5061version = "1.1")
    public Object getDelegate(Object obj) {
        return ((KProperty1) getReflected()).getDelegate(obj);
    }

    @Override // p094kotlin.p105jvm.functions.Function1
    /* renamed from: invoke */
    public Object mo2237invoke(Object obj) {
        return mo2259get(obj);
    }

    @SinceKotlin(m5061version = "1.1")
    public PropertyReference1(Object obj) {
        super(obj);
    }

    @Override // p094kotlin.p113reflect.KProperty, p094kotlin.p113reflect.KProperty0
    public KProperty1.InterfaceC1250Getter getGetter() {
        return ((KProperty1) getReflected()).getGetter();
    }

    @SinceKotlin(m5061version = "1.4")
    public PropertyReference1(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
