package p131o;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: o.ey */
/* loaded from: classes.dex */
public final class C3658ey extends AbstractC3723fx implements RandomAccess, InterfaceC3988jy {

    /* renamed from: ZfxDd */
    public static final C3658ey f13509ZfxDd = new C3658ey(new int[0], 0, false);

    /* renamed from: AZxh */
    public int[] f13510AZxh;

    /* renamed from: wA */
    public int f13511wA;

    public C3658ey(int[] iArr, int i, boolean z) {
        super(z);
        this.f13510AZxh = iArr;
        this.f13511wA = i;
    }

    /* renamed from: JHa */
    public static C3658ey m11867JHa() {
        return f13509ZfxDd;
    }

    /* renamed from: lgHUyS */
    private final String m11868lgHUyS(int i) {
        return "Index:" + i + ", Size:" + this.f13511wA;
    }

    /* renamed from: qdMbNW */
    private final void m11869qdMbNW(int i) {
        if (i < 0 || i >= this.f13511wA) {
            throw new IndexOutOfBoundsException(m11868lgHUyS(i));
        }
    }

    @Override // p131o.InterfaceC4118ly
    /* renamed from: KLFTb */
    public final /* bridge */ /* synthetic */ InterfaceC4118ly mo10111KLFTb(int i) {
        if (i >= this.f13511wA) {
            return new C3658ey(Arrays.copyOf(this.f13510AZxh, i), this.f13511wA, true);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: ZfxDd */
    public final int m11870ZfxDd(int i) {
        m11869qdMbNW(i);
        return this.f13510AZxh[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int iIntValue = ((Integer) obj).intValue();
        m11969mjFkc();
        if (i < 0 || i > (i2 = this.f13511wA)) {
            throw new IndexOutOfBoundsException(m11868lgHUyS(i));
        }
        int i3 = i + 1;
        int[] iArr = this.f13510AZxh;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i3, i2 - i);
        } else {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f13510AZxh, i, iArr2, i3, this.f13511wA - i);
            this.f13510AZxh = iArr2;
        }
        this.f13510AZxh[i] = iIntValue;
        this.f13511wA++;
        ((AbstractList) this).modCount++;
    }

    @Override // p131o.AbstractC3723fx, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        m11969mjFkc();
        Charset charset = AbstractC4183my.f15287mjFkc;
        collection.getClass();
        if (!(collection instanceof C3658ey)) {
            return super.addAll(collection);
        }
        C3658ey c3658ey = (C3658ey) collection;
        int i = c3658ey.f13511wA;
        if (i == 0) {
            return false;
        }
        int i2 = this.f13511wA;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArr = this.f13510AZxh;
        if (i3 > iArr.length) {
            this.f13510AZxh = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(c3658ey.f13510AZxh, 0, this.f13510AZxh, this.f13511wA, c3658ey.f13511wA);
        this.f13511wA = i3;
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
        if (!(obj instanceof C3658ey)) {
            return super.equals(obj);
        }
        C3658ey c3658ey = (C3658ey) obj;
        if (this.f13511wA != c3658ey.f13511wA) {
            return false;
        }
        int[] iArr = c3658ey.f13510AZxh;
        for (int i = 0; i < this.f13511wA; i++) {
            if (this.f13510AZxh[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        m11869qdMbNW(i);
        return Integer.valueOf(this.f13510AZxh[i]);
    }

    @Override // p131o.AbstractC3723fx, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f13511wA; i2++) {
            i = (i * 31) + this.f13510AZxh[i2];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i = this.f13511wA;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f13510AZxh[i2] == iIntValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // p131o.AbstractC3723fx, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        m11969mjFkc();
        m11869qdMbNW(i);
        int[] iArr = this.f13510AZxh;
        int i2 = iArr[i];
        if (i < this.f13511wA - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.f13511wA--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        m11969mjFkc();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f13510AZxh;
        System.arraycopy(iArr, i2, iArr, i, this.f13511wA - i2);
        this.f13511wA -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        m11969mjFkc();
        m11869qdMbNW(i);
        int[] iArr = this.f13510AZxh;
        int i2 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13511wA;
    }

    /* renamed from: xJ */
    public final void m11871xJ(int i) {
        m11969mjFkc();
        int i2 = this.f13511wA;
        int[] iArr = this.f13510AZxh;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f13510AZxh = iArr2;
        }
        int[] iArr3 = this.f13510AZxh;
        int i3 = this.f13511wA;
        this.f13511wA = i3 + 1;
        iArr3[i3] = i;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        m11871xJ(((Integer) obj).intValue());
        return true;
    }
}
