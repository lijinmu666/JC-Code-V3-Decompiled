package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final ProtobufArrayList<Object> EMPTY_LIST;

    /* renamed from: array */
    private E[] f3749array;

    /* renamed from: size */
    private int f3750size;

    static {
        ProtobufArrayList<Object> protobufArrayList = new ProtobufArrayList<>(new Object[0], 0);
        EMPTY_LIST = protobufArrayList;
        protobufArrayList.makeImmutable();
    }

    public ProtobufArrayList() {
        this(new Object[10], 0);
    }

    private static <E> E[] createArray(int i) {
        return (E[]) new Object[i];
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return (ProtobufArrayList<E>) EMPTY_LIST;
    }

    private void ensureIndexInRange(int i) {
        if (i < 0 || i >= this.f3750size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i) {
        return "Index:" + i + ", Size:" + this.f3750size;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        ensureIsMutable();
        int i = this.f3750size;
        E[] eArr = this.f3749array;
        if (i == eArr.length) {
            this.f3749array = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.f3749array;
        int i2 = this.f3750size;
        this.f3750size = i2 + 1;
        eArr2[i2] = e;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        ensureIndexInRange(i);
        return this.f3749array[i];
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int i) {
        ensureIsMutable();
        ensureIndexInRange(i);
        E[] eArr = this.f3749array;
        E e = eArr[i];
        if (i < this.f3750size - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (r2 - i) - 1);
        }
        this.f3750size--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        ensureIsMutable();
        ensureIndexInRange(i);
        E[] eArr = this.f3749array;
        E e2 = eArr[i];
        eArr[i] = e;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f3750size;
    }

    private ProtobufArrayList(E[] eArr, int i) {
        this.f3749array = eArr;
        this.f3750size = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public ProtobufArrayList<E> mutableCopyWithCapacity2(int i) {
        if (i >= this.f3750size) {
            return new ProtobufArrayList<>(Arrays.copyOf(this.f3749array, i), this.f3750size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        int i2;
        ensureIsMutable();
        if (i >= 0 && i <= (i2 = this.f3750size)) {
            E[] eArr = this.f3749array;
            if (i2 < eArr.length) {
                System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
            } else {
                E[] eArr2 = (E[]) createArray(((i2 * 3) / 2) + 1);
                System.arraycopy(this.f3749array, 0, eArr2, 0, i);
                System.arraycopy(this.f3749array, i, eArr2, i + 1, this.f3750size - i);
                this.f3749array = eArr2;
            }
            this.f3749array[i] = e;
            this.f3750size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i));
    }
}
