package p131o;

import java.util.Arrays;

/* renamed from: o.yM */
/* loaded from: classes.dex */
public abstract class AbstractC4943yM extends AbstractC1954FN {

    /* renamed from: wA */
    public boolean f17509wA;

    /* renamed from: mjFkc */
    public Object[] f17508mjFkc = new Object[4];

    /* renamed from: AZxh */
    public int f17507AZxh = 0;

    public AbstractC4943yM(int i) {
    }

    /* renamed from: AZxh */
    public final void m14001AZxh(int i) {
        Object[] objArr = this.f17508mjFkc;
        int length = objArr.length;
        if (length >= i) {
            if (this.f17509wA) {
                this.f17508mjFkc = (Object[]) objArr.clone();
                this.f17509wA = false;
                return;
            }
            return;
        }
        int i2 = length + (length >> 1) + 1;
        if (i2 < i) {
            int iHighestOneBit = Integer.highestOneBit(i - 1);
            i2 = iHighestOneBit + iHighestOneBit;
        }
        if (i2 < 0) {
            i2 = Integer.MAX_VALUE;
        }
        this.f17508mjFkc = Arrays.copyOf(objArr, i2);
        this.f17509wA = false;
    }

    /* renamed from: mjFkc */
    public final AbstractC4943yM m14002mjFkc(Object obj) {
        obj.getClass();
        m14001AZxh(this.f17507AZxh + 1);
        Object[] objArr = this.f17508mjFkc;
        int i = this.f17507AZxh;
        this.f17507AZxh = i + 1;
        objArr[i] = obj;
        return this;
    }
}
