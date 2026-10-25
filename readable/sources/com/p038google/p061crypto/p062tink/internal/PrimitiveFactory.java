package com.p038google.p061crypto.p062tink.internal;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite;

/* loaded from: classes.dex */
public abstract class PrimitiveFactory<PrimitiveT, KeyProtoT extends MessageLite> {

    /* renamed from: clazz */
    private final Class<PrimitiveT> f3118clazz;

    public PrimitiveFactory(Class<PrimitiveT> cls) {
        this.f3118clazz = cls;
    }

    public abstract PrimitiveT getPrimitive(KeyProtoT keyprotot);

    public final Class<PrimitiveT> getPrimitiveClass() {
        return this.f3118clazz;
    }
}
