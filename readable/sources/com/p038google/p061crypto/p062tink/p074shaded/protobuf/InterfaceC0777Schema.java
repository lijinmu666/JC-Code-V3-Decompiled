package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ArrayDecoders;

@CheckReturnValue
/* renamed from: com.google.crypto.tink.shaded.protobuf.Schema */
/* loaded from: classes.dex */
interface InterfaceC0777Schema<T> {
    /* renamed from: equals */
    boolean mo4093equals(T t, T t2);

    int getSerializedSize(T t);

    int hashCode(T t);

    boolean isInitialized(T t);

    void makeImmutable(T t);

    void mergeFrom(T t, InterfaceC0775Reader interfaceC0775Reader, ExtensionRegistryLite extensionRegistryLite);

    void mergeFrom(T t, T t2);

    void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers);

    T newInstance();

    /* renamed from: writeTo */
    void mo4094writeTo(T t, InterfaceC0811Writer interfaceC0811Writer);
}
