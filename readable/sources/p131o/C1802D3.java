package p131o;

/* renamed from: o.D3 */
/* loaded from: classes.dex */
public class C1802D3 implements InterfaceC1666B3 {

    /* renamed from: AZxh */
    public int f7785AZxh;

    /* renamed from: mjFkc */
    public final Object[] f7786mjFkc;

    public C1802D3(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f7786mjFkc = new Object[i];
    }

    @Override // p131o.InterfaceC1666B3
    /* renamed from: AZxh */
    public Object mo7658AZxh() {
        int i = this.f7785AZxh;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f7786mjFkc;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.f7785AZxh = i - 1;
        return obj;
    }

    @Override // p131o.InterfaceC1666B3
    /* renamed from: mjFkc */
    public boolean mo7659mjFkc(Object obj) {
        int i = this.f7785AZxh;
        Object[] objArr = this.f7786mjFkc;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = obj;
        this.f7785AZxh = i + 1;
        return true;
    }

    @Override // p131o.InterfaceC1666B3
    /* renamed from: wA */
    public void mo7660wA(Object[] objArr, int i) {
        if (i > objArr.length) {
            i = objArr.length;
        }
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[i2];
            int i3 = this.f7785AZxh;
            Object[] objArr2 = this.f7786mjFkc;
            if (i3 < objArr2.length) {
                objArr2[i3] = obj;
                this.f7785AZxh = i3 + 1;
            }
        }
    }
}
