package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {

    /* renamed from: list */
    private final LazyStringList f3803list;

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.f3803list = lazyStringList;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    /* renamed from: add */
    public void mo4058add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return Collections.unmodifiableList(this.f3803list.asByteArrayList());
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return Collections.unmodifiableList(this.f3803list.asByteStringList());
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    public byte[] getByteArray(int i) {
        return this.f3803list.getByteArray(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    public ByteString getByteString(int i) {
        return this.f3803list.getByteString(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    /* renamed from: getRaw */
    public Object mo4060getRaw(int i) {
        return this.f3803list.mo4060getRaw(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return this.f3803list.getUnderlyingElements();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new Iterator<String>() { // from class: com.google.crypto.tink.shaded.protobuf.UnmodifiableLazyStringList.2

            /* renamed from: iter */
            Iterator<String> f3806iter;

            {
                this.f3806iter = UnmodifiableLazyStringList.this.f3803list.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f3806iter.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Iterator
            public String next() {
                return this.f3806iter.next();
            }
        };
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i) {
        return new ListIterator<String>(i) { // from class: com.google.crypto.tink.shaded.protobuf.UnmodifiableLazyStringList.1

            /* renamed from: iter */
            ListIterator<String> f3804iter;
            final /* synthetic */ int val$index;

            {
                this.val$index = i;
                this.f3804iter = UnmodifiableLazyStringList.this.f3803list.listIterator(i);
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f3804iter.hasNext();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.f3804iter.hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f3804iter.nextIndex();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.f3804iter.previousIndex();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator
            public void add(String str) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public String next() {
                return this.f3804iter.next();
            }

            @Override // java.util.ListIterator
            public String previous() {
                return this.f3804iter.previous();
            }

            @Override // java.util.ListIterator
            public void set(String str) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    public void mergeFrom(LazyStringList lazyStringList) {
        throw new UnsupportedOperationException();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    /* renamed from: set */
    public void mo4062set(int i, ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f3803list.size();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    /* renamed from: add */
    public void mo4059add(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        return this.f3803list.get(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    /* renamed from: set */
    public void mo4063set(int i, byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
