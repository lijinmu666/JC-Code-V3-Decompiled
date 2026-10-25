package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final LongArrayList EMPTY_LIST;

    /* renamed from: array */
    private long[] f3718array;

    /* renamed from: size */
    private int f3719size;

    static {
        LongArrayList longArrayList = new LongArrayList(new long[0], 0);
        EMPTY_LIST = longArrayList;
        longArrayList.makeImmutable();
    }

    public LongArrayList() {
        this(new long[10], 0);
    }

    public static LongArrayList emptyList() {
        return EMPTY_LIST;
    }

    private void ensureIndexInRange(int i) {
        if (i < 0 || i >= this.f3719size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i) {
        return "Index:" + i + ", Size:" + this.f3719size;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int i = longArrayList.f3719size;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3719size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.f3718array;
        if (i3 > jArr.length) {
            this.f3718array = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(longArrayList.f3718array, 0, this.f3718array, this.f3719size, longArrayList.f3719size);
        this.f3719size = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.LongList
    /* renamed from: addLong */
    public void mo4044addLong(long j) {
        ensureIsMutable();
        int i = this.f3719size;
        long[] jArr = this.f3718array;
        if (i == jArr.length) {
            long[] jArr2 = new long[((i * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f3718array = jArr2;
        }
        long[] jArr3 = this.f3718array;
        int i2 = this.f3719size;
        this.f3719size = i2 + 1;
        jArr3[i2] = j;
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
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.f3719size != longArrayList.f3719size) {
            return false;
        }
        long[] jArr = longArrayList.f3718array;
        for (int i = 0; i < this.f3719size; i++) {
            if (this.f3718array[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.LongList
    /* renamed from: getLong */
    public long mo4045getLong(int i) {
        ensureIndexInRange(i);
        return this.f3718array[i];
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iHashLong = 1;
        for (int i = 0; i < this.f3719size; i++) {
            iHashLong = (iHashLong * 31) + Internal.hashLong(this.f3718array[i]);
        }
        return iHashLong;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f3718array[i] == jLongValue) {
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
        long[] jArr = this.f3718array;
        System.arraycopy(jArr, i2, jArr, i, this.f3719size - i2);
        this.f3719size -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.LongList
    /* renamed from: setLong */
    public long mo4046setLong(int i, long j) {
        ensureIsMutable();
        ensureIndexInRange(i);
        long[] jArr = this.f3718array;
        long j2 = jArr[i];
        jArr[i] = j;
        return j2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f3719size;
    }

    private LongArrayList(long[] jArr, int i) {
        this.f3718array = jArr;
        this.f3719size = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public Long get(int i) {
        return Long.valueOf(mo4045getLong(i));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Long> mutableCopyWithCapacity2(int i) {
        if (i >= this.f3719size) {
            return new LongArrayList(Arrays.copyOf(this.f3718array, i), this.f3719size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Long remove(int i) {
        ensureIsMutable();
        ensureIndexInRange(i);
        long[] jArr = this.f3718array;
        long j = jArr[i];
        if (i < this.f3719size - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.f3719size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Long set(int i, Long l) {
        return Long.valueOf(mo4046setLong(i, l.longValue()));
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Long l) {
        mo4044addLong(l.longValue());
        return true;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i, Long l) {
        m4072addLong(i, l.longValue());
    }

    /* renamed from: addLong */
    private void m4072addLong(int i, long j) {
        int i2;
        ensureIsMutable();
        if (i >= 0 && i <= (i2 = this.f3719size)) {
            long[] jArr = this.f3718array;
            if (i2 < jArr.length) {
                System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
            } else {
                long[] jArr2 = new long[((i2 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i);
                System.arraycopy(this.f3718array, i, jArr2, i + 1, this.f3719size - i);
                this.f3718array = jArr2;
            }
            this.f3718array[i] = j;
            this.f3719size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i));
    }
}
