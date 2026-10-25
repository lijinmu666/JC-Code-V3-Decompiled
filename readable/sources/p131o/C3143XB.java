package p131o;

import java.util.Arrays;

/* renamed from: o.XB */
/* loaded from: classes.dex */
public final class C3143XB {

    /* renamed from: wA */
    public C3079WB f11556wA;

    /* renamed from: mjFkc */
    public Object[] f11555mjFkc = new Object[8];

    /* renamed from: AZxh */
    public int f11554AZxh = 0;

    /* renamed from: AZxh */
    public final AbstractC3414bC m10911AZxh() {
        C3079WB c3079wb = this.f11556wA;
        if (c3079wb != null) {
            throw c3079wb.m10834mjFkc();
        }
        C1811DC c1811dcM7983xJ = C1811DC.m7983xJ(this.f11554AZxh, this.f11555mjFkc, this);
        C3079WB c3079wb2 = this.f11556wA;
        if (c3079wb2 == null) {
            return c1811dcM7983xJ;
        }
        throw c3079wb2.m10834mjFkc();
    }

    /* renamed from: mjFkc */
    public final C3143XB m10912mjFkc(Object obj, Object obj2) {
        int i = this.f11554AZxh + 1;
        Object[] objArr = this.f11555mjFkc;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.f11555mjFkc = Arrays.copyOf(objArr, AbstractC1609AB.m7596mjFkc(length, i2));
        }
        AbstractC2638PW.m9959mjFkc(obj, obj2);
        Object[] objArr2 = this.f11555mjFkc;
        int i3 = this.f11554AZxh;
        int i4 = i3 + i3;
        objArr2[i4] = obj;
        objArr2[i4 + 1] = obj2;
        this.f11554AZxh = i3 + 1;
        return this;
    }
}
