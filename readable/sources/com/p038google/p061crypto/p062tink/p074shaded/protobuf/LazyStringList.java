package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public interface LazyStringList extends ProtocolStringList {
    /* renamed from: add */
    void mo4058add(ByteString byteString);

    /* renamed from: add */
    void mo4059add(byte[] bArr);

    boolean addAllByteArray(Collection<byte[]> collection);

    boolean addAllByteString(Collection<? extends ByteString> collection);

    List<byte[]> asByteArrayList();

    byte[] getByteArray(int i);

    ByteString getByteString(int i);

    /* renamed from: getRaw */
    Object mo4060getRaw(int i);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();

    void mergeFrom(LazyStringList lazyStringList);

    /* renamed from: set */
    void mo4062set(int i, ByteString byteString);

    /* renamed from: set */
    void mo4063set(int i, byte[] bArr);
}
