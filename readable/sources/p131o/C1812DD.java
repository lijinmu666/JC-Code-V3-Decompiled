package p131o;

import java.util.Arrays;

/* renamed from: o.DD */
/* loaded from: classes.dex */
public final class C1812DD extends AbstractC4733vD {
    public C1812DD() {
        super(4);
    }

    /* renamed from: AZxh */
    public final AbstractC2219JD m7987AZxh() {
        this.f16994wA = true;
        return AbstractC2219JD.m8921qdMbNW(this.f16993mjFkc, this.f16992AZxh);
    }

    /* renamed from: mjFkc */
    public final C1812DD m7988mjFkc(Object obj) {
        obj.getClass();
        int i = this.f16992AZxh;
        int i2 = i + 1;
        Object[] objArr = this.f16993mjFkc;
        int length = objArr.length;
        if (length < i2) {
            int i3 = length + (length >> 1) + 1;
            if (i3 < i2) {
                int iHighestOneBit = Integer.highestOneBit(i);
                i3 = iHighestOneBit + iHighestOneBit;
            }
            if (i3 < 0) {
                i3 = Integer.MAX_VALUE;
            }
            this.f16993mjFkc = Arrays.copyOf(objArr, i3);
            this.f16994wA = false;
        } else if (this.f16994wA) {
            this.f16993mjFkc = (Object[]) objArr.clone();
            this.f16994wA = false;
        }
        Object[] objArr2 = this.f16993mjFkc;
        int i4 = this.f16992AZxh;
        this.f16992AZxh = i4 + 1;
        objArr2[i4] = obj;
        return this;
    }
}
