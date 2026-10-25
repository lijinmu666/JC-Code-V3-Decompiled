package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.InterfaceC0758IntList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final IntArrayList EMPTY_LIST;

    /* renamed from: array */
    private int[] f3690array;

    /* renamed from: size */
    private int f3691size;

    static {
        IntArrayList intArrayList = new IntArrayList(new int[0], 0);
        EMPTY_LIST = intArrayList;
        intArrayList.makeImmutable();
    }

    public IntArrayList() {
        this(new int[10], 0);
    }

    public static IntArrayList emptyList() {
        return EMPTY_LIST;
    }

    private void ensureIndexInRange(int i) {
        if (i < 0 || i >= this.f3691size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i) {
        return "Index:" + i + ", Size:" + this.f3691size;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int i = intArrayList.f3691size;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3691size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArr = this.f3690array;
        if (i3 > iArr.length) {
            this.f3690array = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(intArrayList.f3690array, 0, this.f3690array, this.f3691size, intArrayList.f3691size);
        this.f3691size = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal.InterfaceC0758IntList
    /* renamed from: addInt */
    public void mo4038addInt(int i) {
        ensureIsMutable();
        int i2 = this.f3691size;
        int[] iArr = this.f3690array;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f3690array = iArr2;
        }
        int[] iArr3 = this.f3690array;
        int i3 = this.f3691size;
        this.f3691size = i3 + 1;
        iArr3[i3] = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.f3691size != intArrayList.f3691size) {
            return false;
        }
        int[] iArr = intArrayList.f3690array;
        for (int i = 0; i < this.f3691size; i++) {
            if (this.f3690array[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal.InterfaceC0758IntList
    /* renamed from: getInt */
    public int mo4039getInt(int i) {
        ensureIndexInRange(i);
        return this.f3690array[i];
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3691size; i2++) {
            i = (i * 31) + this.f3690array[i2];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f3690array[i] == iIntValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i, int i2) {
        ensureIsMutable();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f3690array;
        System.arraycopy(iArr, i2, iArr, i, this.f3691size - i2);
        this.f3691size -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal.InterfaceC0758IntList
    /* renamed from: setInt */
    public int mo4041setInt(int i, int i2) {
        ensureIsMutable();
        ensureIndexInRange(i);
        int[] iArr = this.f3690array;
        int i3 = iArr[i];
        iArr[i] = i2;
        return i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f3691size;
    }

    private IntArrayList(int[] iArr, int i) {
        this.f3690array = iArr;
        this.f3691size = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer get(int i) {
        return Integer.valueOf(mo4039getInt(i));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Integer> mutableCopyWithCapacity2(int i) {
        if (i >= this.f3691size) {
            return new IntArrayList(Arrays.copyOf(this.f3690array, i), this.f3691size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Integer remove(int i) {
        ensureIsMutable();
        ensureIndexInRange(i);
        int[] iArr = this.f3690array;
        int i2 = iArr[i];
        if (i < this.f3691size - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.f3691size--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Integer set(int i, Integer num) {
        return Integer.valueOf(mo4041setInt(i, num.intValue()));
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Integer num) {
        mo4038addInt(num.intValue());
        return true;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i, Integer num) {
        m4035addInt(i, num.intValue());
    }

    /* renamed from: addInt */
    private void m4035addInt(int i, int i2) {
        int i3;
        ensureIsMutable();
        if (i >= 0 && i <= (i3 = this.f3691size)) {
            int[] iArr = this.f3690array;
            if (i3 < iArr.length) {
                System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
            } else {
                int[] iArr2 = new int[((i3 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                System.arraycopy(this.f3690array, i, iArr2, i + 1, this.f3691size - i);
                this.f3690array = iArr2;
            }
            this.f3690array[i] = i2;
            this.f3691size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i));
    }
}
