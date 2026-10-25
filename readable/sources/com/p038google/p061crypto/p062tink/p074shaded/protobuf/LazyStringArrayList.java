package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {

    /* renamed from: EMPTY */
    public static final LazyStringList f3711EMPTY;
    private static final LazyStringArrayList EMPTY_LIST;

    /* renamed from: list */
    private final List<Object> f3712list;

    public static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {

        /* renamed from: list */
        private final LazyStringArrayList f3713list;

        public ByteArrayListView(LazyStringArrayList lazyStringArrayList) {
            this.f3713list = lazyStringArrayList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f3713list.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, byte[] bArr) {
            this.f3713list.m4056add(i, bArr);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] get(int i) {
            return this.f3713list.getByteArray(i);
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] remove(int i) {
            String strRemove = this.f3713list.remove(i);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.asByteArray(strRemove);
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] set(int i, byte[] bArr) {
            Object andReturn = this.f3713list.setAndReturn(i, bArr);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.asByteArray(andReturn);
        }
    }

    public static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {

        /* renamed from: list */
        private final LazyStringArrayList f3714list;

        public ByteStringListView(LazyStringArrayList lazyStringArrayList) {
            this.f3714list = lazyStringArrayList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f3714list.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, ByteString byteString) {
            this.f3714list.m4055add(i, byteString);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString get(int i) {
            return this.f3714list.getByteString(i);
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString remove(int i) {
            String strRemove = this.f3714list.remove(i);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.asByteString(strRemove);
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString set(int i, ByteString byteString) {
            Object andReturn = this.f3714list.setAndReturn(i, byteString);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.asByteString(andReturn);
        }
    }

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
        EMPTY_LIST = lazyStringArrayList;
        lazyStringArrayList.makeImmutable();
        f3711EMPTY = lazyStringArrayList;
    }

    public LazyStringArrayList() {
        this(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] asByteArray(Object obj) {
        return obj instanceof byte[] ? (byte[]) obj : obj instanceof String ? Internal.toByteArray((String) obj) : ((ByteString) obj).toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteString asByteString(Object obj) {
        return obj instanceof ByteString ? (ByteString) obj : obj instanceof String ? ByteString.copyFromUtf8((String) obj) : ByteString.copyFrom((byte[]) obj);
    }

    private static String asString(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof ByteString ? ((ByteString) obj).toStringUtf8() : Internal.toStringUtf8((byte[]) obj);
    }

    public static LazyStringArrayList emptyList() {
        return EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object setAndReturn(int i, ByteString byteString) {
        ensureIsMutable();
        return this.f3712list.set(i, byteString);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> collection) {
        ensureIsMutable();
        boolean zAddAll = this.f3712list.addAll(collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        ensureIsMutable();
        boolean zAddAll = this.f3712list.addAll(collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return new ByteArrayListView(this);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return new ByteStringListView(this);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ensureIsMutable();
        this.f3712list.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    public byte[] getByteArray(int i) {
        Object obj = this.f3712list.get(i);
        byte[] bArrAsByteArray = asByteArray(obj);
        if (bArrAsByteArray != obj) {
            this.f3712list.set(i, bArrAsByteArray);
        }
        return bArrAsByteArray;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    public ByteString getByteString(int i) {
        Object obj = this.f3712list.get(i);
        ByteString byteStringAsByteString = asByteString(obj);
        if (byteStringAsByteString != obj) {
            this.f3712list.set(i, byteStringAsByteString);
        }
        return byteStringAsByteString;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    /* renamed from: getRaw */
    public Object mo4060getRaw(int i) {
        return this.f3712list.get(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.f3712list);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return isModifiable() ? new UnmodifiableLazyStringList(this) : this;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    public void mergeFrom(LazyStringList lazyStringList) {
        ensureIsMutable();
        for (Object obj : lazyStringList.getUnderlyingElements()) {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                this.f3712list.add(Arrays.copyOf(bArr, bArr.length));
            } else {
                this.f3712list.add(obj);
            }
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f3712list.size();
    }

    public LazyStringArrayList(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add((LazyStringArrayList) obj);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends String> collection) {
        ensureIsMutable();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.f3712list.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        Object obj = this.f3712list.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.f3712list.set(i, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String stringUtf82 = Internal.toStringUtf8(bArr);
        if (Internal.isValidUtf8(bArr)) {
            this.f3712list.set(i, stringUtf82);
        }
        return stringUtf82;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public LazyStringArrayList mutableCopyWithCapacity2(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.f3712list);
        return new LazyStringArrayList((ArrayList<Object>) arrayList);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public String set(int i, String str) {
        ensureIsMutable();
        return asString(this.f3712list.set(i, str));
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.f3712list = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object setAndReturn(int i, byte[] bArr) {
        ensureIsMutable();
        return this.f3712list.set(i, bArr);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i, String str) {
        ensureIsMutable();
        this.f3712list.add(i, str);
        ((AbstractList) this).modCount++;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public String remove(int i) {
        ensureIsMutable();
        Object objRemove = this.f3712list.remove(i);
        ((AbstractList) this).modCount++;
        return asString(objRemove);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    /* renamed from: set */
    public void mo4062set(int i, ByteString byteString) {
        setAndReturn(i, byteString);
    }

    public LazyStringArrayList(List<String> list) {
        this((ArrayList<Object>) new ArrayList(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: add */
    public void m4055add(int i, ByteString byteString) {
        ensureIsMutable();
        this.f3712list.add(i, byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    /* renamed from: set */
    public void mo4063set(int i, byte[] bArr) {
        setAndReturn(i, bArr);
    }

    private LazyStringArrayList(ArrayList<Object> arrayList) {
        this.f3712list = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: add */
    public void m4056add(int i, byte[] bArr) {
        ensureIsMutable();
        this.f3712list.add(i, bArr);
        ((AbstractList) this).modCount++;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    /* renamed from: add */
    public void mo4058add(ByteString byteString) {
        ensureIsMutable();
        this.f3712list.add(byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.LazyStringList
    /* renamed from: add */
    public void mo4059add(byte[] bArr) {
        ensureIsMutable();
        this.f3712list.add(bArr);
        ((AbstractList) this).modCount++;
    }
}
