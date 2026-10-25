package p131o;

/* renamed from: o.HGlNf */
/* loaded from: classes.dex */
public final class C2086HGlNf implements InterfaceC3271Z3 {

    /* renamed from: wA */
    public static final Object f8569wA = new Object();

    /* renamed from: AZxh */
    public volatile Object f8570AZxh = f8569wA;

    /* renamed from: mjFkc */
    public volatile InterfaceC3271Z3 f8571mjFkc;

    public C2086HGlNf(InterfaceC3271Z3 interfaceC3271Z3) {
        this.f8571mjFkc = interfaceC3271Z3;
    }

    /* renamed from: AZxh */
    public static Object m8534AZxh(Object obj, Object obj2) {
        if (obj == f8569wA || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    /* renamed from: mjFkc */
    public static InterfaceC3271Z3 m8535mjFkc(InterfaceC3271Z3 interfaceC3271Z3) {
        AbstractC2070H3.m8508AZxh(interfaceC3271Z3);
        return interfaceC3271Z3 instanceof C2086HGlNf ? interfaceC3271Z3 : new C2086HGlNf(interfaceC3271Z3);
    }

    @Override // p131o.InterfaceC3271Z3
    /* renamed from: get */
    public Object mo7567get() {
        Object objMo7567get = this.f8570AZxh;
        Object obj = f8569wA;
        if (objMo7567get == obj) {
            synchronized (this) {
                try {
                    objMo7567get = this.f8570AZxh;
                    if (objMo7567get == obj) {
                        objMo7567get = this.f8571mjFkc.mo7567get();
                        this.f8570AZxh = m8534AZxh(this.f8570AZxh, objMo7567get);
                        this.f8571mjFkc = null;
                    }
                } finally {
                }
            }
        }
        return objMo7567get;
    }
}
