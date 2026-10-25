package p131o;

/* renamed from: o.O0 */
/* loaded from: classes.dex */
public class C2541O0 implements InterfaceC3339a4 {

    /* renamed from: wA */
    public static final Object f9850wA = new Object();

    /* renamed from: AZxh */
    public volatile InterfaceC3339a4 f9851AZxh;

    /* renamed from: mjFkc */
    public volatile Object f9852mjFkc = f9850wA;

    public C2541O0(InterfaceC3339a4 interfaceC3339a4) {
        this.f9851AZxh = interfaceC3339a4;
    }

    @Override // p131o.InterfaceC3339a4
    /* renamed from: get */
    public Object mo8427get() {
        Object objMo8427get = this.f9852mjFkc;
        Object obj = f9850wA;
        if (objMo8427get == obj) {
            synchronized (this) {
                try {
                    objMo8427get = this.f9852mjFkc;
                    if (objMo8427get == obj) {
                        objMo8427get = this.f9851AZxh.mo8427get();
                        this.f9852mjFkc = objMo8427get;
                        this.f9851AZxh = null;
                    }
                } finally {
                }
            }
        }
        return objMo8427get;
    }
}
