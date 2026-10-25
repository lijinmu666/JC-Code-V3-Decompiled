package p131o;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* renamed from: o.Sy */
/* loaded from: classes.dex */
public final class C2864Sy extends AbstractC3723fx implements RandomAccess {

    /* renamed from: ZfxDd */
    public static final C2864Sy f10624ZfxDd = new C2864Sy(new Object[0], 0, false);

    /* renamed from: AZxh */
    public Object[] f10625AZxh;

    /* renamed from: wA */
    public int f10626wA;

    public C2864Sy(Object[] objArr, int i, boolean z) {
        super(z);
        this.f10625AZxh = objArr;
        this.f10626wA = i;
    }

    /* renamed from: ZfxDd */
    public static C2864Sy m10207ZfxDd() {
        return f10624ZfxDd;
    }

    /* renamed from: xJ */
    private final void m10208xJ(int i) {
        if (i < 0 || i >= this.f10626wA) {
            throw new IndexOutOfBoundsException(m10209JHa(i));
        }
    }

    /* renamed from: JHa */
    public final String m10209JHa(int i) {
        return "Index:" + i + ", Size:" + this.f10626wA;
    }

    @Override // p131o.InterfaceC4118ly
    /* renamed from: KLFTb */
    public final /* bridge */ /* synthetic */ InterfaceC4118ly mo10111KLFTb(int i) {
        if (i >= this.f10626wA) {
            return new C2864Sy(Arrays.copyOf(this.f10625AZxh, i), this.f10626wA, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        m11969mjFkc();
        if (i < 0 || i > (i2 = this.f10626wA)) {
            throw new IndexOutOfBoundsException(m10209JHa(i));
        }
        int i3 = i + 1;
        Object[] objArr = this.f10625AZxh;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i3, i2 - i);
        } else {
            Object[] objArr2 = new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.f10625AZxh, i, objArr2, i3, this.f10626wA - i);
            this.f10625AZxh = objArr2;
        }
        this.f10625AZxh[i] = obj;
        this.f10626wA++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        m10208xJ(i);
        return this.f10625AZxh[i];
    }

    @Override // p131o.AbstractC3723fx, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        m11969mjFkc();
        m10208xJ(i);
        Object[] objArr = this.f10625AZxh;
        Object obj = objArr[i];
        if (i < this.f10626wA - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.f10626wA--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        m11969mjFkc();
        m10208xJ(i);
        Object[] objArr = this.f10625AZxh;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10626wA;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        m11969mjFkc();
        int i = this.f10626wA;
        Object[] objArr = this.f10625AZxh;
        if (i == objArr.length) {
            this.f10625AZxh = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f10625AZxh;
        int i2 = this.f10626wA;
        this.f10626wA = i2 + 1;
        objArr2[i2] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
