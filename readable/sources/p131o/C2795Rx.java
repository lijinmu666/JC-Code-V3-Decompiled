package p131o;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: o.Rx */
/* loaded from: classes.dex */
public final class C2795Rx extends AbstractC3723fx implements RandomAccess, InterfaceC3917iy {

    /* renamed from: ZfxDd */
    public static final C2795Rx f10498ZfxDd = new C2795Rx(new float[0], 0, false);

    /* renamed from: AZxh */
    public float[] f10499AZxh;

    /* renamed from: wA */
    public int f10500wA;

    public C2795Rx(float[] fArr, int i, boolean z) {
        super(z);
        this.f10499AZxh = fArr;
        this.f10500wA = i;
    }

    /* renamed from: JHa */
    public static C2795Rx m10110JHa() {
        return f10498ZfxDd;
    }

    @Override // p131o.InterfaceC4118ly
    /* renamed from: KLFTb */
    public final /* bridge */ /* synthetic */ InterfaceC4118ly mo10111KLFTb(int i) {
        if (i >= this.f10500wA) {
            return new C2795Rx(Arrays.copyOf(this.f10499AZxh, i), this.f10500wA, true);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: ZfxDd */
    public final float m10112ZfxDd(int i) {
        m10114qdMbNW(i);
        return this.f10499AZxh[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float fFloatValue = ((Float) obj).floatValue();
        m11969mjFkc();
        if (i < 0 || i > (i2 = this.f10500wA)) {
            throw new IndexOutOfBoundsException(m10113lgHUyS(i));
        }
        int i3 = i + 1;
        float[] fArr = this.f10499AZxh;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i3, i2 - i);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f10499AZxh, i, fArr2, i3, this.f10500wA - i);
            this.f10499AZxh = fArr2;
        }
        this.f10499AZxh[i] = fFloatValue;
        this.f10500wA++;
        ((AbstractList) this).modCount++;
    }

    @Override // p131o.AbstractC3723fx, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        m11969mjFkc();
        Charset charset = AbstractC4183my.f15287mjFkc;
        collection.getClass();
        if (!(collection instanceof C2795Rx)) {
            return super.addAll(collection);
        }
        C2795Rx c2795Rx = (C2795Rx) collection;
        int i = c2795Rx.f10500wA;
        if (i == 0) {
            return false;
        }
        int i2 = this.f10500wA;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        float[] fArr = this.f10499AZxh;
        if (i3 > fArr.length) {
            this.f10499AZxh = Arrays.copyOf(fArr, i3);
        }
        System.arraycopy(c2795Rx.f10499AZxh, 0, this.f10499AZxh, this.f10500wA, c2795Rx.f10500wA);
        this.f10500wA = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // p131o.AbstractC3723fx, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2795Rx)) {
            return super.equals(obj);
        }
        C2795Rx c2795Rx = (C2795Rx) obj;
        if (this.f10500wA != c2795Rx.f10500wA) {
            return false;
        }
        float[] fArr = c2795Rx.f10499AZxh;
        for (int i = 0; i < this.f10500wA; i++) {
            if (Float.floatToIntBits(this.f10499AZxh[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        m10114qdMbNW(i);
        return Float.valueOf(this.f10499AZxh[i]);
    }

    @Override // p131o.AbstractC3723fx, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i = 0; i < this.f10500wA; i++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f10499AZxh[i]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i = this.f10500wA;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f10499AZxh[i2] == fFloatValue) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: lgHUyS */
    public final String m10113lgHUyS(int i) {
        return "Index:" + i + ", Size:" + this.f10500wA;
    }

    /* renamed from: qdMbNW */
    public final void m10114qdMbNW(int i) {
        if (i < 0 || i >= this.f10500wA) {
            throw new IndexOutOfBoundsException(m10113lgHUyS(i));
        }
    }

    @Override // p131o.AbstractC3723fx, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        m11969mjFkc();
        m10114qdMbNW(i);
        float[] fArr = this.f10499AZxh;
        float f = fArr[i];
        if (i < this.f10500wA - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (r2 - i) - 1);
        }
        this.f10500wA--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        m11969mjFkc();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f10499AZxh;
        System.arraycopy(fArr, i2, fArr, i, this.f10500wA - i2);
        this.f10500wA -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        m11969mjFkc();
        m10114qdMbNW(i);
        float[] fArr = this.f10499AZxh;
        float f = fArr[i];
        fArr[i] = fFloatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10500wA;
    }

    /* renamed from: xJ */
    public final void m10115xJ(float f) {
        m11969mjFkc();
        int i = this.f10500wA;
        float[] fArr = this.f10499AZxh;
        if (i == fArr.length) {
            float[] fArr2 = new float[((i * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.f10499AZxh = fArr2;
        }
        float[] fArr3 = this.f10499AZxh;
        int i2 = this.f10500wA;
        this.f10500wA = i2 + 1;
        fArr3[i2] = f;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        m10115xJ(((Float) obj).floatValue());
        return true;
    }
}
