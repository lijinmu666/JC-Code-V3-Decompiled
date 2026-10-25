package p131o;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: o.yy */
/* loaded from: classes.dex */
public final class C4982yy extends AbstractC3723fx implements RandomAccess, InterfaceC4054ky {

    /* renamed from: ZfxDd */
    public static final C4982yy f17601ZfxDd = new C4982yy(new long[0], 0, false);

    /* renamed from: AZxh */
    public long[] f17602AZxh;

    /* renamed from: wA */
    public int f17603wA;

    public C4982yy(long[] jArr, int i, boolean z) {
        super(z);
        this.f17602AZxh = jArr;
        this.f17603wA = i;
    }

    /* renamed from: JHa */
    public static C4982yy m14056JHa() {
        return f17601ZfxDd;
    }

    /* renamed from: lgHUyS */
    private final String m14057lgHUyS(int i) {
        return "Index:" + i + ", Size:" + this.f17603wA;
    }

    /* renamed from: qdMbNW */
    private final void m14058qdMbNW(int i) {
        if (i < 0 || i >= this.f17603wA) {
            throw new IndexOutOfBoundsException(m14057lgHUyS(i));
        }
    }

    @Override // p131o.InterfaceC4118ly
    /* renamed from: KLFTb */
    public final /* bridge */ /* synthetic */ InterfaceC4118ly mo10111KLFTb(int i) {
        if (i >= this.f17603wA) {
            return new C4982yy(Arrays.copyOf(this.f17602AZxh, i), this.f17603wA, true);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: ZfxDd */
    public final long m14059ZfxDd(int i) {
        m14058qdMbNW(i);
        return this.f17602AZxh[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long jLongValue = ((Long) obj).longValue();
        m11969mjFkc();
        if (i < 0 || i > (i2 = this.f17603wA)) {
            throw new IndexOutOfBoundsException(m14057lgHUyS(i));
        }
        int i3 = i + 1;
        long[] jArr = this.f17602AZxh;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i3, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f17602AZxh, i, jArr2, i3, this.f17603wA - i);
            this.f17602AZxh = jArr2;
        }
        this.f17602AZxh[i] = jLongValue;
        this.f17603wA++;
        ((AbstractList) this).modCount++;
    }

    @Override // p131o.AbstractC3723fx, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        m11969mjFkc();
        Charset charset = AbstractC4183my.f15287mjFkc;
        collection.getClass();
        if (!(collection instanceof C4982yy)) {
            return super.addAll(collection);
        }
        C4982yy c4982yy = (C4982yy) collection;
        int i = c4982yy.f17603wA;
        if (i == 0) {
            return false;
        }
        int i2 = this.f17603wA;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.f17602AZxh;
        if (i3 > jArr.length) {
            this.f17602AZxh = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(c4982yy.f17602AZxh, 0, this.f17602AZxh, this.f17603wA, c4982yy.f17603wA);
        this.f17603wA = i3;
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
        if (!(obj instanceof C4982yy)) {
            return super.equals(obj);
        }
        C4982yy c4982yy = (C4982yy) obj;
        if (this.f17603wA != c4982yy.f17603wA) {
            return false;
        }
        long[] jArr = c4982yy.f17602AZxh;
        for (int i = 0; i < this.f17603wA; i++) {
            if (this.f17602AZxh[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        m14058qdMbNW(i);
        return Long.valueOf(this.f17602AZxh[i]);
    }

    @Override // p131o.AbstractC3723fx, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f17603wA; i2++) {
            long j = this.f17602AZxh[i2];
            Charset charset = AbstractC4183my.f15287mjFkc;
            i = (i * 31) + ((int) (j ^ (j >>> 32)));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i = this.f17603wA;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f17602AZxh[i2] == jLongValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // p131o.AbstractC3723fx, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        m11969mjFkc();
        m14058qdMbNW(i);
        long[] jArr = this.f17602AZxh;
        long j = jArr[i];
        if (i < this.f17603wA - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.f17603wA--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        m11969mjFkc();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f17602AZxh;
        System.arraycopy(jArr, i2, jArr, i, this.f17603wA - i2);
        this.f17603wA -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        m11969mjFkc();
        m14058qdMbNW(i);
        long[] jArr = this.f17602AZxh;
        long j = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f17603wA;
    }

    /* renamed from: xJ */
    public final void m14060xJ(long j) {
        m11969mjFkc();
        int i = this.f17603wA;
        long[] jArr = this.f17602AZxh;
        if (i == jArr.length) {
            long[] jArr2 = new long[((i * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f17602AZxh = jArr2;
        }
        long[] jArr3 = this.f17602AZxh;
        int i2 = this.f17603wA;
        this.f17603wA = i2 + 1;
        jArr3[i2] = j;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        m14060xJ(((Long) obj).longValue());
        return true;
    }
}
