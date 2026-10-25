package p131o;

import java.util.Arrays;

/* renamed from: o.Ps */
/* loaded from: classes.dex */
public final class C2658Ps extends AbstractC2468Ms {
    public C2658Ps() {
        super(4);
    }

    /* renamed from: AZxh */
    public final AbstractC2919Ts m9966AZxh() {
        this.f9623wA = true;
        return AbstractC2919Ts.m10441qdMbNW(this.f9622mjFkc, this.f9621AZxh);
    }

    /* renamed from: mjFkc */
    public final C2658Ps m9967mjFkc(Object obj) {
        int i = this.f9621AZxh;
        int i2 = i + 1;
        Object[] objArr = this.f9622mjFkc;
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
            this.f9622mjFkc = Arrays.copyOf(objArr, i3);
            this.f9623wA = false;
        } else if (this.f9623wA) {
            this.f9622mjFkc = (Object[]) objArr.clone();
            this.f9623wA = false;
        }
        Object[] objArr2 = this.f9622mjFkc;
        int i4 = this.f9621AZxh;
        this.f9621AZxh = i4 + 1;
        objArr2[i4] = obj;
        return this;
    }
}
